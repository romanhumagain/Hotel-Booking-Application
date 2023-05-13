package models;

public class Cancel {
	// declaring instance variable
	private int bookingId;

	public Cancel() {
		this.bookingId = 0;
	}

	public Cancel(int bookingId) {
		super();
		this.bookingId = bookingId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
//creating to string method
	@Override
	public String toString() {
		return "Cancel [bookingId=" + bookingId + "]";
	}

}
