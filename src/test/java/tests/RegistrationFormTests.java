package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import com.example.RegistrationForm;
import com.example.components.CalendarWidget;
import com.example.components.RegistrationFormResults;

import static io.qameta.allure.Allure.step;

@Tag("remote")
public class RegistrationFormTests extends TestData{
    TestData testData = new TestData();

    @BeforeAll
    static void configTests() {
        TestsConfiguration testsConfiguration = new TestsConfiguration();
        testsConfiguration.configureTests();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

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

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Final screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }
}
