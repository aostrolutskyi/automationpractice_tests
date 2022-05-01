package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebLibrary {

    public static boolean isElementPresent(WebElement element) throws Exception {

        try {

            element.getText();

        } catch (NoSuchElementException e) {

            return false;

        } catch (Exception e) {

            throw new Exception("Unexpected Exception. " + e.getClass() + ", " + e.getMessage());
        }


        return true;
    }
}
