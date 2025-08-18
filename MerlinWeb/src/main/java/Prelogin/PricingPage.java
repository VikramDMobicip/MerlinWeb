package Prelogin;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PricingPage extends BrowserSetupClass {

	/*
	 * //Report setup ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\PricingTest\\pricingPages.html");
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
	
	
	
	@Test(priority = 1)
	public void a1_PricingPage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Pricing Page", "To check the Pricing web page title,header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pricing']")));
		webDriver.findElement(By.xpath("//a[text()='Pricing']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Mobicip Pricing']")));

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Select Pricing Plan | Mobicip Parental Control Software")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}

		// Header Elements
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='company_logo']"));
			webDriver.findElement(By.xpath("//*[text()='Features']"));
			webDriver.findElement(By.xpath("//*[text()='Pricing']"));
			webDriver.findElement(By.xpath("//*[text()='Support']"));
			webDriver.findElement(By.xpath("//*[text()='Testimonials']"));
			webDriver.findElement(By.xpath("//*[text()='Login']"));
			webDriver.findElement(By.xpath("//*[text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Pre login - Header is incorrect");
		}
		if (a == true) {
			test.pass("Pre login - Header is correct");
		}
	}

	@Test(priority = 2)
	public void a2_Section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("Lite Plan",
				"To check the Prelogin Pricing web page section 1 - Lite Plan");
		extentTest.set(test1);
		String p = webDriver.findElement(By.xpath("//h3[@class='content_subtitle']")).getText();
		if (p.equals("Choose the plan that's right for your family")) {
			test1.pass("Section 1 - Title is correct");
		} else {
			test1.fail("Section 1 - Title is not correct");
		}

		String p4 = webDriver.findElement(By.xpath("//h4[@class='content_description']")).getText();
		System.out.println(p4);
		if (p4.equals("Enjoy Premium features FREE for 7 days")) {
			test1.pass("Offer info text is correct");
		} else {
			test1.fail("Offer info text is not correct");
		}

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//li[@class='pricing_container lite unselect_plan']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Pricing 'Lite plan' card not present");
		}
		if (a == true) {
			test1.pass("Pricing 'Lite plan' card present");
		}

		String p1 = webDriver.findElement(By.xpath("//p[text()='Lite']")).getText();
		if (p1.equals("LITE")) {
			test1.pass("Title is correct");
		} else {
			test1.fail("Title is not correct");
		}

		String p2 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/div[1]/p"))
				.getText();
		System.out.println(p2);
		if (p2.equals("$2.99 /month")) {
			test1.pass("Plan rate is correct");
		} else {
			test1.fail("Plan rate is not correct");
		}

		String p3 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/p[2]"))
				.getText();
		if (p3.equals("Billed Annually")) {
			test1.pass("'Billed Annually' text is correct");
		} else {
			test1.fail("'Billed Annually' text is not correct");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Start free trial button not present");
		}
		if (a == true) {
			test1.pass("Start free trial button present");
		}

		a = true;
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/div[2]/a"))
				.click();
		try {
			webDriver.findElement(By.xpath("//h1[text()='Welcome to Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Start free trial button redirects failed");
		}
		if (a == true) {
			test1.pass("Start free trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		String f1 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[1]/p"))
				.getText();
		System.out.println(f1);
		if (f1.equals("Manage up to 5 Devices")) {
			test1.pass("'5 Managed Devices' correct");
		} else {
			test1.fail("'5 Managed Devices' not correct");
		}

		String f2 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[2]/p"))
				.getText();

		if (f2.equals("App Blocker")) {
			test1.pass("'App Blocker' correct");
		} else {
			test1.fail("'App Blocker' not correct");
		}

		String f3 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[5]/p"))
				.getText();
		System.out.println(f3);
		if (f3.equals("Screen Time Limits")) {
			test1.pass("'Screen Time Limits' correct");
		} else {
			test1.fail("'Screen Time Limits' not correct");
		}

		String f4 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[6]/p"))
				.getText();
		System.out.println(f4);
		if (f4.equals("Activity Schedules")) {
			test1.pass("'Activity Schedules' correct");
		} else {
			test1.fail("'Activity Schedules' not correct");
		}

		String f5 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[3]/p"))
				.getText();
		System.out.println(f5);
		if (f5.equals("Uninstall Protection")) {
			test1.pass("'Uninstall Protection' correct");
		} else {
			test1.fail("'Uninstall Protection' not correct");
		}

		String f6 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[7]/p"))
				.getText();
		System.out.println(f6);
		if (f6.equals("Family Locator")) {
			test1.pass("'Family Locator' correct");
		} else {
			test1.fail("'Family Locator' not correct");
		}

		String f7 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[4]/p"))
				.getText();
		if (f7.equals("Website Blocker")) {
			test1.pass("'Website Blocker' correct");
		} else {
			test1.fail("'Website Blocker' not correct");
		}

		String f8 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[8]/p"))
				.getText();
		if (f8.equals("Remotely Lock Devices")) {
			test1.pass("'Remotely Lock Devices' correct");
		} else {
			test1.fail("'Remotely Lock Devices' not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		String f9 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[10]/p"))
				.getText();
		if (f9.equals("Social Media Monitor")) {
			test1.pass("'Social Media Monitor' correct");
		} else {
			test1.fail("'Social Media Monitor' not correct");
		}

		String f10 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[11]/p"))
				.getText();
		if (f10.equals("App Timers")) {
			test1.pass("'App Timers' correct");
		} else {
			test1.fail("'App Timers' not correct");
		}

		String f11 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[3]/ul/li[12]/p"))
				.getText();
		if (f11.equals("Parenting Expert Tips")) {
			test1.pass("'Parenting Expert Advice' correct");
		} else {
			test1.fail("'Parenting Expert Advice' not correct");
		}

	}

	@Test(priority = 3)
	public void a3_Section1() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("Standard Plan",
				"To check the Prelogin Pricing web page section 1 - Standard Plan");
		extentTest.set(test2);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,-400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//li[@class='pricing_container standard unselect_plan']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Pricing 'Standard plan' card not present");
		}
		if (a == true) {
			test2.pass("Pricing 'Standard plan' card present");
		}

		String p1 = webDriver.findElement(By.xpath("//p[text()='Standard']")).getText();
		if (p1.equals("STANDARD")) {
			test2.pass("Title is correct");
		} else {
			test2.fail("Title is not correct");
		}

		String p2 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/div[1]/p"))
				.getText();
		if (p2.equals("$4.99 /month")) {
			test2.pass("Plan rate is correct");
		} else {
			test2.fail("Plan rate is not correct");
		}

		String p3 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/p[2]"))
				.getText();
		if (p3.equals("Billed Annually")) {
			test2.pass("'Billed Annually' text is correct");
		} else {
			test2.fail("'Billed Annually' text is not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Start free trial button not present");
		}
		if (a == true) {
			test2.pass("Start free trial button present");
		}

		a = true;
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/div[2]/a"))
				.click();
		try {
			webDriver.findElement(By.xpath("//h1[text()='Welcome to Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Start free trial button redirects failed");
		}
		if (a == true) {
			test2.pass("Start free trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		String f1 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[1]/p"))
				.getText();
		System.out.println(f1);
		if (f1.equals("Manage up to 10 Devices")) {
			test2.pass("'Manage up to 10 Devices' correct");
		} else {
			test2.fail("'Manage up to 10 Devices' not correct");
		}

		String f2 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[2]/p"))
				.getText();
		if (f2.equals("App Blocker")) {
			test2.pass("'App Blocker' correct");
		} else {
			test2.fail("'App Blocker' not correct");
		}

		String f3 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[5]/p"))
				.getText();
		if (f3.equals("Screen Time Limits")) {
			test2.pass("'Screen Time Limits' correct");
		} else {
			test2.fail("'Screen Time Limits' not correct");
		}

		String f4 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[6]/p"))
				.getText();
		if (f4.equals("Activity Schedules")) {
			test2.pass("'Activity Schedules' correct");
		} else {
			test2.fail("'Activity Schedules' not correct");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(2);

		String f5 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[8]/p"))
				.getText();
		if (f5.equals("Remotely Lock Devices")) {
			test2.pass("'Remotely Lock Devices' correct");
		} else {
			test2.fail("'Remotely Lock Devices' not correct");
		}

		String f6 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[7]/p"))
				.getText();
		if (f6.equals("Family Locator")) {
			test2.pass("'Family Locator' correct");
		} else {
			test2.fail("'Family Locator' not correct");
		}

		String f7 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[4]/p"))
				.getText();
		if (f7.equals("Website Blocker")) {
			test2.pass("'Website Blocker' correct");
		} else {
			test2.fail("'Website Blocker' not correct");
		}

		String f8 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[10]/p"))
				.getText();
		if (f8.equals("Social Media Monitor")) {
			test2.pass("'Social Media Monitor' correct");
		} else {
			test2.fail("'Social Media Monitor' not correct");
		}

		String f9 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[11]/p"))
				.getText();
		if (f9.equals("App Timers")) {
			test2.pass("'App Timers' correct");
		} else {
			test2.fail("'App Timers' not correct");
		}

		String f10 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[2]/ul/li[12]/p"))
				.getText();
		if (f10.equals("Parenting Expert Tips")) {
			test2.pass("'Parenting Expert Tips' correct");
		} else {
			test2.fail("'Parenting Expert Tips' not correct");
		}
	}

	@Test(priority = 4)
	public void a4_Section1() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("Premium Plan",
				"To check the Prelogin Pricing web page section 1 - Premium Plan");
		extentTest.set(test3);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,-400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Pricing 'Premium plan' card not present");
		}
		if (a == true) {
			test3.pass("Pricing 'Premium plan' card present");
		}

		/*
		 * String p = webDriver.findElement(By.xpath(
		 * "//ul[@class='pricing_wrapper']/li[3]/div[1]/p")).getText();
		 * if(p.equals("BEST VALUE")) {test3.pass("Plan tag is correct");}
		 * else{test3.fail("Plan tag is not correct");}
		 */

		String p1 = webDriver.findElement(By.xpath("//p[text()='Premium']")).getText();
		if (p1.equals("PREMIUM")) {
			test3.pass("Title is correct");
		} else {
			test3.fail("Title is not correct");
		}

		String p2 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/div[2]/p"))
				.getText();
		if (p2.equals("$7.99 /month")) {
			test3.pass("Plan rate is correct");
		} else {
			test3.fail("Plan rate is not correct");
		}

		String p3 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/p[2]"))
				.getText();
		if (p3.equals("Billed Annually")) {
			test3.pass("'Billed Annually' text is correct");
		} else {
			test3.fail("'Billed Annually' text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/div[3]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Start free trial button not present");
		}
		if (a == true) {
			test3.pass("Start free trial button present");
		}

		a = true;
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/div[3]/a"))
				.click();
		try {
			webDriver.findElement(By.xpath("//h1[text()='Welcome to Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Start free trial button redirects failed");
		}
		if (a == true) {
			test3.pass("Start free trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);

		String f1 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[1]/p"))
				.getText();
		if (f1.equals("Manage up to 20 Devices")) {
			test3.pass("'Manage up to 20 Devices' correct");
		} else {
			test3.fail("'Manage up to 20 Devices' not correct");
		}

		String f2 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[2]/p"))
				.getText();
		if (f2.equals("App Blocker")) {
			test3.pass("'App Blocker' correct");
		} else {
			test3.fail("'App Blocker' not correct");
		}

		String f3 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[5]/p"))
				.getText();
		if (f3.equals("Screen Time Limits")) {
			test3.pass("'Screen Time Limits' correct");
		} else {
			test3.fail("'Screen Time Limits' not correct");
		}

		String f4 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[6]/p"))
				.getText();
		if (f4.equals("Activity Schedules")) {
			test3.pass("'Activity Schedules' correct");
		} else {
			test3.fail("'Activity Schedules' not correct");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(2);

		String f5 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[8]/p"))
				.getText();
		if (f5.equals("Remotely Lock Devices")) {
			test3.pass("'Remotely Lock Devices' correct");
		} else {
			test3.fail("'Remotely Lock Devices' not correct");
		}

		String f6 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[10]/p"))
				.getText();
		if (f6.equals("Social Media Monitor")) {
			test3.pass("'Social Media Monitor' correct");
		} else {
			test3.fail("'Social Media Monitor' not correct");
		}

		String f7 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[7]/p"))
				.getText();
		if (f7.equals("Family Locator")) {
			test3.pass("'Family Locator' correct");
		} else {
			test3.fail("'Family Locator' not correct");
		}

		String f8 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[12]/p"))
				.getText();
		if (f8.equals("Parenting Expert Tips")) {
			test3.pass("'Parenting Expert Advice' correct");
		} else {
			test3.fail("'Parenting Expert Advice' not correct");
		}

		String f9 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[11]/p"))
				.getText();
		if (f9.equals("App Timers")) {
			test3.pass("'App Timers' correct");
		} else {
			test3.fail("'App Limits' not correct");
		}

		String f10 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[4]/p"))
				.getText();
		if (f10.equals("Website Blocker")) {
			test3.pass("'Website Blocker' correct");
		} else {
			test3.fail("'Website Blocker' not correct");
		}

		String f11 = webDriver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/section[1]/div/div/ul[1]/li[1]/ul/li[9]/p"))
				.getText();
		if (f11.equals("Activity Reports")) {
			test3.pass("'Activity Reports' correct");
		} else {
			test3.fail("'Activity Reports' not correct");
		}
	}

	@Test(priority = 5)
	public void a5_Section2() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("Section 2", "To check the Prelogin Pricing web page section 2");
		extentTest.set(test4);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='pricing_quote_img']/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Device image not present");
		}
		if (a == true) {
			test4.pass("Device image present");
		}

		String p = webDriver.findElement(By.xpath("//div[@class='pricing_quote_wrapper']/p")).getText();
		if (p.equals("Have more than 20 devices ? Get a Quote")) {
			test4.pass("Device info text is correct");
		} else {
			test4.fail("Device info text is not correct");
		}

		/*
		 * a=true; //webDriver.findElement(By.xpath("//*[@id=\"closeIcon\"]")).click();
		 * //TimeUnit.SECONDS.wait(5);
		 * webDriver.findElement(By.xpath("//a[text()='Get a Quote']")).click();
		 * TimeUnit.SECONDS.wait(5); try {
		 * webDriver.findElement(By.xpath("//h1[text()='Request Quote']")).click(); }
		 * catch(NoSuchElementException e){a=false;
		 * test4.fail("Get a Quote link redirects failed");}
		 * if(a==true){test4.pass("Get a Quote link works fine");}
		 * TimeUnit.SECONDS.sleep(2); webDriver.navigate().back();
		 * TimeUnit.SECONDS.sleep(2);
		 */

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[1]/a/div/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("1.Logo image not present");
		}
		if (a == true) {
			test4.pass("1.Logo image present");
		}

		String p1 = webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[1]/a/p")).getText();
		if (p1.equals("Mom's Choice Awards Gold Recipient")) {
			test4.pass("Logo text is correct");
		} else {
			test4.fail("Logo text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[2]/div[2]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("2.Logo image not present");
		}
		if (a == true) {
			test4.pass("2.Logo image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Certified'and text()='Secure']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Logo text is not correct");
		}
		if (a == true) {
			test4.pass("Logo text is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[3]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("3.Logo image not present");
		}
		if (a == true) {
			test4.pass("3.Logo image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Trusted'and text()='Provider']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Logo text is not correct");
		}
		if (a == true) {
			test4.pass("Logo text is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[4]/div/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("4.Logo image not present");
		}
		if (a == true) {
			test4.pass("4.Logo image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Satisfaction'and text()='Guaranteed']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Logo text is not correct");
		}
		if (a == true) {
			test4.pass("Logo text is correct");
		}

		String p2 = webDriver.findElement(By.xpath("//h3[text()='Why Parents Love Mobicip?']")).getText();
		if (p2.equals("Why Parents Love Mobicip?")) {
			test4.pass("'Why Parents Love Mobicip?' question is shown correctly");
		} else {
			test4.fail("'Why Parents Love Mobicip?' question is not shown correctly");
		}

		JavascriptExecutor j001 = (JavascriptExecutor) webDriver;
		j001.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("/html/body/div[1]/div/div/div/section[2]/div[1]/div/div/div[2]/ul/li[1]/h2"));
			webDriver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/section[2]/div[1]/div/div/div[2]/ul/li[1]/p"));
			webDriver.findElement(
					By.xpath("/html/body/div[1]/div/div/div/section[2]/div[1]/div/div/div[2]/ul/li[1]/div"));
			webDriver.findElement(
					By.xpath("/html/body/div[1]/div/div/div/section[2]/div[1]/div/div/div[2]/ul/li[2]/h2"));
			webDriver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/section[2]/div[1]/div/div/div[2]/ul/li[2]/p"));
			webDriver.findElement(
					By.xpath("/html/body/div[1]/div/div/div/section[2]/div[1]/div/div/div[2]/ul/li[2]/div"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Customer reviews are not shown");
		}
		if (a == true) {
			test4.pass("Customer reviews are shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[2]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Free Trial button is not shown");
		}
		if (a == true) {
			test4.pass("Free Trial button is shown");
		}

		JavascriptExecutor j002 = (JavascriptExecutor) webDriver;
		j002.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		String p3 = webDriver.findElement(By.xpath("//h3[text()='Secure Your Child’s Device Today']")).getText();
		if (p3.equals("Secure Your Child’s Device Today")) {
			test4.pass("'Secure Your Child’s Device Today' title is shown correctly");
		} else {
			test4.fail("'Secure Your Child’s Device Today' title is not shown correctly");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[3]/div/div/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Description is not shown");
		}
		if (a == true) {
			test4.pass("Description is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()=' Manage your child’s access to websites and apps ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Manage your child’s access to websites and apps'title is not shown");
		}
		if (a == true) {
			test4.pass("Manage your child’s access to websites and apps'title is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()='You can manage your child’s access to specific website categories on any browser on their internet-connected devices using Mobicip parental controls. You can block specific apps and websites that you don’t want your child to access. App blocking works on iPhones, iPads, Android and Kindle Fire. ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Manage your child’s access to websites and apps' content is not shown");
		}
		if (a == true) {
			test4.pass("Manage your child’s access to websites and apps' content is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='https://www.mobicip.com/assets/content/pricing/web_categories-3bf5b06fa3459859672fce9645cce2b89f68a9f52175cfb7ca28fd875737859f.png']"));
			webDriver.findElement(By.xpath(
					"//img[@src='https://www.mobicip.com/assets/content/pricing/content_restricted-a9e67114c3b07692359b429cb1c5a663d86c5af9ae3ec05aa6130fae27677133.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Manage your child’s access to websites and apps'screenshots are not shown");
		}
		if (a == true) {
			test4.pass("Manage your child’s access to websites and apps'screenshots are shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Block Websites & Apps']"));

		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Block Websites & Apps button is not shown");
		}
		if (a == true) {
			test4.pass("Block Websites & Apps button is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()=' Prevent cyberbullying and sexting ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Prevent cyberbullying and sexting' title is not shown");
		}
		if (a == true) {
			test4.pass("'Prevent cyberbullying and sexting' title is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()=' You can set timers in the Mobicip app to limit screen time spent on social media apps. Additionally, you receive alerts whenever a potentially dangerous conversation is detected on your child’s social media. Mobicip, by default, blocks all apps rated 17+ on the iOS App Store and Google Play Store, thereby reducing the likelihood of your child stumbling across dating and sexting apps. ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Prevent cyberbullying and sexting' description is not shown");
		}
		if (a == true) {
			test4.pass("'Prevent cyberbullying and sexting' decsription is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='https://www.mobicip.com/assets/content/pricing/block_apps-883b8c34ccea71d3c577826c3a753041ddfae297e7bfcdaec9bee5ffd001260c.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Prevent cyberbullying and sexting' screenshot is not shown");
		}
		if (a == true) {
			test4.pass("'Prevent cyberbullying and sexting' screenshot is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Monitor Social Media']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Monitor Social Media' button is not shown");
		}
		if (a == true) {
			test4.pass("'Monitor Social Media' button is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()=' Protect with advanced location safety ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Protect with advanced location safety' title is not shown");
		}
		if (a == true) {
			test4.pass("'Protect with advanced location safety' title is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()=' Add an extra layer of protection by setting up safe boundaries for places your child visits and receive notifications so you know they arrived safely. You can also check your child’s location using the Mobicip family map and share your live location with your loved ones.  ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Protect with advanced location safety' description is not shown");
		}
		if (a == true) {
			test4.pass("'Protect with advanced location safety' description is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='https://www.mobicip.com/assets/content/pricing/family_locator-5ff207c2492ec41d87a625cf8877d8a2e4e6a643f8a14397be72362416024297.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Protect with advanced location safety' screenshot is not shown");
		}
		if (a == true) {
			test4.pass("'Protect with advanced location safety' screenshot is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Receive Location Alerts']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Receive Location Alerts button' is not shown");
		}
		if (a == true) {
			test4.pass("'Receive Location Alerts' button is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()=' Enjoy superior customer service ']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Enjoy superior customer service' title is not shown");
		}
		if (a == true) {
			test4.pass("'Enjoy superior customer service' title is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/section[3]/div/div/div[2]/div[4]/div[2]/p"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Enjoy superior customer service' description is not shown");
		}
		if (a == true) {
			test4.pass("'Enjoy superior customer service' description is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Email Support']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("'Email Support' button is not shown");
		}
		if (a == true) {
			test4.pass("'Email Support' button is shown");
		}
	}

	@Test(priority = 6)
	public void a6_Section3() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("Section 3", "To check the Prelogin Pricing web page section 3");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,2000)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Have questions on billing and pricing?']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Section title is not correct");
		}
		if (a == true) {
			test5.pass("Section title is correct");
		}

		String q = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[1]/h3"))
				.getText();
		if (q.equals("How will you bill me?")) {
			test5.pass("Qn 1 is correct");
		} else {
			test5.fail("Qn 1 is not correct");
		}

		String p = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[1]/p"))
				.getText();
		if (p.equals(
				"If you purchased a subscription from the Mobicip website, you will be billed and charged annually. If you made an in-app purchase on iOS, you will be billed and charged through your App Store account.")) {
			test5.pass("Ans 1 is correct");
		} else {
			test5.fail("Ans 1 is not correct");
		}

		String q1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[2]/h3"))
				.getText();
		if (q1.equals("How to get started with Mobicip?")) {
			test5.pass("Qn 2 is correct");
		} else {
			test5.fail("Qn 2 is not correct");
		}

		String p1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[2]/p"))
				.getText();
		if (p1.equals(
				"First, select a plan that works for your family and sign up for an account. Mobicip will guide you through an easy setup procedure to start managing all your devices.")) {
			test5.pass("Ans 2 is correct");
		} else {
			test5.fail("Ans 2 is not correct");
		}

		String q2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[3]/h3"))
				.getText();
		if (q2.equals("Which platforms are supported by Mobicip?")) {
			test5.pass("Qn 3 is correct");
		} else {
			test5.fail("Qn 3 is not correct");
		}

		String p2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[3]/p"))
				.getText();
		if (p2.equals(
				"Mobicip provides the widest platform coverage making it easier to manage iOS, Android, Windows, Mac, Chromebooks and Kindle Fire devices.")) {
			test5.pass("Ans 3 is correct");
		} else {
			test5.fail("Ans 3 is not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		String q3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[4]/h3"))
				.getText();
		if (q3.equals("Can I cancel and get my money back?")) {
			test5.pass("Qn 4 is correct");
		} else {
			test5.fail("Qn 4 is not correct");
		}

		String p3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[4]/p"))
				.getText();
		if (p3.equals(
				"Absolutely! We have a 30-day money back guarantee if the product does not meet your expectations. Reach us at support@mobicip.com if you have any questions.")) {
			test5.pass("Ans 4 is correct");
		} else {
			test5.fail("Ans 4 is not correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[4]/p/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Support link not present");
		}
		if (a == true) {
			test5.pass("Support link present");
		}

		String q4 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[5]/h3"))
				.getText();
		if (q4.equals("How does the 7-day free trial work?")) {
			test5.pass("Qn 5 is correct");
		} else {
			test5.fail("Qn 5 is not correct");
		}

		String p4 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[5]/p"))
				.getText();
		if (p4.equals(
				"You will have access to all premium features during the free trial period. Your credit card will not be charged during this period.")) {
			test5.pass("Ans 5 is correct");
		} else {
			test5.fail("Ans 5 is not correct");
		}

		String q5 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[6]/h3"))
				.getText();
		if (q5.equals("What are the available payment options?")) {
			test5.pass("Qn 6 is correct");
		} else {
			test5.fail("Qn 6 is not correct");
		}

		String p5 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[6]/p"))
				.getText();
		if (p5.equals(
				"Online subscriptions require a Visa / Master / American Express / Discover credit card (sorry, no debit or prepaid cards). In-app subscriptions will accept the respective app store's payment method.")) {
			test5.pass("Ans 6 is correct");
		} else {
			test5.fail("Ans 6 is not correct");
		}

		JavascriptExecutor j21 = (JavascriptExecutor) webDriver;
		j21.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\"billing_pricing_section\"]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Start Free Trial button is not correct");
		}
		if (a == true) {
			test5.pass("Start Free Trial button is correct");
		}

		JavascriptExecutor j11 = (JavascriptExecutor) webDriver;
		j11.executeScript("window.scrollBy(0,2000)");
		TimeUnit.SECONDS.sleep(3);

		String h = webDriver.findElement(By.xpath("//h2[text()=' Prefer downloading from app stores?']")).getText();
		System.out.println(h);
		if (h.equals("Prefer downloading from app stores?")) {
			test5.pass("Question is correct");
		} else {
			test5.fail("Question is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='download_icon ios']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Appstore button is not shown");
		}
		if (a == true) {
			test5.pass("Appstore button is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='download_icon android']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Playstore button is not shown");
		}
		if (a == true) {
			test5.pass("Playstore button is shown");
		}

	}

	@Test(priority=7)
	public void a7_section4() throws InterruptedException
  {
	ExtentTest test6=extentreport.createTest("section 4","To check the Prelogin Pricing web page section 4");
	
	scrollPageTillViewOf(webDriver,"//button[text()='Submit']");
	try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
	
	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
	element.click();
	
	boolean a=true;
    try {webDriver.findElement(By.xpath("//div[text()='Have more questions ?']"));}
    catch(NoSuchElementException e){a=false;
    test6.fail("Pricing page - 'Have more questions' is not present");}
    if(a==true){test6.pass("Pricing page - 'Have more questions' is present");}
    
    a=true;
    try{webDriver.findElement(By.xpath("//input[@name='name']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("1.Name Required Field - Failed");}
	if(a==true){test6.pass("1.Name Required Field - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='email']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Email Required Field - Failed");}
	if(a==true){test6.pass("Email Required Field - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//textarea[@name='message']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Message Required Field - Failed");}
	if(a==true){test6.pass("Message Required Field - Displayed");}
	
	webDriver.navigate().refresh();
	TimeUnit.SECONDS.sleep(5);
	
	scrollPageTillViewOf(webDriver,"//textarea[@name='message']");
	try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
	
	webDriver.findElement(By.xpath("//input[@name='name']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	
	scrollPageTillViewOf(webDriver,"//button[text()='Submit']");
	try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
	
	WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
	element1.click();
	
	//webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
	TimeUnit.SECONDS.sleep(3);
	
	a=true;
    try{webDriver.findElement(By.xpath("//input[@name='name']/following::span[text()='Only blank space(s) not accepted']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Name Blank space validation - Failed");}
	if(a==true){test6.pass("Name Blank space validation - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Email Blank space validation - Failed");}
	if(a==true){test6.pass("Email Blank space validation - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//textarea[@name='message']/following::span[text()='Only blank space(s) not accepted']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Message Blank space validation - Failed");}
	if(a==true){test6.pass("Message Blank space validation - Displayed");}
	
	webDriver.navigate().refresh();
	TimeUnit.SECONDS.sleep(5);
	
	scrollPageTillViewOf(webDriver,"//input[@name='name']");
	try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
	
	webDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("name&");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys("suvetha@m");
	TimeUnit.SECONDS.sleep(2);
	
	scrollPageTillViewOf(webDriver,"//button[text()='Submit']");
	try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
	
	WebDriverWait wait11 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	WebElement element11 = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
	element11.click();
	
	//webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
	TimeUnit.SECONDS.sleep(3);
	
	a=true;
    try{webDriver.findElement(By.xpath("//input[@name='name']/following::span[text()='Alphanumeric characters and -_(), only accepted']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Name Special char validation - Failed");}
	if(a==true){test6.pass("Name Special char validation - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Email invalid syntax validation - Failed");}
	if(a==true){test6.pass("Email invalid syntax validation - Displayed");}
	
	webDriver.navigate().refresh();
  } 	

	@Test(priority = 8)
	public void a8_section5() throws InterruptedException {
		ExtentTest test7 = extentreport.createTest("section 5,6", "To check the Prelogin Pricing web page section 5,6");
		extentTest.set(test7);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(
					By.xpath("//h2[text()='Try Mobicip For Free. ' and text()=' No Credit Card Required']"));
			webDriver.findElement(By.xpath("//div[@class='try_free_email']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Pricing page - Build better is not present");
		}
		if (a == true) {
			test7.pass("Pricing page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Pricing page - Footer is not present");
		}
		if (a == true) {
			test7.pass("Pricing page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='company_logo']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
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
	 * @AfterTest public void teardown() { //webDriver.quit(); extentreport.flush();
	 * }
	 */

}
