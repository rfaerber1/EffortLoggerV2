// Author: Din Zaklan
// Date: 11/11/2023
// Description: The controller for the Defect Console page.
package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class DefectConsole {
	
	ObservableList<String> projectList = FXCollections.observableArrayList("Business", "Development");
	ObservableList<String> defectList = FXCollections.observableArrayList("Defect 1", "Defect 2");
	ObservableList<String> stepInjected = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting","Coach Meeting", "Stakeholder Meeting");
	ObservableList<String> stepRemoved = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting","Coach Meeting", "Stakeholder Meeting");
	ObservableList<String> defectCategory = FXCollections.observableArrayList("Not Specified", "10 Documentation", "20 Syntax", "30 Build Package", "40 Assignment", "50 Interface", "60 Checking", "70 Data", "80 Function", "90 System", "100 Environment");
	
	@FXML
	private Button returnButton;
	
	public void changeScene(ActionEvent event)  throws IOException {
		Main m = new Main();
		m.changeScene("EffortLoggerV2GUIPrototype.fxml");
	}
	
	@FXML
	private ChoiceBox<String> decoSeleProjBox;
	@FXML
	private ChoiceBox<String> selePrevDefBox;
	@FXML
	private ChoiceBox<String> stepInjectedBox;
	@FXML
	private ChoiceBox<String> stepRemovedBox;
	@FXML
	private ChoiceBox<String> defCategoryBox;
	@FXML
	private void initialize() {
		decoSeleProjBox.setItems(projectList);
		selePrevDefBox.setItems(defectList);
		stepInjectedBox.setItems(stepInjected);
		stepRemovedBox.setItems(stepRemoved);
		defCategoryBox.setItems(defectCategory);
	}
}
