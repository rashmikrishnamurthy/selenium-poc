package qa.poc.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	By closeDefaultWindow = By.xpath("//button[@class = 'close']");
	By newLink = By.linkText("NEW");
	
	public HomePage(WebDriver driver){
        this.driver = driver;
    }
	
	public void clickNewLink() {
		driver.findElements(newLink).get(0).click();
		System.out.println("Opening timesheets page...");
	}
	
	public void closeDefaultWindow() {
		System.out.println("Closing default window...");
		driver.findElement(closeDefaultWindow).click();
	}
}
