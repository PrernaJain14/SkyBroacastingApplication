package sky.broadcaster.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sky.broadcaster.model.Product;
import sky.broadcaster.service.CatalogueService;

/** Its a db connecting class to retrieve records from mysql db
 * 
 * @author Inspiration
 *
 */
@Service
public class CatalogueServiceImpl implements CatalogueService{
	
	private static final Logger log = LoggerFactory.getLogger(CatalogueServiceImpl.class);
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	/** Returns list of sports channels that are available.
	 * 
	 */
	@Override
	public List<Product> getListOfSportsChannelsForLocation(int locationId) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sql = "SELECT u from Product u where u.category=1 and u.is_available=1 and u.locationId = "+locationId;
			Query query = entityManager.createQuery(sql);
			List<Product> productsList =  query.getResultList();
				      
			return productsList;
		} catch (Exception e) {
			log.error("Error while getListOfSportsChannelsForLocation()", e);
			throw e;
		}finally {
			entityManager.close();
		}
	}

	/** Returns list of news channels that are available.
	 * 
	 */
	@Override
	public List<Product> getListOfNewsChannelsForLocation() {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sql = "SELECT distinct u from Product u where u.category=2 and u.is_available=1";
			Query query = entityManager.createQuery(sql);
			List<Product> productsList =  query.getResultList();
			return productsList;
		} catch (Exception e) {
			log.error("Error while getListOfNewsChannelsForLocation()", e);
			throw e;
		}finally {
			entityManager.close();
		}
	}
	

}
