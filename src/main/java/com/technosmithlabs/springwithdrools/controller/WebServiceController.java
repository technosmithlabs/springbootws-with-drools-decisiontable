package com.technosmithlabs.springwithdrools.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technosmithlabs.springwithdrools.model.Request;
import com.technosmithlabs.springwithdrools.model.Response;

@RestController
public class WebServiceController {

	@Autowired
	private KieSession session;

	@Autowired
	private Response responseObject;

	@RequestMapping(method = RequestMethod.POST, value = "/status")
	public Response evalStatus(Request requestObject) {
		session.insert(requestObject);
		session.insert(responseObject);
		session.fireAllRules();
		return responseObject;
	}
}
