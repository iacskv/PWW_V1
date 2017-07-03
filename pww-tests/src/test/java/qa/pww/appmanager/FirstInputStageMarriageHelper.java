package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import qa.pww.models.BornDataMainFields;
import qa.pww.models.MarriageDataMainFields;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static qa.pww.Locators.FirstInputStageBornFormLocators.*;
import static qa.pww.Locators.FirstInputStageMarriageFormLocators.*;


/**
 * Created by k.smotrov on 28.06.2017.
 */
public class FirstInputStageMarriageHelper extends HelperBase{

    public FirstInputStageMarriageHelper(WebDriver wd, Connection pvvDb, Connection zagsDb) {
        super(wd, pvvDb, zagsDb);
    }


    MarriageDataMainFields ags = new MarriageDataMainFields();
    JavascriptExecutor js = (JavascriptExecutor) wd;


    //выход из формы ввода документа (1/2 этап)
    public void backFromInputStageForm() {
        click(By.xpath(BACK_FROM_INPUT_FORM_BTN_BORN));
    }

    //выбор в поле "Актовая запись с изменениями?" (Рождение)
    public void changesFieldBornSetup(String status){
        type(By.xpath(MORE_HISTORY_MARRIAGE), status);
    }

    //сохранение документа (Рождение)
    public void submitSaveBornDoc(){
        click(By.xpath(SAVE_BORN_BTN_BORN));
    }

    //завершение ввода
    public void submitEndInputGroup(){
        click(By.xpath(END_INPUT_BOOK_BTN_BORN));
    }


