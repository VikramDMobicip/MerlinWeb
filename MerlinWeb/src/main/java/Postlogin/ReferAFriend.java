package Postlogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//Please check the website to check whether its staging or Live
//Staging : https://www.webs.prgr.in/login   Live : https://www.mobicip.com/login

public class ReferAFriend extends BrowserSetup{

	
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
    public void beforeTest() 
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PostloginTest\\TestReferAFriend\\reportReferAFriend.html");
		extentreport.attachReporter(spark);
    }
	
    //Checking for the title of Refer a friend - Title page
	@Test(priority=1)
	public void a1_ReferAFriendpage()
	{
  		ExtentTest test=extentreport.createTest("Refer a friend - Title","Verify if able to open Refer a friend page from the Menu options ");
  		     
		//---Dash board---
		String tit=webDriver.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test.pass("Dashboard - title is correct ");}
		else{test.fail("Dashboard - title isn't correct ");}
		boolean a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Hello Vikram!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Dashboard - Header was Incorrect");}
		if(a==true){test.pass("Dashboard - Header was correct");}
			
		//---Refer A Friend---
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
			
		//---Validation - Refer a Friend ---
		//Title
		tit=webDriver.getTitle();
		if(tit.equals("Refer a Friend | Mobicip"))
		{test.pass("Refer a Friend - page opened and title is correct ");}
		else{test.fail("Refer a Friend - title isn't correct ");}
    }
	
	@Test(priority=2)
	public void a2_PageComponents()
	{
  		ExtentTest test=extentreport.createTest("Refer a friend -  Page componenets","Verify if Refer a friend page has all components");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("Mobicip logo is not found");}
		if(a==true) {test.pass("Mobicip logo is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("Back button is not found");}
		if(a==true) {test.pass("Back button is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("Refer a Friend  -  Header is incorrect");}
		if(a==true) {test.pass("Refer a Friend - Header is correct");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("Profile icon is not present");}
		if(a==true) {test.pass("Profile icon is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='background_image']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("Background Image is not present");}
		if(a==true) {test.pass("Background Image is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='input_container']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("Input container is not present");}
		if(a==true) {test.pass("Input container is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='guideline']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("guideline is not present");}
		if(a==true) {test.pass("guideline is present");}
		
		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,300)");

		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='faq_wrapper']"));} 
		catch(NoSuchElementException e){a=false;
		test.fail("FAQ wrapper is not present");}
		if(a==true) {test.pass("FAQ wrapper is present");}		
	}
 	
	@Test(priority=3)
	public void a3_Navigationtoothepages()
	{
  		ExtentTest test=extentreport.createTest("Navigation to other pages","Verify if able to navigate to other pages");
  		boolean a=true;
  		//Mobicip logo
  		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Dashboard']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Mobicip logo is not redirects dashboard");}
		if(a==true) {test.pass("Mobicip logo is redirects dashboard properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Back button 
	    a=true;
  		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Dashboard']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Back button is not redirects previous page");}
		if(a==true) {test.pass("Back button is redirects previous page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Help button 
	    a=true;
  		webDriver.findElement(By.xpath("//a[@class='help_icon']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='Support']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Help button is not redirects Help page");}
		if(a==true) {test.pass("Help button is redirects Help page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Notification button
	    a=true;
  		webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='Notifications']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Notification button is not redirects Notification page");}
		if(a==true) {test.pass("Notification button is redirects Notification page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Profile pop-up : My mobicip
	    a=true;
	    webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='My Mobicip']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("My Mobicip button is not redirects My Mobicip page");}
		if(a==true) {test.pass("My Mobicip button is redirects My Mobicip page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Profile pop-up : Family Locator
	    a=true;
	    webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Family Locator']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='Family Locator']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Family Locator button is not redirects Family Locator page");}
		if(a==true) {test.pass("Family Locator button is redirects Family Locator page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Profile pop-up : Parenting Advice
	    a=true;
	    webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Parenting']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='Parenting Advice']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Parenting Advice button is not redirects Parenting Advice page");}
		if(a==true) {test.pass("Parenting Advice button is redirects Parenting Advice page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Profile pop-up : Share Feedback
	    a=true;
	    webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Share Feedback']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='Share Feedback']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Share Feedback button is not redirects Share Feedback page");}
		if(a==true) {test.pass("Share Feedback button is redirects Share Feedback page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Profile pop-up : Support
	    a=true;
	    webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Support']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='Support']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Support button is not redirects Support page");}
		if(a==true) {test.pass("Support button is redirects Support page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
		//Profile pop-up : About Mobicip
	    a=true;
	    webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='About Mobicip']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='About Mobicip']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("About Mobicip button is not redirects About Mobicip page");}
		if(a==true) {test.pass("About Mobicip button is redirects About Mobicip page properly");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Refer a Friend']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to land on Refer a Friend page again");}
		if(a==true) {test.pass("Able to land on Refer a Friend page again");}
	}
	
	@Test(priority=4)
	public void a4_SingleEmailentry()
	{
  		ExtentTest test=extentreport.createTest("Single Email Entry","Verify if able to enter text in the email field.");
  		boolean a=true;
		try{webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+09jan@mobicip.com");}
		catch(NoSuchElementException e){a=false;
		test.fail("Unable to enter email ID");}
		if(a==true) {test.pass("Able to enter email ID");}
	}
	
	@Test(priority=5)
	public void a5_SingleEmailvalidation()
	{
  		ExtentTest test=extentreport.createTest("Single Email Validation","Verify if the email field shows error in following cases.");
  		//Blank space
  		boolean a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("                ");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Blank space is accepted");}
		if(a==true) {test.pass("Blank space isn't accepted and Proper alert message shown");}
		//Empty field
		a=true;
		
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Empty field is accepted");}
		if(a==true) {test.pass("Empty field isn't accepted and Proper alert message shown");}
		//Blank space inbetween characters
		a=true;
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+07jan @mobicip.com");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Blank space inbetween characters is accepted");}
		if(a==true) {test.pass("Blank space inbetween characters isn't accepted and Proper alert message shown");}
		//Incorrect format
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram!#@mobi().com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Incorrect format is accepted");}
		if(a==true) {test.pass("Incorrect format isn't accepted and Proper alert message shown");}
		//Same account which is logged in
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+1@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Same account which is logged in is accepted");}
		if(a==true) {test.pass("Same account which is logged in isn't accepted and Proper alert message shown");}
		//Already mobicip registered email with subscription
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("Suvetha+pt@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Already mobicip registered email with subscription is accepted");}
		if(a==true) {test.pass("Already mobicip registered email with subscription isn't accepted and Proper alert message shown");}
		//Already mobicip registered email without subscription
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+4@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Already mobicip registered email without subscription is accepted");}
		if(a==true) {test.pass("Already mobicip registered email without subscription isn't accepted and Proper alert message shown");}
	}
	
	@Test(priority=6)
	public void a6_SingleEmailvalidationaccept()
	{
  		ExtentTest test=extentreport.createTest("Single Email Validation Accept","Verify if able to Refer a friend by entering valid email and clicking on Send Referral button.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
			webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.pass("New valid unregistered email without subscription is accepted");}
		if(a==true) {test.fail("New valid unregistered email without subscription isn't accepted and alert message shown");}
	}
	
	@Test(priority=7)
	public void a7_MultipleEmailCommavalidation()
	{
  		ExtentTest test=extentreport.createTest("Multiple Email - Comma Validation ","Verify if the multiple emails are accepted only when they are separated by commas. and Verify if the multiple emails are not accepted and shows error when they aren't separated by commas. and Verify if the commas can have space between email ids and it is still accepted.");
  		boolean a=true;
  		//seperated by dot
  		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+7j@mobicip.com.vikram+8j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("seperated by dot is accepted");}
		if(a==true) {test.pass("seperated by dot isn't accepted and alert message shown");}
		//seperated by &
		a=true;
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+7j@mobicip.com&vikram+8j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("seperated by & is accepted");}
		if(a==true) {test.pass("seperated by & isn't accepted and alert message shown");}
		//seperated by /
		a=true;
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+7j@mobicip.com/vikram+8j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("seperated by / is accepted");}
		if(a==true) {test.pass("seperated by / isn't accepted and alert message shown");}
		//seperated by and 
		a=true;
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+7j@mobicip.com and vikram+8j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("seperated by and is accepted");}
		if(a==true) {test.pass("seperated by and isn't accepted and alert message shown");}
		//seperated by & in one time
		a=true;
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+7j@mobicip.com,vikram+8j@mobicip.com&vikram+9j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("seperated by by & in one time is accepted");}
		if(a==true) {test.pass("seperated by by & in one time isn't accepted and alert message shown");}
	}
	
	@Test(priority=8)
	public void a8_MultipleEmailEmailValidation()
	{
  		ExtentTest test=extentreport.createTest("Multiple Email -Email Validation","Verify if the error is shown properly and not accepted even when one of the multiple emails given is as follows");
  		boolean a=true;
  		//Blank space
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2j@mobicip.com,             ");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Blank space is accepted");}
		if(a==true) {test.pass("One of the email ID has Blank space isn't accepted and Proper alert message shown");}
		//Empty field
		a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2j@mobicip.com,");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Empty field is accepted");}
		if(a==true) {test.pass("One of the email ID has Empty field isn't accepted and Proper alert message shown");}
		//Blank space inbetween characters
		a=true;
		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2j@mobicip.com,vikram+07jan @mobicip.com");
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Blank space inbetween characters is accepted");}
		if(a==true) {test.pass("One of the email ID has Blank space inbetween characters isn't accepted and Proper alert message shown");}
		//Incorrect format
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram!#@mobi().com,vikram+2j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Incorrect format is accepted");}
		if(a==true) {test.pass("One of the email ID has Incorrect format isn't accepted and Proper alert message shown");}
		//Same account which is logged in
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2j@mobicip.com,vikram+1@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Same account which is logged in is accepted");}
		if(a==true) {test.pass("One of the email ID has Same account which is logged in isn't accepted and Proper alert message shown");}
		//Already mobicip registered email with subscription
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("Suvetha+pt@mobicip.com,vikram+2j@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Already mobicip registered email with subscription is accepted");}
		if(a==true) {test.pass("One of the email ID has Already mobicip registered email with subscription isn't accepted and Proper alert message shown");}
		//Already mobicip registered email without subscription
  	    a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2j@mobicip.com, vikram+4@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("One of the email ID has Already mobicip registered email without subscription is accepted");}
		if(a==true) {test.pass("One of the email ID has Already mobicip registered email without subscription isn't accepted and Proper alert message shown");}
	}
	
	@Test(priority=9)
	public void a9_MultipleEmailPositivecase()
	{
  		ExtentTest test=extentreport.createTest("Multiple Email - Positive case","Verify if able to Refer multiple friends by adding multiple emails and clicking on Send Referral.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2k@mobicip.com, vikram+3k@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
			webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.pass("New valid unregistered multiple emails without subscription is accepted");}
		if(a==true) {test.fail("New valid unregistered multiple emails without subscription isn't accepted and alert message shown");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		
		a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2k@mobicip.com, vikram+3k@mobicip.com,vikram+5k@mobicip.com,vikram+6k@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));
			webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));
			webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;
		test.pass("New valid unregistered multiple emails more then 2 without subscription is accepted");}
		if(a==true) {test.fail("New valid unregistered multiple emails more then 2 without subscription isn't accepted and alert message shown");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test(priority=10)
	public void b0_MultipleEmailDuplicateEmail()
	{
  		ExtentTest test=extentreport.createTest("Multiple Email - Dupllicate Email","Verify if the duplicates are not allowed in case of entering multiple emails.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2k@mobicip.com, vikram+2k@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Duplicate Emails Exist']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Duplicate multiple emails without subscription is accepted");}
		if(a==true) {test.pass("Duplicate multiple emails without subscription isn't accepted and alert message shown");}
	}
	
	@Test(priority=11)
	public void b1_Doitlater()
	{
  		ExtentTest test=extentreport.createTest("Do it later ","Verify Do it later button should not affect anything in referral");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+4@mobicip.com");
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//div[text()='Do it Later']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Already a Mobicip User.']"));}
		catch(NoSuchElementException e){a=false;
		test.pass("Do it later didn't validate the input field");}
		if(a==true) {test.fail("Do it later validated the input field");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test(priority=12)
	public void b2_InvitesentMessage()
	{
  		ExtentTest test=extentreport.createTest("Invite sent Message","Verify if Invite sent Successfully. Thanks  a lot for Referral ! Toast Message is shown after sending the Invite");
  		boolean a=true;
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).clear();
  		webDriver.findElement(By.xpath("//textarea[@name='email_ids']")).sendKeys("vikram+2o@mobicip.com");
  		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='Invite sent successfully. Thanks a lot for the referral!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Invite sent Successfully. Thanks  a lot for Referral ! Toast Message is shown after sending the Invite");}
		if(a==true) {test.pass("Invite sent Successfully. Thanks  a lot for Referral ! Toast Message is shown after sending the Invite");}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click(); 
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Refer a Friend']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test(priority=13)
	public void b3_Howitworkssection()
	{
  		ExtentTest test=extentreport.createTest("How it works section","Verify the contents in 'how it works?' ");
  		boolean a=true;
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='How it works']"));
		webDriver.findElement(By.xpath("//p[text()='Invite your friends and we will send them a referral code by email.']"));		
		webDriver.findElement(By.xpath("//span[text()='$20 Amazon gift card']"));
		webDriver.findElement(By.xpath("//p[text()='For every purchase made using the referral code, you will be eligible for a referral reward.']"));
		webDriver.findElement(By.xpath("//p[text()=' for each referred friend, as long as they remain an active Mobicip user for at least 60 days from the date of purchase.' and text()='You will earn a ']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("the contents in 'how it works?' isn't proper");}
		if(a==true) {test.pass("the contents in 'how it works?' is proper");}
	}
	
	@Test(priority=14)
	public void b4_Commentlyaskedquestionssection()
	{
  		ExtentTest test=extentreport.createTest("Commently asked questions section","Verify the contents in Commmenly asked questions");
  		boolean a=true;
  		JavascriptExecutor jse= (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,800)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']"));
		webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']/following::li[1]"));
		webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']/following::li[2]"));		
		webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']/following::li[3]"));		
		webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']/following::li[4]"));		
		webDriver.findElement(By.xpath("//p[text()='Commonly Asked Questions']/following::li[5]"));}
		catch(NoSuchElementException e){a=false;
		test.fail("The contents in Commmenly asked questions isn't proper");}
		if(a==true) {test.pass("The contents in Commmenly asked questions is proper");}
		
		// redirect to dashboard
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@AfterClass
    public void teardown() 
    {
// 		d.quit();
    	extentreport.flush();
    }
}