package com.lotus.src;

import org.openqa.selenium.WebDriver;

import com.lotus.commonutils.CommonUtils;
import com.lotus.datasource.ExcelReader;
import com.lotus.envmanager.TestBedManager;
import com.lotus.keywordcontroller.KeywordController;
import com.lotus.pages.MortgageCalcPage;
import com.lotus.pages.MortgageCalcSummaryPage;

public class Lotus {

	public WebDriver driver;
	public MortgageCalcPage mortgageCalcPage;
	public MortgageCalcSummaryPage mortgageCalcPageSummary;
	public CommonUtils common;
	public ExcelReader readXls;
	public KeywordController keywordExecute;
	public TestBedManager testBedManager;
	
	public Lotus(WebDriver driver){

		this.driver = driver;
		this.common = new CommonUtils();
		this.mortgageCalcPage = new MortgageCalcPage();
		this.mortgageCalcPageSummary = new MortgageCalcSummaryPage(this.driver);
		this.readXls = new ExcelReader();
		this.keywordExecute = new KeywordController();
		this.testBedManager = new TestBedManager();
		return;
	}

}
