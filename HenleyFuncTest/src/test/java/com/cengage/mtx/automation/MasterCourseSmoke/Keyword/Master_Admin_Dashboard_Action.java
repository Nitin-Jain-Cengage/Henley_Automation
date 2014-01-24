package com.cengage.mtx.automation.MasterCourseSmoke.Keyword;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.cengage.mtx.automation.MasterCourseSmoke.pageuiobjects.*;

/**
 * The Class Master_Admin_Dashboard_Action.
 */
public class Master_Admin_Dashboard_Action {
	
	/** The admin dashboard. */
	Master_Admin_Dashboard_Ui adminDashboard;

	/**
	 * Instantiates a new master_ admin_ dashboard_ action.
	 *
	 * @param driver the driver
	 */
	public Master_Admin_Dashboard_Action(WebDriver driver) {
		adminDashboard = new Master_Admin_Dashboard_Ui(driver);
	}

	/**
	 * Verify user navigate to dashboard page.
	 */
	public void verifyUserNavigateToDashboardPage() {
		adminDashboard.getinput_SearchTextBoxAdminDashboard().isDisplayed();
	}

	/**
	 * Enter search term.
	 *
	 * @param bookName the book name
	 */
	public void enterSearchTerm(String bookName) {
		adminDashboard.getinput_SearchTextBoxAdminDashboard().click();
		adminDashboard.getinput_SearchTextBoxAdminDashboard().clear();
		adminDashboard.getinput_SearchTextBoxAdminDashboard().sendKeys(bookName);
	}

	/**
	 * Click on isbn book after search.
	 *
	 * @param isbnNumber the isbn number
	 */
	public void clickOnISBNBookAfterSearch(String isbnNumber) {
		adminDashboard.getlink_isbnBook(isbnNumber).isDisplayed();
		adminDashboard.getlink_isbnBook(isbnNumber).click();
	}

	/**
	 * Verify book content loaded.
	 */
	public void verifyBookContentLoaded() {
		adminDashboard.gettxt_ConeptMap().isDisplayed();
	}

	/**
	 * Verify launch all activity.
	 */
	public void verifyLaunchAllActivity() {
		List<WebElement> UnitList = adminDashboard.getLink_AllUnitName();
		for (int i = 1; i < UnitList.size(); i++) {
			List<WebElement> Unit = adminDashboard.getLink_AllUnitName();
			System.out.println(Unit.get(i).getText());
			Reporter.log("");
			Reporter.log("******************** Unit Name: "+Unit.get(i).getText()+" ********************");
			Unit.get(i).click();
			adminDashboard.get_CourseViewTitleContainer().isDisplayed();
			adminDashboard.waitForSyncPage();
			adminDashboard.getImg_Assessment().isDisplayed();
			adminDashboard.waitForSyncPage();
			List<WebElement> AssessmentList = adminDashboard.getLink_AllAssessmentName();
			System.out.println("Assessment: " + AssessmentList.size());
			String activityNameFromList;
			String activityHeading;
			for (int m = 0; m < AssessmentList.size(); m++) {
				adminDashboard.getImg_Assessment().isDisplayed();
				List<WebElement> Assessment = adminDashboard.getLink_AllAssessmentName();
				activityNameFromList = Assessment.get(m).getText();
				Assessment.get(m).click();

				adminDashboard.waitForSyncPage();
				adminDashboard.getHeading_AssessmentContent().isDisplayed();
				activityHeading = adminDashboard.getHeading_AssessmentContent().getText();
				Reporter.log("----------------------- Assessment Name: "+activityHeading+" -----------------------");

				System.out.println(activityNameFromList);
				System.out.println(activityHeading);
				Assert.assertTrue(activityNameFromList.contains(activityHeading));
				adminDashboard.getButton_CloseButtonAssessmentContent().isDisplayed();
				adminDashboard.switchToDefaultContent();
				adminDashboard.switchToFrame("54_NB_Main_IFrame");
				adminDashboard.switchToFrame("easyXDM_activityService_cxp_Target_provider");
				try {
					adminDashboard.getButton_Next().isDisplayed();
					Reporter.log(" Next Button display");
				} catch (Exception e) {
					try {
						adminDashboard.getbtn_startActivity().isDisplayed();
						Reporter.log("Start Activity display");
					} catch (Exception er) {
						adminDashboard.getbtn_PrintStudy().isDisplayed();
						Reporter.log(" Print button display");
					}
				}
				adminDashboard.switchToDefaultContent();
				adminDashboard.getButton_CloseButtonAssessmentContent().click();
				adminDashboard.waitForSyncPage();
				adminDashboard.getLink_HomeLauncher().click();
				adminDashboard.waitForSyncPage();
				adminDashboard.getImg_Assessment().isDisplayed();
				adminDashboard.get_CourseViewTitleContainer().isDisplayed();
				Assessment.clear();
			}
			AssessmentList.clear();
			adminDashboard.getbtn_Back().click();
			adminDashboard.waitForSyncPage();
			adminDashboard.gettxt_ConeptMap().isDisplayed();
			Unit.clear();
		}
	}
}
