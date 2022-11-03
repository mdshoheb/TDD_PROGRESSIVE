package auto;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import base.BaseClass;

public class AutoTest extends BaseClass {

	@Test
	public void autoQuote() {
		homePage.autoSteps("11368");
		aboutYou.aboutYouSteps("Adam", "K","Sandler", "SR", "06/20/1965", "9610 57th ave", "17F", "Corona");
	}
	
	@Parameters({"zip", "firstName", "middleIn", "lastName", "suffix","dob", "mailingAddress", "apt", "city"})
	@Test
	public void autoQuoteParameter(String zipCode, String firstN, String middleN, String lastN,  String suffix, String dob, String mAddress, String apt, String city) {
		homePage.autoSteps(zipCode);
		aboutYou.aboutYouSteps(firstN, middleN, lastN, suffix, dob, mAddress, apt, city);
	}

}
