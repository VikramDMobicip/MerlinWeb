package Postlogin;
//////////////////// NOTE : NEED TO ENTER CAPTCHA WITHIN 100 Seconds AT FACEBOOK LOGIN STEP
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Prelogin.BrowserSetupClass;
//Need to enter captcha when facebook login


public class SocialMediaMonitoring extends BrowserSetup {

	// Checking for the title of home page and Socialmedia page.
	@Test(priority = 1)
	public void a1_socialMediaPage() {
		ExtentTest test = extentreport.createTest("Social media page",
				"Checking the title of the Social media page ");
		extentTest.set(test);

		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
		// ---Dash board---
		String tit = webDriver.getTitle();
		if (tit.equals("Dashboard | Mobicip")) {
			test.pass("Dashboard - title is correct ");
		} else {
			test.fail("Dashboard - title isn't correct ");
		}
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Social Media']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media - Option was Incorrect");
		}
		if (a == true) {
			test.pass("Social Media - Option was correct");
		}

		// ---Social Media---
		webDriver.findElement(By.xpath("//span[text()='Social Media']")).click();
		a = true;
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Social Media']")));

		try {
			webDriver.findElement(By.xpath("//p[text()='Social Media']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Social Media - Title not present");
		}
		if (a == true) {
			test.pass("Social Media - Title present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Enable Social Media Monitor for ' and text()='11a']")));
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}

		// ---Validation - Social Media ---
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Social Media | Mobicip")) {
			test.pass("Social Media - page opened and title is correct ");
		} else {
			test.fail("Social Media - title isn't correct ");}
	}
	
	// Checking the Social media components
		@Test(priority = 2)
		public void a2_SocialPageElements() {
			ExtentTest test2 = extentreport.createTest("Social media - Elements", "Checking the Social pages components");
			extentTest.set(test2);

			boolean a = true;
			try {
				webDriver.findElement(By.xpath("//p[text()='Enable Social Media Monitor for ' and text()='11a']"));
			} catch (NoSuchElementException e) {
				a = false;
				test2.fail("Social page sub title not found");
			}
			if (a == true) {
				test2.pass("Social page is present");
			}

			a = true;
			try {
				webDriver.findElement(By.xpath("//div[@class='social_media_icon facebook']"));
				webDriver.findElement(By.xpath("//p[text()='Facebook' and text()=' Monitor']"));
				webDriver.findElement(By.xpath("//label[@class='toggle_switch' and @for='10']"));
			} catch (NoSuchElementException e) {
				a = false;
				test2.fail("Facebook elements");
			}
			if (a == true) {
				test2.pass("Facebook elements");
			}
			a = true;
			try {
				webDriver.findElement(By.xpath("//div[@class='social_media_icon snapchat']"));
				webDriver.findElement(By.xpath("//p[text()='Snapchat' and text()=' Monitor']"));
				webDriver.findElement(By.xpath("//label[@class='toggle_switch' and @for='11']"));
				webDriver.findElement(By.xpath("//p[text()='Available only on Android']"));
			} catch (NoSuchElementException e) {
				a = false;
			test2.fail("Snapchat elements");
			}if (a == true) {test2.pass("Snapchat elements");}
		}
		
		
		// Checking the Facebook enable
		@Test(priority = 3)
		public void a3_FacebookEnable() {
			ExtentTest test3 = extentreport.createTest("Faceboook - Enable", "Checking the Facebook monitoring enable");
			extentTest.set(test3);
			webDriver.findElement(By.xpath("//label[@class='toggle_switch' and @for='10']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
			boolean a = true;
			try {webDriver.findElement(By.xpath("//input[@name='email']"));} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook Login page");}
			if (a == true) {test3.pass("Facebook login page");}
			webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys("logu@mobicip.com");
			webDriver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Bluemoon31");
			webDriver.findElement(By.xpath("//button[@id='loginbutton']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(100))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='You previously logged in to Mobicip with Facebook.']")));
			a = true;
			try {webDriver.findElement(By.xpath("//div[text()='You previously logged in to Mobicip with Facebook.']"));
			webDriver.findElement(By.xpath("//span[text()='Would you like to continue?']"));
			webDriver.findElement(By.xpath("//span[text()='Continue as Loganthan']"));
			webDriver.findElement(By.xpath("//span[text()='Cancel']"));
			webDriver.findElement(By.xpath("//span[text()='By continuing, Mobicip will receive ongoing access to the information that you share and Meta will record when Mobicip accesses it. ' and text()=' about this sharing and the settings that you have.']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Mobicip')]//a[text()='Terms of Service']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Mobicip')]//a[text()='Privacy Policy']"));} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook Link page");}
			if (a == true) {test3.pass("Facebook Link page");}
			webDriver.findElement(By.xpath("//span[text()='Continue as Loganthan']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You are successfully connected to your Facebook account.']")));
			a = true;
			try {webDriver.findElement(By.xpath("//p[text()='You are successfully connected to your Facebook account.']"));
				webDriver.findElement(By.xpath("//a[text()='View Facebook Activity']"));} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook Linked message page");}
			if (a == true) {test3.pass("Facebook Linked message page");}
			webDriver.findElement(By.xpath("//a[text()='View Facebook Activity']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Facebook Monitor']")));
			a = true;
			try {webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
			webDriver.findElement(By.xpath("//p[text()='Facebook Monitor']"));} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook monitor page headers");}
			if (a == true) {test3.pass("Facebook monitor page headers");}
			a = true;
			try {webDriver.findElement(By.xpath("//div[@title='Loganthan Palanisamy']"));
			webDriver.findElement(By.xpath("//p[text()='Loganthan Palanisamy']"));
			webDriver.findElement(By.xpath("//p[text()='Monitoring ' and text()='Enabled']"));
			webDriver.findElement(By.xpath("//label[@for='fb_toggle_button']"));
			webDriver.findElement(By.xpath("//p[text()='Flagged Activities (']"));
			webDriver.findElement(By.xpath("//p[text()='Last Sync: ']"));
			webDriver.findElement(By.xpath("//span[text()='Filter']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook monitor page Info section");}
			if (a == true) {test3.pass("Facebook monitor Info section");}
			a = true;
			webDriver.findElement(By.xpath("//span[text()='Filter']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Category']")));
			try {webDriver.findElement(By.xpath("//p[text()='Category']"));
			webDriver.findElement(By.xpath("//p[text()='Action']"));
			webDriver.findElement(By.xpath("//p[text()='Activity Occurrence']"));
			webDriver.findElement(By.xpath("//label[text()='Bullying']"));
			webDriver.findElement(By.xpath("//label[text()='Sexual']"));
			webDriver.findElement(By.xpath("//label[text()='Drugs']"));
			webDriver.findElement(By.xpath("//label[text()='Self Harm/Suicide']"));
			webDriver.findElement(By.xpath("//label[text()='Resolved']"));
			webDriver.findElement(By.xpath("//label[text()='Unresolved']"));
			webDriver.findElement(By.xpath("//label[text()='Today']"));
			webDriver.findElement(By.xpath("//label[text()='7 days']"));
			webDriver.findElement(By.xpath("//label[text()='30 days']"));
			webDriver.findElement(By.xpath("//span[text()='Clear All']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook filter options");}
			if (a == true) {test3.pass("Facebook Filter options");}
			webDriver.findElement(By.xpath("//label[@for='fb_toggle_button']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You will have to redo the authentication if you stop monitoring ' and 'Facebook' and ' now. Are you sure you want to stop the monitoring?']")));
			a = true;
			try {webDriver.findElement(By.xpath("//p[text()='You will have to redo the authentication if you stop monitoring ' and 'Facebook' and ' now. Are you sure you want to stop the monitoring?']"));
			webDriver.findElement(By.xpath("//div[text()='No']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook monitor page Disable popup");}
			if (a == true) {test3.pass("Facebook monitordisable popup");}
			webDriver.findElement(By.xpath("//div[text()='No']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='fb_toggle_button']")));
			a = true;
			try {webDriver.findElement(By.xpath("//label[@for='fb_toggle_button']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook monitor Disable No");}
			if (a == true) {test3.pass("Facebook monitor disable No");}
			webDriver.findElement(By.xpath("//a[@class='logo']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Social Media']")));
			webDriver.findElement(By.xpath("//span[text()='Social Media']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Social Media']")));
			JavascriptExecutor j = (JavascriptExecutor) webDriver;
			j.executeScript("window.scrollBy(0,2000)");
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e1) {e1.printStackTrace();}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View Details']")));
			a = true;
			try {webDriver.findElement(By.xpath("//span[text()='View Details']"));
			webDriver.findElement(By.xpath("//input[@checked and @id='0']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook monitor Enabled in social media page");}
			if (a == true) {test3.pass("Facebook monitor Enabled in social media page");}
			j.executeScript("window.scrollBy(0,2000)");
			try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
			webDriver.findElement(By.xpath("//span[text()='View Details']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='fb_toggle_button']")));
			a = true;
			try {webDriver.findElement(By.xpath("//label[@for='fb_toggle_button']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("View Details button opens facebook monitor page");}
			if (a == true) {test3.pass("View Details button opens facebook monitor page");}
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Social Media']")));
			JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
			j1.executeScript("window.scrollBy(0,2000)");
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e1) {e1.printStackTrace();}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='toggle_switch' and @for='0']")));
			webDriver.findElement(By.xpath("//label[@class='toggle_switch' and @for='0']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You will have to redo the authentication if you stop monitoring ' and 'Facebook' and ' now. Are you sure you want to stop the monitoring?']")));
			a = true;
			try {webDriver.findElement(By.xpath("//p[text()='You will have to redo the authentication if you stop monitoring ' and 'Facebook' and ' now. Are you sure you want to stop the monitoring?']"));
			webDriver.findElement(By.xpath("//div[text()='No']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']"));
			} catch (NoSuchElementException e) {
			a = false;test3.fail("Facebook monitor page Disable popup");}
			if (a == true) {test3.pass("Facebook monitordisable popup");}
			webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
			try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='toggle_switch' and @for='10']")));
			a = true;
			try {webDriver.findElement(By.xpath("//span[text()='View Details']"));
			} catch (NoSuchElementException e) {
			a = false;test3.pass("Facebook monitor Disable Yes");}
			if (a == true) {test3.fail("Facebook monitor disable Yes");}	
		}
		
		// Checking the Snapchat components
		@Test(priority = 4)
		public void a4_SnapchatEnable() {
			ExtentTest test4 = extentreport.createTest("Snapchat - Enable", "Checking the Snapchat monitoring enable");
			extentTest.set(test4);
			webDriver.findElement(By.xpath("//label[@class='toggle_switch' and @for='11']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Snapchat Monitor']")));
			boolean a = true;
			try {webDriver.findElement(By.xpath("//p[text()='Snapchat Monitor']"));} catch (NoSuchElementException e) {
			a = false;test4.fail("Snapchat monitor page opened");}
			if (a == true) {test4.pass("Snapchat monitor page opened");}
			a = true;
			try {webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
			webDriver.findElement(By.xpath("//p[text()='Snapchat Monitor']"));} catch (NoSuchElementException e) {
			a = false;test4.fail("Snapchat monitor page headers");}
			if (a == true) {test4.pass("Snapchat monitor page headers");}
			a = true;
			try {webDriver.findElement(By.xpath("//p[text()='Flagged Activities (']"));
			} catch (NoSuchElementException e) {
			a = false;test4.fail("Snapchat monitor page Info section");}
			if (a == true) {test4.pass("Snapchat monitor Info section");}
			a = true;
			webDriver.findElement(By.xpath("//span[text()='Filter']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Category']")));
			try {webDriver.findElement(By.xpath("//p[text()='Category']"));
			webDriver.findElement(By.xpath("//p[text()='Action']"));
			webDriver.findElement(By.xpath("//p[text()='Activity Occurrence']"));
			webDriver.findElement(By.xpath("//label[text()='Bullying']"));
			webDriver.findElement(By.xpath("//label[text()='Sexual']"));
			webDriver.findElement(By.xpath("//label[text()='Drugs']"));
			webDriver.findElement(By.xpath("//label[text()='Self Harm/Suicide']"));
			webDriver.findElement(By.xpath("//label[text()='Resolved']"));
			webDriver.findElement(By.xpath("//label[text()='Unresolved']"));
			webDriver.findElement(By.xpath("//label[text()='Today']"));
			webDriver.findElement(By.xpath("//label[text()='7 days']"));
			webDriver.findElement(By.xpath("//label[text()='30 days']"));
			webDriver.findElement(By.xpath("//span[text()='Clear All']"));
			} catch (NoSuchElementException e) {a = false; test4.fail("Snapchat filter options");}
			if (a == true) {test4.pass("Snapchat Filter options");}
			webDriver.findElement(By.xpath("//a[@class='logo']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Social Media']")));
			webDriver.findElement(By.xpath("//span[text()='Social Media']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Social Media']")));
			JavascriptExecutor j = (JavascriptExecutor) webDriver;
			j.executeScript("window.scrollBy(0,2000)");
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e1) {e1.printStackTrace();}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View Details']")));
			a = true;
			try {webDriver.findElement(By.xpath("//span[text()='View Details']"));
			webDriver.findElement(By.xpath("//input[@checked and @id='0']"));
			} catch (NoSuchElementException e) {
			a = false;test4.fail("Snapchat monitor Enabled in social media page");}
			if (a == true) {test4.pass("Snapchat monitor Enabled in social media page");}
			j.executeScript("window.scrollBy(0,2000)");
			try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
			webDriver.findElement(By.xpath("//span[text()='View Details']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Snapchat Monitor']")));
			a = true;
			try {webDriver.findElement(By.xpath("//p[text()='Snapchat Monitor']"));
			} catch (NoSuchElementException e) {
			a = false;test4.fail("View Details button opens Snapchat monitor page");}
			if (a == true) {test4.pass("View Details button opens Snapchat monitor page");}
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Social Media']")));
			JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
			j1.executeScript("window.scrollBy(0,2000)");
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e1) {e1.printStackTrace();}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='toggle_switch' and @for='0']")));
			webDriver.findElement(By.xpath("//label[@class='toggle_switch' and @for='0']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You will have to redo the authentication if you stop monitoring ' and 'Snapchat' and ' now. Are you sure you want to stop the monitoring?']")));
			a = true;
			try {webDriver.findElement(By.xpath("//p[text()='You will have to redo the authentication if you stop monitoring ' and 'Snapchat' and ' now. Are you sure you want to stop the monitoring?']"));
			webDriver.findElement(By.xpath("//div[text()='No']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']"));
			} catch (NoSuchElementException e) {
			a = false;test4.fail("Snapchat monitor page Disable popup");}
			if (a == true) {test4.pass("Snapchat monitordisable popup");}
			webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
			try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='toggle_switch' and @for='11']")));
			a = true;
			try {webDriver.findElement(By.xpath("//span[text()='View Details']"));
			} catch (NoSuchElementException e) {
			a = false;test4.pass("Snapchat monitor Disable Yes");}
			if (a == true) {test4.fail("Snapchat monitor disable Yes");}	
			
		}

}
