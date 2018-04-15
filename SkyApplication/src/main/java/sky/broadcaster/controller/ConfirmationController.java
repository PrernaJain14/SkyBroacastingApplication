package sky.broadcaster.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ConfirmationController {
	
	private static final Logger log = LoggerFactory.getLogger(ConfirmationController.class);

	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String showConfirmationView(ModelMap model, HttpServletRequest request, HttpSession session) {
		try {

			int id = Integer.parseInt(""+session.getAttribute("customer_id"));
			model.put("customerID", id);
			return "success";
		} catch (Exception e) {
			log.error("Problem while performing the operation",e);
			return "error";
		}
		
	}

}
