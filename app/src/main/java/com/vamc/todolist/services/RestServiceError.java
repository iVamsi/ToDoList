package com.vamc.todolist.services;

import org.json.JSONException;
import org.json.JSONObject;

// This class should be modified as your server's error response
public class RestServiceError {

	public Integer errorCode;
	public String extendedMessage;
	public String message;
	public String moreInfo;
	public Integer status;

	public RestServiceError() {
	}

	public RestServiceError(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getExtendedMessage() {
		return extendedMessage;
	}

	public void setExtendedMessage(String extendedMessage) {
		this.extendedMessage = extendedMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toJSON() {

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("errorCode", errorCode);
			jsonObject.put("extendedMessage", extendedMessage);
			jsonObject.put("message", message);
			jsonObject.put("moreInfo", moreInfo);
			jsonObject.put("status", status);

			return jsonObject.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}
	}
}
