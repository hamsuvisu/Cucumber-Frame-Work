package com.creatio.crm.application.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void launchApplication() {		
		launchTheApplication();
		Assert.assertEquals(getTitle(), prop.getProperty("title"));
	}
	
	public void verifyLoginHeader() {
		waitForElement(loginPageHeader, 5);
		Assert.assertEquals(getElementText(loginPageHeader), prop.get("loginHeader"));
	}
	
	public void enterCredentials(String username, String password) {
		waitForElement(businessEmailTxtb, 5);
		enterText(businessEmailTxtb, username);
		enterText(passwordTxtb, password);
	}
	
	public void clickOnLoginButton() {
		click(loginBtn);
	}
	
	public void clickOnSignUpLink() {
		waitForElement(signUpLink, 5);
		jsClick(signUpLink);
	}	

}
