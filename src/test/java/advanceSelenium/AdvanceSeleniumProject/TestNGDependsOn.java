package advanceSelenium.AdvanceSeleniumProject;
import org.testng.annotations.Test;

public class TestNGDependsOn {
	
	@Test(priority=2,expectedExceptions = ArithmeticException.class )
	public void loginTest() {
		System.out.println("Login Test");
		int i=9/0;
		System.out.println("Value of i=" +i);
	}
	
	@Test(dependsOnMethods="loginTest",priority=1)
	public void homePage() {
		System.out.println("HomePage Test");
	}

}
