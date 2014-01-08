package com.qait.automation.chemistry.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartSubmitLogOutUi extends BasePage {
	public StartSubmitLogOutUi(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "rhs-actuallystart")
	public WebElement btn_startActivity;
	@FindBy(id = "nav-group-submit")
	public WebElement btn_submitLinkForTutored;
	@FindBy(className = "closeActivity")
	public WebElement close;
	@FindBy(id = "nav-group-submit")
	public WebElement link_submitForTutored;
	@FindBy(xpath = "//div[text()='Submit Activity for Grading']")
	public WebElement btn_SubmitActivity;

	public WebElement getbtn_startActivity() {
		// return btn_startActivity;
		
		return expWait.getWhenVisible(By.xpath("//*[@id='rhs-actuallystart']"), 80);
	}

	public WebElement getbtn_startActivity_Clickable() {
	
		return getWhenClickable(By.id("rhs-actuallystart"), 180);
	}

	public WebElement getbtn_startActivityForTutored() {
		return expWait.getWhenVisible(By.id("rhs-start"), 80);
	}

	public WebElement startActivityForTutored_Clickable() {
		return getWhenClickable(By.id("rhs-start"), 120);
	}
	
	//div[@class='nav-groups']//div[contains(@class,'selected')]
	
	public WebElement getlink_submit() {
		return expWait.getWhenVisible(By.id("submit"), 80);
	}


	public WebElement get_StateForSubmitMaster() {
		return expWait.getWhenVisible(By.xpath("//div[@class='nav-groups']//div[contains(@class,'selected')]"), 80);
	}
	
	public WebElement getbtn_Next() {
		return expWait.getWhenVisible(By.xpath("//div[text()='Next']"), 80);
	}
	
	

	public WebElement getBtn_SubmitActivity() {
		return expWait.getWhenVisible(By.xpath("//div[text()='Submit Activity for Grading']"), 80);
	}

	public WebElement getBtn_ConceptMap() {
		return expWait.getWhenVisible(By.id("conceptMapBtn"), 80);
	}

	public WebElement getOverviewGradedOut() {
		return expWait.getWhenVisible(By.xpath("//*[@class='group' and text()='Overview']"), 80);
	}

	public void checkOverviewStatus() {
		try {
			expWait.getWhenVisible(By.xpath("//*[text()='Overview']/parent::div[@class='sel-item']"), 20);
		} catch (Exception e) {
		}
	}
	// *[text()='Overview']/parent::div[@class='sel-item'] // intoquickperp
	// *[@class='text' and
	// contains(text(),'Overview')]/parent::div/parent::div[@class='group']
	// mastry
}
