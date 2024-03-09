import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ParallelTests {

	WebDriver driver;

	@Test(groups = "Chrome")
	public void LaunchChrome() {
		System.setProperty("webdriver.chrome.driver", "A:\\SELENIUM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "Chrome", dependsOnMethods = "LaunchChrome")
	public void TryAmazon1() {
		System.out.println(Thread.currentThread().getId());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@Test(groups = "Edge")
	public void LaunchEdge() {
		System.setProperty("webdriver.edge.driver", "A:\\SELENIUM\\msedgedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups = "Edge", dependsOnMethods = "LaunchEdge")
	public void TryAmazon2() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oppo");
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println(Thread.currentThread().getId());
	}
}

