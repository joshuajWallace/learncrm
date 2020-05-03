package jjw.project.crmlearn.doa;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jjw.project.crmlearn.entity.Customer;

@Repository
public class CustomerDOAImpl implements CustomerDOA {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
				
		return query.getResultList();
	}
	
	@Override
	public void addCustomer(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(customer);	
		
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		currentSession.delete(customer);	
		
	}
	@Override
	public void updateCustomer(Customer updatedCustomer) {
		
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(updatedCustomer);
		
			
		
	}

}
