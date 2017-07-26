package org.automation.httpclient.methods;

import org.automation.httpclient.HttpRequestDefault;

/**
 * Created by shantonu on 7/10/17.
 */
public class Delete extends HttpRequestDefault {
    public Delete(String url) {
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
