package Prelogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class Footer extends BrowserSetupClass {

	@Test(priority = 1)
	public void a1_PlatformsPage() throws InterruptedException {

		ExtentTest test = extentreport.createTest("Platforms", "To check the Platforms options and respective pages");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Smart Parental Control App for Busy Parents']")));
		WebElement l = webDriver.findElement(By.xpath("//h4[text()='Platforms']"));

		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);

		// iPhone
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h4[text()='Platforms']")).click();
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='iPhone']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Platforms and iPhone option");
		}
		if (a == true) {
			test.pass("Platforms - Platforms and iPhone option");
		}
		// Title
		String tit = webDriver.getTitle();
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control app for your child's iPhone | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Parental Control App for iPhone']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - iPhone title");
		}
		if (a == true) {
			test.pass("Platforms - iPhone title");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='iPad']")));
		TimeUnit.SECONDS.sleep(1);

		// iPad
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='iPad']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - iPad option");
		}
		if (a == true) {
			test.pass("Platforms - iPad option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Best iPad Parental control app for your kid’s devices - Mobicip | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Smart iPad Parental Controls for Frazzled Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - iPad title");
		}
		if (a == true) {
			test.pass("Platforms - iPad title");
		}

		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Android']")));
		TimeUnit.SECONDS.sleep(1);

		// Android
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Android']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Android option");
		}
		if (a == true) {
			test.pass("Platforms - Android option");
		}
		// Title
		tit = webDriver.getTitle();

		if (tit.equals("Best Android Parental control app for your kid’s devices - Mobicip | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Android Parental Controls for Busy & Involved Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Android title");
		}
		if (a == true) {
			test.pass("Platforms - Android title");
		}

		// Kindle
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Kindle Fire']")));
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Kindle Fire']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Kindle option");
		}
		if (a == true) {
			test.pass("Platforms - Kindle option");
		}
		// Title
		tit = webDriver.getTitle();

		if (tit.equals("Best Parental control app for your child's Kindle Fire | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Universal Kindle Fire Parental Controls for Busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Kindle title");
		}
		if (a == true) {
			test.pass("Platforms - Kindle title");
		}

		// Chromebook
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Chromebook']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Chromebook']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Chromebook option");
		}
		if (a == true) {
			test.pass("Platforms - Chromebook option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control software for your child's ChromeBook | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Chromebook Parental Controls for Tiger Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Chromebook title");
		}
		if (a == true) {
			test.pass("Platforms - Chromebook title");
		}

		// Mac
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Mac']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Mac']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Mac option");
		}
		if (a == true) {
			test.pass("Platforms - Mac option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control app for your child's Mac & MacBook | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(
					By.xpath("//h1[text()='All-in-one Mac & MacBook Parental Controls for Busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Mac title");
		}
		if (a == true) {
			test.pass("Platforms - Mac title");
		}

		// Windows
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Windows']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Windows']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Windows option");
		}
		if (a == true) {
			test.pass("Platforms - Windows option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control software for Windows | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Smart Windows Parental Controls for Super-busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Platforms - Windows title");
		}
		if (a == true) {
			test.pass("Platforms - Windows title");
		}

	}

	@Test(priority = 2)
	public void a2_Section1() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Resources", "To check the Resources options and respective pages");
		extentTest.set(test);
		// Support
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Support']")));
		TimeUnit.SECONDS.sleep(1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h4[text()='Resources']"));
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Support']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Resources and Support option");
		}
		if (a == true) {
			test.pass("Resources - Resources and Support option");
		}
		// Title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		if (tit.equals("Customer Support - Articles, Tutorials & FAQs | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='How Can We Help You?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Support title");
		}
		if (a == true) {
			test.pass("Resources - Support title");
		}

		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Forum']")));
		TimeUnit.SECONDS.sleep(1);

		// Forum
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Forum']"));
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Forum option");
		}
		if (a == true) {
			test.pass("Resources - Forum option");
		}
		webDriver.getWindowHandle();
		// Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();

		// Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;

		// Click the link which opens in a new window
		webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Forum']"));
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (environment == 2) {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Forum']")).click();
			// Loop through until we find a new window handle
			for (String windowHandle : webDriver.getWindowHandles()) {
				if (!originalWindow.contentEquals(windowHandle)) {
					webDriver.switchTo().window(windowHandle);
					break;
				}
			}

			// Wait for the new tab to finish loading content
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Forums')]")));
			a = true;
			try {
				webDriver.findElement(By.xpath("//h1[contains(text(),'Forums')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test.fail("Forum link is not opened");
			}
			if (a == true) {
				test.pass("Forum link is opened");
			}
			// Title
			tit = webDriver.getTitle();
			if (tit.equals("Mobicip | Forums")) {
				test.pass("Page title is correct");
			} else {
				test.fail("Page title isn't correct");
			}
			// Close the tab or window
			webDriver.close();
			// Switch back to the old tab or window
			webDriver.switchTo().window(originalWindow);
		}
		TimeUnit.SECONDS.sleep(1);
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Partners']")));
		TimeUnit.SECONDS.sleep(1);

		// Partners
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Partners']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Partners option");
		}
		if (a == true) {
			test.pass("Resources - Partners option");
		}

		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Partner Programs For Affiliates, Resellers or Distributors | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Does Mobicip have a Partner Program?']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Partners title");
		}
		if (a == true) {
			test.pass("Resources - Partners title");
		}

		// School
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='School']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='School']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - School option");
		}
		if (a == true) {
			test.pass("Resources - School option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Internet Filter for Schools & Libaries | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Plug & Play Web Filter in the Cloud for Schools']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - School title");
		}
		if (a == true) {
			test.pass("Resources - School title");
		}

		// Business
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Business']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Business']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Business option");
		}
		if (a == true) {
			test.pass("Resources - Business option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Internet Filter For Business | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Reliable Web Filtering in the Cloud for Business']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Business title");
		}
		if (a == true) {
			test.pass("Resources - Business title");
		}

		// Refer A Friend
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Refer a Friend']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Refer a Friend']"))
					.click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Refer a Friend option");
		}
		if (a == true) {
			test.pass("Resources - Refer a Friend option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Refer A Friend | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Refer A Friend & Get Rewarded!']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Refer a Friend title");
		}
		if (a == true) {
			test.pass("Resources - Refer a Friend title");
		}

		// Testimonials
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Testimonials']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Testimonials']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Testimonials option");
		}
		if (a == true) {
			test.pass("Resources - Testimonials option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip Parental Control Reviews | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='What Parents Are Saying About Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Resources - Testimonials title");
		}
		if (a == true) {
			test.pass("Resources - Testimonials title");
		}
	}

	@Test(priority = 3)
	public void a3_Company() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Company", "To check the Company options and respective pages");
		extentTest.set(test);
		// About
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='About']")));
		TimeUnit.SECONDS.sleep(1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h4[text()='Company']"));
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='About']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Company and About option");
		}
		if (a == true) {
			test.pass("Company - Company and About option");
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("About Us | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='About Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - About title");
		}
		if (a == true) {
			test.pass("Company - About title");
		}

		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Blog']")));
		TimeUnit.SECONDS.sleep(1);
		// Blog
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Blog']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Blog option");
		}
		if (a == true) {
			test.pass("Company - Blog option");
		}

		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Blog | Internet Safety, Digital Citizenship & Social Media | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Blog']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Blog title");
		}
		if (a == true) {
			test.pass("Company - Blog title");
		}
		if (environment == 2) {
			// Video
			j.executeScript("arguments[0].scrollIntoView()",
					webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Video']")));
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Video']")).click();
				TimeUnit.SECONDS.sleep(1);
			} catch (NoSuchElementException e) {
				a = false;
				Assert.fail("Company - Video option");
			}
			if (a == true) {
				test.pass("Company - Video option");
			}

			// Title
			tit = webDriver.getTitle();
			System.out.println(tit);
			if (tit.equals("Videos | Internet Safety, Digital Citizenship & Social Media | Mobicip")) {
				test.pass("Page title is correct");
			} else {
				test.fail("Page title isn't correct");
			}
			// Page Header
			a = true;
			try {
				webDriver.findElement(By.xpath("//a[text()='Video']"));
			} catch (NoSuchElementException e) {
				a = false;
				Assert.fail("Company - Video title");
			}
			if (a == true) {
				test.pass("Company - Video title");
			}
		}
		// Terms
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Terms']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Terms']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Terms option");
		}
		if (a == true) {
			test.pass("Company - Terms option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Terms & Conditions | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[contains(text(),'Terms & Conditions')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Terms title");
		}
		if (a == true) {
			test.pass("Company - Terms title");
		}

		// Privacy
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Privacy']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Privacy']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Privacy option");
		}
		if (a == true) {
			test.pass("Company - Privacy option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Privacy Policy | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[contains(text(),'Privacy Policy')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Privacy title");
		}
		if (a == true) {
			test.pass("Company - Privacy title");
		}

		// Contact Us
		j.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Contact Us']")));
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']//a[text()='Contact Us']")).click();
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Contact Us option");
		}
		if (a == true) {
			test.pass("Company - Contact Us option");
		}
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Customer Support - Articles, Tutorials & FAQs | Mobicip")) {
			test.pass("Page title is correct");
		} else {
			test.fail("Page title isn't correct");
		}
		// Page Header
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Still Have Questions?')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Company - Contact Us title");
		}
		if (a == true) {
			test.pass("Company - Contact Us title");
		}
	}

	@Test(priority = 4)
	public void a4_NewsLetter() throws InterruptedException {
		ExtentTest test = extentreport.createTest("News letter", "To check the Newsletter option");
		extentTest.set(test);
		// About
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", webDriver
				.findElement(By.xpath("//div[@class='footer_section_wrapper']//h4[text()='Sign up for Newsletter']")));
		TimeUnit.SECONDS.sleep(1);
		boolean a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='footer_section_wrapper']//h4[text()='Sign up for Newsletter']"));
			webDriver.findElement(By.xpath("//input[@name='newsletter_email']"));
			webDriver.findElement(By.xpath("//span[text()='Subscribe']"));
			TimeUnit.SECONDS.sleep(1);
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("News letter options");
		}
		if (a == true) {
			test.pass("News letter options");
		}
		webDriver.findElement(By.xpath("//span[text()='Subscribe']")).click();
		TimeUnit.SECONDS.sleep(1);
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Required field shown when clicked without entry");
		}
		if (a == true) {
			test.pass("Required field shown when clicked without entry");
		}
		webDriver.findElement(By.xpath("//input[@name='newsletter_email']")).sendKeys("vikram");
		webDriver.findElement(By.xpath("//span[text()='Subscribe']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Email: Enter a valid email address']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Invalid field shown when clicked with invalid entry");
		}
		if (a == true) {
			test.pass("Invalid field shown when clicked with invalid entry");
		}
		webDriver.findElement(By.xpath("//input[@name='newsletter_email']")).clear();
		webDriver.findElement(By.xpath("//input[@name='newsletter_email']")).sendKeys("vikram+qatest@mobicip.com");
		webDriver.findElement(By.xpath("//span[text()='Subscribe']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Thanks for being part of the Mobicip Family.']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Thanks for being part of the Mobicip Family.']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Invited msg shown when clicked with valid entry");
		}
		if (a == true) {
			test.pass("Invited msg shown when clicked with valid entry");
		}
	}

}
