package Prelogin;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SocialMediaCase extends BrowserSetupClass {

	/*
	 * //Report setup ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\SocialMediaConnect\\SocialMediaConnect.html");
	 * extentreport.attachReporter(spark); }
	 */
	@Test(priority = 1)
	public void a1_SocialLinks() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Social media links in footer",
				"To check the Social media links of mobicip in footer");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,15000)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(
					By.xpath("//a[@class='icon_social facebook' and @href='https://www.facebook.com/mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Facebook link is not present");
		}
		if (a == true) {
			test.pass("Home page - Facebook link is present");
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//a[@class='icon_social twitter' and @href='https://www.twitter.com/mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Twitter link is not present");
		}
		if (a == true) {
			test.pass("Home page - Twitter link is present");
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By
					.xpath("//a[@class='icon_social linkedin' and @href='https://www.linkedin.com/company/mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Linkedin link is not present");
		}
		if (a == true) {
			test.pass("Home page - Linkedin link is present");
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//a[@class='icon_social instagram' and @href='https://www.instagram.com/Mobicip_onlinesafety/']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - instagram link is not present");
		}
		if (a == true) {
			test.pass("Home page - instagram link is present");
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//a[@class='icon_social youtube' and @href='https://www.youtube.com/user/mobicip/featured']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - youtube link is not present");
		}
		if (a == true) {
			test.pass("Home page - youtube link is present");
		}
	}

	@Test(priority = 2)
	public void a2_Facebook() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Facebook", "To check the Facebook link of mobicip and page details");
		extentTest.set(test);
		webDriver.getWindowHandle();
		// Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();

		// Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;

		// Click the link which opens in a new window
		webDriver
				.findElement(
						By.xpath("//a[@class='icon_social facebook' and @href='https://www.facebook.com/mobicip']"))
				.click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				webDriver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait for the new tab to finish loading content
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Mobicip - Parental Control App')]")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[contains(text(),'Mobicip - Parental Control App')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Facebook link is not opened");
		}
		if (a == true) {
			test.pass("Home page - Facebook link is opened");
		}

		// Close the tab or window
		webDriver.close();

		// Switch back to the old tab or window
		webDriver.switchTo().window(originalWindow);
	}

	@Test(priority = 3)
	public void a3_Instagram() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Instagram",
				"To check the Instagram link of mobicip and page details");
		extentTest.set(test);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.getWindowHandle();
		// Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();

		// Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;

		// Click the link which opens in a new window
		webDriver.findElement(By.xpath(
				"//a[@class='icon_social instagram' and @href='https://www.instagram.com/Mobicip_onlinesafety/']"))
				.click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				webDriver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait for the new tab to finish loading content
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='mobicip_onlinesafety']")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='mobicip_onlinesafety']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Instagram link is not opened");
		}
		if (a == true) {
			test.pass("Home page - Instagram link is opened");
		}

		// Close the tab or window
		webDriver.close();

		// Switch back to the old tab or window
		webDriver.switchTo().window(originalWindow);
	}

	@Test(priority = 4)
	public void a4_Twitter() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Twitter", "To check the Twitter link of mobicip and page details");
		extentTest.set(test);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.getWindowHandle();
		// Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();

		// Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;

		// Click the link which opens in a new window
		webDriver.findElement(By.xpath("//a[@class='icon_social twitter' and @href='https://www.twitter.com/mobicip']"))
				.click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				webDriver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait for the new tab to finish loading content
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sign in to X']")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Sign in to X']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Twitter link is not opened");
		}
		if (a == true) {
			test.pass("Home page - Twitter link is opened");
		}

		// Close the tab or window
		webDriver.close();

		// Switch back to the old tab or window
		webDriver.switchTo().window(originalWindow);
	}

	@Test(priority = 5)
	public void a5_Linkedin() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Linkedin", "To check the Linkedin link of mobicip and page details");
		extentTest.set(test);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.getWindowHandle();
		// Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();

		// Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;

		// Click the link which opens in a new window
		webDriver
				.findElement(By.xpath(
						"//a[@class='icon_social linkedin' and @href='https://www.linkedin.com/company/mobicip']"))
				.click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				webDriver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait for the new tab to finish loading content
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Mobicip')]")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[contains(text(),'Mobicip')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - linkedin link is not opened");
		}
		if (a == true) {
			test.pass("Home page - linkedin link is opened");
		}

		// Close the tab or window
		webDriver.close();

		// Switch back to the old tab or window
		webDriver.switchTo().window(originalWindow);
	}

	@Test(priority = 6)
	public void a6_Youtube() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Youtube", "To check the Youtube link of mobicip and page details");
		extentTest.set(test);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.getWindowHandle();
		// Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();

		// Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;

		// Click the link which opens in a new window
		webDriver
				.findElement(By.xpath(
						"//a[@class='icon_social youtube' and @href='https://www.youtube.com/user/mobicip/featured']"))
				.click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				webDriver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait for the new tab to finish loading content
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mobicip Parental Controls']")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Mobicip Parental Controls']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Home page - Youtube link is not opened");
		}
		if (a == true) {
			test.pass("Home page - Youtube link is opened");
		}

		// Close the tab or window
		webDriver.close();

		// Switch back to the old tab or window
		webDriver.switchTo().window(originalWindow);

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
