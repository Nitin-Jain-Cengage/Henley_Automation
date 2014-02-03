package com.cengage.mtx.smoke_test.tests;

import static com.cengage.mtx.utils.YamlReader.getYamlValue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cengage.mtx.TestSessionInitiator;

/**
 * The Class MTXAutomationSmokeTestHistoryStudentWorkFlow.
 */
public class MTXAutomationSmokeTestHistoryStudentWorkFlow {

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
	 */
	@Test
	public void TC001_loginToTheSSOFrontDoor() {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.student.chemistryusername"), getYamlValue("users.student.chemistrypassword"));
	}

	/**
	 * TC002_verify user navigate to dashboard page and click on open button.
	 */
	@Test
	public void TC002_verifyUserNavigateToDashboardPageAndClickOnOpenButton() {
		test.studHomePageActionsPg.verifyStudentHomePageContent();
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("History.BookName").trim(), getYamlValue("testenv"));
	}

	/**
	 * TC003_verify user redirect to student dashboard and concept map button
	 * display.
	 */
	@Test
	public void TC003_verifyUserRedirectToStudentDashboardAndConceptMapButtonDisplay() {
		test.weekWidgetActionsPg.verifyConceptMapButton();
	}

	/**
	 * TC004_verify all apps button displays on student home page.
	 */
	@Test
	public void TC004_verifyAllAppsButtonDisplaysOnStudentHomePage() {
		test.weekWidgetActionsPg.clickOnAllApps();
	}

	/**
	 * TC005_verify student launch activities display on student home page.
	 */
	@Test
	public void TC005_verifyStudentLaunchActivitiesDisplayOnStudentHomePage() {
		test.weekWidgetActionsPg.clickOnMerriamWebsterApp();
	}

	/**
	 * TC006_verify number of week equalswith weekavailablein week slider.
	 */
	@Test
	public void TC006_verifyNumberOfWeekEqualswithWeekavailableinWeekSlider() {
		test.weekWidgetActionsPg.verifyTotalNoOfWeeks();
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("historyweek.weeknumber"));
	}

	// Infographic
	/**
	 * TC007_verify student attempt and submit infographic activity.
	 */
	@Test
	public void TC007_verifyStudentAttemptAndSubmitInfographicActivity() {
		try {
			test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.InfographicActivity"));
			test.historyCourseContent.verifyActivityHeading();
			test.historyCourseContent.switchToActivityContentFrame();
			test.historyCourseContent.verifyStartActivityButtonAndClick();
			test.historyCourseContent.verifyNextButtonDisplays();
			test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
			test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
			test.historyCourseContent.verifyUserNavigateToWeekWidget();
		} catch (Exception e) {
			System.out.println("Fail to perform Infographic Activity");
			e.printStackTrace();
		}
	}

	/**
	 * TC008_verify status display as completed for infographic activity.
	 */
	@Test
	public void TC008_verifyStatusDisplayAsCompletedForInfographicActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Source Activity
	/**
	 * TC009_verify student attemptopen source activity.
	 */
	@Test
	public void TC009_verifyStudentAttemptopenSourceActivity() {
		try {
			test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SourceActivity"));
			test.historyCourseContent.verifyActivityHeading();
			test.historyCourseContent.switchToActivityContentFrame();
			test.historyCourseContent.verifyStartActivityButtonAndClick();
			test.historyCourseContent.verifyNextButtonDisplays();
			test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
			test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
			test.historyCourseContent.verifyUserNavigateToWeekWidget();
		} catch (Exception e) {
			System.out.println("Fail to perform Source Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC010_verify status display as completed for source activity.
	 */
	@Test
	public void TC010_verifyStatusDisplayAsCompletedForSourceActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Essay Activity
	/**
	 * TC011_verify student attempt essay activity.
	 */
	@Test
	public void TC011_verifyStudentAttemptEssayActivity() {
		try {
			test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.EssayActivity"));
			test.historyCourseContent.verifyActivityHeading();
			test.historyCourseContent.switchToActivityContentFrame();
			test.historyCourseContent.verifyStartActivityButtonAndClick();
			test.historyCourseContent.verifyNextButtonDisplays();
			test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
			test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
			test.historyCourseContent.verifyUserNavigateToWeekWidget();
		} catch (Exception e) {
			System.out.println("Fail to perform Essay Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC012_verify status display as completed for essay activity.
	 */
	@Test
	public void TC012_verifyStatusDisplayAsCompletedForEssayActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Single And Multiple Source Activity
	/**
	 * TC013_verify student attempt single and multiple source activity.
	 */
	@Test
	public void TC013_verifyStudentAttemptSingleAndMultipleSourceActivity() {
		try {
			test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SingleAndMultipleSourceActivity"));
			test.historyCourseContent.verifyActivityHeading();
			test.historyCourseContent.switchToActivityContentFrame();
			test.historyCourseContent.verifyStartActivityButtonAndClick();
			test.historyCourseContent.verifyNextButtonDisplays();
			test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
			test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
			test.historyCourseContent.verifyUserNavigateToWeekWidget();
		} catch (Exception e) {
			System.out.println("Fail to perform Multiple Source Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC014_verify status display as completed for single and multiple source
	 * activity.
	 */
	@Test
	public void TC014_verifyStatusDisplayAsCompletedForSingleAndMultipleSourceActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// study
	/**
	 * TC015_verify student attempt study activity.
	 */
	@Test
	public void TC015_verifyStudentAttemptStudyActivity() {
		try {
			test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.StudyActivity"));
			test.historyCourseContent.verifyActivityHeading();
			test.historyCourseContent.switchToActivityContentFrame();
			test.historyCourseContent.verifyPrintButtonDisplayInStudy();
			test.historyCourseContent.closeStudyActivity();
		} catch (Exception e) {
			System.out.println("Fail to perform Multiple Study Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC016_log out from application.
	 */
	@Test
	public void TC016_logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
		test.startSubmitLogOutActionsPg.verifyLogOutMessage();
	}

	/**
	 * Takeresult.
	 * 
	 * @param result
	 *            the result
	 */
	@AfterMethod
	public void takeresult(ITestResult result) {
		test.takeScreenshotOfFailure(result);
		if (!result.isSuccess()) {
			try {
				test.historyCourseContent.closeStudyActivity();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
