package sky.broadcaster.service;

import org.springframework.stereotype.Service;

@Service
public interface CustomerLocationService {
	
	public int getLocationOfCustomer(int customerId);
	
	

}
