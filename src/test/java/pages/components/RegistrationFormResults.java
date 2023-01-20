package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class RegistrationFormResults {
    public RegistrationFormResults checkResultsAppear() {
        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public RegistrationFormResults validateResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
