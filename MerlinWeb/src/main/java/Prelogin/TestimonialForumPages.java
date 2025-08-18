package Prelogin;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestimonialForumPages extends BrowserSetupClass {

	/*
	 * //Report setup ExtentReports extentreport; ExtentSparkReporter spark ;
	 * 
	 * @BeforeClass public void beforeTest() { extentreport = new ExtentReports();
	 * spark = new ExtentSparkReporter(
	 * "TestReports\\PreLoginTest\\TestimonialsForum\\TestimonialForumPagesReport.html"
	 * ); extentreport.attachReporter(spark); }
	 */

	@Test(priority = 1)
	public void a1_testimonialPage() throws InterruptedException {
		ExtentTest test = extentreport.createTest("Testimonial page",
				"To check the Prelogin Testimonial web page title,header");
		extentTest.set(test);
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[text()='Testimonials' and @class='header_nav_anchor']")));
		webDriver.findElement(By.xpath("//a[text()='Testimonials' and @class='header_nav_anchor']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='testimonial_title']")));
		
		TimeUnit.SECONDS.sleep(5);
		
		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip Parental Control Reviews | Mobicip")) {
			test.pass("Testimonial Page title is correct");
		} else {
			Assert.fail("Testimonial Page title isn't correct");
		}

		// Header Elements
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='company_logo']"));
			webDriver.findElement(By.xpath("//*[text()='Features']"));
			webDriver.findElement(By.xpath("//*[text()='Pricing']"));
			webDriver.findElement(By.xpath("//*[text()='Support']"));
			webDriver.findElement(By.xpath("//*[text()='Testimonials']"));
			webDriver.findElement(By.xpath("//*[text()='Login']"));
			webDriver.findElement(By.xpath("//*[text()='Start Free Trial']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Pre login Testimonial page - Header is incorrect");
		}
		if (a == true) {
			test.pass("Pre login Testimonial page - Header is correct");
		}
	}

	@Test(priority = 2)
	public void a2_section1() throws InterruptedException {
		ExtentTest test1 = extentreport.createTest("section 1", "To check the Prelogin Testimonial web page section 1");
		extentTest.set(test1);
		TimeUnit.SECONDS.sleep(5);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//h1[text()='What Parents Are Saying About Mobicip']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 title is not shown");
		}
		if (a == true) {
			test1.pass("Section 1 title is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='screentime_video_container']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Youtube video is not shown");
		}
		if (a == true) {
			test1.pass("Youtube video is shown");
		}

		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='featured_on_container']"));
			webDriver.findElement(By.xpath("//p[text()='Featured on']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo1-d37079ebdfb5ea3a266a652b9b1dc22eba011cec7bf2258a41765660dacc6e3d.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo2-4078e7468f93f8f7e83a61810b84a61c7bdddb1510010e3a3ac3dc78e280daa6.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo3-3a8008eaefde68b43198adae9eedf702202d563ec588d1cb00b3f697a70f0f58.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo4-ce45078b349de73060d1ea9dda250372466a8d0c457a09acb3733fca01ba95cf.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo5-8a00ee24558c9223b39f910c01be03f727912279eee612b60d822ee10416e966.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo6-e50bed609b570ccaa6a34837ef3dfa5c412521359550fc4003f763e2205416f6.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo7-cecb3b9b2d32b7b626670564a726cf752a576c371a756bb825f5c657bae6f82b.png']"));
			webDriver.findElement(By.xpath(
					"//img[@data-src='https://www.mobicip.com/assets/content/testimonial/logo8-503f87ed0656220611e97564180a81c5c909d158f3a98bb1d6cb9adcab422249.png']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Featured on section is not shown");
		}
		if (a == true) {
			test1.pass("Featured on section is not shown");
		}
	}

	@Test(priority = 3)
	public void a3_section2() throws InterruptedException {
		ExtentTest test2 = extentreport.createTest("section 2", "To check the Prelogin Testimonial web page section 2");
		extentTest.set(test2);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='content_section']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 2 is not present");
		}
		if (a == true) {
			test2.pass("Section 2 is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath(
					"//p[text()='Over 2 million parents trust Mobicip to protect their kids online and develop healthy digital habits.']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 2 description is not present");
		}
		if (a == true) {
			test2.pass("Section 2 description is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//a[@class='primary_button']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Start Free Trial button is not shown");
		}
		if (a == true) {
			test2.pass("Start Free Trial button is shown");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[@class='review_msg review_msg_main']"));
			webDriver.findElement(By.xpath("//span[text()='Ivan']"));
			webDriver.findElement(By.xpath("//span[text()='Zoe']"));
			webDriver.findElement(By.xpath("//span[text()='Robinson']"));
			webDriver.findElement(By.xpath("//span[text()='Nancy']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Customer review Set 1 is not present");
		}
		if (a == true) {
			test2.pass("Customer review Set 1 is present");
		}

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,1500)");
		TimeUnit.SECONDS.sleep(3);

		webDriver.findElement(By.xpath("//span[@aria-label='Go to slide 2']")).click();
		try {
			webDriver.findElement(By.xpath("//span[text()='Fred']"));
			webDriver.findElement(By.xpath("//span[text()='Sandy']"));
			webDriver.findElement(By.xpath("//span[text()='Diane']"));
			webDriver.findElement(By.xpath("//span[text()='James']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Customer review Set 2 is not present");
		}
		if (a == true) {
			test2.pass("Customer review Set 2 is present");
		}

		webDriver.findElement(By.xpath("//span[@aria-label='Go to slide 3']")).click();

		try {
			webDriver.findElement(By.xpath("//span[text()='Kevin']"));
			webDriver.findElement(By.xpath("//span[text()='Clara']"));
			webDriver.findElement(By.xpath("//span[text()='Kim']"));
			webDriver.findElement(By.xpath("//span[text()='Jacqueline']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Customer review Set 3 is not present");
		}
		if (a == true) {
			test2.pass("Customer review Set 3 is present");

		}

	}

	@Test(priority = 4)
	public void a4_section3() throws InterruptedException {
		ExtentTest test3 = extentreport.createTest("section 3,4",
				"To check the Prelogin Testimonial web page section 3,4");
		extentTest.set(test3);
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//section[@class='content_section lightblue']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 3 is not present");
		}
		if (a == true) {
			test3.pass("Section 3 is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//p[text()='Begin Your Digital Parenting Journey With Mobicip Today']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 3 Description is not Present");
		}
		if (a == true) {
			test3.pass("Section 3 Description is Present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//h2[text()='Mobicip Pricing']"));
			webDriver.findElement(By.xpath("//h3[@class='content_subtitle']"));
			webDriver.findElement(By.xpath("//h4[@class='content_description']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 3 title and subtitle are not Present");
		}
		if (a == true) {
			test3.pass("Section 3 title and subtitle are Present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='pricing_quote_wrapper']"));
			webDriver.findElement(By.xpath("//div[@class='pricing_quote_img']"));
			webDriver.findElement(By.xpath("//p[@class='quote_msg']"));
			webDriver.findElement(By.xpath("//a[@class='quote_link']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Pricing Quote section is not Present");
		}
		if (a == true) {
			test3.pass("Pricing Quote section is Present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//ul[@class='pricing_section_image_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Product specifications are not provided");
		}
		if (a == true) {
			test3.pass("Product specifications are provided");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='content_section darkblue']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Products features are not provided");
		}
		if (a == true) {
			test3.pass("Product features are provided");
		}

	}

	@Test(priority = 5)
	public void a5_section5() throws InterruptedException {
		ExtentTest test4 = extentreport.createTest("section 5",
				"To check the Prelogin Testimonials web page section 5");
		extentTest.set(test4);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Testimonials page - Footer is not present");
		}
		if (a == true) {
			test4.pass("Testimonials page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void b1_section1() throws InterruptedException {
		ExtentTest test5 = extentreport.createTest("Forum Page", "To check the Prelogin Forum web page");
		extentTest.set(test5);
		webDriver.get("https://content.mobicip.com/forum");
		TimeUnit.SECONDS.sleep(4);

		// page title
		String tit = webDriver.getTitle();
		System.out.println(tit);
		tit = webDriver.getTitle();
		if (tit.equals("Mobicip | Forums")) {
			test5.pass("Forum Page title is correct");
		} else {
			Assert.fail("Forum Page title isn't correct");
		}

		// Header Elements
		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//*[text()='Features']"));
			webDriver.findElement(By.xpath("//*[text()='Pricing']"));
			webDriver.findElement(By.xpath("//*[text()='Support']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Pre login Forum page - Header is incorrect");
		}
		if (a == true) {
			test5.pass("Pre login Forum page - Header is correct");
		}

	}

	@Test(priority = 7)
	public void b2_section2() throws InterruptedException {
		ExtentTest test6 = extentreport.createTest("section 1", "To check the Prelogin Forum web page section 1");
		extentTest.set(test6);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(3);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='sidebar_content_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Section 1 is not present");
		}
		if (a == true) {
			test6.pass("Section 1 is present");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-5']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("1.Technical Support is not present");
		}
		if (a == true) {
			test6.pass("1.Technical Support is present");
		}

		String p = webDriver.findElement(By.xpath("//tr[@id='forum-list-5']/td/div[2]/a")).getText();
		if (p.equals("Technical Support")) {
			test6.pass("Text correct");
		} else {
			Assert.fail("Text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-5']/td/div[2]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Link redirects failed");
		}
		if (a == true) {
			test6.pass("Link works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		JavascriptExecutor j1 = (JavascriptExecutor) webDriver;
		j1.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(3);

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-2']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("2.General Announcements is not present");
		}
		if (a == true) {
			test6.pass("2.General Announcements is present");
		}

		String p1 = webDriver.findElement(By.xpath("//tr[@id='forum-list-2']/td/div[2]/a")).getText();
		if (p1.equals("General Announcements")) {
			test6.pass("Text correct");
		} else {
			Assert.fail("Text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-2']/td/div[2]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Link redirects failed");
		}
		if (a == true) {
			test6.pass("Link works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-7']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("3.Filtering policy is not present");
		}
		if (a == true) {
			test6.pass("3.Filtering policy is present");
		}

		String p2 = webDriver.findElement(By.xpath("//tr[@id='forum-list-7']/td/div[2]/a")).getText();
		if (p2.equals("Filtering policy")) {
			test6.pass("Text correct");
		} else {
			Assert.fail("Text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-7']/td/div[2]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Link redirects failed");
		}
		if (a == true) {
			test6.pass("Link works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-6']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("4.Internet Safety Resources is not present");
		}
		if (a == true) {
			test6.pass("4.Internet Safety Resources is present");
		}

		String p3 = webDriver.findElement(By.xpath("//tr[@id='forum-list-6']/td/div[2]/a")).getText();
		if (p3.equals("Internet Safety Resources")) {
			test6.pass("Text correct");
		} else {
			Assert.fail("Text not correct");
		}

		a = true;
		try {
			webDriver.findElement(By.xpath("//tr[@id='forum-list-6']/td/div[2]/a")).click();
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Link redirects failed");
		}
		if (a == true) {
			test6.pass("Link works fine");
		}
		TimeUnit.SECONDS.sleep(2);
		webDriver.navigate().back();
		TimeUnit.SECONDS.sleep(2);

	}

	@Test(priority = 8)
	public void b3_section3() throws InterruptedException {
		ExtentTest test7 = extentreport.createTest("section 3", "To check the Prelogin Forum web page section 3");
		extentTest.set(test7);
		JavascriptExecutor j = (JavascriptExecutor) webDriver;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);

		boolean a = true;
		try {
			webDriver.findElement(By.xpath("//div[@class='footer_section_wrapper']"));
		} catch (NoSuchElementException e) {
			a = false;
			Assert.fail("Forum page - Footer is not present");
		}
		if (a == true) {
			test7.pass("Forum page - Footer is present");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//a[@class='header_company_logo']")).click();
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

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

/*
 * @AfterTest public void afterTest() throws FileNotFoundException {
 * extentreport.flush();
 */

/*
 * // public static void main(String[] args)
 * 
 * { // Set up email properties Properties props = new Properties();
 * props.put("mail.smtp.host", "smtp.gmail.com"); props.put("mail.smtp.port",
 * "587"); props.put("mail.smtp.auth", "true");
 * props.put("mail.smtp.starttls.enable", "true");
 * 
 * // Authenticate the email account Session session =
 * Session.getInstance(props, new javax.mail.Authenticator() { protected
 * PasswordAuthentication getPasswordAuthentication() { return new
 * PasswordAuthentication("hariharanv308@gmail.com", "gfmy vukk vxij lgtm"); //
 * Replace with your email credentials } });
 * 
 * try { // Compose the email Message message = new MimeMessage(session);
 * message.setFrom(new InternetAddress("hariharanv308@gmail.com")); // Sender's
 * email message.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse("hari@mobicip.com")); // Recipient's email
 * message.setSubject("Automation Test Report with Multiple Attachments");
 * 
 * // Email body text BodyPart messageBodyPart = new MimeBodyPart();
 * messageBodyPart.setText("Hi! Please find the attached test reports.");
 * 
 * Multipart multipart = new MimeMultipart();
 * multipart.addBodyPart(messageBodyPart);
 * 
 * // List of files to attach String[] filenames = {
 * "C:\\Users\\User\\git\\MerlinWeb\\MerlinWeb\\TestReports\\PreLoginTest\\TestimonialsForum\\TestimonialForumPagesReport.html",
 * "C:\\Users\\User\\git\\MerlinWeb\\MerlinWeb\\TestReports\\TestFeatures\\reportFeatures.html"
 * };
 * 
 * for (String filename : filenames) { messageBodyPart = new MimeBodyPart();
 * DataSource source = new FileDataSource(filename);
 * messageBodyPart.setDataHandler(new DataHandler(source));
 * 
 * // Extract the file name for the attachment display String extractedFileName
 * = filename.contains("\\") ? filename.substring(filename.lastIndexOf("\\") +
 * 1) : filename.contains("/") ? filename.substring(filename.lastIndexOf("/") +
 * 1) : filename; // Use full filename if no slashes are present
 * 
 * messageBodyPart.setFileName(extractedFileName);
 * multipart.addBodyPart(messageBodyPart); }
 * 
 * 
 * // Combine all parts message.setContent(multipart);
 * 
 * // Send the email Transport.send(message);
 * 
 * System.out.println("Email sent successfully with multiple attachments.");
 * 
 * } catch (MessagingException e) { e.printStackTrace(); } } } }
 * 
 */
