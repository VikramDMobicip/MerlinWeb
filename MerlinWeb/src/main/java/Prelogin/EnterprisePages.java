package Prelogin;

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

public class EnterprisePages extends BrowserSetupClass {

	/*
	 * ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\EnterpriseTest\\enterprisePagesReport.html");
	 * extentreport.attachReporter(spark); }
	 */
	@Test(priority = 1)
	public void a1_schoolPage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("school page", "To check the Prelogin school web page title,header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		WebElement l = webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='School']"));
		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='footer_ul']//a[text()='School']")));
		webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='School']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='enterprise_btn']")));

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Internet Filter for Schools & Libaries | Mobicip")) {
			test.pass("school Page title is correct");
		} else {
			test.fail("school Page title isn't correct");
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
			test.fail("Pre login school page - Header is incorrect");
		}
		if (a == true) {
			test.pass("Pre login school page - Header is correct");
		}
	}

	@Test(priority = 2)
	public void a2_section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1", "To check the Prelogin school web page section 1");
		extentTest.set(test1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Plug & Play Web Filter in the Cloud for Schools']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Section title is not correct");
		}
		if (a == true) {
			test1.pass("Section title is correct");
		}
		TimeUnit.SECONDS.sleep(4);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='enterprise_btn']/child::a[text()='Request Quote']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Request Quote button redirects failed");
		}
		if (a == true) {
			test1.pass("Request Quote button works fine");
		}
		TimeUnit.SECONDS.sleep(4);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[1]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[2]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[3]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[4]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[5]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[6]"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Platform icons not present");
		}
		if (a == true) {
			test1.pass("Platforms icon present");
		}

		String p = webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/p")).getText();
		if (p.equals("Protects iOS, Android, macOS, Windows, Chromebook & Kindle")) {
			test1.pass("Platforms text correct");
		} else {
			test1.fail("Platforms text not correct");
		}
	}

	@Test(priority = 3)
	public void a3_section2() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("section 2", "To check the Prelogin school web page section 2");
		extentTest.set(test2);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[1]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Alpine School icon not present");
		}
		if (a == true) {
			test2.pass("Alpine School icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[2]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Lansing Christian school icon not present");
		}
		if (a == true) {
			test2.pass("Lansing Christian school icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[3]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Los Banos Unified School icon not present");
		}
		if (a == true) {
			test2.pass("Los Banos Unified School icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[4]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Captapult Learning icon not present");
		}
		if (a == true) {
			test2.pass("Captapult Learning icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[5]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Midwestern intermediate Unit IV icon not present");
		}
		if (a == true) {
			test2.pass("Midwestern intermediate Unit IV icon present");
		}

	}

	@Test(priority = 4)
	public void a4_section3() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("section 3", "To check the Prelogin school web page section 3");
		extentTest.set(test3);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Plug & Play Web Filter']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Plug & Play Web Filter - not correct");
		}
		if (a == true) {
			test3.pass("Plug & Play Web Filter - correct");
		}

		String desc1 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[1]/p")).getText();
		if (desc1.equals(
				"Mobicip is 100% cloud-based. No appliance. No capital equipment. No hardware. No networking expertise required. After all, it is used by millions of parents around the world. Simple, intuitive apps help you deploy web filtering effortlessly on a wide variety of device types. Just install, enable, and manage.")) {
			test3.pass("Description - correct");
		} else {
			test3.fail("Description - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for iPad']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Web Filter for iPad - not correct");
		}
		if (a == true) {
			test3.pass("Web Filter for iPad - correct");
		}

		String desc2 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[2]/p")).getText();
		if (desc2.equals(
				"Protect Safari and any other app that has a built-in browser on your student iPads. Powerful dynamic content filtering by user, group or account ensures that educational content is allowed while objectionable stuff is blocked across all apps. Integrate with your existing device management for smooth and easy deployment. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test3.pass("Description - correct");
		} else {
			test3.fail("Description - not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(5);

		String t1 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/span")).getText();
		if (t1.equals("Filtering Strategy")) {
			test3.pass("Filtering Strategy - correct");
		} else {
			test3.fail("Filtering Strategy - not correct");
		}

		String p1 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[1]/span"))
				.getText();
		if (p1.equals("Safe Browser")) {
			test3.pass("point 1 - correct");
		} else {
			test3.fail("point 1 - wrong");
		}

		String p11 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[2]/span"))
				.getText();
		if (p11.equals("Global Proxy")) {
			test3.pass("point 2 - correct");
		} else {
			test3.fail("point 2 - wrong");
		}

		String p12 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[3]/span"))
				.getText();
		if (p12.equals("Enforced VPN")) {
			test3.pass("point 3 - correct");
		} else {
			test3.fail("point 3 - wrong");
		}

		String p13 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[4]/span"))
				.getText();
		if (p13.equals("Content Filter Plug-in")) {
			test3.pass("point 4 - correct");
		} else {
			test3.fail("point 4 - wrong");
		}

		String t2 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/span")).getText();
		if (t2.equals("Easy Deployment")) {
			test3.pass("Easy Deployment - correct");
		} else {
			test3.fail("Easy Deployment - not correct");
		}

		String p2 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[1]/span"))
				.getText();
		if (p2.equals("Deployment server")) {
			test3.pass("point 1 - correct");
		} else {
			test3.fail("point 1 - wrong");
		}

		String p21 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[2]/span"))
				.getText();
		if (p21.equals("MDM Integration")) {
			test3.pass("point 2 - correct");
		} else {
			test3.fail("point 2 - wrong");
		}

		String p22 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[3]/span"))
				.getText();
		if (p22.equals("Single Sign-on")) {
			test3.pass("point 3 - correct");
		} else {
			test3.fail("point 3 - wrong");
		}

		String p23 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[4]/span"))
				.getText();
		if (p23.equals("Apple DEP")) {
			test3.pass("point 4 - correct");
		} else {
			test3.fail("point 4 - wrong");
		}

		String t3 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/span")).getText();
		if (t3.equals("Remote Administration")) {
			test3.pass("Remote Administration - correct");
		} else {
			test3.fail("Remote Administration - not correct");
		}

		String p3 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[1]/span"))
				.getText();
		if (p3.equals("Intuitive web console")) {
			test3.pass("point 1 - correct");
		} else {
			test3.fail("point 1 - wrong");
		}

		String p31 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[2]/span"))
				.getText();
		if (p31.equals("Admin app on iOS & Android")) {
			test3.pass("point 2 - correct");
		} else {
			test3.fail("point 2 - wrong");
		}

		String p32 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[3]/span"))
				.getText();
		if (p32.equals("Override requests")) {
			test3.pass("point 3 - correct");
		} else {
			test3.fail("point 3 - wrong");
		}

		String p33 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[4]/span"))
				.getText();
		if (p33.equals("Delegated management")) {
			test3.pass("point 4 - correct");
		} else {
			test3.fail("point 4 - wrong");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,400)");

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Chromebook']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Web Filter for Chromebook - not correct");
		}
		if (a == true) {
			test3.pass("Web Filter for Chromebook - correct");
		}

		String desc3 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[3]/p")).getText();
		if (desc3.equals("Monitor usage or manage remotely from admin console on the web or mobile app")) {
			test3.pass("Description correct");
		} else {
			test3.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Windows']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Web Filter for Windows - not correct");
		}
		if (a == true) {
			test3.pass("Web Filter for Windows - correct");
		}

		String desc4 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[4]/p")).getText();
		if (desc4.equals("Monitor usage or manage remotely from admin console on the web or mobile app.")) {
			test3.pass("Description correct");
		} else {
			test3.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Mac']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Web Filter for Mac - not correct");
		}
		if (a == true) {
			test3.pass("Web Filter for Mac - correct");
		}

		String desc5 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[5]/p")).getText();
		if (desc5.equals("Monitor usage or manage remotely from admin console on the web or mobile app.")) {
			test3.pass("Description correct");
		} else {
			test3.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Android, Kindle, Nook']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Web Filter for Android, Kindle, Nook - not correct");
		}
		if (a == true) {
			test3.pass("Web Filter for Android, Kindle, Nook - correct");
		}

		String desc6 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[6]/p")).getText();
		if (desc6.equals(
				"Apply universal web filtering across Android smartphones or tablets too, including the Kindle and Nook by deploying the Mobicip Safe Browser! Powerful dynamic content filtering by user, group or account ensures that educational content is allowed while objectionable stuff is blocked across all apps. A custom app with your logo and credentials built-in ensures smooth and easy deployment. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test3.pass("Description correct");
		} else {
			test3.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Easy Reporting & Admin']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Easy Reporting & Admin - not correct");
		}
		if (a == true) {
			test3.pass("Easy Reporting & Admin - correct");
		}

		String desc7 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[7]/p")).getText();
		if (desc7.equals(
				"Tired of clunky admin consoles in your network appliance? What if you could manage the filter from an app on your phone or iPad? It opens up a whole new set of possibilities like notifications, override requests, and real-time reports available instantly where you are. Or you could always login at mobicip.com and use the web-based console from any browser.")) {
			test3.pass("Description correct");
		} else {
			test3.fail("Description wrong");
		}
	}

	@Test(priority = 5)
	public void a5_section4() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("section 4", "To check the Prelogin school web page section 4");
		extentTest.set(test4);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1300)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Safe. Secure. Reliable']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Section title is not correct");
		}
		if (a == true) {
			test4.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[1]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("1.Icon - not correct");
		}
		if (a == true) {
			test4.pass("1.Icon - correct");
		}

		String li1 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[1]/p")).getText();
		if (li1.equals("Protect iOS, Android, Windows, Mac, Chrome.")) {
			test4.pass("1.Title - correct");
		} else {
			test4.fail("1.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[2]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("2.Icon - not correct");
		}
		if (a == true) {
			test4.pass("2.Icon - correct");
		}

		String li2 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[2]/p")).getText();
		if (li2.equals("Secure any number of users, devices and computers from one account.")) {
			test4.pass("2.Title - correct");
		} else {
			test4.fail("2.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[3]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("3.Icon - not correct");
		}
		if (a == true) {
			test4.pass("3.Icon - correct");
		}

		String li3 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[3]/p")).getText();
		if (li3.equals("Customize settings & review browsing history reports from web dashboard.")) {
			test4.pass("3.Title - correct");
		} else {
			test4.fail("3.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[4]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("4.Icon - not correct");
		}
		if (a == true) {
			test4.pass("4.Icon - correct");
		}

		String li4 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[4]/p")).getText();
		if (li4.equals("Configure and monitor apps and web usage on-the-go from mobile app.")) {
			test4.pass("4.Title - correct");
		} else {
			test4.fail("4.Title - not correct");
		}

		TimeUnit.SECONDS.sleep(5);
		webDriver.findElement(By.xpath("//div[@class='swiper_bullets_container']/div/span[2]")).click();
		TimeUnit.SECONDS.sleep(5);

		a = true;
		try {
			webDriver.findElement(By
					.xpath("//div[@class='main_wrapper']/div/section[5]/div/div/div[1]/div/div/div[2]/ul/li/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("5.Icon - not correct");
		}
		if (a == true) {
			test4.pass("5.Icon - correct");
		}

		String li5 = webDriver
				.findElement(
						By.xpath("//div[@class='main_wrapper']/div/section[5]/div/div/div[1]/div/div/div[2]/ul/li/p"))
				.getText();
		if (li5.equals("Manage and monitor app downloads and usage with instant alerts.")) {
			test4.pass("5.Title - correct");
		} else {
			test4.fail("5.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='swiper_bullets_container']/div/span[1]")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Bullet point - click failed");
		}
		if (a == true) {
			test4.pass("Bullet points - Able to click");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 6)
	public void a6_section5() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section 5", "To check the Prelogin school web page section 5");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='What They Say']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Section title is not correct");
		}
		if (a == true) {
			test5.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[1]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Left Quotation icon - not displayed");
		}
		if (a == true) {
			test5.pass("Left Quotation icon - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[3]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Right Quotation icon - not displayed");
		}
		if (a == true) {
			test5.pass("Right Quotation icon - displayed");
		}

		String q1 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/p")).getText();
		if (q1.equals(
				"Thank you! We have 50 iPads used 1:1 everyday in our middle school department. Three years and counting Mobicip has stood in the gap as our choice because it really works. A huge shout-out to all of you at Mobicip!")) {
			test5.pass("1.Quote - correct");
		} else {
			test5.fail("1.Quote - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Image - not displayed");
		}
		if (a == true) {
			test5.pass("Image - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Walt Bringolf']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Name is not correct");
		}
		if (a == true) {
			test5.pass("Name is correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//p[text()='Middle School Chairman,'and text()='Providence Christian School']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("School name is not correct");
		}
		if (a == true) {
			test5.pass("School name is correct");
		}

		String q2 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/p")).getText();
		if (q2.equals(
				"I have worked with Mobicip for the last three years in two different school sytems. We use Mobicip as our browser and mobile filter. With Mobicip's premium account for our schools and our hundreds of units we know that inappropriate content is kept away from students and with Mobicip these tools can be used for teaching and learning. Thank you Mobicip!")) {
			test5.pass("2.Quote - correct");
		} else {
			test5.fail("2.Quote - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Image - not displayed");
		}
		if (a == true) {
			test5.pass("Image - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Susan Wells']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Name is not correct");
		}
		if (a == true) {
			test5.pass("Name is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Principal,'and text()='WG Pearson School, NC']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("School name is not correct");
		}
		if (a == true) {
			test5.pass("School name is correct");
		}

		String q3 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[3]/p")).getText();
		if (q3.equals(
				"I think things are working much better and it has been a good alternative to our other browser from K9. It works in some ways that the other does not. I will let you know if we have any other needs, but we are happy now.")) {
			test5.pass("3.Quote - correct");
		} else {
			test5.fail("3.Quote - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[3]/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Image - not displayed");
		}
		if (a == true) {
			test5.pass("Image - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Jason Salas']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Name is not correct");
		}
		if (a == true) {
			test5.pass("Name is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Charleston Catholic School']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("School name is not correct");
		}
		if (a == true) {
			test5.pass("School name is correct");
		}
	}

	@Test(priority = 7)
	public void a7_section6() throws InterruptedException {
		ExtentTest test6 = extentreport.createTest("section 6", "To check the Prelogin school web page section 6");
		extentTest.set(test6);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[1]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("The Huffington Post icon not present");
		}
		if (a == true) {
			test6.pass("The Huffington Post icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[2]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("PC icon not present");
		}
		if (a == true) {
			test6.pass("PC icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[3]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("The Newyork Times icon not present");
		}
		if (a == true) {
			test6.pass("The Newyork Times icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[4]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Today icon not present");
		}
		if (a == true) {
			test6.pass("Today icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[5]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Eye Witness News icon not present");
		}
		if (a == true) {
			test6.pass("Eye Witness News icon present");
		}

	}

	@Test(priority = 8)
	public void a8_section7() throws InterruptedException {
		ExtentTest test15 = extentreport.createTest("section 7", "To check the Prelogin school web page section 7,8");
		extentTest.set(test15);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("School page - Build better is not present");
		}
		if (a == true) {
			test15.pass("School page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("School page - Footer is not present");
		}
		if (a == true) {
			test15.pass("School page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void b1_businessPage() throws InterruptedException {
		ExtentTest test7 = extentreport.createTest("Business page",
				"To check the Prelogin business web page title,header");
		extentTest.set(test7);
		boolean a = true;
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");

		TimeUnit.SECONDS.sleep(5);

		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[2]/ul/li[5]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Pre login - Footer business redirect failed");
		}
		if (a == true) {
			test7.pass("Pre login - Footer business redirects to business page");
		}

		TimeUnit.SECONDS.sleep(5);

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Internet Filter For Business | Mobicip")) {
			test7.pass("Business Page title is correct");
		} else {
			test7.fail("Business Page title isn't correct");
		}

		// Header Elements
		a = true;
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
			test7.fail("Pre login business page - Header is incorrect");
		}
		if (a == true) {
			test7.pass("Pre login business page - Header is correct");
		}
	}

	@Test(priority = 10)
	public void b2_section1() throws InterruptedException {
		ExtentTest test8 = extentreport.createTest("section 1", "To check the Prelogin Business web page section 1");
		extentTest.set(test8);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Reliable Web Filtering in the Cloud for Business']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Section title is not correct");
		}
		if (a == true) {
			test8.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='enterprise_btn']/child::a[text()='Request Quote']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Request Quote button redirects failed");
		}
		if (a == true) {
			test8.pass("Request Quote button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[1]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[2]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[3]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[4]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[5]"));
			webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/div/figure[6]"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Platform icons not present");
		}
		if (a == true) {
			test8.pass("Platforms icon present");
		}

		String p = webDriver.findElement(By.xpath("//div[@class='product_icons_wrapper']/p")).getText();
		if (p.equals("Protects iOS, Android, macOS, Windows, Chromebook & Kindle")) {
			test8.pass("Platforms text correct");
		} else {
			test8.fail("Platforms text not correct");
		}
	}

	@Test(priority = 11)
	public void b3_section2() throws InterruptedException {
		ExtentTest test9 = extentreport.createTest("section 2", "To check the Prelogin business web page section 2");
		extentTest.set(test9);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[1]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Alpine School icon not present");
		}
		if (a == true) {
			test9.pass("Alpine School icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[2]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Lansing Christian school icon not present");
		}
		if (a == true) {
			test9.pass("Lansing Christian school icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[3]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Los Banos Unified School icon not present");
		}
		if (a == true) {
			test9.pass("Los Banos Unified School icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[4]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Captapult Learning icon not present");
		}
		if (a == true) {
			test9.pass("Captapult Learning icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/div[5]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Midwestern intermediate Unit IV icon not present");
		}
		if (a == true) {
			test9.pass("Midwestern intermediate Unit IV icon present");
		}
	}

	@Test(priority = 12)
	public void b4_section3() throws InterruptedException {
		ExtentTest test10 = extentreport.createTest("section 3", "To check the Prelogin business web page section 3");
		extentTest.set(test10);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Plug & Play Web Filter']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Plug & Play Web Filter - not correct");
		}
		if (a == true) {
			test10.pass("Plug & Play Web Filter - correct");
		}

		String desc1 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[1]/p")).getText();
		if (desc1.equals(
				"Mobicip is 100% cloud-based. No appliance. No capital equipment. No hardware. No networking expertise required. After all, the Family edition is used by millions of parents around the world. Simple, intuitive apps help you deploy web filtering effortlessly on a wide variety of device types. Just install, enable, and it is good to go.")) {
			test10.pass("Description - correct");
		} else {
			test10.fail("Description - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for iPad']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Web Filter for iPad - not correct");
		}
		if (a == true) {
			test10.pass("Web Filter for iPad - correct");
		}

		String desc2 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[2]/p")).getText();
		if (desc2.equals(
				"Protect Safari and any other app that has a built-in browser on your student iPads. Powerful dynamic content filtering by user, group or account ensures that educational content is allowed while objectionable stuff is blocked across all apps. Integrate with your existing device management for smooth and easy deployment. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test10.pass("Description - correct");
		} else {
			test10.fail("Description - not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(5);
		String t1 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/span")).getText();
		if (t1.equals("Filtering Strategy")) {
			test10.pass("Filtering Strategy - correct");
		} else {
			test10.fail("Filtering Strategy - not correct");
		}

		String p1 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[1]/span"))
				.getText();
		if (p1.equals("Safe Browser")) {
			test10.pass("point 1 - correct");
		} else {
			test10.fail("point 1 - wrong");
		}

		String p11 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[2]/span"))
				.getText();
		if (p11.equals("Global Proxy")) {
			test10.pass("point 2 - correct");
		} else {
			test10.fail("point 2 - wrong");
		}

		String p12 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[3]/span"))
				.getText();
		if (p12.equals("Enforced VPN")) {
			test10.pass("point 3 - correct");
		} else {
			test10.fail("point 3 - wrong");
		}

		String p13 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[1]/li[4]/span"))
				.getText();
		if (p13.equals("Content Filter Plug-in")) {
			test10.pass("point 4 - correct");
		} else {
			test10.fail("point 4 - wrong");
		}

		String t2 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/span")).getText();
		if (t2.equals("Easy Deployment")) {
			test10.pass("Easy Deployment - correct");
		} else {
			test10.fail("Easy Deployment - not correct");
		}

		String p2 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[1]/span"))
				.getText();
		if (p2.equals("Deployment server")) {
			test10.pass("point 1 - correct");
		} else {
			test10.fail("point 1 - wrong");
		}

		String p21 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[2]/span"))
				.getText();
		if (p21.equals("MDM Integration")) {
			test10.pass("point 2 - correct");
		} else {
			test10.fail("point 2 - wrong");
		}

		String p22 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[3]/span"))
				.getText();
		if (p22.equals("Single Sign-on")) {
			test10.pass("point 3 - correct");
		} else {
			test10.fail("point 3 - wrong");
		}

		String p23 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[2]/li[4]/span"))
				.getText();
		if (p23.equals("Apple DEP")) {
			test10.pass("point 4 - correct");
		} else {
			test10.fail("point 4 - wrong");
		}

		String t3 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/span")).getText();
		if (t3.equals("Remote Administration")) {
			test10.pass("Remote Administration - correct");
		} else {
			test10.fail("Remote Administration - not correct");
		}

		String p3 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[1]/span"))
				.getText();
		if (p3.equals("Intuitive web console")) {
			test10.pass("point 1 - correct");
		} else {
			test10.fail("point 1 - wrong");
		}

		String p31 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[2]/span"))
				.getText();
		if (p31.equals("Admin app on iOS & Android")) {
			test10.pass("point 2 - correct");
		} else {
			test10.fail("point 2 - wrong");
		}

		String p32 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[3]/span"))
				.getText();
		if (p32.equals("Override requests")) {
			test10.pass("point 3 - correct");
		} else {
			test10.fail("point 3 - wrong");
		}

		String p33 = webDriver.findElement(By.xpath("//div[@class='enterprise_sub_container']/ul[3]/li[4]/span"))
				.getText();
		if (p33.equals("Delegated management")) {
			test10.pass("point 4 - correct");
		} else {
			test10.fail("point 4 - wrong");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Chromebook']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Web Filter for Chromebook - not correct");
		}
		if (a == true) {
			test10.pass("Web Filter for Chromebook - correct");
		}

		String desc3 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[3]/p")).getText();
		if (desc3.equals(
				"Setup single sign-on Chromebook filtering by deploying Mobicip using the Google Chromebook Management Console. Powerful dynamic content filtering by user, group or account ensures that objectionable stuff is blocked. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test10.pass("Description correct");
		} else {
			test10.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Windows']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Web Filter for Windows - not correct");
		}
		if (a == true) {
			test10.pass("Web Filter for Windows - correct");
		}

		String desc4 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[4]/p")).getText();
		if (desc4.equals(
				"Apply universal web filtering across your desktops and laptops too! Powerful dynamic content filtering by user, group or account ensures that objectionable stuff is blocked across all apps. Active Directory integration allows for easy deployment and student login. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test10.pass("Description correct");
		} else {
			test10.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Mac']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Web Filter for Mac - not correct");
		}
		if (a == true) {
			test10.pass("Web Filter for Mac - correct");
		}

		String desc5 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[5]/p")).getText();
		if (desc5.equals(
				"Apply universal web filtering across your Macbooks, iMacs and Mac minis too! Powerful dynamic content filtering by user, group or account ensures that objectionable stuff is blocked across all apps. Integrate with your existing Student Information System (SIS) for smooth and easy deployment. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test10.pass("Description correct");
		} else {
			test10.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Web Filter for Android, Kindle, Nook']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Web Filter for Android, Kindle, Nook - not correct");
		}
		if (a == true) {
			test10.pass("Web Filter for Android, Kindle, Nook - correct");
		}

		String desc6 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[6]/p")).getText();
		if (desc6.equals(
				"Apply universal web filtering across Android smartphones or tablets too, including the Kindle and Nook by deploying the Mobicip Safe Browser! Powerful dynamic content filtering by user, group or account ensures that educational content is allowed while objectionable stuff is blocked across all apps. A custom app with your logo and credentials built-in ensures smooth and easy deployment. Monitor usage or manage remotely from admin console on the web or iOS app.")) {
			test10.pass("Description correct");
		} else {
			test10.fail("Description wrong");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Easy Reporting & Admin']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Easy Reporting & Admin - not correct");
		}
		if (a == true) {
			test10.pass("Easy Reporting & Admin - correct");
		}

		String desc7 = webDriver.findElement(By.xpath("//div[@class='enterprise_wrapper']/div[7]/p")).getText();
		if (desc7.equals(
				"Tired of clunky admin consoles in your network appliance? What if you could manage the filter from an app on your phone or iPad? It opens up a whole new set of possibilities like notifications, override requests, and real-time reports available instantly where you are. Or you could always login at mobicip.com and use the web-based console from any browser.")) {
			test10.pass("Description correct");
		} else {
			test10.fail("Description wrong");
		}
	}

	@Test(priority = 13)
	public void b5_section4() throws InterruptedException {
		ExtentTest test11 = extentreport.createTest("section 4", "To check the Prelogin business web page section 4");
		extentTest.set(test11);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1300)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Safe. Secure. Reliable']"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("Section title is not correct");
		}
		if (a == true) {
			test11.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[1]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("1.Icon - not correct");
		}
		if (a == true) {
			test11.pass("1.Icon - correct");
		}

		String li1 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[1]/p")).getText();
		if (li1.equals("Protect iOS, Android, Windows, Mac, Chrome.")) {
			test11.pass("1.Title - correct");
		} else {
			test11.fail("1.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[2]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("2.Icon - not correct");
		}
		if (a == true) {
			test11.pass("2.Icon - correct");
		}

		String li2 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[2]/p")).getText();
		if (li2.equals("Secure any number of users, devices and computers from one account.")) {
			test11.pass("2.Title - correct");
		} else {
			test11.fail("2.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[3]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("3.Icon - not correct");
		}
		if (a == true) {
			test11.pass("3.Icon - correct");
		}

		String li3 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[3]/p")).getText();
		if (li3.equals("Customize settings & review browsing history reports from web dashboard.")) {
			test11.pass("3.Title - correct");
		} else {
			test11.fail("3.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[4]/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("4.Icon - not correct");
		}
		if (a == true) {
			test11.pass("4.Icon - correct");
		}

		String li4 = webDriver.findElement(By.xpath("//ul[@class='enterprise_feature_wrapper'][1]/li[4]/p")).getText();
		if (li4.equals("Configure and monitor apps and web usage on-the-go from mobile app.")) {
			test11.pass("4.Title - correct");
		} else {
			test11.fail("4.Title - not correct");
		}

		webDriver.findElement(By.xpath("//div[@class='swiper_bullets_container']/div/span[2]")).click();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By
					.xpath("//div[@class='main_wrapper']/div/section[5]/div/div/div[1]/div/div/div[2]/ul/li/span[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("5.Icon - not correct");
		}
		if (a == true) {
			test11.pass("5.Icon - correct");
		}

		String li5 = webDriver
				.findElement(
						By.xpath("//div[@class='main_wrapper']/div/section[5]/div/div/div[1]/div/div/div[2]/ul/li/p"))
				.getText();
		if (li5.equals("Manage and monitor app downloads and usage with instant alerts.")) {
			test11.pass("5.Title - correct");
		} else {
			test11.fail("5.Title - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='swiper_bullets_container']/div/span[1]")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("Bullet point - click failed");
		}
		if (a == true) {
			test11.pass("Bullet points - Able to click");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 14)
	public void b6_section5() throws InterruptedException {
		ExtentTest test12 = extentreport.createTest("section 5", "To check the Prelogin business web page section 5");
		extentTest.set(test12);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='What They Say']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Section title is not correct");
		}
		if (a == true) {
			test12.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[1]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Left Quotation icon - not displayed");
		}
		if (a == true) {
			test12.pass("Left Quotation icon - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[3]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Right Quotation icon - not displayed");
		}
		if (a == true) {
			test12.pass("Right Quotation icon - displayed");
		}

		String q1 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/p")).getText();
		if (q1.equals(
				"Thank you! We have 50 iPads used 1:1 everyday in our middle school department. Three years and counting Mobicip has stood in the gap as our choice because it really works. A huge shout-out to all of you at Mobicip!")) {
			test12.pass("1.Quote - correct");
		} else {
			test12.fail("1.Quote - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[1]/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Image - not displayed");
		}
		if (a == true) {
			test12.pass("Image - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Walt Bringolf']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Name is not correct");
		}
		if (a == true) {
			test12.pass("Name is correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//p[text()='Middle School Chairman,'and text()='Providence Christian School']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("School name is not correct");
		}
		if (a == true) {
			test12.pass("School name is correct");
		}

		String q2 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/p")).getText();
		if (q2.equals(
				"I have worked with Mobicip for the last three years in two different school sytems. We use Mobicip as our browser and mobile filter. With Mobicip's premium account for our schools and our hundreds of units we know that inappropriate content is kept away from students and with Mobicip these tools can be used for teaching and learning. Thank you Mobicip!")) {
			test12.pass("2.Quote - correct");
		} else {
			test12.fail("2.Quote - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[2]/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Image - not displayed");
		}
		if (a == true) {
			test12.pass("Image - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Susan Wells']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Name is not correct");
		}
		if (a == true) {
			test12.pass("Name is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Principal,'and text()='WG Pearson School, NC']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("School name is not correct");
		}
		if (a == true) {
			test12.pass("School name is correct");
		}

		String q3 = webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[3]/p")).getText();
		if (q3.equals(
				"I think things are working much better and it has been a good alternative to our other browser from K9. It works in some ways that the other does not. I will let you know if we have any other needs, but we are happy now.")) {
			test12.pass("3.Quote - correct");
		} else {
			test12.fail("3.Quote - not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='review_wrapper']/div[2]/ul/li[3]/div/div[1]/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Image - not displayed");
		}
		if (a == true) {
			test12.pass("Image - displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Jason Salas']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Name is not correct");
		}
		if (a == true) {
			test12.pass("Name is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Charleston Catholic School']"));
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("School name is not correct");
		}
		if (a == true) {
			test12.pass("School name is correct");
		}
	}

	@Test(priority = 15)
	public void b7_section6() throws InterruptedException {
		ExtentTest test13 = extentreport.createTest("section 6", "To check the Prelogin business web page section 6");
		extentTest.set(test13);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[1]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("The Huffington Post icon not present");
		}
		if (a == true) {
			test13.pass("The Huffington Post icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[2]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("PC icon not present");
		}
		if (a == true) {
			test13.pass("PC icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[3]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("The Newyork Times icon not present");
		}
		if (a == true) {
			test13.pass("The Newyork Times icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[4]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Today icon not present");
		}
		if (a == true) {
			test13.pass("Today icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section[7]/div/div/div[5]/div/picture"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Eye Witness News icon not present");
		}
		if (a == true) {
			test13.pass("Eye Witness News icon present");
		}

	}

	@Test(priority = 16)
	public void b8_section7() throws InterruptedException {
		ExtentTest test14 = extentreport.createTest("section 7", "To check the Prelogin Business web page section 7,8");
		extentTest.set(test14);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Business page - Build better is not present");
		}
		if (a == true) {
			test14.pass("Business page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Business page - Footer is not present");
		}
		if (a == true) {
			test14.pass("Business page - Footer is present");
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

}

/*
 * @AfterClass public void teardown() { extentreport.flush(); } }
 */
