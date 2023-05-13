package models;

public class Customer {
	// declaring instance variable
	private int customerId;
	private String customerUserName;
	private String customerPassword;
	private String customerName;
	private String customerEmail;
	private String customerContact;
	private String customerAddress;
	private String customerType;
	private String dateOfBirth;
	private String companyName;
	private String companyContact;

	// creating default constructor
	public Customer() {

		this.customerId = 0;
		this.customerUserName = "";
		this.customerPassword = "";
		this.customerName = "";
		this.customerEmail = "";
		this.customerContact = "";
		this.customerAddress = "";
		this.customerType = "";
		this.dateOfBirth = "";
		this.companyContact = "";
		this.companyName = "";

	}

	// creating parameterized constructor
	public Customer(int customerId, String customerUserName, String customerPassword, String customerName,
			String customerEmail, String customerContact, String customerAddress, String customerType,
			String dateOfBirth, String companyName, String companyContact) {
		super();
		this.customerId = customerId;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
		this.customerType = customerType;
		this.dateOfBirth = dateOfBirth;
		this.companyName = companyName;
		this.companyContact = companyContact;
	}

	// creating getter and setter method for all variable
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	// creating to string method
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerUserName=" + customerUserName + ", customerPassword="
				+ customerPassword + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", customerContact=" + customerContact + ", customerAddress=" + customerAddress + ", customerType="
				+ customerType + ", dateOfBirth=" + dateOfBirth + ", companyName=" + companyName + ", companyContact="
				+ companyContact + "]";
	}
}