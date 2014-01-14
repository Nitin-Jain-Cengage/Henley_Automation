/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.automation.BasicSmoke.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static com.cengage.automation.utils.YamlReader.getYamlValue;

import com.cengage.automation.TestSessionInitiator;

/**
 * 
 * @author QAIT
 */
public class Basic_Chemistry_SmokeTest {
	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("src\\test\\resources\\testdata\\TestData.yml");
		test.launchApplication();
	}

	@Test
	public void loginToTheSSOFrontDoor() {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.student.chemistryusername"), getYamlValue("users.student.chemistrypassword"));
	}

	@Test(dependsOnMethods = "loginToTheSSOFrontDoor")
	public void performOperationsOnHomePage() {
		test.studHomePageActionsPg.verifyStudentHomePageContent();
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("Chemistry.BookName"), getYamlValue("testenv"));
	}

	@Test(dependsOnMethods = "performOperationsOnHomePage")
	public void ActionsOnWeekWidgetView() {
		test.weekWidgetActionsPg.verifyConceptMapButton();
	}

	@Test(dependsOnMethods = "ActionsOnWeekWidgetView")
	public void verifyAllAppsButtonDisplays() {
		test.weekWidgetActionsPg.clickOnAllApps();
	}

	@Test(dependsOnMethods = "verifyAllAppsButtonDisplays")
	public void clickOnAppsAndVerifyAllOpen() {
		test.weekWidgetActionsPg.clickOnMerriamWebsterApp();
	}

	@Test(dependsOnMethods = "clickOnAppsAndVerifyAllOpen")
	public void verifyNumberOfWeekEqualswithWeekavailableinWeekSlider() {
		test.weekWidgetActionsPg.verifyTotalNoOfWeeks();
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("week.weeknumber"));
	}

	@Test(dependsOnMethods = "verifyNumberOfWeekEqualswithWeekavailableinWeekSlider")
	public void AttemptingTutoredActivity() {
		// Tutored Activity
		test.diffActivitiesActionsPg.clickOnTutoredActivity(getYamlValue("activity.tutored"));
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	@Test(dependsOnMethods = "AttemptingTutoredActivity")
	public void startAndSubmitTutoredActivity() {
		test.startSubmitLogOutActionsPg.clickOnStartActivityForTutored();
		test.startSubmitLogOutActionsPg.clickOnSubmitLinkForTutored();
		test.startSubmitLogOutActionsPg.clickOnSubmitButton();
	}

	@Test(dependsOnMethods = "startAndSubmitTutoredActivity")
	public void verifyStatusdisplayAsCompletedForTutoredActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	@Test(dependsOnMethods = "verifyStatusdisplayAsCompletedForTutoredActivity")
	public void OpenIntroductionandQuickPrepActivity() {
		// Introduction and Quick Prep Activity
		test.diffActivitiesActionsPg.clickOnIntroQuickPrep();
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	@Test(dependsOnMethods = "OpenIntroductionandQuickPrepActivity")
	public void verifyStartActiviyandSubmit() {
		test.startSubmitLogOutActionsPg.startSubmitActions();
	}

	@Test(dependsOnMethods = "verifyStartActiviyandSubmit")
	public void verifyIntroductionandQuickPrepActivityStatusAsCompleted() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	@Test(dependsOnMethods = "verifyIntroductionandQuickPrepActivityStatusAsCompleted")
	public void AttemptingMasteryActivity() {
		// Mastery Activity
		test.diffActivitiesActionsPg.clickOnMasteryActivity();
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	@Test(dependsOnMethods = "AttemptingMasteryActivity")
	public void startAndSubmitMasteryActivity() {
		test.startSubmitLogOutActionsPg.startSubmitMasterActions();
	}

	@Test(dependsOnMethods = "startAndSubmitMasteryActivity")
	public void verifyStatusdisplayAsCompletedForMasteryActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	@Test(dependsOnMethods = "verifyStatusdisplayAsCompletedForMasteryActivity")
	public void AttemptingReviewandChallengeActivity() {
		// Review and Challenge Activity
		test.diffActivitiesActionsPg.clickOnReviewAndChallenge();
		test.diffActivitiesActionsPg.getTitleOfActivity();
	}

	@Test(dependsOnMethods = "AttemptingReviewandChallengeActivity")
	public void startAndSubmitReviewandChallengeActivity() {
		test.startSubmitLogOutActionsPg.startSubmitActions();
	}

	@Test(dependsOnMethods = "startAndSubmitReviewandChallengeActivity")
	public void verifyStatusdisplayAsCompletedForReviewandChallengeActivity() {
		test.weekWidgetActionsPg.verifyActivityStatusDisplayAsCompleted();
	}

	@Test(dependsOnMethods = "verifyStatusdisplayAsCompletedForReviewandChallengeActivity")
	public void AttemptingStudyGuide() {
		// Study Guide
		test.diffActivitiesActionsPg.clickOnStudyGuide();
	}

	@Test(dependsOnMethods = "AttemptingStudyGuide")
	public void startAndSubmitStudyGuide() {
		test.diffActivitiesActionsPg.getTitleOfActivity();
		test.startSubmitLogOutActionsPg.clickOnClose();
	}

	@Test(dependsOnMethods = "startAndSubmitStudyGuide")
	public void logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
	}

	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}