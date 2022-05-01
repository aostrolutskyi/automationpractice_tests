package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public PageHeader header;
    public MainPageFooter footer;

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.header = new PageHeader(driver);
        this.footer = new MainPageFooter(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id='center_column']/form/p/button")
    public WebElement proceedToCheckoutButton2;

    @FindBy(xpath = "//*[@id='form']/p/button")
    public WebElement proceedToCheckoutButton3;

    @FindBy(xpath = "//*[@id='cgv']")
    public WebElement termsOfServiceCheckBox;

    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    public WebElement hookPaymentButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    public WebElement confirmOrderButton;

    //*[@id="header"]/div[3]/div/div/div[3]/div/a/span[1]
}
