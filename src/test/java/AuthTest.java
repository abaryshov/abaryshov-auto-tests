import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AuthTest {

    @Test
    public void shouldAuthorizeTest() {
        open("https://github.com");
        $("[href='/login']").click();
        $("[id='login_field']").sendKeys("ABaryshov");
        $("[id='password']").sendKeys("04061996ABaryshov");
        $(".js-sign-in-button").click();
        $(".Header").shouldBe(visible);
        $("[aria-label='View profile and more']").click();
        $(byText("Your profile")).click();
        $(".vcard-names").shouldBe(visible);
    }
}