package org.loginTests;

import org.baseTest.BaseTest;
import org.junit.Test;

import static org.data.TestData.*;

public class LoginTest extends BaseTest {

    @Test

    public void T111_validLogin() {
        pageProvider.getLoginPage()
                .loginWithInputCredentials(VALID_LOGIN, VALID_PASSWORD);

        pageProvider.getHomePage()
                .checkIsPopUpWindowLogInSuccessfulVisible()
                .closePopUpWindowLogInSuccessful()
                .getHeaderElement()
                .clickOnButtonMyCabinetInHomePage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutVisible()
                .checkIsButtonMyOrdersVisible()
                .checkIsButtonPrivateDataVisible()
                .checkIsButtonWishListVisible()
                .checkIsButtonMyReviewsVisible();

    }

    @Test
    public void T112_invalidLogin() {
        pageProvider.getLoginPage()
                .loginWithInputCredentials(INVALID_LOGIN, VALID_PASSWORD);

        pageProvider.getLoginPage()
                .checkIsPopUpWindowInvalidDataVisible()
                .checkIsTextInPopUpWindowInvalidLoginVisible()
                .closePopUpWindowInvalidData();

        pageProvider.getLoginPage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInLoginPage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutNotVisible()
                .checkIsButtonMyOrdersNotVisible()
                .checkIsButtonPrivateDataNotVisible()
                .checkIsButtonWishListNotVisible()
                .checkIsButtonMyReviewsNotVisible();
    }

    @Test
    public void T113_invalidPassword() {
        pageProvider.getLoginPage()
                .loginWithInputCredentials(VALID_LOGIN, INVALID_PASSWORD);

        pageProvider.getLoginPage()
                .checkIsPopUpWindowInvalidDataVisible()
                .checkIsTextInPopUpWindowInvalidPasswordVisible()
                .closePopUpWindowInvalidData();

        pageProvider.getLoginPage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInLoginPage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutNotVisible()
                .checkIsButtonMyOrdersNotVisible()
                .checkIsButtonPrivateDataNotVisible()
                .checkIsButtonWishListNotVisible()
                .checkIsButtonMyReviewsNotVisible();
    }

    @Test
    public void T114_SingOut() {
        pageProvider.getLoginPage()
                .loginWithInputCredentials(VALID_LOGIN, VALID_PASSWORD);

        pageProvider.getHomePage()
                .closePopUpWindowLogInSuccessful()
                .getHeaderElement()
                .clickOnButtonMyCabinetInHomePage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutVisible()
                .checkIsButtonMyOrdersVisible()
                .checkIsButtonPrivateDataVisible()
                .checkIsButtonWishListVisible()
                .checkIsButtonMyReviewsVisible()
                .clickOnButtonSingOut()
                .refreshPage();

        pageProvider.getLoginPage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInLoginPage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutNotVisible()
                .checkIsButtonMyOrdersNotVisible()
                .checkIsButtonPrivateDataNotVisible()
                .checkIsButtonWishListNotVisible()
                .checkIsButtonMyReviewsNotVisible();
    }

    @Test
    public void T115_StayLoggedInNewTab() {
        pageProvider.getLoginPage()
                .loginWithInputCredentials(VALID_LOGIN, VALID_PASSWORD);

        pageProvider.getHomePage()
                .closePopUpWindowLogInSuccessful()
                .getHeaderElement()
                .clickOnButtonMyCabinetInHomePage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutVisible();

        pageProvider.getHomePage().openNewTab();
        pageProvider.getLoginPage().switchToNewTab(1);
        pageProvider.getLoginPage().openPage();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInHomePage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutVisible();

        pageProvider.getHomePage().switchToMainTab();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInHomePage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutVisible();

        pageProvider.getHomePage().switchToNewTab(1);
        pageProvider.getHomePage().closeCurrentTab();
        pageProvider.getHomePage().switchToMainTab();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInHomePage();

        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutVisible();
    }

    @Test
    public void T116_inputDataDisappearsAfterRefreshing() {
        pageProvider.getLoginPage()
                .openPage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInLoginPage()
                .enterTextIntoInputLogin(VALID_LOGIN)
                .enterTextIntoInputPassword(VALID_PASSWORD)
                .refreshPage();
        pageProvider.getLoginPage()
                .getHeaderElement()
                .clickOnButtonMyCabinetInLoginPage();
        pageProvider.getMyProfilePage()
                .checkIsButtonSingOutNotVisible()
                .checkIsButtonMyOrdersNotVisible()
                .checkIsButtonPrivateDataNotVisible()
                .checkIsButtonWishListNotVisible()
                .checkIsButtonMyReviewsNotVisible();
    }

}
