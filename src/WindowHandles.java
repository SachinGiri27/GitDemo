import java.util.Iterator;
import java.util.Set;
//WindowHandles OR ChildWindowOperations
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click(); // to open new window
		Set<String> windows = driver.getWindowHandles(); // [Parentid, Childid]
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();

		driver.switchTo().window(childid);

		driver.findElement(By.cssSelector(".im-para.red"));
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")));

		String emailid = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(emailid);

	}

}
