package edu.mum.scm.service;

import java.util.List;

import edu.mum.scm.domain.Customer;

public interface CustomerService {

	public Customer save(Customer customer);

	public List<Customer> findAll();

	public Customer findOne(Long id);

}
