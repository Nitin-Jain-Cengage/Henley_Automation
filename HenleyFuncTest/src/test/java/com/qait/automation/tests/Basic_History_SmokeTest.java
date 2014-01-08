package com.qait.automation.tests;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;

public class Basic_History_SmokeTest {
	/**
	 * @author QAIT
	 */
	TestSessionInitiator test;
	String username = getYamlValue("users.student.chemistryusername");
	String password = getYamlValue("users.student.chemistrypassword");

	public Basic_History_SmokeTest() {
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
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("History.BookName").trim());
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
		test.weekWidgetActionsPg.getCurrentDispWeek(getYamlValue("historyweek.weeknumber"));
	}

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
	
	@AfterClass
	public void tearDownClass() throws Exception {
		 test.closeBrowserSession();
	}
	
}
