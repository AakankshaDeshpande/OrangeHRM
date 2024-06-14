package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestBase;

public class PageObjectManager {
	public WebDriver driver;
	public LoginPage loginpage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public LoginPage getLoginpage() {
		loginpage = new LoginPage(driver);
		return loginpage;
	}

}
