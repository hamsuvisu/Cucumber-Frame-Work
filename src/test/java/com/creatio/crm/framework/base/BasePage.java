package com.creatio.crm.framework.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.creatio.crm.framework.utilities.PropUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage {

	// This class will have all the common methods related to browser configurations

	private static WebDriver driver = null;
	public Properties prop = PropUtil.readData("Config.properties");

	// method to launch the browser based on browser name coming from runner file
	@Before
	public void setupBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Invalid browser input");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	// method to tear down the browser sessions
	@After(order = 0)
	public void teardownBrowser() {
		driver.quit();
	}

	// method to tear down the browser sessions
	@After(order = 1)
	public void failedTestListener(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(file);
			scenario.attach(fileContent, "image/png", "Screenshot");
		}
	}

	// method to share browser session (driver) with other classes
	public WebDriver getDriver() {
		return driver;
	}

	// method to update browser session
	public void setDriver(WebDriver newDriver) {
		driver = newDriver;
	}
}
