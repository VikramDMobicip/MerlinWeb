package Prelogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class CompetitorBark extends BrowserSetupClass {
	//------------------------------ Bark Page ---------------------

	@Test(priority = 1)
	public void a1_Barkpage() throws InterruptedException {
	      if(environment==1) {
			  webDriver.get("https://webs.prgr.in/content/mobicip-vs-bark");}
	      if(environment==2) {
	    	  webDriver.get("https://www.mobicip.com/content/mobicip-vs-bark");}
		ExtentTest test = extentreport.createTest("Competitor Bark Page", "To check the Bark web page title, header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Mobicip vs. Bark']")));
		WebElement l = webDriver.findElement(By.xpath("//h1[text()='Mobicip vs. Bark']"));

		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip vs. Bark - | Mobicip")) {
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
		ExtentTest test1 = extentreport.createTest("section 1 Bark", "To check the Bark web page section 1");
		extentTest.set(test1);
		
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Mobicip vs. Bark']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Title text is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Title text is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//strong[text()='Why Choose ' and 'Over Bark?']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/09/19105542/Frame-427320755-4.jpg']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/16123547/APP-AND-PLAYSTOE-4.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/17063854/Adobe-Express-file-26.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110003/banner-image-3-4-1024x857.jpg']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Sub title Element and images is not present");
		}
		if (a == true) {
			test1.pass("Sub title Element and images is present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(3);
		}

		@Test(priority = 3)
		public void a3_Section2() throws InterruptedException {
			ExtentTest test1 = extentreport.createTest("section 2 Bark", "To check the Bark web page section 2");
			extentTest.set(test1);
			boolean	a = true;
		try {
			webDriver.findElement(By.xpath("//strong[text()='Mobicip leads with seamless iOS setup']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Mobicip.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320779-2.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320781-1.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320782-2.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320783-1.png']"));
			
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip feature icons is not present");
		}
		if (a == true) {
			test1.pass("Mobicip feature icons present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Bark.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320785-1.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320786-1.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320787-1.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320788-1.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Bark complications icons is not present");
		}
		if (a == true) {
			test1.pass("Bark Complications icons is present");
		}
		j.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);
	}
		
	@Test(priority = 4)
	public void a4_Section3() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 3 Bark", "To check the Bark web page section 3");
			extentTest.set(test1);
			//img[@src='']
			boolean a = true;
			try {
				webDriver.findElement(By.xpath("//strong[contains(text(),'Mobicip has worked wonderfully for me and my family over the last year. I')]"));
				webDriver.findElement(By.xpath("//div[@class='wp-block-jetpack-rating-star is-style-filled']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Review-Bethany-2.png']"));
			} catch (NoSuchElementException e) {
				a = false;
				Assert.fail("Section 3 - star and text is not present");
			}
			if (a == true) {
				test1.pass("Section 3 - star and text is present");
			}
	}
	
	@Test(priority = 5)
	public void a5_Section4() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()=' and Bark compare for families']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 4 Bark", "To check the Bark web page section 4");
			extentTest.set(test1);
			
			boolean a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()=' and Bark compare for families']"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'s how key features offered by ')]"));
				webDriver.findElement(By.xpath("//mark[text()='Mobicip']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison title is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison title is present");}
			
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Cross Platform Solution']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'covers all the major platforms including Windows, Mac, Android, iOS, Kindle, and Chromebook devices.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark covers iOS, Android, and Amazon devices.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/1-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 1 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 1 is present");}
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='iOS Device Compatibility']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='iOS Device Compatibility']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'has easy setup and excellent monitoring in iOS devices')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark has complicated setup in iOS platform and requires frequent backups on a computer to receive alerts. No uninstall protection.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/2-2.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 2 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 2 is present");}
			//Point 3
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Content Filtering']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Content Filtering']"));
				webDriver.findElement(By.xpath("//p[contains(text(),' provides comprehensive content filtering over ')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark Filters websites based on 17 web categories.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/3-3.jpg']"));
			} catch (NoSuchElementException e){
				a = false;
				test1.fail("Section 4 - Comparison point 3 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 3 is present");}
			//Point 4
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Screen Time Limits']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Screen Time Limits']"));
				webDriver.findElement(By.xpath("//p[contains(text(),' gives you more flexibility with ')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark focuses on daily scheduling and lacks overall screen time limit settings. Category-specific time restriction is not supported. For instance, it’s inconvenient if you want to limit playing online games to 30 minutes/day.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/4-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 4 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 4 is present");}
			//Point 5
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='App Blocking']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='App Blocking']"));
				webDriver.findElement(By.xpath("//p[contains(text(),' allows you to block inappropriate apps over various categories. ')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark allows individual app blocking No whitelisted apps feature Monitors after the apps are installed')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/5-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 5 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 5 is present");}
			//Point 6
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Activity Reports and Alerts']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Activity Reports and Alerts']"));
				webDriver.findElement(By.xpath("//p[contains(text(),' provides full overview of ')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark is specialised for sending alerts for issues like Cyberbullying, suicidal ideation, online predators and more.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/6.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 6 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 6 is present");}
			//Point 7
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Location Monitoring']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Location Monitoring']"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'geofencing Alerts, real-time location tracking, location history reports.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark provides geofencing and location check-in requests & Lacks real-time location tracking and history.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/7-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 7 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 7 is present");}
			//Point 8
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Social Media Monitoring']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Social Media Monitoring']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Mobicip monitors social media content on Facebook and Snapchat for harmful content and sends real-time alerts.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark monitors social media channels for dangerous content and sends real-time alerts')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/8-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 8 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 8 is present");}
			//Point 9
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Additional Parent']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Additional Parent']"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'2 parents or guardians')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark requires hardware or a joint email account.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/9-2.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 9 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 9 is present");}
			//Point 10
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Uninstall Protection']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Uninstall Protection']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Mobicip requires a parent’s Apple account credentials for uninstallation on iOS, adding an extra layer of security to prevent children from bypassing restrictions.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Bark has no protection.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/10-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 10 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 10 is present");}		
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/11-9.jpg']")) );
			a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/11-9.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison pricing is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison pricing is present");}
	}
	
	
	@Test(priority = 6)
	public void a6_Section5() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110212/Who-Should-Choose-Bark_.jpg']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 5 Bark", "To check the who should choose Bark section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110212/Who-Should-Choose-Bark_.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/08/Bark-Illustration-1-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  who should choose Bark  title and pic is not present");}
			if (a == true) {
				test1.pass("Section 5 -  who should choose Bark  title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Choose Bark if:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You only want website filtering')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want to monitor teens and tweens:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You require text, photos, and videos monitoring')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You are concerned about bullying:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You are not an iPhone user')]"));
			webDriver.findElement(By.xpath("//li[text()='It is not ideal for younger children, as parents want to know what they are doing online.']"));
			webDriver.findElement(By.xpath("//li[text()=': In iOS devices Bark is unreliable and the app setup is complicated.']"));

			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  who should choose Bark description points not present");}
			if (a == true) {
				test1.pass("Section 5 -  who should choose Bark description points is present");}
	}
	
	@Test(priority = 7)
	public void a7_Section6() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110210/Who-Should-Choose-Mobicip_-1.jpg']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 6 Bark", "To check the who should choose Mobicip section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110210/Who-Should-Choose-Mobicip_-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/08/Mobidcip-Illustration-3-2-856x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  who should choose Mobicip title and pic is not present");}
			if (a == true) {
				test1.pass("Section 5 -  who should choose Mobicip title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Choose Mobicip if:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You are looking for parental controls suitable for all age groups from younger kids to teenagers: ')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want up-to-the-minute alerts:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want an easy setup:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Your child knows about VPNs:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You are on a budget:')]"));
			webDriver.findElement(By.xpath("//li//strong[contains(text(),'$2.99/month')]"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip is ideal for all age groups with customisable parental control features and restrictions.']"));
			webDriver.findElement(By.xpath("//li[text()='The real-time alerts with Mobicip scan websites in popular browsers like Chrome, Firefox, and Safari, and social media platforms and applications like Instagram, Snapchat, and YouTube.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip is simple, letting you create a profile for each child with pre-defined control settings, ranging from strict to mere monitoring.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip excels with integrated VPN and filtering, blocking unauthorized VPNs, and providing real-time alerts, ensuring a secure online environment.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip offers budget-friendly plans starting from ']"));
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[contains(text(),'You want custom content filtering:')]")) );
			TimeUnit.SECONDS.sleep(1);
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want custom content filtering:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want a reliable app: ')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want good location monitoring')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You use iPhones:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want good app blocking')]"));
			webDriver.findElement(By.xpath("//li//strong[contains(text(),'geofencing')]"));
			webDriver.findElement(By.xpath("//li[text()='The filtering options in Mobicip are plentiful.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip always performs well, does not crash, and is continuously updated to work across platforms.']"));
			webDriver.findElement(By.xpath("//li[text()='The location tracking in Mobicip is precise and offers a history of where your child was at what time.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip has excellent compatibility with iOS devices and you can protect your child from uninstalling.']"));
			webDriver.findElement(By.xpath("//li[text()=' boundaries without any request from parent.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  who should choose Mobicip description points not present");}
			if (a == true) {
				test1.pass("Section 5 -  who should choose Mobicip description points is present");}
	}
	

	@Test(priority = 8)
	public void a8_Section7() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Bark?']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 7 Bark", "To check the What are Real Customers Saying About Bark section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Bark?']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/08/Bark-testimonial-illustration-4-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 7 -  What are Real Customers Saying About Bark title and pic is not present");}
			if (a == true) {
				test1.pass("Section 7 -  What are Real Customers Saying About Bark title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Easy to bypass on iPhones:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Complex setup process:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Delayed alerts:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Inconsistent protection:')]"));
			webDriver.findElement(By.xpath("//p[text()='Here are some concerns raised by parents regarding bark:']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 7 -  What are Real Customers Saying About Bark description points not present");}
			if (a == true) {
				test1.pass("Section 7 -  What are Real Customers Saying About Bark description points is present");}
	}
	
	@Test(priority = 9)
	public void a9_Section8() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Mobicip?']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 8 Bark", "To check the What are Real Customers Saying About Mobicip section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Mobicip?']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/09/Mobicip-testimonial-illustration-1-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 8 -  What are Real Customers Saying About Mobicip title and pic is not present");}
			if (a == true) {
				test1.pass("Section 8 -  What are Real Customers Saying About Mobicip title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Stress relief and peace of mind:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Ensuring family safety online:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Most user friendly parental control app:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Great software and customer service')]"));
			webDriver.findElement(By.xpath("//p[text()='Here are some feedbacks by parents regarding mobicip:']"));
						
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 8 -  What are Real Customers Saying About Mobicip description points not present");}
			if (a == true) {
				test1.pass("Section 8 -  What are Real Customers Saying About Mobicip description points is present");}
	}
	
	
	@Test(priority = 10)
	public void a10_Section9() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h3[contains(text(),'Choose the plan that')]")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 9 Bark", "To check Pricing of Mobicip section");
			extentTest.set(test1);
			pricingSection(test1);
	}
	
	@Test(priority = 11)
	public void a11_Section10() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 10 Bark", "To check Certificates and awards of Mobicip section");
			extentTest.set(test1);			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Certified')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Trusted')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Satisfaction')]"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_1-b972429cbd3fd9cf6af4996c4b3282508ae96813e26ce2196dbf349a7cdc75be.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_2-69db14cac1bcaf7f6a6f434a5aded72634ad1154f4e1e55f04b217c0bc282757.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_3-b5551a1c3ebd8cb9eb86aa597aec0d666ed9448c075bdd597d2c9f64b36a3a26.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_4-8b32a2cd1fb70a8a1cb002d43a5d2dea48377bb422f571f1222e99bc924435e0.png']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 9 -  Certificates and awards of Mobicip title is not present");}
			if (a == true) {
				test1.pass("Section 9 -  Certificates and awards of Mobicip title is present");}
	}
	
	@Test(priority = 12)
	public void a12_section11() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section Footer Bark", "To check the Prelogin Mobicip vs Bark web page Footer section");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']")) );
		TimeUnit.SECONDS.sleep(2);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Bark page - Build better is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Bark page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Bark page - Footer is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Bark page - Footer is present");
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

	//------------------------------ Qustodio Competetor Page -----------------------------------------
	
	@Test(priority = 13)
	public void a13_QustodioPage() throws InterruptedException {
	      if(environment==1) {
			  webDriver.get("https://webs.prgr.in/content/mobicip-vs-qustodio");}
	      if(environment==2) {
	    	  webDriver.get("https://www.mobicip.com/content/mobicip-vs-qustodio");}
		ExtentTest test = extentreport.createTest("Competitor Qustodio Page", "To check the Qustodio web page title, header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Mobicip vs. Qustodio']")));
		WebElement l = webDriver.findElement(By.xpath("//h1[text()='Mobicip vs. Qustodio']"));

		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip vs. Qustodio - | Mobicip")) {
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

	@Test(priority = 14)
	public void a14_Section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1 Qustodio", "To check the Qustodio web page section 1");
		extentTest.set(test1);
		
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Mobicip vs. Qustodio']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Title text is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Title text is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//strong[text()='Why Choose ' and 'Over Qustodio?']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/09/19105617/Frame-427320755-1.jpg']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/16123547/APP-AND-PLAYSTOE-4.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/17063854/Adobe-Express-file-26.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110735/banner-image-1-1-1024x857.jpg']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Sub title Element and images is not present");
		}
		if (a == true) {
			test1.pass("Sub title Element and images is present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(3);
		}

		@Test(priority = 15)
		public void a15_Section2() throws InterruptedException {
			ExtentTest test1 = extentreport.createTest("section 2 Qustodio", "To check the Qustodio web page section 2");
			extentTest.set(test1);
			boolean	a = true;
		try {
			webDriver.findElement(By.xpath("//strong[text()='Challenging the limits of parental control tools ']"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'digital age, keeping your family safe online is more crucial than ever. With the plethora of devices and endless streams of content, ensuring your children')]"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'s online safety is a top priority for every parent. To help simplify this critical decision, we')]"));
			webDriver.findElement(By.xpath("//h3[contains(text(),'ve crafted a detailed comparison between two of the leading parental control apps available: Mobicip versus Qustodio.')]"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Qustodio web page section 2 is not present");
		}
		if (a == true) {
			test1.pass("Qustodio web page section 2 present");
		}
		
	}
	
	@Test(priority = 16)
	public void a16_Section3() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='Feature Comparison ']")) );
		TimeUnit.SECONDS.sleep(1);
		ExtentTest test1 = extentreport.createTest("section 3/4 Qustodio", "To check the Qustodio web page section 3/4");
			extentTest.set(test1);
			
			boolean a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Feature Comparison ']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 3 - Comparison title is not present");}
			if (a == true) {
				test1.pass("Section 3 - Comparison title is present");}
			
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='7-day free trial']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'offers a ')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'offers only a')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/logo-free-trial-2.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/1-2.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 1 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 1 is present");}
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110508/Frame-427320671.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()=' age-based screen time recommendations']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'equips you with the best ways to set time limits alongside')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'provides setting up time limits for screen time as a whole')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110508/Frame-427320671.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110507/Frame-427320670-9.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/2-2.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 2 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 2 is present");}
			//Point 3
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320757-1.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Facebook, and Snapchat']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Keeping an eye on your child’s social media activities is crucial in today')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'only tracks screen time without monitoring messages or providing alerts.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320757-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/3-1.jpg']"));
			} catch (NoSuchElementException e){
				a = false;
				test1.fail("Section 4 - Comparison point 3 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 3 is present");}
			//Point 4
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110932/logo-Block-Apps.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Don’t stress! Mobicip ']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Worried about your child’s safety on social media? Not sure if the age restrictions set by app creators are enough?')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'allows you to block inappropriate apps over various categories.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110932/logo-Block-Apps.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/4-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 4 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 4 is present");}
			//Point 5
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320760-1.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()=' Whitelist-Only Mode ']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'offers extensive website filtering ')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'digital well-being goes beyond just managing screen time—')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320760-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/5-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 5 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 5 is present");}
			//Point 6
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320763.png']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='integrated VPN and filtering, blocking unauthorized VPNs,']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'allows easy evasion of web filters via VPN.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'As a parent, you want to ensure your child’s online safety without worrying about VPN evasion.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320763.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/6-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 6 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 6 is present");}
			//Point 7
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320766-1.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//p[contains(text(),'Qustodio does not have this feature, making it easier for kids to uninstall and evade controls.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),' Apple account credentials for uninstallation on iOS, adding an extra layer of security to prevent children from bypassing restrictions.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320766-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/7-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 7 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 7 is present");}
			//Point 8
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320769-1.png']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()=' browsing history, app usage, and screen time.']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'provides comprehensive reports on')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320769-1.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/8-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 8 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 8 is present");}
			//Point 9
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320773-1.png']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//p[contains(text(),'Mobicip and Qustodio offer location monitoring features with real-time location tracking, location history reports, and Geofencing alerts.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Knowing your child’s whereabouts is crucial for their safety and your peace of mind.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/9-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Frame-427320773-1.png']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 9 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 9 is present");}
			//Point 10
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110925/logo-Pricing.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()=' $35.88/ year ']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'offers better features at a more affordable price.')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Premium plans start from')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110925/logo-Pricing.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/10.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison point 10 is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison point 10 is present");}		
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='What makes Mobicip the better option for you?']")) );
			a = true;
			try {webDriver.findElement(By.xpath("//strong[text()='What makes Mobicip the better option for you?']"));
			webDriver.findElement(By.xpath("//h2[text()='Following a comparison of all the features available between Mobicip and Qustodio, we are certain that Mobicip is superior in three key areas, making it the ideal choice for your family.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 - Comparison summary is not present");}
			if (a == true) {
				test1.pass("Section 4 - Comparison summary is present");}
	}
	
	
	@Test(priority = 17)
	public void a17_Section5() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110719/logo-Age-Based-Web-Category-Filtering-1-1.jpg']")) );
		TimeUnit.SECONDS.sleep(1);
		ExtentTest test1 = extentreport.createTest("section 5 Qustodio", "To check features of mobicip section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110719/logo-Age-Based-Web-Category-Filtering-1-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Age-based-illustration-1-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  Age based web filtering  title and pic is not present");}
			if (a == true) {
				test1.pass("Section 5 -  Age based web filtering  title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Detailed Descriptions of Each Category')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Profanity Filter')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Broad Browser Support')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Whitelist-only Mode')]"));
			webDriver.findElement(By.xpath("//p[contains(text(),': Mobicip provides clear, detailed descriptions of each web category it filters')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  Age based web filtering description points not present");}
			if (a == true) {
				test1.pass("Section 5 -  Age based web filtering description points is present");}
			
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110921/logo-Advanced-Screen-Time-Management.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
				
			a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110921/logo-Advanced-Screen-Time-Management.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Advanced-Screen-Time-illustration-1-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  Advanced-Screen-Time-Management title and pic is not present");}
			if (a == true) {
				test1.pass("Section 5 -  Advanced-Screen-Time-Management title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Customizable Schedules for Different Activities')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Age-Based Screen Time Recommendations')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Family Time Feature')]"));
			webDriver.findElement(By.xpath("//p[text()=': With just one click, the Family Time setting allows you to lock all monitored devices.']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip offers a range of advanced features that make it superior to Qustodio.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  Advanced-Screen-Time-Management description points not present");}
			if (a == true) {
				test1.pass("Section 5 -  Advanced-Screen-Time-Management description points is present");}
	
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110718/logo-Comprehensive-Social-Media-Monitoring-1.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110718/logo-Comprehensive-Social-Media-Monitoring-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/Social-Media-Monitoringillustration-1-3-1024x918.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 - Social-Media-Monitoring title and pic is not present");}
			if (a == true) {
				test1.pass("Section 5 - Social-Media-Monitoring title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Monitoring Tools for Major Platforms')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Detailed Activity Reports')]"));
			webDriver.findElement(By.xpath("//p[text()=': Mobicip offers advanced monitoring tools specifically designed for popular social media platforms like Facebook and Snapchat.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  Social-Media-Monitoring description points not present");}
			if (a == true) {
				test1.pass("Section 5 -  Social-Media-Monitoring description points is present");}
	}


	@Test(priority = 18)
	public void a18_Section6() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//div[@class='wp-block-jetpack-rating-star is-style-filled']")) );
		TimeUnit.SECONDS.sleep(1);
		ExtentTest test1 = extentreport.createTest("section 6 Qustodio", "To check the Real Customers Saying About Mobicip section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//div[@class='wp-block-jetpack-rating-star is-style-filled']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110022/Review-Sherin-1-300x103.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 7 -   Real Customers Saying About Mobicip title and pic is not present");}
			if (a == true) {
				test1.pass("Section 7 -   Real Customers Saying About Mobicip title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Mobicip has worked wonderfully for me and my family over the last year.')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'ve recommended it to many people and even included it as my top choice in a seminar our state PTA did last year on internet safety.')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Thank you for a fantastic app and your quick reply.')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'I am thrilled to find out customer service is as important to you as providing a quality application')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 7 -  What are Real Customers Saying About Mobicip description points not present");}
			if (a == true) {
				test1.pass("Section 7 -  What are Real Customers Saying About Mobicip description points is present");}
	}
	

	@Test(priority = 19)
	public void a19_Section9() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h2[text()='Mobicip Pricing']")) );
		TimeUnit.SECONDS.sleep(1);
		ExtentTest test1 = extentreport.createTest("section 9 Qustodio", "To check Pricing of Mobicip section");
			extentTest.set(test1);
			pricingSection(test1);
	}
	
	@Test(priority = 21)
	public void a21_Section10() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]")) );
		TimeUnit.SECONDS.sleep(1);
		ExtentTest test1 = extentreport.createTest("section 10 Qustodio", "To check Certificates and awards of Mobicip section");
			extentTest.set(test1);			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Certified')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Trusted')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Satisfaction')]"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_1-b972429cbd3fd9cf6af4996c4b3282508ae96813e26ce2196dbf349a7cdc75be.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_2-69db14cac1bcaf7f6a6f434a5aded72634ad1154f4e1e55f04b217c0bc282757.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_3-b5551a1c3ebd8cb9eb86aa597aec0d666ed9448c075bdd597d2c9f64b36a3a26.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_4-8b32a2cd1fb70a8a1cb002d43a5d2dea48377bb422f571f1222e99bc924435e0.png']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 9 -  Certificates and awards of Mobicip title is not present");}
			if (a == true) {
				test1.pass("Section 9 -  Certificates and awards of Mobicip title is present");}
	}
	
	@Test(priority = 22)
	public void a22_section11() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section Footer Qustodio", "To check the Prelogin Mobicip vs Qustodio web page Footer section");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']")) );
		TimeUnit.SECONDS.sleep(1);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Qustodio page - Build better is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Qustodio page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Qustodio page - Footer is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Qustodio page - Footer is present");
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

