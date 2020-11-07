package pages;

import annotations.ElementTitle;
import elements.TextField;
import org.openqa.selenium.support.FindBy;

public class TimeTablePage extends BasePage{

    @ElementTitle("поиск групп")
    @FindBy(id = "sched_search")
    private TextField group;
}
