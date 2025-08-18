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

public class HomePage extends BrowserSetupClass {

	/*
	 * //Report setup ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new
	 * ExtentSparkReporter("TestReports\\PreLoginTest\\HomeTest\\HomeReport.html");
	 * extentreport.attachReporter(spark); }
	 */

	@Test(priority = 1)
	public void a1_HomePage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Home Page", "To check the Home web page title,header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental Control App for Busy Parents | Mobicip")) {
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
		ExtentTest test1 = extentreport.createTest("section 1", "To check the Prelogin Home web page section 1");
		extentTest.set(test1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Smart Parental Control App for Busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Section 1 - Main title text is not correct");
		}
		if (a == true) {
			test1.pass("Section 1 - Main title text is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Your Peace of Mind Matters']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Sub title is not correct");
		}
		if (a == true) {
			test1.pass("Sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//*[text()='Limit screen time, filter internet, monitor social media, track location, and more.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Description is not correct");
		}
		if (a == true) {
			test1.pass("Description is correct");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[text()='Mobicip is a proud recipient of']"));
			if (environment == 2) {
			webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/shared/awards/family_choice_award-ac412834daa0e18ade33fa97b27293f9f01bf0eb64fa767202b571120bf84b0f.png']"));
			}
			webDriver.findElement(By.xpath("//div[text()='Family Choice Award']"));
			if (environment == 2) {
			webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/shared/awards/mom_s_choice_award-3c5590085930b7a7017f4af4fdc9b4c674e9e108a3f058d25e686512b1422e8c.png']"));
			}
			webDriver.findElement(By.xpath("//div[text()='Mom’s Choice Award']"));
			if (environment == 2) {
			webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/shared/awards/bbb_award-0c8d85c8633138761dffb0cb00204cb9e05c524a91c260ac8e14cdb95beb0389.png']"));
			}
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Awards section is not correct");
		}
		if (a == true) {
			test1.pass("Awards section is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='banner_content_container']/div[3]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Start free trial button not present");
		}
		if (a == true) {
			test1.pass("Start free trial button present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='banner_content_container']/div[3]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Start free trial button redirects failed");
		}
		if (a == true) {
			test1.pass("Start Free Trial  button redirects to pricing page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='product_icons_container']/figure[1]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_container']/figure[2]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_container']/figure[3]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_container']/figure[4]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_container']/figure[5]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_container']/figure[6]"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("All Platforms icon not present");
		}
		if (a == true) {
			test1.pass("All Platforms icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Protects iOS, Android, macOS, Windows, Chromebook & Kindle']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("All Platforms text not correct");
		}
		if (a == true) {
			test1.pass("All Platforms text correct");
		}

	}

	@Test(priority = 3)
	public void a3_Section2() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("section 2", "Protect Your Family from Big Tech s Influence");
		extentTest.set(test2);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,350)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[contains(text(),'Protect Your Family from Big Tech')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Section 2 - Title text is not correct");
		}
		if (a == true) {
			test2.pass("Section 2 - Title text is correct");
		}

		String li1 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[1]/a/span[2]"))
				.getText();
		if (li1.equals("Limit")) {
			test2.pass("1.Limit title is correct");
		} else {
			test2.fail("1.Limit title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[1]/a/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Icon is not present");
		}
		if (a == true) {
			test2.pass("Icon is present");
		}

