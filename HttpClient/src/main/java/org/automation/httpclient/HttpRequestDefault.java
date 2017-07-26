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
public abstract class HttpRequestDefault implements Runnable{

    public HttpRequestDefault(String url){
        this.url=url;
    }
    private String baseUrl;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String path="/";
    private String url;
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    protected String encoding;
    protected long timeout_connection = 3000;
    protected long timeout_response = 3000;
    protected boolean isFollowRedirection = false;

    protected HttpClient client;
    protected HttpResponse response;

    protected HttpEntity entity;

    public abstract int perform();


    protected WebDriver driver;

    protected void iniBrowser(){
        driver.manage().window().maximize();

    }
    protected String getUrl() {

        return(url==null)?baseUrl+path:url;
    }
    protected String getContent() throws IOException {
        return EntityUtils.toString(entity);
    }
    protected int getStatusCode(){
        return response.getStatusLine().getStatusCode();
    }
}
