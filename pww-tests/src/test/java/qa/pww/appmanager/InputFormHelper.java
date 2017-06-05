package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static qa.pww.Locators.FirstInputStageFormLocators.*;
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


    public void gotoMainPage(){
        click(By.xpath(MAIN_SPAN));
    }



    public void gotoInputForm() throws InterruptedException {

        click(By.xpath(PVV_SPAN));
        click(By.xpath(INPUT_BTN));

    }

    public void fillFormFiltersFirstStage() {
        click(By.xpath(TYPE_DOC)); //клик по фильтру "Тип"
        click(By.xpath("//div[text()='Книга записей актов (2000-2003)']")); //выбор "Книга 2000-2003"
        click(By.xpath(STAGE)); //клик по фильтру "Этап"
        click(By.xpath("//div[text()='1']")); //клик по "1"

    }

    public void fillFormFiltersSecondStage() {
        click(By.xpath(TYPE_DOC)); //клик по фильтру "Тип"
        click(By.xpath("//div[text()='Книга записей актов (2000-2003)']")); //выбор "Книга 2000-2003"
        click(By.xpath(STAGE)); //клик по фильтру "Этап"
        click(By.xpath("//div[text()='2']")); //клик по "2"

    }

    public void submitFormFilters() {
        click(By.xpath(SHOW_BTN)); //клик по кнопке "Показать"
    }

    //получение максимального номера книги (группы документов) из БД
    public String getFromDbMaxBookId() throws SQLException {
        List<String> bookId = new ArrayList<>();
        PreparedStatement statement = getPvvDb().prepareStatement("select DOC_GRP_ID from DOCUMENT_GROUP");
        ResultSet resultSet = statement.executeQuery();
        while( resultSet.next() ){
            bookId.add(resultSet.getString("DOC_GRP_ID"));

        }
        String maxBookId = Collections.max(bookId);
        System.out.println("номер книги в DB = " + maxBookId);
        resultSet.close();
        return maxBookId;
    }

    //поиск строки в таблице с макс номером книги из UI
    public String getfromUiBookMaxInd() {

        String book_max_id;
        List<WebElement> elements = wd.findElements(By.xpath("//div[contains(text(),'Номер книги:')]"));
        ArrayList<String> book_id = new ArrayList<>();
        for (WebElement element : elements) {
            String identifier = element.getText();
            identifier = identifier.replaceAll("Наименование.*", "").replaceAll("Номер книги: ", "").replace(",", "").replace(" ", "");
            book_id.add(identifier);
        }
        book_max_id = Collections.max(book_id);
        System.out.println("номер книги в UI= " + book_max_id);
        return book_max_id;
    }

    public void checkNumNewBook() throws SQLException, InterruptedException {


        String numDb = getFromDbMaxBookId();
        String numUi = getfromUiBookMaxInd();

        assertThat(numDb, equalTo(numUi));
    }



    public void selectBook() throws InterruptedException {
        //Thread.sleep(5000);
        click(By.xpath("//div[contains(text(),'Номер книги: " + getfromUiBookMaxInd() + "')]"));
    }

    public void gotoViewBookForm() throws InterruptedException {
        //Thread.sleep(5000);
        click(By.xpath(VIEW_BTN));
    }

    public void selectAgs() {
        click(By.xpath("//span[contains(text(),'Запись акта о рождении')]"));
    }

    public void checkNeedInput() {
        assertThat(wd.findElement(By.xpath(NEED_INPUT_TD)).getText(), equalTo("да"));

    }

    public void checkInputedTrue() {
        assertThat(wd.findElement(By.xpath(INPUTED_TD)).getText(), equalTo("нет"));
    }

    public void gotoInputStageForm(){
        click(By.xpath(LETS_INPUT_BTN));
    }

    public String textNumDoc(){
        String a = "";
        a = js.executeScript("return document.evaluate('" + NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        return a;
    }

    public void backFromInputStageForm(){
        click(By.xpath(BACK_FROM_INPUT_FORM_BTN));
    }

    public void backFromReviewDocForm(){
        click(By.xpath(BACK_FROM_REVIEW_DOC_FORM));
    }



    //получение реквизитов 1 документа книги (группы документов) с макс. номером (последней загруженной) из БД
    public List<String> getFromDbDocMainFields() throws Exception {
        String sqlFieldsRequest = "WITH DOCUMENT_VALUES AS (SELECT DOC_STAGE_PROP_ID PROPERTY_ID, REQ_ID, VALUE, LEVEL PROPERTY_LEVEL, ROWNUM PROPERTY_ORDER, PROP_ORDER MULTIPLICITY FROM DOCUMENT_STAGE_PROPERTY START WITH PARENT_ID IS NULL AND DOC_STAGE_ID = (SELECT MIN (doc_stage_id) FROM document_stage WHERE doc_id IN (SELECT MIN (doc_id) FROM document WHERE doc_grp_id IN (SELECT MAX (doc_grp_id) FROM document_group))) CONNECT BY PRIOR DOC_STAGE_PROP_ID = PARENT_ID) SELECT PROPERTY_ORDER, LPAD(' ', (PROPERTY_LEVEL - 1) * 6, ' ') || REQ_NAME PROPERTY_NAME, VALUE, MULTIPLICITY, DOCUMENT_VALUES.REQ_ID, REQ_CODE PROPERTY_CODE, PROPERTY_ID FROM DOCUMENT_VALUES, DOCUMENT_TYPE_REQUISITE WHERE DOCUMENT_VALUES.REQ_ID = DOCUMENT_TYPE_REQUISITE.REQ_ID ORDER BY PROPERTY_ORDER";
        List<String> reqValue = new ArrayList<>();
        PreparedStatement statement = getPvvDb().prepareStatement(sqlFieldsRequest);
        ResultSet resultSet = statement.executeQuery();
        while( resultSet.next() ){
            reqValue.add(resultSet.getString("VALUE" ));
        }
        resultSet.close();
        return reqValue;
    }




}
