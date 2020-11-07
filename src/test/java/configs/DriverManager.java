package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver webDriver;

    public static WebDriver getWD(){
        if(webDriver == null){
            System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
            webDriver = new EdgeDriver();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return webDriver;
    }
}
