package application;
 
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
 
public class EffortConsole implements Initializable{
    @FXML private Text clockStatus;
    
    @FXML protected void stopActivity(ActionEvent event) {
        clockStatus.setText("Clock Stopped");
    }
    @FXML protected void startActivity(ActionEvent event) {
        clockStatus.setText("Clock Started");
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

    
    @FXML ChoiceBox<Integer> PlanningPokerCards;
    ObservableList<Integer> list = FXCollections.observableArrayList();
    
    private void loadCards() {
    	list.removeAll();
    	list.addAll(
    			  1,2,3,4,5,6 				
    	);
    	PlanningPokerCards.getItems().addAll(list);
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