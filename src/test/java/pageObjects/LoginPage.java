package pageObjects;

import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver  = driver;
	}
	
	public void getHomeUrl()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

}
