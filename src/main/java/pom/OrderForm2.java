package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderForm2 {
    public final By dateButton = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--005 react-datepicker__day--weekend']");
    public final By daysOption = By.xpath(".//span[@class = 'Dropdown-arrow']");
    public final By daysChoice = By.xpath(".//div[@class = 'Dropdown-option']");
    public final By checkBox = By.xpath(".//input[@id = 'black']");
    public final By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    public final By orderButtonYes = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[5]/div[2]/button[2]");

    public final By dateInput = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    public final By userComment = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");

    private WebDriver driver;

    public OrderForm2(WebDriver driver) {
        this.driver = driver;
    }


    public void setDateInput(String text){
        driver.findElement(dateInput).sendKeys(text);
    }
    public void dateButtonClick(){
        driver.findElement(dateButton).click();
    }


    public void daysOptionClick(){
        driver.findElement(daysOption).click();
    }
    public void daysChoiceClick(){
        driver.findElement(daysChoice).click();
    }
    public void daysNumberInput(){
        daysOptionClick();
        daysChoiceClick();

    }
    public void checkBoxChoice(){
        driver.findElement(checkBox).click();
    }
    public void inputUserComment(String text){
        driver.findElement(userComment).sendKeys(text);
    }
    public void orderConfirmClick(){
        driver.findElement(orderButton).click();
    }
    public void orderConfirmYesClick(){
        driver.findElement(orderButtonYes).click();
    }
    public void orderFinalConfirmClick(){
        orderConfirmClick();
        orderConfirmYesClick();

    }
}