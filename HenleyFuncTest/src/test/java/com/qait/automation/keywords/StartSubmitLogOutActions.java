package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.pageuiobjects.StartSubmitLogOutUi;

public class StartSubmitLogOutActions {
	
	StartSubmitLogOutUi startSubmitLogOutPg;
	WebDriver driver;

	public StartSubmitLogOutActions(WebDriver driver) {
		super();
		this.driver=driver;

		startSubmitLogOutPg = new StartSubmitLogOutUi(driver);
	
	}
	
	public void clickOnStartActivity()
	{
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.switchToFrame("54_NB_Main_IFrame");
		startSubmitLogOutPg.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		startSubmitLogOutPg.btn_startActivity.isDisplayed();
		startSubmitLogOutPg.btn_startActivity.click();
	}
	
	public void clickOnStartActivityForTutored()
	{
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.switchToFrame("54_NB_Main_IFrame");
		startSubmitLogOutPg.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		startSubmitLogOutPg.getbtn_startActivityForTutored().isDisplayed();
		startSubmitLogOutPg.getbtn_startActivityForTutored().click();
	}
	
	public void clickOnSubmitLink()
	{
		startSubmitLogOutPg.checkOverviewStatus();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().isDisplayed();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();

	}
	
	public void clickOnSubmitLinkForTutored()
	{
		startSubmitLogOutPg.getOverviewGradedOut();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getOverviewGradedOut().isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.click();
		startSubmitLogOutPg.waitForSyncPage();
		
	}
	
	public void clickOnSubmitButton()
	{
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getBtn_SubmitActivity().isDisplayed();
		startSubmitLogOutPg.getBtn_SubmitActivity().click();
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getBtn_ConceptMap().isDisplayed();
	}
		
	public void clickOnClose()
	{
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.close.click();
	}

	public void startSubmitActions()
	{
		clickOnStartActivity();
		clickOnSubmitLink();
		clickOnSubmitButton();
	}
	
	public void logOutFromApp()
	{
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.clickOnLogOut();
	}
		
}
