package com.ticketninja.pilot.controllers.RequestController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketninja.pilot.controllers.RequestController.IRequestController;
import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.ChatFuelDTO;
import com.ticketninja.pilot.dtos.InnerDTO;
import com.ticketninja.pilot.dtos.MailDTO;
import com.ticketninja.pilot.services.EmailService.impl.EmailServiceImpl;
import com.ticketninja.pilot.services.MainService.impl.MainServiceImpl;

@RestController
public class RequestControllerImpl implements IRequestController {
	@Autowired
	MainServiceImpl service;
	@Autowired
	EmailServiceImpl mailService;
	// @Autowired
	// ResourceLoader loader;

	// Get the Organization's name
	@RequestMapping(value = "/sendOrgName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganizationName(@RequestParam("orgName") String orgName,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgName(orgName);
		innerDto.setMail(mail);
		return service.saveOrganizationName(innerDto);
	}

	// Get the Organization's zip code
	@RequestMapping(value = "/sendOrgZip", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersZipCode(@RequestParam("orgZipCode") String orgZipCode,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgZipCode(orgZipCode);
		innerDto.setMail(mail);
		return service.saveOrganisersZipCode(innerDto);
	}

	// Get Organizetion's settlement
	@RequestMapping(value = "/sendOrgSettlement", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersSettlement(@RequestParam("orgSettlement") String orgSettlement,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgSettlement(orgSettlement);
		innerDto.setMail(mail);
		return service.saveOrganisersSettlement(innerDto);
	}

	// Get Organization's street
	@RequestMapping(value = "/sendOrgStreet", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersStreet(@RequestParam("orgStreet") String orgStreet,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgStreet(orgStreet);
		innerDto.setMail(mail);
		return service.saveOrganisersStreet(innerDto);
	}

	// Get Organization's house number
	@RequestMapping(value = "/sendOrgHouseNum", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendOrganisersHouseNumber(@RequestParam("orgHouseNum") String orgHouseNum,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setOrgHouseNum(orgHouseNum);
		innerDto.setMail(mail);
		return service.saveOrganisersHouseNumber(innerDto);
	}

	// Get organizer's full name
	@RequestMapping(value = "/sendContactNameFB", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendContactNameFB(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setContName(firstName + " " + lastName);
		innerDto.setMail(mail);
		return service.saveContactName(innerDto);
	}

	@RequestMapping(value = "/sendContactNameManual", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendContactNameManual(@RequestParam("contName") String contName,
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
	@RequestMapping(value = "/sendEventDate", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendEventDate(@RequestParam("eventDate") String eventDate,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setEventDate(eventDate);
		innerDto.setMail(mail);
		return service.saveEventDate(innerDto);
	}

	// Validate checksum that sent in e-mail
	@RequestMapping(value = "/validateCheckSum", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> validateCheckSum(@RequestParam("checkSum") String checkSumFromUser,
			@RequestParam("mail") String mail, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setCheckSum(checkSumFromUser);
		innerDto.setMail(mail);
		return service.validateCheckSum(innerDto);
	}

	// Send e-mail to user with checksum and store user by its e-mail
	@RequestMapping(value = "/validateMail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> validateMail(@RequestParam("mail") String mail,
			@RequestParam("lang") String lang, @RequestParam("isCorrect") String isCorrect) {
		MailDTO mailDto = new MailDTO(mail);
		// Resource htmlResource =
		// loader.getResource("classpath:static/htmlmailHUN.html");
		// htmlResource = loader.getResource("classpath:static/htmlmailENG.html");
		mailDto.setLang(lang);
		// Resource cssResource =
		// loader.getResource("classpath:static/appearenceMail.css");
		// Resource logoResource =
		// loader.getResource("classpath:static/ninja_logo.png");
		// Resource backgroundResource =
		// loader.getResource("classpath:static/backgroundv5.png");
		// mailDto.addParameter("checkSum", mailDto.setCheckS());
		// mailDto.setBackgroundResource(backgroundResource);
		// mailDto.setHtmlResource(htmlResource);
		// mailDto.setCssResource(cssResource);
		// mailDto.setLogoResource(logoResource);
		// mailDto.setChangeTokenCss("<css>");
		// mailDto.setChangeTokenHtml("<params>");

		return mailService.validateHtmlMailAddress(mailDto);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> deleteUser(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setMail(mail);
		return service.deleteUser(innerDto);
	}

	@RequestMapping(value = "/sendTruncatedDetailsSendGridMail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> truncatedSendGridMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		MailDTO mailDto = new MailDTO(mail);
		return mailService.sendTruncatedDetailsSendGridMail(mailDto);
	}

	@RequestMapping(value = "/sendWholeDetailsSendGridMail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> wholeSendGridMail(@RequestParam("mail") String mail,
			@RequestParam("isCorrect") String isCorrect) {
		MailDTO mailDto = new MailDTO(mail);
		return mailService.sendWholeDetailsSendGridMail(mailDto);
	}

	@RequestMapping(value = "/recieveFeedback", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> recieveFeedback(@RequestParam("mail") String mail,
			@RequestParam("feedback") String feedback, @RequestParam("isCorrect") String isCorrect) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setMail(mail);
		innerDto.setFeedback(feedback);
		return service.saveFeedback(innerDto);
	}

	@RequestMapping(value = "/viewFeedbacks", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> viewFeedbacks() {
		return service.getFeedbacks();
	}
	
	@CrossOrigin(origins="http://chatbot.synapps.hu")
	@RequestMapping(value= "/viewWebhook", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ChatFuelDTO> viewWebhook(@RequestParam("hostName") String hostName) {
		ChatFuelDTO Dto=new ChatFuelDTO();
		Dto.addMessages(hostName);
		return new ResponseEntity<ChatFuelDTO>(Dto, HttpStatus.OK);
	}
	
}
