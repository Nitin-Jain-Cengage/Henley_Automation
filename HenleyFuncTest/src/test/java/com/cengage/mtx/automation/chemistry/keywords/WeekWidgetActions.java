package com.cengage.mtx.automation.chemistry.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cengage.mtx.automation.chemistry.pageuiobjects.WeekWidgetUi;

// TODO: Auto-generated Javadoc
/**
 * The Class WeekWidgetActions.
 */
public class WeekWidgetActions extends StudentHomePageActions {
	
	/** The week widget pge. */
	protected WeekWidgetUi weekWidgetPge;
	
	/** The driver. */
	WebDriver driver;
	
	/** The numbr. */
	int numbr;
	
	/** The current week. */
	String currentWeek;
	
	/** The yweek. */
	int yweek;
	
	/** The activity_heading. */
	static String activity_heading;

	/**
	 * Instantiates a new week widget actions.
	 *
	 * @param driver the driver
	 */
	public WeekWidgetActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		weekWidgetPge = new WeekWidgetUi(driver);
	}

	/**
	 * Verify total no of weeks.
	 *
	 * @return true, if successful
	 */
	public boolean verifyTotalNoOfWeeks() {
		if (weekWidgetPge.totalNoOfWeeks.size() == weekWidgetPge.NoOfWeeksOnSlider.size()) {
			System.out.println("Total no. of weeks:->" + weekWidgetPge.totalNoOfWeeks.size());
			System.out.println("Total no of weeks on divider:->" + weekWidgetPge.NoOfWeeksOnSlider.size());
			return true;
		} else
			return false;
	}

	/**
	 * Switch to new window.
	 */
	public void switchToNewWindow() {
		weekWidgetPge.getWindowHandle();
		
	}

	/**
	 * Gets the title of activity.
	 *
	 * @return the title of activity
	 */
	public void getTitleOfActivity() {
		activity_heading = weekWidgetPge.titleOfActivity_Clickable().getText();
		System.out.println("Activity Title:->" + activity_heading);
	}

	/**
	 * Verify activity status display as completed.
	 */
	public void verifyActivityStatusDisplayAsCompleted() {
		verifyStausDisplayAsCompleted(activity_heading);
	}

	/**
	 * Verify staus display as completed.
	 *
	 * @param activityName the activity name
	 */
	public void verifyStausDisplayAsCompleted(String activityName) {
		Assert.assertTrue(weekWidgetPge.getPreocessingIndicator(activityName).isDisplayed());
		weekWidgetPge.waitForSync();
	}

	/**
	 * Verify concept map button.
	 */
	public void verifyConceptMapButton() {
		try {
			weekWidgetPge.btn_conceptMap().isDisplayed();
		} catch (Exception e) {
			weekWidgetPge.acceptButtonOnStudentContent().isDisplayed();
			weekWidgetPge.acceptButtonOnStudentContent().click();
			weekWidgetPge.btn_conceptMap().isDisplayed();
		}
	}

	/**
	 * Click on all apps.
	 */
	public void clickOnAllApps() {
		weekWidgetPge.waitForSyncPage();
		weekWidgetPge.btn_allApps().isDisplayed();
		weekWidgetPge.btn_allApps().click();
	}

	/**
	 * Click on merriam webster app.
	 */
	public void clickOnMerriamWebsterApp() {
		for (int i = 0; i < weekWidgetPge.lbl_appName.size(); i++) {
			System.out.println(weekWidgetPge.lbl_appName.get(i).getAttribute("alt"));
			if (weekWidgetPge.lbl_appName.get(i).getAttribute("alt").equals("Merriam-Webster's Dictionary")) {
				weekWidgetPge.appNameLink.get(i).click();
				getverifyMerriamWebsterApp();
			} else {
				weekWidgetPge.appNameLink.get(i).isDisplayed();				
				weekWidgetPge.appNameLink.get(i).click();
				getVerify(weekWidgetPge.lbl_appName.get(i).getAttribute("alt"));
			}
			weekWidgetPge.btn_allApps().click();
		}
		weekWidgetPge.btn_allApps().click();
	}

	/**
	 * Gets the verify.
	 *
	 * @param appName the app name
	 * @return the verify
	 */
	public void getVerify(String appName) {
		weekWidgetPge.getHeadingNameOfTheApp(appName);
		Assert.assertTrue(weekWidgetPge.getHeadingNameOfTheApp(appName).isDisplayed());
		weekWidgetPge.getHeadingNameOfTheApp(appName);
		Assert.assertTrue(weekWidgetPge.getCollapse(appName).isDisplayed());
		weekWidgetPge.getCollapse(appName).click();
	}

	/**
	 * Gets the verify merriam webster app.
	 *
	 * @return the verify merriam webster app
	 */
	public void getverifyMerriamWebsterApp() {
		weekWidgetPge.getHeadingNameOfMerriamWebsterApp();
		weekWidgetPge.getHeadingNameOfMerriamWebsterApp().isDisplayed();
		weekWidgetPge.getHeadingNameOfMerriamWebsterApp();
		Assert.assertTrue(weekWidgetPge.getCollapseForMerriamWebsterApp().isDisplayed());
		weekWidgetPge.getCollapseForMerriamWebsterApp().click();
	}

	/**
	 * Navigate to week.
	 *
	 * @param week the week
	 */
	public void navigateToWeek(String week) {
		String temp = driver.getCurrentUrl();
		String[] weeknav = week.toLowerCase().split("week");
		int weekNo = Integer.parseInt(weeknav[1].trim());
		weekNo = weekNo-1;
		weeknav = temp.split("currentWeekIndex=");
		temp = weeknav[0] + "currentWeekIndex=" + weekNo;
		System.out.println("Created URL" + temp);
		driver.navigate().to(temp);
	}
	
}
