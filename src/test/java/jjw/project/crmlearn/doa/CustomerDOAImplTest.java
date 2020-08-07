package jjw.project.crmlearn.doa;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerDOAImplTest {
	
	@Mock
	SessionFactory sessionFactory;
	
	@InjectMocks
	CustomerDOA customerDOA;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetCustomers() {
		customerDOA.getCustomers();
	}

	@Test
	void testAddCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomersStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomersString() {
		fail("Not yet implemented");
	}

}
