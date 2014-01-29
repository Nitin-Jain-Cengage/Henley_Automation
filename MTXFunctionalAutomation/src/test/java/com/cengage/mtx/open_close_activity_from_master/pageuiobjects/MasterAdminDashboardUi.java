package com.cengage.mtx.open_close_activity_from_master.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.chemistry.pageuiobjects.BasePage;

/**
 * The Class Master_Admin_Dashboard_Ui.
 */
public class MasterAdminDashboardUi extends BasePage {
	
	/**
	 * Instantiates a new master_ admin_ dashboard_ ui.
	 *
	 * @param driver the driver
	 */
	public MasterAdminDashboardUi(WebDriver driver) {
		super(driver);
	}

	/**
	 * Gets the input_ search text box admin dashboard.
	 *
	 * @return the input_ search text box admin dashboard
	 */
	public WebElement getinput_SearchTextBoxAdminDashboard() {
		return expWait.getWhenVisible(By.id("searchField"), 80);
	}

	/**
	 * Gets the link_isbn book.
	 *
	 * @param isbnNumber the isbn number
	 * @return the link_isbn book
	 */
	public WebElement getlink_isbnBook(String isbnNumber) {
		return expWait.getWhenVisible(By.xpath("//div[contains(text(),'" + isbnNumber + "')]/parent::div/a"), 80);
	}

	/**
	 * Gets the txt_ conept map.
	 *
	 * @return the txt_ conept map
	 */
	public WebElement gettxt_ConeptMap() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Concept Map')]"), 80);
	}

	/**
	 * Gets the img_ assessment.
	 *
	 * @return the img_ assessment
	 */
	public WebElement getImg_Assessment() {
		return expWait.getWhenVisible(By.xpath("(//div[@class='list_area']//div[@class='thumbIcon' and @title='Assessment'])[1]"), 80);
	}

	/**
	 * Gets the heading_ unit.
	 *
	 * @return the heading_ unit
	 */
	public WebElement getHeading_Unit() {
		return expWait.getWhenVisible(By.xpath("//span[@class='lpn_title' and contains(text(),'Henley Chemistry Digital Course_Do_Not_Edit')]"), 80);
	}

	/**
	 * Gets the link_ all unit name.
	 *
	 * @return the link_ all unit name
	 */
	public List<WebElement> getLink_AllUnitName() {
		return driver.findElements(By.xpath("//*[@class='lpn_name']/a"));
	}

	/**
	 * Gets the link_ all assessment name.
	 *
	 * @return the link_ all assessment name
	 */
	public List<WebElement> getLink_AllAssessmentName() {
		return driver.findElements(By.xpath("//div[@class='list_area']//div[@class='thumbIcon' and @title='Assessment']/parent::div/following-sibling::div/h3/a"));
	}

	/**
	 * Gets the _ course view title container.
	 *
	 * @return the _ course view title container
	 */
	public WebElement get_CourseViewTitleContainer() {
		return expWait.getWhenVisible(By.xpath("//*[@class='lpn_back' and @style='display: block;']"), 80);
	}

	/**
	 * Gets the link_ home launcher.
	 *
	 * @return the link_ home launcher
	 */
	public WebElement getLink_HomeLauncher() {
		return driver.findElement(By.id("nb_lpLauncher"));
	}

	/**
	 * Gets the nav_ unit nav.
	 *
	 * @return the nav_ unit nav
	 */
	public WebElement getNav_UnitNav() {
		return driver.findElement(By.id("nb_lpNav"));
	}

	/**
	 * Gets the btn_ back.
	 *
	 * @return the btn_ back
	 */
	public WebElement getbtn_Back() {
		return expWait.getWhenVisible(By.xpath(".//*[@class='lpn_back' and @style='display: block;']/a"), 80);
	}

	/**
	 * Gets the _ course view title container disabled.
	 *
	 * @return the _ course view title container disabled
	 */
	public WebElement get_CourseViewTitleContainerDisabled() {
		return expWait.getWhenVisible(By.xpath("//*[@class='lpn_back' and @style='display: none;']"), 80);
	}

	//
	/**
	 * Gets the heading_ assessment content.
	 *
	 * @return the heading_ assessment content
	 */
	public WebElement getHeading_AssessmentContent() {
		return expWait.getWhenVisible(By.xpath("//div[@id='54_NB_App']//div[@class='nb_actTitle nb_math']"), 80);
	}

	/**
	 * Gets the button_ close button assessment content.
	 *
	 * @return the button_ close button assessment content
	 */
	public WebElement getButton_CloseButtonAssessmentContent() {
		return expWait.getWhenVisible(By.xpath("//div[@id='54_NB_App']//a[@class='closeActivity']"), 80);
	}

	/**
	 * Gets the button_ next.
	 *
	 * @return the button_ next
	 */
	public WebElement getButton_Next() {
		return expWait.getWhenVisible(By.xpath("//*[text()='Next']"), 30);
	}

	/**
	 * Gets the btn_start activity.
	 *
	 * @return the btn_start activity
	 */
	public WebElement getbtn_startActivity() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Start Activity')]"), 5);
	}

	/**
	 * Gets the btn_ print study.
	 *
	 * @return the btn_ print study
	 */
	public WebElement getbtn_PrintStudy() {
		return expWait.getWhenVisible(By.id("print-button"), 5);
	}
}
