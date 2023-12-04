package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LaptopsAndNotebooksTest extends BaseTest {

    /******************************** All Elements' Action Methods on Apparel page *************************************/

    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    MacBookProductPage macBookProductPage = new MacBookProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    /*********************** All Test Methods As Per Requirements *****************************************/

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnLaptopsAndNotebooksMenu();
        homePage.clickOnShowAllLaptopAndNotebooksSubMenu();

        String actualLaptopAndNotebooksPageText = laptopsAndNotebooksPage.getWelcomeText();
        String expectedLaptopAndNotebooksPageText = "Laptops & Notebooks";
        Assert.assertEquals(actualLaptopAndNotebooksPageText, expectedLaptopAndNotebooksPageText);

        laptopsAndNotebooksPage.sortByFilter("Price (High > Low)");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        homePage.mouseHoverAndClickOnCurrencyDroDown();
        homePage.selectSterlingPoundFromCurrencyDropDown();

        homePage.mouseHoverOnLaptopsAndNotebooksMenu();
        homePage.clickOnShowAllLaptopAndNotebooksSubMenu();

        String actualLaptopAndNotebooksPageText = laptopsAndNotebooksPage.getWelcomeText();
        String expectedLaptopAndNotebooksPageText = "Laptops & Notebooks";
        Assert.assertEquals(actualLaptopAndNotebooksPageText, expectedLaptopAndNotebooksPageText);

        laptopsAndNotebooksPage.sortByFilter("Price (High > Low)");

        laptopsAndNotebooksPage.clickOnMacBookProduct();

        String expectedProductMessage = "MacBook";
        String actualProductMessage = macBookProductPage.getWelcomeText().substring(0, expectedProductMessage.length());
        Assert.assertEquals(actualProductMessage, expectedProductMessage);

        macBookProductPage.clickOnAddToCart();

        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!";
        String actualSuccessMessage = macBookProductPage.getCartAddSuccessfulMessage().substring(0, expectedSuccessMessage.length());
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        macBookProductPage.clickOnShoppingCartLinkInMessage();

        Thread.sleep(2000);
        String expectedShoppingCartText = "Shopping Cart";
        String actualShoppingCartText = shoppingCartPage.getWelcomeText().substring(0,expectedShoppingCartText.length());
        Assert.assertEquals(actualShoppingCartText, expectedShoppingCartText);

        shoppingCartPage.sendDataToQuantityField(Keys.CONTROL +"a");
        shoppingCartPage.sendDataToQuantityField("2");

        shoppingCartPage.clickOnUpdateButton();

        String expectedUpdateMessage = "Success: You have modified your shopping cart!";
        String actualUpdateMessage = shoppingCartPage.getShoppingCartUpdateMessage().substring(0, expectedUpdateMessage.length());
        Assert.assertEquals(actualUpdateMessage, expectedUpdateMessage);

        String expectedCartTotal = "£737.45";
        String actualCartTotal = shoppingCartPage.getCartTotal().substring(0, expectedCartTotal.length());
        Assert.assertEquals(actualCartTotal, expectedCartTotal);

        shoppingCartPage.clickOnCheckOut();

        String expectedCheckoutText = "Checkout";
        String actualCheckoutText = checkoutPage.getCheckoutText();
        Assert.assertEquals(actualCheckoutText, expectedCheckoutText);

        String expectedNewCustomerText = "New Customer";
        String actualNewCustomerText = checkoutPage.getNewCustomerText();
        Assert.assertEquals(actualNewCustomerText, expectedNewCustomerText);

        checkoutPage.clickOnGuestCheckoutRadioButton();

        checkoutPage.clickOnGuestCheckoutContinueButton();

        checkoutPage.sendDataToFirstNameField("Abcd");
        checkoutPage.sendDataToLastNameField("Xyz");
        Random random = new Random();
        checkoutPage.sendDataToEmailField("abcd"+random.nextInt()+"@gmail.com");
        checkoutPage.sendDataToTelephoneField("074424856275");
        checkoutPage.sendDataToAddressField("1, ancd st.");
        checkoutPage.sendDataToCityField("London");
        checkoutPage.sendDataToPostCodeField("HA0 2AB");
        checkoutPage.selectCountry("United Kingdom");
        checkoutPage.selectState("Essex");
        checkoutPage.clickOnBillingDetailContinueButton();
        checkoutPage.sendDataToCommentField("The product is good!");
        checkoutPage.clickOnTermAndCondition();
        checkoutPage.clickOnPaymentMethodContinueButton();

        String expectedPaymentWarningMessage = "Warning: Payment method required!";
        String actualPaymentWarningMessage = checkoutPage.getPaymentWarningMessage().substring(0,expectedPaymentWarningMessage.length());
        Assert.assertEquals(actualPaymentWarningMessage, expectedPaymentWarningMessage);
    }

}
