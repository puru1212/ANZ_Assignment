package com.qa.anz.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.anz.factory.DriverFactory;
import com.qa.anz.pges.LoginCalculatorPage;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	LoginCalculatorPage logCal;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.iniProperties();
		driver = df.iniDriver(prop);
		logCal = new LoginCalculatorPage(driver);
	}

	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
