package com.ticketninja.pilot.controllers.RequestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketninja.pilot.dtos.AttributeDTO;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> sendOrganizationName(@RequestParam("orgName") String orgName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendOrganisersZipCode(@RequestParam("zipCode") String zipCode,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendOrganisersSettlement(@RequestParam("settlement") String settlement,
			@RequestParam("isCorrect") String isCorrect, @RequestParam("mail") String mail);

	public ResponseEntity<AttributeDTO> sendOrganisersStreet(@RequestParam("street") String street,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendOrganisersHouseNumber(@RequestParam("houseNum") String houseNum,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendContactName(@RequestParam("fullName") String fullName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendContactsComment(@RequestParam("comment") String comment,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> validateCheckSum(@RequestParam("checkSum") String checkSumFromUser,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> validateMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect);

//	public ResponseEntity<AttributeDTO> sendingMimeMail(@RequestParam("mail") String mail,
//			@RequestParam("isCorrect") String isCorrect);
}
