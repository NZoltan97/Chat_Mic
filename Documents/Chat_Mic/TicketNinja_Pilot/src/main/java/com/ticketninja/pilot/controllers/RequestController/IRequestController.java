package com.ticketninja.pilot.controllers.RequestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketninja.pilot.dtos.AttributeDTO;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> sendOrganizationName(@RequestParam("orgName") String orgName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendOrganisersZipCode(@RequestParam("orgZipCode") String orgZipCode,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendOrganisersSettlement(@RequestParam("orgSettlement") String orgSettlement,
			@RequestParam("isCorrect") String isCorrect, @RequestParam("mail") String mail);

	public ResponseEntity<AttributeDTO> sendOrganisersStreet(@RequestParam("orgStreet") String orgStreet,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendOrganisersHouseNumber(@RequestParam("orgHouseNum") String orgHouseNum,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendContactNameFB(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);
	
	public ResponseEntity<AttributeDTO> sendContactNameManual(@RequestParam("contName") String contName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);
	
	public ResponseEntity<AttributeDTO> sendEventName(@RequestParam("eventName") String eventName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);
	
	public ResponseEntity<AttributeDTO> sendEventDate(@RequestParam("eventDate") String eventDate,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendComment(@RequestParam("comment") String comment,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> validateCheckSum(@RequestParam("checkSum") String checkSumFromUser,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> validateMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect, @RequestParam("lang") String lang);
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> deleteUser(@RequestParam("mail") String mail);
}
