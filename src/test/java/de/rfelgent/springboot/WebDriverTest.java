package de.rfelgent.springboot;

import de.rfelgent.springboot.fixtures.SeleniumSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author rfelgentraeger
 */
@RunWith(SpringRunner.class)
@SeleniumSetup
@SpringBootTest
public class WebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverTest.class);

    @Autowired
    private WebDriver webDriver;

    @Test
    public void one() {
        LOGGER.warn("Executing test one()");
    }

    @Test
    public void two() {
        LOGGER.warn("Executing test two()");

        assertTrue("Forcing invalid assertion, so that Screenshot is taken by custom test execution listener", false);
    }

    @Test
    public void three() {
        LOGGER.warn("Executing test three()");
    }
}
