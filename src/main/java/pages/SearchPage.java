package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class SearchPage {

	WebDriver driver;
	private ElementsUtils elementsUtils;
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
		
	}
	
	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")			// This is from pagefactory to support POM
	private WebElement vaildHPProduct;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")			// This is from pagefactory to support POM
	private WebElement messageText;
	
	
	// 
	
	public boolean displayStatusOfValidProduct()
	{
		//return vaildHPProduct.isDisplayed();
		return elementsUtils.displayStatusOfElement(vaildHPProduct, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
	
	public String displayStatusOfInValidProduct()
	{
		//return messageText.getText();
		return elementsUtils.getTextFromElement(messageText, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}
}
