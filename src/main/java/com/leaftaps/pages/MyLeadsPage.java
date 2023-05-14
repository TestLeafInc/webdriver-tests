package com.leaftaps.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectHooks;

public class MyLeadsPage extends ProjectHooks{
	
	public CreateLeadPage clickCreateLeadLink() {
		click(locateElement(Locators.XPATH, "//a[text()='Create Lead']"));
		reportStep("Create Lead link is clicked", "pass");
		return new CreateLeadPage();
	}

}
