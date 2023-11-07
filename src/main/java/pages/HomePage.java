package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class HomePage {

	WebDriver driver;
	private ElementsUtils elementUtils;     // from ElementsUtils File operations is getting performed
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);   // pass driver to elementsUtils
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")								// This is from pagefactory to support POM
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText ="Register")
	private WebElement registerOPtion;
	
	@FindBy(xpath ="//input[contains(@class,'form-control input-lg')]")
	private WebElement searchBoxField;
	
	@FindBy(xpath ="//span[contains(@class,'input-group-btn')]/button")
	private WebElement clickSearchButton;
	
	/*
	 * @FindBy(xpath ="//input[contains(@class,'form-control input-lg')]") private
	 * WebElement searchBoxFieldForInvalid;
	 */
	
	public void clickOnMyAccount()
	{
	//	myAccountDropMenu.click();    // Normal way of clicking 
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASE_TIME);  // from ElementsUtils reusable methods clicking to perform action of myAccount drop menu
	}
	
	public void clickOnLogin()
	{
		//loginOption.click();
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	
	public void clickOnRegister()
	{
		//registerOPtion.click();
		elementUtils.clickOnElement(registerOPtion, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	
	public void enterProductIntoSearchBox(String ProductText)
	{
		//searchBoxField.sendKeys(ProductText);
		elementUtils.typeTextIntoElement(searchBoxField, ProductText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	/*
	 * public void enterInValidProductIntoSearchBox(String invalidProductText) {
	 * searchBoxFieldForInvalid.sendKeys(invalidProductText); }
	 */
	public void clickSearchButtonOPtion()
	{
		//clickSearchButton.click();
		elementUtils.clickOnElement(clickSearchButton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	
	
}
