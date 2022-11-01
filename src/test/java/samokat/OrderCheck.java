package samokat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPageOrder;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)

public class OrderCheck {
    private final String userName;
    private final String userSurname;
    private final String userAdress;
    private final String userPhone;

    private final String userComment;

    private final String dateChoice;




    public OrderCheck(String userName, String userSurname, String userAdress, String userPhone, String userComment, String dateChoice) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAdress = userAdress;
        this.userPhone = userPhone;
        this.userComment = userComment;
        this.dateChoice = dateChoice;


    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Иван", "Иванов", "Иваново 3", "89999999999", "Оставьте самокат у двери", "05.11.2022"},
                { "Петр", "Петров", "Петрово 1", "87777777777", "Оставьте самокат под окном", "05.11.2022"},

        };
    }


    private WebDriver driver;

    @Before
    public void setUP() {
        driver = new FirefoxDriver(); //ChromeDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }


    @Test
    public void checkIfOrderSent1() {
        MainPageOrder mainPageOrder = new MainPageOrder(driver);

        mainPageOrder.open(); //Открыть страницу
        mainPageOrder.clickOrderButton(); // Нажать на кнопку Заказать
        mainPageOrder.orderForm1().inputUserName(userName); //Заполнить Имя
        mainPageOrder.orderForm1().inputUserSurname(userSurname); //Заполнить фамилию
        mainPageOrder.orderForm1().inputUserAdress(userAdress); //Заполнить адрес
        mainPageOrder.orderForm1().metro(); //Нажатие на поле станции и выбор станции в одном методе
        mainPageOrder.orderForm1().inputUserPhone(userPhone); //Заполнить телефон
        mainPageOrder.orderForm1().proceedButtonClick(); //Кликнуть кнопку далее
        mainPageOrder.orderForm2().setDateInput(dateChoice); // Выбрать дату
        mainPageOrder.orderForm2().dateButtonClick(); // Кликнуть на дату
        mainPageOrder.orderForm2().daysNumberInput(); //Выбрать кол-во дней
        mainPageOrder.orderForm2().checkBoxChoice(); //Выбрать чекбокс
        mainPageOrder.orderForm2().inputUserComment(userComment); //Оставляем комментарий
        mainPageOrder.orderForm2().orderFinalConfirmClick(); // Подтверждаем отправку заказа
        String text = driver.findElement(By.xpath(".//div[text()='Заказ оформлен']")).getText();
        String expected = "Заказ оформлен";
        Assert.assertThat(text, containsString(expected));


    }
    @Test
    public void checkIfOrderSent2() {
        MainPageOrder mainPageOrder = new MainPageOrder(driver);

        mainPageOrder.open();
        mainPageOrder.scrollPage();//Прокручиваем страничку
        mainPageOrder.clickOrderButtonOne(); //Кликем по другой кнопке Заказать
        mainPageOrder.orderForm1().inputUserName(userName); //Заполнить Имя
        mainPageOrder.orderForm1().inputUserSurname(userSurname); //Заполнить фамилию
        mainPageOrder.orderForm1().inputUserAdress(userAdress); //Заполнить адрес
        mainPageOrder.orderForm1().metro(); //Нажатие на поле станции и выбор станции в одном методе
        mainPageOrder.orderForm1().inputUserPhone(userPhone); //Заполнить телефон
        mainPageOrder.orderForm1().proceedButtonClick(); //Кликнуть кнопку далее
        mainPageOrder.orderForm2().setDateInput(dateChoice); // Выбрать дату
        mainPageOrder.orderForm2().dateButtonClick(); // Кликнуть на дату
        mainPageOrder.orderForm2().daysNumberInput(); //Выбрать кол-во дней
        mainPageOrder.orderForm2().checkBoxChoice(); //Выбрать чекбокс
        mainPageOrder.orderForm2().inputUserComment(userComment); //Оставляем комментарий
        mainPageOrder.orderForm2().orderFinalConfirmClick(); // Подтверждаем отправку заказа
        String text = driver.findElement(By.xpath(".//div[text()='Заказ оформлен']")).getText();
        String expected = "Заказ оформлен";
        Assert.assertThat(text, containsString(expected));


    }


    @After
    public void tearDown() {
        driver.quit();

    }
}
