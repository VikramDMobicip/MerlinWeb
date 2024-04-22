package Prelogin;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Scanner;
import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserSetupClass {
  
  public static WebDriver webDriver = null;  
  ExtentReports extentReports = null;
  
  
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
			  webDriver.get("https://webs.prgr.in/");}
	      if(environment==2) {
	    	  webDriver.get("https://www.mobicip.com/");}
	  } 
	  
	  // Firefox browser setup
      else if (browser == 2) {
		  System.out.println("Setup and Launch Firefoxbrowser");
		  WebDriverManager.firefoxdriver().setup();
		  webDriver =new FirefoxDriver();
		  webDriver.get("https://www.mobicip.com/");
		  if(environment==1) {
			  webDriver.get("https://webs.prgr.in/");}
	      if(environment==2) {
	    	  webDriver.get("https://www.mobicip.com/");}
      }
  	  //without webdriver in maven
      else if (browser == 12) {
  		  System.out.println("Setup and Launch Firefoxbrowser");
  		  webDriver =new FirefoxDriver();
  		  webDriver.get("https://www.mobicip.com/");
      }
	  
	  
	  // Edge browser setup
	  else if (browser == 3) {
		  System.out.println("Setup and Launch Edgebrowser");
				
		  WebDriverManager.edgedriver().setup();
		  webDriver =new EdgeDriver();
		  webDriver.get("https://www.mobicip.com/");
	  }
	  //without webdriver in maven  
	  else if (browser == 13) {
		  System.out.println("Setup and Launch Edgebrowser");
		  webDriver =new EdgeDriver();
		  webDriver.get("https://www.mobicip.com/");
	  }
	  
 }
  
  @AfterSuite
  public void afterSuite() {
	  webDriver.quit();
  }
  
}

