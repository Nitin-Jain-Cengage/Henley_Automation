/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.chemistry.pageuiobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class LoginPageUi.
 */
public class LoginPageUi extends BasePage {

	/**
	 * Instantiates a new login page ui.
	 *
	 * @param driver the driver
	 */
	public LoginPageUi(WebDriver driver) {
		super(driver);
	}

	/** The inp_username. */
	@FindBy(id = "emailId")
	public WebElement inp_username;
	
	/** The inp_password. */
	@FindBy(id = "password")
	WebElement inp_password;
	
	/** The btn_login. */
	@FindBy(css = "input[type='submit']")
	WebElement btn_login;
	
	/** The btn_logins. */
	@FindBy(css = "input[type='submit']")
	List<WebElement> btn_logins;

	/**
	 * Gets the user name field.
	 *
	 * @return the user name field
	 */
	public WebElement getUserNameField() {
		return inp_username;
	}

	/**
	 * Gets the login button by index.
	 *
	 * @param index the index
	 * @return the login button by index
	 */
	public WebElement getLoginButtonByIndex(int index) {
		return getElementByIndex(btn_logins, index);
	}

	/**
	 * Gets the login button bytext.
	 *
	 * @param elementtext the elementtext
	 * @return the login button bytext
	 */
	public WebElement getLoginButtonBytext(String elementtext) {
		return getElementByText(btn_logins, elementtext);
	}

	/**
	 * Gets the password field.
	 *
	 * @return the password field
	 */
	public WebElement getPasswordField() {
		return inp_password;
	}

	/**
	 * Gets the login button.
	 *
	 * @return the login button
	 */
	public WebElement getLoginButton() {
		return btn_login;
	}
}