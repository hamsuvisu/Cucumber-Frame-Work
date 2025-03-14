package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void verifyLoginIsSuccessful() {
		waitForElement(homePageHeaderLink,120);
	}
	
	public void verifySignUpIsSuccessful() {
		waitForElement(homePageHeaderLink,120);
	}


}
