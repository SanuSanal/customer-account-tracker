package com.assignment.bank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.bank.dto.ApiResponseDTO;
import com.assignment.bank.dto.CustomerDTO;
import com.assignment.bank.entities.CustomerEntity;
import com.assignment.bank.repository.CustomerRepository;

/**
 * The Class CustomerServiceImpl.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the api response DTO
	 */
	@Override
	public ApiResponseDTO deleteUser(Long id) {
		final Optional<CustomerEntity> existing = customerRepository.findById(id);
		if (!existing.isPresent()) {
			return new ApiResponseDTO(404, "No customer exists with id:" + id);
		}
		final CustomerEntity entity = existing.get();
		customerRepository.delete(entity);
		return new ApiResponseDTO(200, "Customer deleted.");
	}

	/**
	 * Fetch customers.
	 *
	 * @param searchKey the search key
	 * @return the list
	 */
	@Override
	public Set<CustomerDTO> fetchCustomers(String searchKey) {
		List<CustomerEntity> customers = null;
		if (searchKey == null || searchKey.trim().isEmpty()) {
			customers = customerRepository.findAll();
		} else {
			customers = customerRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(searchKey,
					searchKey);
		}
		return customers.stream()
				.map(entity -> new CustomerDTO(entity.getId(), entity.getFirstName(), entity.getLastName(),
						entity.getDob(), entity.getEmailId(), entity.getMobileNumber(), entity.getAddress(),
						entity.getCreatedTime(), entity.getAccountEntities()))
				.collect(Collectors.toSet());
	}

	/**
	 * Save customer.
	 *
	 * @param customerDTO the customer DTO
	 * @return the string
	 */
	@Override
	public ApiResponseDTO saveCustomer(CustomerDTO customerDTO) {
		final CustomerEntity existingCustomer = customerRepository
				.findByMobileNumberOrEmailId(customerDTO.getMobileNumber(), customerDTO.getEmailId());
		if (existingCustomer != null) {
			return new ApiResponseDTO(409, "Customer with same mobile number or email id already exists!");
		}
		final CustomerEntity newCustomer = new CustomerEntity(customerDTO.getFirstName(), customerDTO.getLastName(),
				customerDTO.getDob(), customerDTO.getMobileNumber(), customerDTO.getEmailId(), customerDTO.getAddress(),
				LocalDateTime.now());
		final CustomerEntity savedCustomer = customerRepository.save(newCustomer);
		return new ApiResponseDTO(200, "new customer created with ID: " + savedCustomer.getId());
	}

	/**
	 * Update customer.
	 *
	 * @param id  the id
	 * @param dto the customer DTO
	 * @return the api response DTO
	 */
	@Override
	public ApiResponseDTO updateCustomer(Long id, CustomerDTO dto) {
		final Optional<CustomerEntity> existing = customerRepository.findById(id);
		if (!existing.isPresent()) {
			return new ApiResponseDTO(404, "No customer exists with id:" + id);
		}
		final CustomerEntity existingCustomer = customerRepository.findByMobileNumberOrEmailId(dto.getMobileNumber(),
				dto.getEmailId());
		if (existingCustomer != null && existingCustomer.getId() != id) {
			return new ApiResponseDTO(409, "Customer with same mobile number or email id already exists!");
		}
		final CustomerEntity entity = existing.get();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setDob(dto.getDob());
		entity.setMobileNumber(dto.getMobileNumber());
		entity.setEmailId(dto.getEmailId());
		entity.setAddress(dto.getAddress());
		customerRepository.save(entity);
		return new ApiResponseDTO(200, "Customer details updated");
	}

}
