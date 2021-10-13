package com.qa.anz.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.anz.utils.Constants;

public class LoginCalculatorPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginCalculatorPageTitleTest() {
		String actualTitle = logCal.LoginCalculatorPageTitle();
		System.out.println("Calculator Page Title is : " + actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@DataProvider
	public Object[][] getEstimateTestData() {
		return new Object[][] {
				{ "Single", "Home to live in", "0", "80000", "10000", "500", "0", "100", "0", "10000", } };

	}

	@Test(priority = 2, dataProvider = "getEstimateTestData")
	public void getEstimate(String appType, String propertyType, String text, String yourIncomeValue,
			String otherIncomeValue, String livingExpencesValue, String currLoanRepaymentValue,
			String otherLoanRepaymentValue, String otherCommitmentsValue, String creditLimitValue) {
		String finalEstimate = logCal.getBorrowEstimate(appType, propertyType, text, yourIncomeValue, otherIncomeValue,
				livingExpencesValue, currLoanRepaymentValue, otherLoanRepaymentValue, otherCommitmentsValue,
				creditLimitValue);
		System.out.println("Based on the input provided Final estimated value is : " + finalEstimate);
		Assert.assertEquals(finalEstimate, Constants.BORROWING_ESTIMATE,
				"The Calculated amount is not matching with the expected.");
	}

	@Test(priority = 3)
	public void clearFormTest() {
		Assert.assertTrue(logCal.clearScreen());
	}

	@Test(priority = 4)
	public void footerMessageTest() {
		logCal.getMessage("1");
	}

}
