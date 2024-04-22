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

public class WebCateDuplicate extends baseClass{

	//Report setup
//	WebDriver d;
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestCategoryDuplicate\\reportContentCategoryDupli.html");
		extentreport.attachReporter(spark);
	}
		
	@Test
	public void a1_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Contents ","To check the Content web page");
	  	
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
//		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();    
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
		j.executeScript("window.scrollBy(0,600)");
	}
	
	@Test
	public void a2_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Contents - Category & Duplicate  ","To check the Content >  Category Option is placed and opened properly");
		boolean a= true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//a[@class='logo']"));
			d.findElement(By.xpath("//p[text()='Content']"));
			d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			d.findElement(By.xpath("//div[@class='user_profile_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Contents - Header components are not present");}
		if(a==true){test.pass("Contents -  Header components are present");}
	}
	
	@Test
	public void a3_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Contents - Website options","Checking for all the options in websites and if they have a right arrow at the right end. Also checking for duplicate settings option");
		boolean a= true;
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Web Categories']/following-sibling::span[@class='icon_right_arrow']"));
			d.findElement(By.xpath("//span[text()='Allowed Websites']/following-sibling::span[@class='icon_right_arrow']"));
			d.findElement(By.xpath("//span[text()='Blocked Websites']/following-sibling::span[@class='icon_right_arrow']"));
			d.findElement(By.xpath("//span[text()='Networks']/following-sibling::span[@class='icon_right_arrow']"));
			d.findElement(By.xpath("//span[text()='Keywords and Phrases']/following-sibling::span[@class='icon_right_arrow']"));
			d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Contents - all the options in websites are not present");}
		if(a==true){test.pass("Contents - all the options in websites are present");}
	}
	
	@Test
	public void a4_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Contents - Monitor only","Checking for the info text for Monitor only child");
		boolean a= true;
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,-300)");
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Jerry']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[text()='You cannot change web settings as Jerry is in Monitor only mode.']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Contents - info text for Monitor only child are not present");}
		if(a==true){test.pass("Contents - info text for Monitor only child are present");}
		d.findElement(By.xpath("//p[@title='ch1']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
	public void a5_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Web categories - Title and header components","Checking the title and components of the header");
		//title
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		d.findElement(By.xpath("//span[text()='Web Categories']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=d.getTitle();
		if(tit.equals("Web Categories | Content Monitoring | Mobicip"))
		{test.pass("Web Categories - title is correct ");}
		else{test.fail("Web Categories - title isn't correct ");}
		//Header components
		boolean a= true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//a[@class='logo']"));
			d.findElement(By.xpath("//p[text()='Web Categories']"));
			d.findElement(By.xpath("//span[@id='headerBack']"));
			d.findElement(By.xpath("//div[@title='ch1']/div[@class='profile_image_container']"));
			d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			d.findElement(By.xpath("//div[@class='user_profile_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Contents - Header components are not present");}
		if(a==true){test.pass("Contents -  Header components are present");}
	}
	
	@Test
	public void a6_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Web categories - Info text and sample icon","Checking for the information text and sample icon");
		boolean a=true;
  		try{d.findElement(By.xpath("//p[text()=\"Mobicip by default blocks certain web categories based on child's age.\"]"));
  			d.findElement(By.xpath("//p[text()='Settings will not apply to Mobicip preset schedules.']"));
  			d.findElement(By.xpath("//p[@class='blocked_label']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Web categories - Info texts are not present");}
  		if(a==true){test.pass("Content - Web categories - Info texts are present");}
  	}
	
	@Test
	public void a7_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Web categories - Categories","Checking for all the categories and the toggle buttons");
		JavascriptExecutor j = (JavascriptExecutor)d;
		//Ads and Marketing
		boolean a= true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']"));
			d.findElement(By.xpath("//span[text()='Ads and Marketing']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Ads and Marketing category is not present");}
		if(a==true){test.pass("Web categories  -  Ads and Marketing category are present");}
		//Alcohol and Addiction
		a= true;
		try{d.findElement(By.xpath("//span[text()='Alcohol and Addiction']"));
			d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Alcohol and Addiction category is not present");}
		if(a==true){test.pass("Web categories  -  Alcohol and Addiction category are present");}
		//Dating
		a= true;
		try{d.findElement(By.xpath("//span[text()='Dating']"));
			d.findElement(By.xpath("//span[text()='Dating']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Dating category is not present");}
		if(a==true){test.pass("Web categories  - Dating category are present");}
		//Entertainment
		a= true;
		try{d.findElement(By.xpath("//span[text()='Entertainment']"));
			d.findElement(By.xpath("//span[text()='Entertainment']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Entertainment category is not present");}
		if(a==true){test.pass("Web categories  - Entertainment category are present");}
		//Gambling
		a= true;
		try{d.findElement(By.xpath("//span[text()='Gambling']"));
			d.findElement(By.xpath("//span[text()='Gambling']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Gambling category is not present");}
		if(a==true){test.pass("Web categories  - Gambling category are present");}
		j.executeScript("window.scrollBy(0,325)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Games
		a= true;
		try{d.findElement(By.xpath("//span[text()='Games']"));
			d.findElement(By.xpath("//span[text()='Games']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Games category is not present");}
		if(a==true){test.pass("Web categories  - Games category are present");}
		//Government and Society
		a= true;
		try{d.findElement(By.xpath("//span[text()='Government and Society']"));
			d.findElement(By.xpath("//span[text()='Government and Society']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Government and Society category is not present");}
		if(a==true){test.pass("Web categories  - Government and Society category are present");}
		//Health
		a= true;
		try{d.findElement(By.xpath("//span[text()='Health']"));
			d.findElement(By.xpath("//span[text()='Health']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Health category is not present");}
		if(a==true){test.pass("Web categories  - Health category are present");}
		//Lifestyle
		a= true;
		try{d.findElement(By.xpath("//span[text()='Lifestyle']"));
			d.findElement(By.xpath("//span[text()='Lifestyle']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Lifestyle category is not present");}
		if(a==true){test.pass("Web categories  - Lifestyle category are present");}
		//Mature and Adult
		a= true;
		try{d.findElement(By.xpath("//span[text()='Mature and Adult']"));
			d.findElement(By.xpath("//span[text()='Mature and Adult']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Mature and Adult category is not present");}
		if(a==true){test.pass("Web categories  - Mature and Adult category are present");}
		j.executeScript("window.scrollBy(0,350)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//News
		a= true;
		try{d.findElement(By.xpath("//span[text()='News']"));
			d.findElement(By.xpath("//span[text()='News']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - News category is not present");}
		if(a==true){test.pass("Web categories  - News category are present");}
		//Proxies
		a= true;
		try{d.findElement(By.xpath("//span[text()='Proxies']"));
			d.findElement(By.xpath("//span[text()='Proxies']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Proxies category is not present");}
		if(a==true){test.pass("Web categories  - Proxies category are present");}
		//Shopping
		a= true;
		try{d.findElement(By.xpath("//span[text()='Shopping']"));
			d.findElement(By.xpath("//span[text()='Shopping']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Shopping category is not present");}
		if(a==true){test.pass("Web categories  - Shopping category are present");}
		//Social
		a= true;
		try{d.findElement(By.xpath("//span[text()='Social']"));
			d.findElement(By.xpath("//span[text()='Social']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Social category is not present");}
		if(a==true){test.pass("Web categories  - Social category are present");}
		//Sports
		a= true;
		try{d.findElement(By.xpath("//span[text()='Sports']"));
			d.findElement(By.xpath("//span[text()='Sports']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Sports category is not present");}
		if(a==true){test.pass("Web categories  - Sports category are present");}
		j.executeScript("window.scrollBy(0,400)");
		//Utilities
		a= true;
		try{d.findElement(By.xpath("//span[text()='Utilities']"));
			d.findElement(By.xpath("//span[text()='Utilities']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Utilities category is not present");}
		if(a==true){test.pass("Web categories  - Utilities category are present");}
		//Weapons and Violence
		a= true;
		try{d.findElement(By.xpath("//span[text()='Weapons and Violence']"));
			d.findElement(By.xpath("//span[text()='Weapons and Violence']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Weapons and Violence category is not present");}
		if(a==true){test.pass("Web categories  - Weapons and Violence category are present");}
		//YouTube
		a= true;
		try{d.findElement(By.xpath("//span[text()='YouTube']"));
			d.findElement(By.xpath("//span[text()='YouTube']/following-sibling::div[@class='toggle_switch_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - YouTube category is not present");}
		if(a==true){test.pass("Web categories  - YouTube category are present");}
	}
	
	//Make it ch1 child - category alcohol and addiction , Dating , Gambling - blocked ; Others are allowed
	@Test
	public void a8_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Web categories - Toggle buttons","Enabling and disabling the toggle buttons");
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		//Ads and Marketing
		boolean a= true;
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Ads and Marketing category is not clickable");}
		if(a==true){test.pass("Web categories  -  Ads and Marketing category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Alcohol and Addiction
		a= true;
		try{d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Alcohol and Addiction category is not clickable");}
		if(a==true){test.pass("Web categories  -  Alcohol and Addiction category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Dating
		a= true;
		try{d.findElement(By.xpath("//span[text()='Dating']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Dating category is not clickable");}
		if(a==true){test.pass("Web categories  - Dating category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Entertainment
		a= true;
		try{d.findElement(By.xpath("//span[text()='Entertainment']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Entertainment category is not clickable");}
		if(a==true){test.pass("Web categories  - Entertainment category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Gambling
		a= true;
		try{d.findElement(By.xpath("//span[text()='Gambling']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Gambling category is not clickable");}
		if(a==true){test.pass("Web categories  - Gambling category is clickable");}
		j.executeScript("window.scrollBy(0,325)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Games
		a= true;
		try{d.findElement(By.xpath("//span[text()='Games']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Games category is not clickable");}
		if(a==true){test.pass("Web categories  - Games category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Government and Society
		a= true;
		try{d.findElement(By.xpath("//span[text()='Government and Society']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Government and Society category is not clickable");}
		if(a==true){test.pass("Web categories  - Government and Society category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Health
		a= true;
		try{d.findElement(By.xpath("//span[text()='Health']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Health category is not clickable");}
		if(a==true){test.pass("Web categories  - Health category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Lifestyle
		a= true;
		try{d.findElement(By.xpath("//span[text()='Lifestyle']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Lifestyle category is not clickable");}
		if(a==true){test.pass("Web categories  - Lifestyle category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Mature and Adult
		a= true;
		try{d.findElement(By.xpath("//span[text()='Mature and Adult']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Mature and Adult category is not clickable");}
		if(a==true){test.pass("Web categories  - Mature and Adult category is clickable");}
		j.executeScript("window.scrollBy(0,350)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//News
		a= true;
		try{d.findElement(By.xpath("//span[text()='News']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - News category is not clickable");}
		if(a==true){test.pass("Web categories  - News category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Proxies
		a= true;
		try{d.findElement(By.xpath("//span[text()='Proxies']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Proxies category is not clickable");}
		if(a==true){test.pass("Web categories  - Proxies category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Shopping
		a= true;
		try{d.findElement(By.xpath("//span[text()='Shopping']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Shopping category is not clickable");}
		if(a==true){test.pass("Web categories  - Shopping category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Social
		a= true;
		try{d.findElement(By.xpath("//span[text()='Social']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Social category is not clickable");}
		if(a==true){test.pass("Web categories  - Social category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Sports
		a= true;
		try{d.findElement(By.xpath("//span[text()='Sports']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Sports category is not clickable");}
		if(a==true){test.pass("Web categories  - Sports category is clickable");}
		j.executeScript("window.scrollBy(0,400)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Utilities
		a= true;
		try{d.findElement(By.xpath("//span[text()='Utilities']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Utilities category is not clickable");}
		if(a==true){test.pass("Web categories  - Utilities category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Weapons and Violence
		a= true;
		try{d.findElement(By.xpath("//span[text()='Weapons and Violence']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Weapons and Violence category is not clickable");}
		if(a==true){test.pass("Web categories  - Weapons and Violence category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//YouTube
		a= true;
		try{d.findElement(By.xpath("//span[text()='YouTube']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - YouTube category is not clickable");}
		if(a==true){test.pass("Web categories  - YouTube category is clickable");}
		
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		j.executeScript("window.scrollBy(0,-1500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Ads and Marketing
		a= true;
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Ads and Marketing category is not clickable");}
		if(a==true){test.pass("Web categories  -  Ads and Marketing category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Alcohol and Addiction
		a= true;
		try{d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Alcohol and Addiction category is not clickable");}
		if(a==true){test.pass("Web categories  -  Alcohol and Addiction category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Dating
		a= true;
		try{d.findElement(By.xpath("//span[text()='Dating']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Dating category is not clickable");}
		if(a==true){test.pass("Web categories  - Dating category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Entertainment
		a= true;
		try{d.findElement(By.xpath("//span[text()='Entertainment']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Entertainment category is not clickable");}
		if(a==true){test.pass("Web categories  - Entertainment category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Gambling
		a= true;
		try{d.findElement(By.xpath("//span[text()='Gambling']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Gambling category is not clickable");}
		if(a==true){test.pass("Web categories  - Gambling category is clickable");}
		j.executeScript("window.scrollBy(0,325)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Games
		a= true;
		try{d.findElement(By.xpath("//span[text()='Games']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Games category is not clickable");}
		if(a==true){test.pass("Web categories  - Games category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Government and Society
		a= true;
		try{d.findElement(By.xpath("//span[text()='Government and Society']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Government and Society category is not clickable");}
		if(a==true){test.pass("Web categories  - Government and Society category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Health
		a= true;
		try{d.findElement(By.xpath("//span[text()='Health']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Health category is not clickable");}
		if(a==true){test.pass("Web categories  - Health category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Lifestyle
		a= true;
		try{d.findElement(By.xpath("//span[text()='Lifestyle']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Lifestyle category is not clickable");}
		if(a==true){test.pass("Web categories  - Lifestyle category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Mature and Adult
		a= true;
		try{d.findElement(By.xpath("//span[text()='Mature and Adult']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Mature and Adult category is not clickable");}
		if(a==true){test.pass("Web categories  - Mature and Adult category is clickable");}
		j.executeScript("window.scrollBy(0,350)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//News
		a= true;
		try{d.findElement(By.xpath("//span[text()='News']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - News category is not clickable");}
		if(a==true){test.pass("Web categories  - News category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Proxies
		a= true;
		try{d.findElement(By.xpath("//span[text()='Proxies']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Proxies category is not clickable");}
		if(a==true){test.pass("Web categories  - Proxies category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Shopping
		a= true;
		try{d.findElement(By.xpath("//span[text()='Shopping']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Shopping category is not clickable");}
		if(a==true){test.pass("Web categories  - Shopping category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Social
		a= true;
		try{d.findElement(By.xpath("//span[text()='Social']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Social category is not clickable");}
		if(a==true){test.pass("Web categories  - Social category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Sports
		a= true;
		try{d.findElement(By.xpath("//span[text()='Sports']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Sports category is not clickable");}
		if(a==true){test.pass("Web categories  - Sports category is clickable");}
		j.executeScript("window.scrollBy(0,400)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Utilities
		a= true;
		try{d.findElement(By.xpath("//span[text()='Utilities']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Utilities category is not clickable");}
		if(a==true){test.pass("Web categories  - Utilities category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Weapons and Violence
		a= true;
		try{d.findElement(By.xpath("//span[text()='Weapons and Violence']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - Weapons and Violence category is not clickable");}
		if(a==true){test.pass("Web categories  - Weapons and Violence category is clickable");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//YouTube
		a= true;
		try{d.findElement(By.xpath("//span[text()='YouTube']/following::label[1]")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Web categories  - YouTube category is not clickable");}
		if(a==true){test.pass("Web categories  - YouTube category is clickable");}
	}
	
	//Make it ch1 child - category alcohol and addiction , Dating , Gambling - blocked ; Others are allowed 
	@Test
	public void a9_ContentWebCategory()
	{
		ExtentTest test=extentreport.createTest("Web categories -  Go back and visit again","Checking if the changes retained when visited again");
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		//Changing the status of Ads and Marketing   & Alcohol and Addiction
		boolean a= true;
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::input[@id='category_toggle_500' and @checked]"));
			d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::input[@id='category_toggle_501' and not(@checked)]"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Situation is not expected");}
		if(a==true){test.pass("Situation is expected");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		
		d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.navigate().refresh();   
		// it is must to refresh once we clicked on toggle button, then only it will get changed in xpath
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::input[@id='category_toggle_500' and not(@checked)]"));
			d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::input[@id='category_toggle_501' and @checked]"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Properly status of both categories are not changed");}
		if(a==true){test.pass("Properly status of both categories are changed");}
		
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Web Categories']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::input[@id='category_toggle_500' and not(@checked)]"));
		d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::input[@id='category_toggle_501' and @checked]"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Properly status of both categories are not changed after revisiting");}
		if(a==true){test.pass("Properly status of both categories are changed after revisiting");}
		
		d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.navigate().refresh();   
		// it is must to refresh once we clicked on toggle button, then only it will get changed in xpath
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		// redirect to dashboard
		d.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
	public void b1_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Contents - Duplicate  ","Verify if clicking on Duplicate app settings to other children option, Duplicate App settings page is loaded.");
		boolean a= true;
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Content']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Websites']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,700)");
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=d.getTitle();
		if(tit.equals("Duplicate Settings"))
		{test.pass("Duplicate Settings - title is correct ");}
		else{test.fail("Duplicate Settings - title isn't correct ");}
		//Header components
		a= true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//a[@class='logo']"));
			d.findElement(By.xpath("//p[text()='Duplicate Settings']"));
			d.findElement(By.xpath("//span[@id='headerBack']"));
			d.findElement(By.xpath("//div[@title='DuplicateAuto']/div[@class='profile_image_container']"));
			d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			d.findElement(By.xpath("//div[@class='user_profile_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Header components are not present");}
		if(a==true){test.pass("Duplicate Settings -  Header components are present");}
	}
	
	@Test
	public void b2_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate settings - Components","Verify if Duplicate App settings page has the components");
		boolean a= true;
		try{d.findElement(By.xpath("//p[text()='Select Child User']"));
			d.findElement(By.xpath("//span[text()='MAM Automation']"));
			d.findElement(By.xpath("//span[text()='Emulator']"));
			d.findElement(By.xpath("//span[text()='windows']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - All MAM children are not displayed");}
		if(a==true){test.pass("Duplicate Settings - All MAM children are displayed");}	
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,600)");
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}	
		//specific options
		a= true;
		try{d.findElement(By.xpath("//input[@value='Allowed Websites']/following-sibling::label[1]"));
			d.findElement(By.xpath("//input[@value='Blocked Websites']/following-sibling::label[1]"));
			d.findElement(By.xpath("//input[@value='Keywords and Phrases']/following-sibling::label[1]"));
			d.findElement(By.xpath("//input[@value='Networks']/following-sibling::label[1]"));
			d.findElement(By.xpath("//input[@value='Web Categories']/following-sibling::label[1]"));
			d.findElement(By.xpath("//p[text()='Allowed Websites']"));
			d.findElement(By.xpath("//p[text()='Keywords and Phrases']"));
			d.findElement(By.xpath("//p[text()='Networks']"));
			d.findElement(By.xpath("//p[text()='Web Categories']"));
			d.findElement(By.xpath("//p[text()='Blocked Websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - All specific options are are not displayed");}
		if(a==true){test.pass("Duplicate Settings - All specific options are are displayed");}		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//All options
		a= true;
		try{d.findElement(By.xpath("//input[@id='check_all']/following-sibling::label[1]"));
			d.findElement(By.xpath("//p[text()='Duplicate all settings']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Duplicate all  option is not displayed");}
		if(a==true){test.pass("Duplicate Settings - Duplicate all  option is displayed");}	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Save button
		a= true;
		try{d.findElement(By.xpath("//button[text()='Save']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Save button is not displayed");}
		if(a==true){test.pass("Duplicate Settings - Save button  is displayed");}	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	@Test
	public void b3_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate settings - MAM Child Duplicate","Verify if the list has all the manage and monitor child users in the account.");
		boolean a= true;
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,-600)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[text()='Select Child User']"));
			d.findElement(By.xpath("//span[text()='MAM Automation']"));
			d.findElement(By.xpath("//span[text()='Emulator']"));
			d.findElement(By.xpath("//span[text()='windows']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - All Moniter MAM children are not displayed");}
		if(a==true){test.pass("Duplicate Settings - All MAM children are displayed");}	
	}
	@Test
	public void b4_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate settings - MO Child Not Duplicate","Verify if the list doesn't show any monitor only child profile in the account.");
		boolean a= true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Jerry']"));
			d.findElement(By.xpath("//span[text()='MO Automation']"));}
		catch(NoSuchElementException e) {a=false;
		test.pass("Duplicate Settings - All MO children are not displayed");}
		if(a==true){test.fail("Duplicate Settings - MO children are displayed");}
	}
	//MAM Automation child should not have any restriction and 
	//DuplicateAuto child has Allowed - icc.in , 
	//Blocked web -  cricbuzz.com , 
	//Web cate - first three blocked , 
	//phrase - box office , 
	//networks, 1.2.3.4 , 1.1.1.1/255.0.0.0
	//allowed web duplicate
	@Test
	public void b5_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate Single option - Allowed web","Verify if able to duplicate the selected single settings to the child profiles selected.  - Allowed web");
		boolean a= true;
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		d.findElement(By.xpath("//input[@value='Allowed Websites']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Allowed websites alone is not applied");}
		if(a==true){test.pass("Duplicate Settings - Allowed websites alone is applied");}
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Allowed Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='icc.in']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Allowed websites alone is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Allowed websites alone is duplicated properly");}
		d.findElement(By.xpath("//span[text()='icc.in']/preceding::label[1]")). click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
	}
	//Blocked websites duplicate
	@Test
	public void b6_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate Single option - Blocked web","Verify if able to duplicate the selected single settings to the child profiles selected.  - Blocked web");
		boolean a= true;
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@value='Blocked Websites']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Blocked websites alone is not applied");}
		if(a==true){test.pass("Duplicate Settings - Blocked websites alone is applied");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Blocked Websites']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='cricbuzz.com']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Blocked websites alone is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Blocked websites alone is duplicated properly");}
		d.findElement(By.xpath("//span[text()='cricbuzz.com']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	//Web categories duplicate
	@Test
	public void b7_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate Single option - Web category","Verify if able to duplicate the selected single settings to the child profiles selected.  - Web category");
		boolean a= true;
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,600)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@value='Web Categories']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Web Categories alone is not applied");}
		if(a==true){test.pass("Duplicate Settings - Web Categories alone is applied");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Web Categories']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::input[@id='category_toggle_500' and not(@checked)]"));
			d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::input[@id='category_toggle_501' and not(@checked)]"));
			d.findElement(By.xpath("//span[text()='Entertainment']/following::input[@id='category_toggle_509' and @checked]"));
			d.findElement(By.xpath("//span[text()='Dating']/following::input[@id='category_toggle_506' and not(@checked)]"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Web Categories alone is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Web Categories alone is duplicated properly");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::label[1]")).click();	
		d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::label[1]")).click();	
		d.findElement(By.xpath("//span[text()='Dating']/following::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	//Networks duplicate
	@Test
	public void b8_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate Single option - Networks","Verify if able to duplicate the selected single settings to the child profiles selected.  - Networks");
		boolean a= true;
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@value='Networks']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Networks alone is not applied");}
		if(a==true){test.pass("Duplicate Settings - Networks alone is applied");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Networks']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Single IP address']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='IP Address Range']")).click();
		a=true;
		try{d.findElement(By.xpath("//div[text()='1.2.3.4']"));
			d.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.0.0.0']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Networks alone is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Networks alone is duplicated properly");}
		d.findElement(By.xpath("//div[text()='1.2.3.4']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.0.0.0']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	//Phrases duplicate
	@Test
	public void b9_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate Single option - Networks","Verify if able to duplicate the selected single settings to the child profiles selected.  - Networks");
		boolean a= true;
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@value='Keywords and Phrases']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Phrases alone is not applied");}
		if(a==true){test.pass("Duplicate Settings - Phrases alone is applied");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Keywords and Phrases']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='box office']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Phrases alone is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Phrases alone is duplicated properly");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='box office']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	//All duplicate
	@Test
	public void c0_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate All option","Verify if able to duplicate the selected All settings to the child profiles selected.");
		boolean a= true;
//				d.findElement(By.xpath("//span[@id='headerBack']")).click();
//				try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,600)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,400)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@name='check_all']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Duplicate All option is not applied");}
		if(a==true){test.pass("Duplicate Settings - Duplicate All option is applied");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//checking Blocked website
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Blocked Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='cricbuzz.com']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Blocked websites - Duplicate All is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Blocked websites - Duplicate All is duplicated properly");}
		d.findElement(By.xpath("//span[text()='cricbuzz.com']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//checking Allowed websites
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Allowed Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='icc.in']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Allowed websites - Duplicate All is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Allowed websites - Duplicate All is duplicated properly");}
		d.findElement(By.xpath("//span[text()='icc.in']/preceding::label[1]")). click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//Checking Web Categories
		JavascriptExecutor j5 = (JavascriptExecutor)d;
		j5.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Web Categories']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::input[@id='category_toggle_500' and not(@checked)]"));
			d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::input[@id='category_toggle_501' and not(@checked)]"));
			d.findElement(By.xpath("//span[text()='Entertainment']/following::input[@id='category_toggle_509' and @checked]"));
			d.findElement(By.xpath("//span[text()='Dating']/following::input[@id='category_toggle_506' and not(@checked)]"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Web Categories - Duplicate All is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Web Categories - Duplicate All is duplicated properly");}
		d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::label[1]")).click();	
		d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::label[1]")).click();	
		d.findElement(By.xpath("//span[text()='Dating']/following::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//Checking Networks
		JavascriptExecutor j6 = (JavascriptExecutor)d;
		j6.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Networks']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Single IP address']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='IP Address Range']")).click();
		a=true;
		try{d.findElement(By.xpath("//div[text()='1.2.3.4']"));
			d.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.0.0.0']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Networks - Duplicate All is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Networks - Duplicate All is duplicated properly");}
		d.findElement(By.xpath("//div[text()='1.2.3.4']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.0.0.0']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//Checking Phrases
		JavascriptExecutor j4 = (JavascriptExecutor)d;
		j4.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Keywords and Phrases']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='box office']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Phrases - Duplicate All is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Phrases - Duplicate All is duplicated properly");}
		d.findElement(By.xpath("//span[text()='box office']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click(); 		
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
	}
	//Couple of Options duplicate
	@Test
	public void c1_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Duplicate couple of Options","Verify if able to duplicate the selected All settings to the child profiles selected.");
		boolean a= true;
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,600)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@value='Keywords and Phrases']/following-sibling::label[1]")).click();
		d.findElement(By.xpath("//input[@value='Blocked Websites']/following-sibling::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//button[text()='Save']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Duplicate couple of options is not applied");}
		if(a==true){test.pass("Duplicate Settings - Duplicate couple of options is applied");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='MAM Automation']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,300)");
		//checking Blocked website
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Blocked Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='cricbuzz.com']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Blocked websites - Duplicate couple of options is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Blocked websites - Duplicate couple of options is duplicated properly");}
		d.findElement(By.xpath("//span[text()='cricbuzz.com']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//checking Allowed websites
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Allowed Websites']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='No websites added']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Allowed websites - Duplicate couple of options is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Allowed websites - Duplicate couple of options is duplicated properly");}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//Checking Web Categories
		JavascriptExecutor j5 = (JavascriptExecutor)d;
		j5.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Web Categories']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Ads and Marketing']/following::input[@id='category_toggle_500' and @checked]"));
			d.findElement(By.xpath("//span[text()='Alcohol and Addiction']/following::input[@id='category_toggle_501' and @checked]"));
			d.findElement(By.xpath("//span[text()='Entertainment']/following::input[@id='category_toggle_509' and @checked]"));
			d.findElement(By.xpath("//span[text()='Dating']/following::input[@id='category_toggle_506' and @checked]"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Web Categories - Duplicate  couple of options is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Web Categories - Duplicate  couple of options is duplicated properly");}
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//Checking Networks
		JavascriptExecutor j6 = (JavascriptExecutor)d;
		j6.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Networks']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Single IP address']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='IP Address Range']")).click();
		a=true;
		try{d.findElement(By.xpath("//span[text()='No network added']/following::span[text()='No network added']"));
			d.findElement(By.xpath("//span[text()='No network added']/preceding::span[text()='No network added']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Networks - Duplicate couple of options is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Networks - Duplicate  couple of options is duplicated properly");}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		//Checking Phrases
		JavascriptExecutor j4 = (JavascriptExecutor)d;
		j4.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Keywords and Phrases']")).click();
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='box office']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Phrases - Duplicate couple of options is not duplicated properly");}
		if(a==true){test.pass("Duplicate Settings - Phrases - Duplicate couple of options is duplicated properly");}
		d.findElement(By.xpath("//span[text()='box office']/preceding::label[1]")).click();	
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,-500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='DuplicateAuto']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
	}
	
	@Test
	public void c2_ContentWebDuplicate()
	{
		ExtentTest test=extentreport.createTest("Required field  while not selecting","Verify if unable to duplicate the settings to the child profiles not selected.");
		boolean a= true;
		//Not select both optionss
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Save']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Required field is not asking while not selecting the child profile to duplicate");}
		if(a==true){test.pass("Required field is asking while not selecting the child profile to duplicate");}
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,400)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//p[text()='Duplicate all settings']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Required field is not asking while not selecting the settings to duplicate");}
		if(a==true){test.pass("Required field is asking while not selecting the settings to duplicate");}
		//Not select the settings
		d.findElement(By.xpath("//button[text()='Save']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//p[text()='Duplicate all settings']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Required field is not asking while not selecting the settings alone to duplicate");}
		if(a==true){test.pass("Required field is asking while not selecting the settings alone to duplicate");}
		j1.executeScript("window.scrollBy(0,-400)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//not selecting child - select all settings
		d.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		j1.executeScript("window.scrollBy(0,400)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@name='check_all']/following-sibling::label[1]")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Save']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Required field is not asking while not selecting the child profile alone to duplicate -  select all settings");}
		if(a==true){test.pass("Required field is asking while not selecting the child profile alone to duplicate -  select all settings");}
		d.findElement(By.xpath("//input[@name='check_all']/following-sibling::label[1]")).click();
		//not selecting child - select some settings
		d.findElement(By.xpath("//input[@name='check_all']/following-sibling::label[1]")).click();
		d.findElement(By.xpath("//input[@value='Keywords and Phrases']/following-sibling::label[1]")).click();
		d.findElement(By.xpath("//input[@value='Blocked Websites']/following-sibling::label[1]")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Save']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Required field is not asking while not selecting the child profile alone to duplicate -  select some settings");}
		if(a==true){test.pass("Required field is asking while not selecting the child profile alone to duplicate -  select some settings");}		 		
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