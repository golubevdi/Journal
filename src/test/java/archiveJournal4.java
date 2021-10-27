import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;


public class archiveJournal4 extends MainTest{
    public WebDriver driver;
    public static final By test4Button = By.id("128427");
    public static final By activateButton1 = By.id("128530");
    public static final By activateButton2 = By.id("128586");
    public static final By activateButton3 = By.id("128612");

    public archiveJournal4(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Начало. Запуск браузера")
    public void StartTest(){
        System.out.println("шаг 1 запуск браузера");
        System.out.println("-------------------------------------------------------");
        String Base_URL = "http://127.0.0.1:8043";
        this.driver.get(Base_URL);
    }

    @Step("Переход на станицу Тест 4")
    public void test4page() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("шаг 2 переход на окно теста");
        System.out.println("-------------------------------------------------------");

        //Поиск кнопки с переходом на окно теста 4
        driver.findElement(test4Button).click();
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);
    }
    @Step("Активация Тревог с нужным приоритетом")
    public void alarms() throws InterruptedException {
        System.out.println("шаг 3 активация Тревог с нужным приоритетом");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Поиск атрибута Тревоги 1 (tbmain button active - нажата; tbmain button - отжата)
        WebElement search_button_act1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28530\").shadowRoot.querySelector(\"div[class]\")");
        String aClass1 = search_button_act1.getAttribute("class");
        System.out.println("Состояние кнопки Активность Тревоги 1 до начала теста: " + aClass1);
        System.out.println("-------------------------------------------------------");

        //Проверка нажата ли кнопка Тревоги 1 (если нажата, то отжать)
        if (aClass1.equals("tbmain button active")) {
            driver.findElement(activateButton1).click();
        }
        Thread.sleep(2000);

        //Поиск атрибута Тревоги 2 (tbmain button active - нажата; tbmain button - отжата)
        WebElement search_button_act2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28586\").shadowRoot.querySelector(\"div[class]\")");
        String aClass2 = search_button_act2.getAttribute("class");
        System.out.println("Состояние кнопки Активность Тревоги 2 до начала теста: " + aClass2);
        System.out.println("-------------------------------------------------------");

        //Проверка нажата ли кнопка Тревоги 2 (если нажата, то отжать)
        if (aClass2.equals("tbmain button active")) {
            driver.findElement(activateButton2).click();
        }
        Thread.sleep(2000);

        //Поиск атрибута Тревоги 3 (tbmain button active - нажата; tbmain button - отжата)
        WebElement search_button_act3 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28612\").shadowRoot.querySelector(\"div[class]\")");
        String aClass3 = search_button_act3.getAttribute("class");
        System.out.println("Состояние кнопки Активность Тревоги 3 до начала теста: " + aClass3);
        System.out.println("-------------------------------------------------------");

        //Проверка нажата ли кнопка Тревоги 2 (если нажата, то отжать)
        if (aClass3.equals("tbmain button active")) {
            driver.findElement(activateButton3).click();
        }
        Thread.sleep(2000);

        //Проверка есть ли значение в инкременте 1
        String s_inc_1 = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28638\").shadowRoot.querySelector(\"#numberTextBox\").value");
        while (!s_inc_1.equals("0")){
            WebElement search_button_inc_1_down = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28638\").shadowRoot.querySelector(\"#decr\")");
            search_button_inc_1_down.click();

            s_inc_1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28638\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }
        Thread.sleep(2000);

        //Увеличиваем значение инкремента Тревоги 1
        WebElement search_button_inc_1_up = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28638\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_1_up.click();
        Thread.sleep(2000);

        //Проверка есть ли значение в инкременте 2
        String s_inc_2 = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28655\").shadowRoot.querySelector(\"#numberTextBox\").value");
        while (!s_inc_2.equals("0")){
            WebElement search_button_inc_2_down = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28655\").shadowRoot.querySelector(\"#decr\")");
            search_button_inc_2_down.click();

            s_inc_2 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28655\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }
        Thread.sleep(2000);

        //Увеличиваем значение инкремента Тревоги 2
        WebElement search_button_inc_2_up = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28655\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_2_up.click();
        Thread.sleep(500);
        search_button_inc_2_up.click();
        Thread.sleep(500);

        //Проверка есть ли значение в инкременте 3
        String s_inc_3 = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28672\").shadowRoot.querySelector(\"#numberTextBox\").value");
        while (!s_inc_3.equals("0")){
            WebElement search_button_inc_3_down = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28672\").shadowRoot.querySelector(\"#decr\")");
            search_button_inc_3_down.click();

            s_inc_3 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28672\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }
        Thread.sleep(2000);

        //Увеличиваем значение инкремента Тревоги 3
        WebElement search_button_inc_3_up = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28672\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_3_up.click();
        Thread.sleep(500);
        search_button_inc_3_up.click();
        Thread.sleep(1000);
        search_button_inc_3_up.click();
        Thread.sleep(2000);

        //Проверка есть ли значение в текстовом вводе для сообщения Тревоги 1
        String s_mes_1 = (String)
                jse.executeScript
                      ("return document.querySelector(\"#\\\\31 28776\").shadowRoot.querySelector(\"input[type=text]\").value");
        System.out.println(s_mes_1);

        while (s_mes_1.length()>0){

            WebElement search_input_mes_1 = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28776\").shadowRoot.querySelector(\"input[type=text]\")");

            System.out.println("Отправка Back_space");
            search_input_mes_1.sendKeys("\b");


            s_mes_1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28776\").shadowRoot.querySelector(\"input[type=text]\").value");
        }

        //Проверка есть ли значение в текстовом вводе для сообщения Тревоги 2
        String s_mes_2 = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28804\").shadowRoot.querySelector(\"input[type=text]\").value");
        System.out.println(s_mes_2);
        Thread.sleep(1000);
        while (s_mes_2.length()>0){

            WebElement search_input_mes_2 = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28804\").shadowRoot.querySelector(\"input[type=text]\")");

            System.out.println("Отправка Back_space");
            search_input_mes_2.sendKeys("\b");


            s_mes_2 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28804\").shadowRoot.querySelector(\"input[type=text]\").value");
        }
        Thread.sleep(1000);
        //Проверка есть ли значение в текстовом вводе для сообщения Тревоги 3
        String s_mes_3 = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28790\").shadowRoot.querySelector(\"input[type=text]\").value");
        System.out.println(s_mes_3);

        while (s_mes_3.length()>0){

            WebElement search_input_mes_3 = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28790\").shadowRoot.querySelector(\"input[type=text]\")");

            System.out.println("Отправка Back_space");
            search_input_mes_3.sendKeys("\b");


            s_mes_3 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 28790\").shadowRoot.querySelector(\"input[type=text]\").value");
        }

        Thread.sleep(2000);

        //Активация тревог
        driver.findElement(activateButton1).click();
        driver.findElement(activateButton2).click();
        driver.findElement(activateButton3).click();
        Thread.sleep(1000);

        //Деактивация тревог
        driver.findElement(activateButton1).click();
        driver.findElement(activateButton2).click();
        driver.findElement(activateButton3).click();
        Thread.sleep(1000);

        //Квитировать все
        WebElement acked_all = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j--all.btn\")");
        acked_all.click();
        Thread.sleep(3000);
    }
}
