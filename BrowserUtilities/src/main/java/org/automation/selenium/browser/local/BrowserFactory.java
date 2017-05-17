package org.automation.selenium.browser.local;


import org.automation.property.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by shantonu on 4/2/16.
 */
public class BrowserFactory {
    private static WebDriver aBrowser;

    private static String nameOfBrowser = getDefaultLocalBrowserName();


    public static WebDriver getABrowser() {
        return getABrowser(nameOfBrowser);
    }



    public static WebDriver getABrowser(String browserName) {
        String os = PropertyUtil.getSysProperty("os.name");
        if ("firefox".equals(browserName)) {
            if (os.contains("windows")) {
                PropertyUtil.setSysProperty("webdriver.firefox.bin", "place where you unzipped firefox executable");
            } else {
                PropertyUtil.setSysProperty("webdriver.firefox.bin", "/home/shantonu/ff46/firefox");
            }
            aBrowser = new FirefoxDriver();
        } else if ("edge".equals(browserName)) {
            aBrowser = new EdgeDriver();
        } else if ("opera".equals(browserName)) {
            aBrowser = new OperaDriver();
        } else if ("ie".equals(browserName)) {
            //File iedriver = new File(getIEPath()); // reading from property //-Dwebdriver.ie.driver=physicall using command line
            File iedriver = new File("Point your Selenium Server exe Path");//todo for your PC
            PropertyUtil.setSysProperty("webdriver.ie.driver", iedriver.getAbsolutePath());

            aBrowser = new InternetExplorerDriver();
        } else if ("chrome".equals(browserName)) {

            String pathWindows = "C:\\Users\\%USERNAME%\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";// can be changed for your PC
            String pathlunix = "/usr/local/bin/chromedriver";
            ChromeDriverService service;
            if (os.contains("windows")) {
                PropertyUtil.setSysProperty("webdriver.chrome.driver", pathWindows);
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(pathlunix))
                        .usingAnyFreePort()
                        .build();
            } else {
                PropertyUtil.setSysProperty("webdriver.chrome.driver", pathlunix);
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(pathlunix))
                        .usingAnyFreePort()
                        .build();
            }
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

        } else if ("safari".equals(browserName)) {
            aBrowser = new SafariDriver();
        } else {
            return getDefaultDriver();
        }

        return aBrowser;
    }



    public static WebDriver getDefaultDriver() {
        return getABrowser("chrome");
    }

    private static String getDefaultLocalBrowserName() {
        try {
            return PropertyUtil.getProperty("browser.properties", "selenium.browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getIEPath() {
        try {
            return PropertyUtil.getProperty("browser.properties", "selenium.browser.ie.path");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static WebDriver getDefaultRemoteDriver() {
        return null;//todo
    }
}
