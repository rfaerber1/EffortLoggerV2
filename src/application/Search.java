package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Search implements Initializable {

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
	
	public void initialize(URL url, ResourceBundle resourceBundle) {
		listView.getItems().addAll(words);
	}
	
	private List<String> searchList(String searchWords, List<String> listOfStrings) {
		List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
		return listOfStrings.stream().filter(input -> { //input = test
			return searchWordsArray.stream().allMatch(word ->  //word = t
			input.toLowerCase().contains(word.toLowerCase()));
		}).collect(Collectors.toList());
	}
}

