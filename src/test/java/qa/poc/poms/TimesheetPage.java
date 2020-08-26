package qa.poc.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TimesheetPage {

	private WebDriver driver;
	
	private By project = By.xpath("//select[contains(@id,'project_id')]");
	private By task = By.xpath("//select[contains(@id,'task_id')]");
	private By hours = By.xpath("//input[contains(@id,'hours')]");
	private By description = By.xpath("//textarea[contains(@id,'activity_log')]");
	
	private By submitTimeSheet = By.xpath("//input[@value='Submit Timesheet']");
	
	private String projectVal = "Drupal Research";
	private String taskVal = "Testing";
	private String hoursVal = "8";
	private String descriptionVal = "Testing QA Automation";
	
	
	public TimesheetPage(WebDriver driver){
        this.driver = driver;
    }
	
	public void setProject(int index) throws InterruptedException {
		Select projectSelect = new Select(driver.findElements(project).get(index));
		projectSelect.selectByVisibleText(projectVal);
		Thread.sleep(500L);
	}
	
	public void setTask(int index) {
		Select projectSelect = new Select(driver.findElements(task).get(index));
		projectSelect.selectByVisibleText(taskVal);
	}
	
	public void setHours(int index) {
		driver.findElements(hours).get(index).sendKeys(hoursVal);
	}

	public void setDescription(int index) {
		driver.findElements(description).get(index).sendKeys(descriptionVal);
	}
	
	public void setProjectVal(String project) {
		this.projectVal = project;
	}
	
	public void setTaskVal(String task) {
		this.taskVal = task;
	}
	
	public void setDescriptionVal(String description) {
		this.descriptionVal = description;
	}

	
	public void fillAllTimeSheets() throws InterruptedException {
		System.out.println("Fill all time sheets........");
		setProject(0);
		setTask(0);
		setHours(0);
		setDescription(0);		
		
		setProject(1);
		setTask(1);
		setHours(1);
		setDescription(1);
		
		setProject(2);
		setTask(2);
		setHours(2);
		setDescription(2);
		
		setProject(3);
		setTask(3);
		setHours(3);
		setDescription(3);
		
		setProject(4);
		setTask(4);
		setHours(4);
		setDescription(4);
	}
	
	public void fillTimeSheet(int index) throws InterruptedException {
		System.out.println("Fill timesheet row...");
		setProject(index);
		setTask(index);
		setHours(index);
		setDescription(index);
	}
	
	public void submitTimeSheet() {
		System.out.println("Submitting timesheets page...");
		driver.findElement(submitTimeSheet).submit();
	}
}
