package exercise4_3;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise4_3.WebTablePage;

import static org.testng.AssertJUnit.assertEquals;


public class WebTablesTest extends BaseTest {

    private WebTablePage webTablePage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise4_3.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        DriverManager.get().get(config.get("url") + config.get("web-tables"));
        webTablePage = new WebTablePage(DriverManager.get());
    }

    @Test(priority = 1)
    public void addNewUser() {
        int beforeCount = webTablePage.getAllUser();
        webTablePage
                .addNewUser()
                .inputFirstName(config.get("firstName"))
                .inputLastName(config.get("lastName"))
                .inputEmail(config.get("email"))
                .inputAge(config.get("age"))
                .inputSalary(config.get("salary"))
                .inputDepartment(config.get("department"))
                .submitData();

        assertEquals(webTablePage.getAllUser(), beforeCount + 1);
    }


    @Test
    public void closeModalWithoutSubmit() {
        int beforeCount = webTablePage.getAllUser();

        webTablePage
                .addNewUser()
                .closeAddNew();

        assertEquals(webTablePage.getAllUser(), beforeCount);
    }



}