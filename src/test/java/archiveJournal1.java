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

public class archiveJournal1 extends MainTest{

    public WebDriver driver;
    public static final By test1Button = By.id("81112");
    public static final By textInput = By.id("79104");
    public static final By dischargeButton = By.id("84002");
    public static final By activateButton = By.id("78174");
    //public static final String filePath = "C:/Users/DGolubev/Downloads/journal.csv/";
    String home = System.getProperty("user.home");
    File file = new File(home+"/Downloads/journal.csv");

    public archiveJournal1(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Начало. Запуск браузера")
    public void StartTest(){
        System.out.println("шаг 1 запуск браузера");
        System.out.println("-------------------------------------------------------");
        String Base_URL = "http://127.0.0.1:8043";
        this.driver.get(Base_URL);
    }

    @Step("Проверка отображения в журнале пользовательского параметра тревоги")
    public void ActivateMessage(String parameter_1_input)throws InterruptedException{

        System.out.println("шаг 2 переход на страницу теста и активация сообщения");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Поиск кнопки с переходом на окно теста 1
        driver.findElement(test1Button).click();

        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);

        //Поиск кнопки "Сброс" и клик по ней
        driver.findElement(dischargeButton).click();

        //Ожидание совершения действия
        Thread.sleep(1000);

        //Проверка нажата ли кнопка(если нажата, то отжать)
        WebElement search_button_act1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 8174\").shadowRoot.querySelector(\"div[class]\")");

        String aClass1 = search_button_act1.getAttribute("class");
        System.out.println(aClass1);

        //Если "tbmain button active", то кнопку надо отжать
        if (aClass1.equals("tbmain button active")){
            driver.findElement(activateButton).click();
        }
        Thread.sleep(1000);

        //Поиск элемента "Текстовый ввод" и задание ему значения "-k"
        driver.findElement(textInput).sendKeys(parameter_1_input);

        //Поиск кнопки "Активность" и клик по ней (кнопка с фиксацией, положение вкл.)
        driver.findElement(activateButton).click();

        //Ожидание появления сообщения в Архивном журнале
        Thread.sleep(1000);

        //Поиск поля пользовательского параметра в журнале и получения из него значения
        WebElement text1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\" td:nth-child(8)\")");

        //Сравнение что в журнале и что в текстовом вводе
        Assertions.assertEquals(text1.getText(), parameter_1_input);

        //Ожидание (чтобы успеть все увидеть глазами)
        Thread.sleep(3000);
    }

    @Step("Проверка поля пользовательского параметра после квитирования")
    public void AckedMessage(String parameter_1_input, String comment_input) throws InterruptedException{
        System.out.println("шаг 3 квитирование");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Поиск кнопки "квит" у последнего появившегося сообщения в архивном журнале
        WebElement search_button = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelectorAll(\".ack\")[0]");

        //Клик по кнопке "квит"
        search_button.click();

        //Ожидание появления окна с предложением задать комментарий при квитировании
        Thread.sleep(2000);

        //Поиск поля ввода для комментария
        WebElement search_input1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\"#inp\")");

        //Задание комментария
        search_input1.sendKeys(comment_input);

        //Поиск кнопки подтверждения квитирования "ок"
        WebElement search_button1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\"#btnOk\")");

        //Подтверждением квитирования "ок"
        search_button1.click();

        //Ожидание нового сообщения в журнале
        Thread.sleep(1000);

        //Поиск у последнего сообщения поля Параметр_1
        WebElement text1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\" td:nth-child(8)\")");

        //Из поля Параметр_1 в параметр String parameter_1
        String parameter_1_output = text1.getText();

        //Поиск У последнего сообщения поля Комментарий
        WebElement text2 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\" td:nth-child(9)\")");

        //Из поля Комментарий в параметр String par1
        String comment_output = text2.getText();

        //Вывод параметров в консоль
        System.out.println("Параметр_1 :" + parameter_1_output);
        System.out.println("Комментарий :" + comment_output);

        //Сравнение
        Assertions.assertEquals(parameter_1_output,parameter_1_input);
        Assertions.assertEquals(comment_input,comment_output);
    }

    @Step("Проверка поля пользовательского параметра после перезагрузки клиента")
    public void RefreshPage(String parameter_1_input) throws InterruptedException{
        System.out.println("шаг 4 перезагрузка страницы");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Перезагрузка страницы
        driver.navigate().refresh();

        //Ожидание загрузки страницы и элементов
        Thread.sleep(4000);

        //Поиск у последнего сообщения поля Параметр_1
        WebElement text1 = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\" td:nth-child(8)\")");

        //Из поля Параметр_1 в параметр String parameter_1
        String parameter_1_output = text1.getText();

        //Сравнение
        Assertions.assertEquals(parameter_1_output,parameter_1_input);

        //Поиск кнопки "Активность" и клик по ней (кнопка с фиксацией, положение выкл.)
        driver.findElement(activateButton).click();

        //Ожидание перед закрытием
        Thread.sleep(1000);
    }

    @Step("Проверка пользовательского параметра в последней строчке CSV-файла")
    public void fileCSV(String parameter_1_input, String comment_input) throws InterruptedException{
        System.out.println("шаг 5 скачивание CSV");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement exportButton = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\37 7958\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j-export.btn\")");
        exportButton.click();
        Thread.sleep(2000);
        BufferedReader br = null;
        String out ="";

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1251"));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null){
                count++;
                out = line;
                if (count == 3){
                    break;
                }
            }
        } catch (IOException e){
            System.out.println("Error" + e);
        } finally {
            try {
                assert br != null;
                br.close();
            }catch (IOException e){
                System.out.println("Error" + e);
            }
        }

        String[] subStr;
        String delimeter = ";"; // Разделитель
        subStr = out.split(delimeter); // Разделения строки str с помощью метода split()
        // Вывод результата на экран
        System.out.println(subStr[0]+";"+subStr[1]+";"+subStr[2]+";"+subStr[3]);
        //Первая строка Событие;Время;Сообщение;Параметр_1;Комментарий;
        //Вторая строка содержит событие Исчезновение
        //Третья строка содержит событие Квитирование
        String parameter_CSV = subStr[3];
        String comment_CSV = subStr[4];
        Assertions.assertEquals(parameter_CSV,parameter_1_input);
        Assertions.assertEquals(comment_CSV,comment_input);

    }
    @Step("Удаление csv файла")
    public void deleteFile() {
        //Удаление файла CSV
        Assertions.assertTrue(file.delete());
    }
}
