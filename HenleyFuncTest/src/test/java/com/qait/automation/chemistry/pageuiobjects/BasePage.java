/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.chemistry.pageuiobjects;

import com.qait.automation.utils.SeleniumWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author prashantshukla
 */
public class BasePage extends SeleniumWait{

    protected WebDriver driver;
    protected SeleniumWait expWait;

    public BasePage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected WebElement getElementByIndex(List<WebElement> elementlist, int index) {
        return elementlist.get(index);
    }

    protected WebElement getElementByText(List<WebElement> elementlist, String elementtext) {
        WebElement element = null;
        for (WebElement elem : elementlist) {
            if (elem.getText().equalsIgnoreCase(elementtext)) {
                element = elem;
            }
        }
        //FIXME: handle if no element with the text is found in list
        if (element == null) {
        }
        return element;
    }
    
    public void getWindowHandle(){
    	
    		for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
       		}
        }
    
    public void switchToFrame(String stf) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(stf));
	}
    
    public void switchToDefaultContent() {
    	driver.switchTo().defaultContent();
	}
    
    public void clickOnLogOut(){
       	driver.findElement(By.xpath(".//*[@class[contains(.,'user-menu-link')]]")).click();
       	driver.findElement(By.id("logout_link")).click();
      	
    }
    
    public void waitForSyncPage(){
    	expWait.waitForDomToLoad();
    }
}