    //получение номера а/з из формы ввода
    public String textNumDoc() {
        String a = "";
        a = js.executeScript("return document.evaluate('" + NUM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        return a;
    }

    //получение реквизитов 1-11 документа книги (группы документов) с макс. номером (последней загруженной) из БД
    public MarriageDataMainFields getMainFieldFromPvvDb() throws SQLException {
        String value;
        String sqlFieldsRequest="WITH document_values AS (\n" +
                "    SELECT\n" +
                "        doc_stage_prop_id property_id,\n" +
                "        req_id,\n" +
                "        value,\n" +
                "        level property_level,\n" +
                "        ROWNUM property_order,\n" +
                "        prop_order multiplicity\n" +
                "    FROM\n" +
                "        document_stage_property\n" +
                "    START WITH\n" +
                "        parent_id IS NULL\n" +
                "    AND\n" +
                "        doc_stage_id = (\n" +
                "            SELECT MIN(doc_stage_id)\n" +
                "            FROM document_stage\n" +
                "            WHERE doc_id IN (\n" +
                "                    SELECT MIN(doc_id)\n" +
                "                    FROM document d join document_type dt on d.doc_type_id = dt.doc_type_id and dt.type_code = 'marriageAct'\n" +
                "                    WHERE doc_grp_id IN ( SELECT MAX(doc_grp_id) FROM document_group)))\n" +
                "    CONNECT BY\n" +
                "        PRIOR doc_stage_prop_id = parent_id\n" +
                ") SELECT\n" +
                "    property_order,\n" +
                "    lpad(\n" +
                "        ' ',\n" +
                "        (property_level - 1) * 6,\n" +
                "        ' '\n" +
                "    )\n" +
                "     || req_name property_name,\n" +
                "    value,\n" +
                "    multiplicity,\n" +
                "    document_values.req_id,\n" +
                "    req_code property_code,\n" +
                "    property_id\n" +
                "FROM\n" +
                "    document_values,\n" +
                "    document_type_requisite\n" +
                "WHERE\n" +
                "    document_values.req_id = document_type_requisite.req_id\n" +
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

        //ЖЕНИХ (1-11)
        ags.hiLastNameBefore = reqValue.get(8);
        ags.hiLastNameAfter = reqValue.get(9);
        ags.hiFirstName = reqValue.get(10);
        ags.hiMiddleName = reqValue.get(11);
        ags.hiDateBorn = reqValue.get(12);
        ags.hiAge = reqValue.get(13);
        ags.hiCountryNoClass = reqValue.get(14);
        ags.hiRegionNoClass = reqValue.get(15);
        ags.hiCountry = reqValue.get(16);
        ags.hiRegion = reqValue.get(17);
        ags.hiDistrict = reqValue.get(18);
        ags.hiTown = reqValue.get(19);
        ags.hiPunkt = reqValue.get(20);
        ags.hiCitizenshipNoClass = reqValue.get(21);
        ags.hiCitizenship = reqValue.get(22);
        ags.hiNationalNoClass = reqValue.get(23);
        ags.hiNational = reqValue.get(24);
        ags.hiDivorceDoc = reqValue.get(25);
        ags.hiDivorceDocNum = reqValue.get(26);
        ags.hiDivorceDocDate = reqValue.get(27);
        ags.hiDivorceDocOrg = reqValue.get(28);
        ags.hiDoc = reqValue.get(29);
        ags.hiDocSer = reqValue.get(30);
        ags.hiDocNum = reqValue.get(31);
        ags.hiDocDate = reqValue.get(32);
        ags.hiDocOrg = reqValue.get(33);

        //НЕВЕСТА (1-11)
        ags.sheLastNameBefore = reqValue.get(35);
        ags.sheLastNameAfter = reqValue.get(36);
        ags.sheFirstName = reqValue.get(37);
        ags.sheMiddleName = reqValue.get(38);
        ags.sheDateBorn = reqValue.get(39);
        ags.sheAge = reqValue.get(40);
        ags.sheCountryNoClass = reqValue.get(41);
        ags.sheRegionNoClass = reqValue.get(42);
        ags.sheCountry = reqValue.get(43);
        ags.sheRegion = reqValue.get(44);
        ags.sheDistrict = reqValue.get(45);
        ags.sheTown = reqValue.get(46);
        ags.shePunkt = reqValue.get(47);
        ags.sheCitizensshipNoClass = reqValue.get(48);
        ags.sheCitizensship = reqValue.get(49);
        ags.sheNationalNoClass = reqValue.get(50);
        ags.sheNational = reqValue.get(51);
        ags.sheDivorceDoc = reqValue.get(52);
        ags.sheDivorceDocNum = reqValue.get(53);
        ags.sheDivorceDocDate = reqValue.get(54);
        ags.sheDivorceDocOrg = reqValue.get(55);
        ags.sheDoc = reqValue.get(56);
        ags.sheDocSer = reqValue.get(57);
        ags.sheDocNum = reqValue.get(58);
        ags.sheDocDate = reqValue.get(59);
        ags.sheDocOrg = reqValue.get(60);

        return ags;
    }

    //получение значений полей из формы ввода документа
    public MarriageDataMainFields getMainFieldFromPvv() {

        MarriageDataMainFields ags = new MarriageDataMainFields();
        String dataField = "";

        JavascriptExecutor js = (JavascriptExecutor) wd;
        //данные о а/з

        dataField = js.executeScript("return document.evaluate('" + NUM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsNum =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + LITER_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.liter =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + NAME_ZAGS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.zagsAgsName =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + NUM_COPY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsCopy =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + DD_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsDd =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + MM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsMm =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + YYYY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.agsYyyy =  checkDateFields(dataField);
        ags.agsDate =  ags.agsDd + "/" + ags.agsMm + "/" + ags.agsYyyy;


        //поля сведения ОН (
        dataField = js.executeScript("return document.evaluate('" + HI_LASTNAME_BEFORE_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiLastNameBefore =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_LASTNAME_AFTER_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiLastNameAfter =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_FNAME_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiFirstName =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_MNAME_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiMiddleName =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + HI_DD_BORN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDdBorn =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_MM_BORN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiMmBorn =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_YYYY_BORN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiYyyyBorn =  checkDateFields(dataField);
        ags.hiDateBorn =  ags.hiDdBorn + "/" + ags.hiMmBorn + "/" + ags.hiYyyyBorn;

        
        dataField = js.executeScript("return document.evaluate('" + HI_AGE_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiAge =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_COUNTRY_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCountryNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_REGION_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiRegionNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_COUNTRY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCountry =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_REGION_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiRegion =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DISTRICT_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDistrict =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_TOWN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiTown =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_PUNKT_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiPunkt =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_CITIZENSHIP_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCitizenshipNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_CITIZENSHIP_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCitizenship =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_NATIONAL_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiNationalNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_NATIONAL_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiNational =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DIV_DOC_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DIV_NUM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocNum =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + HI_DIV_DD_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocDd =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DIV_MM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocMm =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DIV_YYYY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocYyyy =  checkDateFields(dataField);
        ags.hiDivorceDocDate =  ags.hiDivorceDocDd + "/" + ags.hiDivorceDocMm + "/" + ags.hiDivorceDocYyyy;
        
        dataField = js.executeScript("return document.evaluate('" + HI_DIV_ORG_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocOrg =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DOC_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DOC_SER_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocSer =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" +  HI_DOC_NUM_MARRIAGE+ "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocNum =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + HI_DOC_DD_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocDd =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DOC_MM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocMm =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + HI_DOC_YYYY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocYyyy =  checkDateFields(dataField);
        ags.hiDocDate =  ags.hiDocDd + "/" + ags.hiDocMm + "/" + ags.hiDocYyyy;

        dataField = js.executeScript("return document.evaluate('" + HI_DOC_ORG_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocOrg =  checkFields(dataField);

        //сведения о невесте
        dataField = js.executeScript("return document.evaluate('" + SHE_LASTNAME_BEFORE_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheLastNameBefore =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_LASTNAME_AFTER_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheLastNameAfter =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_FNAME_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheFirstName =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_MNAME_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheMiddleName =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + SHE_DD_BORN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDdBorn =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_MM_BORN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheMmBorn =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_YYYY_BORN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheYyyyBorn =  checkDateFields(dataField);
        ags.sheDateBorn =  ags.sheDdBorn + "/" + ags.sheMmBorn + "/" + ags.sheYyyyBorn;
        
        dataField = js.executeScript("return document.evaluate('" + SHE_AGE_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheAge =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_COUNTRY_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCountryNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_REGION_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheRegionNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_COUNTRY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCountry =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_REGION_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheRegion =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DISTRICT_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDistrict =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_TOWN_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheTown =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_PUNKT_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.shePunkt =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_CITIZENSHIP_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCitizensshipNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_CITIZENSHIP_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCitizensship =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_NATIONAL_NO_CLASS_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheNationalNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_NATIONAL_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheNational =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DIV_DOC_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DIV_NUM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocNum =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + SHE_DIV_DD_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocDd =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DIV_MM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocMm =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DIV_YYYY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocYyyy =  checkDateFields(dataField);
        ags.sheDivorceDocDate =  ags.sheDivorceDocDd + "/" + ags.sheDivorceDocMm + "/" + ags.sheDivorceDocYyyy;
        
        dataField = js.executeScript("return document.evaluate('" + SHE_DIV_ORG_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocOrg =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_SER_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocSer =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_NUM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocNum =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_DD_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocDd =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_MM_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocMm =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_YYYY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocYyyy =  checkDateFields(dataField);
        ags.sheDocDate =  ags.sheDocDd + "/" + ags.sheDocMm + "/" + ags.sheDocYyyy;
        
        dataField = js.executeScript("return document.evaluate('" + SHE_DOC_ORG_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocOrg =  checkFields(dataField);

        //есть Изменения?
        dataField = js.executeScript("return document.evaluate('" + MORE_HISTORY_MARRIAGE + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.moreStage =  checkFields(dataField);
        
        return ags;
    }

    public String checkDateFields(String dataField) {

        if (dataField.equals("ДД") || dataField.equals("ММ") || dataField.equals("ГГГГ")) {
            dataField = "";
        }
        //System.out.println(dataField);
        return dataField;
    }

    public String checkFields(String dataField) {

        if (dataField.length() == 1 ) {
            return "//";
        }

        return dataField;
    }

}
