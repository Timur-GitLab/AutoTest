package elements;

import interfaces.TextEditable;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement implements TextEditable {
    public TextField(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setText(String text){
        getWrappedElement().sendKeys(text);
    }

    @Override
    public void getText(){
        getWrappedElement().getText();
    }

    public void search(String text){
        getWrappedElement().sendKeys(text);
        getWrappedElement().submit();
    }

}
