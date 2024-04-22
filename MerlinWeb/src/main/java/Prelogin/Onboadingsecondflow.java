package Prelogin;

//Change 106 Email account each and every time before running the code

import java.time.Duration;
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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Onboadingsecondflow extends BrowserSetupClass {


	ExtentReports extent;
	ExtentTest test1;

	@BeforeClass
	public void beforeTest() 
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\OnboardingFlow2\\OnboardingFlow2Report.html");
		extent.attachReporter(spark);
	}
	
	@Test
	public void a1_homePage() throws InterruptedException
	{
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		String actit = webDriver.getTitle();
		test1 = extent.createTest("Signup page");
		if (actit.equals("Best Parental Control App for Busy Parents | Mobicip"))
		{
			test1.pass("Title is shown correct");
		}
		else
		{
			test1.fail("Title is not correct");
		}
		boolean a = webDriver.findElement(By.linkText("Login")).isEnabled();
		if (a)
		{
			test1.pass("Login button is enabled");
		}
		else
		{
			test1.fail("Login button is disabled");
		}
		webDriver.findElement(By.linkText("Login")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='illustrations_wrapper']")));
		String actit1 = webDriver.getTitle();
		String extit1 = "Login | Mobicip";
		test1 = extent.createTest("Login page");
		if (actit1.equals(extit1))
		{
			test1.pass("Login page title is shown correct");
		}
		else
		{
			test1.fail("Login page title is not correct");
		}
		boolean b = webDriver.findElement(By.linkText("Sign Up")).isDisplayed();
		if (b)
		{
			test1.pass("Signup is displayed");
		}
		else
		{
			test1.fail("Signup is not displayed");
		}	
	}

	@Test
	public void b2_signUp() throws InterruptedException
	{
		//Sign up page - page title
		webDriver.findElement(By.linkText("Sign Up")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='illustrations_wrapper']")));
		String actit = webDriver.getTitle();
		String extit = "Create Account | Mobicip";
		test1 = extent.createTest("Signup page");
		if (actit.equals(extit))
		{
			test1.pass("Signup page title is shown correct");
		}
		else
		{
			test1.fail("Signup page title is not correct");
		}
		//Sign up - Create account with Valid accounts
		webDriver.navigate().refresh();
		webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("vikram");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("vikram+auto3@mobicip.com");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("12345");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Congratulations!']")));
		boolean a = webDriver.findElement(By.xpath("//h5[text()='Congratulations!']")).isDisplayed();
		if(a)
		{
			test1.pass("Account Created successfully with valid inputs");
		}
		else
		{
			test1.fail("Account creation unsuccessful with valid inputs");
		}
	}
	
	@Test
	public void c3_addCoparent() throws InterruptedException
	{
		test1 = extent.createTest("Add CoParent Page");
		// Verify if Add coparent page title is correct
		String actit = webDriver.getTitle();
		if (actit.equals("Add Co-Parent | Onboarding | Mobicip"))
		{
			test1.pass("Add Coparent page title is shown correct");
		}
		else
		{
			test1.fail("Add Coparent page title is not shown correct");
		}
		
		boolean a=true;
		try {webDriver.findElement(By.xpath("//div[@class='secondary_button']")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("'Do it Later' link redirects failed");}
		if(a==true){test1.pass("'Do it Later' link redirects works fine");}
		TimeUnit.SECONDS.sleep(5);
	}
	
	@Test
	public void d4_addChild() throws InterruptedException
	{
	    JavascriptExecutor js = (JavascriptExecutor) webDriver;

		test1 = extent.createTest("Add Child Page");
		// Verify if Add Child page title is correct
		String actit = webDriver.getTitle();
		if (actit.equals("Add a Child | Onboarding | Mobicip"))
		{
			test1.pass("Add Child page title is shown correct");
		}
		else
		{
			test1.fail("Add Child page title is not shown correct");
		}
		// Verify adding child with valid inputs
		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
        Boolean a;
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Child One");
		Thread.sleep(3000);
		Select date = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("11");
		Select month = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
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
		try
		{
		webDriver.findElement(By.xpath("//h5"));
		a=true;
		}
		catch(NoSuchElementException e)
		{
			a=false;
			test1.fail("Add Child - Not successfull with valid inputs");
		}
		if (a==true)
		{
			test1.pass("Add Child - Successfully added with valid inputs");
		}
	}
	
	@Test
	public void e5_ChildAdded() throws InterruptedException
		{
	
		test1 = extent.createTest("Add a Child Page");
		// Verify if Add Child page title is correct
		String actit = webDriver.getTitle();
		if (actit.equals("Add a Child | Onboarding | Mobicip"))
		{
			test1.pass("Add a Child page title is shown correct");
		}
		else
		{
			test1.fail("Add a Child page title is not shown correct");
		}
	
		Thread.sleep(3000);
		String f = webDriver.findElement(By.xpath("//button[@class='primary_button']")).getText();
		if(f.equals("Next"))
		{test1.pass("Next button Present");}
		else{test1.fail("Next button not Present");}
		
		webDriver.findElement(By.xpath("//button[@class='primary_button']")).click();
		Thread.sleep(9000); 
		
		// page title
		String tit=webDriver.getTitle();
		tit = webDriver.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test1.pass("Dashboard page redirects pass");}
		else{test1.fail("Dashboard page redirects fail");}	
	}
	
	@Test
	public void f6_KopiData() throws InterruptedException
	{
		test1 = extent.createTest("Kopi guide data");
		
		String f1 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		if(f1.equals("Hi! I'm Eva. I use Mobicip to monitor my child Kopi. Let me show you some cool features."))
		{test1.pass("Kopi info 1 Correct");}
		else{test1.fail("Kopi info 1 not Correct");}
		
		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);
		
		String f2 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		if(f2.equals("Meet my child Kopi. Check out how I ensure and help build safe digital habits."))
		{test1.pass("Kopi info 2 Correct");}
		else{test1.fail("Kopi info 2 not Correct");}
		
		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);
		
		String f3 = webDriver.findElement(By.xpath("//span[@class='feature_tour_skip']")).getText();
		if(f3.equals("Skip"))
		{test1.pass("Skip text Correct");}
		else{test1.fail("Skip text not Correct");}
			
		webDriver.findElement(By.xpath("//span[@class='feature_tour_skip']")).click();
		Thread.sleep(3000);
		
		WebElement e = webDriver.findElement(By.xpath("//div[@class='user_profile_wrapper']"));
		Actions act = new Actions(webDriver);
		act.moveToElement(e).perform();
				
		webDriver.findElement(By.xpath("//ul[@class='profile_dropdown_ul']/li[8]/div")).click();
		Thread.sleep(3000);
		
		 webDriver.findElement(By.xpath("//a[@class='company_logo']")).click();
		 new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
	}

	@AfterClass
	public void tearDown()
	{
		extent.flush();
	}

}
