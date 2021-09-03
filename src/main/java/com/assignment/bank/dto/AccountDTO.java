package com.assignment.bank.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class AccountDTO.
 */
public class AccountDTO {

	/** The account number. */
	private String accountNumber;

	/** The account type. */
	private String accountType;

	/** The branch. */
	private String branch;

	/** The balance. */
	private Double balance;

	/** The created time. */
	private LocalDateTime createdTime;

	/** The account holder. */
	private Long customerID;

	/**
	 * Instantiates a new account DTO.
	 */
	public AccountDTO() {
	}

	/**
	 * Instantiates a new account DTO.
	 *
	 * @param accountNumber the account number
	 * @param accountType   the account type
	 * @param branch        the branch
	 * @param balance       the balance
	 * @param createdTime   the created time
	 */
	public AccountDTO(String accountNumber, String accountType, String branch, Double balance,
			LocalDateTime createdTime) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branch = branch;
		this.balance = balance;
		this.createdTime = createdTime;
	}

	/**
	 * Instantiates a new account DTO.
	 *
	 * @param accountNumber the account number
	 * @param accountType   the account type
	 * @param branch        the branch
	 * @param balance       the balance
	 * @param createdTime   the created time
	 * @param customerID    the customer ID
	 */
	public AccountDTO(String accountNumber, String accountType, String branch, Double balance,
			LocalDateTime createdTime, Long customerID) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branch = branch;
		this.balance = balance;
		this.createdTime = createdTime;
		this.customerID = customerID;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AccountDTO other = (AccountDTO) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(balance, other.balance) && Objects.equals(branch, other.branch)
				&& Objects.equals(createdTime, other.createdTime) && Objects.equals(customerID, other.customerID);
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Gets the account type.
	 *
	 * @return the account type
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * Gets the branch.
	 *
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * Gets the created time.
	 *
	 * @return the created time
	 */
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	/**
	 * Gets the customer ID.
	 *
	 * @return the customer ID
	 */
	public Long getCustomerID() {
		return customerID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType, balance, branch, createdTime, customerID);
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Sets the account type.
	 *
	 * @param accountType the new account type
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * Sets the branch.
	 *
	 * @param branch the new branch
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * Sets the created time.
	 *
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * Sets the customer ID.
	 *
	 * @param customerID the new customer ID
	 */
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AccountDTO [accountNumber=" + accountNumber + ", accountType=" + accountType + ", branch=" + branch
				+ ", balance=" + balance + ", createdTime=" + createdTime + ", customerID=" + customerID + "]";
	}

}
