package steps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import listener.CustExtentReport;

public class LoginFB extends CustExtentReport
{	
	WebDriver driver;
	
	@Given("user navigates to facebook website")
	public void user_navigates_to_facebook_website() 
	{
		ExtentTest loginfo=null;
		try {
			test = extent.createTest(Feature.class,"Login");
			test = test.createNode(Scenario.class,"In order to verify login to facebook");
			loginfo=test.createNode(new GherkinKeyword("Given"),"user_navigates_to_facebook_website");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			loginfo.pass("@Given ==> user navigated to facebook.com");
			loginfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		}
		catch (AssertionError | Exception e)
		{
			testStepHandle("FAIL", driver, loginfo, e);
		}
	}

	@When("user validates the homepage title")
	public void user_validates_the_homepage_title() 
	{
		ExtentTest loginfo=null;
		try {
			
			loginfo=test.createNode(new GherkinKeyword("When"),"user_validates_the_homepage_title");
			String pagetitle = driver.getTitle();	
//			System.out.println("@When ==> The page title is ==> "+ pagetitle);
			
			loginfo.pass("@When ==> The page title is ==> "+ pagetitle);
			loginfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError | Exception e)
		{
			testStepHandle("FAIL", driver, loginfo, e);
		}
	}

	@Then("user enters {string} username")
	public void user_enters_username(String string) 
	{
		ExtentTest loginfo=null;
		try {
			
			loginfo=test.createNode(new GherkinKeyword("Then"),"user_enters_username");
			driver.findElement(By.id("email")).sendKeys(string);	
//			System.out.println("@Then == user name entered ==> "+string);
			loginfo.pass("@Then == user name entered ==> "+string);
			loginfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError | Exception e)
		{
			testStepHandle("FAIL", driver, loginfo, e);
		}
		
	}

	@And("user enters {string} password")
	public void user_enters_password(String string) 
	{
		ExtentTest loginfo=null;
		try {
			
			loginfo=test.createNode(new GherkinKeyword("And"),"user_enters_password");
			driver.findElement(By.id("pass")).sendKeys(string);
//			System.out.println("@And == password enter ==> "+string);		
			loginfo.pass("@And == password enter ==> "+string);
			loginfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError | Exception e)
		{
			testStepHandle("FAIL", driver, loginfo, e);
		}
	}
	
	@And("user age selection")
	public void user_age_selection(DataTable dataTable) {
		ExtentTest loginfo=null;
		try {
			
			loginfo=test.createNode(new GherkinKeyword("And"),"user_age_selection");
			List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//		    System.out.println("@And == selected age is: "+data.get(0).get("Age")+" -- and selected locations as "+data.get(0).get("country"));		
			loginfo.pass("@And == selected age is: "+data.get(0).get("Age")+" -- and selected locations as "+data.get(0).get("country"));
			loginfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError | Exception e)
		{
			testStepHandle("FAIL", driver, loginfo, e);
		} 
	}

	@Then("user {string} successfully logged in")
	public void user_successfully_logged_in(String string) 
	{
		ExtentTest loginfo=null;
		try {			
			loginfo=test.createNode(new GherkinKeyword("Then"),"user_successfully_logged_in");
			
			Assert.assertTrue(driver.getTitle().equals("@"));
			driver.quit();
//			System.out.println("@Then == user "+string+" login");		
			loginfo.pass("@Then == user "+string+" login");
			loginfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError | Exception e)
		{
			testStepHandle("FAIL", driver, loginfo, e);
		}

	}
}
