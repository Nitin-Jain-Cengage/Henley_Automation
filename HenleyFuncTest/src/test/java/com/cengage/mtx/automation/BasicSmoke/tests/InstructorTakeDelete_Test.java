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
 * The Class InstructorTakeDelete_Test.
 */
public class InstructorTakeDelete_Test {

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
	 * Login to the sso front door.
	 *
	 * @param myName the my name
	 */
	@Test
	@Parameters({"myName"})
	public void loginToTheSSOFrontDoor(@Optional("history") String myName) {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.instructor.username"), getYamlValue("users.instructor.password"));
		bookType = myName.toLowerCase().trim();

	}
	
	/**
	 * Perform operations on home page.
	 */
	@Test(dependsOnMethods="loginToTheSSOFrontDoor") 
	public void performOperationsOnHomePage()
	{

		test.instTakeDeletePg.selectProdIsbn(getYamlValue("DeleteTake."+bookType+".isbn"));
		test.instTakeDeletePg.clickOnCourseName(getYamlValue("DeleteTake."+bookType+".coursename"), getYamlValue("testenv"));
	}
	
	/**
	 * Actions on week widget view.
	 */
	@Test(dependsOnMethods="performOperationsOnHomePage")
	public void actionsOnWeekWidgetView()
	{
		test.instTakeDeletePg.clickOnAllApps();
		test.instTakeDeletePg.clickOnViewProgressApp();
	}
	
	/**
	 * Actions on student tab.
	 */
	@Test(dependsOnMethods="actionsOnWeekWidgetView")
	public void actionsOnStudentTab(){
		test.instTakeDeletePg.clickOnStudentRoasterTab();
		test.instTakeDeletePg.clickOnStudent(getYamlValue("DeleteTake."+bookType+".studentname"));
	}
	
	/**
	 * Perform delete of student score.
	 */
	@Test(dependsOnMethods="actionsOnStudentTab")
	public void performDeleteOfStudentScore() {
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
