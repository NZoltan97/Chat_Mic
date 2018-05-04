package com.ticketninja.pilot.services.IMainService;

import org.springframework.http.ResponseEntity;

import com.ticketninja.pilot.dtos.AttributeDTO;

public interface IMainService {
	//Service methods
	public ResponseEntity<AttributeDTO> giveWholeInfo(String organizationName, String settlement, String contName,
			String mail, String street, String houseNumber, String zipCode);
	public ResponseEntity<AttributeDTO> giveOrganizationName(String orgName, String mail);
	public ResponseEntity<AttributeDTO> giveOrganisersZipCode(String zipCode, String mail);
	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(String settlement, String mail);
	public ResponseEntity<AttributeDTO> giveOrganisersStreet(String street, String mail);
	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(String houseNum, String mail);
	public ResponseEntity<AttributeDTO> giveContactName(String fullName, String mail);
	public ResponseEntity<AttributeDTO> giveContactsComment(String mail, String comment);
	public ResponseEntity<AttributeDTO> validateCheckSum(String mail, String checkSumFromUser);
	public ResponseEntity<AttributeDTO> validateMailAddress(String mail);
//	public ResponseEntity<AttributeDTO> sendingMimeMail(String mail, String isCorrect);
}
