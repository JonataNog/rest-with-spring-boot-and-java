package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.operations.Converter;
import br.com.erudio.operations.MathOperations;

@RestController
public class MathController {
	
	private  final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if(!MathOperations.isNumeric(numberOne) || !MathOperations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return MathOperations.sum(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo)); 
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if(!MathOperations.isNumeric(numberOne) || !MathOperations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return MathOperations.subtraction(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!MathOperations.isNumeric(numberOne) || !MathOperations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return MathOperations.multiplication(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!MathOperations.isNumeric(numberOne) || !MathOperations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return MathOperations.division(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if(!MathOperations.isNumeric(numberOne) || !MathOperations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return MathOperations.avg(Converter.convertToDouble(numberOne), Converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "square/{number}", method = RequestMethod.GET)
	public Double square(
			@PathVariable(value = "number") String number) throws Exception{
		
		if(!MathOperations.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return MathOperations.square(Converter.convertToDouble(number));
	}
}
