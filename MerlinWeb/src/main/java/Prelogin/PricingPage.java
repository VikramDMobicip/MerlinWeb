package Prelogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PricingPage extends BrowserSetupClass {
    //Report setup
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\PricingTest\\pricingPages.html");
		extentreport.attachReporter(spark);
	}
	
	@Test
	public void a1_PricingPage() throws InterruptedException
	  {
		ExtentTest test=extentreport.createTest("Pricing Page","To check the Pricing web page title,header");
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pricing']")));
		webDriver.findElement(By.xpath("//a[text()='Pricing']")).click();
		new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'plan')]")));

		
	// page title
	String tit=webDriver.getTitle();
	System.out.println(tit);
	tit = webDriver.getTitle();
	if(tit.equals("Select Pricing Plan | Mobicip Parental Control Software"))
	{test.pass("Page title is correct");}
	else{test.fail("Page title isn't correct");}
		
	//Header Elements
	boolean a=true;
	try {webDriver.findElement(By.xpath("//a[@class='company_logo']"));
	webDriver.findElement(By.xpath("//*[text()='Features']"));
	webDriver.findElement(By.xpath("//*[text()='Pricing']"));
	webDriver.findElement(By.xpath("//*[text()='Support']"));
	webDriver.findElement(By.xpath("//*[text()='Testimonials']"));
	webDriver.findElement(By.xpath("//*[text()='Login']"));
	webDriver.findElement(By.xpath("//*[text()='Start Free Trial']"));}
	catch(NoSuchElementException e){a=false;
	test.fail("Pre login - Header is incorrect");}
	if(a==true){test.pass("Pre login - Header is correct");}	
	}

@Test
public void a2_Section1() throws InterruptedException 
{
	ExtentTest test1=extentreport.createTest("Lite Plan","To check the Prelogin Pricing web page section 1 - Lite Plan");
	
	String p = webDriver.findElement(By.xpath("//div[@class='main_wrapper']/div/section/div/div/h2")).getText();
	if(p.equals("Choose the plan that's right for your family"))
	{test1.pass("Section 1 - Title is correct");}
	else{test1.fail("Section 1 - Title is not correct");}
	
	boolean a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]"));}
	catch(NoSuchElementException e){a=false;
	test1.fail("Pricing 'Lite plan' card not present");}
	if(a==true){test1.pass("Pricing 'Lite plan' card present");}
	
	String p1 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/p[1]")).getText();
	if(p1.equals("LITE"))
	{test1.pass("Title is correct");}
	else{test1.fail("Title is not correct");}
	
	String p2 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/div[1]/p")).getText();
	if(p2.equals("$2.99 /month"))
	{test1.pass("Plan rate is correct");}
	else{test1.fail("Plan rate is not correct");}
	
	String p3 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/p[2]")).getText();
	if(p3.equals("Billed Annually"))
	{test1.pass("'Billed Annually' text is correct");}
	else{test1.fail("'Billed Annually' text is not correct");}
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,200)");
	TimeUnit.SECONDS.sleep(2);
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/div[2]/a"));}
	catch(NoSuchElementException e){a=false;
	test1.fail("Start free trial button not present");}
	if(a==true){test1.pass("Start free trial button present");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/div[2]/a")).click();}
	catch(NoSuchElementException e){a=false;
	test1.fail("Start free trial button redirects failed");}
	if(a==true){test1.pass("Start free trial button works fine");}
	TimeUnit.SECONDS.sleep(2);
	webDriver.navigate().back();
	TimeUnit.SECONDS.sleep(2);
	
	String p4 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/span[1]")).getText();
	if(p4.equals("All Premium features free for 7 days"))
	{test1.pass("Offer info text is correct");}
	else{test1.fail("Offer info text is not correct");}
	
	String f1 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[1]/p")).getText();
	if(f1.equals("5 Managed Devices"))
	{test1.pass("'5 Managed Devices' correct");}
	else{test1.fail("'5 Managed Devices' not correct");}
	
	String f2 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[2]/p")).getText();
	if(f2.equals("App Blocker"))
	{test1.pass("'App Blocker' correct");}
	else{test1.fail("'App Blocker' not correct");}
	
	String f3 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[3]/p")).getText();
	if(f3.equals("Daily Screen Time Limits"))
	{test1.pass("'Daily Screen Time Limits' correct");}
	else{test1.fail("'Daily Screen Time Limits' not correct");}
	
	String f4 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[4]/p")).getText();
	if(f4.equals("Activity Schedules"))
	{test1.pass("'Activity Schedules' correct");}
	else{test1.fail("'Activity Schedules' not correct");}
	
	String f5 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[5]/p")).getText();
	if(f5.equals("Lock All Devices"))
	{test1.pass("'Lock All Devices' correct");}
	else{test1.fail("'Lock All Devices' not correct");}
	
	String f6 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[6]/p")).getText();
	if(f6.equals("Family Locator"))
	{test1.pass("'Family Locator' correct");}
	else{test1.fail("'Family Locator' not correct");}
	
	String f7 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[7]/p")).getText();
	if(f7.equals("Website Blocker"))
	{test1.pass("'Website Blocker' correct");}
	else{test1.fail("'Website Blocker' not correct");}
	
	JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
	j1.executeScript("window.scrollBy(0,200)");
	TimeUnit.SECONDS.sleep(2);
	
	String f8 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[8]/p")).getText();
	if(f8.equals("Social Media Monitor"))
	{test1.pass("'Social Media Monitor' correct");}
	else{test1.fail("'Social Media Monitor' not correct");}
	
	String f9 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[9]/p")).getText();
	if(f9.equals("App Limits"))
	{test1.pass("'App Limits' correct");}
	else{test1.fail("'App Limits' not correct");}
	
	String f10 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[1]/ul/li[10]/p")).getText();
	if(f10.equals("Parenting Expert Advice"))
	{test1.pass("'Parenting Expert Advice' correct");}
	else{test1.fail("'Parenting Expert Advice' not correct");}
	
}
	
