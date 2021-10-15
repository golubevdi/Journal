import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class archiveJournal2 extends MainTest{

    public WebDriver driver;
    public static final By test2Button = By.id("95231");
    public static final By activateButton2 = By.id("94893");
    public static final By activateButton3 = By.id("98089");

    public archiveJournal2(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Начало. Переход на страницу для теста")
    public void StartTest(){
        System.out.println("шаг 1 запуск браузера");
        String Base_URL = "http://127.0.0.1:8043";
        this.driver.get(Base_URL);
    }
    @Step("Активация, квитирование и деактивация сообщений")
    public void preparation() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);
        //Поиск кнопки с переходом на окно теста 2
        driver.findElement(test2Button).click();
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Проверка нажата ли кнопка(если нажата, то отжать)
        WebElement search_button_act = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4893\").shadowRoot.querySelector(\"div[class]\")");
        String aClass = search_button_act.getAttribute("class");
        System.out.println(aClass);
        if (aClass.equals("tbmain button active")) {
            driver.findElement(activateButton2).click();
        }
        Thread.sleep(2000);
        //Проверка нажата ли кнопка(если нажата, то отжать)
        WebElement search_button_act2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 8089\").shadowRoot.querySelector(\"div[class]\")");
        String aClass2 = search_button_act2.getAttribute("class");
        System.out.println(aClass2);
        if (aClass.equals("tbmain button active")) {
            driver.findElement(activateButton3).click();
        }
        Thread.sleep(2000);
        //Активация Тревоги 1
        driver.findElement(activateButton2).click();
        Thread.sleep(2000);
        //Поиск кнопки "квит" у Тревоги 1
        WebElement search_button_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelectorAll(\".ack\")[0]");
        //Клик по кнопке "квит"
        search_button_1.click();
        //Поиск кнопки подтверждения квитирования "ок"
        WebElement search_button_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(\"#btnOk\")");
        //Подтверждение квитирования "ок"
        search_button_2.click();
        Thread.sleep(2000);
        //Деактивация тревоги 1
        driver.findElement(activateButton2).click();
        Thread.sleep(2000);
        //Активация тревоги 2
        driver.findElement(activateButton3).click();
        Thread.sleep(2000);
        //Деактивация тревоги 2
        driver.findElement(activateButton3).click();
        Thread.sleep(2000);

    }
    @Step("Проверка цветов")
    public void compareColor(String color_act, String color_deact, String color_ack) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Поиск цвета у события "Появление" Тревоги 1
        WebElement color_message_active = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(5)')");
        String col_activ = color_message_active.getAttribute("style");
        System.out.println("цвет события появление: "+col_activ);
        //Ожидание
        Thread.sleep(2000);
        //Поиск цвета у события "Исчезновение" Тревоги 1
        WebElement color_message_deactiv = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(3)')");
        String col_deact = color_message_deactiv.getAttribute("style");
        System.out.println("цвет события исчезновение: "+col_deact);
        //Поиск цвета у события "Квитирование" Тревоги 1
        WebElement color_message_acked = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(4')");
        String col_acked = color_message_acked.getAttribute("style");
        System.out.println("цвет события квитирования: "+col_acked);
        //Сравнение цветов
        Assertions.assertEquals(color_act, col_activ);
        Assertions.assertEquals(color_deact, col_deact);
        Assertions.assertEquals(color_ack, col_acked);
        //Ожидание перед закрытием
        Thread.sleep(10000);
    }
}
