package org.wishListTests;

import org.baseTest.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class AddToWishListTest extends BaseTest {

    @Before
    public void clearWishList() {
        pageProvider.getLoginPage()
                .openPage()
                .getHeaderElement()
                .clickOnButtonWishListInLoginPage();
        pageProvider.getWishListPage()
                .clearAllItemsFromWishList()
                .clickOnButtonGoToLoginPage();
    }

    @Test
    public void T131_addToWishList() {

        pageProvider.getLoginPage()
                .openPage()
                .getHeaderElement()
                .checkIsWishListEmpty()
                .scrollToElementNewCollection()
                .clickOnButtonAddToWishList()
                .getHeaderElement()
                .checkIsWishListNotEmpty()
                .getHeaderElement()
                .clickOnButtonWishListInLoginPage();

        pageProvider.getWishListPage()
                .checkIsButtonGoToHomePageVisible()
                .checkIsButtonGoToWishListVisible()
                .checkIsButtonDeleteItemFromWishListVisible()
                .checkIsButtonAddToCartFromWishListVisible();
    }

    @Test
    public void T132_deleteFromWishList() {
        pageProvider.getLoginPage()
                .openPage()
                .getHeaderElement()
                .checkIsWishListEmpty()
                .scrollToElementNewCollection()
                .clickOnButtonAddToWishList()
                .getHeaderElement()
                .checkIsWishListNotEmpty()
                .getHeaderElement()
                .clickOnButtonWishListInLoginPage();

        pageProvider.getWishListPage()
                .checkIsButtonGoToHomePageVisible()
                .checkIsButtonGoToWishListVisible()
                .checkIsButtonDeleteItemFromWishListVisible()
                .checkIsButtonAddToCartFromWishListVisible()
                .clickOnButtonDeleteItemFromWishList()
                .clickOnButtonGoToWishList()
                .checkIsTextInEmptyWishListVisible();
    }


}
