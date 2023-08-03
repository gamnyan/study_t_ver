package restaurant;

import java.util.List;

public class RestaurantService {
	RestaurantDAO dao;

	public RestaurantService() {
		dao = new RestaurantDAO();
	}

	public List<CardTypes> getCardTypes() {
		return dao.selectCardTypes();
	}

	public CardTypes getCardTypesById(int cardTypeId) {
		return dao.selectCardTypesById(cardTypeId);
	}
	
	public List<Coupons> getCoupons() {
		return dao.selectCoupons();
	}
	
	public Coupons getCouponsById(int couponId) {
		return dao.selectCouponsById(couponId);
	}
	public List<CreditCards> getCreditCards() {
		return dao.selectCreditCards();
	}
	
	public CreditCards getCreditCardsById(int cardId) {
		return dao.selectCreditCardsById(cardId);
	}
	public List<Drinks> getDrinks() {
		return dao.selectDrinks();
	}
	
	public Drinks getDrinksById(int drinkId) {
		return dao.selectDrinksById(drinkId);
	}
	public List<Menus> getMenus() {
		return dao.selectMenus();
	}
	
	public Menus getMenusById(int menuId) {
		return dao.selectMenusById(menuId);
	}
}
