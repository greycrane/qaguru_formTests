package tests;

import com.example.RegistrationForm;
import com.example.components.CalendarWidget;
import com.example.components.RegistrationFormResults;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("remote")
public class RegistrationFormTests extends TestBase{
    TestData testData = new TestData();

    @Test
    void studentRegistrationFormTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        CalendarWidget calendarWidget = new CalendarWidget();
        RegistrationFormResults registrationFormResults = new RegistrationFormResults();

        step("Open form", () -> {
            registrationForm.openPage();
        });
        step("Fill in form", () -> {
            registrationForm
                    .setFirstname(testData.firstName)
                    .setLastname(testData.lastName)
                    .setEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .setMobileNumber(String.valueOf(testData.mobileNumber));

            calendarWidget.setDate(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth);

            registrationForm
                    .setSubject(testData.subject)
                    .setHobby(testData.hobby)
                    .setPicture(testData.picture)
                    .setAddress(testData.currentAddress)
                    .setState(testData.state)
                    .setCity(testData.city);
        });
        step("Submit form", () -> {
            registrationForm.submitForm();
        });
        step("Verify results", () -> {
            registrationFormResults
                    .checkResultsAppear()
                    .validateResults(testData.resultsStudentName, testData.firstName + " " + testData.lastName)
                    .validateResults(testData.resultsStudentEmail, testData.userEmail)
                    .validateResults(testData.resultsGender, testData.gender)
                    .validateResults(testData.resultsMobile, String.valueOf(testData.mobileNumber))
                    .validateResults(testData.resultsDateOfBirth, testData.dayOfBirth + " "
                            + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .validateResults(testData.resultsSubjects, testData.subject)
                    .validateResults(testData.resultsHobbies, testData.hobby)
                    .validateResults(testData.resultsPicture, testData.picture)
                    .validateResults(testData.resultsAddress, testData.currentAddress)
                    .validateResults(testData.resultsStateAndCity, testData.state + " " + testData.city);
        });
    }
}
