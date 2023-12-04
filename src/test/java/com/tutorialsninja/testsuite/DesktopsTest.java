package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HPLP3065ProductPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DesktopsTest extends BaseTest {

    /******************************** All Elements' Action Methods on Apparel page *************************************/

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    HPLP3065ProductPage hplp3065ProductPage = new HPLP3065ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    /*********************** All Test Methods As Per Requirements *****************************************/

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.mouseHoverOnDesktopMenu();
        homePage.clickOnShowAllDesktopsSubMenu();

        List<WebElement> list = desktopsPage.getAllProductTitleOnPage();
        ArrayList originalList = new ArrayList();
        for (WebElement l: list) {
            originalList.add(l.getText());
        }
        Collections.reverse(originalList);
        //System.out.println(originalList);

        desktopsPage.sortByFilter("Name (Z - A)");
        Thread.sleep(2000);
        ArrayList sortedList = new ArrayList();
        list = desktopsPage.getAllProductTitleOnPage();
        for (WebElement l: list) {
            sortedList.add(l.getText());
        }
        //System.out.println(sortedList);
        Assert.assertEquals(originalList, sortedList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        homePage.mouseHoverAndClickOnCurrencyDroDown();
        homePage.selectSterlingPoundFromCurrencyDropDown();

        homePage.mouseHoverOnDesktopMenu();
        homePage.clickOnShowAllDesktopsSubMenu();

        List<WebElement> list = desktopsPage.getAllProductTitleOnPage();
        ArrayList originalList = new ArrayList();
        for (WebElement l: list) {
            originalList.add(l.getText().toLowerCase(Locale.ROOT));
        }
        Collections.sort(originalList);
        System.out.println(originalList);

        desktopsPage.sortByFilter("Name (A - Z)");
        Thread.sleep(2000);
        ArrayList sortedList = new ArrayList();
        list = desktopsPage.getAllProductTitleOnPage();
        for (WebElement l: list) {
            sortedList.add(l.getText().toLowerCase(Locale.ROOT));
        }
        System.out.println(sortedList);
        Assert.assertEquals(originalList, sortedList);

        desktopsPage.clickOnHPLP3065Product();

        hplp3065ProductPage.selectDeliveryDate("28","Nov", "2023");

        hplp3065ProductPage.sendDataToQuantityField(Keys.CONTROL + "a");
        hplp3065ProductPage.sendDataToQuantityField("1");

        hplp3065ProductPage.clickOnAddToCart();

        String expectedSuccessMessage = "Success: You have added HP LP3065 to your shopping cart!";
        String actualSuccessMessage = hplp3065ProductPage.getCartAddSuccessfulMessage().substring(0, expectedSuccessMessage.length());
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        hplp3065ProductPage.clickOnShoppingCartLinkInMessage();

        Thread.sleep(2000);
        String expectedShoppingCartText = "Shopping Cart";
        String actualShoppingCartText = shoppingCartPage.getWelcomeText().substring(0,expectedShoppingCartText.length());
        Assert.assertEquals(actualShoppingCartText, expectedShoppingCartText);

        String expectedProductName = "HP LP3065";
        String actualProductName = shoppingCartPage.getProductName().substring(0,expectedProductName.length());
        Assert.assertEquals(actualProductName, expectedProductName);

        String expectedDeliveryDate = "Delivery Date:2023-11-28";
        String actualDeliveryDate = shoppingCartPage.getDeliveryDate().substring(0, expectedDeliveryDate.length());
        Assert.assertEquals(actualDeliveryDate, expectedDeliveryDate);

        String expectedModel = "Product 21";
        String actualModel = shoppingCartPage.getModel().substring(0, expectedModel.length());
        Assert.assertEquals(actualModel, expectedModel);

        String expectedPrice = "£74.73";
        String actualPrice = shoppingCartPage.getTotalPrice().substring(0, expectedPrice.length());
        Assert.assertEquals(actualPrice, expectedPrice);
    }
}
