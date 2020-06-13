package jjw.project.crmlearn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jjw.project.crmlearn.doa.CustomerDOA;
import jjw.project.crmlearn.entity.Customer;

class CustomerDAOs {
	
	@Autowired
	CustomerDOA customerDOA;

	@Test
	@Transactional
	void test() {
		List<Customer> customers = customerDOA.getCustomers();
		Customer testCustomer = customers.get(0);
		assertTrue(testCustomer.getFirstName() == "David");
		
	}

}
