package com.cengage.mtx.automation.chemistry.keywords;


import org.openqa.selenium.WebDriver;

import com.cengage.mtx.automation.chemistry.pageuiobjects.DifferentActivitiesUi;

public class DifferentActivitiesActions extends WeekWidgetActions {
	DifferentActivitiesUi diffActivitiesPg;
	WebDriver driver;

	public DifferentActivitiesActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		diffActivitiesPg = new DifferentActivitiesUi(driver);
	}

	public void clickOnIntroQuickPrep() {
		diffActivitiesPg.getLbl_IntoQuickPrep_Clickable().click();
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

	public void clickOnTutoredActivity(String TutoredActivityName) {
		diffActivitiesPg.getlbl_TutoredActivity_Clickable(TutoredActivityName).click();
	}
}