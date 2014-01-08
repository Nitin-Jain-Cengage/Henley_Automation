package com.qait.automation.chemistry.pageuiobjects;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentActivitiesUi extends BasePage {
	public DifferentActivitiesUi(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(.//label[contains(text(),'Introduction and Quick Prep')])[1]")
	private WebElement lbl_IntroQuickPrep;
	@FindBy(xpath = "(.//div[contains(@class,'dash-middle')]//div[contains(@title,'Mastery')])[1]")
	public WebElement lbl_MasteryActivity;
	@FindBy(xpath = ".//div[contains(@class,'dash-middle')]//div[contains(@title,'Review and Challenge')]")
	public WebElement lbl_ReviewAndChallenge;
	@FindBy(xpath = ".//div[contains(@class,'dash-middle')]//div[contains(@title,'Study Guide')]")
	public WebElement lbl_StudyGuide;

	public WebElement getLbl_IntoQuickPrep() {
		return lbl_IntroQuickPrep;
	}

	public WebElement getLbl_IntoQuickPrep_Clickable(int yweek) {
		int xweek = yweek - 1;
		String xpath = "//div[@id='week" + xweek + "']//label[contains(.,'Introduction and Quick Prep')]";
		return getWhenClickable(By.xpath(xpath), 90);
	}

	public WebElement getlbl_MateryActivity() {
		return lbl_MasteryActivity;
	}

	public WebElement getlbl_MateryActivity_Clickable() {
		return getWhenClickable(By.xpath("(.//div[contains(@class,'dash-middle')]//div[contains(@title,'Mastery')])[1]"), 90);
	}

	public WebElement getlbl_ReviewAndChallenge() {
		return lbl_ReviewAndChallenge;
	}

	public WebElement getlbl_ReviewAndChallenge_Clickable() {
		return getWhenClickable(By.xpath(".//div[contains(@class,'dash-middle')]//div[contains(@title,'Review and Challenge')]"), 120);
	}

	public WebElement getlbl_StudyGuide() {
		return lbl_StudyGuide;
	}

	public WebElement getlbl_StudyGuide_Clickable() {
		return getWhenClickable(By.xpath(".//div[contains(@class,'dash-middle')]//div[contains(@title,'Study Guide')]"), 120);
	}

	String TutoredActivityName = getYamlValue("activity.tutored");
	String path = ".//div[contains(@class,'dash-middle')]//div[contains(@title,'index')]".replaceAll("index", TutoredActivityName);

	public WebElement getlbl_TutoredActivity_Clickable() {
		return getWhenClickable(By.xpath(path), 90);
	}
}
