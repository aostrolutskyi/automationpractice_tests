import configuration.Urls;
import helpers.User;
import helpers.UserActions;
import helpers.WebBrowser;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.MainPage;

import java.time.Duration;
import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BuyClothesTest {

    WebDriver driver;
    User user1, user2;
    private static String searchWord= "Blouse";
    MainPage mainPage;
    CartPage cartPage;

    public void initialize(String browserName){
        this.driver = WebBrowser.setWebBrowser(browserName);
        this.driver.get(Urls.frontPageUrl);
        this.mainPage = new MainPage(this.driver);
        this.cartPage = new CartPage(this.driver);
    }

    @AfterEach
    public void AfterTest() {
        this.driver.quit();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("Browser#setUpBrowser")
    public void BuyClothesFromSearchFieldTest(String browser) throws Exception {
        initialize(browser);
        this.user1 = new User("makings.officer.05@icloud.com");
        UserActions.signInToWebsite(this.driver, this.user1);

        this.mainPage.header.searchField.sendKeys(this.searchWord);


        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/ul")));


        List<WebElement> listOfElements = driver.findElements(By.xpath("/html/body/div[2]/ul"));
        listOfElements.get(0).click();
        Thread.sleep(3600);
        this.mainPage.addToCartButton.click();
        Thread.sleep(3600);
        this.mainPage.proceedToCheckoutButton.click();
        this.cartPage.proceedToCheckoutButton.click();
        this.cartPage.proceedToCheckoutButton2.click();
        this.cartPage.termsOfServiceCheckBox.click();
        this.cartPage.proceedToCheckoutButton3.click();
        this.cartPage.hookPaymentButton.click();
        this.cartPage.confirmOrderButton.click();
        WebElement orderText = driver.findElement(By.xpath("//*[@id='center_column']/div/p/strong"));
        Assertions.assertTrue(orderText.getText().equals("Your order on My Store is complete."));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("Browser#setUpBrowser")
    public void BuyClothesFromRandomBasketTest(String browser) throws Exception {
        initialize(browser);
        this.user2 = new User("makings.officer.05@icloud.com");

        this.mainPage.header.searchField.sendKeys(this.searchWord);


        WebElement firstResult = new WebDriverWait(this.driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/ul")));



        List<WebElement> listOfElements = this.driver.findElements(By.xpath("/html/body/div[2]/ul"));
        listOfElements.get(0).click();

        this.mainPage.WaitForAddToCartButton();
        Thread.sleep(3600);
        this.mainPage.addToCartButton.click();
        Thread.sleep(3600);
        UserActions.signInToWebsite(this.driver, this.user2);
        this.driver.get(Urls.cartUrl);
        WebElement cartEmpty = this.driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]"));
        WebElement cartQuantity = this.driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]"));
        Assertions.assertTrue(cartEmpty.getAttribute("class").equals("ajax_cart_no_product unvisible"));
        Assertions.assertTrue(cartQuantity.getAttribute("class").equals("ajax_cart_quantity"));


        this.cartPage.proceedToCheckoutButton.click();
        this.cartPage.proceedToCheckoutButton2.click();
        this.cartPage.termsOfServiceCheckBox.click();
        this.cartPage.proceedToCheckoutButton3.click();
        this.cartPage.hookPaymentButton.click();
        this.cartPage.confirmOrderButton.click();
        WebElement orderText = driver.findElement(By.xpath("//*[@id='center_column']/div/p/strong"));
        Assertions.assertTrue(orderText.getText().equals("Your order on My Store is complete."));
    }

}
