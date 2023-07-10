package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd;

    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;

    public HelperSearch getSearch() {
        return search;
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    public void init(){
//        wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        search = new HelperSearch(wd);
//        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void tearDown(){
        wd.quit();
    }
}
