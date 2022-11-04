package base;

import static utils.IConstant.*;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.auto.AboutYou;
import pages.common.HomePage;
import pages.homeOwners.ConfirmPropertyAddressPage;
import pages.homeOwners.HomeOwnerZipCode;
import pages.homeOwners.PropertyAddressPage;
import utils.Configuration;

public class BaseClass {

	Configuration config = new Configuration();
	WebDriver driver;
	protected HomePage homePage;
	protected AboutYou aboutYou;
	protected HomeOwnerZipCode homeOwnerZipCode;
	protected PropertyAddressPage propertyAddressPage;
	protected ConfirmPropertyAddressPage confirnPropertyAddressPage;
	
     //@Parameters("browser") need it for crossBrowser testing
	@BeforeMethod
	public void setUpDriver() {
		//public void setUpDriver(browser){}
		//initDriver(browser); need it for crossBrowser testing
		initDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty((URL)));
		long pageLoadTime = Long.parseLong(config.getProperty(PAGELOAD_WAIT));
		long implicitWait = Long.parseLong(config.getProperty(IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		initClasses();
		
	}

	private void initDriver() {
		//private void initDriver() {}
		//switch (browser)  need it for crossBrowser testing
		String browserName = config.getProperty(BROWSER);
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}

	private void initClasses() {
		homePage = new HomePage(driver);
		aboutYou = new AboutYou(driver);
		homeOwnerZipCode = new HomeOwnerZipCode(driver);
		propertyAddressPage = new PropertyAddressPage(driver);
		confirnPropertyAddressPage = new ConfirmPropertyAddressPage(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void closingDriverSession() {
		getDriver().quit();
	}

}
