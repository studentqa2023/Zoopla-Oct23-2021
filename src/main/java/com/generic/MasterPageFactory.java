package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {
	
	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//*[contains(text(),'Sign in')])[2]")
	private WebElement signinbtn;
	
	@FindBy(xpath="//*[@id='input-email-address']")
	private WebElement email;
	
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="(//*[contains(text(),'Sign in')])[7]")
	private WebElement signinbtn2;
	
	@FindBy(xpath="(//*[contains(text(),'My Zoopla')])[1]")
	private WebElement myZoopla;
	
	@FindBy(xpath="(//*[contains(text(),'Sign out')])[1]")
	private WebElement signoutbtn;

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	public WebElement getMyZoopla() {
		return myZoopla;
	}

	public WebElement getSigninbtn2() {
		return signinbtn2;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}

}
