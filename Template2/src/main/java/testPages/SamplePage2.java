package testPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class SamplePage2 extends TestBase {

	@FindBy(xpath = "//span[contains(.,'Health Care Financial Services')]")
	WebElement HealthcareFinancialService;
	@FindBy(xpath = "//span[contains(.,'Optum Bank customer support')]")
	WebElement OptumBankCustomerSupport;
	@FindBy(xpath = "//button[@class='main-nav__list--main-item']//span[text()='Investments']")
	WebElement Inverstments;
	
	public SamplePage2() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 45);
	}
	
	public void gettingToCustomersPage() {
		//Hello! Hello!!!
		//Annother CHange
		wait.until(ExpectedConditions.visibilityOf(HealthcareFinancialService));
		HealthcareFinancialService.click();
		OptumBankCustomerSupport.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this is how to switch to next window
		Set<String> window = driver.getWindowHandles();
		Iterator<String> i = window.iterator();
		
		String parentwindow = i.next();
		String childwindow = i.next();
		
		driver.switchTo().window(childwindow);
	}

	public boolean verifyInverstments() {
		wait.until(ExpectedConditions.visibilityOf(Inverstments));
		return Inverstments.isDisplayed();
	}
}
  