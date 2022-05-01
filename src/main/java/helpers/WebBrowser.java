package helpers;

import configuration.ChromeDriverConfiguration;
import configuration.FirefoxDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebBrowser {


    public static WebDriver setWebBrowser(String browserName){
        WebDriver driver = null;

        if (browserName.equals("Chrome")){
            ChromeDriverConfiguration.setDriverPath();
            driver = new ChromeDriver(ChromeDriverConfiguration.setDriverOptions());

        }
        else
            if (browserName.equals("FireFox")) {
                FirefoxDriverConfiguration.setDriverPath();
                driver = new FirefoxDriver();
            }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        return driver;
    }

}
