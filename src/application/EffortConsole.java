package application;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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

	 */
	
	Project project;
	EffortLog effortLog;
	
	public SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");
	public SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");
	public Date date = new Date();
	
    @FXML private Text clockStatus;
    
    // Stop Activity and update endTime for Effort Log
    @FXML protected void stopActivity(ActionEvent event) {
    	if(clockStatus.getText().compareTo("Clock Started") == 0) {
    		clockStatus.setText("Clock Stopped");
    		clockStatus.setFill(Color.RED);
        	date.setTime(System.currentTimeMillis());
        	effortLog.setEndTime(timeFormatter.format(date));
    	}
    }
    
    // Start Activity / Create Effort Log
    @FXML protected void startActivity(ActionEvent event) {
    	if(getProject() != null && getLifeCycleStep() != null && getEffortCategory() != null && getDeliverable() != null && clockStatus.getText().compareTo("Clock Stopped") == 0) {
    		clockStatus.setText("Clock Started");
    		clockStatus.setFill(Color.GREEN);
    		date.setTime(System.currentTimeMillis());
    		
    		// create effort log for selected project
    		project = Data.getProject(getProject());
    		effortLog = new EffortLog(getDeliverable(), getEffortCategory(), getLifeCycleStep());
    		
    		// set current time and date
    		effortLog.setDate(dateFormatter.format(date));
    		effortLog.setStartTime(timeFormatter.format(date));
    		
    		// save effort log to correct project
    		project.createEffortLog(effortLog);
    		
    		// temporary, show effort log was created
    		//String effortLog = project.getEffortLogs().get(project.getEffortLogs().size()-1).getLog();
    		//System.out.println("EffortLog created within Project: " + project.getName() +"\nEffort Log: \n" + effortLog);
    	}
    }
    
    
    @FXML ChoiceBox<String> Projects;
    ObservableList<String> projects = FXCollections.observableArrayList();
    
    // Load list of projects in UI
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
    
    // Get user selected Project
    public String getProject() {
    	return Projects.getSelectionModel().getSelectedItem();
    }
      
    
    @FXML ChoiceBox<String> LifeCycleSteps;
    ObservableList<String> steps = FXCollections.observableArrayList();
    
    // Load list of life cycle steps into UI
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
    
    // Get user selected Life Cycle Step
    public String getLifeCycleStep() {
    	return LifeCycleSteps.getSelectionModel().getSelectedItem();
    }
           
    
    @FXML ChoiceBox<String> EffortCategories;
    ObservableList<String> categories = FXCollections.observableArrayList();
    
    // Load list of Effort Categories
    private void loadCategories() {
    	categories.removeAll();
    	categories.addAll(
    			   	"Plans",
    			   	"Deliverables",
    			   	"Interruptions",
    			   	"Defects"
    	);
    	EffortCategories.getItems().addAll(categories);
    }
    
    // Get user selected Effort Category
    public String getEffortCategory() {
    	return EffortCategories.getSelectionModel().getSelectedItem();
    }

    
    @FXML ChoiceBox<String> Deliverables;
    ObservableList<String> deliverables = FXCollections.observableArrayList();
    String[] plansList = {
    		"Project Plan",
		   	"Risk Management Plan",
		   	"Conceptual Design Plan",
		   	"Detailed Design Plan",
		   	"Implementation Plan"
    };
    String[] deliverablesList = {
    		"Concpetual Design",
    		"Detailed Design",
    		"Test Cases",
    		"Solution",
    		"Reflection",
    		"Outline",
    		"Draft",
    		"Report",
    		"User Defined",
    		"Other"
    };
    String[] interruptionsList = {
    		"Break",
    		"Phone",
    		"Teammate",
    		"Visitor",
    		"Other"
    };
    String[] defectsList = {
    		"-no defect selected-"
    		// generated from defects made in defect console
    };
    String[] othersList = {}; //empty
    
    // Get correct deliverable list based on selected Effort Category
    protected String[] getDeliverablesList(String effortCategory) {
    	if(effortCategory.equals("Plans")) {
    		return plansList;
    	}
    	else if(effortCategory.equals("Deliverables")) {
    		return deliverablesList;
    	}
    	else if(effortCategory.equals("Interruptions")) {
    		return interruptionsList;
    	}
    	else if(effortCategory.equals("Defects")) {
    		return defectsList;
    	}
    	else {
    		return othersList;
    	}
    }
    
    // Load list of Deliverables into UI
    private void loadDeliverables() {
    	Deliverables.getItems().removeAll();
    	while(deliverables.size() > 0) {
			deliverables.remove(0);
		}
    	if(getEffortCategory() != null) {
    		deliverables.addAll(getDeliverablesList(getEffortCategory()));
    	}
    	Deliverables.getItems().addAll(deliverables);
    }
   
    // Get user Selected Deliverables
    public String getDeliverable() {
    	if(Deliverables.getSelectionModel().getSelectedItem().equals("-no defect selected-")) {
    		return null;
    	}
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
		
		// Update Deliverables Choices based on selected Effort Category
		EffortCategories.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldCategory, String newCategory) {
				while(Deliverables.getItems().size() > 0) {
					Deliverables.getItems().remove(0);
				}
				loadDeliverables();
				Deliverables.getSelectionModel().selectFirst();
			}
		});
		
	}
	ArrayList<String> words = new ArrayList<> (
    		Arrays.asList("EffortLoggerV1", "VerificationSystem", "LoginSystem", "TaskEditor")
   	);
    	
        @FXML
    	private TextField searchBar;
    	
   	@FXML
   	private ListView<String> listView;
   	
   	@FXML
   	protected void search(ActionEvent event) {
    	listView.getItems().clear();
    	listView.getItems().addAll(searchList(searchBar.getText(),words));
   	}
   	
   	/*public void initialize(URL url, ResourceBundle resourceBundle) {
    	listView.getItems().addAll(words);
    	}*/
   	
   	private List<String> searchList(String searchWords, List<String> listOfStrings) {
   		List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
   		return listOfStrings.stream().filter(input -> { //input = test
    		return searchWordsArray.stream().allMatch(word ->  //word = t
    		input.toLowerCase().contains(word.toLowerCase()));
    		}).collect(Collectors.toList());
   	}

}
