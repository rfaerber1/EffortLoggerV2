package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
 
public class EffortLogEditor implements Initializable{
	Parent pane;
	
	@FXML protected void showEffortLogConsole(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("EffortLoggerV2GUIPrototype.fxml"));
		Main.setScene("Effort Console", pane);
	}
	
	Project project;
	EffortLog effortLog;
	CheckInput checkInput = new CheckInput();
	
	@FXML TextField Date;
	@FXML TextField StartTime;
	@FXML TextField EndTime;
	
	// Called when 'update this entry' is pressed
	@FXML protected void updateLog(ActionEvent event) {
		if(effortLog != null && checkInput.checkForDate(Date.getText()) == true && checkInput.checkForTime(StartTime.getText()) == true && checkInput.checkForTime(StartTime.getText()) == true) {
			effortLog.setDate(Date.getText());
			effortLog.setStartTime(StartTime.getText());
			effortLog.setEndTime(EndTime.getText());
			effortLog.setName();
		}
	}
	
	
	@FXML ChoiceBox<String> Projects;
    ObservableList<String> projects = FXCollections.observableArrayList();
    
    private void loadProjects() {    	    	
    	projects.removeAll();
    	
    	String[] projectNames = Data.getProjectNames();
    	for (int i = 0; i < Data.getNumberOfProjects(); i++) {
    		projects.add(projectNames[i]);
    	}

    	Projects.getItems().addAll(projects);
    }
    
    public String getProject() {
    	return Projects.getSelectionModel().getSelectedItem();
    }
    
    @FXML ChoiceBox<String> EffortLogs;
    ObservableList<String> effortLogs = FXCollections.observableArrayList();
    
   private void loadEffortLogs() {   
	   while(effortLogs.size() > 0) {
			effortLogs.remove(0);
		}
	   effortLogs.removeAll();
    	
    	if(getProject() != null) {
    		project = Data.getProject(getProject());
	    	String[] effortLogNames = project.getEffortLogNames();
	    	for (int i = 0; i < effortLogNames.length; i++) {
	    		effortLogs.add(effortLogNames[i]);
	    	}
	    	
	    	EffortLogs.getItems().addAll(effortLogs);
    	}
    }
    
    public String getEffortLog() {
    	return EffortLogs.getSelectionModel().getSelectedItem();
    }
       
    @FXML ChoiceBox<String> LifeCycleSteps;
    ObservableList<String> steps = FXCollections.observableArrayList();
    
    private void loadSteps() {
    	steps.removeAll();
    	steps.addAll(
    			   "Planning", 
    			   "Information Gathering",
    			   "Information Understanding",
    			   "Verifying",
    			   "Outlining",
    			   "Drafting",
    			   "Finalizing",
    			   "Team Meeting",
    			   "Coach Meeting",
    			   "Stakeholder Meeting"
    	);
    	LifeCycleSteps.getItems().addAll(steps);
    }
    
    public String getLifeCycleStep() {
    	return LifeCycleSteps.getSelectionModel().getSelectedItem();
    }
           
    @FXML ChoiceBox<String> EffortCategories;
    ObservableList<String> categories = FXCollections.observableArrayList();
    
    private void loadCategories() {
    	categories.removeAll();
    	categories.addAll(
    			   	"Plans",
    			   	"Deliverables",
    			   	"Interruptions",
    			   	"Defects",
    			   	"Others"
    	);
    	EffortCategories.getItems().addAll(categories);
    }
    
    public String getEffortCategory() {
    	return EffortCategories.getSelectionModel().getSelectedItem();
    }
 
    
    @FXML ChoiceBox<String> Deliverables;
    ObservableList<String> deliverables = FXCollections.observableArrayList();
    
    private void loadDeliverables() {
    	deliverables.removeAll();
    	deliverables.addAll(
    			   	"Project Plan",
    			   	"Risk Management Plan",
    			   	"Conceptual Design Plan",
    			   	"Detailed Design Plan",
    			   	"Implementation Plan"
    	);
    	Deliverables.getItems().addAll(deliverables);
    }
    
    public String getDeliverable() {
    	return Deliverables.getSelectionModel().getSelectedItem();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		loadProjects();
		loadEffortLogs();
		loadSteps();
		loadCategories();
		loadDeliverables();
		
		// Update Effort Logs Choice Box based on Project selection
		Projects.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldProject, String newProject) {
				while(EffortLogs.getItems().size() > 0) {
					EffortLogs.getItems().remove(0);
				}
				loadEffortLogs();
			}
		});
		
		// Update Dates and Times based on Effort Log selection
		EffortLogs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldLog, String newLog) {
				effortLog = Data.getProject(getProject()).getEffortLog(getEffortLog());
				if(effortLog != null) {
					Date.setText(effortLog.getDate());
					StartTime.setText(effortLog.getStartTime());
					EndTime.setText(effortLog.getEndTime());
				}
			}
		});
		
	}
}