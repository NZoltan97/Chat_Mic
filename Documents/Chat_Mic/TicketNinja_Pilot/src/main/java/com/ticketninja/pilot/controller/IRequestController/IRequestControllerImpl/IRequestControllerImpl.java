package com.ticketninja.pilot.controller.IRequestController.IRequestControllerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketninja.pilot.controller.IRequestController.IRequestController;
import com.ticketninja.pilot.dto.AttributeDTO;
import com.ticketninja.pilot.services.IMainService.IMainServiceImpl.IMainServiceImpl;

@RestController
public class IRequestControllerImpl implements IRequestController {
	@Autowired
	IMainServiceImpl service;

	// GET request handler
	@RequestMapping(value = "/giveUserInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveWholeInfo(@RequestParam("organizationName") String organizationName,
			@RequestParam("settlement") String settlement, @RequestParam("contName") String contName,
			@RequestParam("mail") String mail, @RequestParam("street") String street,
			@RequestParam("houseNumber") String houseNumber, @RequestParam("zipCode") String zipCode,
			@RequestParam("isCorrect") String isCorrect) {
		return service.giveWholeInfo(organizationName, settlement, contName, mail, street, houseNumber, zipCode,
				isCorrect);
	}

	// Get organization name
	@RequestMapping(value = "/giveOrgName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveOrganizationName(@RequestParam("orgName") String orgName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.giveOrganizationName(orgName, mail, isCorrect);
	}

	// Get organizer's zip code
	@RequestMapping(value = "/giveOrgZip", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveOrganisersZipCode(@RequestParam("zipCode") String zipCode,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.giveOrganisersZipCode(zipCode, mail, isCorrect);
	}

	// Get organizer's settlement
	@RequestMapping(value = "/giveSettlement", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(@RequestParam("settlement") String settlement,
			@RequestParam("isCorrect") String isCorrect, @RequestParam("mail") String mail) {
		return service.giveOrganisersSettlement(settlement, mail, isCorrect);
	}

	// Get organizer's street
	@RequestMapping(value = "/giveStreet", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveOrganisersStreet(@RequestParam("street") String street,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.giveOrganisersStreet(street, mail, isCorrect);
	}

	// Get organizer's house number
	@RequestMapping(value = "/giveHouseNum", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(@RequestParam("houseNum") String houseNum,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.giveOrganisersHouseNumber(houseNum, mail, isCorrect);
	}

	// Get organizer's fullname
	@RequestMapping(value = "/giveContactName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> getContactName(@RequestParam("fullName") String fullName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.giveContactName(fullName, mail, isCorrect);
	}

	// Get additional comment from contact
	@RequestMapping(value = "/giveGetContactComment", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> giveContactsComment(@RequestParam("comment") String comment,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.giveContactsComment(comment, mail, isCorrect);
	}

	// Validate checksum that sent in e-mail
	@RequestMapping(value = "/validateCheckSum", method = RequestMethod.GET)
	public ResponseEntity<AttributeDTO> validateCheckSum(@RequestParam("checkSum") String checkSumFromUser,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		return service.validateCheckSum(checkSumFromUser, mail, isCorrect);
	}

	// Send e-mail to user with checksum and store user by its e-mail
	@RequestMapping(value = "/giveMail", method = RequestMethod.GET)
	public ResponseEntity<AttributeDTO> sendingMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		return service.sendingMail(mail, isCorrect);
	}

	// Send HTML e-mail to user with checksum and store user by its e-mail
	@RequestMapping(value = "/giveGetMimeMail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendingMimeMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		return service.sendingMimeMail(mail, isCorrect);
	}

}