//	--------------------------- Kidslox -----------------------------------------------

	
	@Test(priority = 23)
	public void a23_KidsloxPage() throws InterruptedException {
	      if(environment==1) {
			  webDriver.get("https://webs.prgr.in/content/mobicip-vs-kidslox");}
	      if(environment==2) {
	    	  webDriver.get("https://www.mobicip.com/content/mobicip-vs-kidslox");}
		ExtentTest test = extentreport.createTest("Competitor Kidslox Page", "To check the Kidslox web page title, header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Mobicip vs Kidslox']")));
		WebElement l = webDriver.findElement(By.xpath("//h1[text()='Mobicip vs Kidslox']"));

		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip vs Kidslox - | Mobicip")) {
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

	@Test(priority = 24)
	public void a24_Section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1 Kidslox", "To check the Kidslox web page section 1");
		extentTest.set(test1);
		
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Mobicip vs Kidslox']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Title text is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Title text is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//strong[text()='Why Choose ' and 'Over Kidslox?']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Frame-427320755.jpg']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/16123547/APP-AND-PLAYSTOE-4.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/17063854/Adobe-Express-file-26.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/banner-image-3-3-1024x857.jpg']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Sub title Element and images is not present");
		}
		if (a == true) {
			test1.pass("Sub title Element and images is present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(3);
	}
	
	@Test(priority = 25)
	public void a25_Section2() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='Parental Control Feature Analysis']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 2 Kidslox", "To check the Kidslox web page section 4");
			extentTest.set(test1);
			
			boolean a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Parental Control Feature Analysis']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison title is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison title is present");}
			
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Cross Platform Solution']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'A robust parental control app should provide seamless functionality across all major platforms and devices.')]"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'Android, iOS, Windows, macOS, Kindle devices, and Chromebooks')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/1-3.jpg']"));
				webDriver.findElement(By.xpath("//p[text()=' but lacks compatibility with other devices like Kindles and Chromebooks.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 1 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 1 is present");}
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='iOS Device Compatibility']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//mark[text()='iOS Device Compatibility']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Effective parental control apps should leverage iOS-specific features for a smoother and more integrated experience.')]"));
				webDriver.findElement(By.xpath("//p[text()='Mobicip offers seamless integration with Apple Screen Time, providing easy setup and comprehensive monitoring to manage your child’s device effectively.']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Kidslox works on iOS devices but lacks advanced integration with Apple-specific features like Screen time.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/2-4.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 2 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 2 is present");}
			//Point 3
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Free trial']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Free trial']"));
				webDriver.findElement(By.xpath("//strong[text()='3-day free trial']"));
				webDriver.findElement(By.xpath("//strong[text()='7-day free trial']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'A free trial lets parents test a parental control app before committing to a subscription.')]"));
				webDriver.findElement(By.xpath("//p[text()=' with full access to all features, allowing parents to thoroughly explore its capabilities.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/3-4.jpg']"));
			} catch (NoSuchElementException e){
				a = false;
				test1.fail("Section 2 - Comparison point 3 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 3 is present");}
			//Point 4
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Screen Time Scheduling']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Screen Time Scheduling']"));
				webDriver.findElement(By.xpath("//strong[text()='pause all devices']"));
				webDriver.findElement(By.xpath("//strong[text()='custom schedules']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Kidslox allows you to set daily time limits and schedules, but its uniform rules for all time segments may lack the flexibility needed for varied routines.')]"));
				webDriver.findElement(By.xpath("//p[text()=', block specific apps and websites during key hours, and even ']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/4-3.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 4 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 4 is present");}
			//Point 5
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Content Filtering and Monitoring']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Content Filtering and Monitoring']"));
				webDriver.findElement(By.xpath("//strong[text()=' 20+ web categories']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Effective content monitoring helps shield children from inappropriate material and promotes safe online exploration')]"));
				webDriver.findElement(By.xpath("//p[text()='Kidslox lacks advanced filtering technologies for comprehensive monitoring.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/5-3.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 5 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 5 is present");}
			//Point 6
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Social Media Monitoring']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Social Media Monitoring']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Monitoring social media helps protect kids from harmful content and unsafe interactions.')]"));
				webDriver.findElement(By.xpath("//p[text()='Mobicip monitors content on Facebook and Snapchat, sending real-time alerts for harmful or inappropriate activity.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/6-1.jpg']"));
				webDriver.findElement(By.xpath("//p[text()='Kidslox does not offer social media monitoring.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 6 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 6 is present");}
			//Point 7
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Blocking']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Blocking']"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'category-based options')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Unrestricted access to apps and websites can expose kids to inappropriate content and distractions.')]"));
				webDriver.findElement(By.xpath("//p[text()='Kidslox enables permanent blocking of inappropriate apps, games, and websites.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/7-3.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 7 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 7 is present");}
			//Point 8
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Activity reports and alerts']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Activity reports and alerts']"));
				webDriver.findElement(By.xpath("//strong[text()='detailed overview']"));					
				webDriver.findElement(By.xpath("//strong[text()='basic activity reports']"));							
				webDriver.findElement(By.xpath("//p[contains(text(),'Staying informed about your child')]"));
				webDriver.findElement(By.xpath("//p[text()=' of browsing history, app usage, and screen time, along with real-time alerts to keep parents informed.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/8-2.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 8 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 8 is present");}
			//Point 9
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Uninstall Protection']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Uninstall Protection']"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'Mobicip prevents unauthorized uninstallation')]"));
				webDriver.findElement(By.xpath("//strong[contains(text(),'deleting the app disables all protections')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Uninstall protection ensures kids can’t bypass parental controls by simply deleting the app.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/9-3.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 9 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 9 is present");}
			//Point 10
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Location tracking']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Location tracking']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Location tracking ensures peace of mind by keeping parents informed about their child’s whereabouts.')]"));
				webDriver.findElement(By.xpath("//p[text()='Mobicip provides real-time location tracking and detailed location history.']"));
				webDriver.findElement(By.xpath("//p[text()='Kidslox also offers real-time location tracking and history.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/10-3.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 10 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 10 is present");}		
			//Point 11
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Additional Parent']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Additional Parent']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Sharing parental control responsibilities is easier with support for multiple parent accounts.')]"));
				webDriver.findElement(By.xpath("//p[text()='Mobicip allows two parents or guardians to manage the same family account independently, ensuring shared supervision without sharing login credentials.']"));
				webDriver.findElement(By.xpath("//p[text()='Kidslox does not support adding multiple parent accounts, requiring parents to share a single login for joint supervision.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/12-5.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 11 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 11 is present");}	
			//Point 12
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Geofencing']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Geofencing']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Geofencing provides peace of mind by alerting parents when children move in and out of designated safe zones.')]"));
				webDriver.findElement(By.xpath("//p[text()='Mobicip’s geofencing feature allows parents to set virtual boundaries around key locations like schools or friends’ homes, with alerts when children enter or leave these areas.']"));
				webDriver.findElement(By.xpath("//p[text()=' supports geofencing for essential locations, but its interface for setting boundaries is less user-friendly.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/13.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 12 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 12 is present");}		
			//Point 13
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Trust and Privacy']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Trust and Privacy']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Spyware features in parental control apps can significantly impact trust and privacy within families.')]"));
				webDriver.findElement(By.xpath("//p[text()='Mobicip focuses on alerts for potential issues, promoting trust and proactive engagement without invasive monitoring.']"));
				webDriver.findElement(By.xpath("//p[text()='On Androids, Kidslox will take a screenshot of your child’s phone and send it to you anytime.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/14-1.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 13 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 13 is present");}		
			//Point 14
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[text()='Child Accounts']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Child Accounts']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Parental control apps should accommodate all your family’s devices for seamless management.')]"));
				webDriver.findElement(By.xpath("//p[text()=', making it ideal for larger families or households with multiple devices.']"));
				webDriver.findElement(By.xpath("//p[text()=', suitable for smaller families or fewer devices.']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/15.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 14 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 14 is present");}		
			//Point 13
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/11-10.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/11-10.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison pricing img is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison pricing img is present");}		
	
	}
	
	
	@Test(priority = 26)
	public void a26_Section3() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Who-Should-Choose-Bark_.jpg']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 3 Kidslox", "To check the who should choose Kidslox section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Who-Should-Choose-Bark_.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/kidslox-Illustration-4-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 3 -  who should choose Kidslox  title and pic is not present");}
			if (a == true) {
				test1.pass("Section 3 -  who should choose Kidslox  title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Choose Kidslox if:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Only Need Core Features')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Okay Without Social Media Monitoring')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Have a Smaller Family')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Geofencing Isn')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Use Non-iOS Devices')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'t Need Multiple Parent Accounts')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 3 -  who should choose Kidslox description points not present");}
			if (a == true) {
				test1.pass("Section 3 -  who should choose Kidslox description points is present");}
	}
	
	@Test(priority = 27)
	public void a27_Section4() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110210/Who-Should-Choose-Mobicip_-1.jpg']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 4 Kidslox", "To check the who should choose Mobicip section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2024/08/19110210/Who-Should-Choose-Mobicip_-1.jpg']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Mobidcip-Illustration-4-2-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 -  who should choose Mobicip title and pic is not present");}
			if (a == true) {
				test1.pass("Section 4 -  who should choose Mobicip title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Choose Mobicip if:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Need Advanced Features')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Want Social Media Monitoring')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Have a Larger Family')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Use iOS Devices')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Need Geofencing')]"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip offers robust parental control tools, including detailed activity reports, real-time alerts, and advanced app blocking options like category-based filters and Whitelist-Only Mode.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip monitors activity on Facebook and Snapchat, sending alerts for harmful or inappropriate content, making it ideal for families with teens and tweens.']"));
			webDriver.findElement(By.xpath("//li[text()='With support for up to 20 devices, Mobicip is perfect for larger households or families with multiple devices.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip seamlessly integrates with Apple Screen Time, offering easy setup and excellent monitoring tailored for iOS users.']"));
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//strong[contains(text(),'You Want Strong Uninstall Protection')]")) );
			TimeUnit.SECONDS.sleep(1);
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Prefer a Longer Free Trial')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Need Multiple Parent Accounts')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Want Strong Uninstall Protection')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You Value Comprehensive Cross-Platform Support')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You are on a budget')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'You want custom content filtering')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'$2.99/month')]"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip requires parent credentials for uninstallation on both iOS and Android, ensuring children cannot bypass the controls.']"));
			webDriver.findElement(By.xpath("//li[text()=' Mobicip offers a 7-day free trial with full access to all features.']"));
			webDriver.findElement(By.xpath("//li[text()=' Mobicip works across Android, iOS, Windows, macOS, Kindle devices, and Chromebooks.']"));
			webDriver.findElement(By.xpath("//li[text()='Mobicip offers budget-friendly plans starting from ']"));
			webDriver.findElement(By.xpath("//li[text()='The filtering options in Mobicip are plentiful.']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 -  who should choose Mobicip description points not present");}
			if (a == true) {
				test1.pass("Section 4 -  who should choose Mobicip description points is present");}
	}
	

	@Test(priority = 28)
	public void a28_Section5() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Kidslox?']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 5 Kidslox", "To check the What are Real Customers Saying About Kidslox section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Kidslox?']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/kidslox-review-2-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  What are Real Customers Saying About Kidslox title and pic is not present");}
			if (a == true) {
				test1.pass("Section 5 -  What are Real Customers Saying About Kidslox title and pic is present");}
			a = true;
			try {
			webDriver.findElement(By.xpath("//strong[contains(text(),'Limited functionality and buggy performance')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Unreliable and stressful experience')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'No free trial and refund issues')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Ineffective blocking and poor customer service')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Easy to bypass')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 5 -  What are Real Customers Saying About Kidslox description points not present");}
			if (a == true) {
				test1.pass("Section 5 -  What are Real Customers Saying About Kidslox description points is present");}
	}
	
	@Test(priority = 29)
	public void a29_Section6() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Mobicip?']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 6 Kidslox", "To check the What are Real Customers Saying About Mobicip section");
			extentTest.set(test1);
			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//strong[text()='What are Real Customers Saying About Using Mobicip?']"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/Mobicip-review-1-1024x1024.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 6 -  What are Real Customers Saying About Mobicip title and pic is not present");}
			if (a == true) {
				test1.pass("Section 6 -  What are Real Customers Saying About Mobicip title and pic is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//strong[contains(text(),'Stress relief and peace of mind:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Ensuring family safety online:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Most user friendly parental control app:')]"));
			webDriver.findElement(By.xpath("//strong[contains(text(),'Great software and customer service')]"));
			webDriver.findElement(By.xpath("//p[text()='Here are some feedbacks by parents regarding mobicip:']"));
						
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 6 -  What are Real Customers Saying About Mobicip description points not present");}
			if (a == true) {
				test1.pass("Section 6 -  What are Real Customers Saying About Mobicip description points is present");}
	}
	
	
	@Test(priority = 30)
	public void a30_Section7() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h3[contains(text(),'Choose the plan that')]")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 9 Kidslox", "To check Pricing of Mobicip section");
			extentTest.set(test1);
			pricingSection(test1);
	}
	
	@Test(priority = 31)
	public void a31_Section8() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 10 Kidslox", "To check Certificates and awards of Mobicip section");
			extentTest.set(test1);			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Certified')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Trusted')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Satisfaction')]"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_1-b972429cbd3fd9cf6af4996c4b3282508ae96813e26ce2196dbf349a7cdc75be.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_2-69db14cac1bcaf7f6a6f434a5aded72634ad1154f4e1e55f04b217c0bc282757.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_3-b5551a1c3ebd8cb9eb86aa597aec0d666ed9448c075bdd597d2c9f64b36a3a26.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_4-8b32a2cd1fb70a8a1cb002d43a5d2dea48377bb422f571f1222e99bc924435e0.png']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 8 -  Certificates and awards of Mobicip title is not present");}
			if (a == true) {
				test1.pass("Section 8 -  Certificates and awards of Mobicip title is present");}
	}
	
	@Test(priority = 32)
	public void a32_section9() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section Footer Kidslox", "To check the Prelogin Mobicip vs Kidslox web page Footer section");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']")) );
		TimeUnit.SECONDS.sleep(2);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Kidslox page - Build better is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Kidslox page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Kidslox page - Footer is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Kidslox page - Footer is present");
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

