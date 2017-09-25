package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.User;
import edu.mum.scm.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Customer getCustomerByCredentials(User credentials);

}
