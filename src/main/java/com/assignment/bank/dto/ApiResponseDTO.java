package com.assignment.bank.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class ApiResponseDTO.
 */
public class ApiResponseDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status code. */
	private Integer statusCode;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new api response DTO.
	 */
	public ApiResponseDTO() {
	}

	/**
	 * Instantiates a new api response DTO.
	 *
	 * @param statusCode the status code
	 * @param message the message
	 */
	public ApiResponseDTO(Integer statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
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
		final ApiResponseDTO other = (ApiResponseDTO) obj;
		return Objects.equals(message, other.message) && Objects.equals(statusCode, other.statusCode);
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(message, statusCode);
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ApiResponseDTO [statusCode=" + statusCode + ", message=" + message + "]";
	}
}
