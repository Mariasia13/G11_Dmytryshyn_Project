package org.pages.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pages.*;

public class HeaderElements extends CommonActionsWithElements {

    private Logger logger = Logger.getLogger(getClass());

    @FindBy(xpath = "//div[@id='cabinet']")
    private WebElement buttonMyCabinet;

    @FindBy(xpath = "//div[@id='wishes']")
    private WebElement buttonWishList;

    @FindBy(xpath = "//div[@id='basket']")
    private WebElement buttonCart;

    @FindBy(xpath = "//*[@class='modal-title new_carttitle']")
    private WebElement textInPopUpWasAddedToCart;

    @FindBy(xpath = "//a[@id='close_modal']")
    private WebElement buttonGoToGoods;

    @FindBy(xpath = "//a[@class='cart_popup_remove sprt sprt_trash']")
    private WebElement buttonDeleteItemFromCart;

    @FindBy(xpath = "//span[@class='close sprt sprt_nope']")
    private WebElement buttonClosePopUpWindowAddToCart;

    @FindBy(xpath = "//span[@class='close sprt sprt_nope-sw']")
    private WebElement buttonClosePopUpWindowEmptyCart;

    @FindBy(xpath = "//p[@class='emptycart']")
    private WebElement textInPopUpEmptyCart;

    @FindBy(xpath = "//span[@id='ajax_countw' and (text()='0')]")
    private WebElement emptyWishList;

    @FindBy(xpath = "//span[@id='ajax_countw' and (text()='1')]")
    private WebElement notEmptyWishList;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnButtonMyCabinetInLoginPage() {
        clickOnElement(buttonMyCabinet);
        return new LoginPage(webDriver);
    }

    public HomePage clickOnButtonMyCabinetInHomePage() {
        clickOnElement(buttonMyCabinet);
        return new HomePage(webDriver);
    }

    public LoginPage clickOnButtonWishListInLoginPage() {
        clickOnElement(buttonWishList);
        return new LoginPage(webDriver);
    }

    public HomePage clickOnButtonCartInHomePage() {
        clickOnElement(buttonCart);
        return new HomePage(webDriver);
    }

    public HomePage checkIsTextInPopUpWindowAddToCartVisible() {
        isElementVisibleOnPopup(textInPopUpWasAddedToCart);
        return new HomePage(webDriver);
    }

    public HomePage closePopUpWindowAddToCart() {
        clickOnElement(buttonClosePopUpWindowAddToCart);
        return new HomePage(webDriver);
    }

    public HomePage checkIsTextInPopupWindowAddToCartVisible() {
        isElementVisibleOnPopup(textInPopUpWasAddedToCart);
        return new HomePage(webDriver);
    }

    public HomePage checkIsButtonDeleteItemFromCartVisible() {
        isElementVisibleOnPopup(buttonDeleteItemFromCart);
        return new HomePage(webDriver);
    }

    public HomePage clickOnButtonDeleteItemFromCart() {
        clickOnElement(buttonDeleteItemFromCart);
        return new HomePage(webDriver);
    }

    public LoginPage checkIsWishListEmpty() {
        checkIsElementVisible(emptyWishList);
        return new LoginPage(webDriver);
    }

    public LoginPage checkIsWishListNotEmpty() {
        checkIsElementVisible(notEmptyWishList);
        return new LoginPage(webDriver);
    }

    public HomePage clearAllItemsFromCart() {
        while (true) {
            try {
                if (buttonDeleteItemFromCart.isDisplayed()) {
                    clickOnButtonDeleteItemFromCart();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                logger.error("Thread was interrupted", e);
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                logger.info("All items have been removed from the Cart");
                break;
            }
        }
        return new HomePage(webDriver);
    }

    public HomePage checkIsButtonGoToGoodsVisible() {
        isElementVisibleOnPopup(buttonGoToGoods);
        return new HomePage(webDriver);
    }

}
