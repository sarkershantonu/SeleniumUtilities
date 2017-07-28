package org.automation.selenium.browserstack;

import org.automation.property.PropertyUtil;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

/**
 * Created by shantonu on 4/7/16.
 * this class is responsible for all browser stack configuration based capabilities
 */
public class BrowserStackCapabilities {

    /**
     * @param capabilities => will get to set the value
     * @param config       format => osName.browsername.resolution
     *                     No dot for versions, dot reserverd as seperator
     *                     COnfig sample => https://www.browserstack.com/automate/java
     * @return => returned what changed.
     * Sample 3 configuration given
     * todo => add as much capability as you can from https://www.browserstack.com/start
     */
    public static DesiredCapabilities getCapabilities(DesiredCapabilities capabilities, String config) {

        if (config == "win7.ie8.1024x768") {
            capabilities.setCapability("browser", "IE");
            capabilities.setCapability("browser_version", "8.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "7");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win7.ff41.1024x768") {
            capabilities.setCapability("browser", "Firefox");
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability("browser_version", "41.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "7");
            setCommon(capabilities, "pc");
        } else if (config == "win10.edge.1024x768") {
            capabilities.setCapability("browser", "Edge");
            capabilities.setCapability("browser_version", "13.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "10");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win10.ie11.1024x768") {
            capabilities.setCapability("browser", "IE");
            capabilities.setCapability("browser_version", "11.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "10");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win10.ff45.1024x768") {
            capabilities.setCapability("browser", "Firefox");
            capabilities.setCapability("browser_version", "45.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "10");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win10.gc49.1024x768") {
            capabilities.setCapability("browser", "Chrome");
            capabilities.setCapability("browser_version", "49.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "10");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win81.ie11.1024x768") {
            capabilities.setCapability("browser", "IE");
            capabilities.setCapability("browser_version", "11.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8.1");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win81.ff45.1024x768") {
            capabilities.setCapability("browser", "Firefox");
            capabilities.setCapability("browser_version", "45.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8.1");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win81.gc49.1024x768") {
            capabilities.setCapability("browser", "Chrome");
            capabilities.setCapability("browser_version", "49.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8.1");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win81.opera1216.1024x768") {
            capabilities.setCapability("browser", "Opera");
            capabilities.setCapability("browser_version", "12.16");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8.1");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win8.ie10.1024x768") {
            capabilities.setCapability("browser", "IE");
            capabilities.setCapability("browser_version", "10.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win8.ff45.1024x768") {
            capabilities.setCapability("browser", "Firefox");
            capabilities.setCapability("browser_version", "45.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win8.gc49.1024x768") {
            capabilities.setCapability("browser", "Chrome");
            capabilities.setCapability("browser_version", "49.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win8.opera1216.1024x768") {
            capabilities.setCapability("browser", "Opera");
            capabilities.setCapability("browser_version", "12.16");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "8");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win7.ie8.1024x768") {
            capabilities.setCapability("browser", "IE");
            capabilities.setCapability("browser_version", "8.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "7");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win7.ff45.1024x768") {
            capabilities.setCapability("browser", "Firefox");
            capabilities.setCapability("browser_version", "45.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "7");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win7.gc49.1024x768") {
            capabilities.setCapability("browser", "Chrome");
            capabilities.setCapability("browser_version", "49.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "7");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "win7.opera1216.1024x768") {
            capabilities.setCapability("browser", "Opera");
            capabilities.setCapability("browser_version", "12.16");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "7");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "wixp.ie6.1024x768") {
            capabilities.setCapability("browser", "IE");
            capabilities.setCapability("browser_version", "6.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "XP");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "winxp.ff45.1024x768") {
            capabilities.setCapability("browser", "Firefox");
            capabilities.setCapability("browser_version", "45.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "XP");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "winxp.gc49.1024x768") {
            capabilities.setCapability("browser", "Chrome");
            capabilities.setCapability("browser_version", "49.0");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "XP");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "winxp.opera1216.1024x768") {
            capabilities.setCapability("browser", "Opera");
            capabilities.setCapability("browser_version", "12.16");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "XP");
            capabilities.setCapability("resolution", "1024x768");
            setCommon(capabilities, "pc");
        } else if (config == "iphone6.iphone.mobile") {
            capabilities.setCapability("browserName", "iPhone");
            capabilities.setPlatform(Platform.MAC);
            capabilities.setCapability("device", "iPhone 6");
            setCommon(capabilities, "iphone");
        }
        // // TODO: add more
        return capabilities;
    }

    /**
     * to minimize duplication of capability setting, use commonly used capbility settings for different divices
     *
     * @param capabilities
     * @param deviceType   => pc/mac browser, iphone-android browser, tab browser , will increase based on compatibility
     * @return
     */
    private static DesiredCapabilities setCommon(DesiredCapabilities capabilities, String deviceType) {
        if (deviceType == "mobile") {

        } else if (deviceType == "pc") {
            capabilities.setCapability("browserstack.debug", "true");

        } else if (deviceType == "tab") {

        } else if (deviceType == "mac") {

        } else if (deviceType == "android") {

        } else if (deviceType == "iphone") {

        } else if (deviceType == "ipad") {

        }
        return capabilities;
    }
}
