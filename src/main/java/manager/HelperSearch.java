package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDays(dateFrom, dateTo);
    }
    public void fillSearchFormDatePickerDays(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDaysDatePicker(dateFrom, dateTo);
    }

    public void fillSearchFormDatePickerMonths(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodMonthsDatePicker(dateFrom, dateTo);
    }
    public void fillSearchFormDatePickerYears(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodYearsDatePicker(dateFrom, dateTo);
    }

    public void selectPeriodDays(String dateFrom, String dateTo) {
//        click(By.id("dates"));
        type(By.id("dates"), dateFrom + " - " + dateTo);
        pause(3000);
    }
    public void selectPeriodDaysDatePicker(String dateFrom, String dateTo) {
        //date  7/10/2023
        //index 0  1   2
        String[] startDate = dateFrom.split("/");
        String[] endDate = dateTo.split("/");
        click(By.id("dates"));
//        click(By.xpath("//div[.=' " + startDate[1] + " ']"));
//        click(By.xpath("//div[.=' " + endDate[1] + " ']"));
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartDate));
        click(By.xpath(locatorEndDate));
        pause(3000);
    }

    public void selectPeriodMonthsDatePicker(String dateFrom, String dateTo){
        int fromNowToStartMonth = 0, startToEndMonth = 0;
        String[] startDate = dateFrom.split("/");
        String[] endDate = dateTo.split("/");
        startToEndMonth = Integer.parseInt(endDate[0]) - Integer.parseInt(startDate[0]);
        click(By.id("dates"));
        if(LocalDate.now().getMonthValue() != Integer.parseInt(startDate[0])){
            fromNowToStartMonth = Integer.parseInt(startDate[0]) - LocalDate.now().getMonthValue();
        }
        for (int i = 0; i < fromNowToStartMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }

        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartDate));

        for (int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
        pause(3000);
    }

    public void selectPeriodYearsDatePicker(String dateFrom, String dateTo){
        LocalDate startDate = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate nowDate = LocalDate.now();
        String locatorStartDate = String.format("//div[.=' %s ']", startDate.getDayOfMonth());
        String locatorEndDate = String.format("//div[.=' %s ']", endDate.getDayOfMonth());

        click(By.id("dates"));

        int startToEndMonth = startDate.getYear() - nowDate.getYear() == 0 ?
                startDate.getMonthValue() - nowDate.getMonthValue() :
                12 - nowDate.getMonthValue() + startDate.getMonthValue();

        for (int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorStartDate));

        startToEndMonth = endDate.getYear() - startDate.getYear() == 0 ?
                endDate.getMonthValue() - startDate.getMonthValue() :
                12 - startDate.getMonthValue() + endDate.getMonthValue();

        for (int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
        pause(3000);
    }


    public void fillCity(String city) {
        type(By.id("city"), city);
        pause(3000);
        click(By.cssSelector("div.pac-item"));
        pause(3000);
    }

    public void submitForm(){
        wd.findElement(By.cssSelector("[type='submit']")).click();
    }

}
