package de.rfelgent.springboot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author rfelgentraeger
 */
@SpringBootApplication
public class AppConfig {

    @Bean
    public WebDriver webDriverFireFox() {
        FirefoxProfile customProfile = new FirefoxProfile();
        //settings for the popup behavior
        customProfile.setPreference("privacy.popups.showBrowserMessage", true);
        customProfile.setPreference("dom.popup_maximum", 0);
        customProfile.setPreference("dom.popup_allowed_events", "");
        customProfile.setPreference("privacy.popups.policy", 1);
        //popup end
        FirefoxOptions options = new FirefoxOptions()
                .setProfile(customProfile)
                .setLogLevel(FirefoxDriverLogLevel.FATAL)
                //.setHeadless(true)
                ;
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        return new FirefoxDriver(options) {
            private final Logger LOGGER = LoggerFactory.getLogger(FirefoxDriver.class);
            @Override
            public void quit() {
                //this method is called by org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener
                LOGGER.warn("Closing webDriver instance");
                super.quit();
            }
        };
    }
}
