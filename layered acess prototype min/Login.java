package application;

public class Login 
{
	private String username;
	private String password;
	final static String adminAccess = "verysecurepassword";
	
	public void setName(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;		
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}

}
