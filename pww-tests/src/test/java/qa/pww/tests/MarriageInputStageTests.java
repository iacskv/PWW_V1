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
    //проверка из UI будет глючить если не делать очистки БД

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
        a = app.firstInputStageMarriageHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageMarriageHelper().backFromInputStageForm();
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
        a = app.firstInputStageMarriageHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageMarriageHelper().backFromInputStageForm();
        System.out.println("проверка возможности открытия книги на заполнение в 1 этапе - ok");
        System.out.println("--------------------------");
    }

    @Test (enabled = true, priority = 4)
    //проверка основных полей (1-21) (1 этап ввода) загруженных из  UI и БД ПВВ
    public void checkMainFieldOnFirstInputStage() throws InterruptedException, SQLException {
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
        /*System.out.println("интерфейс");
        System.out.println(agsPvvUi.agsNum);
        System.out.println(agsPvvUi.liter );
        System.out.println(agsPvvUi.agsDate );
        System.out.println(agsPvvUi.zagsAgsName  );
        System.out.println(agsPvvUi.agsCopy  );
        System.out.println("реквизиты АГС - ок");
        System.out.println(agsPvvUi.hiLastNameBefore  );
        System.out.println(agsPvvUi.hiLastNameAfter );
        System.out.println(agsPvvUi.hiFirstName  );
        System.out.println(agsPvvUi.hiMiddleName  );
        System.out.println(agsPvvUi.hiDateBorn );
        System.out.println(agsPvvUi.hiAge  );
        System.out.println(agsPvvUi.hiCountryNoClass  );
        System.out.println(agsPvvUi.hiRegionNoClass ); ///!!!!!
        System.out.println(agsPvvUi.hiCountry );
        System.out.println(agsPvvUi.hiRegion );
        System.out.println(agsPvvUi.hiDistrict );
        System.out.println(agsPvvUi.hiTown );
        System.out.println(agsPvvUi.hiPunkt  );
        System.out.println(agsPvvUi.hiCitizenshipNoClass);
        System.out.println(agsPvvUi.hiCitizenship );
        System.out.println(agsPvvUi.hiNationalNoClass  );
        System.out.println(agsPvvUi.hiNational  );
        System.out.println(agsPvvUi.hiDivorceDoc  );
        System.out.println(agsPvvUi.hiDivorceDocNum  );
        System.out.println(agsPvvUi.hiDivorceDocDate  );
        System.out.println(agsPvvUi.hiDivorceDocOrg );
        System.out.println(agsPvvUi.hiDoc  );
        System.out.println(agsPvvUi.hiDocSer  );
        System.out.println(agsPvvUi.hiDocNum  );
        System.out.println(agsPvvUi.hiDocDate  );
        System.out.println(agsPvvUi.hiDocOrg  );
        System.out.println("ЖЕНИХ - ок");
        System.out.println(agsPvvUi.sheLastNameBefore  );
        System.out.println(agsPvvUi.sheLastNameAfter  );
        System.out.println(agsPvvUi.sheFirstName  );
        System.out.println(agsPvvUi.sheMiddleName  );
        System.out.println(agsPvvUi.sheDateBorn  );
        System.out.println(agsPvvUi.sheAge  );
        System.out.println(agsPvvUi.sheCountryNoClass );
        System.out.println(agsPvvUi.sheRegionNoClass ); ///!!!!!
        System.out.println(agsPvvUi.sheCountry );
        System.out.println(agsPvvUi.sheRegion  );
        System.out.println(agsPvvUi.sheDistrict  );
        System.out.println(agsPvvUi.sheTown  );
        System.out.println(agsPvvUi.shePunkt );
        System.out.println(agsPvvUi.sheCitizensshipNoClass );
        System.out.println(agsPvvUi.sheCitizensship  );
        System.out.println(agsPvvUi.sheNationalNoClass );
        System.out.println(agsPvvUi.sheNational  );
        System.out.println(agsPvvUi.sheDivorceDoc  );
        System.out.println(agsPvvUi.sheDivorceDocNum  );
        System.out.println(agsPvvUi.sheDivorceDocDate  );
        System.out.println(agsPvvUi.sheDivorceDocOrg  );
        System.out.println(agsPvvUi.sheDoc  );
        System.out.println(agsPvvUi.sheDocSer );
        System.out.println(agsPvvUi.sheDocNum  );
        System.out.println(agsPvvUi.sheDocDate );
        System.out.println(agsPvvUi.sheDocOrg );
        System.out.println("НЕВЕСТА - ок");
        System.out.println("-----конец--------");

        System.out.println("база");
        System.out.println(  agsPvvDb.agsNum);
        System.out.println(  agsPvvDb.liter );
        System.out.println(  agsPvvDb.agsDate );
        System.out.println(  agsPvvDb.zagsAgsName  );
        System.out.println(  agsPvvDb.agsCopy  );
        System.out.println("реквизиты АГС - ок");
        System.out.println(  agsPvvDb.hiLastNameBefore  );
        System.out.println(  agsPvvDb.hiLastNameAfter );
        System.out.println(  agsPvvDb.hiFirstName  );
        System.out.println(  agsPvvDb.hiMiddleName  );
        System.out.println(  agsPvvDb.hiDateBorn );
        System.out.println(  agsPvvDb.hiAge  );
        System.out.println(  agsPvvDb.hiCountryNoClass  );
        System.out.println(  agsPvvDb.hiRegionNoClass ); ///!!!!!
        System.out.println(  agsPvvDb.hiCountry );
        System.out.println(  agsPvvDb.hiRegion );
        System.out.println(  agsPvvDb.hiDistrict );
        System.out.println(  agsPvvDb.hiTown );
        System.out.println(  agsPvvDb.hiPunkt  );
        System.out.println(  agsPvvDb.hiCitizenshipNoClass);
        System.out.println(  agsPvvDb.hiCitizenship );
        System.out.println(  agsPvvDb.hiNationalNoClass  );
        System.out.println(  agsPvvDb.hiNational  );
        System.out.println(  agsPvvDb.hiDivorceDoc  );
        System.out.println(  agsPvvDb.hiDivorceDocNum  );
        System.out.println(  agsPvvDb.hiDivorceDocDate  );
        System.out.println(  agsPvvDb.hiDivorceDocOrg );
        System.out.println(  agsPvvDb.hiDoc  );
        System.out.println(  agsPvvDb.hiDocSer  );
        System.out.println(  agsPvvDb.hiDocNum  );
        System.out.println(  agsPvvDb.hiDocDate  );
        System.out.println(  agsPvvDb.hiDocOrg  );
        System.out.println("ЖЕНИХ - ок");
        System.out.println(  agsPvvDb.sheLastNameBefore  );
        System.out.println(  agsPvvDb.sheLastNameAfter  );
        System.out.println(  agsPvvDb.sheFirstName  );
        System.out.println(  agsPvvDb.sheMiddleName  );
        System.out.println(  agsPvvDb.sheDateBorn  );
        System.out.println(  agsPvvDb.sheAge  );
        System.out.println(  agsPvvDb.sheCountryNoClass );
        System.out.println(  agsPvvDb.sheRegionNoClass ); ///!!!!!
        System.out.println(  agsPvvDb.sheCountry );
        System.out.println(  agsPvvDb.sheRegion  );
        System.out.println(  agsPvvDb.sheDistrict  );
        System.out.println(  agsPvvDb.sheTown  );
        System.out.println(  agsPvvDb.shePunkt );
        System.out.println(  agsPvvDb.sheCitizensshipNoClass );
        System.out.println(  agsPvvDb.sheCitizensship  );
        System.out.println(  agsPvvDb.sheNationalNoClass );
        System.out.println(  agsPvvDb.sheNational  );
        System.out.println(  agsPvvDb.sheDivorceDoc  );
        System.out.println(  agsPvvDb.sheDivorceDocNum  );
        System.out.println(  agsPvvDb.sheDivorceDocDate  );
        System.out.println(  agsPvvDb.sheDivorceDocOrg  );
        System.out.println(  agsPvvDb.sheDoc  );
        System.out.println(  agsPvvDb.sheDocSer );
        System.out.println(  agsPvvDb.sheDocNum  );
        System.out.println(  agsPvvDb.sheDocDate );
        System.out.println(  agsPvvDb.sheDocOrg );
        System.out.println("НЕВЕСТА - ок");
        System.out.println("-------конец--------");*/

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
        assertThat(agsPvvUi.sheLastNameAfter, equalTo(agsPvvDb.sheLastNameAfter));
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

    @Test (enabled = true, priority = 4)
    //проверка основных полей (1-21) (1 этап ввода) загруженных из  UI и БД ПВВ
    public void checkMainFieldOnSecondInputStage() throws InterruptedException, SQLException {
        MarriageDataMainFields agsPvvUi;
        MarriageDataMainFields agsPvvDb;

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
        agsPvvUi = app.firstInputStageMarriageHelper().getMainFieldFromPvv();
        //получение значений полей а/з из БД
        agsPvvDb = app.firstInputStageMarriageHelper().getMainFieldFromPvvDb();
        /*System.out.println("интерфейс");
        System.out.println(agsPvvUi.agsNum);
        System.out.println(agsPvvUi.liter );
        System.out.println(agsPvvUi.agsDate );
        System.out.println(agsPvvUi.zagsAgsName  );
        System.out.println(agsPvvUi.agsCopy  );
        System.out.println("реквизиты АГС - ок");
        System.out.println(agsPvvUi.hiLastNameBefore  );
        System.out.println(agsPvvUi.hiLastNameAfter );
        System.out.println(agsPvvUi.hiFirstName  );
        System.out.println(agsPvvUi.hiMiddleName  );
        System.out.println(agsPvvUi.hiDateBorn );
        System.out.println(agsPvvUi.hiAge  );
        System.out.println(agsPvvUi.hiCountryNoClass  );
        System.out.println(agsPvvUi.hiRegionNoClass ); ///!!!!!
        System.out.println(agsPvvUi.hiCountry );
        System.out.println(agsPvvUi.hiRegion );
        System.out.println(agsPvvUi.hiDistrict );
        System.out.println(agsPvvUi.hiTown );
        System.out.println(agsPvvUi.hiPunkt  );
        System.out.println(agsPvvUi.hiCitizenshipNoClass);
        System.out.println(agsPvvUi.hiCitizenship );
        System.out.println(agsPvvUi.hiNationalNoClass  );
        System.out.println(agsPvvUi.hiNational  );
        System.out.println(agsPvvUi.hiDivorceDoc  );
        System.out.println(agsPvvUi.hiDivorceDocNum  );
        System.out.println(agsPvvUi.hiDivorceDocDate  );
        System.out.println(agsPvvUi.hiDivorceDocOrg );
        System.out.println(agsPvvUi.hiDoc  );
        System.out.println(agsPvvUi.hiDocSer  );
        System.out.println(agsPvvUi.hiDocNum  );
        System.out.println(agsPvvUi.hiDocDate  );
        System.out.println(agsPvvUi.hiDocOrg  );
        System.out.println("ЖЕНИХ - ок");
        System.out.println(agsPvvUi.sheLastNameBefore  );
        System.out.println(agsPvvUi.sheLastNameAfter  );
        System.out.println(agsPvvUi.sheFirstName  );
        System.out.println(agsPvvUi.sheMiddleName  );
        System.out.println(agsPvvUi.sheDateBorn  );
        System.out.println(agsPvvUi.sheAge  );
        System.out.println(agsPvvUi.sheCountryNoClass );
        System.out.println(agsPvvUi.sheRegionNoClass ); ///!!!!!
        System.out.println(agsPvvUi.sheCountry );
        System.out.println(agsPvvUi.sheRegion  );
        System.out.println(agsPvvUi.sheDistrict  );
        System.out.println(agsPvvUi.sheTown  );
        System.out.println(agsPvvUi.shePunkt );
        System.out.println(agsPvvUi.sheCitizensshipNoClass );
        System.out.println(agsPvvUi.sheCitizensship  );
        System.out.println(agsPvvUi.sheNationalNoClass );
        System.out.println(agsPvvUi.sheNational  );
        System.out.println(agsPvvUi.sheDivorceDoc  );
        System.out.println(agsPvvUi.sheDivorceDocNum  );
        System.out.println(agsPvvUi.sheDivorceDocDate  );
        System.out.println(agsPvvUi.sheDivorceDocOrg  );
        System.out.println(agsPvvUi.sheDoc  );
        System.out.println(agsPvvUi.sheDocSer );
        System.out.println(agsPvvUi.sheDocNum  );
        System.out.println(agsPvvUi.sheDocDate );
        System.out.println(agsPvvUi.sheDocOrg );
        System.out.println("НЕВЕСТА - ок");
        System.out.println("-----конец--------");

        System.out.println("база");
        System.out.println(  agsPvvDb.agsNum);
        System.out.println(  agsPvvDb.liter );
        System.out.println(  agsPvvDb.agsDate );
        System.out.println(  agsPvvDb.zagsAgsName  );
        System.out.println(  agsPvvDb.agsCopy  );
        System.out.println("реквизиты АГС - ок");
        System.out.println(  agsPvvDb.hiLastNameBefore  );
        System.out.println(  agsPvvDb.hiLastNameAfter );
        System.out.println(  agsPvvDb.hiFirstName  );
        System.out.println(  agsPvvDb.hiMiddleName  );
        System.out.println(  agsPvvDb.hiDateBorn );
        System.out.println(  agsPvvDb.hiAge  );
        System.out.println(  agsPvvDb.hiCountryNoClass  );
        System.out.println(  agsPvvDb.hiRegionNoClass ); ///!!!!!
        System.out.println(  agsPvvDb.hiCountry );
        System.out.println(  agsPvvDb.hiRegion );
        System.out.println(  agsPvvDb.hiDistrict );
        System.out.println(  agsPvvDb.hiTown );
        System.out.println(  agsPvvDb.hiPunkt  );
        System.out.println(  agsPvvDb.hiCitizenshipNoClass);
        System.out.println(  agsPvvDb.hiCitizenship );
        System.out.println(  agsPvvDb.hiNationalNoClass  );
        System.out.println(  agsPvvDb.hiNational  );
        System.out.println(  agsPvvDb.hiDivorceDoc  );
        System.out.println(  agsPvvDb.hiDivorceDocNum  );
        System.out.println(  agsPvvDb.hiDivorceDocDate  );
        System.out.println(  agsPvvDb.hiDivorceDocOrg );
        System.out.println(  agsPvvDb.hiDoc  );
        System.out.println(  agsPvvDb.hiDocSer  );
        System.out.println(  agsPvvDb.hiDocNum  );
        System.out.println(  agsPvvDb.hiDocDate  );
        System.out.println(  agsPvvDb.hiDocOrg  );
        System.out.println("ЖЕНИХ - ок");
        System.out.println(  agsPvvDb.sheLastNameBefore  );
        System.out.println(  agsPvvDb.sheLastNameAfter  );
        System.out.println(  agsPvvDb.sheFirstName  );
        System.out.println(  agsPvvDb.sheMiddleName  );
        System.out.println(  agsPvvDb.sheDateBorn  );
        System.out.println(  agsPvvDb.sheAge  );
        System.out.println(  agsPvvDb.sheCountryNoClass );
        System.out.println(  agsPvvDb.sheRegionNoClass ); ///!!!!!
        System.out.println(  agsPvvDb.sheCountry );
        System.out.println(  agsPvvDb.sheRegion  );
        System.out.println(  agsPvvDb.sheDistrict  );
        System.out.println(  agsPvvDb.sheTown  );
        System.out.println(  agsPvvDb.shePunkt );
        System.out.println(  agsPvvDb.sheCitizensshipNoClass );
        System.out.println(  agsPvvDb.sheCitizensship  );
        System.out.println(  agsPvvDb.sheNationalNoClass );
        System.out.println(  agsPvvDb.sheNational  );
        System.out.println(  agsPvvDb.sheDivorceDoc  );
        System.out.println(  agsPvvDb.sheDivorceDocNum  );
        System.out.println(  agsPvvDb.sheDivorceDocDate  );
        System.out.println(  agsPvvDb.sheDivorceDocOrg  );
        System.out.println(  agsPvvDb.sheDoc  );
        System.out.println(  agsPvvDb.sheDocSer );
        System.out.println(  agsPvvDb.sheDocNum  );
        System.out.println(  agsPvvDb.sheDocDate );
        System.out.println(  agsPvvDb.sheDocOrg );
        System.out.println("НЕВЕСТА - ок");
        System.out.println("-------конец--------");*/

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
        assertThat(agsPvvUi.sheLastNameAfter, equalTo(agsPvvDb.sheLastNameAfter));
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
        System.out.println("проверка основных полей (1-11) (2 этап ввода) загруженных из  UI и БД ПВВ - ok");
        System.out.println("--------------------------");
        //возврат к списку книг (выход из формы ввода)
        app.firstInputStageMarriageHelper().backFromInputStageForm();
    }

    @Test (enabled = true, priority = 5)
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
        app.firstInputStageMarriageHelper().changesFieldBornSetup("Да");
        //сохранение документа
        app.firstInputStageMarriageHelper().submitSaveBornDoc();
        //ожидание загрузки
        Thread.sleep(1000);
        //завершение ввода группы (книги)
        app.firstInputStageMarriageHelper().submitEndInputGroup();
        System.out.println("проверка завершения ввода документа (без истории) на 1 этапе ввода без изменения - ok");

    }

    @Test (enabled = true, priority = 5)
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
