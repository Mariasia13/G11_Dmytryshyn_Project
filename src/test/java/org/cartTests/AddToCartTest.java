package org.cartTests;

import org.baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

import static org.data.TestData.VALID_LOGIN;
import static org.data.TestData.VALID_PASSWORD;

public class AddToCartTest extends BaseTest {

    @Test
    public void T121_addToCart() {

        pageProvider.getLoginPage()
                .loginWithInputCredentials(VALID_LOGIN, VALID_PASSWORD);
        pageProvider.getHomePage()
                .closePopUpWindowLogInSuccessful();

        pageProvider.getHomePage()
                .scrollToElementNewCollection()
                .clickOnButtonAddToCart()
                .getHeaderElement()
                .checkIsTextInPopupWindowAddToCartVisible()
                .getHeaderElement()
                .checkIsButtonDeleteItemFromCartVisible()
                .getHeaderElement()
                .closePopUpWindowAddToCart()
                .getHeaderElement()
                .clickOnButtonCartInHomePage()
                .getHeaderElement()
                .checkIsButtonDeleteItemFromCartVisible()
                .getHeaderElement()
                .checkIsTextInPopUpWindowAddToCartVisible()
                .getHeaderElement()
                .checkIsButtonGoToGoodsVisible()
        ;
    }

    @After
    public void clearCart() {

        pageProvider.getHomePage()
                .getHeaderElement()
                .clearAllItemsFromCart()
        ;
    }

}
