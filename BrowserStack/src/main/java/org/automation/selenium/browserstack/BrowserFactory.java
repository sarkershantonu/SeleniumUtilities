package org.automation.selenium.browserstack;

import org.automation.property.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by shantonu on 7/28/17.
 * this responsible to initiate browsers
 */
public class BrowserFactory {
    private static Properties prop;
    static {
        try {
            prop = new PropertyUtil("./properties/browserstack").read("browserstack.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static WebDriver driver;
    private static String remoteUrl ="";
    private static String username = prop.getProperty("browserstack.user");
    private static String key=prop.getProperty("browserstack.key");
    private static String server=prop.getProperty("browserstack.server");
    private static String capabilityNodeId = prop.getProperty("browserstack.capability.node");

    public static WebDriver getDriver(){
        if(driver==null) {
            try {
                driver = new RemoteWebDriver(new URL("http://" + username + ":" + key + "@" + server + "/wd/hub"), new BrowserStackCapabilities(capabilityNodeId).getCapabilities());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
