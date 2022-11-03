package home;

import org.testng.annotations.Test;
import base.BaseClass;

public class HomeTest extends BaseClass {
	
	@Test
	public void homeOwnersQuote() {
		homePage.homeSteps();
		homeOwnerZipCode.zipCodeSteps("11369");
		propertyAddressPage.addressSteps("3115 87th Street, East Elmhurst, NY, USA");
		confirnPropertyAddressPage.confirmAddressSteps("Confirm your property address", "3115 87th Street", "Corona");
	}
 
}
