package org.automation.selenium.browser.remote;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.automation.selenium.browser.CapabilityFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shantonu on 1/7/17.
 */
public class RemoteBrowserFactory {
    private static RemoteWebDriver aRemoteBrowser;

    //todo => desire capability property reading for name of browser
    private static DesiredCapabilities capabilities = null;

    private static String internalRemoteDriverConfig = "node1.firefox.1920x1080";



    // todo this two should be replace by enum
    public static RemoteWebDriver getARemoteBrowser(String provider, String browserCapability) {

        if (provider == "browserstack") {
            try {
                // todo , get this capability config from property
                return new RemoteWebDriver(new URL(RemoteConfig.browserstack_URL), CapabilityFactory.getCapability(browserCapability));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (provider == "soucelab") {

            try {
                return new RemoteWebDriver(new URL(RemoteConfig.saucelabs_URL), CapabilityFactory.getCapability(browserCapability));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (provider == "appium-ios") {
            try {
                return new IOSDriver(new URL(RemoteConfig.appium_URL), CapabilityFactory.getCapability(browserCapability));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (provider == "appium-android") {
            try {
                return  new AndroidDriver(new URL(RemoteConfig.appium_URL), CapabilityFactory.getCapability(browserCapability));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return aRemoteBrowser;
    }
    //todo
    public static RemoteWebDriver getARemoteBrowser(String provider, DesiredCapabilities capabilities){
        return  aRemoteBrowser;
    }
    public static RemoteWebDriver getDefaultRemoteDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL(RemoteConfig.inhouse_hubUrl), CapabilityFactory.getDefault());
    }
}
