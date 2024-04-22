package Postlogin;
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

// Before start it - Make ch1 as MM child - Having No Blocked Websites previously. one allowed website - allowed.com                   

public class ContentBlockedWeb extends baseClass{
	//Report setup
//	WebDriver d;
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestWebsites\\reportContentBlockedWeb.html");
		extentreport.attachReporter(spark);
    }
		
  	@Test
	public void a1_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Content - Blocked Web ","To check the Content > Blocked Website Option is placed and opened properly");
  		
		//---Dash board---
		String tit=d.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test.pass("Dashboard - title is correct  ");}
		else{test.fail("Dashboard - title isn't correct ");}
		boolean a=true;
		try {d.findElement(By.xpath("//p[text()='Hello Vikram!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Dashboard - Header was Incorrect");}
		if(a==true){test.pass("Dashboard - Header was correct");}
		
		//---Content Option---
		a=true;
		d.findElement(By.xpath("//p[@title='ch1']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Content']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content option is not present in dashboard");}
		if(a==true){test.pass("Content option is present in dashboard");}
		d.findElement(By.xpath("//span[text()='Content']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		//---Content Web---
		a=true;
		try{d.findElement(By.xpath("//a[text()='Websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Websites option is not present in dashboard");}
		if(a==true){test.pass("Content - Websites option is present in dashboard");}
		d.findElement(By.xpath("//a[text()='Websites']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
 		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		
		//---Content - Blocked Web---
		a=true;
		try{d.findElement(By.xpath("//span[text()='Blocked Websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Blocked Websites option is not present in dashboard");}
		if(a==true){test.pass("Content - Blocked Websites option is present in dashboard");}
		d.findElement(By.xpath("//span[text()='Blocked Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		tit=d.getTitle();
		System.out.println(tit);
		if(tit.equals("Blocked Websites | Content Monitoring | Mobicip"))
		{test.pass("Blocked websites - Title is correct  ");}
		else{test.fail("Blocked websites - Title isn't correct ");}
		
	}
  	
  	@Test
	public void a2_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Content - Blocked Web - Header components ","Checking the components of the header");
  		boolean a=true;
		try{d.findElement(By.xpath("//a[@class='logo']"));
			d.findElement(By.xpath("//span[@id='headerBack']"));
			d.findElement(By.xpath("//div[@title='ch1']/div[@class='profile_image_container']"));
			d.findElement(By.xpath("//p[text()='Blocked Websites']"));
			d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			d.findElement(By.xpath("//div[@class='user_profile_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Blocked Websites - Header components are not present");}
		if(a==true){test.pass("Content - Blocked Websites -  Header components are present");}
	}
  	
  	@Test
	public void a3_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Blocked websites - Info text ","Checking for the information text ");
  		boolean a=true;
		try{d.findElement(By.xpath("//p[text()='Mobicip by default blocks inappropriate websites which are unsafe for children.']"));
			d.findElement(By.xpath("//p[text()='Settings will not apply to Mobicip preset schedules.']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Blocked Websites - Info texts are not present");}
		if(a==true){test.pass("Content - Blocked Websites - Info texts are present");}
	}
  	
  	@Test
	public void a4_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Blocked Web - Text Box Components","Checking for the add button and info text");
  		boolean a=true;
		try{d.findElement(By.xpath("//input[@name='websiteName']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Blocked Websites - Text Box is not present");}
		if(a==true){test.pass("Content - Blocked Websites - Text Box is present");}
		
		a=true;
		try{d.findElement(By.xpath("//button[@class='link_button add']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Blocked Websites - Text Box Add button is not present");}
		if(a==true){test.pass("Content - Blocked Websites - Text Box Add button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Use commas to add multiple websites. Example:']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Blocked Websites - Text Box info is not present");}
		if(a==true){test.pass("Content - Blocked Websites - Text Box info is present");}
	}
  
  	@Test
	public void a5_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("No Blocked websites - Icon and Text ","Checking for the icon and text when no websites are added. ");
  		boolean a=true;
  		try{d.findElement(By.xpath("//span[text()='No websites added']"));
  			d.findElement(By.xpath("//div[@class='no_data_container websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("No Blocked websites - Icon and Text is improper");}
		if(a==true){test.pass("No Blocked websites - Icon and Text is proper");}
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
  
  	@Test
  	public void a6_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Blocked websites - Validation check ","Checking the input field with multiple inputs - Check if the websites are accepted or error is thrown");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("nytimes.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='nytimes.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper website is not added");}
  		if(a==true){test.pass("Proper website is added properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("123.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='123.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper website is not added");}
  		if(a==true){test.pass("Proper website is added properly");}
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is added");}
  		if(a==true){test.pass("Improper website is not added");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

  		 // We're sorry, but something went wrong (500) 
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("!@#abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - !@#abcd.com");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		a=true;
  		try{d.findElement(By.xpath("//span[text()=\"We're sorry, but something went wrong (500)\"]"));}
  		catch(NoSuchElementException e) {a=false;
  		test.pass("Proper Error message is displayed,properly validated ");}
  		if(a==true){test.fail("Proper Error message isn't displayed, Not properly validated - !@#abcd.com");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("hi#$jim.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - hi#$jim.com");}
  		if(a==true){test.pass("Error Message shown is properly shown - hi#$jim.com");}
  	
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("123...com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website -  123...com");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("123.com.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.pass("Error Message shown is not shown - Web added - Invalid Website - 123.com.com");}
  		if(a==true){test.fail("Error Message shown is shown - 123.com.com");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd.com,abcd.com,abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Duplicate Urls Exist']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicates website are added");}
  		if(a==true){test.pass("Duplicates website are not added");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd.com,,abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is not added");}
  		if(a==true){test.pass("Improper website is added ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd.com,");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is not added");}
  		if(a==true){test.pass("Improper website is added ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("!@#.com, abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is not added");}
  		if(a==true){test.pass("Improper website is added ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

	}
  	
  	@Test
 	public void a7_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Blocked websites - Duplicate website check","Checking if able to add a website that is already added");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("nytimes.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//p[text()=' already added.']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicate websites added");}
  		if(a==true){test.pass("Duplicate websites are not added - Pop-up displayed.");}
  		d.findElement(By.xpath("//button[text()='Okay']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
 	
  	@Test
 	public void a8_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Blocking an allowed website","Checking if able to block an allowed website");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("allowed.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//p[text()='. Do you want to ']"));
  			d.findElement(By.xpath("//div[text()='No']"));
  			d.findElement(By.xpath("//button[text()='Yes']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Pop up not displayed - Blocking an allowed website");}
  		if(a==true){test.pass("Pop up properly displayed - Blocking an allowed website");}
  		
  		d.findElement(By.xpath("//div[text()='No']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='allowed.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.pass("Click on No button - Not Blocked an allowed website");}
  		if(a==true){test.fail("Click on No button - Blocked an allowed website");}
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("allowed.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//button[text()='Yes']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='allowed.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Unable to Block an allowed website");}
  		if(a==true){test.pass("Able to Block an allowed website");}
	}
  	
	@Test
 	public void a9_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Deleting websites","Checking if able to delete a website");
  		boolean a=true;
  		JavascriptExecutor j= (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//delete one website
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='nytimes.com']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='1']"));
  			d.findElement(By.xpath("//span[text()='website']"));
  			d.findElement(By.xpath("//span[text()=' selected']"));
  			d.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("One website selected - not displayed properly");}
  		if(a==true){test.pass("One website selected - displayed properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//div[text()='Delete '  and text()='1' and text()='blocked' and text()='website' and text()='?']"));
			d.findElement(By.xpath("//div[text()='No']"));
			d.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("One website Delete - Popup - not displayed properly");}
		if(a==true){test.pass("One website Delete - Popup - displayed properly");}
			
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='nytimes.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("One website Delete - deleted properly");}
		if(a==true){test.fail("One website Delete not deleted properly");}
		
		a=true;
  		
		//Delete more than one website
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='123.com.com']/preceding::label[1]")).click();
  		d.findElement(By.xpath("//span[text()='123.com']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='2']"));
  			d.findElement(By.xpath("//span[text()='websites']"));
  			d.findElement(By.xpath("//span[text()=' selected']"));
  			d.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("More than One Websites selected - not displayed properly");}
  		if(a==true){test.pass("More than One websites selected - displayed properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//div[text()='Delete '  and text()='2' and text()='blocked' and text()='websites' and text()='?']"));
			d.findElement(By.xpath("//div[text()='No']"));
			d.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("More than One Websites Delete - Popup - not displayed properly");}
		if(a==true){test.pass("More than One Websites Delete - Popup - displayed properly");}
		
		d.findElement(By.xpath("//button[text()='Yes']")).click(); 		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='123.com.com']"));
			d.findElement(By.xpath("//span[text()='123.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One Websites Delete - deleted properly");}
		if(a==true){test.fail("More than One Websites Delete not deleted properly");}
		
		//Delete All websites
		a=true;
  		d.findElement(By.xpath("//span[text()='allowed.com']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='all_website_checked']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='2']"));
  			d.findElement(By.xpath("//span[text()='websites']"));
  			d.findElement(By.xpath("//span[text()=' selected']"));
  			d.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("All Websites selected - not displayed properly");}
  		if(a==true){test.pass("All websites selected - displayed properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//div[text()='Delete '  and text()='2' and text()='blocked' and text()='websites' and text()='?']"));
			d.findElement(By.xpath("//div[text()='No']"));
			d.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("More than One Websites Delete - Popup - not displayed properly - add properly 3 websites/ becoxzz of abc...com");}
		if(a==true){test.pass("More than One Websites Delete - Popup - displayed properly");}
		
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
		try{d.findElement(By.xpath("//span[text()='allowed.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One Websites Delete - deleted properly");}
		if(a==true){test.fail("More than One Websites Delete not deleted properly");}
	}
	
	@Test
 	public void b0_ContentBlockedWeb()
	{
  		ExtentTest test=extentreport.createTest("Blocked websites - Go back and visit again","Checking if the changes are retained when visited again");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("allowed.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
  		d.findElement(By.xpath("//span[text()='Blocked Websites']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		try{d.findElement(By.xpath("//span[text()='allowed.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("The changes are not retained when visited again");}
		if(a==true){test.pass("The changes are retained when visited again");}
  		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,300)");
  	}
	
	@Test
	public void b1_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Content - Allowed Web ","To check the Content > Allowed Website Option is placed and opened properly");
		//--- Content - Allowed Web ---
		boolean a=true;
		try{d.findElement(By.xpath("//span[text()='Allowed Websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Allowed Websites option is not present in dashboard");}
		if(a==true){test.pass("Content - Allowed Websites option is present in dashboard");}
		d.findElement(By.xpath("//span[text()='Allowed Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=d.getTitle();
		System.out.println(tit);
		if(tit.equals("Allowed Websites | Content Monitoring | Mobicip"))
		{test.pass("Allowed websites - Title is correct  ");}
		else{test.fail("Allowed websites - Title isn't correct ");}
	}
  	
  	@Test
	public void b2_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Content - Allowed Web - Header components ","Checking the components of the header");
  		boolean a=true;
		try{d.findElement(By.xpath("//a[@class='logo']"));
			d.findElement(By.xpath("//span[@id='headerBack']"));
			d.findElement(By.xpath("//div[@title='ch1']/div[@class='profile_image_container']"));
			d.findElement(By.xpath("//p[text()='Allowed Websites']"));
			d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			d.findElement(By.xpath("//div[@class='user_profile_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Allowed Websites - Header components are not present");}
		if(a==true){test.pass("Content - Allowed Websites -  Header components are present");}
	}
  	
  	@Test
	public void b3_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Allowed websites - Info text ","Checking for the information text ");
  		boolean a=true;
		try{d.findElement(By.xpath("//p[text()='The websites listed below will not be blocked by Mobicip.']"));
			d.findElement(By.xpath("//p[text()='Settings will not apply to Mobicip preset schedules.']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Allowed Websites - Info texts are not present");}
		if(a==true){test.pass("Content - Allowed Websites - Info texts are present");}
	}
  	
  	@Test
	public void b4_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Allowed Web - Text Box Components","Checking for the add button and info text");
  		boolean a=true;
		try{d.findElement(By.xpath("//input[@name='websiteName']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Allowed Websites - Text Box is not present");}
		if(a==true){test.pass("Content - Allowed Websites - Text Box is present");}
		
		a=true;
		try{d.findElement(By.xpath("//button[@class='link_button add']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Allowed Websites - Text Box Add button is not present");}
		if(a==true){test.pass("Content - Allowed Websites - Text Box Add button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Use commas to add multiple websites. Example:']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Allowed Websites - Text Box info is not present");}
		if(a==true){test.pass("Content - Allowed Websites - Text Box info is present");}
	}
  
  	@Test
	public void b5_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("No Allowed websites - Icon and Text ","Checking for the icon and text when no websites are added. ");
  		boolean a=true;
  		try{d.findElement(By.xpath("//span[text()='No websites added']"));
  			d.findElement(By.xpath("//div[@class='no_data_container websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("No Allowed websites - Icon and Text is improper");}
		if(a==true){test.pass("No Allowed websites - Icon and Text is proper");}
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
  
  	@Test
  	public void b6_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Allowed websites - Validation check ","Checking the input field with multiple inputs - Check if the websites are accepted or error is thrown");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("nytimes.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='nytimes.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper website is not added");}
  		if(a==true){test.pass("Proper website is added properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("123.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='123.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper website is not added");}
  		if(a==true){test.pass("Proper website is added properly");}
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is added");}
  		if(a==true){test.pass("Improper website is not added");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

  		 // We're sorry, but something went wrong (500) 
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("!@#abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		a=true;
  		try{d.findElement(By.xpath("//span[text()=\"We're sorry, but something went wrong (500)\"]"));}
  		catch(NoSuchElementException e) {a=false;
  		test.pass("Proper Error message is displayed,properly validated ");}
  		if(a==true){test.fail("Proper Error message isn't displayed, Not properly validated ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("hi#$jim.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper website is not added");}
  		if(a==true){test.pass("hi#$jim.com  website is not added properly");}
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("123...com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("123.com.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();

  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd.com,abcd.com,abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Duplicate Urls Exist']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicates website are added");}
  		if(a==true){test.pass("Duplicates website are not added");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd.com,,abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is not added");}
  		if(a==true){test.pass("Improper website is added ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("abcd.com,");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is not added");}
  		if(a==true){test.pass("Improper website is added ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("!@#.com, abcd.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='Invalid url: Enter a valid url']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper website is not added");}
  		if(a==true){test.pass("Improper website is added ");}
  		d.findElement(By.xpath("//input[@name='websiteName']")).clear();
	}
  	
  	@Test
 	public void b7_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Allowed websites - Duplicate website check","Checking if able to add a website that is already added");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("nytimes.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//p[text()=' already added.']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicate websites added");}
  		if(a==true){test.pass("Duplicate websites are not added - Pop-up displayed.");}
  		d.findElement(By.xpath("//button[text()='Okay']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
 	                        
  	@Test
 	public void b8_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Allowing an blocked website","Checking if able to block an allowed website");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("allowed.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//p[text()='. Do you want to ']"));
  			d.findElement(By.xpath("//div[text()='No']"));
  			d.findElement(By.xpath("//button[text()='Yes']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Pop up not displayed - Allowing an blocked website");}
  		if(a==true){test.pass("Pop up properly displayed - Allowing an blocked website");}
  		
  		d.findElement(By.xpath("//div[text()='No']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='allowed.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.pass("Click on No button - Not allowed an Blocked website");}
  		if(a==true){test.fail("Click on No button - allowed an Blocked website");}
  		
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("allowed.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//button[text()='Yes']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='allowed.com']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Unable to allow an blocked website");}
  		if(a==true){test.pass("Able to allow an blocked website");}
	}

  	@Test
 	public void b9_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Whitelist mode - Components check","Checking for the components in Whitelist mode");
  		boolean a=true;
  		try{d.findElement(By.xpath("//span[text()='Whitelist only mode']"));
			d.findElement(By.xpath("//p[text()='Enabling will allow ONLY the websites added here']"));
			d.findElement(By.xpath("//label[@class='toggle_switch']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("the components in Whitelist mode are not present ");}
		if(a==true){test.pass("the components in Whitelist mode are present ");}
	}
  	
  	@Test
 	public void c0_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Whitelist mode - Toggle","Enable and Disable toggle buttons");
  		boolean a=true;
  		d.findElement(By.xpath("//label[@class='toggle_switch']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//p[text()='Enabling whitelist only mode will allow ONLY the sites added here. All other sites will be blocked.']"));
			d.findElement(By.xpath("//div[text()='Cancel']"));
			d.findElement(By.xpath("//button[text()='Continue']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Pop up for Whitelist mode is not opened.");}
		if(a==true){test.pass("Pop up for Whitelist mode is opened.");}
		d.findElement(By.xpath("//button[text()='Continue']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}	
	}
  	
  	@Test
 	public void c1_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Deleting websites","Checking if able to delete a website");
  		boolean a=true;
  		JavascriptExecutor j= (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//delete one website
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='nytimes.com']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='1']"));
  			d.findElement(By.xpath("//span[text()='website']"));
  			d.findElement(By.xpath("//span[text()=' selected']"));
  			d.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("One website selected - not displayed properly");}
  		if(a==true){test.pass("One website selected - displayed properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//div[text()='Delete '  and text()='1' and text()='allowed' and text()='website' and text()='?']"));
			d.findElement(By.xpath("//div[text()='No']"));
			d.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("One website Delete - Popup - not displayed properly");}
		if(a==true){test.pass("One website Delete - Popup - displayed properly");}
			
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='nytimes.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("One website Delete - deleted properly");}
		if(a==true){test.fail("One website Delete not deleted properly");}
		
		a=true;
  		
		//Delete more than one website
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='123.com.com']/preceding::label[1]")).click();
  		d.findElement(By.xpath("//span[text()='123.com']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='2']"));
  			d.findElement(By.xpath("//span[text()='websites']"));
  			d.findElement(By.xpath("//span[text()=' selected']"));
  			d.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("More than One Websites selected - not displayed properly");}
  		if(a==true){test.pass("More than One websites selected - displayed properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//div[text()='Delete '  and text()='2' and text()='allowed' and text()='websites' and text()='?']"));
			d.findElement(By.xpath("//div[text()='No']"));
			d.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("More than One Websites Delete - Popup - not displayed properly");}
		if(a==true){test.pass("More than One Websites Delete - Popup - displayed properly");}
		
		d.findElement(By.xpath("//button[text()='Yes']")).click(); 		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='123.com.com']"));
			d.findElement(By.xpath("//span[text()='123.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One Websites Delete - deleted properly");}
		if(a==true){test.fail("More than One Websites Delete not deleted properly");}
		
		//Delete All websites
		a=true;
  		d.findElement(By.xpath("//span[text()='allowed.com']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='all_website_checked']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//span[text()='2']"));
  			d.findElement(By.xpath("//span[text()='websites']"));
  			d.findElement(By.xpath("//span[text()=' selected']"));
  			d.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("All Websites selected - not displayed properly");}
  		if(a==true){test.pass("All websites selected - displayed properly");}
  		
  		a=true;
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//div[text()='Delete '  and text()='2' and text()='allowed' and text()='websites' and text()='?']"));
			d.findElement(By.xpath("//div[text()='No']"));
			d.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("More than One Websites Delete - Popup - not displayed properly - add properly 3 websites/ becoxzz of abc...com");}
		if(a==true){test.pass("More than One Websites Delete - Popup - displayed properly");}
		
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
		try{d.findElement(By.xpath("//span[text()='allowed.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One Websites Delete - deleted properly");}
		if(a==true){test.fail("More than One Websites Delete not deleted properly");}
	}
	
  	@Test
 	public void c2_ContentAllowedWeb()
	{
  		ExtentTest test=extentreport.createTest("Allowed websites - Go back and visit again","Checking if the changes are retained when visited again");
  		boolean a=true;
  		d.findElement(By.xpath("//input[@name='websiteName']")).sendKeys("allowed.com");
  		d.findElement(By.xpath("//button[@class='link_button add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
  		d.findElement(By.xpath("//span[text()='Allowed Websites']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		try{d.findElement(By.xpath("//span[text()='allowed.com']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("The changes are not retained when visited again");}
		if(a==true){test.pass("The changes are retained when visited again");}
  		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		
		// redirect to dashboard
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  	}

  	@AfterClass
	public void teardown()
    {
    	extentreport.flush();
//    	d.quit();
    }
}