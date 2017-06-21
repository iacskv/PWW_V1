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


    BornDataMainFields ags = new BornDataMainFields();


    public void gotoMainPage() {
        click(By.xpath(MAIN_SPAN));
    }


    public void gotoInputForm() throws InterruptedException {

        click(By.xpath(PVV_SPAN));
        click(By.xpath(INPUT_BTN));

    }

        public void fillFormFiltersStage(String typeAgs, String stage) {
        click(By.xpath(TYPE_DOC)); //клик по фильтру "Тип"
        click(By.xpath("//div[text()='" + typeAgs + "']")); //выбор "Книга 2000-2003"
        click(By.xpath(STAGE)); //клик по фильтру "Этап"
        click(By.xpath("//div[text()='" + stage+ "']")); //клик по "2"

    }

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
       public BornDataMainFields getMainFieldFromPvvDb() throws SQLException {
        String value;
        String sqlFieldsRequest = "WITH document_values\n" +
                "     AS (    SELECT doc_stage_prop_id property_id,\n" +
                "                    req_id,\n" +
                "                    VALUE,\n" +
                "                    LEVEL property_level,\n" +
                "                    ROWNUM property_order,\n" +
                "                    prop_order multiplicity\n" +
                "               FROM document_stage_property\n" +
                "         START WITH     parent_id IS NULL\n" +
                "                    AND doc_stage_id =\n" +
                "                           (SELECT MIN (doc_stage_id)\n" +
                "                              FROM document_stage\n" +
                "                             WHERE doc_id IN\n" +
                "                                      (SELECT MIN (doc_id)\n" +
                "                                         FROM document\n" +
                "                                        WHERE doc_grp_id IN\n" +
                "                                                 (SELECT MAX (doc_grp_id)\n" +
                "                                                    FROM document_group where doc_grp_phase = 'input')))\n" +
                "         CONNECT BY PRIOR doc_stage_prop_id = parent_id)\n" +
                "  SELECT property_order,\n" +
                "         LPAD (' ', (property_level - 1) * 6, ' ') || req_name property_name,\n" +
                "         VALUE,\n" +
                "         multiplicity,\n" +
                "         document_values.req_id,\n" +
                "         req_code property_code,\n" +
                "         property_id\n" +
                "    FROM document_values, document_type_requisite\n" +
                "   WHERE document_values.req_id = document_type_requisite.req_id\n" +
                "ORDER BY property_order";
        List<String> reqValue = new ArrayList<>();
        PreparedStatement statement = getPvvDb().prepareStatement(sqlFieldsRequest);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            value = resultSet.getString("VALUE");
            if ((value == null) || value.equals("")) {
                value = "//";
            }
            if (value.equals("[empty_string]")) {
                value = "//";
            }
            reqValue.add(value);
        }

        resultSet.close();

        ags.agsNum = reqValue.get(2);
        ags.liter = reqValue.get(3);
        ags.agsDate = reqValue.get(4);
        ags.zagsAgsName = reqValue.get(5);
        ags.agsCopy = reqValue.get(6);

        ags.childSex = reqValue.get(8);
        ags.childLastName = reqValue.get(9);
        ags.childFirstName = reqValue.get(10);
        ags.childMiddleName = reqValue.get(11);
        ags.childDateBorn = reqValue.get(12);
        ags.childCountryNoClass = reqValue.get(13);
        ags.childRegionNoClass = reqValue.get(14);

        ags.childCountry = reqValue.get(15);
        ags.childRegion = reqValue.get(16);
        ags.childDisnrict = reqValue.get(17);
        ags.childTown = reqValue.get(18);
        ags.childPunkt = reqValue.get(19);
        ags.childBirthCond = reqValue.get(20);

        ags.vosstDate = reqValue.get(22);
        ags.vosstOrg = reqValue.get(24);

        ags.fatherLastName = reqValue.get(25);
        ags.fatherFirstName = reqValue.get(26);
        ags.fatherMiddleName = reqValue.get(27);
        ags.fatherDateBorn = reqValue.get(28);
        ags.fatherCountryNoClass = reqValue.get(29);
        ags.fatherRegionNoClass = reqValue.get(30);
        ags.fatherCountry = reqValue.get(31);
        ags.fatherRegion = reqValue.get(32);
        ags.fatherDistrict = reqValue.get(33);
        ags.fatherTown = reqValue.get(34);
        ags.fatherPunkt = reqValue.get(35);
        ags.fatherCitizenshipNoClass = reqValue.get(36);
        ags.fatherCitizenship = reqValue.get(37);
        ags.fatherNationalNoClass = reqValue.get(38);
        ags.fatherNational = reqValue.get(39);

        ags.matherLastName = reqValue.get(41);
        ags.matherFirstName = reqValue.get(42);
        ags.matherMiddleName = reqValue.get(43);
        ags.matherDateBorn = reqValue.get(44);
        ags.matherCountryNoClass = reqValue.get(45);
        ags.matherRegionNoClass = reqValue.get(46);
        ags.matherCountry = reqValue.get(47);
        ags.matherRegion = reqValue.get(48);
        ags.matherDistrict = reqValue.get(49);
        ags.matherTown = reqValue.get(50);
        ags.matherPunkt = reqValue.get(51);
        ags.matherCitizenshipNoClass = reqValue.get(52);
        ags.matherCitizenship = reqValue.get(53);
        ags.matherNationalNoClass = reqValue.get(54);
        ags.matherNational = reqValue.get(55);

        ags.baseTypeDoc = reqValue.get(57);
        ags.baseNumDoc = reqValue.get(58);
        ags.baseDateDoc = reqValue.get(59);
        ags.baseOrgDoc = reqValue.get(60);

        ags.certSeria = reqValue.get(62);
        ags.certNum = reqValue.get(63);
        ags.certDate = reqValue.get(64);

        return ags;
    }

    //получение значений полей из формы ввода документа
    public BornDataMainFields getMainFieldFromPvv() {

        BornDataMainFields ags = new BornDataMainFields();
        String dataField = "";

        JavascriptExecutor js = (JavascriptExecutor) wd;
        //данные о а/з
        dataField = js.executeScript("return document.evaluate('" + NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsNum = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + LITER + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.liter = checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + CH_DD_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.agsDd = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_MM_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.agsMm = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_YYYY_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.agsYyyy = dataField;
        ags.agsDate = ags.agsDd + "/" + ags.agsMm + "/" + ags.agsYyyy;

        dataField = js.executeScript("return document.evaluate('" + NAME_ZAGS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.zagsAgsName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + NUM_COPY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsCopy = checkFields(dataField);

        //данные о ребенке
        dataField = js.executeScript("return document.evaluate('" + CH_SEX + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childSex = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_LASTNAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childLastName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_FNAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childFirstName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_MNAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childMiddleName = checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + CH_BORN_DD_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.childDdBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_BORN_MM_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.childMmBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + CH_BORN_YYYY_ACT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.childYyyyBorn = dataField;
        ags.childDateBorn = ags.childDdBorn + "/" + ags.childMmBorn + "/" + ags.childYyyyBorn;

        dataField = js.executeScript("return document.evaluate('" + CH_COUNTRY_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childCountryNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_REGION_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childRegionNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_COUNTRY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childCountry = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_REGION + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childRegion = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_DISTRICT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childDisnrict = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_TOWN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childTown = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_PUNKT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childPunkt = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CH_IS_A_LIFE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.childBirthCond = checkFields(dataField);

        //основание о восстановлении
        dataField = js.executeScript("return document.evaluate('" + VOSST_DD + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.vosstDd = dataField;
        dataField = js.executeScript("return document.evaluate('" + VOSST_MM + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.vosstMm = dataField;
        dataField = js.executeScript("return document.evaluate('" + VOSST_YYYY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.vosstYyyy = dataField;
        ags.vosstDate = ags.vosstDd + "/" + ags.vosstMm + "/" + ags.vosstYyyy;
        dataField = js.executeScript("return document.evaluate('" + VOSST_ORG + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.vosstOrg = checkFields(dataField);

        //данные об отце
        dataField = js.executeScript("return document.evaluate('" + FATHER_LAST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherLastName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_FIRST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherFirstName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_MIDDLE_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherMiddleName = checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + FATHER_DD_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.fatherDdBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_MM_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.fatherMmBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + FATHER_YYYY_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.fatherYyyyBorn = dataField;
        ags.fatherDateBorn = ags.fatherDdBorn + "/" + ags.fatherMmBorn + "/" + ags.fatherYyyyBorn;

        dataField = js.executeScript("return document.evaluate('" + FATHER_COUNTRY_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCountryNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_REGION_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherRegionNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_COUNTRY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCountry = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_REGION + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherRegion = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_DISNRICT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherDistrict = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_TOWN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherTown = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_PUNKT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherPunkt = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_CITIZENSHIP_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCitizenshipNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_CITIZENSHIP + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherCitizenship = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_NATIONAL_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherNationalNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + FATHER_NATIONAL + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.fatherNational = checkFields(dataField);

        //данные о матери
        dataField = js.executeScript("return document.evaluate('" + MATHER_LAST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherLastName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_FIRST_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherFirstName = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_MIDDLE_NAME + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherMiddleName = checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + MATHER_DD_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.matherDdBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_MM_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.matherMmBorn = dataField;
        dataField = js.executeScript("return document.evaluate('" + MATHER_YYYY_BORN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.matherYyyyBorn = dataField;
        ags.matherDateBorn = ags.matherDdBorn + "/" + ags.matherMmBorn + "/" + ags.matherYyyyBorn;

        dataField = js.executeScript("return document.evaluate('" + MATHER_COUNTRY_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCountryNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_REGION_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherRegionNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_COUNTRY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCountry = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_REGION + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherRegion = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_DISNRICT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherDistrict = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_TOWN + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherTown = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_PUNKT + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherPunkt = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_CITIZENSHIP_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCitizenshipNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_CITIZENSHIP + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherCitizenship = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_NATIONAL_NO_CLASS + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherNationalNoClass = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MATHER_NATIONAL + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.matherNational = checkFields(dataField);


        //основание данных об отце
        dataField = js.executeScript("return document.evaluate('" + BASE_TYPE_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.baseTypeDoc = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + BASE_NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.baseNumDoc = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + BASE_DD_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.baseDdDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_MM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.baseMmDoc = dataField;
        dataField = js.executeScript("return document.evaluate('" + BASE_YYYY_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.baseYyyyDoc = dataField;
        ags.baseDateDoc = ags.baseDdDoc + "/" + ags.baseMmDoc + "/" + ags.baseYyyyDoc;

        dataField = js.executeScript("return document.evaluate('" + BASE_ORG_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.baseOrgDoc = dataField;

        //выданное свидетельство
        dataField = js.executeScript("return document.evaluate('" + CERT_SERIA + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.certSeria = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CERT_NUM + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.certNum = checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + CERT_DD + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.certDd = dataField;
        dataField = js.executeScript("return document.evaluate('" + CERT_MM + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.certMm = dataField;
        dataField = js.executeScript("return document.evaluate('" + CERT_YYYY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        dataField = checkDateFields(dataField);
        ags.certYyyy = dataField;
        ags.certDate = ags.certDd + "/" + ags.certMm + "/" + ags.certYyyy;

        //признак наличия изменений
        dataField = js.executeScript("return document.evaluate('" + MORE_HISTORY + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.moreStage = dataField;


        //вывод на консоль для отладки
        /*System.out.println(ags.agsNum);
        System.out.println(ags.liter);
        System.out.println(ags.agsDd);
        System.out.println(ags.agsMm);
        System.out.println(ags.agsYyyy);
        System.out.println(ags.agsDate);
        System.out.println(ags.zagsAgsName);
        System.out.println(ags.agsCopy);

        System.out.println(ags.childSex);
        System.out.println(ags.childLastName);
        System.out.println(ags.childFirstName);
        System.out.println(ags.childMiddleName);
        System.out.println(ags.childDdBorn);
        System.out.println(ags.childMmBorn);
        System.out.println(ags.childYyyyBorn);
        System.out.println(ags.childDateBorn);
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
        System.out.println(ags.vosstDate);
        System.out.println(ags.vosstOrg);

        System.out.println(ags.fatherLastName);
        System.out.println(ags.fatherFirstName);
        System.out.println(ags.fatherMiddleName);
        System.out.println(ags.fatherDdBorn);
        System.out.println(ags.fatherMmBorn);
        System.out.println(ags.fatherYyyyBorn);
        System.out.println(ags.fatherDateBorn);
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
        System.out.println(ags.matherDateBorn);
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
        System.out.println(ags.baseDateDoc);
        System.out.println(ags.baseOrgDoc);

        System.out.println(ags.certSeria);
        System.out.println(ags.certNum);
        System.out.println(ags.certDd);
        System.out.println(ags.certMm);
        System.out.println(ags.certYyyy);
        System.out.println(ags.certDate);

        System.out.println(ags.moreStage);
*/
        return ags;
    }

    public String checkDateFields(String dataField) {

        if (dataField.equals("ДД") || dataField.equals("ММ") || dataField.equals("ГГГГ")) {
            dataField = "";
        }
        return dataField;
    }

    public String checkFields(String dataField) {

        if (dataField.length() == 1 ) {
            return "//";
        }

        return dataField;
    }

    public String getNumAgsFromAxeLocator(){
        String value;
        value = wd.findElement(By.xpath("//label[contains(text(),'Литера:')]/following-sibling::*//input")).getText();

        return value;
    }

    //выбор в поле "Актовая запись с изменениями?"
    public void changesFieldSetup (String status){
        type(By.xpath(MORE_HISTORY), status);
    }

    //сохранение документа
    public void submitSaveDoc(){
        click(By.xpath(SAVE_BTN));
    }

    //завершение ввода
    public void submitEndInputGroup(){
        click(By.xpath(END_INPUT_BOOK_BTN));
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
