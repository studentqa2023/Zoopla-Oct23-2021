package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.Screenshot;

public class ZooplaLogin {
	
	WebDriverWait wait;
	public void getLogin(WebDriver driver) {
		MasterPageFactory mpf = new MasterPageFactory(driver);
		
		Highlighter.addColor(driver, mpf.getSigninbtn());
		Screenshot.getScreenShot(driver, "Home page before login");
		mpf.getSigninbtn().click();
		
		Highlighter.addColor(driver, mpf.getEmail());
		mpf.getEmail().sendKeys(BaseConfig.getConfigValue("username"));
		
		Highlighter.addColor(driver, mpf.getPassword());
		mpf.getPassword().sendKeys(BaseConfig.getConfigValue("password"));
		
		Screenshot.getScreenShot(driver, "Login page");
		
		Highlighter.addColor(driver, mpf.getSigninbtn2());
		mpf.getSigninbtn2().click();
		
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(mpf.getMyZoopla()));
		
		Highlighter.addColor(driver, mpf.getMyZoopla());
		
		Actions ac = new Actions(driver);
		ac.moveToElement(mpf.getMyZoopla()).perform();
		
		Screenshot.getScreenShot(driver, "Home page after login");
		
		if(mpf.getSignoutbtn().isDisplayed()) {
			System.out.println("Zoopla login test passed!");
			Assert.assertTrue(mpf.getSignoutbtn().isDisplayed(), "Login succesful!");
		}else {
			System.out.println("Zoopla login test failed!");
			Assert.assertTrue(mpf.getSignoutbtn().isDisplayed(), "Login unsuccesful!");
		}
		
		
	}

}
