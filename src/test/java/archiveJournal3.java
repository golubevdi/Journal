import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

public class archiveJournal3 extends MainTest{
    public WebDriver driver;
    public static final By test3Button = By.id("104312");
    public static final By activateButton1 = By.id("103114");
    public static final By activateButton2 = By.id("103575");
    public static final By textMessage1 = By.id("103484");
    public static final By textComment1 = By.id("104002");
    public static final By textMessage2 = By.id("104083");
    public static final By textComment2 = By.id("104100");

    public archiveJournal3(WebDriver driver) {

        this.driver = driver;
    }
    @Step("Начало. Переход на страницу для теста")
    public void StartTest(){
        System.out.println("шаг 1 запуск браузера");
        String Base_URL = "http://127.0.0.1:8043";
        this.driver.get(Base_URL);
    }
    @Step("Проверка отображения в журнале пользовательского параметра тревоги")
    public void preparation1(String message_1_input, String comment_1_input, String message_2_input, String comment_2_input) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);
        //Поиск кнопки с переходом на окно теста 2
        driver.findElement(test3Button).click();
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Проверка нажата ли кнопка(если нажата, то отжать), для Тревоги 1
        WebElement search_button_act1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03114\").shadowRoot.querySelector(\"div[class]\")");
        String aClass1 = search_button_act1.getAttribute("class");
        System.out.println("Состояние кнопки Активность Тревоги 1 до начала теста: " + aClass1);
        if (aClass1.equals("tbmain button active")) {
            driver.findElement(activateButton1).click();
        }
        Thread.sleep(2000);

        //Проверка нажата ли кнопка(если нажата, то отжать), для Тревоги 2
        WebElement search_button_act2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03575\").shadowRoot.querySelector(\"div[class]\")");
        String aClass2 = search_button_act2.getAttribute("class");
        System.out.println("Состояние кнопки Активность Тревоги 2 до начала теста: " + aClass2);
        if (aClass2.equals("tbmain button active")) {
            driver.findElement(activateButton2).click();
        }
        //Увеличиваем значение инкремента Тревоги 1
        WebElement search_button_inc_up = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_up.click();
        Thread.sleep(2000);
        WebElement text_inc = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 08016\").shadowRoot.querySelector(\"div\")");
        String text_inc_output = text_inc.getText();
        //вывод значения инкремента Тревоги 1 в консоль
        System.out.println("приоритет тревоги 1: " + text_inc_output);
        //Увеличиваем значение инкремента Тревоги 1
        WebElement search_button_inc_up_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_up_2.click();
        search_button_inc_up_2.click();
        Thread.sleep(2000);
        WebElement text_inc_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 08031\").shadowRoot.querySelector(\"div\")");
        String text_inc2 = text_inc_2.getText();
        //вывод значения инкремента Тревоги 2 в консоль
        System.out.println("приоритет тревоги 2: " + text_inc2);
        Thread.sleep(2000);

        //Поиск элемента для задания сообщения Тревоги 1 и задание ему значения "сообщение"
        driver.findElement(textMessage1).sendKeys(message_1_input);
        //Поиск элемента для задания комментария Тревоги 1 и задание ему значения "комментарий"
        driver.findElement(textComment1).sendKeys(comment_1_input);
        //Поиск элемента для задания сообщения Тревоги 1 и задание ему значения "сообщение"
        driver.findElement(textMessage2).sendKeys(message_2_input);
        //Поиск элемента для задания комментария Тревоги 1 и задание ему значения "комментарий"
        driver.findElement(textComment2).sendKeys(comment_2_input);

        //Поиск кнопки "Активность" Тревоги 1 и клик по ней (кнопка с фиксацией, положение вкл.)
        driver.findElement(activateButton1).click();
        //Поиск кнопки "Активность" Тревоги 2 и клик по ней (кнопка с фиксацией, положение вкл.)
        driver.findElement(activateButton2).click();

        Thread.sleep(7000);
    }
}

