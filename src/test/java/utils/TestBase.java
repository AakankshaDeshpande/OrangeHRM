package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver initilizeBrowser() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fs);
		
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (p.getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (p.getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS..");
			}
			// browser
			switch (p.getProperty("browser").toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
			}

			this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		} else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (p.getProperty("browser").toLowerCase()) {
			case "chrome":
				this.driver = new ChromeDriver();
				break;
			case "edge":
				this.driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				this.driver = null;
			}
		}
		this.driver.manage().deleteAllCookies();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		return driver;

	}


}
