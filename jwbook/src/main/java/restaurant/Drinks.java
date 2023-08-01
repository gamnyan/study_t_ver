/*CREATE TABLE drinks(
    drinkId IDENTITY,
    drinkName VARCHAR(64) NOT NULL,
    price BIGINT NOT NULL,
    stock BIGINT NOT NULL
);*/

package restaurant;

public class Drinks {
	private int drinkId;
	private String drinkName;
	private int price;
	private int stock;

	public int getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
