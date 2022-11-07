package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderForm2 {
    public final By dateButton = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--010']"); //Локатор выбора даты в календаре
    public final By daysOption = By.xpath(".//span[@class = 'Dropdown-arrow']"); //Локатор поля дл выбора срока аренды
    public final By daysChoice = By.xpath(".//div[@class = 'Dropdown-option']"); //Локатор для выбора из выпадающего списка суток
    public final By checkBox = By.xpath(".//input[@id = 'black']"); //Локатор для выбора черного чек-бокса
    public final By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");//Локатор кнопки заказать
    public final By orderButtonYes = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[5]/div[2]/button[2]");//Локатор кнопки Да
    public final By dateInput = By.xpath(".//input[@placeholder = '* Когда привезти самокат']"); //Локатор поля ввода даты
    public final By userComment = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");//Локатор поля комментарий
    public static final String expectedText = "Заказ оформлен"; //Ожидаемый текст, если заказа оформлен
    private WebDriver driver;
    public OrderForm2(WebDriver driver) {
        this.driver = driver;
    }
    public void setDateInput(){ //Метод для нжатия на поле Дата
        driver.findElement(dateInput).click();
    }
    public void dateButtonClick(){
        driver.findElement(dateButton).click();
    } //Метод для выбора даты в календаре
    public void daysOptionClick(){
        driver.findElement(daysOption).click();
    }//Нажать на поле выбора кол-ва дней
    public void daysChoiceClick(){
        driver.findElement(daysChoice).click();
    } //Выбрать кол-во дней
    public void daysNumberInput(){
        daysOptionClick();//Два предыдущих метода в одном
        daysChoiceClick();
    }
    public void checkBoxChoice(){
        driver.findElement(checkBox).click();
    } //Метод выбора чек-бокса
    public void inputUserComment(String text){//Метод для ввода комментария
        driver.findElement(userComment).sendKeys(text);
    }
    public void orderConfirmClick(){
        driver.findElement(orderButton).click();
    } //Метод для отправки заказа
    public void orderConfirmYesClick(){
        driver.findElement(orderButtonYes).click();
    } //Метод для подтверждения заказа
    public void orderFinalConfirmClick(){ //Заказать и подтвердить заказ
        orderConfirmClick();
        orderConfirmYesClick();
    }
}