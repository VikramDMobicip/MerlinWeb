package Postlogin;
import java.time.Duration;
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

//Please check the website to check whether its staging or Live
//Staging : https://www.webs.prgr.in   Live : https://www.mobicip.com


public class DropALine{
	
	WebDriver d;
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeSuite
    public void beforeTest() 
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PostloginTest\\TestDropUsALine\\reportDropUsALine.html");
		extentreport.attachReporter(spark);
    }
	
    //Checking for the title of home page and support page
	@Test(priority=1)
	public void homepage()
	{
  		ExtentTest test=extentreport.createTest("Homepage","Checking the title of the Support page ");
  		System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver-win64_122\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		d=new ChromeDriver(options);
		
	    try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	    
	    d.manage().window().maximize();
	    
	    d.get("https://www.mobicip.com");
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Support' and @class='header_nav_anchor']")));
    
		String tit = d.getTitle();
	    if(tit.equals("Best Parental Control App for Busy Parents | Mobicip"))
	    {test.pass("Homepage title is correct");}
	    else{test.fail("Homepage title is incorrect");}
	    //support page
	    try {TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e) {e.printStackTrace();}
	    d.findElement(By.xpath("//a[text()='Support' and @class='header_nav_anchor']")).click();
	    try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
	    tit=d.getTitle();
	    if(tit.equals("Customer Support - Articles, Tutorials & FAQs | Mobicip"))
	    {test.pass("Support page title is correct");}
	    else{test.fail("Support page title is incorrect");}
    }
	
	//Scrolling down till "Still have questions"
  	@Test(priority=2)
	public void scroll() {
  		ExtentTest test2=extentreport.createTest("Scroll","Scrolling down till \"Still have questions\"");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,550)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		test2.pass("Scrolled down till drop us line");
	}
  	
	//Checking the heading "Still have questions?"
	@Test(priority=3)
	public void stillhavequestions() 
	{
		boolean a=true;
		ExtentTest test3=extentreport.createTest("Still have questions","Scrolling down till 'Still have questions'");
		try {d.findElement(By.xpath("//h2[text()='Still Have Questions?']"));}
		catch(NoSuchElementException e){a=false;
			test3.fail("Still have questions? text is present");}
		if(a==true){test3.pass("Still have questions? text is not present");}
	}
	
	//Checking whether drop us a line is clickable or not
	@Test(priority=4)
	public void Dropusaline() {
		ExtentTest test4=extentreport.createTest("Drop us a line","Checking whether drop us a line is clickable or not");
		boolean a=true;
		try{d.findElement(By.xpath("//span[text()='Drop us a line']")).click();}
		catch(NoSuchElementException e){a=false;
			test4.fail("Drop us a line element not found");}
		if(a==true) { test4.pass("Drop us a line option is clickable");}
	}
	
	//Checking whether select question label is present or not
	@Test(priority=5)
	public void selectquestion() {
		ExtentTest test5=extentreport.createTest("Select question");
		boolean a=true;
		try{d.findElement(By.xpath("//p[text()='Select Question']"));}
		catch(NoSuchElementException e){a=false;
			test5.fail("Select question label not found");}
		if(a==true){test5.pass("Select question label is present");}
	}
	
	//Checking for every option and the questions below it
	@Test(priority=6)
	public void settingupmobicip() {
		ExtentTest test6=extentreport.createTest("Setting up Mobicip","Checking for every option and the questions below it");
		boolean a=true;
		try{Select s = new Select(d.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Setting Up Mobicip");}
		catch(NoSuchElementException e){a=false;
			test6.fail("Setting Up Mobicip Element not found");}
		if(a==true){test6.pass("Setting Up Mobicip Element is found");}	
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='Mobicip parental controls setup - iPhone/iPad']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question Mobicip parental controls setup - iPhone/iPad not found");}
		if(a==true){test6.pass("Question Mobicip parental controls setup - iPhone/iPad is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='New to Mobicip? Get Started!']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question New to Mobicip? Get Started! is not found");}
		if(a==true){test6.pass("Question New to Mobicip? Get Started! is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
	}
	
	@Test(priority=7)
	public void requestinformation() {
		ExtentTest test6=extentreport.createTest("Request Information","Checking the option - Request information");
		boolean a=true;
		try{Select s = new Select(d.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Request Information");}
		catch(NoSuchElementException e){a=false;
			test6.fail("Request Information Element not found");}
		if(a==true){test6.pass("Request Information Element is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='Does Mobicip offer a free trial?']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question Does Mobicip offer a free trial? not found");}
		if(a==true){test6.pass("Question Does Mobicip offer a free trial? is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='Will Mobicip monitor Text Messages?']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question Will Mobicip monitor Text Messages? not found");}
		if(a==true){test6.pass(" Question Will Mobicip monitor Text Messages? is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
	}
	
	@Test(priority=8)
	public void featurenotworking() {
		ExtentTest test6=extentreport.createTest("Feature Not Working","Checking the option - Feature not working");
		boolean a=true;
		try{Select s = new Select(d.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Feature Not Working");}
		catch(NoSuchElementException e){a=false;
			test6.fail("Feature Not Working Element not found");}
		if(a==true){test6.pass("Feature Not Working Element is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='Why is Snapchat monitoring not available for iOS devices?']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question Why is Snapchat monitoring not available for iOS devices?  not found");}
		if(a==true){test6.pass("Question Why is Snapchat monitoring not available for iOS devices?  is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
	}
	
	
	@Test(priority=9)
	public void cancelsubscription() {
		ExtentTest test6=extentreport.createTest("Cancel My Subscription","Checking the option - Cancel My Subscription");
		boolean a=true;
		try{Select s = new Select(d.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Cancel Plan");}
		catch(NoSuchElementException e){a=false;
			test6.fail("Cancel My plan Element not found");}
		if(a==true){test6.pass("Cancel My plan Element is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
//		a=true;
//		try{d.findElement(By.xpath("//a[text()='How do I cancel my subscription?']"));}
//		catch(NoSuchElementException e){a=false;
//			test6.fail("Question How do I cancel my subscription? not found");}
//		if(a==true){test6.pass("Question How do I cancel my subscription? is found");}
//		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();} 
	}
	
	@Test(priority=10)
	public void Other() {
		ExtentTest test6=extentreport.createTest("Other","Checking the option - Other");
		boolean a=true;
		try{Select s = new Select(d.findElement(By.xpath("//p[text()='Select Question']/following::select")));
			s.selectByVisibleText("Other");}
		catch(NoSuchElementException e){a=false;
			test6.fail("Other Element not found");}
		if(a==true){test6.pass("Other Element is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();}
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='Will Mobicip work in Incognito/Private mode?']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question Will Mobicip work in Incognito/Private mode? not found");}
		if(a==true){test6.pass("Question Will Mobicip work in Incognito/Private mode? is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();} 
		
		a=true;
		try{d.findElement(By.xpath("//a[text()='Why is my customized setting not working on my child device?']"));}
		catch(NoSuchElementException e){a=false;
			test6.fail("Question Why is my customized setting not working on my child device? not found");}
		if(a==true){test6.pass("Question Why is my customized setting not working on my child device? is found");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();} 
	}
	
	//Scrolling till drop us a message text
	@Test(priority=11)
	public void scroll2() {
  		ExtentTest test11=extentreport.createTest("Scroll","Scrolling till drop us a message text");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,390)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		try{d.findElement(By.xpath("//p[text()='Drop us a message']"));}
		catch(NoSuchElementException e){a=false;
			test11.fail("Scrolled down isn't properly");}
		if(a==true){test11.pass("Scrolled down is properly");}
		try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e) {e.printStackTrace();} 
	}
	
	//Checking for Drop us a message text
	@Test(priority=12)
	public void dropusamessage() {
		ExtentTest test12=extentreport.createTest("Drop us a message","Checking for Drop us a message text");
		boolean a=true;
		try{d.findElement(By.xpath("//p[text()='Drop us a message']"));}
		catch(NoSuchElementException e){a=false;
			test12.fail("Drop us a message label not found");}
		if(a==true){test12.pass("Drop us a message label is present");}
	}
	
	//Checking for empty fields and its alert
	@Test(priority=13)
	public void emptyfields(){
		ExtentTest test13=extentreport.createTest("Empty field","Checking for empty fields and its alert");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-350)", "");
		boolean a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{ 
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][3]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Required Field'][4]"));} 
		catch(NoSuchElementException e){a=false;
			test13.fail("Alert is not thrown for empty fields");}
		if(a==true){test13.pass("Alert - Required field is properly shown");}
	}
	
	//Checking for blank spaces and its alert
	@Test(priority=14)
	public void blankspaces(){
		ExtentTest test14=extentreport.createTest("Blank space","Checking for blank spaces and its alert");
		boolean a=true;
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::input[1]")).sendKeys("     ");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::input[2]")).sendKeys("     ");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::input[3]")).sendKeys("     ");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::input[4]")).sendKeys("     ");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::input[5]")).sendKeys("     ");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::input[6]")).sendKeys("     ");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//p[text()='Drop us a message']/following::textarea[1]")).sendKeys("     ");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][5]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][1]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][2]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][3]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only blank space(s) not accepted'][4]"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Invalid Email: Enter a valid email address']"));
			d.findElement(By.xpath("//p[text()='Drop us a message']/following::span[text()='Only numeric value accepted']"));} 
		catch(NoSuchElementException e){a=false;
			test14.fail("Alert is not shown for blank spaces");}
		if(a==true){test14.pass("Alert is shown for blank spaces");}
	}
	
	//Checking for Name Validations
	@Test(priority=15)
	public void name() {
		ExtentTest test15=extentreport.createTest("Name Validation","Checking for Name Validations");
		boolean a=true;
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_name']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_name']")).sendKeys("vikram!@#");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-350)", "");
		try{TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"))  ;} 
		catch(NoSuchElementException e){a=false;
			test15.fail("No alert shown for vikram!@#");}
		if(a==true){test15.pass("Name - vikram!@#, Alert - Alphanumeric characters and -_(), only accepted ");}

		a=true;
		d.findElement(By.xpath("//input[@id='contact_name']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_name']")).sendKeys("vikram123");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse1= (JavascriptExecutor) d;
		jse1.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"))  ;} 
		catch(NoSuchElementException e){a=false;
			test15.pass("No alert shown for vikram123");}
		if(a==true){test15.fail("Name - vikram123, Alert - Alphanumeric characters and -_(), only accepted ");}
		
		a=true;
		d.findElement(By.xpath("//input[@id='contact_name']")).clear();
		d.findElement(By.xpath("//input[@id='contact_name']")).sendKeys("Vikram-_()");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse2= (JavascriptExecutor) d;
		jse2.executeScript("window.scrollBy(0,-350)", "");
		try{TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"))  ;} 
		catch(NoSuchElementException e){a=false;
			test15.pass("No alert shown for Vikram-_()");}
		if(a==true){test15.fail("Name - Vikram-_(), Alert - Alphanumeric characters and -_(), only accepted ");}
	}
	
	//Checking for Email Validations
	@Test(priority=16)
	public void email() {
		ExtentTest test16=extentreport.createTest("Email Validation","Checking for Email Validations");
		boolean a=true;
		d.findElement(By.xpath("//input[@id='contact_email']")).clear();
		d.findElement(By.xpath("//input[@id='contact_email']")).sendKeys("vikram+!@#@mobicip.com");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test16.fail("No alert shown for vikram+!@#@mobicip.com");}
		if(a==true){test16.pass("Email - vikram+!@#@mobicip.com, Alert - Invalid Email: Enter a valid email address");}

		a=true;
		d.findElement(By.xpath("//input[@id='contact_email']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_email']")).sendKeys("@mobicip.com");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse1= (JavascriptExecutor) d;
		jse1.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));} 
		catch(NoSuchElementException e){a=false;
		test16.fail("No alert shown for @mobicip.com");}
		if(a==true){test16.pass("Email - @mobicip.com, Alert - Invalid Email: Enter a valid email address");}

		a=true;
		d.findElement(By.xpath("//input[@id='contact_email']")).clear();
		d.findElement(By.xpath("//input[@id='contact_email']")).sendKeys("vikram+1@mobicip.com");
		jse1.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse2= (JavascriptExecutor) d;
		jse2.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"))  ;} 
		catch(NoSuchElementException e){a=false;
			test16.pass("No alert shown for vikram+1@mobicip.com");}
		if(a==true){test16.fail("Email - vikram+1@mobicip.com, Alert - Invalid Email: Enter a valid email address");}	
	}
	
	//Checking for Phone number Validations
	@Test(priority=17)
	public void phone() {
		ExtentTest test17=extentreport.createTest("Phone Number Validation","Checking for Phone number Validations");
		boolean a=true;
		d.findElement(By.xpath("//input[@id='contact_phone']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("abcd");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Only numeric value accepted']"));} 
		catch(NoSuchElementException e){a=false;
			test17.fail("No alert shown for abcd");}
		if(a==true){test17.pass("Number - abcd, Alert - Only numeric value accepted");}

		a=true;
		d.findElement(By.xpath("//input[@id='contact_phone']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("123!@#");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse1= (JavascriptExecutor) d;
		jse1.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Only numeric value accepted']"));} 
		catch(NoSuchElementException e){a=false;
			test17.fail("No alert shown for abcd - 123!@#");}
		if(a==true){test17.pass("Number - 123!@#, Alert - Only numeric value accepted");}
		
		a=true;
		d.findElement(By.xpath("//input[@id='contact_phone']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("1234567890");
		jse1.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse2= (JavascriptExecutor) d;
		jse2.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Only numeric value accepted']"))  ;} 
		catch(NoSuchElementException e){a=false;
			test17.pass("No alert shown for 1234567890");}
		if(a==true){test17.fail("Number - 1234567890, Alert - Only numeric value accepted");}	
	}
	
	//Checking for Device name Validations
	@Test(priority=18)
	public void devicename() {
		ExtentTest test18=extentreport.createTest("Device Name Validation","Checking for Device name Validations");
		boolean a=true;
		d.findElement(By.xpath("//input[@id='contact_device']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_device']")).sendKeys("iPhone!@#");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test18.fail("No alert shown for iPhone!@#");}
		if(a==true){test18.pass("Name - iPhone!@#, Alert - Alphanumeric characters and -_(), only accepted");}
		
		a=true;
		d.findElement(By.xpath("//input[@id='contact_device']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_device']")).sendKeys("iPhone-13(Pro)");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse1= (JavascriptExecutor) d;
		jse1.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test18.pass("No alert shown for iPhone-13(Pro)");}
		if(a==true){test18.fail("Name - iPhone-13(Pro), Alert - Alphanumeric characters and -_(), only accepted");}
	}
	
	//Checking for OS version Validations
	@Test(priority=19)
	public void OSversion() {
		ExtentTest test19=extentreport.createTest("OS version Validation","Checking for OS version Validations");
		boolean a=true;
		d.findElement(By.xpath("//input[@id='contact_os']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_os']")).sendKeys("a12!@# ");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test19.fail("No alert shown for a12!@#");}
		if(a==true){test19.pass("Version - a12!@#, Alert - Alphanumeric characters and -_(), only accepted");}
		
		a=true;
		d.findElement(By.xpath("//input[@id='contact_os']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_os']")).sendKeys("15.5");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse1= (JavascriptExecutor) d;
		jse1.executeScript("window.scrollBy(0,-200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test19.pass("No alert shown for 15.5");}
		if(a==true){test19.fail("Version - 15.5, Alert - Alphanumeric characters and -_(), only accepted");}
	}
	
	//Checking for Child name Validations
	@Test(priority=20)
	public void childname() {
		ExtentTest test20=extentreport.createTest("Child Name Validation","Checking for Child name Validations");
		boolean a=true;
		d.findElement(By.xpath("//input[@id='contact_child_name']")).clear();
		d.findElement(By.xpath("//input[@id='contact_child_name']")).sendKeys("Marc!@#");
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		jse.executeScript("window.scrollBy(0,-200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test20.fail("No alert shown for Marc!@#");}
		if(a==true){test20.pass("Name - Marc!@#, Alert - Alphanumeric characters and -_(), only accepted ");}
		
		a=true;
		d.findElement(By.xpath("//input[@id='contact_child_name']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_child_name']")).sendKeys("Marc123");
		jse.executeScript("window.scrollBy(0,200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse1= (JavascriptExecutor) d;
		jse1.executeScript("window.scrollBy(0,-200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test20.pass("No alert shown for Marc123");}
		if(a==true){test20.fail("Name - Marc123, Alert - Alphanumeric characters and -_(), only accepted ");}
		
		a=true;
		d.findElement(By.xpath("//input[@id='contact_child_name']")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_child_name']")).sendKeys("Marc-(12)");
		jse1.executeScript("window.scrollBy(0,200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor jse2= (JavascriptExecutor) d;
		jse2.executeScript("window.scrollBy(0,-200)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test20.pass("No alert shown for Marc-(12)");}
		if(a==true){test20.fail("Name - Marc-(12), Alert - Alphanumeric characters and -_(), only accepted ");}
		jse2.executeScript("window.scrollBy(0,200)", "");
	}
	
	//Checking for Message Validations
	@Test(priority=21)
	public void message() {
		ExtentTest test21=extentreport.createTest("Message Validationand cancel button ","Checking for Message Validations and cancel button");
		boolean a=true;
		d.findElement(By.xpath("//textarea[@id='contact_message']")).clear();
		d.findElement(By.xpath("//div[text()='Cancel']")).click();
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//p[@class='backend_message success']"));} 
		catch(NoSuchElementException e){a=false;
		test21.pass("Form is not submitted while click on cancel button");	}
		if(a==true){test21.fail("Form submitted successfully while click on cancel button");}
		
		a=true;
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,-350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@id='contact_name']")).sendKeys("Vikram-_()");
		d.findElement(By.xpath("//input[@id='contact_email']")).sendKeys("vikram+1@mobicip.com");
		d.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("1234567890");
		d.findElement(By.xpath("//input[@id='contact_device']")).sendKeys("iPhone-13(Pro)");
		d.findElement(By.xpath("//input[@id='contact_os']")).sendKeys("15.5");
		d.findElement(By.xpath("//input[@id='contact_child_name']")).sendKeys("Marc-(12)");
		jse.executeScript("window.scrollBy(0,350)", "");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//textarea[@id='contact_message']")).sendKeys("QA Mobicip -Automation Testing ,Mobicip (pronounced mo-be-sip) is named after mobile CIPA. CIPA stands for Children's Internet Protection Act, a regulation by the US government that mandates secure internet access when provided by public schools or libraries. In the dark days before smartphones and tablets, the founders had a vision that learning is going to be transformed by ubiquitous always-on mobile technology in the hands of K-12 students. And so Mobicip was born, with a mission to create and foster the safe use of technology for learning and enrichment. A few million downloads, ten years, and petabytes of usage later, we believe the vision has come full circle as the world as we know it, and not just education, has been transformed. 123!@#$%^&*()_+,ncbjhskamx,cnbdjkasbcndhmxc jksdam,jksamakmsndjla,MSla,jsmxcnbvhfcjksmdncfhusk,mdjsla,zxmcjndkxm ncjcdm,zxnkcjskxamdsjkla,.d.sa;kmxc hjsdiskl,mxcnjhdskmjkmnjkdmnfdjkbfvhjdk333333333333333333333333333333333333333333333333333333333333333");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		try {TimeUnit.SECONDS.sleep(15);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Alphanumeric characters and -_(), only accepted']"));} 
		catch(NoSuchElementException e){a=false;
			test21.pass("Long message with special characters is accepted");}
		if(a==true){test21.fail("Long message is not accepted, Alert - Alphanumeric characters and -_(), only accepted ");}
	}
	
	//Checking whether the form is submitted successfully
	@Test(priority=22)
	public void submission() {
		ExtentTest test22=extentreport.createTest("Submission and message","Checking whether the form is submitted successfully");
		boolean a=true;
		JavascriptExecutor jse= (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,-100)", "");
		try{d.findElement(By.xpath("//p[@class='backend_message success']"));} 
		catch(NoSuchElementException e){a=false;
		test22.fail("Form is not submitted");	}
		if(a==true){test22.pass("Form submitted successfully");}
	}
	
  	@AfterSuite
    public void teardown() 
    {
  		d.quit();
    	extentreport.flush();
    }
 }