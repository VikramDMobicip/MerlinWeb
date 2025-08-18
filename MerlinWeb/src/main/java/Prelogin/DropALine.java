package Prelogin;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Please check the website to check whether its staging or Live
//Staging : https://www.webs.prgr.in   Live : https://www.mobicip.com

public class DropALine extends BrowserSetupClass {

	/*
	 * ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeSuite public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\TestDropUsALine\\reportDropUsALine.html");
	 * extentreport.attachReporter(spark); }
	 */

	// Click With Delay
	public void ClickwithDelay(WebDriver driver, String element) {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		webDriver.findElement(By.xpath(element)).click();
	}

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

	// Checking for the title of home page and support page
	@Test(priority = 1)
	public void homepage() {
		ExtentTest test = extentreport.createTest("Homepage", "Checking the title of the Support page ");
		extentTest.set(test);
		String tit = webDriver.getTitle();
		if (tit.equals("Best Parental Control App for Busy Parents | Mobicip")) {
			test.pass("Homepage title is correct");
		} else {
			Assert.fail("Homepage title is incorrect");
		}
		// support page
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[text()='Support' and @class='header_nav_anchor']")).click();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tit = webDriver.getTitle();
		if (tit.equals("Customer Support - Articles, Tutorials & FAQs | Mobicip")) {
			test.pass("Support page title is correct");
		} else {
			Assert.fail("Support page title is incorrect");
		}
	}

