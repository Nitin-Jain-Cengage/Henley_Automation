/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.launchpad.automation.pageuiobjects;

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
    @FindBy(xpath="//span[text()='General_Chemistry']/parent::a")
    public WebElement btn_Open;
    
    
	public WebElement getBtn_Open() {
		return expWait.getWhenVisible(By.xpath("//span[text()='General_Chemistry']/parent::a"), 120);
	}
    
	public WebElement getBtn_Open(String dashboard_label_txt) {
		return expWait.getWhenVisible(By.xpath("//span[text()='"+ dashboard_label_txt +"']/parent::a"), 120);
	}       
  
}

