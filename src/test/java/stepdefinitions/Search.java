package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {

	WebDriver driver;
	private HomePage homepage;
	private SearchPage searchpage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver =Driverfactory.getDriver();
	    
	}
	//User enters valid product "HP" into search box field
	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String ProductText) 
	{
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBox(ProductText);
	    
	}

	@And("User click on Search button")
	public void user_click_on_search_button() {
		
		homepage.clickSearchButtonOPtion();
		
	}

	@Then("User should get valid product displayed in searech result")
	public void user_should_get_valid_product_displayed_in_searech_result() {
		
		searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.displayStatusOfValidProduct());
		
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText)
	{
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBox(invalidProductText);
		
	// * Intentionaly faillinher to get fail report and to take screenshot for that same
		//	Assert.fail();
								// or
								// int a = 10/0; // 
	}

	@Then("User should get warning message about no product matching")
	public void user_should_get_warning_message_about_no_product_matching() {
		
		searchpage = new SearchPage(driver);
		
		Assert.assertEquals("There is no product that matches the search criteria.",searchpage.displayStatusOfInValidProduct());
		
	}

	@When("User do not enter any product name into search box field")
	public void user_do_not_enter_any_product_name_into_search_box_field() {
	
		homepage = new HomePage(driver);
	}
	
	
}
