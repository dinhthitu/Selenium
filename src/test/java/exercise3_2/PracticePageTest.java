package exercise3_2;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise3_2.PracticePage;

import static org.testng.AssertJUnit.assertFalse;

public class PracticePageTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_2.properties");
    }

    private PracticePage practicePage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        practicePage = new PracticePage(DriverManager.get());
        practicePage.openPracticePage();
    }

    @Test
    public void testFillCompleteForm() {
        practicePage.enterName(config.get("firstname"),config.get("lastname"))
                .enterEmail(config.get("email"))
                .selectGender(config.get("gender"))
                .enterMobile(config.get("mobile"))
                .selectDateOfBirth(config.get("dateOfBirth"))
                .enterSubjects(config.get("subjects"))
                .selectHobbies(config.get("hobbies"))
                .setAddress(config.get("currentAddress"))
                .selectState(config.get("state"))
                .submitForm();

        assertFalse(practicePage.isModalDisplayed());
    }
}