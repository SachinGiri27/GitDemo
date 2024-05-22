import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrollings {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scrolling windows
		js.executeScript("window.scrollBy(0,500)");
		//Scrolling a table in window
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		//to get the values from the table in window
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for(int i=0; i<values.size();i++)
		{
			Integer.parseInt(values.get(i).getText());
			System.out.println(Integer.parseInt(values.get(i).getText()));
			//to get sum-> sum + value--> first sum=0 and increases by value every time to add
			sum = sum + Integer.parseInt(values.get(i).getText());	
		}
		System.out.println(sum);
		//to check and compare the values 
		int total= Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		//Assertion
		Assert.assertEquals(sum, total);

	}

}
