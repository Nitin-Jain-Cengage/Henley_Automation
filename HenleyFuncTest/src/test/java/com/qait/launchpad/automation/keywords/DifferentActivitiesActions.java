package com.qait.launchpad.automation.keywords;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.launchpad.automation.pageuiobjects.DifferentActivitiesUi;

public class DifferentActivitiesActions extends WeekWidgetActions{
	
	DifferentActivitiesUi diffActivitiesPg;
	static String activity_heading;

	public DifferentActivitiesActions(WebDriver driver) {
		super(driver);
		diffActivitiesPg = new DifferentActivitiesUi(driver);
	}

	public void clickOnIntroQuickPrep() {
		int yweek= Integer.parseInt(getYamlValue("week.weeknumber"));		
		diffActivitiesPg.getLbl_IntoQuickPrep_Clickable(yweek).click();
	}
	
	public void clickOnMasteryActivity() {
		diffActivitiesPg.lbl_MasteryActivity.click();
	}
	
	public void clickOnReviewAndChallenge() {
		diffActivitiesPg.lbl_ReviewAndChallenge.click();
	}
	
	public void clickOnStudyGuide() {
		diffActivitiesPg.lbl_StudyGuide.click();
	}
	
	public void clickOnTutoredActivity(){
		diffActivitiesPg.getlbl_TutoredActivity_Clickable().click();
	}
	
	public void verifyActivityStatusDisplayAsCompleted(String activityName) {
		Assert.assertTrue(diffActivitiesPg.getPreocessingIndicator(activityName).isDisplayed());
		diffActivitiesPg.waitForSync();
		
	}
	
	public void ToGetActivityHeadingandverifyActivityStatusDisplay()
	{
		activity_heading= diffActivitiesPg.getActivityHeading().getText();
	}
		
}