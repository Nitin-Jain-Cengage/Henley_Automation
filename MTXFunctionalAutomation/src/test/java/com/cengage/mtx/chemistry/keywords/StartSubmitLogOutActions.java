package com.cengage.mtx.chemistry.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cengage.mtx.chemistry.pageuiobjects.StartSubmitLogOutUi;

/**
 * The Class StartSubmitLogOutActions.
 */
public class StartSubmitLogOutActions extends DifferentActivitiesActions {

	/** The start submit log out pg. */
	StartSubmitLogOutUi startSubmitLogOutPg;
	
	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new start submit log out actions.
	 *
	 * @param driver the driver
	 */
	public StartSubmitLogOutActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		startSubmitLogOutPg = new StartSubmitLogOutUi(driver);
	}

	/**
	 * Click on start activity.
	 */
	public void clickOnStartActivity() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.switchToFrame(startSubmitLogOutPg
				.getFrame_Content().getAttribute("id"));
		startSubmitLogOutPg
				.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		startSubmitLogOutPg.btn_startActivity.isDisplayed();
		startSubmitLogOutPg.btn_startActivity.click();
	}

	/**
	 * Click on start activity for tutored.
	 */
	public void clickOnStartActivityForTutored() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.switchToFrame(startSubmitLogOutPg
				.getFrame_Content().getAttribute("id"));
		startSubmitLogOutPg
				.switchToFrame("easyXDM_activityService_cxp_Target_provider");
		startSubmitLogOutPg.getbtn_startActivityForTutored().isDisplayed();
		startSubmitLogOutPg.getbtn_startActivityForTutored().click();
	}

	/**
	 * Click on submit link.
	 */
	public void clickOnSubmitLink() {
		startSubmitLogOutPg.checkOverviewStatus();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().isDisplayed();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
	}

	/**
	 * Click on submit master link.
	 */
	public void clickOnSubmitMasterLink() {
		startSubmitLogOutPg.checkOverviewStatus();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.waitLong(4);
		startSubmitLogOutPg.get_StateForSubmitMaster().isDisplayed();
		startSubmitLogOutPg.getbtn_Next().isDisplayed();
		startSubmitLogOutPg.getbtn_Next().click();
		startSubmitLogOutPg.getlink_submit().isDisplayed();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getlink_submit().click();
		startSubmitLogOutPg.waitForSyncPage();
	}

	/**
	 * Click on submit link for tutored.
	 */
	public void clickOnSubmitLinkForTutored() {
		startSubmitLogOutPg.getOverviewGradedOut();
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getOverviewGradedOut().isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.isDisplayed();
		startSubmitLogOutPg.link_submitForTutored.click();
		startSubmitLogOutPg.waitForSyncPage();
	}

	/**
	 * Click on submit button.
	 */
	public void clickOnSubmitButton() {
		startSubmitLogOutPg.waitForSyncPage();
		startSubmitLogOutPg.getBtn_SubmitActivity().isDisplayed();
		startSubmitLogOutPg.getBtn_SubmitActivity().click();
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.waitForSyncPage();
		try {
			startSubmitLogOutPg.getBtn_ConceptMap().isDisplayed();
		} catch (Exception e) {
			System.out
					.println("Concept Map button not found on Page: Page Refresh and Search Button Again");
			driver.navigate().refresh();
			startSubmitLogOutPg.getBtn_ConceptMap().isDisplayed();
		}
	}

	/**
	 * Click on close.
	 */
	public void clickOnClose() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.close.click();
	}

	/**
	 * Start submit actions.
	 */
	public void startSubmitActions() {
		clickOnStartActivity();
		clickOnSubmitLink();
		clickOnSubmitButton();
	}

	/**
	 * Start submit master actions.
	 */
	public void startSubmitMasterActions() {
		clickOnStartActivity();
		clickOnSubmitMasterLink();
		clickOnSubmitButton();
	}

	/**
	 * Log out from app.
	 */
	public void logOutFromApp() {
		startSubmitLogOutPg.switchToDefaultContent();
		startSubmitLogOutPg.clickOnLogOut();
		startSubmitLogOutPg.waitForSyncPage();
	}

	/**
	 * Verify log out message.
	 */
	public void verifyLogOutMessage() {
		System.out
				.println(startSubmitLogOutPg.getTxt_LogoutMessage().getText());
		Assert.assertTrue(startSubmitLogOutPg.getTxt_LogoutMessage().getText()
				.contains("You have logged out or timed out of your course.")
				&& startSubmitLogOutPg
						.getTxt_LogoutMessage()
						.getText()
						.contains("Restart your session to continue your work."));
	}
}
