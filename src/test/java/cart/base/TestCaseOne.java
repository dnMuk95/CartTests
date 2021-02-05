package cart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCaseOne {
	public WebDriver driver;
	public TestCaseOne(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_2Xfa2_']/div[3]/div[1]/div")
	WebElement title;
	
	@FindBy(xpath="//input[@class='_3704LK']")
	WebElement search;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCart;
	
	@FindBy(xpath="//button[@class='_23FHuj'][2]")
	WebElement addMore;
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	WebElement amount;
	
	@FindBy(xpath="//input[@class='_253qQJ']")
	WebElement countItems;
	
	public WebElement title()
	{
		return title;
	}
	
	public WebElement search()
	{
		return search;
	}
	
	public WebElement addToCart()
	{
		return addToCart;
	}
	
	public WebElement addMore()
	{
		return addMore;
	}
	
	public WebElement amount()
	{
		return amount;
	}
	
	public WebElement countItems()
	{
		return countItems;
	}
}
