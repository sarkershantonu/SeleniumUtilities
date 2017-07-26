package org.automation.httpclient.methods;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.automation.httpclient.HttpRequestDefault;

import java.io.IOException;

/**
 * Created by shantonu on 7/10/17.
 * http client
 */
public class Get extends HttpRequestDefault {
    @Override
    public void perform() {
        client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(getUrl());
        try {
            response = client.execute(httpGet);
            httpResponseCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {

            e.printStackTrace();
        }


    }


}
