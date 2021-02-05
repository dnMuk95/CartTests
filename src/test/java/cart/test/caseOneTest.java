package cart.test;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import cart.base.*;

//Test case 1 >> Add one item to the cart and verify.

public class caseOneTest extends Setup{

	@Override
	@Test
	public void testcase() throws Exception{
		//Verify that user logins successfully.
		Thread.sleep(7000);
		TestCaseOne t = new TestCaseOne(driver);
		String name = t.title().getText();
		Assert.assertEquals(name, "Mukta");
		
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
		t.addToCart().click();
		Thread.sleep(4000);
	}

	
}
