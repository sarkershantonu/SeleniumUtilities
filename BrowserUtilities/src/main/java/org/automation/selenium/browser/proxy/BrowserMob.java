package org.automation.selenium.browser.proxy;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import net.lightbody.bmp.proxy.http.BrowserMobHttpRequest;
import net.lightbody.bmp.proxy.http.RequestInterceptor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by shantonu on 8/19/16.
 */
public class BrowserMob {

    public WebDriver getFirefoxWithProxy(String host, int proxy_port, final String addReffer) {
        ProxyServer server = new ProxyServer(proxy_port); //net.lightbody.bmp.proxy.ProxyServer;
        server.start();
        server.setCaptureHeaders(true);
        Proxy proxy = server.seleniumProxy(); //org.openqa.selenium.Proxy
        proxy.setHttpProxy(host).setSslProxy(host);
        server.addRequestInterceptor(
                new RequestInterceptor() {
                    @Override
                    public void process(BrowserMobHttpRequest browserMobHttpRequest, Har har) {
                        browserMobHttpRequest.addRequestHeader("Referer", addReffer);
                    }
                });

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        return new FirefoxDriver(capabilities);
    }

    //https://sites.google.com/a/chromium.org/chromedriver/capabilities
    public WebDriver getChromeWithProxy() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();//=> this part need to simplify with testing.
        return new ChromeDriver();//// TODO: 8/19/16
    }
}
