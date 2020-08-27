package qa.poc.testflow;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import qa.poc.poms.HomePage;
import qa.poc.poms.LoginPage;
import qa.poc.poms.TimesheetPage;

public class TimeSheetFillTest {
	
	WebDriver driver;
	
	@Before
	public void setup() {
//		System.setProperty("webdriver.gecko.driver", "C:\\workspace\\geckodriver.exe");
//		driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver","C:\\workspace\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setProxy(null);
 
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
	}
	
	@Test 
	public void testHappyPathFlow() throws InterruptedException {
		driver.get("https://dev3.resourcestack.com");
		
		Assert.assertEquals(driver.getTitle(), "RSI - ChronStack");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn("sameerrsi@gmail.com", "ZAQ!2wsx");
		
		HomePage homePage = new HomePage(driver);
		homePage.closeDefaultWindow();
		homePage.clickNewLink();
		
		Thread.sleep(3000L);
		TimesheetPage timeSheetPage = new TimesheetPage(driver);
		timeSheetPage.fillAllTimeSheets();
		timeSheetPage.submitTimeSheet();
		
		saveScreenShot("src\\test\\resources\\HappyPathFlow.png");
		
		driver.close();
    }
	
	@Test 
	public void testAlternateProjectFlow() throws InterruptedException {
		driver.get("https://dev3.resourcestack.com");
		
		Assert.assertEquals(driver.getTitle(), "RSI - ChronStack");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn("sameerrsi@gmail.com", "ZAQ!2wsx");
		
		HomePage homePage = new HomePage(driver);
		homePage.closeDefaultWindow();
		homePage.clickNewLink();
		
		Thread.sleep(3000L);
		TimesheetPage timeSheetPage = new TimesheetPage(driver);
		timeSheetPage.fillTimeSheet(0);
		
		timeSheetPage.setProjectVal("Resourcestack cloud");
		timeSheetPage.setTaskVal("Research");
		timeSheetPage.fillTimeSheet(1);
		
		timeSheetPage.setProjectVal("Drupal Research");
		timeSheetPage.setTaskVal("Testing");
		timeSheetPage.fillTimeSheet(2);
		
		timeSheetPage.setProjectVal("Resourcestack cloud");
		timeSheetPage.setTaskVal("Research");
		timeSheetPage.fillTimeSheet(3);
		
		timeSheetPage.setProjectVal("Drupal Research");
		timeSheetPage.setTaskVal("Testing");
		timeSheetPage.fillTimeSheet(4);
		
		timeSheetPage.submitTimeSheet();
		
		saveScreenShot("src\\test\\resources\\AlternateProjectFlow.png");
		
		driver.close();
    }

	@Test 
	public void testCustomDescriptionFlow() throws InterruptedException {
		driver.get("https://dev3.resourcestack.com");
		
		Assert.assertEquals(driver.getTitle(), "RSI - ChronStack");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn("sameerrsi@gmail.com", "ZAQ!2wsx");
		
		HomePage homePage = new HomePage(driver);
		homePage.closeDefaultWindow();
		homePage.clickNewLink();
		
		Thread.sleep(3000L);
		TimesheetPage timeSheetPage = new TimesheetPage(driver);
		timeSheetPage.setDescriptionVal("Testing QA Automation on Monday");
		timeSheetPage.fillTimeSheet(0);
		
		timeSheetPage.setDescriptionVal("Testing QA Automation on Tuesday");
		timeSheetPage.fillTimeSheet(1);
		
		timeSheetPage.setDescriptionVal("Testing QA Automation on Wednesday");
		timeSheetPage.fillTimeSheet(2);
		
		timeSheetPage.setDescriptionVal("Testing QA Automation on Thursday");
		timeSheetPage.fillTimeSheet(3);
		
		timeSheetPage.setDescriptionVal("Testing QA Automation on Friday");
		timeSheetPage.fillTimeSheet(4);
		
		timeSheetPage.submitTimeSheet();
		
		saveScreenShot("src\\test\\resources\\CustomDescriptionFlow.png");
		
		driver.close();
		
    }
	
	private void saveScreenShot(String fileName) {
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		
		try {
			Files.copy(screenShot.getScreenshotAs(OutputType.FILE), new File(fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
