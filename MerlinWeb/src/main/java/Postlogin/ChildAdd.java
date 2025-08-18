package Postlogin;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Prelogin.BrowserSetupClass;

public class ChildAdd extends BrowserSetup {

	// Click With Delay
	public void ClickwithDelay(WebDriver driver, String element) {
		new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		webDriver.findElement(By.xpath(element)).click();
	}

	// Delay
	public void waitTillLocate(WebDriver driver, String element) {
		new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}

	// Scroll Till Element into center of the page
	public void scrollPageTillViewOf(WebDriver driver, String webelement) {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		waitTillLocate(driver, webelement);
		WebElement webElement = driver.findElement(By.xpath(webelement));
		j.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", webElement);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // Unable to ignore this static sleep - otherwise scroll function isn't worked
			// well
	}

	// Checking for the title of My family page.
	@Test(priority = 1)
	public void a1_homepage() {
		ExtentTest test1 = extentreport.createTest("My Mobicip page", "Checking the title of the My Family page ");
		extentTest.set(test1);
		waitTillLocate(webDriver, "//span[text()='Dashboard']");
		// ---Dashboard---
		String tit = webDriver.getTitle();
		if (tit.equals("Dashboard | Mobicip")) {
			test1.pass("Dashboard - title is correct ");
		} else {
			test1.fail("Dashboard - title isn't correct ");
		}
		// ---My Mobicip page---
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ClickwithDelay(webDriver, "//div[@class='user_profile_container']");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ClickwithDelay(webDriver, "//span[text()='My Mobicip']");
		waitTillLocate(webDriver, "//p[text()='My Mobicip']");

		// ---Validation - My Mobicip Page ---
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("My Mobicip | Mobicip")) {
			test1.pass("My Mobicip - title is correct  ");
		} else {
			test1.fail("My Mobicip - title isn't correct ");
		}

