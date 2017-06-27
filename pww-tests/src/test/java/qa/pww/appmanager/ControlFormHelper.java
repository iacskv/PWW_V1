package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.SQLException;

import static qa.pww.Locators.ControlFormLocator.*;
import static qa.pww.Locators.SpanLocators.*;
import static qa.pww.tests.TestBase.app;

/**
 * Created by k.smotrov on 23.06.2017.
 */
public class ControlFormHelper extends HelperBase{

    public ControlFormHelper(WebDriver wd, Connection pvvDb, Connection zagsDb) {
        super(wd, pvvDb, zagsDb);
    }

    public void finishInputDocStage(String needChange1, String needChange2) throws InterruptedException {


        //возврат на "главную"
        app.inputFormHelper().gotoMainPage();
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "1");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму ввода
        app.inputFormHelper().gotoInputStageForm();
        //ожидание загрузки
        Thread.sleep(5000);
        //установка "Актовая запись с изменениями?"
        app.inputFormHelper().changesFieldMarriageSetup(needChange1);
        //сохранение документа
        app.inputFormHelper().submitSaveMarriageDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.inputFormHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа  на 1 этапе ввода без изменения - ok");

        //возврат на "главную"
        app.inputFormHelper().gotoMainPage();
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "2");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму ввода
        app.inputFormHelper().gotoInputStageForm();
        //ожидание загрузки
        Thread.sleep(5000);
        //установка "Актовая запись с изменениями?" = да
        app.inputFormHelper().changesFieldMarriageSetup(needChange2);
        //сохранение документа
        app.inputFormHelper().submitSaveMarriageDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.inputFormHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа на 2 этапе ввода без изменения - ok");
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
