/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.chemistry.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cengage.mtx.utils.SeleniumWait;

/**
 * The Class BasePage.
 */
public class BasePage extends SeleniumWait {

	/** The driver. */
	protected WebDriver driver;
	
	/** The exp wait. */
	protected SeleniumWait expWait;

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 */
	public BasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Gets the element by index.
	 *
	 * @param elementlist the elementlist
	 * @param index the index
	 * @return the element by index
	 */
	protected WebElement getElementByIndex(List<WebElement> elementlist,
			int index) {
		return elementlist.get(index);
	}

	/**
	 * Gets the element by text.
	 *
	 * @param elementlist the elementlist
	 * @param elementtext the elementtext
	 * @return the element by text
	 */
	protected WebElement getElementByText(List<WebElement> elementlist,
			String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().equalsIgnoreCase(elementtext)) {
				element = elem;
			}
		}
		if (element == null) {
		}
		return element;
	}

	/**
	 * Gets the window handle.
	 *
	 * @return the window handle
	 */
	public void getWindowHandle() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 * Gets the _ token name.
	 *
	 * @param token the token
	 * @return the _ token name
	 */
	public void get_TokenName(String token) {
		waitLong(token.length());
	}

	/**
	 * Switch to frame.
	 *
	 * @param stf the stf
	 */
	public void switchToFrame(String stf) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(stf));
	}

	/**
	 * Switch to default content.
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Click on log out.
	 */
	public void clickOnLogOut() {
		driver.findElement(
				By.xpath(".//*[@class[contains(.,'user-menu-link')]]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('logout_link').click();");
	}

	/**
	 * Wait for sync page.
	 */
	public void waitForSyncPage() {
		expWait.waitForDomToLoad();
	}

	/**
	 * Wait long.
	 *
	 * @param i the i
	 */
	public void waitLong(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkWeekSliderSpinnerToDisappear() {
		expWait.waitForElementToDisappear(By.id("weekslider"), 5);
	}

	/**
	 * Execute js.
	 *
	 * @param script the script
	 */
	public void executeJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, (Object) null);
	}
}
