package elements;

import configs.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseElement  {

    protected WebElement wrappedElement;
    private WebDriverWait webDriverWait;

    public BaseElement(WebElement webElement){
        webDriverWait = new WebDriverWait(DriverManager.getWD(),10);
        this.wrappedElement = webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        wrappedElement.isDisplayed();
    }

    public WebElement getWrappedElement(){
        return this.wrappedElement;
    }


}
