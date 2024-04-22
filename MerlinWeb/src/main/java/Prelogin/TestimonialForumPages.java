package Prelogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestimonialForumPages extends BrowserSetupClass{

	//Report setup
			ExtentReports extentreport;
			ExtentSparkReporter spark ;
			
			@BeforeClass
			public void beforeTest() 
			{
				extentreport = new ExtentReports();
				spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\TestimonialsForum\\TestimonialForumPagesReport.html");
				extentreport.attachReporter(spark);
			}
			
			@Test
			public void a1_testimonialPage() throws InterruptedException
			  {
				ExtentTest test=extentreport.createTest("Testimonial page","To check the Prelogin Testimonial web page title,header");
				
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Testimonials' and @class='header_nav_anchor']")));
				webDriver.findElement(By.xpath("//a[text()='Testimonials' and @class='header_nav_anchor']")).click();
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bodyContainer contentContainer']")));
					
				// page title
				String tit=webDriver.getTitle();
				System.out.println(tit);
				tit = webDriver.getTitle();
				if(tit.equals("Mobicip"))
				{test.pass("Testimonial Page title is correct");}
				else{test.fail("Testimonial Page title isn't correct");}
					
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
				test.fail("Pre login Testimonial page - Header is incorrect");}
				if(a==true){test.pass("Pre login Testimonial page - Header is correct");}
			  }

			@Test
			public void a2_section1() throws InterruptedException
			  {
				ExtentTest test1=extentreport.createTest("section 1","To check the Prelogin Testimonial web page section 1");
				
                TimeUnit.SECONDS.sleep(5);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[1]"));}
				catch(NoSuchElementException e){a=false;
				test1.fail("Section 1 is not present");}
				if(a==true){test1.pass("Section 1 is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[1]//img"));}
				catch(NoSuchElementException e){a=false;
				test1.fail("Banner Image is Present");}
				if(a==true){test1.pass("Banner Image is Present");}
			  } 

			@Test
			public void a3_section2() throws InterruptedException
			  {
				ExtentTest test2=extentreport.createTest("section 2","To check the Prelogin Testimonial web page section 2");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(3);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[3]"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Section 2 is not present");}
				if(a==true){test2.pass("Section 2 is present");}
				
				JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
				j1.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(3);
                
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[4]"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Reviews set 1 are not present");}
				if(a==true){test2.pass("Reviews set 1 are present");}
				
				JavascriptExecutor j2 = (JavascriptExecutor)webDriver;
				j2.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(3);
                
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[5]"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Playstore review 1 not present");}
				if(a==true){test2.pass("Playstore review 1 present");}
				
				JavascriptExecutor j3 = (JavascriptExecutor)webDriver;
				j3.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(3);
                
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[6]"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Reviews set 2 are not present");}
				if(a==true){test2.pass("Reviews set 2 are present");}
				
				JavascriptExecutor j4 = (JavascriptExecutor)webDriver;
				j4.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(3);
                
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[7]"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Reviews set 3 are not present");}
				if(a==true){test2.pass("Reviews set 3 are present");}
				
				JavascriptExecutor j5 = (JavascriptExecutor)webDriver;
				j5.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(3);
                
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[8]"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Playstore review 2 not present");}
				if(a==true){test2.pass("Playstore review 2 present");}
				
			  } 

			@Test
			public void a4_section3() throws InterruptedException
			  {
				ExtentTest test3=extentreport.createTest("section 3,4","To check the Prelogin Testimonial web page section 3,4");
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,550)");
                TimeUnit.SECONDS.sleep(5);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[9]"));}
				catch(NoSuchElementException e){a=false;
				test3.fail("Section 3 is not present");}
				if(a==true){test3.pass("Section 3 is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[9]//img"));}
				catch(NoSuchElementException e){a=false;
				test3.fail("Image is Present");}
				if(a==true){test3.pass("Image is Present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[10]"));}
				catch(NoSuchElementException e){a=false;
				test3.fail("Section 4 is not present");}
				if(a==true){test3.pass("Section 4 is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='bodyContainer contentContainer']/div[10]//img"));}
				catch(NoSuchElementException e){a=false;
				test3.fail("Image is Present");}
				if(a==true){test3.pass("Image is Present");}
				
			  } 

			@Test
			public void a5_section5() throws InterruptedException
			  {
				ExtentTest test4=extentreport.createTest("section 5","To check the Prelogin Testimonials web page section 5");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,500)");
				TimeUnit.SECONDS.sleep(2);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
			    catch(NoSuchElementException e){a=false;
			    test4.fail("Testimonials page - Footer is not present");}
			    if(a==true){test4.pass("Testimonials page - Footer is present");}
			    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
			  } 

			@Test
			public void b1_section1() throws InterruptedException
			  {
				ExtentTest test5=extentreport.createTest("Forum Page","To check the Prelogin Forum web page");

				webDriver.get("https://content.mobicip.com/forum");
				TimeUnit.SECONDS.sleep(4);
				
				// page title
				String tit=webDriver.getTitle();
				System.out.println(tit);
				tit = webDriver.getTitle();
				if(tit.equals("Mobicip | Forums"))
				{test5.pass("Forum Page title is correct");}
				else{test5.fail("Forum Page title isn't correct");}
					
				//Header Elements
				boolean a = true;
				try {webDriver.findElement(By.xpath("//a[@class='company_logo']"));
				webDriver.findElement(By.xpath("//*[text()='Features']"));
				webDriver.findElement(By.xpath("//*[text()='Pricing']"));
				webDriver.findElement(By.xpath("//*[text()='Support']"));
				webDriver.findElement(By.xpath("//*[text()='Testimonials']"));
				webDriver.findElement(By.xpath("//*[text()='Login']"));
				webDriver.findElement(By.xpath("//*[text()='Start Free Trial']"));}
				catch(NoSuchElementException e){a=false;
				test5.fail("Pre login Forum page - Header is incorrect");}
				if(a==true){test5.pass("Pre login Forum page - Header is correct");}
				
				
			  } 

			@Test
			public void b2_section2() throws InterruptedException
			  {
				ExtentTest test6=extentreport.createTest("section 1","To check the Prelogin Forum web page section 1");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,100)");
                TimeUnit.SECONDS.sleep(3);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='sidebar_content_wrapper']"));}
				catch(NoSuchElementException e){a=false;
				test6.fail("Section 1 is not present");}
				if(a==true){test6.pass("Section 1 is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-5']"));}
				catch(NoSuchElementException e){a=false;
				test6.fail("1.Technical Support is not present");}
				if(a==true){test6.pass("1.Technical Support is present");}
				
				String p = webDriver.findElement(By.xpath("//tr[@id='forum-list-5']/td/div[2]/a")).getText();
				if(p.equals("Technical Support"))
				{test6.pass("Text correct");}
				else{test6.fail("Text not correct");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-5']/td/div[2]/a")).click();}
				catch(NoSuchElementException e){a=false;
				test6.fail("Link redirects failed");}
				if(a==true){test6.pass("Link works fine");}
				TimeUnit.SECONDS.sleep(2);
				webDriver.navigate().back();
				TimeUnit.SECONDS.sleep(2);
				
				JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
				j1.executeScript("window.scrollBy(0,100)");
                TimeUnit.SECONDS.sleep(3);
                
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-2']"));}
				catch(NoSuchElementException e){a=false;
				test6.fail("2.General Announcements is not present");}
				if(a==true){test6.pass("2.General Announcements is present");}
				
				String p1 = webDriver.findElement(By.xpath("//tr[@id='forum-list-2']/td/div[2]/a")).getText();
				if(p1.equals("General Announcements"))
				{test6.pass("Text correct");}
				else{test6.fail("Text not correct");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-2']/td/div[2]/a")).click();}
				catch(NoSuchElementException e){a=false;
				test6.fail("Link redirects failed");}
				if(a==true){test6.pass("Link works fine");}
				TimeUnit.SECONDS.sleep(2);
				webDriver.navigate().back();
				TimeUnit.SECONDS.sleep(2);
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-7']"));}
				catch(NoSuchElementException e){a=false;
				test6.fail("3.Filtering policy is not present");}
				if(a==true){test6.pass("3.Filtering policy is present");}
				
				String p2 = webDriver.findElement(By.xpath("//tr[@id='forum-list-7']/td/div[2]/a")).getText();
				if(p2.equals("Filtering policy"))
				{test6.pass("Text correct");}
				else{test6.fail("Text not correct");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-7']/td/div[2]/a")).click();}
				catch(NoSuchElementException e){a=false;
				test6.fail("Link redirects failed");}
				if(a==true){test6.pass("Link works fine");}
				TimeUnit.SECONDS.sleep(2);
				webDriver.navigate().back();
				TimeUnit.SECONDS.sleep(2);
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-6']"));}
				catch(NoSuchElementException e){a=false;
				test6.fail("4.Internet Safety Resources is not present");}
				if(a==true){test6.pass("4.Internet Safety Resources is present");}
				
				String p3 = webDriver.findElement(By.xpath("//tr[@id='forum-list-6']/td/div[2]/a")).getText();
				if(p3.equals("Internet Safety Resources"))
				{test6.pass("Text correct");}
				else{test6.fail("Text not correct");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//tr[@id='forum-list-6']/td/div[2]/a")).click();}
				catch(NoSuchElementException e){a=false;
				test6.fail("Link redirects failed");}
				if(a==true){test6.pass("Link works fine");}
				TimeUnit.SECONDS.sleep(2);
				webDriver.navigate().back();
				TimeUnit.SECONDS.sleep(2);
				
			  }
			
			@Test
			public void b3_section3() throws InterruptedException
			  {
				ExtentTest test7=extentreport.createTest("section 3","To check the Prelogin Forum web page section 3");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,500)");
				TimeUnit.SECONDS.sleep(2);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
			    catch(NoSuchElementException e){a=false;
			    test7.fail("Forum page - Footer is not present");}
			    if(a==true){test7.pass("Forum page - Footer is present");}
			    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
			    webDriver.findElement(By.xpath("//a[@class='header_company_logo']")).click();
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

			  } 

						
			@AfterClass
			public void teardown()
			  {
			    extentreport.flush(); 	
			   }

}