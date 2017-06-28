package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.pww.models.BornDataMainFields;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static qa.pww.Locators.FirstInputStageBornFormLocators.*;
import static qa.pww.Locators.FirstInputStageMarriageFormLocators.*;
import static qa.pww.Locators.InputFormLocators.*;
import static qa.pww.Locators.ReviewDocForm.*;
import static qa.pww.Locators.SpanLocators.*;


/**
 * Created by k.smotrov on 25.05.2017.
 */
public class InputFormHelper extends HelperBase {


    public InputFormHelper(WebDriver wd, Connection pvvDb, Connection zagsDb) {
        super(wd, pvvDb, zagsDb);
    }

    JavascriptExecutor js = (JavascriptExecutor) wd;
    BornDataMainFields ags = new BornDataMainFields();

    //переход на "главную"
    public void gotoMainPage() {
        click(By.xpath(MAIN_SPAN));
    }

    //переход в форму выборы группы для ввода
    public void gotoInputForm() throws InterruptedException {

        click(By.xpath(PVV_SPAN));
        click(By.xpath(INPUT_BTN));

    }

    //заполнение фильтров поиска
    public void fillFormFiltersStage(String typeAgs, String stage) {
        click(By.xpath(TYPE_DOC)); //клик по фильтру "Тип"
        click(By.xpath("//div[text()='" + typeAgs + "']")); //выбор "Книга 2000-2003"
        click(By.xpath(STAGE)); //клик по фильтру "Этап"
        click(By.xpath("//div[text()='" + stage+ "']")); //клик по "2"

    }

    //запуск поиска пофильтрам
    public void submitFormFilters() {
        click(By.xpath(SHOW_BTN)); //клик по кнопке "Показать"
    }

    //получение максимального номера книги (группы документов) из БД
    public String getFromDbMaxBookId() throws SQLException {
        List<String> bookId = new ArrayList<>();
        PreparedStatement statement = getPvvDb().prepareStatement("select DOC_GRP_ID from DOCUMENT_GROUP where doc_grp_phase = 'input'");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            bookId.add(resultSet.getString("DOC_GRP_ID"));

        }
        String maxBookId = Collections.max(bookId);
        System.out.println("номер книги в DB = " + maxBookId);
        resultSet.close();
        return maxBookId;
    }

    //поиск строки в таблице с макс номером книги из UI
    public String getfromInputFormBookMaxInd() {

        String book_max_id = "";
        List<WebElement> elements = wd.findElements(By.xpath("//div[contains(text(),'Номер книги:')]"));
        ArrayList<String> book_id = new ArrayList<>();
        for (WebElement element : elements) {
            String identifier = element.getText();
            identifier = identifier.replaceAll("Наименование.*", "").replaceAll("Номер книги: ", "").replace(",", "").replace(" ", "");
            book_id.add(identifier);
        }
        book_max_id = Collections.max(book_id);
        System.out.println("последняя загруженная книга в UI= " + book_max_id);
        return book_max_id;
    }

    //сверка номера в БД и UI
    public void checkNumNewBook() throws SQLException, InterruptedException {
        String numDb = getFromDbMaxBookId();
        String numUi = getfromInputFormBookMaxInd();
        assertThat(numDb, equalTo(numUi));
    }


    //выбор последней загруженной книги из UI
    public void selectBook() throws InterruptedException {
        click(By.xpath("//div[contains(text(),'Номер книги: " + getfromInputFormBookMaxInd() + "')]"));
    }

    //переход на форму просмотра списка документов
    public void gotoViewBookForm() throws InterruptedException {
        click(By.xpath(VIEW_BTN));
    }

    //выбор а/з (рождение) на форме просмотра списка документов
    public void selectAgsBorn() {
        click(By.xpath("//span[contains(text(),'Запись акта о рождении')]"));
    }

    //выбор а/з (брак) на форме просмотра списка документов
    public void selectAgsMarriage() {
        click(By.xpath("//span[contains(text(),'Запись акта о браке')]"));
    }

    //проверка на "требуется ввод" на форме просмотра списка документов
    public void checkNeedInput() {
        assertThat(wd.findElement(By.xpath(NEED_INPUT_TD)).getText(), equalTo("да"));

    }

    //проверка на "введен" на форме просмотра списка документов
    public void checkInputedTrue() {
        assertThat(wd.findElement(By.xpath(INPUTED_TD)).getText(), equalTo("нет"));
    }

    //переход на форму ввода документа (1/2 этап)
    public void gotoInputStageForm() {
        click(By.xpath(LETS_INPUT_BTN));
    }



    //выход на форму списка книг
    public void backFromReviewDocForm() {
        click(By.xpath(BACK_FROM_REVIEW_DOC_FORM));
    }








    public String getNumAgsFromAxeLocator(){
        String value;
        value = wd.findElement(By.xpath("//label[contains(text(),'Литера:')]/following-sibling::*//input")).getText();

        return value;
    }


    //выбор в поле "Актовая запись с изменениями?" (Брак)
    public void changesFieldMarriageSetup(String status){
        type(By.xpath(MORE_HISTORY_MARRIAGE), status);
    }

    //сохранение документа (Брак)
    public void submitSaveMarriageDoc(){
        click(By.xpath(SAVE_MARRIAGE_BTN));
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputFormHelper that = (InputFormHelper) o;

        return ags != null ? ags.equals(that.ags) : that.ags == null;
    }

    @Override
    public int hashCode() {
        return ags != null ? ags.hashCode() : 0;
    }

}
