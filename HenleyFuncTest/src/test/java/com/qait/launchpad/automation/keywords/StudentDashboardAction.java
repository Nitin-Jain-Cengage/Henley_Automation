package com.qait.launchpad.automation.keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.launchpad.automation.pageuiobjects.StudentDashboardUi;

public class StudentDashboardAction extends LoginPageActions {
	WebDriver driver;
	StudentDashboardUi studentDashboard;
	static String winHandleBefore;

	public StudentDashboardAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		studentDashboard = new StudentDashboardUi(driver);
	}

	public void verifyLandingPageLoaded() {
		studentDashboard.getBtn_Open().isDisplayed();
	}

	public void clickOnOpenButton(String bookName) {
		studentDashboard.getBtn_OpenBook(bookName).click();
	}

	public void verifyStudentBoardDisplay() {
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		studentDashboard.getBtn_ConceptMap().isDisplayed();
	}

	public void navigateToWeek(String week) {
		studentDashboard.getWeekNavigation(week).click();
	}

	public void verifyApplicationNavigatedToWeek(String week) {
		studentDashboard.waitForSync();
		Assert.assertTrue(studentDashboard.getActiveWeek().getText().equalsIgnoreCase(week));
	}

	public void openActivity(String week) {
		studentDashboard.getWeekNavigation(week).click();
		studentDashboard.waitForSync();
		Assert.assertTrue(studentDashboard.getActiveWeek().getText().equalsIgnoreCase(week));
	}

	public void clickOnActivityLink(String activityName) {
		studentDashboard.waitForSync();
		studentDashboard.getActivityToPerform(activityName).click();
		studentDashboard.waitForSync();
	}

	public void verifyActivityPaneDisplay() {
		studentDashboard.getActivityHeading().isDisplayed();
		studentDashboard.waitForActivityFrame().isDisplayed();
		studentDashboard.switchToFrame("54_NB_Main_IFrame");
		studentDashboard.switchToFrame("easyXDM_activityService_cxp_Target_provider");
	}

	public void clickStartActivityButtonDisplay() {
		studentDashboard.getStartActivityButton().isDisplayed();
		studentDashboard.getStartActivityButton().click();
	}

	public void completedActivityAndSubmitActivity() {
		studentDashboard.getOverviewGradedOut().isDisplayed();
		studentDashboard.getLink_SubmitActivity().isDisplayed();
		studentDashboard.getLink_SubmitActivity().click();
		studentDashboard.getBtn_SubmitActivity().isDisplayed();
		studentDashboard.getBtn_SubmitActivity().click();
		studentDashboard.switchToDefaultContent();
	}

	public void verifyActivityStatusDisplayAsCompleted(String activityName) {
		Assert.assertTrue(studentDashboard.getPreocessingIndicator(activityName).isDisplayed());
		studentDashboard.waitForSync();
	}

	public void logoutfromApplicationAndVerifyLogoutMessage() {
		studentDashboard.logoutFromApplication();
		Assert.assertTrue(studentDashboard.getTxt_LogoutMessage().getText().equalsIgnoreCase("You have logged out or timed out of your course.") &&
				studentDashboard.getTxt_LogoutMessage().getText().equalsIgnoreCase("Restart your session to continue your work."));
	}
}
