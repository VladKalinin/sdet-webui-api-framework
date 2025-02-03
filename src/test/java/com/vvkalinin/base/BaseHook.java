package com.vvkalinin.base;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.vvkalinin.constants.Device;

import static com.vvkalinin.pageobject.Page.isCurrentPageOpened;

import com.vvkalinin.configuration.AppConfig;
import com.vvkalinin.pageobject.pages.homepage.HomePage;
import com.vvkalinin.utils.ProfileMatcher;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static java.lang.Boolean.TRUE;

import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.SessionNotCreatedException;

import static org.openqa.selenium.remote.CapabilityType.ACCEPT_INSECURE_CERTS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.net.URL;

@ContextConfiguration(classes = AppConfig.class)
@CucumberContextConfiguration
public class BaseHook {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseHook.class);

    @Value("${webdriver.browser}")
    private String browser;

    @Value("${webdriver.timeout}")
    private long timeout;

    @Value("${webdriver.page.load.timeout}")
    private long pageLoadTimeout;

    @Value("${webdriver.pollingInterval}")
    private long pollingInterval;

    @Value("${webdriver.base.url}")
    private String baseUrl;

    @Value("${mobile.emulation.device.name}")
    private String mobileDeviceName;

    @Value("${desktop.browser.size}")
    private String desktopBrowserSize;

    @Autowired
    private ProfileMatcher profileMatcher;

    @Autowired
    private HomePage homePage;

    @Before(order = 1, value = "not @application=API")
    public void setBrowser() {
        Configuration.browser = browser;
        Configuration.browserCapabilities.setCapability(ACCEPT_INSECURE_CERTS, true);
        String host = System.getenv("SELENIUM_HUB");
        if (host != null) {
            Configuration.remote =  "http://" + host + ":4444/wd/hub";
        }
    }

    /**
     * Allows Selenide to use JavaScript to set the value of an input
     * field directly instead of simulating typing character-by-character
     */
    @Before(order = 2, value = "not @application=API")
    public void switchOnFastSetValue() {
        Configuration.fastSetValue = TRUE;
    }

    @Before(order = 3, value = "not @application=API")
    public void setupTimeouts() {
        Configuration.pollingInterval = pollingInterval;
        Configuration.timeout = timeout;
        Configuration.pageLoadTimeout = pageLoadTimeout;
    }

    @Before(order = 4, value = "not @application=API")
    public void setupBaseURL() {
        Configuration.baseUrl = baseUrl;
    }

    @Before(order = 5, value = "not @application=API")
    public void resizeBrowser() {
        if (!isDesktop()) {
            System.setProperty("chromeoptions.mobileEmulation", "deviceName=" + mobileDeviceName);
        } else {
            Configuration.browserSize = desktopBrowserSize;
        }
    }

    @Before(order = 7, value = "not @application=API")
    public void openHomePage() {
        try {
            homePage.open();
        } catch (SessionNotCreatedException e) {
            LOGGER.info("Session not created. Retrying...");
            homePage.open();
        }
        isCurrentPageOpened(HomePage.class);
        refresh();
        switchTo().defaultContent();
    }

    @After(order = 1, value = "not @application=API")
    public void quitWebDriver() {
        clearBrowserLocalStorage();
        clearBrowserCache();
        getWebDriver().quit();
    }

    private boolean isDesktop() {
        return profileMatcher.isProfilesMatches(Device.DESKTOP.getName());
    }

}
