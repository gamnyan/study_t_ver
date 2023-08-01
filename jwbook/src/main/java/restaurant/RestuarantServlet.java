package restaurant;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/restaurantControl")
public class RestuarantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDAO dao;
	private ServletContext ctx;

	// 웹 리소스 기본 경로 지정
	private final String START_PAGE = "restaurant/bill.jsp";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new RestaurantDAO();
		ctx = getServletContext();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		dao = new RestaurantDAO();

		// 자바 리플레션을 사용해 if(switch) 없이 요청에 따라 구현 메서드가 실행되도록 구성
		Method m;
		String view = null;

		// action 파라미터 없이 접근한 경우
		if (action == null) {
//			action = "listCardTypes";
//			action = "listCoupons";
//			action = "listCreditCards";
//			action = "listDrinks";
//			action = "listMenus";
			action = "listRestaurant";
		}

		try {
			// 현재 클래스에서 action 이름과 HttpServletRequest를 파라미터로 하는 메서드 찾음
			m = this.getClass().getMethod(action, HttpServletRequest.class);

			// 메서드 실행 후 리턴값 받아옴
			view = (String) m.invoke(this, request);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			ctx.log("요청 action 없음!!");
			request.setAttribute("error", "action 파라미터가 잘못되었습니다!!");
			view = START_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// POST 요청에서는 리디렉션 방법으로 이동하도록 분기
		if (view.startsWith("redirect:/")) {
			String rview = view.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
	
	public String listRestaurant(HttpServletRequest request) {
		List<CardTypes> cardTypeList;
		List<Coupons> couponList;
		List<CreditCards> creditCardList;
		List<Drinks> drinkList;
		List<Menus> menuList;
		try {
			cardTypeList = dao.getCardTypes();
			request.setAttribute("cardTypeList", cardTypeList);
			couponList = dao.getCoupons();
			request.setAttribute("couponList", couponList);
			creditCardList = dao.getCreditCards();
			request.setAttribute("creditCardList", creditCardList);
			drinkList = dao.getDrinks();
			request.setAttribute("drinkList", drinkList);
			menuList = dao.getMenus();
			request.setAttribute("menuList", menuList);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("메뉴 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "메뉴 목록이 정상적으로 처리되지 않았습니다!!");
		}
		return "restaurant/bill.jsp";
	}

//	public String listCardTypes(HttpServletRequest request) {
//		List<CardTypes> cardTypeList;
//		try {
//			cardTypeList = dao.getCardTypes();
//			request.setAttribute("cardTypeList", cardTypeList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("카드타입 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "카드타입 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listCoupons(HttpServletRequest request) {
//		List<Coupons> couponList;
//		try {
//			couponList = dao.getCoupons();
//			request.setAttribute("couponList", couponList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("쿠폰 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "쿠폰 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listCreditCards(HttpServletRequest request) {
//		List<CreditCards> creditCardList;
//		try {
//			creditCardList = dao.getCreditCards();
//			request.setAttribute("creditCardList", creditCardList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("크레딧카드 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "크레딧카드 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listDrinks(HttpServletRequest request) {
//		List<Drinks> drinkList;
//		try {
//			drinkList = dao.getDrinks();
//			request.setAttribute("drinkList", drinkList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("음료 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "음료 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listMenus(HttpServletRequest request) {
//		List<Menus> menuList;
//		try {
//			menuList = dao.getMenus();
//			request.setAttribute("menuList", menuList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("메뉴 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "메뉴 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}

//	public String getCardTypes(HttpServletRequest request) {
//		int cardTypeId = Integer.parseInt(request.getParameter("cardTypeId"));
//		try {
//			CardTypes ct = dao.getCardTypes(cardTypeId);
//			request.setAttribute("cardTypes", ct);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("카드타입을 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "카드타입을 정상적으로 가져오지 못했습니다!!");
//		}
//		return "restaurant/restraurant.jsp";
//	}
//	public String getCoupons(HttpServletRequest request) {
//		int couponId = Integer.parseInt(request.getParameter("couponId"));
//		try {
//			Coupons c = dao.getCoupons(couponId);
//			request.setAttribute("coupons", c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("쿠폰을 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "쿠폰을 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}
//	public String getRestaurant(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}
//	public String getRestaurant(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}
//	public String getRestaurant(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}

//	public String addNews(HttpServletRequest request) {
//		News n = new News();
//		try {
//			// 이미지 파일 저장
//			Part part = request.getPart("file");
//			String fileName = getFilename(part);
//			if (fileName != null && !fileName.isEmpty()) {
//				part.write(fileName);
//			}
//			// 입력값을 News 객체로 매핑
//			BeanUtils.populate(n, request.getParameterMap());
//			
//			// 이미지 파일 이름을 News 객체에도 저장
//			n.setImg("/img/" + fileName);
//			dao.addNews(n);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("뉴스 추가 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다!!");
//			return listNews(request);
//		}
//		return "redirect:/news.nhn?action=listNews";
//	}
//
//	public String deleteNews(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			dao.delNews(aid);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스 삭제 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
//			return listNews(request);
//		}
//		return "redirect:/news.nhn?action=listNews";
//	}
//
//	private String getFilename(Part part) {
//		String fileName = null;
//		// 파일 이름이 들어 있는 헤더 영역을 가져옴
//		String header = part.getHeader("content-disposition");
//		System.out.println("Header => " + header);
//
//		// 파일 이름이 들어 있는 속성 부분의 시작 위치를 가져와 " " 사이의 값만 가지고 옴
//		int start = header.indexOf("filename=");
//		fileName = header.substring(start + 10, header.length() - 1);
//		ctx.log("파일명:" + fileName);
//		return fileName;
//	}
}
