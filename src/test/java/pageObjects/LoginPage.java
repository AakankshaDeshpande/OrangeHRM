package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver  = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name ='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name ='password']")
	WebElement password;
	
	@FindBy(xpath ="//button[@type ='submit']")
	WebElement loginbtn;
	
	public void getHomeUrl()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void sendUsername(String uName)
	{
		username.sendKeys(uName);
	}
	public void sendpwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	public String getTitleLoginPage()
	{
	String title = driver.getTitle();
	System.out.println(title);
	return title;
	}

}
