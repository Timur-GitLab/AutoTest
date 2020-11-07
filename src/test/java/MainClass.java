import configs.DriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TimeTablePage;
import steps.CommonSteps;

public class MainClass {

    WebDriver driver = DriverManager.getWD();
    CommonSteps commonSteps;

    @Test
    public void allActions(){
        driver.get("https://www.bsu.edu.ru");
        commonSteps = new CommonSteps();
        commonSteps.setPage(HomePage.class);
        commonSteps.click("расписание");
        commonSteps.setPage(TimeTablePage.class);
        commonSteps.search("поиск групп","12001808");
        commonSteps.work();
    }

    @After
    public void tearDown(){
        DriverManager.getWD().close();
        DriverManager.getWD().quit();
    }
}
