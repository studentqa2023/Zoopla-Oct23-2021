package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.BaseConfig;

public class DriverManager {
	
	public WebDriver getDriver() {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_v94.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(BaseConfig.getConfigValue("QA_URL"));
		
		return driver;
	}

}
