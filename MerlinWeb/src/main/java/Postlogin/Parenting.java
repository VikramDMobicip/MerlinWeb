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

public class Parenting extends baseClass {
	
//	WebDriver d;
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeSuite
    public void beforeTest() 
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestParenting\\reportParenting.html");
		extentreport.attachReporter(spark);
    }
	
    //Checking for the title of home page and Parenting page
	@Test(priority=1)
	public void a1_homepage()
	{
  		ExtentTest test=extentreport.createTest("Homepage","Checking the title of the Parenting page ");
  		
		//---Dash board---
		String tit=d.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test.pass("Dashboard - title is correct ");}
		else{test.fail("Dashboard - title isn't correct ");}
		boolean a=true;
		try {d.findElement(By.xpath("//p[text()='Hello Vikram!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Dashboard - Header was Incorrect");}
		if(a==true){test.pass("Dashboard - Header was correct");}
			
		//---Parenting---
		d.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Parenting']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		
		//---Validation - Parenting ---
		//Title
		tit=d.getTitle();
		if(tit.equals("Parenting Advice | Mobicip"))
		{test.pass("Parenting - page opened and title is correct ");}
		else{test.fail("Parenting - title isn't correct ");}
    }
	
	//Checking the header components 
  	@Test(priority=2)
	public void a2_ParentingHeader() {
  		ExtentTest test2=extentreport.createTest("Parenting - Header","Checking the header components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Mobicip logo is not found");}
		if(a==true) {test2.pass("Mobicip logo is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Back button is not found");}
		if(a==true) {test2.pass("Back button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Parenting Advice']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Parenting Advice -  Header is incorrect");}
		if(a==true) {test2.pass("Parenting Advice - Header is correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Profile icon is not present");}
		if(a==true) {test2.pass("Profile icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[@class='help_icon']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Help icon is not present");}
		if(a==true) {test2.pass("Help icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Notification icon is not present");}
		if(a==true) {test2.pass("Notification icon is present");}
	}
  	
	//Checking the Blog components 
  	@Test(priority=3)
	public void a3_Blogs() {
  		ExtentTest test3=extentreport.createTest("Blogs","Checking the Blogs");
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='From our Blog']"));
  		d.findElement(By.xpath("//div[@class='content_container parenting_component']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Blogs section is not present");}
		if(a==true) {test3.pass("Blogs section is present");}
  	}
  	
    //Checking the Dangerous Apps components 
  	@Test(priority=4)
	public void a4_DangerousApps() {
  		ExtentTest test4=extentreport.createTest("Dangerous Apps","Checking the Dangerous Apps components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='Dangerous apps']"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Dangerous Apps section is not present");}
		if(a==true) {test4.pass("Dangerous Apps section is present");}
		d.findElement(By.xpath("//p[text()='Dangerous apps']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

		a = true;
  		try{d.findElement(By.xpath("//p[text()='Dangerous apps']"));
  		d.findElement(By.xpath("//p[text()='Omegle']"));
  		d.findElement(By.xpath("//a[contains(@href,'parents-need-know-about-omegle')]"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("omegle section is not present");}
		if(a==true) {test4.pass("omegle section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Yubo']"));
  		d.findElement(By.xpath("//a[contains(@href,'parents-need-know-about-yubo-tinder-teens-app')]"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("yubo section is not present");}
		if(a==true) {test4.pass("yubo section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Finsta']"));
  		d.findElement(By.xpath("//a[contains(@href,'rise-what-should-you-do-about-it')]"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("Finsta section is not present");}
		if(a==true) {test4.pass("Finsta section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Unsafe apps']"));
  		d.findElement(By.xpath("//a[contains(@href,'these-apps-are-not-your-kids')]"));}
		catch(NoSuchElementException e){a=false;
		test4.fail("Finsta section is not present");}
		if(a==true) {test4.pass("Finsta section is present");}
		
		d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  	}
  	
  	 //Checking the Apps for Education components 
  	@Test(priority=5)
	public void a5_AppsforEducation() {
  		ExtentTest test5=extentreport.createTest("Apps for Education","Checking the Apps for Education components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='Apps for education']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Apps for Education section is not present");}
		if(a==true) {test5.pass("Apps for Education section is present");}
		d.findElement(By.xpath("//p[text()='Apps for education']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

		a = true;
  		try{d.findElement(By.xpath("//p[text()='Apps for education']"));
  		d.findElement(By.xpath("//p[text()='Websites']"));
  		d.findElement(By.xpath("//a[contains(@href,'kids-websites-educational')]"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Websites section is not present");}
		if(a==true) {test5.pass("Websites section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Email services']"));
  		d.findElement(By.xpath("//a[contains(@href,'email-for-kids')]"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Email services section is not present");}
		if(a==true) {test5.pass("Email services section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Educational apps']"));
  		d.findElement(By.xpath("//a[contains(@href,'top-10-educational-apps-kids')]"));}
		catch(NoSuchElementException e){a=false;
		test5.fail("Educational apps section is not present");}
		if(a==true) {test5.pass("Educational apps section is present");}
		
		d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  	}
	
  	//Checking the Trending amongst teens
  	@Test(priority=6)
	public void a6_Trendingamongstteens(){
  		ExtentTest test6=extentreport.createTest("Trending amongst teens","Checking the Trending amongst teens components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='Trending amongst teens']"));}
		catch(NoSuchElementException e){a=false;
		test6.fail("Trending amongst teens section is not present");}
		if(a==true) {test6.pass("Trending amongst teens section is present");}
		d.findElement(By.xpath("//p[text()='Trending amongst teens']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

		a = true;
  		try{d.findElement(By.xpath("//p[text()='Trending amongst teens']"));
  		d.findElement(By.xpath("//p[text()='Snapchat']"));
  		d.findElement(By.xpath("//a[contains(@href,'is-snapchat-safe')]"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Snapchat section is not present");}
		if(a==true) {test6.pass("Snapchat section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Poparazzi']"));
  		d.findElement(By.xpath("//a[contains(@href,'what-is-poparazzi')]"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Poparazzi section is not present");}
		if(a==true) {test6.pass("Poparazzi section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Marcopolo']"));
  		d.findElement(By.xpath("//a[contains(@href,'what-is-marco-polo-app')]"));}
		catch(NoSuchElementException e){a=false;
		test6.fail("Marcopolo section is not present");}
		if(a==true) {test6.pass("Marcopolo section is present");}
		
		d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  	}
 
	//Checking the Learn from our Experts
  	@Test(priority=7)
	public void a7_LearnfromourExperts(){
  		ExtentTest test7=extentreport.createTest("Learn from our Experts","Checking the Learn from our Experts components");
  		boolean a = true;
  		
  		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{d.findElement(By.xpath("//p[text()='Learn from our Experts']"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Learn from our Experts is not present");}
		if(a==true) {test7.pass("Learn from our Experts is present");}

		a = true;
  		try{d.findElement(By.xpath("//p[text()='Diana Graber']"));
  		d.findElement(By.xpath("//p[text()='Digital Parenting Expert']"));
  		d.findElement(By.xpath("//span[text()='Free Digital Citizenship Course']"));
  		d.findElement(By.xpath("//a[contains(@href,'free-digital-citizenship-course')]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Digital Citizenship Course section is not present");}
		if(a==true) {test7.pass("Digital Citizenship Course section is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Cyberwise Chats']"));
  		d.findElement(By.xpath("//a[contains(@href,'cyberwisechats')]"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Cyberwise Chats section is not present");}
		if(a==true) {test7.pass("Cyberwise Chats section is present");}
  	}
  	
	//Checking the Help
  	@Test(priority=8)
	public void a8_Help(){
  		ExtentTest test8=extentreport.createTest("Help","Checking the Help");
     	boolean a = true;
     	try{d.findElement(By.xpath("//a[text()='Looking for help on a specific topic?']"));
  		d.findElement(By.xpath("//a[@href='/blog']"));} 
		catch(NoSuchElementException e){a=false;
		test8.fail("Help is not present");}
		if(a==true) {test8.pass("Help is present");}
  	}
  	
    //Checking the Social media
  	@Test(priority=9)
	public void a9_Help(){
  		ExtentTest test9=extentreport.createTest("Follow on Social media","Checking the Follow on Social media ");
     	boolean a = true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
     	try{d.findElement(By.xpath("//p[text()='Follow our Social Media Pages']"));
  		d.findElement(By.xpath("//a[@href='/blog']"));} 
		catch(NoSuchElementException e){a=false;
		test9.fail("Follow our Social Media text is not present");}
		if(a==true) {test9.pass("Follow our Social Media text is present");}
		
		a = true;
     	try{d.findElement(By.xpath("//a[@class='facebook']"));
  		d.findElement(By.xpath("//a[@href='https://www.facebook.com/mobicip']"));} 
		catch(NoSuchElementException e){a=false;
		test9.fail("Facebook is not present");}
		if(a==true) {test9.pass("Facebook text is present");}
		
		a = true;
     	try{d.findElement(By.xpath("//a[@class='twitter']"));
  		d.findElement(By.xpath("//a[@href='https://www.twitter.com/mobicip']"));} 
		catch(NoSuchElementException e){a=false;
		test9.fail("Twitter is not present");}
		if(a==true) {test9.pass("Twitter text is present");}
		
		a = true;
     	try{d.findElement(By.xpath("//a[@class='linkedin']"));
  		d.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/mobicip']"));} 
		catch(NoSuchElementException e){a=false;
		test9.fail("Linkedin is not present");}
		if(a==true) {test9.pass("Linkedin text is present");}
		
		a = true;
     	try{d.findElement(By.xpath("//a[@class='instagram']"));
  		d.findElement(By.xpath("//a[@href='https://www.instagram.com/mobicip_family']"));} 
		catch(NoSuchElementException e){a=false;
		test9.fail("instagram is not present");}
		if(a==true) {test9.pass("Linkedin text is present");}
  	}
  	
    //Checking the Social media
  	@Test(priority=10)
	public void a10_GotoDashboard(){
  		ExtentTest test10=extentreport.createTest("Return to dashboard","Returning to dashboard");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		String tit=d.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test10.pass("Dashboard - title is correct ");}
		else{test10.fail("Dashboard - title isn't correct ");}
  	}
  	
  	@AfterSuite
    public void teardown() 
    {
//  		d.quit();
    	extentreport.flush();
    }
  	
}