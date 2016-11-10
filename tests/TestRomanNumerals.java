import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRomanNumerals {

	
	private String romanNumValid;
	private String romanNumEmpty;
	private String romanNumInvalid;
	
	@Before
	public void setUp(){
		romanNumEmpty = "";
		romanNumInvalid = "CIAO";
		romanNumValid = "CXIII";
	}
	
	@Test
	public void validRomanNumber() throws InvalidRomanDigitException{
		//Arrange
		//Act
		
		assertTrue("Numero CXIII in decimale", 113 == RomanNumerals.convertToInteger(romanNumValid));
	}
	@Test (expected = InvalidRomanDigitException.class)
	public void emptyString() throws InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNumEmpty);
	}
	
	@Test (expected = InvalidRomanDigitException.class)
	public void invalidRomanNumber() throws InvalidRomanDigitException{
		RomanNumerals.convertToInteger(romanNumInvalid);
	}

}