	// Scrolling down till "Still have questions"
	@Test(priority = 2)
	public void scroll() {
		ExtentTest test2 = extentreport.createTest("Scroll", "Scrolling down till \"Still have questions\"");
		extentTest.set(test2);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,550)", "");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test2.pass("Scrolled down till drop us line");
	}

	// Checking the heading "Still have questions?"
	@Test(priority = 3)
	public void stillhavequestions() {
		boolean a = true;
		ExtentTest test3 = extentreport.createTest("Still have questions",
				"Scrolling down till 'Still have questions'");
		extentTest.set(test3);
		try {
			webDriver.findElement(By.xpath("//h2[text()='Still Have Questions?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Still have questions? text is present");
		}
		if (a == true) {
			test3.pass("Still have questions? text is not present");
		}
	}

	// Checking whether drop us a line is clickable or not
	@Test(priority = 4)
	public void Dropusaline() {
		ExtentTest test4 = extentreport.createTest("Drop us a line",
				"Checking whether drop us a line is clickable or not");
		extentTest.set(test4);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Drop us a line']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Drop us a line element not found");
		}
		if (a == true) {
			test4.pass("Drop us a line option is clickable");
		}
	}

	// Checking whether select question label is present or not
	@Test(priority = 5)
	public void selectquestion() {
		ExtentTest test5 = extentreport.createTest("Select question");
		extentTest.set(test5);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Select Question']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Select question label not found");
		}
		if (a == true) {
			test5.pass("Select question label is present");
		}
	}

	// Checking for every option and the questions below it
	@Test(priority = 6)
	public void settingupmobicip() {
		ExtentTest test6 = extentreport.createTest("Setting up Mobicip",
				"Checking for every option and the questions below it");
		extentTest.set(test6);
		boolean a = true;
		try {
			Select s = new Select(webDriver.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Setting Up Mobicip");
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Setting Up Mobicip Element not found");
		}
		if (a == true) {
			test6.pass("Setting Up Mobicip Element is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Mobicip parental controls setup - iPhone/iPad']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question Mobicip parental controls setup - iPhone/iPad not found");
		}
		if (a == true) {
			test6.pass("Question Mobicip parental controls setup - iPhone/iPad is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='New to Mobicip? Get Started!']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question New to Mobicip? Get Started! is not found");
		}
		if (a == true) {
			test6.pass("Question New to Mobicip? Get Started! is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void requestinformation() {
		ExtentTest test6 = extentreport.createTest("Request Information", "Checking the option - Request information");
		extentTest.set(test6);
		boolean a = true;
		try {
			Select s = new Select(webDriver.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Request Information");
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Request Information Element not found");
		}
		if (a == true) {
			test6.pass("Request Information Element is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Does Mobicip offer a free trial?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question Does Mobicip offer a free trial? not found");
		}
		if (a == true) {
			test6.pass("Question Does Mobicip offer a free trial? is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Will Mobicip monitor Text Messages?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question Will Mobicip monitor Text Messages? not found");
		}
		if (a == true) {
			test6.pass(" Question Will Mobicip monitor Text Messages? is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void featurenotworking() {
		ExtentTest test6 = extentreport.createTest("Feature Not Working", "Checking the option - Feature not working");
		extentTest.set(test6);
		boolean a = true;
		try {
			Select s = new Select(webDriver.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Feature Not Working");
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Feature Not Working Element not found");
		}
		if (a == true) {
			test6.pass("Feature Not Working Element is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Why is Snapchat monitoring not available for iOS devices?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question Why is Snapchat monitoring not available for iOS devices?  not found");
		}
		if (a == true) {
			test6.pass("Question Why is Snapchat monitoring not available for iOS devices?  is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void cancelsubscription() {
		ExtentTest test6 = extentreport.createTest("Cancel My Subscription",
				"Checking the option - Cancel My Subscription");
		extentTest.set(test6);
		boolean a = true;
		try {
			Select s = new Select(webDriver.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Cancel Plan");
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Cancel My plan Element not found");
		}
		if (a == true) {
			test6.pass("Cancel My plan Element is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		a=true;
//		try{webDriver.findElement(By.xpath("//a[text()='How do I cancel my subscription?']"));}
//		catch(NoSuchElementException e){a=false;
//			test6.fail("Question How do I cancel my subscription? not found");}
//		if(a==true){test6.pass("Question How do I cancel my subscription? is found");}
//		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();} 
	}

	@Test(priority = 10)
	public void Other() {
		ExtentTest test6 = extentreport.createTest("Other", "Checking the option - Other");
		extentTest.set(test6);
		boolean a = true;
		try {
			Select s = new Select(webDriver.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Other");
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Other Element not found");
		}
		if (a == true) {
			test6.pass("Other Element is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Will Mobicip work in Incognito/Private mode?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question Will Mobicip work in Incognito/Private mode? not found");
		}
		if (a == true) {
			test6.pass("Question Will Mobicip work in Incognito/Private mode? is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//a[text()='Why is my customized setting not working on my child device?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Question Why is my customized setting not working on my child device? not found");
		}
		if (a == true) {
			test6.pass("Question Why is my customized setting not working on my child device? is found");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Scrolling till drop us a message text
	@Test(priority = 11)
	public void scroll2() {
		ExtentTest test11 = extentreport.createTest("Scroll", "Scrolling till drop us a message text");
		extentTest.set(test11);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,390)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Drop us a message']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Scrolled down isn't properly");
		}
		if (a == true) {
			test11.pass("Scrolled down is properly");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Checking for Drop us a message text
	@Test(priority = 12)
	public void dropusamessage() {
		ExtentTest test12 = extentreport.createTest("Drop us a message", "Checking for Drop us a message text");
		extentTest.set(test12);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Drop us a message']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Drop us a message label not found");
		}
		if (a == true) {
			test12.pass("Drop us a message label is present");
		}
	}

	// Checking for empty fields and its alert
	@Test(priority = 13)
	public void emptyfields() {
		ExtentTest test13 = extentreport.createTest("Empty field", "Checking for empty fields and its alert");
		extentTest.set(test13);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		scrollPageTillViewOf(webDriver,"//button[text()='Submit']");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		
		webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][1]")));
		jse.executeScript("window.scrollBy(0,-350)", "");
		boolean a = true;
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(
					By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][1]"));
			webDriver.findElement(
					By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][2]"));
			webDriver.findElement(
					By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][3]"));
			webDriver.findElement(
					By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][4]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Alert is not thrown for empty fields");
		}
		if (a == true) {
			test13.pass("Alert - Required field is properly shown");
		}
	}

	// Checking for blank spaces and its alert
	@Test(priority = 14)
	public void blankspaces() throws InterruptedException {
		ExtentTest test14 = extentreport.createTest("Blank space", "Checking for blank spaces and its alert");
		extentTest.set(test14);
		boolean a = true;
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::input[1]")).sendKeys("     ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::input[2]")).sendKeys("     ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::input[3]")).sendKeys("     ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::input[4]")).sendKeys("     ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::input[5]")).sendKeys("     ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::input[6]")).sendKeys("     ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//p[text()='Drop us a message']/following::textarea[1]")).sendKeys("     ");
		scrollPageTillViewOf(webDriver,"//button[text()='Submit']");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][5]")));
		try {
			webDriver.findElement(By.xpath(
					"//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][5]"));
			webDriver.findElement(By.xpath(
					"//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][1]"));
			webDriver.findElement(By.xpath(
					"//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][2]"));
			webDriver.findElement(By.xpath(
					"//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][3]"));
			webDriver.findElement(By.xpath(
					"//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][4]"));
			webDriver.findElement(By.xpath(
					"//p[text()='Drop us a message']/following::span[text()='Invalid Email: Enter a valid email address']"));
			webDriver.findElement(
					By.xpath("//p[text()='Drop us a message']/following::span[text()='Only numeric value accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Alert is not shown for blank spaces");
		}
		if (a == true) {
			test14.pass("Alert is shown for blank spaces");
		}
		
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);
	}

	public void captureconsolelogs() {
		List<String> errors = BrowserSetupClass.getConsoleErrors();
		if (!errors.isEmpty()) {
			for (String error : errors) {
				extentTest.get().log(Status.FAIL, "Console Error: " + error);
			}
		}
	}

	/*
	 * @AfterSuite public void teardown() { extentreport.flush();
	 * //webDriver.quit();
	 * 
	 * }
	 */

}
