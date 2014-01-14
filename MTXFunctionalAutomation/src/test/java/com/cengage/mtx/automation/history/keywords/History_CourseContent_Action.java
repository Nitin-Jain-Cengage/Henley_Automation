package com.cengage.mtx.automation.history.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.automation.chemistry.keywords.StartSubmitLogOutActions;
import com.cengage.mtx.automation.history.pageuiobjects.History_CourseContent_Ui;

/**
 * @param QAIT
 */
public class History_CourseContent_Action extends StartSubmitLogOutActions {
	WebDriver driver;
	History_CourseContent_Ui historyCourseContent;
	static String HeadingName;

	public History_CourseContent_Action(WebDriver driver) {
		super(driver);
		this.driver = driver;
		historyCourseContent = new History_CourseContent_Ui(driver);
	}

	public void verifyAndClickOnActivity(String activityName) {
		for (WebElement ele : historyCourseContent.get_ActivityNameFromList()) {
			if (ele.getText().contains(activityName)) {
				ele.click();
				break;
			}
		}
	}

	public void verifyActivityHeading() {
		historyCourseContent.getActivityHeading().isDisplayed();
		System.out.println(historyCourseContent.getActivityHeading().getText());
		HeadingName = historyCourseContent.getActivityHeading().getText();
	}

	public void switchToActivityContentFrame() {
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.switchToFrame(historyCourseContent.getFrame_Content().getAttribute("id"));
		historyCourseContent.switchToFrame("easyXDM_activityService_cxp_Target_provider");
	}

	public void verifyStartActivityButtonAndClick() {
		historyCourseContent.getbtn_startActivity().isDisplayed();
		historyCourseContent.getbtn_startActivity().click();
		historyCourseContent.waitForSyncPage();
	}

	public void verifyNextButtonDisplays() {
		historyCourseContent.getbtn_NextButton().isDisplayed();
	}

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

	public void verifySubmitActivityButtonDisplayAndClick() {
		historyCourseContent.getBtn_SubmitActivity().isDisplayed();
		historyCourseContent.getBtn_SubmitActivity().click();
	}

	public void verifyUserNavigateToWeekWidget() {
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.btn_conceptMap().isDisplayed();
	}

	public void verifyCompletedStatus() {
		verifyStausDisplayAsCompleted(HeadingName);
	}

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

	public void verifyPrintButtonDisplayInStudy() {
		historyCourseContent.getbtn_PrintStudy().isDisplayed();
	}

	public void closeStudyActivity() {
		historyCourseContent.switchToDefaultContent();
		historyCourseContent.getbtn_closeActivity().isDisplayed();
		historyCourseContent.getbtn_closeActivity().click();
		verifyUserNavigateToWeekWidget();
	}
}
