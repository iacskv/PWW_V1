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


    public void gotoMainPage() {
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
        while (resultSet.next()) {
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

    //сверка номера в БД и UI
    public void checkNumNewBook() throws SQLException, InterruptedException {
        String numDb = getFromDbMaxBookId();
        String numUi = getfromUiBookMaxInd();
        assertThat(numDb, equalTo(numUi));
    }


    //выбор последней загруженной книги из UI
    public void selectBook() throws InterruptedException {
        click(By.xpath("//div[contains(text(),'Номер книги: " + getfromUiBookMaxInd() + "')]"));
    }

    //переход на форму просмотра списка документов
    public void gotoViewBookForm() throws InterruptedException {
        click(By.xpath(VIEW_BTN));
    }

    //выбор а/з на форме просмотра списка документов
    public void selectAgs() {
        click(By.xpath("//span[contains(text(),'Запись акта о рождении')]"));
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

    //определение номера документа из UI
    public String textNumDoc() {
        String a = "";
        a = js.executeScript("return document.evaluate('" + NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        return a;
    }

    //выход из формы ввода документа (1/2 этап)
    public void backFromInputStageForm() {
        click(By.xpath(BACK_FROM_INPUT_FORM_BTN));
    }

    //выход на форму списка книг
    public void backFromReviewDocForm() {
        click(By.xpath(BACK_FROM_REVIEW_DOC_FORM));
    }


    //получение реквизитов 1 документа книги (группы документов) с макс. номером (последней загруженной) из БД
    public List<String> getFromDbDocMainFields() throws Exception {
        String sqlFieldsRequest = "WITH DOCUMENT_VALUES AS (SELECT DOC_STAGE_PROP_ID PROPERTY_ID, REQ_ID, VALUE, LEVEL PROPERTY_LEVEL, ROWNUM PROPERTY_ORDER, PROP_ORDER MULTIPLICITY FROM DOCUMENT_STAGE_PROPERTY START WITH PARENT_ID IS NULL AND DOC_STAGE_ID = (SELECT MIN (doc_stage_id) FROM document_stage WHERE doc_id IN (SELECT MIN (doc_id) FROM document WHERE doc_grp_id IN (SELECT MAX (doc_grp_id) FROM document_group))) CONNECT BY PRIOR DOC_STAGE_PROP_ID = PARENT_ID) SELECT PROPERTY_ORDER, LPAD(' ', (PROPERTY_LEVEL - 1) * 6, ' ') || REQ_NAME PROPERTY_NAME, VALUE, MULTIPLICITY, DOCUMENT_VALUES.REQ_ID, REQ_CODE PROPERTY_CODE, PROPERTY_ID FROM DOCUMENT_VALUES, DOCUMENT_TYPE_REQUISITE WHERE DOCUMENT_VALUES.REQ_ID = DOCUMENT_TYPE_REQUISITE.REQ_ID ORDER BY PROPERTY_ORDER";
        List<String> reqValue = new ArrayList<>();
        PreparedStatement statement = getPvvDb().prepareStatement(sqlFieldsRequest);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            reqValue.add(resultSet.getString("VALUE"));
        }
        resultSet.close();
        return reqValue;
    }

    //получение значений полей из формы ввода документа

    public BornDataMainFields getMainField(){

        BornDataMainFields ags = new BornDataMainFields();
        String dataField = "";

        JavascriptExecutor js = (JavascriptExecutor) wd;
        //данные о а/з
        dataField = js.executeScript("return document.evaluate('" + NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsNum = dataField;
        dataField = js.executeScript("return document.evaluate('" + LITER + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.liter = dataField;

        dataField = js.executeScript("return document.evaluate('" + CH_DD_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.agsDd = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_MM_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.agsmm = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_YYYY_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.agsYyyy = dataField;

        dataField = js.executeScript("return document.evaluate('" + NAME_ZAGS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.zagsAgsName = dataField;
        dataField = js.executeScript("return document.evaluate('" + NUM_COPY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsCopy = dataField;

        //данные о ребенке
        dataField = js.executeScript("return document.evaluate('" + CH_SEX + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childSex = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_LASTNAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childLastName = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_FNAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childFirstName = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_MNAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childMiddleName = dataField;

        dataField = js.executeScript("return document.evaluate('" + CH_BORN_DD_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.childDdBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_BORN_MM_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.childMmBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_BORN_YYYY_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.childYyyyBorn = dataField;

        dataField = js.executeScript("return document.evaluate('" + CH_COUNTRY_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childCountryNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_REGION_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childRegionNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_COUNTRY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childCountry = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_REGION + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childRegion = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_DISTRICT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childDisnrict = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_PUNKT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childPunkt = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_IS_A_LIFE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childBirthCond = dataField;

        //основание о восстановлении
        dataField = js.executeScript("return document.evaluate('" + VOSST_DD + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.vosstDd = dataField;
        dataField = js.executeScript("return document.evaluate('" + VOSST_MM + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.vosstMm = dataField;
        dataField = js.executeScript("return document.evaluate('" + VOSST_YYYY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.vosstYyyy = dataField;
        dataField = js.executeScript("return document.evaluate('" + VOSST_ORG + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.vosstOrg = dataField;

        //данные об отце
        dataField = js.executeScript("return document.evaluate('" + FATHER_LAST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherLastName = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_FIRST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherFirstName = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_MIDDLE_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherMiddleName = dataField;

        dataField = js.executeScript("return document.evaluate('" + FATHER_DD_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.fatherDdBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_MM_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.fatherMmBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_YYYY_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.fatherYyyyBorn = dataField;

        dataField = js.executeScript("return document.evaluate('" + FATHER_COUNTRY_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCountryNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_REGION_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherRegionNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_COUNTRY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCountry = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_REGION + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherRegion = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_DISNRICT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherDistrict = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_PUNKT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherPunkt = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_CITIZENSHIP_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCitizenshipNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_CITIZENSHIP + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCitizenship = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_NATIONAL_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherNationalNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_NATIONAL + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherNational = dataField;

        //данные о матери
        dataField = js.executeScript("return document.evaluate('" + MATHER_LAST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherLastName = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_FIRST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherFirstName = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_MIDDLE_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherMiddleName = dataField;

        dataField = js.executeScript("return document.evaluate('" + MATHER_DD_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.matherDdBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_MM_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.matherMmBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_YYYY_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.matherYyyyBorn = dataField;

        dataField = js.executeScript("return document.evaluate('" + MATHER_COUNTRY_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCountryNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_REGION_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherRegionNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_COUNTRY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCountry = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_REGION + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherRegion = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_DISNRICT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherDistrict = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_PUNKT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherPunkt = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_CITIZENSHIP_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCitizenshipNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_CITIZENSHIP + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCitizenship = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_NATIONAL_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherNationalNoClass = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_NATIONAL + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherNational = dataField;


        //основание данных об отце
        dataField = js.executeScript("return document.evaluate('" + BASE_TYPE_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.baseTypeDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.baseNumDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_DD_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.baseDdDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_MM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.baseMmDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_YYYY_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.baseYyyyDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_ORG_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.baseOrgDoc = dataField;

        //выданное свидетельство
        dataField = js.executeScript("return document.evaluate('" + CERT_SERIA + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.certSeria = dataField;
        dataField = js.executeScript("return document.evaluate('" + CERT_NUM + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.certNum = dataField;
        dataField = js.executeScript("return document.evaluate('" + CERT_DD + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.certDd = dataField;
        dataField = js.executeScript("return document.evaluate('" + CERT_MM + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.certMm = dataField;
        dataField = js.executeScript("return document.evaluate('" + CERT_YYYY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDataFields(dataField);
        ags.certYyyy = dataField;

        //признак наличия изменений
        dataField = js.executeScript("return document.evaluate('" + MORE_STAFE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.moreStage = dataField;


        //вывод на консоль для отладки
        System.out.println(ags.agsNum);
        System.out.println(ags.liter);
        System.out.println(ags.agsDd);
        System.out.println(ags.agsmm);
        System.out.println(ags.agsYyyy);
        System.out.println(ags.zagsAgsName);
        System.out.println(ags.agsCopy);

        System.out.println(ags.childSex);
        System.out.println(ags.childLastName);
        System.out.println(ags.childFirstName);
        System.out.println(ags.childMiddleName);
        System.out.println(ags.childDdBorn);
        System.out.println(ags.childMmBorn);
        System.out.println(ags.childYyyyBorn);
        System.out.println(ags.childCountryNoClass);
        System.out.println(ags.childRegionNoClass);
        System.out.println(ags.childCountry);
        System.out.println(ags.childRegion);
        System.out.println(ags.childDisnrict);
        System.out.println(ags.childPunkt);
        System.out.println(ags.childBirthCond);

        System.out.println(ags.vosstDd);
        System.out.println(ags.vosstMm);
        System.out.println(ags.vosstYyyy);
        System.out.println(ags.vosstOrg);

        System.out.println(ags.fatherLastName);
        System.out.println(ags.fatherFirstName);
        System.out.println(ags.fatherMiddleName);
        System.out.println(ags.fatherDdBorn);
        System.out.println(ags.fatherMmBorn);
        System.out.println(ags.fatherYyyyBorn);
        System.out.println(ags.fatherCountryNoClass);
        System.out.println(ags.fatherRegionNoClass);
        System.out.println(ags.fatherCountry);
        System.out.println(ags.fatherRegion);
        System.out.println(ags.fatherDistrict);
        System.out.println(ags.fatherPunkt);
        System.out.println(ags.fatherCitizenshipNoClass);
        System.out.println(ags.fatherCitizenship);
        System.out.println(ags.fatherNationalNoClass);
        System.out.println(ags.fatherNational);

        System.out.println(ags.matherLastName);
        System.out.println(ags.matherFirstName);
        System.out.println(ags.matherMiddleName);
        System.out.println(ags.matherDdBorn);
        System.out.println(ags.matherMmBorn);
        System.out.println(ags.matherYyyyBorn);
        System.out.println(ags.matherCountryNoClass);
        System.out.println(ags.matherRegionNoClass);
        System.out.println(ags.matherCountry);
        System.out.println(ags.matherRegion);
        System.out.println(ags.matherDistrict);
        System.out.println(ags.matherPunkt);
        System.out.println(ags.matherCitizenshipNoClass);
        System.out.println(ags.matherCitizenship);
        System.out.println(ags.matherNationalNoClass);
        System.out.println(ags.matherNational);

        System.out.println(ags.baseTypeDoc);
        System.out.println(ags.baseNumDoc);
        System.out.println(ags.baseDdDoc);
        System.out.println(ags.baseMmDoc);
        System.out.println(ags.baseYyyyDoc);
        System.out.println(ags.baseOrgDoc);

        System.out.println(ags.certSeria);
        System.out.println(ags.certNum);
        System.out.println(ags.certDd);
        System.out.println(ags.certMm);
        System.out.println(ags.certYyyy);

        System.out.println(ags.moreStage);

        return ags;
    }

    public String checkDataFields(String dataField){

        if (dataField.equals("ДД") || dataField.equals("ММ") || dataField.equals("ГГГГ")){dataField = "";}
        return dataField;
    }




}
