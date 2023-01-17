package forms;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormsTests {

    @BeforeAll
    static void configTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void studentRegistrationFormTest() {
        String firstName = "John";
        String lastName = "Doe";
        String userEmail = "j.doe@hotmail.com";
        String gender = "Male";
        String mobileNumber = "9991234567";
        String yearOfBirth = "1990";
        String monthOfBirth = "February";
        String dayOfBirth = "01";
        String subject1 = "Biology";
        String subject2 = "Maths";
        String hobbie1 = "Reading";
        String hobbie2 = "Music";
        String picture = "student.png";
        String currentAddress = "10 Lincoln Blvd";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $(byText(hobbie1)).click();
        $(byText(hobbie2)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();
        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").
                shouldHave(
                        text(firstName + " " + lastName),
                        text(userEmail),
                        text(gender),
                        text(mobileNumber),
                        text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                        text(subject1 + ", " + subject2),
                        text(hobbie1 + ", " + hobbie2),
                        text(picture),
                        text(currentAddress),
                        text(state + " " + city)
                );
    }
}
