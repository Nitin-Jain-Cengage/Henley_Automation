package com.qait.launchpad.automation.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentDashboardUi extends BasePage {
	public StudentDashboardUi(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(@class,'aplia_button')]")
	public WebElement btn_Open;
	@FindBy(id = "nextWeek")
	public WebElement btn_nextWeek;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement link_SubmitActivity;
	@FindBy(xpath = "//div[text()='Submit Activity for Grading']")
	public WebElement btn_SubmitActivity;
	@FindBy(id = "logout")
	public WebElement txt_LogoutMessage;

	public WebElement getTxt_LogoutMessage() {
		return txt_LogoutMessage;
	}

	public WebElement getBtn_SubmitActivity() {
		return expWait.getWhenVisible(By.xpath("//div[text()='Submit Activity for Grading']"), 80);
	}

	public WebElement getLink_SubmitActivity() {
		return link_SubmitActivity;
	}

	public WebElement getBtn_nextWeek() {
		return btn_nextWeek;
	}

	public WebElement getBtn_Open() {
		return expWait.getWhenVisible(By.xpath("//div[@class='dashboard_row']//span[contains(text(),.) and @class='hide']/parent::a"), 80);
	}

	public WebElement getBtn_OpenBook(String bookName) {
		System.out.println("//div[@class='dashboard_row']//span[contains(text(),\"" + bookName + "\") and @class='hide']/parent::a");
		return expWait.getWhenVisible(By.xpath("//div[@class='dashboard_row']//span[text()=\"" + bookName + "\" and @class='hide']/parent::a"), 80);
	}

	public WebElement getBtn_ConceptMap() {
		return expWait.getWhenVisible(By.id("conceptMapBtn"), 80);
	}

	public WebElement getWeekNavigation(String week) {
		List<WebElement> listWeek = driver.findElements(By.xpath("//div[@id='weekSlider']/div"));
		String[] weeknav = week.toLowerCase().split("week");
		int weekNo = Integer.parseInt(weeknav[1].trim());
		if (weekNo > listWeek.size()) {
			System.out.println("Entered week is not present on Dashboard");
		} else {
			return listWeek.get(weekNo - 1);
		}
		return null;
	}

	public WebElement getActiveWeek() {
		return driver.findElement(By.xpath("//div[contains(@class,'dash-middle')]/h2"));
	}

	public WebElement getPreocessingIndicator(String activityName) {
		return expWait.getWhenVisible(
				By.xpath("//div[contains(@class,'dash-middle')]//ul[contains(@class,'assignments ')]//label[contains(text(),'" + activityName
						+ "')]/parent::div/parent::li/i[@class='statusIcon completed']"), 80);
	}

	public WebElement getActivityToPerform(String str) {
		List<WebElement> templst = driver.findElements(By.xpath("//div[contains(@class,'dash-middle')]//ul[contains(@class,'assignments ')]/li"));
		for (WebElement ele : templst) {
			if (ele.getText().equalsIgnoreCase(str)) {
				return ele;
			}
		}
		return null;
	}

	public void waitForSync() {
		expWait.waitForDomToLoad();
	}

	public WebElement getStartActivityButton() {
		return expWait.getWhenVisible(By.xpath("//div[@class='button' and contains(text(),'Start Activity')]"), 80);
	}

	public WebElement getOverviewGradedOut() {
		return expWait.getWhenVisible(By.xpath("//ul[@id='nav-grouped-items']/li[@class='group' and text()='Overview']"), 80);
	}

	public WebElement getActivityHeading() {
		return expWait.getWhenVisible(By.xpath("//div[@class='nb_titles']"), 80);
	}

	public void switchToFrame(String fID) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(fID));
	}

	public WebElement waitForActivityFrame() {
		return expWait.getWhenVisible(By.xpath("//div[@id='appFrames']//iframe"), 80);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void logoutFromApplication() {
		expWait.executeJs("document.getElementById('logout_link').click();");
	}
}
