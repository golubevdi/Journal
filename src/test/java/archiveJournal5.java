import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class archiveJournal5 extends MainTest{
    public WebDriver driver;
    public static final By test5Button = By.id("130910");
    public static final By activateButton = By.id("130957");

    public archiveJournal5(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Начало. Запуск браузера")
    public void StartTest(){
        System.out.println("шаг 1 запуск браузера");
        System.out.println("-------------------------------------------------------");
        String Base_URL = "http://127.0.0.1:8043";
        this.driver.get(Base_URL);
    }

    @Step("Переход на станицу Тест 5")
    public void test5page() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("шаг 2 переход на окно теста");
        System.out.println("-------------------------------------------------------");

        //Поиск кнопки с переходом на окно теста 4
        driver.findElement(test5Button).click();
        //Ожидание (загрузка страницы, элементов)
        Thread.sleep(2000);
    }
    @Step("Генерация сообщений")
    public void alarmsActivation() throws InterruptedException{
        //Поиск кнопки активации тревог и клик по ней
        driver.findElement(activateButton).click();

        //Ожидание (появления сообщений в журнале)
        Thread.sleep(2000);
    }
    @Step("Автопрокрутка")
    public void auto() throws InterruptedException{
        System.out.println("шаг 3 включения автопрокрутки в верхнем положении скроллбара");
        System.out.println("-------------------------------------------------------");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        /*
        //Переход к последней странице
        //Данный вариант не работает, так как всплывающая подсказка не дает нажать на кнопку
        WebElement last_page = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 30459\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div.hmi-j-step-down.btn\")");
        last_page.click();
        Thread.sleep(2000);
        */
        //посчитать кол-во сообщений в журнале
        Long events_count = (Long)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 30459\").shadowRoot.querySelector(\"div > div:nth-child(2) > table > tbody\").childElementCount");
        System.out.println("Кол-во сообщений: " + events_count);
        //скроллинг вниз
        WebElement element_last = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 30459\").shadowRoot.querySelector(\"tr:nth-child("+events_count+")\")");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element_last);

        Thread.sleep(1000);

        //проверка кнопки автопрокрутка
        String auto_btn = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 30459\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div:nth-child(10)\").className");
        Assertions.assertEquals(auto_btn, "btn hmi-j-play");
        System.out.println("автопрокрутка выкл");

        //Переход к первой странице
        WebElement first_page = (WebElement)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 30459\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div:nth-child(13)\")");
        first_page.click();
        Thread.sleep(2000);

        //проверка кнопки автопрокрутка
        auto_btn = (String)
                jse.executeScript
                        ("return document.querySelector(\"#\\\\31 30459\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar > div:nth-child(10)\").className");
        Assertions.assertEquals(auto_btn, "btn active hmi-j-pause");
        System.out.println("автопрокрутка вкл");
    }
}
