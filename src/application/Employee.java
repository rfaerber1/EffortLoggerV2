package application;

/* Code by Bailey Learned
 * 
 */

public class Employee { //Employee class since data will only be accessible to employees
	private String username;
	private String password;
	private long ID; //unique 12-digit ID number
	
	public Employee() { //default constructor
		this.username = "none";
		this.password = "none";
		this.ID = 000000000000;
	}
	public Employee(String username, String password, long ID) { //parameterized constructor
		this.username = username;
		this.password = password;
		this.ID = ID;
	}
	void setUsername(String username) { //sets username
		this.username = username;
	}
	String getUsername() {//returns username
		return username;
	}
	void setPassword(String password) { //sets or resets password
		this.password = password;
	}
	String getPassword() { //returns password
		return password;
	}
	void setID(long ID) { //sets ID
		this.ID = ID;
	}
	long getID() { //returns ID
		return ID;
	}
}
