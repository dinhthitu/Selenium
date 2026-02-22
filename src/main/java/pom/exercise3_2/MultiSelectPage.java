package pom.exercise3_2;

import locator.exercise3_2.MultiSelectLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.BasePage;


public class MultiSelectPage extends BasePage {

    public MultiSelectPage(WebDriver driver) {
        super(driver);
    }

    public MultiSelectPage openMultiSelectPage() {
        WebElement widgets = waitForClickable(MultiSelectLocator.WIDGETS);
        scrollToCenter(widgets);
        widgets.click();
        WebElement selectMenu = waitForClickable(MultiSelectLocator.SELECT_MENU);
        scrollToCenter(selectMenu);
        selectMenu.click();
        return this;
    }

    public MultiSelectPage selectStyleColor(String value) {

        WebElement oldStyleMenu = waitForClickable(MultiSelectLocator.OLD_SELECT_MENU);
        Select selector = new Select(oldStyleMenu);
        selector.selectByVisibleText(value);

        return this;
    }

    public Select getSelect() {
        WebElement element = waitForClickable(MultiSelectLocator.MULTI_SELECT);
        scrollToCenter(element);

        Select select = new Select(element);
        if (!select.isMultiple()) {
            throw new IllegalStateException("This select does not support multiple selection");
        }
        return select;
    }

    public MultiSelectPage selectByValue(String value) {
        getSelect().selectByValue(value);
        return this;
    }

    public MultiSelectPage selectByIndex(int index) {
        getSelect().selectByIndex(index);
        return this;
    }

    public MultiSelectPage selectByText(String text) {
        getSelect().selectByVisibleText(text);
        return this;
    }

    public MultiSelectPage deselectByText(String text) {
        getSelect().deselectByVisibleText(text);
        return this;
    }

    public MultiSelectPage deleteByIndex(int index) {
        getSelect().deselectByIndex(index);
        return this;
    }

    public int getSelectSize() {
        return getSelect().getAllSelectedOptions().size();

    }

    public MultiSelectPage deselectAll() {
        getSelect().deselectAll();
        return this;
    }
}
