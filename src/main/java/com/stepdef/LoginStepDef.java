package com.stepdef;

import org.openqa.selenium.WebDriver;

import com.generic.DriverManager;
import com.generic.ZooplaLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	WebDriver driver;
	@Given("open the browser and pass the URL")
	public void setup() {
		driver = new DriverManager().getDriver();
	}
	
	@When("enter valid username and password")
	public void loginTest() {
		new ZooplaLogin().getLogin(driver);
	}
	
	@Then("Login should be successful")
	public void tearDown() {
		driver.quit();
	}

}
