package models;

public class Login {
	// declaring instance variables
	String username;
	String password;

	// creating default constructor
	public Login() {
		this.username = "";
		this.password = "";
	}

	// creating parameterized constructor
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	// creating getter and setter for all method
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// creating to string method
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}
}
