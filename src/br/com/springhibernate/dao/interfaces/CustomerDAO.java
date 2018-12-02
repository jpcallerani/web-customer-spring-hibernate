package br.com.springhibernate.dao.interfaces;

import java.util.List;

import br.com.springhibernate.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer findById(int id);

	public void deleteCustomer(int id);
	
}
