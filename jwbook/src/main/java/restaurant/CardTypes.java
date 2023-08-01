/*CREATE TABLE cardTypes(
    cardType VARCHAR(64) NOT NULL,
    title VARCHAR(64) NOT NULL
);*/

package restaurant;

public class CardTypes {
	private int cardTypeId;
	private String cardType;
	private String title;

	public int getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
