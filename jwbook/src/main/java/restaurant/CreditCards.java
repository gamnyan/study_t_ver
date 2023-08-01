/*CREATE TABLE creditCards(
    cardId IDENTITY,
    cardType VARCHAR(64) NOT NULL,
    cardName VARCHAR(64) NOT NULL,
    discount BIGINT NOT NULL,
    discountType VARCHAR(64) NOT NULL
);*/

package restaurant;

public class CreditCards {
	private int cardId;
	private String cardType;
	private String cardName;
	private int discount;
	private String discountType;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
}
