package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PrototypePane extends Pane {

	// The constructor creates two panes with waves and movement controls
	// Initial colors for the waves are BLACK and PINK
	// The two panes are arranged in a GridPane
	
	Pane pane;
	
	Button MainScreenBtn;
	Button Prototype1Btn;
	Button Prototype2Btn;
	Button Prototype3Btn;
	Button Prototype4Btn;
	
	Pane MainScreen;
	Pane Prototype1;
	CheckInputPrototype Prototype2;
	VerificationPrototype Prototype3;
	Pane Prototype4;
		
	Pane prototypePane;
	
	public PrototypePane(int width, int height) throws IOException {
		int NumBtns = 5;
		
		MainScreen = FXMLLoader.load(getClass().getResource("EffortLoggerV2GUIPrototype.fxml"));
		//Prototype1 = new Prototype1(width, height-25);
		Prototype2 = new CheckInputPrototype(width, height-50);
		Prototype3 = new VerificationPrototype();
		//Prototype4 = new Prototype4();
		
		pane = new Pane();
		pane.getChildren().add(MainScreen);
		
		MainScreenBtn = new Button("Main Screen");
		MainScreenBtn.setMinSize(width/NumBtns, 5);
		MainScreenBtn.setOnAction(new ButtonHandler());
		
		Prototype1Btn = new Button("Prototype 1");
		Prototype1Btn.setMinSize(width/NumBtns, 5);
		Prototype1Btn.setOnAction(new ButtonHandler());
		
		Prototype2Btn = new Button("Prototype 2");
		Prototype2Btn.setMinSize(width/NumBtns, 5);
		Prototype2Btn.setOnAction(new ButtonHandler());
		
		Prototype3Btn = new Button("Prototype 3");
		Prototype3Btn.setMinSize(width/NumBtns, 5);
		Prototype3Btn.setOnAction(new ButtonHandler());
		
		Prototype4Btn = new Button("Prototype 3");
		Prototype4Btn.setMinSize(width/NumBtns, 5);
		Prototype4Btn.setOnAction(new ButtonHandler());
		
		HBox buttons = new HBox(MainScreenBtn, Prototype1Btn, Prototype2Btn, Prototype3Btn, Prototype4Btn);
		VBox test = new VBox(pane, buttons);

		prototypePane = this;
		prototypePane.getChildren().add(test);
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle (ActionEvent event) {
			if(event.getSource().equals(MainScreenBtn)) {
				System.out.println("MainScreen Pressed");
				pane.getChildren().clear();
				pane.getChildren().add(MainScreen);
			}
			if(event.getSource().equals(Prototype1Btn)) {
				System.out.println("MainScreen Pressed");
				pane.getChildren().clear();
				pane.getChildren().add(Prototype1);
			}
			if(event.getSource().equals(Prototype2Btn)) {
				System.out.println("effort log pressed");
				pane.getChildren().clear();
				pane.getChildren().add(Prototype2);
			}
			if(event.getSource().equals(Prototype3Btn)) {
				System.out.println("defect console pressed");
				Prototype3.run();
			}	
			if(event.getSource().equals(Prototype4Btn)) {
				System.out.println("effort log pressed");
				pane.getChildren().clear();
				pane.getChildren().add(Prototype4);
			}
		}
	}
		
}