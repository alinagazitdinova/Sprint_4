

package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageFour {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By Heading5 = By.id("accordion__heading-4");

    private WebDriver driver;
    public MainPageFour(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get(url);
    }
    public void clickHeading5(){
        driver.findElement(Heading5).click();
    }
    public void scrollPage(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
}
