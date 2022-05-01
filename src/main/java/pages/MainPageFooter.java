package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageFooter {

    private WebDriver driver;

    public MainPageFooter(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//*[@id='social_block']/ul/li[1]/a")
    public WebElement facebookLogo;

}
