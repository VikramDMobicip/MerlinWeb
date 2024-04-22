package Postlogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class shareFeedback extends baseClass{

	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
    public void beforeTest() 
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestShareFeedback\\reportShareFeedback.html");
		extentreport.attachReporter(spark);
    }
	
    //Checking for the title of home page and About mobicip page
	@Test
	public void a1_homepage()
	{
  		ExtentTest test=extentreport.createTest("Share Feedback page","Checking the title of the Share Feedback page ");
  		         
		//---Dash board---
		String tit=d.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test.pass("Dashboard - title is correct ");}
		else{test.fail("Dashboard - title isn't correct ");}
		boolean a=true;
		try {d.findElement(By.xpath("//p[text()='Hello Vikram!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Dashboard - Header was Incorrect");}
		if(a==true){test.pass("Dashboard - Header was correct");}
			
		//---Share Feedback---
		d.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Share Feedback']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		
		//---Validation - Share Feedback ---
		//Title
		tit=d.getTitle();
		if(tit.equals("Share Feedback | Mobicip"))
		{test.pass("Share Feedback - page opened and title is correct ");}
		else{test.fail("Share Feedback - title isn't correct ");}
    }
	
	public void goToShareFeedbackPage() {
  		d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//div[@class='user_profile_container']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Share Feedback']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  	}
	
	//Checking the header components
  	@Test
	public void a2_AboutMobicipHeader() {
  		ExtentTest test2=extentreport.createTest("Share Feedback - Header","Checking the header components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Mobicip logo is not found");}
		if(a==true) {test2.pass("Mobicip logo is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Back button is not found");}
		if(a==true) {test2.pass("Back button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Share Feedback']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("About Mobicip -  Header is incorrect");}
		if(a==true) {test2.pass("About Mobicip - Header is correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Profile icon is not present");}
		if(a==true) {test2.pass("Profile icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[@class='help_icon']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Help icon is not present");}
		if(a==true) {test2.pass("Help icon is present");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

		a=true;
		try{d.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Notification icon is not present");}
		if(a==true) {test2.pass("Notification icon is present");}
	}
  	
    //Share Feedback - Info text
  	@Test
	public void a3_ShareFeedbackInfotext(){
  		ExtentTest test3=extentreport.createTest("Share Feedback - Info text","Checking the Info text");
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='On a scale of 0 to 10, how likely are you to recommend Mobicip to a friend?']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Mobicip Info text is not found");}
		if(a==true) {test3.pass("Mobicip Info text is present");}
  	}

    //Share Feedback - Page Components
  	@Test
	public void a4_ShareFeedbackPageComponents(){
  		ExtentTest test4=extentreport.createTest("Share Feedback - Page components","Checking the Page components");
  		
  		boolean a = true;
  		try{d.findElement(By.xpath("//span[text()='Not Likely']"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Not Likely text is not found");}
		if(a==true) {test4.pass("Not Likely text is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//span[text()='Likely']"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Likely text is not found");}
		if(a==true) {test4.pass("Likely text is present");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range']"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Rating bar  is not found");}
		if(a==true) {test4.pass("Rating bar is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//div[@class='slider_label']"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Rating bar value text is not found");}
		if(a==true) {test4.pass("Rating bar value is present");}
		
		a = true;
  		try{d.findElement(By.xpath("//button[text()='Submit']"));} 
		catch(NoSuchElementException e){a=false;
		test4.fail("Submit button is not found");}
		if(a==true) {test4.pass("Submit button is present");}
  	}
  	
    //Share Feedback - 9 & 10 
  	@Test
	public void a5_Feedback9and10(){
  		ExtentTest test5=extentreport.createTest("Share Feedback - 9 & 10 ","Verify able to submit rating with 9 and 10. Warm Smile emoji is shown and No feedback form shown");
  		
  		//Checking value 10 shown by default
  		boolean a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='10']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Rating 10 is not shown by default");}
		if(a==true) {test5.pass("Rating 10 is shown by default");}
  		
  		//Slider function 
  		WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act = new Actions(d);
  		act.dragAndDropBy(slider, -60, 0).perform();  // slide left to 60 pixels to select 9
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//checking 9 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='9']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Rating 9 is not selected after a step of left slide");}
		if(a==true) {test5.pass("Rating 9 is  selected after a step of left slide");}
		
		//checking happy emoji shown while 9 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider happy']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Happy emoji is not shown while 9 is selected");}
		if(a==true) {test5.pass("Happy emoji is shown while 9 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test5.pass("Feedback and Reason options are not shown properly while 9 is selected");}
		if(a==true) {test5.fail("Feedback and Reason options are shown - improper");}
		
		//Submit with 9 
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Rating with 9 is not successfully submitted");}
		if(a==true) {test5.pass("Rating with 9 is successfully submitted");}
		 
		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
  		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test5.pass("App rating section is not shown as expected . The issue is fixed");}
		if(a==true) {test5.fail("App rating section is shown. The issue is not fixed");}
		
		//Checking with rating 10
		goToShareFeedbackPage();
		//Slider function
  		WebElement slider1 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act1 = new Actions(d);
  		act1.dragAndDropBy(slider1, -180, 0).perform();  // slide left to 180 pixels to select 7
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		act1.dragAndDropBy(slider1, 180, 0).perform();  // slide Right to 60 pixels to select 10
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 10 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='10']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Rating 10 is not selected after some step of right slide");}
		if(a==true) {test5.pass("Rating 10 is  selected after some step of right slide");}
  	
		//checking happy emoji shown while 10 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider happy']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Happy emoji is not shown while 10 is selected");}
		if(a==true) {test5.pass("Happy emoji is shown while 10 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test5.pass("Feedback and Reason options are not shown properly while 10 is selected");}
		if(a==true) {test5.fail("Feedback and Reason options are shown while 10 is selected - improper");}
		
		//Submit with 10
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test5.fail("Rating with 10 is not successfully submitted");}
		if(a==true) {test5.pass("Rating with 10 is successfully submitted");}
		
		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test5.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test5.fail("App rating section is shown. Reproduced with 10");}
  	}
  	
    //Share Feedback - 7 and 8
  	@Test
	public void a6_Feedback7and8(){
  		ExtentTest test6=extentreport.createTest("Share Feedback - 7 & 8","Verify able to submit rating with 7 and 8. Neutral face emoji is shown and  feedback form shown");
  		goToShareFeedbackPage();
  		//Slider function 
  		WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act = new Actions(d);
  		act.dragAndDropBy(slider, -120, 0).perform();  // slide left to 120 pixels to select 8
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//checking 8 is selected
  		boolean a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='8']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Rating 8 is not selected after a step of left slide");}
		if(a==true) {test6.pass("Rating 8 is  selected after a step of left slide");}
		
		//checking speechless emoji shown while 8 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider speechless']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("speechless emoji is not shown while 8 is selected");}
		if(a==true) {test6.pass("speechless emoji is shown while 8 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Feedback and Reason options are not shown, while 8 is selected");}
		if(a==true) {test6.pass("Feedback and Reason options are shown properly while 8 is selected");}
		
		//Submit with 8 
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Rating with 8 is not successfully submitted");}
		if(a==true) {test6.pass("Rating with 8 is successfully submitted");}
		 
		//Existing issue - while submit with 8 shows an info section of app rating , Which is not expected in web
		a = true;
  		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test6.pass("App rating section is not shown as expected . The issue is fixed");}
		if(a==true) {test6.fail("App rating section is shown. The issue is not fixed for value 8");}
		
		//Checking with rating 7
		goToShareFeedbackPage();
		//Slider function
  		WebElement slider1 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act1 = new Actions(d);
  		act1.dragAndDropBy(slider1, -180, 0).perform();  // slide left to 180 pixels to select 7
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 7 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='7']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Rating 7 is not selected after some step of right slide");}
		if(a==true) {test6.pass("Rating 7 is  selected after some step of right slide");}
  	
		//checking speechless emoji shown while 7 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider speechless']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("speechless emoji is not shown while 7 is selected");}
		if(a==true) {test6.pass("speechless emoji is shown while 7 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Feedback and Reason options are not shown properly while 7 is selected");}
		if(a==true) {test6.pass("Feedback and Reason options are shown properly while 7 is selected");}
		
		//Submit with 7 rating
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test6.fail("Rating with 7 is not successfully submitted");}
		if(a==true) {test6.pass("Rating with 7 is successfully submitted");}
		
		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test6.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test6.fail("App rating section is shown. Reproduced with 7");}
  	}
  	
//  public int app_rating_issue() {
//  	boolean a = true;
//		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
//		catch(NoSuchElementException e){a=false;
//		return 0;}
//		return 1;
//  	}
  	
    //Share Feedback - 0 to 6
  	@Test
	public void a7_Feedback7and8(){
  		ExtentTest test7=extentreport.createTest("Share Feedback - 0 to 6","Verify able to submit rating with  0 to 6. Frown emoji is shown and  feedback form shown");
  		
  		goToShareFeedbackPage();
  		//Slider function 
  		WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act = new Actions(d);
  		act.dragAndDropBy(slider, -250, 0).perform();  // slide left to 250 pixels to select 6
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//checking 6 is selected
  		boolean a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='6']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 6 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 6 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 6 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 6 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 6 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 6 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 6 is selected");}
		
		//Submit with 6
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 6 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 6 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 6");}
		
		//Checking with rating 5
		goToShareFeedbackPage();
  		//Slider function 
  		WebElement slider1 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act1 = new Actions(d);
  		act1.dragAndDropBy(slider1, -320, 0).perform();  // slide left to 320 pixels to select 5
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 5 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='5']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 5 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 5 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 5 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 5 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 5 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 5 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 5 is selected");}
		
		//Submit with 5
		JavascriptExecutor j1= (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 5 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 5 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 5");}
		
		//Checking for value 4
		goToShareFeedbackPage();
  		//Slider function 
  		WebElement slider2 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act2 = new Actions(d);
  		act2.dragAndDropBy(slider2, -390, 0).perform();  // slide left to 390 pixels to select 4
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		//checking 4 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='4']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 4 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 4 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 4 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 4 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 4 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 4 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 4 is selected");}
		
		//Submit with 4
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 4 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 4 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 4");}
		
		//Checking with rating 3
		goToShareFeedbackPage();
  		//Slider function 
  		WebElement slider3 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act3 = new Actions(d);
  		act3.dragAndDropBy(slider3, -460, 0).perform();  // slide left to 460 pixels to select 3
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 3 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='3']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 3 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 3 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 3 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 3 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 3 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 3 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 3 is selected");}
		
		//Submit with 3
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 3 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 3 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 3");}

		//Checking for value 2
		goToShareFeedbackPage();
  		//Slider function 
  		WebElement slider4 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act4 = new Actions(d);
  		act4.dragAndDropBy(slider4, -520, 0).perform();  // slide left to 520 pixels to select 2
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 2 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='2']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 2 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 2 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 2 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 2 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 2 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 2 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 2 is selected");}
		
		//Submit with 2
		JavascriptExecutor j4 = (JavascriptExecutor)d;
		j4.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 2 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 2 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 2");}

		//Checking with rating 1
		goToShareFeedbackPage();
  		
  		//Slider function 
  		WebElement slider5 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act5 = new Actions(d);
  		act5.dragAndDropBy(slider5, -590, 0).perform();  // slide left to 590 pixels to select 1
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 1 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='1']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 1 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 1 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 1 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 1 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 1 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 1 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 1 is selected");}
		
		//Submit with 1
		
		JavascriptExecutor j5 = (JavascriptExecutor)d;
		j5.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 1 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 1 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 1");}

		//Checking with rating 0
		goToShareFeedbackPage();
  		
  		//Slider function 
  		WebElement slider6 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act6 = new Actions(d);
  		act6.dragAndDropBy(slider6, -650, 0).perform();  // slide left to 650 pixels to select 0
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		
  		//checking 0 is selected
  		a = true;
  		try{d.findElement(By.xpath("//span[@class='input-range__label-container' and text()='0']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating 0 is not selected after a step of left slide");}
		if(a==true) {test7.pass("Rating 0 is  selected after a step of left slide");}
		
		//checking Sad emoji shown while 0 is selected
  		a = true;
  		try{d.findElement(By.xpath("//div[@class='input-range__slider sad']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("sad emoji is not shown while 0 is selected");}
		if(a==true) {test7.pass("sad emoji is shown while 0 is selected");}
		
		//No feedback,reason needed 
		a = true;
  		try{d.findElement(By.xpath("//div[@class='feedback_user_input']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Feedback and Reason options are not shown, while 0 is selected");}
		if(a==true) {test7.pass("Feedback and Reason options are shown properly while 0 is selected");}
		
		//Submit with 0
		JavascriptExecutor j6 = (JavascriptExecutor)d;
		j6.executeScript("window.scrollBy(0,1000)"); 
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
		a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test7.fail("Rating with 0 is not successfully submitted");}
		if(a==true) {test7.pass("Rating with 0 is successfully submitted");}

		//Existing issue - while submit with 9 shows an info section of app rating , Which is not expected in web
		a = true;
		try{d.findElement(By.xpath("//div[@class='app_rating']"));} 
		catch(NoSuchElementException e){a=false;
		test7.pass("App rating section is not shown as expected . Not reproduced");}
		if(a==true) {test7.fail("App rating section is shown. Reproduced with 0");}
  	}
  	  	
	@Test
	public void a8_ReasonFeedbackResponded(){
  		ExtentTest test8=extentreport.createTest("Tell us Why , Feedback - responded ","Verify able to submit with select Tell us why and add Feedback");
  		goToShareFeedbackPage();
		//Slider function 
  		WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act = new Actions(d);
  		act.dragAndDropBy(slider, -180, 0).perform();  // slide left to 180 pixels to select 7
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='support_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='setup_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='security_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='features_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("QA Automation");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
  		//Checking able to submit
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test8.fail("Unable to submit with select Tell us why and add Feedback");}
		if(a==true) {test8.pass("Able to submit with select Tell us why and add Feedback");}
	}
	
  	//Tell us Why , Feedback - Both not responded
	@Test
	public void a9_ReasonFeedbackNotResponded(){
  		ExtentTest test9=extentreport.createTest("Tell us Why , Feedback - Not responded ","Verify able to submit without select Tell us why and add Feedback");
  		goToShareFeedbackPage();
		//Slider function 
  		WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
  		Actions act = new Actions(d);
  		act.dragAndDropBy(slider, -380, 0).perform();  // slide left to 380 pixels to select 5
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)");
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//button[text()='Submit']")).click();
  		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
  		//Checking able to submit
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
  		d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test9.fail("Unable to submit without select Tell us why and add Feedback");}
		if(a==true) {test9.pass("Able to submit without select Tell us why and add Feedback");}
	}
  	
	//Tell us Why - responded , Feedback -  Not responded 
	@Test
	public void b0_ReasonOnlyResponded(){
		ExtentTest test10=extentreport.createTest("Tell us Why - responded, Feedback -  Not responded","Verify able to submit with select Tell us why and  without add Feedback");
  		goToShareFeedbackPage();
		//Slider function 
	  	WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
	  	Actions act = new Actions(d);
	  	act.dragAndDropBy(slider, -580, 0).perform();  // slide left to 580 pixels to select 1
	  	try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//label[@for='support_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='setup_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//label[@for='security_button']")).click();
  		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}	
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	  	//Checking able to submit
	  	boolean a = true;
	  	try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
	  	d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test10.fail("Unable to submit with select Tell us why and  without add Feedback");}
		if(a==true) {test10.pass("Able to submit with select Tell us why and  without add Feedback");}
	}
	
  	
	//Tell us Why - Not responded , Feedback -  responded
	@Test
	public void b1_ReasonFeedbackResponded(){
		ExtentTest test11=extentreport.createTest("Tell us Why - Not responded , Feedback -  responded","Verify able to submit without select Tell us why and  with add Feedback");
  		goToShareFeedbackPage();
		//Slider function 
	  	WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
	  	Actions act = new Actions(d);
	  	act.dragAndDropBy(slider, -250, 0).perform();  // slide left to 250 pixels to select 6
	  	try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("Automation QA");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	  	//Checking able to submit
	  	boolean a = true;
	  	try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
	  	d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test11.fail("Unable to submit with select Tell us why and  without add Feedback");}
		if(a==true) {test11.pass("Able to submit with select Tell us why and  without add Feedback");}
	}
	
  	//Tell us Why - Not responded , Feedback -  responded
  	@Test
  	public void b2_Feedback(){
  		ExtentTest test12=extentreport.createTest("Feedback - Validation","Verify able to submit feedback with Alphanumerical only with max 250 characters, More than 250 characters, Less than 250 characters And Unable to submit With Special characters");
  		goToShareFeedbackPage();
  		WebElement slider = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
	  	Actions act = new Actions(d);
	  	act.dragAndDropBy(slider, -250, 0).perform();  // slide left to 250 pixels to select 6
	  	//With Special characters
	  	JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,1000)");
		d.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("QWERTYUIOPASDFGHJKLZXCVBN#$@@!%QWERTYUIOPASDFGHJKLZXCVBN");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	  	boolean a=true;
	  	try{d.findElement(By.xpath("//span[text()='Special Characters not allowed']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("Able to submit With Special characters");}
		if(a==true) {test12.pass("Unable to submit With Special characters and Alert message shown while Special characters are added");}	
	  	d.findElement(By.xpath("//textarea[@name='feedback_text']")).clear();
	  	
	  	//With MORE THEN 250 CHARACTERS
		d.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("QWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERT");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	  	a=true;
	  	try{d.findElement(By.xpath("//span[text()='More than 250 characters not accepted']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("Able to submit With More then 250 characters");}
		if(a==true) {test12.pass("Unable to submit With More then 250 characters and Alert message shown while More then 250 characters are added");}	
	  	d.findElement(By.xpath("//textarea[@name='feedback_text']")).clear();
	  	
	  	//less then 250 characters
	  	d.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("QWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNqwertyuiop123456");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	    a=true;
	  	try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
	  	d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("Unable to submit with less then 250 characters ");}
		if(a==true) {test12.pass("Able to submit with less then 250 characters ");}	
		
		//With max limit of 250characters
		goToShareFeedbackPage();
 		WebElement slider1 = d.findElement(By.xpath("//span[@class='input-range__slider-container']"));
	  	Actions act1 = new Actions(d);
	  	act1.dragAndDropBy(slider1, -250, 0).perform();  // slide left to 250 pixels to select 6
	  	JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,1000)");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//textarea[@name='feedback_text']")).sendKeys("QWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBNQWERTYUIOPASDFGHJKLZXCVBN");
  		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
	    a=true;
	  	try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
	  	d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
		catch(NoSuchElementException e){a=false;
		test12.fail("Unable to submit with Max 250 characters ");}
		if(a==true) {test12.pass("Able to submit with maximum 250 characters ");}	
  	}
   	
  //Tell us Why - Not responded , Feedback -  responded
  	@Test
  	public void b3_SubmittedPage(){
  		ExtentTest test13=extentreport.createTest("Submitted - Thanks page.","Verify submitted page UI is shown fine.");
  		boolean  a = true;
  		try{d.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("Mobicip logo is not found");}
		if(a==true) {test13.pass("Mobicip logo is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("Back button is not found");}
		if(a==true) {test13.pass("Back button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Share Feedback']"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("About Mobicip -  Header is incorrect");}
		if(a==true) {test13.pass("About Mobicip - Header is correct");}
	  	try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}

		a=true;
		try{d.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("Profile icon is not present");}
		if(a==true) {test13.pass("Profile icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[@class='help_icon']"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("Help icon is not present");}
		if(a==true) {test13.pass("Help icon is present");}
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

		a=true;
		try{d.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));} 
		catch(NoSuchElementException e){a=false;
		test13.fail("Notification icon is not present");}
		if(a==true) {test13.pass("Notification icon is present");}

  		a=true;
 	  	try{d.findElement(By.xpath("//p[text()='Thank you for sharing your valuable feedback!']"));
 	  	d.findElement(By.xpath("//img[@alt='Feedback thanks']"));} 
 		catch(NoSuchElementException e){a=false;
 		test13.fail("Sumbit page UI is improper");}
 		if(a==true) {test13.pass("Sumbit page UI is Proper");}

		// redirect to dashboard
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  	}
  	
  	@AfterClass
    public void teardown() 
    {
//  		d.quit();
    	extentreport.flush();
    }
}