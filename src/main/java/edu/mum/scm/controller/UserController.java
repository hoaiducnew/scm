package edu.mum.scm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.scm.domain.User;
import edu.mum.scm.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/user-register")
	public String addNewUser(@ModelAttribute User user) {
		return "user-register";
	}

	@RequestMapping(value = { "/user-register" }, method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "user-register";
		}

		user = userService.save(user);
		session.setAttribute("user", user);
		return "redirect:/login";
	}

}
