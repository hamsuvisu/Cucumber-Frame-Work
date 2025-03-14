package com.creatio.crm.application.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements{
	
	public CookiesPageSteps(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyWhetherCookiesPopUpIsDisplayed() {
		waitForElement(cookiesHeader, 60);
	}
	
	public void verifyCookiesPopUpContent(String expContent) {
		String actualContent = getElementText(cookiesContent);
		Assert.assertEquals(actualContent, expContent);
	}
	
	public void verifyCookiesPopUpLogos() {
		Assert.assertTrue(isElementDisplayed(creatioLogo));
		Assert.assertTrue(isElementDisplayed(cookiebotLogo));
	}
	
	public void verifyCookiesSelectionButtons() {
		Assert.assertTrue(isElementDisplayed(allowAllBtn));
		Assert.assertTrue(isElementDisplayed(allowSelectionBtn));
		Assert.assertTrue(isElementDisplayed(denyBtn));
	}
	
	public void selectCookies(String option) {
		if(option.equalsIgnoreCase("AllowAll"))
			click(allowAllBtn);
		else if(option.equalsIgnoreCase("AllowSelection"))
			click(allowSelectionBtn);
		else if(option.equalsIgnoreCase("Deny"))
			click(denyBtn);
	}
	
	public void verifyCookiesPopUpNecessarySwitchButtonIsDisabled() {
//		Assert.assertTrue(isElementDisplayed(necessarySwitchtn));
		Assert.assertTrue(!isElementEnabled(necessarySwitchtn));
	}
	
	public void verifyCookiesPopUpSwitchButtons() {
//		Assert.assertTrue(isElementDisplayed(preferencesSwitchBtn));
		Assert.assertTrue(isElementEnabled(preferencesSwitchBtn));
		
//		Assert.assertTrue(isElementDisplayed(statisticsSwitchBtn));
		Assert.assertTrue(isElementEnabled(statisticsSwitchBtn));
		
//		Assert.assertTrue(isElementDisplayed(marketingSwitchBtn));
		Assert.assertTrue(isElementEnabled(marketingSwitchBtn));
	}
	
	public void clickOnShowDetailsLink() {
		click(showDetailsLink);
	}

	public void verifyCookiesPopUpShowDetails() {
		waitForElement(cookiePopUpExpandedDetails, 60);
	}
	
	public void verifyCookiesPopUpGettingDisappeared() {
		waitForElementDisappeared(cookiesHeader, 60);
	}
}
