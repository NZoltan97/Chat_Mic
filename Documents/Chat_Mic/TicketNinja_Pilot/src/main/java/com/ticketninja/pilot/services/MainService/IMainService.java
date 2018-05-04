package com.ticketninja.pilot.services.MainService;

import org.springframework.http.ResponseEntity;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.InnerDTO;
import com.ticketninja.pilot.dtos.MailValidationDTO;

public interface IMainService {
	//Service methods
	public ResponseEntity<AttributeDTO> giveWholeInfo(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveOrganizationName(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveOrganisersZipCode(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveOrganisersStreet(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveContactName(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> giveContactsComment(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> validateCheckSum(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> validateMailAddress(MailValidationDTO mailDto);
//	public ResponseEntity<AttributeDTO> sendingMimeMail(String mail, String isCorrect);
}
