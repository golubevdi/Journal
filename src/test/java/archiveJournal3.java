import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;


public class archiveJournal3 extends MainTest{
    public WebDriver driver;
    public static final By test3Button = By.id("104312");
    public static final By activateButton1 = By.id("103114");
    public static final By activateButton2 = By.id("103575");
    public static final By textMessage1 = By.id("111187");
    public static final By textComment1 = By.id("104002");
    public static final By textMessage2 = By.id("104083");
    public static final By textComment2 = By.id("104100");
    public static final By resetButton1 = By.id("120081");
    public static final By resetButton2 = By.id("120120");


    public archiveJournal3(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Начало. Переход на страницу для теста")
    public void StartTest(){
        System.out.println("шаг 1 запуск браузера");
        System.out.println("-------------------------------------------------------");
        String Base_URL = "http://127.0.0.1:8043";
        this.driver.get(Base_URL);
    }

    @Step("Переход на станицу Тест 3")
    public void test3page() throws InterruptedException {
        Thread.sleep(2000);
        //Поиск кнопки с переходом на окно теста 2
        driver.findElement(test3Button).click();
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);
    }

    @Step("Активация, квитирование и деактивация Тревоги 1")
    public void alarm1(String message_1_input, String comment_1_input) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Проверка нажата ли кнопка(если нажата, то отжать), для Тревоги 1
        WebElement search_button_act1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03114\").shadowRoot.querySelector(\"div[class]\")");
        String aClass1 = search_button_act1.getAttribute("class");
        System.out.println("Состояние кнопки Активность Тревоги 1 до начала теста: " + aClass1);
        System.out.println("-------------------------------------------------------");

        //Проверка нажата ли кнопка Тревоги 1 (если нажата, то отжать)
        if (aClass1.equals("tbmain button active")) {
            driver.findElement(activateButton1).click();
        }
        Thread.sleep(2000);

        //Сброс сообщений
        driver.findElement(resetButton1).click();

        //Проверка есть ли значение в инкременте 1
        String s_inc = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#numberTextBox\").value");
        while (!s_inc.equals("0")){
            WebElement search_button_inc_down = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#decr\")");
            search_button_inc_down.click();

            //Ожидание между кликами по инкременту
            //Thread.wait(500);
            s_inc = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }
        Thread.sleep(2000);

        //Увеличиваем значение инкремента Тревоги 1
        WebElement search_button_inc_up = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#incr\")");
        search_button_inc_up.click();
        Thread.sleep(2000);

        //Поиск элемента для задания сообщения Тревоги 1 и задание ему значения "сообщение"
        driver.findElement(textMessage1).sendKeys(message_1_input);

        //Поиск элемента для задания комментария Тревоги 1 и задание ему значения "комментарий"
        driver.findElement(textComment1).sendKeys(comment_1_input);


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
        Thread.sleep(2000);
    }

    @Step("Проверка столбцов журнала у события квитирование Тревоги")
    public void acked(String message_1_input, String comment_1_input,
                      String full_name_object, String name_object, String source) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(2000);
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

        String inc1 ="";
        if (message_1_input.equals("сообщение")) {
            //вытащить текст из инкремента
            inc1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#numberTextBox\").value");

        } else if(message_1_input.equals("message")) {
            //вытащить текст из инкремента 2
            inc1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }

        //Вывод параметров в консоль
        System.out.println("ДЛЯ ТРЕВОГИ 1: ");
        System.out.println("Приоритет : " + priorityAckedText1);
        System.out.println("Событие: " + ackedText1);
        System.out.println("Сообщение: " + messageAckText1);
        System.out.println("Комментарий: " + commentAckText1);
        System.out.println("Полное имя объекта: " + fullNameObjectAckText1);
        System.out.println("Объект: " + nameObjectAckText1);
        System.out.println("Источник: " + sourceAckText1);
        System.out.println("-------------------------------------------------------");

        //Проверки
        Assertions.assertEquals("Квитирование",ackedText1);
        Assertions.assertEquals(inc1, priorityAckedText1);

        //есть ошибка
        Assertions.assertEquals(message_1_input, messageAckText1);
        //Assertions.assertEquals(comment_1_input, commentAckText1);

        Assertions.assertEquals(full_name_object,fullNameObjectAckText1);
        Assertions.assertEquals(name_object,nameObjectAckText1);
        Assertions.assertEquals(source,sourceAckText1);

        //Ожидание
        Thread.sleep(2000);
    }

    @Step("Проверка столбцов журнала у события появление Тревоги")
    public void on(String message_1_input, String comment_1_input,
                   String full_name_object, String name_object, String source) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Поиск у сообщения (событие появление) поля Событие
        WebElement event_on1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(4)\")");
        //Из поля в параметр String
        String onText1 = event_on1.getText();

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

        //Поиск значения приоритет (событие квитирование)
        WebElement priority_on_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(3) > td:nth-child(5)\")");
        //Из поля в параметр String
        String priorityOnText1 = priority_on_1.getText();

        //Вывод в консоль
        System.out.println("Приоритет: " + priorityOnText1);
        System.out.println("Событие: " + onText1);
        System.out.println("Сообщение: " + messageOnText1);
        System.out.println("Комментарий: " + commentOnText1);
        System.out.println("Полное имя объекта: " + fullNameObjectOnText1);
        System.out.println("Объект: " + nameObjectOnText1);
        System.out.println("Источник: " + sourceOnText1);
        System.out.println("-------------------------------------------------------");

        String inc1 ="";
        if (message_1_input.equals("сообщение")) {
            //вытащить текст из инкремента
            inc1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#numberTextBox\").value");
        } else if(message_1_input.equals("message")) {
            //вытащить текст из инкремента 2
            inc1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }
        //Проверки
        Assertions.assertEquals("Появление",onText1);
        Assertions.assertEquals(inc1, priorityOnText1);

        //есть ошибка
        Assertions.assertEquals(message_1_input, messageOnText1);
        //Assertions.assertEquals(comment_1_input, commentOnText1);

        Assertions.assertEquals(full_name_object,fullNameObjectOnText1);
        Assertions.assertEquals(name_object,nameObjectOnText1);
        Assertions.assertEquals(source,sourceOnText1);

        //Ожидание
        Thread.sleep(2000);
    }

    @Step("Проверка столбцов журнала у события исчезновение Тревоги")
    public void off(String message_1_input, String comment_1_input,
                    String full_name_object, String name_object, String source) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Поиск значения приоритет (событие квитирование)
        WebElement priority_off_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(5)\")");
        //Из поля в параметр String
        String priorityOffText1 = priority_off_1.getText();

        //Поиск у сообщения (событие исчезновение) поля Событие
        WebElement event_off1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(4)\")");
        //Из поля в параметр String
        String offText1 = event_off1.getText();

        //Поиск у сообщения (событие появление) поля Сообщение
        WebElement message_off_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(7)\")");
        //Из поля в параметр String
        String messageOffText1 = message_off_1.getText();

        //Поиск у сообщения (событие появление) поля Комментарий
        WebElement comment_off_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(8)\")");
        //Из поля в параметр String
        String commentOffText1 = comment_off_1.getText();

        //Поиск у сообщения (событие появление) поля Полное имя
        WebElement fullName_object_off_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(9)\")");
        //Из поля в параметр String
        String fullNameObjectOffText1 = fullName_object_off_1.getText();

        //Поиск у сообщения (событие появление) поля Имя объекта
        WebElement name_object_off_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(10)\")");
        //Из поля в параметр String
        String nameObjectOffText1 = name_object_off_1.getText();

        //Поиск у сообщения (событие появление) поля Источник
        WebElement source_off_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child(1) > td:nth-child(11)\")");
        //Из поля в параметр String
        String sourceOffText1 = source_off_1.getText();


        //Вывод в консоль
        System.out.println("Приоритет : " + priorityOffText1);
        System.out.println("Событие: " + offText1);
        System.out.println("Сообщение: " + messageOffText1);
        System.out.println("Комментарий: " + commentOffText1);
        System.out.println("Полное имя объекта: " + fullNameObjectOffText1);
        System.out.println("Объект: " + nameObjectOffText1);
        System.out.println("Источник: " + sourceOffText1);
        System.out.println("-------------------------------------------------------");

        String inc1 ="";
        if (message_1_input.equals("сообщение")) {
            //вытащить текст из инкремента 1
            inc1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 03434\").shadowRoot.querySelector(\"#numberTextBox\").value");
        } else if(message_1_input.equals("message")) {
            //вытащить текст из инкремента 2
            inc1 = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }

        //Проверки
        Assertions.assertEquals("Исчезновение",offText1);
        Assertions.assertEquals(inc1, priorityOffText1);

        //есть ошибка
        Assertions.assertEquals(message_1_input, messageOffText1);
        //Assertions.assertEquals(comment_1_input, commentOffText1);

        Assertions.assertEquals(full_name_object,fullNameObjectOffText1);
        Assertions.assertEquals(name_object,nameObjectOffText1);
        Assertions.assertEquals(source,sourceOffText1);

        //Ожидание
        Thread.sleep(2000);
    }

    @Step("Активация, квитирование и деактивация Тревоги 2")
    public void alarm2(String message_2_input, String comment_2_input) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Проверка нажата ли кнопка(если нажата, то отжать), для Тревоги 2

        WebElement search_button_act2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 03575\").shadowRoot.querySelector(\"div[class]\")");
        String aClass2 = search_button_act2.getAttribute("class");

        System.out.println("Состояние кнопки Активность Тревоги 2 до начала теста: " + aClass2);
        System.out.println("-------------------------------------------------------");

        if (aClass2.equals("tbmain button active")) {
            driver.findElement(activateButton2).click();
        }


        //вытащить текст из инкремента 2
        String incText2 = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#numberTextBox\").value");

        //Поиск элемента для задания сообщения Тревоги 2 и задание ему значения "сообщение"
        driver.findElement(textMessage2).sendKeys(message_2_input);
        //Поиск элемента для задания комментария Тревоги 2 и задание ему значения "комментарий"
        driver.findElement(textComment2).sendKeys(comment_2_input);

        //вывод значения инкремента Тревоги 2 в консоль
        System.out.println("приоритет тревоги 2: " + incText2);
        Thread.sleep(2000);

        String s_inc = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#numberTextBox\").value");
        while (!s_inc.equals("0")){
            WebElement search_button_inc_down = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#decr\")");
            search_button_inc_down.click();
            //Thread.sleep(500);
            s_inc = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#numberTextBox\").value");
        }
        Thread.sleep(1000);

        //Увеличиваем значение инкремента Тревоги 2
        WebElement search_button_inc_up_2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 04066\").shadowRoot.querySelector(\"#incr\")");

        search_button_inc_up_2.click();
        Thread.sleep(1000);

        search_button_inc_up_2.click();
        Thread.sleep(1000);

        //Поиск кнопки "Активность" Тревоги 1 и клик по ней (кнопка с фиксацией, положение вкл.)
        driver.findElement(activateButton2).click();
        Thread.sleep(2000);

        //Поиск кнопки "квит" у последнего появившегося сообщения в архивном журнале
        WebElement search_button2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelectorAll(\".ack\")[0]");
        //Клик по кнопке
        search_button2.click();

        Thread.sleep(2000);

        //сброс сообщения
        driver.findElement(resetButton2).click();

        //Поиск кнопки "Активность" Тревоги 1 и клик по ней (кнопка с фиксацией, положение выкл.)
        driver.findElement(activateButton2).click();

        Thread.sleep(2000);
    }

    @Step("Включение фильтра Приоритет и проверка")
    public void filters_severity(int severity) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Вход в окно фильтров
        WebElement button_filters = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-filter\")");
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);


        if (severity == 1) {
            WebElement filter_1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_0\")");
            //Активация фильтра
            filter_1.click();
        }
        else if (severity == 2){
            WebElement filter_2 = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_1\")");
            //Активация фильтра
            filter_2.click();
        }

        Thread.sleep(1000);

        //Выход из окна фильтров
        button_filters.click();

        Thread.sleep(2000);
        //кол-во сообщений в журнале

        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);

        //Проверка фильтров Приоритет по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(5)\")";
            WebElement message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ message.getText());

            //Сравнение приоритета сообщения с 1
            if ((severity == 1)){
                Assertions.assertEquals(message.getText(), "1");
            }
            if ((severity == 2)){
                Assertions.assertEquals(message.getText(), "2");
            }
            events_count--;
        }

        //Открытие окна фильтров
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (severity == 1) {
            WebElement filter_1 = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_0\")");
            //Активация фильтра
            filter_1.click();
        }
        else if (severity == 2){
            WebElement filter_2 = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_1\")");
            //Активация фильтра
            filter_2.click();
        }

        //Закрытие окна фильтров
        button_filters.click();

        Thread.sleep(2000);
    }

    @Step("Включение фильтра Сообщение и проверка")
    public void filters_message(String message) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Вход в окно фильтров
        WebElement button_filters = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-filter\")");
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (message.equals("сообщение")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_2\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (message.equals("message")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_3\")");
            //Активация фильтра
            filters_message.click();
        }

        Thread.sleep(1000);

        //Выход из окна фильтров
        button_filters.click();

        Thread.sleep(1000);

        //кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);

        //Проверка фильтров Сообщение по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(7)\")";
            WebElement f_message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ f_message.getText());

            //Сравнение сообщения
            if (message.equals("сообщение")){
                Assertions.assertEquals(f_message.getText(), "сообщение");
            }
            else if (message.equals("message")) {
                Assertions.assertEquals(f_message.getText(), "message");
            }
            events_count--;
        }

        //Открытие окна фильтров
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (message.equals("сообщение")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_2\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (message.equals("message")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_3\")");
            //Активация фильтра
            filters_message.click();
        }

        //Закрытие окна фильтров
        button_filters.click();

        Thread.sleep(2000);
    }

    @Step("Включение фильтра Объект и проверка")
    public void filters_object(String object) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Вход в окно фильтров
        WebElement button_filters = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-filter\")");
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (object.equals("Объект 1")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_4\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (object.equals("Object 2")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_5\")");
            //Активация фильтра
            filters_message.click();
        }

        Thread.sleep(1000);

        //Выход из окна фильтров
        button_filters.click();

        Thread.sleep(1000);

        //кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);

        //Проверка фильтров Объект по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(10)\")";
            WebElement f_message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ f_message.getText());

            //Сравнение сообщения
            if (object.equals("Объект 1")){
                Assertions.assertEquals(f_message.getText(), "Объект 1");
            }
            else if (object.equals("Object 2")) {
                Assertions.assertEquals(f_message.getText(), "Object 2");
            }
            events_count--;
        }

        //Открытие окна фильтров
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (object.equals("Объект 1")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_4\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (object.equals("Object 2")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_5\")");
            //Активация фильтра
            filters_message.click();
        }

        //Закрытие окна фильтров
        button_filters.click();

        Thread.sleep(2000);
    }

    @Step("Включение фильтра Полное имя Объекта и проверка")
    public void filters_full_name_object(String full_name_object) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Вход в окно фильтров
        WebElement button_filters = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-filter\")");
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (full_name_object.equals("Объекты.Test 3.Объект 1")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_6\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (full_name_object.equals("Объекты.Test 3.Object 2")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_7\")");
            //Активация фильтра
            filters_message.click();
        }

        Thread.sleep(1000);

        //Выход из окна фильтров
        button_filters.click();

        Thread.sleep(1000);

        //кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);

        //Проверка фильтров Объект по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(9)\")";
            WebElement f_message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ f_message.getText());

            //Сравнение сообщения
            if (full_name_object.equals("Объекты.Test 3.Объект 1")){
                Assertions.assertEquals(f_message.getText(), "Объекты.Test 3.Объект 1");
            }
            else if (full_name_object.equals("Объекты.Test 3.Object 2")) {
                Assertions.assertEquals(f_message.getText(), "Объекты.Test 3.Object 2");
            }
            events_count--;
        }

        //Открытие окна фильтров
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (full_name_object.equals("Объекты.Test 3.Объект 1")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_6\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (full_name_object.equals("Объекты.Test 3.Object 2")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_7\")");
            //Активация фильтра
            filters_message.click();
        }

        //Закрытие окна фильтров
        button_filters.click();

        Thread.sleep(2000);
    }
    @Step("Включение фильтра Источник и проверка")
    public void filters_source(String source) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Вход в окно фильтров
        WebElement button_filters = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-filter\")");
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (source.equals("Тревога 1")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_8\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (source.equals("Alarm 2")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_9\")");
            //Активация фильтра
            filters_message.click();
        }

        Thread.sleep(1000);

        //Выход из окна фильтров
        button_filters.click();

        Thread.sleep(1000);

        //кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);

        //Проверка фильтров Объект по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(11)\")";
            WebElement f_message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ f_message.getText());

            //Сравнение сообщения
            if (source.equals("Тревога 1")){
                Assertions.assertEquals(f_message.getText(), "Тревога 1");
            }
            else if (source.equals("Alarm 2")) {
                Assertions.assertEquals(f_message.getText(), "Alarm 2");
            }
            events_count--;
        }

        //Открытие окна фильтров
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (source.equals("Тревога 1")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_8\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (source.equals("Alarm 2")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_9\")");
            //Активация фильтра
            filters_message.click();
        }

        //Закрытие окна фильтров
        button_filters.click();

        Thread.sleep(2000);
    }

    @Step("Включение фильтра Комментарий и проверка")
    public void filters_comment(String comment) throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Вход в окно фильтров
        WebElement button_filters = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-filter\")");
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (comment.equals("комментарий")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_10\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (comment.equals("comment")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_11\")");
            //Активация фильтра
            filters_message.click();
        }

        Thread.sleep(1000);

        //Выход из окна фильтров
        button_filters.click();

        Thread.sleep(1000);

        //кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);

        //Проверка фильтров Объект по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(7)\")";
            WebElement f_message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ f_message.getText());

            //Сравнение сообщения
            if (comment.equals("комментарий")){
                Assertions.assertEquals(f_message.getText(), "комментарий");
            }
            else if (comment.equals("comment")) {
                Assertions.assertEquals(f_message.getText(), "comment");
            }
            events_count--;
        }

        //Открытие окна фильтров
        button_filters.click();

        //Ожидание
        Thread.sleep(1000);

        if (comment.equals("комментарий")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_10\")");
            //Активация фильтра
            filters_message.click();
        }
        else if (comment.equals("comment")) {
            WebElement filters_message = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#\\\\31 02863\").shadowRoot.querySelector(\"#f_11\")");
            //Активация фильтра
            filters_message.click();
        }

        //Закрытие окна фильтров
        button_filters.click();

        Thread.sleep(2000);
    }

}
