package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private TestService testService;
	
	
	
	public TestController(TestService testService) {
		super();
		this.testService = testService;
		// TODO Auto-generated constructor stub
	}



	@RequestMapping("/test/string")
	public String getTestString(){
		return testService.getString();
	}
}
