package com.vamc.todolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("applicant_id")
	@Expose
	private Integer applicantId;
	@SerializedName("applicant_Name")
	@Expose
	private String applicantName;
	@SerializedName("email_mail")
	@Expose
	private String emailMail;
	@SerializedName("password")
	@Expose
	private String password;
	@SerializedName("valid_user")
	@Expose
	private String validUser;

	/**
	 * 
	 * @return The applicantId
	 */
	public Integer getApplicantId() {
		return applicantId;
	}

	/**
	 * 
	 * @param applicantId
	 *            The applicant_id
	 */
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	/**
	 * 
	 * @return The applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * 
	 * @param applicantName
	 *            The applicant_Name
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * 
	 * @return The emailMail
	 */
	public String getEmailMail() {
		return emailMail;
	}

	/**
	 * 
	 * @param emailMail
	 *            The email_mail
	 */
	public void setEmailMail(String emailMail) {
		this.emailMail = emailMail;
	}

	/**
	 * 
	 * @return The password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            The password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return The validUser
	 */
	public String getValidUser() {
		return validUser;
	}

	/**
	 * 
	 * @param validUser
	 *            The valid_user
	 */
	public void setValidUser(String validUser) {
		this.validUser = validUser;
	}

}