package com.assignment.bank.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.bank.dto.ApiResponseDTO;
import com.assignment.bank.dto.CustomerDTO;
import com.assignment.bank.service.CustomerService;

/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("api")
public class CustomerController {

	/** The customer service. */
	@Autowired
	private CustomerService customerService;

	/**
	 * Creates the customer.
	 *
	 * @param customerDTO the customer DTO
	 * @return the string
	 */
	@PostMapping("save-customer")
	public ResponseEntity<ApiResponseDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
		final ApiResponseDTO response = customerService.saveCustomer(customerDTO);
		if (response.getStatusCode() == 200) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.internalServerError().body(response);
		}
	}

	/**
	 * Delete customer.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("delete-customer")
	public ResponseEntity<ApiResponseDTO> deleteCustomer(@RequestParam(value = "id") Long id) {
		final ApiResponseDTO responseDTO = customerService.deleteUser(id);
		if (responseDTO.getStatusCode() == 404) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
		} else {
			return ResponseEntity.ok(responseDTO);
		}
	}

	/**
	 * Fetch customers.
	 *
	 * @param searchKey the search key
	 * @return the list
	 */
	@GetMapping("get-customers")
	public Set<CustomerDTO> fetchCustomers(@RequestParam(value = "searchKey", required = false) String searchKey) {
		return customerService.fetchCustomers(searchKey);
	}

	/**
	 * Update customer.
	 *
	 * @param id          the id
	 * @param customerDTO the customer DTO
	 * @return the api response DTO
	 */
	@PutMapping("update-customer")
	public ResponseEntity<ApiResponseDTO> updateCustomer(@RequestParam(value = "id") Long id,
			@RequestBody CustomerDTO customerDTO) {
		final ApiResponseDTO response = customerService.updateCustomer(id, customerDTO);
		if (response.getStatusCode() == 200) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.internalServerError().body(response);
		}
	}
}
