package qa.pww.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 22.06.2017.
 */
public class ControlDocumentTests extends TestBase{

    String fileForMoveAgsToSave = "src/test/resources/AGS_WITHOUT_HISTORY.txt";
    String fileForMoveAgsToCor = "src/test/resources/AGS_WITH_HISTORY.txt";

    @Test (enabled = true, priority = 1)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Готов к выгрузке" (группа без ошибок и без истории)
    public void moveGroupToVerification() throws InterruptedException, IOException {

        //загрузка нужной а/з
        app.controlFormHelper().loadNewBook(fileForMoveAgsToSave);
        //ввод и завершение ввода с признаком "изменений нет"
        app.controlFormHelper().finishInputDocStage("Нет", "Нет");

        //переход на вкладку "Управление документами"
        app.controlFormHelper().gotoControlSpan();
        //выбор книги проведенной по вводу ранее
        Thread.sleep(1000);
        String book_max_id = app.controlFormHelper().getfromControlDocFormBookMaxInd();
        app.controlFormHelper().selectBook(book_max_id);

        //проверка что статус книги "Ввод"
        String status_book = app.controlFormHelper().getBookStatus(book_max_id);
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
        assertThat(status_book, equalTo("готов к выгрузке"));
        System.out.println("статус книги " + book_max_id + " - готов к выгрузке");
    }



    @Test (enabled = true, priority = 6)
    //перевод из "Готов к выгрузке" в "Корректировка"
    public void moveGroupToCorrectionFromSave() throws IOException, InterruptedException {

        //переход на вкладку "Управление документами"
        app.controlFormHelper().gotoControlSpan();

        //проверка что есть книга со статусом "готов к выгрузке", если нет создать такую
        String book_ready_phase = app.controlFormHelper().selectBookReadyPhase();
        if ( book_ready_phase.equals("") ){
                moveGroupToVerification();
            }
        String status_book = app.controlFormHelper().getBookStatus(book_ready_phase);
        assertThat(status_book, equalTo("готов к выгрузке"));
        System.out.println("статус книги " + book_ready_phase + " - готов к выгрузке");

        //открытие окна "Редактирование"
        app.controlFormHelper().selectBook(book_ready_phase);
        app.controlFormHelper().gotoEditForm();

        //изменение фазы с "Ввода" на "Верификация" и проверка
        app.controlFormHelper().moveBookToCorrPhase();
        status_book = app.controlFormHelper().getBookStatus(book_ready_phase);
        assertThat(status_book, equalTo("верификация"));
        System.out.println("статус книги " + book_ready_phase + " - верификация");

    }

    @Test (enabled = false, priority = 5)
    //перевод группы из "Корректировки" в "Готов к выгрузке"
    public void moveGroupToSaveFromCorrection(){
        //пусто
    }

    @Test (enabled = false, priority = 2)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа c ошибоками, без истории)
    public void moveGroupWithErrorsToCorrection(){
        //пусто
    }

    @Test (enabled = false, priority = 3)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа без ошибок, с историей)
    public void moveGroupWithHistoryToCorrection(){
        //пусто
    }

    @Test (enabled = false, priority = 4)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа c ошибоками, с историей)
    public void moveGroupWithErrorsAndHistoryToCorrection(){
        //пусто
    }


}
