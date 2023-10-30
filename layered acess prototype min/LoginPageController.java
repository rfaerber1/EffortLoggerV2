package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginPageController
{
	private Scene scene;
	private Stage stage;
	private Login login = new Login();
	
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	

	
	public void submitLogin(ActionEvent event) throws IOException
	{
		login.setName(usernameField.getText());
		login.setPassword(passwordField.getText());
		
		if(Login.adminAccess.equals(passwordField.getText()))
		{
			FXMLLoader fxmlLoaderAdmin = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(fxmlLoaderAdmin.load(), 400, 400);
			stage.setTitle("Admin Account");
			
			AdminPageController control = fxmlLoaderAdmin.getController();
			control.getInfo(login);
			stage.setScene(scene);
			stage.show();			
		}
		else
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(fxmlLoader.load(), 400, 400);
			stage.setTitle("Login Info");
			
			LoginViewController control = fxmlLoader.getController();
			control.setLogin(login);
			stage.setScene(scene);
			stage.show();			
		}
			
	}

}
