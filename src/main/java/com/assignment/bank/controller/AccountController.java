package com.assignment.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.bank.dto.AccountDTO;
import com.assignment.bank.dto.ApiResponseDTO;
import com.assignment.bank.dto.FundTreansferDTO;
import com.assignment.bank.service.AccountService;

/**
 * The Class AccountController.
 */
@RestController
@RequestMapping("api")
public class AccountController {

	/** The account service. */
	@Autowired
	private AccountService accountService;

	/**
	 * Creates the account.
	 *
	 * @param accountDTO the account DTO
	 * @return the api response DTO
	 */
	@PostMapping("create-account")
	public ResponseEntity<ApiResponseDTO> createAccount(@RequestBody AccountDTO accountDTO) {
		if (accountDTO.getAccountType() == null
				|| (!"SAVINGS".equals(accountDTO.getAccountType()) && !"CURRENT".equals(accountDTO.getAccountType()))) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO(400, "Invalid account type.!"));
		}
		final ApiResponseDTO responseDTO = accountService.createAccount(accountDTO);
		if (responseDTO.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDTO);
		} else {
			return ResponseEntity.internalServerError().body(responseDTO);
		}
	}

	/**
	 * Fetch account.
	 *
	 * @param accntNo the accnt no
	 * @return the account DTO
	 */
	@GetMapping("fetch-account")
	public AccountDTO fetchAccount(@RequestParam("accntNo") String accntNo) {
		return accountService.fetchAccount(accntNo);
	}

	/**
	 * Fund transfer.
	 *
	 * @param fundTreansferDTO the fund treansfer DTO
	 * @return the response entity
	 */
	@PostMapping("fund-transfer")
	public ResponseEntity<ApiResponseDTO> fundTransfer(@RequestBody FundTreansferDTO fundTreansferDTO) {
		final ApiResponseDTO responseDTO = accountService.fundTransfer(fundTreansferDTO);
		if (responseDTO.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDTO);
		} else {
			return ResponseEntity.internalServerError().body(responseDTO);
		}
	}

}
