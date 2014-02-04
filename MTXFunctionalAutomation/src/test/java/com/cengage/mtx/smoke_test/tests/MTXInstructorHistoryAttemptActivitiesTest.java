package com.cengage.mtx.smoke_test.tests;

import static com.cengage.mtx.utils.YamlReader.getYamlValue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cengage.mtx.TestSessionInitiator;

public class MTXInstructorHistoryAttemptActivitiesTest {

	/** The test. */
	TestSessionInitiator test;

	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator(System.getProperty("datafile", "MTX_smoke_qaf_testData.yml"));
		test.launchApplication();
	}

	/**
	 * TC001_login to the sso front door.
	 * 
	 * @param myName
	 *            the my name
	 */
	@Test
	public void TC001_loginToTheSSOFrontDoor() {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.instructor.username"), getYamlValue("users.instructor.password"));
	}

	/**
	 * TC002_perform operations on home page.
	 */
	@Test
	public void TC002_performOperationsOnHomePage() {
		test.instTakeDeletePg.selectProdIsbn(getYamlValue("DeleteTake.history.isbn"));
		test.instTakeDeletePg.clickOnCourseName(getYamlValue("DeleteTake.history.coursename"), getYamlValue("testenv"));
	}

	@Test
	public void TC003_verifyUserRedirectToInstructorDashboardAndConceptMapButtonDisplay() {
		test.weekWidgetActionsPg.verifyConceptMapButton();
	}

	/**
	 * TC004_verify all apps button displays on instructor home page.
	 */
	@Test
	public void TC004_verifyAllAppsButtonDisplaysOnInstructorHomePage() {
		test.weekWidgetActionsPg.clickOnAllApps();
	}

	/**
	 * TC005_verify student launch activities display on instructor home page.
	 */
	@Test
	public void TC005_verifyStudentLaunchActivitiesDisplayOnInstructorHomePage() {
		test.weekWidgetActionsPg.clickOnMerriamWebsterApp();
	}

	/**
	 * TC006_verify number of week equals with week available in week slider.
	 */
	@Test
	public void TC006_verifyNumberOfWeekEqualswithWeekavailableinWeekSlider() {
		test.weekWidgetActionsPg.verifyTotalNoOfWeeks();
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("historyweek.weeknumber"));
	}

	// Infographic Activity
	/**
	 * TC007_verify presence of start activity button or next button for
	 * infographic activity.
	 */
	@Test
	public void TC007_verifyInstructorInfographicActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.InfographicActivity"));
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.verifyStartActivityOrNextIsPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	// Source Activity
	/**
	 * TC008_verify presence of start activity button or next button for
	 * infographic activity.
	 */
	@Test
	public void TC008_verifyInstructorOpenSourceActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SourceActivity"));
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.verifyStartActivityOrNextIsPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	// Essay Activity
	/**
	 * TC009_verify instructor essay activity.
	 */
	@Test
	public void TC009_verifyInstructorEssayActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.EssayActivity"));
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.verifyStartActivityOrNextIsPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	// Single And Multiple Source Activity
	/**
	 * TC010_verify instructor single and multiple source activity.
	 */
	@Test
	public void TC010_verifyInstructorSingleAndMultipleSourceActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SingleAndMultipleSourceActivity"));
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.verifyStartActivityOrNextIsPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * TC011_verify student open study guide.
	 */
	@Test
	public void TC011_verifyInstructorOpenStudyGuide() {
		// Study Guide
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.StudyActivity"));
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
		test.historyCourseContent.verifyPrintButtonDisplayInStudy();
		test.historyCourseContent.closeStudyActivity();
	}

	/**
	 * TC012_log out from application.
	 */
	@Test
	public void TC012_logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
	}

	@AfterMethod
	public void captureScreenShotOnFailure(ITestResult result) {
		test.takeScreenshotOfFailure(result);
	}

	/**
	 * Tear down class.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}
