package elements;

import interfaces.Clickable;
import org.openqa.selenium.*;

public class Button extends BaseElement implements Clickable {
    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click(){
        getWrappedElement().click();
    }



}
