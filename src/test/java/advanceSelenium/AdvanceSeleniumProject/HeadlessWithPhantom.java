package advanceSelenium.AdvanceSeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HeadlessWithPhantom {
	
	//PhantomJSDriver internally uses Ghost driver.
	//Ghost driver used as JSON wire protocol-->HTTP Rest calls
	//Directly interact with HTML DOM
	public static void main(String[] args) {
		System.setProperty("phantomjs.binary.path","C:\\Users\\prata\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		WebDriver driver=new PhantomJSDriver();
		driver.get("https://www.google.com");
		System.out.println("Title: "+driver.getTitle());
	}

}
