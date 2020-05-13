package jjw.project.crmlearn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jjw.project.crmlearn.entity.Customer;
import jjw.project.crmlearn.services.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
	
		return "list-customers";
	}
	
	@GetMapping("/search")
	public String searchCustomerName(@RequestParam("name") String name, Model theModel){
		name.strip();
		String[] names = name.split(" ");
		List<Customer> customers;
		if(names.length > 1) {
			customers = customerService.getCustomers(names[0], names[1]);
		}
		else {
			customers = customerService.getCustomers(names[0]);
		}
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/add-customer")
	public String addCustomer(Model theModel) {
		Customer newCustomer = new Customer();
		theModel.addAttribute("customer", newCustomer);
		return "add-customer";
	}
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.addCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/update-customer")
	public String updateCustomerForm(@RequestParam("customerId") String customerId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(customerId);
		theModel.addAttribute("customer", theCustomer);
		return "update";
	}
	@PostMapping("/update-customer")
	public String updateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.updateCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam("customerId") String customerId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(customerId);
		customerService.deleteCustomer(theCustomer);
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		return "redirect:/customers/list";
	}
}
