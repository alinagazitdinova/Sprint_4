

package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageThree {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By Heading4 = By.id("accordion__heading-3");

    private WebDriver driver;
    public MainPageThree(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get(url);
    }
    public void clickHeading4(){
        driver.findElement(Heading4).click();
    }
    public void scrollPage(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
}
