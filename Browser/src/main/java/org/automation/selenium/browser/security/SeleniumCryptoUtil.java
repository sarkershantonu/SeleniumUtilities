package org.automation.selenium.browser.security;

import org.openqa.selenium.internal.Base64Encoder;

/**
 * Created by shantonu on 8/28/16.
 */
public class SeleniumCryptoUtil {
    private static Base64Encoder engine = new Base64Encoder();
    public static String encode(byte[] input){
        return engine.encode(input);
    }
    public static byte[] decode(String input){
        return engine.decode(input);
    }
//todo , string to string & byte[] to byte[]

}
