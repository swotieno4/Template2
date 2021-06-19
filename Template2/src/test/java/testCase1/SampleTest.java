package testCase1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.TestBase;
import testPages.SamplePage;

public class SampleTest extends TestBase{

 SamplePage samplepage;
	
 public SampleTest() {
	 super();
 }
	@BeforeMethod
	
	public void SetUp() {
		startbrowser();
		samplepage= new SamplePage();
	
	}
	
	@Test(priority=0,description="verify on the dash that investment is dispalyed")
	public void testingInvestments() {
		samplepage.gettingToCustomersPage();
		boolean verify = samplepage.verifyInverstments();
		Assert.assertTrue(verify);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}


