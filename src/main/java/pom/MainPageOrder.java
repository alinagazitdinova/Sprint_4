package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageOrder {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By orderButton = By.className("Button_Button__ra12g");

    private final By orderButtonOne = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[5]/button[1]");
    private final By userNameInput = By.xpath(".//*[@placeholder='* Имя']");


    private WebDriver driver;

    public MainPageOrder(WebDriver driver) {
        this.driver = driver;

    }
    public void open(){
        driver.get(url);
    }
    public void scrollPage(){
        WebElement element = driver.findElement(orderButtonOne);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickOrderButtonOne(){
        driver.findElement(orderButtonOne).click();

    }


    public void clickOrderButton(){
        driver.findElement(orderButton).click();

    }


    public OrderForm1 orderForm1(){
        return new OrderForm1(driver);
    }
    public OrderForm2 orderForm2(){
        return new OrderForm2(driver);
    }
}
