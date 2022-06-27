package com.gadget.Calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	
	
	public double addNumbers(double x, double y) {
		return x + y;
	}
	
	public double subtractNumbers(double x, double y) {
		return x - y;
	}
	
	public double multiplyNumbers(double x, double y) {
		return x * y;
	}
	
	public double divideNumbers(double x, double y) {
		return x / y;
	}
	
	public double moduloNumbers(double x, double y) {
		return x % y;
	}
	
	

}
