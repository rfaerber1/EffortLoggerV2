package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	int WIDTH = 780;
	int HEIGHT = 500;
	
	@Override
	public void start(Stage stage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("EffortLoggerV2GUIPrototype.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
		/*
		// create a ControlPane object
		UserInterfacePane pane = new UserInterfacePane(WIDTH, HEIGHT);

		// put pane onto the rootPane
		Pane rootPane = new Pane();
		rootPane.getChildren().add(pane);

		// Create a scene and place rootPane in the stage
		Scene scene = new Scene(rootPane, WIDTH, HEIGHT);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage.setTitle("User Input Prototype");
		
		// Place the scene in the stage
		stage.setScene(scene); 
		// Display the stage
		stage.show(); */
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

