package com.ticketninja.pilot.controllers.RequestController.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketninja.pilot.controllers.RequestController.IRequestController;
import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.InnerDTO;
import com.ticketninja.pilot.dtos.MailValidationDTO;
import com.ticketninja.pilot.services.EmailService.impl.EmailServiceImpl;
import com.ticketninja.pilot.services.MainService.impl.MainServiceImpl;

@RestController
public class RequestControllerImpl implements IRequestController {
	@Autowired
	MainServiceImpl service;
	@Autowired
	EmailServiceImpl mailService;
	@Autowired
	ResourceLoader loader;
	
	@RequestMapping(value = "/testHtmlMail", method = RequestMethod.GET)
	public String testHtmlMail() {
		MailValidationDTO mailDto=new MailValidationDTO("Nardelotti97@gmail.com", "Email verifikáció", "checkSum");
		Resource resource=loader.getResource("classpath:static/htmlmail.html");
		mailDto.setResource(resource);
		mailDto.setChangeToken("$");
		mailService.sendHtmlMail(mailDto);
		return "We sent you a mail.";
	}

	// Get organization name
	@RequestMapping(value = "/sendOrgName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganizationName(@RequestParam("orgName") String orgName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgName(orgName);
		innerDto.setMail(mail);
		return service.saveOrganizationName(innerDto);
	}

	// Get organizer's zip code
	@RequestMapping(value = "/sendOrgZip", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersZipCode(@RequestParam("zipCode") String zipCode,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setZipCode(zipCode);
		innerDto.setMail(mail);
		return service.saveOrganisersZipCode(innerDto);
	}

	// Get organizer's settlement
	@RequestMapping(value = "/sendSettlement", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersSettlement(@RequestParam("settlement") String settlement,
			@RequestParam("isCorrect") String isCorrect, @RequestParam("mail") String mail) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgSettlement(settlement);
		innerDto.setMail(mail);
		return service.saveOrganisersSettlement(innerDto);
	}

	// Get organizer's street
	@RequestMapping(value = "/sendStreet", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersStreet(@RequestParam("street") String street,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgStreet(street);
		innerDto.setMail(mail);
		return service.saveOrganisersStreet(innerDto);
	}

	// Get organizer's house number
	@RequestMapping(value = "/sendHouseNum", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersHouseNumber(@RequestParam("houseNum") String houseNum,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setHouseNum(houseNum);
		innerDto.setMail(mail);
		return service.saveOrganisersHouseNumber(innerDto);
	}

	// Get organizer's fullname
	@RequestMapping(value = "/sendContactName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendContactName(@RequestParam("fullName") String contName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setContName(contName);
		innerDto.setMail(mail);
		return service.saveContactName(innerDto);
	}

	// Get additional comment from contact
	@RequestMapping(value = "/sendGetContactComment", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendContactsComment(@RequestParam("comment") String comment,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setComment(comment);
		innerDto.setMail(mail);
		return service.saveContactsComment(innerDto);
	}

	// Validate checksum that sent in e-mail
	@RequestMapping(value = "/validateCheckSum", method = RequestMethod.GET)
	public ResponseEntity<AttributeDTO> validateCheckSum(@RequestParam("checkSum") String checkSumFromUser,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setCheckSum(checkSumFromUser);
		innerDto.setMail(mail);
		return service.validateCheckSum(innerDto);
	}

	// Send e-mail to user with checksum and store user by its e-mail
	@RequestMapping(value = "/validateMail", method = RequestMethod.GET)
	public ResponseEntity<AttributeDTO> validateMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		MailValidationDTO mailDto = new MailValidationDTO(mail, "Email verifikáció", "checkSum");
		return mailService.validateMailAddress(mailDto);
	}

	// Send HTML e-mail to user with checksum and store user by its e-mail
	// @RequestMapping(value = "/giveGetMimeMail", method = RequestMethod.GET,
	// produces = "application/json")
	// public ResponseEntity<AttributeDTO> sendingMimeMail(@RequestParam("mail")
	// String mail,
	// @RequestParam("isCorrect") String isCorrect) {
	// return service.sendingMimeMail(mail);
	// }

}
