package com.technosmithlabs.springwithdrools.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Response evalStatus(@RequestBody Request requestObject) throws FileNotFoundException {
		final InputStream is = new FileInputStream(new File(
				"/Users/anshulgautam/anshul-workstation/projects/springbootws-with-drools-decisiontable/src/main/resources/drools/rules.xls"));
		SpreadsheetCompiler comp = new SpreadsheetCompiler();
		String drl = comp.compile(false, is, InputType.XLS);
		System.out.println(drl);
		System.out.println(requestObject.getFullName());
		session.insert(requestObject);
		session.setGlobal("response", responseObject);
		session.fireAllRules();
		return responseObject;
	}
}
