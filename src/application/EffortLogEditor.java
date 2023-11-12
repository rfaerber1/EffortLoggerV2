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
 
public class EffortLogEditor implements Initializable{
	Parent pane;
	
	@FXML protected void showEffortLogConsole(ActionEvent event) throws IOException {
		pane = FXMLLoader.load(getClass().getResource("EffortLoggerV2GUIPrototype.fxml"));
		Main.setScene("Effort Console", pane);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}