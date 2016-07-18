package com.lotus.test;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.lotus.src.Lotus;

public class KeywordMortCalcTest {
	
	WebDriver driver;
	Lotus key = new Lotus(driver);

	@BeforeTest
	public void setUp() {
		driver = key.common.getWebDriver(key.testBedManager.getBrowserType());
	}

	@Test
	public void testMortgageCalc() {
		try {
			String excelTD[][] = key.readXls.readXL("src/test/resources/keyword-source.xls", "keyword");
			for (int count = 1; count < excelTD.length; count++) {
				String keyTD = excelTD[count][2];
				String injectedArg1 = excelTD[count][3];
				String injectedArg2 = excelTD[count][4];
				String injectedArg3 = excelTD[count][5];
				key.keywordExecute.execute(driver, keyTD, injectedArg1, injectedArg2, injectedArg3);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			System.out.println(stringWriter.toString());
		}
	}

	@AfterTest
	public void exitTest() {
		driver.quit();
	}

}
