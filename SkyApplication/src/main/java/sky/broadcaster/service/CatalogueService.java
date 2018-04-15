package sky.broadcaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sky.broadcaster.model.Product;

@Service
public interface CatalogueService {

	public List<Product> getListOfSportsChannelsForLocation(int locationId);
	
	public List<Product> getListOfNewsChannelsForLocation();

}
