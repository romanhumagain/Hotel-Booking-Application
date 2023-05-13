package models;

public class Bill {
	// declaring instance variables
	private int billNumber;
	private int totalAmount;
	private String paymentMethod;
	private String paymentDate;
	private int bookingId;

	// creating default constructor
	public Bill() {

		this.billNumber = 0;
		this.totalAmount = 0;
		this.paymentMethod = "";
		this.paymentDate = "";
		this.bookingId = 0;
	}

	// creating parameterized constructor
	public Bill(int billNumber, int totalAmount, String paymentMethod, String paymentDate, int bookingId) {
		super();
		this.billNumber = billNumber;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.bookingId = bookingId;
	}

	// getter and setter method for all variable
	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	// creating to string method
	@Override
	public String toString() {
		return "Bill [billNumber=" + billNumber + ", totalAmount=" + totalAmount + ", paymentMethod=" + paymentMethod
				+ ", paymentDate=" + paymentDate + ", bookingId=" + bookingId + "]";
	}

}
