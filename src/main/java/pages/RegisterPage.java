package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementsUtils elementUtils;

	// Constructor created to initialize driver and Object reference for
	// RegisterPage

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}

	// Intialising the locators for Register Functionality

	@FindBy(id = "input-firstname")
	private WebElement FirstNameField;
	 
	@FindBy(id = "input-lastname")
	private WebElement LastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telePhoneNumber;		
	
	@FindBy(id = "input-password")
	private WebElement passwordTextField;	
	
	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordTextField;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement YesnewsLetterOption;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyAgreeCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clicksOnContinueButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	// To perform Actions to the RegisterPage Functionality

	public void enterFirstNameText(String firstNameText)
	{
		//FirstNameField.sendKeys(firstNameText);
		elementUtils.typeTextIntoElement(FirstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void enterLastNameText(String lastNameText)
	{
		//LastNameField.sendKeys(lastNameText);
		elementUtils.typeTextIntoElement(LastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}

	public void enterEmailAddress(String emailText)
	{
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void telePhoneNumberField(String telePhoneText)
	{
		//telePhoneNumber.sendKeys(telePhoneText);
		elementUtils.typeTextIntoElement(telePhoneNumber, telePhoneText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void passwordTextField(String passwordText)
	{
		//passwordTextField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordTextField, passwordText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void confirmPasswordTextField(String confirmPasswordText)
	{
		//confirmpasswordTextField.sendKeys(confirmPasswordText);
		elementUtils.typeTextIntoElement(confirmpasswordTextField, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void newsLetterSelectionOption()
	{
		//YesnewsLetterOption.click();
		elementUtils.clickOnElement(YesnewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void privacypolicyAgreeCheckBox()
	{
		//privacyPolicyAgreeCheckBox.click();
		elementUtils.clickOnElement(privacyPolicyAgreeCheckBox, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public void clicksOnContinueButton()
	{
		//clicksOnContinueButton.click();
		elementUtils.clickOnElement(clicksOnContinueButton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String displayDuplicateWarrningMessage()
	{
		//return warningMessage.getText();
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String getFirstNameWarningMessage()
	{
		//return firstNameWarningMessage.getText();
		return elementUtils.getTextFromElement(firstNameWarningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String getLastNameWarningMessage()
	{
		//return lastNameWarningMessage.getText();
		return elementUtils.getTextFromElement(lastNameWarningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String getEmailWarningMessage()
	{
		//return emailWarningMessage.getText();
		return elementUtils.getTextFromElement(emailWarningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String getTelephoneWarningMessage()
	{
		//return telephoneWarningMessage.getText();
		return elementUtils.getTextFromElement(telephoneWarningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String getPasswordWarningMessage()
	{
		//return passwordWarningMessage.getText();
		return elementUtils.getTextFromElement(passwordWarningMessage, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
}
