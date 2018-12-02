package br.com.springhibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springhibernate.dao.interfaces.CustomerDAO;
import br.com.springhibernate.entity.Customer;
import br.com.springhibernate.service.interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.findById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

}
