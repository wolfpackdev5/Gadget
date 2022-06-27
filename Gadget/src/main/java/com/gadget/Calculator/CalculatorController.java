package com.gadget.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
	//disable the functions after one is pressed in the front end
	//just need to add logging
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/calculate/{display}")
	public ResponseEntity<Double> calculate(@PathVariable String display) {
		System.out.println(display);
		double result = 0;
		String[] farr = display.split(" ");
		double x = Double.parseDouble(farr[0]);
		String method = farr[1];
		double y = Double.parseDouble(farr[2]);
		
		if(method.contains("%")) {
			result = x % y;
		}
		if(method.contains("/")) {
			result = x / y;
		}
		if(method.contains("*")) {
			result = x * y;
		}
		if(method.contains("+")) {
			result = x + y;
		}
		if(method.contains("-")) {
			result = x - y;
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}

}
