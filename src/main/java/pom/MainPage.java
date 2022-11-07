package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/"; //url сервиса

    private final By CookiesButton = By.id("rcc-confirm-button"); //Локатор кнопки принять куки

    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    } //Открыть страницу

    public void scrollPage(){ //метод чтобы прокрутить страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
    public void cookiesButtonClick(){ //Метод для нажатия на кнопку принять куки
        driver.findElement(CookiesButton).click();
    };

    public OrderForm1 orderForm1(){
        return new OrderForm1(driver);
    }
    public OrderForm2 orderForm2(){
        return new OrderForm2(driver);
    }

}
