package org.automation.httpclient;

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


}
