package com.creatio.crm.application.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	public LoginPageSteps loginPage;
	public CookiesPageSteps cookiesPage;
	public HomePageSteps homePage;
	public SignUpPageSteps signUpPage;
	
	@Given("Initialize all pages")
	public void initialize_all_pages() {
		WebDriver driver = new BasePage().getDriver(); //get driver after launching the browser window successfully
		loginPage = new LoginPageSteps(driver); // pass browser details to each class while locating elements
		cookiesPage = new CookiesPageSteps(driver);
		homePage = new HomePageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);	    
	}

	@Given("Launch the application")
	public void launch_the_application() {
		loginPage.launchApplication();	    
	}

	@Then("Verify cookies popup is displayed successfully")
	public void verify_cookies_popup_is_displayed_successfully() {
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();	    
	}

	@Then("^Verify cookies popUp (.*)$")
	public void verifyCookiesPopUpContent(String string) {
		cookiesPage.verifyCookiesPopUpContent(string);	    
	}

	@Then("Verify Cookies popup logos")
	public void verify_cookies_popup_logos() {
		cookiesPage.verifyCookiesPopUpLogos();	    
	}

	@Then("Verify Cookies popup selection buttons")
	public void verify_cookies_popup_selection_buttons() {
		cookiesPage.verifyCookiesSelectionButtons();	    
	}

	@Then("Verify cookies popup necessary button is disabled")
	public void verify_cookies_popup_necessary_button_is_disabled() {
		cookiesPage.verifyCookiesPopUpNecessarySwitchButtonIsDisabled();	    
	}

	@Then("Verify Cookies popup switch buttons are displayed and enabled")
	public void verify_cookies_popup_switch_buttons_are_displayed_and_enabled() {
		cookiesPage.verifyCookiesPopUpSwitchButtons();	    
	}

	@When("User click on show details link")
	public void user_click_on_show_details_link() {
		cookiesPage.clickOnShowDetailsLink();	    
	}

	@Then("User should be able to get expanded view of cookies popup")
	public void user_should_be_able_to_get_expanded_view_of_cookies_popup() {
		cookiesPage.verifyCookiesPopUpShowDetails();	    
	}

	@When("User click on {string} button")
	public void user_click_on_button(String string) {
		cookiesPage.selectCookies(string);	    
	}

	@Then("Cookies popup should be disappeared")
	public void cookies_popup_should_be_disappeared() {
		cookiesPage.verifyCookiesPopUpGettingDisappeared();	    
	}

	@When("^User enter (.*) and (.*)$")
	public void enterCredentials(String username, String password) {
		loginPage.enterCredentials(username, password);	    
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		loginPage.clickOnLoginButton();	    
	}

	@Then("Login Should be successful")
	public void login_should_be_successful() {
		homePage.verifyLoginIsSuccessful();	    
	}
	
	@Then("Close the cookies popUp by selecting the option {string}")
	public void close_the_cookies_pop_up_by_selecting_the_option(String string) {
		cookiesPage.selectCookies(string);
		cookiesPage.verifyCookiesPopUpGettingDisappeared();	
	}

	@When("User click on the SignUp link")
	public void user_click_on_the_sign_up_link() {
		loginPage.clickOnSignUpLink();
	}

	@Then("SignUp page should be launched")
	public void sign_up_page_should_be_launched() {
		signUpPage.verifySignUpPageIsLaunched();
	}

	@When("^User entered (.*) and (.*)$")
	public void enterUserDetails(String user, String pass) {
		signUpPage.enterUserDetails(user, pass);
	}

	@When("Click on Continue button")
	public void click_on_continue_button() {
		signUpPage.clickOnContinueButton();
	}

	@When("Enter Company Details")
	public void enter_company_details() {
		signUpPage.enterCompanyDetails();
	}

	@When("Click on SignUp button")
	public void click_on_sign_up_button() {
		signUpPage.clickOnSignUpButton();
	}

	@Then("SignUp should be successful")
	public void sign_up_should_be_successful() {
		homePage.verifySignUpIsSuccessful();
	}

}
