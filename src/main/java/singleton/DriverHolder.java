package singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class DriverHolder {

    private static HashMap<String, WebDriver> session = new HashMap<String, WebDriver>();
    private static WebDriver webDriver;

    private DriverHolder() {
    }

    public static synchronized WebDriver getDriver(String driverName) {

        if(driverName.equalsIgnoreCase("OTHER")) {
            if (session.get(driverName) == null) {

                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                session.put(driverName, webDriver);
            }

            webDriver = session.get("other");
        }
        return webDriver;
    }

    public static void shutDown(WebDriver driver) {
        if (webDriver != null) driver.quit();
    }

}
