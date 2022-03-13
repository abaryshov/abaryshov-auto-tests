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
        sleep(2000);
        $("[id='login_field']").sendKeys("ABaryshov");
        sleep(2000);
        $("[id='password']").sendKeys("04061996ABaryshov");
        sleep(2000);
        $(".js-sign-in-button").click();
        sleep(2000);
        $(".Header").shouldBe(visible);
        $("[aria-label='View profile and more']").click();
        sleep(2000);
        $(byText("Your profile")).click();
        sleep(2000);
        $(".vcard-names").shouldBe(visible);
    }

}