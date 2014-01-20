package com.cengage.automation.BasicSmoke.tests;

import static com.cengage.automation.utils.YamlReader.getYamlValue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cengage.automation.TestSessionInitiator;


public class InstructorTakeDelete_Test {

	TestSessionInitiator test;
	static String bookType;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("src\\test\\resources\\testdata\\TestData.yml");
		test.launchApplication();
	}

	@Test
	@Parameters({"myName"})
	public void loginToTheSSOFrontDoor(@Optional("chemistry") String myName) {
		test.loginActionsPg.loginToTheApplication(getYamlValue("users.instructor.username"), getYamlValue("users.instructor.password"));
		bookType = myName.toLowerCase().trim();

	}
	
	@Test(dependsOnMethods="loginToTheSSOFrontDoor") 
	public void performOperationsOnHomePage()
	{

		test.instTakeDeletePg.selectProdIsbn(getYamlValue("DeleteTake."+bookType+".isbn"));
		test.instTakeDeletePg.clickOnCourseName(getYamlValue("DeleteTake."+bookType+".coursename"), getYamlValue("testenv"));
	}
	
	@Test(dependsOnMethods="performOperationsOnHomePage")
	public void actionsOnWeekWidgetView()
	{
		test.instTakeDeletePg.clickOnAllApps();
		test.instTakeDeletePg.clickOnViewProgressApp();
	}
	
	@Test(dependsOnMethods="actionsOnWeekWidgetView")
	public void actionsOnStudentTab(){
		test.instTakeDeletePg.clickOnStudentRoasterTab();
		test.instTakeDeletePg.clickOnStudent(getYamlValue("DeleteTake."+bookType+".studentname"));
	}
	
	@Test(dependsOnMethods="actionsOnStudentTab")
	public void performDeleteOfStudentScore() {
		test.instTakeDeletePg.getListOfActivityScoresAndDelete();
	}
	
	@AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
	}
}
