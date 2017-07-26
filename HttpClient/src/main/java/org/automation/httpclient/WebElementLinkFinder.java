package org.automation.httpclient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shantonu on 7/26/17.
 */
public class WebElementLinkFinder {

    private WebDriver browser;
    public WebElementLinkFinder(WebDriver driver){
        this.browser=driver;
    }

    public String getLinkFromElement(WebElement element){
        return element.getAttribute("href");
    }

}
