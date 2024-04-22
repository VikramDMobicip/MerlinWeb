package Prelogin;

import java.time.Duration;
import java.util.ArrayList;
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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Change line 276 , 411 Email account each and every time before running the code
public class OnboardingPages extends BrowserSetupClass{

	ExtentReports extent;
	ExtentTest test1;
	
	@BeforeClass
	public void beforeTest() 
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\OnboardingFlow1\\OnboardingPages.html");
		extent.attachReporter(spark);
	}

	
	@Test
	public void a1_homePage() throws InterruptedException
	{
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		test1 = extent.createTest("Home page");
		
		String actit = webDriver.getTitle();
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
		//Sign up page - Validate the page title
		webDriver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(1000);
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
		//Sign up page - Verify - Name, Email, Password & Submit button are present

		boolean a = webDriver.findElement(By.xpath("//input[@placeholder='Name']")).isDisplayed();
		boolean b = webDriver.findElement(By.xpath("//input[@placeholder='Email']")).isDisplayed();
		boolean c = webDriver.findElement(By.xpath("//input[@placeholder='Password']")).isDisplayed();
		boolean d1 = webDriver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		if (a&&b&&c&&d1)
		{
			test1.pass("All Signup page elements are present");
		}
		else
		{
			test1.fail("Signup page elements are not shown properly");
		}
		//Sign up page - Validate Terms & Conditions link

		webDriver.findElement(By.linkText("Terms & Conditions")).click();
		List<String> browserTabs = new ArrayList<String> (webDriver.getWindowHandles());
		webDriver.switchTo().window(browserTabs.get(1));
		String actit1 = webDriver.getTitle();
		String extit1 = "Terms & Conditions | Mobicip";
		if (actit1.equals(extit1))
		{
			test1.pass("Terms & Conditions works as expected");
		}
		else
		{
			test1.fail("Terms & Conditions is not working");
		}
		webDriver.close();
		webDriver.switchTo().window(browserTabs.get(0));

		//Sign up page - Validate Privacy Policy

		webDriver.findElement(By.linkText("Privacy Policy")).click();
		browserTabs = new ArrayList<String> (webDriver.getWindowHandles());
		Thread.sleep(1000);
		webDriver.switchTo().window(browserTabs.get(1));
		String actit2 = webDriver.getTitle();
		String extit2 = "Privacy Policy | Mobicip";
		if (actit2.equals(extit2))
		{
			test1.pass("Privacy Policy works as expected");
		}
		else
		{
			test1.fail("Privacy Policy is not working");
		}
		webDriver.close();
		webDriver.switchTo().window(browserTabs.get(0));
	}

	@Test
	public void c3_signupValidation() throws InterruptedException
	{
		//Sign Up page - Validate with Empty inputs
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Required Field')]")));
		boolean a = webDriver.findElement(By.xpath("//span[contains(.,'Required Field')]")).isDisplayed();
		if (a)
		{
			test1.pass("Empty input alert is shown");
		}
		else
		{
			test1.fail("Empty input alert is not shown");
		}
		//Sign Up page - Validate with blank space 
		webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("  ");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("  ");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("  ");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Required Field')]")));
		boolean b = webDriver.findElement(By.xpath("//span[contains(.,'Required Field')]")).isDisplayed();
		if (b)
		{
			test1.pass("Blank space input alert is shown");
		}
		else
		{
			test1.fail("Blank space input alert is not shown");
		}
		
		//Reload the page
		webDriver.navigate().refresh();
		Thread.sleep(1000);
		
		//Sign Up page - Validate with Existing email
		webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Uma");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("uma@mobicip.com");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("12345");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'user already exist')]")));

		Boolean c=true;
		try
		{
			webDriver.findElement(By.xpath("//span[contains(.,'user already exist')]"));
		}
		catch(NoSuchElementException e) 
		{
			c=false;
			test1.fail("User already exists alert is not shown");
		}
		if(c==true)
		{
			test1.pass("User already exists alert is shown");
		}
		
		//Reload the page		
		webDriver.navigate().refresh();
		Thread.sleep(1000);

		//Sign Up page - Validate with Incomplete email
		webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Uma");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("uma@");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("12345");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Invalid Email: Enter a valid email address')]")));

		Boolean d1 =true;
		try
		{
			webDriver.findElement(By.xpath("//span[contains(.,'Invalid Email: Enter a valid email address')]"));
		}
		catch(NoSuchElementException e) 
		{
			d1=false;
			test1.fail("Invalid email alert is not shown");
		}
		if(d1==true)
		{
			test1.pass("Invalid email alert is shown");
		}
		//Reload the page			
			webDriver.navigate().refresh();
			Thread.sleep(1000);

		//Sign Up page - Validate with short pwd
				webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Uma");
				webDriver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("uma+p20dec22@mobicip.com");
				webDriver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("123");
				webDriver.findElement(By.xpath("//button[@type='submit']")).click();
				new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Must be at least 5 characters long')]")));

				Boolean f =true;
				try
				{
					webDriver.findElement(By.xpath("//span[contains(.,'Must be at least 5 characters long')]"));
				}
				catch(NoSuchElementException e) 
				{
					f=false;
					test1.fail("Password - Must be 5 character long alert is not shown");
				}
				if(f==true)
				{
					test1.pass("Password - Must be 5 character long alert is shown");
				}
	}
	
	@Test
	public void d4_signUpValid() throws InterruptedException
	{
		//Sign up - Create account with Valid accounts
		webDriver.navigate().refresh();
		webDriver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Vikram");
		webDriver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("vikram+am3@mobicip.com");
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
	public void e5_addCoparent() throws InterruptedException
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
		// Verify if all elements in Add Coparent page are present
		boolean a = webDriver.findElement(By.xpath("//h5")).isDisplayed();
		boolean b = webDriver.findElement(By.xpath("//p[@id='headerTitle']")).isDisplayed();
		boolean c = webDriver.findElement(By.xpath("//h1[text() = 'Add a Co-Parent']")).isDisplayed();
		boolean d1 = webDriver.findElement(By.xpath("//label[text() = 'Name']")).isDisplayed();
		boolean e = webDriver.findElement(By.id("add_parent_name")).isDisplayed();
		boolean f = webDriver.findElement(By.xpath("//label[text() = 'Email']")).isDisplayed();
		boolean g = webDriver.findElement(By.id("add_parent_email")).isDisplayed();
		boolean h = webDriver.findElement(By.xpath("//div[@class='secondary_button']")).isDisplayed();
		boolean i = webDriver.findElement(By.xpath("//button[text()='Send Invite']")).isDisplayed();
		
		if (a&&b&&c&&d1&&e&&f&&g&&h&&i)
		{
			test1.pass("All Add Coparent page elements are present");
		}
		else
		{
			test1.fail("Add Coparent page elements are not shown properly");
		}
		// Validate with empty input for all fields
		
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Required Field')]")));
		boolean x = webDriver.findElement(By.xpath("//span[contains(.,'Required Field')]")).isDisplayed();
		if (x)
		{
			test1.pass("Coparent - Empty input alert is shown");
		}
		else
		{
			test1.fail("Coparent - Empty input alert is not shown");
		}
		//Reload the page
				webDriver.navigate().refresh();
				Thread.sleep(1000);
		//Add Coparent page - Validate with blank space 
		webDriver.findElement(By.id("add_parent_name")).sendKeys("  ");
		webDriver.findElement(By.id("add_parent_email")).sendKeys("  ");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Required Field')]")));
		boolean y = webDriver.findElement(By.xpath("//span[contains(.,'Required Field')]")).isDisplayed();
		if (y)
		{
			test1.pass("Coparent - Blank space input alert is shown");
		}
		else
		{
			test1.fail("Coparent - Blank space input alert is not shown");
		}
		
		//Reload the page
		webDriver.navigate().refresh();
		Thread.sleep(1000);
		
		//Add Coparent page - Validate with Existing email
		webDriver.findElement(By.id("add_parent_name")).sendKeys("Uma");
		webDriver.findElement(By.id("add_parent_email")).sendKeys("uma@mobicip.com");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Mobicip account already exists')]")));

		Boolean z=true;
		try
		{
			webDriver.findElement(By.xpath("//span[contains(.,'Mobicip account already exists')]"));
		}
		catch(NoSuchElementException ex) 
		{
			z=false;
			test1.fail("User already exists alert is not shown");
		}
		if(z==true)
		{
			test1.pass("User already exists alert is shown");
		}
		
		//Reload the page		
		webDriver.navigate().refresh();
		Thread.sleep(1000);

		//Add Coparent page - Validate with Incomplete email
		webDriver.findElement(By.id("add_parent_name")).sendKeys("Uma");
		webDriver.findElement(By.id("add_parent_email")).sendKeys("uma@");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Invalid Email: Enter a valid email address')]")));

		Boolean y1 =true;
		try
		{
			webDriver.findElement(By.xpath("//span[contains(.,'Invalid Email: Enter a valid email address')]"));
		}
		catch(NoSuchElementException exc) 
		{
			y1=false;
			test1.fail("Invalid email alert is not shown");
		}
		if(y1==true)
		{
			test1.pass("Invalid email alert is shown");
		}
		//Reload the page			
			webDriver.navigate().refresh();
			Thread.sleep(1000);	
			
			// Validate - Coparent page with Valid email address
			webDriver.findElement(By.id("add_parent_name")).sendKeys("vikram");
			webDriver.findElement(By.id("add_parent_email")).sendKeys("vikram+amp3@mobicip.com");
			webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
			new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5")));
			
			Boolean bo = webDriver.findElement(By.xpath("//h5")).isDisplayed();
			if(bo==true)
			{	
			test1.pass("Coparent invite done successfully");
			}
		
	}
	
	@Test
	public void f6_addChild() throws InterruptedException
	{
	    TimeUnit.SECONDS.sleep(5);
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
	
		
		Boolean a=true;
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(3);
		
		//Verify adding child with empty input
		webDriver.findElement(By.xpath("//button[.='Add']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Required Field']")));
		try
		{
			webDriver.findElement(By.xpath("//span[.='Required Field']"));
			a=true;
		}
		catch(NoSuchElementException e)
		{
			a=false;
			test1.fail("Add Child - Empty input alert message not shown");
		}
		if (a==true)
		{
			test1.pass("Add Child - Empty input alert message is shown");
		}
		Thread.sleep(1000);
		webDriver.navigate().refresh();
		
		//Verify adding child with blank space for Name
		JavascriptExecutor j11 = (JavascriptExecutor)webDriver;
		j11.executeScript("window.scrollBy(0,550)");
		TimeUnit.SECONDS.sleep(5);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("  ");
		webDriver.findElement(By.xpath("//button[.='Add']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Required Field']")));
		try
		{
			webDriver.findElement(By.xpath("//span[.='Required Field']"));
			a=true;
		}
		catch(NoSuchElementException e)
		{
			a=false;
			test1.fail("Add Child - Blank input alert message not shown");
		}
		if (a==true)
		{
			test1.pass("Add Child - Blank input alert message is shown");
		}
		Thread.sleep(1000);
		webDriver.navigate().refresh();
		
		//Verify adding child with special character for Name
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("child_");
		JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
		j1.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(3);
		webDriver.findElement(By.xpath("//button[.='Add']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Only alphanumeric accepted']")));
		try
		{
			webDriver.findElement(By.xpath("//span[.='Only alphanumeric accepted']"));
			a=true;
		}
		catch(NoSuchElementException e)
		{
			a=false;
			test1.fail("Add Child - Only alphanumeric accepted message not shown");
		}
		if (a==true)
		{
			test1.pass("Add Child - Only alphanumeric accepted message is shown");
		}
		Thread.sleep(1000);
		webDriver.navigate().refresh();		
		
	}
	
	// Verify adding child with valid inputs
