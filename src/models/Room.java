package models;

public class Room {
	// declaring instance variable
	private int roomId;
	private String roomType;
	private int roomPrice;
	private String availabilityStatus;

	// creating default constructor
	public Room() {
		super();
		this.roomId = 0;
		this.roomType = "";
		this.roomPrice = 0;
		this.availabilityStatus = "";
	}

	// creating parameterized constructor
	public Room(int roomId, String roomType, int roomPrice, String availabilityStatus) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.availabilityStatus = availabilityStatus;
	}

	// creating getter and setter for all variable
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

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	// creating to string method
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomPrice=" + roomPrice
				+ ", availabilityStatus=" + availabilityStatus + "]";
	}

}