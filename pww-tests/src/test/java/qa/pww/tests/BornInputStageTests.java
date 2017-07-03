package qa.pww.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.pww.models.BornDataMainFields;
import qa.pww.models.DocForLoad;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 25.05.2017.
 */
public class BornInputStageTests extends TestBase {


    String typedoc = "Книга записей актов (2000-2003)";
    String typeags = "Запись акта о рождении";
    String year = "2003";
    String typezags = "Кронштадтский (1997-2003)";
    String fNum = "287";
    String lNum = "287";
    DocForLoad docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

    //проверка из UI будет глючить если не делать очистки БД

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

    @Test(enabled = true, priority = 1)
    //проверка максимального номера (последненго загруженного) группы документов в БД и UI на 2 этапе
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

    @Test(enabled = true, priority = 2)
    //проверка что загруженная книга отображается в таблице 1 этапа ввода с нужными статусами
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
        app.inputFormHelper().selectAgsBorn();
        //проверка на "Требует ввода"
        app.inputFormHelper().checkNeedInput();
        //проверка на "Введен"
        app.inputFormHelper().checkInputedTrue();
        //возврат к списку книг
        app.inputFormHelper().backFromReviewDocForm();
        System.out.println("проверка что загруженная книга отображается в таблице 1 этапа ввода с нужными статусами - ok");
        System.out.println("--------------------------");
    }

    @Test(enabled = true, priority = 2)
    //проверка что загруженная книга отображается в таблице 2 этапа ввода с нужными статусами
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
        app.inputFormHelper().selectAgsBorn();
        //проверка на "Требует ввода"
        app.inputFormHelper().checkNeedInput();
        //проверка на "Введен"
        app.inputFormHelper().checkInputedTrue();
        //возврат к списку книг
        app.inputFormHelper().backFromReviewDocForm();
        System.out.println("проверка что загруженная книга отображается в таблице 2 этапа ввода с нужными статусами - ok");
        System.out.println("--------------------------");
    }

    @Test(enabled = true, priority = 3)
    //проверка возможности открытия книги на заполнение в 1 этапе
    public void possibilityOpenBookOnFirstInputStage() throws InterruptedException {
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
        a = app.firstInputStageBornHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageBornHelper().backFromInputStageForm();
        System.out.println("проверка возможности открытия книги на заполнение в 1 этапе - ok");
        System.out.println("--------------------------");
    }

    @Test(enabled = true, priority = 3)
    //проверка возможности открытия книги на заполнение в 2 этапе
    public void possibilityOpenBookOnSecondInputStage() throws InterruptedException {
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
        //ожидание загрузки и получение текста № а/з
        Thread.sleep(5000);
        String a = "";
        a = app.firstInputStageBornHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageBornHelper().backFromInputStageForm();
        System.out.println("проверка возможности открытия книги на заполнение в 1 этапе - ok");
        System.out.println("--------------------------");
    }

    @Test (enabled = true, priority = 4)
    //проверка основных полей (1-21) (1 этап ввода) загруженных из  UI и БД ПВВ
    public void checkMainFieldOnFirstInputStage() throws InterruptedException, SQLException {
        BornDataMainFields agsPvvUi;
        BornDataMainFields agsPvvDb;

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
        agsPvvUi = app.firstInputStageBornHelper().getMainFieldFromPvv();
        //получение значений полей а/з из БД
        agsPvvDb = app.firstInputStageBornHelper().getMainFieldFromPvvDb();
        //сравнение полей из БД с UI
        assertThat(agsPvvUi.agsNum, equalTo(agsPvvDb.agsNum));
        assertThat(agsPvvUi.liter, equalTo(agsPvvDb.liter));
        assertThat(agsPvvUi.agsDate, equalTo(agsPvvDb.agsDate));
        assertThat(agsPvvUi.zagsAgsName, equalTo(agsPvvDb.zagsAgsName));
        assertThat(agsPvvUi.agsCopy, equalTo(agsPvvDb.agsCopy));
        System.out.println("реквизиты АГС - ок");
        assertThat(agsPvvUi.childSex, equalTo(agsPvvDb.childSex));
        assertThat(agsPvvUi.childLastName, equalTo(agsPvvDb.childLastName));
        assertThat(agsPvvUi.childFirstName, equalTo(agsPvvDb.childFirstName));
        assertThat(agsPvvUi.childMiddleName, equalTo(agsPvvDb.childMiddleName));
        assertThat(agsPvvUi.childDateBorn, equalTo(agsPvvDb.childDateBorn));
        assertThat(agsPvvUi.childCountryNoClass, equalTo(agsPvvDb.childCountryNoClass));
        assertThat(agsPvvUi.childRegionNoClass, equalTo(agsPvvDb.childRegionNoClass));
        assertThat(agsPvvUi.childCountry, equalTo(agsPvvDb.childCountry)); ///!!!!!
        assertThat(agsPvvUi.childRegion, equalTo(agsPvvDb.childRegion));
        assertThat(agsPvvUi.childDisnrict, equalTo(agsPvvDb.childDisnrict));
        assertThat(agsPvvUi.childTown, equalTo(agsPvvDb.childTown));
        assertThat(agsPvvUi.childPunkt, equalTo(agsPvvDb.childPunkt));
        assertThat(agsPvvUi.childBirthCond, equalTo(agsPvvDb.childBirthCond));
        System.out.println("РЕБЕНОК - ок");
        assertThat(agsPvvUi.vosstDate, equalTo(agsPvvDb.vosstDate));
        assertThat(agsPvvUi.vosstOrg, equalTo(agsPvvDb.vosstOrg));
        System.out.println("ВОССТАНОВЛЕНО - ок");
        assertThat(agsPvvUi.fatherLastName, equalTo(agsPvvDb.fatherLastName));
        assertThat(agsPvvUi.fatherFirstName, equalTo(agsPvvDb.fatherFirstName));
        assertThat(agsPvvUi.fatherMiddleName, equalTo(agsPvvDb.fatherMiddleName));
        assertThat(agsPvvUi.fatherDateBorn, equalTo(agsPvvDb.fatherDateBorn));
        assertThat(agsPvvUi.fatherCountryNoClass, equalTo(agsPvvDb.fatherCountryNoClass));
        assertThat(agsPvvUi.fatherRegionNoClass, equalTo(agsPvvDb.fatherRegionNoClass));
        assertThat(agsPvvUi.fatherCountry, equalTo(agsPvvDb.fatherCountry));
        assertThat(agsPvvUi.fatherRegion, equalTo(agsPvvDb.fatherRegion));
        assertThat(agsPvvUi.fatherDistrict, equalTo(agsPvvDb.fatherDistrict));
        assertThat(agsPvvUi.fatherTown, equalTo(agsPvvDb.fatherTown));
        assertThat(agsPvvUi.fatherPunkt, equalTo(agsPvvDb.fatherPunkt));
        assertThat(agsPvvUi.fatherCitizenshipNoClass, equalTo(agsPvvDb.fatherCitizenshipNoClass));
        assertThat(agsPvvUi.fatherCitizenship, equalTo(agsPvvDb.fatherCitizenship));
        assertThat(agsPvvUi.fatherNationalNoClass, equalTo(agsPvvDb.fatherNationalNoClass));
        assertThat(agsPvvUi.fatherNational, equalTo(agsPvvDb.fatherNational));
        System.out.println("ОТЕЦ - ок");
        assertThat(agsPvvUi.matherLastName, equalTo(agsPvvDb.matherLastName));
        assertThat(agsPvvUi.matherFirstName, equalTo(agsPvvDb.matherFirstName));
        assertThat(agsPvvUi.matherMiddleName, equalTo(agsPvvDb.matherMiddleName));
        assertThat(agsPvvUi.matherDateBorn, equalTo(agsPvvDb.matherDateBorn));
        assertThat(agsPvvUi.matherCountryNoClass, equalTo(agsPvvDb.matherCountryNoClass));
        assertThat(agsPvvUi.matherRegionNoClass, equalTo(agsPvvDb.matherRegionNoClass));
        assertThat(agsPvvUi.matherCountry, equalTo(agsPvvDb.matherCountry));
        assertThat(agsPvvUi.matherRegion, equalTo(agsPvvDb.matherRegion));
        assertThat(agsPvvUi.matherDistrict, equalTo(agsPvvDb.matherDistrict));
        assertThat(agsPvvUi.matherTown, equalTo(agsPvvDb.matherTown));
        assertThat(agsPvvUi.matherPunkt, equalTo(agsPvvDb.matherPunkt));
        assertThat(agsPvvUi.matherCitizenshipNoClass, equalTo(agsPvvDb.matherCitizenshipNoClass));
        assertThat(agsPvvUi.matherCitizenship, equalTo(agsPvvDb.matherCitizenship));
        assertThat(agsPvvUi.matherNationalNoClass, equalTo(agsPvvDb.matherNationalNoClass));
        assertThat(agsPvvUi.matherNational, equalTo(agsPvvDb.matherNational));
        System.out.println("МАТЬ - ок");
        assertThat(agsPvvUi.baseTypeDoc, equalTo(agsPvvDb.baseTypeDoc));
        assertThat(agsPvvUi.baseNumDoc, equalTo(agsPvvDb.baseNumDoc));
        assertThat(agsPvvUi.baseDateDoc, equalTo(agsPvvDb.baseDateDoc));
        assertThat(agsPvvUi.baseOrgDoc, equalTo(agsPvvDb.baseOrgDoc));
        System.out.println("ОСНОВАНИЕ ОТЦА - ок");
        assertThat(agsPvvUi.certSeria, equalTo(agsPvvDb.certSeria));
        assertThat(agsPvvUi.certNum, equalTo(agsPvvDb.certNum));
        assertThat(agsPvvUi.certDate, equalTo(agsPvvDb.certDate));
        System.out.println("СВИДЕТЕЛЬСВО - ок");
        System.out.println("проверка основных полей (1-21) (1 этап ввода) загруженных из  UI и БД ПВВ - ok");
        System.out.println("--------------------------");
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageBornHelper().backFromInputStageForm();
    }

    @Test (enabled = true, priority = 4)
    //проверка основных полей (1-21) (2 этап ввода) загруженных из  UI и БД ПВВ
    public void checkMainFieldOnSecondInputStage() throws InterruptedException, SQLException {
        BornDataMainFields agsPvvUi;
        BornDataMainFields agsPvvDb;

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
        //получение значений полей а/з с формы ввода документа
        agsPvvUi = app.firstInputStageBornHelper().getMainFieldFromPvv();
        //получение значений полей а/з из БД
        agsPvvDb = app.firstInputStageBornHelper().getMainFieldFromPvvDb();
        //сравнение полей из БД с UI
        assertThat(agsPvvUi.agsNum, equalTo(agsPvvDb.agsNum));
        assertThat(agsPvvUi.liter, equalTo(agsPvvDb.liter));
        assertThat(agsPvvUi.agsDate, equalTo(agsPvvDb.agsDate));
        assertThat(agsPvvUi.zagsAgsName, equalTo(agsPvvDb.zagsAgsName));
        assertThat(agsPvvUi.agsCopy, equalTo(agsPvvDb.agsCopy));
        System.out.println("реквизиты АГС - ок");
        assertThat(agsPvvUi.childSex, equalTo(agsPvvDb.childSex));
        assertThat(agsPvvUi.childLastName, equalTo(agsPvvDb.childLastName));
        assertThat(agsPvvUi.childFirstName, equalTo(agsPvvDb.childFirstName));
        assertThat(agsPvvUi.childMiddleName, equalTo(agsPvvDb.childMiddleName));
        assertThat(agsPvvUi.childDateBorn, equalTo(agsPvvDb.childDateBorn));
        assertThat(agsPvvUi.childCountryNoClass, equalTo(agsPvvDb.childCountryNoClass));
        assertThat(agsPvvUi.childRegionNoClass, equalTo(agsPvvDb.childRegionNoClass));
        assertThat(agsPvvUi.childCountry, equalTo(agsPvvDb.childCountry)); ///!!!!!
        assertThat(agsPvvUi.childRegion, equalTo(agsPvvDb.childRegion));
        assertThat(agsPvvUi.childDisnrict, equalTo(agsPvvDb.childDisnrict));
        assertThat(agsPvvUi.childTown, equalTo(agsPvvDb.childTown));
        assertThat(agsPvvUi.childPunkt, equalTo(agsPvvDb.childPunkt));
        assertThat(agsPvvUi.childBirthCond, equalTo(agsPvvDb.childBirthCond));
        System.out.println("РЕБЕНОК - ок");
        assertThat(agsPvvUi.vosstDate, equalTo(agsPvvDb.vosstDate));
        assertThat(agsPvvUi.vosstOrg, equalTo(agsPvvDb.vosstOrg));
        System.out.println("ВОССТАНОВЛЕНО - ок");
        assertThat(agsPvvUi.fatherLastName, equalTo(agsPvvDb.fatherLastName));
        assertThat(agsPvvUi.fatherFirstName, equalTo(agsPvvDb.fatherFirstName));
        assertThat(agsPvvUi.fatherMiddleName, equalTo(agsPvvDb.fatherMiddleName));
        assertThat(agsPvvUi.fatherDateBorn, equalTo(agsPvvDb.fatherDateBorn));
        assertThat(agsPvvUi.fatherCountryNoClass, equalTo(agsPvvDb.fatherCountryNoClass));
        assertThat(agsPvvUi.fatherRegionNoClass, equalTo(agsPvvDb.fatherRegionNoClass));
        assertThat(agsPvvUi.fatherCountry, equalTo(agsPvvDb.fatherCountry));
        assertThat(agsPvvUi.fatherRegion, equalTo(agsPvvDb.fatherRegion));
        assertThat(agsPvvUi.fatherDistrict, equalTo(agsPvvDb.fatherDistrict));
        assertThat(agsPvvUi.fatherTown, equalTo(agsPvvDb.fatherTown));
        assertThat(agsPvvUi.fatherPunkt, equalTo(agsPvvDb.fatherPunkt));
        assertThat(agsPvvUi.fatherCitizenshipNoClass, equalTo(agsPvvDb.fatherCitizenshipNoClass));
        assertThat(agsPvvUi.fatherCitizenship, equalTo(agsPvvDb.fatherCitizenship));
        assertThat(agsPvvUi.fatherNationalNoClass, equalTo(agsPvvDb.fatherNationalNoClass));
        assertThat(agsPvvUi.fatherNational, equalTo(agsPvvDb.fatherNational));
        System.out.println("ОТЕЦ - ок");
        assertThat(agsPvvUi.matherLastName, equalTo(agsPvvDb.matherLastName));
        assertThat(agsPvvUi.matherFirstName, equalTo(agsPvvDb.matherFirstName));
        assertThat(agsPvvUi.matherMiddleName, equalTo(agsPvvDb.matherMiddleName));
        assertThat(agsPvvUi.matherDateBorn, equalTo(agsPvvDb.matherDateBorn));
        assertThat(agsPvvUi.matherCountryNoClass, equalTo(agsPvvDb.matherCountryNoClass));
        assertThat(agsPvvUi.matherRegionNoClass, equalTo(agsPvvDb.matherRegionNoClass));
        assertThat(agsPvvUi.matherCountry, equalTo(agsPvvDb.matherCountry));
        assertThat(agsPvvUi.matherRegion, equalTo(agsPvvDb.matherRegion));
        assertThat(agsPvvUi.matherDistrict, equalTo(agsPvvDb.matherDistrict));
        assertThat(agsPvvUi.matherTown, equalTo(agsPvvDb.matherTown));
        assertThat(agsPvvUi.matherPunkt, equalTo(agsPvvDb.matherPunkt));
        assertThat(agsPvvUi.matherCitizenshipNoClass, equalTo(agsPvvDb.matherCitizenshipNoClass));
        assertThat(agsPvvUi.matherCitizenship, equalTo(agsPvvDb.matherCitizenship));
        assertThat(agsPvvUi.matherNationalNoClass, equalTo(agsPvvDb.matherNationalNoClass));
        assertThat(agsPvvUi.matherNational, equalTo(agsPvvDb.matherNational));
        System.out.println("МАТЬ - ок");
        assertThat(agsPvvUi.baseTypeDoc, equalTo(agsPvvDb.baseTypeDoc));
        assertThat(agsPvvUi.baseNumDoc, equalTo(agsPvvDb.baseNumDoc));
        assertThat(agsPvvUi.baseDateDoc, equalTo(agsPvvDb.baseDateDoc));
        assertThat(agsPvvUi.baseOrgDoc, equalTo(agsPvvDb.baseOrgDoc));
        System.out.println("ОСНОВАНИЕ ОТЦА - ок");
        assertThat(agsPvvUi.certSeria, equalTo(agsPvvDb.certSeria));
        assertThat(agsPvvUi.certNum, equalTo(agsPvvDb.certNum));
        assertThat(agsPvvUi.certDate, equalTo(agsPvvDb.certDate));
        System.out.println("СВИДЕТЕЛЬСВО - ок");
        System.out.println("проверка основных полей (1-21) (1 этап ввода) загруженных из  UI и БД ПВВ - ok");
        System.out.println("--------------------------");
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageBornHelper().backFromInputStageForm();
    }

    @Test (enabled = false, priority = 5)
    //проверка завершения ввода документа на 1 этапе ввода без изменения без изменения полей с направлением на корректировку
    public void finishInputDocOnFistInputStage() throws InterruptedException {
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
        app.firstInputStageBornHelper().changesFieldBornSetup("Да");
        //сохранение документа
        app.firstInputStageBornHelper().submitSaveBornDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.firstInputStageBornHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа (без истории) на 1 этапе ввода без изменения - ok");

    }

    @Test (enabled = false, priority = 5)
    //проверка завершения ввода документа  на 2 этапе ввода без изменения без изменения полей с направлением на корректировку
    public void finishInputDocOnSecondInputStage() throws InterruptedException {
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
        app.firstInputStageBornHelper().changesFieldBornSetup("Да");
        //сохранение документа (Рождение)
        app.firstInputStageBornHelper().submitSaveBornDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.firstInputStageBornHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа (без истории) на 2 этапе ввода без изменения - ok");
    }


}
