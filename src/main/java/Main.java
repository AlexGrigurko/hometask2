import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import singleton.DriverHolder;

public class Main {
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverHolder.getDriver("other");

        driver.get("https://google.com");
        Thread.sleep(3000);

        DriverHolder.shutDown(driver);

    }
}
