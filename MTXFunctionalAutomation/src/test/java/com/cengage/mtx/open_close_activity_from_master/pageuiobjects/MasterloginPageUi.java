package com.cengage.mtx.open_close_activity_from_master.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.chemistry.pageuiobjects.BasePage;

/**
 * The Class Master_loginPage_Ui.
 */
public class MasterloginPageUi extends BasePage{

	/**
	 * Instantiates a new master_login page_ ui.
	 *
	 * @param driver the driver
	 */
	public MasterloginPageUi(WebDriver driver) {
		super(driver);
	}

	/**
	 * Gets the input_ admin user name.
	 *
	 * @return the input_ admin user name
	 */
	public WebElement getinput_AdminUserName() {
		return expWait.getWhenVisible(By.name("username"), 80);
	}
	
	/**
	 * Gets the input_ admin password.
	 *
	 * @return the input_ admin password
	 */
	public WebElement getinput_AdminPassword() {
		return expWait.getWhenVisible(By.name("password"), 80);
	}
	
	/**
	 * Gets the btn_ admin go.
	 *
	 * @return the btn_ admin go
	 */
	public WebElement getBtn_AdminGO() {
		return expWait.getWhenVisible(By.className("goButton"), 80);
	}
}