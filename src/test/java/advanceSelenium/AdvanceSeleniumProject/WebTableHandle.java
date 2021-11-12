package advanceSelenium.AdvanceSeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	public static void main(String[] args) {
		
		XLS_Reader reader=new XLS_Reader(System.getProperty("user.dir")+"\\src\\main\\resources\\Data.xlsx");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		
		String beforeXpath_lname="//table[@id='table1']/tbody[1]/tr[";
		String afterXpath_lname="]/td[1]";
		
		String beforeXpath_fname="//table[@id='table1']/tbody[1]/tr[";
		String afterXpath_fname="]/td[2]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		int rowCount=rows.size();
		System.out.println("Total no. of rows="+rowCount);
		
		for(int i=1;i<=rowCount;i++) {
			String actualXpath_lname=beforeXpath_lname+i+afterXpath_lname;
			String lastname=driver.findElement(By.xpath(actualXpath_lname)).getText();
			System.out.println(lastname);
			reader.setCellData("Data", "LastName", i+1, lastname);
			
			String actualXpath_fname=beforeXpath_fname+i+afterXpath_fname;
			String firstname=driver.findElement(By.xpath(actualXpath_fname)).getText();
			System.out.println(firstname);
			reader.setCellData("Data", "FirstName", i+1, firstname);
		}
		driver.close();	

	}

}
