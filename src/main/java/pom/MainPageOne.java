package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageOne {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By Heading2 = By.id("accordion__heading-1");

    private WebDriver driver;
    public MainPageOne(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get(url);
    }
    public void clickHeading2(){
        driver.findElement(Heading2).click();
    }
    public void scrollPage(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
}
