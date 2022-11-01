package auto;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import base.BaseClass;

public class AutoTest extends BaseClass {

	@Test
	public void autoQuote() {
		homePage.autoSteps("11368");
		aboutYou.aboutYouSteps("Adam", "Sandler", "K", "06/20/1965", "9610 57th ave", "17F", "Corona");
	}
	
	@Parameters({"zip", "firstName", "lastName", "middleIn", "dob", "mailingAddress", "apt", "city"})
	@Test
	public void autoQuoteParameter(String zipCode, String firstN, String lastN, String middleN, String dob, String mAddress, String apt, String city) {
		homePage.autoSteps(zipCode);
		aboutYou.aboutYouSteps(firstN, lastN, middleN, dob, mAddress, apt, city);
	}

}
