package com.cengage.mtx.automation.MasterCourseSmoke.Keyword;

import org.openqa.selenium.WebDriver;

import com.cengage.mtx.automation.MasterCourseSmoke.pageuiobjects.Master_loginPage_Ui;

// TODO: Auto-generated Javadoc
/**
 * The Class Master_loginPage_Action.
 */
public class Master_loginPage_Action {
	
	/**
	 * The master login page.
	 *
	 */
	Master_loginPage_Ui masterLoginPage;

	/**
	 * Instantiates a new master_login page_ action.
	 *
	 * @param driver the driver
	 */
	public Master_loginPage_Action(WebDriver driver) {
		masterLoginPage = new Master_loginPage_Ui(driver);
	}
	
	/**
	 * Login to the admin application.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void loginToTheAdminApplication(String username, String password) {
		masterLoginPage.getinput_AdminUserName().sendKeys(username);
		masterLoginPage.getinput_AdminPassword().sendKeys(password);
		masterLoginPage.getBtn_AdminGO().click();
	}
	

	
}
