package com.cengage.mtx.chemistry.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class StartSubmitLogOutUi.
 */
public class StartSubmitLogOutUi extends BasePage {

	/**
	 * Instantiates a new start submit log out ui.
	 *
	 * @param driver the driver
	 */
	public StartSubmitLogOutUi(WebDriver driver) {
		super(driver);
	}

	/** The btn_start activity. */
	@FindBy(id = "rhs-actuallystart")
	public WebElement btn_startActivity;
	
	/** The btn_submit link for tutored. */
	@FindBy(id = "nav-group-submit")
	public WebElement btn_submitLinkForTutored;
	
	/** The close. */
	@FindBy(className = "closeActivity")
	public WebElement close;
	
	/** The link_submit for tutored. */
	@FindBy(id = "nav-group-submit")
	public WebElement link_submitForTutored;
	
	/** The btn_ submit activity. */
	@FindBy(xpath = "//div[text()='Submit Activity for Grading']")
	public WebElement btn_SubmitActivity;
	
	/** The txt_ logout message. */
	@FindBy(id = "logout")
	public WebElement txt_LogoutMessage;

	/**
	 * Gets the btn_start activity.
	 *
	 * @return the btn_start activity
	 */
	public WebElement getbtn_startActivity() {
		return expWait.getWhenVisible(By.xpath("//*[@id='rhs-actuallystart']"),
				80);
	}

	/**
	 * Gets the btn_start activity_ clickable.
	 *
	 * @return the btn_start activity_ clickable
	 */
	public WebElement getbtn_startActivity_Clickable() {
		return getWhenClickable(By.id("rhs-actuallystart"), 180);
	}

	/**
	 * Gets the txt_ logout message.
	 *
	 * @return the txt_ logout message
	 */
	public WebElement getTxt_LogoutMessage() {
		return txt_LogoutMessage;
	}

	/**
	 * Gets the btn_start activity for tutored.
	 *
	 * @return the btn_start activity for tutored
	 */
	public WebElement getbtn_startActivityForTutored() {
		return expWait.getWhenVisible(By.id("rhs-start"), 80);
	}

	/**
	 * Gets the frame_ content.
	 *
	 * @return the frame_ content
	 */
	public WebElement getFrame_Content() {
		return expWait.getWhenVisible(
				By.xpath("//*[contains(@id,'_NB_Main_IFrame')]"), 80);
	}

	/**
	 * Start activity for tutored_ clickable.
	 *
	 * @return the web element
	 */
	public WebElement startActivityForTutored_Clickable() {
		return getWhenClickable(By.id("rhs-start"), 120);
	}

	/**
	 * Gets the link_submit.
	 *
	 * @return the link_submit
	 */
	public WebElement getlink_submit() {
		return expWait.getWhenVisible(By.id("submit"), 80);
	}

	/**
	 * Gets the _ state for submit master.
	 *
	 * @return the _ state for submit master
	 */
	public WebElement get_StateForSubmitMaster() {
		return expWait
				.getWhenVisible(
						By.xpath("//div[@class='nav-groups']//div[contains(@class,'selected')]"),
						80);
	}

	/**
	 * Gets the btn_ next.
	 *
	 * @return the btn_ next
	 */
	public WebElement getbtn_Next() {
		return expWait.getWhenVisible(By.xpath("//div[text()='Next']"), 80);
	}

	/**
	 * Gets the btn_ submit activity.
	 *
	 * @return the btn_ submit activity
	 */
	public WebElement getBtn_SubmitActivity() {
		return expWait.getWhenVisible(
				By.xpath("//div[text()='Submit Activity for Grading']"), 80);
	}

	/**
	 * Gets the btn_ concept map.
	 *
	 * @return the btn_ concept map
	 */
	public WebElement getBtn_ConceptMap() {
		return expWait.getWhenVisible(By.id("conceptMapBtn"), 80);
	}

	/**
	 * Gets the overview graded out.
	 *
	 * @return the overview graded out
	 */
	public WebElement getOverviewGradedOut() {
		return expWait.getWhenVisible(
				By.xpath("//*[@class='group' and text()='Overview']"), 80);
	}

	/**
	 * Check overview status.
	 */
	public void checkOverviewStatus() {
		try {
			expWait.getWhenVisible(
					By.xpath("//*[text()='Overview']/parent::div[@class='sel-item']"),
					20);
		} catch (Exception e) {
		}
	}
}
