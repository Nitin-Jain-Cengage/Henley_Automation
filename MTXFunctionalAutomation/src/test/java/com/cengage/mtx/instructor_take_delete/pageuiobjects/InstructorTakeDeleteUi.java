package com.cengage.mtx.instructor_take_delete.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cengage.mtx.chemistry.pageuiobjects.BasePage;

/**
 * The Class InstructorTakeDeleteUi.
 */
public class InstructorTakeDeleteUi extends BasePage {
	
	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new instructor take delete ui.
	 *
	 * @param driver the driver
	 */
	public InstructorTakeDeleteUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/** The Drpdwn_product isbn. */
	@FindBy(id="productISBN")
	public WebElement Drpdwn_productIsbn;
	
	/** The lnk_course. */
	@FindBy(xpath = "//*[@id='columnMain']//a")
	public List<WebElement> lnk_course;
	
	/** The lnk_studname. */
	@FindBy(className="studentNameList")
	public List<WebElement> lnk_studname;
	
	/** The lnk_activity score. */
	@FindBy(xpath="//*[@id='student_summary']//a[@class='activity-score' and contains(text(),'%')]")
	public List<WebElement> lnk_activityScore;
	
	/** The lnk_delete. */
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public WebElement lnk_delete;
	
	/** The btn_delete attempt. */
	@FindBy(xpath="//input[@id='attempt_delete']")
	public WebElement btn_deleteAttempt;
	
	/** The close. */
	@FindBy(id="close_progress_detail")
	public WebElement close;
	
	/**
	 * Gets the lnk_ stud roaster_ clickable.
	 *
	 * @return the lnk_ stud roaster_ clickable
	 */
	public WebElement getlnk_StudRoaster_Clickable() {
		return getWhenVisible(By.id("StudentTab"), 80);
	}
	
	/**
	 * Gets the lnk_ delete_ clickable.
	 *
	 * @return the lnk_ delete_ clickable
	 */
	public WebElement getlnk_Delete_Clickable() {
		return getWhenVisible(By.xpath("//a[contains(text(),'Delete')]"), 10);
	}
	
	/**
	 * Gets the txt_get delete take heading.
	 *
	 * @return the txt_get delete take heading
	 */
	public WebElement getTxt_getDeleteTakeHeading(){
		return getWhenVisible(By.xpath("//*[contains(@class,'sub_list_title')]"), 30);		
	}
	
	/**
	 * Gets the txt_ lastelement.
	 *
	 * @param count the count
	 * @return the txt_ lastelement
	 */
	public WebElement getTxt_Lastelement(int count){
		return getWhenVisible(By.xpath("//*[@id='student_summary']/tr["+count+"]"), 30);		
	}
	
	/**
	 * Gets the list_ active course.
	 *
	 * @return the list_ active course
	 */
	public List<WebElement> getList_ActiveCourse(){
		return driver.findElements(By.xpath("//*[@id='student_summary']/tr"));	
		
	}
	
	/**
	 * Gets the lnk_ delete attempt_ clickable.
	 *
	 * @return the lnk_ delete attempt_ clickable
	 */
	public WebElement getlnk_DeleteAttempt_Clickable() {
		return getWhenVisible(By.xpath("//input[@id='attempt_delete']"), 5);
	}
	
	/**
	 * Gets the lnk_ close_ clickable.
	 *
	 * @return the lnk_ close_ clickable
	 */
	public WebElement getlnk_Close_Clickable() {
		return getWhenVisible(By.id("close_progress_detail"), 5);
	}
	
}
