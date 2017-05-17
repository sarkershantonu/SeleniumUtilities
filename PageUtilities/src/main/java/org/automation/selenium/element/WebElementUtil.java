package org.automation.selenium.element;

import org.openqa.selenium.WebElement;


public class WebElementUtil {

    public static void print(WebElement element) {
        System.out.println("TAG " + element.getTagName());
        System.out.println("TXT " + element.getText());
        System.out.println("VAL " + element.getAttribute("value"));
        System.out.println(element.toString());
    }

    public static boolean isEnable(WebElement element){
        return element.isEnabled();
    }
    public static String getValue(WebElement element){
        return element.getAttribute("value");
    }

}
