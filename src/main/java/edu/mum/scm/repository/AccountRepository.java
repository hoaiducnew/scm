package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	public Account getAccountByCardNo(String cardNo);

}
