package org.automation.httpclient;

import org.automation.httpclient.methods.Get;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shantonu on 7/26/17.
 */
public class TestHttpClient {
    private HttpRequestDefault arequest;
    WebDriver browser;
    ExecutorService service;

    @Before
    public void initTest(){
        service = Executors.newFixedThreadPool(20);
        System.setProperty("webdriver.chrome.driver","/home/shantonu/selenium/chromedriver");
        browser = new ChromeDriver();
    }
    @After
    public void exit(){
        browser.close();
    }
    @Test
    public void testSingleGet(){
        arequest = new Get("https://demo.opencart.com");
        arequest.perform();
    }
    @Test
    public void testMultiThreadedGet(){
        WebElementLinkFinder linkFinder = new WebElementLinkFinder(browser);
        List<String> links = linkFinder.getLinksFromAPage("https://demo.opencart.com");
        for (String url : links){
            service.execute(new Get(url));
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }


    }
}
