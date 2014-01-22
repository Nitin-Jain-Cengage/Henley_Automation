package com.cengage.mtx.automation.history.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.automation.chemistry.keywords.StartSubmitLogOutActions;
import com.cengage.mtx.automation.history.pageuiobjects.History_CourseContent_Ui;

// TODO: Auto-generated Javadoc
/**
 * The Class History_CourseContent_Action.
 */
public class History_CourseContent_Action extends StartSubmitLogOutActions {
	
	/** The driver. */
	WebDriver driver;
	
	/** The history course content. */
	History_CourseContent_Ui historyCourseContent;
	
	/** The Heading name. */
	static String HeadingName;

	/**
	 * Instantiates a new history_ course content_ action.
	 *
	 * @param driver the driver
	 */
	public History_CourseContent_Action(WebDriver driver) {
		super(driver);
		this.driver = driver;
		historyCourseContent = new History_CourseContent_Ui(driver);
	}

	/**
	 * Verify and click on activity.
	 *
	 * @param activityName the activity name
	 */
	public void verifyAndClickOnActivity(String activityName) {
		for (WebElement ele : historyCourseContent.get_ActivityNameFromList()) {
			if (ele.getText().contains(activityName)) {
				ele.click();
				break;
			}
		}
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
		historyCourseContent.switchToFrame(historyCourseContent.getFrame_Content().getAttribute("id"));
		historyCourseContent.switchToFrame("easyXDM_activityService_cxp_Target_provider");
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
			if (historyCourseContent.getbtn_showSubmitActivityButtonState().getAttribute("style").contains("display: none;")) {
				historyCourseContent.waitForSyncPage();
				System.out.println(historyCourseContent.getbtn_showSubmitActivityButtonState().getAttribute("style"));
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
	 * Verify infographic activity display1.
	 */
	public void verifyInfographicActivityDisplay1() {
		for (WebElement ele : historyCourseContent.get_ActivityNameFromList()) {
			if (ele.getText().contains("2.5 European Exploration")) {
				ele.click();
				break;
			}
		}
		historyCourseContent.getActivityHeading().isDisplayed();
		System.out.println(historyCourseContent.getActivityHeading().getText());
		String HeadingName = historyCourseContent.getActivityHeading().getText();
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.switchToFrame(historyCourseContent.getFrame_Content().getAttribute("id"));
		historyCourseContent.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		historyCourseContent.getbtn_startActivity().isDisplayed();
		historyCourseContent.getbtn_startActivity().click();
		historyCourseContent.waitForSyncPage();
		historyCourseContent.getbtn_NextButton().isDisplayed();
		System.out.println(historyCourseContent.getbtn_showSubmitActivityButtonState().getAttribute("style"));
		for (int i = 0; i < 80; i++) {
			System.out.println(historyCourseContent.getbtn_showSubmitActivityButtonState().getAttribute("style"));
			if (historyCourseContent.getbtn_showSubmitActivityButtonState().getAttribute("style").contains("display: none;")) {
				System.out.println(historyCourseContent.getbtn_showSubmitActivityButtonState().getAttribute("style"));
				historyCourseContent.getbtn_NextButton().click();
				historyCourseContent.waitForSyncPage();
			} else {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		historyCourseContent.getBtn_SubmitActivity().click();
		historyCourseContent.btn_conceptMap().isDisplayed();
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
