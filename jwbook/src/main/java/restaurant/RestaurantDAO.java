package restaurant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class RestaurantDAO {
	protected DataSource dataSource;

	final static String QUERY_PATH = "/restaurant/restaurant_sql.properties";
	final static Map<String, String> QM;
	static {
		try {
			QM = QueryLoader.instance().load(QUERY_PATH);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new ExceptionInInitializerError(ioe);
		}
	}

	public RestaurantDAO() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/jwbookdb");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}

	public List<CardTypes> selectCardTypes() {
		List<CardTypes> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<CardTypes>> h = new BeanListHandler<>(CardTypes.class);
			rtn = qr.query(QM.get("selectCardTypes"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public List<Coupons> selectCoupons() {
		List<Coupons> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Coupons>> h = new BeanListHandler<>(Coupons.class);
			rtn = qr.query(QM.get("selectCoupons"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public List<CreditCards> selectCreditCards() {
		List<CreditCards> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<CreditCards>> h = new BeanListHandler<>(CreditCards.class);
			rtn = qr.query(QM.get("selectCreditCards"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public List<Drinks> selectDrinks() {
		List<Drinks> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Drinks>> h = new BeanListHandler<>(Drinks.class);
			rtn = qr.query(QM.get("selectDrinks"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public List<Menus> selectMenus() {
		List<Menus> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Menus>> h = new BeanListHandler<>(Menus.class);
			rtn = qr.query(QM.get("selectMenus"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public CardTypes selectCardTypesById(int cardTypeId) {
		CardTypes rtn = null;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<CardTypes> h = new BeanHandler<>(CardTypes.class);
			Object[] p = { cardTypeId };
			rtn = qr.query(QM.get("selectCardTypesById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	public Coupons selectCouponsById(int couponId) {
		Coupons rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Coupons> h = new BeanHandler<>(Coupons.class);
			Object[] p = { couponId };
			rtn = qr.query(QM.get("selectCouponsById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	public CreditCards selectCreditCardsById(int cardId) {
		CreditCards rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<CreditCards> h = new BeanHandler<>(CreditCards.class);
			Object[] p = { cardId };
			rtn = qr.query(QM.get("selectCreditCardsById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	public Drinks selectDrinksById(int drinkId) {
		Drinks rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Drinks> h = new BeanHandler<>(Drinks.class);
			Object[] p = { drinkId };
			rtn = qr.query(QM.get("selectDrinksById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	public Menus selectMenusById(int menuId) {
		Menus rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Menus> h = new BeanHandler<>(Menus.class);
			Object[] p = { menuId };
			rtn = qr.query(QM.get("selectMenusById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
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
