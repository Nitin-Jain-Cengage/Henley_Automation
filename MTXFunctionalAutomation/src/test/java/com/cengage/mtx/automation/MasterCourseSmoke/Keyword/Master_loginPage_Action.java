package com.cengage.mtx.automation.MasterCourseSmoke.Keyword;

import org.openqa.selenium.WebDriver;

import com.cengage.mtx.automation.MasterCourseSmoke.pageuiobjects.Master_loginPage_Ui;

public class Master_loginPage_Action {
	/**
	 * @param args
	 */
	Master_loginPage_Ui masterLoginPage;

	public Master_loginPage_Action(WebDriver driver) {
		masterLoginPage = new Master_loginPage_Ui(driver);
	}
	
	public void loginToTheAdminApplication(String username, String password) {
		masterLoginPage.getinput_AdminUserName().sendKeys(username);
		masterLoginPage.getinput_AdminPassword().sendKeys(password);
		masterLoginPage.getBtn_AdminGO().click();
	}
	

	
}
