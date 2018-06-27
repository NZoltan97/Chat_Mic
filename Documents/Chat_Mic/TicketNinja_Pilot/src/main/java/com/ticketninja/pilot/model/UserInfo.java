package com.ticketninja.pilot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="orgName")
	private String orgName;

	@Column(name="orgSettlement")
	private String orgSettlement;

	@Column(name="contName")
	private String contName;

	@Column(name="mail")
	private String mail;

	@Column(name="orgStreet")
	private String orgStreet;

	@Column(name="orgHouseNum")
	private String orgHouseNum;

	@Column(name="orgZipCode")
	private String orgZipCode;
	
	@Column(name="eventName")
	private String eventName;
	
	@Column(name="eventDate")
	private String eventDate;

	@Column(name="checkSum")
	private int checkSum;
	
	@Column(name="isValid")
	private boolean isValid;
	
	@Column(name="comment")
	private String comment;

	public UserInfo() {}

	public UserInfo(String mail, int checkSum) {
		this.mail = mail;
		this.isValid=false;
		this.checkSum=checkSum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public int getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}