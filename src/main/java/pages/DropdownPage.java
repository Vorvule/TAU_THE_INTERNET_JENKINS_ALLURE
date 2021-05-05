package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    private Select findDropDownElement() {
        return new Select((driver.findElement(dropdown)));
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByValue("1");
    }

    public List<String> getSelectedOption() {
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }

}
