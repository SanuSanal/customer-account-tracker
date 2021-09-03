package com.assignment.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.bank.entities.CustomerEntity;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	/**
	 * Find by first name containing ignore case or last name containing ignore
	 * case.
	 *
	 * @param searchKey  the search key
	 * @param searchKey2 the search key 2
	 * @return the list
	 */
	public List<CustomerEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String searchKey,
			String searchKey2);

	/**
	 * Find by mobile number.
	 *
	 * @param mobileNumber the mobile number
	 * @param email        the email
	 * @return the customer entity
	 */
	public CustomerEntity findByMobileNumberOrEmailId(Long mobileNumber, String email);

}
