/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.launchpad.automation.pageuiobjects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qait.automation.utils.SeleniumWait;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author prashantshukla
 */
public class BasePage {

    WebDriver driver;
    SeleniumWait expWait;

    public BasePage(WebDriver driver) {
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
    
  
}
