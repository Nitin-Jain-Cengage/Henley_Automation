package com.cengage.mtx.history.keywords;

import org.openqa.selenium.WebDriver;

import com.cengage.mtx.chemistry.keywords.StartSubmitLogOutActions;
import com.cengage.mtx.history.pageuiobjects.HistoryCourseContentUi;

/**
 * The Class HistoryCourseContentAction.
 */
public class HistoryCourseContentAction extends StartSubmitLogOutActions {

	/** The driver. */
	WebDriver driver;
	
	/** The history course content. */
	HistoryCourseContentUi historyCourseContent;
	
	/** The Heading name. */
	static String HeadingName;

	/**
	 * Instantiates a new history course content action.
	 *
	 * @param driver the driver
	 */
	public HistoryCourseContentAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		historyCourseContent = new HistoryCourseContentUi(driver);
	}

	/**
	 * Verify and click on activity.
	 *
	 * @param activityName the activity name
	 */
	public void verifyAndClickOnActivity(String activityName) {
		historyCourseContent.get_ActivityNameLink(activityName).isDisplayed();
		historyCourseContent.get_ActivityNameLink(activityName).click();
		historyCourseContent.waitForSyncPage();
	}
	
	/**
	 * Verify start activity or next button is present.
	 */
	public void verifyStartActivityOrNextIsPresent()
	{
		historyCourseContent.waitForSyncPage();
		switchToActivityContentFrame();
		try{
			historyCourseContent.getbtn_startActivity().isDisplayed();
			System.out.println("start activity button is present");
		}catch(Exception e)
		{	verifyNextButtonDisplays();
			System.out.println("next button is present");
		}
		historyCourseContent.waitForSyncPage();
	}

	/**
	 * Verify activity heading.
	 */
	public void verifyActivityHeading() {
		historyCourseContent.getActivityHeading().isDisplayed();
		System.out.println(historyCourseContent.getActivityHeading().getText());
		HeadingName = historyCourseContent.getActivityHeading().getText();
	}

	/**
	 * Switch to activity content frame.
	 */
	public void switchToActivityContentFrame() {
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.switchToFrame(historyCourseContent
				.getFrame_Content().getAttribute("id"));
		historyCourseContent
				.switchToFrame("easyXDM_activityService_cxp_Target_provider");
	}

	/**
	 * Verify start activity button and click.
	 */
	public void verifyStartActivityButtonAndClick() {
		historyCourseContent.getbtn_startActivity().isDisplayed();
		historyCourseContent.getbtn_startActivity().click();
		historyCourseContent.waitForSyncPage();
	}

	/**
	 * Verify next button displays.
	 */
	public void verifyNextButtonDisplays() {
		historyCourseContent.getbtn_NextButton().isDisplayed();
	}

	/**
	 * Click on next button and submit activity.
	 */
	public void clickOnNextButtonAndSubmitActivity() {
		for (int i = 0; i < 80; i++) {
			if (historyCourseContent.getbtn_showSubmitActivityButtonState()
					.getAttribute("style").contains("display: none;")) {
				historyCourseContent.waitForSyncPage();
				System.out.println(historyCourseContent
						.getbtn_showSubmitActivityButtonState().getAttribute(
								"style"));
				historyCourseContent.getbtn_NextButton().click();
				historyCourseContent.waitForSyncPage();
			} else {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Verify submit activity button display and click.
	 */
	public void verifySubmitActivityButtonDisplayAndClick() {
		historyCourseContent.getBtn_SubmitActivity().isDisplayed();
		historyCourseContent.getBtn_SubmitActivity().click();
	}

	/**
	 * Verify user navigate to week widget.
	 */
	public void verifyUserNavigateToWeekWidget() {
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.btn_conceptMap().isDisplayed();
	}

	/**
	 * Verify completed status.
	 */
	public void verifyCompletedStatus() {
		verifyStausDisplayAsCompleted(HeadingName);
	}

	/**
	 * Verify print button display in study.
	 */
	public void verifyPrintButtonDisplayInStudy() {
		historyCourseContent.getbtn_PrintStudy().isDisplayed();
	}

	/**
	 * Close study activity.
	 */
	public void closeStudyActivity() {
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.getbtn_closeActivity().isDisplayed();
		historyCourseContent.getbtn_closeActivity().click();
		verifyUserNavigateToWeekWidget();
	}
}
