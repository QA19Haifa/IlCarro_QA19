package tests;

import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    // fillSearchForm with location
    // fillSearchForm with date
    // submit

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillSearchForm("Haifa", "7/10/2023", "7/20/2023");
        app.getSearch().submitForm();
    }
    @Test
    public void searchPositiveTestDatePickerDays(){
        app.getSearch().fillSearchFormDatePickerDays("Haifa", "7/10/2023", "7/20/2023");
        app.getSearch().submitForm();

    }

    @Test
    public void searchPositiveTestDatePickerMonths(){
        app.getSearch().fillSearchFormDatePickerMonths("Haifa", "7/13/2023", "10/13/2023");
        app.getSearch().submitForm();

    }
    @Test
    public void searchPositiveTestDatePickerYears(){
        app.getSearch().fillSearchFormDatePickerYears("Haifa", "03/13/2024", "07/12/2024");
        app.getSearch().submitForm();

    }
}
