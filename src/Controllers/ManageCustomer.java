package Controllers;

import models.Customer;

public class ManageCustomer {
	private Customer customer;

	public ManageCustomer() {
		this.customer = new Customer();
	}

	public ManageCustomer(Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void login() {
		this.customer = new JDBC().login(this.customer);
	}
}
