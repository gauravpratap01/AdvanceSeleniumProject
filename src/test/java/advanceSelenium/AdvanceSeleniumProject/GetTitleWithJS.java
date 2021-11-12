package advanceSelenium.AdvanceSeleniumProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitleWithJS {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=1)
	public void getTitleWithJS() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title").toString();
		System.out.println(title);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}
