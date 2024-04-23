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

// Before start it ===== Make Jerry as MO child ===== 
//                   Make jacky as MO child - its changed into MAM child and revert automatically.
//                   Blocked apps - jacky  - note/notepad/ insta -appstore should not be there      
//                                                    - add playstore instagram and chess  previously

public class ContentApps extends BrowserSetup{
	//Report setup
    
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PostloginTest\\TestContentApps\\reportContentApps.html");
		extentreport.attachReporter(spark);
    }
		
  	@Test
	public void a1_ContentOption()
	{
  		ExtentTest test=extentreport.createTest("Content Option","To check the Content Option is placed in dashboard");
  		
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
		try{webDriver.findElement(By.xpath("//span[text()='Content']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Content option is not present in dashboard");}
		if(a==true){test.pass("Content option is present in dashboard");}
	}
  	
	@Test
	public void a2_ContentNavigation()
	{
  		ExtentTest test=extentreport.createTest("Content Navigation","To check, the Content Page opened while clicking on content button");
  		webDriver.findElement(By.xpath("//span[text()='Content']")).click();
  		
  		//---Validation---
  		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
  		String tit=webDriver.getTitle();
 		if(tit.equals("Content Monitoring | Mobicip"))
 		{test.pass("Content - title is correct  ");}
 		else{test.fail("Content - title isn't correct");}
	}
	
	@Test
	public void a3_ContentUI()
	{
  		ExtentTest test=extentreport.createTest("Content UI","To check, the Content Page has proper UI");
  		boolean a=true;
  		try {webDriver.findElement(By.xpath("//p[text()='Content']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Content - Header was Incorrect");}
		if(a==true){test.pass("Content - Header was correct");}
	}
	
	@Test
	public void a4_OtherpageNavigation()
	{
  		ExtentTest test=extentreport.createTest("Otherpage Navigation","To check, the Content Page is able to opened from other pages");
  		boolean a=true;
  		
  		//---Social Media <--> Content
  		webDriver.findElement(By.xpath("//span[text()='Social Media']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Social Media']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Social media - Page is not opened");}
		if(a==true){test.pass("Social media - Page is opened");}
		
		webDriver.findElement(By.xpath("//span[text()='Content']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Content']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Content - Page is not opened");}
		if(a==true){test.pass("Content - Page is opened");}
		
  		//---Locator <--> Content
  		webDriver.findElement(By.xpath("//span[text()='Locator']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Locator']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Locator - Page is not opened");}
		if(a==true){test.pass("Locator - Page is opened");}
		
		webDriver.findElement(By.xpath("//span[text()='Content']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Content']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Content - Page is not opened");}
		if(a==true){test.pass("Content - Page is opened");}
		
  		//---Scheduling <--> Content
		webDriver.findElement(By.xpath("//span[text()='Scheduling']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Scheduling']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Scheduling - Page is not opened");}
		if(a==true){test.pass("Scheduling - Page is opened");}
		
		webDriver.findElement(By.xpath("//span[text()='Content']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Content']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Content - Page is not opened");}
		if(a==true){test.pass("Content - Page is opened");}
	}
	
	@Test
	public void a5_ContentHeader()
	{
  		ExtentTest test=extentreport.createTest("Content Header","Verify if the Header elements in content page.");
  		boolean a=true;
  		try {webDriver.findElement(By.xpath("//p[text()='Content']"));
  			webDriver.findElement(By.xpath("//a[@class='logo']"));
  			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
  			webDriver.findElement(By.xpath("//div[@class='profile_image_wrapper profile_32']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Content Header - is not proper");}
		if(a==true){test.pass("Content Header - is proper");}
	}
	
	@Test
	public void a6_ContentChildUsers()
	{
  		ExtentTest test=extentreport.createTest("Content Child Users","Verify if the page shows the list of child users present in the account.");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//p[@title='ch1']"));
  			webDriver.findElement(By.xpath("//p[@title='jacky']"));
  			webDriver.findElement(By.xpath("//p[@title='Jerry']"));
  			webDriver.findElement(By.xpath("//p[@title='Vikram D']"));
  			webDriver.findElement(By.xpath("//p[@title='vivo2']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Content Child Users - is not proper"); }
  		if(a==true){test.pass("Content Child Users - is proper");}
	}
	
	@Test
	public void a7_ContentChildSelct()
	{
  		ExtentTest test=extentreport.createTest("Content Child Select","Verify if able to select any child.");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//p[@title='ch1']")).click();
  			webDriver.findElement(By.xpath("//p[@title='jacky']")).click();
  			webDriver.findElement(By.xpath("//p[@title='Jerry']")).click();
  			webDriver.findElement(By.xpath("//p[@title='Vikram D']")).click();
  			webDriver.findElement(By.xpath("//p[@title='vivo2']")).click();
  			webDriver.findElement(By.xpath("//p[@title='ch1']")).click();}
  		catch(NoSuchElementException e){a=false;
		test.fail("Content Child Select - is not proper"); }
  		if(a==true){test.pass("Content Child Select - is proper");}
	}
	
	@Test
	public void a8_AppsWebButtton()
	{
  		ExtentTest test=extentreport.createTest("Apps Web Buttton","Verify if there is Apps and Web tabs for all the manage and monitor child profiles.");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//a[text()='Apps']"));
  			webDriver.findElement(By.xpath("//a[text()='Websites']"));}
  		catch(NoSuchElementException e) {a=false;
		test.fail("Apps Web Buttton - is not present"); }
  		if(a==true){test.pass("Apps Web Buttton - is present");}
	}
	
	@Test
	public void a9_AppsByDefault()
	{
  		ExtentTest test=extentreport.createTest("Apps By Default","Verify if the Apps tab is shown selected by default initially when we select a manage and monitor child.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Social Media']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='Content']")).click();
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Blocked Apps']"));
  			webDriver.findElement(By.xpath("//span[text()='Limit Apps']"));}
  		catch(NoSuchElementException e) {a=false;
		test.fail("Apps By Default - is not proper"); }
  		if(a==true){test.pass("Apps By Default - is proper");}
	}
	
	@Test
	public void b0_ContentDisabledMoniterOnly()
	{
  		ExtentTest test=extentreport.createTest("Content Disabled Moniter Only","Verify if the Apps and Web tabs are shown disabled on selecting a Monitor only child.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//p[@title='jacky']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
        try{webDriver.findElement(By.xpath("//p[text()='You cannot change app settings as jacky is in Monitor only mode.']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content Disabled Moniter Only -Not Worked properly");}
  		if(a==true){test.pass("Content Disabled Moniter Only - Worked properly");}
	}
	
	@Test
	public void b1_MOChildChange()
	{
  		ExtentTest test=extentreport.createTest("MO Child Change","Verify if \"Change child settings?\" option is present in the Content page of the Monitor only child.");
  		boolean a=true;
  		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//a[text()='Change ']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("MO Child Change - Option is not there."); }
  		if(a==true){test.pass("MO Child Change - Option is there");}
  	}
	
	@Test
	public void b2_MOChildChangeWorking() {
  		ExtentTest test=extentreport.createTest("MO Child Change Working","Verify if able to change the child's filter settings to manage and monitor using the \"Change child's settings?\" option.");
  		boolean a=false;
  		webDriver.findElement(By.xpath("//a[text()='Change ']")).click();
  		try{TimeUnit.SECONDS.sleep(7);}catch(InterruptedException e) {e.printStackTrace();}
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
  		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='filter_monitor_and_manage']")).click();
		webDriver.findElement(By.xpath("//button[text()='Save']")).click();
  		try{TimeUnit.SECONDS.sleep(10);}catch(InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//a[text()='Change ']"));}
  		catch(NoSuchElementException e) {a=true;
  		test.pass("MO Child Change - Unable to change as Moniter and manage child"); }
  		if(a==false){test.fail("MO Child Change - Able to change as Moniter and manage child");}
	}
	
	@Test
	public void b3_MAMChildEnabled(){
  		ExtentTest test=extentreport.createTest("MAM Child Enabled","Verify if content page is enabled for the child for which filter level is changed from Monitor only level to Manage & monitor level.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Blocked Apps']")).click();
  		try{TimeUnit.SECONDS.sleep(6);}catch(InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='Blocked Apps']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("MAM Child - Unable to access content settings"); }
  		if(a==true){test.pass("MAM Child - Able to access content settings {Content - Apps Enabled}");}
	}
	
	@Test
	public void b4_MOChildDisabled(){
  		ExtentTest test=extentreport.createTest("Mo Child Disabled","Verify if content page is disabled for the child for Moniter Only Child");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[@class='header_back']")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//p[text()='Jerry']")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='You cannot change app settings as Jerry is in Monitor only mode.']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("MO Child - Able to access content settings"); }
  		if(a==true){test.pass("MO Child - Unable to access content settings {Content - Apps Enabled}");}
	}
	
	@Test
	public void b5_ContentComponents(){
  		ExtentTest test=extentreport.createTest("Content Components"," Verify if the apps tab in Content management page has all the components for a Manage and monitor child ");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//p[@title='jacky']")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//span[text()='Blocked Apps']"));
  			webDriver.findElement(By.xpath("//span[text()='Limit Apps']"));
  			webDriver.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Content Components - Components missing"); }
  		if(a==true){test.pass("Content Components - All components were placed");}
	}
	
	@Test
	public void b6_BlockAppspage(){
  		ExtentTest test=extentreport.createTest("Block Apps page","Verify if clicking on Block apps option opens \"Block Apps\" page.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Blocked Apps']")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		String tit=webDriver.getTitle();
  		if(tit.equals("Blocked Apps | Content Monitoring | Mobicip")){
  			test.pass("Blocked Apps - Title is correct");
  		}else{test.fail("Blocked Apps - Title is not correct");}
  		try{webDriver.findElement(By.xpath("//p[text()='Blocked Apps']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Blocked Apps - Header is not correct"); }
		if(a==true){test.pass("Blocked Apps - Header is correct");}
	}
	
	@Test
	public void b7_BlockAppsComponents(){
		ExtentTest test=extentreport.createTest("Block Apps Components","Verify if Block Apps page has following components");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[@id='headerBack']"));
  		webDriver.findElement(By.xpath("//div[@class='profile_image_wrapper profile_42'][@title='jacky']"));
  		webDriver.findElement(By.xpath("//p[text()='Blocked Apps']"));
  		webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
  		webDriver.findElement(By.xpath("//p[text()='Settings will not apply to Mobicip preset schedules.']"));
  		webDriver.findElement(By.xpath("//h2[text()='Allowed Categories']"));
  		webDriver.findElement(By.xpath("//span[text()='Social Media']"));
  		webDriver.findElement(By.xpath("//span[text()='Entertainment']"));
  		webDriver.findElement(By.xpath("//span[text()='Games']"));
  		webDriver.findElement(By.xpath("//h2[text()='Blocked Apps']"));
  		webDriver.findElement(By.xpath("//div[@class='filter_button']"));
  		webDriver.findElement(By.xpath("//div[@class='store_search_container']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Blocked Apps Components - Block Apps page not have all components "); }
		if(a==true){test.pass("Blocked Apps Components - Block Apps page have all components ");}
	}
	
	@Test
	public void b8_BlockAppsHeader(){
		ExtentTest test=extentreport.createTest("Block Apps Header","Verify if able to go back to Content > Apps page by clicking on Back button and able to go to Notifications page by clicking on Notifications icon.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='Blocked Apps']")).click();
  		try{TimeUnit.SECONDS.sleep(4);}catch(InterruptedException e) {e.printStackTrace();}
  		try{webDriver.findElement(By.xpath("//p[text()='Blocked Apps']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Back button is worked properly");}
		if(a==true){test.pass("Back button is not worked properly");}
		webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]")).click();
  		try{TimeUnit.SECONDS.sleep(4);}catch(InterruptedException e) {e.printStackTrace();}
  		a=true;
  		try{webDriver.findElement(By.xpath("//p[text()='Notifications']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Notification button is worked properly"); }
		if(a==true){test.pass("Notification button is not worked properly");}
  		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	}
	
	@Test
	public void b9_BlockAppsCategory(){
		ExtentTest test=extentreport.createTest("Block Apps Category ON/OFF","Verify if able to turn ON and OFF the Social media, Entertainment and Games category using the toggle button.");
  		boolean a=true;
  		try {
  		webDriver.findElement(By.xpath("//input[@id='app_category_1']/following-sibling::label")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@id='app_category_1']/following-sibling::label")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@id='app_category_2']/following-sibling::label")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@id='app_category_2']/following-sibling::label")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@id='app_category_3']/following-sibling::label")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//input[@id='app_category_3']/following-sibling::label")).click();
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Unable to toggle all the category buttons"); }
		if(a==true){test.pass("Able to toggle all the category buttons");}
  	}
  		
	@Test
	public void c0_BlockAppsFilterSearchbar() {
		ExtentTest test=extentreport.createTest("Block Apps - Filter / Search bar","Verify if Blocked Apps section has Filter option and search option.");
  		boolean a=true;
  		try {webDriver.findElement(By.xpath("//span[@class='store_icon']"));
  		webDriver.findElement(By.xpath("//button[@class='store_search_button']"));
  		webDriver.findElement(By.xpath("//input[@type='text']"));
  		webDriver.findElement(By.xpath("//div[@class='filter_button']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Unable to toggle all the category buttons"); }
		if(a==true){test.pass("Able to toggle all the category buttons");}
	}
	
	@Test
	public void c1_Searchbarcomponents() {
		ExtentTest test=extentreport.createTest("Search bar - Components","Verify if the Search bar has All components");
  		boolean a=true;
  		try {webDriver.findElement(By.xpath("//span[@class='store_icon']"));
  		webDriver.findElement(By.xpath("//button[@class='store_search_button']"));
  		webDriver.findElement(By.xpath("//input[@type='text']"));
  		webDriver.findElement(By.xpath("//div[@class='filter_button']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("Unable to toggle all the category buttons"); }
  		if(a==true){test.pass("Able to toggle all the category buttons");}
	}
	
	@Test
	public void c2_Selectingstores() {
		ExtentTest test=extentreport.createTest("Selecting stores ","Verify if able to select Appstore or playstore.");
  		boolean a=true;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,300)");
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//div[@class='store_type_container']")).click();
  		try {webDriver.findElement(By.xpath("//li[@class='store_type_li playstore']"));
  			 webDriver.findElement(By.xpath("//li[@class='store_type_li appstore']"));  
  			 webDriver.findElement(By.xpath("//li[@class='store_type_li playstore']")).click();
  			 webDriver.findElement(By.xpath("//div[@class='store_type_container']")).click();
  			 webDriver.findElement(By.xpath("//li[@class='store_type_li appstore']")).click(); 
  		}catch(NoSuchElementException e) {a=false;
  		test.fail("Unable to select Appstore or playstore"); }
  		if(a==true){test.pass("Able to select Appstore or playstore");}
	}
	
	@Test 
	public void c3_NotFoundApps() {
		ExtentTest test=extentreport.createTest("Not found Apps","Verify if it shows the appropriate message when searched app is not found in app/play store.");
  		boolean a=true;
  		test.pass("Have to discuss with team");
  		// Have to discuss with team
	}
		
	@Test 
	public void c4_Appslisting(){
		ExtentTest test=extentreport.createTest("Apps listing","Verify if the results related to the search are listed correctly.");
  		boolean a=true;
  	    webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("carrom");  
  	    webDriver.findElement(By.xpath("//button[@class='store_search_button']")).click();  
  		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		try {webDriver.findElement(By.xpath("//p[text()='Carrom Pool: Disc Game']"));
  		webDriver.findElement(By.xpath("//p[text()='Carrom 3D']"));
  		webDriver.findElement(By.xpath("//p[text()='Pool Break Lite 3D Billiards 8 Ball Snooker Carrom']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("The results related to the search are not listed correctly"); }
  		if(a==true){test.pass("The results related to the search are listed correctly");} 		
	}

	@Test 
	public void c5_Apppartname(){
		ExtentTest test=extentreport.createTest("App part name","Verify if the results are shown on searching any part of the app name.");
  		boolean a=true;
  	    webDriver.findElement(By.xpath("//div[@class='popup_content']/descendant::input[@type='text']")).clear();  
  	    webDriver.findElement(By.xpath("//div[@class='popup_content']/descendant::input[@type='text']")).sendKeys("temple run");  
  	    webDriver.findElement(By.xpath("//div[@class='popup_content']/descendant::button[@class='store_search_button']")).click();  
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//p[text()='Temple Run']"));
		webDriver.findElement(By.xpath("//p[text()='Temple Run 2']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("The results with part of name related to the search are not listed correctly"); }
		if(a==true){test.pass("The results with part of name related to the search are listed correctly");} 	
	}                 
	
	@Test 
	public void c6_ComponentsinApp(){
		ExtentTest test=extentreport.createTest("Components in App","Verify if the search results are displayed with selection button, App name, Age rating, and store icon.");
  		boolean a=true;
  		try {webDriver.findElement(By.xpath("//label[@class='check_box']"));
 		webDriver.findElement(By.xpath("//p[text()='Temple Run']"));
 		webDriver.findElement(By.xpath("//p[text()='Temple Run']/following-sibling::span[@title='Imangi Studios, LLC']"));
 		webDriver.findElement(By.xpath("//p[text()='Temple Run']/following-sibling::div[@class='user_rating']"));}
 		catch(NoSuchElementException e) {a=false;
 		test.fail("The search results are not displayed with selection button, App name, Age rating, and store icon."); }
 		if(a==true){test.pass("The search results are displayed with selection button, App name, Age rating, and store icon.");} 	
  	}
	// --------------Need to rework ----------
	@Test 
	public void c7_SelectApps(){
		ExtentTest test=extentreport.createTest("Select Apps","Verify if able to select the searched apps.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//p[text()='Temple Run']/preceding::label[@class='check_box']")).click();
  		webDriver.findElement(By.xpath("//p[text()='Temple Run']/following::label[@class='check_box'][1]")).click();
  		try {webDriver.findElement(By.xpath("//span[@class='app_selected_label']"));
 		webDriver.findElement(By.xpath("//div[@class='link_button add']"));}
 		catch(NoSuchElementException e) {a=false;
 		test.fail("The search results are not displayed with selection button, App name, Age rating, and store icon."); }
 		if(a==true){test.pass("The search results are displayed with selection button, App name, Age rating, and store icon.");} 	
	}
	
	@Test 
	public void c8_AddselectApps(){
		ExtentTest test=extentreport.createTest("Add select Apps","Verify if newly added apps are shown listed in the Blocked Apps section.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Add to blocked apps']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,200)");
  	    try {webDriver.findElement(By.xpath("//li[@app-name='Temple Run']"));
		webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Newly added apps are not shown listed in the Blocked Apps section."); }
		if(a==true){test.pass("Newly added apps are shown listed in the Blocked Apps section.");} 	
	}
	
	//Please add instagram -playstore  in blocked apps 	before starting of the test
	@Test 
	public void c9_SameAppinBothstores(){
		ExtentTest test=extentreport.createTest("Same App in Both stores","Verify if able to search and add the same app from app store and play store.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  	    webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("instagram");  
  	    webDriver.findElement(By.xpath("//button[@class='store_search_button']")).click();  
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//p[text()='Instagram']/preceding::label[@class='check_box']")).click();
  	         try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
  	  	     webDriver.findElement(By.xpath("//span[text()='Add to blocked apps']")).click();
  	         try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
  	         webDriver.findElement(By.xpath("//li[@app-name='Instagram']//span[@class='icon_platform android']"));  
  	       	 webDriver.findElement(By.xpath("//li[@app-name='Instagram']//span[@class='icon_platform ios']"));  }
		catch(NoSuchElementException e) {a=false;
		test.fail("Unable to search and add the same app from app store and play store."); }
		if(a==true){test.pass("Able to search and add the same app from app store and play store.");} 	
	}
	
	@Test 
	public void d0_DetailsofApp(){
		ExtentTest test=extentreport.createTest("Details of App","Verify if each app listed as blocked is shown with app name, icon, age rating and appstore/playstore icon.");
  		boolean a=true;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,100)");
  		try {webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']//div[@class='app_icon_container']"));
  			 webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']//p[@class='app_name']"));
  			 webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']//span[@class='icon_platform ios']"));
  			 webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']//span[@class='app_age']"));
  			 webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']//button[@class='app_delete']"));}
 		catch(NoSuchElementException e) {a=false;
 		test.fail("The search results are not displayed with selection button, App name, Age rating, and store icon."); }
 		if(a==true){test.pass("The search results are displayed with selection button, App name, Age rating, and store icon.");} 	
	}

	@Test
	public void d1_DeleteApps(){
		ExtentTest test=extentreport.createTest("Delete Apps","Verify if clicking on Delete button deletes the app from the blocked list.");
  		boolean a=false;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,100)");
  		webDriver.findElement(By.xpath("//li[@app-name='Temple Run']//button[@class='app_delete']")).click();  
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//button[@data-name='app_allowed']")).click();  
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']//button[@class='app_delete']")).click(); 
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//button[@data-name='app_allowed']")).click();  
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//li[@app-name='Instagram']//span[@class='icon_platform ios']/following::button[@class='app_delete'][1]")).click();  
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//button[@data-name='app_allowed']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}	
  	    try {webDriver.findElement(By.xpath("//li[@app-name='Instagram']//span[@class='icon_platform ios']"));
		   webDriver.findElement(By.xpath("//li[@app-name='Temple Run 2']"));
		   webDriver.findElement(By.xpath("//li[@app-name='Temple Run']"));}
  	    catch(NoSuchElementException e) {a=true;
  	    test.pass("Selected Apps got deleted "); }
  	    if(a==false){test.fail("Selected Apps were not deleted");}   
	}
	
	@Test
	public void d2_addsameappafterdelete(){
		ExtentTest test=extentreport.createTest("Add same app after delete","Verify if able to add back the same app to blocked list after deleting the app once.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//input[@type='text']")).clear();
  		try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  	    webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("instagram");  
  	    webDriver.findElement(By.xpath("//button[@class='store_search_button']")).click();  
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    webDriver.findElement(By.xpath("//p[text()='Instagram']/preceding::label[@class='check_box']")).click(); 
  	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
  	    webDriver.findElement(By.xpath("//span[text()='Add to blocked apps']")).click();
	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
	    JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,100)");
	    try {webDriver.findElement(By.xpath("//li[@app-name='Instagram']//span[@class='icon_platform ios']"));}
	    catch(NoSuchElementException e) {a=false;
	    	test.fail("Unable to add back the same app to blocked list after deleting the app once."); }
	    if(a==true){test.pass("Able to add back the same app to blocked list after deleting the app once.");} 
  	}
	
	@Test
	public void d3_Filter(){
		ExtentTest test=extentreport.createTest("Filter open","Verify if the filter options are shown on clicking the Filter icon.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Filter']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//p[text()='Platform']"));
  			 webDriver.findElement(By.xpath("//p[text()='Age Ratings']")); 
  			 webDriver.findElement(By.xpath("//p[text()='Search App']"));
  			 webDriver.findElement(By.xpath("//span[text()='Clear All']"));}
	    catch(NoSuchElementException e) {a=false;
	    	test.fail("Filter not opened"); }
	    if(a==true){test.pass("The filter options are shown on clicking the Filter icon.");}
  	}
	
	@Test
	public void d4_FilterComponents(){
		ExtentTest test=extentreport.createTest("Filter Components","Verify if the filter have Platform and Age rating category.");
  		boolean a=true;
  		 try {webDriver.findElement(By.xpath("//p[text()='Platform']"));
			  webDriver.findElement(By.xpath("//p[text()='Age Ratings']")); 
			  webDriver.findElement(By.xpath("//p[text()='Search App']"));
			  webDriver.findElement(By.xpath("//span[text()='Clear All']"));
			  webDriver.findElement(By.xpath("//label[@for='app_platform_ios']"));
			  webDriver.findElement(By.xpath("//label[@for='app_platform_android']"));
			  webDriver.findElement(By.xpath("//label[@for='age_rating_4']"));  
			  webDriver.findElement(By.xpath("//label[@for='age_rating_9']"));  
			  webDriver.findElement(By.xpath("//label[@for='age_rating_12']"));  
			  webDriver.findElement(By.xpath("//label[@for='age_rating_17']"));  
			  webDriver.findElement(By.xpath("//label[@for='age_rating_18']")); 
			  webDriver.findElement(By.xpath("//input[@name='search_string']"));}
        catch(NoSuchElementException e) {a=false;
    	test.fail("The filter have Platform and Age rating category."); }
        if(a==true){test.pass("The filter not have the Platform and Age rating category.");}
	}
		
	@Test
	public void d5_FilterOneSelection(){
		ExtentTest test=extentreport.createTest("Filter One Selection","Verify if able to select one filter option in one category.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//label[@for='app_platform_ios']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//span[@class='icon_platform ios']"));}
  	    catch(NoSuchElementException e) {a=false;
  	    test.fail("Only iOS Apps are not listed - while selecting iOS"); }
  	    if(a==true){test.pass("Only iOS Apps are listed - while selecting iOS");}
  	    a=true;
  	    try {webDriver.findElement(By.xpath("//span[@class='icon_platform android']"));}
	    catch(NoSuchElementException e) {a=false;
	    test.pass("Android Apps are not listed - while selecting iOS"); }
	    if(a==true){test.fail("Android Apps are listed - while selecting iOS");}
	    // selecting android
	    a=true;
	    webDriver.findElement(By.xpath("//label[@for='app_platform_android']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//span[@class='icon_platform android']"));}
  	    catch(NoSuchElementException e) {a=false;
  	    test.fail("Only android Apps are not listed - while selecting android"); }
  	    if(a==true){test.pass("Only android Apps are listed - while selecting android");}
  	    a=true;
  	    try {webDriver.findElement(By.xpath("//span[@class='icon_platform ios']"));}
	    catch(NoSuchElementException e) {a=false;
	    test.pass("iOS Apps are not listed - while selecting android"); }
	    if(a==true){test.fail("iOS Apps are listed - while selecting android");}	    
  	}
	
	@Test
	public void d6_FilterMoreSelection(){
		ExtentTest test=extentreport.createTest("Filter More Selection","Verify if able to select more than one category.");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//label[text()='12+']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//span[text()='12+']"));}
  	    catch(NoSuchElementException e) {a=false;
  	    test.fail("Only 12+ Apps are not listed - while selecting 12+"); }
  	    if(a==true){test.pass("Only 12+ Apps are listed - while selecting 12+");}
  	    a=true;
  	    try {webDriver.findElement(By.xpath("//span[text()='4+']"));}
	    catch(NoSuchElementException e) {a=false;
	    test.pass("other than 12+ Apps are not listed - while selecting 12+"); }
	    if(a==true){test.fail("other than 12+ Apps are listed - while selecting 12+");}
	    // selecting 4+
	    a=true;
	    webDriver.findElement(By.xpath("//label[text()='4+']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    try {webDriver.findElement(By.xpath("//span[text()='4+']"));}
  	    catch(NoSuchElementException e) {a=false;
  	    test.fail("Only 4+ Apps are not listed - while selecting 4+"); }
  	    if(a==true){test.pass("Only 4+ Apps are listed - while selecting 4+");}
  	    a=true;
  	    try {webDriver.findElement(By.xpath("//span[text()='12+']"));}
	    catch(NoSuchElementException e) {a=false;
	    test.pass("other than 4+ Apps are not listed - while selecting 4+"); }
	    if(a==true){test.fail("other than 4+ Apps are listed - while selecting 4+");}
  	}
	
	@Test
	public void d7_ClearAllFilters(){
		ExtentTest test=extentreport.createTest("Clear All Filters","Verify if able to clear all the applied filters.");
  		boolean a=true;
  		try {webDriver.findElement(By.xpath("//span[text()='Clear All']")).click();}
  	    catch(NoSuchElementException e) {a=false;
  	    test.fail("No Clear All button placed"); }
  	    if(a==true){test.pass("Clear All button placed");}
  	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
  	    a=true;
  	    try {webDriver.findElement(By.xpath("//li[@app-name='Chess']")); 
  	    	webDriver.findElement(By.xpath("//li[@app-name='Instagram']"));  
  	    	webDriver.findElement(By.xpath("//li[@app-name='Instagram']/following::li[@app-name='Instagram']"));}
	    catch(NoSuchElementException e) {a=false;
	    test.fail("other than 4+ Apps are not listed - while selecting 4+"); }
	    if(a==true){test.pass("other than 4+ Apps are listed - while selecting 4+");}
	    webDriver.findElement(By.xpath("//li[@app-name='Instagram']//span[@class='icon_platform ios']/following::button[@class='app_delete'][1]")).click();  
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//button[@data-name='app_allowed']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
	}
	 
	@Test
	public void d8_LimitApps(){
		ExtentTest test=extentreport.createTest("Limit Apps","Verify if able to open Limit Apps");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//span[text()='Limit Apps']")).click(); 
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    String tit=webDriver.getTitle();
		if(tit.equals("Limit Apps | Content Monitoring | Mobicip")){
			test.pass("Limit Apps - Title is correct");
		}else{test.fail("Limit Apps - Title is not correct");}
		try{webDriver.findElement(By.xpath("//p[text()='Limit Apps']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Header is not correct"); }
		if(a==true){test.pass("Limit Apps - Header is correct");}
	}
	
	@Test
	public void d9_LimitAppsComponents(){
		ExtentTest test=extentreport.createTest("Limit Apps - Components","Verify if All components placed in Limit Apps");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[@id='headerBack']"));
  			webDriver.findElement(By.xpath("//div[@class='profile_image_wrapper profile_42'][@title='jacky']"));
  			webDriver.findElement(By.xpath("//p[text()='Limit Apps']"));
  			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
  			webDriver.findElement(By.xpath("//p[text()='We let you set time limits on some of the most popular apps used by kids.']"));
  			webDriver.findElement(By.xpath("//p[text()='Social Media']/following-sibling::p[@class='the_link']"));
  			webDriver.findElement(By.xpath("//p[text()='Social Media']"));
  			webDriver.findElement(By.xpath("//p[text()='Entertainment']"));
  			webDriver.findElement(By.xpath("//p[text()='Games']"));
  			webDriver.findElement(By.xpath("//p[text()='Entertainment']/following-sibling::p[@class='the_link']"));
  			webDriver.findElement(By.xpath("//p[text()='Games']/following-sibling::p[@class='the_link']"));
  			webDriver.findElement(By.xpath("//span[text()='Android only']"));
  			webDriver.findElement(By.xpath("//a[text()='Learn more']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps Components -  page not have all components "); }
		if(a==true){test.pass("Limit Apps Components -  page have all components ");}
	}
	
	@Test
	public void e0_LimitAppsSocialmedia(){
		ExtentTest test=extentreport.createTest("Limit Apps - Social media","Verify if able to set time limit for Social media");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//p[text()='Social Media']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='2'][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='2'][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Done']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    try{webDriver.findElement(By.xpath("//p[text()='Social Media']/following-sibling::p[text()='2h 30m']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set time limit for Social media"); }
		if(a==true){test.pass("Limit Apps - Able to set time limit for Social media");}
	    
		a=true;
		webDriver.navigate().refresh();
  	    try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//p[text()='Social Media']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='0'][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='0'][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Done']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    try{webDriver.findElement(By.xpath("//p[text()='Social Media']/following-sibling::p[text()='0m']"));}
	    catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set zero time limit for Social media"); }
		if(a==true){test.pass("Limit Apps - Able to set zero time limit for Social media");}
		
		a=true;
		webDriver.findElement(By.xpath("//p[text()='Social Media']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  	    try{webDriver.findElement(By.xpath("//span[text()='Social Media']"));
  	    	webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']"));
  	    	webDriver.findElement(By.xpath("//span[text()='If an app from this categories is getting used in a schedule, that time will not be counted in the set limit.']"));
  	    	webDriver.findElement(By.xpath("//span[@class='p_cross']")).click();}
	    catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set zero time limit for Social media"); }
		if(a==true){test.pass("Limit Apps - Able to set zero time limit for Social media");}
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	}
	
	@Test
	public void e1_LimitAppsEntertainment(){
		ExtentTest test=extentreport.createTest("Limit Apps - Entertainment","Verify if able to set time limit for Entertainment");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//p[text()='Entertainment']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='3'][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='1'][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Done']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    try{webDriver.findElement(By.xpath("//p[text()='Entertainment']/following-sibling::p[text()='3h 15m']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set time limit for Entertainment"); }
		if(a==true){test.pass("Limit Apps - Able to set time limit for Entertainment");}
	    
		a=true;
		webDriver.findElement(By.xpath("//p[text()='Entertainment']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='0'][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='0'][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Done']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    try{webDriver.findElement(By.xpath("//p[text()='Entertainment']/following-sibling::p[text()='0m']"));}
	    catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set zero time limit for Entertainment"); }
		if(a==true){test.pass("Limit Apps - Able to set zero time limit for Entertainment");}
		
		a=true;
		webDriver.findElement(By.xpath("//p[text()='Entertainment']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  	    try{webDriver.findElement(By.xpath("//span[text()='Entertainment']"));
  	    	webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']"));
  	    	webDriver.findElement(By.xpath("//span[text()='If an app from this categories is getting used in a schedule, that time will not be counted in the set limit.']"));
  	    	webDriver.findElement(By.xpath("//span[@class='p_cross']")).click();}
	    catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set zero time limit for Entertainment"); }
		if(a==true){test.pass("Limit Apps - Able to set zero time limit for Entertainment");}
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	}
	
	@Test
	public void e2_LimitAppsGames(){
		ExtentTest test=extentreport.createTest("Limit Apps - Games","Verify if able to set time limit for Games");
  		boolean a=true;
  		webDriver.findElement(By.xpath("//p[text()='Games']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='1'][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='3'][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Done']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    try{webDriver.findElement(By.xpath("//p[text()='Games']/following-sibling::p[text()='1h 45m']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set time limit for Games"); }
		if(a==true){test.pass("Limit Apps - Able to set time limit for Games");}
	    
		a=true;
		webDriver.findElement(By.xpath("//p[text()='Games']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='0'][1]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::div[@class='custom_select_container '][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']/following::label[@index='0'][2]")).click();
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Done']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    try{webDriver.findElement(By.xpath("//p[text()='Games']/following-sibling::p[text()='0m']"));}
	    catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set zero time limit for Games"); }
		if(a==true){test.pass("Limit Apps - Able to set zero time limit for Games");}
		
		a=true;
		webDriver.findElement(By.xpath("//p[text()='Games']/following-sibling::p[@class='the_link']")).click();
  	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
  	    try{webDriver.findElement(By.xpath("//span[text()='Games']"));
  	    	webDriver.findElement(By.xpath("//p[text()='Block usage if it exceeds']"));
  	    	webDriver.findElement(By.xpath("//span[text()='If an app from this categories is getting used in a schedule, that time will not be counted in the set limit.']"));
  	    	webDriver.findElement(By.xpath("//span[@class='p_cross']")).click();}
	    catch(NoSuchElementException e) {a=false;
		test.fail("Limit Apps - Unable to set zero time limit for Games"); }
		if(a==true){test.pass("Limit Apps - Able to set zero time limit for Games");}
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	    webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();} 
	}
	
	@Test
	public void e3_Duplicatesettings(){
		ExtentTest test=extentreport.createTest("Duplicate settings","Verify if clicking on \"Duplicate app settings to other children\" option, Duplicate App settings page is loaded.");
  		boolean a=true;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[text()='Duplicate Settings to Another Child']")).click();
		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
  	    String tit=webDriver.getTitle();
		if(tit.equals("Duplicate Settings")){test.pass("Duplicate Settings - Title is correct");}
		else{test.fail("Duplicate Settings - Title is not correct");}
		try{webDriver.findElement(By.xpath("//p[text()='Duplicate Settings']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate Settings - Header is not correct"); }
		if(a==true){test.pass("Duplicate Settings - Header is correct");}
	}
	
	@Test
	public void e4_DuplicatesettingsComponents(){
		ExtentTest test=extentreport.createTest("Duplicate settings - Components"," Verify if Duplicate App settings page has the components");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[@id='headerBack']"));
  			webDriver.findElement(By.xpath("//div[@class='profile_image_wrapper profile_42'][@title='jacky']"));
  			webDriver.findElement(By.xpath("//p[text()='Duplicate Settings']"));
  			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification')]"));
  			webDriver.findElement(By.xpath("//p[text()='Select Child User']"));
  			webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']"));
  			webDriver.findElement(By.xpath("//p[text()='Blocked Apps']"));
  			webDriver.findElement(By.xpath("//span[text()='ch1']"));
  			webDriver.findElement(By.xpath("//span[text()='vivo2']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("Duplicate App settings - page not have all components "); }
		if(a==true){test.pass("Duplicate App settings - page have all components");}
	}
	
	@Test
	public void e5_MAMChildDuplicate(){
		ExtentTest test=extentreport.createTest("MAM Child Duplicate","Verify if the list has all the manage and monitor child users in the account.");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[text()='ch1']"));
			webDriver.findElement(By.xpath("//span[text()='vivo2']"));
			webDriver.findElement(By.xpath("//span[text()='Emulator']"));
  			webDriver.findElement(By.xpath("//span[text()='MAM Automation']"));}
  		catch(NoSuchElementException e) {a=false;
  		test.fail("The list haven't all the manage and monitor child users in the account."); }
  		if(a==true){test.pass("The list have all the manage and monitor child users in the account.");}
	}
	
	@Test
	public void e6_MOChildNotDuplicate(){
		ExtentTest test=extentreport.createTest("MO Child Not Duplicate","Verify if the list doesn't show any monitor only child profile in the account.");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[text()='Jerry']"));
  			webDriver.findElement(By.xpath("//span[text()='MO Automation']"));
  			webDriver.findElement(By.xpath("//span[text()='Vikram D']"));}
		catch(NoSuchElementException e) {a=false;
		test.pass("The list doesn't show any monitor only child profile in the account."); }
		if(a==true){test.pass("The list does show any monitor only child profile in the account.");}
	}
	
	@Test
	public void e7_DuplicateSelectedChild(){
		ExtentTest test=extentreport.createTest("Duplicate Selected Child","Verify if able to duplicate the selected settings to the child profiles selected.");
  		boolean a=true;
  		try{webDriver.findElement(By.xpath("//span[text()='ch1']")).click();
  			webDriver.findElement(By.xpath("//span[text()='vivo2']")).click();
  			webDriver.findElement(By.xpath("//span[text()='Emulator']")).click();
			webDriver.findElement(By.xpath("//span[text()='MAM Automation']")).click();}
		catch(NoSuchElementException e) {a=false;
		test.fail("Unable to select all the manage and monitor child users in the account."); }
		if(a==true){test.pass("Able to select all the manage and monitor child users in the account.");}
	    try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//span[text()='ch1']")).click();
		webDriver.findElement(By.xpath("//span[text()='vivo2']")).click();
		webDriver.findElement(By.xpath("//span[text()='Emulator']")).click();
		webDriver.findElement(By.xpath("//span[text()='MAM Automation']")).click();
		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
	public void e8_Duplicateoptions(){
		ExtentTest test=extentreport.createTest("Duplicate options","Verify only able to duplicate only after selecting both options");
  		boolean a=true;
	    webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    try{webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/following::span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
	    catch(NoSuchElementException e) {a=false;
	    test.fail("Able to proceed without selecting child and settings"); }
	    if(a==true){test.pass("Unable to proceed without selecting child and settings");}
	    
	    a=true;
	    webDriver.findElement(By.xpath("//span[text()='MAM Automation']")).click();
	    webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    try{webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/following::span[text()='Required Field']"));}
	    catch(NoSuchElementException e) {a=false;
	    	test.fail("Able to proceed without selecting settings"); }
	    if(a==true){test.pass("Unable to proceed without selecting settings");}
	    
	    a=true;
	    webDriver.findElement(By.xpath("//span[text()='MAM Automation']")).click();
	    webDriver.findElement(By.xpath("//label[@for='check_all']")).click(); 
		try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    try{webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
	    catch(NoSuchElementException e) {a=false;
	    	test.fail("Able to proceed without selecting child"); }
	    if(a==true){test.pass("Unable to proceed without selecting child");}
	}
	
	@Test
	public void e9_DuplicateoneOption(){
		ExtentTest test=extentreport.createTest("Duplicate one Option","Verify if able to select any one of the options to duplicate - Block apps or Limit apps.");
  		boolean a=true;
	    webDriver.findElement(By.xpath("//span[text()='MAM Automation']")).click();
	    JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//label[@for='1']")).click(); 
	    try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e) {e.printStackTrace();}
	    webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
	    try{webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/following::span[text()='Required Field']"));
    	webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
	    catch(NoSuchElementException e) {a=false;
    		test.pass("Able to proceed only with selecting both settings with one option and child"); }
	    if(a==true){test.fail("Unable to proceed only with selecting both settings with one option and child");}
	}
	
	@Test
	public void f0_DuplicateSave(){
		ExtentTest test=extentreport.createTest("Duplicate Save","Verify if able to duplicate the settings only after clicking on Save button.");
  		boolean a=true;
  		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='duplicate_label']")).click();
		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
  		webDriver.findElement(By.xpath("//span[text()='MAM Automation']")).click();
	    webDriver.findElement(By.xpath("//label[@for='check_all']")).click();
 	    webDriver.findElement(By.xpath("//button[text()='Save']")).click();
 		try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e) {e.printStackTrace();}
 	    try{webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/following::span[text()='Required Field']"));
 	    	webDriver.findElement(By.xpath("//p[text()='Duplicate all settings']/preceding::span[text()='Required Field']"));}
 	    catch(NoSuchElementException e) {a=false;
 	    	test.pass("Able to proceed only with selecting both settings and child");}
 	    if(a==true){test.fail("Unable to proceed only with selecting both settings and child");}
		try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
	public void f1_SaveJackyAsMO() {
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='My Family']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@title='jacky']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		j.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Settings']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Save']")).click();
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
