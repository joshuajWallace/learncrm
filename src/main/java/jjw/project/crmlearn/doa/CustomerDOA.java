package jjw.project.crmlearn.doa;

import java.util.List;
import jjw.project.crmlearn.entity.Customer;

public interface CustomerDOA {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public void updateCustomer(Customer updatedCustomer);

	

}
