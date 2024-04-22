package Prelogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SignupLoginPages extends BrowserSetupClass{

	//Report setup
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\SignUpLoginPageTest\\SignupLoginPagesReport.html");
		extentreport.attachReporter(spark);
	}
	
	
	// Signup page
	@Test
	public void a1_signupPage() throws InterruptedException
	  {
		ExtentTest test=extentreport.createTest("Signup page","To check the Prelogin Signup web page title,logo");
		  	
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Login' and @class='header_link login']")));
		webDriver.findElement(By.xpath("//a[text()='Login' and @class='header_link login']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign Up']")));
		webDriver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Sign Up']")));
							
		// page title
		String tit=webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if(tit.equals("Create Account | Mobicip"))
		{test.pass("Signup Page title is correct");}
		else{test.fail("Signup Page title isn't correct");}
			
		//Header Elements
		boolean a=true;
		try {webDriver.findElement(By.xpath("//header[@class='content_header']/a"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Pre login Signup page - Logo is incorrect");}
		if(a==true){test.pass("Pre login Signup page - Logo is correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//header[@class='content_header']/a")).click();}
		catch(NoSuchElementException e){a=false;
		test.fail("Link redirects failed");}
		if(a==true){test.pass("Link works fine");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
	  }

	@Test
	public void a2_sectionLeft() throws InterruptedException
	  {
		ExtentTest test1=extentreport.createTest("Section Left","To check the Prelogin Signup web page title,Left section");
		
		TimeUnit.SECONDS.sleep(1);  	
		
		boolean a=true;
		try {webDriver.findElement(By.xpath("//div[@class='illustrations_wrapper']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("Features slide section is not Present");}
		if(a==true){test1.pass("Features slide section is Present");}
		
		// Feature 1 - Track location
		webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[1]")).click();
		TimeUnit.SECONDS.sleep(3); 
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][1]//img"));
		}
		catch(NoSuchElementException e){a=false;
		test1.fail("1.Features Image is not present");}
		if(a==true){test1.pass("1.Features Image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Track location.'and text()='Get alerts when your child needs help.'and text()='Set safe boundaries.']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("Description is not Correct");}
		if(a==true){test1.pass("Description is Correct");}
		
		String f1 = webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][1]//p[2]")).getText();
		if(f1.equals("Know your child is safe everywhere!"))
		{test1.pass("Quote is Correct");}
		else{test1.fail("Quote is not Correct");}
		
		// Feature 2 - Device usage
		webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[2]")).click();
		TimeUnit.SECONDS.sleep(3); 
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][2]//img"));
		}
		catch(NoSuchElementException e){a=false;
		test1.fail("2.Features Image is not present");}
		if(a==true){test1.pass("2.Features Image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Manage screen time limits and schedules. Block'and text()='inappropriate web content & apps. Collaborate with your'and text()='child to set daily usage limits.']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("Description is not Correct");}
		if(a==true){test1.pass("Description is Correct");}
		
		String f2 = webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][2]//p[2]")).getText();
		if(f2.equals("Manage your child�s device usage!"))
		{test1.pass("Quote is Correct");}
		else{test1.fail("Quote is not Correct");}
		
		
		// Feature 3 - social media
		webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[3]")).click();
		TimeUnit.SECONDS.sleep(3); 
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][3]//img"));
		}
		catch(NoSuchElementException e){a=false;
		test1.fail("3.Features Image is not present");}
		if(a==true){test1.pass("3.Features Image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Detect potential risks on social media. Monitor for'and text()='cyberbullying,online predators & more. Get peace of mind'and text()='when your kids are online.']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("Description is not Correct");}
		if(a==true){test1.pass("Description is Correct");}
		
		String f3 = webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][3]//p[2]")).getText();
		if(f3.equals("Keep yourself up-to-date!"))
		{test1.pass("Quote is Correct");}
		else{test1.fail("Quote is not Correct");}
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[1]"));
			webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[2]"));
			webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[3]"));
			}
		catch(NoSuchElementException e){a=false;
		test1.fail("Slider buttons are not present");}
		if(a==true){test1.pass("Slider buttons are present");}
		
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[1]/img"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("1.iOS platform image is not present");}
		if(a==true){test1.pass("1.iOS platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[1]")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("Links redirects failed");}
		if(a==true){test1.pass("Link redirects to ios-iphone page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[2]/img"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("2.Android platform image is not present ");}
		if(a==true){test1.pass("2.Android platform image is present ");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[2]")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("Links redirects failed");}
		if(a==true){test1.pass("Link redirects to Android page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[3]/img"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("3.Mac platform image is not present");}
		if(a==true){test1.pass("3.Mac platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[3]")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("Links redirects failed");}
		if(a==true){test1.pass("Link redirects to Mac page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[4]/img"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("4.Windows platform image is not present");}
		if(a==true){test1.pass("4.Windows platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[4]")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("Links redirects failed");}
		if(a==true){test1.pass("Link redirects to Windows page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[5]/img"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("5.Chromebook platform image is not present");}
		if(a==true){test1.pass("5.Chromebook platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[5]")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("Links redirects failed");}
		if(a==true){test1.pass("Link redirects to Chromebook page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
	  }

	@Test
	public void a3_sectionRight() throws InterruptedException
	  {
		ExtentTest test2=extentreport.createTest("Section Right","To check the Prelogin Signup web page title,Right section");
		
		TimeUnit.SECONDS.sleep(1);  	
		
		boolean a=true;
		try {webDriver.findElement(By.xpath("//div[@class='session_form_container']//h1"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Signup title is not present");}
		if(a==true){test2.pass("Signup title is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']/div[1]//input"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Name field is not present");}
		if(a==true){test2.pass("Name field is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']/div[2]//input"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Email field is not present");}
		if(a==true){test2.pass("Email field is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']/div[3]//input"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Password field is not present");}
		if(a==true){test2.pass("Password field is present");}
		
		String p = webDriver.findElement(By.xpath("//p[@class='agree_terms']")).getText();
		if(p.equals("By continuing, you agree to Mobicip Terms & Conditions and Privacy Policy"))
		{test2.pass("Info text is correct");}
		else{test2.fail("Info text is not correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[@class='agree_terms']/a[1]"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Terms link not present");}
		if(a==true){test2.pass("Terms link present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[@class='agree_terms']/a[2]"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Privacy link not present");}
		if(a==true){test2.pass("Privacy link present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='session_form_container']//button"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Signup button is not present");}
		if(a==true){test2.pass("Signup button is present");}
		
		String p1 = webDriver.findElement(By.xpath("//div[@class='bottom_navigation_wrapper']//span")).getText();
		if(p1.equals("Already have an account?"))
		{test2.pass("Already have an account? - Text is correct");}
		else{test2.fail("Already have an account? - Text is not correct");}
		
		String p2 = webDriver.findElement(By.xpath("//div[@class='bottom_navigation_wrapper']//a")).getText();
		if(p2.equals("Log in"))
		{test2.pass("Login text is correct");}
		else{test2.fail("Login text is not correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='bottom_navigation_wrapper']//a")).click();}
		catch(NoSuchElementException e){a=false;
		test2.fail("Link redirects failed");}
		if(a==true){test2.pass("Link works fine");}
		TimeUnit.SECONDS.sleep(2);
	  }	
	
	// Login page
	@Test
	public void b1_loginPage() throws InterruptedException
	  {
		ExtentTest test3=extentreport.createTest("Login page","To check the Prelogin Login web page title,logo");
		  						
		// page title
		String tit=webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if(tit.equals("Login | Mobicip"))
		{test3.pass("Login Page title is correct");}
		else{test3.fail("Login Page title isn't correct");}
			
		//Header Elements
		boolean a=true;
		try {webDriver.findElement(By.xpath("//header[@class='content_header']/a"));}
		catch(NoSuchElementException e){a=false;
		test3.fail("Pre login Login page - Logo is incorrect");}
		if(a==true){test3.pass("Pre-login Login page - Logo is correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//header[@class='content_header']/a")).click();}
		catch(NoSuchElementException e){a=false;
		test3.fail("Link redirects failed");}
		if(a==true){test3.pass("Link works fine");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
	  }

	@Test
	public void b2_sectionLeft() throws InterruptedException
	  {
		ExtentTest test4=extentreport.createTest("Section Left","To check the Prelogin Login web page title,Left section");
		
		TimeUnit.SECONDS.sleep(1);  	
		
		boolean a=true;
		try {webDriver.findElement(By.xpath("//div[@class='illustrations_wrapper']"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("Features slide section is not Present");}
		if(a==true){test4.pass("Features slide section is Present");}
		
		// Feature 1 - Track location
		webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[1]")).click();
		TimeUnit.SECONDS.sleep(3); 
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][1]//img"));
		}
		catch(NoSuchElementException e){a=false;
		test4.fail("1.Features Image is not present");}
		if(a==true){test4.pass("1.Features Image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Track location.'and text()='Get alerts when your child needs help.'and text()='Set safe boundaries.']"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("Description is not Correct");}
		if(a==true){test4.pass("Description is Correct");}
		
		String f1 = webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][1]//p[2]")).getText();
		if(f1.equals("Know your child is safe everywhere!"))
		{test4.pass("Quote is Correct");}
		else{test4.fail("Quote is not Correct");}
		
		// Feature 2 - Device usage
		webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[2]")).click();
		TimeUnit.SECONDS.sleep(3); 
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][2]//img"));
		}
		catch(NoSuchElementException e){a=false;
		test4.fail("2.Features Image is not present");}
		if(a==true){test4.pass("2.Features Image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Manage screen time limits and schedules. Block'and text()='inappropriate web content & apps. Collaborate with your'and text()='child to set daily usage limits.']"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("Description is not Correct");}
		if(a==true){test4.pass("Description is Correct");}
		
		String f2 = webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][2]//p[2]")).getText();
		if(f2.equals("Manage your child�s device usage!"))
		{test4.pass("Quote is Correct");}
		else{test4.fail("Quote is not Correct");}
		
		
		// Feature 3 - social media
		webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[3]")).click();
		TimeUnit.SECONDS.sleep(3); 
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][3]//img"));
		}
		catch(NoSuchElementException e){a=false;
		test4.fail("3.Features Image is not present");}
		if(a==true){test4.pass("3.Features Image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Detect potential risks on social media. Monitor for'and text()='cyberbullying,online predators & more. Get peace of mind'and text()='when your kids are online.']"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("Description is not Correct");}
		if(a==true){test4.pass("Description is Correct");}
		
		String f3 = webDriver.findElement(By.xpath("//div[@class='illustration_wrapper'][3]//p[2]")).getText();
		if(f3.equals("Keep yourself up-to-date!"))
		{test4.pass("Quote is Correct");}
		else{test4.fail("Quote is not Correct");}
		
		a=true;
		try {
			webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[1]"));
			webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[2]"));
			webDriver.findElement(By.xpath("//div[@class='slider_navigation_wrapper']/div[3]"));
			}
		catch(NoSuchElementException e){a=false;
		test4.fail("Slider buttons are not present");}
		if(a==true){test4.pass("Slider buttons are present");}
		
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(5);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[1]/img"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("1.iOS platform image is not present");}
		if(a==true){test4.pass("1.iOS platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[1]")).click();}
		catch(NoSuchElementException e){a=false;
		test4.fail("Links redirects failed");}
		if(a==true){test4.pass("Link redirects to ios-iphone page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[2]/img"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("2.Android platform image is not present ");}
		if(a==true){test4.pass("2.Android platform image is present ");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[2]")).click();}
		catch(NoSuchElementException e){a=false;
		test4.fail("Links redirects failed");}
		if(a==true){test4.pass("Link redirects to Android page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[3]/img"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("3.Mac platform image is not present");}
		if(a==true){test4.pass("3.Mac platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[3]")).click();}
		catch(NoSuchElementException e){a=false;
		test4.fail("Links redirects failed");}
		if(a==true){test4.pass("Link redirects to Mac page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[4]/img"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("4.Windows platform image is not present");}
		if(a==true){test4.pass("4.Windows platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[4]")).click();}
		catch(NoSuchElementException e){a=false;
		test4.fail("Links redirects failed");}
		if(a==true){test4.pass("Link redirects to Windows page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[5]/img"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("5.Chromebook platform image is not present");}
		if(a==true){test4.pass("5.Chromebook platform image is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='downloads_container']//a[5]")).click();}
		catch(NoSuchElementException e){a=false;
		test4.fail("Links redirects failed");}
		if(a==true){test4.pass("Link redirects to Chromebook page");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
	  }

	@Test
	public void b3_sectionRight() throws InterruptedException
	  {
		ExtentTest test5=extentreport.createTest("Section Right","To check the Prelogin Login web page title,Right section");
		
		TimeUnit.SECONDS.sleep(1);  	
		
		boolean a=true;
		try {webDriver.findElement(By.xpath("//div[@class='session_form_container']//h1"));}
		catch(NoSuchElementException e){a=false;
		test5.fail("Login title is not present");}
		if(a==true){test5.pass("Login title is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']/div[1]//input"));}
		catch(NoSuchElementException e){a=false;
		test5.fail("Email field is not present");}
		if(a==true){test5.pass("Email field is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']/div[2]//input"));}
		catch(NoSuchElementException e){a=false;
		test5.fail("Password field is not present");}
		if(a==true){test5.pass("Password field is present");}
		
		String p = webDriver.findElement(By.xpath("//div[@class='forgot_password']/a")).getText();
		if(p.equals("Forgot Password?"))
		{test5.pass("Forget password is correct");}
		else{test5.fail("Forget password is not correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='session_form_container']//button"));}
		catch(NoSuchElementException e){a=false;
		test5.fail("Continue button is not present");}
		if(a==true){test5.pass("Continue button is present");}
		
		String p1 = webDriver.findElement(By.xpath("//div[@class='bottom_navigation_wrapper']//span")).getText();
		if(p1.equals("Don't have an account?"))
		{test5.pass("Don't have an account? - Text is correct");}
		else{test5.fail("Don't have an account? - Text is not correct");}
		
		String p2 = webDriver.findElement(By.xpath("//div[@class='bottom_navigation_wrapper']//a")).getText();
		if(p2.equals("Sign Up"))
		{test5.pass("Signup text is correct");}
		else{test5.fail("Signup text is not correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='bottom_navigation_wrapper']//a")).click();}
		catch(NoSuchElementException e){a=false;
		test5.fail("Link redirects failed");}
		if(a==true){test5.pass("Link works fine");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
	  }	

	@Test
	public void c1_validation() throws InterruptedException
	  {
		ExtentTest test6=extentreport.createTest("Validation","To check the Prelogin Login web page title,Validation");
		boolean a=true;
		
		// Required Field
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("");
		webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("");
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//button[text()='Continue']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']/following::span[text()='Required Field']")));
		
		try{webDriver.findElement(By.xpath("//input[@name='login_email']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test6.fail("Email Required Field - Failed");}
		if(a==true){test6.pass("Email Required Field - Displayed");}
		
		try{webDriver.findElement(By.xpath("//input[@name='login_password']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test6.fail("Password Required Field - Failed");}
		if(a==true){test6.pass("Password Required Field - Displayed");}
		
		webDriver.navigate().refresh();
		
		// Invalid email syntax 
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("suvetha@mobicip");
		webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12");
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//button[text()='Continue']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']/following::span[text()='Invalid Email: Enter a valid email address']")));
		
		try{webDriver.findElement(By.xpath("//input[@name='login_email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e) {a=false;
		test6.fail("Email - Invalid syntax - Failed");}
		if(a==true){test6.pass("Email - Invalid syntax - Displayed");}
		
		webDriver.navigate().refresh();
		
		// Invalid email  
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("suvetha+suve1@mobicip.com");
		webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//button[text()='Continue']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Login Failed - Enter a valid email']")));
		
		try{webDriver.findElement(By.xpath("//span[text()='Login Failed - Enter a valid email']"));}
		catch(NoSuchElementException e) {a=false;
		test6.fail("Email - Invalid email - Failed");}
		if(a==true){test6.pass("Email - Invalid email - Displayed");}
		
		webDriver.navigate().refresh();		
		
		// Invalid Password syntax
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("suvetha+pt@mobicip.com");
		webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12");
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//button[text()='Continue']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Login Failed - Enter a valid email / passworwebDriver. 4 attempts left']")));
		
		try{webDriver.findElement(By.xpath("//span[text()='Login Failed - Enter a valid email / passworwebDriver. 4 attempts left']"));}
		catch(NoSuchElementException e) {a=false;
		test6.fail("Password - Invalid syntax - Failed");}
		if(a==true){test6.pass("Password - Invalid syntax - Displayed");}
		
		webDriver.navigate().refresh();	
		
		// Invalid Password syntax
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("suvetha+pt@mobicip.com");
		webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12");
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//button[text()='Continue']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Login Failed - Enter a valid email / passworwebDriver. 3 attempts left']")));
		
		try{webDriver.findElement(By.xpath("//span[text()='Login Failed - Enter a valid email / passworwebDriver. 3 attempts left']"));}
		catch(NoSuchElementException e) {a=false;
		test6.fail("Password - Invalid syntax - Failed");}
		if(a==true){test6.pass("Password - Invalid syntax - Displayed");}
		
		webDriver.navigate().refresh();
		
		// Valid Credentials
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("suvetha+711@mobicip.com");
		webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
		TimeUnit.SECONDS.sleep(1);
				
		webDriver.findElement(By.xpath("//button[text()='Continue']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='login_password']")));
		
		TimeUnit.SECONDS.sleep(4);
		String tit=webDriver.getTitle();
		tit = webDriver.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test6.pass("Valid Credential - Passed");}
		else{test6.fail("Valid Credential - Failed");}
				
		WebElement e = webDriver.findElement(By.xpath("//div[@class='user_profile_wrapper']"));
		Actions act = new Actions(webDriver);
		act.moveToElement(e).perform();
				
		webDriver.findElement(By.xpath("//ul[@class='profile_dropdown_ul']/li[8]/div")).click();
		TimeUnit.SECONDS.sleep(5);
		webDriver.findElement(By.xpath("//div[@class='header_session_links']/a[1]")).click();
		TimeUnit.SECONDS.sleep(3);
				
		webDriver.findElement(By.xpath("//div[@class='forgot_password']/a")).click();
		TimeUnit.SECONDS.sleep(3);
	  }	

	// Forget Password
	@Test
	public void d1_forgetPasswordPage() throws InterruptedException
	  {
		ExtentTest test7=extentreport.createTest("Forget Password page","To check the Prelogin Forget Password web page title,logo");
		
		// page title
		String tit=webDriver.getTitle();
		tit = webDriver.getTitle();
		if(tit.equals("Forgot Password | Mobicip"))
		{test7.pass("Forgot Password Page title is correct");}
		else{test7.fail("Forgot Password Page title isn't correct");}
			
		//Header Elements
		boolean a=true;
		try {webDriver.findElement(By.xpath("//header[@class='content_header']/a"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Pre login Forgot Password page - Logo is incorrect");}
		if(a==true){test7.pass("Pre-login Forgot Password page - Logo is correct");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//header[@class='content_header']/a")).click();}
		catch(NoSuchElementException e){a=false;
		test7.fail("Link redirects failed");}
		if(a==true){test7.pass("Link works fine");}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='session_form_container']//h1"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Forgot Password title is not present");}
		if(a==true){test7.pass("Forgot Password title is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']//label"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Email placeholder is not present");}
		if(a==true){test7.pass("Email placeholder is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='input_fields_wrapper']/div[1]//input"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Email field is not present");}
		if(a==true){test7.pass("Email field is present");}
		
		a=true;
		try {webDriver.findElement(By.xpath("//div[@class='session_form_container']//button"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Reset Password button is not present");}
		if(a==true){test7.pass("Reset Password button is present");}
		
		// Required Field
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("");
		TimeUnit.SECONDS.sleep(1);
		
		webDriver.findElement(By.xpath("//button[text()='Reset Password']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required Field']")));
		
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test7.fail("Email Required Field - Failed");}
		if(a==true){test7.pass("Email Required Field - Displayed");}	
		
		// Invalid email  
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("suvetha+suve1@mobicip.com");
		TimeUnit.SECONDS.sleep(1);
				
		webDriver.findElement(By.xpath("//button[text()='Reset Password']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please enter a valid email']")));
				
		try{webDriver.findElement(By.xpath("//span[text()='Please enter a valid email']"));}
		catch(NoSuchElementException e) {a=false;
		test7.fail("Email - Invalid email - Failed");}
		if(a==true){test7.pass("Email - Invalid email - Displayed");}
				
		webDriver.navigate().refresh();		
		
		// Invalid email syntax 
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("suvetha@mobicip");
		TimeUnit.SECONDS.sleep(1);
				
		webDriver.findElement(By.xpath("//button[text()='Reset Password']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Email: Enter a valid email address']")));
				
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e) {a=false;
		test7.fail("Email - Invalid syntax - Failed");}
		if(a==true){test7.pass("Email - Invalid syntax - Displayed");}
		webDriver.navigate().refresh();
		
		// Invalid email syntax 
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("suvetha+711@mobicip.com");
		TimeUnit.SECONDS.sleep(1);
						
		webDriver.findElement(By.xpath("//button[text()='Reset Password']")).click();
		TimeUnit.SECONDS.sleep(20);
		webDriver.findElement(By.xpath("//a[@class='company_logo']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		
	  }
	
	@AfterClass
	public void teardown()
	  {
	    extentreport.flush(); 	
	   }
}
