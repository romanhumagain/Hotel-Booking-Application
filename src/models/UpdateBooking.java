package models;

public class UpdateBooking {
	// declaring instance variables
	private int bookingId;
	private String checkIn;
	private String checkOut;
	private String roomType;
	private int numberOfRoom;
	private String bookingStatus;
	private String paymentStatus;
	private int customerId;
	private int managerId;
	private int roomId;

	// creating default constructor
	public UpdateBooking() {
		this.bookingId = 0;
		this.checkIn = "";
		this.checkOut = "";
		this.roomType = "";
		this.numberOfRoom = 0;
		this.bookingStatus = "";
		this.paymentStatus = "";
		this.customerId = 0;
		this.managerId = 0;
		this.roomId = 0;
	}

	// creating parameterized constructor
	public UpdateBooking(int bookingId, String checkIn, String checkOut, String roomType, int numberOfRoom,
			String bookingStatus, String paymentStatus, int customerId, int managerId, int roomId) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomType = roomType;
		this.numberOfRoom = numberOfRoom;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.customerId = customerId;
		this.managerId = managerId;
		this.roomId = roomId;
	}

	// creating getter and setter
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	// creating to string method
	@Override
	public String toString() {
		return "UpdateBooking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", roomType=" + roomType + ", numberOfRoom=" + numberOfRoom + ", bookingStatus=" + bookingStatus
				+ ", paymentStatus=" + paymentStatus + ", customerId=" + customerId + ", managerId=" + managerId
				+ ", roomId=" + roomId + "]";
	}

}
