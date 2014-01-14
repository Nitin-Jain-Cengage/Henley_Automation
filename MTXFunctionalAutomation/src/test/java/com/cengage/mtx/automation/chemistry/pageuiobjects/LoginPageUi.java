/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation.chemistry.pageuiobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author QAIT
 */
public class LoginPageUi extends BasePage {
	public LoginPageUi(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "emailId")
	public WebElement inp_username;
	@FindBy(id = "password")
	WebElement inp_password;
	@FindBy(css = "input[type='submit']")
	WebElement btn_login;
	@FindBy(css = "input[type='submit']")
	List<WebElement> btn_logins;

	public WebElement getUserNameField() {
		return inp_username;
	}

	public WebElement getLoginButtonByIndex(int index) {
		return getElementByIndex(btn_logins, index);
	}

	public WebElement getLoginButtonBytext(String elementtext) {
		return getElementByText(btn_logins, elementtext);
	}

	public WebElement getPasswordField() {
		return inp_password;
	}

	public WebElement getLoginButton() {
		return btn_login;
	}
}