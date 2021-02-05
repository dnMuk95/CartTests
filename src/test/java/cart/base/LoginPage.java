package cart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='_1_3w1N']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='IiD88i _351hSN']//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='_1D1L_j']//button[@type='submit']")
	WebElement loginbtn;
	
	public WebElement loginbutton()
	{
		return loginButton;
	}

	public WebElement username()
	{
		return username;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement loginbtn()
	{
		return loginbtn;
	}
}
