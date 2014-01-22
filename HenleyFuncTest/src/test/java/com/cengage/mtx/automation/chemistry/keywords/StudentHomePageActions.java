/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation.chemistry.keywords;

import org.openqa.selenium.WebDriver;

import com.cengage.mtx.automation.chemistry.pageuiobjects.StudentHomePageUI;


// TODO: Auto-generated Javadoc
/**
 * The Class StudentHomePageActions.
 * 
 * @author shivamtiwari
 */
public class StudentHomePageActions extends LoginPageActions {
	
	/** The std page. */
	StudentHomePageUI stdPage;
	
	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new student home page actions.
	 * 
	 * @param driver
	 *            the driver
	 */
	public StudentHomePageActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		stdPage = new StudentHomePageUI(driver);
	}

	/**
	 * Verify student home page content.
	 *
	 * @return true, if successful
	 */
	public boolean verifyStudentHomePageContent() {
		if (stdPage.txt_MyHome.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Click on open button.
	 * 
	 * @param bookName
	 *            the book name
	 * @param env
	 *            the env
	 */
	public void clickOnOpenButton(String bookName, String env) {
		stdPage.waitForSyncPage();
		stdPage.getText_CoursesAndMaterials().isDisplayed();
		stdPage.get_LastAccessBookSection().isDisplayed();
		stdPage.getBtn_Open(bookName).isDisplayed();
		stdPage.getBtn_Open(bookName).isDisplayed();
		String attValue = stdPage.getBtn_Open(bookName).getAttribute("onclick");
		String[] url = attValue.split("http://.*.ng.cengage.com");
		System.out.println(url[1]);
		url = url[1].split("','MTC',");
		if (env.equals("qad")) {
			driver.navigate().to("http://qad-ng.cengage.com" + url[0]);
		}
		if (env.equals("qaf")) {
			driver.navigate().to("http://qaf.ng.cengage.com" + url[0]);
		}
	}
}
