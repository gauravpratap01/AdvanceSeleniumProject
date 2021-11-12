package advanceSelenium.AdvanceSeleniumProject;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileTest {
	WebDriver driver;
	File folder;
	JavascriptExecutor js;
	
	@BeforeMethod
	public void setup() {
		
		//UUID used to generate unique folder name
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir(); //to create directory with this name
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		
		Map<String,Object> pref=new HashMap<String, Object>();
		pref.put("profile.default_content_settings.popups", 0);
		pref.put("download.default_directory", folder.getAbsolutePath());
		//pref.put("download.default_directory", "C:\Tutorial\down"); //for exact path
		
		options.setExperimentalOption("prefs", pref);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver=new ChromeDriver(options);		
	}
	
	@Test
	public void downloadTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("sample.png")).click();
		
		//js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", ele);
		
		
		Thread.sleep(3000);
		File[] listOfFiles = folder.listFiles();
		//Make sure directory is not empty
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file:listOfFiles)
		{
			//make sure downloaded file is not empty
			Assert.assertTrue(file.length()>0);
		}
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.close();
		
		for(File file:folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}
	
	
	
	

}
