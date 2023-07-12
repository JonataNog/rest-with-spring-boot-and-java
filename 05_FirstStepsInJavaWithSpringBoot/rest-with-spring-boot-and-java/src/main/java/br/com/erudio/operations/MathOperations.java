package br.com.erudio.operations;

public class MathOperations {
	
	public static Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	
	public static Double subtraction(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public static Double multiplication(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public static Double division(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}
	
	public static Double avg(Double numberOne, Double numberTwo) {
		return ((numberOne + numberTwo) / 2);
	}
	
	public static Double square(Double number) {
		return Math.sqrt(number);
	}
	
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

}
