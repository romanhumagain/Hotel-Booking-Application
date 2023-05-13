package models;

public class CreditCard {
	// declaring instance variable
	private String cardNumber;
	private String cardType;
	private String cardHolderName;
	private int customerId;

	// creating default constructor
	public CreditCard() {
		this.cardNumber = "";
		this.cardType = "";
		this.cardHolderName = "";
		this.customerId = 0;
	}

	// creating parameterized constructor
	public CreditCard(String cardNumber, String cardType, String cardHolderName, int customerId) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cardHolderName = cardHolderName;
		this.customerId = customerId;
	}

	// creating getter and setter for all variable
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// creating to string method
	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", cardType=" + cardType + ", cardHolderName=" + cardHolderName
				+ ", customerId=" + customerId + "]";
	}

}