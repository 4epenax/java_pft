package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

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
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(contactHelper.wd);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        contactHelper.wd.findElement(By.name("user")).click();
        contactHelper.wd.findElement(By.name("user")).clear();
        contactHelper.wd.findElement(By.name("user")).sendKeys(username);
        contactHelper.wd.findElement(By.name("pass")).click();
        contactHelper.wd.findElement(By.name("pass")).clear();
        contactHelper.wd.findElement(By.name("pass")).sendKeys(password);
        contactHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        contactHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void gotoHomePage() {
        contactHelper.wd.findElement(By.linkText("home")).click();
    }

    public void stop() {
        contactHelper.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
