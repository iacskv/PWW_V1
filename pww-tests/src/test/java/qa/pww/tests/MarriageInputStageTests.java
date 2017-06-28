package qa.pww.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.pww.models.BornDataMainFields;
import qa.pww.models.DocForLoad;
import qa.pww.models.MarriageDataMainFields;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 25.05.2017.
 */
public class MarriageInputStageTests extends TestBase {


    String typedoc = "Книга записей актов (2000-2003)";
    String typeags = "Запись акта о браке";
    String year = "2003";
    String typezags = "Кронштадтский (1997-2003)";
    String fNum = "171";
    String lNum = "171";
    DocForLoad docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

    @BeforeClass
    public void initLoadDataForm() throws InterruptedException {
        //загрузка АГС
        app.loadDataHelper().gotoLoadDataPage();
        app.loadDataHelper().fillLoadNewDocGroupFofm(docAttr);
        app.loadDataHelper().submitLoad();
        app.loadDataHelper().waitingLogText();
    }

    @AfterMethod
    public void ShutdownLoadDataForm() {
        //возврат на "главную"
        app.inputFormHelper().gotoMainPage();
    }

    @Test(enabled = true, priority = 1)
    //проверка максимального номера (последненго загруженного) группы документов в БД и UI на 1 этапе
    //проверка из UI будет глючить если не делать очистки БД
    public void checkNumNewBookOnFirstInputStage() throws InterruptedException, SQLException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "1");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //проверка совпадения номера последней загруженной книги по UI  и БД
        app.inputFormHelper().checkNumNewBook();
        System.out.println("проверка максимального номера (последненго загруженного) группы документов в БД и UI на 1 этапе = ok");
        System.out.println("--------------------------");
    }

    @Test(enabled = true, priority = 2)
    //проверка что загруженная книга отображается в таблице 1 этапа ввода с нужными статусами
    //проверка из UI будет глючить если не делать очистки БД
    public void checkPresentNewBookOnFirstInputStage() throws InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "1");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму просмотра группы
        app.inputFormHelper().gotoViewBookForm();
        //выбор агс
        app.inputFormHelper().selectAgsMarriage();
        //проверка на "Требует ввода"
        app.inputFormHelper().checkNeedInput();
        //проверка на "Введен"
        app.inputFormHelper().checkInputedTrue();
        //возврат к списку книг
        app.inputFormHelper().backFromReviewDocForm();
        System.out.println("проверка что загруженная книга отображается в таблице 1 этапа ввода с нужными статусами - ok");
        System.out.println("--------------------------");
    }

    @Test(enabled = true, priority = 3)
    //проверка максимального номера (последненго загруженного) группы документов в БД и UI на 2 этапе
    //проверка из UI будет глючить если не делать очистки БД
    public void checkNumNewBookOnSecondInputStage() throws SQLException, InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (2 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "2");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //проверка совпадения номера последней загруженной книги по UI  и БД
        app.inputFormHelper().checkNumNewBook();
        System.out.println("проверка максимального номера (последненго загруженного) группы документов в БД и UI на 2 этапе - ok");
        System.out.println("--------------------------");
    }


    @Test(enabled = true, priority = 4)
    //проверка что загруженная книга отображается в таблице 2 этапа ввода с нужными статусами
    //проверка из UI будет глючить если не делать очистки БД
    public void checkPresentNewBookOnSecondInputStage() throws InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (2 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersStage("Книга записей актов (2000-2003)", "2");
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму просмотра группы
        app.inputFormHelper().gotoViewBookForm();
        //выбор агс
        app.inputFormHelper().selectAgsMarriage();
        //проверка на "Требует ввода"
        app.inputFormHelper().checkNeedInput();
        //проверка на "Введен"
        app.inputFormHelper().checkInputedTrue();
        //возврат к списку книг
        app.inputFormHelper().backFromReviewDocForm();
        System.out.println("проверка что загруженная книга отображается в таблице 2 этапа ввода с нужными статусами - ok");
        System.out.println("--------------------------");
    }

    @Test(enabled = true, priority = 5)
    //проверка возможности открытия книги на заполнение в 1 этапе
    //проверка из UI будет глючить если не делать очистки БД
    public void fistInputStage() throws InterruptedException {
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
        //ожидание загрузки и получение текста № а/з
        Thread.sleep(5000);
        String a = "";
        a = app.firstInputStageMarriageHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageMarriageHelper().backFromInputStageForm();
        System.out.println("проверка возможности открытия книги на заполнение в 1 этапе - ok");
        System.out.println("--------------------------");
    }


    @Test (enabled = false, priority = 6)
    //проверка основных полей (1-21) (1 этап ввода) загруженных из  UI и БД ПВВ
    public void checkMainFieldOnFirstStage() throws InterruptedException, SQLException {
        MarriageDataMainFields agsPvvUi;
        MarriageDataMainFields agsPvvDb;

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
        //получение значений полей а/з с формы ввода документа
        agsPvvUi = app.firstInputStageMarriageHelper().getMainFieldFromPvv();
        //получение значений полей а/з из БД
        agsPvvDb = app.firstInputStageMarriageHelper().getMainFieldFromPvvDb();
        //сравнение полей из БД с UI
        assertThat(agsPvvUi.agsNum, equalTo(agsPvvDb.agsNum));
        assertThat(agsPvvUi.liter, equalTo(agsPvvDb.liter));
        assertThat(agsPvvUi.agsDate, equalTo(agsPvvDb.agsDate));
        assertThat(agsPvvUi.zagsAgsName, equalTo(agsPvvDb.zagsAgsName));
        assertThat(agsPvvUi.agsCopy, equalTo(agsPvvDb.agsCopy));
        System.out.println("реквизиты АГС - ок");
        assertThat(agsPvvUi.hiLastNameBefore, equalTo(agsPvvDb.hiLastNameBefore));
        assertThat(agsPvvUi.hiLastNameAfter, equalTo(agsPvvDb.hiLastNameBefore));
        assertThat(agsPvvUi.hiFirstName, equalTo(agsPvvDb.hiFirstName));
        assertThat(agsPvvUi.hiMiddleName, equalTo(agsPvvDb.hiMiddleName));
        assertThat(agsPvvUi.hiDateBorn, equalTo(agsPvvDb.hiDateBorn));
        assertThat(agsPvvUi.hiAge, equalTo(agsPvvDb.hiAge));
        assertThat(agsPvvUi.hiCountryNoClass, equalTo(agsPvvDb.hiCountryNoClass));
        assertThat(agsPvvUi.hiRegionNoClass, equalTo(agsPvvDb.hiRegionNoClass)); ///!!!!!
        assertThat(agsPvvUi.hiCountry, equalTo(agsPvvDb.hiCountry));
        assertThat(agsPvvUi.hiRegion, equalTo(agsPvvDb.hiRegion));
        assertThat(agsPvvUi.hiDistrict, equalTo(agsPvvDb.hiDistrict));
        assertThat(agsPvvUi.hiTown, equalTo(agsPvvDb.hiTown));
        assertThat(agsPvvUi.hiPunkt, equalTo(agsPvvDb.hiPunkt));
        assertThat(agsPvvUi.hiCitizenshipNoClass, equalTo(agsPvvDb.hiCitizenshipNoClass));
        assertThat(agsPvvUi.hiCitizenship, equalTo(agsPvvDb.hiCitizenship));
        assertThat(agsPvvUi.hiNationalNoClass, equalTo(agsPvvDb.hiNationalNoClass));
        assertThat(agsPvvUi.hiNational, equalTo(agsPvvDb.hiNational));
        assertThat(agsPvvUi.hiDivorceDoc, equalTo(agsPvvDb.hiDivorceDoc));
        assertThat(agsPvvUi.hiDivorceDocDate, equalTo(agsPvvDb.hiDivorceDocDate));
        assertThat(agsPvvUi.hiDivorceDocOrg, equalTo(agsPvvDb.hiDivorceDocOrg));
        assertThat(agsPvvUi.hiDoc, equalTo(agsPvvDb.hiDoc));
        assertThat(agsPvvUi.hiDocSer, equalTo(agsPvvDb.hiDocSer));
        assertThat(agsPvvUi.hiDocNum, equalTo(agsPvvDb.hiDocNum));
        assertThat(agsPvvUi.hiDocDate, equalTo(agsPvvDb.hiDocDate));
        assertThat(agsPvvUi.hiDocOrg, equalTo(agsPvvDb.hiDocOrg));
        System.out.println("ЖЕНИХ - ок");
        assertThat(agsPvvUi.sheLastNameBefore, equalTo(agsPvvDb.sheLastNameBefore));
        assertThat(agsPvvUi.sheLastNameAfter, equalTo(agsPvvDb.sheLastNameBefore));
        assertThat(agsPvvUi.sheFirstName, equalTo(agsPvvDb.sheFirstName));
        assertThat(agsPvvUi.sheMiddleName, equalTo(agsPvvDb.sheMiddleName));
        assertThat(agsPvvUi.sheDateBorn, equalTo(agsPvvDb.sheDateBorn));
        assertThat(agsPvvUi.sheAge, equalTo(agsPvvDb.sheAge));
        assertThat(agsPvvUi.sheCountryNoClass, equalTo(agsPvvDb.sheCountryNoClass));
        assertThat(agsPvvUi.sheRegionNoClass, equalTo(agsPvvDb.sheRegionNoClass)); ///!!!!!
        assertThat(agsPvvUi.sheCountry, equalTo(agsPvvDb.sheCountry));
        assertThat(agsPvvUi.sheRegion, equalTo(agsPvvDb.sheRegion));
        assertThat(agsPvvUi.sheDistrict, equalTo(agsPvvDb.sheDistrict));
        assertThat(agsPvvUi.sheTown, equalTo(agsPvvDb.sheTown));
        assertThat(agsPvvUi.shePunkt, equalTo(agsPvvDb.shePunkt));
        assertThat(agsPvvUi.sheCitizensshipNoClass, equalTo(agsPvvDb.sheCitizensshipNoClass));
        assertThat(agsPvvUi.sheCitizensship, equalTo(agsPvvDb.sheCitizensship));
        assertThat(agsPvvUi.sheNationalNoClass, equalTo(agsPvvDb.sheNationalNoClass));
        assertThat(agsPvvUi.sheNational, equalTo(agsPvvDb.sheNational));
        assertThat(agsPvvUi.sheDivorceDoc, equalTo(agsPvvDb.sheDivorceDoc));
        assertThat(agsPvvUi.sheDivorceDocDate, equalTo(agsPvvDb.sheDivorceDocDate));
        assertThat(agsPvvUi.sheDivorceDocOrg, equalTo(agsPvvDb.sheDivorceDocOrg));
        assertThat(agsPvvUi.sheDoc, equalTo(agsPvvDb.sheDoc));
        assertThat(agsPvvUi.sheDocSer, equalTo(agsPvvDb.sheDocSer));
        assertThat(agsPvvUi.sheDocNum, equalTo(agsPvvDb.sheDocNum));
        assertThat(agsPvvUi.sheDocDate, equalTo(agsPvvDb.sheDocDate));
        assertThat(agsPvvUi.sheDocOrg, equalTo(agsPvvDb.sheDocOrg));
        System.out.println("НЕВЕСТА - ок");
        System.out.println("проверка основных полей (1-11) (1 этап ввода) загруженных из  UI и БД ПВВ - ok");
        System.out.println("--------------------------");
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageMarriageHelper().backFromInputStageForm();
    }

    @Test (enabled = false, priority = 7)
    //проверка завершения ввода документа на 1 этапе ввода без изменения без изменения полей с направлением на корректировку
    public void finishInputDocOnFistStage() throws InterruptedException {
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
        //установка "Актовая запись с изменениями?" = да
        app.firstInputStageMarriageHelper().changesFieldBornSetup("Да");
        //сохранение документа
        app.firstInputStageMarriageHelper().submitSaveBornDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.firstInputStageMarriageHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа (без истории) на 1 этапе ввода без изменения - ok");

    }

    @Test (enabled = false, priority = 8)
    //проверка завершения ввода документа  на 2 этапе ввода без изменения без изменения полей с направлением на корректировку
    public void finishInputDocOnSecondStage() throws InterruptedException {
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
        //установка "Актовая запись с изменениями?" (Рождение) = да
        app.firstInputStageMarriageHelper().changesFieldBornSetup("Да");
        //сохранение документа (Рождение)
        app.firstInputStageMarriageHelper().submitSaveBornDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.firstInputStageMarriageHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа (без истории) на 2 этапе ввода без изменения - ok");
    }


}
