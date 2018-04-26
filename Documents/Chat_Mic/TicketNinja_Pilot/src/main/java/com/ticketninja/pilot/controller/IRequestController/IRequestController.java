package com.ticketninja.pilot.controller.IRequestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketninja.pilot.dto.AttributeDTO;
import com.ticketninja.pilot.dto.ChatFuelDTO;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> giveWholeInfo(@RequestParam("organizationName") String organizationName,
			@RequestParam("settlement") String settlement, @RequestParam("contName") String contName,
			@RequestParam("mail") String mail, @RequestParam("street") String street,
			@RequestParam("houseNumber") String houseNumber, @RequestParam("zipCode") String zipCode, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> giveOrganizationName(@RequestParam("orgName") String orgName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> giveOrganisersZipCode(@RequestParam("zipCode") String zipCode,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(@RequestParam("settlement") String settlement,
			@RequestParam("isCorrect") String isCorrect, @RequestParam("mail") String mail);

	public ResponseEntity<AttributeDTO> giveOrganisersStreet(@RequestParam("street") String street,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(@RequestParam("houseNum") String houseNum,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> getContactName(@RequestParam("fullName") String fullName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> giveContactsComment(@RequestParam("comment") String comment,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> validateCheckSum(@RequestParam("checkSum") String checkSumFromUser,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendingMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect);

	public ResponseEntity<AttributeDTO> sendingMimeMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect);
}
