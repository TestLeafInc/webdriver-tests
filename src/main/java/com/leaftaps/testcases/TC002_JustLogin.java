package com.leaftaps.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectHooks;
import com.leaftaps.pages.LoginPage;

public class TC002_JustLogin extends ProjectHooks{
	@BeforeTest
	public void setValues() {
<<<<<<< HEAD
		testcaseName = "Login";
		testDescription ="Login to Automation";
		authors="Lakshmi";
		category ="Smoke";
=======
		testcaseName = "Edittab";
		testDescription ="Login to Leaftaps";
		authors="Poovarasan";
		category ="Sanity";
>>>>>>> 55804f26fba77e2547475cba684275c9c8e6d366
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void runLogin(String username, String password) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin();

	}

}
