package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class AccountPage {

	WebDriver driver;
	private ElementsUtils elementUtils;
	
	// Constructor created to initialize driver
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);   // pass driver to elementsUtils

	}

	// Intialising the locators for Login Functionality
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation;

	// To perform Actions to the Login Functionality
	
	public boolean displayStatusofeditYourAccountInformationOption() // return boolean value of account information Assertion
	{
		
	//	return editYourAccountInformation.isDisplayed();	  // checks for Assertion wether the information displayed so return True/Fals 
		return elementUtils.displayStatusOfElement(editYourAccountInformation, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	
}
