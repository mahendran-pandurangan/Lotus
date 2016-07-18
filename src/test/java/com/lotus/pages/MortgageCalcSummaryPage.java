package com.lotus.pages;

import org.openqa.selenium.WebDriver;

import com.lotus.commonutils.CommonUtils;

public class MortgageCalcSummaryPage {
	
	private WebDriver driver;
	private CommonUtils common;

	public MortgageCalcSummaryPage(WebDriver driver){
		this.driver = driver;
		this.common = new CommonUtils();
	}
	
	public String getAmount(WebDriver driver, String getValue){
		return common.getWebElementText(driver, getValue);
	}

}
