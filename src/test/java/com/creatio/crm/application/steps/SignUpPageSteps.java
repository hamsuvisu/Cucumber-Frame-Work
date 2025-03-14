package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.SignUpPageElements;

public class SignUpPageSteps extends SignUpPageElements{
	
	public SignUpPageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void verifySignUpPageIsLaunched() {
		waitForElement(signUpPageHeader, 60);
	}
	
	public void enterUserDetails(String email, String password) {
		enterText(businessEmailTxtb, uniqueId("hhmmss")+email);
		enterText(passwordTxtb, password);
	}
	
	public void clickOnContinueButton() {
		click(continueBtn);
	}
	
	public void enterCompanyDetails() {
		waitForElement(firstNameTxtb, 5);
		wait(3);
		enterText(firstNameTxtb, "BharathTechAcademy");
		enterText(lastNameTxtb, "Academy");
		enterText(websiteTxtb, "www.BharathTechAcademy.com");
		enterText(companyTxtb, "BharathTechAcademy");
		enterText(countryTxtb, "India");
		waitForElement(countryOption,5);
		click(countryOption);
		wait(5);
		click(phoneTxtb);
		wait(5);
		enterInfo(phoneTxtb, "90"+uniqueId("ddMMhhmm"));
	}
	
	public void clickOnSignUpButton() {
		jsClick(SignUpBtn);
	}

}
