package com.assignment.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.bank.entities.AccountEntity;

/**
 * The Interface AccountRepositoty.
 */
@Repository
public interface AccountRepositoty extends JpaRepository<AccountEntity, Long> {

	/**
	 * Find by account number.
	 *
	 * @param fromAccount the from account
	 * @return the account entity
	 */
	public AccountEntity findByAccountNumber(String fromAccount);

	/**
	 * Find by customer entity id and account type.
	 *
	 * @param id          the id
	 * @param accountType the account type
	 * @return the account entity
	 */
	public AccountEntity findByCustomerEntity_IdAndAccountType(Long id, String accountType);

}
