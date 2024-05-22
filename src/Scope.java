import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//1. Count of link on the webpage

		// List<WebElement> link =driver.findElements(By.tagName("a"));
		// System.out.println(link.size());
		System.out.println(driver.findElements(By.tagName("a")).size());
//2. Count of links in footer section
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
//3. Count of links in first column of footer section
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
//4. Click on each link in column and check if the pages are opening
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			// click on link tab because it was not coming back to parent window from child
			// window
			String ClickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonlinkTab);
			Thread.sleep(3000);
		}
//5. Get text of every child(newly opened) window.
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
