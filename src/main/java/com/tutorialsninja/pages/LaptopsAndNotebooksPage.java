package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksPage extends Utility {

    /******************************** All Elements' Path on LaptopsAndNotebooks page ***********************************************/

    By welcomeText = By.tagName("h2");
    By sortByFilter = By.xpath("//select[@id='input-sort']");
    By MacBookProductName = By.xpath("//a[normalize-space()='MacBook']");

    /******************************** All Elements' Action Methods on LaptopsAndNotebooks page *************************************/

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void sortByFilter(String sortByOption) {
        selectByVisibleTextFromDropDown(sortByFilter, sortByOption);
    }

    public void clickOnMacBookProduct () {
        clickOnElement(MacBookProductName);
    }
}
