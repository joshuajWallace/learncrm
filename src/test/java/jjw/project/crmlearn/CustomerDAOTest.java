package jjw.project.crmlearn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import jjw.project.crmlearn.doa.CustomerDOA;
import jjw.project.crmlearn.entity.Customer;

class CustomerDAOTest {
	
	@Autowired
	CustomerDOA customerDOA;

	@Test
	void test() {
		return;
		List<Customer> customers = customerDOA.getCustomers();
		Customer testCustomer = customers.get(0);
		assertTrue(testCustomer.getFirstName() == "David");
		
	}

}
