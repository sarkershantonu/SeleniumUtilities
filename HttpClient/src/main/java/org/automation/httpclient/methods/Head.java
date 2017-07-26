package org.automation.httpclient.methods;

import org.automation.httpclient.HttpRequestDefault;

/**
 * Created by shantonu on 7/11/17.
 */
public class Head extends HttpRequestDefault {
    public Head(String url) {
        super(url);
    }

    @Override
    public void run() {
        perform();
    }
    @Override
    public int perform() {
        return 0;
    }
}
