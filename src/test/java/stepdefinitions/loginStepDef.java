package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utils.TestBase;
import utils.testContextSetup;

public class loginStepDef {
	testContextSetup testcontextsetup;
	PageObjectManager pageobjectmanager;
	LoginPage loginpage;
	public loginStepDef(testContextSetup testcontextsetup)
	{
		this.testcontextsetup = testcontextsetup;
		this.loginpage =testcontextsetup.pageobjectmanager.getLoginpage();
	}
	
	@Given("The user is on  Orange HRM page")
	public void the_user_is_on_orange_hrm_page() {
		loginpage.getHomeUrl();
		Assert.assertTrue(loginpage.getTitleLoginPage().contains("OrangeHRM"));
	    
	}

	@When("The user enters valid user name as {string} and  password as {string} and user clicks on login button")
	public void the_user_enters_valid_user_name_as_and_password_as_and_user_clicks_on_login_button(String userName, String passWord) {
	  
		loginpage.sendUsername(userName);
		loginpage.sendpwd(passWord);
		loginpage.clickLogin();
	}

	@Then("The user should be able to log in and directed to Dashboard page")
	public void the_user_should_be_able_to_log_in_and_directed_to_dashboard_page() {
	   
		Assert.assertTrue(loginpage.getTitleLoginPage().contains("OrangeHRM"));
	}




}
