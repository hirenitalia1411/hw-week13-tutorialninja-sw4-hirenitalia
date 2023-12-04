package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    /******************************** All Elements' Path on Login page ***********************************************/

    By welcomeText = By.xpath("//h2[normalize-space()='Returning Customer']");
    By emailField = By.xpath("//input[@id='input-email']");
    By passwordField = By.xpath("//input[@id='input-password']");
    By loginButton = By.xpath("//input[@value='Login']");

    /******************************** All Elements' Action Methods on Login page *************************************/

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void sendDataToEmailField(String email){
        sendTextToElement(emailField, email);
    }

    public void sendDataToPasswordField(String password){
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
