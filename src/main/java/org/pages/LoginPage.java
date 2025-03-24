package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='log_email']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@id='log_password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='wrapper']//input[@class='btn btn-primary access' and @value='Ввійти']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//span[contains(text(), 'Вибачте, такого користувача не знайдено.')]")
    private WebElement textInPopUpWindowInvalidLogin;

    @FindBy(xpath = "//span[contains(text(), 'Невірний пароль')]")
    private WebElement textInPopUpWindowInvalidPassword;

    @FindBy(xpath = "//div[@class='modal-dialog success_register']")
    private WebElement popUpWindowInvalidData;

    @FindBy(xpath = "//button[@class='close closeok']")
    private WebElement buttonClosePopUpWindowInvalidData;

    @FindBy(xpath = "//*[text()='Нові товари']")
    private WebElement elementNewCollection;

    @FindBy(xpath = "//div[@id='tab-latest-0']//div[@class='HeartAnimation ']")
    private WebElement buttonAddToWishListNewCollection;

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public LoginPage openPage() {
        webDriver.get(baseUrl);
        logger.info("Login Page was opened with url " + baseUrl);
        return this;
    }

    public LoginPage enterTextIntoInputLogin(String login) {
        clearAndEnterTextIntoElement(inputUserName, login);
        return this;
    }

    public LoginPage enterTextIntoInputPassword(String password) {
        clearAndEnterTextIntoElement(inputPassword, password);
        return this;
    }

    public LoginPage clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
        return this;
    }

    public LoginPage checkIsPopUpWindowInvalidDataVisible() {
        isElementVisibleOnPopup(popUpWindowInvalidData);
        return this;
    }

    public LoginPage checkIsTextInPopUpWindowInvalidLoginVisible() {
        isElementVisibleOnPopup(textInPopUpWindowInvalidLogin);
        return this;
    }

    public LoginPage checkIsTextInPopUpWindowInvalidPasswordVisible() {
        isElementVisibleOnPopup(textInPopUpWindowInvalidPassword);
        return this;
    }

    public LoginPage closePopUpWindowInvalidData() {
        clickOnElement(buttonClosePopUpWindowInvalidData);
        return this;
    }

    public void loginWithInputCredentials(String login, String password) {
        openPage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInLoginPage()
                .enterTextIntoInputLogin(login)
                .enterTextIntoInputPassword(password)
                .clickOnButtonSignIn();
    }

    public LoginPage scrollToElementNewCollection() {
        scrollToElement(elementNewCollection);
        return this;
    }

    public LoginPage clickOnButtonAddToWishList() {
        clickOnElement(buttonAddToWishListNewCollection);
        return this;
    }

}
