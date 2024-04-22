package Postlogin;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class addChild extends baseClass{
	//Report setup
//	WebDriver d;
	ExtentReports extentreport;
	ExtentSparkReporter spark;
	
	@BeforeClass
    public void beforeTest()
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestAddMember\\reportAddChild.html");
		extentreport.attachReporter(spark);}
	
	public void ClickwithDelay(WebDriver driver,String element)
	{	new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		d.findElement(By.xpath(element)).click();}
	
	public void waitTillLocate(WebDriver driver,String element) {
	new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));}

	@Test
	public void a1_myMobicip()
	{
  		ExtentTest test=extentreport.createTest("My Mobicip","To check the My Mobicip page");
  		
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
		
		//---My Mobicip page---
		ClickwithDelay(d,"//div[@class='user_profile_container']");
		ClickwithDelay(d,"//span[text()='My Mobicip']");
		waitTillLocate(d,"//p[text()='My Mobicip']");

		//---Validation - My Mobicip Page ---
		//Title
		tit=d.getTitle();
		if(tit.equals("My Mobicip | Mobicip")){test.pass("My Mobicip - title is correct  ");}
		else{test.fail("My Mobicip - title isn't correct ");}
		
		//Header Elements
		a=true;
		try {d.findElement(By.xpath("//p[text()='My Mobicip']"));
			 d.findElement(By.xpath("//span[@id='headerBack']"));
			 d.findElement(By.xpath("//a[@class='logo']"));
			 d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			 d.findElement(By.xpath("//div[@class='profile_image_container']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("My Mobicip - Header is incorrect");}
		if(a==true){test.pass("Dashboard - Header is correct");}
	}
  	
  	@Test
	public void a2_myFamily()
	{
  		ExtentTest test1=extentreport.createTest("My Family","To check the My Family page");
  		
  		//---My Family page---
		ClickwithDelay(d,"//span[text()='My Family']");
		waitTillLocate(d,"//p[text()='My Family']");

		//---Validation---
		//Title
		String tit=d.getTitle();
		if(tit.equals("My Family | Mobicip")){test1.pass("My Family - title is correct");}
		else{test1.fail("My Family - title isn't correct ");}
		
		//Header Elements
		boolean a=true;
		try {d.findElement(By.xpath("//p[text()='My Family']"));
			 d.findElement(By.xpath("//span[@id='headerBack']"));
			 d.findElement(By.xpath("//a[@class='logo']"));
			 d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			 d.findElement(By.xpath("//div[@class='profile_image_container']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("My Family - Header is incorrect");}
		if(a==true){test1.pass("My Family - Header is correct");}
		
		//Add Member Button
		a=true;
		waitTillLocate(d,"//a[@class='icon_add']");
		try {d.findElement(By.xpath("//a[@class='icon_add']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("My Family - Add member icon is present ");}
		if(a==true){test1.pass("My Family - Add member icon isn't present");}
	}
  	
  	@Test
  	public void a3_addChildPage()
	{
  		ExtentTest test2 = extentreport.createTest("Add Child page","To check that by default Add Child page get opened");
  		
  		//---Add Child page---
  		ClickwithDelay(d,"//a[@class='icon_add']");
  		waitTillLocate(d,"//label[text()='Birth Date']");

		//---Validation--- Checking that Add child open by default while clicking on Add button
		boolean a=true;
		try {d.findElement(By.xpath("//label[text()='Birth Date']"));
			 d.findElement(By.xpath("//span[text()='Monitor and Manage']"));
			 d.findElement(By.xpath("//span[text()='Monitor only']"));
			 d.findElement(By.xpath("//button[text()='Add']"));}
		catch(NoSuchElementException e){a=false;
		test2.fail("Add Child page - Not opened");}
		if(a==true){test2.pass("Add Child page - Opened by default");}
	}
		
	@Test	
	public void a4_addMemberHeader()
	{
		ExtentTest test3=extentreport.createTest("Add Member - Header","To check the header of Add Member ");
  		
		//---Validation---Header and Title---Add Child---
		//Title
		String tit=d.getTitle();
		if(tit.equals("Add Member | My Family | Mobicip")){test3.pass("Add Child page - title is correct  ");}
		else{test3.fail("Add Child page - title isn't correct ");}
		
		//Header Elements
  		waitTillLocate(d,"//p[text()='Add a Member']");
		boolean a=true;
		try {d.findElement(By.xpath("//p[text()='Add a Member']"));
			 d.findElement(By.xpath("//span[@id='headerBack']"));
			 d.findElement(By.xpath("//a[@class='logo']"));
			 d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			 d.findElement(By.xpath("//div[@class='profile_image_container']"));}
		catch(NoSuchElementException e){a=false;
		test3.fail("Add Child page - Header is incorrect");}
		if(a==true){test3.pass("Add Child page - Header is correct");}
		
		//---Navigate to Add Parent Page---
		ClickwithDelay(d,"//label[@for='add_member_parent']");
		waitTillLocate(d,"//p[text()='Add a Member']");
		
		//---Validation---Header and Title---Add Parent---
		//Title  		
		tit=d.getTitle();
		if(tit.equals("Add Member | My Family | Mobicip")){test3.pass("Add Parent page - title is correct  ");}
		else{test3.fail("Add Parent page - title isn't correct ");}
		
		//Header Elements
		a=true;
		try {d.findElement(By.xpath("//p[text()='Add a Member']"));
			 d.findElement(By.xpath("//span[@id='headerBack']"));
			 d.findElement(By.xpath("//a[@class='logo']"));
			 d.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			 d.findElement(By.xpath("//div[@class='profile_image_container']"));}
		catch(NoSuchElementException e){a=false;
		test3.fail("Add Parent page - Header is incorrect");}
		if(a==true){test3.pass("Add Parent page - Header is correct");}
	}
	
	@Test
	public void a5_childName(){
		ExtentTest test4=extentreport.createTest("Child Name","To check the Child Name");
  		
		//---Navigate to Add Child Page---
		ClickwithDelay(d,"//label[@for='add_member_child']");
		waitTillLocate(d,"//label[text()='Name']");
		
		//---Validation---Child Name---
		boolean a=true;
		try {d.findElement(By.xpath("//label[text()='Name']"));
			 d.findElement(By.xpath("//input[@type='text']"));
			 d.findElement(By.xpath("//input[@type='text']")).sendKeys("Childname");
			 d.findElement(By.xpath("//input[@type='text']")).clear();}
		catch(NoSuchElementException e){a=false;
		test4.fail("Add Child page - Child Name input is improper");}
		if(a==true){test4.pass("Add Child page - Child Name input is proper");}
	}
	
	@Test
	public void a6_dateOfBirth(){
		ExtentTest test5=extentreport.createTest("Child DOB","To check the Child DOB");
  				
		//---Validation---Child Dob---
		boolean a=true;
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[text()='Birth Date']");
		try {d.findElement(By.xpath("//label[text()='Birth Date']"));
		Select date =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("10");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		Select month =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("6");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		Select year =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2007");
		}
		catch(NoSuchElementException e){a=false;
		test5.fail("Add Child page - Child Name input is improper");}
		if(a==true){test5.pass("Add Child page - Child Name input is proper");}
	}
	
	@Test
	public void a7_typeOfChild(){
		ExtentTest test6=extentreport.createTest("Child Filter Level","To check the Child FILTER Type");
  				
		//---Validation---Filter Type---
		boolean a=true;
		try {d.findElement(By.xpath("//span[text()='Monitor and Manage']"));
		     d.findElement(By.xpath("//p[text()='Restrict content and screen time. Track app usage. Add schedules.']"));
		     d.findElement(By.xpath("//span[text()='Monitor only']"));
		     d.findElement(By.xpath("//p[text()='No restrictions. Track screen time usage and online activities.']"));
		     d.findElement(By.xpath("//label[@for='filter_monitor_and_manage']")).click();
		     d.findElement(By.xpath("//label[@for='filter_monitor']")).click();}
		catch(NoSuchElementException e){a=false;
		test6.fail("Add Child page - Filter Level input is improper");}
		if(a==true){test6.pass("Add Child page - Filter Level input is proper");}
	}
	
	@Test
	public void a8_requiredField(){		
		ExtentTest test7=extentreport.createTest("Child - Required Field","To check that unable to save without enough details");
		d.navigate().refresh();		
		boolean a=true;
		
		//---Validation---Required Field---
		//No DOB---No name---No Filter level
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//input[@type='text']/following::span[1]");
		try{d.findElement(By.xpath("//input[@type='text']/following::span[1]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[2]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[3]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[4]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[5]"));}
		catch(NoSuchElementException e){a=false;
		test7.fail("Add Child page - No DOB,No name,No Filter level - Not worked ");}
		if(a==true){test7.pass("Add Child page - No DOB,No name,No Filter level -  Worked ");}
		
		//No DOB---No Filter level--only name
		a=true;
		boolean b=false;
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/following::span[text()='Required Field'][4]");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test7.pass("Add Child page - No DOB, No Filter level -  Worked ");}
		else{test7.fail("Add Child page - No DOB, Filter level - Not worked ");}
		
		//No DOB---No Name---only Filter level
		a=true;
		b=false;
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//input[@type='text']/following::span[text()='Required Field'][4]");
		try{d.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][3]"));
			d.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][4]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//input[@type='text']/following::span[text()='Required Field'][5]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test7.pass("Add Child page - No DOB, No Name -  Worked ");}
		else{test7.fail("Add Child page - No DOB,No Name - Not worked ");}
		
		//No Filter level---No Name---Only DOB
		a=true;
		b=false;
		d.navigate().refresh();
		JavascriptExecutor j4 = (JavascriptExecutor)d;
		j4.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("10");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		Select month =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("6");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		Select year =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2007");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/following::span[text()='Required Field']");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field']"));
			d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test7.pass("Add Child page - No Filter level , No Name -  Worked ");}
		else{test7.fail("Add Child page - No Filter level ,No Name - Not worked ");}
		
		//No Name
		a=true;
		b=false;
		d.navigate().refresh();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date1 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date1.selectByValue("10");
		Select month1 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month1.selectByValue("6");
		Select year1 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year1.selectByValue("2007");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test7.pass("Add Child page - No Name -  Worked ");}
		else{test7.fail("Add Child page - No Name - Not worked ");}
		
		//No Filter level
		a=true;
		b=false;
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("10");
		Select month2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		Select year2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2007");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/following::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test7.pass("Add Child page - No filter level -  Worked ");}
		else{test7.fail("Add Child page - No filter level - Not worked ");}
		
		//No DOB
		a=true;
		b=false;
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,500)");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/following::span[text()='Required Field'][1]");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][3]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Birth Date']/following::span[text()='Required Field'][4]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test7.pass("Add Child page - No Name -  Worked ");}
		else{test7.fail("Add Child page - No Name - Not worked ");}
	}
	
	@Test
	public void a9_nameInvalid(){		
		ExtentTest test8=extentreport.createTest("Child - Name Invalid ","To check that unable to save with invalid name");
		d.navigate().refresh();		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=true;
		
		//Blank space
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("10");
		Select month2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		Select year2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2007");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("           ");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test8.fail("Add Child - Invalid name - Blank space only - Accpeted ");
		a=true;}
		else {test8.pass("Add Child - Invalid name - Blank space only - Declined ");}
		
		//only special characters 
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("!@#$%^&*({]");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test8.fail("Add Child - Invalid name - Only special characters  - Accpeted ");
		a=true;}
		else {test8.pass("Add Child - Invalid name - Only special characters  - Declined ");}
		
		//special characters with numbers & letters
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("1234!@#$%child^&*({name]");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test8.fail("Add Child - Invalid name - Alphanumeric with special characters - Accpeted ");
		a=true;}
		else {test8.pass("Add Child - Invalid name - Alphanumeric with special characters - Declined ");}
	}
	
	@Test
	public void b0_ageUnderOne(){		
		ExtentTest test9=extentreport.createTest("Child - Age under One Year ","To check that unable to save with Age under One Year ");
		d.navigate().refresh();		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=true;
		
		//---Validation---
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("31");
		Select month2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("12");
		Select year2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2022");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOne");
		ClickwithDelay(d,"//button[text()='Add']");
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//div[@class='filter_level_wrapper has_error']/preceding::span[text()='Minimum 1 year old required'][1]"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test9.fail("Add Child -  Age under One Year  - error not shown ");}
		else {test9.pass("Add Child -  Age under One Year - Declined ");}
	}
	
	@Test
	public void b1_childNamevalid(){		
		ExtentTest test10=extentreport.createTest("Child - Name Valid ","To check that able to save with valid name");
		d.navigate().refresh();		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=false;
		
		//---Validation---
		//Only alphabets
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("10");
		Select month2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		Select year2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2007");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("ChildOneIs theName Of Child");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=true;}
		if(a==false) {test10.fail("Add Child - Valid name - Alphabetical letters Only - Declined  ");}
		else {test10.pass("Add Child - valid name - Alphabetical letters Only - Accpeted ");
		a=false;}
		
		//only numerical letters
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("123456780");
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Required Field']//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=true;}
		if(a==false) {test10.fail("Add Child - Valid name - Numerical letters Only - Declined  ");}
		else {test10.pass("Add Child - valid name - Numerical letters Only - Accpeted ");
		a=false;}
		
		//Alpha-Numerical letters
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("Child1 is the name of1234 child");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		ClickwithDelay(d,"//button[text()='Add']");
		waitTillLocate(d,"//label[text()='Birth Date']/preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Required Field']"));
		d.findElement(By.xpath("//label[text()='Birth Date']/preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=true;}
		if(a==false) {test10.fail("Add Child - Valid name - Alpha-Numerical letters Only - Declined  ");}
		else {test10.pass("Add Child - valid name - Alpha-Numerical letters Only - Accpeted ");
		a=false;}
	}
	
	@Test
	public void b2_saveChildProfile(){		
		ExtentTest test11=extentreport.createTest("Child - Save ","To check that able to save with details");
		
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=true;
		
		//Saving a Monitor only child under age 10.
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date.selectByValue("1");
		Select month =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month.selectByValue("6");
		Select year =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year.selectByValue("2017");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("MOUnder10");
		d.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		ClickwithDelay(d,"//button[text()='Add']");
		
		///---validation---MOUnder10
		try{ClickwithDelay(d,"//span[text()='MOU']");}
		catch(NoSuchElementException e){test11.fail("Adding Monitor only child under age 10 - Unsuccessful");
		a=false;}
		if(a==true){test11.pass("Adding Monitor only child under age 10 - Successful");}
		JavascriptExecutor jmou1 = (JavascriptExecutor)d;
		jmou1.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//span[text()='6']");
		a=true;
		try{d.findElement(By.xpath("//span[text()='6']"));
			d.findElement(By.xpath("//span[text()='Monitor only']"));
			d.findElement(By.xpath("//h1[text()='MOUnder10']"));}
		catch(NoSuchElementException e){test11.fail("Monitor only child under age 10 - Improper Details Displayed. ");
		a=false;}
		if(a==true){test11.pass("Monitor only child under age 10 - Proper Details Displayed.");}
		a=true;
		try {ClickwithDelay(d,"//span[text()='Delete Child']");
			 waitTillLocate(d,"//p[text()='Do you want to delete the child ']");
			 d.findElement(By.xpath("//p[text()='Do you want to delete the child ']"));
			 ClickwithDelay(d,"//button[text()='Yes']");}
		catch(NoSuchElementException e){test11.fail("Unable to delete MO child Below 10");
		a=false;}
		if(a==true){test11.pass("Monitor Only child Below age 10 - Able to delete ");}
		
		//Saving a Monitor only child above age 10.
		a=true;
		JavascriptExecutor jmoa12= (JavascriptExecutor)d;
		jmoa12.executeScript("window.scrollBy(0,-500)");
		ClickwithDelay(d,"//a[@class='icon_add']");
  		waitTillLocate(d,"//p[text()='Add a Member']");
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
  		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("1");
		Select month2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("6");
		Select year2 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2006");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("MOAbove10");
		d.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		ClickwithDelay(d,"//button[text()='Add']");
		
		///---validation---MOAbove10
		a=true;
		try{ClickwithDelay(d,"//span[text()='MOA']");}
		catch(NoSuchElementException e){test11.fail("Adding Monitor only child Above age 10 - Unsuccessful");
		a=false;}if(a==true){test11.pass("Adding Monitor only child Above age 10 - Successful");}
		JavascriptExecutor jmoa13= (JavascriptExecutor)d;
		jmoa13.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//span[text()='Monitor only']");
		a=true;
		try{d.findElement(By.xpath("//span[text()='17']"));
			d.findElement(By.xpath("//span[text()='Monitor only']"));
			d.findElement(By.xpath("//h1[text()='MOAbove10']"));}
		catch(NoSuchElementException e){test11.fail("Monitor only child Above age 10 - Improper Details Displayed. ");
		a=false;}if(a==true){test11.pass("Monitor only child Above age 10 - Proper Details Displayed.");}
		
		a=true;
		try {ClickwithDelay(d,"//span[text()='Delete Child']");
		 waitTillLocate(d,"//p[text()='Do you want to delete the child ']");
		 d.findElement(By.xpath("//p[text()='Do you want to delete the child ']"));
		 ClickwithDelay(d,"//button[text()='Yes']");}
		catch(NoSuchElementException e){test11.fail("Unable to delete MO child Above 10");
		a=false;}
		if(a==true){test11.pass("Monitor Only child Above age 10 - Able to delete ");}
		
		a=true;
		JavascriptExecutor jmoa14= (JavascriptExecutor)d;
		jmoa14.executeScript("window.scrollBy(0,-500)");		
		//Saving a Monitor and Manage child under age 10.
		ClickwithDelay(d,"//a[@class='icon_add']");
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date1 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date1.selectByValue("1");
		Select month1 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month1.selectByValue("6");
		Select year1 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year1.selectByValue("2017");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("MMUnder10");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		ClickwithDelay(d,"//button[text()='Add']");
		
		///---validation---MMUnder10
		waitTillLocate(d,"//span[text()='MMU']");
		try{d.findElement(By.xpath("//span[text()='MMU']"));}
		catch(NoSuchElementException e){test11.fail("Adding Monitor and Manage child under age 10 - Unsuccessful");
		a=false;}
		if(a==true){test11.pass("Adding Monitor and Manage child under age 10 - Successful");}
		ClickwithDelay(d,"//span[text()='MMU']");

		JavascriptExecutor jmoa15= (JavascriptExecutor)d;
		jmoa15.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//span[text()='Monitor and Manage']");
		a=true;
		try{d.findElement(By.xpath("//span[text()='6']"));
			d.findElement(By.xpath("//span[text()='Monitor and Manage']"));
			d.findElement(By.xpath("//h1[text()='MMUnder10']"));}
		catch(NoSuchElementException e){test11.fail("Monitor and Manage child under age 10 - Improper Details Displayed. ");
		a=false;}
		if(a==true){test11.pass("Monitor and Manage child under age 10 - Proper Details Displayed.");}
		a=true;
		try {ClickwithDelay(d,"//span[text()='Delete Child']");
		 waitTillLocate(d,"//p[text()='Do you want to delete the child ']");
		 d.findElement(By.xpath("//p[text()='Do you want to delete the child ']"));
		 ClickwithDelay(d,"//button[text()='Yes']");}
		catch(NoSuchElementException e){test11.fail("Unable to delete MAM child Under 10");
		a=false;}
		if(a==true){test11.pass("Monitor and Manage child under age 10 - Able to delete.");}
		
		a=true;
		JavascriptExecutor jmoa16= (JavascriptExecutor)d;
		jmoa16.executeScript("window.scrollBy(0,-500)");
		ClickwithDelay(d,"//a[@class='icon_add']");

		//Saving a Monitor and Manage child Above age 10.
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,500)");
	    waitTillLocate(d,"//label[text()='Birth Date']//following::select[1]");
		Select date3 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date3.selectByValue("1");
		Select month3 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month3.selectByValue("6");
		Select year3 =new Select(d.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year3.selectByValue("2006");
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("MMAbove10");
		ClickwithDelay(d,"//label[@for='filter_monitor_and_manage']");
		ClickwithDelay(d,"//button[text()='Add']");

		///---validation---MMAbove10
		a=true;
		try{ClickwithDelay(d,"//span[text()='MMA']");}
		catch(NoSuchElementException e){test11.fail("Adding Monitor and Manage child Above age 10 - Unsuccessful");
		a=false;}
		if(a==true){test11.pass("Adding Monitor and Manage child Above age 10 - Successful");}
		JavascriptExecutor jmoa17= (JavascriptExecutor)d;
		jmoa17.executeScript("window.scrollBy(0,500)");
		a=true;
		waitTillLocate(d,"//span[text()='Monitor and Manage']");
		try{d.findElement(By.xpath("//span[text()='17']"));
			d.findElement(By.xpath("//span[text()='Monitor and Manage']"));
			d.findElement(By.xpath("//h1[text()='MMAbove10']"));}
		catch(NoSuchElementException e){test11.fail("Monitor and Manage child Above age 10 - Improper Details Displayed. ");
		a=false;}
		if(a==true){test11.pass("Monitor and Manage child Above age 10 - Proper Details Displayed.");}
		a=true;
		try {ClickwithDelay(d,"//span[text()='Delete Child']");
		 waitTillLocate(d,"//p[text()='Do you want to delete the child ']");
		 d.findElement(By.xpath("//p[text()='Do you want to delete the child ']"));
		 ClickwithDelay(d,"//button[text()='Yes']");}
		catch(NoSuchElementException e){test11.fail("Unable to delete MAM child Above 10");
		a=false;}
		if(a==true){test11.pass("Monitor and Manage child Above age 10 - Able to delete.");}
		JavascriptExecutor jmoa19= (JavascriptExecutor)d;
		jmoa19.executeScript("window.scrollBy(0,-500)");
	}
	
	@Test
	public void b3_parentNameEmail(){		
		ExtentTest test12=extentreport.createTest("Parent - Name & Email ","To check that able to enter Name & Email details");
		d.navigate().refresh();
		ClickwithDelay(d,"//a[@class='icon_add']");
		ClickwithDelay(d,"//label[@for='add_member_parent']");
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[text()='Parent Name']");
		//---Validation---Parent Name---
		boolean a=true;
		try {d.findElement(By.xpath("//label[text()='Parent Name']"));
			 d.findElement(By.xpath("//label[text()='Email Address']//preceding::input[@type='text']"));
			 d.findElement(By.xpath("//label[text()='Email Address']//preceding::input[@type='text']")).sendKeys("ParentName");
			 d.findElement(By.xpath("//label[text()='Email Address']//preceding::input[@type='text']")).clear();}
		catch(NoSuchElementException e){a=false;
		test12.fail("Add Parent page - Parent Name input is improper");
		a=false;}
		if(a==true){test12.pass("Add Parent page - Parent Name input is proper");}
		a=true;
		
		//---Validation---Parent Email---
		try {d.findElement(By.xpath("//label[text()='Email Address']"));
			 d.findElement(By.xpath("//label[text()='Email Address']//following::input[@type='text']"));
			 d.findElement(By.xpath("//label[text()='Email Address']//following::input[@type='text']")).sendKeys("ParentEmail");
			 d.findElement(By.xpath("//label[text()='Email Address']//following::input[@type='text']")).clear();}
		catch(NoSuchElementException e){a=false;
		test12.fail("Add Parent page - Parent Email input is improper");}
		if(a==true){test12.pass("Add Parent page - Parent Email input is proper");}
	}
	
	@Test
	public void b4_parentType(){
		ExtentTest test13=extentreport.createTest("Parent - Type","To check that able to set all type of parent ");
		d.navigate().refresh();
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//label[@for='parent_role_admin']");
		boolean a=true;
		try {d.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		     d.findElement(By.xpath("//label[@for='parent_role_user']")).click();
		     d.findElement(By.xpath("//label[@for='parent_role_view_only']")).click();
		     d.findElement(By.xpath("//span[text()='Manage Parent, Child & Device Settings']"));
		     d.findElement(By.xpath("//span[text()='Manage Child & Device Settings']"));
		     d.findElement(By.xpath("//span[text()='View only & Not change anything']"));
		     d.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][1]"));
		     d.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][2]"));
		     d.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][2]"));
		     d.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][4]"));
		     d.findElement(By.xpath("//p[text()='Profile managed']//following::span[@class='child_name'][5]"));}			 
		catch(NoSuchElementException e){a=false;
		test13.fail("Add Parent page - Parent Type input is improper");}
		if(a==true){test13.pass("Add Parent page - Parent Type input is proper");}
	}
	
	@Test
	public void b5_parentRequiredField(){	
		ExtentTest test14=extentreport.createTest("Parent - Required Field","To check that unable to save a parent without enough details");
		d.navigate().refresh();		
		boolean a=true;
		
		//---Validation---Required Field---
		
		//No Email---No Name---No Type 
		ClickwithDelay(d,"//button[text()='Send Invite']");
		try{d.findElement(By.xpath("//label[text()='Email Address']/preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][3]"));}
		catch(NoSuchElementException e){a=false;
		test14.fail("Add Parent page - No Email ,No name,No Type - Not worked ");}
		if(a==true){test14.pass("Add Parent  page - No Email ,No name,No Type - Worked ");}
		
		//No Email---No Type
		a=true;
		boolean b=false;
		d.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]")).sendKeys("ParentOne");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//label[text()='Email Address']/following::span[text()='Required Field'][1]");
		try{d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][3]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Email Address']/preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page - No Email , No Type -  Worked ");}
		else{test14.fail("Add Parent page - No Email ,No type - Not worked ");}
		
		//No Email---No Name---only Type
		a=true;
		b=false;
		d.navigate().refresh();	
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		ClickwithDelay(d,"//label[@for='parent_role_admin']");
		ClickwithDelay(d,"//button[text()='Send Invite']");
		waitTillLocate(d,"//p[text()='This parent can']//preceding::span[text()='Required Field'][2]");
		try{d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Email Address']/following::span[text()='Required Field'][2]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page - No Email, No Name -  Worked ");}
		else{test14.fail("Add Parent page - No Email,No Name - Not worked ");}
		
		//No Type---No Name---Only Email
		a=true;
		b=false;
		d.navigate().refresh();
		JavascriptExecutor j4 = (JavascriptExecutor)d;
		j4.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		ClickwithDelay(d,"//button[text()='Send Invite']");
		waitTillLocate(d,"//label[text()='Email Address']//preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][2]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page - No Type , No Name -  Worked ");}
		else{test14.fail("Add Parent page - No Type ,No Name - Not worked ");}
		
		//No Name
		a=true;
		b=false;
		d.navigate().refresh();
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		d.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//label[text()='Email Address']//preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Email Address']//following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Email Address']//following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//label[text()='Email Address']//following::span[text()='Required Field'][3]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page - No Name -  Worked ");}
		else{test14.fail("Add Parent page - No Name - Not worked ");}
		
		//No Type
		a=true;
		b=false;
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]")).sendKeys("ParentOne");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//p[text()='This parent can']//following::span[text()='Required Field'][2]");
		try{d.findElement(By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page -No Type -  Worked ");}
		else{test14.fail("Add Parent page - No Type - Not worked ");}
		
		//No Email
		a=true;
		b=false;
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]")).sendKeys("ParentOne");
		d.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//p[text()='This parent can']//preceding::span[text()='Required Field'][1]");
		try{d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field'][1]"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][2]"));
			d.findElement(By.xpath("//p[text()='This parent can']//following::span[text()='Required Field'][1]"));
			d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page - No Email -  Worked ");}
		else{test14.fail("Add Parent page - No Email - Not worked ");}
		
		//No Child Associate - View and User Parent
		a=true;
		b=false;
		d.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j5 = (JavascriptExecutor)d;
		j5.executeScript("window.scrollBy(0,500)");
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//label[text()='Parent Name']//following::input[@type='text'][1]")).sendKeys("ParentOne");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		d.findElement(By.xpath("//label[@for='parent_role_user']")).click();
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//p[text()='Profile managed']//following::span[text()='Required Field']");
		try{d.findElement(By.xpath("//p[text()='Profile managed']//following::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//p[text()='Profile managed']//preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page - No Child selected - User -  Worked ");}
		else{test14.fail("Add Parent page - No Child selected - User - Not worked ");}
		
		a=true;
		b=false;
		d.findElement(By.xpath("//label[@for='parent_role_view_only']")).click();
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//p[text()='Profile managed']//following::span[text()='Required Field']");
		try{d.findElement(By.xpath("//p[text()='Profile managed']//following::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//p[text()='This parent can']//preceding::span[text()='Required Field']"));
			d.findElement(By.xpath("//p[text()='Profile managed']//preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){b=true;}
		if(a==true && b==true){test14.pass("Add Parent page -No Child selected - View - Worked ");}
		else{test14.fail("Add Parent page - No Child selected - View - Not worked ");}
	}
	
	@Test
	public void b6_parentNameInvalid(){		
		ExtentTest test15=extentreport.createTest("Parent - Name Invalid ","To check that unable to save a Parent with invalid name");
		d.navigate().refresh();		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=true;
		
		//Blank space
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2607@mobicip.com");
		d.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		d.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("           ");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//label[text()='Email Address']//preceding::span[text()='Required Field']");
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Required Field']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test15.fail("Add Parent - Invalid name - Blank space only - Accpeted ");
		a=true;}
		else {test15.pass("Add Parent - Invalid name - Blank space only - Declined ");}
		
		//only special characters 
		d.findElement(By.xpath("//input[@name='parent_name']")).clear();
		d.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("!@#$%^&*({]");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']");
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test15.fail("Add Parent - Invalid name - Only special characters  - Accpeted ");
		a=true;}
		else {test15.pass("Add Parent - Invalid name - Only special characters  - Declined ");}
		
		//special characters with numbers & letters
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("1234!@#$%child^&*({name]");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']");
		try{d.findElement(By.xpath("//label[text()='Email Address']//preceding::span[text()='Only alphanumeric accepted']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test15.fail("Add Child - Invalid name - Alphanumeric with special characters - Accpeted ");
		a=true;}
		else {test15.pass("Add Child - Invalid name - Alphanumeric with special characters - Declined ");}
	}
	
	@Test
	public void b7_parentEmailIDInvalid(){		
		ExtentTest test16=extentreport.createTest("Parent - Email Invalid ","To check that unable to save a Parent with invalid Email");
		d.navigate().refresh();		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=true;
		
		//parent
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("parent");
		d.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		d.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentname");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//span[text()='Invalid Email: Enter a valid email address']");
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test16.fail("Add Parent - Invalid Email - Blank space only - Accpeted ");
		a=true;}
		else {test16.pass("Add Parent - Invalid Email - Blank space only - Declined ");}
		
		//parent1234
		d.findElement(By.xpath("//input[@name='parent_email']")).clear();
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("parent1234");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//span[text()='Invalid Email: Enter a valid email address']");
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false){test16.fail("Add Parent - Invalid Email - Only special characters - Accpeted ");
		a=true;}
		else {test16.pass("Add Parent - Invalid Email - Only special characters  - Declined ");}
		
		//@mobicip.com
		d.findElement(By.xpath("//input[@name='parent_email']")).clear();
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("@mobicip.com");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//span[text()='Invalid Email: Enter a valid email address']");
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test16.fail("Add Parent - Invalid Email - Alphanumeric with special characters - Accpeted ");
		a=true;}
		else {test16.pass("Add Parent - Invalid Email - Alphanumeric with special characters - Declined ");}
		
		//@mobicip.com
		d.findElement(By.xpath("//input[@name='parent_email']")).clear();
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("parent@mobicip");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//span[text()='Invalid Email: Enter a valid email address']");
		try{d.findElement(By.xpath("//span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e){a=false;}
		if(a==false) {test16.fail("Add Parent - Invalid Email - Alphanumeric with special characters - Accpeted ");
		a=true;}
		else {test16.pass("Add Parent - Invalid Email - Alphanumeric with special characters - Declined ");}
	}
	
	@Test
	public void b8_adminParentRegistration(){
		ExtentTest test17=extentreport.createTest("Parent - Admin registered","To check that able to save a Admin Parent with Proper details");
		d.navigate().refresh();	
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		boolean a=true;
		
		//Saving a Admin Parent
		waitTillLocate(d,"//input[@name='parent_email']");
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507admin@mobicip.com");
		d.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		d.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentAdmin");
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		waitTillLocate(d,"//span[text()='parentAdmin']");

		//---validation---Admin Parent
		try{d.findElement(By.xpath("//span[text()='parentAdmin']")).click();}
		catch(NoSuchElementException e){test17.fail("Adding Admin Parent - Unsuccessful");
		a=false;}
		if(a==true){test17.pass("Adding Admin Parent - Successful");}
		JavascriptExecutor j11= (JavascriptExecutor)d;
		j11.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='Invited']//preceding::p[text()='parentAdmin']"));
			d.findElement(By.xpath("//span[text()='Invited']"));
			d.findElement(By.xpath("//span[text()='vikram+2507admin@mobicip.com']"));
			d.findElement(By.xpath("//p[text()=' can']"));
			d.findElement(By.xpath("//span[text()='Manage Parent, Child & Device Settings']"));
			d.findElement(By.xpath("//p[text()=' can watch over']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='ch1']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='jacky']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Jerry']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Vikram D']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='vivo2']"));}
		catch(NoSuchElementException e){test17.fail("Admin Parent - Improper Details Displayed. ");
		a=false;}
		if(a==true){test17.pass("Admin Parent - Proper Details Displayed.");}
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{d.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
			d.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			d.findElement(By.xpath("//button[text()='Yes']")).click();} 
		catch(NoSuchElementException e){test17.fail("Admin Parent - Unable to delete");
		a=false;}
		if(a==true){test17.pass("Admin Parent - Able to delete");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j12= (JavascriptExecutor)d;
		j12.executeScript("window.scrollBy(0,-1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		
	}
	
	@Test
	public void b9_userParentRegistration(){
		ExtentTest test18=extentreport.createTest("Parent - User registered","To check that able to save a User Parent with Proper details");
		//Saving a User Parent
		d.findElement(By.xpath("//a[@class='icon_add']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//label[@for='add_member_parent']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507user@mobicip.com");
		d.findElement(By.xpath("//label[@for='parent_role_user']")).click();
		d.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentUser");
		d.findElement(By.xpath("//span[@class='child_name' and text()='ch1']")).click();
		d.findElement(By.xpath("//span[@class='child_name' and text()='Jerry']")).click();
		d.findElement(By.xpath("//span[@class='child_name' and text()='vivo2']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		
		//---validation---User Parent
		try{d.findElement(By.xpath("//span[text()='parentUser']")).click();}
		catch(NoSuchElementException e){test18.fail("Adding User Parent - Unsuccessful");
		a=false;}
		if(a==true){test18.pass("Adding User Parent - Successful");}
		JavascriptExecutor j11= (JavascriptExecutor)d;
		j11.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='Invited']//preceding::p[text()='parentUser']"));
			d.findElement(By.xpath("//span[text()='Invited']"));
			d.findElement(By.xpath("//span[text()='vikram+2507user@mobicip.com']"));
			d.findElement(By.xpath("//p[text()=' can']"));
			d.findElement(By.xpath("//span[text()='Manage Child & Device Settings']"));
			d.findElement(By.xpath("//p[text()=' can watch over']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='ch1']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Jerry']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='vivo2']"));}
		catch(NoSuchElementException e){test18.fail("User Parent - Improper Details Displayed. ");
		a=false;}
		if(a==true){test18.pass("User Parent - Proper Details Displayed.");}
		a=true;
		try{d.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
			d.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			d.findElement(By.xpath("//button[text()='Yes']")).click();} 
		catch(NoSuchElementException e){test18.fail("User Parent - Unable to delete");
		a=false;}
		if(a==true){test18.pass("User Parent - Able to delete");}		
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j12= (JavascriptExecutor)d;
		j12.executeScript("window.scrollBy(0,-1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
    }
	
	@Test
	public void c0_viewParentRegistration(){
		ExtentTest test19=extentreport.createTest("Parent - View registered","To check that able to save a View Parent with Proper details");
		//Saving a View Parent
		d.findElement(By.xpath("//a[@class='icon_add']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//label[@for='add_member_parent']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507view@mobicip.com");
		d.findElement(By.xpath("//label[@for='parent_role_view_only']")).click();
		d.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentView");
		d.findElement(By.xpath("//span[@class='child_name' and text()='jacky']")).click();
		d.findElement(By.xpath("//span[@class='child_name' and text()='Jerry']")).click();
		d.findElement(By.xpath("//span[@class='child_name' and text()='Vikram D']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Send Invite']")).click();
		try {TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a=true;
		
		//---validation---View Parent
		try{d.findElement(By.xpath("//span[text()='parentView']")).click();}
		catch(NoSuchElementException e){test19.fail("Adding View Parent - Unsuccessful");
		a=false;}
		if(a==true){test19.pass("Adding View Parent - Successful");}
		JavascriptExecutor j11= (JavascriptExecutor)d;
		j11.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{d.findElement(By.xpath("//span[text()='Invited']//preceding::p[text()='parentView']"));
			d.findElement(By.xpath("//span[text()='Invited']"));
			d.findElement(By.xpath("//span[text()='vikram+2507view@mobicip.com']"));
			d.findElement(By.xpath("//p[text()=' can']"));
			d.findElement(By.xpath("//span[text()='View only & Not change anything']"));
			d.findElement(By.xpath("//p[text()=' can watch over']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='jacky']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Jerry']"));
			d.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='Vikram D']"));}
		catch(NoSuchElementException e){test19.fail("View Parent - Improper Details Displayed. ");
		a=false;}
		if(a==true){test19.pass("View Parent - Proper Details Displayed.");}
		a=true;
		try{d.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
			d.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			d.findElement(By.xpath("//button[text()='Yes']")).click();} 
		catch(NoSuchElementException e){test19.fail("View Parent - Unable to delete");
		a=false;}
		if(a==true){test19.pass("View Parent - Able to delete");}		
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j12= (JavascriptExecutor)d;
		j12.executeScript("window.scrollBy(0,-1000)");
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










