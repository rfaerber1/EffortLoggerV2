package application;
 
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

 
public class EffortConsole implements Initializable{

	Parent pane;
	
	@FXML protected void showEffortLogEditor(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("EffortLogEditor.fxml"));
		Main.setScene("Effort Log Editor", pane);
	}
	
	/* Need to be implemented
	
	@FXML protected void showDefectLogConsole(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("_______.fxml"));
		Main.setScene("Defect Log Console", pane);
	}
	
	Also Planning Poker Pane
	 */
	
    @FXML private Text clockStatus;
    
    @FXML protected void stopActivity(ActionEvent event) {
        clockStatus.setText("Clock Stopped");
    }
    @FXML protected void startActivity(ActionEvent event) {
    	if(getProject() != null && getLifeCycleStep() != null && getEffortCategory() != null && getDeliverable() != null) {
    		clockStatus.setText("Clock Started");
    		
    		// create effort log for selected project
    		Project project = Data.getProject(getProject());
    		project.createEffortLog( new EffortLog(getDeliverable(), getEffortCategory(), getLifeCycleStep()) );
    		
    		// temporary, show effort log was created
    		String effortLog = project.getEffortLogs().get(project.getEffortLogs().size()-1).getLog();
    		System.out.println("EffortLog created within Project: " + project.getName() +"\nEffort Log: \n" + effortLog);
    	}
    }
    
    @FXML ChoiceBox<String> Projects;
    ObservableList<String> projects = FXCollections.observableArrayList();
    
    private void loadProjects() {    	
    	Data.addProject(new Project("Business Project"));
    	Data.addProject(new Project("Development Project"));
    	
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

    
    @FXML ChoiceBox<Integer> PlanningPokerCards;
    ObservableList<Integer> list = FXCollections.observableArrayList();
    
    private void loadCards() {
    	list.removeAll();
    	list.addAll(
    			  1,2,3,4,5,6 				
    	);
    	PlanningPokerCards.getItems().addAll(list);
    }
    
    public int getPlanningPokerCards() {
    	return PlanningPokerCards.getSelectionModel().getSelectedItem();
    }
    
      
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadProjects();
		loadSteps();
		loadCategories();
		loadDeliverables();
		loadCards();
	}
    

}