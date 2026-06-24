package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utilities.PropertyUtil;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //SoftAssert softAssert=new SoftAssert();

    public static WebDriver getDriver() {
        return driver.get();
    }

    //public LoginPage loginPage;

    public static void initDriver(String browser) throws IOException {
        if (browser == null || browser.isBlank()) {
            browser = PropertyUtil.fetchProperty("browser");
            if (browser == null || browser.isBlank()) {
                browser = "edge";
            }
        }

        switch (browser.toLowerCase()) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--headless=new");          // modern headless for Chromium
                //options.addArguments("--no-sandbox");            // useful in CI/Linux
                // options.addArguments("--disable-dev-shm-usage"); // avoid shared memory issues
                // driver = new ChromeDriver(options);
                driver.set(new ChromeDriver(options));
                break;
            }
            case "edge": {
                EdgeOptions options = new EdgeOptions();
                // options.addArguments("--headless=new");          // modern headless for edge
                //options.addArguments("--no-sandbox");            // useful in CI/Linux
                // options.addArguments("--disable-dev-shm-usage"); // avoid shared memory issues
                // driver = new ChromeDriver(options);
                driver.set(new EdgeDriver(options));


            }

        }
        WebDriver d = getDriver();
        if (d != null) {
            try {
                d.manage().window().maximize(); // no-op in some headless modes, safe to call
                d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
            } catch (Exception ignored) {
                // Guard against any headless maximize quirks
            }
        }
    }

    public static void quitDriver() {
        WebDriver d = getDriver();
        if(d!=null){
            try {
                d.quit();
            }
            finally {
                driver.remove();
            }
        }

    }

}

