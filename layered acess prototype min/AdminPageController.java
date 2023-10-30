package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class AdminPageController
{
	private Scene scene;
	private Stage stage;
	
	private Login login = new Login();
	
	@FXML
	private Label username;
	
	@FXML
	private PasswordField passwordField;
	
	public void getInfo(Login pLog)
	{
		login = pLog;
		username.setText(login.getUsername());		
	}
	
	public void submitAdmin(ActionEvent event) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
		login.setPassword(passwordField.getText());
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load(), 400, 400);
		stage.setTitle("Login Info");
		
		LoginViewController control = fxmlLoader.getController();
		control.setLogin(login);
		stage.setScene(scene);
		stage.show();
		
		
	}

}
