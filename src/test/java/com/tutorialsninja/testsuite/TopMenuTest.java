package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    /******************************** All Elements' Action Methods on Apparel page *************************************/

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    /*********************** All Test Methods As Per Requirements *****************************************/

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopMenu();
        homePage.clickOnShowAllDesktopsSubMenu();

        String actualDesktopPageText = desktopsPage.getWelcomeText();
        String expectedDesktopPageText = "Desktops";
        Assert.assertEquals(actualDesktopPageText, expectedDesktopPageText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.mouseHoverOnLaptopsAndNotebooksMenu();
        homePage.clickOnShowAllLaptopAndNotebooksSubMenu();

        String actualLaptopAndNotebooksPageText = laptopsAndNotebooksPage.getWelcomeText();
        String expectedLaptopAndNotebooksPageText = "Laptops & Notebooks";
        Assert.assertEquals(actualLaptopAndNotebooksPageText, expectedLaptopAndNotebooksPageText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsMenu();
        homePage.clickOnShowAllComponentsSubMenu();

        String actualComponentsPageText = componentsPage.getWelcomeText();
        String expectedComponentsPageText = "Components";
        Assert.assertEquals(actualComponentsPageText, expectedComponentsPageText);
    }
}
