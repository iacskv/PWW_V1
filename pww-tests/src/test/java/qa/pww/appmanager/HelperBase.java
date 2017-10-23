package qa.pww.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.sql.Connection;

/**
 * Created by Константин on 19.03.2017.
 */
public class HelperBase {
    protected WebDriver wd;
    protected Connection pvvDb;
    protected Connection zagsDb;

    public HelperBase(WebDriver wd, Connection pvvDb, Connection zagsDb) {
        this.wd = wd;
        this.pvvDb = pvvDb;
        this.zagsDb = zagsDb;
    }

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void doubleClickAndType(By locator, String text) throws InterruptedException {

            Actions actions = new Actions(wd);
            actions.doubleClick(wd.findElement(locator))
                    .keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL)
                    .sendKeys(Keys.DELETE)
                    .sendKeys(text).perform();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void attach(By locator, File file) {

        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public WebDriver getWd() {
        return wd;
    }

    public Connection getPvvDb() {
        return pvvDb;
    }

    public Connection getZagsDb() {
        return zagsDb;
    }
}
