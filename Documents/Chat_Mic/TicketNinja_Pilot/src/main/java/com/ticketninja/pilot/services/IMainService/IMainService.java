package com.ticketninja.pilot.services.IMainService;

import org.springframework.http.ResponseEntity;

import com.ticketninja.pilot.dto.AttributeDTO;

public interface IMainService {
	//Service methods
	public ResponseEntity<AttributeDTO> giveWholeInfo(String organizationName, String settlement, String contName,
			String mail, String street, String houseNumber, String zipCode, String isCorrect);
	public ResponseEntity<AttributeDTO> giveOrganizationName(String orgName, String mail,String isCorrect);
	//public ResponseEntity<AttributeDTO> giveOrganisersZipCode();
	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(String settlement, String mail, String isCorrect);
	public ResponseEntity<AttributeDTO> giveOrganisersStreet(String street, String mail, String isCorrect);
	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(String houseNum, String mail, String isCorrect);
	public ResponseEntity<AttributeDTO> giveContactName(String fullName, String mail, String isCorrect);
	public ResponseEntity<AttributeDTO> giveContactsComment(String mail, String comment, String isCorrect);
	public ResponseEntity<AttributeDTO> validateCheckSum(String mail, String checkSumFromUser, String isCorrect);
	public ResponseEntity<AttributeDTO> sendingMail(String mail, String isCorrect);
	public ResponseEntity<AttributeDTO> sendingMimeMail(String mail, String isCorrect);
}
