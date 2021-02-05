package cart.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Initialization;
import cart.base.*;

public abstract class Setup extends Initialization{

	WebDriver driver;
	@BeforeTest
	public void beforeTest() throws Exception
	{
		Initialization i = new Initialization();
		driver = i.initialization();
		
		LoginPage login = new LoginPage(driver);
		
		if(login.username().isDisplayed())
			login(login);
		else
		{
			login.loginbutton().click();
			login(login);
		}
	}
	
	public void login(LoginPage login)
	{
		
		login.username().sendKeys("8416004024");
		login.password().sendKeys("mukta@123");
		login.loginbtn().click();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	public WebDriver windows()
	{
		Set<String> handle = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		Iterator<String> i = handle.iterator();
		while(i.hasNext())
		{
			String child = i.next();
			if(!child.equals(parent))
			{
				driver.switchTo().window(child);
			}
		}
		return driver;
	}
	
	@Test 
	public abstract void testcase() throws Exception;
}