		String li11 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[1]/a/p")).getText();
		if (li11.equals("Decide how and when your child can access videos, games & social media")) {
			test2.pass("Description is correct");
		} else {
			test2.fail("Description is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[1]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Limit link redirects failed");
		}
		if (a == true) {
			test2.pass("Limit link redirects works fine");
		}
		TimeUnit.SECONDS.sleep(3);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-1400)");
		TimeUnit.SECONDS.sleep(3);

		String li2 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[2]/a/span[2]"))
				.getText();
		if (li2.equals("Protect")) {
			test2.pass("2.Protect title is correct");
		} else {
			test2.fail("2.Protect title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[2]/a/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Icon is not present");
		}
		if (a == true) {
			test2.pass("Icon is present");
		}

		String li21 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[2]/a/p")).getText();
		if (li21.equals("Block harmful content on the web and in apps")) {
			test2.pass("Description is correct");
		} else {
			test2.fail("Description is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[2]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Protect link redirects failed");
		}
		if (a == true) {
			test2.pass("Protect link redirects works fine");
		}
		TimeUnit.SECONDS.sleep(3);

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,-2200)");
		TimeUnit.SECONDS.sleep(3);

		String li3 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[3]/a/span[2]"))
				.getText();
		if (li3.equals("Monitor")) {
			test2.pass("3.Monitor title is correct");
		} else {
			test2.fail("3.Monitor title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[3]/a/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Icon is not present");
		}
		if (a == true) {
			test2.pass("Icon is present");
		}

		String li31 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[3]/a/p")).getText();
		if (li31.equals("Monitor online activity and track location to prevent risky behaviors")) {
			test2.pass("Description is correct");
		} else {
			test2.fail("Description is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[3]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Monitor link redirects failed");
		}
		if (a == true) {
			test2.pass("Monitor link redirects works fine");
		}
		TimeUnit.SECONDS.sleep(3);

		JavascriptExecutor j3 = (JavascriptExecutor) webDriver;
		j3.executeScript("window.scrollBy(0,-2900)");
		TimeUnit.SECONDS.sleep(3);

		String li4 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[4]/a/span[2]"))
				.getText();
		if (li4.equals("Collaborate")) {
			test2.pass("4.Collaborate title is correct");
		} else {
			test2.fail("4.Collaborate title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[4]/a/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Icon is not present");
		}
		if (a == true) {
			test2.pass("Icon is present");
		}

		String li41 = webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[4]/a/p")).getText();
		if (li41.equals("Motivate your child with achievable goals to improve self-esteem")) {
			test2.pass("Description is correct");
		} else {
			test2.fail("Description is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='home_main_feature_wrapper']/li[4]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Collaborate link redirects failed");
		}
		if (a == true) {
			test2.pass("Collaborate link redirects works fine");
		}
		TimeUnit.SECONDS.sleep(3);

		JavascriptExecutor j4 = (JavascriptExecutor) webDriver;
		j4.executeScript("window.scrollBy(0,-3300)");
		TimeUnit.SECONDS.sleep(3);
	}

	@Test(priority = 4)
	public void a4_Section3() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("section 3", "To check the Prelogin Home web page section 3");
		extentTest.set(test3);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='More Than 2 Million Parents Love Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Section 3 - Title text is not correct");
		}
		if (a == true) {
			test3.pass("Section 3 - Title text is correct");
		}

		String li1 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/p")).getText();
		if (li1.contains("It's a great app for kids."))
			;
		else {
			test3.fail("1. Quote is not correct");
		}

		String li11 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/div/div/p"))
				.getText();
		if (li11.equals("Mobicip Dad, California")) {
			test3.pass("Name text is correct");
		} else {
			test3.fail("Name text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/div/div/div[@class='rating_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Rating icon is not present");
		}
		if (a == true) {
			test3.pass("Rating icon is present");
		}

		String li2 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/p")).getText();
		if (li2.contains("While Microsoft Family")) {
			test3.pass("2. Quote is correct");
		} else {
			test3.fail("2. Quote is not correct");
		}

		String li21 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/div/div/p"))
				.getText();
		if (li21.equals("Mobicip Mom, North Carolina")) {
			test3.pass("Name text is correct");
		} else {
			test3.fail("Name text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/div/div/div[@class='rating_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Rating icon is not present");
		}
		if (a == true) {
			test3.pass("Rating icon is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='left_quotation']/span"));
			webDriver.findElement(By.xpath("//div[@class='right_quotation']/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Open,Close Quotes Icon not present");
		}
		if (a == true) {
			test3.pass("Open,Close Quotes Icon present");
		}
	}

	@Test(priority = 5)
	public void a5_Section4() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("section 4", "To check the Prelogin Home web page section 4");
		extentTest.set(test4);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Featured on']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Section 4 - Title text is not correct");
		}
		if (a == true) {
			test4.pass("Section 4 - Title text is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[1]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("1.CNN Review - Image not present");
		}
		if (a == true) {
			test4.pass("1.CNN Review - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[2]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("2.TopTen Review - Image not present");
		}
		if (a == true) {
			test4.pass("2.TopTen Review - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[3]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("3.Eyewitness News - Image not present");
		}
		if (a == true) {
			test4.pass("3.Eyewitness News - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[4]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("4.Today - Image not present");
		}
		if (a == true) {
			test4.pass("4.Today - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[5]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("5.The New York Times - Image not present");
		}
		if (a == true) {
			test4.pass("5.The New York Times - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[6]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("6.PC - Image not present");
		}
		if (a == true) {
			test4.pass("6.PC - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[7]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("7.Tech Radar - Image not present");
		}
		if (a == true) {
			test4.pass("7.Tech Radar - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='home_logo_wrapper']/div[8]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("8.Fox43 - Image not present");
		}
		if (a == true) {
			test4.pass("8.Fox43 - Image present");
		}
	}

	@Test(priority = 6)
	public void a6_Section5() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section 5 - Limit",
				"To check the Prelogin Home web page section 5");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(5);

		String l1 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/span"))
				.getText();
		if (l1.equals("Limit")) {
			test5.pass("1. Limit tag is correct");
		} else {
			test5.fail("1. Limit tag is not correct");
		}

		String l2 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/h2"))
				.getText();
		if (l2.equals("Effectively manage screen addiction with healthy limits")) {
			test5.pass("Title is correct");
		} else {
			test5.fail("Title is not correct");
		}

		String l3 = webDriver.findElement(By
				.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[1]/a/h3/span"))
				.getText();
		if (l3.equals("Screen Time")) {
			test5.pass("1.Screen time - title is correct");
		} else {
			test5.fail("1.Screen time - title is not correct");
		}

		String l4 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[1]"))
				.getText();
		if (l4.equals("Set daily screen time within healthy limits for your children.")) {
			test5.pass("Description is correct");
		} else {
			test5.fail("Description is not correct");
		}

		String l5 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[2]/span"))
				.getText();
		if (l5.equals("Learn More")) {
			test5.pass("Learn more is present");
		} else {
			test5.fail("Learn more is not present");
		}

		boolean a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[1]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Learn more link fails");
		}
		if (a == true) {
			test5.pass("Learn more redirects to Screen time page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);

		String l6 = webDriver.findElement(By
				.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[2]/a/h3/span"))
				.getText();
		if (l6.equals("App Limits")) {
			test5.pass("2.Applimits - title is correct");
		} else {
			test5.fail("2.Applimits - title is correct");
		}

		String l7 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[1]"))
				.getText();
		if (l7.equals("Limit the time spent every day on social media, games and videos.")) {
			test5.pass("Description is correct");
		} else {
			test5.fail("Description is not correct");
		}

		String l8 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[2]/span"))
				.getText();
		if (l8.equals("Learn More")) {
			test5.pass("Learn more is present");
		} else {
			test5.fail("Learn more is not present");
		}

		a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[2]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Learn more link fails");
		}
		if (a == true) {
			test5.pass("Learn more redirects to Applimits page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);

		String l9 = webDriver.findElement(By
				.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[3]/a/h3/span"))
				.getText();
		if (l9.equals("Schedules")) {
			test5.pass("3.Schedules - title is correct");
		} else {
			test5.fail("3.Schedules - title is correct");
		}

		String l10 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[3]/a/p[1]"))
				.getText();
		if (l10.equals("Create customized schedules for activities with access to specific apps and websites.")) {
			test5.pass("Description is correct");
		} else {
			test5.fail("Description is not correct");
		}

		String l11 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[3]/a/p[2]/span"))
				.getText();
		if (l11.equals("Learn More")) {
			test5.pass("Learn more is present");
		} else {
			test5.fail("Learn more is not present");
		}

		a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[1]/ul/li[3]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Learn more link fails");
		}
		if (a == true) {
			test5.pass("Learn more redirects to Schedules page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver
					.findElement(By.xpath("//div[@class='home_feature_wrapper limit right_image']/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Background Image not present");
		}
		if (a == true) {
			test5.pass("Background Image present");
		}

		a = true;
		try {
			webDriver
					.findElement(By.xpath("//div[@class='home_feature_wrapper limit right_image']/div/div[2]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("All 3 features image not present");
		}
		if (a == true) {
			test5.pass("All 3 features image present");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Start freetrial button not present");
		}
		if (a == true) {
			test5.pass("Start freetrial button present");
		}
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver
					.findElement(
							By.xpath("//div[@class='home_feature_wrapper limit right_image']/ul/li/div[1]/div[2]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Start freetrial link fails");
		}
		if (a == true) {
			test5.pass("Start freetrial link redirects to pricing page");
		}
		TimeUnit.SECONDS.sleep(3);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 7)
	public void a7_Section5() throws InterruptedException {
		ExtentTest test6 = extentreport.createTest("section 5 - Protect",
				"To check the Prelogin Home web page section 5");
		extentTest.set(test6);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(5);

		String l1 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/span"))
				.getText();
		if (l1.equals("Protect")) {
			test6.pass("2. Protect tag is correct");
		} else {
			test6.fail("2. Protect tag is not correct");
		}

		String l2 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/h2"))
				.getText();
		if (l2.equals("AI-based parental control that fights Big Tech")) {
			test6.pass("Title is correct");
		} else {
			test6.fail("Title is not correct");
		}

		String l3 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[1]/a/h3/span"))
				.getText();
		if (l3.equals("Internet Filter")) {
			test6.pass("1.Internet filter - title is correct");
		} else {
			test6.fail("1.Internet filter - title is not correct");
		}

		String l4 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[1]"))
				.getText();
		if (l4.equals("Keep your family's browsing safe & block adult websites with the most powerful web filter.")) {
			test6.pass("Description is correct");
		} else {
			test6.fail("Description is not correct");
		}

		String l5 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[2]/span"))
				.getText();
		if (l5.equals("Learn More")) {
			test6.pass("Learn more is present");
		} else {
			test6.fail("Learn more is not present");
		}

		boolean a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[1]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Learn more link fails");
		}
		if (a == true) {
			test6.pass("Learn more redirects to Internet filter page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);

		String l6 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[2]/a/h3/span"))
				.getText();
		if (l6.equals("App Blocker")) {
			test6.pass("2.AppBlocker - title is correct");
		} else {
			test6.fail("2.AppBlocker - title is not correct");
		}

		String l7 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[1]"))
				.getText();
		if (l7.equals("Block apps in social media, games, video and other categories.")) {
			test6.pass("Description is correct");
		} else {
			test6.fail("Description is not correct");
		}

		String l8 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[2]/span"))
				.getText();
		if (l8.equals("Learn More")) {
			test6.pass("Learn more is present");
		} else {
			test6.fail("Learn more is not present");
		}

//		a=true;
//		try {webDriver.findElement(By.xpath("//div[@class='home_feature_wrapper protect left_image']/ul/li/div[1]/div[1]/ul/li[2]/a")).click();}
//		catch(NoSuchElementException e){a=false;
//		test6.fail("Learn more link fails");}
//		if(a==true){test6.pass("Learn more redirects to AppBlocker page");}
//		TimeUnit.SECONDS.sleep(2);
//		webDriver.navigate().back();
//		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper protect left_image']/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Background Image not present");
		}
		if (a == true) {
			test6.pass("Background Image present");
		}

	}

	@Test(priority = 8)
	public void a8_Section5() throws InterruptedException {
		ExtentTest test7 = extentreport.createTest("section 5 - Monitor",
				"To check the Prelogin Home web page section 5");
		extentTest.set(test7);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(5);

		String l1 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/span"))
				.getText();
		if (l1.equals("Monitor")) {
			test7.pass("1. Monitor tag is correct");
		} else {
			test7.fail("1. Monitor tag is not correct");
		}

		String l2 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/h2"))
				.getText();
		if (l2.equals("Monitor online habits & intervene when alerted")) {
			test7.pass("Title is correct");
		} else {
			test7.fail("Title is not correct");
		}

		String l3 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[1]/a/h3/span"))
				.getText();
		if (l3.equals("Social Media")) {
			test7.pass("1.Social Media - title is correct");
		} else {
			test7.fail("1.Social Media - title is not correct");
		}

		String l4 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[1]"))
				.getText();
		if (l4.equals("Mobicip proactively monitors social media for harmful content.")) {
			test7.pass("Description is correct");
		} else {
			test7.fail("Description is not correct");
		}

		String l5 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[2]/span"))
				.getText();
		if (l5.equals("Learn More")) {
			test7.pass("Learn more is present");
		} else {
			test7.fail("Learn more is not present");
		}

		boolean a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[1]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Learn more link fails");
		}
		if (a == true) {
			test7.pass("Learn more redirects to Social media page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);

		String l6 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[2]/a/h3/span"))
				.getText();
		if (l6.equals("Family Locator")) {
			test7.pass("2.Family Locator - title is correct");
		} else {
			test7.fail("2.Family Locator - title is correct");
		}

		String l7 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[1]"))
				.getText();
		if (l7.equals(
				"View live location. Create geofences to know when your child enters & leaves from frequented spots.")) {
			test7.pass("Description is correct");
		} else {
			test7.fail("Description is not correct");
		}

		String l8 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[2]/span"))
				.getText();
		if (l8.equals("Learn More")) {
			test7.pass("Learn more is present");
		} else {
			test7.fail("Learn more is not present");
		}

		a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[2]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Learn more link fails");
		}
		if (a == true) {
			test7.pass("Learn more redirects to Family locator page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);

		String l9 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[3]/a/h3/span"))
				.getText();
		if (l9.equals("Activity Summary")) {
			test7.pass("3.Activity Summary - title is correct");
		} else {
			test7.fail("3.Activity Summary - title is correct");
		}

		String l10 = webDriver
				.findElement(By.xpath(
						"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[3]/a/p[1]"))
				.getText();
		if (l10.equals("Keep track of how your children spend their time online.")) {
			test7.pass("Description is correct");
		} else {
			test7.fail("Description is not correct");
		}

		String l11 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[3]/a/p[2]/span"))
				.getText();
		if (l11.equals("Learn More")) {
			test7.pass("Learn more is present");
		} else {
			test7.fail("Learn more is not present");
		}

		a = true;
		try {
			webDriver
					.findElement(By.xpath(
							"//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[1]/ul/li[3]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Learn more link fails");
		}
		if (a == true) {
			test7.pass("Learn more redirects to Activity summary page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper monitor right_image']/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Background Image not present");
		}
		if (a == true) {
			test7.pass("Background Image present");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper monitor right_image']/div/div[2]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("All 3 features image not present");
		}
		if (a == true) {
			test7.pass("All 3 features image present");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Start freetrial button not present");
		}
		if (a == true) {
			test7.pass("Start freetrial button present");
		}
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver
					.findElement(
							By.xpath("//div[@class='home_feature_wrapper monitor right_image']/ul/li/div[1]/div[2]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Start freetrial link fails");
		}
		if (a == true) {
			test7.pass("Start freetrial link redirects to pricing page");
		}
		TimeUnit.SECONDS.sleep(3);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 9)
	public void a9_Section5() throws InterruptedException {
		ExtentTest test8 = extentreport.createTest("section 5 - Collaborate",
				"To check the Prelogin Home web page section 5");
		extentTest.set(test8);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(5);

		String l1 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/span"))
				.getText();
		if (l1.equals("Collaborate")) {
			test8.pass("4. Collaborate tag is correct");
		} else {
			test8.fail("4. Collaborate tag is not correct");
		}

		String l2 = webDriver
				.findElement(By.xpath("//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/h2"))
				.getText();
		if (l2.equals("Collaborate with your children and parenting partners")) {
			test8.pass("Title is correct");
		} else {
			test8.fail("Title is not correct");
		}

		String l3 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[1]/a/h3/span"))
				.getText();
		if (l3.equals("Child Dashboard")) {
			test8.pass("1.Child Dashboard - title is correct");
		} else {
			test8.fail("1.Child Dashboard - title is not correct");
		}

		String l4 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[1]"))
				.getText();
		if (l4.equals("Let your child keep an eye on their screen time usage and learn self regulation.")) {
			test8.pass("Description is correct");
		} else {
			test8.fail("Description is not correct");
		}

		String l5 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[1]/a/p[2]/span"))
				.getText();
		if (l5.equals("Learn More")) {
			test8.pass("Learn more is present");
		} else {
			test8.fail("Learn more is not present");
		}

		boolean a = true;
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[1]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Learn more link fails");
		}
		if (a == true) {
			test8.pass("Learn more redirects to collaboration page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);

		String l6 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[2]/a/h3/span"))
				.getText();
		if (l6.equals("Guardians")) {
			test8.pass("2.Guardians - title is correct");
		} else {
			test8.fail("2.Guardians - title is not correct");
		}

		String l7 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[1]"))
				.getText();
		if (l7.equals(
				"Share your digital parenting responsibilities with trusted others among your family and friends.")) {
			test8.pass("Description is correct");
		} else {
			test8.fail("Description is not correct");
		}

		String l8 = webDriver.findElement(By.xpath(
				"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[2]/a/p[2]/span"))
				.getText();
		if (l8.equals("Learn More")) {
			test8.pass("Learn more is present");
		} else {
			test8.fail("Learn more is not present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[1]/ul/li[2]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Learn more link fails");
		}
		if (a == true) {
			test8.pass("Learn more redirects to collaboration page");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper collaborate left_image']/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Background Image not present");
		}
		if (a == true) {
			test8.pass("Background Image present");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper collaborate left_image']/div/div[2]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("All 3 features image not present");
		}
		if (a == true) {
			test8.pass("All 3 features image present");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[2]/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Start freetrial button not present");
		}
		if (a == true) {
			test8.pass("Start freetrial button present");
		}
		TimeUnit.SECONDS.sleep(3);

//		a=true;
//		try {webDriver.findElement(By.xpath("//div[@class='home_feature_wrapper collaborate left_image']/ul/li/div[1]/div[2]/a")).click();}
//		catch(NoSuchElementException e){a=false;
//		test8.fail("Start freetrial link fails");}
//		if(a==true){test8.pass("Start freetrial link redirects to pricing page");}
//		TimeUnit.SECONDS.sleep(3);
//		webDriver.navigate().back();
//		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 10)
	public void b1_Section6() throws InterruptedException {
		ExtentTest test9 = extentreport.createTest("section 6", "To check the Prelogin Home web page section 6");
		extentTest.set(test9);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Our Partners']"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Section 6 - Title text is not correct");
		}
		if (a == true) {
			test9.pass("Section 6 - Title text is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='partner_section_ul']/li[1]//picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("1.Verizon - Image not present");
		}
		if (a == true) {
			test9.pass("1.Verizon - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='partner_section_ul']/li[2]//picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("2.Cyber Wise - Image not present");
		}
		if (a == true) {
			test9.pass("2.Cyber Wise - Image present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='partner_section_ul']/li[3]//picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("3.World Childhood Foundation - Image not present");
		}
		if (a == true) {
			test9.pass("3.World Childhood Foundation - Image present");
		}
	}

	@Test(priority = 11)
	public void b2_section7() throws InterruptedException {
		ExtentTest test10 = extentreport.createTest("section 7,8", "To check the Prelogin Home web page section 7,8");
		extentTest.set(test10);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Home page - Build better is not present");
		}
		if (a == true) {
			test10.pass("Home page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Home page - Footer is not present");
		}
		if (a == true) {
			test10.pass("Home page - Footer is present");
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
