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
    public void preparation1() throws InterruptedException{
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
        System.out.println(aClass1);
        if (aClass1.equals("tbmain button active")) {
            driver.findElement(activateButton1).click();
        }
        Thread.sleep(2000);

        //Проверка нажата ли кнопка(если нажата, то отжать), для Тревоги 2
        WebElement search_button_act2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03575\").shadowRoot.querySelector(\"div[class]\")");
        String aClass2 = search_button_act2.getAttribute("class");
        System.out.println(aClass2);
        if (aClass2.equals("tbmain button active")) {
            driver.findElement(activateButton2).click();
        }
    }
}

