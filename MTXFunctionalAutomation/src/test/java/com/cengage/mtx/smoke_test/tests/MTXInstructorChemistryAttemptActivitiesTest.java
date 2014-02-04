package com.cengage.mtx.smoke_test.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cengage.mtx.TestSessionInitiator;
import static com.cengage.mtx.utils.YamlReader.getYamlValue;

public class MTXInstructorChemistryAttemptActivitiesTest {

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
		test.instTakeDeletePg.selectProdIsbn(getYamlValue("DeleteTake.chemistry.isbn"));
		test.instTakeDeletePg.clickOnCourseName(getYamlValue("DeleteTake.chemistry.coursename"), getYamlValue("testenv"));
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
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("week.weeknumber"));
	}

	/**
	 * TC007_verify presence of submit link for tutored activity.
	 */
	@Test
	public void TC007_verifyInstructorTutoredActivity() {
		// Tutored Activity
		test.diffActivitiesActionsPg.clickOnTutoredActivity(getYamlValue("activity.tutored"));
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.verifySubmitLinkIsPresentForTutored();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * TC008_verify presence of submit link for intro and quick prep activity.
	 */
	@Test
	public void TC008_verifyInstructorOpenIntroQuickPrepActivity() {
		// introduction and quick prep activity
		test.diffActivitiesActionsPg.clickOnIntroQuickPrep();
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.verifySubmitLinkPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * TC009_verify presence of submit link for mastery activity.
	 */
	@Test
	public void TC009_verifyInstructorOpenMasteryActivity() {
		// Mastery Activity
		test.diffActivitiesActionsPg.clickOnMasteryActivity();
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.verifySubmitLinkPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * TC010_verify presence of submit link for review and challenge activity.
	 */
	@Test
	public void TC010_verifyInstructorOpenReviewandChallengeActivity() {
		// Review and Challenge Activity
		test.diffActivitiesActionsPg.clickOnReviewAndChallenge();
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.verifySubmitLinkPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * TC011_verify open and close for study guide.
	 */
	@Test
	public void TC011_verifyInstructorOpenStudyGuide() {
		// Study Guide
		test.diffActivitiesActionsPg.clickOnStudyGuide();
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.verifyKeyConceptsTextPresent();
		test.startSubmitLogOutActionsPg.clickOnClose();
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
