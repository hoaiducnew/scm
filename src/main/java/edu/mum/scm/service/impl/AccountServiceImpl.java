package edu.mum.scm.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.dao.AccountDao;
import edu.mum.scm.domain.Account;
import edu.mum.scm.domain.Cart;
import edu.mum.scm.domain.Customer;
import edu.mum.scm.domain.LineItem;
import edu.mum.scm.domain.Order;
import edu.mum.scm.domain.OrderStatus;
import edu.mum.scm.domain.Payment;
import edu.mum.scm.domain.Product;
import edu.mum.scm.service.AccountService;
import edu.mum.scm.service.CustomerService;
import edu.mum.scm.service.ProductService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountdao;
	@Autowired
	ProductService productservice;
	@Autowired
	CustomerService customerservice;

	public void saveAccount(Account account, Customer customer) {

		customer.setAccount(account);
		account.setCustomer(customer);
		account.setCustomer(customer);
		accountdao.save(account);
		customerservice.saveCustomer(customer);
	}

	public Order payANDorder(Payment payment, Customer customer, Cart cart) {
		Account account = accountdao.getAccountByCardNo(customer.getAccount().getCardNo());
		for (LineItem item : cart.getItems()) {
			Product product = productservice.getProduct(item.getProduct().getProductcode());
			product.setQuantity(product.getQuantity() - item.getQuanity());

		}

		payment.setTotal(cart.getTotalamout());
		payment.setAccount(account);

		Order order = new Order();
		order.setOrderstatus(OrderStatus.NEW);
		order.setShippingAdress(customer.getAddress());
		order.setPayment(payment);
		payment.setOrder(order);
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(payment);
		account.setPayments(payments);
		List<Cart> carts = new ArrayList<Cart>();
		carts.add(cart);
		account.setCarts(carts);
		accountdao.save(account);
		return order;
	}

}
