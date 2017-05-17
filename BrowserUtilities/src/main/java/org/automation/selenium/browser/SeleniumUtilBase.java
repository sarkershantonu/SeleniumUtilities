package org.automation.selenium.browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;

/**
 * Created by shantonu on 5/17/17.
 */
public abstract class SeleniumUtilBase {
    protected WebDriver driver;
    protected JavascriptExecutor executor;

    public SeleniumUtilBase(WebDriver aDriver) {
        this.driver = aDriver;
        executor =(JavascriptExecutor) this.driver;
    }


    private SeleniumUtilBase() {

    }


    public InputStream getResourceAsStream(String resource) {
        return this.getClass().getResourceAsStream(resource);
    }
}
