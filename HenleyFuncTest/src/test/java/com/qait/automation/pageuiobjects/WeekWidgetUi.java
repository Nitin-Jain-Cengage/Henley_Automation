package com.qait.automation.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeekWidgetUi extends BasePage {
	public WeekWidgetUi(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//*[@class[contains(.,'dash-middle')]]")
	private WebElement currentVisibleWeek;
	@FindBy(xpath = ".//*[@class[contains(.,'dash-middle')]]/h2")
	public WebElement getCurrentVisibleWeekValue;
	@FindBy(xpath = "//div[@class='dockGroup']/li/a")
	public List<WebElement> appNameLink;
	@FindBy(id = "prevWeek")
	public WebElement previousWeekArrow;
	@FindBy(id = "nextWeek")
	public WebElement nextWeekArrow;
	@FindBy(xpath = ".//div[contains(@class,'week')]")
	public List<WebElement> totalNoOfWeeks;
	@FindBy(className = "sliderDivider")
	public List<WebElement> NoOfWeeksOnSlider;
	@FindBy(id = "conceptMapBtn")
	public WebElement btn_conceptMap;
	@FindBy(xpath = ".//*[@class[contains(.,'nb_actTitle')]]")
	public WebElement titleOfActivity;
	@FindBy(xpath = "//a[@id='app_toggle']")
	public WebElement btn_allApps;
	@FindBy(xpath = "//div[@class='dockGroup']/li/a/img")
	public List<WebElement> lbl_appName;

	public WebElement ConceptMap_Clickable() {
		return getWhenVisible(By.id("conceptMapBtn"), 90);
	}

	public void waitForSync() {
		expWait.waitForDomToLoad();
	}

	public WebElement titleOfActivity_Clickable() {
		return getWhenVisible(By.xpath(".//*[@class[contains(.,'nb_actTitle')]]"), 90);
	}

	public WebElement getPreocessingIndicator(String activityName) {
		return expWait.getWhenVisible(
				By.xpath("//div[contains(@class,'dash-middle')]//ul[contains(@class,'assignments ')]//label[contains(text(),'" + activityName
						+ "')]/parent::div/parent::li/i[@class='statusIcon completed']"), 80);
	}

	public WebElement get_appName() {
		return expWait.getWhenVisible(By.xpath("//div[@class='dockGroup']/li/a/img"), 80);
	}

	public WebElement get_appNameLink() {
		return expWait.getWhenVisible(By.xpath("//div[@class='dockGroup']/li/a"), 80);
	}

	public WebElement getHeadingNameOfTheApp(String appName) {
		return expWait.getWhenVisible(By.xpath("//h2[text()='" + appName + "']"), 80);
	}

	public WebElement getCollapse(String appName) {
		return expWait.getWhenVisible(By.xpath("//h2[text()='" + appName + "']/parent::div/div/a"), 80);
	}

	public WebElement getHeadingNameOfMerriamWebsterApp() {
		return expWait.getWhenVisible(By.xpath("//h2[contains(text(),'Merriam-Webster')]"), 80);
	}

	public WebElement getCollapseForMerriamWebsterApp() {
		return expWait.getWhenVisible(By.xpath("//h2[contains(text(),'Merriam-Webster')]/parent::div/div/a"), 80);
	}
}
