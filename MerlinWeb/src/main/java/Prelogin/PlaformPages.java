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

public class PlaformPages extends BrowserSetupClass {

	/*
	 * //Report setup ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\PlatformPage\\plaformPagesReport.html");
	 * extentreport.attachReporter(spark); }
	 */
	@Test(priority = 1)
	public void a1_iPhonePage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("iPhone page", "To check the Prelogin iPhone web page title,header");
		extentTest.set(test);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,10000)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='iPhone']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Pre login - Footer iPhone redirect failed");
		}
		if (a == true) {
			test.pass("Pre login - Footer iPhone redirects to iPhone Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control app for your child's iPhone | Mobicip")) {
			test.pass("iPhone Page title is correct");
		} else {
			test.fail("iPhone Page title isn't correct");
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
			test.fail("Pre login iPhone page - Header is incorrect");
		}
		if (a == true) {
			test.pass("Pre login iPhone page - Header is correct");
		}
	}

	@Test(priority = 2)
	public void a2_section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1", "To check the Prelogin iPhone web page section 1");
		extentTest.set(test1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Parental Control App for iPhone']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Section title is not correct");
		}
		if (a == true) {
			test1.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//*[text()='Comprehensive iPhone parental controls for busy, tech-savvy parents of young children']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Section sub title is not correct");
		}
		if (a == true) {
			test1.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Start Free Trial button redirects failed");
		}
		if (a == true) {
			test1.pass("Start Free Trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Download icon not present");
		}
		if (a == true) {
			test1.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Background Image not present");
		}
		if (a == true) {
			test1.pass("Background Image present");
		}
	}

	@Test(priority = 3)
	public void a3_section2() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("section 2", "To check the Prelogin iPhone web page section 2");
		extentTest.set(test2);
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Features of our iPhone Parental Control App']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Section title is not correct");
		}
		if (a == true) {
			test2.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Track Location']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Feature - Track Location text not correct");
		}
		if (a == true) {
			test2.pass("1 - Track Location text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(5);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).click();
		a = true;
		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test2.pass("2 - Monitor Social Media text correct");
		} else {
			test2.fail("Feature - Monitor Social Media text not correct");
		}

		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test2.pass("3 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Block Apps']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Block Apps']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Feature - Block Apps text not correct");
		}
		if (a == true) {
			test2.pass("4 - Block Apps text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,400)");

		webDriver.findElement(By.xpath("//*[text()='Set App Limits']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Set App Limits']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Feature - Set App Limits text not correct");
		}
		if (a == true) {
			test2.pass("5 - Set App Limits text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[5]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/h3")).click();
		a = true;
		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/h3")).getText();
		if (f7.equals("View Daily Activity Summary")) {
			test2.pass("6 - View Activity Summary text correct");
		} else {
			test2.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test2.pass("7 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/div[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("sub text not present");
		}
		if (a == true) {
			test2.pass("sub text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Image not present");
		}
		if (a == true) {
			test2.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 4)
	public void a4_section3() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("section 3", "To check the Prelogin iPhone web page section 3");
		extentTest.set(test3);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='How to Set Up Mobicip’s iPhone Parental Control']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Section title is not correct");
		}
		if (a == true) {
			test3.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("Follow our easy setup guide")) {
			test3.pass("Section sub title is correct");
		} else {
			test3.fail("Section sub title is not correct");
		}

		/*
		 * a=true; try
		 * {webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click()
		 * ;} catch(NoSuchElementException e){a=false;
		 * test3.fail("Step-by-Step Instructions redirects failed");}
		 * if(a==true){test3.pass("Step-by-Step Instructions redirects Pass");}
		 * webDriver.navigate().back();
		 */

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test3.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test3.pass("Download text is correct");
		} else {
			test3.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Download icon not present");
		}
		if (a == true) {
			test3.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test3.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test3.pass("Sign Up text is correct");
		} else {
			test3.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Create username & password text not present");
		}
		if (a == true) {
			test3.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test3.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test3.pass("Configure text is correct");
		} else {
			test3.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test3.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test3.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test3.pass("Monitor text is correct");
		} else {
			test3.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test3.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 5)
	public void a5_section4() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("section 4", "To check the Prelogin iPhone web page section 4");
		extentTest.set(test4);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='iPhone Parental Controls Installation Video']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Section title is not correct");
		}
		if (a == true) {
			test4.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Mobicip - #1 Rated Parental Controls for Apple iPhone']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Section sub title is not correct");
		}
		if (a == true) {
			test4.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='child_setup_video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("video is not present");
		}
		if (a == true) {
			test4.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(10);
	}

	@Test(priority = 6)
	public void a6_section5() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section 5", "To check the Prelogin iPhone web page section 5");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Why Mobicip Parental Control App for Your Child’s iPhone?']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Section title is not correct");
		}
		if (a == true) {
			test5.pass("Section title is correct");
		}

		try {
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][1]/div/div[1]"));
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][1]/div/div[2]"));
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][1]/div/div[3]"));
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][1]/div/div[4]"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Section contents not present");
		}
		if (a == true) {
			test5.pass("Section contents present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(3);

		a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Voted #1 Parent-Approved and Top Rated']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Section title is not correct");
		}
		if (a == true) {
			test5.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][2]/div/div[1]"));
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][2]/div/div[2]"));
			webDriver.findElement(By.xpath("//div[@class='content_container iphone_container'][2]/div/div[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Section contents not present");
		}
		if (a == true) {
			test5.pass("Section contents present");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='stats_counters']/div[1]"));
			webDriver.findElement(By.xpath("//div[@class='stats_counters']/div[2]"));
			webDriver.findElement(By.xpath("//div[@class='stats_counters']/div[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Rating Section contents not present");
		}
		if (a == true) {
			test5.pass("Rating Section contents present");
		}

		String question = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[1]/h3")).getText();
		if (question.equals("What is a parental control app for the iPhone?")) {
			test5.pass("Question 1 correct");
		} else {
			test5.fail("Question 1 not correct");
		}

		String answer = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[1]/p")).getText();
		if (answer.equals(
				"A parental control app for iPhone is a software that parents use to monitor their child's online activities and manage within healthy limits. It typically includes features such as app blocking, web filtering, screen time limits, location tracking, and social media monitoring.")) {
			test5.pass("Answer 1 correct");
		} else {
			test5.fail("Answer 1 not correct");
		}

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[2]/h3")).getText();
		if (question1.equals("Can I monitor an iPhone from my Android device?")) {
			test5.pass("Question 2 correct");
		} else {
			test5.fail("Question 2 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[2]/p")).getText();
		if (answer1.equals(
				"Yes, you can. First, set up Mobicip in Parent Mode on your Android device, then set up Mobicip in Child Mode on your child's iPhone. With Mobicip parental controls, parents can monitor their child's iPhone, iPad, Android phone/tablet, Kindle Fire, Mac, Windows device or Chromebook from any device of their choice.")) {
			test5.pass("Answer 2 correct");
		} else {
			test5.fail("Answer 2 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[3]/h3")).getText();
		if (question2.equals("Can my child uninstall Mobicip from iOS devices?")) {
			test5.pass("Question 3 correct");
		} else {
			test5.fail("Question 3 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[3]/p")).getText();
		if (answer2.equals(
				"While most parental control apps can be uninstalled or disabled, Mobicip offers an extra layer of protection. Uninstall Protection requires a parent's iTunes credentials to remove the app, making it more difficult for children to bypass parental controls.This added security feature gives parents peace of mind knowing their child's safety is not compromised.")) {
			test5.pass("Answer 3 correct");
		} else {
			test5.fail("Answer 3 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[4]/h3")).getText();
		if (question3.equals("Does Mobicip block videos on the YouTube app?")) {
			test5.pass("Question 4 correct");
		} else {
			test5.fail("Question 4 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container four-layout']/li[4]/p")).getText();
		if (answer3.equals(
				"Mobicip allows parents to filter videos, block inappropriate video content and set YouTube parental controls on the iPhone. The latest version of Mobicip works using VPN technology that allows it to filter videos directly on the Youtube app. In addition, Mobicip already filters videos on the YouTube website.")) {
			test5.pass("Answer 4 correct");
		} else {
			test5.fail("Answer 4 not correct");
		}
	}

	@Test(priority = 7)
	public void a7_section6() throws InterruptedException {
		ExtentTest test42 = extentreport.createTest("section 6,7", "To check the Prelogin iPhone web page section 6,7");
		extentTest.set(test42);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test42.fail("Form is not present");
		}
		if (a == true) {
			test42.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test42.fail("iPhone page - Build better is not present");
		}
		if (a == true) {
			test42.pass("iPhone page - Build better is present");
		}

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test42.fail("iPhone page - Footer is not present");
		}
		if (a == true) {
			test42.pass("iPhone page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 8)
	public void b1_iPadPage() throws InterruptedException {
		ExtentTest test6 = extentreport.createTest("iPad page", "To check the Prelogin iPad web page title,header");
		extentTest.set(test6);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[1]/ul/li[2]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Pre login - Footer iPad redirect failed");
		}
		if (a == true) {
			test6.pass("Pre login - Footer iPad redirects to iPad Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best iPad Parental control app for your kid’s devices - Mobicip | Mobicip"))

		{
			test6.pass("iPad Page title is correct");
		} else {
			test6.fail("iPad Page title isn't correct");
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
			test6.fail("Pre login iPad page - Header is incorrect");
		}
		if (a == true) {
			test6.pass("Pre login iPad page - Header is correct");
		}
	}

	@Test(priority = 9)
	public void b2_section1() throws InterruptedException {
		ExtentTest test7 = extentreport.createTest("section 1", "To check the Prelogin iPad web page section 1");
		extentTest.set(test7);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Smart iPad Parental Controls for Frazzled Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Section title is not correct");
		}
		if (a == true) {
			test7.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//*[text()='Don’t let the iPad babysit your child. Schedule screen time and instant-lock the iPad from your phone.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Section sub title is not correct");
		}
		if (a == true) {
			test7.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Start Free Trial button redirects failed");
		}
		if (a == true) {
			test7.pass("Start Free Trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Download icon not present");
		}
		if (a == true) {
			test7.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Background Image not present");
		}
		if (a == true) {
			test7.pass("Background Image present");
		}
	}

	@Test(priority = 10)
	public void b3_section2() throws InterruptedException {
		ExtentTest test8 = extentreport.createTest("section 2", "To check the Prelogin iPad web page section 2");
		extentTest.set(test8);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Cultivate Good Digital Citizenship & Etiquette']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Section title is not correct");
		}
		if (a == true) {
			test8.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Track Location']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Feature - Track Location text not correct");
		}
		if (a == true) {
			test8.pass("1 - Track Location text correct");
		}

		String f2 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p")).getText();
		if (f2.equals("Set geofences & locate your kids on demand")) {
			test8.pass("sub text correct");
		} else {
			test8.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Family locator page redirects failed");
		}
		if (a == true) {
			test8.pass("Family locator page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Feature - Schedule & Limit Screen Time text not correct");
		}
		if (a == true) {
			test8.pass("2 - Schedule & Limit Screen Time text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/p")).getText();
		if (f3.equals("Set healthy time limits for how and when the iPad is used.")) {
			test8.pass("sub text correct");
		} else {
			test8.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test8.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).click();
		a = true;
		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test8.pass("3 - Monitor Social Media text correct");
		} else {
			test8.fail("Feature - Monitor Social Media text not correct");
		}

		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Get alerted on risky interactions on Facebook.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("sub text not correct");
		}
		if (a == true) {
			test8.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test8.pass("4 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f4 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p")).getText();
		if (f4.equals("Block websites, filter adult content and keep your kids safe online")) {
			test8.pass("sub text correct");
		} else {
			test8.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Website blocker page redirects failed");
		}
		if (a == true) {
			test8.pass("Website blocker page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Block Apps']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Block Apps']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Feature - Block Apps text not correct");
		}
		if (a == true) {
			test8.pass("5 - Block Apps text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Completely block distracting, inappropriate or addictive games and apps.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("sub text not correct");
		}
		if (a == true) {
			test8.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Set App Limits']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Set App Limits']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Feature - Set App Limits text not correct");
		}
		if (a == true) {
			test8.pass("6 - Set App Limits text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f6 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[5]/p")).getText();
		if (f6.equals("Set screen time allowances for specific categories and apps.")) {
			test8.pass("sub text correct");
		} else {
			test8.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[5]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test8.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/h3")).click();

		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/h3")).getText();
		if (f7.equals("View Activity Summary")) {
			test8.pass("7 - View Activity Summary text correct");
		} else {
			test8.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String feature = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/p")).getText();
		if (feature.equals("Get a daily snapshot of your family's device usage.")) {
			test8.pass("sub text correct");
		} else {
			test8.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test8.pass("8 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Child dashboard shows how they spend their time online every day']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("sub text not correct");
		}
		if (a == true) {
			test8.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Image not present");
		}
		if (a == true) {
			test8.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 11)
	public void b4_section3() throws InterruptedException {
		ExtentTest test9 = extentreport.createTest("section 3", "To check the Prelogin iPad web page section 3");
		extentTest.set(test9);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Parental Controls is Anything But Easy.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Section title is not correct");
		}
		if (a == true) {
			test9.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("Don’t worry. We can do this together. Follow our Step-by-Step Instructions")) {
			test9.pass("Section sub title is correct");
		} else {
			test9.fail("Section sub title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Step-by-Step Instructions redirects failed");
		}
		if (a == true) {
			test9.pass("Step-by-Step Instructions redirects Pass");
		}
		webDriver.navigate().back();

		webDriver.findElement(By.xpath("//div[@class='get_started_wrapper']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test9.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test9.pass("Download text is correct");
		} else {
			test9.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Download icon not present");
		}
		if (a == true) {
			test9.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test9.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test9.pass("Sign Up text is correct");
		} else {
			test9.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Create username & password text not present");
		}
		if (a == true) {
			test9.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test9.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test9.pass("Configure text is correct");
		} else {
			test9.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test9.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test9.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test9.pass("Monitor text is correct");
		} else {
			test9.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test9.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test9.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 12)
	public void b5_section4() throws InterruptedException {
		ExtentTest test10 = extentreport.createTest("section 4", "To check the Prelogin iPad web page section 4");
		extentTest.set(test10);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Watch the Video Walkthrough']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Section title is not correct");
		}
		if (a == true) {
			test10.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Parental Controls & Family Locator for Apple iPads']"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("Section sub title is not correct");
		}
		if (a == true) {
			test10.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='child_setup_video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test10.fail("video is not present");
		}
		if (a == true) {
			test10.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(10);
	}

	@Test(priority = 13)
	public void b6_section5() throws InterruptedException {
		ExtentTest test11 = extentreport.createTest("section 5", "To check the Prelogin iPad web page section 5");
		extentTest.set(test11);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		TimeUnit.SECONDS.sleep(3);
		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='#1 Rated Parental Control Software for Apple Devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("Section title is not correct");
		}
		if (a == true) {
			test11.pass("Section title is correct");
		}

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/h3")).getText();
		if (question1.equals("Can I monitor my child's iPad from my Android device?")) {
			test11.pass("Question 1 correct");
		} else {
			test11.fail("Question 1 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/p")).getText();
		if (answer1.equals(
				"Yes, you can. First, set up Mobicip in Parent Mode on your Android device, then set up Mobicip in Child Mode on your child's iPad. With Mobicip parental controls , parents can monitor their child's iPhones, iPads, Android phones/tablets, Kindle Fire, Mac, Windows devices or Chromebooks from any device of their choice.")) {
			test11.pass("Answer 1 correct");
		} else {
			test11.fail("Answer 1 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/h3")).getText();
		if (question2.equals("Can my child uninstall Mobicip from iOS devices?")) {
			test11.pass("Question 2 correct");
		} else {
			test11.fail("Question 2 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/p")).getText();
		if (answer2.equals(
				"While most parental control apps can be uninstalled or disabled, Mobicip offers an extra layer of protection. Uninstall Protection requires a parent's iTunes credentials to remove the app, making it more difficult for children to bypass parental controls.This added security feature gives parents peace of mind knowing their child's safety is not compromised.")) {
			test11.pass("Answer 2 correct");
		} else {
			test11.fail("Answer 2 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/h3")).getText();
		if (question3.equals("Does Mobicip block inappropriate videos on the YouTube app in iPads?")) {
			test11.pass("Question 3 correct");
		} else {
			test11.fail("Question 3 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/p")).getText();
		if (answer3.equals(
				"Mobicip allows parents to filter videos, block inappropriate video content and set YouTube parental controls on the iPad. The latest version of Mobicip works using VPN technology that allows it to filter videos directly on the Youtube app. In addition, Mobicip already filters videos on the YouTube website.")) {
			test11.pass("Answer 3 correct");
		} else {
			test11.fail("Answer 3 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test11.fail("Form is not present");
		}
		if (a == true) {
			test11.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 14)
	public void b7_section6() throws InterruptedException {
		ExtentTest test43 = extentreport.createTest("section 6,7", "To check the Prelogin iPad web page section 6,7");
		extentTest.set(test43);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test43.fail("iPad page - Build better is not present");
		}
		if (a == true) {
			test43.pass("iPad page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test43.fail("iPad page - Footer is not present");
		}
		if (a == true) {
			test43.pass("iPad page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 15)
	public void c1_AndroidPage() throws InterruptedException {
		ExtentTest test12 = extentreport.createTest("Android page",
				"To check the Prelogin Android web page title,header");
		extentTest.set(test12);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[1]/ul/li[3]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test12.fail("Pre login - Footer Android redirect failed");
		}
		if (a == true) {
			test12.pass("Pre login - Footer Android redirects to Android Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Android Parental control app for your kid’s devices - Mobicip | Mobicip")) {
			test12.pass("Android Page title is correct");
		} else {
			test12.fail("Android Page title isn't correct");
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
			test12.fail("Pre login Android page - Header is incorrect");
		}
		if (a == true) {
			test12.pass("Pre login Android page - Header is correct");
		}
	}

	@Test(priority = 16)
	public void c2_section1() throws InterruptedException {
		ExtentTest test13 = extentreport.createTest("section 1", "To check the Prelogin Android web page section 1");
		extentTest.set(test13);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Android Parental Controls for Busy & Involved Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Section title is not correct");
		}
		if (a == true) {
			test13.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//*[text()='Big Tech loves to keeps your child engaged 24x7. Smart parents like you know better.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Section sub title is not correct");
		}
		if (a == true) {
			test13.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Start Free Trial button redirects failed");
		}
		if (a == true) {
			test13.pass("Start Free Trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Download icon not present");
		}
		if (a == true) {
			test13.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test13.fail("Background Image not present");
		}
		if (a == true) {
			test13.pass("Background Image present");
		}
	}

	@Test(priority = 17)
	public void c3_section2() throws InterruptedException {
		ExtentTest test14 = extentreport.createTest("section 2", "To check the Prelogin Android web page section 2");
		extentTest.set(test14);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Keep in Touch With Your Family’s Digital Life']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Section title is not correct");
		}
		if (a == true) {
			test14.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Track Location']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Feature - Track Location text not correct");
		}
		if (a == true) {
			test14.pass("1 - Track Location text correct");
		}

		String f2 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p")).getText();
		if (f2.equals("Set geofences & locate your kids on demand")) {
			test14.pass("sub text correct");
		} else {
			test14.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Family locator page redirects failed");
		}
		if (a == true) {
			test14.pass("Family locator page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Feature - Schedule & Limit Screen Time not present");
		}
		if (a == true) {
			test14.pass("2 - Schedule & Limit Screen Time text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/p")).getText();
		if (f3.equals("Set healthy time limits for how and when the phone or tab is used")) {
			test14.pass("sub text correct");
		} else {
			test14.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test14.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).click();
		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test14.pass("3 - Monitor Social Media text correct");
		} else {
			test14.fail("Feature - Monitor Social Media text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Get alerted on risky interactions on Facebook & Snapchat']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("sub text not correct");
		}
		if (a == true) {
			test14.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test14.pass("4 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f4 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p")).getText();
		if (f4.equals("Block websites , filter adult content and keep your kids safe online")) {
			test14.pass("sub text correct");
		} else {
			test14.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Website blocker page redirects failed");
		}
		if (a == true) {
			test14.pass("Website blocker page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Block Apps']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Block Apps']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Feature - Block Apps text not correct");
		}
		if (a == true) {
			test14.pass("5 - Block Apps text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Completely block distracting, inappropriate or addictive games and apps.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("sub text not correct");
		}
		if (a == true) {
			test14.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Set App Limits']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Set App Limits']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Feature - Set App Limits text not correct");
		}
		if (a == true) {
			test14.pass("6 - Set App Limits text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f6 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/p")).getText();
		if (f6.equals("Set screen time allowances for specific categories and apps.")) {
			test14.pass("sub text correct");
		} else {
			test14.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/p/strong/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test14.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/h3")).click();

		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/h3")).getText();
		if (f7.equals("View Activity Summary")) {
			test14.pass("7 - View Activity Summary text correct");
		} else {
			test14.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String feature = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/p")).getText();
		if (feature.equals("Get a daily snapshot of your family's device usage.")) {
			test14.pass("sub text correct");
		} else {
			test14.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test14.pass("8 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Child dashboard shows how they spend their time online every day']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("sub text not correct");
		}
		if (a == true) {
			test14.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test14.fail("Image not present");
		}
		if (a == true) {
			test14.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 18)
	public void c4_section3() throws InterruptedException {
		ExtentTest test15 = extentreport.createTest("section 3", "To check the Prelogin Android web page section 3");
		extentTest.set(test15);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Parental Control is Easier Said than Done.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Section title is not correct");
		}
		if (a == true) {
			test15.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("We can do this together. Follow our Step-by-Step Instructions")) {
			test15.pass("Section sub title is correct");
		} else {
			test15.fail("Section sub title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Step-by-Step Instructions redirects failed");
		}
		if (a == true) {
			test15.pass("Step-by-Step Instructions redirects Pass");
		}
		webDriver.navigate().back();

		webDriver.findElement(By.xpath("//div[@class='get_started_wrapper']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test15.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test15.pass("Download text is correct");
		} else {
			test15.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Download icon not present");
		}
		if (a == true) {
			test15.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test15.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test15.pass("Sign Up text is correct");
		} else {
			test15.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Create username & password text not present");
		}
		if (a == true) {
			test15.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test15.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test15.pass("Configure text is correct");
		} else {
			test15.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test15.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test15.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test15.pass("Monitor text is correct");
		} else {
			test15.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test15.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test15.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 19)
	public void c5_section4() throws InterruptedException {
		ExtentTest test16 = extentreport.createTest("section 4", "To check the Prelogin Android web page section 4");
		extentTest.set(test16);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Watch the Video Walkthrough']"));
		} catch (NoSuchElementException e) {
			a = false;
			test16.fail("Section title is not correct");
		}
		if (a == true) {
			test16.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Android Parental Controls']"));
		} catch (NoSuchElementException e) {
			a = false;
			test16.fail("Section sub title is not correct");
		}
		if (a == true) {
			test16.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test16.fail("video is not present");
		}
		if (a == true) {
			test16.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 20)
	public void c6_section5() throws InterruptedException {
		ExtentTest test17 = extentreport.createTest("section 5", "To check the Prelogin Android web page section 5");
		extentTest.set(test17);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		TimeUnit.SECONDS.sleep(3);

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/h3")).getText();
		if (question1.equals("Why is Mobicip the best parental control solution for Android devices?")) {
			test17.pass("Question 1 correct");
		} else {
			test17.fail("Question 1 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/p")).getText();
		if (answer1.equals(
				"Mobicip's real-time content filtering is one of the smartest & most robust internet filters available in the market today. Several independent 3rd party assessments have repeatedly shown how Mobicip is way ahead of peers with respect to its filtering technology. Keeping the modern multi-device family in mind, Mobicip is available on a wide range of operating systems & platforms. Parents can set up Mobicip on any combination of family devices involving iPhones, iPads, Android phones or tablets, Kindle Fire, Mac, Windows devices and Chromebooks. Mobicip takes child data privacy very seriously and is compliant with the Children's Online Privacy Protection Act (“COPPA”).")) {
			test17.pass("Answer 1 correct");
		} else {
			test17.fail("Answer 1 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/h3")).getText();
		if (question2.equals("Can Mobicip filter videos on the YouTube app on Android phones & tablets?")) {
			test17.pass("Question 2 correct");
		} else {
			test17.fail("Question 2 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/p")).getText();
		if (answer2.equals(
				"The latest version of Mobicip works using VPN, and so is now able to filter the native YouTube app. However due to restrictions set by Google & YouTube, 3rd-party parental control apps like Mobicip will not be able to filter videos on the YouTube app for devices running Android 7.0 (Nougat) or higher versions (Oreo, Pie & Android 10). But Mobicip's parental controls for YouTube can still filter videos when accessed through a browser. All you need to do is block access to the native YouTube app to ensure that YouTube can be accessed only on a browser. Mobicip filters YouTube by reviewing the title, description, comments and other meta information associated with each video. Mobicip's rich reporting feature also allows parents to view the list of videos watched by their kids!")) {
			test17.pass("Answer 2 correct");
		} else {
			test17.fail("Answer 2 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/h3")).getText();
		if (question3.equals("Can my child uninstall Mobicip from Android devices?")) {
			test17.pass("Question 3 correct");
		} else {
			test17.fail("Question 3 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/p")).getText();
		if (answer3.equals(
				"When installed as recommended, it will be impossible for kids to uninstall or disable Mobicip's Android parental controls. During setup parents are asked to grant Mobicip access to certain permissions (Device Admin & Accessibility Services); when setup correctly in this manner, children will not be able to uninstall Mobicip from their Android phone or tablet. If those permissions aren't granted to Mobicip, kids might be able to uninstall or disable Mobicip; but parents will still be notified immediately, allowing them to be one step ahead of their tech-savvy kids.")) {
			test17.pass("Answer 3 correct");
		} else {
			test17.fail("Answer 3 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test17.fail("Form is not present");
		}
		if (a == true) {
			test17.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 21)
	public void c7_section6() throws InterruptedException {
		ExtentTest test44 = extentreport.createTest("section 6,7",
				"To check the Prelogin Android web page section 6,7");
		extentTest.set(test44);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test44.fail("Android page - Build better is not present");
		}
		if (a == true) {
			test44.pass("Android page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test44.fail("Android page - Footer is not present");
		}
		if (a == true) {
			test44.pass("Android page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 22)
	public void d1_kindlePage() throws InterruptedException {
		ExtentTest test18 = extentreport.createTest("Kindle page",
				"To check the Prelogin Kindle web page title,header");
		extentTest.set(test18);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[1]/ul/li[4]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test18.fail("Pre login - Footer kindle redirect failed");
		}
		if (a == true) {
			test18.pass("Pre login - Footer kindle redirects to kindle Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control app for your child's Kindle Fire | Mobicip")) {
			test18.pass("kindle Page title is correct");
		} else {
			test18.fail("kindle Page title isn't correct");
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
			test18.fail("Pre login kindle page - Header is incorrect");
		}
		if (a == true) {
			test18.pass("Pre login kindle page - Header is correct");
		}
	}

	@Test(priority = 23)
	public void d2_section1() throws InterruptedException {
		ExtentTest test19 = extentreport.createTest("section 1", "To check the Prelogin kindle web page section 1");
		extentTest.set(test19);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Universal Kindle Fire Parental Controls for Busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test19.fail("Section title is not correct");
		}
		if (a == true) {
			test19.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()='The Kindle Fire is One of the Best Readers, but You Know Too Much of a Good Thing May Not be as Good.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test19.fail("Section sub title is not correct");
		}
		if (a == true) {
			test19.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test19.fail("Start Free Trial button redirects failed");
		}
		if (a == true) {
			test19.pass("Start Free Trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test19.fail("Download icon not present");
		}
		if (a == true) {
			test19.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test19.fail("Background Image not present");
		}
		if (a == true) {
			test19.pass("Background Image present");
		}
	}

	@Test(priority = 24)
	public void d3_section2() throws InterruptedException {
		ExtentTest test20 = extentreport.createTest("section 2", "To check the Prelogin kindle web page section 2");
		extentTest.set(test20);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Help Digital Kids Learn to be Responsible']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Section title is not correct");
		}
		if (a == true) {
			test20.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Track Location']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Feature - Track Location text not correct");
		}
		if (a == true) {
			test20.pass("1 - Track Location text correct");
		}

		String f2 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p")).getText();
		if (f2.equals("Set geofences & locate your kids on demand")) {
			test20.pass("sub text correct");
		} else {
			test20.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Family locator page redirects failed");
		}
		if (a == true) {
			test20.pass("Family locator page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Feature - Schedule & Limit Screen Time not present");
		}
		if (a == true) {
			test20.pass("2 - Schedule & Limit Screen Time text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/p")).getText();
		if (f3.equals("Set healthy time limits for how and when the Kindle Fire is used")) {
			test20.pass("sub text correct");
		} else {
			test20.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test20.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).click();
		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test20.pass("Feature - Monitor Social Media text correct");
		} else {
			test20.fail("3 - Monitor Social Media text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Get alerted on risky interactions on Facebook.']"));
		} catch (NoSuchElementException e) {
			a = false;
			System.out.println();
			test20.fail("sub text not correct");
		}
		if (a == true) {
			test20.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test20.pass("4 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f4 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p")).getText();
		if (f4.equals("Block websites, filter adult content and keep your kids safe online")) {
			test20.pass("sub text correct");
		} else {
			test20.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Website Blocker page redirects failed");
		}
		if (a == true) {
			test20.pass("Website Blocker page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Block Apps']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Block Apps']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Feature - Block Apps text not correct");
		}
		if (a == true) {
			test20.pass("5 - Block Apps text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Completely block distracting, inappropriate or addictive games and apps.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("sub text not correct");
		}
		if (a == true) {
			test20.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Set App Limits']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Set App Limits']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Feature - Set App Limits text not correct");
		}
		if (a == true) {
			test20.pass("6 - Set App Limits text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f6 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/p")).getText();
		if (f6.equals("Set screen time allowances for specific categories and apps.")) {
			test20.pass("sub text correct");
		} else {
			test20.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[6]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test20.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/h3")).click();

		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/h3")).getText();
		if (f7.equals("View Activity Summary")) {
			test20.pass("7 - View Activity Summary text correct");
		} else {
			test20.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String feature = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[7]/p")).getText();
		if (feature.equals("Get a daily snapshot of your family's device usage."))

		{
			test20.pass("sub text correct");
		} else {
			test20.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test20.pass("8 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Child dashboard shows how they spend their time online every day']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("sub text not correct");
		}
		if (a == true) {
			test20.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test20.fail("Image not present");
		}
		if (a == true) {
			test20.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 25)
	public void d4_section3() throws InterruptedException {
		ExtentTest test21 = extentreport.createTest("section 3", "To check the Prelogin kindle web page section 3");
		extentTest.set(test21);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Parental Controls is Tough. So Let’s Get Going.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Section title is not correct");
		}
		if (a == true) {
			test21.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("We can do this together. Follow our Step-by-Step Instructions")) {
			test21.pass("Section sub title is correct");
		} else {
			test21.fail("Section sub title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Step-by-Step Instructions redirects failed");
		}
		if (a == true) {
			test21.pass("Step-by-Step Instructions redirects Pass");
		}
		webDriver.navigate().back();

		webDriver.findElement(By.xpath("//div[@class='get_started_wrapper']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test21.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test21.pass("Download text is correct");
		} else {
			test21.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Download icon not present");
		}
		if (a == true) {
			test21.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test21.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test21.pass("Sign Up text is correct");
		} else {
			test21.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Create username & password text not present");
		}
		if (a == true) {
			test21.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test21.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test21.pass("Configure text is correct");
		} else {
			test21.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test21.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test21.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test21.pass("Monitor text is correct");
		} else {
			test21.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test21.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test21.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 26)
	public void d5_section4() throws InterruptedException {
		ExtentTest test22 = extentreport.createTest("section 4", "To check the Prelogin kindle web page section 4");
		extentTest.set(test22);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Watch the Video Walkthrough']"));
		} catch (NoSuchElementException e) {
			a = false;
			test22.fail("Section title is not correct");
		}
		if (a == true) {
			test22.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test22.fail("video is not present");
		}
		if (a == true) {
			test22.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 27)
	public void d6_section5() throws InterruptedException {
		ExtentTest test23 = extentreport.createTest("section 5", "To check the Prelogin kindle web page section 5");
		extentTest.set(test23);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		TimeUnit.SECONDS.sleep(3);

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/h3")).getText();
		if (question1.equals("Why parental controls for the Kindle Fire?")) {
			test23.pass("Question 1 correct");
		} else {
			test23.fail("Question 1 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/p")).getText();
		if (answer1.equals(
				"The Kindle is a global leader in the e-book reader/tablet segment. The Kindle Fire is the first digital device for millions of young children, used as a stepping-stone to ease their entry into the connected world that is the internet. Instilling a sense of digital discipline right from childhood is therefore extremely crucial.")) {
			test23.pass("Answer 1 correct");
		} else {
			test23.fail("Answer 1 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/h3")).getText();
		if (question2.equals("Can I manage screen time on the Kindle Fire?")) {
			test23.pass("Question 2 correct");
		} else {
			test23.fail("Question 2 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/p")).getText();
		if (answer2.equals(
				"Yes, absolutely. You can block or allow screen time during specific daily/weekly schedules. When screen time is blocked, your kid's Kindle Fire would be completely unusable.")) {
			test23.pass("Answer 2 correct");
		} else {
			test23.fail("Answer 2 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/h3")).getText();
		if (question3.equals("Can I block apps on the Kindle Fire, with Mobicip?")) {
			test23.pass("Question 3 correct");
		} else {
			test23.fail("Question 3 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/p")).getText();
		if (answer3.equals(
				"Yes, absolutely. Once you block an app, your child won't be able to access or use it at all. If your child still goes ahead and clicks on the blocked app, a custom block-page will be displayed on the screen.")) {
			test23.pass("Answer 3 correct");
		} else {
			test23.fail("Answer 3 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test23.fail("Form is not present");
		}
		if (a == true) {
			test23.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 28)
	public void d7_section6() throws InterruptedException {
		ExtentTest test45 = extentreport.createTest("section 6,7",
				"To check the Prelogin Kindle fire web page section 6,7");
		extentTest.set(test45);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test45.fail("Kindle fire page - Build better is not present");
		}
		if (a == true) {
			test45.pass("Kindle fire page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test45.fail("Kindle fire page - Footer is not present");
		}
		if (a == true) {
			test45.pass("Kindle fire page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 29)
	public void e1_MacPage() throws InterruptedException {
		ExtentTest test24 = extentreport.createTest("Mac page", "To check the Prelogin Mac web page title,header");
		extentTest.set(test24);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[1]/ul/li[5]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test24.fail("Pre login - Footer Mac redirect failed");
		}
		if (a == true) {
			test24.pass("Pre login - Footer Mac redirects to Mac Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control app for your child's Mac & MacBook | Mobicip")) {
			test24.pass("Mac Page title is correct");
		} else {
			test24.fail("Mac Page title isn't correct");
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
			test24.fail("Pre login Mac page - Header is incorrect");
		}
		if (a == true) {
			test24.pass("Pre login Mac page - Header is correct");
		}
	}

	@Test(priority = 30)
	public void e2_section1() throws InterruptedException {
		ExtentTest test25 = extentreport.createTest("section 1", "To check the Prelogin Mac web page section 1");
		extentTest.set(test25);
		boolean a = true;
		try {
			webDriver
					.findElement(By.xpath("//*[text()='All-in-one Mac & MacBook Parental Controls for Busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test25.fail("Section title is not correct");
		}
		if (a == true) {
			test25.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//*[text()='Filter inappropriate websites, limit screen time and encourage responsible online behaviour.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test25.fail("Section sub title is not correct");
		}
		if (a == true) {
			test25.pass("Section sub title is correct");
		}

		/*
		 * a=true; try {webDriver.findElement(By.
		 * xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"
		 * )).click();} catch(NoSuchElementException e){a=false;
		 * test25.fail("Start Free Trial button redirects failed");}
		 * if(a==true){test25.pass("Start Free Trial button works fine");}
		 * TimeUnit.SECONDS.sleep(2); webDriver.navigate().back();
		 * TimeUnit.SECONDS.sleep(2);
		 */

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test25.fail("Download icon not present");
		}
		if (a == true) {
			test25.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test25.fail("Background Image not present");
		}
		if (a == true) {
			test25.pass("Background Image present");
		}
	}

	@Test(priority = 31)
	public void e3_section2() throws InterruptedException {
		ExtentTest test26 = extentreport.createTest("section 2", "To check the Prelogin Mac web page section 2");
		extentTest.set(test26);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,720)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Stay Involved and Be Informed to be Worry-Free.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Section title is not correct");
		}
		if (a == true) {
			test26.pass("Section title is correct");
		}

		webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Feature - Schedule & Limit Screen Time not present");
		}
		if (a == true) {
			test26.pass("1 - Schedule & Limit Screen Time text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f1 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p")).getText();
		if (f1.equals("Set healthy time limits for how and when the Mac is used")) {
			test26.pass("sub text correct");
		} else {
			test26.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test26.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Image not present");
		}
		if (a == true) {
			test26.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).click();
		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test26.pass("Feature - Monitor Social Media text correct");
		} else {
			test26.fail("2 - Monitor Social Media text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Get alerted on risky interactions on Facebook.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("sub text not correct");
		}
		if (a == true) {
			test26.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Image not present");
		}
		if (a == true) {
			test26.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test26.pass("3 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/p")).getText();
		if (f3.equals("Block websites, filter adult content and keep your kids safe online")) {
			test26.pass("sub text correct");
		} else {
			test26.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Website Blocker page redirects failed");
		}
		if (a == true) {
			test26.pass("Website Blocker page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Image not present");
		}
		if (a == true) {
			test26.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/h3")).click();
		a = true;
		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/h3")).getText();
		if (f7.equals("View Activity Summary")) {
			test26.pass("4 - View Activity Summary text correct");
		} else {
			test26.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String feature = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p")).getText();
		if (feature.equals("Get a daily snapshot of your family's device usage.")) {
			test26.pass("sub text correct");
		} else {
			test26.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Image not present");
		}
		if (a == true) {
			test26.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test26.pass("5 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Child dashboard shows how they spend their time online every day']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("sub text not correct");
		}
		if (a == true) {
			test26.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test26.fail("Image not present");
		}
		if (a == true) {
			test26.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 32)
	public void e4_section3() throws InterruptedException {
		ExtentTest test27 = extentreport.createTest("section 3", "To check the Prelogin Mac web page section 3");
		extentTest.set(test27);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Setting Up Parental Controls Takes a Lot of Hard Work']"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Section title is not correct");
		}
		if (a == true) {
			test27.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("Don’t worry. We can do this together. Follow our Step-by-Step Instructions")) {
			test27.pass("Section sub title is correct");
		} else {
			test27.fail("Section sub title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Step-by-Step Instructions redirects failed");
		}
		if (a == true) {
			test27.pass("Step-by-Step Instructions redirects Pass");
		}
		webDriver.navigate().back();

		webDriver.findElement(By.xpath("//div[@class='get_started_wrapper']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test27.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test27.pass("Download text is correct");
		} else {
			test27.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Download icon not present");
		}
		if (a == true) {
			test27.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test27.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test27.pass("Sign Up text is correct");
		} else {
			test27.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Create username & password text not present");
		}
		if (a == true) {
			test27.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test27.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test27.pass("Configure text is correct");
		} else {
			test27.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test27.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test27.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test27.pass("Monitor text is correct");
		} else {
			test27.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test27.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test27.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 33)
	public void e5_section4() throws InterruptedException {
		ExtentTest test28 = extentreport.createTest("section 4", "To check the Prelogin Mac web page section 4");
		extentTest.set(test28);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Watch the Video Walkthrough']"));
		} catch (NoSuchElementException e) {
			a = false;
			test28.fail("Section title is not correct");
		}
		if (a == true) {
			test28.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test28.fail("video is not present");
		}
		if (a == true) {
			test28.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 34)
	public void e6_section5() throws InterruptedException {
		ExtentTest test29 = extentreport.createTest("section 5", "To check the Prelogin Mac web page section 5");
		extentTest.set(test29);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(3);

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/h3")).getText();
		if (question1.equals("Why parental controls for the Mac?")) {
			test29.pass("Question 1 correct");
		} else {
			test29.fail("Question 1 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/p")).getText();
		if (answer1.equals(
				"Mobicip's most popular parental controls for Mac OS lets you block inappropriate web content before it can be viewed. You can also schedule allowed screen time and instantly lock the device for quality family time. Parents can now manage all settings on Mac, Windows, iOS and Android devices for everyone in the family through a single parent dashboard.")) {
			test29.pass("Answer 1 correct");
		} else {
			test29.fail("Answer 1 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/h3")).getText();
		if (question2.equals("How does screen time work on the Mac?")) {
			test29.pass("Question 2 correct");
		} else {
			test29.fail("Question 2 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/p")).getText();
		if (answer2.equals(
				"When your child accesses the Mac during screen time limits, all she would be able to see would be a custom block screen. Essentially, your child's Mac will be completely unusable during screen time limits.")) {
			test29.pass("Answer 2 correct");
		} else {
			test29.fail("Answer 2 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/h3")).getText();
		if (question3.equals("Can children remove Mobicip from a Mac?")) {
			test29.pass("Question 3 correct");
		} else {
			test29.fail("Question 3 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/p")).getText();
		if (answer3.equals("No they can't. Only the registered admin user can uninstall Mobicip from the Mac.")) {
			test29.pass("Answer 3 correct");
		} else {
			test29.fail("Answer 3 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test29.fail("Form is not present");
		}
		if (a == true) {
			test29.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 35)
	public void e7_section6() throws InterruptedException {
		ExtentTest test46 = extentreport.createTest("section 6,7", "To check the Prelogin Mac web page section 6,7");
		extentTest.set(test46);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test46.fail("Mac page - Build better is not present");
		}
		if (a == true) {
			test46.pass("Mac page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test46.fail("Mac page - Footer is not present");
		}
		if (a == true) {
			test46.pass("Mac page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 36)
	public void f1_WindowsPage() throws InterruptedException {
		ExtentTest test30 = extentreport.createTest("Windows page",
				"To check the Prelogin Windows web page title,header");
		extentTest.set(test30);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[1]/ul/li[6]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test30.fail("Pre login - Footer Windows redirect failed");
		}
		if (a == true) {
			test30.pass("Pre login - Footer Windows redirects to Windows Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control software for Windows | Mobicip")) {
			test30.pass("Windows Page title is correct");
		} else {
			test30.fail("Windows Page title isn't correct");
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
			test30.fail("Pre login Windows page - Header is incorrect");
		}
		if (a == true) {
			test30.pass("Pre login Windows page - Header is correct");
		}
	}

	@Test(priority = 37)
	public void f2_section1() throws InterruptedException {
		ExtentTest test31 = extentreport.createTest("section 1", "To check the Prelogin Windows web page section 1");
		extentTest.set(test31);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Smart Windows Parental Controls for Super-busy Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test31.fail("Section title is not correct");
		}
		if (a == true) {
			test31.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()='Stay involved and informed about your family’s digital footprint, anytime anywhere']"));
		} catch (NoSuchElementException e) {
			a = false;
			test31.fail("Section sub title is not correct");
		}
		if (a == true) {
			test31.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test31.fail("Start Free Trial button redirects failed");
		}
		if (a == true) {
			test31.pass("Start Free Trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test31.fail("Download icon not present");
		}
		if (a == true) {
			test31.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test31.fail("Background Image not present");
		}
		if (a == true) {
			test31.pass("Background Image present");
		}
	}

	@Test(priority = 38)
	public void f3_section2() throws InterruptedException {
		ExtentTest test32 = extentreport.createTest("section 2", "To check the Prelogin Windows web page section 2");
		extentTest.set(test32);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,720)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Your Peace of Mind Matters. Be in the Know.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Section title is not correct");
		}
		if (a == true) {
			test32.pass("Section title is correct");
		}

		webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Feature - Schedule & Limit Screen Time not present");
		}
		if (a == true) {
			test32.pass("1 - Schedule & Limit Screen Time text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f1 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p")).getText();
		if (f1.equals("Set healthy time limits around how and when your kids use their Windows device.")) {
			test32.pass("sub text correct");
		} else {
			test32.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test32.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Image not present");
		}
		if (a == true) {
			test32.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).click();

		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test32.pass("Feature - Monitor Social Media text correct");
		} else {
			test32.fail("2 - Monitor Social Media text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Get alerted on risky interactions on Facebook.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("sub text not correct");
		}
		if (a == true) {
			test32.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Image not present");
		}
		if (a == true) {
			test32.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test32.pass("3 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/p")).getText();
		if (f3.equals("Block websites, filter adult content and keep your kids safe online")) {
			test32.pass("sub text correct");
		} else {
			test32.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Website Blocker page redirects failed");
		}
		if (a == true) {
			test32.pass("Website Blocker page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Image not present");
		}
		if (a == true) {
			test32.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/h3")).click();
		a = true;
		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/h3")).getText();
		if (f7.equals("View Activity Summary")) {
			test32.pass("4 - View Activity Summary text correct");
		} else {
			test32.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String feature = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p")).getText();
		if (feature.equals("Get a daily snapshot of your child's device usage.")) {
			test32.pass("sub text correct");
		} else {
			test32.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Image not present");
		}
		if (a == true) {
			test32.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test32.pass("5 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Child dashboard shows how they spend their time online every day']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("sub text not correct");
		}
		if (a == true) {
			test32.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test32.fail("Image not present");
		}
		if (a == true) {
			test32.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 39)
	public void f4_section3() throws InterruptedException {
		ExtentTest test33 = extentreport.createTest("section 3", "To check the Prelogin Windows web page section 3");
		extentTest.set(test33);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Yes, Setting Up Parental Controls is a Challenge']"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Section title is not correct");
		}
		if (a == true) {
			test33.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("Don’t worry. We can do this together. Follow our Step-by-Step Instructions")) {
			test33.pass("Section sub title is correct");
		} else {
			test33.fail("Section sub title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Step-by-Step Instructions redirects failed");
		}
		if (a == true) {
			test33.pass("Step-by-Step Instructions redirects Pass");
		}
		webDriver.navigate().back();

		webDriver.findElement(By.xpath("//div[@class='get_started_wrapper']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test33.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test33.pass("Download text is correct");
		} else {
			test33.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Download icon not present");
		}
		if (a == true) {
			test33.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test33.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test33.pass("Sign Up text is correct");
		} else {
			test33.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Create username & password text not present");
		}
		if (a == true) {
			test33.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test33.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test33.pass("Configure text is correct");
		} else {
			test33.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test33.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test33.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test33.pass("Monitor text is correct");
		} else {
			test33.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test33.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test33.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 40)
	public void f5_section4() throws InterruptedException {
		ExtentTest test34 = extentreport.createTest("section 4", "To check the Prelogin Windows web page section 4");
		extentTest.set(test34);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Watch the Video Walkthrough']"));
		} catch (NoSuchElementException e) {
			a = false;
			test34.fail("Section title is not correct");
		}
		if (a == true) {
			test34.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test34.fail("video is not present");
		}
		if (a == true) {
			test34.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 41)
	public void f6_section5() throws InterruptedException {
		ExtentTest test35 = extentreport.createTest("section 5", "To check the Prelogin Windows web page section 5");
		extentTest.set(test35);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,800)");
		TimeUnit.SECONDS.sleep(3);

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/h3")).getText();
		if (question1.equals("Why is Mobicip's internet filter better than other web filters?")) {
			test35.pass("Question 1 correct");
		} else {
			test35.fail("Question 1 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/p")).getText();
		if (answer1.equals(
				"Most parental controls use a fixed database of blacklisted urls to filter web content. Mobicip's advanced internet filter scan keywords, phrases and on-page content in real-time and only blocks inappropriate or adult content.")) {
			test35.pass("Answer 1 correct");
		} else {
			test35.fail("Answer 1 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/h3")).getText();
		if (question2.equals("Can my child uninstall Mobicip on Windows 10?")) {
			test35.pass("Question 2 correct");
		} else {
			test35.fail("Question 2 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/p")).getText();
		if (answer2.equals(
				"Only the registered admin can uninstall Mobicip. So rest assured; your kids can't remove Mobicip on their own.")) {
			test35.pass("Answer 2 correct");
		} else {
			test35.fail("Answer 2 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/h3")).getText();
		if (question3.equals("I am not tech-saavy. Where can I find help?")) {
			test35.pass("Question 3 correct");
		} else {
			test35.fail("Question 3 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/p")).getText();
		if (answer3.equals(
				"We have tons of tutorials, videos, FAQs and blogs to help you out. Check out our helpdesk. Contact us if you need further assistance. Several grandparents use Mobicip, it's not that difficult to figure it out.")) {
			test35.pass("Answer 3 correct");
		} else {
			test35.fail("Answer 3 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test35.fail("Form is not present");
		}
		if (a == true) {
			test35.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 42)
	public void f7_section6() throws InterruptedException {
		ExtentTest test47 = extentreport.createTest("section 6,7",
				"To check the Prelogin Windows web page section 6,7");
		extentTest.set(test47);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test47.fail("Windows page - Build better is not present");
		}
		if (a == true) {
			test47.pass("Windows page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test47.fail("Windows page - Footer is not present");
		}
		if (a == true) {
			test47.pass("Windows page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 43)
	public void g1_ChromebookPage() throws InterruptedException {
		ExtentTest test36 = extentreport.createTest("Chromebook page",
				"To check the Prelogin Chromebook web page title,header");
		extentTest.set(test36);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[1]/ul/li[7]/a"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test36.fail("Pre login - Footer Chromebook redirect failed");
		}
		if (a == true) {
			test36.pass("Pre login - Footer Chromebook redirects to Chromebook Platform page");
		}

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Best Parental control software for your child's ChromeBook | Mobicip")) {
			test36.pass("Chromebook Page title is correct");
		} else {
			test36.fail("Chromebook Page title isn't correct");
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
			test36.fail("Pre login Chromebook page - Header is incorrect");
		}
		if (a == true) {
			test36.pass("Pre login Chromebook page - Header is correct");
		}
	}

	@Test(priority = 44)
	public void g2_section1() throws InterruptedException {
		ExtentTest test37 = extentreport.createTest("section 1", "To check the Prelogin Chromebook web page section 1");
		extentTest.set(test37);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Chromebook Parental Controls for Tiger Parents']"));
		} catch (NoSuchElementException e) {
			a = false;
			test37.fail("Section title is not correct");
		}
		if (a == true) {
			test37.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//*[text()='Secure the Chromebook and accompany your children as they embark on their digital journey.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test37.fail("Section sub title is not correct");
		}
		if (a == true) {
			test37.pass("Section sub title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='email_btn_container']/child::a[text()='Start Free Trial']"))
					.click();
		} catch (NoSuchElementException e) {
			a = false;
			test37.fail("Start Free Trial button redirects failed");
		}
		if (a == true) {
			test37.pass("Start Free Trial button works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='download_image']/child::a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test37.fail("Download icon not present");
		}
		if (a == true) {
			test37.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='platform_banner_image']/child::picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test37.fail("Background Image not present");
		}
		if (a == true) {
			test37.pass("Background Image present");
		}
	}

	@Test(priority = 45)
	public void g3_section2() throws InterruptedException {
		ExtentTest test38 = extentreport.createTest("section 2", "To check the Prelogin Chromebook web page section 2");
		extentTest.set(test38);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,720)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Stay one step ahead of Big Tech with a watchful eye']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Section title is not correct");
		}
		if (a == true) {
			test38.pass("Section title is correct");
		}

		webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Schedule & Limit Screen Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Feature - Schedule & Limit Screen Time not present");
		}
		if (a == true) {
			test38.pass("1 - Schedule & Limit Screen Time text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f1 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p")).getText();
		if (f1.equals("Set healthy time limits for how and when the chromebook is used")) {
			test38.pass("sub text correct");
		} else {
			test38.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[1]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Screentime page redirects failed");
		}
		if (a == true) {
			test38.pass("Screentime page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Image not present");
		}
		if (a == true) {
			test38.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).click();

		String h3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[2]/h3")).getText();
		if (h3.equals("Monitor Social Media")) {
			test38.pass("Feature - Monitor Social Media text correct");
		} else {
			test38.fail("2 - Monitor Social Media text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Get alerted on risky interactions on Facebook.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("sub text not correct");
		}
		if (a == true) {
			test38.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Image not present");
		}
		if (a == true) {
			test38.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Filter Web Content']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Filter Web Content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Feature - Filter Web Content text not correct");
		}
		if (a == true) {
			test38.pass("3 - Filter Web Content text correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String f3 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/p")).getText();
		if (f3.equals("Block websites, filter adult content and keep your kids safe online")) {
			test38.pass("sub text correct");
		} else {
			test38.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[3]/p/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Website Blocker page redirects failed");
		}
		if (a == true) {
			test38.pass("Website Blocker page redirect passed");
		}
		TimeUnit.SECONDS.sleep(1);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Image not present");
		}
		if (a == true) {
			test38.pass("Image present");
		}

		webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/h3")).click();
		a = true;
		String f7 = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/h3")).getText();
		if (f7.equals("View Activity Summary")) {
			test38.pass("4 - View Activity Summary text correct");
		} else {
			test38.fail("Feature - View Activity Summary text not correct");
		}
		TimeUnit.SECONDS.sleep(1);

		String feature = webDriver.findElement(By.xpath("//ul[@class='sub_features_ul']/li[4]/p")).getText();
		if (feature.equals("Get a daily snapshot of your family's device usage.")) {
			test38.pass("sub text correct");
		} else {
			test38.fail("sub text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Image not present");
		}
		if (a == true) {
			test38.pass("Image present");
		}

		webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Teach Self-Regulation']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Feature - Teach Self-Regulation text not correct");
		}
		if (a == true) {
			test38.pass("5 - Teach Self-Regulation text correct");
		}

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//*[text()='Child dashboard shows how they spend their time online every day']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("sub text not correct");
		}
		if (a == true) {
			test38.pass("sub text correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//*[@id=\'sub_feature\']"));
		} catch (NoSuchElementException e) {
			a = false;
			test38.fail("Image not present");
		}
		if (a == true) {
			test38.pass("Image present");
		}
		TimeUnit.SECONDS.sleep(1);
	}

	@Test(priority = 46)
	public void g4_section3() throws InterruptedException {
		ExtentTest test39 = extentreport.createTest("section 3", "To check the Prelogin Chromebook web page section 3");
		extentTest.set(test39);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Setting Up Parental Controls is Not for the Faint of Heart']"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Section title is not correct");
		}
		if (a == true) {
			test39.pass("Section title is correct");
		}

		String subtitle = webDriver.findElement(By.xpath("//p[@class='get_started_label']")).getText();
		if (subtitle.equals("Don’t worry. We can do this together. Follow our Step-by-Step Instructions")) {
			test39.pass("Section sub title is correct");
		} else {
			test39.fail("Section sub title is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='get_started_label']/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Step-by-Step Instructions redirects failed");
		}
		if (a == true) {
			test39.pass("Step-by-Step Instructions redirects Pass");
		}
		webDriver.navigate().back();

		webDriver.findElement(By.xpath("//div[@class='get_started_wrapper']")).click();
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Step 1 - Download not present");
		}
		if (a == true) {
			test39.pass("Step 1 - Download present");
		}

		String download = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/span")).getText();
		if (download.equals("Download")) {
			test39.pass("Download text is correct");
		} else {
			test39.fail("Download text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[1]/div/a/picture/img"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Download icon not present");
		}
		if (a == true) {
			test39.pass("Download icon present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Step 2 - Signup not present");
		}
		if (a == true) {
			test39.pass("Step 2 - Signup present");
		}

		String signup = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[2]/span")).getText();
		if (signup.equals("Sign Up")) {
			test39.pass("Sign Up text is correct");
		} else {
			test39.fail("Sign Up text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Create username & 'and text()=' password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Create username & password text not present");
		}
		if (a == true) {
			test39.pass("Create username & password text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Step 3 - Configure not present");
		}
		if (a == true) {
			test39.pass("Step 3 - Configure present");
		}

		String configure = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[3]/span")).getText();
		if (configure.equals("Configure")) {
			test39.pass("Configure text is correct");
		} else {
			test39.fail("Configure text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Setup your 'and text()=' family devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Setup your family devices text not present");
		}
		if (a == true) {
			test39.pass("Setup your family devices text present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]"));
			webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Step 4 - Monitor not present");
		}
		if (a == true) {
			test39.pass("Step 4 - Monitor present");
		}

		String monitor = webDriver.findElement(By.xpath("//ul[@class='get_started_ul']/li[4]/span")).getText();
		if (monitor.equals("Monitor")) {
			test39.pass("Monitor text is correct");
		} else {
			test39.fail("Monitor text is not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Monitor online 'and text()=' activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test39.fail("Monitor online activity text not present");
		}
		if (a == true) {
			test39.pass("Monitor online activity text present");
		}
	}

	@Test(priority = 47)
	public void g5_section4() throws InterruptedException {
		ExtentTest test40 = extentreport.createTest("section 4", "To check the Prelogin Chromebook web page section 4");
		extentTest.set(test40);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;

		try {
			webDriver.findElement(By.xpath("//*[text()='Watch the Video Walkthrough']"));
		} catch (NoSuchElementException e) {
			a = false;
			test40.fail("Section title is not correct");
		}
		if (a == true) {
			test40.pass("Section title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='video_container']/iframe"));
		} catch (NoSuchElementException e) {
			a = false;
			test40.fail("video is not present");
		}
		if (a == true) {
			test40.pass("video is present");
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Test(priority = 48)
	public void g6_section5() throws InterruptedException {
		ExtentTest test41 = extentreport.createTest("section 5", "To check the Prelogin Chromebook web page section 5");
		extentTest.set(test41);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		String question1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/h3")).getText();
		if (question1.equals("Why are parental controls on Chromebook essential?")) {
			test41.pass("Question 1 correct");
		} else {
			test41.fail("Question 1 not correct");
		}

		String answer1 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[1]/p")).getText();
		if (answer1.equals(
				"Research shows that learning responsible use of the Internet and screen time, especially at younger ages, helps children develop into healthy netizens in adulthood. More than half of American primary & secondary school students use Chromebooks. Thus parental controls for Chromebook play a huge role in ensuring digital citizenship.")) {
			test41.pass("Answer 1 correct");
		} else {
			test41.fail("Answer 1 not correct");
		}

		String question2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/h3")).getText();
		if (question2.equals("Does Mobicip provide App Monitoring on Chromebook?")) {
			test41.pass("Question 2 correct");
		} else {
			test41.fail("Question 2 not correct");
		}

		String answer2 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[2]/p")).getText();
		if (answer2.equals("No, App Monitoring is supported only on iOS and Android devices at this time.")) {
			test41.pass("Answer 2 correct");
		} else {
			test41.fail("Answer 2 not correct");
		}

		String question3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/h3")).getText();
		if (question3.equals("Why is Mobicip better than other Chromebook parental controls?")) {
			test41.pass("Question 3 correct");
		} else {
			test41.fail("Question 3 not correct");
		}

		String answer3 = webDriver
				.findElement(By.xpath("//ul[@class='question_wrapper faq_container three-layout']/li[3]/p")).getText();
		if (answer3.equals(
				"It is no longer enough to allow or block domains. Filtering the internet of today requires a dynamic filter that does deep packet inspection, like Mobicip. With its screen time limiting feature, Mobicip has become a truly holistic Chromebook parental control app designed for the modern digital family.")) {
			test41.pass("Answer 3 correct");
		} else {
			test41.fail("Answer 3 not correct");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,600)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='faq_form_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			test41.fail("Form is not present");
		}
		if (a == true) {
			test41.pass("Form is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 49)
	public void g7_section6() throws InterruptedException {
		ExtentTest test48 = extentreport.createTest("section 6,7",
				"To check the Prelogin Chromebook web page section 6,7");
		extentTest.set(test48);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test48.fail("Chromebook page - Build better is not present");
		}
		if (a == true) {
			test48.pass("Chromebook page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test48.fail("Chromebook page - Footer is not present");
		}
		if (a == true) {
			test48.pass("Chromebook page - Footer is present");
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
