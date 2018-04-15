package sky.broadcaster.impl;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sky.broadcaster.model.Customer;
import sky.broadcaster.service.CustomerLocationService;

@Service
public class CustomerLocationServiceImpl implements CustomerLocationService{

	private static final Logger log = LoggerFactory.getLogger(CustomerLocationServiceImpl.class);
	
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	/** Returns location of customer from customer table
	 * 
	 */
	@Override
	public int getLocationOfCustomer(int customerId) {
		EntityManager entityManager =null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Customer user = entityManager.find(Customer.class, customerId);		      
			return user.getLocationId();
		} catch (Exception e) {
			log.error("Error while getLocationOfCustomer()", e);
			throw e;
		}finally {
			entityManager.close();
		}
	}

}