@Test
public void a3_Section1() throws InterruptedException 
{
	ExtentTest test2=extentreport.createTest("Standard Plan","To check the Prelogin Pricing web page section 1 - Standard Plan");
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,-400)");
	TimeUnit.SECONDS.sleep(2);
	
	boolean a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]"));}
	catch(NoSuchElementException e){a=false;
	test2.fail("Pricing 'Standard plan' card not present");}
	if(a==true){test2.pass("Pricing 'Standard plan' card present");}
	
	String p1 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/p[1]")).getText();
	if(p1.equals("STANDARD"))
	{test2.pass("Title is correct");}
	else{test2.fail("Title is not correct");}
	
	String p2 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/div[1]/p")).getText();
	if(p2.equals("$4.99 /month"))
	{test2.pass("Plan rate is correct");}
	else{test2.fail("Plan rate is not correct");}
	
	String p3 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/p[2]")).getText();
	if(p3.equals("Billed Annually"))
	{test2.pass("'Billed Annually' text is correct");}
	else{test2.fail("'Billed Annually' text is not correct");}
	
	JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
	j1.executeScript("window.scrollBy(0,300)");
	TimeUnit.SECONDS.sleep(2);
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/div[2]/a"));}
	catch(NoSuchElementException e){a=false;
	test2.fail("Start free trial button not present");}
	if(a==true){test2.pass("Start free trial button present");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/div[2]/a")).click();}
	catch(NoSuchElementException e){a=false;
	test2.fail("Start free trial button redirects failed");}
	if(a==true){test2.pass("Start free trial button works fine");}
	TimeUnit.SECONDS.sleep(2);
	webDriver.navigate().back();
	TimeUnit.SECONDS.sleep(2);
	
	String p4 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/span[1]")).getText();
	if(p4.equals("All Premium features free for 7 days"))
	{test2.pass("Offer info text is correct");}
	else{test2.fail("Offer info text is not correct");}
	
	String f1 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[1]/p")).getText();
	if(f1.equals("10 Managed Devices"))
	{test2.pass("'10 Managed Devices' correct");}
	else{test2.fail("'10 Managed Devices' not correct");}
	
	String f2 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[2]/p")).getText();
	if(f2.equals("App Blocker"))
	{test2.pass("'App Blocker' correct");}
	else{test2.fail("'App Blocker' not correct");}
	
	String f3 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[3]/p")).getText();
	if(f3.equals("Daily Screen Time Limits"))
	{test2.pass("'Daily Screen Time Limits' correct");}
	else{test2.fail("'Daily Screen Time Limits' not correct");}
	
	String f4 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[4]/p")).getText();
	if(f4.equals("Activity Schedules"))
	{test2.pass("'Activity Schedules' correct");}
	else{test2.fail("'Activity Schedules' not correct");}
	
	JavascriptExecutor j2 = (JavascriptExecutor)webDriver;
	j2.executeScript("window.scrollBy(0,100)");
	TimeUnit.SECONDS.sleep(2);
	
	String f5 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[5]/p")).getText();
	if(f5.equals("Lock All Devices"))
	{test2.pass("'Lock All Devices' correct");}
	else{test2.fail("'Lock All Devices' not correct");}
	
	String f6 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[6]/p")).getText();
	if(f6.equals("Family Locator"))
	{test2.pass("'Family Locator' correct");}
	else{test2.fail("'Family Locator' not correct");}
	
	String f7 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[7]/p")).getText();
	if(f7.equals("Website Blocker"))
	{test2.pass("'Website Blocker' correct");}
	else{test2.fail("'Website Blocker' not correct");}
	
	String f8 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[8]/p")).getText();
	if(f8.equals("Social Media Monitor"))
	{test2.pass("'Social Media Monitor' correct");}
	else{test2.fail("'Social Media Monitor' not correct");}
	
	String f9 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[9]/p")).getText();
	if(f9.equals("App Limits"))
	{test2.pass("'App Limits' correct");}
	else{test2.fail("'App Limits' not correct");}
	
	String f10 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[2]/ul/li[10]/p")).getText();
	if(f10.equals("Parenting Expert Advice"))
	{test2.pass("'Parenting Expert Advice' correct");}
	else{test2.fail("'Parenting Expert Advice' not correct");}
}

