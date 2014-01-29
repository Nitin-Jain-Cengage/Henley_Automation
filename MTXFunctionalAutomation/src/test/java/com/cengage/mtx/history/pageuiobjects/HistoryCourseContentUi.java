package com.cengage.mtx.history.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.chemistry.pageuiobjects.BasePage;

/**
 * The Class History_CourseContent_Ui.
 */
public class HistoryCourseContentUi extends BasePage {

	/**
	 * Instantiates a new history_ course content_ ui.
	 * 
	 * @param driver
	 *            the driver
	 */
	public HistoryCourseContentUi(WebDriver driver) {
		super(driver);
	}

	/**
	 * Gets the _ activity name from list.
	 * 
	 * @return the _ activity name from list
	 */
	public WebElement get_ActivityNameLink(String activityName) {
		return driver.findElement(By.xpath("//div[contains(@class,'dash-middle')]//div[@title='"+activityName+"']"));
	}

	/**
	 * Gets the btn_start activity.
	 * 
	 * @return the btn_start activity
	 */
	public WebElement getbtn_startActivity() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Start Activity')]"), 80);
	}

	/**
	 * Gets the btn_show submit activity button.
	 * 
	 * @return the btn_show submit activity button
	 */
	public WebElement getbtn_showSubmitActivityButton() {
		return expWait.getWhenVisible(By.xpath("//button[@data-ng-show='showSubmitActivityButton']"), 10);
	}

	/**
	 * Gets the activity heading.
	 * 
	 * @return the activity heading
	 */
	public WebElement getActivityHeading() {
		return expWait.getWhenVisible(By.xpath("//div[@class='nb_titles']/div"), 80);
	}

	/**
	 * Gets the btn_ print study.
	 * 
	 * @return the btn_ print study
	 */
	public WebElement getbtn_PrintStudy() {
		return expWait.getWhenVisible(By.id("print-button"), 80);
	}

	/**
	 * Gets the btn_close activity.
	 * 
	 * @return the btn_close activity
	 */
	public WebElement getbtn_closeActivity() {
		return expWait.getWhenVisible(By.className("closeActivity"), 80);
	}

	/**
	 * Gets the frame_ content.
	 * 
	 * @return the frame_ content
	 */
	public WebElement getFrame_Content() {
		return expWait.getWhenVisible(By.xpath("//*[contains(@id,'_NB_Main_IFrame')]"), 80);
	}

	/**
	 * Gets the btn_show submit activity button state.
	 * 
	 * @return the btn_show submit activity button state
	 */
	public WebElement getbtn_showSubmitActivityButtonState() {
		return driver.findElement(By.xpath("//button[@data-ng-show='showSubmitActivityButton']/parent::div"));
	}

	/**
	 * Gets the btn_ submit activity.
	 * 
	 * @return the btn_ submit activity
	 */
	public WebElement getBtn_SubmitActivity() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Submit Activity for Grading')]"), 80);
	}

	/**
	 * Btn_concept map.
	 * 
	 * @return the web element
	 */
	public WebElement btn_conceptMap() {
		return expWait.getWhenVisible(By.id("conceptMapBtn"), 80);
	}

	/**
	 * Gets the btn_ next button.
	 * 
	 * @return the btn_ next button
	 */
	public WebElement getbtn_NextButton() {
		return expWait.getWhenVisible(By.xpath("//button[contains(text(),'Next') and @style='']"), 80);
	}

	/**
	 * Gets the btn_ all next button.
	 * 
	 * @return the btn_ all next button
	 */
	public List<WebElement> getBtn_AllNextButton() {
		return driver.findElements(By.xpath("//button[@type='button' and contains(text(),'Next')]"));
	}
}
