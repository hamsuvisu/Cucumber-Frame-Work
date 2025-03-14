package com.creatio.crm.application.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue={"com.creatio.crm.application.stepDefinitions","com.creatio.crm.framework.base"},
		plugin= {"pretty","html:Reports/AutomationTestReport.html"}	
//		,tags="@Regression or @Sanity"
		)

public class E2ETestRunner {

}