@Test
public void a4_Section1() throws InterruptedException 
{
	ExtentTest test3=extentreport.createTest("Premium Plan","To check the Prelogin Pricing web page section 1 - Premium Plan");
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,-400)");
	TimeUnit.SECONDS.sleep(2);
	
	boolean a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]"));}
	catch(NoSuchElementException e){a=false;
	test3.fail("Pricing 'Premium plan' card not present");}
	if(a==true){test3.pass("Pricing 'Premium plan' card present");}
	
	String p = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/div[1]/p")).getText();
	if(p.equals("BEST VALUE"))
	{test3.pass("Plan tag is correct");}
	else{test3.fail("Plan tag is not correct");}
	
	String p1 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/p[1]")).getText();
	if(p1.equals("PREMIUM"))
	{test3.pass("Title is correct");}
	else{test3.fail("Title is not correct");}
	
	String p2 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/div[2]/p")).getText();
	if(p2.equals("$7.99 /month"))
	{test3.pass("Plan rate is correct");}
	else{test3.fail("Plan rate is not correct");}
	
	String p3 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/p[2]")).getText();
	if(p3.equals("Billed Annually"))
	{test3.pass("'Billed Annually' text is correct");}
	else{test3.fail("'Billed Annually' text is not correct");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/div[3]/a"));}
	catch(NoSuchElementException e){a=false;
	test3.fail("Start free trial button not present");}
	if(a==true){test3.pass("Start free trial button present");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/div[3]/a")).click();}
	catch(NoSuchElementException e){a=false;
	test3.fail("Start free trial button redirects failed");}
	if(a==true){test3.pass("Start free trial button works fine");}
	TimeUnit.SECONDS.sleep(2);
	webDriver.navigate().back();
	TimeUnit.SECONDS.sleep(2);
	
	JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
	j1.executeScript("window.scrollBy(0,300)");
	TimeUnit.SECONDS.sleep(2);
	
	String p4 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/span[1]")).getText();
	if(p4.equals("Free for 7 days"))
	{test3.pass("Offer info text is correct");}
	else{test3.fail("Offer info text is not correct");}
	
	String f1 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[1]/p")).getText();
	if(f1.equals("20 Managed Devices"))
	{test3.pass("'20 Managed Devices' correct");}
	else{test3.fail("'20 Managed Devices' not correct");}
	
	String f2 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[2]/p")).getText();
	if(f2.equals("App Blocker"))
	{test3.pass("'App Blocker' correct");}
	else{test3.fail("'App Blocker' not correct");}
	
	String f3 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[3]/p")).getText();
	if(f3.equals("Daily Screen Time Limits"))
	{test3.pass("'Daily Screen Time Limits' correct");}
	else{test3.fail("'Daily Screen Time Limits' not correct");}
	
	String f4 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[4]/p")).getText();
	if(f4.equals("Activity Schedules"))
	{test3.pass("'Activity Schedules' correct");}
	else{test3.fail("'Activity Schedules' not correct");}
	
	JavascriptExecutor j2 = (JavascriptExecutor)webDriver;
	j2.executeScript("window.scrollBy(0,100)");
	TimeUnit.SECONDS.sleep(2);
	
	String f5 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[5]/p")).getText();
	if(f5.equals("Lock All Devices"))
	{test3.pass("'Lock All Devices' correct");}
	else{test3.fail("'Lock All Devices' not correct");}
	
	String f6 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[6]/p")).getText();
	if(f6.equals("Social Media Monitor"))
	{test3.pass("'Social Media Monitor' correct");}
	else{test3.fail("'Social Media Monitor' not correct");}
	
	String f7 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[7]/p")).getText();
	if(f7.equals("Family Locator"))
	{test3.pass("'Family Locator' correct");}
	else{test3.fail("'Family Locator' not correct");}
	
	String f8 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[8]/p")).getText();
	if(f8.equals("Parenting Expert Advice"))
	{test3.pass("'Parenting Expert Advice' correct");}
	else{test3.fail("'Parenting Expert Advice' not correct");}
	
	String f9 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[9]/p")).getText();
	if(f9.equals("App Limits"))
	{test3.pass("'App Limits' correct");}
	else{test3.fail("'App Limits' not correct");}
	
	String f10 = webDriver.findElement(By.xpath("//ul[@class='pricing_wrapper']/li[3]/ul/li[10]/p")).getText();
	if(f10.equals("Website Blocker"))
	{test3.pass("'Website Blocker' correct");}
	else{test3.fail("'Website Blocker' not correct");}
}

@Test
public void a5_Section2() throws InterruptedException 
{
	ExtentTest test4=extentreport.createTest("Section 2","To check the Prelogin Pricing web page section 2");
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,400)");
	TimeUnit.SECONDS.sleep(2);
	
	boolean a=true;
	try {webDriver.findElement(By.xpath("//div[@class='pricing_quote_img']/picture"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("Device image not present");}
	if(a==true){test4.pass("Device image present");}
	
	String p = webDriver.findElement(By.xpath("//div[@class='pricing_quote_wrapper']/p")).getText();
	if(p.equals("Have more than 20 devices ? Get a Quote"))
	{test4.pass("Device info text is correct");}
	else{test4.fail("Device info text is not correct");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//div[@class='pricing_quote_wrapper']/p/a")).click();}
	catch(NoSuchElementException e){a=false;
	test4.fail("Get a Quote link redirects failed");}
	if(a==true){test4.pass("Get a Quote link works fine");}
	TimeUnit.SECONDS.sleep(2);
	webDriver.navigate().back();
	TimeUnit.SECONDS.sleep(2);
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[1]/a/div/div/picture"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("1.Logo image not present");}
	if(a==true){test4.pass("1.Logo image present");}
	
	String p1 = webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[1]/a/p")).getText();
	if(p1.equals("Mom's Choice Awards Gold Recipient"))
	{test4.pass("Logo text is correct");}
	else{test4.fail("Logo text is not correct");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[2]/div[2]/div/picture"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("2.Logo image not present");}
	if(a==true){test4.pass("2.Logo image present");}
		
	a=true;
	try {webDriver.findElement(By.xpath("//p[text()='Certified'and text()='Secure']"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("Logo text is not correct");}
	if(a==true){test4.pass("Logo text is correct");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[3]/div/a/img"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("3.Logo image not present");}
	if(a==true){test4.pass("3.Logo image present");}
		
	a=true;
	try {webDriver.findElement(By.xpath("//p[text()='Trusted'and text()='Provider']"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("Logo text is not correct");}
	if(a==true){test4.pass("Logo text is correct");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']/li[4]/div/div/picture"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("4.Logo image not present");}
	if(a==true){test4.pass("4.Logo image present");}
		
	a=true;
	try {webDriver.findElement(By.xpath("//p[text()='Satisfaction'and text()='Guaranteed']"));}
	catch(NoSuchElementException e){a=false;
	test4.fail("Logo text is not correct");}
	if(a==true){test4.pass("Logo text is correct");}
}

@Test
public void a6_Section3() throws InterruptedException 
{
	ExtentTest test5=extentreport.createTest("Section 3","To check the Prelogin Pricing web page section 3");
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,400)");
	TimeUnit.SECONDS.sleep(2);
	
	boolean a=true;
	try {webDriver.findElement(By.xpath("//*[text()='FAQ']"));}
	catch(NoSuchElementException e){a=false;
	test5.fail("Section title is not correct");}
	if(a==true){test5.pass("Section title is correct");}
	
	String q = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[1]/h3")).getText();
	if(q.equals("How will you bill me?"))
	{test5.pass("Qn 1 is correct");}
	else{test5.fail("Qn 1 is not correct");}
	
	String p = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[1]/p")).getText();
	if(p.equals("If you purchased a subscription from the Mobicip website, you will be billed and charged annually. If you made an in-app purchase on iOS, you will be billed and charged through your App Store account."))
	{test5.pass("Ans 1 is correct");}
	else{test5.fail("Ans 1 is not correct");}
	
	String q1 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[2]/h3")).getText();
	if(q1.equals("How to get started with Mobicip?"))
	{test5.pass("Qn 2 is correct");}
	else{test5.fail("Qn 2 is not correct");}
	
	String p1 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[2]/p")).getText();
	if(p1.equals("First, select a plan that works for your family and sign up for an account. Mobicip will guide you through an easy setup procedure to start managing all your devices."))
	{test5.pass("Ans 2 is correct");}
	else{test5.fail("Ans 2 is not correct");}
	
	String q2 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[3]/h3")).getText();
	if(q2.equals("Which platforms are supported by Mobicip?"))
	{test5.pass("Qn 3 is correct");}
	else{test5.fail("Qn 3 is not correct");}
	
	String p2 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[3]/p")).getText();
	if(p2.equals("Mobicip provides the widest platform coverage making it easier to manage iOS, Android, Windows, Mac, Chromebooks and Kindle Fire devices."))
	{test5.pass("Ans 3 is correct");}
	else{test5.fail("Ans 3 is not correct");}
	
	JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
	j1.executeScript("window.scrollBy(0,400)");
	TimeUnit.SECONDS.sleep(2);
	
	String q3 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[4]/h3")).getText();
	if(q3.equals("Can I cancel and get my money back?"))
	{test5.pass("Qn 4 is correct");}
	else{test5.fail("Qn 4 is not correct");}
	
	String p3 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[4]/p")).getText();
	if(p3.equals("Absolutely! We have a 30-day money back guarantee if the product does not meet your expectations. Reach us at support@mobicip.com if you have any questions."))
	{test5.pass("Ans 4 is correct");}
	else{test5.fail("Ans 4 is not correct");}
	
	a=true;
	try {webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[4]/p/a"));}
	catch(NoSuchElementException e){a=false;
	test5.fail("Support link not present");}
	if(a==true){test5.pass("Support link present");}
	
	String q4 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[5]/h3")).getText();
	if(q4.equals("How does the 7-day free trial work?"))
	{test5.pass("Qn 5 is correct");}
	else{test5.fail("Qn 5 is not correct");}
	
	String p4 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[5]/p")).getText();
	if(p4.equals("You will have access to all premium features during the free trial period. Your credit card will not be charged during this period."))
	{test5.pass("Ans 5 is correct");}
	else{test5.fail("Ans 5 is not correct");}
	
	String q5 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[6]/h3")).getText();
	if(q5.equals("What are the available payment options?"))
	{test5.pass("Qn 6 is correct");}
	else{test5.fail("Qn 6 is not correct");}
	
	String p5 = webDriver.findElement(By.xpath("//ul[@class='question_wrapper pricing faq_container three-layout']/li[6]/p")).getText();
	if(p5.equals("Online subscriptions require a Visa / Master / American Express / Discover credit card (sorry, no debit or prepaid cards). In-app subscriptions will accept the respective app store's payment method."))
	{test5.pass("Ans 6 is correct");}
	else{test5.fail("Ans 6 is not correct");}
}

@Test
public void a7_section4() throws InterruptedException
  {
	ExtentTest test6=extentreport.createTest("section 4","To check the Prelogin Pricing web page section 4");
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,400)");
	TimeUnit.SECONDS.sleep(3);
	
	webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
	TimeUnit.SECONDS.sleep(3);
	
	boolean a=true;
    try {webDriver.findElement(By.xpath("//div[text()='Have more questions ?']"));}
    catch(NoSuchElementException e){a=false;
    test6.fail("Pricing page - 'Have more questions' is not present");}
    if(a==true){test6.pass("Pricing page - 'Have more questions' is present");}
    
    a=true;
    try{webDriver.findElement(By.xpath("//input[@name='name']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("1.Name Required Field - Failed");}
	if(a==true){test6.pass("1.Name Required Field - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='email']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Email Required Field - Failed");}
	if(a==true){test6.pass("Email Required Field - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='subject']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Subject Required Field - Failed");}
	if(a==true){test6.pass("Subject Required Field - Displayed");}
	
	JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
	j1.executeScript("window.scrollBy(0,200)");
	TimeUnit.SECONDS.sleep(3);
	
	a=true;
	try{webDriver.findElement(By.xpath("//textarea[@name='message']/following::span[text()='Required Field']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Message Required Field - Failed");}
	if(a==true){test6.pass("Message Required Field - Displayed");}
	
	webDriver.navigate().refresh();
	TimeUnit.SECONDS.sleep(5);
	
	JavascriptExecutor j2 = (JavascriptExecutor)webDriver;
	j2.executeScript("window.scrollBy(0,2000)");
	TimeUnit.SECONDS.sleep(3);
	
	webDriver.findElement(By.xpath("//input[@name='name']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//input[@name='subject']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(" ");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
	TimeUnit.SECONDS.sleep(3);
	
	a=true;
    try{webDriver.findElement(By.xpath("//input[@name='name']/following::span[text()='Only blank space(s) not accepted']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Name Blank space validation - Failed");}
	if(a==true){test6.pass("Name Blank space validation - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Email Blank space validation - Failed");}
	if(a==true){test6.pass("Email Blank space validation - Displayed");}
	
	JavascriptExecutor j3 = (JavascriptExecutor)webDriver;
	j3.executeScript("window.scrollBy(0,200)");
	TimeUnit.SECONDS.sleep(3);
	
	a=true;
	try{webDriver.findElement(By.xpath("//textarea[@name='message']/following::span[text()='Only blank space(s) not accepted']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Message Blank space validation - Failed");}
	if(a==true){test6.pass("Message Blank space validation - Displayed");}
	
	webDriver.navigate().refresh();
	TimeUnit.SECONDS.sleep(5);
	
	JavascriptExecutor j5 = (JavascriptExecutor)webDriver;
	j5.executeScript("window.scrollBy(0,1990)");
	TimeUnit.SECONDS.sleep(3);
	
	webDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("name&");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys("suvetha@m");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//input[@name='subject']")).sendKeys("subject_");
	TimeUnit.SECONDS.sleep(2);
	webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
	TimeUnit.SECONDS.sleep(3);
	
	a=true;
    try{webDriver.findElement(By.xpath("//input[@name='name']/following::span[text()='Alphanumeric characters and -_(), only accepted']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Name Special char validation - Failed");}
	if(a==true){test6.pass("Name Special char validation - Displayed");}
	
	a=true;
	try{webDriver.findElement(By.xpath("//input[@name='email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
	catch(NoSuchElementException e) {a=false;
	test6.fail("Email invalid syntax validation - Failed");}
	if(a==true){test6.pass("Email invalid syntax validation - Displayed");}
	
	webDriver.navigate().refresh();
  } 	
	
@Test
public void a8_section5() throws InterruptedException
  {
	ExtentTest test7=extentreport.createTest("section 5,6","To check the Prelogin Pricing web page section 4,5");
	
	JavascriptExecutor j = (JavascriptExecutor)webDriver;
	j.executeScript("window.scrollBy(0,400)");
	TimeUnit.SECONDS.sleep(2);
	
	boolean a=true;
    try {webDriver.findElement(By.xpath("//h2[text()='Try Mobicip For Free. No Credit Card Required']"));
    webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
    webDriver.findElement(By.xpath("//a[@class='primary_button']"));}
    catch(NoSuchElementException e){a=false;
    test7.fail("Pricing page - Build better is not present");}
    if(a==true){test7.pass("Pricing page - Build better is present");}
    
    JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
	j1.executeScript("window.scrollBy(0,500)");
	TimeUnit.SECONDS.sleep(2);
	
	a=true;
	try {webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
    catch(NoSuchElementException e){a=false;
    test7.fail("Pricing page - Footer is not present");}
    if(a==true){test7.pass("Pricing page - Footer is present");}
    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
  } 	
	
@AfterSuite	
public void teardown()
  {
	webDriver.quit();
    extentreport.flush(); 	
   }

}