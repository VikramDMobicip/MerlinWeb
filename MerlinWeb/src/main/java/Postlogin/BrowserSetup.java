package Postlogin;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {
	public static WebDriver webDriver = null;  
	
	  @BeforeSuite
	  public void beforeSuite() throws IOException {  
		  
	  // Choose Browser
	  Scanner input = new Scanner (System.in);
	  System.out.println("Browser :\n1. Chrome \n2. Firefox \n3. Edge\nChoose : ");
	  int browser = input.nextInt();
	  System.out.println("Environment :\n1. Staging \n2. Live \nChoose : ");
	  int environment = input.nextInt();
	  input.close();
		  
	  //Chrome browser setup
	  if (browser == 1) {
	  System.out.println("Setup and Launch Chromebrowser");
	  WebDriverManager.chromedriver().clearDriverCache().setup();
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
     // Instantiate a ChromeDriver class.
      webDriver = new ChromeDriver(options);
   	 // Maximize the browser
      webDriver.manage().window().maximize();
		     
     if(environment==1) {
    	  webDriver.get("https://webs.prgr.in/login");}
     if(environment==2) {
    	  webDriver.get("https://www.mobicip.com/login");}
     new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

	 //---Login---
	 webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
	 webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
	 webDriver.findElement(By.xpath("//button[@type='submit']")).click();
	 new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
	
	 } 
		  
     // Firefox browser setup
     else if (browser == 2) {
	  System.out.println("Setup and Launch Firefoxbrowser");
		  WebDriverManager.firefoxdriver().setup();
		  webDriver =new FirefoxDriver();
		  if(environment==1) {
			  webDriver.get("https://webs.prgr.in/");}
	      if(environment==2) {
    	  webDriver.get("https://www.mobicip.com/");}
	      new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

	 	 //---Login---
	 	 webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
	 	 webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
	 	 webDriver.findElement(By.xpath("//button[@type='submit']")).click();
	 	 new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
	 	
      }

	  //without webdriver in maven
      else if (browser == 12) {
	  	  System.out.println("Setup and Launch Firefoxbrowser");
	  	  webDriver =new FirefoxDriver();
	  	  if(environment==1) {
			  webDriver.get("https://webs.prgr.in/");}
	      if(environment==2) {
    	  webDriver.get("https://www.mobicip.com/");}
	      new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

		 //---Login---
		 webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
		 webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
		 webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		 new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
		 
      }
		 
		  
	  // Edge browser setup
	  else if (browser == 3) {
		 System.out.println("Setup and Launch Edgebrowser");
				
		 WebDriverManager.edgedriver().setup();
		 webDriver =new EdgeDriver();
		  if(environment==1) {
			  webDriver.get("https://webs.prgr.in/");}
	      if(environment==2) {
    	  webDriver.get("https://www.mobicip.com/");}
	      new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

		 //---Login---
		 webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
		 webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
		 webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		 new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
			
	  }
	
	  //without webdriver in maven  
	  else if (browser == 13) {
	  System.out.println("Setup and Launch Edgebrowser");
	  webDriver =new EdgeDriver();
	  if(environment==1) {
		  webDriver.get("https://webs.prgr.in/");}
      if(environment==2) {
	  webDriver.get("https://www.mobicip.com/");}
      new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

	  //---Login---
	  webDriver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
	  webDriver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
	  webDriver.findElement(By.xpath("//button[@type='submit']")).click();
	  new WebDriverWait(webDriver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
			
	 }
		  
	 }
	  
	  @AfterSuite
	  public void afterSuite() {
		  webDriver.quit();
	  }

}
