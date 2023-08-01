/*CREATE TABLE coupons(
    couponId IDENTITY,
    title VARCHAR(64) NOT NULL,
    discount BIGINT NOT NULL,
    doubleDiscount BOOLEAN,
    discountType VARCHAR(64) NOT NULL
);*/

package restaurant;

public class Coupons {
	private int couponId;
	private String title;
	private int discount;
	private boolean doubleDiscount;
	private String discountType;

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isDoubleDiscount() {
		return doubleDiscount;
	}

	public void setDoubleDiscount(boolean doubleDiscount) {
		this.doubleDiscount = doubleDiscount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
}
