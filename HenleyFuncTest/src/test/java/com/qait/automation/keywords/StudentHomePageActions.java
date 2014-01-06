/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.pageuiobjects.StudentHomePageUI;

/**
 *
 * @author shwetabansal
 */
public class StudentHomePageActions extends LoginPageActions{
	StudentHomePageUI stdPage;
	WebDriver driver;
    public StudentHomePageActions(WebDriver driver) {
		super(driver);
		this.driver=driver;

		stdPage= new StudentHomePageUI(driver);
	}
	  
    public boolean verifyStudentHomePageContent(){
      
        if(stdPage.txt_MyHome.isDisplayed())
        {
            return true;
        }
        return false;
    }
    
	public void clickOnOpenButton()
    {
    	stdPage.getBtn_Open().isDisplayed();
    	stdPage.getBtn_Open().click();
    }
    
}
