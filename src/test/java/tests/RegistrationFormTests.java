package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;
import pages.components.CalendarWidget;
import pages.components.RegistrationFormResults;

public class RegistrationFormTests {

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
        String hobby1 = "Reading";
        String hobby2 = "Music";
        String picture = "student.png";
        String currentAddress = "10 Lincoln Blvd";
        String state = "NCR";
        String city = "Delhi";
        String resultsStudentName = "Student Name";
        String resultsStudentEmail = "Student Email";
        String resultsGender = "Gender";
        String resultsMobile = "Mobile";
        String resultsDateOfBirth = "Date of Birth";
        String resultsSubjects = "Subjects";
        String resultsHobbies = "Hobbies";
        String resultsPicture = "Picture";
        String resultsAddress = "Address";
        String resultsStateAndCity = "State and City";

        registrationForm
                .openPage()
                .setFirstname(firstName)
                .setLastname(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setMobileNumber(mobileNumber);

        calendarWidget.setDate(dayOfBirth, monthOfBirth, yearOfBirth);

        registrationForm
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobby(hobby1)
                .setHobby(hobby2)
                .setPicture(picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationFormResults
                .checkResultsAppear()
                .validateResults(resultsStudentName, firstName + " " + lastName)
                .validateResults(resultsStudentEmail, userEmail)
                .validateResults(resultsGender, gender)
                .validateResults(resultsMobile, mobileNumber)
                .validateResults(resultsDateOfBirth, dayOfBirth + " "
                        + monthOfBirth + "," + yearOfBirth)
                .validateResults(resultsSubjects, subject1 + ", " + subject2)
                .validateResults(resultsHobbies, hobby1 + ", " + hobby2)
                .validateResults(resultsPicture, picture)
                .validateResults(resultsAddress, currentAddress)
                .validateResults(resultsStateAndCity, state + " " + city);
    }
}
