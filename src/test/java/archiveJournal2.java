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

        //Проверка нажата ли кнопка Тревоги 1 (если нажата, то отжать)
        WebElement search_button_act = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4893\").shadowRoot.querySelector(\"div[class]\")");
        String aClass = search_button_act.getAttribute("class");
        System.out.println(aClass);

        //Если "tbmain button active", то кнопку надо отжать
        if (aClass.equals("tbmain button active")) {
            driver.findElement(activateButton2).click();
        }

        //Ожидание
        Thread.sleep(2000);

        //Проверка нажата ли кнопка Тревоги 2 (если нажата, то отжать)
        WebElement search_button_act2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 8089\").shadowRoot.querySelector(\"div[class]\")");
        String aClass2 = search_button_act2.getAttribute("class");
        System.out.println(aClass2);

        //Если "tbmain button active", то кнопку надо отжать
        if (aClass.equals("tbmain button active")) {
            driver.findElement(activateButton3).click();
        }

        //Ожидание
        Thread.sleep(2000);

        //Активация Тревоги 1
        driver.findElement(activateButton2).click();

        //Ожидание появления сообщения в журнале
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

        //Ожидание появления квитированного сообщения в журнале
        Thread.sleep(2000);

        //Деактивация тревоги 1
        driver.findElement(activateButton2).click();

        //Ожидание появления сообщения в журнале
        Thread.sleep(2000);

        //Активация тревоги 2
        driver.findElement(activateButton3).click();

        //Ожидание появления сообщения в журнале
        Thread.sleep(2000);

        //Деактивация тревоги 2
        driver.findElement(activateButton3).click();

        //Ожидание появления сообщения в журнале
        Thread.sleep(2000);
    }

    @Step("Проверка цветов")
    public void compareColor(String color_act, String color_deact, String color_ack, String color_act_2,
                             String color_deact_2) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Поиск цвета у события "Появление" Тревоги 1
        WebElement color_message_active = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(5)')");
        String col_activ = color_message_active.getAttribute("style");
        System.out.println("цвет события появление тревоги 1: "+col_activ);

        //Ожидание
        Thread.sleep(2000);

        //Поиск цвета у события "Исчезновение" Тревоги 1
        WebElement color_message_deactiv = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(3)')");
        String col_deact = color_message_deactiv.getAttribute("style");
        System.out.println("цвет события исчезновение тревоги 1: "+col_deact);

        //Поиск цвета у события "Квитирование" Тревоги 1
        WebElement color_message_acked = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(4')");
        String col_acked = color_message_acked.getAttribute("style");
        System.out.println("цвет события квитирования тревоги 1: "+col_acked);

        //Поиск цвета у события "Исчезновение" Тревоги 2
        WebElement color_message_deactiv_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(\"tbody>tr\")");
        String col_deact_2 = color_message_deactiv_2.getAttribute("style");
        System.out.println("цвет события исчезновение тревоги 2: "+col_deact_2);

        //Поиск цвета у события "Появление" Тревоги 2
        WebElement color_message_active_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\39 4664\").shadowRoot.querySelector(' tr:nth-child(2)')");
        String col_activ_2 = color_message_active_2.getAttribute("style");
        System.out.println("цвет события появление тревоги 1: "+col_activ_2);

        //Сравнение цветов
        Assertions.assertEquals(color_act, col_activ);
        Assertions.assertEquals(color_deact, col_deact);
        Assertions.assertEquals(color_ack, col_acked);
        Assertions.assertEquals(color_deact_2, col_deact_2);
        Assertions.assertEquals(color_act_2, col_activ_2);
        //Ожидание перед закрытием
        Thread.sleep(10000);
    }
}
