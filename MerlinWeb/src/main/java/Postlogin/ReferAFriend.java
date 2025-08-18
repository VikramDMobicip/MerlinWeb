package Postlogin;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//Please check the website to check whether its staging or Live
//Staging : https://www.webs.prgr.in/login   Live : https://www.mobicip.com/login

import Prelogin.BrowserSetupClass;

public class ReferAFriend extends BrowserSetup {

	// Delay
	public void waitTillLocate(WebDriver driver, String element) {
		new WebDriverWait(driver, Duration.ofSeconds(20))
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

//	ExtentReports extentreport;
//	ExtentSparkReporter spark ;
//	
//	@BeforeClass
//    public void beforeTest() 
//    {
//		extentreport = new ExtentReports();
//		spark = new ExtentSparkReporter("TestReports\\PostloginTest\\TestReferAFriend\\reportReferAFriend.html");
//		extentreport.attachReporter(spark);
//    }

	// Checking for the title of Refer a friend - Title page
	@Test(priority = 1)
	public void a1_ReferAFriendpage() {

		ExtentTest test = extentreport.createTest("Refer a friend - Title",
				"Verify if able to open Refer a friend page from the Menu options ");
		extentTest.set(test);

		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));

// ---Dashboard---
		String tit = webDriver.getTitle();
		if (tit.equals("Dashboard | Mobicip")) {
			test.pass("Dashboard - title is correct ");
		} else {
			test.fail("Dashboard - title isn't correct ");
		}
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Hello Vikram!']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Dashboard - Header was Incorrect");
		}
		if (a == true) {
			test.pass("Dashboard - Header was correct");
		}

		// ---Refer A Friend---
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Refer a Friend']")));

		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Commonly Asked Questions']")));

		// ---Validation - Refer a Friend ---
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Refer a Friend | Mobicip")) {
			test.pass("Refer a Friend - page opened and title is correct ");
		} else {
			test.fail("Refer a Friend - title isn't correct ");
		}
	}

	@Test(priority = 2)
	public void a2_PageComponents() {
		ExtentTest test = extentreport.createTest("Refer a friend -  Page componenets",
				"Verify if Refer a friend page has all components");
		extentTest.set(test);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='logo']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Mobicip logo is not found");
		}
		if (a == true) {
			test.pass("Mobicip logo is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Back button is not found");
		}
		if (a == true) {
			test.pass("Back button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Refer a Friend  -  Header is incorrect");
		}
		if (a == true) {
			test.pass("Refer a Friend - Header is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Profile icon is not present");
		}
		if (a == true) {
			test.pass("Profile icon is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='background_image']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Background Image is not present");
		}
		if (a == true) {
			test.pass("Background Image is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='input_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Input container is not present");
		}
		if (a == true) {
			test.pass("Input container is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='guideline']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("guideline is not present");
		}
		if (a == true) {
			test.pass("guideline is present");
		}

		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,300)");

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='faq_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("FAQ wrapper is not present");
		}
		if (a == true) {
			test.pass("FAQ wrapper is present");
		}
	}

	@Test(priority = 3)
	public void a3_Navigationtoothepages() {
		ExtentTest test = extentreport.createTest("Navigation to other pages",
				"Verify if able to navigate to other pages");
		extentTest.set(test);
		boolean a = true;
		// Mobicip logo
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//span[text()='Dashboard']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Mobicip logo is not redirects dashboard");
		}
		if (a == true) {
			test.pass("Mobicip logo is redirects dashboard properly");
		}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Unable to land on Refer a Friend page again");
		}
		if (a == true) {
			test.pass("Able to land on Refer a Friend page again");
		}
		// Back button
		a = true;
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//span[text()='Dashboard']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Back button is not redirects previous page");
		}
		if (a == true) {
			test.pass("Back button is redirects previous page properly");
		}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Unable to land on Refer a Friend page again");
		}
		if (a == true) {
			test.pass("Able to land on Refer a Friend page again");
		}
		// Help button
		a = true;
		webDriver.findElement(By.xpath("//a[@class='help_icon']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//p[text()='Support']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Help button is not redirects Help page");
		}
		if (a == true) {
			test.pass("Help button is redirects Help page properly");
		}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Unable to land on Refer a Friend page again");
		}
		if (a == true) {
			test.pass("Able to land on Refer a Friend page again");
		}
		// Notification button
		a = true;
		webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//p[text()='Notifications']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Notification button is not redirects Notification page");
		}
		if (a == true) {
			test.pass("Notification button is redirects Notification page properly");
		}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Unable to land on Refer a Friend page again");
		}
		if (a == true) {
			test.pass("Able to land on Refer a Friend page again");
		}
		// Profile pop-up : My mobicip
		a = true;
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//p[text()='My Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("My Mobicip button is not redirects My Mobicip page");
		}
		if (a == true) {
			test.pass("My Mobicip button is redirects My Mobicip page properly");
		}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Unable to land on Refer a Friend page again");
		}
		if (a == true) {
			test.pass("Able to land on Refer a Friend page again");
		}
	}

	@Test(priority = 4)
	public void a3_ReferAFriend() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Refer a Friend Page elements",
				"Verify Refer a friend Page elements");
		extentTest.set(test);
		boolean a = true;
		TimeUnit.SECONDS.sleep(3);
		try {
			webDriver.findElement(By.xpath("//p[text()='Refer Your Friends to Mobicip and Earn!']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Title is not correct");
		}
		if (a == true) {
			test.pass("Title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='background_image']//img"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Image is not present");
		}
		if (a == true) {
			test.pass("Image is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[contains(text(),'Invite your friends to Mobicip, and we')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'For every friend who makes a purchase using the referral code, you')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'$20 Amazon gift card')]"));
			webDriver.findElement(By.xpath("//li//span[text()='1']"));
			webDriver.findElement(By.xpath("//li//span[text()='2']"));
			webDriver.findElement(By.xpath("//li//span[text()='3']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("How it works content is not correct");
		}
		if (a == true) {
			test.pass("How it works content is correct");
		}

		TimeUnit.SECONDS.sleep(3);
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Q/A title is not correct");
		}
		if (a == true) {
			test.pass("Q/A title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='When will I receive my reward?']"));
			webDriver.findElement(
					By.xpath("//p[text()='Is there a limit to the number of referrals I can send your way?']"));
			webDriver.findElement(By.xpath("//p[text()='What is in it for my friend?']"));
			webDriver.findElement(By.xpath("//p[text()='Why did my friend not get a free trial?']"));
			webDriver.findElement(By.xpath(
					"//p[text()='My friend purchased Mobicip, but I did not receive my referral reward. Why?']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Questions are not correct");
		}
		if (a == true) {
			test.pass("Questions are correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()='Your $20 Amazon e-gift card will be processed after your referred friend stays active with Mobicip for 60 days. Remember, you must be an active Mobicip user yourself when we distribute the reward to qualify.']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'No. You can refer as many friends as you')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'10% referral discount')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Your friend might have signed up for Mobicip in the past. Free trials are not available to returning customers.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Either your friend did not purchase Mobicip using your referral code, or cancelled within 60 days of using the product.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Answers are not correct");
		}
		if (a == true) {
			test.pass("Answers are correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//label[contains(text(),'Enter friend') and contains(text(),'s name and email')]"));
			webDriver.findElement(By.xpath("//input[@placeholder='Name']"));
			webDriver.findElement(By.xpath("//input[@placeholder='Email']"));
			webDriver.findElement(By.xpath("//div[text()='Add another']"));
			webDriver.findElement(By.xpath("//button[text()='Send Invite']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Invite section is not correct");
		}
		if (a == true) {
			test.pass("Invite section is correct");
		}

		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 5)
	public void a4_Validation() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Refer a Friend Page - Validations",
				"Refer a friend Page validations");
		extentTest.set(test);
		boolean a = true;

		scrollPageTillViewOf(webDriver, "//button[text()='Send Invite']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Enter Name and Email']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Empty field validation failed");
		}
		if (a == true) {
			test.pass("Empty field validation passed");
		}
		TimeUnit.SECONDS.sleep(1);

		webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("");
		webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suvetha@mobicip.com");
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Enter name for email - suvetha@mobicip.com']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Empty Name field validation failed");
		}
		if (a == true) {
			test.pass("Empty Name field validation passed");
		}
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.navigate().refresh();
		TimeUnit.SECONDS.sleep(1);
		
		scrollPageTillViewOf(webDriver, "//button[text()='Send Invite']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("suvetha");
		webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("");
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Enter email for name - suvetha']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Empty Email field validation failed");
		}
		if (a == true) {
			test.pass("Empty Email field validation passed");
		}
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suvetha@mobicip.com");
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Already a Mobicip User validation failed");
		}
		if (a == true) {
			test.pass("Already a Mobicip User validation passed");
		}

		webDriver.navigate().refresh();
		
		TimeUnit.SECONDS.sleep(1);
		scrollPageTillViewOf(webDriver, "//button[text()='Send Invite']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("@");
		webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suvetha@mobicip.com");
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Invalid Name: Enter a valid name @']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Special char Name field validation failed");
		}
		if (a == true) {
			test.pass("Special char Name validation passed");
		}
		webDriver.navigate().refresh();

		TimeUnit.SECONDS.sleep(1);
		scrollPageTillViewOf(webDriver, "//button[text()='Send Invite']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("suve");
		webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suvetha@");
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(
					By.xpath("//span[text()='Invalid Email: Enter a valid email address for this name suve']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Special char Email field validation failed");
		}
		if (a == true) {
			test.pass("Special char Email validation passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().refresh();

		TimeUnit.SECONDS.sleep(1);
		
		scrollPageTillViewOf(webDriver, "//div[text()='Add another']");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		webDriver.findElement(By.xpath("//div[text()='Add another']")).click();
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//div[@class='refer_input_wrapper'][1]//input[@placeholder='Name']")).sendKeys("suve");
		webDriver.findElement(By.xpath("//div[@class='refer_input_wrapper'][1]//input[@placeholder='Email']")).sendKeys("suvetha@mobicip.com");
		webDriver.findElement(By.xpath("//div[@class='refer_input_wrapper'][2]//input[@placeholder='Name']")).sendKeys("suve");
		webDriver.findElement(By.xpath("//div[@class='refer_input_wrapper'][2]//input[@placeholder='Email']")).sendKeys("suvetha@mobicip.com");
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(
					By.xpath("//span[text()='Duplicate Emails Exist']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Duplicate Emails validation failed");
		}
		if (a == true) {
			test.pass("Duplicate Emails validation passed");
		}
		TimeUnit.SECONDS.sleep(1);
		
	}

	public void captureconsolelogs() {
		List<String> errors = BrowserSetupClass.getConsoleErrors();
		if (!errors.isEmpty()) {
			for (String error : errors) {
				extentTest.get().log(Status.FAIL, "Console Error: " + error);
			}
		}
	}

//	@AfterClass
//    public void teardown() 
//    {
//// 		d.quit();
//    	extentreport.flush();
//    }
}
