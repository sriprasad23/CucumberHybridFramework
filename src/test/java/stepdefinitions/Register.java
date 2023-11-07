package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerpage;
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		
		driver =Driverfactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();
		
	}

	@When("User enters details into the below fields")
	public void user_enters_details_into_the_below_fields(DataTable dataTable) {
		
	
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstNameText(dataMap.get("firstname")); // Taking parameters from Faeature files
		registerpage.enterLastNameText(dataMap.get("lastname"));
		registerpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
		registerpage.telePhoneNumberField(dataMap.get("phone"));
		registerpage.passwordTextField(dataMap.get("password"));
		registerpage.confirmPasswordTextField(dataMap.get("confirmpassword"));
		
	}
	
	// To get duplicate elements from feature files
	@When("User enters the details into the below fields with duplicate email")
	public void User_enters_the_details_into_the_below_fields_with_duplicate_email(DataTable dataTable)
	{
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstNameText(dataMap.get("firstname")); // Taking parameters from Faeature files
		registerpage.enterLastNameText(dataMap.get("lastname"));
		registerpage.enterEmailAddress(dataMap.get("email"));
		registerpage.telePhoneNumberField(dataMap.get("phone"));
		registerpage.passwordTextField(dataMap.get("password"));
		registerpage.confirmPasswordTextField(dataMap.get("confirmpassword"));
		
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy()
	{
		registerpage.privacypolicyAgreeCheckBox();
	  
	}

	@And("clicks on continue button")
	public void clicks_on_continue_button() {
	  
		registerpage.clicksOnContinueButton();
	}

	@Then("User Accounts should get created successfully")
	public void User_Accounts_should_get_created_successfully()
	{
		AccountSuccessPage accountssuccesspage = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!",accountssuccesspage.pageHeading() );

	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter()
	{
		registerpage.newsLetterSelectionOption();
		
	}

	@Then("User should get proper warning message about duplicate email message")
	public void user_should_get_proper_warning_message_about_duplicate_email_message() {
	   
		Assert.assertTrue(registerpage.displayDuplicateWarrningMessage().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into field")
	public void user_dont_enter_any_details_into_field() {
	    
		registerpage = new RegisterPage(driver);
		
		
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		
		Assert.assertTrue(registerpage.displayDuplicateWarrningMessage().contains("Warning: You must agree to the Privacy Policy!"));
	
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordWarningMessage());
	
	}
	
}
