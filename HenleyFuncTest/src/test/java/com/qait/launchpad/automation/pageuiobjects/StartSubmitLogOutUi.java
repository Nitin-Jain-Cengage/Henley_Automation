package com.qait.launchpad.automation.pageuiobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartSubmitLogOutUi extends BasePage{

	public StartSubmitLogOutUi(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="rhs-actuallystart")
	public WebElement btn_startActivity;
	
	public WebElement getbtn_startActivity(){
//		return btn_startActivity;
		return expWait.getWhenVisible(By.xpath("//*[@id='rhs-actuallystart']"), 80);
	}
	
	public WebElement getbtn_startActivity_Clickable() {
		return getWhenClickable(By.id("rhs-actuallystart"), 180);
	}
	
	

	
	public WebElement getbtn_startActivityForTutored(){
		return expWait.getWhenVisible(By.id("rhs-start"), 80);
	}
	
	public WebElement startActivityForTutored_Clickable(){
		return getWhenClickable(By.id("rhs-start"), 120);
	}
	@FindBy(id="submit")
	public WebElement link_submit;
	
	@FindBy(id="nav-group-submit")
	public WebElement link_submitForTutored;
	
	@FindBy(xpath = "//div[text()='Submit Activity for Grading']")
	public WebElement btn_SubmitActivity;
	
	public WebElement getBtn_SubmitActivity() {
		return expWait.getWhenVisible(By.xpath("//div[text()='Submit Activity for Grading']"), 80);
	}
	
	
	@FindBy(id="nav-group-submit")
	public WebElement btn_submitLinkForTutored;
	
	@FindBy(className="closeActivity")
	public WebElement close;

	public WebElement getOverviewGradedOut() {
		return expWait.getWhenVisible(By.xpath("//ul[@id='nav-grouped-items']/li[@class='group' and text()='Overview']"), 80);
	}
}
