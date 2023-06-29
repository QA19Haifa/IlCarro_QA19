package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john" + i + "@mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitForm();
        logger.info("Registration test starts with data : " + user.getEmail()
        + " & " + user.getPassword()
        );
        Assert.assertTrue(app.getUser().isRegistered());

    }

    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john" + i + "@mail.com")
                .withPassword("Asdf1234");

        app.getUser().openRegistrationForm();
        logger.info("Method openRegistrationForm() invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("Method fillRegistrationForm() invoked");
        app.getUser().submitForm();
        logger.info("Method submitForm() invoked");
        logger.info("Registration test starts with data : " + user.getEmail()
                + " & " + user.getPassword()
        );
//        Assert.assertTrue(app.getUser().isRegistered());

    }


}
