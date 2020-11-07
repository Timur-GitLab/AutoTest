package pages;

import annotations.ElementTitle;
import elements.TextField;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SourcePage extends BasePage {

    @ElementTitle("")
    @FindBy(xpath = "//span//b")
    private List<TextField> date;

    @ElementTitle("")
    @FindBy(xpath = "//td[@id='time']//nobr")
    private List<TextField> time;



}
