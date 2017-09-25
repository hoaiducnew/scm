package edu.mum.scm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.dao.CredentialsDao;
import edu.mum.scm.dao.CustomerDao;
import edu.mum.scm.domain.Credentials;
import edu.mum.scm.domain.Customer;
import edu.mum.scm.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerdao;
	
	@Autowired
	CredentialsDao credentialsdao;
	
	public Customer fetchCustomer(String username) {
		Credentials credentials = credentialsdao.getCredentialsByUsername(username);
		return customerdao.getCustomerByCredentials(credentials);

	}

	public void saveCustomer(Customer customer) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(customer.getCredentials().getPassword());
		customer.getCredentials().setPassword(encodedPassword);
		customerdao.save(customer);
	}

}
