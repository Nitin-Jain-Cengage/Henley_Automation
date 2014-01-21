/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation.chemistry.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author shwetabansal
 */
public class StudentHomePageUI extends BasePage {
	public StudentHomePageUI(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[text()='My Home']")
	public WebElement txt_MyHome;

	public WebElement getBtn_Open(String bookName) {
		return expWait.getWhenVisible(By.xpath("//span[text()='" + bookName + "']/parent::a"), 80);
	}

	public WebElement getText_CoursesAndMaterials() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'My Courses') and contains(text(),'Materials')]"), 80);
	}

	public WebElement get_LastAccessBookSection() {
		return driver.findElement(By.xpath("//div[@id='lastAccessed' and @style='']"));
	}
}
