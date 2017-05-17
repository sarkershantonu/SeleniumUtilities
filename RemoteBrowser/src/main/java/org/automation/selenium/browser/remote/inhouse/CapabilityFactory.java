package org.automation.selenium.browser.remote.inhouse;



import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by shantonu on 4/6/16.
 * This class is responsible for getting all capabilities(local + remote)
 * TODO => get all compatibility configuration from property file
 */
public class CapabilityFactory {

    private static DesiredCapabilities capabilities;
    private CapabilityFactory(){}

    /**
     *
     * @param nameOfBrowser
     * @return
     */
    public static DesiredCapabilities getCapability(String nameOfBrowser){
        capabilities = new DesiredCapabilities();

        if(nameOfBrowser=="phantomjs"){
            capabilities = DesiredCapabilities.phantomjs();
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability("takesScreenshot", true);
        }
        else if(nameOfBrowser=="remote-android"){
            capabilities = DesiredCapabilities.android();
        }
        else if(nameOfBrowser=="remote-chrome"){
            capabilities = DesiredCapabilities.chrome();
        }
        else if(nameOfBrowser=="remote-edge"){
            capabilities = DesiredCapabilities.edge();
        }
        else if(nameOfBrowser=="remote-firefox"){
            capabilities = DesiredCapabilities.firefox();

        }
        else if(nameOfBrowser=="remote-htmlunit"){
            capabilities = DesiredCapabilities.htmlUnit();
        }

        else if(nameOfBrowser=="remote-ie"){
            capabilities = DesiredCapabilities.internetExplorer();
        }
        else if(nameOfBrowser=="remote-ipad"){
            capabilities = DesiredCapabilities.ipad();
        }
        else if(nameOfBrowser=="remote-iphone"){
            capabilities = DesiredCapabilities.iphone();
        }
        else if(nameOfBrowser=="remote-opera"){
            capabilities = DesiredCapabilities.operaBlink();

        }
        else if(nameOfBrowser=="remote-phantomjs"){
            capabilities = DesiredCapabilities.phantomjs();
        }
        else if(nameOfBrowser=="remote-safari") {
            capabilities = DesiredCapabilities.safari();
        }
        else{
            //todo default common capabilities will be here
        }


        return capabilities;
    }

    /**
     * Using firefox manager, this will manage secure site capabilities, supporting managed cache, cookie, custom herder etc
     * @return
     */
    public static DesiredCapabilities getCapabilityWithSecurity(){

        return capabilities;
    }

    /**
     * Big todo for inhouse capability entries
     * will be reading from property , and node wise config
     * @return
     */
    public static DesiredCapabilities getInhouseCapabilities(String config){
        return capabilities;
    }

    public static DesiredCapabilities getDefault(){
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setBrowserName("chrome");
        chrome.setPlatform(Platform.ANY);
        chrome.setVersion("ANY");
        return chrome;
    }
}
