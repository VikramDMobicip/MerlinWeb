package Prelogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BlogPage extends BrowserSetupClass{

	  //Report setup
			ExtentReports extentreport;
			ExtentSparkReporter spark ;
				
			@BeforeClass
			public void beforeTest() 
			  {
				extentreport = new ExtentReports();
				spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\BlogTest\\BlogReport.html");
				extentreport.attachReporter(spark);
			  }
			
			@Test
			public void a1_BlogPage() throws InterruptedException
			  {
				ExtentTest test=extentreport.createTest("Blog Page","To check the Blog web page title,header");
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

				WebElement l=webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='Blog']"));
			      // Javascript executor
			    ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
				TimeUnit.SECONDS.sleep(2);
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='footer_ul']//a[text()='Blog']")));
				webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='Blog']")).click();
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Blog']")));

					
				// page title
				String tit=webDriver.getTitle();
				System.out.println(tit);
				tit = webDriver.getTitle();
				if(tit.equals("Blog | Internet Safety, Digital Citizenship & Social Media | Mobicip"))
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
				ExtentTest test1=extentreport.createTest("section 1","To check the Prelogin Blog web page section 1");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,550)");
				TimeUnit.SECONDS.sleep(5);
				j.executeScript("window.scrollBy(0,-550)");
				TimeUnit.SECONDS.sleep(5);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='banner_blog_info']/a/div[1]"));}
				catch(NoSuchElementException e){a=false;
				test1.fail("Section 1 - Title text is not present");}
				if(a==true){test1.pass("Section 1 - Title text is present");}
			    
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='banner_blog_info']/a/div[2]"));}
				catch(NoSuchElementException e){a=false;
				test1.fail("Date Element is not present");}
				if(a==true){test1.pass("Date Element is present");}
				
				a=true;
				try {
					webDriver.findElement(By.xpath("//div[@class='banner_blog_info']/div/div/a[2]"));
					webDriver.findElement(By.xpath("//div[@class='banner_blog_info']/div/div/a[2]"));
					webDriver.findElement(By.xpath("//div[@class='banner_blog_info']/div/div/a[2]"));
					}
				catch(NoSuchElementException e){a=false;
				test1.fail("3 Social media icons is not present");}
				if(a==true){test1.pass("3 Social media icons present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='banner_blog_container']/a[1]/div/img"));}
				catch(NoSuchElementException e){a=false;
				test1.fail("Banner Image is not present - we can ignore if we test in staging");}
				if(a==true){test1.pass("Banner Image is present");}
			}

			@Test
			public void a3_addsection() throws InterruptedException 
			{
				ExtentTest test2=extentreport.createTest("section 1[Add box]","To check the Prelogin Blog web page Add box");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,550)");
				TimeUnit.SECONDS.sleep(5);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//div[@class='z_top']/div/a//img"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Advertise Section is not present");}
				if(a==true){test2.pass("Advertise Section is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='z_top']/div/a//img"));}
				catch(NoSuchElementException e){a=false;
				test2.fail("Add thumbnail not present");}
				if(a==true){test2.pass("Add thumbnail present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='z_top']/div/a")).click();}
				catch(NoSuchElementException e){a=false;
				test2.fail("Advertise Section link redirects failed");}
				if(a==true){test2.pass("Advertise Section link works fine");}
				TimeUnit.SECONDS.sleep(2);
				webDriver.navigate().back();
				TimeUnit.SECONDS.sleep(2);
			}
			
			@Test
			public void a4_Section2() throws InterruptedException 
			{
				ExtentTest test3=extentreport.createTest("section 2","To check the Prelogin Blog web page section 2");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,-200)");
				TimeUnit.SECONDS.sleep(3);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//*[text()='Popular Posts']"));}
				catch(NoSuchElementException e){a=false;
				test3.fail("Section 2 - Title text is not present");}
				if(a==true){test3.pass("Section 2 - Title text is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='blogs_container']"));}
				catch(NoSuchElementException e){a=false;
				test3.fail("Articles section not present");}
				if(a==true){test3.pass("Articles section is present");}
				
				a=true;
				try {
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[1]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[2]"));
				}
				catch(NoSuchElementException e){a=false;
				test3.fail("Articles set 1 not present");}
				if(a==true){test3.pass("Articles set 1 is present");}
				
				JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
				j1.executeScript("window.scrollBy(0,500)");
				TimeUnit.SECONDS.sleep(3);
				
				a=true;
				try {
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[3]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[4]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[5]"));
				}
				catch(NoSuchElementException e){a=false;
				test3.fail("Articles set 2 not present");}
				if(a==true){test3.pass("Articles set 2 is present");}
				
				JavascriptExecutor j2 = (JavascriptExecutor)webDriver;
				j2.executeScript("window.scrollBy(0,500)");
				TimeUnit.SECONDS.sleep(3);
				
				a=true;
				try {
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[6]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[7]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[8]"));
				}
				catch(NoSuchElementException e){a=false;
				test3.fail("Articles set 3 not present");}
				if(a==true){test3.pass("Articles set 3 is present");}
				
				JavascriptExecutor j3 = (JavascriptExecutor)webDriver;
				j3.executeScript("window.scrollBy(0,500)");
				TimeUnit.SECONDS.sleep(3);
				
				a=true;
				try {
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[9]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[10]"));
					webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[11]"));
				}
				catch(NoSuchElementException e){a=false;
				test3.fail("Articles set 4 not present");}
				if(a==true){test3.pass("Articles set 4 is present");}
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='blogs_container']/article[11]")).click();}
				catch(NoSuchElementException e){a=false;
				test3.fail("Article redirects failed");}
				if(a==true){test3.pass("Article redirects works fine");}
				TimeUnit.SECONDS.sleep(2);
				webDriver.navigate().back();
				TimeUnit.SECONDS.sleep(2);
				
			}

			@Test
			public void a5_Section2() throws InterruptedException 
			{
				ExtentTest test4=extentreport.createTest("Pagination","To check the Prelogin Blog web page section 2 - Pagination");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,400)");
				TimeUnit.SECONDS.sleep(3);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//ul[@class='pagination_bar']"));}
				catch(NoSuchElementException e){a=false;
				test4.fail("Pagination is not present");}
				if(a==true){test4.pass("Pagination is present");}
				
				webDriver.findElement(By.xpath("//ul[@class='pagination_bar']/li[4]")).click();
				TimeUnit.SECONDS.sleep(10);
				JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
				j1.executeScript("window.scrollBy(0,2200)");
				TimeUnit.SECONDS.sleep(5);
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='blogs_container']"));}
				catch(NoSuchElementException e){a=false;
				test4.fail("Random page redirect works fine");}
				if(a==true){test4.pass("Random page redirect works fine");}
				
				webDriver.findElement(By.xpath("//ul[@class='pagination_bar']/li[7]")).click();
				TimeUnit.SECONDS.sleep(10);
				
				JavascriptExecutor j2 = (JavascriptExecutor)webDriver;
				j2.executeScript("window.scrollBy(0,2000)");
				TimeUnit.SECONDS.sleep(5);
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='blogs_container']"));}
				catch(NoSuchElementException e){a=false;
				test4.fail("Arrow redirect works fine");}
				if(a==true){test4.pass("Arrow redirect works fine");}
				
			}

			@Test
			public void a6_section3() throws InterruptedException
			  {
				ExtentTest test5=extentreport.createTest("section 3,4","To check the Prelogin Blog web page section 3,4");
				
				JavascriptExecutor j = (JavascriptExecutor)webDriver;
				j.executeScript("window.scrollBy(0,300)");
				TimeUnit.SECONDS.sleep(2);
				
				boolean a=true;
				try {webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
			    webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
			    webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
			    catch(NoSuchElementException e){a=false;
			    test5.fail("Blog page - Build better is not present");}
			    if(a==true){test5.pass("Blog page - Build better is present");}
		        
		        JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
				j1.executeScript("window.scrollBy(0,200)");
				TimeUnit.SECONDS.sleep(2);
				
				a=true;
				try {webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
			    catch(NoSuchElementException e){a=false;
			    test5.fail("Blog page - Footer is not present");}
			    if(a==true){test5.pass("Blog page - Footer is present");}
			    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
			    
			    webDriver.findElement(By.xpath("//a[@class='company_logo']")).click();
				new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

			  } 
			
			@AfterClass
			public void teardown()
			  {
			    extentreport.flush(); 	
			   }	

}
