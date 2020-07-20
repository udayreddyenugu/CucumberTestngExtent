package steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFB 
{	
	@Given("user navigates to facebook website")
	public void user_navigates_to_facebook_website() 
	{
		System.out.println("@Given == user navigates to Facebook website");
	}

	@When("user validates the homepage title")
	public void user_validates_the_homepage_title() 
	{
		System.out.println("@When == user validates the home page tile");
	}

	@Then("user enters {string} username")
	public void user_enters_username(String string) 
	{
		System.out.println("@Then == user enter "+string+" username");
	}

	@And("user enters {string} password")
	public void user_enters_password(String string) 
	{
		System.out.println("@And == user enter "+string+" password");
	}
	
	@And("user age selection")
	public void user_age_selection(DataTable dataTable) {
	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    System.out.println("@And == selected age is: "+data.get(0).get("Age")+" -- and selected locations as "+data.get(0).get("country"));
	    
	}

	@Then("user {string} successfully logged in")
	public void user_successfully_logged_in(String string) 
	{
		System.out.println("@Then == user "+string+" login");
	}
}
