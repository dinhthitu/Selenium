package exercise2_1;

import utils.Calculator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class CalculatorTest {

    private Calculator calculator;
    private SoftAssert softAssert;

    // ===== SUITE =====
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println(">>> Before Suite");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println(">>> After Suite");
    }

    // ===== CLASS =====
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println(">>> Before Class");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println(">>> After Class");
    }

    // ===== METHOD =====
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        softAssert = new SoftAssert();
        System.out.println(">>> Before Method");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        System.out.println(">>> After Method: " + result.getName());
    }

    // ===== TESTS =====

    @Test(groups = "basic")
    public void testAdd() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test(groups = "basic")
    public void testSubtract() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test(groups = "basic")
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(4, 5), 20);
    }

    @Test(groups = "basic")
    public void testDivide() {
        Assert.assertEquals(calculator.divide(10, 2), 5.0);
    }

    @Test(groups = "edge")
    public void testDivideByZero() {
        try {
            calculator.divide(10, 0);
            Assert.fail("Expected exception was not thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("divide by zero"));
        }
    }

    @Test(groups = "soft")
    public void testSoftAssertExample() {
        softAssert.assertEquals(calculator.add(1, 1), 2);
        softAssert.assertEquals(calculator.subtract(5, 2), 3);
        softAssert.assertEquals(calculator.multiply(2, 3), 6);
        softAssert.assertAll();
    }
}