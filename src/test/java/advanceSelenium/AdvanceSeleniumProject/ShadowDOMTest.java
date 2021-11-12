package advanceSelenium.AdvanceSeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://embed.plnkr.co/fVIYs97WzjwjYnuDE75u/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		WebElement element=(WebElement) jsExecutor.executeScript("return document.querySelector(\"#container\").shadowRoot.querySelector(\"#inside\");");
		
		String text=(String) jsExecutor.executeScript("arguments[0].textContent;", element);
		System.out.println(text);
	}

}
