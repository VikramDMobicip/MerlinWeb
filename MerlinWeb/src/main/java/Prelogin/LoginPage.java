package Prelogin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class LoginPage extends BrowserSetupClass {

	// Report setup
	// ExtentReports extentreport;
	// ExtentSparkReporter spark ;

	/*
	 * @BeforeTest public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\\\PreLoginTest\\\\LoginPage\\\\LoginPageReport.html");
	 * extentreport.attachReporter(spark); }
	 */
	@Test(priority = 1)
	public void a1_LoginPage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Login Page", "To check the login page");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='header_link login']")));
		webDriver.findElement(By.xpath("//a[@class='header_link login']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue']")));

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Login | Mobicip")) {
			test.pass("Login Page title is correct");
		} else {
			AssertJUnit.fail("Login Page title isn't correct");
		}

		// Header Elements
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='company_logo']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company Logo is not present");
		}
		if (a == true) {
			test.pass("Section 1 is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Login']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Login heading is not present");
		}
		if (a == true) {
			test.pass("Login heading is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//input[@type='text']"));
			webDriver.findElement(By.xpath("//input[@placeholder='Email']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Email field and placeholder text are not present");
		}
		if (a == true) {
			test.pass("Email field and placeholder text are present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//input[@type='password']"));
			webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
			webDriver.findElement(By.xpath("//span[@class='icon_eye']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Password field, placeholder text and mask/unmask button are not present");
		}
		if (a == true) {
			test.pass("Password field, placeholder text and mask/unmask button are present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Forgot Password?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Forgot Password is not present");
		}
		if (a == true) {
			test.pass("Forgot Password is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()=\"Don't have an account?\"]"));
			webDriver.findElement(By.xpath("//a[text()='Sign Up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("'Dont have an account?' and Sign up button are not present");
		}
		if (a == true) {
			test.pass("'Dont have an account?' and Sign up button are present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/s_illus_location-13ad654ddd97d993bfa6b78f1dc70c7b.svg']"));
			webDriver.findElement(By.xpath("//div[@class='illustration_container illustration_detail']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Slide 1 is not shown");
		}
		if (a == true) {
			test.pass("Slide 1 is shown");
		}

		a = true;

		webDriver.findElement(By.xpath("//div[@id='1']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//img[@src='//www.mobicip.com/packs/media/images/illustartion-manage-ea4b1ed9aefe734e2ff5b0cc2c94e436.svg']")));
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/illustartion-manage-ea4b1ed9aefe734e2ff5b0cc2c94e436.svg']"));
			webDriver.findElement(By.xpath("//div[@class='illustration_container illustration_detail']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Slide 2 is not shown");
		}
		if (a == true) {
			test.pass("Slide 2 is shown");
		}

		a = true;
		webDriver.findElement(By.xpath("//div[@id='2']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//img[@src='//www.mobicip.com/packs/media/images/illustartion-manage-ea4b1ed9aefe734e2ff5b0cc2c94e436.svg']")));
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/illustartion-up-to-date-1a3adcb423a33eabed3b4d6e71d90451.svg']"));
			webDriver.findElement(By.xpath("//div[@class='illustration_container illustration_detail']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Slide 3 is not shown");
		}
		if (a == true) {
			test.pass("Slide 3 is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_appstore-e0ebbfc99b685b4a2d6b1b7a4ea4fecd.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Appstore button is not present");
		}
		if (a == true) {
			test.pass("Appstore button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_playstore-33ae99d898e079561abac629ceefb3b8.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Playstore button is not present");
		}
		if (a == true) {
			test.pass("Playstore button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_mac-73c55d0fdea70f11a885445ba98ce829.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("MacOS button is not present");
		}
		if (a == true) {
			test.pass("MacOS button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_windows-d4eab1d89de23bbb2a376a0640c2ff25.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Windows button is not present");
		}
		if (a == true) {
			test.pass("Windows button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_chromebook-93e5217b4293f5e99ab275b4a5bc219b.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Chromestore button is not present");
		}
		if (a == true) {
			test.pass("Chromestore button is present");
		}

		webDriver.findElement(By.xpath("//a[@class=\"company_logo\"]")).click();
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
