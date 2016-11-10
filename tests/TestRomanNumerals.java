import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRomanNumerals {

	
	private String romanNumValid;
	private String romanNumEmpty;
	private String romanNumInvalid;
	private String romanNum3RepetitionsInvalid;
	private String romanNum1RepetitionsInvalid;
	
	@Before
	public void setUp(){
		romanNumEmpty = "";
		romanNumInvalid = "CIAO";
		romanNumValid = "CXIII";
		romanNum3RepetitionsInvalid = "IXIII";
		romanNum1RepetitionsInvalid = "VVI";
	}
	
	@Test
	public void validRomanNumber() throws Max1RepetitionsException,InvalidRomanDigitException, Max3RepetitionsException{
		//Arrange
		//Act
		
		assertTrue("Numero CXIII in decimale", 113 == RomanNumerals.convertToInteger(romanNumValid));
	}
	@Test (expected = InvalidRomanDigitException.class)
	public void emptyString() throws  Max1RepetitionsException,Max3RepetitionsException,InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNumEmpty);
	}
	
	@Test (expected = InvalidRomanDigitException.class)
	public void invalidRomanNumber() throws Max1RepetitionsException, Max3RepetitionsException, InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNumInvalid);
	}
	
	@Test (expected = Max3RepetitionsException.class)
	public void invalid3Repetitions() throws Max1RepetitionsException, Max3RepetitionsException, InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNum3RepetitionsInvalid);
	}
	
	@Test (expected = Max1RepetitionsException.class)
	public void invalid1Repetitions() throws  Max1RepetitionsException, Max3RepetitionsException, InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNum1RepetitionsInvalid);
	}

}
