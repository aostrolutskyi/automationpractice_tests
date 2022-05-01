package helpers;

import configuration.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.SignInPage;

public class UserActions {

    public static void signInToWebsite(WebDriver driver, User user){
        //Actions actions = null;
        SignInPage signInPage = new SignInPage(driver);
        driver.get(Urls.signInUrl);
        signInPage.emailAddressField.sendKeys(user.getUserLoginEmail());
        signInPage.passwordField.sendKeys(user.getUserPassword());
        signInPage.submitLoginButton.click();
    }
}
