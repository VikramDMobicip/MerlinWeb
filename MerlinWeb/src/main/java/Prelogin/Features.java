package Prelogin;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Features extends BrowserSetupClass {

	// ExtentReports extentreport;
	// ExtentSparkReporter spark;

	/*
	 * @BeforeSuite public void beforeTest() {
	 * 
	 * extentreport = new ExtentReports(); spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\TestFeatures\\reportFeatures.html");
	 * extentreport.attachReporter(spark); }
	 */
	// Checking the Home page opening properly
	@Test(priority = 1)
	public void a1_Homepage() {
		ExtentTest test = extentreport.createTest("Home page", "Checking the Home page opening properly");
		extentTest.set(test);
		String tit = webDriver.getTitle();
		System.out.println(tit);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tit.equals("Best Parental Control App for Busy Parents | Mobicip"))

		{
			test.pass("Homepage title is correct");
		} else {
			test.fail("Homepage title is incorrect");
		}
	}

	// Checking the Features button is present properly in home page
	@Test(priority = 2)
	public void a2_Featuresbutton() {
		ExtentTest test = extentreport.createTest("Features button",
				"Checking the Features button is present properly in home page");
		extentTest.set(test);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Features']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Features button is not present in home page");
		}
		if (a == true) {
			test.pass("Features button is present properly in home page");
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Screen Time Scheduler']"));
			webDriver.findElement(
					By.xpath("//p[text()='Create schedules to limit screen ' and text()=' time & app usage']"));
			webDriver.findElement(By.xpath("//span[text()='Social Media Monitor']"));
			webDriver.findElement(
					By.xpath("//p[text()='Monitor social media & prevent ' and text()=' risky behavior']"));
			webDriver.findElement(By.xpath("//span[@class='title' and text()='App Blocker']"));
			webDriver.findElement(By.xpath("//p[text()='Limit and block distractive ' and text()=' apps']"));
			webDriver.findElement(By.xpath("//span[@class='title' and text()='Activity Summary']"));
			webDriver.findElement(
					By.xpath("//p[text()='Keep track of how your children ' and text()=' spend their time online']"));
			webDriver.findElement(By.xpath("//span[@class='title' and text()='Website Blocker']"));
			webDriver.findElement(By.xpath("//p[text()='Monitor & block adult ' and text()=' websites']"));
			webDriver.findElement(By.xpath("//span[@class='title' and text()='Family Locator']"));
			webDriver.findElement(
					By.xpath("//p[text()='Locate your children and set geo-boundaries to ensure their safety']"));
			webDriver.findElement(By.xpath("//span[@class='title' and text()='Expert Advice']"));
			webDriver.findElement(By.xpath("//p[text()='Learn parenting tips from experts on digital wellness']"));
			webDriver.findElement(By.xpath("//span[@class='title' and text()='Collaboration']"));
			webDriver.findElement(By.xpath("//p[text()='Team up with co-parents / guardians & your child']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("All Features are not shown in Features pop-up");
		}
		if (a == true) {
			test.pass("All Features are shown in Features pop-up");
		}
	}

	// Checking the elements in Screen time page Screen time - Title, Screen time -
	// Header, Screen time - Defination, Screen time - Start free trail button,
	// Screen time - Features, Screen time - Importance, Screen time - Effects,
	// Screen time - Why Mobicip ?, Screen time - Customer review, Screen time -
	// Build better section, Screen time - Footer.

	@Test(priority = 3)
	public void a3_Screentimepage() {
		ExtentTest test = extentreport.createTest("Screen time page",
				"Checking the elements in Screen time page Screen time ");
		extentTest.set(test);
		webDriver.findElement(By.xpath("//span[text()='Screen Time Scheduler']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Screen Time Parental Controls | Mobicip")) {
			test.pass("Screen time page title is correct");
		} else {
			test.fail("Screen time page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page Header is incorrect");
		}
		if (a == true) {
			test.pass("Screen time page Header is correct");
		}
		// List of features
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page List of features is present");
		}
		if (a == true) {
			test.pass("Screen time page List of features is present");
		}
		// Defination
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='SCREEN TIME']"));
			webDriver.findElement(By.xpath("//span[text()='Schedule Screen Time & App Usage']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Set daily screen time schedules for apps and websites. Limit screen time by app or category, Lock the screen remotely on demand. View screen time usage reports and take corrective action.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page Definition is incorrect");
		}
		if (a == true) {
			test.pass("Screen time page Definition is correct");
		}
		// start free trail
		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page Start Free Trial button is not present");
		}
		if (a == true) {
			test.pass("Screen time page Start Free Trial button is present");
		}
		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,568)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Features of Mobicip Screen Time Scheduler']"));
			webDriver.findElement(By.xpath("//h3[text()='Schedules']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Set schedules for activities like school, homework and sleep to ensure productive learning and healthy habits. Block specific apps and websites, and manage screen time during a schedule.')]"));
			webDriver.findElement(By.xpath("//h3[text()=' Daily Free Time Limit']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Set daily screen time allowed for entertainment with access to games, social media and movies.')]"));
			j.executeScript("window.scrollBy(0,380)");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webDriver.findElement(By.xpath("//h3[text()='Family Time']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Set schedules for activities like school, homework and sleep to ensure productive learning and healthy habits. Block specific apps and websites, and manage screen time during a schedule.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page Features is not present");
		}
		if (a == true) {
			test.pass("Screen time page Features is present");
		}
		// Importance
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Why Limiting Screen Time is Important?']"));
			webDriver.findElement(By.xpath(
					"//p[@class='paragraph_content' and  contains(text(),' Kids are spending more time on screens than ever before.')]"));
			webDriver.findElement(
					By.xpath("//span[text()='How Much Time Kids and Teens Are Spending on Their Screens?']"));
			webDriver.findElement(By.xpath("//div[@class='screentime_stat_image_container screentime_first_stat']"));

			webDriver.findElement(By.xpath("//div[@class='screentime_stats_container']/div[2]/span"));
			webDriver.findElement(By.xpath("//div[@class='screentime_stat_image_container screentime_second_stat']"));
			webDriver.findElement(By.xpath("//a[text()='How do kids bypass Apple Screen Time?']"));
			webDriver.findElement(By.xpath("//a[text()='Negative Effects of Technology & How To Overcome Them']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page Importance is not present");
		}
		if (a == true) {
			test.pass("Screen time page Importance is present");
		}
		j.executeScript("window.scrollBy(0,350)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Effects
		try {
			webDriver.findElement(By.xpath("//h2[text()='Effects of Screen Time on Sleep & Sight']"));
			webDriver.findElement(By.xpath(
					"//p[@class='paragraph_content' and  contains(text(),'The National Sleep Foundation recommends that you should stop using tablets & smartphones at least 30')]"));
			webDriver.findElement(By.xpath("//ul[@class='paragraph_ul']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page Effects is not present");
		}
		if (a == true) {
			test.pass("Screen time page Effects is present");
		}
		j.executeScript("window.scrollBy(0,700)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Why Mobicip ?
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Why Choose Mobicip')]"));
			webDriver.findElement(By.xpath("//span[text()='Apple']/parent::p[@class='paragraph_content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page - Why Mobicip ? is not present");
		}
		if (a == true) {
			test.pass("Screen time page - Why Mobicip ? is present");
		}
		j.executeScript("window.scrollBy(0,800)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Customer review
		// try
		// {webDriver.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Playstore']"));
		// webDriver.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Appstore']"));}
		// catch(NoSuchElementException e){a=false;
		// test.fail("Screen time page - Customer review is not present");}
		// if(a==true){test.pass("Screen time page - Customer review is present");}

		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Build better
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page - Build better is not present");
		}
		if (a == true) {
			test.pass("Screen time page - Build better is present");
		}
		j.executeScript("window.scrollBy(0,550)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page - Footer is not present");
		}
		if (a == true) {
			test.pass("Screen time page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Checking the elements in Social media monitor.
	@Test(priority = 4)
	public void a5_SocialMediaMoniter() {
		ExtentTest test = extentreport.createTest("Social media monitor ",
				"Checking the elements in Social media monitor page Screen time ");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5500)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver
				.findElement(By.xpath(
						"//a[@class='feature_anchor social_media_monitor ']//span[text()='Social Media Monitor']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		if (tit.equals("Powerful Social Media Monitoring & Parental Control Software | Mobicip")) {
			test.pass("Social Media Monitor page title is correct");
		} else {
			test.fail("Social Media Monitor page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page Header is incorrect");
		}
		if (a == true) {
			test.pass("Social Media Monitor page Header is correct");
		}
		// List of features
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page List of features is present");
		}
		if (a == true) {
			test.pass("Social Media Monitor page List of features is present");
		}
		// Defination
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='SOCIAL MEDIA MONITOR']"));
			webDriver.findElement(By.xpath("//span[text()='Parental Monitoring of Social Media']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Receive real-time alerts on dangerous interactions and unhealthy behavior.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page Definition is incorrect");
		}
		if (a == true) {
			test.pass("Social Media Monitor page Definition is correct");
		}
		// start free trail
		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page Start Free Trial button is not present");
		}
		if (a == true) {
			test.pass("Social Media Monitor page Start Free Trial button is present");
		}
		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,568)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Features of Mobicip Social Media Monitor']"));
			webDriver.findElement(By.xpath("//h3[text()='Social Media Monitor']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),' Facebook and Snapchat for harmful content. Real-time alerts help you to prevent cyberbullying and predatory attacks.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Alerts']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Receive alerts in real time when potentially harmful or inappropriate activity is detected.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page Features is not present");
		}
		if (a == true) {
			test.pass("Social Media Monitor page Features is present");
		}
		// Importance
		j.executeScript("window.scrollBy(0,650)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Why Monitor Social Media?']"));
			webDriver.findElement(By.xpath(
					"//h2[text()='Why Monitor Social Media?']/following::div[@class='paragraph_content_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page Importance is not present");
		}
		if (a == true) {
			test.pass("Social Media Monitor page Importance is present");
		}
		j.executeScript("window.scrollBy(0,600)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Customer review
		try {
			webDriver.findElement(By.xpath("//div[@class='rating_wrapper']"));
			webDriver.findElement(By.xpath("//p[@class='review_msg']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page - Customer review is not present");
		}
		if (a == true) {
			test.pass("Social Media Monitor page - Customer review is present");
		}
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Build better
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media Monitor page - Build better is not present");
		}
		if (a == true) {
			test.pass("Social Media Monitor time - Build better is present");
		}
		j.executeScript("window.scrollBy(0,650)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Screen time page - Footer is not present");
		}
		if (a == true) {
			test.pass("Screen time page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Checking the elements in App Blocker page
	@Test(priority = 5)
	public void a6_Appblocker() {
		ExtentTest test = extentreport.createTest("App Blocker page", "Checking the elements in App Blocker page ");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5500)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='feature_anchor app_blocker ']//span[text()='App Blocker']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		if (tit.equals("App Limits Parental Controls | Mobicip")) {
			test.pass("App Blocker page title is correct");
		} else {
			test.fail("App Blocker page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("App Blocker page Header is incorrect");
		}
		if (a == true) {
			test.pass("App Blocker page Header is correct");
		}
		// Banner section
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
			webDriver.findElement(By.xpath("//h1[text()='APP BLOCKER']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Block Distracting Apps &')]"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'Help kids stay focused by blocking and limiting time spent on')]"));
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Banner section is not present");
		}
		if (a == true) {
			test.pass("Banner section is present");
		}
		JavascriptExecutor ja = (JavascriptExecutor) webDriver;
		ja.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Looking for an easier way to manage your child’s iOS and Google Play apps?

		a = true;
		try {
			webDriver
					.findElement(By.xpath("//h2[contains(text(),'Looking for an easier way to manage your child’s')]"));
			webDriver.findElement(By.xpath("//span[text()='Start your free trial']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'and foster a safe and balanced online space for your child.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s App Blocker is your powerful, easy-to-use solution. Gain peace of mind by effortlessly managing app usage, significantly reducing screen time, and fostering healthier digital habits. Whether you need to limit social media exposure, limit gaming hours, or block inappropriate content, Mobicip empowers you to create a safer online world for your family.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail(
					"Looking for an easier way to manage your child’s iOS and Google Play apps? section is incorrect");
		}
		if (a == true) {
			test.pass("Looking for an easier way to manage your child’s iOS and Google Play apps? section is correct");
		}

		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Key Features of ']"));
			webDriver.findElement(By.xpath("//h3[text()='Set Custom App Time Limits']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Manage how long your child can access apps in social media, entertainment and games')]"));
			webDriver.findElement(By.xpath("//h3[text()='Block Addictive or Distracting Apps']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Instantly block or restrict access to social media, games, or any app that disrupts focus and well-being')]"));
			webDriver.findElement(By.xpath("//h3[text()='Prevent Unwanted App Usage']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Use preemptive blocking to restrict certain app categories before your child can use them')]"));
			webDriver.findElement(By.xpath("//h3[text()='Real-Time Activity Updates']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Get helpful updates about new app activity- if any new apps are installed')]"));
			webDriver.findElement(By.xpath("//h3[text()='Cross-Platform Support']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s devices within one platform. Mobicip works across iOS, Android, Windows, Kindle Fire, and more')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Features section is not present");
		}
		if (a == true) {
			test.pass("Features section is present");
		}
		j.executeScript("window.scrollBy(0,800)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Why Parents Choose Mobicip App Blocker

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Why Parents Choose Mobicip App Blocker')]"));
			webDriver.findElement(By.xpath("//span[text()='Kevin']"));
			webDriver.findElement(By.xpath("//span[text()='Amy']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Mobicip makes it easy to block harmful apps and set screen time limits. It gives me peace of mind.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'I love receiving usage reports and limiting app access. It really helps us keep our kids safe online.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Why Parents Choose Mobicip App Blocker section is not present");
		}
		if (a == true) {
			test.pass("Why Parents Choose Mobicip App Blocker section is present");
		}
		j.executeScript("window.scrollBy(0,200)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Frequently Asked Questions

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Frequently Asked ']"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'s App Blocker work?')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Mobicip enables you to customize app access, set daily time limits for specific app categories, and monitor app usage across all your child')]"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'Can I block apps on both Android and iOS?')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Yes. Mobicip is compatible with Android smartphones/tablets, iPhones, iPads, and Kindle Fire, offering comprehensive coverage across platforms.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Can I stop my child from downloading specific apps?']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'If your child downloads a new app that falls under the blocked category, they won’t be able to access it. If the app is allowed, its usage will appear in the activity summary.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Frequently Asked Questions section is not present");
		}
		if (a == true) {
			test.pass("Frequently Asked Questions section is present");
		}
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Trusted by Parents & Recognized by Experts

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Trusted by Parents & Recognized by Experts']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/family_choice_award-e68edf21fa35a82b8a3ed3f66237fe0729bb8173ff9b06cb43614180a0cd6fb9.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/mom_s_choice_award-f218c924113364215086cf942521071565facdb280e68fca41d0ffba1803aae7.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/bbb_award-ee9c11e889f395d16d55788d3551b65da8c5e82ba7e454de4d3ef89f4e7b30d8.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/money_back-36f0d34a43967f366aea6b4fd6554840dbc008e739e083c2cf68230c839a7d5c.svg']"));
			}
			webDriver.findElement(By.xpath("//p[text()='Honoring Excellence']"));
			webDriver.findElement(By.xpath("//p[text()=' Gold Recipient']"));
			webDriver.findElement(By.xpath("//p[text()='Trusted Provider']"));
			webDriver.findElement(By.xpath("//p[text()='Satisfaction Guaranteed ']"));

		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Trusted by Parents & Recognized by Experts section is not present");
		}
		if (a == true) {
			test.pass("Trusted by Parents & Recognized by Experts section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Available Across All Platforms

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Available Across All')]"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'Download Mobicip on your preferred device:')]"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/qr_app_store-15a0842d3767e48b96fa5b7ab3d5b4235fa9122728a49d85c09216b68bf2a30c.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/qr_play_store-4008cd84dc07d9b77858c3c7f4977392db59f35ca87821c28fe4ad05ab10abf4.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/app_store-18a487bfaebb0a42d84b3bd006052edc34eebb3b8f6be636ca2c2bb4e1175bae.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/play_store-fee201ab569b5b292850fd96a60831711873193fd3c27396ccd017c0f99780c5.svg']"));
			}
			webDriver.findElement(By.xpath("//span[contains(text(),'iPhones & iPads')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Android Phones & Tablets')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Kindle Fire')]"));
			
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Available Across All Platforms section is not present");
		}
		if (a == true) {
			test.pass("Available Across All Platforms section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Helpful Resources on Digital Parenting

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Helpful Resources on Digital Parenting']"));
			webDriver.findElement(By.xpath("//div//article[1]"));
			webDriver.findElement(By.xpath("//div//article[2]"));
			webDriver.findElement(By.xpath("//div//article[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Helpful Resources on Digital Parenting section is not present");
		}
		if (a == true) {
			test.pass("Helpful Resources on Digital Parenting section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Start Building Healthy Digital Habits Today!
		try {
			webDriver.findElement(By.xpath("//h2[text()='Start Building Healthy Digital Habits Today!']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Start Building Healthy Digital Habits Today! section is not present");
		}
		if (a == true) {
			test.pass("Start Building Healthy Digital Habits Today! section is present");
		}
		j.executeScript("window.scrollBy(0,550)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Footer section is not present");
		}
		if (a == true) {
			test.pass("Footer section is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Checking the elements in Activity summary page
	@Test(priority = 6)
	public void a7_ActivitySummary() {
		ExtentTest test = extentreport.createTest("Activity summary page",
				"Checking the elements in Activity summary page");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver
				.findElement(
						By.xpath("//a[@class='feature_anchor activity_summary ']//span[text()='Activity Summary']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Activity Summary Parental Control Software | Mobicip")) {
			test.pass("Activity summary page title is correct");
		} else {
			test.fail("Activity summary page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Header is incorrect");
		}
		if (a == true) {
			test.pass("Header is correct");
		}

		// Banner section
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
			webDriver.findElement(By.xpath("//h1[text()='ONLINE ACTIVITY SUMMARY']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'s Screen Time, Apps & Websites')]"));
			webDriver.findElement(By.xpath("//p[contains(text(),'s devices.')]"));
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Banner section is not present");
		}
		if (a == true) {
			test.pass("Banner section is present");
		}
		JavascriptExecutor ja = (JavascriptExecutor) webDriver;
		ja.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Ensure Online Safety & Well Being

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Ensure Online Safety & Well Being']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Concerned about your child')]"));
			webDriver.findElement(By.xpath("//p[contains(text(),'s digital habits? Mobicip')]"));
			webDriver.findElement(By.xpath("//span[text()='Parental Control Dashboard']"));
			webDriver.findElement(By.xpath("//span[text()='Online Monitoring App.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Ensure Online Safety & Well Being section is incorrect");
		}
		if (a == true) {
			test.pass("Ensure Online Safety & Well Being section is correct");
		}

		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Key Features & Benefits']"));
			webDriver.findElement(By.xpath("//h3[text()='Screen Time Management']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Monitor daily screen time and set healthy limits tailored to your child')]"));
			webDriver.findElement(By.xpath("//h3[text()='App & Social Media Usage']"));
			webDriver.findElement(By
					.xpath("//p[contains(text(),'Track time spent on social media, video, chat, and gaming apps.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Detailed Browsing History']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Review websites and videos accessed, and block inappropriate content instantly')]"));
			webDriver.findElement(By.xpath("//h3[text()='URL and App Access Requests']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Easily manage requests for more screen time or app access directly from your')]"));
			webDriver.findElement(By.xpath("//h3[text()='Location History']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'View the places your child visits to ensure they stay safe.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Features section is not present");
		}
		if (a == true) {
			test.pass("Features section is present");
		}
		j.executeScript("window.scrollBy(0,800)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Customer review

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Jenna R']"));
			webDriver.findElement(By.xpath("//span[text()='Marcus T']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Mobicip gives me peace of mind knowing what my kids are doing online.')]"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'I love how I can manage all devices from one place.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Customer review section is not present");
		}
		if (a == true) {
			test.pass("Customer review section is present");
		}
		j.executeScript("window.scrollBy(0,200)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Awards & Recognitions

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Awards & Recognitions']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/family_choice_award-e68edf21fa35a82b8a3ed3f66237fe0729bb8173ff9b06cb43614180a0cd6fb9.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/mom_s_choice_award-f218c924113364215086cf942521071565facdb280e68fca41d0ffba1803aae7.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/bbb_award-ee9c11e889f395d16d55788d3551b65da8c5e82ba7e454de4d3ef89f4e7b30d8.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/money_back-36f0d34a43967f366aea6b4fd6554840dbc008e739e083c2cf68230c839a7d5c.svg']"));
			}
			webDriver.findElement(By.xpath("//p[text()='Honoring Excellence']"));
			webDriver.findElement(By.xpath("//p[text()=' Gold Recipient']"));
			webDriver.findElement(By.xpath("//p[text()='Trusted Provider']"));
			webDriver.findElement(By.xpath("//p[text()='Satisfaction Guaranteed ']"));

		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Awards & Recognitions section is not present");
		}
		if (a == true) {
			test.pass("Awards & Recognitions section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Frequently Asked Questions

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Frequently Asked Questions']"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'s Activity Summary?')]"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'s Activity Summary provides insights into your child')]"));
			webDriver.findElement(By.xpath("//h3[text()='Can I monitor multiple devices with one account?']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'Yes, Mobicip supports multiple devices across iOS, Android')]"));
			webDriver.findElement(By.xpath("//h3[text()='Does Mobicip send activity reports automatically?']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'ll receive daily/weekly summaries via email, so you')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Frequently Asked Questions section is not present");
		}
		if (a == true) {
			test.pass("Frequently Asked Questions section is present");
		}
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Download Mobicip Parental Control

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()=' Mobicip Parental Control ']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/qr_app_store-15a0842d3767e48b96fa5b7ab3d5b4235fa9122728a49d85c09216b68bf2a30c.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/qr_play_store-4008cd84dc07d9b77858c3c7f4977392db59f35ca87821c28fe4ad05ab10abf4.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/app_store-18a487bfaebb0a42d84b3bd006052edc34eebb3b8f6be636ca2c2bb4e1175bae.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/play_store-fee201ab569b5b292850fd96a60831711873193fd3c27396ccd017c0f99780c5.svg']"));
			}
			webDriver.findElement(
					By.xpath("//p[text()='Works with iOS, Android, Windows, Chromebook, MacOS and Kindle fire.']"));

		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Download Mobicip Parental Control section is not present");
		}
		if (a == true) {
			test.pass("Download Mobicip Parental Control section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Related Articles & Resources

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Related Articles & Resources']"));
			webDriver.findElement(By.xpath("//div//article[1]"));
			webDriver.findElement(By.xpath("//div//article[2]"));
			webDriver.findElement(By.xpath("//div//article[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Related Articles & Resources section is not present");
		}
		if (a == true) {
			test.pass("Related Articles & Resources section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Start Building Healthy Digital Habits Today!
		try {
			webDriver.findElement(By.xpath("//h2[text()='Start Building Healthy Digital Habits Today!']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Start Building Healthy Digital Habits section is not present");
		}
		if (a == true) {
			test.pass("Start Building Healthy Digital Habits section is present");
		}
		j.executeScript("window.scrollBy(0,550)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Footer section is not present");
		}
		if (a == true) {
			test.pass("Footer section is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void a8_WebsiteBlocker() {
		ExtentTest test = extentreport.createTest("Website Blocker",
				"Checking the elements in Website Blocker time page");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='feature_anchor website_blocker ']//span[text()='Website Blocker']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Website Blocker Parental Controls | Mobicip")) {
			test.pass("Website Blocker page title is correct");
		} else {
			test.fail("Website Blocker page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page Header is incorrect");
		}
		if (a == true) {
			test.pass("Website Blocker page Header is correct");
		}
		// List of features
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page List of features is present");
		}
		if (a == true) {
			test.pass("Website Blocker page List of features is present");
		}
		// Defination
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='WEBSITE BLOCKER']"));
			webDriver.findElement(
					By.xpath("//span[text()='Website Blocker & Internet Filter: Protect Your Kids Online']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Block websites and filter inappropriate content across any browser, YouTube, or other social media.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page Definition is incorrect");
		}
		if (a == true) {
			test.pass("Website Blocker page Definition is correct");
		}
		// start free trail
		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page Start Free Trial button is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page Start Free Trial button is present");
		}
		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,568)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Features of Mobicip Website Blocker']"));
			webDriver.findElement(By.xpath("//h3[text()='Website Filter']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'Block age-inappropriate websites and 20 web categories.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Porn Blocker']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Nearly 70% of kids inadvertently stumble upon websites displaying porn & violence while searching for something completely innocent online.')]"));
			j.executeScript("window.scrollBy(0,380)");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webDriver.findElement(By.xpath("//h3[text()='Youtube Filter']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Are your kids spending too much time on YouTube? With Mobicip, you can')]"));
			webDriver.findElement(By.xpath("//h3[text()='Whitelist-Only Mode']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Only allow websites that you want your kids to access. Everything else online will be blocked.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page Features is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page Features is present");
		}
		// Importance
		j.executeScript("window.scrollBy(0,320)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Why Block Websites or Filter the Internet?']"));
			webDriver.findElement(By.xpath(
					"//p[@class='paragraph_content' and  contains(text(),'The internet has greatly facilitated a free exchange')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page Importance is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page Importance is present");
		}
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Why Mobicip?
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Why Choose Mobicip')]"));
			webDriver.findElement(By.xpath(
					"//strong[contains(text(),'internet filtering software')]/parent::p[@class='paragraph_content']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page - Why Mobicip ? is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page - Why Mobicip ? is present");
		}
		j.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Customer review
		try {
			webDriver.findElement(By.xpath("//p[@class='review_msg']"));
			webDriver.findElement(By.xpath("//span[@class='reviewer_name']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page - Customer review is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page - Customer review is present");
		}
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Build better
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page - Build better is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page - Build better is present");
		}
		j.executeScript("window.scrollBy(0,750)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Website Blocker page - Footer is not present");
		}
		if (a == true) {
			test.pass("Website Blocker page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void a9_Familylocator() {
		ExtentTest test = extentreport.createTest("Family locator",
				"Checking the elements in Family locator time page");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		j1.executeScript("window.scrollBy(0,100)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.findElement(By.xpath("//a[@class='feature_anchor family_locator ']//span[text()='Family Locator']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Family Locator Parental Controls | Mobicip")) {
			test.pass("Family Locator page title is correct");
		} else {
			test.fail("Family Locator page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Family Locator page Header is incorrect");
		}
		if (a == true) {
			test.pass("Family Locator page Header is correct");
		}
		// Banner section
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
			webDriver.findElement(By.xpath("//h1[text()='FAMILY LOCATOR']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'View Location for Your')]"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'s location in real time and get instant alerts when they')]"));
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Banner section is not present");
		}
		if (a == true) {
			test.pass("Banner section is present");
		}
		JavascriptExecutor ja = (JavascriptExecutor) webDriver;
		ja.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Worried About Your Child's Safety?

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Worried About Your Child')]"));
			webDriver.findElement(By.xpath("//span[text()='Family Location Tracker']"));
			webDriver.findElement(By.xpath("//span[text()='real-time GPS tracking, geofencing,']"));
			webDriver.findElement(By.xpath("//span[text()='instant alerts.']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Worried About Your Child's Safety? section is incorrect");
		}
		if (a == true) {
			test.pass("Worried About Your Child's Safety? section is correct");
		}

		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Key Features & Benefits of Mobicip Location Tracker']"));
			webDriver.findElement(By.xpath("//h3[text()='Real-Time GPS Location Tracking']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'s current location instantly on an intuitive map')]"));
			webDriver.findElement(By.xpath("//h3[text()='Geofencing Alerts']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Set up safe zones (like school or home) and receive automatic notifications when your child enters or leaves them')]"));
			webDriver.findElement(By.xpath("//h3[text()='Location Sharing']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Easily coordinate family routines, pick-ups, and meet-ups with shared location access.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Cross-Platform Compatibility']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Use Mobicip seamlessly across iPhones, iPads,  Kindle fire,  Android phones and tablets.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Privacy-First Design']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s privacy is our top priority, data is encrypted and securely stored.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Features section is not present");
		}
		if (a == true) {
			test.pass("Features section is present");
		}
		j.executeScript("window.scrollBy(0,800)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// What Parents Say

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'What Parents Say')]"));
			webDriver.findElement(By.xpath("//span[text()='Jennifer M']"));
			webDriver.findElement(By.xpath("//span[text()='David R']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s Location Tracker has been a lifesaver! I get peace of mind knowing where my kids are without constantly texting them.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Love the geofencing feature. I get notified the second my son leaves school. Super helpful!')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("What Parents Say section is not present");
		}
		if (a == true) {
			test.pass("What Parents Say section is present");
		}
		j.executeScript("window.scrollBy(0,200)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Trusted by Parents & Recognized by Experts

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Trusted by Parents & Recognized by Experts']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/family_choice_award-e68edf21fa35a82b8a3ed3f66237fe0729bb8173ff9b06cb43614180a0cd6fb9.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/mom_s_choice_award-f218c924113364215086cf942521071565facdb280e68fca41d0ffba1803aae7.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/bbb_award-ee9c11e889f395d16d55788d3551b65da8c5e82ba7e454de4d3ef89f4e7b30d8.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/shared/awards/money_back-36f0d34a43967f366aea6b4fd6554840dbc008e739e083c2cf68230c839a7d5c.svg']"));
			}
			webDriver.findElement(By.xpath("//p[text()='Honoring Excellence']"));
			webDriver.findElement(By.xpath("//p[text()=' Gold Recipient']"));
			webDriver.findElement(By.xpath("//p[text()='Trusted Provider']"));
			webDriver.findElement(By.xpath("//p[text()='Satisfaction Guaranteed ']"));

		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Trusted by Parents & Recognized by Experts section is not present");
		}
		if (a == true) {
			test.pass("Trusted by Parents & Recognized by Experts section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Frequently Asked Questions

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Frequently Asked Questions']"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'Is Mobicip')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Yes. Mobicip uses end-to-end encryption and adheres to strict data protection standards')]"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'Can I track my child')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'No. Mobicip promotes ethical, transparent tracking with parental supervision and child awareness.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Does Mobicip work on both Android and iOS?']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Absolutely. The app supports iPhones, iPads, and Android devices alike')]"));
			webDriver.findElement(
					By.xpath("//h3[contains(text(),'Can multiple parents or guardians view the same child')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Yes! Multiple caregivers can access the location for shared visibility and convenience')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Frequently Asked Questions section is not present");
		}
		if (a == true) {
			test.pass("Frequently Asked Questions section is present");
		}
		j.executeScript("window.scrollBy(0,300)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Available On All Major Platforms

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Available On All Major ')]"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/qr_app_store-15a0842d3767e48b96fa5b7ab3d5b4235fa9122728a49d85c09216b68bf2a30c.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/qr_play_store-4008cd84dc07d9b77858c3c7f4977392db59f35ca87821c28fe4ad05ab10abf4.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/app_store-18a487bfaebb0a42d84b3bd006052edc34eebb3b8f6be636ca2c2bb4e1175bae.svg']"));
			}
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/activity_summary/play_store-fee201ab569b5b292850fd96a60831711873193fd3c27396ccd017c0f99780c5.svg']"));
			}
			webDriver.findElement(
					By.xpath("//p[text()='Works with iOS, Android, Windows, Chromebook, MacOS and Kindle fire.']"));

		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Available On All Major Platforms section is not present");
		}
		if (a == true) {
			test.pass("Available On All Major Platforms section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Related Articles & Resources

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Related Articles & Resources']"));
			webDriver.findElement(By.xpath("//div//article[1]"));
			webDriver.findElement(By.xpath("//div//article[2]"));
			webDriver.findElement(By.xpath("//div//article[3]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Related Articles & Resources section is not present");
		}
		if (a == true) {
			test.pass("Related Articles & Resources section is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Build Better Digital Habits With Mobicip
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Build Better Digital Habits With Mobicip section is not present");
		}
		if (a == true) {
			test.pass("Build Better Digital Habits With Mobicip section is present");
		}
		j.executeScript("window.scrollBy(0,550)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Footer section is not present");
		}
		if (a == true) {
			test.pass("Footer section is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void b1_Collaboration() {
		ExtentTest test = extentreport.createTest("Collaboration", "Checking the elements in Collaboration page");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		j1.executeScript("window.scrollBy(0,100)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='feature_anchor collaboration ']//span[text()='Collaboration']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Collaboration Tools Parental Control Software | Mobicip")) {
			test.pass("Collaboration page title is correct");
		} else {
			test.fail("Collaboration page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page Header is incorrect");
		}
		if (a == true) {
			test.pass("Collaboration page Header is correct");
		}
		// List of features
		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='feature_ul']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page List of features is present");
		}
		if (a == true) {
			test.pass("Collaboration page List of features is present");
		}
		// Defination
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='COLLABORATION']"));
			webDriver.findElement(By.xpath("//span[text()='Collaborate with Your Child and Guardian']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'Invite a co-parent or a guardian to manage your family')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page Defination is incorrect");
		}
		if (a == true) {
			test.pass("Collaboration page Defination is correct");
		}
		// start free trail
		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page Start Free Trial button is not present");
		}
		if (a == true) {
			test.pass("Collaboration page Start Free Trial button is present");
		}
		// Features
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,568)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Features of Mobicip Collaboration']"));
			webDriver.findElement(By.xpath("//h3[text()='Guardians']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Share your parenting duties with trusted ')]"));
			webDriver.findElement(By.xpath("//h3[text()='Child Dashboard']"));
			webDriver.findElement(
					By.xpath("//p[contains(text(),'Your children can self-regulate their screen time consumption,')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page Features is not present");
		}
		if (a == true) {
			test.pass("Collaboration page Features is present");
		}
		// Importance
		j.executeScript("window.scrollBy(0,560)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[contains(text(),'Benefits of Collaborating with Children')]"));
			webDriver.findElement(By.xpath(
					"//p[@class='paragraph_content' and  contains(text(),'Several studies have documented the benefits of parent-child collaboration.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page Importance is not present");
		}
		if (a == true) {
			test.pass("Collaboration page Importance is present");
		}
		j.executeScript("window.scrollBy(0,450)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Customer review
		try {
			webDriver.findElement(By.xpath("//p[@class='review_msg']"));
			webDriver.findElement(By.xpath("//span[@class='reviewer_name']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page - Customer review is not present");
		}
		if (a == true) {
			test.pass("Collaboration page - Customer review is present");
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Build better
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page - Build better is not present");
		}
		if (a == true) {
			test.pass("Collaboration page - Build better is present");
		}
		j.executeScript("window.scrollBy(0,850)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Collaboration page - Footer is not present");
		}
		if (a == true) {
			test.pass("Collaboration page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Checking the elements in Porn Blocker page
	@Test(priority = 10)
	public void b2_PornBlocker() {
		ExtentTest test = extentreport.createTest("Porn Blocker page", "Checking the elements in Porn Blocker page");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='feature_anchor porn_blocker ']//span[text()='Porn Blocker']"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Powerful Porn Blocker App for your child's Smartphone | Mobicip")) {
			test.pass("Porn Blocker page title is correct");
		} else {
			test.fail("Porn Blocker page title is incorrect");
		}
		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Header is incorrect");
		}
		if (a == true) {
			test.pass("Header is correct");
		}

		// Banner section
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='PORN BLOCKER']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'s digital world from pornography')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Mobicip is one of the best porn blocker software that allows parents to block pornography and other inappropriate content on their child')]"));
			webDriver.findElement(By.xpath(
					"//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/features/porn_blocker/Banner-c0320c1dda992922d492376e86307372569bf4d41b56b20ffcff8fe6c6cfb791.png']"));
			}
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Banner section is not present");
		}
		if (a == true) {
			test.pass("Banner section is present");
		}
		JavascriptExecutor ja = (JavascriptExecutor) webDriver;
		ja.executeScript("window.scrollBy(0,500)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Features
		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='How can you block pornography with Mobicip?']"));
			webDriver.findElement(By.xpath("//h3[text()='Porn Filter']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'You can add specific websites to the block list, or you can choose from a pre-set list of web categories like adult and mature websites')]"));
			webDriver.findElement(By.xpath("//h3[text()='Adult Content Blocker']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'You can block explicit content in any browser, YouTube, or social media platform with Mobicip')]"));
			webDriver.findElement(By.xpath("//h3[text()='Keywords and Phrase Blocker']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'You can set up a list of specific words and phrases that are commonly associated with explicit content. When your child tries to access a website or search for something using these keywords, the blocker will prevent them from accessing the content.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Real-time Alerts']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'It adds another layer of security, giving you extra peace of mind that your child is safe from mature and violent content.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Features section is not present");
		}
		if (a == true) {
			test.pass("Features section is present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Why do you need a porn blocker?

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Why do you need a porn blocker?']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s exposure to inappropriate content online, including porn. Parents need to protect their children from pornography because exposure to porn can have negative effects on their emotional, psychological, and social development. Here are some reasons why:')]"));
			webDriver.findElement(By.xpath("//h3[text()='Distorted view of sexuality']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Children who are exposed to pornography at a young age may develop unrealistic and distorted views of sexuality, which can lead to unhealthy sexual behavior later in life.')]"));
			webDriver.findElement(By.xpath("//h3[text()='Low self-esteem']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Pornography often portrays women and men as objects, and this can negatively impact a child')]"));
			webDriver.findElement(By.xpath("//h3[text()='Addictive behaviour ']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Children who are exposed to pornography at a young age may develop an addiction to it, which can lead to social isolation, depression, and other mental health issues.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Why do you need a porn blocker? section is not present");
		}
		if (a == true) {
			test.pass("Why do you need a porn blocker? section is present");
		}
		j.executeScript("window.scrollBy(0,200)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Read our blog
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Read our blog']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Read our blog section is not present");
		}
		if (a == true) {
			test.pass("Read our blog section is present");
		}
		j.executeScript("window.scrollBy(0,200)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[text()='Read our blog']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Read our blog link redirects failed");
		}
		if (a == true) {
			test.pass("Read our blog link works fine");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.navigate().back();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		j.executeScript("window.scrollBy(0,400)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Why Mobicip is the Best Porn Blocker?

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Why Mobicip is the Best Porn Blocker?']"));

			webDriver.findElement(By.xpath("//h3[text()='Advanced Content Filtering']"));
			webDriver.findElement(By.xpath("//h3[text()='Customizable Filtering Levels']"));
			webDriver.findElement(By.xpath("//h3[text()='Real-Time Blocking']"));
			webDriver.findElement(By.xpath("//h3[text()='Uninstall Protection']"));
			webDriver.findElement(By.xpath("//h3[text()='Multi-Platform Support']"));
			webDriver.findElement(By.xpath("//h3[text()='App and Browser Filtering']"));
			webDriver.findElement(By.xpath("//h3[text()='User-Friendly Interface']"));
			webDriver.findElement(By.xpath("//h3[text()='Detailed Reporting and Monitoring']"));
			webDriver.findElement(By.xpath("//h3[text()='Safe Search Enforcement']"));
			webDriver.findElement(By.xpath("//h3[text()='Age-Appropriate Filtering Profiles']"));
			webDriver.findElement(By.xpath("//h3[text()='Flexible Whitelisting and Blacklisting']"));
			webDriver.findElement(By.xpath("//h3[text()='Responsive Customer Support']"));

			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Provides 24/7 responsive customer support for assistance and troubleshooting')]/preceding::a[text()='Start Free Trial'][1]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Provides 24/7 responsive customer support for assistance and troubleshooting')]/following::a[text()='Start Free Trial'][1]"));

			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Mobicip is the only parental control app capable of categorizing web content instantly while implementing safe search measures. Its advanced adult content filter effectively recognizes and prohibits access to over 30 web categories, encompassing adult content, pornography, violent material, advertisements, gambling sites, and numerous others. Find out all that makes Mobicip stand out among all other porn blocker.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Utilizes AI-based filtering technology to effectively block explicit content across various mediums.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Offers extensive customization options for filtering levels, catering to different age groups and preferences')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Provides real-time blocking of adult content, preventing access as soon as it is detected')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s Apple ID and password in order to delete the app on iOS devices')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Available on various platforms including Windows, macOS, iOS, Android, Chromebook and Kindle Fire')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Extends filtering capabilities to both web browsers and apps, ensuring comprehensive coverage of online activities')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Features an intuitive and easy-to-use interface suitable for both parents and children, with simple setup and management')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Provides detailed reports on internet activity, including attempts to access blocked content and overall usage statistics')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Enforces safe search settings on popular search engines to filter out explicit content from search results')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Offers predefined filtering profiles based on age groups for easy setup and age-appropriate content restrictions')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Allows users to whitelist specific websites or blacklist unwanted sites, giving them control over allowed and blocked content')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'Provides 24/7 responsive customer support for assistance and troubleshooting')]"));

		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Why Mobicip is the Best Porn Blocker? section is not present");
		}
		if (a == true) {
			test.pass("Why Mobicip is the Best Porn Blocker? section is present");
		}
		j.executeScript("window.scrollBy(0,3100)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Pricing

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Mobicip Pricing']"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'s right for your family')]"));
			webDriver.findElement(By.xpath("//h4[contains(text(),'Enjoy Premium features')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'FREE for 7 days')]"));
			webDriver.findElement(By.xpath("//p[text()='Premium']"));
			webDriver.findElement(By.xpath("//p[text()='Standard']"));
			webDriver.findElement(By.xpath("//p[text()='Lite']"));
			webDriver.findElement(By.xpath("//a[text()='Get a Quote']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_1-b972429cbd3fd9cf6af4996c4b3282508ae96813e26ce2196dbf349a7cdc75be.png']"));
			}
			webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_2-69db14cac1bcaf7f6a6f434a5aded72634ad1154f4e1e55f04b217c0bc282757.png']"));
			}
			webDriver.findElement(By.xpath("//p[text()='Certified' and text()='Secure']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_3-b5551a1c3ebd8cb9eb86aa597aec0d666ed9448c075bdd597d2c9f64b36a3a26.png']"));
			}
			webDriver.findElement(By.xpath("//p[text()='Trusted' and text()='Provider']"));
			if (environment == 2) {
				webDriver.findElement(By.xpath(
						"//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_4-8b32a2cd1fb70a8a1cb002d43a5d2dea48377bb422f571f1222e99bc924435e0.png']"));
			}
			webDriver.findElement(By.xpath("//p[text()='Satisfaction' and text()='Guaranteed']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Pricing section is not present");
		}
		if (a == true) {
			test.pass("Pricing section is present");
		}
		j.executeScript("window.scrollBy(0,800)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Customer review

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Kevin']"));
			webDriver.findElement(By.xpath("//span[text()='Amy']"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'ve seen statistics that kids are exposed to porn and other bad stuff as early as 8 years old. Being a parent is hard enough and Mobicip makes one area of life just a bit safer and easier to manage.')]"));
			webDriver.findElement(By.xpath(
					"//p[contains(text(),'s been so helpful getting reports and being able to limit times of use restrict websites, giving me peace of mind!')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Customer review section is not present");
		}
		if (a == true) {
			test.pass("Customer review section is present");
		}
		j.executeScript("window.scrollBy(0,200)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Build Better Digital Habits With Mobicip
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Build Better Digital Habits With Mobicip section is not present");
		}
		if (a == true) {
			test.pass("Build Better Digital Habits With Mobicip section is present");
		}
		j.executeScript("window.scrollBy(0,550)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Footer section is not present");
		}
		if (a == true) {
			test.pass("Footer section is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 11)
	public void b3_ExpertAdvice() {
		ExtentTest test = extentreport.createTest("Expert Advice", "Checking the elements in Expert Advice page");
		extentTest.set(test);
		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Features']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//span[text()='Expert Advice']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("Blog | Internet Safety, Digital Citizenship & Social Media | Mobicip")) {
			test.pass("Expert Advice page title is correct");
		} else {
			test.fail("Expert Advice page title is incorrect");
		}

		// Header
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='icon_menu']"));
			webDriver.findElement(By.xpath("//a[text()='Pricing']"));
			webDriver.findElement(By.xpath("//span[text()='Features']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
			webDriver.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
			webDriver.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice page Header is incorrect");
		}
		if (a == true) {
			test.pass("Expert Advice page Header is correct");
		}

		// Blog -Title
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@title='Blog']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice page Title is present");
		}
		if (a == true) {
			test.pass("Expert Advice page Title is present");
		}

		// Share button
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='share_blog_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice page Share button is not present");
		}
		if (a == true) {
			test.pass("Expert Advice page Share button is present");
		}

		// Blog container
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='blogs_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice page Blog container is not present");
		}
		if (a == true) {
			test.pass("Expert Advice page Blog container is present");
		}

		// Page Navigation
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1680)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			webDriver.findElement(By.xpath("//ul[@class='pagination_bar']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice page - Page Navigation is not present");
		}
		if (a == true) {
			test.pass("Expert Advice page - Page Navigation is present");
		}

		j.executeScript("window.scrollBy(0,100)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Build better
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice  page - Build better is not present");
		}
		if (a == true) {
			test.pass("Expert Advice  page - Build better is present");
		}
		j.executeScript("window.scrollBy(0,850)");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Footer
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Expert Advice  page - Footer is not present");
		}
		if (a == true) {
			test.pass("Expert Advice  page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	 * @AfterTest public void teardown() { webDriver.quit(); extentreport.flush(); }
	 */

}
