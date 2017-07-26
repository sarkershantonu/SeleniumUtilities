package org.automation.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

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
    protected HttpResponse response;
    protected int httpResponseCode;
    protected HttpEntity entity;

    public abstract void perform();

    protected WebDriver driver;

    protected void iniBrowser(){
        driver.manage().window().maximize();

    }
    protected String getUrl() {
        String protocol = (isHttps)?"https":"http";
        return protocol+"://"+host+":"+port+path;
    }
    protected String getContent() throws IOException {
        return EntityUtils.toString(entity);
    }
    protected int getStatusCode(){
        return response.getStatusLine().getStatusCode();
    }
}
