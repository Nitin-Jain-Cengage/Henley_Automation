package com.cengage.automation.InstructorTakeDelete.Keyword;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cengage.automation.InstructorTakeDelete.pageuiobjects.InstructorTakeDeleteUi;
import com.cengage.automation.chemistry.keywords.WeekWidgetActions;

public class InstructorTakeDeleteActions extends WeekWidgetActions {

	InstructorTakeDeleteUi instructorTakeDeletePg;
	WebDriver driver;

	public InstructorTakeDeleteActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		instructorTakeDeletePg = new InstructorTakeDeleteUi(driver);
	}

	public void selectProdIsbn(String ProdIsbnName) {
		Select product = new Select(instructorTakeDeletePg.Drpdwn_productIsbn);
		product.selectByVisibleText(ProdIsbnName);
	}

	public void clickOnCourseName(String CourseName, String env) {
		for (WebElement ele : instructorTakeDeletePg.lnk_course) {
			if (ele.getText().equalsIgnoreCase(CourseName)) {
				String attribute = ele.getAttribute("href");
				String[] url = attribute.split("http.*.ng.cengage.com");

				System.out.println(url[1]);

				if (env.equals("qad")) {
					driver.navigate().to("http://qad-ng.cengage.com" + url[1]);
				}

				if (env.equals("qaf")) {
					driver.navigate().to("http://qaf.ng.cengage.com" + url[1]);
				}

				break;
			}
		}
	}

	public void switchToNewWindow() {
		instructorTakeDeletePg.getWindowHandle();
	}

	public void clickOnViewProgressApp() {
		for (int i = 0; i < weekWidgetPge.lbl_appName.size(); i++) {

			if (weekWidgetPge.lbl_appName.get(i).getAttribute("alt")
					.equals("View Progress")) {
				weekWidgetPge.appNameLink.get(i).click();

			}
		}
	}

	public void getVerify(String appName) {
		weekWidgetPge.getHeadingNameOfTheApp(appName);
		Assert.assertTrue(weekWidgetPge.getHeadingNameOfTheApp(appName)
				.isDisplayed());
		weekWidgetPge.getHeadingNameOfTheApp(appName);
	}

	public void clickOnStudentRoasterTab() {
		instructorTakeDeletePg.waitForSyncPage();
		instructorTakeDeletePg.switchToFrame("22_NB_Dock_IFrame");
		instructorTakeDeletePg.getlnk_StudRoaster_Clickable().click();
	}

	public void clickOnStudent(String studName) {
		instructorTakeDeletePg.waitForSyncPage();
		for (WebElement ele1 : instructorTakeDeletePg.lnk_studname) {
			if (ele1.getText().equalsIgnoreCase(studName)) {
				System.out.println("student found");
				ele1.click();
				break;
			}
		}
	}

	public void getListOfActivityScoresAndDelete() {
		List<WebElement> ele2 = instructorTakeDeletePg.lnk_activityScore;
		int count = ele2.size();
		int lasteleNum = instructorTakeDeletePg.getList_ActiveCourse().size();
		instructorTakeDeletePg.getTxt_Lastelement(lasteleNum).isDisplayed();
		System.out.println("lasteleNum : " + lasteleNum);
		int newListElementToClick = 0;
		System.out.println("ele Size : " + ele2.size());
		for (int i = 0; i < count; i++) {
			instructorTakeDeletePg.waitForSyncPage();
			instructorTakeDeletePg.getTxt_Lastelement(lasteleNum).isDisplayed();

			System.out.println(i);
			List<WebElement> ele3 = instructorTakeDeletePg.lnk_activityScore;
			System.out.println("ele3 size" + ele3.size());
			ele3.get(newListElementToClick).click();

			try {
				instructorTakeDeletePg.getTxt_getDeleteTakeHeading()
						.isDisplayed();
				System.out.println(instructorTakeDeletePg
						.getTxt_getDeleteTakeHeading().getText());
				instructorTakeDeletePg.getlnk_Delete_Clickable().click();
				instructorTakeDeletePg.getlnk_DeleteAttempt_Clickable().click();
				instructorTakeDeletePg.getlnk_Close_Clickable().click();
			} catch (Exception ex) {
				newListElementToClick++;
				instructorTakeDeletePg.getTxt_getDeleteTakeHeading()
						.isDisplayed();
				System.out.println(instructorTakeDeletePg
						.getTxt_getDeleteTakeHeading().getText());
				System.out.println("Delete take not avilable");
				instructorTakeDeletePg.getlnk_Close_Clickable().isDisplayed();
				instructorTakeDeletePg.getlnk_Close_Clickable().click();
				continue;
			}

		}
	}
}
