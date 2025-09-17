package Prelogin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
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

public class VideoPage extends BrowserSetupClass {

	@Test(priority = 1)
	public void a1_VideoPage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Video Page", "To check the Video web page title,header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		WebElement l = webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='Video']"));
		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='footer_ul']//a[text()='Video']")));
		webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='Video']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Video']")));

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Videos | Internet Safety, Digital Citizenship & Social Media | Mobicip")) {
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
		ExtentTest test1 = extentreport.createTest("section 1", "To check the Prelogin Video web page section 1");
		extentTest.set(test1);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(5);
		j.executeScript("window.scrollBy(0,-550)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='banner_video_info']/a/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Title text is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Title text is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='banner_video_info']/a/div[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Date Element is not present");
		}
		if (a == true) {
			test1.pass("Date Element is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='banner_video_info']/div/div/a[2]"));
			webDriver.findElement(By.xpath("//div[@class='banner_video_info']/div/div/a[3]"));
			webDriver.findElement(By.xpath("//div[@class='banner_video_info']/div/div/a[4]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("3 Social media icons is not present");
		}
		if (a == true) {
			test1.pass("3 Social media icons present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='banner_video_container']/a[1]/div/img"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Banner Image is not present - we can ignore if we test in staging");
		}
		if (a == true) {
			test1.pass("Banner Image is present");
		}
	}

	@Test(priority = 3)
	public void a3_addsection() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("section 1[Add box]", "To check the Prelogin Video web page Add box");
		extentTest.set(test2);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='z_top']/div/a//img"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Advertise Section is not present");
		}
		if (a == true) {
			test2.pass("Advertise Section is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='z_top']/div/a//img"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Add thumbnail not present");
		}
		if (a == true) {
			test2.pass("Add thumbnail present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='z_top']/div/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Advertise Section link redirects failed");
		}
		if (a == true) {
			test2.pass("Advertise Section link works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 4)
	public void a4_Section2() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("section 2", "To check the Prelogin Video web page section 2");
		extentTest.set(test3);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,-200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Popular Videos']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 2 - Title text is not present");
		}
		if (a == true) {
			test3.pass("Section 2 - Title text is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='videos_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Articles section not present");
		}
		if (a == true) {
			test3.pass("Articles section is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[1]"));
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Articles set 1 not present");
		}
		if (a == true) {
			test3.pass("Articles set 1 is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[3]"));
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[4]"));
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[5]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Articles set 2 not present");
		}
		if (a == true) {
			test3.pass("Articles set 2 is present");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[6]"));
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[7]"));
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[8]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Articles set 3 not present");
		}
		if (a == true) {
			test3.pass("Articles set 3 is present");
		}

		JavascriptExecutor j3 = (JavascriptExecutor) webDriver;
		j3.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[9]"));
			webDriver.findElement(By.xpath("//div[@class='videos_container']/article[10]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Articles set 4 not present");
		}
		if (a == true) {
			test3.pass("Articles set 4 is present");
		}

		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 6)
	public void a6_section3() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section 3,4", "To check the Prelogin Video web page section 3,4");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Video page - Build better is not present");
		}
		if (a == true) {
			test5.pass("Video page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Video page - Footer is not present");
		}
		if (a == true) {
			test5.pass("Video page - Footer is present");
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
