package com.cengage.automation.BasicSmoke.tests;

import static com.cengage.automation.utils.YamlReader.getYamlValue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cengage.automation.TestSessionInitiator;

public class Basic_History_SmokeTest {
	/**
	 * @author QAIT
	 */
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
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("History.BookName").trim(), getYamlValue("testenv"));

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
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("historyweek.weeknumber"));
	}

	// Infographic
	@Test(dependsOnMethods = "verifyNumberOfWeekEqualswithWeekavailableinWeekSlider")
	public void openInfographicActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.InfographicActivity"));
	}

	@Test(dependsOnMethods = "openInfographicActivity")
	public void verifyInfographicActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	@Test(dependsOnMethods = "verifyInfographicActivityPanelDisplay")
	public void startActivityButtonInfographicDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	@Test(dependsOnMethods = "startActivityButtonInfographicDisplayAndClick")
	public void attemptInfographicActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	@Test(dependsOnMethods = "attemptInfographicActivityandSubmit")
	public void verifyCompleteStatusForInfographicActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Source Activity
	@Test(dependsOnMethods = "verifyCompleteStatusForInfographicActivity")
	public void openSourceActivityActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SourceActivity"));
	}

	@Test(dependsOnMethods = "openSourceActivityActivity")
	public void verifySourceActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	@Test(dependsOnMethods = "verifySourceActivityPanelDisplay")
	public void startActivityButtonSourceActivityDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	@Test(dependsOnMethods = "startActivityButtonSourceActivityDisplayAndClick")
	public void attemptSourceActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	@Test(dependsOnMethods = "attemptSourceActivityandSubmit")
	public void verifyCompleteStatusForSourceActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Essay Activity
	@Test(dependsOnMethods = "verifyCompleteStatusForSourceActivity")
	public void openEssayActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.EssayActivity"));
	}

	@Test(dependsOnMethods = "openEssayActivity")
	public void verifyEssayActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	@Test(dependsOnMethods = "verifyEssayActivityPanelDisplay")
	public void startActivityButtonEssayActivityDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	@Test(dependsOnMethods = "startActivityButtonEssayActivityDisplayAndClick")
	public void attemptEssayActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	@Test(dependsOnMethods = "attemptEssayActivityandSubmit")
	public void verifyCompleteStatusForEssayActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Single And Multiple Source Activity
	@Test(dependsOnMethods = "verifyCompleteStatusForEssayActivity")
	public void openSingleAndMultipleSourceActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SingleAndMultipleSourceActivity"));
	}

	@Test(dependsOnMethods = "openSingleAndMultipleSourceActivity")
	public void verifySingleAndMultipleSourceActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	@Test(dependsOnMethods = "verifySingleAndMultipleSourceActivityPanelDisplay")
	public void startActivityButtonSingleAndMultipleSourceActivityDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	@Test(dependsOnMethods = "startActivityButtonSingleAndMultipleSourceActivityDisplayAndClick")
	public void attemptSingleAndMultipleSourceActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	@Test(dependsOnMethods = "attemptSingleAndMultipleSourceActivityandSubmit")
	public void verifyCompleteStatusForSingleAndMultipleSourceActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// study
	@Test(dependsOnMethods = "verifyCompleteStatusForSingleAndMultipleSourceActivity")
	public void openStudyActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.StudyActivity"));
	}

	@Test(dependsOnMethods = "openStudyActivity")
	public void verifyStudyActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	@Test(dependsOnMethods = "verifyStudyActivityPanelDisplay")
	public void startStudyActivityAndClose() {
		test.historyCourseContent.verifyPrintButtonDisplayInStudy();
		test.historyCourseContent.closeStudyActivity();
	}

	@Test(dependsOnMethods = "startStudyActivityAndClose")
	public void logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
		test.startSubmitLogOutActionsPg.verifyLogOutMessage();
	}

	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}
