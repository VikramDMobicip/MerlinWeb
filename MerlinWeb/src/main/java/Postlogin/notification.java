package Postlogin;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//enable all notification settings
//email report - weekly - monday is saved previouly
//Staging : https://www.webs.prgr.in/login   Live : https://www.mobicip.com/login

public class notification extends BrowserSetup{

	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
    public void beforeTest() 
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PostloginTest\\TestNotification\\reportNotification.html");
		extentreport.attachReporter(spark);
    }
	
	//Login using credentials
	@Test(priority=2)
	public void a2_dashboard()
	{
  		ExtentTest test1=extentreport.createTest("dashboard","Checking the dashboard page");
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=webDriver.getTitle();
	    if(tit.equals("Dashboard | Mobicip"))
	    {test1.pass("Dashboard page title is correct");}
	    else{test1.fail("Dashboard page title is incorrect");}
	}
	
	//Checking the notification icon and title
	@Test(priority=3)
	public void a3_notifications() {
		ExtentTest test3=extentreport.createTest("Notification icon and title","Verify if there is Notification icon in the top right corner of dashboard page.");
		boolean a=true;
		try{webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]")).click();} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Notification icon not found");}
		if(a==true) {test3.pass("Notification icon is clickable");}
		
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=webDriver.getTitle();
	    if(tit.equals("Notifications | Mobicip"))
	    {test3.pass("Notification page title is correct");}
	    else{test3.fail("Notification page title is incorrect");}
	}
	
	//Checking settings icon and its page title
	@Test(priority=4)
	public void a4_settings() {
		ExtentTest test4=extentreport.createTest("Settings icon and page title","Verify if there is Settings icon in the top right corner of notifications page.");
		boolean a=true;
		try{webDriver.findElement(By.xpath("//a[@class='icon_settings']")).click();} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Settings icon not found");}
		if(a==true) {test4.pass("Settings icon is clickable");}
		
		
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=webDriver.getTitle();
	    if(tit.equals("Notification Settings | Mobicip"))
	    {test4.pass("Settings page title is correct");}
	    else{test4.fail("Settings page title is incorrect");}
	}
	
	//Checking notifications icon in settings page
	@Test(priority=5)
	public void a5_icon() {
		ExtentTest test5=extentreport.createTest("Notification icon in Settings page","Verify if Notification icon is not present in Notification Settings page.");
		boolean a=true;
		try{webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]")).click();} 
		catch(NoSuchElementException e){a=false;
		test5.pass("Notification icon is present in Settings page");}
		if(a==true) {test5.fail("Notification icon is not found in Settings page");}
	}
	
	//Checking for the header components
	@Test(priority=6)
	public void a6_Components() {
		ExtentTest test6=extentreport.createTest("Components","Verify if notification settings page has all the components");
		boolean a=true;
		try{webDriver.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Mobicip logo is not found");}
		if(a==true) {test6.pass("Mobicip logo is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//span[@class='header_back']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Back button is not found");}
		if(a==true) {test6.pass("Back button is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Notification Settings']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Header is incorrect");}
		if(a==true) {test6.pass("Header is correct");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Profile icon is not present");}
		if(a==true) {test6.pass("Profile icon is present");}
	}
	
	//Checking the notification text and default state of toggle button
	@Test(priority=7)
	public void a7_Notification_text() {
		ExtentTest test7=extentreport.createTest("Notification settings - options","Checking the notification text and default state of toggle buttons");
		
		boolean a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Notify me if the device is inactive for a week']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Text 'Notify me if the device is inactive for a week' is incorrect");}
		if(a==true) {test7.pass("Text 'Notify me if the device is inactive for a week' is correct");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//input[@name='setting_code[DEV_ACT]' and @checked]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Toggle button is disabled for 'Notify me if the device is inactive for a week' ");}
		if(a==true) {test7.pass("Toggle button is enabled for 'Notify me if the device is inactive for a week' ");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Notify me if the new app installed in the device']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Text 'Notify me if new app is installed' is incorrect");}
		if(a==true) {test7.pass("Text 'Notify me if new app is installed' is correct");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//input[@name='setting_code[NEW_APP]' and @checked]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Toggle button is disabled for 'Notify me if new app is installed'");}
		if(a==true) {test7.pass("Toggle button is enabled for 'Notify me if new app is installed'");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//input[@name='setting_code[NEW_APP]' and @checked]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Toggle button is disabled for 'Notify me if new app is installed'");}
		if(a==true) {test7.pass("Toggle button is enabled for 'Notify me if new app is installed'");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Notify if any profile is deleted']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Text 'Notify me if profile is deleted' is incorrect");}
		if(a==true) {test7.pass("Text 'Notify me if profile is deleted' is correct");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//input[@name='setting_code[DEL_PROF]' and @checked]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Toggle button is disabled for 'Notify me if profile is deleted'");}
		if(a==true) {test7.pass("Toggle button is enabled for 'Notify me if profile is deleted'");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Send Reports by Email showing child activity']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Text 'Send device activity report by email' is incorrect");}
		if(a==true) {test7.pass("Text 'Send device activity report by email' is correct");}

		a=true;
		try{webDriver.findElement(By.xpath("//input[@name='setting_code[EMAIL_REP]' and @checked]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Toggle button is enabled for 'Send device activity report by email'");}
		if(a==true) {test7.pass("Toggle button is disabled for 'Send device activity report by email'");}
		
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Notify me if child reaches a marked place']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Text 'Notify me if child reaches a marked place' is incorrect");}
		if(a==true) {test7.pass("Text 'Notify me if child reaches a marked place' is correct");}

		a=true;
		try{webDriver.findElement(By.xpath("//input[@name='setting_code[CHILD_LOC]' and @checked]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Toggle button is disabled for 'Notify me if child reaches a marked place");}
		if(a==true) {test7.pass("Toggle button is enabled for 'Notify me if child reaches a marked place'");}
	}
		
	//Disabling the toggle buttons
	@Test(priority=8)
	public void a8_disable_toggle_button() {
		ExtentTest test8=extentreport.createTest("Disabling the toggle buttons","Verify if able to disable the toggle buttons of all the notifications settings.");
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,-1000)"); 
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='setting_code_DEV_ACT']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='setting_code_NEW_APP']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='setting_code_DEL_PROF']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='setting_code_EMAIL_REP']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
		j1.executeScript("window.scrollBy(0,1000)"); 
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
		webDriver.findElement(By.xpath("//label[@for='setting_code_CHILD_LOC']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
		test8.pass("Toggle button is disabled for All");
	}
	
	//Revisiting the page
	@Test(priority=9)
	public void a9_revisiting() {
		ExtentTest test9=extentreport.createTest("Revisiting the page ","Revisiting the page to ensure the changes are retained");
		webDriver.findElement(By.xpath("//span[@class='header_back']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='icon_settings']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		a=webDriver.findElement(By.xpath("//input[@type='checkbox' and @name='setting_code[DEV_ACT]']")).isSelected();
		if(a==true)
			test9.fail("Toggle button is enabled for 'Notify me if the device is inactive for a week' ");
			
		else
			test9.pass("Toggle button is disabled for 'Notify me if the device is inactive for a week' ");	
		a=webDriver.findElement(By.xpath("//input[@type='checkbox' and @name='setting_code[NEW_APP]']")).isSelected();
		if(a==true)
			test9.fail("Toggle button is enabled for 'Notify me if new app is installed'");
			
		else
			test9.pass("Toggle button is disabled for 'Notify me if new app is installed'");
		
		a=webDriver.findElement(By.xpath("//input[@type='checkbox' and @name='setting_code[DEL_PROF]']")).isSelected();
		if(a==true)
			test9.fail("Toggle button is enabled for 'Notify me if profile is deleted'");
			
		else
			test9.pass("Toggle button is disabled for 'Notify me if profile is deleted'");
		
		a=webDriver.findElement(By.xpath("//input[@type='checkbox' and @name='setting_code[EMAIL_REP]']")).isSelected();
		if(a==true)
			test9.fail("Toggle button is enabled for 'Send device activity report by email'");
			
		else
			test9.pass("Toggle button is disabled for 'Send device activity report by email'");
		
		a=webDriver.findElement(By.xpath("//input[@type='checkbox' and @name='setting_code[CHILD_LOC]']")).isSelected();
		if(a==true)
			test9.fail("Toggle button is enabled for 'Notify me if child reaches a marked place'");
			
		else
			test9.pass("Toggle button is disabled for 'Notify me if child reaches a marked place");
	}	
	
	//Enabling the toggle buttons
	@Test(priority=10)
	public void b0_enable_toggle_button() {
		ExtentTest test10=extentreport.createTest("Enabling the toggle buttons","Verify if able to enable the toggle buttons of all the notifications settings");
			webDriver.findElement(By.xpath("//label[@for='setting_code_DEV_ACT']")).click();
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			webDriver.findElement(By.xpath("//label[@for='setting_code_NEW_APP']")).click();
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			webDriver.findElement(By.xpath("//label[@for='setting_code_DEL_PROF']")).click();
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			webDriver.findElement(By.xpath("//label[@for='setting_code_CHILD_LOC']")).click();
			try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
			webDriver.findElement(By.xpath("//label[@for='setting_code_EMAIL_REP']")).click();
			try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	//Checking the email label
	@Test(priority=11)
	public void b1_Email_label() {
		ExtentTest test11=extentreport.createTest("Email reports section","Verify if Email reports section has all components");
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,300)"); 
		
		boolean a=true;
		try{webDriver.findElement(By.xpath("//label[text()='Send activity report to']"));} 
		catch(NoSuchElementException e){a=false;
		test11.fail("Label 'Send activity report to' is not found");}
		if(a==true) {test11.pass("Label 'Send activity report to' is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Use commas to add multiple emails']"));} 
		catch(NoSuchElementException e){a=false;
		test11.fail("Text 'Use commas to add multiple emails' is not found");}
		if(a==true) {test11.pass("Text 'Use commas to add multiple emails' is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//input[@value='vikram+1@mobicip.com']"));} 
		catch(NoSuchElementException e){a=false;
		test11.fail(" Email textbox has owner account email id isn't shown by default.");}
		if(a==true) {test11.pass(" Email textbox has owner account email id shown by default.");}
		
	}   
	
	//Email validation with different email
	@Test(priority=12)
	public void b2_Email_validation() {
		ExtentTest test12=extentreport.createTest("Email Validation","Validate the some cases in Send Activity to textbox");
		//Blank space
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("      ");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown for blank spaces");}
		if(a==true) {test12.pass("Error thrown for blank spaces");}
		
		//special characters
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram!@#@gmail.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown for Invalid Emails");}
		if(a==true) {test12.pass("Error thrown for Invalid Emails");}
		
		//Duplicate Email
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com,vikram+1@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Duplicate Emails Exist']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown for Duplicate Emails");}
		if(a==true) {test12.pass("Error thrown for Duplicate Emails");}
	
		//Invalid multiple 
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com vikram+2@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown for Invalid Emails");}
		if(a==true) {test12.pass("Error thrown for Invalid Emails");}
		
		//Valid Emails
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com, vikram+2@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test12.pass("No Error thrown Valid Emails");}
		if(a==true) {test12.fail("Error thrown Valid Emails");}
		
		//Valid Emails
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com,vikram+2@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test12.pass("No Error thrown Valid Emails");}
		if(a==true) {test12.fail("Error thrown Valid Emails");}
		
		//Invalid multiple entries
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com,");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown for blank spaces");}
		if(a==true) {test12.pass("Error thrown for blank spaces");}
		
		//Invalid multiple entries
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com,  ,vikram+2@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown for blank spaces");}
		if(a==true) {test12.pass("Error thrown for blank spaces");}
		
		//Invalid multiple entries
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com,vikram!#@$@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("No Error thrown Valid Emails");}
		if(a==true) {test12.pass("Error thrown Valid Emails");}
		
		//Valid
		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("vikram+1@mobicip.com");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test12.pass("No Error thrown Valid Emails");}
		if(a==true) {test12.fail("Error thrown Valid Emails");}
	}
	
	//Checking the label
	@Test(priority=13)
	public void b3_freq_label() {
		ExtentTest test13=extentreport.createTest("How often - label","Checking the How often - label is shown");
		boolean a=true;
		try{webDriver.findElement(By.xpath("//p[text()='How often?']"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("Label 'How often?' is not present");}
		if(a==true) {test13.pass("Label 'How often?' is present");}	
	}
		
	//Checking the weekly option
	@Test(priority=14)
	public void b4_weekly() {
		ExtentTest test14=extentreport.createTest("Weekly","Verify if clicking on Weekly shows the day selection field.");
		boolean a=true;
		a=webDriver.findElement(By.xpath("//input[@type='radio' and @id='frequency_id_weekly']")).isSelected();
		if(a==true)
			test14.pass("Weekly option is selected by default");	
		else
			test14.fail("Weekly option is not selected by default");
		
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		
		a=webDriver.findElement(By.xpath("//input[@type='radio' and @id='weekday_2']")).isSelected();
		if(a==true)
				test14.pass("Monday is selected by default");	
		else
				test14.fail("Monday is not selected by default");
		a=true;
		try
			{ 
				webDriver.findElement(By.xpath("//span[text()='Sunday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
				webDriver.findElement(By.xpath("//span[text()='Tuesday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
				webDriver.findElement(By.xpath("//span[text()='Wednesday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
				webDriver.findElement(By.xpath("//span[text()='Thursday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
				webDriver.findElement(By.xpath("//span[text()='Friday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
				webDriver.findElement(By.xpath("//span[text()='Saturday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
				webDriver.findElement(By.xpath("//span[text()='Monday']")).click();
				try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
			} 
		catch(NoSuchElementException e){
				a=false;
				test14.fail("Not able to select the days");}
		if(a==true) {test14.pass("Able to select any day");}
		
	}
		
	//Checking the daily option
	@Test(priority=15)
	public void b5_daily() {
		ExtentTest test15=extentreport.createTest("Daily","Verify if clicking on Daily, no field is shown.");
		webDriver.findElement(By.xpath("//label[text()='Daily']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Sunday']"));} 
		catch(NoSuchElementException e){a=false;
		test15.pass("Days field is not present in daily option");}
		if(a==true) {test15.fail("Days field is present in daily");}
	}
		
	//Checking the monthly date label
	@Test(priority=16)
	public void b6_monthly_label() {
		ExtentTest test15=extentreport.createTest("Monthly date label","Verify if clicking on Monthly shows the date selection field.");
		webDriver.findElement(By.xpath("//label[text()='Monthly']")).click();
		boolean a=true;
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//label[text()='Select report date']"));} 
		catch(NoSuchElementException e){a=false;
			test15.fail("Label 'Select report date' is not found");}
	    if(a==true){test15.pass("Label 'Select report date' is present");}
	}
	
	//Checking the dates
	@Test(priority=17)
	public void b7_monthly() {
	ExtentTest test16=extentreport.createTest("Monthly date","Verify if able to select any date from 1 to 31 on selecting Monthly option.");	
	boolean a=true;
	try
	{ 
			Select s = new Select(webDriver.findElement(By.xpath("//label[text()='Select report date']/following::select")));
			s.selectByVisibleText("2");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("3");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("4");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("5");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("6");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("7");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("8");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("9");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("10");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("11");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("12");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("13");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("14");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("15");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("16");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("17");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("18");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("19");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("20");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("21");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("22");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("23");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("24");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("25");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("26");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("27");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("28");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("29");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("30");
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			s.selectByVisibleText("31");	
		} 
		catch(NoSuchElementException e)
		{	a=false;
			test16.fail("Not able to select the dates");}
		if(a==true) {test16.pass("Able to select any date");}
	    }
		
	//Checking the email type
	@Test(priority=18)
	public void b8_emailtype() {
		ExtentTest test17=extentreport.createTest("Email type","Verify if able to select either pdf or html");	
		boolean a=true;
		a=webDriver.findElement(By.xpath("//input[@type='radio' and @id='format_id_pdf']")).isSelected();
		if(a==true)test17.pass("PDF is selected by default");
		else {test17.fail("PDF is not selected by default");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//label[@for='format_id_html']")).click();} 
		catch(NoSuchElementException e){a=false;
			test17.fail("Not able to select HTML option");}
		if(a==true) {test17.pass("Able to select HTML option");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{webDriver.findElement(By.xpath("//p[text()='Email Report settings updated successfully']"));} 
		catch(NoSuchElementException e){a=false;
			test17.fail("Changes were not saved ");}
		if(a==true) {test17.pass("Changes got saved -pop up shown");}
	}
		
	//Revisiting the page
	@Test(priority=19)
	public void b9_Revisiting() {
		ExtentTest test18=extentreport.createTest("Clicking back and revisiting");
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[text()='Weekly']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='format_id_pdf']")).click();
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Apply']")).click();
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@class='header_back']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='icon_settings']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		a=webDriver.findElement(By.xpath("//input[@type='radio' and @id='frequency_id_weekly']")).isSelected();
		if(a==true)
			test18.pass("Changes were not saved");
		else
			test18.fail("Changes were saved");	
		// redirect to dashboard
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
		
	@AfterClass
    public void teardown() 
    {
//  		d.quit();
    	extentreport.flush();
    }
}