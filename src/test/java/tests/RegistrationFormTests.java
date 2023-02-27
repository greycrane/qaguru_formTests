package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;
import pages.components.CalendarWidget;
import pages.components.RegistrationFormResults;

public class RegistrationFormTests {
    TestData testData = new TestData();

    @BeforeAll
    static void configTests() {
       TestsConfiguration testsConfiguration = new TestsConfiguration();
       testsConfiguration.configureTests();
    }

    @Test
    void studentRegistrationFormTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        CalendarWidget calendarWidget = new CalendarWidget();
        RegistrationFormResults registrationFormResults = new RegistrationFormResults();

        registrationForm
                .openPage()
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
                .setCity(testData.city)
                .submitForm();

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
    }
}
