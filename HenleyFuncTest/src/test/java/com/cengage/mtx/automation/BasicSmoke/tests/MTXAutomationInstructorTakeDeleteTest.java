package com.cengage.mtx.automation.BasicSmoke.tests;

import static com.cengage.mtx.automation.utils.YamlReader.getYamlValue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cengage.mtx.automation.TestSessionInitiator;


/**
 * The Class MTXAutomationInstructorTakeDeleteTest.
 */
public class MTXAutomationInstructorTakeDeleteTest {

	/** The test. */
	TestSessionInitiator test;
	
	/** The book type. */
	static String bookType;

	/**
	 * Sets the up class.
	 */
	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("src\\test\\resources\\testdata\\TestData.yml");
		test.launchApplication();
	}

	/**
	 * TC001_login to the sso front door.
	 *
	 * @param myName the my name
	 */
	@Test
	@Parameters({"courseType"})
	public void TC001_loginToTheSSOFrontDoor(@Optional("history") String myName) {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.instructor.username"), getYamlValue("users.instructor.password"));
		bookType = myName.toLowerCase().trim();

	}
	
	/**
	 * TC002_perform operations on home page.
	 */
	@Test 
	public void TC002_performOperationsOnHomePage()
	{

		test.instTakeDeletePg.selectProdIsbn(getYamlValue("DeleteTake."+bookType+".isbn"));
		test.instTakeDeletePg.clickOnCourseName(getYamlValue("DeleteTake."+bookType+".coursename"), getYamlValue("testenv"));
	}
	
	/**
	 * TC003_actions on week widget view.
	 */
	@Test
	public void TC003_actionsOnWeekWidgetView()
	{
		test.instTakeDeletePg.clickOnAllApps();
		test.instTakeDeletePg.clickOnViewProgressApp();
	}
	
	/**
	 * TC004_actions on student tab.
	 */
	@Test
	public void TC004_actionsOnStudentTab(){
		test.instTakeDeletePg.clickOnStudentRoasterTab();
		test.instTakeDeletePg.clickOnStudent(getYamlValue("DeleteTake."+bookType+".studentname"));
	}
	
	/**
	 * TC005_perform delete of student score.
	 */
	@Test
	public void TC005_performDeleteOfStudentScore() {
		test.instTakeDeletePg.getListOfActivityScoresAndDelete();
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
