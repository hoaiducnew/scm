package edu.mum.scm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
	public Account getAccountByCardNo(String cardNo);

}
