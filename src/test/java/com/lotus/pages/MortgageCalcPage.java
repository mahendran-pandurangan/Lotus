package com.lotus.pages;

import org.openqa.selenium.WebDriver;

import com.lotus.commonutils.CommonUtils;

public class MortgageCalcPage {
	
	private CommonUtils common = new CommonUtils();
	
	public void homePage(WebDriver driver, String homeValue, String pmi, String calculateButton){
		common.sendKey(driver, homeValue, "400000");
		common.sendKey(driver, pmi, "1.5");
		common.clickElement(driver, calculateButton);
	}

}
