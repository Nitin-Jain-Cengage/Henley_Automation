/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.smoke_test.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static com.cengage.mtx.utils.YamlReader.getYamlValue;

import com.cengage.mtx.TestSessionInitiator;

/**
 * The Class MTXAutomationSmokeTestChemistryStudentWorkFlow.
 */
public class MTXAutomationSmokeTestChemistryStudentWorkFlow {

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
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("Chemistry.BookName"), getYamlValue("testenv"));
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
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("week.weeknumber"));
	}

	/**
	 * TC007_verify student attempt and submit conceptual tutored activity.
	 */
	@Test
	public void TC007_verifyStudentAttemptAndSubmitConceptualTutoredActivity() {
		// Tutored Activity
		try {
			test.diffActivitiesActionsPg.clickOnTutoredActivity(getYamlValue("activity.tutored"));
			test.diffActivitiesActionsPg.getTitleOfActivity();
			test.startSubmitLogOutActionsPg.clickOnStartActivityForTutored();
			test.startSubmitLogOutActionsPg.clickOnSubmitLinkForTutored();
			test.startSubmitLogOutActionsPg.clickOnSubmitButton();
		} catch (Exception e) {
			System.out.println("Fail to perform Conceptual Tutored Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC008_verify statusdisplay as completed for conceptual tutored activity.
	 */
	@Test
	public void TC008_verifyStatusdisplayAsCompletedForConceptualTutoredActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * TC009_verify student attempt and submit introductionand quick prep
	 * activity.
	 */
	@Test
	public void TC009_verifyStudentAttemptAndSubmitIntroductionandQuickPrepActivity() {
		// Introduction and Quick Prep Activity
		try {
			test.diffActivitiesActionsPg.clickOnIntroQuickPrep();
			test.diffActivitiesActionsPg.getTitleOfActivity();
			test.startSubmitLogOutActionsPg.startSubmitActions();
		} catch (Exception e) {
			System.out.println("Fail to perform Introduction and Quick Prep Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC010_verify introductionand quick prep activity status as completed.
	 */
	@Test
	public void TC010_verifyIntroductionandQuickPrepActivityStatusAsCompleted() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * TC011_verify student attempt and submit mastery activity.
	 */
	@Test
	public void TC011_verifyStudentAttemptAndSubmitMasteryActivity() {
		// Mastery Activity
		try {
			test.diffActivitiesActionsPg.clickOnMasteryActivity();
			test.diffActivitiesActionsPg.getTitleOfActivity();
			test.startSubmitLogOutActionsPg.startSubmitMasterActions();
		} catch (Exception e) {
			System.out.println("Fail to perform Mastery Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC012_verify statusdisplay as completed for mastery activity.
	 */
	@Test
	public void TC012_verifyStatusdisplayAsCompletedForMasteryActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * TC013_verify student attempt and submit reviewand challenge activity.
	 */
	@Test
	public void TC013_verifyStudentAttemptAndSubmitReviewandChallengeActivity() {
		// Review and Challenge Activity
		try {
			test.diffActivitiesActionsPg.clickOnReviewAndChallenge();
			test.diffActivitiesActionsPg.getTitleOfActivity();
			test.startSubmitLogOutActionsPg.startSubmitActions();
		} catch (Exception e) {
			System.out.println("Fail to perform Review and Challenge Activity ");
			e.printStackTrace();
		}
	}

	/**
	 * TC014_verify statusdisplay as completed for reviewand challenge activity.
	 */
	@Test
	public void TC014_verifyStatusdisplayAsCompletedForReviewandChallengeActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * TC015_verify student open study guide.
	 */
	@Test
	public void TC015_verifyStudentOpenStudyGuide() {
		// Study Guide
		test.diffActivitiesActionsPg.clickOnStudyGuide();
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * TC016_log out from application.
	 */
	@Test
	public void TC016_logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
	}

	/**
	 * Capture screen shot on failure.
	 * 
	 * @param result
	 *            the result
	 */
	@AfterMethod
	public void captureScreenShotOnFailure(ITestResult result) {
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
