package configs;

import elements.Button;
import pages.BasePage;

import java.lang.reflect.InvocationTargetException;

public class PageManager {

    private static BasePage currentPage;

    public static void createPage(Class<? extends BasePage> page) {
        try {
            currentPage = page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

        public static BasePage getCurrentPage() {
            return currentPage;
        }

}
