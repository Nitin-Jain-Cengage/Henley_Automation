/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.chemistry.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.chemistry.pageuiobjects.StudentHomePageUI;

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
    
	public void clickOnOpenButton(String bookName)
    {
		stdPage.waitForSyncPage();
		stdPage.getText_CoursesAndMaterials().isDisplayed();
		stdPage.get_LastAccessBookSection().isDisplayed();
		stdPage.getBtn_Open(bookName).isDisplayed();
		
		stdPage.getBtn_Open(bookName).isDisplayed();
    	String attValue = stdPage.getBtn_Open(bookName).getAttribute("onclick");
    	String [] url = attValue.split("http");
    	url = url[1].split("','MTC',");
    	driver.navigate().to("http"+url[0]);
		
		
		
//		while(stdPage.get_LastAccessBookSection().getAttribute("style").contains("display:none")){
//			System.out.println(stdPage.get_LastAccessBookSection().getAttribute("style"));
//			stdPage.waitForSyncPage();
//		}
//		
//		for (int i=0; i<80; i++){
//			if (stdPage.get_LastAccessBookSection().getAttribute("style").contains("display:none"))
//		}
		
		
//    	stdPage.getBtn_Open(bookName).isDisplayed();
//    	String attValue = stdPage.getBtn_Open(bookName).getAttribute("onclick");
//    	String [] url = attValue.split("http");
//    	url = url[1].split("','MTC',");
//    	driver.navigate().to("http"+url[0]);
    }
    
}