@Test
	public void g7_validAddChild() throws InterruptedException
	{
		test1 = extent.createTest("Add Valid Child");
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,600)");
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
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5")));
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
	public void h8_ChildAdded() throws InterruptedException
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
	String f1 = webDriver.findElement(By.xpath("//h5[@class='onboarding_header']")).getText();
	if(f1.equals("Successfully added Child One"))
	{test1.pass("Child added successfully");}
	else{test1.fail("Unable to add child");}
	Thread.sleep(3000);
	
	boolean a = webDriver.findElement(By.xpath("//span[text()='Child One']")).isDisplayed();
	boolean b = webDriver.findElement(By.xpath("//span[text()='16' and text()=' yrs']")).isDisplayed();
	boolean c = webDriver.findElement(By.xpath("//p[text()='Monitor and Manage']")).isDisplayed();
	if (a&&b&&c)
	{
		test1.pass("Added child details are correct");
	}
	else
	{
		test1.fail("Added child details are not correct");
	}
	
	String f2 = webDriver.findElement(By.xpath("//a[@class='link_button add']/span")).getText();
	if(f2.equals("Add Another Child"))
	{test1.pass("Add another child link Present");}
	else{test1.fail("Add another child link not Present");}
	
	webDriver.findElement(By.xpath("//a[@class='link_button add']/span")).click();
	Thread.sleep(2000);
	
	}
	
	// Verify adding child with Monitoronly filter
