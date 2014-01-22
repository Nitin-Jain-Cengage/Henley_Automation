package com.cengage.mtx.automation.chemistry.keywords;


import org.openqa.selenium.WebDriver;

import com.cengage.mtx.automation.chemistry.pageuiobjects.DifferentActivitiesUi;

// TODO: Auto-generated Javadoc
/**
 * The Class DifferentActivitiesActions.
 */
public class DifferentActivitiesActions extends WeekWidgetActions {
	
	/** The diff activities pg. */
	DifferentActivitiesUi diffActivitiesPg;
	
	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new different activities actions.
	 *
	 * @param driver the driver
	 */
	public DifferentActivitiesActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		diffActivitiesPg = new DifferentActivitiesUi(driver);
	}

	/**
	 * Click on intro quick prep.
	 */
	public void clickOnIntroQuickPrep() {
		diffActivitiesPg.getLbl_IntoQuickPrep_Clickable().click();
	}

	/**
	 * Click on mastery activity.
	 */
	public void clickOnMasteryActivity() {
		diffActivitiesPg.lbl_MasteryActivity.click();
	}

	/**
	 * Click on review and challenge.
	 */
	public void clickOnReviewAndChallenge() {
		diffActivitiesPg.lbl_ReviewAndChallenge.click();
	}

	/**
	 * Click on study guide.
	 */
	public void clickOnStudyGuide() {
		diffActivitiesPg.lbl_StudyGuide.click();
	}

	/**
	 * Click on tutored activity.
	 *
	 * @param TutoredActivityName the tutored activity name
	 */
	public void clickOnTutoredActivity(String TutoredActivityName) {
		diffActivitiesPg.getlbl_TutoredActivity_Clickable(TutoredActivityName).click();
	}
}