package qa.pww.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.pww.models.DocForLoad;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by k.smotrov on 23.06.2017.
 */
public class GoldWayForMarriage extends TestBase{

    String typedoc = "Книга записей актов (2000-2003)";
    String typeags = "Запись акта о браке";
    String year = "2003";
    String typezags = "Кронштадтский (1997-2003)";
    String fNum = "172";
    String lNum = "172";
    DocForLoad docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

    String book_max_id="";

    @BeforeClass
    public void initLoadDataForm() throws InterruptedException {
        //загрузка АГС
        app.loadDataHelper().gotoLoadDataPage();
        app.loadDataHelper().fillLoadNewDocGroupFofm(docAttr);
        app.loadDataHelper().submitLoad();
        app.loadDataHelper().waitingLogText();
    }

    @Test(enabled = true, priority = 1)
    //проверка завершения ввода документа (без истории) без изменения полей с направлением на корректировку
    public void finishInputDocOnFistStage() throws InterruptedException, SQLException {

        //возврат на "главную"
        app.inputFormHelper().gotoMainPage();
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "1");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        book_max_id = app.inputFormHelper().getfromUiBookMaxInd(); //сохранение номера книги для корректировки
        app.inputFormHelper().selectBook();
        //переход на форму ввода
        app.inputFormHelper().gotoInputStageForm();
        //ожидание загрузки
        Thread.sleep(5000);
        //установка "Актовая запись с изменениями?" = да
        app.inputFormHelper().changesFieldMarriageSetup("Да");
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
        app.inputFormHelper().changesFieldMarriageSetup("Да");
        //сохранение документа
        app.inputFormHelper().submitSaveMarriageDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.inputFormHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа на 2 этапе ввода без изменения - ok");
    }

    @Test (enabled = true, priority = 3)
    //перевод книги на корректировку на форме "Управление Документами"
    public void controlDoc() throws InterruptedException {

        String status_book="";

        //переход на вкладку "Управление документами"
        app.controlFormHelper().gotoControlSpan();
        //выбор книги проведенной по вводу ранее
        app.controlFormHelper().selectBook(book_max_id);

        //проверка что статус книги "Ввод"
        status_book = app.controlFormHelper().getBookStatus(book_max_id);
        assertThat(status_book, equalTo("ввод"));
        System.out.println("статус книги " + book_max_id + " - ввод");

        //открытие окна "Редактирование"
        app.controlFormHelper().selectBook(book_max_id);
        app.controlFormHelper().gotoEditForm();
        //изменение фазы с "Ввода" на "Верификация"
        app.controlFormHelper().moveBookToVerificationPhase();

        //проверка статуса книги
        Thread.sleep(70000);
        status_book = app.controlFormHelper().getBookStatus(book_max_id);
        assertThat(status_book, equalTo("корректировка"));
        System.out.println("статус книги " + book_max_id + " - корректировка");
    }
}
