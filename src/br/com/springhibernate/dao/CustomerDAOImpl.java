package br.com.springhibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.springhibernate.dao.interfaces.CustomerDAO;
import br.com.springhibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		Session sessao = sessionFactory.getCurrentSession();
		List<Customer> customers = new ArrayList<>();
		try {
			Query query = sessao.createQuery("from Customer order by firstName", Customer.class);
			customers = query.getResultList();
		} catch (JDBCException ex) {
			System.out.println(ex.getCause() + "------" + ex.getMessage());
		}
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session sessao = sessionFactory.getCurrentSession();
		sessao.saveOrUpdate(customer);
	}

	@Override
	public Customer findById(int id) {
		Session sessao = sessionFactory.getCurrentSession();
		return sessao.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session sessao = sessionFactory.getCurrentSession();
		sessao.delete(new Customer(id, "", "", ""));
	}

}
