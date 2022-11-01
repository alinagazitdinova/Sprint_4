package samokat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;

public class ImportantQuestionsCheckText {

    private WebDriver driver;

    @Before
    public void setUP(){
        driver = new FirefoxDriver(); //geckodriver

    }

    @Test
    public void neededTextWhenClicking1() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.open();

        mainPage.scrollPage();

        mainPage.clickHeading1();

        Thread.sleep(500); //по-другому тест падает(
        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-0']/p")).getText();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(expected, text);


    }
    @Test
    public void neededTextWhenClicking2() throws InterruptedException {

        MainPageOne mainPageOne = new MainPageOne(driver);

        mainPageOne.open();

        mainPageOne.scrollPage();

        mainPageOne.clickHeading2();

        Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-1']/p")).getText();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals(expected, text);


    }
    @Test
    public void neededTextWhenClicking3() throws InterruptedException {
        MainPageTwo mainPageTwo = new MainPageTwo(driver);

        mainPageTwo.open();

        mainPageTwo.scrollPage();

        mainPageTwo.clickHeading3();

        Thread.sleep(500);
        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-2']/p")).getText();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals(expected, text);


    }
    @Test
    public void neededTextWhenClicking4() throws InterruptedException {
        MainPageThree mainPageThree = new MainPageThree(driver);

        mainPageThree.open();

        mainPageThree.scrollPage();

        mainPageThree.clickHeading4();

        Thread.sleep(500);
        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-3']/p")).getText();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals(expected, text);


    }
    @Test
    public void neededTextWhenClicking5() throws InterruptedException {

        MainPageFour mainPageFour = new MainPageFour(driver);

        mainPageFour.open();

        mainPageFour.scrollPage();

        mainPageFour.clickHeading5();

        Thread.sleep(500);
        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-4']/p")).getText();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals(expected, text);
    }
    @Test
    public void neededTextWhenClicking6() throws InterruptedException {

        MainPageFive mainPageFive = new MainPageFive(driver);

        mainPageFive.open();

        mainPageFive.scrollPage();

        mainPageFive.clickHeading6();
        Thread.sleep(500);

        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-5']/p")).getText();

        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

        Assert.assertEquals(expected, text);
    }
    @Test
    public void neededTextWhenClicking7() throws InterruptedException {

        MainPageSix mainPageSix = new MainPageSix(driver);

        mainPageSix.open();

        mainPageSix.scrollPage();

        mainPageSix.clickHeading7();
        Thread.sleep(500);

        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-6']/p")).getText();

        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

        Assert.assertEquals(expected, text);
    }
    @Test
    public void neededTextWhenClicking8() throws InterruptedException {

        MainPageSeven mainPageSeven = new MainPageSeven(driver);

        mainPageSeven.open();

        mainPageSeven.scrollPage();

        mainPageSeven.clickHeading8();
        Thread.sleep(500);

        String text = driver.findElement(By.xpath("//*[@id= 'accordion__panel-7']/p")).getText();

        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        Assert.assertEquals(expected, text);
    }

    @After
    public void tearDown(){
        driver.quit();

    }
}
