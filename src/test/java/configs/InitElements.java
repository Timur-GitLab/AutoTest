package configs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitElements {

    public static void initPageElements(Object page){
        Field[] fields = page.getClass().getDeclaredFields();

        List<Field> annotatedFields = Arrays.stream(fields).filter(field->field.isAnnotationPresent(FindBy.class)).collect(Collectors.toList());

        annotatedFields.forEach(afield->{
            FindBy.FindByBuilder findByBuilder = new FindBy.FindByBuilder();
            By by = findByBuilder.buildIt(afield.getAnnotation(FindBy.class),afield);

            WebElement webElement = DriverManager.getWD().findElement(by);

            afield.setAccessible(true);
            Object value = null;
            try {
                value = afield.getType().getDeclaredConstructor(WebElement.class).newInstance(webElement);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
                afield.set(page, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

}
