//Author: Din Zaklan

package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
	
	public Login() {
		
	}
	@FXML
	private Button loginButton;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	public void userLogin(ActionEvent event) throws IOException {
		checkLogin();
		
	}
	private void checkLogin() throws IOException {
		Main m = new Main();
		if(username.getText().toString().equals("effortlogger") && password.getText().toString().equals("12345")) {
			m.changeScene("EffortConsole.fxml");
		}
	}
}
