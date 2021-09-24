import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@DisplayName("Тесты архивного журнала")
@ExtendWith(ScreenshotExt.class)
public class MainTest {
    final String color_act = "background-color: aqua;";
    final String color_deact = "background-color: gold;";
    final String color_ack = "background-color: crimson;";


    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeEach
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        //Скачивание нужного драйвера
        //вот так вот WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Autotests\\chromedriver_win32\\chromedriver.exe");
        //Создаем новый объект chromedriver
        driver.set(new ChromeDriver());
        //Полноэкранный режим driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Проверка отображения пользовательского параметра тревоги в журнале (русские символы)")
    public void test1() throws InterruptedException {
        Journal journal = new Journal(driver.get());
        //Параметр для проверки
        final String parameter_1_input = "-квит_1";
        final String comment_input = "квитировано";

        journal.StartTest();

        journal.ActivateMessage(parameter_1_input);
        journal.AckedMessage(parameter_1_input, comment_input);
        journal.RefreshPage(parameter_1_input);
        journal.fileCSV(parameter_1_input, comment_input);
    }
    @Test
    @DisplayName("Проверка отображения пользовательского параметра тревоги в журнале (английские символы)")
    public void test2() throws InterruptedException {
        Journal journal = new Journal(driver.get());
        //Параметр для проверки
        final String parameter_1_input = "-ack_2";
        final String comment_input = "acked";

        journal.StartTest();
        journal.ActivateMessage(parameter_1_input);
        journal.AckedMessage(parameter_1_input, comment_input);
        journal.RefreshPage(parameter_1_input);
        journal.fileCSV(parameter_1_input, comment_input);
    }
    @Test
    @DisplayName("Issue 21417: Свойство Состояние+Приоритет для журнала")
    public void test3() throws InterruptedException {


        Journal journal = new Journal(driver.get());
        journal.StartTest();
        journal.color(color_act,color_deact,color_ack);
    }
}
