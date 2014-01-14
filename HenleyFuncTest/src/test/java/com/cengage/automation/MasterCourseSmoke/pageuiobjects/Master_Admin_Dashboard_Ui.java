package com.cengage.automation.MasterCourseSmoke.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cengage.automation.chemistry.pageuiobjects.BasePage;

public class Master_Admin_Dashboard_Ui extends BasePage {
	public Master_Admin_Dashboard_Ui(WebDriver driver) {
		super(driver);
	}

	public WebElement getinput_SearchTextBoxAdminDashboard() {
		return expWait.getWhenVisible(By.id("searchField"), 80);
	}

	public WebElement getlink_isbnBook(String isbnNumber) {
		return expWait.getWhenVisible(By.xpath("//div[contains(text(),'" + isbnNumber + "')]/parent::div/a"), 80);
	}

	public WebElement gettxt_ConeptMap() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Concept Map')]"), 80);
	}

	public WebElement getImg_Assessment() {
		return expWait.getWhenVisible(By.xpath("(//div[@class='list_area']//div[@class='thumbIcon' and @title='Assessment'])[1]"), 80);
	}

	public WebElement getHeading_Unit() {
		return expWait.getWhenVisible(By.xpath("//span[@class='lpn_title' and contains(text(),'Henley Chemistry Digital Course_Do_Not_Edit')]"), 80);
	}

	public List<WebElement> getLink_AllUnitName() {
		return driver.findElements(By.xpath("//*[@class='lpn_name']/a"));
	}

	public List<WebElement> getLink_AllAssessmentName() {
		return driver.findElements(By.xpath("//div[@class='list_area']//div[@class='thumbIcon' and @title='Assessment']/parent::div/following-sibling::div/h3/a"));
	}

	public WebElement get_CourseViewTitleContainer() {
		return expWait.getWhenVisible(By.xpath("//*[@class='lpn_back' and @style='display: block;']"), 80);
	}

	public WebElement getLink_HomeLauncher() {
		return driver.findElement(By.id("nb_lpLauncher"));
	}

	public WebElement getNav_UnitNav() {
		return driver.findElement(By.id("nb_lpNav"));
	}

	public WebElement getbtn_Back() {
		return expWait.getWhenVisible(By.xpath(".//*[@class='lpn_back' and @style='display: block;']/a"), 80);
	}

	public WebElement get_CourseViewTitleContainerDisabled() {
		return expWait.getWhenVisible(By.xpath("//*[@class='lpn_back' and @style='display: none;']"), 80);
	}

	//
	public WebElement getHeading_AssessmentContent() {
		return expWait.getWhenVisible(By.xpath("//div[@id='54_NB_App']//div[@class='nb_actTitle nb_math']"), 80);
	}

	public WebElement getButton_CloseButtonAssessmentContent() {
		return expWait.getWhenVisible(By.xpath("//div[@id='54_NB_App']//a[@class='closeActivity']"), 80);
	}

	public WebElement getButton_Next() {
		return expWait.getWhenVisible(By.xpath("//*[text()='Next']"), 30);
	}

	public WebElement getbtn_startActivity() {
		return expWait.getWhenVisible(By.xpath("//*[contains(text(),'Start Activity')]"), 5);
	}

	public WebElement getbtn_PrintStudy() {
		return expWait.getWhenVisible(By.id("print-button"), 5);
	}
}
