package com.qa.anz.pges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.anz.utils.ElementUtil;

public class LoginCalculatorPage {
	
	public WebDriver driver;
	private ElementUtil eleUtil;
	
	private By singleApplicationType = By.xpath("(//li[@class='selected']/label)[position()=1]"); 
	private By zeroDepadant = By.xpath("//select[@title='Number of dependants']"); 
	private By homeToLiveInPropertyType = By.xpath("(//li[@class='selected']/label)[position()=2]"); 
	
	private By yourIncome = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=1]"); 
	private By otherIncome = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=2]"); 
	private By livingExpences = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=3]"); 
	private By currLoanRepayment = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=4]"); 
	private By otherLoanRepayment = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=5]"); 
	private By otherCommitments = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=6]"); 
	private By creditLimit = By.xpath("(//div[@class='borrow__question']//div[@class='input__wrapper']/input)[position()=7]"); 
	private By buttonCalc = By.xpath("//button[@id='btnBorrowCalculater']");
	private By finalBorrowAmt = By.xpath("//span[@id='borrowResultTextAmount']");
	private By buttonStartOver = By.xpath("//button[@class='start-over']");
	private By footerMessage = By.xpath("//span[@class='borrow__error__text']");
	
	public LoginCalculatorPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String LoginCalculatorPageTitle() {
		return driver.getTitle();
	}
	

	public String getBorrowEstimate(String appType, String propertyType,  String text, 
			String yourIncomeValue, String otherIncomeValue, String livingExpencesValue, String currLoanRepaymentValue, 
			String otherLoanRepaymentValue, String otherCommitmentsValue, String creditLimitValue ) {
		
		if(appType.equalsIgnoreCase("single")) {
			eleUtil.doClick(singleApplicationType);
		}
		eleUtil.doSelectByVisibleText(zeroDepadant, text);
		if(propertyType.equalsIgnoreCase("Home to live in")) {
			eleUtil.doClick(homeToLiveInPropertyType);
		}
		eleUtil.doSendKeys(yourIncome, yourIncomeValue);
		eleUtil.doSendKeys(otherIncome, otherIncomeValue);
		eleUtil.doSendKeys(livingExpences, livingExpencesValue);
		eleUtil.doSendKeys(currLoanRepayment, currLoanRepaymentValue);
		eleUtil.doSendKeys(otherLoanRepayment, otherLoanRepaymentValue);
		eleUtil.doSendKeys(otherCommitments, otherCommitmentsValue);
		eleUtil.doSendKeys(creditLimit, creditLimitValue);
		eleUtil.doClick(buttonCalc);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String amt = eleUtil.waitForElementPresence(finalBorrowAmt, 8);
		return amt;
	}
	
	public boolean clearScreen() {
		eleUtil.doClick(buttonStartOver);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return eleUtil.doIsBlank(yourIncome);
	}
	
	public String getMessage(String value) {
		eleUtil.doSendKeys(livingExpences, value);
		eleUtil.doClick(buttonCalc);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return eleUtil.doGetText(footerMessage);
		
	}
	
	
	
}
