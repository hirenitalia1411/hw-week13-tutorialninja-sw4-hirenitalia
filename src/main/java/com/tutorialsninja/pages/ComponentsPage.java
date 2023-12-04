package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    /******************************** All Elements' Path on Components page ***********************************************/

    By welcomeText = By.tagName("h2");

    /******************************** All Elements' Action Methods on Components page *************************************/

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }
}
