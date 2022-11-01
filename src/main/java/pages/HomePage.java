package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*;
import common.CommonWaits;
import utils.data.AutoData;

public class HomePage {

	WebDriver driver;
	CommonWaits waits;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		waits = new CommonWaits(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='txt' and text()='Auto ']")
	WebElement autoProductElement;
	@FindBy(xpath = "//input[@id='zipCode_overlay']")
	WebElement zipCodElement;
	@FindBy(xpath = "//input[@id='qsButton_overlay']")
	WebElement getQuotElement;

	public void autoSteps(String zipCode) {
		click(autoProductElement);
		input(zipCodElement, zipCode);
		click(getQuotElement);
	}
	public void autoSteps(AutoData autoData) {
		click(autoProductElement);
		input(zipCodElement, autoData.getZip());
		click(getQuotElement);
	}

}
