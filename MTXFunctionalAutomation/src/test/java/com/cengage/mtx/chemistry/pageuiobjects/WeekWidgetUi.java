package com.cengage.mtx.chemistry.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class WeekWidgetUi.
 */
public class WeekWidgetUi extends BasePage {

	/**
	 * Instantiates a new week widget ui.
	 *
	 * @param driver the driver
	 */
	public WeekWidgetUi(WebDriver driver) {
		super(driver);
	}

	/** The current visible week. */
	@FindBy(xpath = ".//*[@class[contains(.,'dash-middle')]]")
	private WebElement currentVisibleWeek;
	
	/** The get current visible week value. */
	@FindBy(xpath = ".//*[@class[contains(.,'dash-middle')]]/h2")
	public WebElement getCurrentVisibleWeekValue;
	
	/** The app name link. */
	@FindBy(xpath = "//div[@class='dockGroup']/li/a")
	public List<WebElement> appNameLink;
	
	/** The previous week arrow. */
	@FindBy(id = "prevWeek")
	public WebElement previousWeekArrow;
	
	/** The next week arrow. */
	@FindBy(id = "nextWeek")
	public WebElement nextWeekArrow;
	
	/** The total no of weeks. */
	@FindBy(xpath = ".//div[contains(@class,'week')]")
	public List<WebElement> totalNoOfWeeks;
	
	/** The No of weeks on slider. */
	@FindBy(className = "sliderDivider")
	public List<WebElement> NoOfWeeksOnSlider;
	
	/** The title of activity. */
	@FindBy(xpath = ".//*[@class[contains(.,'nb_actTitle')]]")
	public WebElement titleOfActivity;
	
	/** The lbl_app name. */
	@FindBy(xpath = "//div[@class='dockGroup']/li/a/img")
	public List<WebElement> lbl_appName;

	/**
	 * Concept map_ clickable.
	 *
	 * @return the web element
	 */
	public WebElement ConceptMap_Clickable() {
		return getWhenVisible(By.id("conceptMapBtn"), 90);
	}

	/**
	 * Gets the link_ all score.
	 *
	 * @return the link_ all score
	 */
	public WebElement getLink_AllScore() {
		return getWhenVisible(By.id("performanceBtn"), 90);
	}

	/**
	 * Check week slider spinner to disappear.
	 */


	/**
	 * Wait for sync.
	 */
	public void waitForSync() {
		expWait.waitForDomToLoad();
	}

	/**
	 * Btn_all apps.
	 *
	 * @return the web element
	 */
	public WebElement btn_allApps() {
		return expWait.getWhenVisible(By.id("app_toggle"), 90);
	}

	/**
	 * Js_block all app view.
	 */
	public void js_blockAllAppView() {
		driver.findElement(By.id("nb_dock")).isDisplayed();
		String str = driver.findElement(By.id("nb_dock")).getAttribute("style");
		str = str.replaceAll("none", "block");
		System.out
				.println("document.getElementById('nb_dock').setAttribute(\"style\","
						+ str + ");");
		executeJs("document.getElementById('nb_dock').setAttribute(\"style\","
				+ str + ");");
	}

	/**
	 * Accept button on student content.
	 *
	 * @return the web element
	 */
	public WebElement acceptButtonOnStudentContent() {
		return expWait.getWhenVisible(
				By.xpath("//a[contains(text(),'Accept')]"), 30);
	}

	/**
	 * Btn_ enter on course content.
	 *
	 * @return the web element
	 */
	public WebElement btn_EnterOnCourseContent() {
		return expWait.getWhenVisible(By.xpath("//input[@value='Enter']"), 20);
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
	 * Title of activity_ clickable.
	 *
	 * @return the web element
	 */
	public WebElement titleOfActivity_Clickable() {
		return getWhenVisible(
				By.xpath(".//*[@class[contains(.,'nb_actTitle')]]"), 90);
	}

	/**
	 * Gets the preocessing indicator.
	 *
	 * @param activityName the activity name
	 * @return the preocessing indicator
	 */
	public WebElement getPreocessingIndicator(String activityName) {
		return expWait
				.getWhenVisible(
						By.xpath("//div[contains(@class,'dash-middle')]//ul[contains(@class,'assignments ')]//label[contains(text(),'"
								+ activityName
								+ "')]/parent::div/parent::li/i[@class='statusIcon completed']"),
						80);
	}

	/**
	 * Gets the _app name.
	 *
	 * @return the _app name
	 */
	public WebElement get_appName() {
		return expWait.getWhenVisible(
				By.xpath("//div[@class='dockGroup']/li/a/img"), 80);
	}

	/**
	 * Gets the _app name link.
	 *
	 * @return the _app name link
	 */
	public WebElement get_appNameLink() {
		return expWait.getWhenVisible(
				By.xpath("//div[@class='dockGroup']/li/a"), 80);
	}

	/**
	 * Gets the heading name of the app.
	 *
	 * @param appName the app name
	 * @return the heading name of the app
	 */
	public WebElement getHeadingNameOfTheApp(String appName) {
		return expWait.getWhenVisible(
				By.xpath("//h2[text()='" + appName + "']"), 80);
	}

	/**
	 * Gets the collapse.
	 *
	 * @param appName the app name
	 * @return the collapse
	 */
	public WebElement getCollapse(String appName) {
		return expWait.getWhenVisible(
				By.xpath("//h2[text()='" + appName + "']/parent::div/div/a"),
				80);
	}

	/**
	 * Gets the heading name of merriam webster app.
	 *
	 * @return the heading name of merriam webster app
	 */
	public WebElement getHeadingNameOfMerriamWebsterApp() {
		return expWait.getWhenVisible(
				By.xpath("//h2[contains(text(),'Merriam-Webster')]"), 80);
	}

	/**
	 * Gets the collapse for merriam webster app.
	 *
	 * @return the collapse for merriam webster app
	 */
	public WebElement getCollapseForMerriamWebsterApp() {
		return expWait
				.getWhenVisible(
						By.xpath("//h2[contains(text(),'Merriam-Webster')]/parent::div/div/a"),
						80);
	}
}
