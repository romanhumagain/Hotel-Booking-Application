package models;

public class Register {
	// declaring instance variables
	private int customerId;
	private String fullName;
	private String address;
	private String contact;
	private String email;
	private String gender;
	private String country;
	private String customerType;
	private String customerUserName;
	private String customerPassword;
	private String dateOfBirth;
	private String companyName;
	private String companyContact;

	// creating default constructor
	public Register() {

		this.customerId = 0;
		this.fullName = "";
		this.address = "";
		this.contact = "";
		this.email = "";
		this.gender = "";
		this.country = "";
		this.customerType = "";
		this.customerUserName = "";
		this.customerPassword = "";
		this.dateOfBirth = "";
		this.companyName = "";
		this.companyContact = "";

	}

	// creating parameterized constructor
	public Register(int customerId, String fullName, String address, String contact, String email, String gender,
			String country, String customerType, String customerUserName, String customerPassword, String dateOfBirth,
			String companyName, String companyContact) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.customerType = customerType;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
		return "Register [customerId=" + customerId + ", fullName=" + fullName + ", address=" + address + ", contact="
				+ contact + ", email=" + email + ", gender=" + gender + ", country=" + country + ", customerType="
				+ customerType + ", customerUserName=" + customerUserName + ", customerPassword=" + customerPassword
				+ ", dateOfBirth=" + dateOfBirth + ", companyName=" + companyName + ", companyContact=" + companyContact
				+ "]";
	}

}