package Prelogin;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginPage extends BrowserSetupClass {

	//Report setup
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\TestimonialsForum\\TestimonialForumPagesReport.html");
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
	
	@AfterClass
	public void teardown()
	  {
	    extentreport.flush(); 	
	   }

}