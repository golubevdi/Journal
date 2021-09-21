import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Тесты архивного журнала")
@ExtendWith(ScreenshotExt.class)
public class MainTest {


    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeEach
    public void start() {
        //Скачивание нужного драйвера
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
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
}
