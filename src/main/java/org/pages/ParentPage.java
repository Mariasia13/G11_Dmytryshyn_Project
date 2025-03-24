package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.elements.HeaderElements;
import org.utils.ConfigProvider;

abstract public class ParentPage extends CommonActionsWithElements {
    protected String baseUrl = ConfigProvider.configProperties.base_url();
    protected HeaderElements header;

    public ParentPage(WebDriver webDriver) {super(webDriver);
        this.header = new HeaderElements(webDriver);}

    private Logger logger = Logger.getLogger(getClass());

    abstract protected String getRelativeUrl();

    public HeaderElements getHeaderElement() {
        return header;
    }

    protected void checkURL() {
        Assert.assertEquals("URL is not expected"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern(){
        Assert.assertTrue("URL is not expected \n" +
                        "Expected url: " + baseUrl + getRelativeUrl() +
                        "\n Actual url: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl()));
    }
    // open new tab using JS
    public void openNewTab() {
        try {
            ((JavascriptExecutor) webDriver).executeScript("window.open()");
            logger.info("New tab was opened");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // switch to new tab
    public void switchToNewTab(int tabIndex) {
        try {
            webDriverWait10.until(ExpectedConditions.numberOfWindowsToBe(tabIndex + 1));
            webDriver.switchTo().window((String) webDriver.getWindowHandles().toArray()[tabIndex]);
            logger.info("Switched to tab with index: " + tabIndex);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // switch to main tab
    public void switchToMainTab() {
        try {
            webDriver.switchTo().window((String) webDriver.getWindowHandles().toArray()[0]);
            logger.info("Switched to main tab");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // close current tab
    public void closeCurrentTab() {
        try {
            webDriver.close();
            logger.info("Current tab was closed");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // refresh page
    public void refreshPage() {
        try {
            webDriver.navigate().refresh();
            logger.info("Page was refreshed");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
