package application;

/* Code by Raylene Faerber
 * Description: Interface for users to enter different types of input. Tests are then run on the input to ensure it follows the correct format.
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;


public class CheckInputPrototype extends Pane {
	
	private InputTests test = new InputTests();

	private int width, height;
	
	private TextField nameInput;
	private Label nameFeedback;
	private Button nameBtn;
	
	private TextField intInput;
	private Label intFeedback;
	private Button intBtn;
	
	private TextField doubleInput;
	private Label doubleFeedback;
	private Button doubleBtn;
	
	private TextField dateInput;
	private Label dateFeedback;
	private Button dateBtn;
	
	private TextField timeInput;
	private Label timeFeedback;
	private Button timeBtn;
	
	private TextArea textInput;
	private Label textFeedback;
	private Button textBtn;
	
	private String userInput;
	
	
	public CheckInputPrototype(int h, int w) {
		height = h;
		width = w;
		
		// components for inputting a name
		nameInput = new TextField();
		nameInput.setMaxWidth(width/4);
		
		nameBtn = new Button("Enter");
		nameBtn.setMaxWidth(width/8);
		
		nameFeedback = new Label("Input a name");
		
		HBox nameBox = new HBox(nameInput, nameBtn);
		VBox nameContainer = new VBox(nameBox, nameFeedback);
		nameContainer.setPadding(new Insets(5, 5, 5, 5));
		
		nameBtn.setOnAction(new ButtonHandler());
		
		// components for inputting an integer
		intInput = new TextField();
		intInput.setMaxWidth(width/4);
		
		intBtn = new Button("Enter");
		intBtn.setMaxWidth(width/8);
		
		intFeedback = new Label("Input an integer");
		
		HBox intBox = new HBox(intInput, intBtn);
		VBox intContainer = new VBox(intBox, intFeedback);
		intContainer.setPadding(new Insets(5, 5, 5, 5));
		
		intBtn.setOnAction(new ButtonHandler());
		
		// components for inputting a double
		doubleInput = new TextField();
		doubleInput.setMaxWidth(width/4);
				
		doubleBtn = new Button("Enter");
		doubleBtn.setMaxWidth(width/8);
				
		doubleFeedback = new Label("Input a double");
		
		HBox doubleBox = new HBox(doubleInput, doubleBtn);
		VBox doubleContainer = new VBox(doubleBox, doubleFeedback);
		doubleContainer.setPadding(new Insets(5, 5, 5, 5));
				
		doubleBtn.setOnAction(new ButtonHandler());
		
		// components for inputting a date
		dateInput = new TextField();
		dateInput.setMaxWidth(width/4);
				
		dateBtn = new Button("Enter");
		dateBtn.setMaxWidth(width/8);
				
		dateFeedback = new Label("Input a date in the format yyyy-mm-dd");
		
		HBox dateBox = new HBox(dateInput, dateBtn);
		VBox dateContainer = new VBox(dateBox, dateFeedback);
		dateContainer.setPadding(new Insets(5, 5, 5, 5));
		
		dateBtn.setOnAction(new ButtonHandler());
		
		// components for inputting a time
		timeInput = new TextField();
		timeInput.setMaxWidth(width/4);
				
		timeBtn = new Button("Enter");
		timeBtn.setMaxWidth(width/8);
				
		timeFeedback = new Label("Input a time in the format hh:mm:ss");
		
		timeBtn.setOnAction(new ButtonHandler());
		
		HBox timeBox = new HBox(timeInput, timeBtn);
		VBox timeContainer = new VBox(timeBox, timeFeedback);
		timeContainer.setPadding(new Insets(5, 5, 5, 5));
		
		// components for inputting a text
		textInput = new TextArea();
		textInput.setMaxWidth(width/2);
		textInput.setWrapText(true);
		
		textBtn = new Button("Enter");
		textBtn.setMaxWidth(width/8);
				
		textFeedback = new Label("Input text");
		textFeedback.setPadding(new Insets(5, 5, 5, 5));
		
		HBox textBox = new HBox(textBtn, textFeedback);
		VBox textContainer = new VBox(textInput, textBox);
		textContainer.setPadding(new Insets(5, 5, 5, 5));
				
		textBtn.setOnAction(new ButtonHandler());
		
		VBox container = new VBox(nameContainer, intContainer, doubleContainer, dateContainer, timeContainer, textContainer);
		container.setPadding(new Insets(5, 5, 5, 5));
		this.getChildren().add(container);
	}
	
	// check input if all characters are acceptable
	private boolean inputCheck(Boolean check, String input, Label feedback) {
		if(input == "") {
			feedback.setText("Input is empty");
			return false;
		}
		else if(check) {
			feedback.setText("Input looks good!");
			return true;
		}
		else {
			feedback.setText("Invalid input, can't use character " + test.getBadChar());
			return false;
		}
	}
	
	// check input for characters and length (when format matters)
	private boolean inputCheck(Boolean check, String input, Label feedback, String dateOrtime) {
		if(input == "") {
			feedback.setText("Input is empty");
			return false;
		}
		else if(check) {
			feedback.setText("Input looks good!");
			return true;
		}
		else if ((!test.getCorrectLength() && dateOrtime.equals("date")) || (test.getBadChar()=='-' && dateOrtime.equals("date"))) {
			feedback.setText("Invalid input, doesn't follow correct form yyyy-mm-dd");
			return false;
		}
		else if ((!test.getCorrectLength() && dateOrtime.equals("time")) || (test.getBadChar()==':'&& dateOrtime.equals("time"))) {
			feedback.setText("Invalid input, doesn't follow correct form hh:mm:ss");
			return false;
		}
		else {
			feedback.setText("Invalid input, can't use character " + test.getBadChar());
			return false;
		}
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle (ActionEvent event) {
			if(event.getSource().equals(nameBtn)) {
				userInput = nameInput.getText();
				inputCheck(test.checkForAllLetters(userInput), userInput, nameFeedback);
			}
			
			if(event.getSource().equals(intBtn)) {
				userInput = intInput.getText();
				inputCheck(test.checkForInt(userInput), userInput, intFeedback);
			}
			
			if(event.getSource().equals(doubleBtn)) {
				userInput = doubleInput.getText();
				inputCheck(test.checkForDouble(userInput), userInput, doubleFeedback);
			}
			
			if(event.getSource().equals(dateBtn)) {
				dateFeedback.setText("Testings");
				userInput = dateInput.getText();
				inputCheck(test.checkForDate(userInput), userInput, dateFeedback, "date");
			}
			
			if(event.getSource().equals(timeBtn)) {
				userInput = timeInput.getText();
				inputCheck(test.checkForTime(userInput), userInput, timeFeedback, "time");
			}
			
			if(event.getSource().equals(textBtn)) {
				userInput = textInput.getText();
				inputCheck(test.checkForGeneralText(userInput), userInput, textFeedback);
			}
			
		}
	}
	
}