package com.qait.launchpad.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.launchpad.automation.pageuiobjects.StartSubmitLogOutUi;

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
		startSubmitLogOutPg.btn_startActivityForTutored.isDisplayed();
		startSubmitLogOutPg.btn_startActivityForTutored.click();
	}
	
	public void clickOnSubmitLink()
	{
		startSubmitLogOutPg.link_submit.click();
	}
	
	public void clickOnSubmitLinkForTutored()
	{
		startSubmitLogOutPg.getOverviewGradedOut().isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.click();
	}
	
	public void clickOnSubmitButton()
	{
		startSubmitLogOutPg.btn_SubmitActivity.click();
		startSubmitLogOutPg.switchToDefaultContent();
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
