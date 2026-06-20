package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    //BYTES is used instead of FILE since this needs to be run in CICD
    public static byte[] captureScreenshot(WebDriver driver ){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

    }
}
