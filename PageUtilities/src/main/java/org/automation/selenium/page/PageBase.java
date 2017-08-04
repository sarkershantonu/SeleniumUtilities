package org.automation.selenium.page;

import lombok.Getter;
import lombok.Setter;

import org.automation.selenium.browser.local.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.function.Function;

public abstract class PageBase {

    @Getter @Setter protected String name;
    @Getter @Setter protected String url;
    private WebDriver driver;


    /**
     * The text proves the page is loaded
     * @param pageLoadText
     */
    private String pageLoadedText ="";

    //todo , need fto decide how to validate load
    // public abstract void setPageLoadText(String pageLoadText);

    protected PageBase(){
        this.driver = Browser.getInstance();
        initElement(this);
    }
    public PageBase(WebDriver aDriver){
        this.driver =aDriver;
        initElement(this);
    }

    /**
     * Init all web elements
     * @param t
     * @param <T>
     *
     */
    public <T extends PageBase> void initElement(T t){
        PageFactory.initElements(driver,t);
    }

     /**
     * This will wati for another default time our time until curree url contains page url.
     * Avoid wait object referrencing for quick call, we will follow this
     */
    public PageBase verifyUrl(){
        new WebDriverWait(driver, Browser.DEFAULT_WAIT_4_PAGE).until((Function<? super WebDriver, Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl() .contains(url);
            }
        });
        return this;
    }

    public PageBase veify(){
        WebDriverWait wait = new WebDriverWait(driver, Browser.DEFAULT_WAIT_4_PAGE);

        wait.until((Function<? super WebDriver, Boolean>) new ExpectedCondition<Boolean>(){
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return driver.getPageSource().contains(pageLoadedText);
            }
        });


        return this;
    }

    public abstract boolean isPageLoaded() ;

    public abstract void waitForPageLoad();// this will have implementation here => todo
}

