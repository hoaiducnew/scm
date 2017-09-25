package edu.mum.scm.service;

import edu.mum.scm.domain.Customer;

public interface CustomerService {

	public Customer fetchCustomer(String username);

	public void saveCustomer(Customer customer);

}
