package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {
    public RegistrationForm openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationForm setFirstname(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationForm setLastname(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationForm setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationForm setGender(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationForm setMobileNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationForm setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationForm setHobby(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationForm setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationForm setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationForm setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationForm setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationForm submitForm() {
        $("#submit").click();

        return this;
    }
}
