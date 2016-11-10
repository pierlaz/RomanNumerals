import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRomanNumerals {

	
	private String romanNumValid;
	private String romanNumEmpty;
	private String romanNumInvalid;
	private String romanNum3RepetitionsInvalid;
	
	@Before
	public void setUp(){
		romanNumEmpty = "";
		romanNumInvalid = "CIAO";
		romanNumValid = "CXIII";
		romanNum3RepetitionsInvalid = "IXIII";
	}
	
	@Test
	public void validRomanNumber() throws InvalidRomanDigitException, Max3RepetitionsException{
		//Arrange
		//Act
		
		assertTrue("Numero CXIII in decimale", 113 == RomanNumerals.convertToInteger(romanNumValid));
	}
	@Test (expected = InvalidRomanDigitException.class)
	public void emptyString() throws  Max3RepetitionsException,InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNumEmpty);
	}
	
	@Test (expected = InvalidRomanDigitException.class)
	public void invalidRomanNumber() throws  Max3RepetitionsException, InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNumInvalid);
	}
	
	@Test (expected = Max3RepetitionsException.class)
	public void invalid3Repetitions() throws  Max3RepetitionsException, InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNum3RepetitionsInvalid);
	}

}
