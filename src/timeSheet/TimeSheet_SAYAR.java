package timeSheet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TimeSheet_SAYAR {
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Desktop\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\home\\Desktop\\workspace\\TimeSheet.html");
	}

	@After
	public void tearDown() {
//		driver.quit();	
	}

	@Test @Ignore
	public void test16() throws InterruptedException {
//*Click"Sick Day", select "Overtime" and input hour and minute
//only positive numbers medium fail
		WebElement el = driver.findElement(By.id("leave1"));

		Select se = new Select(el);
		se.selectByIndex(1);

		driver.findElement(By.id("leavehrs1")).sendKeys("-1");
		driver.findElement(By.id("over1")).sendKeys("-2");

	}

//	@Ignore
	@Test
	public void test17() throws InterruptedException {
//Go to Week 1 "Regular Day In" click drop-down menu select other type in 
//customized time click "Copy Across"
//copies Mon thru Friday the same time medium	fail

		WebElement ele = driver.findElement(By.id("in1"));

		Select sel = new Select(ele);
		sel.selectByIndex(12);
		driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-small copy_btn']")).click();

	}

	//@Ignore
//	@Test
	public void test18() throws InterruptedException {
//Go to Week 1 "Regular Day Out" click drop-down menu select other type in 
//customized time click "Copy Across"		
//copies Mon thru Friday the same time medium	fail

		WebElement el = driver.findElement(By.id("out1"));
		Select sel = new Select(el);
		sel.selectByIndex(11);
		driver.findElement(By.xpath("//*[@id=\"theform\"]/form/div[3]/table/tbody/tr[8]/td[3]/button")).click();

	}

	@Ignore
	@Test
	public void test19() throws InterruptedException {
//Go to Week 1 "Leave Hours" type in any number 
//should accept number b/w 0 and 24  medium	fail

		WebElement el = driver.findElement(By.id("leave1"));

		Select sel = new Select(el);
		sel.selectByIndex(2);
		driver.findElement(By.id("leavehrs1")).sendKeys("27");
		;

	}

	@Ignore
	@Test
	public void test20() throws InterruptedException {
//Go to Week 1 "Overtime" type in any number 		
//should accept number b/w 0 and 24 medium	fail

		WebElement el = driver.findElement(By.id("leave1"));

		Select sel = new Select(el);
		sel.selectByIndex(2);
		driver.findElement(By.id("over1")).sendKeys("-27");

	}

	@Ignore
	@Test
	public void test21() throws InterruptedException {
//Go to Week 2 Wednesday under "Regular Day In" drop-down menu
//time-in high	fail

		WebElement result = driver.findElement(By.id("in10"));
		String resultString = result.getText();
		System.out.println(resultString);

		String searchResult = "";
		for (int i = 0; i < resultString.length(); i++) {

			if (Character.isAlphabetic(resultString.charAt(i))) {
				searchResult += resultString.charAt(i);
			}
		}
		System.out.println(searchResult);

		String expectedResult = "TimeIn";
		String actualResult = searchResult.substring(0, 7);
		System.out.println(actualResult);

		Assert.assertEquals(expectedResult, actualResult);

	}

	@Ignore
	@Test
	public void test22() throws InterruptedException {
//Select a day for Week1 and go to Week2  checkif Date startsfromnext Monday's date
//starts from Monday  high	pass

		WebElement el = driver.findElement(By.id("Date1"));
		Select sel = new Select(el);
		sel.selectByIndex(1);

		String expectedDate = "4/8/2019";
		String actualDate = driver.findElement(By.xpath("//*[@id=\"Date8\"]")).getText();
		Assert.assertEquals(expectedDate, actualDate);
	}

	@Ignore
	@Test
	public void test23() throws InterruptedException {
//Go to Week 2 "Regular Day In" click dropdwon menu select other type in customized 
//time click "Copy Across"
// copies Mon thru Friday the same time medium	fail

		WebElement el = driver.findElement(By.xpath("//*[@id=\"in8\"]"));
		Select sel = new Select(el);
		sel.selectByIndex(12);
		driver.findElement(By.xpath("//*[@id=\"theform\"]/form/div[3]/table/tbody/tr[19]/td[2]/button")).click();
	}

	@Ignore
	@Test
	public void test24() throws InterruptedException {
//Go to Week 2 "Regular Day Out" click dropdwon menu select other type in customized 
//time click "Copy Across"
//copies Mon thru Friday the same time medium	fail

		WebElement el = driver.findElement(By.xpath("//*[@id=\"out8\"]"));
		Select sel = new Select(el);
		sel.selectByIndex(12);
		driver.findElement(By.xpath("//*[@id=\"theform\"]/form/div[3]/table/tbody/tr[19]/td[3]/button")).click();

	}

	@Ignore
	@Test
	public void test25() throws InterruptedException {
//Go to Week 2 "Leave Hours" type in any number 
//should accept number b/w 0 and 24 medium	fail

		WebElement el = driver.findElement(By.id("leave8"));
		Select sel = new Select(el);
		sel.selectByIndex(3);
		driver.findElement(By.id("leavehrs8")).sendKeys("5000");

	}

	@Ignore
	@Test
	public void test26() throws InterruptedException {
//Go to Week 2 "Overtime" type in any number 
//should accept number b/w 0 and 24 medium	fail
		WebElement el = driver.findElement(By.id("leave8"));
		Select sel = new Select(el);
		sel.selectByIndex(3);
		driver.findElement(By.id("over8")).sendKeys("-5000");
	}

	@Ignore @Test
	public void test27() throws InterruptedException {
//"Regular Day In" 2.30 pm  "Regular Day Out" 1.30 pm 
//Day out time cannot be earlier than Day in time medium	fail

		WebElement el = driver.findElement(By.id("in1"));
		Select sel = new Select(el);
		sel.selectByIndex(11);
		
		WebElement ele = driver.findElement(By.id("out1"));
		Select sele = new Select(ele);
		sele.selectByIndex(2);
	}

	
	@Ignore	@Test
	public void test28() throws InterruptedException {
//After filling out other fields, click "Submit"
//A notification for submitting the form  medium	fail

		driver.findElement(By.id("fname")).sendKeys("Mehmet");
		driver.findElement(By.id("lname")).sendKeys("Sayar");
		WebElement e = driver.findElement(By.id("department"));
		Select s = new Select (e) ;
		s.selectByIndex(3);
		
		WebElement el = driver.findElement(By.id("Date1"));
		Select se = new Select (el) ;
		se.selectByIndex(1);
		
		driver.findElement(By.id("validate")).click();
		driver.findElement(By.id("submit_btn")).click();
	}

	
	@Ignore	@Test
	public void test29() throws InterruptedException {
//Week 1 Tuesday Regular Day In select 7.30 AM
//7.30 AM medium	pass

		WebElement el = driver.findElement(By.id("in2"));
		Select se = new Select(el);
		se.selectByIndex(1);
		
		String expectedResult = "07:30 AM";
		String actualResult = driver.findElement(By.xpath("//*[@id=\"in2\"]/option[2]")).getText();
		Assert.assertEquals(expectedResult, actualResult);
	}

	
	@Ignore
	@Test
	public void test30() throws InterruptedException {
//Week 2 Friday Regular Day In select 2.30 PM
//2.30 PM medium	pass

		WebElement el = driver.findElement(By.id("in12"));
		Select se = new Select(el);
		se.selectByIndex(11);
		
		String expectedResult = "02:30 PM";
		String actualResult = driver.findElement(By.xpath("//*[@id=\"in12\"]/option[12]")).getText();
		Assert.assertEquals(expectedResult, actualResult);
	}

}
