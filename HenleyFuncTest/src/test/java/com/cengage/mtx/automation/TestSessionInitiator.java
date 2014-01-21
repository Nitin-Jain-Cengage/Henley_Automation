/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation;

import static com.cengage.mtx.automation.utils.YamlReader.getYamlValue;
import static com.cengage.mtx.automation.utils.YamlReader.getYamlValues;
import static com.cengage.mtx.automation.utils.YamlReader.setYamlFilePath;

import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import com.cengage.mtx.automation.InstructorTakeDelete.Keyword.InstructorTakeDeleteActions;
import com.cengage.mtx.automation.MasterCourseSmoke.Keyword.Master_Admin_Dashboard_Action;
import com.cengage.mtx.automation.MasterCourseSmoke.Keyword.Master_loginPage_Action;
import com.cengage.mtx.automation.chemistry.keywords.*;
import com.cengage.mtx.automation.history.keywords.History_CourseContent_Action;

/**
 * 
 * @author QAIT
 */
public class TestSessionInitiator {
	WebDriver driver;
	public LoginPageActions loginActionsPg;
	public StudentHomePageActions studHomePageActionsPg;
	public WeekWidgetActions weekWidgetActionsPg;
	public DifferentActivitiesActions diffActivitiesActionsPg;
	public StartSubmitLogOutActions startSubmitLogOutActionsPg;
	public History_CourseContent_Action historyCourseContent;
	public Master_loginPage_Action masterLoginPg;
	public Master_Admin_Dashboard_Action adminDashboardPg;
	public InstructorTakeDeleteActions instTakeDeletePg;
	
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	long timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;

	public TestSessionInitiator(String datafileloc) {
		System.out.println(setYamlFilePath(datafileloc));
		_getSessionConfig();
		_configureBrowser();
		_initPage();
	}

	private void _configureBrowser() {
		Map<String, Object> driverConfig = getYamlValues("selenium");
		driver = WebDriverFactory.getDriver(driverConfig);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0, 0));
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(dim);
	}

	private void _getSessionConfig() {
		browser = getYamlValue("selenium.browser");
		seleniumserver = getYamlValue("selenium.server");
		seleniumserverhost = getYamlValue("selenium.remote.host");
		appbaseurl = getYamlValue("baseurl");
		applicationpath = appbaseurl;
		timeout = Integer.parseInt(getYamlValue("selenium.timeout"));
	}

	private void _initPage() {
		loginActionsPg = new LoginPageActions(driver);
		studHomePageActionsPg = new StudentHomePageActions(driver);
		weekWidgetActionsPg = new WeekWidgetActions(driver);
		diffActivitiesActionsPg = new DifferentActivitiesActions(driver);
		startSubmitLogOutActionsPg = new StartSubmitLogOutActions(driver);
		historyCourseContent = new History_CourseContent_Action(driver);
		masterLoginPg = new Master_loginPage_Action(driver);
		adminDashboardPg = new Master_Admin_Dashboard_Action(driver);
		instTakeDeletePg = new InstructorTakeDeleteActions(driver);
	}

	public void launchApplication() {
		System.out.println("The application url is :- " + applicationpath);
		driver.get(applicationpath);
	}

	public void launchUrl(String URL) {
		driver.get(URL);
	}

	public void launchApplicationUrl(String URL) {
		launchUrl(URL);
	}

	public void closeBrowserSession() {
		driver.quit();
	}
	
	 public void takeScreenshotOfFailure(ITestResult result) {
	        Calendar calendar = Calendar.getInstance();
	        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	        String methodName = result.getInstanceName()+"_" + result.getName();
	      if (!result.isSuccess()) {
	         try {
	          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	          FileUtils.copyFile(scrFile, new File("target/failsafe-reports/screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".jpg"));
	          } catch (Exception ex) {
	        	 ex.printStackTrace();
	         }
	        }
	       }
}