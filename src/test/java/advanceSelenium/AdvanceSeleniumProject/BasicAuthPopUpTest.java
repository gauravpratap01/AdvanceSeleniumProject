package advanceSelenium.AdvanceSeleniumProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthPopUpTest {
	public WebDriver driver;
	public String username="admin";
	public String password="admin";
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test
	public void method1() {		
		//Format is--> https://username:paswd@test.com
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String url="https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		String text=driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "Congratulations! You must have the proper credentials.","Text didn't match");		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
