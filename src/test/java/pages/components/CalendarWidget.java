package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarWidget {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
