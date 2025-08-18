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

public class Dashboard extends BrowserSetup {

	public void scrollToOption(WebElement element) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Checking the header components
	@Test(priority = 1)
	public void a1_dashboardHeader() {
		ExtentTest test = extentreport.createTest("Dashboard - Header", "Checking the header components");
		extentTest.set(test);

		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='James']")));

		boolean a = true;
		webDriver.findElement(By.xpath("//div[@title='James']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='no_device_container']//img")));

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Dashboard']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Dashboard - Menu title isn't correct");
		}
		if (a == true) {
			test.pass("Dashboard - Menu title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='logo']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Mobicip logo is not found");
		}
		if (a == true) {
			test.pass("Mobicip logo is present");
		}

		a = true;
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
		try {
			webDriver.findElement(By.xpath("//p[text()='Hello Vikram!']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Dashboard -  Header title is incorrect");
		}
		if (a == true) {
			test.pass("Dashboard - Header title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='user_profile_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Profile icon is not present");
		}
		if (a == true) {
			test.pass("Profile icon is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='help_icon']"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Help icon is not present");
		}
		if (a == true) {
			test.pass("Help icon is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test.fail("Notification icon is not present");
		}
		if (a == true) {
			test.pass("Notification icon is present");
		}
	}

	@Test(priority = 2)
	public void a2_childAndFamilyPause() {
		ExtentTest test1 = extentreport.createTest("Child Profile and Lock all Devices",
				"Checking the Child & Lock all Devices components");
		extentTest.set(test1);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='child_list_ul']"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Child Profile UI isn't displayed");
		}
		if (a == true) {
			test1.pass("Child Profile UI displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='child_list_actions']/a"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Add Child UI isn't displayed");
		}
		if (a == true) {
			test1.pass("Add Child UI displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='child_list_actions']/button"));
		} catch (NoSuchElementException e) {
			a = false;
			test1.fail("Family Pause UI isn't displayed");
		}
		if (a == true) {
			test1.pass("Family Pause UI displayed");
		}

	}

	@Test(priority = 3)
	public void a3_noDevice() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("No Child Device Linked",
				"Checking No Child Device Linked components");
		extentTest.set(test2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='no_device_container']//img"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("No Device Img isn't displayed");
		}
		if (a == true) {
			test2.pass("No Device Img displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='no_device_container']//p"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("No Device info text isn't displayed");
		}
		if (a == true) {
			test2.pass("No Device info text displayed");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,300)");

		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='no_device_container']//a"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Add Device button isn't displayed");
		}
		if (a == true) {
			test2.pass("Add Device button displayed");
		}

		webDriver.findElement(By.xpath("//div[@class='no_device_container']//a")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Choose a device type']")));

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Choose a device type']"));
		} catch (NoSuchElementException e) {
			a = false;
			test2.fail("Add Device button isn't redirected to Add device Page");
		}
		if (a == true) {
			test2.pass("Add Device button redirected to Add device Page");
		}

		webDriver.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='no_device_container']//p")));

		webDriver.findElement(By.xpath("//div[@title='1Android']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Screen Time - Today']")));

	}

	@Test(priority = 4)
	public void a4_withDeviceScreentime() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("Screentime", "Checking Screentime components");
		extentTest.set(test3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()='Screen Time - Today']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Screentime title isn't displayed");
		}
		if (a == true) {
			test3.pass("Screentime title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Screen Time Used']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Graph Title isn't displayed");
		}
		if (a == true) {
			test3.pass("Graph Title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//label//span[text()='0m']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("Graph 0m isn't displayed");
		}
		if (a == true) {
			test3.pass("Graph 0m displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='By Activity']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("By Activity title incorrect");
		}
		if (a == true) {
			test3.pass("By Activity title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Social Media']"));
			webDriver.findElement(By.xpath("//p[text()='Games']"));
			webDriver.findElement(By.xpath("//p[text()='Entertainment']"));
			webDriver.findElement(By.xpath("//p[text()='Others']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("All 4 categories names incorrect");
		}
		if (a == true) {
			test3.pass("All 4 categories names are correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Games']/preceding::span[text()='0m'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Entertainment']/preceding::span[text()='0m'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Others']/preceding::span[text()='0m'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Others']/following::span[text()='0m']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("0m not displayed for all 4 categories");
		}
		if (a == true) {
			test3.pass("0m displayed for all 4 categories");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()='App Usage']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("App Usage title incorrect");
		}
		if (a == true) {
			test3.pass("App Usage title is correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='No Apps Used']"));
		} catch (NoSuchElementException e) {
			a = false;
			test3.fail("No Apps Used info text incorrect");
		}
		if (a == true) {
			test3.pass("No Apps Used info text is correct");
		}

	}

	@Test(priority = 5)
	public void a5_last30Days() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("Last 30 Days", "Checking Last 30 Days components");
		extentTest.set(test4);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='history_icon']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Last 30 Days icon isn't displayed");
		}
		if (a == true) {
			test4.pass("Last 30 Days icon displayed");
		}

		webDriver.findElement(By.xpath("//div[@class='history_icon']")).click();
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Recommended']")));

		a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()='Last 30 days']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Graph Title isn't displayed");
		}
		if (a == true) {
			test4.pass("Graph Title is displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='stacked_bargraph_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Graph isn't displayed");
		}
		if (a == true) {
			test4.pass("Graph is displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='graph_duration']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Graph duration isn't displayed");
		}
		if (a == true) {
			test4.pass("Graph duration is displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Recommended']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Recommended text isn't displayed");
		}
		if (a == true) {
			test4.pass("Recommended text is displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='30 day Avg']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("30 day Avg text isn't displayed");
		}
		if (a == true) {
			test4.pass("30 day Avg text is displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[text()='Today']"));
		} catch (NoSuchElementException e) {
			a = false;
			test4.fail("Today text isn't displayed");
		}
		if (a == true) {
			test4.pass("Today text is displayed");
		}

		webDriver.findElement(By.xpath("//div[text()='Today']")).click();
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Screen Time Used']")));

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,300)");
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 6)
	public void a6_manageFreetime() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("Manage Freetime", "Checking Manage Freetime components");
		extentTest.set(test5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Manage Free Time']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Manage Free Time text isn't displayed");
		}
		if (a == true) {
			test5.pass("Manage Free Time text displayed");
		}

		webDriver.findElement(By.xpath("//span[text()='Manage Free Time']")).click();
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains(text(),'Manage Today') and contains(text(),'s Free Time for')]")));

		a = true;
		try {
			webDriver.findElement(
					By.xpath("//p[contains(text(),'Manage Today') and contains(text(),'s Free Time for')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Popup title isn't displayed");
		}
		if (a == true) {
			test5.pass("Popup title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='0']"));
			webDriver.findElement(By.xpath("//label[text()='12']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Scale Start/End time interval isn't displayed");
		}
		if (a == true) {
			test5.pass("Scale Start/End time interval displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='0m']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Used time isn't displayed");
		}
		if (a == true) {
			test5.pass("Used time displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='2h']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Default time 2h isn't displayed");
		}
		if (a == true) {
			test5.pass("Default time 2h displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//button[text()='Save']"));
		} catch (NoSuchElementException e) {
			a = false;
			test5.fail("Save button isn't displayed");
		}
		if (a == true) {
			test5.pass("Save button displayed");
		}

		webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 7)
	public void a7_lockDevice() throws InterruptedException {
		ExtentTest test6 = extentreport.createTest("Lock Device", "Checking Lock Device components");
		extentTest.set(test6);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Lock Device']"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Lock Device text isn't displayed");
		}
		if (a == true) {
			test6.pass("Lock Device text displayed");
		}

		webDriver.findElement(By.xpath("//span[text()='Lock Device']")).click();
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Pause Screen Time for ')]")));

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[contains(text(),'Pause Screen Time for ')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Popup title isn't displayed");
		}
		if (a == true) {
			test6.pass("Popup title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//button[text()='Done']/preceding::span[text()='Custom'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Custom option not displayed");
		}
		if (a == true) {
			test6.pass("Custom option displayed");
		}

		a = true;
		try {
			webDriver
					.findElement(By.xpath("//button[text()='Done']/preceding::span[text()='End of day (11:59pm)'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("End of day option not displayed");
		}
		if (a == true) {
			test6.pass("End of day option displayed");
		}

		webDriver.findElement(By.xpath("//button[text()='Done']/preceding::span[text()='15m'][2]")).click();
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Done']/preceding::span[text()='0m'][1]")).click();
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.xpath("//button[text()='Done']")).click();
		TimeUnit.SECONDS.sleep(1);

		a = true;
		try {
			webDriver.findElement(By.xpath("//button[text()='Done']/preceding::p[@class='input_error'][1]"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("0 interval Error msg isn't displayed");
		}
		if (a == true) {
			test6.pass("0 interval Error msg displayed");
		}

		webDriver.findElement(By.xpath("//button[text()='Done']/preceding::span[@class='p_cross'][1]")).click();
		TimeUnit.SECONDS.sleep(1);

		webDriver.findElement(By.xpath("//span[text()='Lock Device']")).click();
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Pause Screen Time for ')]")));

		a = true;
		try {
			webDriver.findElement(By.xpath("//button[text()='Done']"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Done button isn't displayed");
		}
		if (a == true) {
			test6.pass("Done button displayed");
		}

		webDriver.findElement(By.xpath("//button[text()='Done']")).click();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Paused by parent']"));
			webDriver.findElement(By.xpath("//span[text()='Unlock Device']"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("Custom pause isn't applied");
		}
		if (a == true) {
			test6.pass("Custom pause applied");
		}

		webDriver.findElement(By.xpath("//span[text()='Unlock Device']")).click();
		TimeUnit.SECONDS.sleep(2);
		webDriver.findElement(By.xpath("//span[text()='Lock Device']")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//button[text()='Done']/preceding::div[1]")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//button[text()='Done']")).click();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Paused by parent']"));
			webDriver.findElement(By.xpath("//span[text()='Unlock Device']"));
		} catch (NoSuchElementException e) {
			a = false;
			test6.fail("EOD pause isn't applied");
		}
		if (a == true) {
			test6.pass("EOD pause applied");
		}
		webDriver.findElement(By.xpath("//span[text()='Unlock Device']")).click();
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 8)
	public void a8_timeLine() throws InterruptedException {
		ExtentTest test7 = extentreport.createTest("Timeline", "Checking Timeline components");
		extentTest.set(test7);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[contains(text(),'All Activity')]"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("All Activity title isn't displayed");
		}
		if (a == true) {
			test7.pass("All Activity title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='No activity reports found']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Info msg isn't displayed");
		}
		if (a == true) {
			test7.pass("Info msg displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Filters']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Filter option not displayed");
		}
		if (a == true) {
			test7.pass("Filter option displayed");
		}

		webDriver.findElement(By.xpath("//span[text()='Filters']")).click();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Activity Type']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Activity Type title not displayed");
		}
		if (a == true) {
			test7.pass("Activity Type title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Web']"));
			webDriver.findElement(By.xpath("//label[text()='Apps']"));
			webDriver.findElement(By.xpath("//label[text()='Location']"));
			webDriver.findElement(By.xpath("//label[text()='Social Media']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("All 4 options not displayed");
		}
		if (a == true) {
			test7.pass("All 4 options displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Activity Occurrence']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Activity Occurrence title not displayed");
		}
		if (a == true) {
			test7.pass("Activity Occurrence title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='Today']"));
			webDriver.findElement(By.xpath("//label[text()='Yesterday']"));
			webDriver.findElement(By.xpath("//label[text()='7 days']"));
			webDriver.findElement(By.xpath("//label[text()='30 days']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("All 4 options not displayed");
		}
		if (a == true) {
			test7.pass("All 4 options displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Devices']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Devices title not displayed");
		}
		if (a == true) {
			test7.pass("Devices title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//label[text()='sdk_gphone64_x86_64']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Device name not displayed");
		}
		if (a == true) {
			test7.pass("Device name displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='Clear All']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Clear All not displayed");
		}
		if (a == true) {
			test7.pass("Clear All displayed");
		}

		webDriver.findElement(By.xpath("//div[@class='switch_tab_container']//div[2]")).click();
		TimeUnit.SECONDS.sleep(4);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='switch_tab_container']//div[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Alerts title isn't displayed");
		}
		if (a == true) {
			test7.pass("Alerts title displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//span[text()='No New Alerts']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Info msg isn't displayed");
		}
		if (a == true) {
			test7.pass("Info msg displayed");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[text()='Clear']"));
		} catch (NoSuchElementException e) {
			a = false;
			test7.fail("Clear option not displayed");
		}
		if (a == true) {
			test7.pass("Clear option displayed");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,-300)");

		TimeUnit.SECONDS.sleep(5);

		// ---Support Page---
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Family']")));

		webDriver.findElement(By.xpath("//span[text()='My Family']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='1Android']")));

		webDriver.findElement(By.xpath("//div[@title='1Android']")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//span[text()='Settings']")).click();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,300)");

		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//div//label[@for='filter_monitor']")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		TimeUnit.SECONDS.sleep(4);
	}

	@Test(priority = 9)
	public void a9_monitorOnly() throws InterruptedException {
		ExtentTest test8 = extentreport.createTest("Monitor Only", "Checking Monitor Only components");
		extentTest.set(test8);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h3[text()='Screen Time - Today']"));
			webDriver.findElement(By.xpath("//p[text()='Screen Time Used']"));
			webDriver.findElement(By.xpath("//label//span[text()='0m']"));
			webDriver.findElement(By.xpath("//span[text()='By Activity']"));
			webDriver.findElement(By.xpath("//p[text()='Social Media']"));
			webDriver.findElement(By.xpath("//p[text()='Games']"));
			webDriver.findElement(By.xpath("//p[text()='Entertainment']"));
			webDriver.findElement(By.xpath("//p[text()='Others']"));
			webDriver.findElement(By.xpath("//p[text()='Games']/preceding::span[text()='0m'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Entertainment']/preceding::span[text()='0m'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Others']/preceding::span[text()='0m'][1]"));
			webDriver.findElement(By.xpath("//p[text()='Others']/following::span[text()='0m']"));
			webDriver.findElement(By.xpath("//h3[text()='App Usage']"));
			webDriver.findElement(By.xpath("//span[text()='No Apps Used']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Screentime elements are not present");
		}
		if (a == true) {
			test8.pass("Screentime elements are present");
		}
		
		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='history_icon']"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Last 30 days elements are not present");
		}
		if (a == true) {
			test8.pass("Last 30 days elements are present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[contains(text(),'All Activity')]"));
			webDriver.findElement(By.xpath("//span[text()='Filters']"));
			webDriver.findElement(By.xpath("//div[@class='switch_tab_container']//div[2]"));
		} catch (NoSuchElementException e) {
			a = false;
			test8.fail("Activity timeline elements are not present");
		}
		if (a == true) {
			test8.pass("Activity timeline elements are present");
		}

		// ---Support Page---
		webDriver.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		webDriver.findElement(By.xpath("//span[text()='My Mobicip']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Family']")));

		webDriver.findElement(By.xpath("//span[text()='My Family']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='1Android']")));

		webDriver.findElement(By.xpath("//div[@title='1Android']")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//span[text()='Settings']")).click();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j2 = (JavascriptExecutor) webDriver;
		j2.executeScript("window.scrollBy(0,300)");

		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//div//label[@for='filter_monitor_and_manage']")).click();
		TimeUnit.SECONDS.sleep(2);

		webDriver.findElement(By.xpath("//button[text()='Save']")).click();
		TimeUnit.SECONDS.sleep(4);

		webDriver.findElement(By.xpath("//a[@class='logo']")).click();
		TimeUnit.SECONDS.sleep(4);
		
		webDriver.findElement(By.xpath("//span[text()='Scheduling']")).click();
		TimeUnit.SECONDS.sleep(4);
		
		JavascriptExecutor j11 = (JavascriptExecutor) webDriver;
		j11.executeScript("window.scrollBy(0,500)");

		TimeUnit.SECONDS.sleep(2);
		
		webDriver.findElement(By.xpath("//a[text()='View all schedules']")).click();
		TimeUnit.SECONDS.sleep(4);
		
		webDriver.findElement(By.xpath("//ul//li[1]//div[@class='toggle_switch_container']")).click();
		TimeUnit.SECONDS.sleep(4);
		
		webDriver.findElement(By.xpath("//ul//li[2]//div[@class='toggle_switch_container']")).click();
		TimeUnit.SECONDS.sleep(4);
		
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
