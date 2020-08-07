package jjw.project.crmlearn.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCustomerStringStringString() {
		String firstName = "John";
		String lastName = "Doe";
		String email = "johndoe@email.com";
		Customer testCustomer = new Customer(firstName, lastName, email);
		
		assertEquals(firstName, testCustomer.getFirstName());
		assertEquals(lastName, testCustomer.getLastName());
		assertEquals(email, testCustomer.getEmail());
	}

}
