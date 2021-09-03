package com.assignment.bank.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class AccountEntity.
 */
@Entity
@Table(name = "Account")
public class AccountEntity {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The account number. */
	@Column(name = "AccountNumber", length = 20, nullable = false, unique = true)
	private String accountNumber;

	/** The branch. */
	@Column(name = "Branch", nullable = false)
	private String branch;

	/** The account type. */
	@Column(name = "AccountType", nullable = false)
	private String accountType;

	/** The balance. */
	@Column(name = "Balance", nullable = false)
	private Double balance;

	/** The created time. */
	@Column(name = "CreatedTime", nullable = false)
	private LocalDateTime createdTime;

	/** The account holder. */
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerEntity customerEntity;

	/**
	 * Instantiates a new account entity.
	 */
	public AccountEntity() {
	}

	/**
	 * Instantiates a new account entity.
	 *
	 * @param accountNumber the account number
	 * @param branch        the branch
	 * @param accountType   the account type
	 * @param balance       the balance
	 * @param createdTime   the created time
	 * @param accountHolder the account holder
	 */
	public AccountEntity(String accountNumber, String branch, String accountType, Double balance,
			LocalDateTime createdTime, CustomerEntity accountHolder) {
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.accountType = accountType;
		this.balance = balance;
		this.createdTime = createdTime;
		customerEntity = accountHolder;
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
		final AccountEntity other = (AccountEntity) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(balance, other.balance) && Objects.equals(branch, other.branch)
				&& Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(customerEntity, other.customerEntity) && Objects.equals(id, other.id);
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
	 * Gets the customer entity.
	 *
	 * @return the customer entity
	 */
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType, balance, branch, createdTime, customerEntity, id);
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
	 * Sets the customer entity.
	 *
	 * @param customerEntity the new customer entity
	 */
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", accountNumber=" + accountNumber + ", branch=" + branch + ", accountType="
				+ accountType + ", balance=" + balance + ", createdTime=" + createdTime + ", customerEntity="
				+ customerEntity + "]";
	}

}
