package jjw.project.crmlearn.services;

import java.util.List;

import jjw.project.crmlearn.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void deleteCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);

	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(String customerId);

}
