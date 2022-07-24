package WebDriver;

import io.cucumber.java8.Th;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver;
    private static EventFiringWebDriver eventFiringWebDriver = null;

    public static WebDriver returnDriver(String browserName) {
        if (driver == null) {
            driver = new ThreadLocal<>();

        }
        WebDriver wDriver = null;
        switch (browserName) {
            case "chrome":
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                wDriver = new ChromeDriver();
                eventFiringWebDriver = new EventFiringWebDriver(wDriver);
                eventFiringWebDriver.register(new Listeners());
                driver.set(eventFiringWebDriver);

        }
        return driver.get();
    }
}
