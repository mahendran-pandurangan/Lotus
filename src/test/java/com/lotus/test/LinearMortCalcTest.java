package com.lotus.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.lotus.src.Lotus;

public class LinearMortCalcTest {
	WebDriver driver;
	
	@Test
	public void testLinearMortgageCalc() throws Exception{
		Lotus lotus = new Lotus(driver);
		driver = lotus.common.getWebDriver("firefox");
		lotus.common.getBaseUrl(driver, "http://www.mortgagecalculator.org/");
		lotus.mortgageCalcPage.homePage(driver, "xpath=.//input[@name='param[homevalue]']", "xpath=.//input[@name='param[pmi]']", "xpath=.//input[@name='cal']");
		String getResult = lotus.mortgageCalcPageSummary.getAmount(driver, "xpath=.(//h3)[2]");
		System.out.println("Mortgage Calculator Page Summary value = " +getResult);
	}
	@AfterTest
	public void exitTest(){
		driver.quit();
	}

}
