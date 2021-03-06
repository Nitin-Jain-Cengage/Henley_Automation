package com.cengage.mtx.instructor_take_delete.keyword;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.cengage.mtx.chemistry.keywords.WeekWidgetActions;
import com.cengage.mtx.instructor_take_delete.pageuiobjects.InstructorTakeDeleteUi;

/**
 * The Class InstructorTakeDeleteActions.
 */
public class InstructorTakeDeleteActions extends WeekWidgetActions {

	/** The instructor take delete pg. */
	InstructorTakeDeleteUi instructorTakeDeletePg;
	
	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new instructor take delete actions.
	 *
	 * @param driver the driver
	 */
	public InstructorTakeDeleteActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		instructorTakeDeletePg = new InstructorTakeDeleteUi(driver);
	}

	/**
	 * Select prod isbn.
	 *
	 * @param ProdIsbnName the prod isbn name
	 */
	public void selectProdIsbn(String ProdIsbnName) {
		Select product = new Select(instructorTakeDeletePg.Drpdwn_productIsbn);
		product.selectByVisibleText(ProdIsbnName);
	}

	/**
	 * Click on course name.
	 *
	 * @param CourseName the course name
	 * @param env the env
	 */
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

	// /*
	// * (non-Javadoc)
	// *
	// * @see com.cengage.mtx.automation.chemistry.keywords.WeekWidgetActions#
	// * switchToNewWindow()
	// */
	// public void switchToNewWindow() {
	// instructorTakeDeletePg.getWindowHandle();
	// }
	/**
	 * Click on view progress app.
	 */
	public void clickOnViewProgressApp() {
		weekWidgetPge.getLink_AllScore().isDisplayed();
		weekWidgetPge.checkWeekSliderSpinnerToDisappear();
		weekWidgetPge
				.executeJs("document.getElementById('dockGroup1').childNodes[3].childNodes[0].click();");
		weekWidgetPge.waitForSyncPage();
		// for (int i = 0; i < weekWidgetPge.lbl_appName.size(); i++) {
		// if
		// (weekWidgetPge.lbl_appName.get(i).getAttribute("alt").equals("View Progress"))
		// {
		// weekWidgetPge.appNameLink.get(i).click();
		// }
		// }
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.cengage.mtx.automation.chemistry.keywords.WeekWidgetActions#getVerify
	// * (java.lang.String)
	// */
	// public void getVerify(String appName) {
	// weekWidgetPge.getHeadingNameOfTheApp(appName);
	// Assert.assertTrue(weekWidgetPge.getHeadingNameOfTheApp(appName).isDisplayed());
	// weekWidgetPge.getHeadingNameOfTheApp(appName);
	// }
	/**
	 * Click on student roaster tab.
	 */
	public void clickOnStudentRoasterTab() {
		instructorTakeDeletePg.waitForSyncPage();
		instructorTakeDeletePg.switchToFrame("22_NB_Dock_IFrame");
		instructorTakeDeletePg.getlnk_StudRoaster_Clickable().click();
	}

	/**
	 * Click on student.
	 *
	 * @param studentName the student name
	 */
	public void clickOnStudent(String studentName) {
		instructorTakeDeletePg.waitForSyncPage();
		for (WebElement ele1 : instructorTakeDeletePg.lnk_studname) {
			if (ele1.getText().equalsIgnoreCase(studentName)) {
				System.out.println("student found");
				ele1.click();
				break;
			}
		}
	}

	/**
	 * Gets the list of activity scores and delete.
	 *
	 * @return the list of activity scores and delete
	 */
	public void getListOfActivityScoresAndDelete() {
		List<WebElement> ele2 = instructorTakeDeletePg.getList_ActiveScore();
		int count = ele2.size();
		int lasteleNum = instructorTakeDeletePg.getList_ActiveCourse().size();
		instructorTakeDeletePg.getTxt_Lastelement(lasteleNum).isDisplayed();
		int newListElementToClick = 0;
		System.out.println("ele Size : " + ele2.size());
		String deletedCourseName = null;
		for (int i = 0; i < count; i++) {
			instructorTakeDeletePg.waitForSyncPage();
			instructorTakeDeletePg.getTxt_Lastelement(lasteleNum).isDisplayed();
			weekWidgetPge.checkWeekSliderSpinnerToDisappear();
			List<WebElement> ele3 = instructorTakeDeletePg
					.getList_ActiveScore();
			ele3.get(newListElementToClick).click();
			try {
				instructorTakeDeletePg.getTxt_getDeleteTakeHeading()
						.isDisplayed();
				String CourseName = instructorTakeDeletePg
						.getTxt_getDeleteTakeHeading().getText();
				instructorTakeDeletePg.getlnk_Delete_Clickable().click();
				instructorTakeDeletePg.getlnk_DeleteAttempt_Clickable().click();
				instructorTakeDeletePg.waitForSyncPage();
				instructorTakeDeletePg.getlnk_Close_Clickable().click();
				System.out.println(CourseName
						+ ": Take Delete Success -------------");
				Reporter.log("Course : '" + CourseName
						+ "' : Take Delete Success");
				deletedCourseName = CourseName;
			} catch (Exception ex) {
				instructorTakeDeletePg.getTxt_getDeleteTakeHeading()
						.isDisplayed();
				String CourseNameNotDelete = instructorTakeDeletePg
						.getTxt_getDeleteTakeHeading().getText();
				if (!CourseNameNotDelete.equalsIgnoreCase(deletedCourseName)) {
					newListElementToClick++;
				}
				System.out.println("After newListElementToClick: "
						+ newListElementToClick);
				instructorTakeDeletePg.getlnk_Close_Clickable().isDisplayed();
				instructorTakeDeletePg.waitForSyncPage();
				instructorTakeDeletePg.getlnk_Close_Clickable().click();
				System.out.println(CourseNameNotDelete
						+ " : Delete take not avilable ******");
				Reporter.log("Course : '" + CourseNameNotDelete
						+ "' : Delete take not avilable ******");
				continue;
			}
			ele3.clear();
		}
	}
}
