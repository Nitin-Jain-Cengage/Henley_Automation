package com.qait.launchpad.automation.pageuiobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeekWidgetUi extends BasePage{

	public WeekWidgetUi(WebDriver driver) 
	{
		super(driver);
	}
			
	@FindBy(xpath=".//*[@class[contains(.,'dash-middle')]]")
	private WebElement currentVisibleWeek; 
	
	@FindBy(xpath=".//*[@class[contains(.,'dash-middle')]]/h2")
	public WebElement getCurrentVisibleWeekValue;
	
	@FindBy(id="prevWeek")
	public WebElement previousWeekArrow;
	
	@FindBy(id="nextWeek")
	public WebElement nextWeekArrow;
	
	@FindBy(xpath=".//div[contains(@class,'week')]")
	public List<WebElement> totalNoOfWeeks;
	
	@FindBy(className="sliderDivider")
	public List<WebElement> NoOfWeeksOnSlider;
	
	@FindBy(id="conceptMapBtn")
	public WebElement btn_conceptMap;
}