		// Header Elements
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='My Mobicip']"));
			webDriver.findElement(By.xpath("//span[@id='headerBack']"));
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			webDriver.findElement(By.xpath("//div[@class='profile_image_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("My Mobicip - Header is incorrect");
		}
		if (a == true) {
			test1.pass("Dashboard - Header is correct");
		}

	}

	@Test(priority = 2)
	public void a2_myFamily() {
		ExtentTest test21 = extentreport.createTest("My Family", "To check the My Family page");
		extentTest.set(test21);
		// ---My Family page---
		ClickwithDelay(webDriver, "//span[text()='My Family']");
		waitTillLocate(webDriver, "//p[text()='My Family']");

		// ---Validation---
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("My Family | Mobicip")) {
			test21.pass("My Family - title is correct");
		} else {
			test21.fail("My Family - title isn't correct ");
		}

		// Header Elements
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='My Family']"));
			webDriver.findElement(By.xpath("//span[@id='headerBack']"));
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			webDriver.findElement(By.xpath("//div[@class='profile_image_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("My Family - Header is incorrect");
		}
		if (a == true) {
			test21.pass("My Family - Header is correct");
		}

		// Add Member Button
		a = true;
		waitTillLocate(webDriver, "//a[@class='icon_add']");
		try {
			webDriver.findElement(By.xpath("//a[@class='icon_add']"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("My Family - Add member icon is present ");
		}
		if (a == true) {
			test21.pass("My Family - Add member icon isn't present");
		}
	}

	@Test(priority = 3)
	public void a3_addChildPage() {
		ExtentTest test2 = extentreport.createTest("Add Child page",
				"To check that by default Add Child page get opened");
		extentTest.set(test2);

		// ---Add Child page---
		ClickwithDelay(webDriver, "//a[@class='icon_add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']");

		// ---Validation--- Checking that Add child open by default while clicking on
		// Add button
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']"));
			webDriver.findElement(By.xpath("//span[text()='Monitor and Manage']"));
			webDriver.findElement(By.xpath("//span[text()='Monitor only']"));
			webDriver.findElement(By.xpath("//button[text()='Add']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Add Child page - Not opened");
		}
		if (a == true) {
			test2.pass("Add Child page - Opened by default");
		}
	}

	@Test(priority = 4)
	public void a4_addMemberHeader() {
		ExtentTest test3 = extentreport.createTest("Add Member - Header", "To check the header of Add Member ");
		extentTest.set(test3);

		// ---Validation---Header and Title---Add Child---
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Add Member | My Family | Mobicip")) {
			test3.pass("Add Child page - title is correct  ");
		} else {
			test3.fail("Add Child page - title isn't correct ");
		}

		// Header Elements
		waitTillLocate(webDriver, "//p[text()='Add a Member']");
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Add a Member']"));
			webDriver.findElement(By.xpath("//span[@id='headerBack']"));
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			webDriver.findElement(By.xpath("//div[@class='profile_image_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Add Child page - Header is incorrect");
		}
		if (a == true) {
			test3.pass("Add Child page - Header is correct");
		}

		// ---Navigate to Add Parent Page---
		ClickwithDelay(webDriver, "//label[@for='add_member_parent']");
		waitTillLocate(webDriver, "//p[text()='Add a Member']");

		// ---Validation---Header and Title---Add Parent---
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Add Member | My Family | Mobicip")) {
			test3.pass("Add Parent page - title is correct  ");
		} else {
			test3.fail("Add Parent page - title isn't correct ");
		}

		// Header Elements
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Add a Member']"));
			webDriver.findElement(By.xpath("//span[@id='headerBack']"));
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			webDriver.findElement(By.xpath("//div[@class='profile_image_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Add Parent page - Header is incorrect");
		}
		if (a == true) {
			test3.pass("Add Parent page - Header is correct");
		}
	}

	@Test(priority = 5)
	public void a5_childName() {
		ExtentTest test4 = extentreport.createTest("Child Name", "To check the Child Name");
		extentTest.set(test4);

		// ---Navigate to Add Child Page---
		ClickwithDelay(webDriver, "//label[@for='add_member_child']");
		waitTillLocate(webDriver, "//label[text()='Name']");

		// ---Validation---Child Name---
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Name']"));
			webDriver.findElement(By.xpath("//input[@type='text']"));
			webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Childname");
			webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Add Child page - Child Name input is improper");
		}
		if (a == true) {
			test4.pass("Add Child page - Child Name input is proper");
		}
	}

	@Test(priority = 6)
	public void a6_dateOfBirth() {
		ExtentTest test5 = extentreport.createTest("Child DOB", "To check the Child DOB");
		extentTest.set(test5);

		// ---Validation---Child Dob---
		boolean a = true;
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//label[text()='Birth Date']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']"));
			Select date = new Select(
					webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
			date.selectByValue("10");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Select month = new Select(
					webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
			month.selectByValue("6");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Select year = new Select(
					webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
			year.selectByValue("2007");
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Add Child page - Child Name input is improper");
		}
		if (a == true) {
			test5.pass("Add Child page - Child Name input is proper");
		}
	}

	@Test(priority = 7)
	public void a7_typeOfChild() {
		ExtentTest test6 = extentreport.createTest("Child Filter Level", "To check the Child FILTER Type");
		extentTest.set(test6);

		// ---Validation---Filter Type---
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Monitor and Manage']"));
			webDriver.findElement(
					By.xpath("//p[text()='Restrict content and screen time. Track app usage. Add schedules.']"));
			webDriver.findElement(By.xpath("//span[text()='Monitor only']"));
			webDriver.findElement(
					By.xpath("//p[text()='No restrictions. Track screen time usage and online activities.']"));
			webDriver.findElement(By.xpath("//label[@for='filter_monitor_and_manage']")).click();
			webDriver.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Add Child page - Filter Level input is improper");
		}
		if (a == true) {
			test6.pass("Add Child page - Filter Level input is proper");
		}
	}

	@Test(priority = 8)
	public void a8_requiredField() {
		ExtentTest test7 = extentreport.createTest("Child - Required Field",
				"To check that unable to save without enough details");
		webDriver.navigate().refresh();
		extentTest.set(test7);
		boolean a = true;

		// ---Validation---Required Field---
		// No DOB---No name---No Filter level
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//input[@type='text']/following::span[1]");
		try {
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[1]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[2]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[3]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[4]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[5]"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Add Child page - No DOB,No name,No Filter level - Not worked ");
		}
		if (a == true) {
			test7.pass("Add Child page - No DOB,No name,No Filter level -  Worked ");
		}

		// No DOB---No Filter level--only name
		a = true;
		boolean b = false;
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field'][4]");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test7.pass("Add Child page - No DOB, No Filter level -  Worked ");
		} else {
			test7.fail("Add Child page - No DOB, Filter level - Not worked ");
		}

		// No DOB---No Name---only Filter level
		a = true;
		b = false;
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		ClickwithDelay(webDriver, "//label[@for='filter_monitor_and_manage']");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//input[@type='text']/following::span[text()='Required Field'][4]");
		try {
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][3]"));
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][4]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][5]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test7.pass("Add Child page - No DOB, No Name -  Worked ");
		} else {
			test7.fail("Add Child page - No DOB,No Name - Not worked ");
		}

		// No Filter level---No Name---Only DOB
		a = true;
		b = false;
		webDriver.navigate().refresh();
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("10");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select month = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("6");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select year = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2007");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test7.pass("Add Child page - No Filter level , No Name -  Worked ");
		} else {
			test7.fail("Add Child page - No Filter level ,No Name - Not worked ");
		}

		// No Name
		a = true;
		b = false;
		webDriver.navigate().refresh();
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date1 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date1.selectByValue("10");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select month1 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month1.selectByValue("6");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select year1 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year1.selectByValue("2007");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		ClickwithDelay(webDriver, "//label[@for='filter_monitor_and_manage']");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test7.pass("Add Child page - No Name -  Worked ");
		} else {
			test7.fail("Add Child page - No Name - Not worked ");
		}

		// No Filter level
		a = true;
		b = false;
		webDriver.navigate().refresh();
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("10");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select month2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select year2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2007");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test7.pass("Add Child page - No filter level -  Worked ");
		} else {
			test7.fail("Add Child page - No filter level - Not worked ");
		}

		// No DOB
		a = true;
		b = false;
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		ClickwithDelay(webDriver, "//label[@for='filter_monitor_and_manage']");
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field'][1]");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field'][1]"));
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test7.pass("Add Child page - No Name -  Worked ");
		} else {
			test7.fail("Add Child page - No Name - Not worked ");
		}
	}

	@Test(priority = 9)
	public void a9_nameInvalid() {
		ExtentTest test8 = extentreport.createTest("Child - Name Invalid ",
				"To check that unable to save with invalid name");
		extentTest.set(test8);
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		boolean a = true;

		// Blank space
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("10");
		Select month2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		Select year2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2007");
		ClickwithDelay(webDriver, "//label[@for='filter_monitor_and_manage']");
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("           ");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test8.fail("Add Child - Invalid name - Blank space only - Accpeted ");
			a = true;
		} else {
			test8.pass("Add Child - Invalid name - Blank space only - Declined ");
		}

		// only special characters
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("!@#$%^&*({]");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']");
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test8.fail("Add Child - Invalid name - Only special characters  - Accpeted ");
			a = true;
		} else {
			test8.pass("Add Child - Invalid name - Only special characters  - Declined ");
		}

		// special characters with numbers & letters
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1234!@#$%child^&*({name]");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']");
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test8.fail("Add Child - Invalid name - Alphanumeric with special characters - Accpeted ");
			a = true;
		} else {
			test8.pass("Add Child - Invalid name - Alphanumeric with special characters - Declined ");
		}
	}

	@Test(priority = 10)
	public void b0_ageUnderOne() {
		ExtentTest test9 = extentreport.createTest("Child - Age under One Year ",
				"To check that unable to save with Age under One Year ");
		webDriver.navigate().refresh();
		extentTest.set(test9);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		boolean a = true;

		// ---Validation---
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("31");
		Select month2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("12");
		Select year2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2024");
		ClickwithDelay(webDriver, "//label[@for='filter_monitor_and_manage']");
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='filter_level_wrapper']/preceding::span[text()='Minimum 1 year old required'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test9.fail("Add Child -  Age under One Year  - error not shown ");
		} else {
			test9.pass("Add Child -  Age under One Year - Declined ");
		}
	}

	@Test(priority = 11)
	public void b1_childNamevalid() {
		ExtentTest test10 = extentreport.createTest("Child - Name Valid ",
				"To check that able to save with valid name");
		webDriver.navigate().refresh();
		extentTest.set(test10);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		boolean a = false;

		// ---Validation---
		// Only alphabets
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("10");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select month2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select year2 = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2007");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOneIs theName Of Child");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
			webDriver.findElement(
					By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = true;
		}
		if (a == false) {
			test10.fail("Add Child - Valid name - Alphabetical letters Only - Declined  ");
		} else {
			test10.pass("Add Child - valid name - Alphabetical letters Only - Accpeted ");
			a = false;
		}

		// only numerical letters
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("123456780");
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
			webDriver.findElement(
					By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = true;
		}
		if (a == false) {
			test10.fail("Add Child - Valid name - Numerical letters Only - Declined  ");
		} else {
			test10.pass("Add Child - valid name - Numerical letters Only - Accpeted ");
			a = false;
		}

		// Alpha-Numerical letters
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Child1 is the name of1234 child");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ClickwithDelay(webDriver, "//button[text()='Add']");
		waitTillLocate(webDriver, "//label[text()='Birth Date']/following::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
			webDriver.findElement(
					By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = true;
		}
		if (a == false) {
			test10.fail("Add Child - Valid name - Alpha-Numerical letters Only - Declined  ");
		} else {
			test10.pass("Add Child - valid name - Alpha-Numerical letters Only - Accpeted ");
			a = false;
		}
	}

	@Test(priority = 12)
	public void b2_saveChildProfile() {
		ExtentTest test11 = extentreport.createTest("Child - Save ", "To check that able to save with details");
		extentTest.set(test11);
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollPageTillViewOf(webDriver,
				"//p[text()='No restrictions. Track screen time usage and online activities.']");
		boolean a = true;

		// Saving a Monitor only child under age 10.
		waitTillLocate(webDriver, "//label[text()='Birth Date']//following::select[1]");
		Select date = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("1");
		Select month = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("1");
		Select year = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2020");
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("MOUnder10");
		webDriver.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		ClickwithDelay(webDriver, "//button[text()='Add']");

		/// ---validation---MOUnder10
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitTillLocate(webDriver, "//span[text()='MOU']");
		try {
			ClickwithDelay(webDriver, "//span[text()='MOU']");
		} catch (NoSuchElementException e) {
			test11.fail("Adding Monitor only child under age 10 - Unsuccessful");
			a = false;
		}
		if (a == true) {
			test11.pass("Adding Monitor only child under age 10 - Successful");
		}
		JavascriptExecutor jmou1 = (JavascriptExecutor) webDriver;
		jmou1.executeScript("window.scrollBy(0,500)");
		scrollPageTillViewOf(webDriver, "//span[text()='Delete Child']");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitTillLocate(webDriver, "//span[text()='5']");
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='5']"));
			webDriver.findElement(By.xpath("//span[text()='Monitor only']"));
			webDriver.findElement(By.xpath("//h1[text()='MOUnder10']"));
		} catch (NoSuchElementException e) {
			test11.fail("Monitor only child under age 10 - Improper Details DisplayewebDriver. ");
			a = false;
		}
		if (a == true) {
			test11.pass("Monitor only child under age 10 - Proper Details Displayed.");
		}
		a = true;
		try {
			scrollPageTillViewOf(webDriver, "//span[text()='Delete Child']");
			ClickwithDelay(webDriver, "//span[text()='Delete Child']");
			waitTillLocate(webDriver, "//p[text()='Do you want to delete the child ']");
			webDriver.findElement(By.xpath("//p[text()='Do you want to delete the child ']"));
			ClickwithDelay(webDriver, "//button[text()='Yes']");
		} catch (NoSuchElementException e) {
			test11.fail("Unable to delete MO child Below 10");
			a = false;
		}
		if (a == true) {
			test11.pass("Monitor Only child Below age 10 - Able to delete ");
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * //Saving a Monitor only child above age 10. a=true; try
		 * {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e)
		 * {e.printStackTrace();} webDriver.navigate().refresh(); try
		 * {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e)
		 * {e.printStackTrace();}
		 * scrollPageTillViewOf(webDriver,"//a[@class='icon_add']"); try
		 * {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e)
		 * {e.printStackTrace();} ClickwithDelay(webDriver,"//a[@class='icon_add']");
		 * try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e)
		 * {e.printStackTrace();} scrollPageTillViewOf(
		 * webDriver,"//p[text()='No restrictions. Track screen time usage and online activities.']"
		 * ); try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e)
		 * {e.printStackTrace();}
		 * waitTillLocate(webDriver,"//label[text()='Birth Date']//following::select[1]"
		 * ); Select date2 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[1]")));
		 * date2.selectByValue("1"); Select month2 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[2]")));
		 * month2.selectByValue("1"); Select year2 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[3]")));
		 * year2.selectByValue("2010");
		 * webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("MOAbove10"
		 * ); webDriver.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		 * ClickwithDelay(webDriver,"//button[text()='Add']");
		 * 
		 * ///---validation---MOAbove10 try {TimeUnit.SECONDS.sleep(2);} catch
		 * (InterruptedException e) {e.printStackTrace();}
		 * waitTillLocate(webDriver,"//span[text()='MOA']");
		 * scrollPageTillViewOf(webDriver,"//span[text()='MOA']"); a=true;
		 * try{ClickwithDelay(webDriver,"//span[text()='MOA']");}
		 * catch(NoSuchElementException
		 * e){test11.fail("Adding Monitor only child Above age 10 - Unsuccessful");
		 * a=false;}if(a==true){test11.
		 * pass("Adding Monitor only child Above age 10 - Successful");}
		 * scrollPageTillViewOf(webDriver,"//span[text()='Delete Child']");
		 * waitTillLocate(webDriver,"//span[text()='Monitor only']"); a=true;
		 * try{webDriver.findElement(By.xpath("//span[text()='15']"));
		 * webDriver.findElement(By.xpath("//span[text()='Monitor only']"));
		 * webDriver.findElement(By.xpath("//h1[text()='MOAbove10']"));}
		 * catch(NoSuchElementException e){test11.
		 * fail("Monitor only child Above age 10 - Improper Details Displayed. ");
		 * a=false;}if(a==true){test11.
		 * pass("Monitor only child Above age 10 - Proper Details Displayed.");}
		 * 
		 * a=true; scrollPageTillViewOf(webDriver,"//span[text()='Delete Child']"); try
		 * {ClickwithDelay(webDriver,"//span[text()='Delete Child']");
		 * waitTillLocate(webDriver,"//p[text()='Do you want to delete the child ']");
		 * webDriver.findElement(By.
		 * xpath("//p[text()='Do you want to delete the child ']"));
		 * ClickwithDelay(webDriver,"//button[text()='Yes']");}
		 * catch(NoSuchElementException
		 * e){test11.fail("Unable to delete MO child Above 10"); a=false;}
		 * if(a==true){test11.pass("Monitor Only child Above age 10 - Able to delete ");
		 * }
		 * 
		 * a=true; try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e)
		 * {e.printStackTrace();} webDriver.navigate().refresh(); try
		 * {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e)
		 * {e.printStackTrace();}
		 * scrollPageTillViewOf(webDriver,"//a[@class='icon_add']"); //Saving a Monitor
		 * and Manage child under age 10.
		 * ClickwithDelay(webDriver,"//a[@class='icon_add']"); scrollPageTillViewOf(
		 * webDriver,"//p[text()='No restrictions. Track screen time usage and online activities.']"
		 * );
		 * waitTillLocate(webDriver,"//label[text()='Birth Date']//following::select[1]"
		 * ); Select date1 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[1]")));
		 * date1.selectByValue("1"); Select month1 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[2]")));
		 * month1.selectByValue("1"); Select year1 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[3]")));
		 * year1.selectByValue("2020");
		 * webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("MMUnder10"
		 * ); ClickwithDelay(webDriver,"//label[@for='filter_monitor_and_manage']");
		 * ClickwithDelay(webDriver,"//button[text()='Add']");
		 * 
		 * ///---validation---MMUnder10 try {TimeUnit.SECONDS.sleep(2);} catch
		 * (InterruptedException e) {e.printStackTrace();}
		 * waitTillLocate(webDriver,"//span[text()='MMU']");
		 * waitTillLocate(webDriver,"//span[text()='MMU']");
		 * scrollPageTillViewOf(webDriver,"//span[text()='MMU']");
		 * waitTillLocate(webDriver,"//span[text()='MMU']");
		 * try{webDriver.findElement(By.xpath("//span[text()='MMU']"));}
		 * catch(NoSuchElementException
		 * e){test11.fail("Adding Monitor and Manage child under age 10 - Unsuccessful"
		 * ); a=false;} if(a==true){test11.
		 * pass("Adding Monitor and Manage child under age 10 - Successful");}
		 * ClickwithDelay(webDriver,"//span[text()='MMU']");
		 * scrollPageTillViewOf(webDriver,"//span[text()='Monitor and Manage']");
		 * waitTillLocate(webDriver,"//span[text()='Monitor and Manage']"); a=true;
		 * try{webDriver.findElement(By.xpath("//span[text()='5']"));
		 * webDriver.findElement(By.xpath("//span[text()='Monitor and Manage']"));
		 * webDriver.findElement(By.xpath("//h1[text()='MMUnder10']"));}
		 * catch(NoSuchElementException e){test11.
		 * fail("Monitor and Manage child under age 10 - Improper Details Displayed. ");
		 * a=false;} if(a==true){test11.
		 * pass("Monitor and Manage child under age 10 - Proper Details Displayed.");}
		 * a=true; try {ClickwithDelay(webDriver,"//span[text()='Delete Child']");
		 * waitTillLocate(webDriver,"//p[text()='Do you want to delete the child ']");
		 * webDriver.findElement(By.
		 * xpath("//p[text()='Do you want to delete the child ']"));
		 * ClickwithDelay(webDriver,"//button[text()='Yes']");}
		 * catch(NoSuchElementException
		 * e){test11.fail("Unable to delete MAM child Under 10"); a=false;}
		 * if(a==true){test11.
		 * pass("Monitor and Manage child under age 10 - Able to delete.");}
		 * 
		 * a=true; try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e)
		 * {e.printStackTrace();} webDriver.navigate().refresh(); try
		 * {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e)
		 * {e.printStackTrace();}
		 * scrollPageTillViewOf(webDriver,"//a[@class='icon_add']");
		 * ClickwithDelay(webDriver,"//a[@class='icon_add']"); waitTillLocate(
		 * webDriver,"//p[text()='No restrictions. Track screen time usage and online activities.']"
		 * ); //Saving a Monitor and Manage child Above age 10. scrollPageTillViewOf(
		 * webDriver,"//p[text()='No restrictions. Track screen time usage and online activities.']"
		 * ); try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1)
		 * {e1.printStackTrace();}
		 * waitTillLocate(webDriver,"//label[text()='Birth Date']//following::select[1]"
		 * ); Select date3 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[1]")));
		 * date3.selectByValue("1"); Select month3 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[2]")));
		 * month3.selectByValue("1"); Select year3 =new Select(webDriver.findElement(By.
		 * xpath("//label[text()='Birth Date']//following::select[3]")));
		 * year3.selectByValue("2010");
		 * webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("MMAbove10"
		 * ); ClickwithDelay(webDriver,"//label[@for='filter_monitor_and_manage']");
		 * ClickwithDelay(webDriver,"//button[text()='Add']");
		 * 
		 * ///---validation---MMAbove10 a=true; try {TimeUnit.SECONDS.sleep(2);} catch
		 * (InterruptedException e) {e.printStackTrace();}
		 * waitTillLocate(webDriver,"//span[text()='MMA']");
		 * try{ClickwithDelay(webDriver,"//span[text()='MMA']");}
		 * catch(NoSuchElementException
		 * e){test11.fail("Adding Monitor and Manage child Above age 10 - Unsuccessful"
		 * ); a=false;} if(a==true){test11.
		 * pass("Adding Monitor and Manage child Above age 10 - Successful");}
		 * JavascriptExecutor jmoa17= (JavascriptExecutor)webDriver;
		 * jmoa17.executeScript("window.scrollBy(0,500)");
		 * scrollPageTillViewOf(webDriver,"//span[text()='Delete Child']"); try
		 * {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e)
		 * {e.printStackTrace();} a=true;
		 * waitTillLocate(webDriver,"//span[text()='Monitor and Manage']");
		 * try{webDriver.findElement(By.xpath("//span[text()='15']"));
		 * webDriver.findElement(By.xpath("//span[text()='Monitor and Manage']"));
		 * webDriver.findElement(By.xpath("//h1[text()='MMAbove10']"));}
		 * catch(NoSuchElementException e){test11.
		 * fail("Monitor and Manage child Above age 10 - Improper Details Displayed. ");
		 * a=false;} if(a==true){test11.
		 * pass("Monitor and Manage child Above age 10 - Proper Details Displayed.");}
		 * a=true; try {ClickwithDelay(webDriver,"//span[text()='Delete Child']");
		 * waitTillLocate(webDriver,"//p[text()='Do you want to delete the child ']");
		 * webDriver.findElement(By.
		 * xpath("//p[text()='Do you want to delete the child ']"));
		 * ClickwithDelay(webDriver,"//button[text()='Yes']");}
		 * catch(NoSuchElementException
		 * e){test11.fail("Unable to delete MAM child Above 10"); a=false;}
		 * if(a==true){test11.
		 * pass("Monitor and Manage child Above age 10 - Able to delete.");}
		 * JavascriptExecutor jmoa19= (JavascriptExecutor)webDriver;
		 * jmoa19.executeScript("window.scrollBy(0,-500)"); try
		 * {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1)
		 * {e1.printStackTrace();}
		 */
	}

	@Test(priority = 13)
	public void b3_parentNameEmail() {
		ExtentTest test12 = extentreport.createTest("Parent - Name & Email ",
				"To check that able to enter Name & Email details");
		extentTest.set(test12);
		webDriver.navigate().refresh();
		ClickwithDelay(webDriver, "//a[@class='icon_add']");
		ClickwithDelay(webDriver, "//label[@for='add_member_parent']");
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//label[text()='Parent Name']");
		// ---Validation---Parent Name---
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Parent Name']"));
			webDriver.findElement(By.xpath("//label[text()='Email Address']//preceding::input[@type='text']"));
			webDriver.findElement(By.xpath("//label[text()='Email Address']//preceding::input[@type='text']"))
					.sendKeys("ParentName");
			webDriver.findElement(By.xpath("//label[text()='Email Address']//preceding::input[@type='text']")).clear();
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Add Parent page - Parent Name input is improper");
			a = false;
		}
		if (a == true) {
			test12.pass("Add Parent page - Parent Name input is proper");
		}
		a = true;

		// ---Validation---Parent Email---
		try {
			webDriver.findElement(By.xpath("//label[text()='Email Address']"));
			webDriver.findElement(By.xpath("//label[text()='Email Address']//following::input[@type='text']"));
			webDriver.findElement(By.xpath("//label[text()='Email Address']//following::input[@type='text']"))
					.sendKeys("ParentEmail");
			webDriver.findElement(By.xpath("//label[text()='Email Address']//following::input[@type='text']")).clear();
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Add Parent page - Parent Email input is improper");
		}
		if (a == true) {
			test12.pass("Add Parent page - Parent Email input is proper");
		}
	}

	@Test(priority = 14)
	public void b4_parentType() {
		ExtentTest test13 = extentreport.createTest("Parent - Type", "To check that able to set all type of parent ");
		extentTest.set(test13);
		webDriver.navigate().refresh();
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//label[@for='parent_role_admin']");
		scrollPageTillViewOf(webDriver, "//label[@for='parent_role_admin']");
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
			webDriver.findElement(By.xpath("//label[@for='parent_role_user']")).click();
			webDriver.findElement(By.xpath("//label[@for='parent_role_view_only']")).click();
			webDriver.findElement(By.xpath("//span[text()='Manage Parent, Child & Device Settings']"));
			webDriver.findElement(By.xpath("//span[text()='Manage Child & Device Settings']"));
			webDriver.findElement(By.xpath("//span[text()='View only & Not change anything']"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][2]"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][2]"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][4]"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][5]"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Add Parent page - Parent Type input is improper");
		}
		if (a == true) {
			test13.pass("Add Parent page - Parent Type input is proper");
		}
	}

	@Test(priority = 15)
	public void b5_parentRequiredField() {
		ExtentTest test14 = extentreport.createTest("Parent - Required Field",
				"To check that unable to save a parent without enough details");
		webDriver.navigate().refresh();
		boolean a = true;
		extentTest.set(test14);

		// ---Validation---Required Field---

		// No Email---No Name---No Type
		ClickwithDelay(webDriver, "//button[text()='Send Invite']");
		try {
			webDriver.findElement(By.xpath("//label[text()='Email Address']/preceding::span[text()='Required Field']"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Add Parent page - No Email ,No name,No Type - Not worked ");
		}
		if (a == true) {
			test14.pass("Add Parent  page - No Email ,No name,No Type - Worked ");
		}

		// No Email---No Type
		a = true;
		boolean b = false;
		webDriver.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]"))
				.sendKeys("ParentOne");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//label[text()='Email Address']/following::span[text()='Required Field'][1]");
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][3]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(By.xpath("//label[text()='Email Address']/preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page - No Email , No Type -  Worked ");
		} else {
			test14.fail("Add Parent page - No Email ,No type - Not worked ");
		}

		// No Email---No Name---only Type
		a = true;
		b = false;
		webDriver.navigate().refresh();
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		scrollPageTillViewOf(webDriver, "//label[@for='parent_role_admin']");
		ClickwithDelay(webDriver, "//label[@for='parent_role_admin']");
		ClickwithDelay(webDriver, "//button[text()='Send Invite']");
		waitTillLocate(webDriver, "//p[text()='This parent can']//preceding::span[text()='Required Field'][2]");
		try {
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][2]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page - No Email, No Name -  Worked ");
		} else {
			test14.fail("Add Parent page - No Email,No Name - Not worked ");
		}

		// No Type---No Name---Only Email
		a = true;
		b = false;
		webDriver.navigate().refresh();
		JavascriptExecutor j4 = (JavascriptExecutor) webDriver;
		j4.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		ClickwithDelay(webDriver, "//button[text()='Send Invite']");
		waitTillLocate(webDriver, "//label[text()='Email Address']//preceding::span[text()='Required Field']");
		try {
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][2]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page - No Type , No Name -  Worked ");
		} else {
			test14.fail("Add Parent page - No Type ,No Name - Not worked ");
		}

		// No Name
		a = true;
		b = false;
		webDriver.navigate().refresh();
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//label[text()='Email Address']//preceding::span[text()='Required Field']");
		try {
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']//following::span[text()='Required Field'][1]"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']//following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']//following::span[text()='Required Field'][3]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page - No Name -  Worked ");
		} else {
			test14.fail("Add Parent page - No Name - Not worked ");
		}

		// No Type
		a = true;
		b = false;
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]"))
				.sendKeys("ParentOne");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//p[text()='This parent can']//following::span[text()='Required Field'][2]");
		try {
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page -No Type -  Worked ");
		} else {
			test14.fail("Add Parent page - No Type - Not worked ");
		}

		// No Email
		a = true;
		b = false;
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j3 = (JavascriptExecutor) webDriver;
		j3.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]"))
				.sendKeys("ParentOne");
		webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//p[text()='This parent can']//preceding::span[text()='Required Field'][1]");
		try {
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][1]"));
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page - No Email -  Worked ");
		} else {
			test14.fail("Add Parent page - No Email - Not worked ");
		}

		// No Child Associate - View and User Parent
		a = true;
		b = false;
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j5 = (JavascriptExecutor) webDriver;
		j5.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]"))
				.sendKeys("ParentOne");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_user']")).click();
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//p[text()='Profile managed']//following::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page - No Child selected - User -  Worked ");
		} else {
			test14.fail("Add Parent page - No Child selected - User - Not worked ");
		}

		a = true;
		b = false;
		webDriver.findElement(By.xpath("//label[@for='parent_role_view_only']")).click();
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//p[text()='Profile managed']//following::span[text()='Required Field']");
		try {
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//following::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		try {
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//p[text()='Profile managed']//preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			b = true;
		}
		if (a == true && b == true) {
			test14.pass("Add Parent page -No Child selected - View - Worked ");
		} else {
			test14.fail("Add Parent page - No Child selected - View - Not worked ");
		}
	}

	@Test(priority = 16)
	public void b6_parentNameInvalid() {
		ExtentTest test15 = extentreport.createTest("Parent - Name Invalid ",
				"To check that unable to save a Parent with invalid name");
		extentTest.set(test15);
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		boolean a = true;

		// Blank space
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("           ");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//label[text()='Email Address']//preceding::span[text()='Required Field']");
		try {
			webDriver
					.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test15.fail("Add Parent - Invalid name - Blank space only - Accpeted ");
			a = true;
		} else {
			test15.pass("Add Parent - Invalid name - Blank space only - Declined ");
		}

		// only special characters
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).clear();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("!@#$%^&*({]");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver,
				"//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']");
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test15.fail("Add Parent - Invalid name - Only special characters  - Accpeted ");
			a = true;
		} else {
			test15.pass("Add Parent - Invalid name - Only special characters  - Declined ");
		}

		// special characters with numbers & letters
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1234!@#$%child^&*({name]");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver,
				"//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']");
		try {
			webDriver.findElement(
					By.xpath("//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test15.fail("Add Child - Invalid name - Alphanumeric with special characters - Accpeted ");
			a = true;
		} else {
			test15.pass("Add Child - Invalid name - Alphanumeric with special characters - Declined ");
		}
	}

	@Test(priority = 17)
	public void b7_parentEmailIDInvalid() {
		ExtentTest test16 = extentreport.createTest("Parent - Email Invalid ",
				"To check that unable to save a Parent with invalid Email");
		extentTest.set(test16);
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		boolean a = true;

		// parent
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("parent");
		webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentname");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//span[text()='Invalid Email: Enter a valid email address']");
		try {
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test16.fail("Add Parent - Invalid Email - Blank space only - Accpeted ");
			a = true;
		} else {
			test16.pass("Add Parent - Invalid Email - Blank space only - Declined ");
		}

		// parent1234
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).clear();
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("parent1234");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//span[text()='Invalid Email: Enter a valid email address']");
		try {
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test16.fail("Add Parent - Invalid Email - Only special characters - Accpeted ");
			a = true;
		} else {
			test16.pass("Add Parent - Invalid Email - Only special characters  - Declined ");
		}

		// @mobicip.com
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).clear();
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("@mobicip.com");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//span[text()='Invalid Email: Enter a valid email address']");
		try {
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test16.fail("Add Parent - Invalid Email - Alphanumeric with special characters - Accpeted ");
			a = true;
		} else {
			test16.pass("Add Parent - Invalid Email - Alphanumeric with special characters - Declined ");
		}

		// @mobicip.com
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).clear();
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("parent@mobicip");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//span[text()='Invalid Email: Enter a valid email address']");
		try {
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
		} catch (NoSuchElementException e) {
			a = false;
		}
		if (a == false) {
			test16.fail("Add Parent - Invalid Email - Alphanumeric with special characters - Accpeted ");
			a = true;
		} else {
			test16.pass("Add Parent - Invalid Email - Alphanumeric with special characters - Declined ");
		}
	}

	@Test(priority = 18)
	public void b8_adminParentRegistration() {
		ExtentTest test17 = extentreport.createTest("Parent - Admin registered",
				"To check that able to save a Admin Parent with Proper details");
		extentTest.set(test17);
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		boolean a = true;

		// Saving a Admin Parent
		waitTillLocate(webDriver, "//input[@name='parent_email']");
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507admin@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentAdmin");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(webDriver, "//span[text()='parentAdmin']");

		// ---validation---Admin Parent
		try {
			webDriver.findElement(By.xpath("//span[text()='parentAdmin']")).click();
		} catch (NoSuchElementException e) {
			test17.fail("Adding Admin Parent - Unsuccessful");
			a = false;
		}
		if (a == true) {
			test17.pass("Adding Admin Parent - Successful");
		}
		JavascriptExecutor j11 = (JavascriptExecutor) webDriver;
		j11.executeScript("window.scrollBy(0,1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Invited']//preceding::p[text()='parentAdmin']"));
			webDriver.findElement(By.xpath("//span[text()='Invited']"));
			webDriver.findElement(By.xpath("//span[text()='vikram+2507admin@mobicip.com']"));
			webDriver.findElement(By.xpath("//p[text()=' can']"));
			webDriver.findElement(By.xpath("//span[text()='Manage Parent, Child & Device Settings']"));
			webDriver.findElement(By.xpath("//p[text()=' can watch over']"));
			webDriver.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='ch1']"));
			webDriver.findElement(
					By.xpath("//div[@class='managed_relationship_container']//child::div[@title='jacky']"));
			webDriver.findElement(
					By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Jerry']"));
		} catch (NoSuchElementException e) {
			test17.fail("Admin Parent - Improper Details Displayed. ");
			a = false;
		}
		if (a == true) {
			test17.pass("Admin Parent - Proper Details Displayed.");
		}
		a = true;
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webDriver.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		} catch (NoSuchElementException e) {
			test17.fail("Admin Parent - Unable to delete");
			a = false;
		}
		if (a == true) {
			test17.pass("Admin Parent - Able to delete");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j12 = (JavascriptExecutor) webDriver;
		j12.executeScript("window.scrollBy(0,-1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 19)
	public void b9_userParentRegistration() {
		ExtentTest test18 = extentreport.createTest("Parent - User registered",
				"To check that able to save a User Parent with Proper details");
		extentTest.set(test18);

		// Saving a User Parent
		waitTillLocate(webDriver, "//a[@class='icon_add']");
		webDriver.findElement(By.xpath("//a[@class='icon_add']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//label[@for='add_member_parent']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507user@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_user']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentUser");
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='ch1']")).click();
		scrollPageTillViewOf(webDriver, "//span[@class='child_name' and text()='Jerry']");
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='Jerry']")).click();
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='vivo2']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean a = true;

		// ---validation---User Parent
		try {
			webDriver.findElement(By.xpath("//span[text()='parentUser']")).click();
		} catch (NoSuchElementException e) {
			test18.fail("Adding User Parent - Unsuccessful");
			a = false;
		}
		if (a == true) {
			test18.pass("Adding User Parent - Successful");
		}
		JavascriptExecutor j11 = (JavascriptExecutor) webDriver;
		j11.executeScript("window.scrollBy(0,1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Invited']//preceding::p[text()='parentUser']"));
			webDriver.findElement(By.xpath("//span[text()='Invited']"));
			webDriver.findElement(By.xpath("//span[text()='vikram+2507user@mobicip.com']"));
			webDriver.findElement(By.xpath("//p[text()=' can']"));
			webDriver.findElement(By.xpath("//span[text()='Manage Child & Device Settings']"));
			webDriver.findElement(By.xpath("//p[text()=' can watch over']"));
			webDriver.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='ch1']"));
			webDriver.findElement(
					By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Jerry']"));
			webDriver.findElement(
					By.xpath("//div[@class='managed_relationship_container']//child::div[@title='vivo2']"));
		} catch (NoSuchElementException e) {
			test18.fail("User Parent - Improper Details Displayed. ");
			a = false;
		}
		if (a == true) {
			test18.pass("User Parent - Proper Details Displayed.");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webDriver.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		} catch (NoSuchElementException e) {
			test18.fail("User Parent - Unable to delete");
			a = false;
		}
		if (a == true) {
			test18.pass("User Parent - Able to delete");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j12 = (JavascriptExecutor) webDriver;
		j12.executeScript("window.scrollBy(0,-1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 20)
	public void c0_viewParentRegistration() {
		ExtentTest test19 = extentreport.createTest("Parent - View registered",
				"To check that able to save a View Parent with Proper details");
		// Saving a View Parent
		extentTest.set(test19);
		waitTillLocate(webDriver, "//a[@class='icon_add']");
		webDriver.findElement(By.xpath("//a[@class='icon_add']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//label[@for='add_member_parent']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507view@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_view_only']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentView");
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='jacky']")).click();
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='Jerry']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean a = true;

		// ---validation---View Parent
		try {
			webDriver.findElement(By.xpath("//span[text()='parentView']")).click();
		} catch (NoSuchElementException e) {
			test19.fail("Adding View Parent - Unsuccessful");
			a = false;
		}
		if (a == true) {
			test19.pass("Adding View Parent - Successful");
		}
		JavascriptExecutor j11 = (JavascriptExecutor) webDriver;
		j11.executeScript("window.scrollBy(0,1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Invited']//preceding::p[text()='parentView']"));
			webDriver.findElement(By.xpath("//span[text()='Invited']"));
			webDriver.findElement(By.xpath("//span[text()='vikram+2507view@mobicip.com']"));
			webDriver.findElement(By.xpath("//p[text()=' can']"));
			webDriver.findElement(By.xpath("//span[text()='View only & Not change anything']"));
			webDriver.findElement(By.xpath("//p[text()=' can watch over']"));
			webDriver.findElement(
					By.xpath("//div[@class='managed_relationship_container']//child::div[@title='jacky']"));
			webDriver.findElement(
					By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Jerry']"));
		} catch (NoSuchElementException e) {
			test19.fail("View Parent - Improper Details Displayed. ");
			a = false;
		}
		if (a == true) {
			test19.pass("View Parent - Proper Details Displayed.");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webDriver.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		} catch (NoSuchElementException e) {
			test19.fail("View Parent - Unable to delete");
			a = false;
		}
		if (a == true) {
			test19.pass("View Parent - Able to delete");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.navigate().refresh();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor j12 = (JavascriptExecutor) webDriver;
		j12.executeScript("window.scrollBy(0,-1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// redirect to dashboard
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void captureconsolelogs() {
		List<String> errors = BrowserSetupClass.getConsoleErrors();
		if (!errors.isEmpty()) {
			for (String error : errors) {
				extentTest.get().log(Status.FAIL, "Console Error: " + error);
			}
		}
	}
}
