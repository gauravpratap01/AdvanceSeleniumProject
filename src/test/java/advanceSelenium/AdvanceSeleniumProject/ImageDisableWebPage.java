package advanceSelenium.AdvanceSeleniumProject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageDisableWebPage {

	public static void main(String[] args) {
		// To speed up the execution time we can disable loading of images on webpage\
		ChromeOptions options=new ChromeOptions();
		disableImage(options);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());

	}
	
	public static void disableImage(ChromeOptions options) {
		HashMap<String,Object> image=new HashMap<String,Object>();
		image.put("images", 2);
		
		HashMap<String,Object> pref=new HashMap<String,Object>();
		pref.put("profile.default_content_setting_values", image);
		options.setExperimentalOption("prefs", pref);
		
		
		
	}

}
