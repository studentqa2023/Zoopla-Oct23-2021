package com.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(publish = true,plugin = { "pretty", 
		"html:target/site/cucumber-pretty", "rerun:target/rerun.txt",
		"json:target/cucumber.json"
		},

		features = { "src/test/resources/ZooplaLogin.feature" }, 
		glue = { "com.stepdef" }, // package name
		monochrome = true, //remove all ?? & console will be easily readable
		dryRun = true, //check feature file
		strict = true //check stepdef
		// ,tags= {"@Function"}
	

)

public class RunnerLogin extends AbstractTestNGCucumberTests{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@AfterClass
	public void getExtentReport() {
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
		
		test = extent.createTest("Smoke Test-Login");
		
		extent.flush();
	}
	
	
}
