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

public class AboutPartnerPages extends BrowserSetupClass{
		
	//Report setup
		ExtentReports extentreport;
		ExtentSparkReporter spark ;
		
		@BeforeClass
		public void beforeTest() 
		{
			extentreport = new ExtentReports();
			spark = new ExtentSparkReporter("TestReports\\PreLoginTest\\AboutPartnerPagesTest\\AboutPartnerPagesReport.html");
			extentreport.attachReporter(spark);
		}
		
		@Test
		public void a1_aboutPage() throws InterruptedException
		{
			ExtentTest test=extentreport.createTest("About page","To check the Prelogin About web page title,header");
			new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

			WebElement l=webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='About']"));
		      // Javascript executor
		    ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", l);
			TimeUnit.SECONDS.sleep(2);
			new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='footer_ul']//a[text()='About']")));
			webDriver.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='About']")).click();
			new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='About Mobicip']")));

			// page title
			String tit=webDriver.getTitle();
			System.out.println(tit);
			tit = webDriver.getTitle();
			if(tit.equals("About Us | Mobicip"))
			{test.pass("About Page title is correct");}
			else{test.fail("About Page title isn't correct");}
				
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
			test.fail("Pre login About page - Header is incorrect");}
			if(a==true){test.pass("Pre login About page - Header is correct");}
		  }

		@Test
		public void a2_section1() throws InterruptedException
		  {
			ExtentTest test1=extentreport.createTest("section 1","To check the Prelogin About web page section 1");
			
			boolean a=true;
			try {webDriver.findElement(By.xpath("//*[text()='About Mobicip']"));}
			catch(NoSuchElementException e){a=false;
			test1.fail("Section title is not correct");}
			if(a==true){test1.pass("Section title is correct");}   	
			
			String p = webDriver.findElement(By.xpath("//p[@class='banner_text']")).getText();
			if(p.equals("Mobicip (pronounced mo-be-sip) is named after mobile CIPA. CIPA stands for Children's Internet Protection Act, a regulation by the US government that mandates secure internet access when provided by public schools or libraries. In the dark days before smartphones and tablets, the founders had a vision that learning is going to be transformed by ubiquitous always-on mobile technology in the hands of K-12 students. And so Mobicip was born, with a mission to create and foster the safe use of technology for learning and enrichment. A few million downloads, ten years, and petabytes of usage later, we believe the vision has come full circle as the world as we know it, and not just education, has been transformed."))
			{test1.pass("Description text correct");}
			else{test1.fail("Description text not correct");}
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='about_image']/picture"));}
			catch(NoSuchElementException e){a=false;
			test1.fail("Banner Image not present");}
			if(a==true){test1.pass("Banner Image present");} 		
		  } 

		@Test
		public void a3_section2() throws InterruptedException
		  {
			ExtentTest test2=extentreport.createTest("section 2","To check the Prelogin About web page section 2");
			
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,550)");
			TimeUnit.SECONDS.sleep(5);
			
			boolean a=true;
			try {webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[1]/div"));}
			catch(NoSuchElementException e){a=false;
			test2.fail("California Image not present");}
			if(a==true){test2.pass("California Image present");} 
			
			String p = webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[1]/p[1]")).getText();
			if(p.equals("USA - California"))
			{test2.pass("Address title correct");}
			else{test2.fail("Address title not correct");}
			
			String p1 = webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[1]/p[2]")).getText();
			if(p1.equals("USA - California 501-1, S Reino Rd. Ste 212, Newbury Park, CA 91320"))
			{test2.pass("Address text correct");}
			else{test2.fail("Address text not correct");}
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[2]/div"));}
			catch(NoSuchElementException e){a=false;
			test2.fail("Bangalore Image not present");}
			if(a==true){test2.pass("Bangalore Image present");} 
			
			String p2 = webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[2]/p[1]")).getText();
			if(p2.equals("India - Bangalore"))
			{test2.pass("Address title correct");}
			else{test2.fail("Address title not correct");}
			
			String p3 = webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[2]/p[2]")).getText();
			if(p3.equals("International Tech Park, Whitefield Road, Bangalore 560 066"))
			{test2.pass("Address text correct");}
			else{test2.fail("Address text not correct");}
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[3]/div"));}
			catch(NoSuchElementException e){a=false;
			test2.fail("Chennai Image not present");}
			if(a==true){test2.pass("Chennai Image present");}
			
			String p4 = webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[3]/p[1]")).getText();
			if(p4.equals("India - Chennai"))
			{test2.pass("Address title correct");}
			else{test2.fail("Address title not correct");}
			
			String p5 = webDriver.findElement(By.xpath("//div[@class='locations_wrapper']/div[3]/p[2]")).getText();
			if(p5.equals("The Executive Centre, Tamarai Tech Park, Chennai 600 032"))
			{test2.pass("Address text correct");}
			else{test2.fail("Address text not correct");}
		  } 

		@Test
		public void a4_section3() throws InterruptedException
		  {
			ExtentTest test3=extentreport.createTest("section 3","To check the Prelogin About web page section 3");
			
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,500)");
			TimeUnit.SECONDS.sleep(2);
			
			String p = webDriver.findElement(By.xpath("//div[@class='about_list_wrapper']/div[1]/h2")).getText();
			if(p.equals("Culture"))
			{test3.pass("Culture title correct");}
			else{test3.fail("Culture title not correct");}
			
			String p1 = webDriver.findElement(By.xpath("//div[@class='about_list_wrapper']/div[1]/p")).getText();
			if(p1.equals("The team culture is collegial and the organization is flat. There are no bosses per se, but every individual is expected to think and act like a boss, managing himself or herself. Nearly half the team is comprised of women, and flexi-schedules and work-life balance are enforced with missionary zeal. At the end of the day, who wouldn't want to work with smart people in a challenging culture that values what you do."))
			{test3.pass("Culture Description correct");}
			else{test3.fail("Culture Description not correct");}
			
			String p2 = webDriver.findElement(By.xpath("//div[@class='about_list_wrapper']/div[2]/h2")).getText();
			if(p2.equals("Careers"))
			{test3.pass("Careers title correct");}
			else{test3.fail("Careers title not correct");}
			
			String p22 = webDriver.findElement(By.xpath("//div[@class='about_list_wrapper']/div[2]/p")).getText();
			if(p22.equals("Consider yourself a smart cookie? A code warrior who loves programming and hacks away into the night? This might be the right place for geeks seeking glory. Contact us and let us know what drives you."))
			{test3.pass("Careers Description correct");}
			else{test3.fail("Careers Description not correct");}
			
			boolean a=true;
			try {webDriver.findElement(By.xpath("//div[@class='about_list_wrapper']/div[2]/p/a")).click();}
			catch(NoSuchElementException e){a=false;
			test3.fail("Contact us link redirects failed");}
			if(a==true){test3.pass("Contact us link works fine");}
			TimeUnit.SECONDS.sleep(2);
			webDriver.navigate().back();
			TimeUnit.SECONDS.sleep(2);
			
		  } 
		
		@Test
		public void a5_section4() throws InterruptedException
		  {
			ExtentTest test4=extentreport.createTest("section 4,5","To check the Prelogin About web page section 4,5");
			
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,400)");
			TimeUnit.SECONDS.sleep(2);
			
			boolean a=true;
		    try {webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
	        webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
	        webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
	        catch(NoSuchElementException e){a=false;
	        test4.fail("About page - Build better is not present");}
	        if(a==true){test4.pass("About page - Build better is present");}
	        
	        JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
			j1.executeScript("window.scrollBy(0,500)");
			TimeUnit.SECONDS.sleep(2);
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
		    catch(NoSuchElementException e){a=false;
		    test4.fail("About page - Footer is not present");}
		    if(a==true){test4.pass("About page - Footer is present");}
		    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
		  } 

		@Test
		public void b1_partnerPage() throws InterruptedException
		  {
			ExtentTest test5=extentreport.createTest("Partner page","To check the Prelogin Partner web page title,header");
			  	
			boolean a=true;
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,200)");
			
			TimeUnit.SECONDS.sleep(3);
			
			try {webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div[2]/div/div[1]/div[1]/div[2]/ul/li[3]/a")).click();}
			catch(NoSuchElementException e){a=false;
			test5.fail("Pre login - Footer Partner redirect failed");}
			if(a==true){test5.pass("Pre login - Footer Partner redirects to Partner page");}
			
			TimeUnit.SECONDS.sleep(5);
								
			// page title
			String tit=webDriver.getTitle();
			System.out.println(tit);
			tit = webDriver.getTitle();
			if(tit.equals("Partner Programs For Affiliates, Resellers or Distributors | Mobicip"))
			{test5.pass("Partner Page title is correct");}
			else{test5.fail("Partner Page title isn't correct");}
				
			//Header Elements
			a=true;
			try {webDriver.findElement(By.xpath("//a[@class='company_logo']"));
			webDriver.findElement(By.xpath("//*[text()='Features']"));
			webDriver.findElement(By.xpath("//*[text()='Pricing']"));
			webDriver.findElement(By.xpath("//*[text()='Support']"));
			webDriver.findElement(By.xpath("//*[text()='Testimonials']"));
			webDriver.findElement(By.xpath("//*[text()='Login']"));
			webDriver.findElement(By.xpath("//*[text()='Start Free Trial']"));}
			catch(NoSuchElementException e){a=false;
			test5.fail("Pre login Partner page - Header is incorrect");}
			if(a==true){test5.pass("Pre login Partner page - Header is correct");}
		  }

		@Test
		public void b2_section1() throws InterruptedException
		  {
			ExtentTest test6=extentreport.createTest("Section 1(Left Part)","To check the Prelogin Partner web page section 1");
			  	
			boolean a=true;
			try {webDriver.findElement(By.xpath("//*[text()='Does Mobicip have a Partner Program?']"));}
			catch(NoSuchElementException e){a=false;
			test6.fail("Section title is not correct");}
			if(a==true){test6.pass("Section title is correct");} 
			
			String p = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[1]/h2")).getText();
			if(p.equals("Affiliates"))
			{test6.pass("Subtitle 1 correct");}
			else{test6.fail("Subtitle 1 not correct");}
			
			String p1 = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[1]/p[1]")).getText();
			if(p1.equals("Mobicip offers an affiliate program in which bloggers, web publishers, influencers, system administrators, consultants, and resellers are invited to promote Mobicip and earn commissions."))
			{test6.pass("Subtitle 1 description correct");}
			else{test6.fail("Subtitle 1 description not correct");}
			
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,400)");
			
			TimeUnit.SECONDS.sleep(2);
			
			String p2 = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[1]/p[2]")).getText();
			if(p2.equals("This is how it works:"))
			{test6.pass("Steps title correct");}
			else{test6.fail("Steps title not correct");}
			
			String s1 = webDriver.findElement(By.xpath("//div[@class='partner_list_wrapper']/div[2]/p[2]")).getText();
			if(s1.equals("Visit the Mobicip Affiliate Program portal to enroll."))
			{test6.pass("Step 1 correct");}
			else{test6.fail("Steps 1 not correct");}
			
			String s2 = webDriver.findElement(By.xpath("//div[@class='partner_list_wrapper']/div[3]/p[2]")).getText();
			if(s2.equals("Once approved, you will have access to affiliate assets such as your own unique affiliate link and easy-to-embed graphics."))
			{test6.pass("Step 2 correct");}
			else{test6.fail("Steps 2 not correct");}
			
			JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
			j1.executeScript("window.scrollBy(0,100)");
			
			TimeUnit.SECONDS.sleep(2);
			
			String s3 = webDriver.findElement(By.xpath("//div[@class='partner_list_wrapper']/div[4]/p[2]")).getText();
			if(s3.equals("Inside the reporting features of the affiliate portal, you can track traffic, conversions, and commissions."))
			{test6.pass("Step 3 correct");}
			else{test6.fail("Steps 3 not correct");}
			
			String s4 = webDriver.findElement(By.xpath("//div[@class='partner_list_wrapper']/div[5]/p[2]")).getText();
			if(s4.equals("You earn a 20% commission on every sale you refer!"))
			{test6.pass("Step 4 correct");}
			else{test6.fail("Steps 4 not correct");}
			
			String p3 = webDriver.findElement(By.xpath("//div[@class='partner_container']/p[3]")).getText();
			if(p3.equals("Join the Mobicip Affiliate Program today. Its free!"))
			{test6.pass("Description 1 correct");}
			else{test6.fail("Description 1 not correct");}
			
			String p4 = webDriver.findElement(By.xpath("//div[@class='partner_container']/p[4]")).getText();
			if(p4.equals("For questions about the affiliate program, please email support@mobicip.com"))
			{test6.pass("Description 2 correct");}
			else{test6.fail("Description 2 not correct");}
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='partner_list_wrapper']/div[2]/p[2]/a"));
			webDriver.findElement(By.xpath("//div[@class='partner_container']/p[3]/a"));}
			catch(NoSuchElementException e){a=false;
			test6.fail("Mobicip Affiliate Program link not present");}
			if(a==true){test6.pass("Mobicip Affiliate Program link present");}
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='partner_container']/p[4]/a"));}
			catch(NoSuchElementException e){a=false;
			test6.fail("support@mobicip.com link not present");}
			if(a==true){test6.pass("support@mobicip.com link present");}
		  }
		
		@Test
		public void b3_section2() throws InterruptedException
		  {
			ExtentTest test7=extentreport.createTest("Section 1(Right Part)","To check the Prelogin Partner web page section 1");
			
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,-500)");
			
			TimeUnit.SECONDS.sleep(2);
			
			String p = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/h2")).getText();
			if(p.equals("Resellers/Distributors"))
			{test7.pass("Title correct");}
			else{test7.fail("Title not correct");}
			
			String p1 = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[1]")).getText();
			if(p1.equals("Getting on Board:"))
			{test7.pass("subtitle 1 correct");}
			else{test7.fail("subtitle 1 not correct");}
			
			String p2 = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[2]")).getText();
			if(p2.equals("Are you interested in selling or distributing Mobicip's products in your region? Contact us today."))
			{test7.pass("Description correct");}
			else{test7.fail("Description not correct");}
			
			String p3 = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[3]")).getText();
			if(p3.equals("For Authorised Resellers/Distributors:"))
			{test7.pass("subtitle 2 correct");}
			else{test7.fail("subtitle 2 not correct");}
			
			String p4 = webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[4]")).getText();
			if(p4.equals("If you are signing up new customers, here's the deal registration form.The customer also needs to sign up here and agree to the \"Terms & Conditions\" before we distribute the licenses."))
			{test7.pass("Description correct");}
			else{test7.fail("Description not correct");}
			
			boolean a=true;
			try {webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[2]/a")).click();}
			catch(NoSuchElementException e){a=false;
			test7.fail("Contact us link redirects failed");}
			if(a==true){test7.pass("Contact us link works fine");}
			TimeUnit.SECONDS.sleep(2);
			webDriver.navigate().back();
			TimeUnit.SECONDS.sleep(2);
			
			JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
			j1.executeScript("window.scrollBy(0,300)");
			
			TimeUnit.SECONDS.sleep(2);
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[4]/a[1]")).click();}
			catch(NoSuchElementException e){a=false;
			test7.fail("Reseller-signup link redirects failed");}
			if(a==true){test7.pass("Reseller-signup link works fine");}
			TimeUnit.SECONDS.sleep(2);
			webDriver.navigate().back();
			TimeUnit.SECONDS.sleep(2);
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='partner_wrapper']/div[2]/p[4]/a[2]")).click();}
			catch(NoSuchElementException e){a=false;
			test7.fail("Signup link redirects failed");}
			if(a==true){test7.pass("Signup link works fine");}
			TimeUnit.SECONDS.sleep(2);
			webDriver.navigate().back();
			TimeUnit.SECONDS.sleep(2);
		  }
		
		@Test
		public void b4_section3() throws InterruptedException
		  {
			ExtentTest test8=extentreport.createTest("section 3,4","To check the Prelogin Partner web page section 3,4");
			
			JavascriptExecutor j = (JavascriptExecutor)webDriver;
			j.executeScript("window.scrollBy(0,400)");
			TimeUnit.SECONDS.sleep(2);
			
			boolean a=true;
		    try {webDriver.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
	        webDriver.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
	        webDriver.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
	        catch(NoSuchElementException e){a=false;
	        test8.fail("Partner page - Build better is not present");}
	        if(a==true){test8.pass("Partner page - Build better is present");}
	        
	        JavascriptExecutor j1 = (JavascriptExecutor)webDriver;
			j1.executeScript("window.scrollBy(0,500)");
			TimeUnit.SECONDS.sleep(2);
			
			a=true;
			try {webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
		    catch(NoSuchElementException e){a=false;
		    test8.fail("Partner page - Footer is not present");}
		    if(a==true){test8.pass("Partner page - Footer is present");}
		    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
		    
		    webDriver.findElement(By.xpath("//a[@class='company_logo']")).click();
			new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='main_title']")));

		  } 

		@AfterClass
		public void teardown()
		  {
		    extentreport.flush(); 	
		   }
}	
