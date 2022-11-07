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

@RunWith(Parameterized.class)

public class ImportantQuestionsCheckText {
    private final String headingLocator;

    private final String answerLocator;

    private final String answerText;
    public ImportantQuestionsCheckText(String headingLocator, String answerLocator, String answerText ) {
        this.headingLocator = headingLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"accordion__heading-0", "//*[@id= 'accordion__panel-0']/p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-1", "//*[@id= 'accordion__panel-1']/p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"accordion__heading-2", "//*[@id= 'accordion__panel-2']/p", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"accordion__heading-3", "//*[@id= 'accordion__panel-3']/p", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"accordion__heading-4", "//*[@id= 'accordion__panel-4']/p", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"accordion__heading-5", "//*[@id= 'accordion__panel-5']/p", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"accordion__heading-6", "//*[@id= 'accordion__panel-6']/p", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"accordion__heading-7", "//*[@id= 'accordion__panel-7']/p", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }

    private WebDriver driver;

    @Before
    public void setUP(){
        driver = new FirefoxDriver(); //ChromeDriver
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //Так некоторые тесты падают(
    }

    @Test
    public void neededTextWhenClicking() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.cookiesButtonClick();
        mainPage.scrollPage();
        Thread.sleep(500);
        driver.findElement(By.id(headingLocator)).click();
        //new WebDriverWait(driver, Duration.ofSeconds(10))
               // .until(ExpectedConditions.elementToBeClickable(By.xpath(answerLocator))); //Пробовала так, некоторые тесты все равно падают.
        Thread.sleep(1000);
        String text = driver.findElement(By.xpath(answerLocator)).getText();
        Assert.assertEquals(answerText, text);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
