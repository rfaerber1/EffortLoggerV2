package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application{
		
	static Stage stg;
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
	    
        Scene scene = new Scene(root, 600, 425);
    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
	}
	
	
	/**
	 * Change scene the stage is showing
	 * 
	 * @param title
	 * @param pane
	 */
	public static void setScene(String title, Parent pane) {
		stg.getScene().setRoot(pane);
		stg.setTitle(title);
	}
	
	
	public static void main(String[] args) {		
		Application.launch(args);
	}
	
}

