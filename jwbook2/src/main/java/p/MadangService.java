package p;

import java.util.List;

public class MadangService {
	MadangDAO dao;

	public MadangService() {
		dao = new MadangDAO();
	}

	public List<Book> getBook() {
		return dao.selectBook();
	}

	public Book getBook(int id) {
		return dao.selectBookById(id);
	}

	public List<Customer> getCustomer() {
		return dao.selectCustomer();
	}

	public Customer getCustomerOrBlank(int id) {
		Customer rtn = null;

		rtn = dao.selectCustomerById(id);

		if (rtn == null) {
			rtn = new Customer();
			rtn.setId(-1);
			rtn.setName("");
			rtn.setAddress("");
			rtn.setPhone("");
		}

		return rtn;
	}
	
	public void addCustomer(Customer customer) {
		dao.insertCustomer(customer);
	}
	
	public void setCustomer(Customer customer) {
		dao.updateCustomer(customer);
	}
	
	public void removeCustomer(int id) {
		dao.deleteCustomer(id);
	}
	
	public List<Ordering> getOrdering(){
		return dao.selectOrdering();
	}
	
	public void addOrdering(Ordering ordering) {
		dao.insertOrdering(ordering);
	}
	
	boolean hasOrderingCustomer(int customerId) {
		boolean rtn = false;
		
		if(dao.selectCountByCustomerId(customerId) > 0) {
			rtn = true;
		}
		
		return rtn;
	}
}
