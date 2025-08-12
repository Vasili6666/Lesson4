import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckExistingCodeForJUnite5Test {
    @Test
    void fillFormTest() {
        open("https://github.com/");

        // Открыть сайт и кликнуть на поле поиска
        $("span[data-target='qbsearch-input.inputButtonText']").shouldBe(visible).click();

        // Вести слово selenide
        $("#query-builder-test").setValue("selenide").pressEnter();

        // Найти и нажать selenide/selenide
        $("span.search-match").shouldHave(text("selenide/selenide")).click();

        // Поиск и нажатие Wiki
        $("#wiki-tab").click();
        // Поиск и нажатие Soft assertions
        $(byText("Soft assertions")).click();

        //Проверка наличия в "wiki-body" текста "Using JUnit5"
        //$("#wiki-body").shouldHave(text("ExtendWith"));
        String expectedCode = """
    @ExtendWith({SoftAssertsExtension.class})
    class Tests {
      @Test
      void test() {
        Configuration.assertionMode = SOFT;
        open("page.html");
        $("#first").should(visible).click();
        $("#second").should(visible).click();
      }
    }""";

        $("#wiki-body").shouldHave(text(expectedCode));

        //sleep(5000);

        Selenide.closeWebDriver();
    }
}