package org.automation;

import org.automation.property.PropertyUtil;

import java.io.IOException;

/**
 * Created by shantonu on 5/17/17.
 * this is spacial class for initiating all prop + confi
 */
public class Init {
    public static void initAllDefaultConfig(){
        try {
            new PropertyUtil("./Common").loadAllDefaultProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
