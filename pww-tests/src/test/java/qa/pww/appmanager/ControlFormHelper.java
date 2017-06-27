package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;

import static qa.pww.Locators.ControlFormLocator.*;
import static qa.pww.Locators.SpanLocators.*;

/**
 * Created by k.smotrov on 23.06.2017.
 */
public class ControlFormHelper extends HelperBase{

    public ControlFormHelper(WebDriver wd, Connection pvvDb, Connection zagsDb) {
        super(wd, pvvDb, zagsDb);
    }

    //переход на вкладку "Управление документами"
    public void gotoControlSpan(){
        click(By.xpath(PVV_SPAN));
        click(By.xpath(CNTRL_DOC_BTN));

    }

    //выбор книги проведенной по вводу ранее
    public void selectBook(String book){
        click(By.xpath("//div[contains(text(),'Номер книги " + book + "')]"));
    }

    //открытие форму "Редактирование"
    public void gotoEditForm(){
        click(By.xpath(EDIT_BTN));
    }

    //изменение фазы с "Ввода" на "Верификация"
    public void moveBookToVerificationPhase() throws InterruptedException {

        Thread.sleep(1000);
        click(By.xpath(PHASE));
        Thread.sleep(1000);
        click(By.xpath(PHASE_VER));
        click(By.xpath(SAVE_AND_EXIT_BTN));

    }

    //ожидание и проверка изменения статуса на "Корректировка"

    public String getBookStatus(String book) throws InterruptedException {
        String status;

        click(By.xpath(FIND_OK_BTN));
        Thread.sleep(1000);
        status = wd.findElement(By.xpath("//div[contains(text(),'Номер книги " + book + "')]/../../td[2]/div")).getText();
        //System.out.println(status);
        return status;
    }





}
