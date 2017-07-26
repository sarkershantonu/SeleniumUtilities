package org.automation.selenium.element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shantonu on 7/26/17.
 */
public class WebElementLinkFinder {

    private WebDriver browser;
    private WebElementLinkFinder(){}
    public WebElementLinkFinder(WebDriver driver){
        this.browser=driver;
    }

    public String getLinkFromElement(WebElement element){
        return element.getAttribute("href");
    }
    public List<String> getLinksFromAPage(String link){
        browser.navigate().to(link);
        List<WebElement> elementList = browser.findElements(By.xpath(".//a[@href!='']"));
        List<String> links = new ArrayList<>();
        for (WebElement element : elementList){
           links.add(getLinkFromElement(element));
        }
        return links;
    }

}
