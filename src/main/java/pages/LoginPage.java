package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class LoginPage {

	WebDriver driver;
	private ElementsUtils elementUtils; // from ElementsUtils File operations is getting performed

	// Constructor created to initialize driver and
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);   // pass driver to elementsUtils

	}

	// Intialising the locators for Login Functionality

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement clickOnLoginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement properWarningMessage;

	// To perform Actions to the Login Functionality

	public void enterEmailAddress(String validemailText) {
		//emailField.sendKeys(validemailText);
		elementUtils.typeTextIntoElement(emailField, validemailText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}

	public void enterPassword(String validpasswordText) {
		//passwordField.sendKeys(validpasswordText);
		elementUtils.typeTextIntoElement(passwordField, validpasswordText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}

	public void clickOnLoginButton() {
		//clickOnLoginButton.click();
		elementUtils.clickOnElement(clickOnLoginButton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}

	public String getWarrningMessage() 
	{
		//return properWarningMessage.getText();
		return elementUtils.getTextFromElement(properWarningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}

}
