package cart.test;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import cart.base.*;


public class AddToCartTest extends Setup{

	TestCaseOne t;
	int amount = 0, count = 0;
	
	@Override
	@Test
	public void testcase() throws Exception{
		//Verify that user logins successfully.
		Thread.sleep(7000);
		t = new TestCaseOne(driver);
		/*String name = t.title().getText();
		Assert.assertEquals(name, "Mukta");*/
		
		//Add an item in cart and verify
		WebElement search = t.search();
		search.sendKeys("iphone",Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='_4ddWXP']/a[2]"));
		Iterator<WebElement> i = li.iterator();
		while(i.hasNext())
		{
			WebElement el = i.next();
			if(el.getText().contains("Apple iPhone 11"))
			{
				el.click();
				System.out.println("Element clicked successfully");
				break;
			}
		}
		driver = windows(); //change window handle to child window
		amount = calculateAmount(); 
		t.addToCart().click();
		Thread.sleep(5000);
	
	}

	@Test(priority=1)
	public void testcase2() throws InterruptedException
	{
		//Increase the quantity of the item from the cart and verify.
		t = new TestCaseOne(driver);
		t.addMore().click();
		Thread.sleep(7000);
		count = calculateCount();
		amount = amount * count;
		System.out.println("Total amount is: " + amount);
	}
	
	@Test(priority=2)
	public void testcase3()
	{
		//Verify the amount calculated after adding items.
	}
	
	public int calculateAmount()
	{
		t = new TestCaseOne(driver);
		String a = t.amount().getText().substring(1); //At 0th index there is currency symbol 
		a = a.replace(",", "");
		amount = Integer.parseInt(a);
		System.out.println("Cost of item->" + amount +"/-");
		return amount;
		
	}
	
	public int calculateCount()
	{
		t = new TestCaseOne(driver);
		count = Integer.parseInt(t.countItems().getAttribute("value"));
		System.out.println("Total no. of items:" + count);
		return count;
	}
}
