package advanceSelenium.AdvanceSeleniumProject;

import org.testng.annotations.Test;

public class RepeatTestMultipleTimes {

	@Test(invocationCount=10)
	public void sum() {
		int a=10;
		int b=20;
		System.out.println("Sum of Number="+(a+b));
			
	}
}
