package com.lotus.test;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.lotus.src.Config;
import com.lotus.src.Lotus;

@ContextConfiguration(locations = { "classpath:config/default/beans.xml" })
public class SpringMortCalcTest extends AbstractTestNGSpringContextTests {

	@Autowired
	Config config;
	
WebDriver driver;
	
	@Test
	public void testLinearMortgageCalc() throws Exception{
		Lotus lotus = new Lotus(driver);
		driver = lotus.common.getWebDriver(config.getBrowserType().toString());
		lotus.common.getBaseUrl(driver, config.getBaseUrl().toString());
		lotus.mortgageCalcPage.homePage(driver, "xpath=.//input[@name='param[homevalue]']", "xpath=.//input[@name='param[pmi]']", "xpath=.//input[@name='cal']");
		String getResult = lotus.mortgageCalcPageSummary.getAmount(driver, "xpath=.(//h3)[2]");
		System.out.println("Mortgage Calculator Page Summary value = " +getResult);
	}
	@AfterTest
	public void exitTest(){
		driver.quit();
	}

}
