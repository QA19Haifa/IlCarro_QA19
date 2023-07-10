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

}
