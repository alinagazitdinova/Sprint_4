package samokat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;
import pom.OrderForm2;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)

public class OrderCheck {
    private final String userName;
    private final String userSurname;
    private final String userAdress;
    private final String userPhone;
    private final String userComment;
    private final String buttonOrder;

    public OrderCheck(String userName, String userSurname, String userAdress, String userPhone, String userComment,  String buttonOrder ) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAdress = userAdress;
        this.userPhone = userPhone;
        this.userComment = userComment;
        this.buttonOrder = buttonOrder;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Иван", "Иванов", "Иваново 3", "89999999999", "Оставьте самокат у двери", ".//button[@class = 'Button_Button__ra12g']"},
                { "Петр", "Петров", "Петрово 1", "87777777777", "Оставьте самокат под окном", ".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"},

        };
    }
    private WebDriver driver;
    private String findText = ".//div[text()='Заказ оформлен']"; //Локатор элемента "Заказ оформлен..." при успешном оформлении заказа

    @Before
    public void setUP() {
        driver = new FirefoxDriver(); //ChromeDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void checkIfOrderSent1()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(); //Открыть страницу
        mainPage.cookiesButtonClick(); //Убираем куки
        driver.findElement(By.xpath(buttonOrder)).click(); //нажать кнопку заказать
        mainPage.orderForm1().inputUserName(userName); //Заполнить Имя
        mainPage.orderForm1().inputUserSurname(userSurname); //Заполнить фамилию
        mainPage.orderForm1().inputUserAdress(userAdress); //Заполнить адрес
        mainPage.orderForm1().metro(); //Нажатие на поле станции и выбор станции в одном методе
        mainPage.orderForm1().inputUserPhone(userPhone); //Заполнить телефон
        mainPage.orderForm1().proceedButtonClick(); //Кликнуть кнопку далее
        mainPage.orderForm2().setDateInput(); // Выбрать дату
        mainPage.orderForm2().dateButtonClick(); // Кликнуть на дату
        mainPage.orderForm2().daysNumberInput(); //Выбрать кол-во дней
        mainPage.orderForm2().checkBoxChoice(); //Выбрать чекбокс
        mainPage.orderForm2().inputUserComment(userComment); //Оставляем комментарий
        mainPage.orderForm2().orderFinalConfirmClick(); // Подтверждаем отправку заказа
        String text = driver.findElement(By.xpath(findText)).getText(); //Проверяем наличие нужного текста на странице заказа
        Assert.assertThat(text, containsString(OrderForm2.expectedText)); //Проверяем, что ожидаемый текст и фактический совпадают
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
