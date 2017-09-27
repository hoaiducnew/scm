package edu.mum.scm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.scm.domain.User;
import edu.mum.scm.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/register")
	public String addNewUser(@ModelAttribute User user) {
		return "user-add";
	}

	@RequestMapping("/save")
	public String saveCustomer(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			System.out.println("inside binding result error");
			return "user-add";
		}
		
		user = userService.save(user);
		session.setAttribute("user" , user);
		
//		customerservice.saveCustomer(customer);
		return "redirect:/";
	}

}
