package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.pww.models.DocForLoad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void loadNewBook(String filePath) throws IOException, InterruptedException {
        //загрузка, ввод, завершение ввода а/з без истории
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            DocForLoad book = new DocForLoad(split[0], split[1], split[2], split[3], split[4], split[5]);
            app.loadDataHelper().gotoLoadDataPage();
            app.loadDataHelper().fillLoadNewDocGroupFofm(book);
            app.loadDataHelper().submitLoad();
            app.loadDataHelper().waitingLogText();
            line = reader.readLine();
        }
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
        app.firstInputStageMarriageHelper().submitEndInputGroup();
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
        app.firstInputStageMarriageHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа на 2 этапе ввода без изменения - ok");
    }

    public String getfromControlDocFormBookMaxInd() {

        String book_max_id = "";
        List<WebElement> elements = wd.findElements(By.xpath("//div[contains(text(),'Номер книги')]"));
        if (elements.size()== 0){return book_max_id;}
        ArrayList<String> book_id = new ArrayList<>();
        for (WebElement element : elements) {
            String identifier = element.getText();
            identifier = identifier.replaceAll("Наименование.*", "").replaceAll("Номер книги ", "").replace(",", "").replace(" ", "");
            book_id.add(identifier);
        }
        book_max_id = Collections.max(book_id);
        //System.out.println("последняя загруженная книга в UI= " + book_max_id);
        return book_max_id;
    }

    //статус книги

    public String getBookStatus(String book) throws InterruptedException {
        String status;

        click(By.xpath(FIND_OK_BTN));
        Thread.sleep(1000);
        status = wd.findElement(By.xpath("//tbody//div[contains(text(),'Номер книги " + book + "')]/../../td[2]/div")).getText();
        //System.out.println(status);
        return status;
    }

    //переход на вкладку "Управление документами"
    public void gotoControlSpan(){
        click(By.xpath(PVV_SPAN));
        click(By.xpath(CNTRL_DOC_BTN));

    }

    //выбор книги проведенной по вводу ранее
    public void selectBook(String book){
        click(By.xpath("//tbody//div[contains(text(),'Номер книги " + book + "')]"));
    }

    public String selectBookReadyPhase(){
        String book = "";
        List<WebElement> elements = wd.findElements(By.xpath("//tbody//div[contains(text(),'готов к выгрузке')]"));
        if (elements.size()== 0){return book;}
        click(By.xpath("//tbody//div[contains(text(),'готов к выгрузке')]"));
        book = wd.findElement(By.xpath("//tbody//div[contains(text(),'Номер книги " + book + "')]/../../td[4]/div")).getText();
        book = book.replaceAll("Наименование.*", "").replaceAll("Номер книги ", "").replace(",", "").replace(" ", "");
        System.out.println(book);
        return book;
    }

    //открытие форму "Редактирование"
    public void gotoEditForm(){
        click(By.xpath(EDIT_BTN));
    }

    //изменение фазы с "ввод" на "Верификация"
    public void moveBookToVerificationPhase() throws InterruptedException {

        Thread.sleep(1000);
        click(By.xpath(PHASE));
        Thread.sleep(1000);
        click(By.xpath(PHASE_VER));
        click(By.xpath(SAVE_AND_EXIT_BTN));

    }

    //изменение фазы с "готов к выгрузке" на "верификация"
    public void moveBookToCorrPhase() throws InterruptedException {

        Thread.sleep(1000);
        click(By.xpath(PHASE));
        Thread.sleep(1000);
        click(By.xpath(PHASE_COR));
        click(By.xpath(SAVE_AND_EXIT_BTN));

    }







}
