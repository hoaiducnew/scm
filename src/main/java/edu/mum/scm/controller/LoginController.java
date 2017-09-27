package edu.mum.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String homePage(Model model) {
		return "redirect:/teams";

	}

	@RequestMapping("/loginsuccess")
	public String loginsuccess(@ModelAttribute("customer") String username, Model model) {
//		Customer customer = customerservice.fetchCustomer(username);
//
//		if (customer.getCredentials().getRole().equals("ROLE_ADMIN")) {
//			return "redirect:admin/addCategory";
//		}
//		model.addAttribute(customer);
//		if (model.containsAttribute("loginFromCheckout")) {
//
//			return "checkout";
//		}

		return "redirect:/";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

}
