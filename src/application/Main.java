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
	public void start(Stage primaryStage) throws IOException {
		// create a ControlPane object
		PrototypePane pane = new PrototypePane(WIDTH, HEIGHT);

		// put pane onto the rootPane
		Pane rootPane = new Pane();
		rootPane.getChildren().add(pane);

		// Create a scene and place rootPane in the stage
		Scene scene = new Scene(rootPane, WIDTH, HEIGHT);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
		primaryStage.setTitle("User Input Prototype");
				
		// Place the scene in the stage
		primaryStage.setScene(scene); 
		// Display the stage
		primaryStage.show(); 
	}
	
	/*@Override
	public void start(Stage stage) {
		Pane root = null;
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
	}*/
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

