package com.assignment.bank.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class CustomerEntity.
 */
@Entity
@Table(name = "Customer")
public class CustomerEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The first name. */
	@Column(name = "FirstName", length = 60, nullable = false)
	private String firstName;

	/** The last name. */
	@Column(name = "LastName", length = 60, nullable = false)
	private String lastName;

	/** The dob. */
	@Column(name = "DOB", nullable = false)
	private LocalDate dob;

	/** The mobile number. */
	@Column(name = "MobileNumber", length = 10, nullable = false, unique = true)
	private Long mobileNumber;

	/** The email id. */
	@Column(name = "Email", length = 100, nullable = false, unique = true)
	private String emailId;

	/** The address. */
	@Column(name = "Address", length = 255)
	private String address;

	/** The created time. */
	@Column(name = "CreatedTime", nullable = false)
	private LocalDateTime createdTime;

	/** The accounts. */
	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
	private List<AccountEntity> accountEntities = new ArrayList<>();

	/**
	 * Instantiates a new customer entity.
	 */
	public CustomerEntity() {
	}

	/**
	 * Instantiates a new customer entity.
	 *
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param dob          the dob
	 * @param mobileNumber the mobile number
	 * @param emailId      the email id
	 * @param address      the address
	 * @param createdTime  the created time
	 */
	public CustomerEntity(String firstName, String lastName, LocalDate dob, Long mobileNumber, String emailId,
			String address, LocalDateTime createdTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
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
		final CustomerEntity other = (CustomerEntity) obj;
		return Objects.equals(accountEntities, other.accountEntities) && Objects.equals(address, other.address)
				&& Objects.equals(createdTime, other.createdTime) && Objects.equals(dob, other.dob)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mobileNumber, other.mobileNumber);
	}

	/**
	 * Gets the account entities.
	 *
	 * @return the account entities
	 */
	public List<AccountEntity> getAccountEntities() {
		return accountEntities;
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
		return Objects.hash(accountEntities, address, createdTime, dob, emailId, firstName, id, lastName, mobileNumber);
	}

	/**
	 * Sets the account entities.
	 *
	 * @param accountEntities the new account entities
	 */
	public void setAccountEntities(List<AccountEntity> accountEntities) {
		this.accountEntities = accountEntities;
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
		return "CustomerEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address + ", createdTime="
				+ createdTime + "]";
	}

}
