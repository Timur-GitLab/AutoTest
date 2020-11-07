package pages;

import configs.DriverManager;
import configs.InitElements;
import configs.PageManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        InitElements.initPageElements(this);
    }
}
