package org.automation.selenium.browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by shantonu on 5/17/17.
 */
public abstract class SeleniumUtilBase {
    protected WebDriver driver;
    protected JavascriptExecutor jsRunner;

    public SeleniumUtilBase(WebDriver aDriver) {
        this.driver = aDriver;
    }


    private SeleniumUtilBase() {

    }


}
