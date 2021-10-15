import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class archiveJournal3 extends MainTest{
    public WebDriver driver;
    public static final By test3Button = By.id("104312");
    public static final By activateButton1 = By.id("103114");
    public static final By activateButton2 = By.id("103575");
    public static final By textMessage1 = By.id("111187");
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
    @Step("Активация, квитирование и деактивация Тревоги 1 и Тревоги 2")
    public void preparation1(String message_1_input, String comment_1_input, String message_2_input, String comment_2_input) throws InterruptedException {
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

        //Поиск значения инкремента 2 (через текст)
        WebElement text_inc_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 08031\").shadowRoot.querySelector(\"div\")");
        String incText2 = text_inc_2.getText();


        //вывод значения инкремента Тревоги 2 в консоль
        System.out.println("приоритет тревоги 2: " + incText2);
        Thread.sleep(2000);
        //Увеличиваем значение инкремента Тревоги 2
        WebElement search_button_inc_up_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_up_2.click();
        search_button_inc_up_2.click();
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
        Thread.sleep(2000);
        //Поиск кнопки "квит" у последнего появившегося сообщения в архивном журнале
        WebElement search_button1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelectorAll(\".ack\")[0]");
        //Клик по кнопке
        search_button1.click();
        Thread.sleep(2000);
        //Поиск кнопки "Активность" Тревоги 1 и клик по ней (кнопка с фиксацией, положение выкл.)
        driver.findElement(activateButton1).click();
    }
    @Step("Проверка столбцов журнала у события квитирование")
    public void acked() throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Поиск значения приоритет (событие квитирование)
        WebElement priority_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(5)\")");
        //Из поля в параметр String
        String priorityAckedText1 = priority_acked_1.getText();

        //Поиск у сообщения (событие квитирование) поля Событие
        WebElement event_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(4)\")");
        //Из поля в параметр String
        String ackedText1 = event_acked_1.getText();

        //Поиск у сообщения (событие квитирование) поля Сообщение
        WebElement message_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(7)\")");
        //Из поля в параметр String
        String messageAckText1 = message_acked_1.getText();

        //Поиск у сообщения (событие квитирование) поля Комментарий
        WebElement comment_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(8)\")");
        //Из поля в параметр String
        String commentAckText1 = comment_acked_1.getText();

        //Поиск у сообщения (событие квитирование) поля Полное имя
        WebElement full_name_object_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(9)\")");
        //Из поля в параметр String
        String fullNameObjectAckText1 = full_name_object_acked_1.getText();

        //Поиск у сообщения (событие квитирование) поля Имя объекта
        WebElement name_object_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(10)\")");
        //Из поля в параметр String
        String nameObjectAckText1 = name_object_acked_1.getText();

        //Поиск у сообщения (событие квитирование) поля Источник
        WebElement source_acked_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(2) > td:nth-child(11)\")");
        //Из поля в параметр String
        String sourceAckText1 = source_acked_1.getText();

        //Поиск значения инкремента 1 (через текст)
        WebElement text_inc = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 08016\").shadowRoot.querySelector(\"div\")");
        String inc1 = text_inc.getText();

        //Вывод параметров в консоль
        System.out.println("ДЛЯ ТРЕВОГИ 1: " + "Приоритет : " + priorityAckedText1);
        System.out.println("Событие: "
                + ackedText1 + "; Сообщение: " + messageAckText1);
        System.out.println("; Комментарий: " + commentAckText1 + "; Полное имя объекта: "
                + fullNameObjectAckText1 + "; Объект: " + nameObjectAckText1 + "Источник: " + sourceAckText1);

        //Проверки
        Assertions.assertEquals(inc1, priorityAckedText1);
        Thread.sleep(10000);
    }
    @Step("Проверка столбцов журнала у события появление")
    public void on() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Поиск у сообщения (событие появление) поля Событие
        WebElement event_on1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(4)\")");
        //Из поля в параметр String
        String OnText1 = event_on1.getText();

        //Поиск у сообщения (событие появление) поля Сообщение
        WebElement message_on_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(7)\")");
        //Из поля в параметр String
        String messageOnText1 = message_on_1.getText();

        //Поиск у сообщения (событие появление) поля Комментарий
        WebElement comment_on_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(8)\")");
        //Из поля в параметр String
        String commentOnText1 = comment_on_1.getText();

        //Поиск у сообщения (событие появление) поля Полное имя
        WebElement fullName_object_on_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(9)\")");
        //Из поля в параметр String
        String fullNameObjectOnText1 = fullName_object_on_1.getText();

        //Поиск у сообщения (событие появление) поля Имя объекта
        WebElement name_object_on_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(10)\")");
        //Из поля в параметр String
        String nameObjectOnText1 = name_object_on_1.getText();

        //Поиск у сообщения (событие появление) поля Источник
        WebElement source_on_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(11)\")");
        //Из поля в параметр String
        String sourceOnText1 = source_on_1.getText();


        //Вывод в консоль
        System.out.println("Событие: "
                + OnText1 + "; Сообщение: " + messageOnText1);
        System.out.println("; Комментарий: " + commentOnText1 + "; Полное имя объекта: "
                + fullNameObjectOnText1 + "; Объект: " + nameObjectOnText1 + "Источник: " + sourceOnText1);

        //Поиск кнопки "Активность" Тревоги 2 и клик по ней (кнопка с фиксацией, положение вкл.)
        //driver.findElement(activateButton2).click();
    }
    @Step("Проверка столбцов журнала у события исчезновение")
    public void off() throws InterruptedException {
        Thread.sleep(7000);
    }
}

