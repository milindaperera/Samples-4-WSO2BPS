package org.wso2.bps.sample;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.fasterxml.jackson.databind.JsonNode;

public class processJsonVariable implements JavaDelegate {

	@Override
	public void execute(DelegateExecution exec) throws Exception {
		System.out.println("Java Service Task Execution");
		
		//When we set native JS json variable within script task, we get it as JsonNode object
		Object jsonJSVariable = exec.getVariable("jsonJSVar");
		
		System.out.println("jsonJSVariable type : " +jsonJSVariable.getClass());
		
		if (jsonJSVariable instanceof JsonNode) {
			JsonNode jObject = (JsonNode)jsonJSVariable;
			String fullname = jObject.get("firstName").asText() + " " + jObject.get("lastName").asText();
			System.out.println("Full Name : " + fullname);
		} else {
			System.out.println("Json Variable creation failed");
		}
	}

}
