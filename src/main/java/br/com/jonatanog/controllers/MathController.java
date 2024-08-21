package br.com.jonatanog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonatanog.converters.NumberConverter;
import br.com.jonatanog.exceptions.UnsupportedMathOperationsException;
import br.com.jonatanog.math.SimpleMath;

@RestController
public class MathController {
	
	SimpleMath math = new SimpleMath();
		
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable String numberOne,
						@PathVariable String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
	public Double subtracion(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		return math.subtracion(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/avg/{numberOne}/{numberTwo}")
	public Double avg(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		return math.avg(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/sqrt/{number}")
	public Double sqrt(@PathVariable String number) throws Exception{
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		return math.sqrt(NumberConverter.convertToDouble(number));
	}
}
