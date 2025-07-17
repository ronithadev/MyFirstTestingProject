package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AdminPage;

public class HrmTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed!");
    }

    @Test(priority = 2)
    public void testLeftMenuOptionsCount() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        AdminPage admin = new AdminPage(driver);
        int count = admin.getMenuCount();
        System.out.println("Left Menu Option Count: " + count);
        Assert.assertEquals(count, 12);
        admin.goToAdminPage();
    }

    @Test(priority = 3)
    public void testSearchByUsername() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        AdminPage admin = new AdminPage(driver);
        admin.goToAdminPage();
        admin.searchByUsername("Admin");
        System.out.println("Search Result: " + admin.getResultText());
    }

    @Test(priority = 4)
    public void testSearchByUserRole() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        AdminPage admin = new AdminPage(driver);
        admin.goToAdminPage();
        admin.searchByUserRole("Admin");
        System.out.println("Search Result: " + admin.getResultText());
    }

    @Test(priority = 5)
    public void testSearchByUserStatus() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        AdminPage admin = new AdminPage(driver);
        admin.goToAdminPage();
        admin.searchByUserStatus("Enabled");
        System.out.println("Search Result: " + admin.getResultText());
    }
}