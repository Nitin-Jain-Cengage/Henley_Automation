package com.cengage.automation.InstructorTakeDelete.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cengage.automation.chemistry.pageuiobjects.BasePage;

public class InstructorTakeDeleteUi extends BasePage {
	
	WebDriver driver;

	public InstructorTakeDeleteUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(id="productISBN")
	public WebElement Drpdwn_productIsbn;
	@FindBy(xpath = "//*[@id='columnMain']//a")
	public List<WebElement> lnk_course;
	@FindBy(className="studentNameList")
	public List<WebElement> lnk_studname;
	@FindBy(xpath="//*[@id='student_summary']//a[@class='activity-score' and contains(text(),'%')]")
	public List<WebElement> lnk_activityScore;
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public WebElement lnk_delete;
	@FindBy(xpath="//input[@id='attempt_delete']")
	public WebElement btn_deleteAttempt;
	@FindBy(id="close_progress_detail")
	public WebElement close;
	
	public WebElement getlnk_StudRoaster_Clickable() {
		return getWhenVisible(By.id("StudentTab"), 80);
	}
	
	public WebElement getlnk_Delete_Clickable() {
		return getWhenVisible(By.xpath("//a[contains(text(),'Delete')]"), 10);
	}
	
	public WebElement getTxt_getDeleteTakeHeading(){
		return getWhenVisible(By.xpath("//*[contains(@class,'sub_list_title')]"), 30);		
	}
	
	public WebElement getTxt_Lastelement(int count){
		return getWhenVisible(By.xpath("//*[@id='student_summary']/tr["+count+"]"), 30);		
	}
	
	public List<WebElement> getList_ActiveCourse(){
		return driver.findElements(By.xpath("//*[@id='student_summary']/tr"));	
		
	}
	
	public WebElement getlnk_DeleteAttempt_Clickable() {
		return getWhenVisible(By.xpath("//input[@id='attempt_delete']"), 5);
	}
	
	public WebElement getlnk_Close_Clickable() {
		return getWhenVisible(By.id("close_progress_detail"), 5);
	}
	
}
