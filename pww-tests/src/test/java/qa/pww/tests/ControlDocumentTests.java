package qa.pww.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.pww.models.DocForLoad;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 22.06.2017.
 */
public class ControlDocumentTests extends TestBase{




    @BeforeClass
    //очистка БД ПВВ
    public void clearDbPVV() throws InterruptedException {

    }



    @Test (enabled = false, priority = 1)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Готов к выгрузке" (группа без ошибок и без истории)
    public void moveGroupToVerification() throws InterruptedException, IOException {


        //загрузка а/з без истории
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/AGS_WITHOUT_HISTORY.txt")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            DocForLoad book = new DocForLoad(split[0], split[1], split[2], split[3], split[4], split[5]);
            app.inputFormHelper().gotoMainPage();
            app.loadDataHelper().fillLoadNewDocGroupFofm(book);
            app.loadDataHelper().submitLoad();
            app.loadDataHelper().waitingLogText();
            line = reader.readLine();
        }

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

    @Test (enabled = false, priority = 2)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа c ошибоками, без истории)
    public void moveGroupWithErrorsToCorrection(){

    }

    @Test (enabled = false, priority = 3)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа без ошибок, с историей)
    public void moveGroupWithHistoryToCorrection(){

    }

    @Test (enabled = false, priority = 4)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа c ошибоками, с историей)
    public void moveGroupWithErrorsAndHistoryToCorrection(){

    }

    @Test (enabled = false, priority = 5)
    //перевод группы из "Корректировки" в "Готов к выгрузке"
    public void moveGroupToSaveFromCorrection(){

    }

    @Test (enabled = false, priority = 6)
    //перевод из "Готов к выгрузке" в "Корректировка"
    public void moveGroupToCorrectionFromSave(){

    }



}
