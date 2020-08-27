package qa.poc.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

    By signIn = By.id("login_modal");
    By userId = By.id("user_email");
    By password = By.id("user_password");
    By login = By.xpath("//input[@type='submit' and @value='Log in']");
    		//By.name("commit");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignIn(){
    	System.out.println("Click sign in button on landing page...");
    	driver.findElement(signIn).click();
    }
    
    public void setUserId(String userName){
        driver.findElement(userId).sendKeys(userName);
    }

    public void setPassword(String passPhrase){
        driver.findElement(password).sendKeys(passPhrase);
    }

    public void submitRequest(){
    	System.out.println("Logging in into the system...");
//    	driver.findElements(login).get(1).submit();
    	driver.findElement(login).submit();
    }
    
    public void signIn(String userName, String password) {
    	clickSignIn();
    	
    	driver.switchTo().window(driver.getWindowHandle());
    	setUserId(userName);
    	setPassword(password);
    	submitRequest();

    }
}
