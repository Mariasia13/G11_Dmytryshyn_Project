package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Авторизація пройшла успішно!')]")
    private WebElement textInPopUpWindowLogInSuccessful;

    @FindBy(xpath = "//button[@class='close closeok']")
    private WebElement buttonClosePopUpWindowLogInSuccessful;

    @FindBy(xpath = "//*[text()='Нові товари']")
    private WebElement elementNewCollection;

    @FindBy(xpath = "//div[@id='tab-latest-0']//input[@value='Купити']")
    private WebElement buttonAddToCartNewCollection;

    @Override
    protected String getRelativeUrl() {
        return "/";
    }


    public HomePage checkIsPopUpWindowLogInSuccessfulVisible() {
        isElementVisibleOnPopup(textInPopUpWindowLogInSuccessful);
        return this;
    }

    public HomePage closePopUpWindowLogInSuccessful() {
        clickOnElement(buttonClosePopUpWindowLogInSuccessful);
        return this;
    }

    public HomePage scrollToElementNewCollection() {
        scrollToElement(elementNewCollection);
        return this;
    }

    public HomePage clickOnButtonAddToCart() {
        clickOnElement(buttonAddToCartNewCollection);
        return this;
    }

}
