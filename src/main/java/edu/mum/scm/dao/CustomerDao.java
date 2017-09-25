package edu.mum.scm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Credentials;
import edu.mum.scm.domain.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	
	public Customer getCustomerByCredentials(Credentials credentials);

}
