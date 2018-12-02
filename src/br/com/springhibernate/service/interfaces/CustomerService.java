package br.com.springhibernate.service.interfaces;

import java.util.List;

import br.com.springhibernate.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
