package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

    public WishListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@href='https://www.zooapteka.kiev.ua/ua/']")
    private WebElement buttonGoToLoginPage;

    @FindBy(xpath = "//a[@href='https://www.zooapteka.kiev.ua/ua/wishlist']")
    private WebElement buttonGoToWishList;

    @FindBy(xpath = "//div[@class='Wishlist_Remove']")
    private WebElement buttonDeleteItemFromWishList;

    @FindBy(xpath = "//div[@class='add_cart carttooltip noselect']")
    private WebElement buttonAddToCartFromWishList;

    @FindBy(xpath = "//*[text()='У Вас немає бажаних товарів']")
    private WebElement textInEmptyWishList;

    @Override
    protected String getRelativeUrl() {
        return "/wishlist";
    }

    public WishListPage checkIsButtonGoToHomePageVisible() {
        checkIsElementVisible(buttonGoToLoginPage);
        return this;
    }

    public WishListPage checkIsButtonGoToWishListVisible() {
        checkIsElementVisible(buttonGoToWishList);
        return this;
    }

    public WishListPage checkIsButtonDeleteItemFromWishListVisible() {
        checkIsElementVisible(buttonDeleteItemFromWishList);
        return this;
    }

    public WishListPage checkIsButtonAddToCartFromWishListVisible() {
        checkIsElementVisible(buttonAddToCartFromWishList);
        return this;
    }

    public WishListPage checkIsTextInEmptyWishListVisible() {
        checkIsElementVisible(textInEmptyWishList);
        return this;
    }

    public LoginPage clickOnButtonGoToLoginPage() {
        clickOnElement(buttonGoToLoginPage);
        return new LoginPage(webDriver);
    }

    public WishListPage clickOnButtonGoToWishList() {
        clickOnElement(buttonGoToWishList);
        return this;
    }

    public WishListPage clickOnButtonDeleteItemFromWishList() {
        clickOnElement(buttonDeleteItemFromWishList);
        return this;
    }

    public WishListPage clearAllItemsFromWishList() {
        while (true) {
            try {
                if (buttonDeleteItemFromWishList.isDisplayed()) {
                    clickOnButtonDeleteItemFromWishList();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                logger.error("Thread was interrupted", e);
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                logger.info("All items have been removed from the WishList");
                break;
            }
        }
        return this;
    }

}
