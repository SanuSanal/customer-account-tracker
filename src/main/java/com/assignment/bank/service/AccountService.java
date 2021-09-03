package com.assignment.bank.service;

import com.assignment.bank.dto.AccountDTO;
import com.assignment.bank.dto.ApiResponseDTO;
import com.assignment.bank.dto.FundTreansferDTO;

/**
 * The Interface AccountService.
 */
public interface AccountService {

	/**
	 * Creates the account.
	 *
	 * @param accountDTO the account DTO
	 * @return the string
	 */
	public ApiResponseDTO createAccount(AccountDTO accountDTO);

	/**
	 * Fetch account.
	 *
	 * @param accntNo the accnt no
	 * @return the account DTO
	 */
	public AccountDTO fetchAccount(String accntNo);

	/**
	 * Fund transfer.
	 *
	 * @param fundTreansferDTO the fund treansfer DTO
	 * @return the api response DTO
	 */
	public ApiResponseDTO fundTransfer(FundTreansferDTO fundTreansferDTO);

}
