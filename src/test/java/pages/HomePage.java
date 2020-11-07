package pages;

import annotations.ElementTitle;
import configs.DriverManager;
import elements.Button;
import elements.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @ElementTitle("пегас")
    @FindBy(xpath = "//img[@title='Система дистанционного обучения «Пегас»']")
    private Button pegas;

    @ElementTitle("поиск")
    @FindBy(xpath = "//input[@name='q']")
    private TextField textSearch;

    @ElementTitle("кнопка искать")
    @FindBy(xpath = "//input[@name='s']")
    private Button btnSearch;

    @ElementTitle("расписание")
    @FindBy(xpath = "//td[@id='ico-right']//a[@title='Расписание занятий']")
    private Button timeTable;

}
