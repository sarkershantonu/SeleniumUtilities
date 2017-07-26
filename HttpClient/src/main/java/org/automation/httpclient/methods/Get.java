package org.automation.httpclient.methods;

import org.apache.http.impl.client.DefaultHttpClient;
import org.automation.httpclient.HttpRequestDefault;

/**
 * Created by shantonu on 7/10/17.
 * http client
 */
public class Get extends HttpRequestDefault {
    @Override
    public void perform() {

        client = new DefaultHttpClient();


    }
}
