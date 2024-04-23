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
 
// no phrase and network should be entered preset in ch1 child 

public class PhrasesNetworks extends BrowserSetup{

	//Report setup

	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PostloginTest\\TestPhrases\\reportContentPhraseNetwork.html");
		extentreport.attachReporter(spark);
	}
		
	@Test
	public void a1_ContentBlockedWeb()
	{
		ExtentTest test=extentreport.createTest("Content - Phrases & Networks  ","To check the Content >  Phrases Option is placed and opened properly");
		//---Dash board---
		String tit=webDriver.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test.pass("Dashboard - title is correct  ");}
		else{test.fail("Dashboard - title isn't correct ");}
		boolean a=true;
		try {webDriver.findElement(By.xpath("//p[text()='Hello Vikram!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Dashboard - Header was Incorrect");}
		if(a==true){test.pass("Dashboard - Header was correct");}
		
		//---Content Option---
		a=true;
		webDriver.findElement(By.xpath("//p[@title='ch1']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Content']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content option is not present in dashboard");}
		if(a==true){test.pass("Content option is present in dashboard");}
		webDriver.findElement(By.xpath("//span[text()='Content']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		//---Content Web---
		a=true;
		try{webDriver.findElement(By.xpath("//a[text()='Websites']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Websites option is not present in dashboard");}
		if(a==true){test.pass("Content - Websites option is present in dashboard");}
		webDriver.findElement(By.xpath("//a[text()='Websites']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	 	JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,300)");
		
//		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
//		webDriver.findElement(By.xpath("//span[text()='Networks']")).click();
//		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}	 
	
 	@Test
 	public void d1_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("Phrase - Title","Checking the title of the page ");
  		boolean a=true;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		//---Content - ---
  		try{webDriver.findElement(By.xpath("//span[text()='Keywords and Phrases']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Keywords and Phrases option is not present in dashboard");}
  		if(a==true){test.pass("Content - Keywords and Phrases option is present in dashboard");}
  		webDriver.findElement(By.xpath("//span[text()='Keywords and Phrases']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
  		String tit=webDriver.getTitle();
  		System.out.println(tit);
  		if(tit.equals("Phrases | Content Monitoring | Mobicip"))
  		{test.pass("Phrases - Title is correct  ");}
  		else{test.fail("Phrases - Title isn't correct ");}
	}
  	
  	@Test
 	public void d2_ContentPhrase(){
  		ExtentTest test= extentreport.createTest("Phrase - Header components","Checking the components of the header - Phrase ");
  		boolean a=true;
		try{webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@title='ch1']/div[@class='profile_image_container']"));
			webDriver.findElement(By.xpath("//p[text()='Phrases']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Phrase - Header components are not present");}
		if(a==true){test.pass("Content - Phrase -  Header components are present");}
	}
  	
  	@Test
 	public void d3_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("Phrase - Add button and info line below the text box","Checking for the add button and info text");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//p[text()='Use commas to add multiple phrases. Example: slenderman, bikini, kim kardashian']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Phrases - Info texts are not present");}
  		if(a==true){test.pass("Content - Phrases - Info texts are present");}
  		
  		try{webDriver.findElement(By.xpath("//input[@name='phrase']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Phrases - Text Box is not present");}
		if(a==true){test.pass("Content - Phrase - Text Box is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//button[@class='link_button add']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Phrases - Text Box Add button is not present");}
		if(a==true){test.pass("Content - Phrases - Text Box Add button is present");}
	}
  	
  	@Test
 	public void d4_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("No Phrases- Icon and text check","Checking for the icon and text when no Phrases are added");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[text()='No phrases added']"));
			webDriver.findElement(By.xpath("//div[@class='no_data_container phrases']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("No Phrases - Icon and Text is improper");}
  		if(a==true){test.pass("No Phrases - Icon and Text is proper");}
  		webDriver.navigate().refresh();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
  	
  	@Test
 	public void d5_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("Phrases - validation check","Checking the input field with multiple inputs");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("cricket");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='cricket']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Phrase is not added");}
  		if(a==true){test.pass("Proper Phrase is added properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("12345");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='12345']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Phrase is not added");}
  		if(a==true){test.pass("Proper Phrase is added properly");}
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("#$D@ftr");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Special Characters not allowed']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper Phrase is added");}
  		if(a==true){test.pass("Improper Phrase is not added");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();

  		 // We're sorry, but something went wrong (500) 
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("______");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='______']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Phrase is not added");}
  		if(a==true){test.pass("Proper Phrase is added properly");}
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("f1race,Real magic");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='f1race']"));
  			webDriver.findElement(By.xpath("//span[text()='Real magic']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Phrase is not added");}
  		if(a==true){test.pass("Proper Phrase is added properly");}
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("1234@#$");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try{webDriver.findElement(By.xpath("//span[text()='Special Characters not allowed']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("abc@#$");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try{webDriver.findElement(By.xpath("//span[text()='Special Characters not allowed']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();

  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("qwer,qwer");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Duplicate Phrases Exist']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicates website are added");}
  		if(a==true){test.pass("Duplicates website are not added");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("cricket");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()=' already added.']"));
  			webDriver.findElement(By.xpath("//button[text()='Okay']")).click();}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicates website are added");}
  		if(a==true){test.pass("Duplicates website are not added");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("knife,,redfish");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper format is added");}
  		if(a==true){test.pass("Improper format is not added ");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();
  		
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("        ");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper format is added");}
  		if(a==true){test.pass("Improper format is not added");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();
	}
  	
  	@Test
 	public void d6_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("Phrases - Duplicate Phrases check","Checking if able to add a Phrases that is already added");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("Real magic,cricket");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()=' already added.']"));
  			webDriver.findElement(By.xpath("//button[text()='Okay']")).click();}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicates website are added");}
  		if(a==true){test.pass("Duplicates website are not added");}
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).clear();
	}
  	
  	@Test
 	public void d7_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("Deleting Phrases ","Checking if able to delete a Phrases ");
  		boolean a=true;
  		//delete one phrase
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='f1race']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='1']"));
  			webDriver.findElement(By.xpath("//span[text()='phrase']"));
  			webDriver.findElement(By.xpath("//span[text()=' selected']"));
  			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("One phrase selected - not displayed properly");}
  		if(a==true){test.pass("One phrase selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='Delete '  and text()='1' and text()=' blocked ' and text()='phrase' and text()='?']"));
			webDriver.findElement(By.xpath("//div[text()='No']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("One phrase Delete - Popup - not displayed properly");}
		if(a==true){test.pass("One phrase Delete - Popup - displayed properly");}
			
		webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='f1race']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("One website Delete - deleted properly");}
		if(a==true){test.fail("One website Delete not deleted properly");}
		
		a=true;
  		//Delete more than one website
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='Real magic']/preceding::label[1]")).click();
  		webDriver.findElement(By.xpath("//span[text()='______']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='2']"));
  			webDriver.findElement(By.xpath("//span[text()='phrases']"));
  			webDriver.findElement(By.xpath("//span[text()=' selected']"));
  			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("More than One phrases selected - not displayed properly");}
  		if(a==true){test.pass("More than One phrases selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='Delete '  and text()='2' and text()=' blocked ' and text()='phrases' and text()='?']"));
			webDriver.findElement(By.xpath("//div[text()='No']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("More than One Websites Delete - Popup - not displayed properly");}
		if(a==true){test.pass("More than One Websites Delete - Popup - displayed properly");}
		
		webDriver.findElement(By.xpath("//button[text()='Yes']")).click(); 		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Real magic']"));
			webDriver.findElement(By.xpath("//span[text()='______']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One phrases Delete - deleted properly");}
		if(a==true){test.fail("More than One phrases Delete not deleted properly");}
		
		//Delete All phrases
		a=true;
  		webDriver.findElement(By.xpath("//span[text()='12345']/preceding::label[1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[@for='all_website_checked']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='2']"));
			webDriver.findElement(By.xpath("//span[text()='phrases']"));
			webDriver.findElement(By.xpath("//span[text()=' selected']"));
			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("All Websites selected - not displayed properly");}
  		if(a==true){test.pass("All websites selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='Delete '  and text()='2' and text()=' blocked ' and text()='phrases' and text()='?']"));
			webDriver.findElement(By.xpath("//div[text()='No']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("More than One Websites Delete - Popup - not displayed properly - add properly 3 websites/ becoxzz of abc...com added previously in the error");}
		if(a==true){test.pass("More than One Websites Delete - Popup - displayed properly");}
		
		webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='12345']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("All phrases Delete - deleted properly");}
		if(a==true){test.fail("All phrases Delete not deleted properly");}
	}
  	
  	@Test
 	public void d8_ContentPhrase()
	{
  		ExtentTest test=extentreport.createTest("Phrases - Go back and visit again","Checking if the changes are retained when visited again");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//input[@name='phrase']")).sendKeys("cricket");
  		webDriver.findElement(By.xpath("//button[@class='link_button add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
  		webDriver.findElement(By.xpath("//span[text()='Keywords and Phrases']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		try{webDriver.findElement(By.xpath("//span[text()='cricket']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("The changes are not retained when visited again");}
		if(a==true){test.pass("The changes are retained when visited again");}
  		webDriver.findElement(By.xpath("//span[text()='cricket']/preceding::label[1]")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
  			  	  	
  	@Test
 	public void e1_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Networks - Title","Checking the title of the page ");
  		boolean a=true;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		//---Content - Networks---
  		try{webDriver.findElement(By.xpath("//span[text()='Networks']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Networks option is not present in dashboard");}
  		if(a==true){test.pass("Content - Networks option is present in dashboard");}
  		webDriver.findElement(By.xpath("//span[text()='Networks']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
  		String tit=webDriver.getTitle();
  		System.out.println(tit);
  		if(tit.equals("Networks | Content Monitoring | Mobicip"))
  		{test.pass("Networks - Title is correct  ");}
  		else{test.fail("Networks - Title isn't correct ");}  		
	}
  	
	@Test
 	public void e2_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Networks - Header components","Checking the components of the header");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//a[@class='logo']"));
  			webDriver.findElement(By.xpath("//span[@id='headerBack']"));
  			webDriver.findElement(By.xpath("//div[@title='ch1']/div[@class='profile_image_container']"));
  			webDriver.findElement(By.xpath("//p[text()='Networks']"));
  			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Networks - Header components are not present");}
  		if(a==true){test.pass("Content - Networks -  Header components are present");}
	}
	 
	@Test
 	public void e3_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Networks - Info text ","Checking for the information text");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[starts-with(text(),\"Disable Mobicip on your child\")]"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Networks - Info texts are not present");}
  		if(a==true){test.pass("Content - Networks - Info texts are present");}
  		
  		try{webDriver.findElement(By.xpath("//span[text()='Single IP address']"));
  			webDriver.findElement(By.xpath("//span[text()='IP Address Range']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Networks - Two branches is not present");}
		if(a==true){test.pass("Content - Networks - Two branches is present");}
		
		a=true;
		try{webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']"));
			webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content - Networks -  Add button is not present");}
		if(a==true){test.pass("Content - Networks - Add button is present");}
	}
	
	@Test
 	public void e4_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Add button and add network pop-up - Single IP address","Checking for the add button and Pop-up");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='Add single IP address']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Networks -  Add button is not working");}
  		if(a==true){test.pass("Content - Networks - Add button is working");}
  		
  		a=true;
  		try{webDriver.findElement(By.xpath("//p[text()='Add single IP address']"));
  			webDriver.findElement(By.xpath("//label[text()='IP Address']"));
  			webDriver.findElement(By.xpath("//input[@placeholder='Enter IP address to allow - Example 192.168.1.1']"));
  			webDriver.findElement(By.xpath("//div[text()='Cancel']"));
  			webDriver.findElement(By.xpath("//button[text()='Add']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Networks -  Pop-up is improprer / Elements are missing ");}
  		if(a==true){test.pass("Content - Networks -  Pop-up is proprer");}
  		webDriver.findElement(By.xpath("//div[text()='Cancel']")).click(); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
 	public void e5_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Networks - No Single IP address - Icon and text check","Checking for the icon and text when no Single IP address are added");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Single IP address']")).click();
  		try{webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='No network added']"));
  			webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::div[@class='no_data_container networks']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("No Networks - Icon and Text is improper");}
		if(a==true){test.pass("No Networks - Icon and Text is proper");}
		webDriver.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
 	public void e6_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Networks - Single IP address - validation check","Checking the input field with multiple inputs");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//1.1.1.1
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1.1.1.1");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='Single IP address']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='1.1.1.1']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Single Network is not added");}
  		if(a==true){test.pass("Proper Single Network is added properly");}
  		//1.23.45.167
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		a=true;
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1.23.45.167");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='1.23.45.167']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Single Network is not added");}
  		if(a==true){test.pass("Proper Single Network is added properly");}
  		//a.b.c.d
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("a.b.c.d");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper Single Network is added");}
  		if(a==true){test.pass("Improper Single Network is not added");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//1.a.b.3
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1.a.b.3");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper Single Network is added");}
  		if(a==true){test.pass("Improper Single Network is not added properly");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//255.255.255.255
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("255.255.255.255");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		a=true;
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.255']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Single Network is not added");}
  		if(a==true){test.pass("Proper Single Network is added properly");}
  		//255.255.255.256
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("255.255.255.256");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//2.5.1.256
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("2.5.1.256");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//1.1.1.a
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1.1.1.a");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//11..1.1
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("11..1.1");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//Blank space
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("     ");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Required Field']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper format is added");}
  		if(a==true){test.pass("Improper format is not added - asking required field");}
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		//255.255.255.1
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("255.255.255.1");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//1.2.3.45
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1.2.3.45");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//54.231.55.98
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("54.231.55.98");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//Checking other three entered details
  		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.1']"));
  			webDriver.findElement(By.xpath("//div[text()='1.2.3.45']"));
  			webDriver.findElement(By.xpath("//div[text()='54.231.55.98']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Networks are not added properly");}
  		if(a==true){test.pass("Networks are added properly");}
	}
  	
	@Test
 	public void e7_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Networks - Duplicate Single IP address check","Checking if able to add a Single IP address  that is already added");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//div[@class='single_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//1.1.1.1
  		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1.1.1.1");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='IP address already there']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Duplicate networks are allowed");}
  		if(a==true){test.pass("Duplicate networks are not added");}
  		webDriver.findElement(By.xpath("//div[text()='Cancel']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
 	public void e8_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Single IP address  - Go back and visit again","Checking if the changes are retained when visited again");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		webDriver.findElement(By.xpath("//span[text()='Networks']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		webDriver.findElement(By.xpath("//span[text()='Single IP address']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.1']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("The changes are not retained when visited again");}
		if(a==true){test.pass("The changes are retained when visited again");}
	}
	
	@Test
 	public void e9_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Deleting Single IP address","Checking if able to delete a Single IP address ");
  		boolean a=true;
  		//delete one network
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//div[text()='255.255.255.1']/preceding::label[@class='check_box'][1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='1' and text()='IP address' and text()=' selected']"));
  			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("One Single IP address selected - not displayed properly");}
  		if(a==true){test.pass("One Single IP address selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.1']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("One Single IP address delete - deleted properly");}
		if(a==true){test.fail("One Single IP address delete not deleted properly");}
		
  		//Delete more than one website
		a=true;
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//div[text()='1.2.3.45']/preceding::label[@class='check_box'][1]")).click();
  		webDriver.findElement(By.xpath("//div[text()='54.231.55.98']/preceding::label[@class='check_box'][1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='2' and text()='IP addresses' and text()=' selected']"));
  			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("More than One Single IP address selected - not displayed properly");}
  		if(a==true){test.pass("More than One Single IP address selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//div[text()='1.2.3.45']"));
			webDriver.findElement(By.xpath("//div[text()='54.231.55.98']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One Single IP address Delete - deleted properly");}
		if(a==true){test.fail("More than One Single IP address Delete not deleted properly");}
		
		//Delete All websites
		a=true;
  		webDriver.findElement(By.xpath("//div[text()='255.255.255.255']/preceding::label[@class='check_box'][1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[@for='all_ip_boxes_checked']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='3' and text()='IP addresses' and text()=' selected']"));
			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("All Websites selected - not displayed properly");}
  		if(a==true){test.pass("All websites selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.255']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("All phrases Delete - deleted properly");}
		if(a==true){test.fail("All phrases Delete not deleted properly");}
		webDriver.findElement(By.xpath("//span[text()='Single IP address']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
 	@Test
 	public void f0_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Add button and add network pop-up - IP Address Range","Checking for the add button and Pop-up");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='Add IP Address Range']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Network range - Add button is not working");}
  		if(a==true){test.pass("Content - Network range - Add button is working");}
  	
  		a=true;
  		try{webDriver.findElement(By.xpath("//p[text()='Add IP Address Range']"));
  			webDriver.findElement(By.xpath("//label[text()='IP Address']"));
  			webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input"));
  			webDriver.findElement(By.xpath("//label[text()='Network Mask']"));
  			webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input"));
  			webDriver.findElement(By.xpath("//div[text()='Cancel']"));
  			webDriver.findElement(By.xpath("//button[text()='Add']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content - Network range -  Pop-up is improprer / Elements are missing ");}
  		if(a==true){test.pass("Content - Network range -  Pop-up is proprer");}
  		webDriver.findElement(By.xpath("//div[text()='Cancel']")).click(); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
 	public void f1_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("No IP Address Range - Icon and text check","Checking for the icon and text when no IP Address Range are added");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='IP Address Range']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='No network added']"));
  			webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::div[@class='no_data_container networks']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("No Network range  - Icon and Text is improper");}
		if(a==true){test.pass("No Network range - Icon and Text is proper");}
		webDriver.navigate().refresh();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
 	public void f2_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("IP Address Range - validation check","Checking the input field with multiple inputs");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//1.1.1.1 / 255.255.255.0
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("1.1.1.1");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.255.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='IP Address Range']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.255.255.0']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Network range is not added");}
  		if(a==true){test.pass("Proper Network range is added properly");}
  		//1.23.45.167 / 255.255.0.0
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		a=true;
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("1.23.45.167");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.0.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='1.23.45.167' and text()='/' and text()='255.255.0.0']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Network range is not added");}
  		if(a==true){test.pass("Proper Network range is added properly");}
  		//a.b.c.d / 2.2.21.1
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("a.b.c.d");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("2.2.21.1");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper Network is added");}
  		if(a==true){test.pass("Improper Network is not added");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//1.1.1.1 / 255.255.1.255
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("1.1.1.1");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.1.255");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Mask is invalid']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper Network is added");}
  		if(a==true){test.pass("Improper Network is not added properly");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//255.255.255.255 / 255.0.0.0
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("255.255.255.255");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.0.0.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.255' and text()='/' and text()='255.0.0.0']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Proper Network range is not added");}
  		if(a==true){test.pass("Proper Network range is added properly");}
  		//255.255.255.256 / 255.255.255.0
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("255.255.255.256");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.255.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//2.5.1.256 / 255.255.255.0 
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("2.5.1.256");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.255.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//1.1.1.1 / 255.255.255.a
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("1.1.1.1");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.255.a");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//1.1.1.1 / 255255..255.0
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("1.1.1.1");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255255..255.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::span[text()='Invalid: Enter a valid value']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Error Message shown is not shown - Web added - Invalid Website");}
  		if(a==true){test.pass("Error Message shown is properly shown");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		//Blank space
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("   ");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("     ");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		a=true;
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}   
  		try{webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::span[text()='Required Field']"));
  			webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::span[text()='Required Field']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Improper format is added");}
  		if(a==true){test.pass("Improper format is not added - asking required field");}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).clear();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//255.255.255.1 / 255.255.255.0
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("255.255.255.1");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.255.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//1.2.3.45 / 255.255.255.0
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("1.2.3.45");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.255.255.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//54.231.55.98 / 255.0.0.0
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("54.231.55.98");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).clear();
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.0.0.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();} 
  		//Checking other three entered details
  		a=true;
  		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.1' and text()='/' and text()='255.255.255.0']"));
  			webDriver.findElement(By.xpath("//div[text()='1.2.3.45' and text()='/' and text()='255.255.255.0']"));
  			webDriver.findElement(By.xpath("//div[text()='54.231.55.98' and text()='/' and text()='255.0.0.0']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Networks are not added properly");}
  		if(a==true){test.pass("Networks are added properly");}
	}
	
	@Test
 	public void f3_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("IP Address Range -  Duplicate IP Address Range check","Checking if able to add a  IP Address Range  that is already added");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//div[@class='range_ip_wrapper']/descendant::span[text()='Add']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/preceding::input")).sendKeys("54.231.55.98");
  		webDriver.findElement(By.xpath("//label[text()='Network Mask']/following::input")).sendKeys("255.0.0.0");
  		webDriver.findElement(By.xpath("//button[text()='Add']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();} 
  		try{webDriver.findElement(By.xpath("//span[text()='IP address already there']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate network is added");}
		if(a==true){test.pass("Duplicate network is not added. Properly alert message is shown");}
  		webDriver.findElement(By.xpath("//div[text()='Cancel']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
   	}
  		
  	@Test
   	public void f4_ContentNetwork()
 	{
   		ExtentTest test=extentreport.createTest("IP Address Range - Go back and visit again","Checking if the changes are retained when visited again");
   		boolean a=true;
   		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
  		webDriver.findElement(By.xpath("//span[text()='Networks']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		webDriver.findElement(By.xpath("//span[text()='IP Address Range']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//div[text()='255.255.255.1' and text()='/' and text()='255.255.255.0']"));
			webDriver.findElement(By.xpath("//div[text()='1.2.3.45' and text()='/' and text()='255.255.255.0']"));
			webDriver.findElement(By.xpath("//div[text()='54.231.55.98' and text()='/' and text()='255.0.0.0']"));} 
		catch(NoSuchElementException e) {a=false;
		test.fail("The changes are not retained when visited again");}
		if(a==true){test.pass("The changes are retained when visited again");}
 	}	
  	
  	@Test
 	public void f5_ContentNetwork()
	{
  		ExtentTest test=extentreport.createTest("Deleting IP Address Range","Checking if able to delete a  IP Address Range");
  		boolean a=true;
  		//delete one network
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//div[text()='54.231.55.98' and text()='/' and text()='255.0.0.0']/preceding::label[@class='check_box'][1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='1' and text()='range' and text()=' selected']"));
  			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));} 
  		catch(NoSuchElementException e) {a=false;
  		test.fail("One IP Address Range selected - not displayed properly");}
  		if(a==true){test.pass("One IP Address Range selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//div[text()='54.231.55.98' and text()='/' and text()='255.0.0.0']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("One IP Address Range delete - deleted properly");}
		if(a==true){test.fail("One IP Address Range delete not deleted properly");}
		
  		//Delete more than one network
		a=true;
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//div[text()='1.2.3.45' and text()='/' and text()='255.255.255.0']/preceding::label[@class='check_box'][1]")).click();
  		webDriver.findElement(By.xpath("//div[text()='255.255.255.1' and text()='/' and text()='255.255.255.0']/preceding::label[@class='check_box'][1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='2' and text()='ranges' and text()=' selected']"));
  			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("More than One IP address Range selected - not displayed properly");}
  		if(a==true){test.pass("More than One IP address Range selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//div[text()='1.2.3.45' and text()='/' and text()='255.255.255.0']"));
			webDriver.findElement(By.xpath("//div[text()='255.255.255.1' and text()='/' and text()='255.255.255.0']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("More than One IP address Range Delete - deleted properly");}
		if(a==true){test.fail("More than One IP address Range Delete not deleted properly");}
		
		//Delete All websites
		a=true;
  		webDriver.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.255.255.0']/preceding::label[@class='check_box'][1]")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//label[@for='all_range_boxes_checked']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='3' and text()='ranges' and text()=' selected']"));
			webDriver.findElement(By.xpath("//span[text()='Delete selected']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("All IP address Range selected - not displayed properly");}
  		if(a==true){test.pass("All IP address Range selected - displayed properly");}
  		
  		a=true;
  		webDriver.findElement(By.xpath("//span[text()='Delete selected']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
		try{webDriver.findElement(By.xpath("//div[text()='1.1.1.1' and text()='/' and text()='255.255.255.0']"));} 
		catch(NoSuchElementException e) {a=false;
		test.pass("All phrases Delete - deleted properly");}
		if(a==true){test.fail("All phrases Delete not deleted properly");}
		webDriver.findElement(By.xpath("//span[text()='Single IP address']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		
		// redirect to dashboard
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
			
  	@AfterClass
	public void teardown()
    {
    	extentreport.flush();
//    	webDriver.quit();
    }
}
