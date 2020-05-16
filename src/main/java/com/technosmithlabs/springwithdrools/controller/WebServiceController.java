package com.technosmithlabs.springwithdrools.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technosmithlabs.springwithdrools.model.Request;
import com.technosmithlabs.springwithdrools.model.Response;
import com.technosmithlabs.springwithdrools.util.CommonUtil;

@RestController
public class WebServiceController {

	@Autowired
	private KieSession session;

	@RequestMapping(method = RequestMethod.POST, value = "/status")
	public Response evalStatus(Request requestObject) {
		final Response responseObject = new Response();
		session.insert(requestObject);
		session.setGlobal("response", responseObject);
		session.setGlobal("util", new CommonUtil());
		session.fireAllRules();
		return responseObject;
	}
}
