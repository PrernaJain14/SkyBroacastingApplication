package sky.broadcaster.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sky.broadcaster.model.Product;
import sky.broadcaster.service.CatalogueService;
import sky.broadcaster.service.CustomerLocationService;

@Controller
public class ProductSelectionController {

	private static final Logger log = LoggerFactory.getLogger(ProductSelectionController.class);

	@Autowired
	CustomerLocationService customerLocationService;

	@Autowired
	CatalogueService catalogueService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showProductSelectionView(ModelMap model, HttpServletRequest request, HttpSession session) {
		try {
			int customer_id=1;
			if(request.getParameter("customer_id")!=null) {
				customer_id = Integer.parseInt(request.getParameter("customer_id"));
			}
			session.setAttribute("customer_id",customer_id );
			int locationId = customerLocationService.getLocationOfCustomer(customer_id);
			List<Product> sportsList = catalogueService.getListOfSportsChannelsForLocation(locationId);
			List<Product> newsList = catalogueService.getListOfNewsChannelsForLocation();
			model.put("sportsList", sportsList);
			model.put("newsList", newsList);
		} catch (Exception e) {
			log.error("Problem while performing the operation");
			return "errorPage";
		}
		
		return "product";
	}

	@RequestMapping(value = "/product/confirm", method = RequestMethod.POST)
	public String showConfirmationPage(ModelMap model, HttpServletRequest request, HttpSession session) {
		int id=1;
		if(session.getAttribute("customer_id")!=null) {
			id = Integer.parseInt(""+session.getAttribute("customer_id"));

		}
		String[] sports = request.getParameterValues("sports");
		if (sports != null && !sports.equals("")) {
			List<String> sportsList = Arrays.asList(sports);
			model.put("sportsList", sportsList);
		}
		String[] news = request.getParameterValues("news");
		if (news != null && !news.equals("")) {
			List<String> newsList = Arrays.asList(news);
			model.put("newsList", newsList);
		}

		model.put("customerID", id);
		return "confirm";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String showErrorView(ModelMap model, HttpServletRequest request, HttpSession session) {
		
		
		return "error";
	}
}
