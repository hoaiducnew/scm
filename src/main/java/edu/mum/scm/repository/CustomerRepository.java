package edu.mum.scm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
