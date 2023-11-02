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
	
	Stage stg;
		
	@Override
	public void start(Stage stage) {
		stg = stage;
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
	}

	// From Din's code
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

