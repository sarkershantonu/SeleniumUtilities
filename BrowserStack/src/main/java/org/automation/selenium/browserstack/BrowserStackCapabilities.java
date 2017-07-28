package org.automation.selenium.browserstack;

import org.automation.property.PropertyUtil;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by shantonu on 4/7/16.
 * this class is responsible for all browser stack configuration based capabilities
 */
public class BrowserStackCapabilities {
    private static Properties prop;

    static {
        try {
            prop = new PropertyUtil("./properties/browserstack").read("browserstack-node.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BrowserStackCapabilities() {
    }

    private DesiredCapabilities capabilities;
    private String node;

    public BrowserStackCapabilities(String nodeid) {
        this.node = nodeid;
    }

    public DesiredCapabilities getCapabilities() {
        capabilities = new DesiredCapabilities();

        if (prop.getProperty(node + ".platform").equals("tab")) {
            capabilities = settingCapabilitiesFortab(capabilities);
        } else if (prop.getProperty(node + ".platform").equals("mobile")) {
            capabilities = settingCapabilitiesFormobile(capabilities);
        } else if (prop.getProperty(node + ".platform").equals("pc")) {
            capabilities = settingCapabilitiesForPC(capabilities);
        } else {
            capabilities = settingCapabilitiesForHeadless(capabilities);
        }

        //you need to handle spacial cases
        if (prop.getProperty(node + ".os").equals("iphone")) {
            capabilities.setPlatform(Platform.MAC);
        }
        return capabilities;
    }

    //todo
    private DesiredCapabilities settingCapabilitiesForHeadless(DesiredCapabilities cap) {
        return cap;
    }

    //todo
    private DesiredCapabilities settingCapabilitiesFortab(DesiredCapabilities cap) {
        return cap;
    }

    //todo
    private DesiredCapabilities settingCapabilitiesFormobile(DesiredCapabilities cap) {
        return cap;
    }

    private DesiredCapabilities settingCapabilitiesForPC(DesiredCapabilities cap) {
        cap.setCapability("browser", prop.getProperty(node + ".browser"));
        cap.setCapability("browser_version", prop.getProperty(node + ".browser.version"));
        cap.setCapability("os", prop.getProperty(node + ".os"));
        cap.setCapability("os_version", prop.getProperty(node + ".os.version"));
        cap.setCapability("resolution", prop.getProperty(node + ".browser.resolution"));
        cap.setAcceptInsecureCerts(true);
        cap.setJavascriptEnabled(true);
        capabilities.setCapability("browserstack.debug", "true");
        return cap;
    }

}
