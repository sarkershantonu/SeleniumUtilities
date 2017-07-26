package org.automation.httpclient.methods;

import org.apache.http.HttpResponse;
import org.apache.http.annotation.ThreadingBehavior;
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


    public Get(String url) {
        super(url);
    }

    @Override
    public int perform() {
        client = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(getUrl());
        try {
            System.out.println(getUrl());
            response = client.execute(httpGet);
            //System.out.println(Thread.activeCount());

        } catch (IOException e) {

            e.printStackTrace();
        }

        if(getStatusCode()!=200){
            System.out.println("ERROR = "+ getStatusCode());
        }

        return getStatusCode();
    }

    @Override
    public void run() {
        perform();

    }
}