@Test
	public void i9_AddMonitorOnlyChild() throws InterruptedException
	{
		test1 = extent.createTest("Add Monitor only Child");
	    JavascriptExecutor js = (JavascriptExecutor) webDriver;
	    Boolean a;
	    webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Child Two");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		Select date = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("11");
		Select month = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("9");
		Select year = new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2005");
		date.selectByValue("14");
		month.selectByValue("11");
		year.selectByValue("2005");
		webDriver.findElement(By.xpath("//input[@id='filter_monitor']/following::label[1]")).click();
		webDriver.findElement(By.xpath("//button[.='Add']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5")));
		try
		{
			webDriver.findElement(By.xpath("//h5"));
		a=true;
		}
		catch(NoSuchElementException e)
		{
			a=false;
			test1.fail("Add Child - Not successfull with monitor only filter");
		}
		if (a==true)
		{
			test1.pass("Add Child - Successfully added with monitor only filter");
		}
		Thread.sleep(4000);		
		boolean a1 = webDriver.findElement(By.xpath("//span[text()='Child Two']")).isDisplayed();
		boolean b1 = webDriver.findElement(By.xpath("//span[text()='17' and text()=' yrs']")).isDisplayed();
		boolean c1 = webDriver.findElement(By.xpath("//p[text()='Monitor only']")).isDisplayed();
		if (a1&&b1&&c1)
		{
			test1.pass("Added child details are correct");
		}
		else
		{
			test1.fail("Added child details are not correct");
		}
		
		Thread.sleep(2000);
		
		String f = webDriver.findElement(By.xpath("//button[@class='primary_button']")).getText();
		if(f.equals("Next"))
		{test1.pass("Next button Present");}
		else{test1.fail("Next button not Present");}
		
		webDriver.findElement(By.xpath("//button[@class='primary_button']")).click();
		Thread.sleep(10000);
		
		// page title
		String tit=webDriver.getTitle();
		tit = webDriver.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test1.pass("Dashboard page redirects pass");}
		else{test1.fail("Dashboard page redirects fail");}
	}

	// Verify adding child with Monitoronly filter
@Test
	public void j1_KopiData() throws InterruptedException
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
		
		String f3 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		if(f3.equals("Shows any explicit or rude content on Kopi's social media accounts."))
		{test1.pass("Kopi info 3 Correct");}
		else{test1.fail("Kopi info 3 not Correct");}
		
		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);
		
		String f4 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		if(f4.equals("I block distracting apps and websites here."))
		{test1.pass("Kopi info 4 Correct");}
		else{test1.fail("Kopi info 4 not Correct");}
		
		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);
		
		String f5 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		if(f5.equals("I find Kopi's live location here."))
		{test1.pass("Kopi info 5 Correct");}
		else{test1.fail("Kopi info 5 not Correct");}
		
		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
		Thread.sleep(3000);
		
		String f6 = webDriver.findElement(By.xpath("//p[@class='ft_content']")).getText();
		if(f6.equals("Set daily screen time limits & create schedules here."))
		{test1.pass("Kopi info 6 Correct");}
		else{test1.fail("Kopi info 6 not Correct");}
		
		webDriver.findElement(By.xpath("//div[@class='ft_button_container']")).click();
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
