/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation.chemistry.keywords;

import org.openqa.selenium.WebDriver;

import com.cengage.mtx.automation.chemistry.pageuiobjects.LoginPageUi;

/**
 * The Class LoginPageActions.
 *
 * @author QAIT
 */
public class LoginPageActions {
	
	/** The loginpage. */
	LoginPageUi loginpage;

	/**
	 * Instantiates a new login page actions.
	 *
	 * @param driver the driver
	 */
	public LoginPageActions(WebDriver driver) {
		loginpage = new LoginPageUi(driver);
	}

	/**
	 * Type user name.
	 *
	 * @param username the username
	 */
	public void typeUserName(String username) {
		loginpage.getUserNameField().clear();
		loginpage.getUserNameField().sendKeys(username);
	}

	/**
	 * Type password.
	 *
	 * @param password the password
	 */
	public void typePassword(String password) {
		loginpage.getPasswordField().clear();
		loginpage.inp_username.sendKeys("");
		loginpage.getPasswordField().sendKeys(password);
	}

	/**
	 * Type username and password.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void typeUsernameAndPassword(String username, String password) {
		typeUserName(username);
		typePassword(password);
	}

	/**
	 * Login to the application.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void loginToTheApplication(String username, String password) {
		typeUsernameAndPassword(username, password);
		loginpage.getLoginButton().click();
	}

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public String getPageTitle() {
		return loginpage.getPageTitle();
	}
}
