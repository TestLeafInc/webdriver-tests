package com.framework.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.ReadExcel;

public class ProjectHooks extends SeleniumBase {

	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return ReadExcel.readExcelData(excelFileName);
	}
	
	@BeforeMethod
	public void preCondition() {
		startApp("chrome", true, "http://leaftaps.com/opentaps");
		setNode();
	}
	
	@AfterMethod
	public void postCondition() {
		close();

	}

	

	
	  

	
	
}
