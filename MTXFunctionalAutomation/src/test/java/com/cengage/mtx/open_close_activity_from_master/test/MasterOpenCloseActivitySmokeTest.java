/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.open_close_activity_from_master.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static com.cengage.mtx.utils.YamlReader.getYamlValue;

import com.cengage.mtx.TestSessionInitiator;

/**
 * The Class MasterOpenCloseActivitySmokeTest.
 */
public class MasterOpenCloseActivitySmokeTest {

	/** The test. */
	TestSessionInitiator test;

	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator(
				"Master_Smoke_TestData.yml");
		test.launchApplication();
	}

	/**
	 * Login to the admin.
	 */
	@Test
	public void loginToTheAdmin() {
		test.masterLoginPg.loginToTheAdminApplication(
				getYamlValue("users.Admin.masterusername"),
				getYamlValue("users.Admin.masterpassword"));
	}

	/**
	 * Perform search.
	 */
	@Test(dependsOnMethods = "loginToTheAdmin")
	public void performSearch() {
		test.adminDashboardPg.verifyUserNavigateToDashboardPage();
		test.adminDashboardPg.enterSearchTerm(getYamlValue("users.Admin.ISBN"));
	}

	/**
	 * Navigate to isb nbook.
	 */
	@Test(dependsOnMethods = "performSearch")
	public void navigateToISBNbook() {
		test.adminDashboardPg
				.clickOnISBNBookAfterSearch(getYamlValue("users.Admin.ISBN"));
		test.adminDashboardPg.verifyBookContentLoaded();
		test.adminDashboardPg.verifyLaunchAllActivity();
	}

	/**
	 * Takeresult.
	 *
	 * @param result the result
	 */
	@AfterMethod
	public void takeresult(ITestResult result) {
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