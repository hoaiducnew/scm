package edu.mum.scm.service;

import edu.mum.scm.domain.Account;
import edu.mum.scm.domain.Cart;
import edu.mum.scm.domain.Customer;
import edu.mum.scm.domain.Order;
import edu.mum.scm.domain.Payment;

public interface AccountService {
	public void saveAccount(Account account, Customer customer);

	public Order payANDorder(Payment payment, Customer customer, Cart cart);

}
