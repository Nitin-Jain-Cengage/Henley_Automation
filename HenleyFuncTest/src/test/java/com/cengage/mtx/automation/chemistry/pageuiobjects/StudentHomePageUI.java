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
 * The Class StudentHomePageUI.
 *
 * @author shwetabansal
 */
public class StudentHomePageUI extends BasePage {
	
	/**
	 * Instantiates a new student home page ui.
	 *
	 * @param driver the driver
	 */
	public StudentHomePageUI(WebDriver driver) {
		super(driver);
	}

	/** The txt_ my home. */
	@FindBy(xpath = "//h1[text()='My Home']")
	public WebElement txt_MyHome;

	/**
	 * Gets the btn_ open.
	 *
	 * @param bookName the book name
	 * @return the btn_ open
	 */
	public WebElement getBtn_Open(String bookName) {
		return expWait.getWhenVisible(By.xpath("//span[text()='" + bookName + "']/parent::a"), 80);
	}

	/**
	 * Gets the text_ courses and materials.
	 *
	 * @return the text_ courses and materials
	 */
	public WebElement getText_CoursesAndMaterials() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'My Courses') and contains(text(),'Materials')]"), 80);
	}

	/**
	 * Gets the _ last access book section.
	 *
	 * @return the _ last access book section
	 */
	public WebElement get_LastAccessBookSection() {
		return driver.findElement(By.xpath("//div[@id='lastAccessed' and @style='']"));
	}
}
