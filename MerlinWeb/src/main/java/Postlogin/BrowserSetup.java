package Postlogin;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.log.Log;
//import org.openqa.selenium.devtools.v115.log.model.LogEntry;
import java.util.ArrayList;
import java.util.List;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BrowserSetup {
	public static WebDriver webDriver = null;

	private static DevTools devTools;
	private static List<String> consoleErrors = new ArrayList<>();

	public static ExtentReports extentreport = null;
	private static ExtentSparkReporter spark;
	protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@BeforeSuite
	public void beforeSuite() throws IOException

	{
		// Choose Browser
		Scanner input = new Scanner(System.in);
		System.out.println("Browser :\n1. Chrome \n2. Firefox \n3. Edge\nChoose : ");
		int browser = input.nextInt();
		System.out.println("Environment :\n1. Staging \n2. Live \nChoose : ");
		int environment = input.nextInt();
		input.close();

		// Chrome browser setup
		if (browser == 1) {
			System.out.println("Setup and Launch Chromebrowser");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			LoggingPreferences logs = new LoggingPreferences();
			logs.enable(LogType.BROWSER, Level.ALL);
			options.setCapability("goog:loggingPrefs", logs);

			// WebDriverManager.chromedriver().clearDriverCache().setup();
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--remote-allow-origins=*");

			// Instantiate a ChromeDriver class.
			webDriver = new ChromeDriver(options);
			// Maximize the browser
			webDriver.manage().window().maximize();

			if (environment == 1) {
				webDriver.get("https://webs.prgr.in/login");
			}
			if (environment == 2) {
				webDriver.get("https://www.mobicip.com/login");
			}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

			devTools = ((ChromeDriver) webDriver).getDevTools();
			devTools.createSession();
			devTools.send(Log.enable());

			devTools.addListener(Log.entryAdded(), logEntry -> {
				if ("SEVERE".equalsIgnoreCase(logEntry.getLevel().toString())) {
					consoleErrors.add(logEntry.getText());
				}
			});

			// ---Login---
			webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
			webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
			devTools = ((ChromeDriver) webDriver).getDevTools();
			devTools.createSession();
			devTools.send(Log.enable());

			devTools.addListener(Log.entryAdded(), logEntry -> {
				if ("SEVERE".equalsIgnoreCase(logEntry.getLevel().toString())) {
					consoleErrors.add(logEntry.getText());
				}
			});
		}

		// Firefox browser setup
		else if (browser == 2) {
			System.out.println("Setup and Launch Firefoxbrowser");
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			if (environment == 1) {
				webDriver.get("https://webs.prgr.in/");
			}
			if (environment == 2) {
				webDriver.get("https://www.mobicip.com/");
			}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

			// ---Login---
			webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
			webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));

		}

		// without webdriver in maven
		else if (browser == 12) {
			System.out.println("Setup and Launch Firefoxbrowser");
			webDriver = new FirefoxDriver();
			if (environment == 1) {
				webDriver.get("https://webs.prgr.in/");
			}
			if (environment == 2) {
				webDriver.get("https://www.mobicip.com/");
			}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

			// ---Login---
			webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
			webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));

		}

		// Edge browser setup
		else if (browser == 3) {
			System.out.println("Setup and Launch Edgebrowser");

			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			if (environment == 1) {
				webDriver.get("https://webs.prgr.in/");
			}
			if (environment == 2) {
				webDriver.get("https://www.mobicip.com/");
			}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

			// ---Login---
			webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
			webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));

		}

		// without webdriver in maven
		else if (browser == 13) {
			System.out.println("Setup and Launch Edgebrowser");
			webDriver = new EdgeDriver();
			if (environment == 1) {
				webDriver.get("https://webs.prgr.in/");
			}
			if (environment == 2) {
				webDriver.get("https://www.mobicip.com/");
			}
			new WebDriverWait(webDriver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

			// ---Login---
			webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
			webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			new WebDriverWait(webDriver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
		}

	}

	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("TestReports\\PostLoginTest\\PostloginReports\\Postlogin.html");
		extentreport.attachReporter(spark);
	}

	public static List<String> getConsoleErrors() {
		return consoleErrors;
	}

	@AfterMethod
	public void captureFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.get().fail("Test Failed: " + result.getThrowable());
		}
	}

	@AfterSuite
	public void aftersuite() throws IOException {

		// Ensure to flush the ExtentReports
		if (extentreport != null) {
			extentreport.flush();
		}

		// Close the WebDriver instance
		if (webDriver != null) {
			webDriver.quit();
		}

// Set up email properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

// Authenticate the email account
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("hariharanv308@gmail.com", "gfmy vukk vxij lgtm"); // Replace with
																										// your email
																										// credentials
			}
		});

		try {
			// Compose the email
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hariharanv308@gmail.com")); // Sender's email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("suvetha@mobicip.com"));// ,gokul@mobicip.com,yazhini@mobicip.com,saranya@mobicip.com,vikram@mobicip.com,suvetha@mobicip.com"));
			message.setSubject("Live Website Postlogin Automation Test Reports");

			// Email body text
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(
					"Hi Team ! Please find the attached test reports of Website Postlogin Automation Testing.");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// List of files to attach
			String[] filenames = {
					"C:\\Users\\suvetha\\eclipse-workspace\\MerlinWeb\\MerlinWeb\\TestReports\\PostLoginTest\\PostloginReports\\Postlogin.html"

			};

			for (String filename : filenames) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));

				// Extract the file name for the attachment display
				String extractedFileName = filename.contains("\\") ? filename.substring(filename.lastIndexOf("\\") + 1)
						: filename.contains("/") ? filename.substring(filename.lastIndexOf("/") + 1) : filename; // Use
																													// full
																													// filename
																													// if
																													// no
																													// slashes
																													// are
																													// present

				messageBodyPart.setFileName(extractedFileName);
				multipart.addBodyPart(messageBodyPart);
			}

			// Combine all parts
			message.setContent(multipart);

			// Send the email
			Transport.send(message);

			System.out.println("Email sent successfully with multiple attachments.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
