package edu.mum.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.scm.service.UserService;

@Controller
@SessionAttributes({ "user" })
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String homePage(Model model) {
		return "forward:/teams";
	}

	@RequestMapping("/loginsuccess")
	public String loginsuccess(@ModelAttribute("user") String username, Model model) {
		model.addAttribute("user", userService.getUserByUsername(username));
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
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

}
