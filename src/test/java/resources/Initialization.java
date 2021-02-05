package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initialization {

	public WebDriver driver; 
	public WebDriver initialization() throws IOException
	{
		FileInputStream fs = new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\cart\\src\\test\\java\\resources\\property.properties");
		Properties p = new Properties();
		p.load(fs);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String webdriverProperty = p.getProperty("webdriverProperty");
		String driverLocation = p.getProperty("driverLocation");
		System.setProperty(webdriverProperty, driverLocation);
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("cannot initialize........");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
}
