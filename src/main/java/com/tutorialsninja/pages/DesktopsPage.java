package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsPage extends Utility {

    /******************************** All Elements' Path on Desktops page ***********************************************/

    By welcomeText = By.tagName("h2");
    By sortByFilter = By.xpath("//select[@id='input-sort']");
    By allProductOnPage = By.tagName("h4");
    By HPLP3065ProductName = By.xpath("//a[normalize-space()='HP LP3065']");

    /******************************** All Elements' Action Methods on Desktops page *************************************/

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public List<WebElement> getAllProductTitleOnPage () {
        List<WebElement> products = driver.findElements(allProductOnPage);
        return products;
    }

    public void sortByFilter(String sortByOption) {
        selectByVisibleTextFromDropDown(sortByFilter, sortByOption);
    }

    public void clickOnHPLP3065Product(){
        clickOnElement(HPLP3065ProductName);
    }
}
