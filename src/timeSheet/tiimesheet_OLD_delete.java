package timeSheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.notification.RunListener.ThreadSafe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tiimesheet_OLD_delete{

	ChromeDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Desktop\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("C:\\Users\\home\\Desktop\\workspace\\TimeSheet.html");
	}
	// verify if the “Google Search” button is displayed and print the result
			boolean timeSheetPresence = driver.findElement(By.xpath("//h3[@align='center']")).isDisplayed();
			System.out.println(timeSheetPresence);
	
	
//	*Go to application	time sheet there	medium	Pass	
	@Test
	public void test2() {
		String actualText = driver.findElement(By.xpath("//h3[@align='center']")).getText();
		String expectedText = "Time Sheet";
		Assert.assertEquals(expectedText, actualText);
	}

//	Go to application	*Place holders for First Name and Last Name should be there 
//	Drop-down menu should be there	high	Pass
	@Test
	public void test3() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='First Name']")).click();
		Thread.sleep(500);

		driver.findElement(By.id("lname")).click();
		Thread.sleep(500);

		WebElement department = driver.findElement(By.id("department"));
		driver.findElement(By.id("department")).click();
		Thread.sleep(500);

		// my expected values
		String[] arr = { "--Select Your Department--", "Central Office", "Maintenance", "Hildreth", "Bromfield", "Pupil Services - DW", 
				"Pupil Services - HES", "Pupil Services - TBS", "Technology", "Technology" };
				        System.out.println("expected elements: "+ Arrays.toString(arr));

		Select dropdown = new Select(department);
		List<WebElement> dropdownvalues = dropdown.getOptions();
		
		
		System.out.println(dropdownvalues.size());
		// this does not print.. System.out.println(dropdownvalues);
		
		for (int i = 0; i < dropdownvalues.size(); i++) {
				Assert.assertEquals(arr[i], dropdownvalues.get(i).getText());
				System.out.println(dropdownvalues.get(i).getText());
		}
		System.out.println("Verification is successful");

		public void test4() {
			
			List<WebElement> departmentElements = driver.findElements(By.xpath("//select[@id='department']/option"));
			//System.out.println(departmentElements.size());  /found 10
			System.out.println("They are in total " + departmentElements.size() + " items including menu header");
			
		for (WebElement eachItem : departmentElements) {
			System.out.println(eachItem.getText());
		}
	
		
		for (int i = 0; i < departmentElements.size(); i++) {
			System.out.println(departmentElements.get(i).getText());
		}
		
		
		
	}


}
