package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage {
    WebDriver driver;

    By menuOptions = By.cssSelector(".oxd-main-menu-item");
    By adminMenu = By.xpath("//span[text()='Admin']");
    By usernameSearchBox = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    By searchButton = By.xpath("//button[normalize-space()='Search']");
    By userRoleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'select-text')]");
    By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class,'select-text')]");
    By dropdownOptions = By.cssSelector("div[role='listbox'] > div");
    By resultCount = By.cssSelector(".orangehrm-horizontal-padding .oxd-text");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAdminPage() {
        driver.findElement(adminMenu).click();
    }

    public int getMenuCount() {
        List<WebElement> menuList = driver.findElements(menuOptions);
        return menuList.size();
    }

    public void searchByUsername(String username) {
        driver.findElement(usernameSearchBox).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    public void searchByUserRole(String role) {
        driver.findElement(userRoleDropdown).click();
        selectDropdownOption(role);
        driver.findElement(searchButton).click();
    }

    public void searchByUserStatus(String status) {
        driver.findElement(statusDropdown).click();
        selectDropdownOption(status);
        driver.findElement(searchButton).click();
    }

    private void selectDropdownOption(String text) {
        List<WebElement> options = driver.findElements(dropdownOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(text)) {
                option.click();
                break;
            }
        }
    }

    public String getResultText() {
        return driver.findElement(resultCount).getText();
    }
}