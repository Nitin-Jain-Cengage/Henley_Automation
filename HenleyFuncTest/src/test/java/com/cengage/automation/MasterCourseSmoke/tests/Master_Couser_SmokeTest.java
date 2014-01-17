/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.automation.MasterCourseSmoke.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static com.cengage.automation.utils.YamlReader.getYamlValue;

import com.cengage.automation.TestSessionInitiator;

/**
 * 
 * @author QAIT
 */
public class Master_Couser_SmokeTest {
	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("src\\test\\resources\\testdata\\MasterSmokeTestData.yml");
		test.launchApplication();
	}

	@Test
	public void loginToTheAdmin() {
		test.masterLoginPg.loginToTheAdminApplication(getYamlValue("users.Admin.masterusername"), getYamlValue("users.Admin.masterpassword"));
	}

	@Test(dependsOnMethods = "loginToTheAdmin")
	public void performSearch() {
		test.adminDashboardPg.verifyUserNavigateToDashboardPage();
		test.adminDashboardPg.enterSearchTerm(getYamlValue("users.Admin.ISBN"));
	}

	@Test(dependsOnMethods = "performSearch")
	public void navigateToISBNbook() {
		test.adminDashboardPg.clickOnISBNBookAfterSearch(getYamlValue("users.Admin.ISBN"));
		test.adminDashboardPg.verifyBookContentLoaded();
		 test.adminDashboardPg.verifyLaunchAllActivity();
	}

	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}