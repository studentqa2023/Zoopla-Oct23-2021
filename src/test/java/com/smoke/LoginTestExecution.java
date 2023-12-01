package com.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.generic.DriverManager;
import com.generic.MasterPageFactory;
import com.generic.ZooplaLogin;

public class LoginTestExecution {
	WebDriver driver;
	WebDriverWait wait;
	ExtentReports extent;
	ExtentTest test;
	MasterPageFactory mpf = new MasterPageFactory(driver);
	
	@BeforeTest
	public void setup() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/ZooplaLoginTest.html");
		reporter.config().setDocumentTitle("Testng Automation");
		reporter.config().setReportName("Smoke test");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Company ", "SMART TECH");
		extent.setSystemInfo("Testing environment ", "QA");
		extent.setSystemInfo("Team ", "QA");
		extent.setSystemInfo("Tester Name: ", System.getProperty("user.name"));
		driver = new DriverManager().getDriver();
		
	}
	
	@Test
	public void testLogin() {
		test = extent.createTest("Smoke Test-Login");
		new ZooplaLogin().getLogin(driver);
	}

	@AfterTest
	public void tearDown() {
	
	driver.quit();
	extent.flush();
	}
}
