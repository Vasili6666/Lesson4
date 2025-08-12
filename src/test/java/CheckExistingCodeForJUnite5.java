import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class CheckExistingCodeForJUnite5 {
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        // Удаляем мешающие элементы
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}