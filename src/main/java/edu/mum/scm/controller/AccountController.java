package edu.mum.scm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scm.domain.Account;
import edu.mum.scm.domain.Cart;
import edu.mum.scm.domain.Customer;
import edu.mum.scm.domain.Order;
import edu.mum.scm.domain.Payment;
import edu.mum.scm.service.AccountService;

@Controller
@RequestMapping("/account")
@SessionAttributes({ "cart", "customer" })
public class AccountController {

	@Autowired
	AccountService accountservice;

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public @ResponseBody Account saveAccount(@Valid @RequestBody Account account, Model model) {
		//creditCardProcessor.verifyAccount();
		System.out.println("accounting saving ...");
		Customer customer = (Customer) model.asMap().get("customer");
		accountservice.saveAccount(account, customer);
		model.addAttribute("customer", customer);
		return account;
	}

	@RequestMapping(value = "/checkoutStep3Payment", method = RequestMethod.POST)
	public String checkoutStep3Payment(Payment payment, Model model, RedirectAttributes redir) {
		// creditcardProcessor.processPayment(payment);
		Customer customer = (Customer) model.asMap().get("customer");
		Cart cart = (Cart) model.asMap().get("cart");
		Order order = accountservice.payANDorder(payment, customer, cart);
		redir.addFlashAttribute(order);
		return "redirect:/account/orderDetails";
	}

	@RequestMapping("orderDetails")
	public String showOrderDetails() {
		return "orderDetails";
	}

}