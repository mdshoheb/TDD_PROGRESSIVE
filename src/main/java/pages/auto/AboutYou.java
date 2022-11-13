package pages.auto;

import static common.CommonActions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.data.AutoData;

public class AboutYou {

	public AboutYou(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_FirstName")
	WebElement firstName;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MiddleInitial")
	WebElement middleInitialElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_LastName")
	WebElement lastNamElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_Suffix")
	WebElement suffixElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_DateOfBirth")
	WebElement dobElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MailingAddress")
	WebElement mailingAddressElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_ApartmentUnit")
	WebElement aptNumberElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_City")
	WebElement cityElement;
	@FindBy(xpath = "//button[text()='Okay, start my quote.']")
	WebElement okayBtnElement;

	public void aboutYouSteps(String firstN, String middleN, String lastName, String suffix, String dob,
			String mAddress, String apt, String city) {
		input(firstName, firstN);
		input(middleInitialElement, middleN);
		input(lastNamElement, lastName);
		selectDropDown(suffixElement, suffix);
		input(dobElement, dob);
		input(mailingAddressElement, mAddress);
		input(aptNumberElement, apt);
		input(cityElement, city);
		click(okayBtnElement);
	}

	 public void aboutYouSteps(AutoData autoData) {
		input(firstName, autoData.getFirstName());
		input(lastNamElement, autoData.getLastName());
		input(middleInitialElement, autoData.getMiddleIn());
		input(dobElement, autoData.getDob());
		input(mailingAddressElement, autoData.getMailingAddress());
		input(aptNumberElement, autoData.getApt());
		input(cityElement, autoData.getCity());
		click(okayBtnElement);
	}

}
