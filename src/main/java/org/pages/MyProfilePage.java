package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends ParentPage {

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='log_out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//a[@href='#account_my_orders']")
    private WebElement buttonMyOrders;

    @FindBy(xpath = "//a[@href='#account_private_data']")
    private WebElement buttonPrivateData;

    @FindBy(xpath = "//a[@href='#account_wish_list']")
    private WebElement buttonWishList;

    @FindBy(xpath = "//a[@href='#account_my_reviews']")
    private WebElement buttonMyReviews;


    @Override
    protected String getRelativeUrl() {
        return "/my-account";
    }

    public MyProfilePage checkIsButtonSingOutVisible() {
        checkIsElementVisible(buttonSignOut);
        return this;
    }

    public MyProfilePage checkIsButtonSingOutNotVisible() {
        checkIsElementNotVisible(buttonSignOut);
        return this;
    }

    public MyProfilePage checkIsButtonMyOrdersVisible() {
        checkIsElementVisible(buttonMyOrders);
        return this;
    }

    public MyProfilePage checkIsButtonPrivateDataVisible() {
        checkIsElementVisible(buttonPrivateData);
        return this;
    }

    public MyProfilePage checkIsButtonWishListVisible() {
        checkIsElementVisible(buttonWishList);
        return this;
    }

    public MyProfilePage checkIsButtonMyReviewsVisible() {
        checkIsElementVisible(buttonMyReviews);
        return this;
    }

    public MyProfilePage checkIsButtonMyOrdersNotVisible() {
        checkIsElementNotVisible(buttonMyOrders);
        return this;
    }

    public MyProfilePage checkIsButtonPrivateDataNotVisible() {
        checkIsElementNotVisible(buttonPrivateData);
        return this;
    }

    public MyProfilePage checkIsButtonWishListNotVisible() {
        checkIsElementNotVisible(buttonWishList);
        return this;
    }

    public MyProfilePage checkIsButtonMyReviewsNotVisible() {
        checkIsElementNotVisible(buttonMyReviews);
        return this;
    }


    public LoginPage clickOnButtonSingOut() {
        clickOnElement(buttonSignOut);
        return new LoginPage(webDriver);
    }

}
