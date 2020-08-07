package jjw.project.crmlearn.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import jjw.project.crmlearn.entity.Customer;
import jjw.project.crmlearn.services.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
	
	@Mock
	CustomerService customerService;
	
	
	@InjectMocks
	CustomerController controller;
	
	MockMvc mockMvc;
	
	List<Customer> customerList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {


		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}

	@Test
	void testListCustomers() throws Exception { 
		customerList.add(new Customer());
		
		given(customerService.getCustomers()).willReturn(customerList);
		
		mockMvc.perform(get("/customers/list")).andExpect(status().isOk())
		.andExpect(model().attribute("customers", customerList))
		.andExpect(view().name("list-customers"));
	}

	@Test
	void testSearchCustomerName() throws Exception {
		customerList.add(new Customer("John", "Doe", "jd@mail.com"));
		
		given(customerService.getCustomers("John")).willReturn(customerList);
		
		given(customerService.getCustomers("John", "Doe")).willReturn(customerList);
		
		mockMvc.perform(get("/customers/search").param("name", "John"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("customers", customerList))
		.andExpect(view().name("list-customers"));
		
		mockMvc.perform(get("/customers/search").param("name", "John Doe"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("customers", customerList))
		.andExpect(view().name("list-customers"));
	}

	@Test
	void testAddCustomer() throws Exception {
		mockMvc.perform(get("/customers/add-new-customer"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("customer"))
		.andExpect(view().name("add-customer"));
	}

	@Test
	void testSaveCustomer() throws Exception {
		mockMvc.perform(post("/customers/save-customer").param("firstName", "John").param("lastName", "Doe").param("email", "jd@mail.com"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/customers/list"));
	}

	@Test
	void testUpdateCustomerForm() throws Exception {
		Customer newCustomer = new Customer("John", "Doe", "jd@mail.com");
		newCustomer.setId(1);
		
		given(customerService.getCustomer("1")).willReturn(newCustomer);
		
		mockMvc.perform(get("/customers/update-customer").param("customerId", "1"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("customer", newCustomer))
		.andExpect(view().name("update"));
	}

	@Test
	void testUpdateCustomer() throws Exception {
		
		mockMvc.perform(post("/customers/update-customer").param("customerId", "1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/customers/list"));
	}

	@Test
	void testDeleteCustomer() throws Exception {
		Customer testCustomer = new Customer("John", "Doe", "jd@mail.com");
		testCustomer.setId(1);
		customerList.add(testCustomer);
		customerList.add(new Customer());
		
		given(customerService.getCustomers()).willReturn(customerList);
		
		mockMvc.perform(get("/customers/delete-customer").param("customerId", "1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(model().attributeExists("customers"))
		.andExpect(view().name("redirect:/customers/list"));
	}

}
