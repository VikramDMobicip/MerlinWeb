package Prelogin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReferaFriend extends BrowserSetupClass {

	/*
	 * //Report setup ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\ReferAFriendTest\\referaFriendReport.html");
	 * extentreport.attachReporter(spark); }
	 */
	@Test(priority = 1)
	public void a1_ReferaFriend() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Refer a Friend",
				"To check the Refer a Friend web page title,header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		WebElement l = webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='Refer a Friend']"));
		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='footer_ul']//a[text()='Refer a Friend']")));
		webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='Refer a Friend']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Refer A Friend & Get Rewarded!']")));

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Refer A Friend | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			Assert.fail("Page title isn't correct");
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
			Assert.fail("Pre login - Header is incorrect");
		}
		if (a == true) {
			test.pass("Pre login - Header is correct");
		}
	}

	@Test(priority = 2)
	public void a2_Section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1",
				"To check the Prelogin Refer a friend web page section 1");
		extentTest.set(test1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Refer A Friend & Get Rewarded!']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Title is not correct");
		}
		if (a == true) {
			test1.pass("Section 1 - Title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='referral_image']/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Banner image is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Banner image is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_container']/input"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Email field is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Email field is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_container']/a"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Login button is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Login button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_container']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Email field - empty response redirected failed");
		}
		if (a == true) {
			test1.pass("Email field - empty response redirected");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().refresh();

		a = true;
		webDriver.findElement(By.xpath("//input[@name='referral_login']")).sendKeys("ABC");
		TimeUnit.SECONDS.sleep(2);

		try {
			webDriver.findElement(By.xpath("//div[@class='email_container']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Email field - invalid response redirected failed");
		}
		if (a == true) {
			test1.pass("Email field - invalid response redirected");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().refresh();

		a = true;
		webDriver.findElement(By.xpath("//input[@name='referral_login']")).sendKeys("suvetha+test@mobicip.com");
		TimeUnit.SECONDS.sleep(2);

		try {
			webDriver.findElement(By.xpath("//div[@class='email_container']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Email field - valid response redirected failed");
		}
		if (a == true) {
			test1.pass("Email field - valid response redirected");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().refresh();

	}

	@Test(priority = 3)
	public void a3_Section2() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("section 2",
				"To check the Prelogin Refer a friend web page section 2");
		extentTest.set(test2);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='How It Works']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 2 - Title is not correct");
		}
		if (a == true) {
			test2.pass("Section 2 - Title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[contains(text(),'Invite your friends to Mobicip, and we') and contains(text(),'ll send a unique referral code directly to their email.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Step 1 not correct");
		}
		if (a == true) {
			test2.pass("Step 1 correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[contains(text(),'For every friend who makes a purchase using the referral code, you') and contains(text(),'ll be eligible for a referral reward.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Step 2 not correct");
		}
		if (a == true) {
			test2.pass("Step 2 correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[contains(text(),'$20 Amazon gift card')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Step 3 not correct");
		}
		if (a == true) {
			test2.pass("Step 3 correct");
		}
	}

	@Test(priority = 4)
	public void a4_Section3() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("section 3",
				"To check the Prelogin Refer a friend web page section 3");
		extentTest.set(test3);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='FAQ']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 3 - Title is not correct");
		}
		if (a == true) {
			test3.pass("Section 3 - Title is correct");
		}

		String p = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[1]/h3")).getText();
		if (p.equals("When will I receive my reward?")) {
			test3.pass("Qn 1 correct");
		} else {
			Assert.fail("Qn 1 not correct");
		}

		String q = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[1]/p")).getText();
		if (q.equals(
				"Your $20 Amazon e-gift card will be processed after your referred friend stays active with Mobicip for 60 days. Remember, you must be an active Mobicip user yourself when we distribute the reward to qualify.")) {
			test3.pass("Ans 1 correct");
		} else {
			Assert.fail("Ans 1 not correct");
		}

		String p1 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[2]/h3")).getText();
		if (p1.equals("Is there a limit to the number of referrals?")) {
			test3.pass("Qn 2 correct");
		} else {
			Assert.fail("Qn 2 not correct");
		}

		String q1 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[2]/p")).getText();
		if (q1.equals(
				"No. You can refer as many friends as you'd like. The more friends you refer, the more rewards you earn.")) {
			test3.pass("Ans 2 correct");
		} else {
			Assert.fail("Ans 2 not correct");
		}

		String p2 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[3]/h3")).getText();
		if (p2.equals("Why did my friend not get a free trial?")) {
			test3.pass("Qn 3 correct");
		} else {
			Assert.fail("Qn 3 not correct");
		}

		String q2 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[3]/p")).getText();
		if (q2.equals(
				"Your friend might have signed up for Mobicip in the past. Free trials are not available to returning customers.")) {
			test3.pass("Ans 3 correct");
		} else {
			Assert.fail("Ans 3 not correct");
		}

		String p3 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[4]/h3")).getText();
		if (p3.equals("What is in it for my friend?")) {
			test3.pass("Qn 4 correct");
		} else {
			Assert.fail("Qn 4 not correct");
		}

		String q3 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[4]/p")).getText();
		if (q3.equals("Your friend will receive a 10% referral discount on the first year's subscription.")) {
			test3.pass("Ans 4 correct");
		} else {
			Assert.fail("Ans 4 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		String p4 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[5]/h3")).getText();
		if (p4.equals("I didn't get the reward. Why?")) {
			test3.pass("Qn 5 correct");
		} else {
			Assert.fail("Qn 5 not correct");
		}

		String q4 = webDriver.findElement(By.xpath("//div[@class='questions_container']/ul/li[5]/p")).getText();
		if (q4.equals(
				"Either your friend did not purchase Mobicip using your referral code, or cancelled within 60 days of using the product.")) {
			test3.pass("Ans 5 correct");
		} else {
			Assert.fail("Ans 5 not correct");
		}

	}

	@Test(priority = 5)
	public void a5_Section4() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("section 4,5",
				"To check the Prelogin Refer a friend web page section 4,5");
		extentTest.set(test4);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Refer a friend page - Build better is not present");
		}
		if (a == true) {
			test4.pass("Refer a friend page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Refer a friend page - Footer is not present");
		}
		if (a == true) {
			test4.pass("Refer a friend page - Footer is present");
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
	 * @AfterTest public void teardown() { extentreport.flush(); }
	 */
}
