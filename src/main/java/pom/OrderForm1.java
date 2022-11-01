package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderForm1 {
    public final By userName = By.xpath(".//*[@placeholder='* Имя']");

    public final By userSurname = By.xpath(".//*[@placeholder='* Фамилия']");

    public final By userAdress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    public final By metroStation = By.xpath(".//*[@class='select-search__input']");
    public final By metroStationOption = By.xpath(".//*[@class='select-search__select']");
    public final By proceedButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public final By userPhone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    private WebDriver driver;

    public OrderForm1(WebDriver driver) {
        this.driver = driver;
    }
    public void inputUserName(String text){
        driver.findElement(userName).sendKeys(text);

    }
    public void inputUserSurname(String text){
        driver.findElement(userSurname).sendKeys(text);

    }
    public void inputUserAdress(String text){
        driver.findElement(userAdress).sendKeys(text);

    }
    public void inputUserPhone(String text){
        driver.findElement(userPhone).sendKeys(text);

    }

    public void setMetroStationClick(){
        driver.findElement(metroStation).click();

    }
    public void setMetroStationOptionClick(){
        driver.findElement(metroStationOption).click();

    }
    public void metro(){
        setMetroStationClick();
        setMetroStationOptionClick();

    }
    public void proceedButtonClick(){
        driver.findElement(proceedButton).click();

    }
}
