package com.cengage.mtx.automation.MasterCourseSmoke.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.automation.chemistry.pageuiobjects.BasePage;

public class Master_loginPage_Ui extends BasePage{

	public Master_loginPage_Ui(WebDriver driver) {
		super(driver);
	}

	public WebElement getinput_AdminUserName() {
		return expWait.getWhenVisible(By.name("username"), 80);
	}
	
	public WebElement getinput_AdminPassword() {
		return expWait.getWhenVisible(By.name("password"), 80);
	}
	
	public WebElement getBtn_AdminGO() {
		return expWait.getWhenVisible(By.className("goButton"), 80);
	}
}
