package models;

public class Profile {
	// declaring instance variable
	private String Name;
	private int bookingId;
	private String checkIn;
	private String checkOut;
	private String bookingStatus;
	private int roomId;
	private String roomType;
	private String paymentStatus;

	// creating default constructor
	public Profile() {
		this.Name = "";
		this.bookingId = 0;
		this.checkIn = "";
		this.checkOut = "";
		this.bookingStatus = "";
		this.roomId = 0;
		this.roomType = "";
		this.paymentStatus = "";
	}

	// creating parameterized constructor
	public Profile(String name, int bookingId, String checkIn, String checkOut, String bookingStatus, int roomId,
			String roomType, String paymentStatus) {
		super();
		Name = name;
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.bookingStatus = bookingStatus;
		this.roomId = roomId;
		this.roomType = roomType;
		this.paymentStatus = paymentStatus;
	}

	// creating getter and setter
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

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

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	// creating to string method
	@Override
	public String toString() {
		return "profile [Name=" + Name + ", bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", bookingStatus=" + bookingStatus + ", roomId=" + roomId + ", roomType=" + roomType + ", paymentStatus="
				+ paymentStatus + "]";
	}
}
