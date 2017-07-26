package org.automation.httpclient.methods;

import org.automation.httpclient.HttpRequestDefault;

/**
 * Created by shantonu on 7/11/17.
 */
public class Trace extends HttpRequestDefault {


    public Trace(String url) {
        super(url);
    }

    @Override
    public int perform() {
return 0;
    }
    @Override
    public void run() {
        perform();
    }
}
