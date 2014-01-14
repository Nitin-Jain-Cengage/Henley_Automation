package com.cengage.mtx.automation.history.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.mtx.automation.chemistry.pageuiobjects.BasePage;

/**
 * @param args
 */
public class History_CourseContent_Ui extends BasePage {
	
	

	public History_CourseContent_Ui(WebDriver driver) {
		super(driver);		
	}

	public List<WebElement> get_ActivityNameFromList() {		
		return driver.findElements(By.xpath("//div[@class='week dash-middle']//li[contains(@class,'assignment')]"));
	}
	
	public WebElement getbtn_startActivity() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Start Activity')]"), 80);
	}
	
	public WebElement getbtn_showSubmitActivityButton() {
		return expWait.getWhenVisible(By.xpath("//button[@data-ng-show='showSubmitActivityButton']"), 10);
	}
	
	public WebElement getActivityHeading() {
		return expWait.getWhenVisible(By.xpath("//div[@class='nb_titles']/div"), 80);
	}
	
	public WebElement getbtn_PrintStudy() {
		return expWait.getWhenVisible(By.id("print-button"), 80);
	}
	
	public WebElement getbtn_closeActivity() {
		return expWait.getWhenVisible(By.className("closeActivity"), 80);
	}
	
	public WebElement getFrame_Content(){
		return expWait.getWhenVisible(By.xpath("//*[contains(@id,'_NB_Main_IFrame')]"), 80);		
	}
	
	public WebElement getbtn_showSubmitActivityButtonState() {
		return driver.findElement(By.xpath("//button[@data-ng-show='showSubmitActivityButton']/parent::div"));
	}
	
	public WebElement getBtn_SubmitActivity() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Submit Activity for Grading')]"), 80);
	}
	
	public WebElement btn_conceptMap(){
		return expWait.getWhenVisible(By.id("conceptMapBtn"), 80);
	}
	
	
	public WebElement getbtn_NextButton() {
		return expWait.getWhenVisible(By.xpath("//button[contains(text(),'Next') and @style='']"), 80);
	}
	
	public List<WebElement> getBtn_AllNextButton(){
		return driver.findElements(By.xpath("//button[@type='button' and contains(text(),'Next')]"));
	}
	
	
	
	//div[@class='week dash-middle']//li[contains(@class,'assignment')]
}
