package models;

public class Booking {

	// declaring instance variable
	private int bookingId;
	private String checkIn;
	private String checkOut;
	private String roomType;
	private int numberOfRoom;
	private String bookingStatus;
	private String paymentStatus;
	private int customerId;
	private int managerId;
	private String roomId;

	// creating default constructor
	public Booking() {

		this.bookingId = 0;
		this.checkIn = "";
		this.checkOut = "";
		this.roomType = "";
		this.numberOfRoom = 0;
		this.bookingStatus = "";
		this.paymentStatus = "";
		this.customerId = 0;
		this.managerId = 0;
		this.roomId = "";
	}

	// creating parameterized constructor
	public Booking(int bookingId, String checkIn, String checkOut, String roomType, int numberOfRoom,
			String bookingStatus, String paymentStatus, int customerId, int managerId, String roomId) {
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

	// getter and setter for all variable
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

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getNumberOfRoom() {
		return numberOfRoom;
	}

	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	// creating to string method
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", roomType="
				+ roomType + ", numberOfRoom=" + numberOfRoom + ", bookingStatus=" + bookingStatus + ", paymentStatus="
				+ paymentStatus + ", customerId=" + customerId + ", managerId=" + managerId + ", roomId=" + roomId
				+ "]";
	}
}
