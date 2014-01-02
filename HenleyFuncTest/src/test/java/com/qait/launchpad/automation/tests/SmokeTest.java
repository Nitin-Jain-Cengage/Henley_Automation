/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.launchpad.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static com.qait.automation.utils.YamlReader.getYamlValue;

import com.qait.automation.TestSessionInitiator;

/**
 * 
 * @author shwetabansal
 */
public class SmokeTest {

	TestSessionInitiator test;
	String username = getYamlValue("users.student.username");
	String password = getYamlValue("users.student.password");

	public SmokeTest() {
		test = new TestSessionInitiator();
	}

	@BeforeClass
	public void setUpClass() {
		test.launchApplication();
	}

	@Test
	public void loginToTheSSOFrontDoor() {
		test.loginActionsPg.loginToTheApplication(username, password);
	}

	@Test(dependsOnMethods = "loginToTheSSOFrontDoor")
	public void performOperationsOnHomePage() {
		test.studHomePageActionsPg.verifyStudentHomePageContent();
		test.studHomePageActionsPg.clickOnOpenButton();
	}

	@Test(dependsOnMethods = "performOperationsOnHomePage")
	public void ActionsOnWeekWidgetView() {
		test.weekWidgetActionsPg.switchToNewWindow();
		test.weekWidgetActionsPg.verifyTotalNoOfWeeks();
		test.weekWidgetActionsPg.getCurrentDispWeek();

	}

	@Test(dependsOnMethods = "ActionsOnWeekWidgetView")
	public void AttemptingDifferentActivities() {
		// Introduction and Quick Prep Activity
		test.diffActivitiesActionsPg.clickOnIntroQuickPrep();
		test.diffActivitiesActionsPg.ToGetActivityHeadingandverifyActivityStatusDisplay();
		test.startSubmitLogOutActionsPg.startSubmitActions();
		//Mastery Activity
		test.diffActivitiesActionsPg.clickOnMasteryActivity();
		test.diffActivitiesActionsPg.ToGetActivityHeadingandverifyActivityStatusDisplay();
		test.startSubmitLogOutActionsPg.startSubmitActions();
		
		//Review and Challenge Activity
		test.diffActivitiesActionsPg.clickOnReviewAndChallenge();
		test.diffActivitiesActionsPg.ToGetActivityHeadingandverifyActivityStatusDisplay();
		test.startSubmitLogOutActionsPg.startSubmitActions();
		
		// Study Guide
		test.diffActivitiesActionsPg.clickOnStudyGuide();
		test.diffActivitiesActionsPg.ToGetActivityHeadingandverifyActivityStatusDisplay();
		test.startSubmitLogOutActionsPg.clickOnClose();
		// Tutored Activity
		test.diffActivitiesActionsPg.clickOnTutoredActivity();
		test.diffActivitiesActionsPg.ToGetActivityHeadingandverifyActivityStatusDisplay();
		test.startSubmitLogOutActionsPg.clickOnStartActivityForTutored();
		test.startSubmitLogOutActionsPg.clickOnSubmitLink();
		test.startSubmitLogOutActionsPg.clickOnSubmitButton();
		
	}

	@Test(dependsOnMethods = "AttemptingDifferentActivities")
	public void logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
	}

	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}