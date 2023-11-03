package application;
 
import java.io.IOException;
import java.net.URL;
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
		Main.getStage().getScene().setRoot(pane);
	}
	
	/* Need to be implemented
	
	@FXML protected void showDefectLogConsole(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("_______.fxml"));
		Main.getStage().getScene().setRoot(pane);
	}
	
	@FXML protected void showDefinitions(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("_______.fxml"));
		Main.getStage().getScene().setRoot(pane);
	}
	
	@FXML protected void showEffortAndDefectLogs(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("________.fxml"));
		Main.getStage().getScene().setRoot(pane);
	}
	 */
	
    @FXML private Text clockStatus;
    
    @FXML protected void stopActivity(ActionEvent event) {
        clockStatus.setText("Clock Stopped");
    }
    @FXML protected void startActivity(ActionEvent event) {
    	if(getProject() != null && getLifeCycleStep() != null && getEffortCategory() != null && getDeliverable() != null) {
    		clockStatus.setText("Clock Started");
    	}
    }
    
    @FXML ChoiceBox<String> Projects;
    ObservableList<String> projects = FXCollections.observableArrayList();
    
    private void loadProjects() {
    	projects.removeAll();
    	projects.addAll(
    			   "Business Project",
    			   "Development Project"
    	);
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