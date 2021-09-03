package com.assignment.bank.service;

import java.util.Set;

import com.assignment.bank.dto.ApiResponseDTO;
import com.assignment.bank.dto.CustomerDTO;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the api response DTO
	 */
	public ApiResponseDTO deleteUser(Long id);

	/**
	 * Fetch customers.
	 *
	 * @param searchKey the search key
	 * @return the list
	 */
	public Set<CustomerDTO> fetchCustomers(String searchKey);

	/**
	 * Save customer.
	 *
	 * @param customerDTO the customer DTO
	 * @return the string
	 */
	public ApiResponseDTO saveCustomer(CustomerDTO customerDTO);

	/**
	 * Update customer.
	 *
	 * @param id          the id
	 * @param customerDTO the customer DTO
	 * @return the api response DTO
	 */
	ApiResponseDTO updateCustomer(Long id, CustomerDTO customerDTO);

}
