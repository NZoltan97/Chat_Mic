package com.ticketninja.pilot.services.MainService;

import org.springframework.http.ResponseEntity;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.InnerDTO;
import com.ticketninja.pilot.dtos.MailValidationDTO;

public interface IMainService {
	//Service methods
	public ResponseEntity<AttributeDTO> saveWholeInfo(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveOrganizationName(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveOrganisersZipCode(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveOrganisersSettlement(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveOrganisersStreet(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveOrganisersHouseNumber(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveContactName(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> saveContactsComment(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> validateCheckSum(InnerDTO innerDto);
	public ResponseEntity<AttributeDTO> validateMailAddress(MailValidationDTO mailDto);
//	public ResponseEntity<AttributeDTO> sendingMimeMail(String mail, String isCorrect);
}
