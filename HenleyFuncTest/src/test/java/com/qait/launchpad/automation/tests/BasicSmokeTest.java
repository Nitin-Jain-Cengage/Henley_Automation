/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.launchpad.automation.tests;

import com.qait.automation.TestSessionInitiator;
import static com.qait.automation.utils.YamlReader.getYamlValue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author shwetabansal
 */
public class BasicSmokeTest {
	TestSessionInitiator test;
	String username = getYamlValue("users.student.username");
	String password = getYamlValue("users.student.password");

	public BasicSmokeTest() {
		test = new TestSessionInitiator();
	}

	@BeforeClass
	public void setUpClass() {
		test.launchApplication();
	}

	@Test
	public void loginToTheSSOFrontDoor() {
		test.pageAction.loginToTheApplication(username, password);
	}

	@Test(dependsOnMethods = "loginToTheSSOFrontDoor")
	public void verifyLandingPage() {
		test.pageAction.verifyLandingPageLoaded();
	}

	@Test(dependsOnMethods = "verifyLandingPage")
	public void clickOnOpenBookButtonAsBookName() {
		test.pageAction.clickOnOpenButton(getYamlValue("users.bookname"));
	}

	@Test(dependsOnMethods = "clickOnOpenBookButtonAsBookName")
	public void verifyStudentBoardDisplay() {
		test.pageAction.verifyStudentBoardDisplay();
	}

	@Test(dependsOnMethods = "verifyStudentBoardDisplay")
	public void navigateToWeek() {
		test.pageAction.navigateToWeek(getYamlValue("users.weekNumber"));
	}

	@Test(dependsOnMethods = "navigateToWeek")
	public void verifyApplicationNavigatedToWeek() {
		test.pageAction.verifyApplicationNavigatedToWeek(getYamlValue("users.weekNumber"));
	}

	@Test(dependsOnMethods = "verifyApplicationNavigatedToWeek")
	public void openActivity() {
		test.pageAction.openActivity(getYamlValue("submittest.testweek"));
	}

	@Test(dependsOnMethods = "openActivity")
	public void clickOnActivityLink() {
		test.pageAction.clickOnActivityLink(getYamlValue("submittest.testName"));
	}

	@Test(dependsOnMethods = "clickOnActivityLink")
	public void verifyActivityPaneDisplay() {
		test.pageAction.verifyActivityPaneDisplay();
	}

	@Test(dependsOnMethods = "verifyActivityPaneDisplay")
	public void clickStartActivityButtonDisplay() {
		test.pageAction.clickStartActivityButtonDisplay();
	}

	@Test(dependsOnMethods = "clickStartActivityButtonDisplay")
	public void completedActivityAndSubmitActivity() {
		test.pageAction.completedActivityAndSubmitActivity();
	}

	@Test(dependsOnMethods = "completedActivityAndSubmitActivity")
	public void verifyActivityStatusDisplayAsCompleted() {
		test.pageAction.verifyActivityStatusDisplayAsCompleted(getYamlValue("submittest.testName"));
	}

	@Test(dependsOnMethods = "verifyActivityStatusDisplayAsCompleted")
	public void logoutfromApplicationAndVerifyLogoutMessage() {
		test.pageAction.logoutfromApplicationAndVerifyLogoutMessage();
	}

	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}