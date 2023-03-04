package tests;

import com.example.glossary.*;
import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String mobileNumber = faker.number().digits(10);
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1970, 2000));
    String monthOfBirth = String.valueOf(faker.options().option(Month.class));
    String dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28));
    String subject = String.valueOf(faker.options().option(Subject.class));
    String hobby = String.valueOf(faker.options().option(Hobby.class));
    String picture = "student.png";
    String currentAddress = faker.address().streetAddress();
    String state = String.valueOf(faker.options().option(State.class));
    String city = getCity();

    private String getCity() {
        if (state.equalsIgnoreCase(String.valueOf(State.NCR))) {
            city = String.valueOf(faker.options().option(NcrCity.class));
        } else if (state.equalsIgnoreCase(String.valueOf(State.Haryana))) {
            city = String.valueOf(faker.options().option(HaryanaCity.class));
        } else {
            city = String.valueOf(faker.options().option(RajasthanCity.class));
        }
        return city;
    }

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
}
