/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.automation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating WebDriver objects.
 */
@SuppressWarnings("unchecked")
public class WebDriverFactory {
	
	/** The browser. */
	private static String browser;
	
	/** The capabilities. */
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	/**
	 * Gets the driver.
	 *
	 * @param seleniumconfig the seleniumconfig
	 * @return the driver
	 */
	public static WebDriver getDriver(Map<String, Object> seleniumconfig) {
		seleniumconfig = (Map<String, Object>) seleniumconfig.get("selenium");
		browser = seleniumconfig.get("browser").toString();
		if (seleniumconfig.get("server").toString().equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				return createFirefoxDriver(getFirefoxProfile());
			} else if (browser.equalsIgnoreCase("chrome")) {
				return setChromeDriver(seleniumconfig.get("driverpath").toString());
			} else if (browser.equalsIgnoreCase("Safari")) {
				return setSafariDriver();
			} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer")) || (browser.equalsIgnoreCase("internet explorer"))) {
				return setInternetExplorerDriver(seleniumconfig.get("driverpath").toString());
			}
		}
		if (seleniumconfig.get("server").toString().equalsIgnoreCase("remote")) {
			return setRemoteDriver(seleniumconfig);
		}
		return new FirefoxDriver();
	}

	/**
	 * Sets the remote driver.
	 *
	 * @param selConfig the sel config
	 * @return the web driver
	 */
	private static WebDriver setRemoteDriver(Map<String, Object> selConfig) {
		DesiredCapabilities cap = null;
		browser = selConfig.get("browser").toString();
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer")) || (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
		}
		String seleniumserveraddress = selConfig.get("remote.host").toString();
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniumserveraddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, capabilities);
	}

	/**
	 * Sets the chrome driver.
	 *
	 * @param driverpath the driverpath
	 * @return the web driver
	 */
	private static WebDriver setChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
		capabilities.setJavascriptEnabled(true);
		return new ChromeDriver();
	}

	/**
	 * Sets the internet explorer driver.
	 *
	 * @param driverpath the driverpath
	 * @return the web driver
	 */
	private static WebDriver setInternetExplorerDriver(String driverpath) {
		System.setProperty("webdriver.ie.driver", driverpath);
		return new InternetExplorerDriver();
	}

	/**
	 * Sets the safari driver.
	 *
	 * @return the web driver
	 */
	private static WebDriver setSafariDriver() {
		return new SafariDriver();
	}

	/**
	 * Creates a new WebDriver object.
	 *
	 * @param firefoxProfile the firefox profile
	 * @return the web driver
	 */
	private static WebDriver createFirefoxDriver(FirefoxProfile firefoxProfile) {
		return new FirefoxDriver(firefoxProfile);
	}

	/**
	 * Gets the firefox profile.
	 *
	 * @return the firefox profile
	 */
	private static FirefoxProfile getFirefoxProfile() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		try {
			firefoxProfile.addExtension(new File("./src/test/resources/firebug.extension/firebug-1.12.5-fx.xpi"));
			firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.12.5");
			firefoxProfile.setPreference("extensions.firebug.script.enableSites", true);
			firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
			firefoxProfile.setPreference("extensions.firebug.allPagesActivation", true);
			firefoxProfile.setPreference("extensions.firebug.delayLoad", false);
			firefoxProfile.addExtension(new File("./src/test/resources/firebug.extension/firepath-0.9.7-fx.xpi"));
		} catch (IOException e) {
			e.printStackTrace();
			Logger.getLogger(WebDriverFactory.class.getName()).log(Level.SEVERE, null, e);
		}
		return firefoxProfile;
	}
}