package com.assignment.bank.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class FundTreansferDTO.
 */
public class FundTreansferDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The from account. */
	private String fromAccount;

	/** The to account. */
	private String toAccount;

	/** The amount. */
	private Double amount;

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
		final FundTreansferDTO other = (FundTreansferDTO) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(fromAccount, other.fromAccount)
				&& Objects.equals(toAccount, other.toAccount);
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Gets the from account.
	 *
	 * @return the from account
	 */
	public String getFromAccount() {
		return fromAccount;
	}

	/**
	 * Gets the to account.
	 *
	 * @return the to account
	 */
	public String getToAccount() {
		return toAccount;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(amount, fromAccount, toAccount);
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Sets the from account.
	 *
	 * @param fromAccount the new from account
	 */
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	/**
	 * Sets the to account.
	 *
	 * @param toAccount the new to account
	 */
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "FundTreansferDTO [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount + "]";
	}
}
