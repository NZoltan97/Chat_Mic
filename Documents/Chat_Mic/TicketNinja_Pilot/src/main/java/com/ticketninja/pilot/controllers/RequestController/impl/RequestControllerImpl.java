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
	public ResponseEntity<AttributeDTO> sendOrganisersSettlement(@RequestParam("settlement") String settlement, @RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
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
	public ResponseEntity<AttributeDTO> sendContactName(@RequestParam("contName") String contName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setContName(contName);
		innerDto.setMail(mail);
		return service.saveContactName(innerDto);
	}

	// Get additional comment from contact
	@RequestMapping(value = "/sendComment", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendComment(@RequestParam("comment") String comment,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setComment(comment);
		innerDto.setMail(mail);
		return service.saveContactsComment(innerDto);
	}
	
	// Get the event's name
	@RequestMapping(value = "/sendEventName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendEventName(@RequestParam("eventName") String eventName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setEventName(eventName);
		innerDto.setMail(mail);
		return service.saveEventName(innerDto);
	}
	
	// Get the event's starting date
		@RequestMapping(value = "/sendDate", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<AttributeDTO> sendDate(@RequestParam("date") String date,
				@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
			InnerDTO innerDto = new InnerDTO();
			innerDto.setDate(date);
			innerDto.setMail(mail);
			return service.saveDate(innerDto);
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
	public ResponseEntity<AttributeDTO> validateMail(@RequestParam("mail") String mail,  @RequestParam("lang") String lang,
			@RequestParam("isCorrect") String isCorrect) {
		MailValidationDTO mailDto=new MailValidationDTO(mail, "Email verifikáció");
		Resource htmlResource=loader.getResource("classpath:static/htmlmailHUN.html");
		if(lang.compareTo("eng")==0) {
			mailDto=new MailValidationDTO(mail, "Email verification");
			htmlResource=loader.getResource("classpath:static/htmlmailENG.html");
		}
			Resource cssResource=loader.getResource("classpath:static/appearence.css");
			Resource logoResource=loader.getResource("classpath:static/ninja_logo.png");
			Resource backgroundResource=loader.getResource("classpath:static/backgroundv5.png");
			mailDto.addParameter("checkSum", mailDto.setCheckS());
			mailDto.setBackgroundResource(backgroundResource);
			mailDto.setHtmlResource(htmlResource);
			mailDto.setCssResource(cssResource);
			mailDto.setLogoResource(logoResource);
			mailDto.setChangeTokenCss("<css>");
			mailDto.setChangeTokenHtml("<params>");
		
		return mailService.validateHtmlMailAddress(mailDto);
	}

}
