package org.automation.httpclient.methods;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.automation.httpclient.HttpRequestDefault;

import java.io.IOException;

/**
 * Created by shantonu on 7/10/17.
 */
public class Post extends HttpRequestDefault {
    public Post(String url) {
        super(url);
    }

    @Override
    public void run() {
        perform();
    }

    @Override
    public int perform() {
        client = new DefaultHttpClient();
        HttpPost post = new HttpPost(getUrl());

        

        try {
            System.out.println(getUrl());
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(getStatusCode()!=200){
            System.out.println("ERROR = "+ getStatusCode());
        }

        return 0;
    }
}
