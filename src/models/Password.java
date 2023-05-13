package models;

public class Password {
	// declaring instance variable
	private int customerId;
	private String Password;

	// creating default constructor
	public Password() {
		this.customerId = 0;
		this.Password = "";
	}

	// creating parameterized constructor
	public Password(int customerId, String password) {
		super();
		this.customerId = customerId;
		this.Password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Password [customerId=" + customerId + ", Password=" + Password + "]";
	}
}
