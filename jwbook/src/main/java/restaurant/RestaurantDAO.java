package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/C:/Java/H2/data/jwbookdb";

	// DB 연결을 가져오는 메서드
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sa", "sa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 뉴스 기사 목록 전체를 가져오는 메서드
	public List<CardTypes> getCardTypes() throws Exception {
		Connection conn = open();
		List<CardTypes> cardTypeList = new ArrayList<>();

		String sql = "SELECT cardTypeId, cardType, title FROM cardTypes";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				CardTypes ct = new CardTypes();
				ct.setCardTypeId(rs.getInt("cardTypeId"));
				ct.setCardType(rs.getString("cardType"));
				ct.setTitle(rs.getString("title"));
				cardTypeList.add(ct);
			}
			return cardTypeList;
		}
	}

	public List<Coupons> getCoupons() throws Exception {
		Connection conn = open();
		List<Coupons> couponList = new ArrayList<>();

		String sql = "SELECT couponId, title, discount, doubleDiscount, discountType FROM coupons";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Coupons c = new Coupons();
				c.setCouponId(rs.getInt("couponId"));
				c.setTitle(rs.getString("title"));
				c.setDiscount(rs.getInt("discount"));
				couponList.add(c);
			}
			return couponList;
		}
	}

	public List<CreditCards> getCreditCards() throws Exception {
		Connection conn = open();
		List<CreditCards> creditCardList = new ArrayList<>();

		String sql = "SELECT cardId, cardType, cardName, discount, discountType FROM creditCards";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				CreditCards cc = new CreditCards();
				cc.setCardId(rs.getInt("cardId"));
				cc.setCardType(rs.getString("cardType"));
				cc.setCardName(rs.getString("cardName"));
				creditCardList.add(cc);
			}
			return creditCardList;
		}
	}

	public List<Drinks> getDrinks() throws Exception {
		Connection conn = open();
		List<Drinks> drinkList = new ArrayList<>();

		String sql = "SELECT drinkId, drinkName, price, stock FROM drinks";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Drinks d = new Drinks();
				d.setDrinkId(rs.getInt("drinkId"));
				d.setDrinkName(rs.getString("drinkName"));
				d.setPrice(rs.getInt("price"));
				drinkList.add(d);
			}
			return drinkList;
		}
	}

	public List<Menus> getMenus() throws Exception {
		Connection conn = open();
		List<Menus> menuList = new ArrayList<>();

		String sql = "SELECT menuId, menuName, price FROM menus";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Menus m = new Menus();
				m.setMenuId(rs.getInt("menuId"));
				m.setMenuName(rs.getString("menuName"));
				m.setPrice(rs.getInt("price"));
				menuList.add(m);
			}
			return menuList;
		}
	}
//
//	// 뉴스 한 개를 클릭했을 때 세부 내용을 보여주는 메서드
//	public News getNews(int aid) throws SQLException {
//		Connection conn = open();
//		News n = new News();
//		String sql = "select aid, title, img, FORMATDATETIME(date, 'yyyy-MM-dd hh:mm:ss')as cdate, content from news where aid=?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, aid);
//		ResultSet rs = pstmt.executeQuery();
//		rs.next();
//
//		try (conn; pstmt; rs) {
//			n.setAid(rs.getInt("aid"));
//			n.setTitle(rs.getString("title"));
//			n.setImg(rs.getString("img"));
//			n.setDate(rs.getString("cdate"));
//			n.setContent(rs.getString("content"));
//			pstmt.executeQuery();
//			return n;
//		}
//	}
//
//	// 뉴스 추가 메서드
//	public void addNews(News n) throws Exception {
//		Connection conn = open();
//		String sql = "insert into news(title, img, date, content) values(?,?,CURRENT_TIMESTAMP(),?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		try (conn; pstmt) {
//			pstmt.setString(1, n.getTitle());
//			pstmt.setString(2, n.getImg());
//			pstmt.setString(3, n.getContent());
//			pstmt.executeUpdate();
//		}
//	}
//
//	// 뉴스 삭제 메서드
//	public void delNews(int aid) throws SQLException {
//		Connection conn = open();
//		String sql = "delete from news where aid=?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		try (conn; pstmt) {
//			pstmt.setInt(1, aid);
//			if (pstmt.executeUpdate() == 0) {
//				throw new SQLException("DB에러");
//			}
//		}
//	}
}
