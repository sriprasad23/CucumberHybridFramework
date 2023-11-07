package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class AccountSuccessPage {
	
	WebDriver driver;
	private ElementsUtils elementsUtils;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement pageHeading;
	
	public String pageHeading()
	{
	//	return pageHeading.getText();
		return elementsUtils.getTextFromElement(pageHeading, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
	}

}
