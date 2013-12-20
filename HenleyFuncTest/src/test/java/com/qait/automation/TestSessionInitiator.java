/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation;

import static com.qait.automation.utils.YamlReader.getYamlValue;
import static com.qait.automation.utils.YamlReader.getYamlValues;
import static com.qait.automation.utils.YamlReader.setYamlFilePath;

import java.awt.Toolkit;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qait.automation.utils.YamlReader;
import com.qait.launchpad.automation.keywords.LoginPageActions;
import com.qait.launchpad.automation.keywords.StudentDashboardAction;

/**
 *
 * @author prashantshukla
 */
public class TestSessionInitiator {

    WebDriver driver;
    public StudentDashboardAction pageAction;
    String browser;
    String seleniumserver;
    String seleniumserverhost;
    String appbaseurl;
    String applicationpath;
    String chromedriverpath;
    long timeout;
    Map<String, Object> chromeOptions = null;
    DesiredCapabilities capabilities;

    public TestSessionInitiator() {
        this(YamlReader.yamlFilePath);
    }

    public TestSessionInitiator(String datafileloc) {
        setYamlFilePath(datafileloc);
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
        pageAction = new StudentDashboardAction(driver);
    }

    public void launchApplication() {
        System.out.println("the aplication url is :- " + applicationpath);
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
}