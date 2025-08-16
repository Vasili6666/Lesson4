import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckExistingCodeForJUnite5Test {
    @Test
    void fillFormTest() {
        open("https://github.com/");
        $("span[data-target='qbsearch-input.inputButtonText']").shouldBe(visible).click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("span.search-match").shouldHave(text("selenide/selenide")).click();
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();
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
        Selenide.closeWebDriver();
    }
}