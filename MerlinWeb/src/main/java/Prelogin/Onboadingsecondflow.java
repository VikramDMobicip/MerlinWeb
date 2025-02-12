package Prelogin;

//Change 106 Email account each and every time before running the code

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Onboadingsecondflow extends BrowserSetupClass {

	/*
	 * ExtentReports extent; ExtentTest test1;
	 * 
	 * @BeforeClass public void beforeTest() { extent = new ExtentReports();
	 * ExtentSparkReporter spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\OnboardingFlow2\\OnboardingFlow2Report.html");
	 * extent.attachReporter(spark); }
	 */
	@Test(priority = 1)
	public void a1_homePage() throws InterruptedException {
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		String actit = webDriver.getTitle();
		ExtentTest test = extentreport.createTest("Signup page");
		extentTest.set(test);
		if (actit.equals("Best Parental Control App for Busy Parents | Mobicip")) {
			test.pass("Home page Title is shown correct");
		} else {
			Assert.fail("Home page Title is not correct");
		}
		boolean a = webDriver.findElement(By.xpath("//a[@data-turbolinks='false' and @class='header_link login']"))
				.isEnabled();
		if (a) {
			test.pass("Login button is enabled");
		} else {
			Assert.fail("Login button is disabled");
		}
		webDriver.findElement(By.xpath("//a[@data-turbolinks='false' and @class='header_link login']")).click();

		new WebDriverWait(webDriver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Login']")));
		String actit1 = webDriver.getTitle();
		System.out.println();
		String extit1 = "Login | Mobicip";
		ExtentTest test1 = extentreport.createTest("Login page");
		extentTest.set(test1);
		if (actit1.equals(extit1)) {
			test1.pass("Login page title is shown correct");
		} else {
			Assert.fail("Login page title is not correct");
		}
		boolean b = webDriver.findElement(By.xpath("//a[@class='b_link' and text()='Sign Up']")).isDisplayed();
		if (b) {
			test1.pass("Signup is displayed");
		} else {
			Assert.fail("Signup is not displayed");
		}
	}

	@Test(priority = 2)
	public void b2_signUp() throws InterruptedException {
		// Sign up page - page title
		webDriver.findElement(By.xpath("//a[@class='b_link' and text()='Sign Up']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Welcome to Mobicip']")));
		String actit = webDriver.getTitle();
		String extit = "Create Account | Mobicip";
		ExtentTest test = extentreport.createTest("Signup page");
		extentTest.set(test);
		if (actit.equals(extit)) {
			test.pass("Signup page title is shown correct");
		} else {
			Assert.fail("Signup page title is not correct");
		}

		/*
		 * // UI Validation a=true; try{
		 * webDriver.findElement(By.xpath("//a[@class='company_logo']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Mobicip Logo is not shown");}
		 * if(a==true){test1.pass("Mobicip Logo is shown");}
		 * 
		 * 
		 * a=true; try{
		 * webDriver.findElement(By.xpath("/h1[text()='Welcome to Mobicip']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Welcome to Mobicip is not shown");}
		 * if(a==true){test1.pass("Welcome to Mobicip is shown");}
		 * 
		 * }
		 * 
		 * 
		 * a=true; try{
		 * webDriver.findElement(By.xpath("/h1[text()='Welcome to Mobicip']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Welcome to Mobicip is not shown");}
		 * if(a==true){test1.pass("Welcome to Mobicip is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{ webDriver.findElement(By.
		 * xpath("//p[text()='Join 2M+ parents who trust us for peace of mind!']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Description is not shown");}
		 * if(a==true){test1.pass("Description is shown");}
		 * 
		 * } a=true; try{ webDriver.findElement(By.xpath("//p[@class='agree_terms']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Terms and Privacy policy links are not shown");}
		 * if(a==true){test1.pass("Terms and Privacy policy links are shown");}
		 * 
		 * }
		 * 
		 * a=true; try{
		 * webDriver.findElement(By.xpath("//span[text()='Already have an account?']"));
		 * }
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("'Already have an account?; question is not shown");}
		 * if(a==true){test1.pass("'Already have an account?; question is shown");}
		 * 
		 * } a=true; try{ webDriver.findElement(By.xpath("//a[text()='Log in']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Login button is not shown");}
		 * if(a==true){test1.pass("Login button is shown");}
		 * 
		 * } a=true; try{ webDriver.findElement(By.xpath(
		 * "//img[@src='//www.mobicip.com/packs/media/images/app/rating_icons/a_rating-ef5443eaafc4750933d60acb3a824bf0.png']"
		 * ));}
		 * 
		 * catch(NoSuchElementException e){a=false; test1.fail("Logo 1 is not shown");}
		 * if(a==true){test1.pass("Logo 1 is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{ webDriver.findElement(By.xpath(
		 * "//img[@src='//www.mobicip.com/packs/media/images/app/rating_icons/moms_choice_award-5c9e44244bde3e38a1df9206774d9b88.png']"
		 * ));}
		 * 
		 * catch(NoSuchElementException e){a=false; test1.fail("Logo 2 is not shown");}
		 * if(a==true){test1.pass("Logo 2 is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{ webDriver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div[2]/div"));
		 * }
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Rating text content is not shown");}
		 * if(a==true){test1.pass("Rating text content is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{ webDriver.findElement(By.xpath(
		 * "//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_appstore-e0ebbfc99b685b4a2d6b1b7a4ea4fecd.png']"
		 * ));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("App store button is not shown");}
		 * if(a==true){test1.pass("App store button is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{ webDriver.findElement(By.xpath(
		 * "//img[@src='//www.mobicip.com/packs/media/images/app/download_icons/icn_playstore-33ae99d898e079561abac629ceefb3b8.png']"
		 * ));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("Playstore button is not shown");}
		 * if(a==true){test1.pass("Playstore button is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{
		 * webDriver.findElement(By.xpath(//img[@src='//www.mobicip.com/packs/media/
		 * images/app/download_icons/icn_mac-73c55d0fdea70f11a885445ba98ce829.png']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("'Download for Mac OS' is not shown");}
		 * if(a==true){test1.pass("'Download for Mac OS' is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{
		 * webDriver.findElement(By.xpath(//img[@src='//www.mobicip.com/packs/media/
		 * images/app/download_icons/icn_windows-d4eab1d89de23bbb2a376a0640c2ff25.png']"
		 * ));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("'Download for Windows' button is not shown");}
		 * if(a==true){test1.pass("'Download for Windows' button is shown");}
		 * 
		 * }
		 * 
		 * a=true; try{
		 * webDriver.findElement(By.xpath(//img[@src='//www.mobicip.com/packs/media/
		 * images/app/download_icons/icn_chromebook-93e5217b4293f5e99ab275b4a5bc219b.png
		 * ']"));}
		 * 
		 * catch(NoSuchElementException e){a=false;
		 * test1.fail("'Download for Chromebook' button is not shown");}
		 * if(a==true){test1.pass("'Download for Chromebook' button is shown");}
		 * 
		 * }
		 */

		// Sign up - Create account with Valid accounts
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timestamp = now.format(formatter);
		webDriver.navigate().refresh();
		webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("vikram");
		LocalDateTime datetime;

		webDriver.findElement(By.xpath("//input[@placeholder = 'Email']"))
				.sendKeys("vikram+" + timestamp + "@mobicip.com");

		webDriver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("12345");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Congratulations!']")));
		boolean a = webDriver.findElement(By.xpath("//h5[text()='Congratulations!']")).isDisplayed();
		if (a) {
			test.pass("Account Created successfully with valid inputs");
		} else {
			Assert.fail("Account creation unsuccessful with valid inputs");
		}
	}

	private String timestamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority = 3)
	public void c3_addCoparent() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Add CoParent Page");
		extentTest.set(test);
		// Verify if Add coparent page title is correct
		String actit = webDriver.getTitle();
		System.out.println();
		if (actit.equals("Add Co-Parent | Onboarding | Mobicip")) {
			test.pass("Add Coparent page title is shown correct");
		} else {
			Assert.fail("Add Coparent page title is not shown correct");
		}

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[text()='Do it Later']")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("'Do it Later' link redirects failed");
		}
		if (a == true) {
			test.pass("'Do it Later' link redirects works fine");
		}
		TimeUnit.SECONDS.sleep(5);
	}

	@Test(priority = 4)
	public void d4_addChild() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		ExtentTest test = extentreport.createTest("Add Child Page");
		extentTest.set(test);
		// Verify if Add Child page title is correct
		String actit = webDriver.getTitle();
		System.out.println();
		if (actit.equals("Add a Child | Onboarding | Mobicip")) {
			test.pass("Add Child page title is shown correct");
		} else {
			Assert.fail("Add Child page title is not shown correct");
		}
		// Verify adding child with valid inputs

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		Boolean a;
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Child One");
		Thread.sleep(3000);
		Select date = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("11");
		Select month = new Select(
				webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("9");
		Select year = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2005");
		Thread.sleep(1000);
		date.selectByValue("15");
		month.selectByValue("10");
		Thread.sleep(1000);
		year.selectByValue("2006");
		webDriver.findElement(By.xpath("//input[@id='filter_monitor_and_manage']/following::label[1]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//button[.='Add']")).click();
		Thread.sleep(5000);
		try {
			webDriver.findElement(By.xpath("//h5"));
			a = true;
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Add Child - Not successfull with valid inputs");
		}
		if (a == true) {
			test.pass("Add Child - Successfully added with valid inputs");
		}
	}

	@Test(priority = 5)
	public void e5_ChildAdded() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Add Child Page");
		extentTest.set(test);
		// Verify if Add Child page title is correct
		String actit = webDriver.getTitle();
		if (actit.equals("Add a Child | Onboarding | Mobicip")) {
			test.pass("Add a Child page title is shown correct");
		} else {
			Assert.fail("Add a Child page title is not shown correct");
		}

		Thread.sleep(3000);
		String f = webDriver.findElement(By.xpath("//button[@class='primary_button']")).getText();
		if (f.equals("Next")) {
			test.pass("Next button Present");
		} else {
			Assert.fail("Next button not Present");
		}

		webDriver.findElement(By.xpath("//button[@class='primary_button']")).click();
		Thread.sleep(9000);

		// page title
		String tit = webDriver.getTitle();
		tit = webDriver.getTitle();
		if (tit.equals("Dashboard | Mobicip")) {
			test.pass("Dashboard page redirects pass");
		} else {
			Assert.fail("Dashboard page redirects fail");
		}
	}

	@Test(priority = 6)
	public void f6_KopiData() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Kopi guide data");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20));
		String f1 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		System.out.println();
		if (f1.equals("Hi! I'm Eva. I use Mobicip to monitor my child Kopi. Let me show you some cool features.")) {
			test.pass("Kopi info 1 Correct");
		} else {
			Assert.fail("Kopi info 1 not Correct");
		}

		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);

		String f2 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		System.out.println();
		if (f2.equals("Meet my child Kopi. Check out how I ensure and help build safe digital habits.")) {
			test.pass("Kopi info 2 Correct");
		} else {
			Assert.fail("Kopi info 2 not Correct");
		}

		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);

		String f3 = webDriver.findElement(By.xpath("//span[@class='feature_tour_skip']")).getText();
		if (f3.equals("Skip")) {
			test.pass("Skip text Correct");
		} else {
			Assert.fail("Skip text not Correct");
		}

		webDriver.findElement(By.xpath("//span[@class='feature_tour_skip']")).click();
		Thread.sleep(3000);

		WebElement e = webDriver.findElement(By.xpath("//div[@class='user_profile_wrapper']"));
		Actions act = new Actions(webDriver);
		act.moveToElement(e).perform();

		webDriver.findElement(By.xpath("//ul[@class='profile_dropdown_ul']/li[8]/div")).click();
		Thread.sleep(3000);

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
	 * @AfterMethod
	 * 
	 * @AfterClass public void tearDown() { extent.flush(); }
	 */

}
