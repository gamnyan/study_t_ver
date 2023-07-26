package p;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class MadangDAO {
	protected DataSource dataSource;

	public MadangDAO() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/jwbookdb");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	public List<Book> selectBook() {
		List<Book> rtn = new ArrayList<>();

		String sql = "SELECT id, title, publisher, price FROM book";
		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				rtn.add(book);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public Book selectBookById(int id) {
		Book rtn = null;

		String sql = "SELECT id, title, publisher, price FROM book WHERE id = ?";
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Book book = new Book();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setPublisher(rs.getString("publisher"));
					book.setPrice(rs.getInt("price"));
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public List<Customer> selectCustomer() {
		List<Customer> rtn = new ArrayList<>();

		String sql = "SELECT id, name, address, phone FROM customer";
		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				rtn.add(customer);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public Customer selectCustomerById(int id) {
		Customer rtn = null;

		String sql = "SELECT id, name, address, phone FROM customer WHERE id = ?";
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					rtn = new Customer();
					rtn.setId(rs.getInt("id"));
					rtn.setName(rs.getString("name"));
					rtn.setAddress(rs.getString("address"));
					rtn.setPhone(rs.getString("phone"));
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO customer (name, address, phone) VALUES (?,?,?)";
		
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhone());
			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void updateCustomer(Customer customer) {
		String sql = "UPDATE customer SET name = ?, address = ?, phone = ? WHERE id = ?";
		
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhone());
			ps.setInt(4, customer.getId());
			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM customer WHERE id = ?";
		
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public List<Ordering> selectOrdering() {
		List<Ordering> rtn = new ArrayList<>();

		String sql = "SELECT o.id, o.sellingPrice, o.orderingDate, c.name, b.title FROM ordering o JOIN customer c ON o.customerId = c.id JOIN book b ON o.bookId = b.id";
		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Ordering ordering = new Ordering();
				ordering.setId(rs.getInt("id"));
				ordering.setSellingPrice(rs.getInt("sellingPrice"));
				ordering.setOrderingDate(rs.getDate("orderingDate"));
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				ordering.setCustomer(customer);
				Book book = new Book();
				book.setTitle(rs.getString("title"));
				ordering.setBook(book);
				rtn.add(ordering);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public void insertOrdering(Ordering ordering) {
		String sql = "INSERT INTO ordering (customerId, bookId, sellingPrice, orderingDate) VALUES (?,?,?,?)";
		
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, ordering.getCustomerId());
			ps.setInt(2, ordering.getBookId());
			ps.setInt(3, ordering.getSellingPrice());
			ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public int selectCountByCustomerId(int customerId) {
		int rtn = -1;

		String sql = "SELECT COUNT(*) FROM ordering WHERE customerId = ?";
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, customerId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					rtn = rs.getInt(1);
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	
}
