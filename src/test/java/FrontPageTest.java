import configuration.BrowserList;
import configuration.Urls;
import helpers.WebBrowser;
import helpers.WebLibrary;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


@ExtendWith(SerenityJUnit5Extension.class)
public class FrontPageTest{

    WebDriver driver;
    protected MainPage mainPage;

    public void initialize(String browserName){
        this.driver = WebBrowser.setWebBrowser(browserName);
        this.mainPage = new MainPage(driver);
        this.driver.get(Urls.frontPageUrl);
    }


    @AfterEach
    public void AfterTest() {
        this.driver.quit();
    }

    public static final String[] list= {"Chrome", "FireFox" };

    @ParameterizedTest(name = "{0}")
    @MethodSource("Browser#setUpBrowser")
    public void isFacebookLogoOnPage (String browser) throws Exception {
        initialize(browser);
        Assertions.assertTrue(WebLibrary.isElementPresent(mainPage.footer.facebookLogo), "There is no Facebook Logo in footer of the home page.");
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("Browser#setUpBrowser")
    public void isHeaderLogoOnPage (String browser) throws Exception {
        initialize(browser);
        Assertions.assertTrue(WebLibrary.isElementPresent(mainPage.header.logoImage), "There is no Logo in header of the home page.");
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("Browser#setUpBrowser")
    public void isSearchFieldOnPage (String browser) throws Exception {
        initialize(browser);
        Assertions.assertTrue(WebLibrary.isElementPresent(mainPage.header.searchField), "There is no Search Field in header of the home page.");
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("Browser#setUpBrowser")
    public void isCartLinkOnPage (String browser) throws Exception {
        initialize(browser);
        Assertions.assertTrue(WebLibrary.isElementPresent(mainPage.header.cartLink), "There is no Cart Link in header of the home page.");
    }
}
