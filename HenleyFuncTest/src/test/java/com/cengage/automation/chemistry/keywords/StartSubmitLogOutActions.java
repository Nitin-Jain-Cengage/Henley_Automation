package com.cengage.automation.chemistry.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cengage.automation.chemistry.pageuiobjects.StartSubmitLogOutUi;

public class StartSubmitLogOutActions extends DifferentActivitiesActions {
	StartSubmitLogOutUi startSubmitLogOutPg;
	WebDriver driver;

	public StartSubmitLogOutActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		startSubmitLogOutPg = new StartSubmitLogOutUi(driver);
	}

	public void clickOnStartActivity() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.switchToFrame(startSubmitLogOutPg.getFrame_Content().getAttribute("id"));
		startSubmitLogOutPg.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		startSubmitLogOutPg.btn_startActivity.isDisplayed();
		startSubmitLogOutPg.btn_startActivity.click();
	}

	public void clickOnStartActivityForTutored() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.switchToFrame(startSubmitLogOutPg.getFrame_Content().getAttribute("id"));
		startSubmitLogOutPg.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		startSubmitLogOutPg.getbtn_startActivityForTutored().isDisplayed();
		startSubmitLogOutPg.getbtn_startActivityForTutored().click();
	}
	


	public void clickOnSubmitLink() {
		startSubmitLogOutPg.checkOverviewStatus();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().isDisplayed();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
	}
	
	public void clickOnSubmitMasterLink() {
		startSubmitLogOutPg.checkOverviewStatus();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.get_StateForSubmitMaster().isDisplayed();
		startSubmitLogOutPg.getbtn_Next().isDisplayed();
		startSubmitLogOutPg.getbtn_Next().click();
		startSubmitLogOutPg.getlink_submit().isDisplayed();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
	}

	public void clickOnSubmitLinkForTutored() {
		startSubmitLogOutPg.getOverviewGradedOut();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getOverviewGradedOut().isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.click();
		startSubmitLogOutPg.waitForSyncPage();
	}

	public void clickOnSubmitButton() {
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getBtn_SubmitActivity().isDisplayed();
		startSubmitLogOutPg.getBtn_SubmitActivity().click();
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getBtn_ConceptMap().isDisplayed();
	}

	public void clickOnClose() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.close.click();
	}

	public void startSubmitActions() {
		clickOnStartActivity();
		clickOnSubmitLink();
		clickOnSubmitButton();
	}
	
	public void startSubmitMasterActions() {
		clickOnStartActivity();
		clickOnSubmitMasterLink();
		clickOnSubmitButton();
	}

	public void logOutFromApp() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.clickOnLogOut();
		startSubmitLogOutPg.waitForSyncPage();
	}
	
	public void verifyLogOutMessage(){
		System.out.println(startSubmitLogOutPg.getTxt_LogoutMessage().getText());
		Assert.assertTrue(startSubmitLogOutPg.getTxt_LogoutMessage().getText().contains("You have logged out or timed out of your course.") &&
				startSubmitLogOutPg.getTxt_LogoutMessage().getText().contains("Restart your session to continue your work."));
		
//		Assert.assertTrue(startSubmitLogOutPg.getTxt_LogoutMessage().getText().equalsIgnoreCase("You have logged out or timed out of your course.") &&
//				startSubmitLogOutPg.getTxt_LogoutMessage().getText().equalsIgnoreCase("Restart your session to continue your work."));
	}
}
