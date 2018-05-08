package de.rfelgent.springboot.fixtures;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * @author rfelgentraeger
 */
public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumTestExecutionListener.class);

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (testContext.getTestException() == null) {
            LOGGER.warn("Not taking a screen shot");
        } else {
            LOGGER.warn("Taking a screen shot");
        }
        //will trigger the re-creation of webdriver, as the bean does not exist anymore in application scope!
        //testContext.getApplicationContext().getBean(WebDriver.class);
    }

    @Override
    public int getOrder() {
        //return  Ordered.HIGHEST_PRECEDENCE;
        return super.getOrder() - 1;
    }
}
