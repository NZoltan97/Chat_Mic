package com.ticketninja.pilot.controllers.RestClientController.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ticketninja.pilot.controllers.RestClientController.IRestClientController;

@RestController
public class RestClientControllerImpl implements IRestClientController {
	
	private static final Logger LOGGER = Logger.getLogger(RestClientControllerImpl.class.getName());
	
	//In progress: Exception, finally branch, url without static string
			@RequestMapping(value = "/callEndpoint", method = RequestMethod.GET)
			public String getAttributeFromEndpoint() {
				String info=new String();
				try {
				String url = "https://private-anon-5936e19d3b-chattest.apiary-mock.com/hello?email=my@mymail.hu";
				RestTemplate restTemplate=new RestTemplate();
				info = restTemplate.getForObject(url, String.class);
				}catch(RestClientException e) {
					LOGGER.log(Level.ALL, e.getMessage(), e);
				}
				return info ;
			}

	
}
