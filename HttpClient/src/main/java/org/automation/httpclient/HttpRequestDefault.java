package org.automation.httpclient;

import org.apache.http.client.HttpClient;
import org.openqa.selenium.WebDriver;

/**
 * Created by shantonu on 7/10/17.
 */
public abstract class HttpRequestDefault {

    protected String host;
    protected String port;
    protected boolean isHttps;
    protected String path;
    protected String encoding;
    protected long timeout_connection = 3000;
    protected long timeout_response = 3000;
    protected boolean isFollowRedirection = false;

    protected HttpClient client;
    public abstract void perform();

    protected WebDriver driver;

    protected void iniBrowser(){
        driver.manage().window().maximize();

    }
    protected String getUrl() {
        String protocol = (isHttps)?"https":"http";
        return protocol+"://"+host+":"+port+path;
    }
}
