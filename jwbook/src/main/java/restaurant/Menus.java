/*CREATE TABLE menus(
    menuId IDENTITY,
    menuName VARCHAR(64) NOT NULL,
    price BIGINT NOT NULL
);*/

package restaurant;

public class Menus {
	private int menuId;
	private String menuName;
	private int price;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
