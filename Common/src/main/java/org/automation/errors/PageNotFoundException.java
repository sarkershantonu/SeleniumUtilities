package org.automation.errors;

/**
 * Created by shantonu on 4/15/16.
 */
public class PageNotFoundException extends Exception {
    public PageNotFoundException(String name) {
        super(name);
    }
}
