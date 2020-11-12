package uk.co.theautomatedtester.book.env;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {

    public static void initWebDriver() {
        String osName = System.getProperty("os.name");
        String chromeDriverPath;

        if (osName.contains("Mac OS")) {
            chromeDriverPath = "src/main/resources/drivers/mac/chromedriver";
        } else if (osName.contains("Windows")) {
            chromeDriverPath = "src/main/resources/drivers/win/chromedriver.exe";
        } else if (osName.contains("Linux")) {
            chromeDriverPath = "src/main/resources/drivers/linux/chromedriver";
        } else {
            throw new IllegalArgumentException("Unknown OS: " + System.getProperty("os.name"));
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }

    public static void openUrl(String url) {
        RunEnvironment.getWebDriver().get(url);
    }

}
