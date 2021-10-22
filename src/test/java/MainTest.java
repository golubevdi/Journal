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
    final String color_act_1 = "background-color: aqua;";
    final String color_deact_1 = "background-color: gold;";
    final String color_ack_1 = "background-color: crimson;";
    final String color_act_2 = "background-color: chartreuse; font-style: italic;";
    final String color_deact_2 = "background-color: darkgray;";

    //Параметр для проверки теста 4 и 5
    final String message_1_input = "сообщение";
    final String comment_1_input = "комментарий";
    final String message_2_input = "message";
    final String comment_2_input = "comment";
    final String full_name_object_1 = "Объекты.Test 3.Объект 1";
    final String name_object_1 = "Объект 1";
    final String source_1 = "Тревога 1";
    final String full_name_object_2 = "Объекты.Test 3.Object 2";
    final String name_object_2 = "Object 2";
    final String source_2 = "Alarm 2";

    final int severity_1 = 1;
    final int severity_2 = 2;

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
        aJournal2.compareColor(color_act_1, color_deact_1, color_ack_1, color_act_2, color_deact_2);
    }

    @Test
    @DisplayName("Проверка отображения сообщений в журнале (русские символы)")
    public void test4() throws InterruptedException {

        archiveJournal3 aJournal3 = new archiveJournal3(driver.get());

//Bug 21528: Удаление комментария в архивном сообщении при квитировании с отключенным свойством запрашивать комментарий

        aJournal3.StartTest();
        aJournal3.alarm1(message_1_input, comment_1_input);
        aJournal3.acked(message_1_input, comment_1_input, full_name_object_1, name_object_1, source_1);
        aJournal3.on(message_1_input, comment_1_input, full_name_object_1, name_object_1, source_1);
        aJournal3.off(message_1_input, comment_1_input, full_name_object_1, name_object_1, source_1);
    }

    @Test
    @DisplayName("Проверка отображения сообщений в журнале (английские символы)")
    public void test5() throws InterruptedException {
        archiveJournal3 aJournal3 = new archiveJournal3(driver.get());

//Bug 21528: Удаление комментария в архивном сообщении при квитировании с отключенным свойством запрашивать комментарий

        aJournal3.StartTest();
        aJournal3.alarm2(message_2_input,comment_2_input);
        aJournal3.acked(message_2_input,comment_2_input,full_name_object_2,name_object_2,source_2);
        aJournal3.on(message_2_input,comment_2_input,full_name_object_2,name_object_2,source_2);
        aJournal3.off(message_2_input,comment_2_input,full_name_object_2,name_object_2,source_2);
    }

    @Test
    @DisplayName("Проверка отображения сообщений в журнале после применения фильтров (русские символы) всегда один фильтр")
    public void test6() throws InterruptedException {
        archiveJournal3 aJournal3 = new archiveJournal3(driver.get());

        aJournal3.StartTest();
        aJournal3.alarm1(message_1_input, comment_1_input);
        aJournal3.filters_severity(severity_1);
        aJournal3.filters_message(message_1_input);
    }

    @Test
    @DisplayName("Проверка отображения сообщений в журнале после применения фильтров (английские символы) всегда один фильтр")
    public void test7() throws InterruptedException {
        archiveJournal3 aJournal3 = new archiveJournal3(driver.get());

        aJournal3.StartTest();
        aJournal3.alarm2(message_2_input,comment_2_input);
        aJournal3.filters_severity(severity_2);
        aJournal3.filters_message(message_2_input);
    }
/*
    @Test
    @DisplayName("Проверка отображения сообщений в журнале после применения фильтров (русские символы) предыдущие фильтры не откл")
    public void test8() throws InterruptedException {

    }*/
}
