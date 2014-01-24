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
 * The Class TestSessionInitiator.
 */
public class TestSessionInitiator {
	
	/** The driver. */
	WebDriver driver;
	
	/** The login actions pg. */
	public LoginPageActions loginActionsPg;
	
	/** The stud home page actions pg. */
	public StudentHomePageActions studHomePageActionsPg;
	
	/** The week widget actions pg. */
	public WeekWidgetActions weekWidgetActionsPg;
	
	/** The diff activities actions pg. */
	public DifferentActivitiesActions diffActivitiesActionsPg;
	
	/** The start submit log out actions pg. */
	public StartSubmitLogOutActions startSubmitLogOutActionsPg;
	
	/** The history course content. */
	public History_CourseContent_Action historyCourseContent;
	
	/** The master login pg. */
	public Master_loginPage_Action masterLoginPg;
	
	/** The admin dashboard pg. */
	public Master_Admin_Dashboard_Action adminDashboardPg;
	
	/** The inst take delete pg. */
	public InstructorTakeDeleteActions instTakeDeletePg;
	
	/** The browser. */
	String browser;
	
	/** The seleniumserver. */
	String seleniumserver;
	
	/** The seleniumserverhost. */
	String seleniumserverhost;
	
	/** The appbaseurl. */
	String appbaseurl;
	
	/** The applicationpath. */
	String applicationpath;
	
	/** The chromedriverpath. */
	String chromedriverpath;
	
	/** The timeout. */
	long timeout;
	
	/** The chrome options. */
	Map<String, Object> chromeOptions = null;
	
	/** The capabilities. */
	DesiredCapabilities capabilities;

	/**
	 * Instantiates a new test session initiator.
	 *
	 * @param datafilelocator the datafilelocator
	 */
	public TestSessionInitiator(String datafilelocator) {
		System.out.println(setYamlFilePath(datafilelocator));
		_getSessionConfig();
		_configureBrowser();
		_initPage();
	}

	/**
	 * _configure browser.
	 */
	private void _configureBrowser() {
		Map<String, Object> driverConfig = getYamlValues("selenium");
		driver = WebDriverFactory.getDriver(driverConfig);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0, 0));
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(dim);
	}

	/**
	 * _get session config.
	 */
	private void _getSessionConfig() {
		browser = getYamlValue("selenium.browser");
		seleniumserver = getYamlValue("selenium.server");
		seleniumserverhost = getYamlValue("selenium.remote.host");
		appbaseurl = getYamlValue("baseurl");
		applicationpath = appbaseurl;
		timeout = Integer.parseInt(getYamlValue("selenium.timeout"));
	}

	/**
	 * _init page.
	 */
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

	/**
	 * Launch application.
	 */
	public void launchApplication() {
		System.out.println("The application url is :- " + applicationpath);
		driver.get(applicationpath);
	}

	/**
	 * Launch url.
	 *
	 * @param URL the url
	 */
	public void launchUrl(String URL) {
		driver.get(URL);
	}

	/**
	 * Launch application url.
	 *
	 * @param URL the url
	 */
	public void launchApplicationUrl(String URL) {
		launchUrl(URL);
	}

	/**
	 * Close browser session.
	 */
	public void closeBrowserSession() {
		driver.quit();
	}
	
	 /**
 	 * Take screenshot of failure.
 	 *
 	 * @param result the result
 	 */
 	public void takeScreenshotOfFailure(ITestResult result) {
	        Calendar calendar = Calendar.getInstance();
	        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	        String methodName = result.getName();
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