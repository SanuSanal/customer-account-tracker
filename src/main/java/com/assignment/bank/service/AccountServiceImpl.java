package com.assignment.bank.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.bank.dto.AccountDTO;
import com.assignment.bank.dto.ApiResponseDTO;
import com.assignment.bank.dto.FundTreansferDTO;
import com.assignment.bank.entities.AccountEntity;
import com.assignment.bank.entities.CustomerEntity;
import com.assignment.bank.repository.AccountRepositoty;
import com.assignment.bank.repository.CustomerRepository;

/**
 * The Class AccountServiceImpl.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	/** The account repositoty. */
	@Autowired
	private AccountRepositoty accountRepositoty;

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Creates the account.
	 *
	 * @param accountDTO the account DTO
	 * @return the string
	 */
	@Override
	public ApiResponseDTO createAccount(AccountDTO accountDTO) {

		final Optional<CustomerEntity> customer = customerRepository.findById(accountDTO.getCustomerID());
		if (!customer.isPresent()) {
			return new ApiResponseDTO(404, "Customer not found");
		}

		final AccountEntity account = accountRepositoty
				.findByCustomerEntity_IdAndAccountType(accountDTO.getCustomerID(), accountDTO.getAccountType());
		if (account != null) {
			return new ApiResponseDTO(500, "This type of account is already present for the customer");
		}

		final CustomerEntity customerEntity = customer.get();

		final Random random = new Random();
		final Long accountNumber = Math.abs(random.nextLong());

		final AccountEntity accountEntity = new AccountEntity(accountNumber.toString(), accountDTO.getBranch(),
				accountDTO.getAccountType(), accountDTO.getBalance(), LocalDateTime.now(), customerEntity);
		accountRepositoty.save(accountEntity);
		return new ApiResponseDTO(200, "Account created. Account Number: " + accountNumber);
	}

	/**
	 * Fetch account.
	 *
	 * @param accntNo the accnt no
	 * @return the account DTO
	 */
	@Override
	public AccountDTO fetchAccount(String accntNo) {
		final AccountEntity accountEntity = accountRepositoty.findByAccountNumber(accntNo);
		if (accountEntity != null) {
			return new AccountDTO(accountEntity.getAccountNumber(), accountEntity.getAccountType(),
					accountEntity.getBranch(), accountEntity.getBalance(), accountEntity.getCreatedTime(),
					accountEntity.getCustomerEntity().getId());
		} else {
			return null;
		}
	}

	/**
	 * Fund transfer.
	 *
	 * @param fundTreansferDTO the fund treansfer DTO
	 * @return the api response DTO
	 */
	@Override
	public ApiResponseDTO fundTransfer(FundTreansferDTO fundTreansferDTO) {
		final AccountEntity fromAccount = accountRepositoty.findByAccountNumber(fundTreansferDTO.getFromAccount());
		final AccountEntity toAccount = accountRepositoty.findByAccountNumber(fundTreansferDTO.getToAccount());
		if (fromAccount == null || toAccount == null) {
			return new ApiResponseDTO(404, "Accounts not found!");
		} else if (fromAccount.getBalance() < fundTreansferDTO.getAmount()) {
			return new ApiResponseDTO(500, "Insufficient funds to transfer.");
		} else {
			fromAccount.setBalance(fromAccount.getBalance() - fundTreansferDTO.getAmount());
			toAccount.setBalance(toAccount.getBalance() + fundTreansferDTO.getAmount());
			accountRepositoty.save(fromAccount);
			accountRepositoty.save(toAccount);
			return new ApiResponseDTO(200, "Fund transfer successful");
		}
	}

}
