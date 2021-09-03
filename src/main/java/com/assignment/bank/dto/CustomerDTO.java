package com.assignment.bank.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class CustomerDTO.
 */
public class CustomerDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The dob. */
	private LocalDate dob;

	/** The email id. */
	private String emailId;

	/** The mobile number. */
	private Long mobileNumber;

	/** The address. */
	private String address;

	/** The created time. */
	private LocalDateTime createdTime;

	/**
	 * Instantiates a new customer DTO.
	 */
	public CustomerDTO() {
	}

	/**
	 * Instantiates a new customer DTO.
	 *
	 * @param id           the id
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param dob          the dob
	 * @param emailId      the email id
	 * @param mobileNumber the mobile number
	 * @param address      the address
	 * @param createdTime  the created time
	 */
	public CustomerDTO(Long id, String firstName, String lastName, LocalDate dob, String emailId, Long mobileNumber,
			String address, LocalDateTime createdTime) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.createdTime = createdTime;
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
		final CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(dob, other.dob) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(mobileNumber, other.mobileNumber);
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
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
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
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
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the mobile number.
	 *
	 * @return the mobile number
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(address, createdTime, dob, emailId, firstName, id, lastName, mobileNumber);
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the mobile number.
	 *
	 * @param mobileNumber the new mobile number
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", address=" + address + ", createdTime="
				+ createdTime + "]";
	}

}
