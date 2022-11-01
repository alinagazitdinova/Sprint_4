

package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageSeven {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By Heading8 = By.id("accordion__heading-7");

    private WebDriver driver;
    public MainPageSeven(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get(url);
    }
    public void clickHeading8(){
        driver.findElement(Heading8).click();
    }
    public void scrollPage(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
}
