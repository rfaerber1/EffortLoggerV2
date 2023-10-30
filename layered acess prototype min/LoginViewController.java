package application;

import javafx.fxml.*;
import javafx.scene.control.*;
public class LoginViewController 
{	
	@FXML
	private Label username;
	@FXML
	private Label password;
	
	public void setLogin(Login login)
	{
		username.setText("Username: " + login.getUsername());
		password.setText("Password: " + login.getPassword());
	}

}
