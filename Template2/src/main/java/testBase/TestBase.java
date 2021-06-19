package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriverWait wait;
	public static Properties prop;
	public static WebDriver driver;
	public static String localdirectory = System.getProperty("user.dir");
	public static String srcmainjavadir = File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator;
	public static String configdir = srcmainjavadir+"config"+File.separator;
	public static String driversdir = File.separator+"drivers"+File.separator;
	//System.getProperty(user.dir) gives you the directory of your project
	//File.separator is used to support other operating systems like linux

public TestBase() {
		
		prop=new Properties();
		
		try {
			FileInputStream fileinput=new FileInputStream(localdirectory+configdir+"config.properties");
			prop.load(fileinput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
}

public static void startbrowser() {
	
	String browser = prop.getProperty("browser");
			
	if(browser.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", localdirectory+driversdir+"geckodriver"+prop.getProperty("geckodriver")+".exe");
		driver = new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", localdirectory+driversdir+"chromedriver"+prop.getProperty("chromedriver")+".exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox"); // Bypass OS security model
		if(prop.getProperty("winchromeheadless").equalsIgnoreCase("true")) {
			options.addArguments("--headless");
		}
	//	options.addArguments("window-size=1920,1080");
		driver = new ChromeDriver(options);
	}
	
	else if(browser.equalsIgnoreCase("Edge")) {
		System.setProperty("webdriver.edge.driver", localdirectory+driversdir+"edgedriver"+prop.getProperty("edgedriver")+".exe");
		driver = new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //time should come from util class
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //update later
	driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
	
	
		driver.get(prop.getProperty("url"));
		
	
	
}
	
}
