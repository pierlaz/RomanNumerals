
public class RomanNumerals {
	
	public static int convertToInteger(java.lang.String romanNumber) throws Max1RepetitionsException,Max3RepetitionsException,InvalidRomanDigitException{
		
		if(RomanNumerals.isValidRomanDigit(romanNumber) == false){
			throw new InvalidRomanDigitException(); 
		}
		
		if(RomanNumerals.max3RepetionsOfADigit(romanNumber) == false){
			throw new Max3RepetitionsException();
		}
		
		if(RomanNumerals.max1RepetionsOfADigit(romanNumber) == false){
			throw new Max1RepetitionsException();
		}
		
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /* operation to be performed on upper cases even if user 
           enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);
            
            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }
	
	 private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
	        if (lastNumber > decimal) {
	            return lastDecimal - decimal;
	        } else {
	            return lastDecimal + decimal;
	        }
	    }
	
	public static boolean isValidRomanDigit(String romanNum){
		boolean flag = true;
		
		if (romanNum.length() == 0){
			return false;
		}
		for(int i=romanNum.length() - 1; i>=0; i--){
			char romanDigit = romanNum.charAt(i);
			if(!(romanDigit == 'I' ||romanDigit == 'V' ||romanDigit == 'X' ||
					romanDigit == 'L' ||romanDigit == 'C' ||romanDigit == 'D' ||
					romanDigit == 'M' )){
				return false;
			}
		}
		
		return flag;
	}
	
	public static boolean max3RepetionsOfADigit(String romanNum) throws Max3RepetitionsException{
		boolean flag = true;
		int contaI = 0;
		int contaC = 0;
		int contaX = 0;
		int contaM = 0;
		
		for(int i=0; i<romanNum.length(); i++){
			char romanDigit = romanNum.charAt(i);
			if(romanDigit == 'I'){
				contaI++;
				if (contaI > 3){
					return false;
				}
			}else if(romanDigit == 'X'){
				contaX++;
				if (contaX > 3){
					return false;
				}
			}else if(romanDigit == 'C'){
				contaC++;
				if (contaC > 3){
					return false;
				}
			}else if(romanDigit == 'M'){
				contaM++;
				if (contaM > 3){
					return false;
				}
			}
		}
		
		return flag;
	}
	
	public static boolean max1RepetionsOfADigit(String romanNum) throws Max1RepetitionsException{
		boolean flag = true;
		int contaV = 0;
		int contaL = 0;
		int contaD = 0;
		
		for(int i=0; i<romanNum.length(); i++){
			char romanDigit = romanNum.charAt(i);
			if(romanDigit == 'V'){
				contaV++;
				if (contaV > 1){
					return false;
				}
			}else if(romanDigit == 'L'){
				contaL++;
				if (contaL > 1){
					return false;
				}
			}else if(romanDigit == 'D'){
				contaD++;
				if (contaD > 1){
					return false;
				}
			}
			
		}
		
		return flag;
		
	}
	
	
	public static void main(String[] args){
		RomanNumerals r = new RomanNumerals();
		
	}
}
