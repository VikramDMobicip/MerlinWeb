package Postlogin;
// Need to change the internal plan dates if current plan expired in live account alone. 

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Prelogin.BrowserSetupClass;


public class MyMobicip  extends BrowserSetup {

	// Checking for the title of home page and My mobicip page.
	@Test(priority = 1)
	public void a1_homepage() {
		ExtentTest test = extentreport.createTest("My Mobicip page",
				"Checking the title of the My Mobicip page ");
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
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user_profile_container']")));
		// ---My Mobicip---
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		waitSeconds(2);
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();

		a = true;
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Mobicip']")));

		try {
			webDriver.findElement(By.xpath("//span[text()='My Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("My Mobicip - Option not present in container");
		}
		if (a == true) {
			test.pass("My Mobicip - Option present in container");
		}
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='My Mobicip']")));
		
		
		// ---Validation - My Mobicip ---
		// Title
		tit = webDriver.getTitle();
		if (tit.equals("My Mobicip | Mobicip")) {
			test.pass("My Mobicip - page opened and title is correct ");
		} else {
			test.fail("My Mobicip - title isn't correct ");
		}
	}

	// Checking the header components
	@Test(priority = 2)
	public void a2_MyMobicipHeader() {
		ExtentTest test2 = extentreport.createTest("My Mobicip - Header", "Checking the header components");
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
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='My Mobicip']")));
		try {
			webDriver.findElement(By.xpath("//p[text()='My Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("My Mobicip -  Header is incorrect");
		}
		if (a == true) {
			test2.pass("My Mobicip - Header is correct");
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
	
	// Checking the My mobicip - Landing page elements
	@Test(priority = 3)
	public void a3_MyMobicipLandingpage() {
		ExtentTest test3 = extentreport.createTest("My Mobicip - Landing page", "Checking the Landing page components");
		extentTest.set(test3);
			boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='image_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Profile image is not found");
		}
		if (a == true) {
			test3.pass("Profile image is present");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='icon_edit']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Profile Edit is not found");
		}
		if (a == true) {
			test3.pass("Profile Edit button is present");
		}
		
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[@class='name' and text()='Vikram']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Profile name is not found");
		}
		if (a == true) {
			test3.pass("Profile name is present");
		}
		
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='text' and text()='vikram+1@mobicip.com']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Profile mail is not found");
		}
		if (a == true) {
			test3.pass("Profile mail is present");
		}
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text' and text()='9677998852']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='text' and text()='9677998852']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Profile phone number is not found");
		}
		if (a == true) {
			test3.pass("Profile phone number is present");
		}
		
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='primary_button' and text()='Reset Password']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Reset password option is not found");
		}
		if (a == true) {
			test3.pass("Reset password option is present");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='label' and text()='My Plan']"));
			webDriver.findElement(By.xpath("//span[@class='label' and text()='My Plan']/following-sibling::span[@class='icon_right_arrow']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("My plan option is not found");
		}
		if (a == true) {
			test3.pass("My plan option is present with arrow");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='label' and text()='My Family']"));
			webDriver.findElement(By.xpath("//span[@class='label' and text()='My Family']/following-sibling::span[@class='icon_right_arrow']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("My Family option is not found");
		}
		if (a == true) {
			test3.pass("My Family option is present with arrow");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='label' and text()='Monitoring Devices ']"));
			webDriver.findElement(By.xpath("//span[@class='label' and text()='Monitoring Devices ']/following-sibling::span[@class='icon_right_arrow']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Monitoring Devices option is not found");
		}
		if (a == true) {
			test3.pass("Monitoring Devices option is present with arrow");
		}
	}
	
	public void waitTillElement(WebDriver webDriver,String WebElement) {
		new WebDriverWait(webDriver, Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElement)));}
	
	public void waitSeconds(int seconds) {
		try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e1) {e1.printStackTrace();}}
	
	public void isElementPresent(WebDriver webDriver,ExtentTest test,String WebElement,String TestCase) {
		boolean a = true;
		try {webDriver.findElement(By.xpath(WebElement));}
		catch (NoSuchElementException e) {a = false;
			test.fail(TestCase);}
		if (a == true) {test.pass(TestCase);}}
	
	//Scroll Till Element into center of the page
	public void scrollPageTillViewOf (WebDriver driver , String webelement) {
		JavascriptExecutor j = (JavascriptExecutor)webDriver;
		waitTillElement(driver , webelement);
		WebElement webElement = driver.findElement(By.xpath(webelement));
		j.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", webElement);
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}   //Unable to ignore this static sleep - otherwise scroll function isn't worked well}
	}	

	// Checking the My mobicip - Profile edit page
	@Test(priority = 4)
	public void a4_ProfileEdit() {
		ExtentTest test4 = extentreport.createTest("Profile Edit page", "Checking the Profile Edit page components");
		extentTest.set(test4);
		webDriver.findElement(By.xpath("//a[@class='icon_edit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Edit Profile']")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Edit Profile']"));
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile edit page header elemtent");
		}
		if (a == true) {
			test4.pass("Profile edit page header elemtent");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='thumbnail_upload_wrapper']"));
			webDriver.findElement(By.xpath("//input[@id='thumbnail']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile image and edit is not found");
		}
		if (a == true) {
			test4.pass("Profile image and edit is present");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Name']"));
			webDriver.findElement(By.xpath("//input[@name='user_name']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile name and edit is not found");
		}
		if (a == true) {
			test4.pass("Profile name and edit is present");
		}
		webDriver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("Vikram#$@");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Save']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Only alphanumeric accepted']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Only alphanumeric accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile name validation not works");
		}
		if (a == true) {
			test4.pass("Profile name validation works");
		}
		webDriver.findElement(By.xpath("//input[@name='user_name']")).clear();
		webDriver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("Vikram");
		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Phone Number']"));
			webDriver.findElement(By.xpath("//input[@name='user_phone_no']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile number and edit is not found");
		}
		if (a == true) {
			test4.pass("Profile number and edit is present");
		}
		webDriver.findElement(By.xpath("//input[@name='user_phone_no']")).sendKeys("12");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Save']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Must be a 10 digit number']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Must be a 10 digit number']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile 10 numbers validation not works");
		}
		if (a == true) {
			test4.pass("Profile 10 numbers validation works");
		}
		webDriver.findElement(By.xpath("//input[@name='user_phone_no']")).sendKeys("#$@");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Save']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Only numbers accepted']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Only numbers accepted']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile numbers only validation not works");
		}
		if (a == true) {
			test4.pass("Profile numbers only validation works");
		}
		webDriver.findElement(By.xpath("//input[@name='user_phone_no']")).clear();
		webDriver.findElement(By.xpath("//input[@name='user_phone_no']")).sendKeys("9677998852");
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='vikram+1@mobicip.com' and @disabled]")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Email Address']"));
			webDriver.findElement(By.xpath("//input[@value='vikram+1@mobicip.com' and @disabled]"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile mail id and disabled to edit is not found");
		}
		if (a == true) {
			test4.pass("Profile mail id and disabled to edit is found");
		}
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[text()='Cancel']"));
			webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Save']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Save and cancel button present");
		}
		if (a == true) {
			test4.pass("Save and cancel button not present");
		}
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Save']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='name' and text()='Vikram']")));
		a = true;
		try {
			webDriver.findElement(By.xpath("//h1[@class='name' and text()='Vikram']"));
			webDriver.findElement(By.xpath("//p[@class='text' and text()='vikram+1@mobicip.com']"));
			webDriver.findElement(By.xpath("//p[@class='text' and text()='9677998852']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Profile not saved when valid credentials added");
		}
		if (a == true) {
			test4.pass("Profile saved successfully when valid credentials added");
		}
		
	}
	
	// Checking the My mobicip - Reset password page
	@Test(priority = 5)
	public void a_ResetPassword() {
		ExtentTest test5 = extentreport.createTest("Reset Password", "Checking the Reset password option");
		extentTest.set(test5);
		webDriver.findElement(By.xpath("//a[@class='primary_button' and text()='Reset Password']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Reset Password']")));
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Reset Password']"));
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Reset Password page header elemtent");}
		if (a == true) {
			test5.pass("Reset Password page header elemtent");}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Please enter your existing password followed by your new Password.']"));} 
		catch (NoSuchElementException e) {a = false;
			test5.fail("Reset password info not present");}
		if (a == true) {
			test5.pass("Reset password info present");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='Old Password']"));
			webDriver.findElement(By.xpath("//input[@placeholder='Type in your old password' and @name='current_password']"));}
		catch (NoSuchElementException e) {a = false;
			test5.fail("Old password is not found");}
		if (a == true) {test5.pass("Old password and edit is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='New Password']"));
			webDriver.findElement(By.xpath("//input[@placeholder='Type in your new password' and @name='new_password']"));}
		catch (NoSuchElementException e) {a = false;
		test5.fail("New password is not found");}
		if (a == true) {test5.pass("New password and edit is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='Confirm Password']"));
			webDriver.findElement(By.xpath("//input[@placeholder='Confirm your new password' and @name='confirm_password']"));}
		catch (NoSuchElementException e) {a = false;
		test5.fail("Confirm password is not found");}
		if (a == true) {test5.pass("Confirm password and edit is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//div[text()='Cancel']"));
			webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Submit']"));}
		catch (NoSuchElementException e) {a = false;
		test5.fail("Submit and cancel is not found");}
		if (a == true) {test5.pass("Submit and cancel and edit is present");}
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='new_password']/parent::div/following-sibling::p//span[text()='Required Field']")));
		a = true;
		try {webDriver.findElement(By.xpath("//input[@name='new_password']/parent::div/following-sibling::p//span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//input[@name='confirm_password']/parent::div/following-sibling::p//span[text()='Required Field']"));
			webDriver.findElement(By.xpath("//input[@name='current_password']/parent::div/following-sibling::p//span[text()='Required Field']"));}
		catch (NoSuchElementException e) {a = false;
		test5.fail("Required Field error is not shown and validated");}
		if (a == true) {test5.pass("Required Field error is shown and validated");}
		webDriver.findElement(By.xpath("//input[@placeholder='Type in your new password' and @name='new_password']")).sendKeys("1a");
		webDriver.findElement(By.xpath("//input[@placeholder='Confirm your new password' and @name='confirm_password']")).sendKeys("1234");
		webDriver.findElement(By.xpath("//input[@placeholder='Type in your old password' and @name='current_password']")).sendKeys("123");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='new_password']/parent::div/following-sibling::p//span[text()='Must be at least 5 characters long']")));
		a = true;
		try {webDriver.findElement(By.xpath("//input[@name='new_password']/parent::div/following-sibling::p//span[text()='Must be at least 5 characters long']"));}
		catch (NoSuchElementException e) {a = false;
		test5.fail("Must be at least 5 characters long is not shown and validated");}
		if (a == true) {test5.pass("Must be at least 5 characters long is shown and validated");}
		webDriver.findElement(By.xpath("//input[@placeholder='Confirm your new password' and @name='confirm_password']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Type in your new password' and @name='new_password']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Type in your new password' and @name='new_password']")).sendKeys("11223");
		webDriver.findElement(By.xpath("//input[@placeholder='Confirm your new password' and @name='confirm_password']")).sendKeys("abcde");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='confirm_password']/parent::div/following-sibling::p//span[contains(text(),'Both Passwords didn')]")));
		a = true;
		try {webDriver.findElement(By.xpath("//input[@name='confirm_password']/parent::div/following-sibling::p//span[contains(text(),'Both Passwords didn')]"));}		
		catch (NoSuchElementException e) {a = false;
		test5.fail("Both Passwords didn't matched is not shown and validated");}
		if (a == true) {test5.pass("Both Passwords didn't matched is shown and validated");}
		webDriver.findElement(By.xpath("//input[@placeholder='Confirm your new password' and @name='confirm_password']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Confirm your new password' and @name='confirm_password']")).sendKeys("11223");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Current Password is incorrect']")));
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='Current Password is incorrect']"));}		
		catch (NoSuchElementException e) {a = false;
		test5.fail("Current Password is incorrect is not shown and validated");}
		if (a == true) {test5.pass("Current Password is incorrect is shown and validated");}
		webDriver.findElement(By.xpath("//input[@placeholder='Type in your old password' and @name='current_password']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Type in your old password' and @name='current_password']")).sendKeys("11223");
		webDriver.findElement(By.xpath("//button[@class='primary_button' and text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='My Mobicip']")));
		a = true;
		try {webDriver.findElement(By.xpath("//p[text()='My Mobicip']"));}		
		catch (NoSuchElementException e) {a = false;
		test5.fail("Reset password not saved");}
		if (a == true) {test5.pass("Reset password saved and redirected to mymobicip page");}
	}

	// Checking the header components
	@Test(priority = 6)
	public void a6_MyPlansPage() throws InterruptedException {
		ExtentTest test6 = extentreport.createTest("My Plans - Elements", "Checking the My Plans components");
		extentTest.set(test6);
		webDriver.findElement(By.xpath("//span[@class='label' and text()='My Plan']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Current Plan Details']")));
		boolean a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Current Plan Details']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Title is not found");}
		if (a == true) {test6.pass("My Plans - Title is present");}	
		a = true;
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Internal Plan ']")));
		try {webDriver.findElement(By.xpath("//p[text()='Internal Plan ']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plan name is not found");}
		if (a == true) {test6.pass("My Plans - Plan name is present");}	
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("My Plans page header elemtent");}
		if (a == true) {
			test6.pass("My Plans page header elemtent");}
		a = true;
		TimeUnit.SECONDS.sleep(3);
		try {webDriver.findElement(By.xpath("//p[text()='Features Included']"));
		webDriver.findElement(By.xpath("//p[text()='5' and text()=' Managed ' and text()='Devices']"));
		webDriver.findElement(By.xpath("//p[text()='Screen Time Limits']"));
		webDriver.findElement(By.xpath("//p[text()='Uninstall Protection']"));
		webDriver.findElement(By.xpath("//p[text()='Social Media Monitor']"));
		webDriver.findElement(By.xpath("//p[text()='Remotely Lock Devices']"));
		webDriver.findElement(By.xpath("//p[text()='Parenting Expert Tips']"));
		webDriver.findElement(By.xpath("//p[text()='Activity Reports']"));
		webDriver.findElement(By.xpath("//p[text()='Family Locator']"));
		webDriver.findElement(By.xpath("//p[text()='App Timers']"));
		webDriver.findElement(By.xpath("//p[text()='Website Blocker']"));
		webDriver.findElement(By.xpath("//p[text()='Activity Schedules']"));
		webDriver.findElement(By.xpath("//p[text()='App Blocker']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plan features are not found");}
		if (a == true) {test6.pass("My Plans - Plan features are present");}	
		a = true;
		
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View Plan History']")));
		
		try {webDriver.findElement(By.xpath("//span[text()='View Plan History']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - View plan History page is not found");}
		if (a == true) {test6.pass("My Plans - View plan History page is present");}
		webDriver.findElement(By.xpath("//span[text()='View Plan History']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Plan History']")));
		a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Plan History']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plan History title is not found");}
		if (a == true) {test6.pass("My Plans - Plan Historytitle is present");}	
		if(environment==2) { // cases only for Live //Check dates if changed
		a = true;
		TimeUnit.SECONDS.sleep(5);
		try {webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//p[text()='Internal Plan']"));
		webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//p[text()='1-year']"));
		webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//span[text()='Purchase date']"));
		webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//span[text()='Purchased through']"));
		webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//span[text()='Status']"));
		webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//b[text()='Mobicip']"));
		webDriver.findElement(By.xpath("//b[text()='Active']/ancestor::div[@class='basic_plan plan_container']//b[text()='07/22/2024']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plan history active elements are not found - Please check purchase date once in script");}
		if (a == true) {test6.pass("My Plans - Plan history active elements are found");}	
		a = true;
		try {webDriver.findElement(By.xpath("//b[text()='07/22/2024']/ancestor::div[@class='basic_plan plan_container']//p[text()='Basic Plan']"));
		webDriver.findElement(By.xpath("//b[text()='07/22/2024']/ancestor::div[@class='basic_plan plan_container']//b[text()='Expired']"));
		webDriver.findElement(By.xpath("//b[text()='07/22/2024']/ancestor::div[@class='basic_plan plan_container']//span[text()='Expired on']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plan history expired elements are not found - Please check expired date once in script");}
		if (a == true) {test6.pass("My Plans - Plan history expired elements are found");}}
		a = true;
		try {webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("My Plans - Plan history page header elemtent");}
		if (a == true) {
			test6.pass("My Plans - Plan history page header elemtent");}
		webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Change Plan']")));
		a = true;
		try {webDriver.findElement(By.xpath("//a[text()='Change Plan']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Change Plan is not found");}
		if (a == true) {test6.pass("My Plans - Change Plan is present");}
		a = true;
		webDriver.findElement(By.xpath("//a[text()='Change Plan']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Plans']")));
		try {webDriver.findElement(By.xpath("//p[text()='Plans']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plans title is not found");}
		if (a == true) {test6.pass("My Plans - Plans title is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Select the plan that works for ']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Plans subtitle is not found");}
		if (a == true) {test6.pass("My Plans - Plans subtitle is present");}
		a = true;
		TimeUnit.SECONDS.sleep(2);
		try {webDriver.findElement(By.xpath("//h2[text()='Premium']"));
			webDriver.findElement(By.xpath("//span[text()='20']"));
			webDriver.findElement(By.xpath("//span[text()='$']/following-sibling::span[text()='7.99']"));
			webDriver.findElement(By.xpath("//span[text()='7.99']/following-sibling::span[text()='/mo']"));
			webDriver.findElement(By.xpath("//h2[text()='Premium']/following-sibling::span[text()='Billed Annually']"));	} catch (NoSuchElementException e) {a = false;
			test6.fail("Premium elements is not found");}
		if (a == true) {test6.pass("Premium elements is present");}
		a = true;
		TimeUnit.SECONDS.sleep(2);
		try {webDriver.findElement(By.xpath("//h2[text()='Standard']"));
		webDriver.findElement(By.xpath("//span[text()='10']"));
			webDriver.findElement(By.xpath("//span[text()='$']/following-sibling::span[text()='4.99']"));
			webDriver.findElement(By.xpath("//span[text()='4.99']/following-sibling::span[text()='/mo']"));
			webDriver.findElement(By.xpath("//h2[text()='Standard']/following-sibling::span[text()='Billed Annually']"));	} catch (NoSuchElementException e) {a = false;
			test6.fail("Standard elements is not found");}
		if (a == true) {test6.pass("Standard elements is present");}
		a = true;
		TimeUnit.SECONDS.sleep(2);
		try {webDriver.findElement(By.xpath("//h2[text()='Lite']"));
		webDriver.findElement(By.xpath("//span[text()='5']"));
			webDriver.findElement(By.xpath("//span[text()='$']/following-sibling::span[text()='2.99']"));
			webDriver.findElement(By.xpath("//span[text()='2.99']/following-sibling::span[text()='/mo']"));
			webDriver.findElement(By.xpath("//h2[text()='Lite']/following-sibling::span[text()='Billed Annually']"));
			} catch (NoSuchElementException e) {a = false;
			test6.fail("Lite elements is not found");}
		if (a == true) {test6.pass("Lite elements is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='Premium' and 'Plan']"));
			webDriver.findElement(By.xpath("//a[text()='Have Questions?']"));
			webDriver.findElement(By.xpath("//a[text()='Upgrade']"));
			} catch (NoSuchElementException e) {a = false;
			test6.fail("Footer pricing elements is not found");}
		if (a == true) {test6.pass("Footer pricing elements is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("My Plans - Plans pricing page header elemtent");}
		if (a == true) {
			test6.pass("My Plans - Plan pricing page header elemtent");}
		webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Cancel Plan']")));
		a = true;
		try {webDriver.findElement(By.xpath("//a[text()='Cancel Plan']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Cancel Plan is not found");}
		if (a == true) {test6.pass("My Plans - Cancel Plan is present");}
		a = true;
		webDriver.findElement(By.xpath("//a[text()='Cancel Plan']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Cancel Subscription']")));
		a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Cancel Subscription']"));} catch (NoSuchElementException e) {a = false;
			test6.fail("My Plans - Cancel Plan title is not found");}
		if (a == true) {test6.pass("My Plans - Cancel Plan title is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//a[@class='logo']"));
		webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
		webDriver.findElement(By.xpath("//a[@class='help_icon']"));
		webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel page header elemtent");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel page header elemtent");}
		a = true;
		try {webDriver.findElement(By.xpath("//h5[text()='We are sorry to see you go…']"));
		webDriver.findElement(By.xpath("//p[contains(text(),'appreciate if you can let us know the reason for your cancellation.')]"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel page Info is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel page Info is shown");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='Email Address']"));
		webDriver.findElement(By.xpath("//input[@value='vikram+1@mobicip.com' and @readonly]"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel Email Info is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel Email Info is shown");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='Phone Number*']"));
		webDriver.findElement(By.xpath("//input[@value='9677998852']"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel Phone Info is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel Phone Info is shown");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='Subject']"));
		webDriver.findElement(By.xpath("//input[@value='Cancel Plan' and @readonly]"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel Subject Info is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel Subject Info is shown");}
		a = true;
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,3000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Did not have features I need']/parent::div//div//label[@for='reason4']")));
		try {webDriver.findElement(By.xpath("//p[text()='Reason']"));
		webDriver.findElement(By.xpath("//span[text()='Setup issues']"));
		webDriver.findElement(By.xpath("//span[text()='Setup issues']/parent::div//div//label[@for='reason0']"));
		webDriver.findElement(By.xpath("//span[text()='Device related issues']"));
		webDriver.findElement(By.xpath("//span[text()='Device related issues']/parent::div//div//label[@for='reason1']"));
		webDriver.findElement(By.xpath("//span[text()='Child uninstalled mobicip']"));
		webDriver.findElement(By.xpath("//span[text()='Child uninstalled mobicip']/parent::div//div//label[@for='reason2']"));
		webDriver.findElement(By.xpath("//span[text()='Features did not work']"));
		webDriver.findElement(By.xpath("//span[text()='Features did not work']/parent::div//div//label[@for='reason3']"));
		webDriver.findElement(By.xpath("//span[text()='Did not have features I need']"));
		webDriver.findElement(By.xpath("//span[text()='Did not have features I need']/parent::div//div//label[@for='reason4']"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel Reason Info is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel Reason Info is shown");}
		a = true;
		try {webDriver.findElement(By.xpath("//label[text()='Tell us more']"));
		webDriver.findElement(By.xpath("//textarea[@name='comment']"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel comment section is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel Comment section Info is shown");}
		a = true;
		try {webDriver.findElement(By.xpath("//button[text()='Send']"));
		webDriver.findElement(By.xpath("//div[text()='Cancel']"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel Submit section is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel Submit section Info is shown");}
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Send']")));
		webDriver.findElement(By.xpath("//button[text()='Send']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required Field']")));
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='Required Field']"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Plan Cancel required field is not shown");}
		if (a == true) {
		test6.pass("My Plans - Plan Cancel required field is shown");}
		webDriver.findElement(By.xpath("//span[text()='Did not have features I need']/parent::div//div//label[@for='reason4']")).click();
		webDriver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("QA automation testing purpose - Please ignore");
		webDriver.findElement(By.xpath("//button[text()='Send']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
		try {webDriver.findElement(By.xpath("//span[text()='Dashboard']"));
		} catch (NoSuchElementException e) {
		a = false;
		test6.fail("My Plans - Cancel sent not properly");}
		if (a == true) {
		test6.pass("My Plans - Cancel sent properly");}
		//    webDriver.findElement(By.xpath("//p[text()='Internal']"));
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Mobicip']")));
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='My Mobicip']")));
	}

	// Checking the my devices components
	@Test(priority = 7)
	public void a7_MyDevicesPage() throws InterruptedException{
		ExtentTest test7 = extentreport.createTest("My Devices - Elements", "Checking the My Devices components");
		extentTest.set(test7);
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='label' and text()='Monitoring Devices ']")));
		boolean a = true;
		try {webDriver.findElement(By.xpath("//span[@class='label' and text()='Monitoring Devices ']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("My Monitoring device option is not found");}
		if (a == true) {test7.pass("My Monitoring device option is present");}
		webDriver.findElement(By.xpath("//span[@class='label' and text()='Monitoring Devices ']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='header_title' and text()='My Devices']")));
		a = true;
		try {webDriver.findElement(By.xpath("//p[@class='header_title' and text()='My Devices']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("My device header is not found");}
		if (a == true) {test7.pass("My Monitoring header option is present");}
		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("My devices page header elemtent");}
		if (a == true) {
			test7.pass("My devices page header elemtent");}
		// Title
		String tit = webDriver.getTitle();
		if (tit.equals("My Devices | Mobicip")) {
			test7.pass("My Devices - page opened and title is correct ");
		} else {
			test7.fail("My Devices - title isn't correct ");	}

		a = true;
		TimeUnit.SECONDS.sleep(2);
		try {webDriver.findElement(By.xpath("//h1[text()='1' and text()='Device']"));
			webDriver.findElement(By.xpath("//h3[text()='sdk_gphone64_x86_64']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("My devices page 1 Device elemtent");}
		if (a == true) {
			test7.pass("My devices page 1 Device elemtent");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//a[@class='link_button add']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='header_title' and text()='Choose a device type']")));		
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='iOS']")));		
		a = true;
		try {webDriver.findElement(By.xpath("//p[@class='header_title' and text()='Choose a device type']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("Choose a device type header title is not found");}
		if (a == true) {test7.pass("Choose a device type option is present");}
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='iOS']"));
			webDriver.findElement(By.xpath("//span[text()='Android']"));
			webDriver.findElement(By.xpath("//span[text()='MacOS']"));
			webDriver.findElement(By.xpath("//span[text()='Windows']"));
			webDriver.findElement(By.xpath("//span[text()='Kindle']"));
			webDriver.findElement(By.xpath("//span[text()='Chromebook']"));
			webDriver.findElement(By.xpath("//img[@class='icon_device_type ios active']"));
			webDriver.findElement(By.xpath("//img[@class='icon_device_type android active']"));
			webDriver.findElement(By.xpath("//img[@class='icon_device_type mac active']"));
			webDriver.findElement(By.xpath("//img[@class='icon_device_type windows active']"));
			webDriver.findElement(By.xpath("//img[@class='icon_device_type kindle active']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Add devices platforms");}
		if (a == true) {
			test7.pass("Add devices platforms");}
		a = true;
		try {webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("Choose a device type next button is not found");}
		if (a == true) {test7.pass("Choose a device next button is present");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='iOS']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue' and @class='primary_button']")));		
		a = true;
		try {webDriver.findElement(By.xpath("//p[text()='Set up Family Sharing']"));
		webDriver.findElement(By.xpath("//p[contains(text(),' iOS devices in order to enforce restrictions. Family Sharing is perfectly safe to use and is an officially supported Apple feature that is designed to work closely with apps like Mobicip.')]"));
		webDriver.findElement(By.xpath("//button[text()='Continue' and @class='primary_button']"));
		webDriver.findElement(By.xpath("//p[contains(text(),'At this time, it is not possible to use Mobicip without enabling Apple')]"));} 
		catch (NoSuchElementException e) {a = false;
			test7.fail("iOS Family sharing Info");}
		if (a == true) {test7.pass("iOS Family sharing Info");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Continue' and @class='primary_button']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Mobicip works seamlessly with Apple ') and contains(text(),'s Family Sharing to protect your family')]")));		
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Set up Family Sharing']"));
			webDriver.findElement(By.xpath("//span[text()='Contact Us']"));
			webDriver.findElement(By.xpath("//div[contains(text(),'Mobicip works seamlessly with Apple ') and contains(text(),'s Family Sharing to protect your family')]"));
			webDriver.findElement(By.xpath("//div[contains(text(),'I') and contains(text(),'ve Set up Family Sharing Already')]"));
			webDriver.findElement(By.xpath("//div[contains(text(),'I Want to Set up Family Sharing')]"));
			webDriver.findElement(By.xpath("//div[contains(text(),'What is Family Sharing Anyway?')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Family sharing status options");}
		if (a == true) {
			test7.pass("Family sharing status options");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Contact Us']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sharing_info_options support selected' and text()='Ask for Help']")));		
		a = true;
		try {
			webDriver.findElement(By.xpath("//span[@class='family_sharing_header_title' and text()='Contact Us']"));
			webDriver.findElement(By.xpath("//div[@class='sharing_info_options support selected' and text()='Ask for Help']"));
			webDriver.findElement(By.xpath("//div[ text()='I need help with']"));
			webDriver.findElement(By.xpath("//span[ text()='Setting up Family Sharing']"));
			webDriver.findElement(By.xpath("//span[ text()='Setting up Mobicip']"));
			webDriver.findElement(By.xpath("//span[ text()='Creating Apple ID for my child']"));
			webDriver.findElement(By.xpath("//span[ text()='Other issues']"));
			webDriver.findElement(By.xpath("//textarea[@name='feedback_text']"));
			webDriver.findElement(By.xpath("//button[text()='Submit']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("Contact Us Ask for help page components");}
		if (a == true) {test7.pass("Contact Us Ask for help page components");}
		webDriver.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("QA Testing purpose - Please Ignore");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='2']")).click();
		webDriver.findElement(By.xpath("//label[@for='1']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Contact Us']")));		
		a = true;
		try {webDriver.findElement(By.xpath("//span[text()='Contact Us']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("Question sent for family sharing");}
		if (a == true) {test7.pass("Question sent for family sharing");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Contact Us']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Schedule a Call']")));		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//div[text()='Schedule a Call']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='call_option_container']")));
		a = true;
		try {webDriver.findElement(By.xpath("//div[@class='call_option_container']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("Schedule call for family sharing");}
		if (a == true) {test7.pass("Schedule call for family sharing");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@class='family_sharing_header_icn']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'I') and contains(text(),'ve Set up Family Sharing Already')]")));		
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//div[contains(text(),'I') and contains(text(),'ve Set up Family Sharing Already')]")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]")));		
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='header_title' and text()='iOS']"));
			webDriver.findElement(By.xpath("//p[@class='content' and contains(text(),'Go to')]"));
			webDriver.findElement(By.xpath("//a[@href='https://apps.apple.com/us/app/parental-control-app-mobicip/id299153586' and contains(text(),'App Store')]"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Or login using your registered Mobicip parent ID and password.')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Use this QR code to add your child')]"));
			webDriver.findElement(By.xpath("//div[@class='icon_container']"));
			webDriver.findElement(By.xpath("//span[text()='Follow the installation instructions']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Allow all permissions during device setup to access accurate reporting of your child')]"));
			webDriver.findElement(By.xpath("//div[text()='Done']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("iOS Add info Page");}
		if (a == true) {test7.pass("iOS Add info Page");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'I Want to Set up Family Sharing')]")));		
		webDriver.findElement(By.xpath("//div[contains(text(),'I Want to Set up Family Sharing')]")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Set up Family Sharing on Your Family')]")));		
		a = true;
		try {webDriver.findElement(By.xpath("//span[contains(text(),'I Want to Set up Family Sharing')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Set up Family Sharing on Your Family')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'On Your Family') and contains(text(),'s iOS Device, open Settings')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Tap your Apple ID')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Sign in to your Apple ID')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Tap Family Sharing')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'I Want to Set up Family Sharing')]"));		
		webDriver.findElement(By.xpath("//span[contains(text(),'You should be an Organizer, Parent or Guardian to invite your child')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Tap Add Member')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'How to set up Family Sharing ?')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'How to create Apple IDs for your children?')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Follow the Prompts')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Finish setting up Family Sharing')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Return to Mobicip')]"));
		webDriver.findElement(By.xpath("//button[contains(text(),'Done with Setup. Let')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Watch How To Video')]"));
		webDriver.findElement(By.xpath("//span[@class='family_sharing_header_icn']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("I Want to Set up Family Sharing Page elements");}
		if (a == true) {test7.pass("I Want to Set up Family Sharing elements");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@class='family_sharing_header_icn']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'What is Family Sharing Anyway?')]")));		
		webDriver.findElement(By.xpath("//div[contains(text(),'What is Family Sharing Anyway?')]")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'What is Family Sharing?')]")));		
		a = true;
		try {webDriver.findElement(By.xpath("//div[contains(text(),'What is Family Sharing?')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Set up Family Sharing')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'What')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Why')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'How')]"));
		webDriver.findElement(By.xpath("//div[contains(text(),'Family Sharing is an Apple feature that allows you to create a group for your family. Family members get to share access to App Store purchases, iCloud storage plan, a family photo album, Apple Music, Apple TV and so much more.')]"));
		webDriver.findElement(By.xpath("//button[contains(text(),'Setup Family Sharing')]"));		
		webDriver.findElement(By.xpath("//div[contains(@class,'sharing_info_img')]"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("What is Family Sharing?");}
		if (a == true) {test7.pass("What is Family Sharing?");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[contains(text(),'Why')]")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Why Setup Family Sharing?')]")));		
		a = true;
		try {webDriver.findElement(By.xpath("//div[contains(text(),'Why Setup Family Sharing?')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Set up Family Sharing')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'What')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Why')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'How')]"));
		webDriver.findElement(By.xpath("//div[contains(text(),'Each family member in a Family Sharing group can share purchases including apps, songs, albums, shows, books etc. Group members get to choose what they want to share, so it comes with privacy built in. Mobicip integrates with Family Sharing to enforce its restrictions.')]"));
		webDriver.findElement(By.xpath("//button[contains(text(),'Setup Family Sharing')]"));		
		webDriver.findElement(By.xpath("//div[contains(@class,'sharing_info_img')]"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("Why is Family Sharing?");}
		if (a == true) {test7.pass("Why is Family Sharing?");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[contains(text(),'How')]")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'How to Enable Family Sharing?')]")));		
		a = true;
		try {webDriver.findElement(By.xpath("//div[contains(text(),'How to Enable Family Sharing?')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Set up Family Sharing')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'What')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'Why')]"));
		webDriver.findElement(By.xpath("//span[contains(text(),'How')]"));
		webDriver.findElement(By.xpath("//div[contains(text(),'As a parent, you are the organizer and you can invite any family member with an Apple ID or set up Apple IDs for children who ')]"));
		webDriver.findElement(By.xpath("//button[contains(text(),'Setup Family Sharing')]"));		
		webDriver.findElement(By.xpath("//div[contains(@class,'sharing_info_img')]"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("How");}
		if (a == true) {test7.pass("How is Family Sharing?");}
		webDriver.findElement(By.xpath("//span[@class='family_sharing_header_icn']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='family_sharing_header_icn']")));
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@class='family_sharing_header_icn']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='header_back' and @id='headerBack']")));
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Android']")));
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Android']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]")));		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='header_title' and text()='Android']"));
			webDriver.findElement(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]"));
			webDriver.findElement(By.xpath("//p[@class='content' and contains(text(),'Go to')]"));
			webDriver.findElement(By.xpath("//a[@href='https://play.google.com/store/apps/details?id=mobicip.com.safeBrowserff']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Or login using your registered Mobicip parent ID and password.')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Use this QR code to add your child')]"));
			webDriver.findElement(By.xpath("//div[@class='icon_container']"));
			webDriver.findElement(By.xpath("//span[text()='Follow the installation instructions']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Allow all permissions during device setup to access accurate reporting of your child')]"));
			webDriver.findElement(By.xpath("//div[text()='Done']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("Android Add info Page");}
		if (a == true) {test7.pass("Android Add info Page");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='MacOS']")));	
		webDriver.findElement(By.xpath("//span[text()='MacOS']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]")));		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='header_title' and text()='MacOS']"));
			webDriver.findElement(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]"));
			webDriver.findElement(By.xpath("//p[@class='content' and contains(text(),'Visit')]"));
			webDriver.findElement(By.xpath("//a[@href='/parental-controls/mac' and text()='Mobicip.com/parental-controls/mac']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Login using your registered Mobicip parent ID and password')]"));
			webDriver.findElement(By.xpath("//div[@class='icon_container']"));
			webDriver.findElement(By.xpath("//span[text()='Follow the installation instructions']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Allow all permissions during device setup to access accurate reporting of your child')]"));
			webDriver.findElement(By.xpath("//div[text()='Done']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("Mac OS Add info Page");}
		if (a == true) {test7.pass("Mac OS Add info Page");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Windows']")));	
		webDriver.findElement(By.xpath("//span[text()='Windows']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]")));		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='header_title' and text()='Windows']"));
			webDriver.findElement(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]"));
			webDriver.findElement(By.xpath("//p[@class='content' and contains(text(),'Visit')]"));
			webDriver.findElement(By.xpath("//a[@href='/parental-controls/windows' and text()='Mobicip.com/parental-controls/windows']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Login using your registered Mobicip parent ID and password')]"));
			webDriver.findElement(By.xpath("//div[@class='icon_container']"));
			webDriver.findElement(By.xpath("//span[text()='Follow the installation instructions']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Allow all permissions during device setup to access accurate reporting of your child')]"));
			webDriver.findElement(By.xpath("//div[text()='Done']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("Windows OS Add info Page");}
		if (a == true) {test7.pass("Windows OS Add info Page");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kindle']")));	
		webDriver.findElement(By.xpath("//span[text()='Kindle']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]")));		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='header_title' and text()='Kindle']"));
			webDriver.findElement(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]"));
			webDriver.findElement(By.xpath("//p[@class='content' and contains(text(),'Go to')]"));
			webDriver.findElement(By.xpath("//a[@href='https://www.amazon.com/Screen-Time-Parental-Control-App/dp/B00OGM0J3G/ref=sr_1_1?crid=25KWCA9UT8V8E&keywords=mobicip&qid=1651240008&sprefix=mobicip%2Caps%2C73&sr=8-1']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Or login using your registered Mobicip parent ID and password.')]"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Use this QR code to add your child')]"));
			webDriver.findElement(By.xpath("//div[@class='icon_container']"));
			webDriver.findElement(By.xpath("//span[text()='Follow the installation instructions']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Allow all permissions during device setup to access accurate reporting of your child')]"));
			webDriver.findElement(By.xpath("//div[text()='Done']"));
		} catch (NoSuchElementException e) {a = false;
			test7.fail("Kindle OS Add info Page");}
		if (a == true) {test7.pass("Kindle OS Add info Page");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@id='headerBack']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Chromebook']")));	
		webDriver.findElement(By.xpath("//span[text()='Chromebook']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		webDriver.findElement(By.xpath("//button[@class='primary_button margin_top_24' and text()='Next']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]")));		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		a = true;
		try {webDriver.findElement(By.xpath("//p[@class='header_title' and text()='Chromebook']"));
			webDriver.findElement(By.xpath("//span[@class='title' and contains(text(),'Install Mobicip on your child')]"));
			webDriver.findElement(By.xpath("//p[@class='content' and contains(text(),'Go to')]"));
			webDriver.findElement(By.xpath("//a[@href='https://chrome.google.com/webstore/detail/mobicip/jpafaidkicnfcohbcfegbokibbghpnee' and text()='Chrome web store']"));
			webDriver.findElement(By.xpath("//span[contains(text(),'Login using your registered Mobicip parent ID and password')]"));
			webDriver.findElement(By.xpath("//div[@class='icon_container']"));
			webDriver.findElement(By.xpath("//span[text()='Follow the installation instructions']"));
			webDriver.findElement(By.xpath("//p[contains(text(),'Allow all permissions during device setup to access accurate reporting of your child')]"));
			webDriver.findElement(By.xpath("//div[text()='Done']"));} catch (NoSuchElementException e) {a = false;
			test7.fail("Kindle OS Add info Page");}
		if (a == true) {test7.pass("Kindle OS Add info Page");}
		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));		
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e1) {e1.printStackTrace();}
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user_profile_container']")));
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Mobicip']")));
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='My Mobicip']")));
	}
	
	
	// Checking the my family components
	@Test(priority = 8)
	public void a8_MyFamilyPage() throws InterruptedException{
		ExtentTest test8 = extentreport.createTest("My Family - Elements", "Checking the My Family components");
		extentTest.set(test8);
		waitTillElement(webDriver,"//span[@class='label' and text()='My Family']");
		webDriver.findElement(By.xpath("//span[@class='label' and text()='My Family']")).click();
		waitTillElement(webDriver,"//p[@class='header_title' and text()='My Family']");
		waitSeconds(2);
		isElementPresent(webDriver,test8,"//p[@class='header_title' and text()='My Family']" , "My Family page Title");
		boolean a = true;
		try {webDriver.findElement(By.xpath("//a[@class='logo']"));
			webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {a = false;
			test8.fail("My Family page header elemtent");}
		if (a == true) {test8.pass("My Family page header elemtent");}
		waitTillElement(webDriver,"//div[@class='profile_image_wrapper profile_64' and @title='11a']");
		isElementPresent(webDriver,test8,"//div[@class='profile_image_wrapper profile_64' and @title='11a']" , "11a Child Profile");
		isElementPresent(webDriver,test8,"//span[@class='child_name' and @title='11a']" , "11a Child Name");
		waitSeconds(1);
		webDriver.findElement(By.xpath("//span[@class='child_name' and @title='11a']")).click();
		waitTillElement(webDriver,"//h1[@class='user_name' and text()='11a']");
		isElementPresent(webDriver,test8,"//h1[@class='user_name' and text()='11a']" , "11a Child Name");
		isElementPresent(webDriver,test8,"//span[@class='user_info age' and text()='9']" , "11a Child Age");
		isElementPresent(webDriver,test8,"//span[text()='Monitor and Manage']" , "11a Child Filterlevel");
		isElementPresent(webDriver,test8,"//span[text()='Delete Child']" , "Delete Child button of child");
		isElementPresent(webDriver,test8,"//span[text()='Settings']" , "Edit Child button of child");
		isElementPresent(webDriver,test8,"//a[@class='icon_add' and @href ='/app/my-family/add-member/child']" , "Add Member Button");
		isElementPresent(webDriver,test8,"//button[@class='icon_family_pause' and @title='Pause all devices']" , "Pause all Devices Button");
		webDriver.findElement(By.xpath("//button[@class='icon_family_pause' and @title='Pause all devices']")).click();
		waitTillElement(webDriver,"//p[@class='p_title' and text()='Lock All Devices']");
		waitSeconds(2);
		isElementPresent(webDriver,test8,"//p[@class='p_title' and text()='Lock All Devices']" , "Pause All Device Popup Title");
		isElementPresent(webDriver,test8,"//span[@class='p_sub_title' and text()='Pause screen time for all family devices']" , "Pause All Device Popup SubTitle");
		isElementPresent(webDriver,test8,"//span[@class='radio_label' and text()='Custom']/preceding-sibling::div" , "Pause All Device Popup custom options");
		isElementPresent(webDriver,test8,"//span[text()='0h']" , "Pause All Device Popup 0h timer");
		isElementPresent(webDriver,test8,"//span[text()='15m']" , "Pause All Device Popup 15m timer");
		isElementPresent(webDriver,test8,"//span[@class='radio_label' and text()='End of day (11:59pm)']/preceding-sibling::div" , "Pause All Device Popup EOD options");
		isElementPresent(webDriver,test8,"//button[text()='Pause']" , "Pause All Device button");
		isElementPresent(webDriver,test8,"//div[@class='popup familytime_pause']//span[@class='p_cross']" , "Pause All Device Exit button");
		webDriver.findElement(By.xpath("//div[@class='popup familytime_pause']//span[@class='p_cross']")).click();
		waitTillElement(webDriver,"//a[@class='icon_add' and @href ='/app/my-family/add-member/child']");
		waitSeconds(2);
		webDriver.findElement(By.xpath("//a[@class='icon_add' and @href ='/app/my-family/add-member/child']")).click();
		waitTillElement(webDriver,"//input[@type='text']");
		waitSeconds(2);
		isElementPresent(webDriver,test8,"//input[@type='text']" , "Add Child Page ");
		scrollPageTillViewOf(webDriver,"//p[text()='No restrictions. Track screen time usage and online activities.']");
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Draft");
		waitTillElement(webDriver,"//label[text()='Birth Date']//following::select[1]");
		Select date2 =new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[1]")));
		date2.selectByValue("1");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		Select month2 =new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[2]")));
		month2.selectByValue("1");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		Select year2 =new Select(webDriver.findElement(By.xpath("//label[text()='Birth Date']//following::select[3]")));
		year2.selectByValue("2015");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='filter_monitor']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Add']")).click();	
		waitTillElement(webDriver,"//span[text()='Draft']");
		waitSeconds(2);
		webDriver.findElement(By.xpath("//span[text()='Draft']")).click();
		scrollPageTillViewOf(webDriver,"//h1[text()='Draft']");
		isElementPresent(webDriver,test8,"//h1[text()='Draft']" , "Child Added");
		scrollPageTillViewOf(webDriver,"//span[text()='Settings']");
		webDriver.findElement(By.xpath("//span[text()='Settings']")).click();
		waitTillElement(webDriver,"//p[text()='Child Settings']");
		waitSeconds(2);
		isElementPresent(webDriver,test8,"//p[text()='Child Settings']" , "Edit Child Page ");
		scrollPageTillViewOf(webDriver,"//p[text()='No restrictions. Track screen time usage and online activities.']");
		webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1");
		webDriver.findElement(By.xpath("//label[@for='filter_monitor_and_manage']")).click();
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Save']")).click();	
		waitTillElement(webDriver,"//span[text()='Draft1']");
		waitSeconds(3);
		scrollPageTillViewOf(webDriver,"//span[text()='Draft1']");
		webDriver.findElement(By.xpath("//span[text()='Draft1']")).click();
		scrollPageTillViewOf(webDriver,"//h1[text()='Draft1']");
		isElementPresent(webDriver,test8,"//h1[text()='Draft1']" , "Child Edited");
		scrollPageTillViewOf(webDriver,"//span[text()='Delete Child']");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[text()='Delete Child']")).click();
		waitTillElement(webDriver,"//p[text()='Do you want to delete the child ']");
		isElementPresent(webDriver,test8,"//p[text()='Do you want to delete the child ']" , "Child Delete popup Info");
		isElementPresent(webDriver,test8,"//button[text()='Yes']" , "Child Delete Yes Button");
		isElementPresent(webDriver,test8,"//div[text()='No']" , "Child Delete No Button");
		webDriver.findElement(By.xpath("//button[text()='Yes']")).click();
		try {TimeUnit.SECONDS.sleep(6);} catch (InterruptedException e) {e.printStackTrace();}
		boolean a1 = false;
		try {webDriver.findElement(By.xpath("//span[text()='Draft1']"));}
		catch (NoSuchElementException e) {a1 = true;
			test8.pass("Child Deleted");}
		if (a1 == false) {test8.fail("Child not Deleted");}
		waitSeconds(2);
		waitTillElement(webDriver,"//a[@class='icon_add']");
		webDriver.findElement(By.xpath("//a[@class='icon_add']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='add_member_parent']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//input[@name='parent_email']")).sendKeys("vikram+2507user@mobicip.com");
		webDriver.findElement(By.xpath("//label[@for='parent_role_user']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("parentUser");
		j1.executeScript("window.scrollBy(0,500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='ch1']")).click();
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='Jerry']")).click();
		webDriver.findElement(By.xpath("//span[@class='child_name' and text()='vivo2']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Send Invite']")).click();
		a=true;
		
		//---validation---User Parent
		try {TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		waitTillElement(webDriver,"//span[contains(text(),'parentUser')]");
		JavascriptExecutor j6 = (JavascriptExecutor)webDriver;
		j6.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);
		scrollPageTillViewOf(webDriver,"//span[contains(text(),'parentUser')]");
		try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[contains(text(),'parentUser')]")).click();}
		catch(NoSuchElementException e){test8.fail("Editing Parent - Unsuccessful");
		a=false;}
		TimeUnit.SECONDS.sleep(2);
		if(a==true){test8.pass("Editing Parent - Successful");}
		JavascriptExecutor j11= (JavascriptExecutor)webDriver;
		j11.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		a=true;
		try{webDriver.findElement(By.xpath("//span[text()='Invited']//preceding::span[contains(text(),'parentUser')]"));
			webDriver.findElement(By.xpath("//span[text()='Invited']"));
			webDriver.findElement(By.xpath("//span[text()='vikram+2507user@mobicip.com']"));
			webDriver.findElement(By.xpath("//p[text()=' can']"));
			webDriver.findElement(By.xpath("//span[text()='Manage Parent, Child & Device Settings']"));
			webDriver.findElement(By.xpath("//span[text()='Settings']"));
			webDriver.findElement(By.xpath("//p[text()=' can watch over']"));
			webDriver.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='1Android']"));}
		catch(NoSuchElementException e){test8.fail("User Parent - Improper Details Displayed. ");
		a=false;}
		if(a==true){test8.pass("User Parent - Proper Details Displayed.");}
		j11.executeScript("window.scrollBy(0,1000)");
		TimeUnit.SECONDS.sleep(2);
		webDriver.findElement(By.xpath("//span[text()='Settings']")).click();
		TimeUnit.SECONDS.sleep(2);
		waitTillElement(webDriver,"//input[@name='parent_email']");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j111= (JavascriptExecutor)webDriver;
		j111.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//label[@for='parent_role_admin']")).click();
		webDriver.findElement(By.xpath("//input[@name='parent_name']")).sendKeys("Admin");
		j111.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		a=true;
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		waitTillElement(webDriver,"//span[contains(text(),'parentUser')]");
		scrollPageTillViewOf(webDriver,"//span[contains(text(),'parentUser')]");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.findElement(By.xpath("//span[contains(text(),'parentUser')]")).click();
		TimeUnit.SECONDS.sleep(1);
		JavascriptExecutor j11a= (JavascriptExecutor)webDriver;
		j11a.executeScript("window.scrollBy(0,1000)");
		TimeUnit.SECONDS.sleep(1);
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		scrollPageTillViewOf(webDriver,"//span[text()='Invited']");
		a=true;
		try{webDriver.findElement(By.xpath("//span[contains(text(),'parentUser')]"));
			webDriver.findElement(By.xpath("//span[text()='Invited']"));
			webDriver.findElement(By.xpath("//span[text()='vikram+2507admin@mobicip.com']"));
			webDriver.findElement(By.xpath("//p[text()=' can']"));
			webDriver.findElement(By.xpath("//span[text()='Manage Parent, Child & Device Settings']"));
			webDriver.findElement(By.xpath("//p[text()=' can watch over']"));
			webDriver.findElement(By.xpath("//div[@class='managed_relationship_container']//child::div[@title='1Android']"));}
		catch(NoSuchElementException e){test8.fail("Edited Parent user");
		a=false;}
		if(a==true){test8.pass("Edited Parent user");}
		a=true;
		j11a.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		try{webDriver.findElement(By.xpath("//span[text()='Delete Parent']")).click();
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
			webDriver.findElement(By.xpath("//p[text()='Do you want to delete the parent ']"));
			webDriver.findElement(By.xpath("//button[text()='Yes']")).click();} 
		catch(NoSuchElementException e){test8.fail("Admin Parent - Unable to delete");
		a=false;}
		if(a==true){test8.pass("Admin Parent - Able to delete");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		webDriver.navigate().refresh();	
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j12= (JavascriptExecutor)webDriver;
		j12.executeScript("window.scrollBy(0,-1000)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
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
