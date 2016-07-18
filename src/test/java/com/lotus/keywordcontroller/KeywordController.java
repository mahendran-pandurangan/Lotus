package com.lotus.keywordcontroller;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.openqa.selenium.WebDriver;

import com.lotus.commonutils.CommonUtils;
import com.lotus.pages.MortgageCalcPage;
import com.lotus.pages.MortgageCalcSummaryPage;

public class KeywordController {
	
	private WebDriver driver;
	private CommonUtils common = new CommonUtils();
	private MortgageCalcPage mortCalc = new MortgageCalcPage();
	private MortgageCalcSummaryPage mortSummary = new MortgageCalcSummaryPage(driver);

	public void execute(WebDriver driver, String keyword, String arg1, String arg2, String arg3) throws Exception {
		System.out.println("keyword: " + keyword + ", " + arg1 + ", " + arg2 + ", " + arg3);
		try {
			switch (keyword) {
			case "getBaseUrl":
				common.getBaseUrl(driver, arg1);
				break;	
			case "homePage":
				mortCalc.homePage(driver, arg1, arg2, arg3);
				break;
			case "getAmount":
				String getResult = mortSummary.getAmount(driver, arg1);
				System.out.println("getAmount value is "+getResult);
				break;
			default:
				System.out.println("Skipping keyword not recognized or not yet supported: " + keyword);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			System.out.println(stringWriter.toString());
		}
	}

}