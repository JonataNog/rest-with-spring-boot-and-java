package br.com.erudio.operations;

public class Converter {
	
	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		String number = strNumber.replaceAll(",", ".");
		if(MathOperations.isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

}
