package timeSheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class TimeSheet_HAKAN {

	ChromeDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Desktop\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("C:\\Users\\home\\Desktop\\workspace\\TimeSheet.html");
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
//		driver.quit();
	}

//	*Go to application	
//	time sheet there	medium	Pass	
//	@Test
	public void test1() {
		String actualText = driver.findElement(By.xpath("//h3[@align='center']")).getText();
		String expectedText = "Time Sheet";
		Assert.assertEquals(expectedText, actualText);
	}

//	Go to application	*Place holders for First Name and Last Name should be there 
//	Drop-down menu should be there	high	Pass
//	@Test
	public void test2() throws InterruptedException {
		// verify if first name is displayed and print the result
		driver.findElement(By.xpath("//input[@name='First Name']")).click();
		boolean firstNamePresence = driver.findElement(By.xpath("//input[@name='First Name']")).isDisplayed();
		System.out.println("First Name is dispalyed : " + firstNamePresence);
		Thread.sleep(500);

		// verify if last name is displayed and print the result
		driver.findElement(By.id("lname")).click();
		boolean lastNamePresence = driver.findElement(By.id("lname")).isDisplayed();
		System.out.println("Last Name is displayed : " + lastNamePresence);
		Thread.sleep(700);

		WebElement department = driver.findElement(By.id("department"));
		driver.findElement(By.id("department")).click();
		Thread.sleep(700);

		// my expected values
		String[] arr = { "--Select Your Department--", "Central Office", "Maintenance", "Hildreth", "Bromfield",
				"Pupil Services - DW", "Pupil Services - HES", "Pupil Services - TBS", "Technology", "Technology" };
		System.out.println("My drop-down expected elements: " + Arrays.toString(arr));

		Select dropdown = new Select(department);
		List<WebElement> dropdownvalues = dropdown.getOptions();

		System.out.println("They are in total " + dropdownvalues.size() + " items");

		for (int i = 0; i < dropdownvalues.size(); i++) {
			Assert.assertEquals(arr[i], dropdownvalues.get(i).getText());
		}
		System.out.println("Verification is successful, all drop-down items match!");
	}

	// *Go to application *Input First Name, Input Last Name,department and Date,
	// Click on Validate Button
	// Name as a signature * Date signed high Pass
//	@Test
	public void test3() {

		WebElement firstName = driver.findElement(By.xpath("//input[@name='First Name']"));
		firstName.clear();
		firstName.sendKeys("Andy");

		WebElement lastName = driver.findElement(By.id("lname"));
		lastName.clear();
		lastName.sendKeys("Garcia");
		driver.findElement(By.id("lname")).click();

		WebElement department = driver.findElement(By.id("department"));
		department.click();
		Select dropdown = new Select(department);
		dropdown.selectByVisibleText("Maintenance");

		WebElement dateDropDown = driver.findElement(By.id("Date1"));
		Select selectADate = new Select(dateDropDown);
		selectADate.selectByIndex(3);

		// find and click validate button
		driver.findElement(By.id("validate")).click();

		String expectedSignature = "Andy Garcia";
		String actualSignature = driver.findElement(By.id("namelevel1")).getText();
		Assert.assertEquals(expectedSignature, actualSignature);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDateTime today = LocalDateTime.now();
		// System.out.println(dtf.format(today));
		String expectedDateSigned = "Date Signed:" + dtf.format(today);

		String actualDateSigned = driver.findElement(By.id("datelevel1")).getText();
		// System.out.println(actualDateSigned);
		Assert.assertEquals(expectedDateSigned, actualDateSigned);
	}

//	*Go to application, 
//	click drop down menu next to last name. dropdown menu is there with 9 items.	
//	high	Pass
//	@Test
	public void test4() {

		List<WebElement> departmentElements = driver.findElements(By.xpath("//select[@id='department']/option"));
		// System.out.println(departmentElements.size()); //outputs 10
		System.out.println("They are in total " + departmentElements.size() + " items including menu header");
	}

//	*Go to application, 
//	click drop down menu next to last name (department dropdown menu)	
//	There should be no duplicate menu items in dropdown menu. 	
//	medium	fail
 
	@Test
	public void test5() {
		List<WebElement> departmentElements = driver.findElements(By.xpath("//select[@id='department']/option"));
//			System.out.println(departmentElements.size()); //found 10
		for (int i = 0; i < departmentElements.size(); i++) {
			for (int j = i + 1; j < departmentElements.size(); j++) {
				if (departmentElements.get(i).getText().equals((departmentElements.get(j).getText()))) {
					System.out.println("Duplicate Element : " + departmentElements.get(j).getText() +" so test failed ");
				}
			}
		}
	}
}


