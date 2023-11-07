package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class login {
	
	WebDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	private AccountPage accountpage;
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page()
	{
		driver = Driverfactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
	}
	
	// For data driven testing parametarise values we should use another way that is implimented here 2 scenarios
	
	/*1st method
	 * @When("User enterd valid email address {string} into email field")
	public void User_enterd_valid_email_address_into_email_field(String validemailText)
	{
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(validemailText);
	}*/
	
	@When("^User enterd valid email address (.+) into email field$")
	public void User_enterd_valid_email_address_into_email_field(String validemailText)
	{
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(validemailText);
	}

	/*@And("User enterd valid password {string} into password field")
	public void user_enterd_valid_password_into_password_field(String validpasswordText) 
	{
		loginpage.enterPassword(validpasswordText);
	 }*/
	
	@And("^User enterd valid password (.+) into password field$")
	public void user_enterd_valid_password_into_password_field(String validpasswordText) 
	{
		loginpage.enterPassword(validpasswordText);
	 }

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLoginButton();

	}

	// This Page Navigates to Account Page 
	@Then("User should get successfully logged in message")
	public void user_should_get_successfully_logged_in_message() {
		
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.displayStatusofeditYourAccountInformationOption());

	}

	// Navigation from other pages so we need to creat object for login page again
	@When("User enterd invalid email address into email field")
	public void User_enterd_invalid_email_address_into_email_field() 
	{
		loginpage = new LoginPage(driver); // create object for login page
		loginpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp()); // Date and time stamp class is created in utils package CommonUtils
		
	}

	@And("User enterd invalid password {string} into password field")
	public void user_enterd_invalid_password_into_password_field(String invalidPasswordText)
	{
		loginpage.enterPassword(invalidPasswordText);
		
	}

	// This Assertion is in Login page
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch()
	{
		
		Assert.assertTrue(loginpage.getWarrningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

	@When("User do not enterd email address into email field")
	public void user_do_not_enterd_email_address_into_email_field() 
	{
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress("");
		
	}

	@And("User do not enterd password into password field")
	public void user_do_not_enterd_password_into_password_field()
	{	
		loginpage.enterPassword("");
  
	}

	
}
