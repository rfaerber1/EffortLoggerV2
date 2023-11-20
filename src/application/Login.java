// Author: Din Zaklan
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

	
public Login() {
		
	}
	@FXML
	private Button loginButton;
	@FXML
	private TextField userIDField;
	@FXML
	private PasswordField passwordField;
	
	// line below is new
	public String UserID;
	
	public void userLogin(ActionEvent event) throws IOException {
		checkLogin();
	}
	//this setMain thing is new
	void checkLogin() throws IOException {
		Main m = new Main();
		
		// below line is new
		String UserID = userIDField.getText().trim();
		
		if(userIDField.getText().toString().equals("user1") && passwordField.getText().toString().equals("12345")) {
			m.changeScene("EffortLoggerV2GUIPrototype.fxml");
		}
	}
	
	// Getter for userIDField
    public TextField getUserIDField() {
        return userIDField;
    }

    // Getter for passwordField
    public PasswordField getPasswordField() {
        return passwordField;
    }

    // Getter for enteredUserID
    public String getUserID() {
        return UserID;
    }
}
