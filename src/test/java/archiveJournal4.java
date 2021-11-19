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

    @Step("Проверка фильтра RT по приоритету (туллбар)")
    public void severityRT() throws InterruptedException {
        System.out.println("шаг 4 проверка фильтра RT по приоритету");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Сброс
        WebElement resetRT_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j-reset_settings.btn\")");
        resetRT_button.click();

        //кол-во сообщений в журнале до применения фильтра
        Long events_count_before = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений до: " + events_count_before);

        //Поиск кнопки Приоритет и клик по ней
        WebElement severityRT_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-info\")");
        severityRT_button.click();
        Thread.sleep(1000);

        //Увеличение начального приоритета на 1
        WebElement inc_up1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#inp1\").shadowRoot.querySelector(\"#incr\")");
        inc_up1.click();

        //Увеличение конечного приоритета на 2
        WebElement inc_up2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#inp2\").shadowRoot.querySelector(\"#incr\")");
        inc_up2.click();
        Thread.sleep(500);
        inc_up2.click();

        //Применение фильтра
        WebElement severityRT_button_ok = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#btnOk\")");
        severityRT_button_ok.click();

        Thread.sleep(1000);

        //кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений после: " + events_count);

        //Проверка, что кол-фо сообщений до применения и после применение фильтра разное
        Assertions.assertNotEquals(events_count_before, events_count);

        //Проверка фильтров Приоритет по всем сообщениям после применения фильтра
        while(events_count != 0){
            String num = events_count.toString();
            String doc = "return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"tr:nth-child("
                    + num + ") > td:nth-child(5)\")";
            WebElement message = (WebElement)
                    jse.executeScript
                            (doc);
            System.out.println("Сообщение №" + num + " = "+ message.getText());

            //Сравнение приоритета сообщения с 1
            Assertions.assertNotEquals(message.getText(),"3");

            events_count--;
        }

        Thread.sleep(3000);
    }

    @Step("Проверка фильтра RT по времени (туллбар)")
    public void timeRT() throws InterruptedException {
        System.out.println("шаг 5 проверка фильтра RT по времени");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Сброс
        WebElement resetRT_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j-reset_settings.btn\")");
        resetRT_button.click();

        //Кол-во сообщений в журнале до применения фильтра
        Long events_count_before = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений до: " + events_count_before);

        //Время у самого раннего сообщения
        String num = events_count_before.toString();
        String doc = "return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"tr:nth-child("
                + num + ") > td:nth-child(6)\")";
        WebElement message = (WebElement)
                jse.executeScript
                        (doc);
        System.out.println("время: " + message.getText());
        String HHmmSS_message = message.getText();

        //Включение фильтра
        WebElement timeRT_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.btn.hmi-j-inerval_go\")");
        timeRT_button.click();

        //Открытие календаря для задания интервала
        WebElement calendar_interval = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#inter\").shadowRoot.querySelector(\"#btnCal\")");
        calendar_interval.click();

        //Выставляем 00 часов
        WebElement calendar_hh = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#calend > div:nth-child(2) > div:nth-child(1) > #down\")");
        calendar_hh.click();

        //Выставляем 01 сек
        WebElement calendar_mm = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#calend > div:nth-child(2) > div:nth-child(3) > #up\")");
        calendar_mm.click();

        //Кнопка подтверждения
        WebElement calendar_ok = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#save\")");
        calendar_ok.click();

        Thread.sleep(1000);

        //Задание начального времени
        WebElement timeRT_button_calendar = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#left\").shadowRoot.querySelector(\"#btnCal\")");
        timeRT_button_calendar.click();

        //Задание DD
        String DD_filter = (String)
                jse.executeScript
                        ("return document.querySelector(\"#dd\").value");
        String DD_message_dd = HHmmSS_message.substring(0, 2);
        System.out.println("день: " + DD_message_dd);

        //Задание MM
        String MMM_filter = (String)
                jse.executeScript
                        ("return document.querySelector(\"#MM\").value");
        String MMM_message_mmm = HHmmSS_message.substring(3, 5);
        System.out.println("месяц: " + MMM_message_mmm);

        //Задание YY
        String YY_filter = (String)
                jse.executeScript
                        ("return document.querySelector(\"#YYYY\").value");
        String YY_message_yy = HHmmSS_message.substring(6, 10);
        System.out.println("год: " + YY_message_yy);


        //Задание HH
        String HH_filter = (String)
                jse.executeScript
                        ("return document.querySelector(\"#HH\").value");
        String HH_message_hh = HHmmSS_message.substring(11, 13);
        System.out.println("часы: " + HH_message_hh);

        //Задание MM
        String mm_filter = (String)
                jse.executeScript
                        ("return document.querySelector(\"#calend > div > div:nth-child(2) > div:nth-child(2) > #mm\").value");

        String mm_message_mm = HHmmSS_message.substring(14, 16);
        System.out.println("минуты: " + mm_message_mm);

        //Задание ss
        String ss_filter = (String)
                jse.executeScript
                        ("return document.querySelector(\"#ss\").value");

        String SS_message_ss = HHmmSS_message.substring(17, 19);
        System.out.println("секунды: " + SS_message_ss);

        //Установка дня (DD) в фильтре
        int dd_f = Integer.parseInt(DD_filter);
        int dd_m = Integer.parseInt(DD_message_dd);

        while (dd_f != dd_m){
            WebElement DD_up = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(1) > div:nth-child(1) > #up\")");
            DD_up.click();
            DD_filter = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#dd\").value");
            dd_f = Integer.parseInt(DD_filter);
        }

        //Установка месяца (mm) в фильтре
        int MMM_f = Integer.parseInt(MMM_filter);
        int MMM_m = Integer.parseInt(MMM_message_mmm);

        while (MMM_f != MMM_m){
            WebElement MMM_up = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(1) > div:nth-child(2) > #up\")");
            MMM_up.click();
            MMM_filter = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#MM\").value");
            MMM_f = Integer.parseInt(MMM_filter);
        }

        //Установка года (YYYY) в фильтре

        int YY_f = Integer.parseInt(YY_filter);
        int YY_m = Integer.parseInt(YY_message_yy);

        while (YY_f != YY_m){
            WebElement YY_up = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(1) > div:nth-child(3) > #up\")");
            YY_up.click();
            YY_filter = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#YYYY\").value");
            YY_f = Integer.parseInt(YY_filter);
        }

        //Установка часов (HH) в фильтре
        int hh_f = Integer.parseInt(HH_filter);
        int hh_m = Integer.parseInt(HH_message_hh);

        while (hh_f != hh_m){
            WebElement HH_up = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(2) > div:nth-child(1) > #up\")");
            HH_up.click();
            HH_filter = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#HH\").value");
            hh_f = Integer.parseInt(HH_filter);
        }

        //Установка минут (mm) в фильтре
        int mm_f = Integer.parseInt(mm_filter);
        int mm_m = Integer.parseInt(mm_message_mm);

        while (mm_f != mm_m){
            WebElement mm_up = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(2) > div:nth-child(2) > #up\")");
            mm_up.click();
            mm_filter = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(2) > div:nth-child(2) > #mm\").value");
            mm_f = Integer.parseInt(mm_filter);
        }

        //Установка секунд (ss) в фильтре
        int ss_f = Integer.parseInt(ss_filter);
        int ss_m = Integer.parseInt(SS_message_ss);

        while (ss_f != ss_m){
            WebElement ss_up = (WebElement)
                    jse.executeScript
                            ("return document.querySelector(\"#calend > div > div:nth-child(2) > div:nth-child(3) > #up\")");
            ss_up.click();
            ss_filter = (String)
                    jse.executeScript
                            ("return document.querySelector(\"#ss\").value");
            ss_f = Integer.parseInt(ss_filter);
        }

        Thread.sleep(1000);

        //Найти и кликнуть по кнопке подтверждения
        WebElement button_save = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#save\")");
        button_save.click();

        Thread.sleep(1000);

        //Кол-во сообщений в журнале после применения фильтра
        Long events_count_after = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений после: " + events_count_after);

        Assertions.assertTrue( events_count_before > events_count_after);

        Thread.sleep(2000);

    }

    @Step("Проверка перехода к дате")
    public void toDateRT() throws InterruptedException {
        System.out.println("шаг 6 проверка перехода к дате (туллбар)");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Сброс
        WebElement resetRT_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j-reset_settings.btn\")");
        resetRT_button.click();
        Thread.sleep(1000);

        //Активация фильтра перехода к дате
        WebElement to_date_filter_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 28860\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j-select-data.btn\")");
        to_date_filter_button.click();

        Thread.sleep(1000);
    }
}
