package steps;

import annotations.ElementTitle;
import configs.PageManager;
import interfaces.Clickable;
import interfaces.TextEditable;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonSteps {

    public void setPage(Class<? extends BasePage> clazz){
        PageManager.createPage(clazz);
    }

    public void click(String elementTitle){
        ((Clickable)getElement(elementTitle)).click();
    }

    public void search(String elementTitle, String text){
        ((TextEditable)getElement(elementTitle)).search(text);
    }

    public void setText(String elementTitle, String text){
        ((TextEditable)getElement(elementTitle)).setText(text);
    }

    public void getText(String elementTitle){
        ((TextEditable)getElement(elementTitle)).getText();
    }

    public Object getElement(String fieldName){
        List<Field> elementTitles = Arrays.stream(PageManager
                .getCurrentPage()
                .getClass()
                .getDeclaredFields())
                .filter(e -> e.isAnnotationPresent(ElementTitle.class))
                .collect(Collectors.toList());

        try {
            return elementTitles.stream().filter(e -> {
                e.setAccessible(true);
                return e.getAnnotation(ElementTitle.class).value().equals(fieldName);
            })
                    .findFirst()
                    .get()
                    .get(PageManager.getCurrentPage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void work(){

    }



}
