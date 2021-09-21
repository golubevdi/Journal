import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.Optional;

public class ScreenshotExt implements TestWatcher {


    @Override
    public void testFailed(ExtensionContext context, Throwable throwable){
        WebDriver driver = null;
        try {
            driver = getDriver(context);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert driver != null;
        Allure.getLifecycle().addAttachment(
                "Screenshot","image/png", "png",((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)
        );
        try {
            getDriver(context).close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason){
        try {
            getDriver(context).close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context){
        try {
            getDriver(context).close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause){
        try {
            getDriver(context).close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private WebDriver getDriver(ExtensionContext context) throws NoSuchFieldException {
        Object instance = context.getRequiredTestInstance();
        try{
            Field field = instance.getClass().getDeclaredField("driver");
            field.setAccessible(true);
            return ((ThreadLocal<WebDriver>) field.get(instance)).get();
        } catch (IllegalAccessException e){     //catch (NoSuchFieldException | IllegalAccessException e)
            throw new RuntimeException(e);
        }
    }
}

