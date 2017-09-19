package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.domain.Customer;
import edu.mum.scm.repository.CustomerRepository;
import edu.mum.scm.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer findOne(Long id) {
		return (Customer) customerRepository.findOne(id);
	}

}
