package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageHeader header;
    public MainPageFooter footer;

    public MainPage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        this.driver = driver;
        this.header = new PageHeader(driver);
        this.footer = new MainPageFooter(driver);
        PageFactory.initElements(driver, this);
    }

    private final String proceedToCheckoutButtonLocator = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a";
    @FindBy(xpath = proceedToCheckoutButtonLocator)
    public WebElement proceedToCheckoutButton;


    private final String addToCartButtonLocator = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div/p/button";
    @FindBy(xpath = addToCartButtonLocator)
    public WebElement addToCartButton;

    public void WaitForProceedToCheckoutButton(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(proceedToCheckoutButtonLocator)));
    }

    public void WaitForAddToCartButton(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addToCartButtonLocator)));
    }
}
