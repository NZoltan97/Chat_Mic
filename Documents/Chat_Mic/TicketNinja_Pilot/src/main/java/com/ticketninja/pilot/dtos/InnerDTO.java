package com.ticketninja.pilot.dtos;

public class InnerDTO {

	private String orgName;

	private String orgSettlement;

	private String contName;

	private String mail;

	private String orgStreet;

	private String orgHouseNum;

	private String orgZipCode;

	private String eventName;

	private String eventDate;

	private String checkSum;

	private boolean isValid;

	private String comment;

	private String lang;

	private String feedback;

	public InnerDTO() {
	};

	public InnerDTO(String mail) {
		this.mail = mail;
		this.isValid = false;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgSettlement() {
		return orgSettlement;
	}

	public void setOrgSettlement(String orgSettlement) {
		this.orgSettlement = orgSettlement;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getOrgStreet() {
		return orgStreet;
	}

	public void setOrgStreet(String orgStreet) {
		this.orgStreet = orgStreet;
	}

	public String getOrgHouseNum() {
		return orgHouseNum;
	}

	public void setOrgHouseNum(String orgHouseNum) {
		this.orgHouseNum = orgHouseNum;
	}

	public String getOrgZipCode() {
		return orgZipCode;
	}

	public void setOrgZipCode(String orgZipCode) {
		this.orgZipCode = orgZipCode;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventDate() {
		return eventDate;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
