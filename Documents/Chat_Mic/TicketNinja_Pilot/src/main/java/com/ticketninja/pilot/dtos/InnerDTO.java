package com.ticketninja.pilot.dtos;


public class InnerDTO {
	
	private String orgName;

	private String orgSettlement;

	private String contName;

	private String mail;

	private String orgStreet;

	private String houseNum;

	private String zipCode;

	private int checkS;
	
	private boolean isValid;
	
	private String comment;
	

	public InnerDTO() {};
	
	public InnerDTO(String mail) {
		this.mail = mail;
		this.isValid=false;
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

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getCheckS() {
		return checkS;
	}

	public void setCheckS(int checkS) {
		this.checkS = checkS;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
		
}
