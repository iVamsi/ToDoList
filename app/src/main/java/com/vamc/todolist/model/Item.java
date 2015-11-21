package com.vamc.todolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

	@SerializedName("Item_id")
	@Expose
	private Integer ItemId;
	
	@SerializedName("applicant_id")
	@Expose
	private Integer applicantId;
	
//	@SerializedName("User_id")
//	@Expose
//	private Integer UserId;
	@SerializedName("Title")
	@Expose
	private String Title;
	@SerializedName("Description")
	@Expose
	private String Description;
	@SerializedName("date")
	@Expose
	private Integer date;
	
	public Integer getApplicantId() {
		return applicantId;
	}
	
	public void setApplicantId(Integer appId) {
		applicantId = appId;
	}

	/**
	 * 
	 * @return The ItemId
	 */
	public Integer getItemId() {
		return ItemId;
	}

	/**
	 * 
	 * @param ItemId
	 *            The Item_id
	 */
	public void setItemId(Integer ItemId) {
		this.ItemId = ItemId;
	}

//	/**
//	 * 
//	 * @return The UserId
//	 */
//	public Integer getUserId() {
//		return UserId;
//	}
//
//	/**
//	 * 
//	 * @param UserId
//	 *            The User_id
//	 */
//	public void setUserId(Integer UserId) {
//		this.UserId = UserId;
//	}

	/**
	 * 
	 * @return The Title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * 
	 * @param Title
	 *            The Title
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}

	/**
	 * 
	 * @return The Description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * 
	 * @param Description
	 *            The Description
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * 
	 * @return The date
	 */
	public Integer getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 *            The date
	 */
	public void setDate(Integer date) {
		this.date = date;
	}

}
