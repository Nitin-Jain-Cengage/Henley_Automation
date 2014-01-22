/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation.BasicSmoke.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static com.cengage.mtx.automation.utils.YamlReader.getYamlValue;

import com.cengage.mtx.automation.TestSessionInitiator;

// TODO: Auto-generated Javadoc
/**
 * The Class Basic_Chemistry_SmokeTest.
 * 
 * @author QAIT
 */
public class Basic_Chemistry_SmokeTest {
	/** The test. */
	TestSessionInitiator test;

	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("src\\test\\resources\\testdata\\TestData.yml");
		test.launchApplication();
	}

	/**
	 * Tc001_login to the sso front door.
	 */
	@Test
	public void Tc001_loginToTheSSOFrontDoor() {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.student.chemistryusername"), getYamlValue("users.student.chemistrypassword"));
	}

	/**
	 * Tc002_perform operations on home page.
	 */
	@Test
	public void Tc002_performOperationsOnHomePage() {
		test.studHomePageActionsPg.verifyStudentHomePageContent();
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("Chemistry.BookName"), getYamlValue("testenv"));
	}

	/**
	 * Tc003_ actions on week widget view.
	 */
	@Test
	public void Tc003_ActionsOnWeekWidgetView() {
		test.weekWidgetActionsPg.verifyConceptMapButton();
	}

	/**
	 * Tc004_verify all apps button displays.
	 */
	@Test
	public void Tc004_verifyAllAppsButtonDisplays() {
		test.weekWidgetActionsPg.clickOnAllApps();
	}

	/**
	 * Tc005_click on apps and verify all open.
	 */
	@Test
	public void Tc005_clickOnAppsAndVerifyAllOpen() {
		test.weekWidgetActionsPg.clickOnMerriamWebsterApp();
	}

	/**
	 * Tc006_verify number of week equalswith weekavailablein week slider.
	 */
	@Test
	public void Tc006_verifyNumberOfWeekEqualswithWeekavailableinWeekSlider() {
		test.weekWidgetActionsPg.verifyTotalNoOfWeeks();
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("week.weeknumber"));
	}

	/**
	 * Tc007_ attempting tutored activity.
	 */
	@Test
	public void Tc007_AttemptingTutoredActivity() {
		// Tutored Activity
		test.diffActivitiesActionsPg.clickOnTutoredActivity(getYamlValue("activity.tutored"));
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	/**
	 * Tc008_start and submit tutored activity.
	 */
	@Test
	public void Tc008_startAndSubmitTutoredActivity() {
		test.startSubmitLogOutActionsPg.clickOnStartActivityForTutored();
		test.startSubmitLogOutActionsPg.clickOnSubmitLinkForTutored();
		test.startSubmitLogOutActionsPg.clickOnSubmitButton();
	}

	/**
	 * Tc009_verify statusdisplay as completed for tutored activity.
	 */
	@Test
	public void Tc009_verifyStatusdisplayAsCompletedForTutoredActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * Tc010_ open introductionand quick prep activity.
	 */
	@Test
	public void Tc010_OpenIntroductionandQuickPrepActivity() {
		// Introduction and Quick Prep Activity
		test.diffActivitiesActionsPg.clickOnIntroQuickPrep();
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	/**
	 * Tc011_verify start activiyand submit.
	 */
	@Test
	public void Tc011_verifyStartActiviyandSubmit() {
		test.startSubmitLogOutActionsPg.startSubmitActions();
	}

	/**
	 * Tc012_verify introductionand quick prep activity status as completed.
	 */
	@Test
	public void Tc012_verifyIntroductionandQuickPrepActivityStatusAsCompleted() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * Tc013_ attempting mastery activity.
	 */
	@Test
	public void Tc013_AttemptingMasteryActivity() {
		// Mastery Activity
		test.diffActivitiesActionsPg.clickOnMasteryActivity();
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	/**
	 * Tc014_start and submit mastery activity.
	 */
	@Test
	public void Tc014_startAndSubmitMasteryActivity() {
		test.startSubmitLogOutActionsPg.startSubmitMasterActions();
	}

	/**
	 * Tc015_verify statusdisplay as completed for mastery activity.
	 */
	@Test
	public void Tc015_verifyStatusdisplayAsCompletedForMasteryActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * Tc016_ attempting reviewand challenge activity.
	 */
	@Test
	public void Tc016_AttemptingReviewandChallengeActivity() {
		// Review and Challenge Activity
		test.diffActivitiesActionsPg.clickOnReviewAndChallenge();
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	/**
	 * Tc017_start and submit reviewand challenge activity.
	 */
	@Test
	public void Tc017_startAndSubmitReviewandChallengeActivity() {
		test.startSubmitLogOutActionsPg.startSubmitActions();
	}

	/**
	 * Tc018_verify statusdisplay as completed for reviewand challenge activity.
	 */
	@Test
	public void Tc018_verifyStatusdisplayAsCompletedForReviewandChallengeActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	/**
	 * Tc019_ attempting study guide.
	 */
	@Test
	public void Tc019_AttemptingStudyGuide() {
		// Study Guide
		test.diffActivitiesActionsPg.clickOnStudyGuide();
	}

	/**
	 * Tc020_start and submit study guide.
	 */
	@Test
	public void Tc020_startAndSubmitStudyGuide() {
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	/**
	 * Tc021_log out from application.
	 */
	@Test
	public void Tc021_logOutFromApplication() {
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
