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
        type(By.xpath(MORE_HISTORY_BORN), status);
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

    //получение реквизитов 1 документа книги (группы документов) с макс. номером (последней загруженной) из БД
    public MarriageDataMainFields getMainFieldFromPvvDb() throws SQLException {
        String value;
        String sqlFieldsRequest="";
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

        ags.agsNum = reqValue.get(0);
        ags.agsNum = reqValue.get(0);
        ags.liter = reqValue.get(0);
        ags.agsDd = reqValue.get(0);
        ags.agsMm = reqValue.get(0);
        ags.agsYyyy = reqValue.get(0);
        ags.agsDate = reqValue.get(0);
        ags.zagsAgsName = reqValue.get(0);
        ags.agsCopy = reqValue.get(0);

        //поля сведения ОН (1-1)
        ags.hiLastNameBefore = reqValue.get(0);
        ags.hiLastNameAfter = reqValue.get(0);
        ags.hiFirstName = reqValue.get(0);
        ags.hiMiddleName = reqValue.get(0);
        ags.hiDdBorn = reqValue.get(0);
        ags.hiMmBorn = reqValue.get(0);
        ags.hiYyyyBorn = reqValue.get(0);
        ags.hiDateBorn = reqValue.get(0);
        ags.hiAge = reqValue.get(0);
        ags.hiCountryNoClass = reqValue.get(0);
        ags.hiRegionNoClass = reqValue.get(0);
        ags.hiCountry = reqValue.get(0);
        ags.hiRegion = reqValue.get(0);
        ags.hiDistrict = reqValue.get(0);
        ags.hiTown = reqValue.get(0);
        ags.hiPunkt = reqValue.get(0);
        ags.hiCitizenshipNoClass = reqValue.get(0);
        ags.hiCitizenship = reqValue.get(0);
        ags.hiNationalNoClass = reqValue.get(0);
        ags.hiNational = reqValue.get(0);
        ags.hiDivorceDoc = reqValue.get(0);
        ags.hiDivorceDocNum = reqValue.get(0);
        ags.hiDivorceDocDd = reqValue.get(0);
        ags.hiDivorceDocMm = reqValue.get(0);
        ags.hiDivorceDocYyyy = reqValue.get(0);
        ags.hiDivorceDocDate = reqValue.get(0);
        ags.hiDivorceDocOrg = reqValue.get(0);
        ags.hiDoc = reqValue.get(0);
        ags.hiDocSer = reqValue.get(0);
        ags.hiDocNum = reqValue.get(0);
        ags.hiDocDd = reqValue.get(0);
        ags.hiDocMm = reqValue.get(0);
        ags.hiDocYyyy = reqValue.get(0);
        ags.hiDocDate = reqValue.get(0);
        ags.hiDocOrg = reqValue.get(0);

        //сведения о матери (11-17)
        ags.sheLastNameBefore = reqValue.get(0);
        ags.sheLastNameAfter = reqValue.get(0);
        ags.sheFirstName = reqValue.get(0);
        ags.sheMiddleName = reqValue.get(0);
        ags.sheDdBorn = reqValue.get(0);
        ags.sheMmBorn = reqValue.get(0);
        ags.sheYyyyBorn = reqValue.get(0);
        ags.sheDateBorn = reqValue.get(0);
        ags.sheAge = reqValue.get(0);
        ags.sheCountryNoClass = reqValue.get(0);
        ags.sheRegionNoClass = reqValue.get(0);
        ags.sheCountry = reqValue.get(0);
        ags.sheRegion = reqValue.get(0);
        ags.sheDistrict = reqValue.get(0);
        ags.sheTown = reqValue.get(0);
        ags.shePunkt = reqValue.get(0);
        ags.sheCitizensshipNoClass = reqValue.get(0);
        ags.sheCitizensship = reqValue.get(0);
        ags.sheNationalNoClass = reqValue.get(0);
        ags.sheNational = reqValue.get(0);
        ags.sheDivorceDoc = reqValue.get(0);
        ags.sheDivorceDocNum = reqValue.get(0);
        ags.sheDivorceDocDd = reqValue.get(0);
        ags.sheDivorceDocMm = reqValue.get(0);
        ags.sheDivorceDocYyyy = reqValue.get(0);
        ags.sheDivorceDocDate = reqValue.get(0);
        ags.sheDivorceDocOrg = reqValue.get(0);
        ags.sheDoc = reqValue.get(0);
        ags.sheDocSer = reqValue.get(0);
        ags.sheDocNum = reqValue.get(0);
        ags.sheDocDd = reqValue.get(0);
        ags.sheDocMm = reqValue.get(0);
        ags.sheDocYyyy = reqValue.get(0);
        ags.sheDocDate = reqValue.get(0);
        ags.sheDocOrg = reqValue.get(0);

        //есть Изменения?
        ags.moreStage = reqValue.get(0);
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
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiLastNameBefore =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiLastNameAfter =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiFirstName =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiMiddleName =  checkFields(dataField);

        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDdBorn =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiMmBorn =  checkDateFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiYyyyBorn =  checkDateFields(dataField);
        ags.hiDateBorn =  ags.hiDdBorn + "/" + ags.hiMmBorn + "/" + ags.hiYyyyBorn;

        
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiAge =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCountryNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiRegionNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCountry =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiRegion =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDistrict =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiTown =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiPunkt =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCitizenshipNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiCitizenship =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiNationalNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiNational =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocNum =  checkFields(dataField);

        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocDd =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocMm =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocYyyy =  checkDateFields(dataField);
        ags.hiDivorceDocDate =  ags.hiDivorceDocDd + "/" + ags.hiDivorceDocMm + "/" + ags.hiDivorceDocYyyy;
        
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDivorceDocOrg =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocSer =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocNum =  checkFields(dataField);

        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocDd =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocMm =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocYyyy =  checkDateFields(dataField);
        ags.hiDocDate =  ags.hiDocDd + "/" + ags.hiDocMm + "/" + ags.hiDocYyyy;

        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.hiDocOrg =  checkFields(dataField);

        //сведения о матери (dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();-dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();7)
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheLastNameBefore =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheLastNameAfter =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheFirstName =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheMiddleName =  checkFields(dataField);

        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDdBorn =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheMmBorn =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheYyyyBorn =  checkDateFields(dataField);
        ags.sheDateBorn =  ags.sheDdBorn + "/" + ags.sheMmBorn + "/" + ags.sheYyyyBorn;
        
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheAge =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCountryNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheRegionNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCountry =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheRegion =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDistrict =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheTown =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.shePunkt =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCitizensshipNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheCitizensship =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheNationalNoClass =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheNational =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocNum =  checkFields(dataField);

        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocDd =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocMm =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocYyyy =  checkDateFields(dataField);
        ags.sheDivorceDocDate =  ags.sheDivorceDocDd + "/" + ags.sheDivorceDocMm + "/" + ags.sheDivorceDocYyyy;
        
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDivorceDocOrg =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDoc =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocSer =  checkFields(dataField);
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocNum =  checkFields(dataField);

        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocDd =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocMm =  checkDateFields(dataField);
        js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocYyyy =  checkDateFields(dataField);
        ags.sheDocDate =  ags.sheDocDd + "/" + ags.sheDocMm + "/" + ags.sheDocYyyy;
        
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.sheDocOrg =  checkFields(dataField);

        //есть Изменения?
        dataField = js.executeScript("return document.evaluate('" + 00000 + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        ags.moreStage =  checkFields(dataField);
        
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






}
