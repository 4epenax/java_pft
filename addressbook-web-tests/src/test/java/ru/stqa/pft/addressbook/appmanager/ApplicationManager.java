package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final GroupHelper groupHelper = new GroupHelper();

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        groupHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper.wd.get("http://localhost/addressbook/group.php");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        groupHelper.wd.findElement(By.name("user")).click();
        groupHelper.wd.findElement(By.name("user")).clear();
        groupHelper.wd.findElement(By.name("user")).sendKeys(username);
        groupHelper.wd.findElement(By.name("pass")).click();
        groupHelper.wd.findElement(By.name("pass")).clear();
        groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
        groupHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        groupHelper.wd.quit();
    }

    public void gotoHomePage() {
        groupHelper.wd.findElement(By.linkText("home")).click();
    }

    public void submitContactCreation() {
        groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        groupHelper.wd.findElement(By.name("firstname")).click();
        groupHelper.wd.findElement(By.name("firstname")).clear();
        groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        groupHelper.wd.findElement(By.name("lastname")).click();
        groupHelper.wd.findElement(By.name("lastname")).clear();
        groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        groupHelper.wd.findElement(By.name("home")).click();
        groupHelper.wd.findElement(By.name("home")).clear();
        groupHelper.wd.findElement(By.name("home")).sendKeys(contactData.getHome());
        groupHelper.wd.findElement(By.name("email")).click();
        groupHelper.wd.findElement(By.name("email")).clear();
        groupHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initContactCreation() {
        groupHelper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
