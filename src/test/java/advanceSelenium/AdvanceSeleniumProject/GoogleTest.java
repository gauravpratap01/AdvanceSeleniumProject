package advanceSelenium.AdvanceSeleniumProject;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/"); 
		
	}	
	
	@Test(priority=-1)
	public void googleTest(){
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");;
		
	}
	@Test(priority=0)
	public void googleSearchTest() {
		driver.findElement(By.name("q")).sendKeys("Testing");
		driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).sendKeys(Keys.ENTER);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
	

}
