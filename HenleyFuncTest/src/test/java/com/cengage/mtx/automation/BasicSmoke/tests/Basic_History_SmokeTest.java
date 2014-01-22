package com.cengage.mtx.automation.BasicSmoke.tests;

import static com.cengage.mtx.automation.utils.YamlReader.getYamlValue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cengage.mtx.automation.TestSessionInitiator;

// TODO: Auto-generated Javadoc
/**
 * The Class Basic_History_SmokeTest.
 */
public class Basic_History_SmokeTest {
	
	/**
	 * The test.
	 *
	 * @author QAIT
	 */
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
		test.studHomePageActionsPg.clickOnOpenButton(getYamlValue("History.BookName").trim(), getYamlValue("testenv"));

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
		test.weekWidgetActionsPg.navigateToWeek(getYamlValue("historyweek.weeknumber"));
	}

	// Infographic
	/**
	 * Tc007_open infographic activity.
	 */
	@Test
	public void Tc007_openInfographicActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.InfographicActivity"));
	}

	/**
	 * Tc008_verify infographic activity panel display.
	 */
	@Test
	public void Tc008_verifyInfographicActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	/**
	 * Tc009_start activity button infographic display and click.
	 */
	@Test
	public void Tc009_startActivityButtonInfographicDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	/**
	 * Tc010_attempt infographic activityand submit.
	 */
	@Test
	public void Tc010_attemptInfographicActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	/**
	 * Tc011_verify complete status for infographic activity.
	 */
	@Test
	public void Tc011_verifyCompleteStatusForInfographicActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Source Activity
	/**
	 * Tc012_open source activity activity.
	 */
	@Test
	public void Tc012_openSourceActivityActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SourceActivity"));
	}

	/**
	 * Tc013_verify source activity panel display.
	 */
	@Test
	public void Tc013_verifySourceActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	/**
	 * Tc014_start activity button source activity display and click.
	 */
	@Test
	public void Tc014_startActivityButtonSourceActivityDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	/**
	 * Tc015_attempt source activityand submit.
	 */
	@Test
	public void Tc015_attemptSourceActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	/**
	 * Tc016_verify complete status for source activity.
	 */
	@Test
	public void Tc016_verifyCompleteStatusForSourceActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Essay Activity
	/**
	 * Tc017_open essay activity.
	 */
	@Test
	public void Tc017_openEssayActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.EssayActivity"));
	}

	/**
	 * Tc018_verify essay activity panel display.
	 */
	@Test
	public void Tc018_verifyEssayActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	/**
	 * Tc019_start activity button essay activity display and click.
	 */
	@Test
	public void Tc019_startActivityButtonEssayActivityDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	/**
	 * Tc020_attempt essay activityand submit.
	 */
	@Test
	public void Tc020_attemptEssayActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	/**
	 * Tc021_verify complete status for essay activity.
	 */
	@Test
	public void Tc021_verifyCompleteStatusForEssayActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// Single And Multiple Source Activity
	/**
	 * Tc022_open single and multiple source activity.
	 */
	@Test
	public void Tc022_openSingleAndMultipleSourceActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.SingleAndMultipleSourceActivity"));
	}

	/**
	 * Tc023_verify single and multiple source activity panel display.
	 */
	@Test
	public void Tc023_verifySingleAndMultipleSourceActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	/**
	 * Tc024_start activity button single and multiple source activity display and click.
	 */
	@Test
	public void Tc024_startActivityButtonSingleAndMultipleSourceActivityDisplayAndClick() {
		test.historyCourseContent.verifyStartActivityButtonAndClick();
	}

	/**
	 * Tc025_attempt single and multiple source activityand submit.
	 */
	@Test
	public void Tc025_attemptSingleAndMultipleSourceActivityandSubmit() {
		test.historyCourseContent.verifyNextButtonDisplays();
		test.historyCourseContent.clickOnNextButtonAndSubmitActivity();
		test.historyCourseContent.verifySubmitActivityButtonDisplayAndClick();
		test.historyCourseContent.verifyUserNavigateToWeekWidget();
	}

	/**
	 * Tc026_verify complete status for single and multiple source activity.
	 */
	@Test
	public void Tc026_verifyCompleteStatusForSingleAndMultipleSourceActivity() {
		test.historyCourseContent.verifyCompletedStatus();
	}

	// study
	/**
	 * Tc027_open study activity.
	 */
	@Test
	public void Tc027_openStudyActivity() {
		test.historyCourseContent.verifyAndClickOnActivity(getYamlValue("historyactivity.StudyActivity"));
	}

	/**
	 * Tc028_verify study activity panel display.
	 */
	@Test
	public void Tc028_verifyStudyActivityPanelDisplay() {
		test.historyCourseContent.verifyActivityHeading();
		test.historyCourseContent.switchToActivityContentFrame();
	}

	/**
	 * Tc029_start study activity and close.
	 */
	@Test
	public void Tc029_startStudyActivityAndClose() {
		test.historyCourseContent.verifyPrintButtonDisplayInStudy();
		test.historyCourseContent.closeStudyActivity();
	}

	/**
	 * Tc030_log out from application.
	 */
	@Test
	public void Tc030_logOutFromApplication() {
		test.startSubmitLogOutActionsPg.logOutFromApp();
		test.startSubmitLogOutActionsPg.verifyLogOutMessage();
	}
	
	 /**
 	 * Takeresult.
 	 *
 	 * @param result the result
 	 */
 	@AfterMethod
	 public void takeresult(ITestResult  result){
		  test.takeScreenshotOfFailure(result);	  
	 }

	/**
	 * Tear down class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}
