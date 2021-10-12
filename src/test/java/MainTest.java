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
    //Параметр для проверки теста 1
    final String parameter_1_input = "-квит_1";
    final String comment_input = "квитировано";

    //Параметр для проверки теста 2
    final String parameter_1_input_1 = "-ack_2";
    final String comment_input_1 = "acked";

    //Параметр для проверки теста 3
    final String color_act = "background-color: aqua;";
    final String color_deact = "background-color: gold;";
    final String color_ack = "background-color: crimson;";

    //Параметр для проверки теста 4
    final String message_1_input = "сообщение";
    final String comment_1_input = "комментарий";
    final String message_2_input = "message";
    final String comment_2_input = "comment";

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
    }/*
    @Test
    @DisplayName("Проверка отображения пользовательского параметра тревоги в журнале (русские символы)")
    public void test1() throws InterruptedException {

        archiveJournal1 aJournal1 = new archiveJournal1(driver.get());

        aJournal1.StartTest();
        aJournal1.ActivateMessage(parameter_1_input);
        aJournal1.AckedMessage(parameter_1_input, comment_input);
        aJournal1.RefreshPage(parameter_1_input);
        aJournal1.fileCSV(parameter_1_input, comment_input);
        aJournal1.deleteFile();
    }
    @Test
    @DisplayName("Проверка отображения пользовательского параметра тревоги в журнале (английские символы)")
    public void test2() throws InterruptedException {

        archiveJournal1 aJournal1 = new archiveJournal1(driver.get());

        aJournal1.StartTest();
        aJournal1.ActivateMessage(parameter_1_input_1);
        aJournal1.AckedMessage(parameter_1_input_1, comment_input_1);
        aJournal1.RefreshPage(parameter_1_input_1);
        aJournal1.fileCSV(parameter_1_input_1, comment_input_1);
        aJournal1.deleteFile();
    }
    @Test
    @DisplayName("Issue 21417: Свойство Состояние+Приоритет для журнала")
    public void test3() throws InterruptedException {

        archiveJournal2 aJournal2 = new archiveJournal2(driver.get());

        aJournal2.StartTest();
        aJournal2.preparation();
        aJournal2.compareColor(color_act,color_deact,color_ack);
    }*/
    @Test
    @DisplayName("Что-то там")
    public void test4() throws InterruptedException {

        archiveJournal3 aJournal3 = new archiveJournal3(driver.get());

        aJournal3.StartTest();
        aJournal3.preparation1(message_1_input,comment_1_input,message_2_input,comment_2_input);
    }
}