//	--------------------------- Net Nanny -----------------------------------------------

	
	@Test(priority = 33)
	public void a33_NetNannyPage() throws InterruptedException {
	      if(environment==1) {
			  webDriver.get("https://webs.prgr.in/content/mobicip-vs-net-nanny");}
	      if(environment==2) {
	    	  webDriver.get("https://www.mobicip.com/content/mobicip-vs-net-nanny");}
		ExtentTest test = extentreport.createTest("Competitor Net Nanny Page", "To check the Net Nanny web page title, header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Mobicip vs. Net Nanny']")));
		WebElement l = webDriver.findElement(By.xpath("//h1[text()='Mobicip vs. Net Nanny']"));

		// Javascript executor
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip vs. Net Nanny - | Mobicip")) {
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

	@Test(priority = 34)
	public void a34_Section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1 Net Nanny", "To check the Net Nanny web page section 1");
		extentTest.set(test1);
		
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='Mobicip vs. Net Nanny']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 - Title text is not present");
		}
		if (a == true) {
			test1.pass("Section 1 - Title text is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//strong[text()='Why Choose ' and 'Over Net Nanny?']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/10/Frame-408-1.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/16123547/APP-AND-PLAYSTOE-4.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads/2025/04/17063854/Adobe-Express-file-26.png']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/10/banner-image-3-3-1024x857.jpg']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Sub title Element and images is not present");
		}
		if (a == true) {
			test1.pass("Sub title Element and images is present");
		}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(2);
	}
	
	@Test(priority = 35)
	public void a35_Section2() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//strong[text()='Comparison of Parental Control Features']")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 2 Net Nanny", "To check the Net Nanny web page section 2");
			extentTest.set(test1);
			
			boolean a = true;
			try {
				webDriver.findElement(By.xpath("//strong[text()='Comparison of Parental Control Features']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison title is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison title is present");}
			
			a = true;
			try {
				webDriver.findElement(By.xpath("//mark[text()='Supported Devices']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'s multi-device homes, you need a parental control app that works across platforms.')]"));
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/1-10.jpg']"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Mobicip covers Windows, Mac, Android, iOS, Kindle, and Chromebook, giving you broad coverage for all your')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 1 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 1 is present");}
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='iOS Device Compatibility']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='iOS Device Compatibility']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Net Nanny is also compatible with iOS, but it doesn')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/10-2.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip offers easy setup, excellent monitoring, and seamless integration with Apple Screen Time, making it simple to manage your child’s usage.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 2 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 2 is present");}
			//Point 3
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Free Trial']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Free Trial']"));
			webDriver.findElement(By.xpath("//mark[text()='7-day free trial']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'When choosing a parental control app, a free trial is a great way to test if the app is suitable to your needs.')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/2-3.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Net Nanny provides a 3-day free trial period limited to just the parent’s device.']"));} catch (NoSuchElementException e){
				a = false;
				test1.fail("Section 2 - Comparison point 3 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 3 is present");}
			//Point 4
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Uninstall Protection']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Uninstall Protection']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Mobicip enhances security by requiring a parent')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/11.jpg']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'t offer this level of uninstall protection.')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 4 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 4 is present");}
			//Point 5
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Screen Time Limits']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Screen Time Limits']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Too much screen time can lead to issues like poor sleep, decreased focus, and even negative impacts on mental health.')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/3.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip offers great flexibility for managing screen time, with options for daily and weekly scheduling, age-based screen time recommendations, and the ability to block or customize time limits for specific apps and websites. If your child exceeds their daily limit, Mobicip immediately blocks further usage.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 5 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 5 is present");}
			//Point 6
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='App Blocking']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='App Blocking']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'App blocking is essential for protecting your child from inappropriate content and distractions, helping them focus on what’s important.')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/4.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip allows blocking apps across various categories, features a Whitelist-Only Mode for approved websites, and sends notifications for new app installations, ensuring full control.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 6 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 6 is present");}
			//Point 7
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Web Filtering And Safe Search']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Web Filtering And Safe Search']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Mobicip offers filtering across 20 categories with a profanity filter, ensuring a safe, tailored online experience for your child.')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2025/01/5-2.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Net Nanny provides web filtering across 14 categories. It lacks the extensive category coverage and profanity filtering offered by Mobicip.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 7 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 7 is present");}
			//Point 8
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Activity Reports And Alerts']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Activity Reports And Alerts']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Activity reports and alerts are crucial for keeping parents informed about their child’s digital habits and ensuring their safety online.')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/6.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip offers a comprehensive overview of browsing history, daily app usage, and screen time, allowing parents to monitor their child’s online activities effectively.']"));
			webDriver.findElement(By.xpath("//p[text()='Net Nanny does not email reports, but allows parents to view real-time, web-based reports including websites and online search terms via their Family-feed and to receive alerts of warned or blocked activities.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 8 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 8 is present");}
			//Point 9
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Social Media Monitoring']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Social Media Monitoring']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/7-1.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip offers robust social media monitoring by tracking activity on Instagram, Facebook, and Snapchat, scanning for harmful content and sending real-time alerts.']"));
			webDriver.findElement(By.xpath("//p[text()='Net Nanny also monitors social media, but it lacks real-time alerts and doesn’t cover Snapchat.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 9 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 9 is present");}
			//Point 10
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Family Locator']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Family Locator']"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/8-1.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Family location tracking is vital for ensuring your child’s safety by knowing where they are at all times.']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip offers comprehensive location monitoring with real-time tracking, location history reports, and Geofencing alerts that notify you if your child enters or leaves a designated area.Net Nanny also provides GPS-based location tracking but lacks advanced features like location history or Geofencing alerts.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 10 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 10 is present");}		
			//Point 11
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//mark[text()='Geofencing']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {webDriver.findElement(By.xpath("//mark[text()='Geofencing']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Geofencing is a powerful tool for keeping your child safe by alerting you when they enter or leave specific areas.')]"));
			webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/11/9-3.jpg']"));
			webDriver.findElement(By.xpath("//p[text()='Mobicip lets you set up zones in advance and customize the zone size.']"));
			webDriver.findElement(By.xpath("//p[text()='Net Nanny only allows you to create geofences around places your child has already visited, with no option to adjust the zone size or predefined zones.']"));} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison point 11 is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison point 11 is present");}	
			//Comparison Picture
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/00.jpg']")) );
			TimeUnit.SECONDS.sleep(1);
			a = true;
			try {
				webDriver.findElement(By.xpath("//img[@src='https://mobicip-content-files.s3.amazonaws.com/wp-content/uploads-cms/2024/12/00.jpg']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 2 - Comparison pricing img is not present");}
			if (a == true) {
				test1.pass("Section 2 - Comparison pricing img is present");}		
	}
	
	
	@Test(priority = 36)
	public void a36_Section3() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h3[contains(text(),'Choose the plan that')]")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 3 Netnanny", "To check Pricing of Mobicip section");
			extentTest.set(test1);
			pricingSection(test1);
	}
	
	@Test(priority = 37)
	public void a37_Section4() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]")) );
		TimeUnit.SECONDS.sleep(2);
		ExtentTest test1 = extentreport.createTest("section 4 Netnanny", "To check Certificates and awards of Mobicip section");
			extentTest.set(test1);			
			boolean a = true;
			try {webDriver.findElement(By.xpath("//p[contains(text(),'s Choice Awards Gold Recipient')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Certified')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Trusted')]"));
				webDriver.findElement(By.xpath("//p[contains(text(),'Satisfaction')]"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_1-b972429cbd3fd9cf6af4996c4b3282508ae96813e26ce2196dbf349a7cdc75be.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_2-69db14cac1bcaf7f6a6f434a5aded72634ad1154f4e1e55f04b217c0bc282757.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_3-b5551a1c3ebd8cb9eb86aa597aec0d666ed9448c075bdd597d2c9f64b36a3a26.png']"));
				webDriver.findElement(By.xpath("//img[@src='https://www.mobicip.com/assets/content/pricing/pricing_logo_4-8b32a2cd1fb70a8a1cb002d43a5d2dea48377bb422f571f1222e99bc924435e0.png']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Section 4 -  Certificates and awards of Mobicip title is not present");}
			if (a == true) {
				test1.pass("Section 4 -  Certificates and awards of Mobicip title is present");}
	}
	
	@Test(priority = 38)
	public void a8_section5() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("section Footer Netnanny", "To check the Prelogin Mobicip vs Kidslox web page Footer section");
		extentTest.set(test5);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']")) );
		TimeUnit.SECONDS.sleep(2);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Netnanny page - Build better is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Netnanny page - Build better is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Mobicip vs Netnanny page - Footer is not present");
		}
		if (a == true) {
			test5.pass("Mobicip vs Netnanny page - Footer is present");
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
	
	public void pricingSection(ExtentTest test1) throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("arguments[0].scrollIntoView()", 
				webDriver.findElement(By.xpath("//h2[contains(text(),'Mobicip Pricing')]")) );
		TimeUnit.SECONDS.sleep(2);
			extentTest.set(test1);
		boolean a = true;
		try {webDriver.findElement(By.xpath("//h2[text()='Mobicip Pricing']"));
				webDriver.findElement(By.xpath("//h3[contains(text(),'Choose the plan that')]"));
				webDriver.findElement(By.xpath("//h3[contains(text(),'s right for your family')]"));
				webDriver.findElement(By.xpath("//h4[contains(text(),'Enjoy Premium features')]"));
				webDriver.findElement(By.xpath("//span[contains(text(),'FREE for 7 days')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Mobicip title is not present");}
			if (a == true) {
				test1.pass("Mobicip title is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Premium')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'$7.99')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//span[contains(text(),'/month')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Billed Annually')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Best Value')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//a[contains(text(),'Start Free Trial')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Manage up to 20 Devices')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'App Blocker')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Website Blocker')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Uninstall Protection')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Screen Time Limits')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Activity Schedules')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Family Locator')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Remotely Lock Devices')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Activity Reports')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Social Media Monitor')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'App Timers')]"));
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//p[contains(text(),'Parenting Expert Tips')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Premium of Mobicip details is not present");}
			if (a == true) {
				test1.pass("Premium of Mobicip details is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Standard')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'$4.99')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//span[contains(text(),'/month')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Billed Annually')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//a[contains(text(),'Start Free Trial')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Manage up to 10 Devices')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'App Blocker')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Website Blocker')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Uninstall Protection')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Screen Time Limits')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Activity Schedules')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Family Locator')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Remotely Lock Devices')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Activity Reports')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Social Media Monitor')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'App Timers')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container standard')]//p[contains(text(),'Parenting Expert Tips')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Standard of Mobicip details is not present");}
			if (a == true) {
				test1.pass("Standard of Mobicip details is present");}
			a = true;
			try {webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Lite')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'$2.99')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//span[contains(text(),'/month')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Billed Annually')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//a[contains(text(),'Start Free Trial')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Manage up to 5 Devices')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'App Blocker')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Website Blocker')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Uninstall Protection')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Screen Time Limits')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Activity Schedules')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Family Locator')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Remotely Lock Devices')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Activity Reports')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Social Media Monitor')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'App Timers')]"));
			webDriver.findElement(By.xpath("//li[contains(@class,'pricing_container lite')]//p[contains(text(),'Parenting Expert Tips')]"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Lite of Mobicip details is not present");}
			if (a == true) {
				test1.pass("Lite of Mobicip details is present");}
			
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//a[contains(text(),'Start Free Trial')]")) );
			webDriver.findElement(By.xpath("//li[@class='pricing_container premium ']//a[contains(text(),'Start Free Trial')]")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[text()='Welcome to Mobicip']")));
			a = true;
			try {webDriver.findElement(By.xpath("//h1[text()='Welcome to Mobicip']"));
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Start new trail not opened signup page");}
			if (a == true) {
				test1.pass("Start new trail opened signup page");}
			webDriver.navigate().back();
			new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//p[contains(text(),' Have more than 20 devices ?')]")));
			j.executeScript("arguments[0].scrollIntoView()", 
					webDriver.findElement(By.xpath("//p[contains(text(),' Have more than 20 devices ?')]")) );
			TimeUnit.SECONDS.sleep(2);
			new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//img[contains(@src,'https://www.mobicip.com/assets/content/pricing/quote_image-9fc92f62e5f83747aad089612285c83fd24bd2e1ec2b6d014f19a3ac68462418.png')]")));
			a = true;
			try {webDriver.findElement(By.xpath("//p[contains(text(),' Have more than 20 devices ?')]"));
			webDriver.findElement(By.xpath("//a[contains(text(),'Get a Quote')]"));
			webDriver.findElement(By.xpath("//img[contains(@src,'https://www.mobicip.com/assets/content/pricing/quote_image-9fc92f62e5f83747aad089612285c83fd24bd2e1ec2b6d014f19a3ac68462418.png')]"));						
			} catch (NoSuchElementException e) {
				a = false;
				test1.fail("Quote more then 20 devices of Mobicip details is not present");}
			if (a == true) {
				test1.pass("Quote more then 20 devices details is present");}
	}

}
