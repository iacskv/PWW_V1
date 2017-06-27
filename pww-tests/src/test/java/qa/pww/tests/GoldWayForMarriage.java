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
    String fNum = "101";
    String lNum = "101";
    DocForLoad docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

    String book_max_id="";

    @BeforeClass
    public void initLoadDataForm() throws InterruptedException, SQLException {
        //загрузка/ввод АГС, получение номера книги
        app.loadDataHelper().gotoLoadDataPage();
        app.loadDataHelper().fillLoadNewDocGroupFofm(docAttr);
        app.loadDataHelper().submitLoad();
        app.loadDataHelper().waitingLogText();
        app.controlFormHelper().finishInputDocStage("Да","Да");
        book_max_id = app.inputFormHelper().getfromInputFormBookMaxInd();
    }


    @Test (enabled = true, priority = 1)
    //перевод книги на корректировку на форме "Управление Документами"
    public void controlDoc() throws InterruptedException, SQLException {

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
