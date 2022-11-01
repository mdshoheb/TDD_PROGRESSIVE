package auto;

import org.testng.annotations.Test;
import base.BaseClass;
import utils.data.AutoData;

public class Test_w_AutoData extends BaseClass{
	
	AutoData autoData = new AutoData("11368", "Idris", "Alba", "J", "02/26/1970", "9610 57th Ave", "17F", "Corona");
	
	@Test
	public void autoQuoteWithAutoData() {
		homePage.autoSteps(autoData);
		aboutYou.aboutYouSteps(autoData);
	}
}
