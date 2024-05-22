//
//
//CHECK WEB FOR THIS ONE, IT WILL NEVER BE USED IN REAL LIFE SCENERIOS BUT PREPARE FOR THE INTERVIEW PERSPECTIVE. 
//CODE BELOW IS NOT CORRECT AND NOT COMPLETE. 
import java.time.Duration;
import java.util.Arrays;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait {

	public FluentWait(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public static <Public> void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		//Fluent Wait
		Wait<WebDriver> wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver,WebElement>()
				{
				public WebElement apply(WebDriver driver)
				{
			return driver.findElement(By.cssSelector("[id='finish'] h4"));
				}				
	});
	}

	private org.openqa.selenium.support.ui.FluentWait<WebDriver> withTimeout(Duration ofSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

}

