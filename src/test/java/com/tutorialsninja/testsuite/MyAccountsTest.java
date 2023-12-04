package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class MyAccountsTest extends BaseTest {

    /******************************** All Elements' Action Methods on Apparel page *************************************/

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    /*********************** All Test Methods As Per Requirements *****************************************/

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccountMenu();
        homePage.clickOnRegisterOptionInMyAccount();

        String expectedRegisterAccountWelcomeText = "Register Account";
        String actualRegisterAccountWelcomeText = registerPage.getWelcomeText().substring(0, expectedRegisterAccountWelcomeText.length());
        Assert.assertEquals(actualRegisterAccountWelcomeText,expectedRegisterAccountWelcomeText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountMenu();
        homePage.clickOnLoginOptionInMyAccount();

        String expectedLoginWelcomeText = "Returning Customer";
        String actualLoginWelcomeText = loginPage.getWelcomeText().substring(0, expectedLoginWelcomeText.length());
        Assert.assertEquals(actualLoginWelcomeText,expectedLoginWelcomeText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccountMenu();
        homePage.clickOnRegisterOptionInMyAccount();

        String expectedRegisterAccountWelcomeText = "Register Account";
        String actualRegisterAccountWelcomeText = registerPage.getWelcomeText().substring(0, expectedRegisterAccountWelcomeText.length());
        Assert.assertEquals(actualRegisterAccountWelcomeText,expectedRegisterAccountWelcomeText);

        registerPage.sendDataToRegistrationFirstNameField("Abcd");
        registerPage.sendDataToRegistrationLastNameField("Xyz");
        Random random = new Random();
        registerPage.sendDataToRegistrationEmailField("abcd"+random.nextInt()+"@gmail.com");
        registerPage.sendDataToRegistrationTelephoneField("07452485254");
        registerPage.sendDataToRegistrationPasswordField("abcd123");
        registerPage.sendDataToRegistrationConfirmPasswordField("abcd123");
        registerPage.clickOnSubscriptionYesButton();
        registerPage.clickOnPrivatePolicyCheckBox();
        registerPage.clickOnRegistrationContinueButton();

        String expectedAccountCreationSuccessMessage = "Your Account Has Been Created!";
        String actualAccountCreationSuccessMessage = registerPage.getMessageOfAccountCreatedSuccess().substring(0, expectedAccountCreationSuccessMessage.length());
        Assert.assertEquals(actualAccountCreationSuccessMessage, expectedAccountCreationSuccessMessage);

        registerPage.clickOnSuccessAccountContinueButton();

        accountPage.clickOnMyAccountMenu();
        accountPage.clickOnLogoutOptionInMyAccount();

        String expectedLogoutMessage = "Account Logout";
        String actualLogoutMessage = accountPage.getLogoutSuccessMessage().substring(0, expectedLogoutMessage.length());
        Assert.assertEquals(actualLogoutMessage, expectedLogoutMessage);

        accountPage.clickOnLogoutMessageContinueButton();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountMenu();
        homePage.clickOnLoginOptionInMyAccount();

        String expectedLoginWelcomeText = "Returning Customer";
        String actualLoginWelcomeText = loginPage.getWelcomeText().substring(0, expectedLoginWelcomeText.length());
        Assert.assertEquals(actualLoginWelcomeText,expectedLoginWelcomeText);

        loginPage.sendDataToEmailField("abcdxyz123@gmail.com");
        loginPage.sendDataToPasswordField("abcd@123");
        loginPage.clickOnLoginButton();

        String expectedAccountPageWelcomeText = "My Account";
        String actualAccountPageWelcomeText = accountPage.getWelcomeText().substring(0, expectedAccountPageWelcomeText.length());
        Assert.assertEquals(actualAccountPageWelcomeText, expectedAccountPageWelcomeText);

        accountPage.clickOnMyAccountMenu();
        accountPage.clickOnLogoutOptionInMyAccount();

        String expectedLogoutMessage = "Account Logout";
        String actualLogoutMessage = accountPage.getLogoutSuccessMessage().substring(0, expectedLogoutMessage.length());
        Assert.assertEquals(actualLogoutMessage, expectedLogoutMessage);

        accountPage.clickOnLogoutMessageContinueButton();
    }
}
