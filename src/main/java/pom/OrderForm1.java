package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderForm1 {
    public final By userName = By.xpath(".//*[@placeholder='* Имя']"); //Локатор поля Имя
    public final By userSurname = By.xpath(".//*[@placeholder='* Фамилия']"); //Локатор поля Фамилия
    public final By userAdress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']"); //Локатор поля Адрес
    public final By metroStation = By.xpath(".//*[@class='select-search__input']"); //Локатор поля метро
    public final By metroStationOption = By.xpath(".//*[@class='select-search__select']"); //Локатор для элементов выпадающего списка метро
    public final By proceedButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //Локатор кнопки Далее
    public final By userPhone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']"); //Локатор поля телефон
    private WebDriver driver;
    public OrderForm1(WebDriver driver) {
        this.driver = driver;
    }
    public void inputUserName(String text){ //Метод для заполнения поля Имя
        driver.findElement(userName).sendKeys(text);

    }
    public void inputUserSurname(String text){ //Метод для заполнения поля Фамилия
        driver.findElement(userSurname).sendKeys(text);
    }
    public void inputUserAdress(String text){ //Метод для заполнения поля Адрес
        driver.findElement(userAdress).sendKeys(text);
    }
    public void inputUserPhone(String text){//Метод для заполнения телефона
        driver.findElement(userPhone).sendKeys(text);
    }

    public void setMetroStationClick(){ //Метод для клика на поле метро
        driver.findElement(metroStation).click();
    }
    public void setMetroStationOptionClick(){ //Метод для выбора станции
        driver.findElement(metroStationOption).click();
    }
    public void metro(){//Объединение методов кликнуть на поле метро и выбрать станцию
        setMetroStationClick();
        setMetroStationOptionClick();
    }
    public void proceedButtonClick(){//Метод для нажатия на кнопку Далее
        driver.findElement(proceedButton).click();
    }
}
