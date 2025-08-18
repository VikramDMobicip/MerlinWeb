package Postlogin;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Prelogin.BrowserSetupClass;


public class LocatorPage extends BrowserSetup {
	
	 public void ClickwithDelay(WebDriver driver,String element) { 
	 new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	 webDriver.findElement(By.xpath(element)).click(); }

	 public void waitForElement(WebDriver driver,String element) { 
	 new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	 }
	 
	 //Scroll Till Element into center of the page
  	 public void scrollPageTillViewOf (WebDriver driver, String webElement ) {
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			waitForElement(driver,webElement);
			j.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", webDriver.findElement(By.xpath(webElement)));
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}   //Unable to ignore this static sleep - otherwise scroll function isn't worked well
	}
	 
	@Test(priority = 1)
	public void a1_locatorPage() {
		ExtentTest test = extentreport.createTest("Locator page",
				"Checking the title of the Locator page ");
		extentTest.set(test);

		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
		// ---Dash board---
		String tit = webDriver.getTitle();
		if (tit.equals("Dashboard | Mobicip")) {
			test.pass("Dashboard - title is correct ");
		} else {
			test.fail("Dashboard - title isn't correct ");
		}
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Hello Vikram!']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Dashboard - Header was Incorrect");
		}
		if (a == true) {
			test.pass("Dashboard - Header was correct");
		}

		// ---About Mobicip---
		webDriver.findElement(By.xpath("//p[text()='1Android']")).click();
		webDriver.findElement(By.xpath("//span[text()='Locator']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Locator']")));

		// ---Validation - About Mobicip ---
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("Locator | Mobicip")) {
			test.pass("Locator - page opened and title is correct ");
		} else {
			test.fail("Locator - title isn't correct ");
		}
	}

	// Checking the header components
	@Test(priority = 2)
	public void a2_AboutMobicipHeader() {
		ExtentTest test2 = extentreport.createTest("Locator - Header", "Checking the header components");
		extentTest.set(test2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='logo']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Mobicip logo is not found");
		}
		if (a == true) {
			test2.pass("Mobicip logo is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Back button is not found");
		}
		if (a == true) {
			test2.pass("Back button is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Profile icon is not present");
		}
		if (a == true) {
			test2.pass("Profile icon is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Help icon is not present");
		}
		if (a == true) {
			test2.pass("Help icon is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Notification icon is not present");
		}
		if (a == true) {
			test2.pass("Notification icon is present");
		}
	}
	
	// Checking the Locator landing page components
	@Test(priority = 3)
	public void a3_LocatorPageElements() {
		ExtentTest test3 = extentreport.createTest("Locator Page Elements", "Checking the Locator Page Elements components");
		extentTest.set(test3);
	
		scrollPageTillViewOf(webDriver,"//span[@class='time']");
		boolean a = true;
		try {webDriver.findElement(By.xpath("//span[@class='time']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Last found time");}
		if (a == true) {test3.pass("Last found time");}
		scrollPageTillViewOf(webDriver,"//span[@class='time']");
		
		a = true;
		try {webDriver.findElement(By.xpath("//span[@class='name' and text()='Last Located']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Last located text");}
		if (a == true) {test3.pass("Last located text");}
		
		a = true;
		try {webDriver.findElement(By.xpath("//span[@class='tag' and text()='others']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Last located tag");}
		if (a == true) {test3.pass("Last located tag");}
		
		a = true;
		try {webDriver.findElement(By.xpath("//a[@class='address_link']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Last located location");}
		if (a == true) {test3.pass("Last located location");}
		
		a = true;
		try {webDriver.findElement(By.xpath("//p[@class='device' and text()='iPad']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Last located device");}
		if (a == true) {test3.pass("Last located device");}
		
		a = true;
		try {webDriver.findElement(By.xpath("//span[ text()='Show saved places']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Show saved places");}
		if (a == true) {test3.pass("Show saved places");}

		a = true;
		try {webDriver.findElement(By.xpath("//span[ text()='Location History']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("//span[ text()='Location History']");}
		if (a == true) {test3.pass("Last located tag");}
		
		a = true;
		try {webDriver.findElement(By.xpath("//div[@class='map_container']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Map section");}
		if (a == true) {test3.pass("Map section");}
		
		scrollPageTillViewOf(webDriver,"//span[text()='Mark a Place']");
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='Mark a Place']"));}
		catch (NoSuchElementException e) {a = false;
			test3.fail("Mark a Place");}
		if (a == true) {test3.pass("Mark a Place");}
		scrollPageTillViewOf(webDriver,"//span[ text()='Show saved places']");

	}
	
	// Checking the Locator Show saved places page components
	@Test(priority = 4)
	public void a4_SavedPlaceElements() {
		ExtentTest test4 = extentreport.createTest("Show saved places Elements", "Checking the Locator Show saved places Elements components");
		extentTest.set(test4);
		
		scrollPageTillViewOf(webDriver,"//span[ text()='Show saved places']");
		webDriver.findElement(By.xpath("//span[ text()='Show saved places']")).click();
		waitForElement(webDriver, "//p[text()='Saved Places']");
		
		boolean a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Saved Places']"));}
		catch (NoSuchElementException e) {a = false;
			test4.fail("Saved Places title");}
		if (a == true) {test4.pass("Saved Places title");}

		a = true;
		try {webDriver.findElement(By.xpath("//div[@class='location_type_switch']"));}
		catch (NoSuchElementException e) {a = false;
			test4.fail("Location type filter");}
		if (a == true) {test4.pass("Location type filter");}
		waitForElement(webDriver, "//span[text()='salem danger']");

		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='salem danger']"));
		webDriver.findElement(By.xpath("//span[text()='dangerous']"));
		webDriver.findElement(By.xpath("//p[text()='Salem, Tamil Nadu, India']"));
		webDriver.findElement(By.xpath("//div[@class='icon_location_type dangerous']"));
		webDriver.findElement(By.xpath("//span[text()='salem danger']/ancestor::li[@class='location_li']//a[text()='Edit']"));
		webDriver.findElement(By.xpath("//span[text()='salem danger']/ancestor::li[@class='location_li']//span[text()='Remove']"));}
		catch (NoSuchElementException e) {a = false;
			test4.fail("Salem Added Info");}
		if (a == true) {test4.pass("Salem Added Info");}
		
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='erode schl']"));
		webDriver.findElement(By.xpath("//span[text()='school']"));
		webDriver.findElement(By.xpath("//p[text()='Erode, Tamil Nadu, India']"));
		webDriver.findElement(By.xpath("//div[@class='icon_location_type school']"));
		webDriver.findElement(By.xpath("//span[text()='erode schl']/ancestor::li[@class='location_li']//a[text()='Edit']"));
		webDriver.findElement(By.xpath("//span[text()='erode schl']/ancestor::li[@class='location_li']//span[text()='Remove']"));}
		catch (NoSuchElementException e) {a = false;
			test4.fail("erode schl Added Info");}
		if (a == true) {test4.pass("erode schl Added Info");}
		}
		
	// Checking the Locator Location History page components
	@Test(priority = 5)
	public void a5_LocationHistoryElements() {
		ExtentTest test5 = extentreport.createTest("Location History Elements", "Checking the Locator Location History Elements components");
		extentTest.set(test5);
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		waitForElement(webDriver, "//span[ text()='Location History']");
		scrollPageTillViewOf(webDriver,"//span[ text()='Location History']");
		webDriver.findElement(By.xpath("//span[ text()='Location History']")).click();
		waitForElement(webDriver, "//p[ text()='Location History']");
		waitForElement(webDriver, "//span[text()='No locations found']");
		boolean a = true;
		try{webDriver.findElement(By.xpath("//p[text()='Location History']"));}
		catch (NoSuchElementException e) {a = false;
			test5.fail("Location History Title");}
		if (a == true) {test5.pass("Location History Title");}
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='No locations found']"));}
		catch (NoSuchElementException e) {a = false;
			test5.fail("No locations found");}
		if (a == true) {test5.pass("No locations found");}
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='Filter']"));}
		catch (NoSuchElementException e) {a = false;
			test5.fail("Filter - History");}
		if (a == true) {test5.pass("Filter - History");}
		webDriver.findElement(By.xpath("//span[text()='Filter']")).click();
		waitForElement(webDriver, "//p[text()='Location']");
		a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Location']"));
		webDriver.findElement(By.xpath("//p[text()='Visited']"));
		webDriver.findElement(By.xpath("//label[text()='Home']"));
		webDriver.findElement(By.xpath("//label[text()='School']"));
		webDriver.findElement(By.xpath("//label[text()='Dangerous']"));
		webDriver.findElement(By.xpath("//label[text()='Others']"));
		webDriver.findElement(By.xpath("//label[text()='Today']"));
		webDriver.findElement(By.xpath("//label[text()='Yesterday']"));
		webDriver.findElement(By.xpath("//label[text()='30 days']"));
		webDriver.findElement(By.xpath("//label[text()='7 days']"));}
		catch (NoSuchElementException e) {a = false;
			test5.fail("Filter - Option");}
		if (a == true) {test5.pass("Filter - Option");}		
	}
	// Checking the Locator Show saved places page components
	@Test(priority = 6)
	public void a6_MarkAPlaceElements() {
			ExtentTest test6 = extentreport.createTest("Mark A Place elements", "Checking the Mark a place Elements components");
			extentTest.set(test6);
			webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
			waitForElement(webDriver, "//span[ text()='Location History']");
			scrollPageTillViewOf(webDriver,"//span[ text()='Location History']");
			scrollPageTillViewOf(webDriver,"//span[text()='Mark a Place']");
			webDriver.findElement(By.xpath("//span[text()='Mark a Place']")).click();
			waitForElement(webDriver, "//p[text()='Mark a Place']");
			waitForElement(webDriver, "//input[@placeholder='Type an Address']");
			
			boolean a = true;
			try{webDriver.findElement(By.xpath("//p[text()='Mark a Place']"));}
			catch (NoSuchElementException e) {a = false;
				test6.fail("Mark A Title Title");}
			if (a == true) {test6.pass("Mark A Title Title");}
			
			a = true;
			try {webDriver.findElement(By.xpath("//input[@placeholder='Type an Address']"));}
			catch (NoSuchElementException e) {a = false;
				test6.fail("Type an address input");}
			if (a == true) {test6.pass("Type an address input");}
			
			a = true;
			try {webDriver.findElement(By.xpath("//div[@class='map_container']"));}
			catch (NoSuchElementException e) {a = false;
				test6.fail("Map container");}
			if (a == true) {test6.pass("Map container");}
			scrollPageTillViewOf(webDriver,"//p[@class='stitle' and text()='Mark a place']");

			a = true;
			try {webDriver.findElement(By.xpath("//p[@class='stitle' and text()='Mark a place']"));
			webDriver.findElement(By.xpath("//label[text()='home']"));
			webDriver.findElement(By.xpath("//label[text()='school']"));
			webDriver.findElement(By.xpath("//label[text()='dangerous']"));
			webDriver.findElement(By.xpath("//label[text()='others']"));
			webDriver.findElement(By.xpath("//label[text()='Place']"));
			webDriver.findElement(By.xpath("//input[@name='name']"));
			webDriver.findElement(By.xpath("//label[text()='Address']"));
			webDriver.findElement(By.xpath("//input[@name='address']"));
			}
			catch (NoSuchElementException e) {a = false;
				test6.fail("Mark A Place Inputs");}
			if (a == true) {test6.pass("Mark A Place");}
			
			scrollPageTillViewOf(webDriver,"//button[text()='Save']");

			try {webDriver.findElement(By.xpath("//button[text()='Save']"));
			webDriver.findElement(By.xpath("//p[text()='Notify me when ']"));
			webDriver.findElement(By.xpath("//p[text()='Enters the place']"));
			webDriver.findElement(By.xpath("//p[text()='Leaves the place']"));
			webDriver.findElement(By.xpath("//label[@for='alert_on_entry']"));
			webDriver.findElement(By.xpath("//label[@for='alert_on_exit']"));}
			catch (NoSuchElementException e) {a = false;
				test6.fail("Mark A Place Notifications settings");}
			if (a == true) {test6.pass("Mark A Place Notifications settings");}
			
	}
	
	// Checking the Locator Show saved places page components
	@Test(priority = 7)
	public void a7_MarkAPlaceAdd() {
			ExtentTest test7 = extentreport.createTest("Mark A Place Add case", "Checking the Mark a place adding location cases");
			extentTest.set(test7);
			scrollPageTillViewOf(webDriver,"//button[text()='Save']");
			webDriver.findElement(By.xpath("//button[text()='Save']")).click();
			waitForElement(webDriver, "//div[@class='location_type_wrapper has_error']//span[text()='Required Field']");
			
			boolean a = true;
			try{webDriver.findElement(By.xpath("//div[@class='location_type_wrapper has_error']//span[text()='Required Field']"));}
			catch (NoSuchElementException e) {a = false;
				test7.fail("Location type error");}
			if (a == true) {test7.pass("Location type error");}
			
			a = true;
			try{webDriver.findElement(By.xpath("//div[@class='input_wrapper has_error']//span[text()='Required Field']"));}
			catch (NoSuchElementException e) {a = false;
				test7.fail("Location name error");}
			if (a == true) {test7.pass("Location name error");}
						
			scrollPageTillViewOf(webDriver,"//input[@name='name']");
			webDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("Coimbatore north");
			webDriver.findElement(By.xpath("//label[text()='home']")).click();
			scrollPageTillViewOf(webDriver,"//input[@placeholder='Type an Address']");
			webDriver.findElement(By.xpath("//input[@placeholder='Type an Address']")).sendKeys("Erode");
			waitForElement(webDriver, "//span[text()='Erode']/parent::li[@id='-1794496277']");
			webDriver.findElement(By.xpath("//span[text()='Erode']/parent::li[@id='-1794496277']")).click();
			a = true;
			scrollPageTillViewOf(webDriver,"//button[text()='Save']");
			webDriver.findElement(By.xpath("//button[text()='Save']")).click();
			waitForElement(webDriver, "//span[text()='Location already exists']");
			try{webDriver.findElement(By.xpath("//span[text()='Location already exists']"));}
			catch (NoSuchElementException e) {a = false;
				test7.fail("Place already added error");}
			if (a == true) {test7.pass("Place already added error");}
			
			scrollPageTillViewOf(webDriver,"//input[@placeholder='Type an Address']");
			webDriver.findElement(By.xpath("//input[@placeholder='Type an Address']")).clear();
			webDriver.findElement(By.xpath("//input[@placeholder='Type an Address']")).sendKeys("Coimbatore north");
			waitForElement(webDriver, "//span[text()='North']/parent::li[@id='-665762964']");
			webDriver.findElement(By.xpath("//span[text()='North']/parent::li[@id='-665762964']")).click();
			a = true;
			waitForElement(webDriver, "//input[@value='Coimbatore North, Tamil Nadu, India' and @readonly]");

			try{webDriver.findElement(By.xpath("//input[@value='Coimbatore North, Tamil Nadu, India' and @readonly]"));}
			catch (NoSuchElementException e) {a = false;
				test7.fail("Place selected properly");}
			if (a == true) {test7.pass("Place selected properly");}
			scrollPageTillViewOf(webDriver,"//label[@for='alert_on_entry']");
			webDriver.findElement(By.xpath("//label[@for='alert_on_entry']")).click();
			scrollPageTillViewOf(webDriver,"//button[text()='Save']");
			webDriver.findElement(By.xpath("//button[text()='Save']")).click();

			a = true;
			scrollPageTillViewOf(webDriver,"//span[text()='Coimbatore north']");
			scrollPageTillViewOf(webDriver,"//span[text()='Coimbatore north']/ancestor::li[@class='location_li']//span[text()='Remove']");
			try {webDriver.findElement(By.xpath("//span[text()='Coimbatore north']"));
			webDriver.findElement(By.xpath("//span[text()='home']"));
			webDriver.findElement(By.xpath("//p[text()='Coimbatore North, Tamil Nadu, India']"));
			webDriver.findElement(By.xpath("//div[@class='icon_location_type home']"));
			webDriver.findElement(By.xpath("//span[text()='Coimbatore north']/ancestor::li[@class='location_li']//span[text()='Remove']"));
			webDriver.findElement(By.xpath("//span[text()='Coimbatore north']/ancestor::li[@class='location_li']//a[text()='Edit']"));}
			catch (NoSuchElementException e) {a = false;
				test7.fail("coimbatore north Added Info");}
			if (a == true) {test7.pass("coimbatore north Added Info");}
	}
			
	// Checking the Locator Show saved places page components
	@Test(priority = 8)
	public void a8_MarkAPlaceEdit() throws InterruptedException {
			ExtentTest test8 = extentreport.createTest("Mark A Place Edit case", "Checking the Mark a place adding location cases");
			extentTest.set(test8);
			scrollPageTillViewOf(webDriver,"//span[text()='Coimbatore north']/ancestor::li[@class='location_li']//a[text()='Edit']");
			webDriver.findElement(By.xpath("//span[text()='Coimbatore north']/ancestor::li[@class='location_li']//a[text()='Edit']")).click();
			waitForElement(webDriver, "//input[@placeholder='Type an Address']");
						
			scrollPageTillViewOf(webDriver,"//input[@name='name']");			
			webDriver.findElement(By.xpath("//input[@name='name']")).clear();
			webDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("Namakkal");
			webDriver.findElement(By.xpath("//label[text()='others']")).click();
			scrollPageTillViewOf(webDriver,"//input[@placeholder='Type an Address']");
			webDriver.findElement(By.xpath("//input[@placeholder='Type an Address']")).sendKeys("Namakkal");
			waitForElement(webDriver, "//span[text()='Namakkal']/parent::li[@id='-1509815012']");
			webDriver.findElement(By.xpath("//span[text()='Namakkal']/parent::li[@id='-1509815012']")).click();
			boolean a = true;
			waitForElement(webDriver, "//input[@value='Namakkal, Tamil Nadu, India' and @readonly]");
			scrollPageTillViewOf(webDriver,"//input[@value='Namakkal, Tamil Nadu, India' and @readonly]");

			try{webDriver.findElement(By.xpath("//input[@value='Namakkal, Tamil Nadu, India' and @readonly]"));}
			catch (NoSuchElementException e) {a = false;
				test8.fail("Place changed selection shown properly");}
			
			scrollPageTillViewOf(webDriver,"//label[@for='alert_on_entry']");
			webDriver.findElement(By.xpath("//label[@for='alert_on_entry']")).click();
			webDriver.findElement(By.xpath("//label[@for='alert_on_exit']")).click();
			scrollPageTillViewOf(webDriver,"//button[text()='Save']");
			webDriver.findElement(By.xpath("//button[text()='Save']")).click();

			a = true;
			scrollPageTillViewOf(webDriver,"//span[text()='others']");
			scrollPageTillViewOf(webDriver,"//span[text()='Namakkal']/ancestor::li[@class='location_li']//a[text()='Edit']");

			try {webDriver.findElement(By.xpath("//span[text()='Namakkal']"));
			webDriver.findElement(By.xpath("//span[text()='others']"));
			webDriver.findElement(By.xpath("//p[text()='Namakkal, Tamil Nadu, India']"));
			webDriver.findElement(By.xpath("//div[@class='icon_location_type others']"));
			webDriver.findElement(By.xpath("//span[text()='Namakkal']/ancestor::li[@class='location_li']//a[text()='Edit']"));
			webDriver.findElement(By.xpath("//span[text()='Namakkal']/ancestor::li[@class='location_li']//span[text()='Remove']"));}
			catch (NoSuchElementException e) {a = false;
				test8.fail("Namakkal Edited Info");}
			if (a == true) {test8.pass("Namakkal Edited Info");}
			try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}   //Unable to ignore this static sleep - otherwise scroll function isn't worked well}
			scrollPageTillViewOf(webDriver,"//span[text()='Namakkal']/ancestor::li[@class='location_li']//span[text()='Remove']");

			webDriver.findElement(By.xpath("//span[text()='Namakkal']/ancestor::li[@class='location_li']//span[text()='Remove']")).click();
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}   //Unable to ignore this static sleep - otherwise scroll function isn't worked well}
			
			TimeUnit.SECONDS.sleep(2);
			
			a = true;
			try {webDriver.findElement(By.xpath("//span[text()='Namakkal']"));}
			catch (NoSuchElementException e) {a = false;
				test8.pass("Namakkal Deleted ");}
			if (a == true) {test8.fail("Namakkal Deleted");}
			
			webDriver.findElement(By.xpath("//a[@class='logo']")).click();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
	public void captureconsolelogs() {
	List<String> errors = BrowserSetupClass.getConsoleErrors();
	if (!errors.isEmpty()) {
		for (String error : errors) {
			extentTest.get().log(Status.FAIL, "Console Error: " + error);
		}
	}
}
			
}
