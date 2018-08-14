package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final NavigationHelper navigationHelper = new NavigationHelper();
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        navigationHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        navigationHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        navigationHelper.wd.get("http://localhost/addressbook/group.php");
        contactHelper = new ContactHelper(navigationHelper.wd);
        groupHelper = new GroupHelper(navigationHelper.wd);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        navigationHelper.wd.findElement(By.name("user")).click();
        navigationHelper.wd.findElement(By.name("user")).clear();
        navigationHelper.wd.findElement(By.name("user")).sendKeys(username);
        navigationHelper.wd.findElement(By.name("pass")).click();
        navigationHelper.wd.findElement(By.name("pass")).clear();
        navigationHelper.wd.findElement(By.name("pass")).sendKeys(password);
        navigationHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        navigationHelper.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
