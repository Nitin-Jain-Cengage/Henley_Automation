package com.cengage.mtx.chemistry.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class DifferentActivitiesUi.
 */
public class DifferentActivitiesUi extends BasePage {

	/**
	 * Instantiates a new different activities ui.
	 *
	 * @param driver the driver
	 */
	public DifferentActivitiesUi(WebDriver driver) {
		super(driver);
	}

	/** The lbl_ intro quick prep. */
	@FindBy(xpath = "(.//label[contains(text(),'Introduction and Quick Prep')])[1]")
	private WebElement lbl_IntroQuickPrep;
	
	/** The lbl_ mastery activity. */
	@FindBy(xpath = "(.//div[contains(@class,'dash-middle')]//div[contains(@title,'Mastery')])[1]")
	public WebElement lbl_MasteryActivity;
	
	/** The lbl_ review and challenge. */
	@FindBy(xpath = ".//div[contains(@class,'dash-middle')]//div[contains(@title,'Review and Challenge')]")
	public WebElement lbl_ReviewAndChallenge;
	
	/** The lbl_ study guide. */
	@FindBy(xpath = ".//div[contains(@class,'dash-middle')]//div[contains(@title,'Study Guide')]")
	public WebElement lbl_StudyGuide;

	/**
	 * Gets the lbl_ into quick prep.
	 *
	 * @return the lbl_ into quick prep
	 */
	public WebElement getLbl_IntoQuickPrep() {
		return lbl_IntroQuickPrep;
	}

	/**
	 * Gets the lbl_ into quick prep_ clickable.
	 *
	 * @return the lbl_ into quick prep_ clickable
	 */
	public WebElement getLbl_IntoQuickPrep_Clickable() {
		return getWhenClickable(
				By.xpath("//div[@class='week dash-middle']//label[contains(.,'Introduction and Quick Prep')]"),
				90);
	}

	/**
	 * Gets the lbl_ matery activity.
	 *
	 * @return the lbl_ matery activity
	 */
	public WebElement getlbl_MateryActivity() {
		return lbl_MasteryActivity;
	}

	/**
	 * Gets the lbl_ matery activity_ clickable.
	 *
	 * @return the lbl_ matery activity_ clickable
	 */
	public WebElement getlbl_MateryActivity_Clickable() {
		return getWhenClickable(
				By.xpath("(.//div[contains(@class,'dash-middle')]//div[contains(@title,'Mastery')])[1]"),
				90);
	}

	/**
	 * Gets the lbl_ review and challenge.
	 *
	 * @return the lbl_ review and challenge
	 */
	public WebElement getlbl_ReviewAndChallenge() {
		return lbl_ReviewAndChallenge;
	}

	/**
	 * Gets the lbl_ review and challenge_ clickable.
	 *
	 * @return the lbl_ review and challenge_ clickable
	 */
	public WebElement getlbl_ReviewAndChallenge_Clickable() {
		return getWhenClickable(
				By.xpath(".//div[contains(@class,'dash-middle')]//div[contains(@title,'Review and Challenge')]"),
				120);
	}

	/**
	 * Gets the lbl_ study guide.
	 *
	 * @return the lbl_ study guide
	 */
	public WebElement getlbl_StudyGuide() {
		return lbl_StudyGuide;
	}

	/**
	 * Gets the lbl_ study guide_ clickable.
	 *
	 * @return the lbl_ study guide_ clickable
	 */
	public WebElement getlbl_StudyGuide_Clickable() {
		return getWhenClickable(
				By.xpath(".//div[contains(@class,'dash-middle')]//div[contains(@title,'Study Guide')]"),
				120);
	}

	// String TutoredActivityName = getYamlValue("activity.tutored");
	// String path = "".replaceAll("index", TutoredActivityName);
	/**
	 * Gets the lbl_ tutored activity_ clickable.
	 *
	 * @param TutoredActivityName the tutored activity name
	 * @return the lbl_ tutored activity_ clickable
	 */
	public WebElement getlbl_TutoredActivity_Clickable(
			String TutoredActivityName) {
		return getWhenClickable(
				By.xpath(".//div[contains(@class,'dash-middle')]//div[contains(@title,'"
						+ TutoredActivityName + "')]"), 90);
	}
}
