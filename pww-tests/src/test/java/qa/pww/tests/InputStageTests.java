package qa.pww.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pww.models.BornDataMainFields;
import qa.pww.models.DocForLoad;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 25.05.2017.
 */
public class InputStageTests extends TestBase {


    String typedoc = "Книга записей актов (2000-2003)";
    String typeags = "Запись акта о рождении";
    String year = "2003";
    String typezags = "Кронштадтский (1997-2003)";
    String fNum = "100";
    String lNum = "100";
    DocForLoad docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

    @BeforeMethod
    public void initLoadDataForm() throws InterruptedException {
        //загрузка АГС
        //app.loadDataHelper().gotoLoadDataPage();
        //app.loadDataHelper().fillLoadNewDocGroupFofm(docAttr);
        //app.loadDataHelper().submitLoad();
        //app.loadDataHelper().waitingLogText();
    }

    @AfterMethod
    public void ShutdownLoadDataForm() {
        //возврат на "главную"
        app.inputFormHelper().gotoMainPage();
    }





    @Test(enabled = true)
    //проверка максимального номера (последненго загруженного) группы документов в БД и UI на 1 этапе
    //проверка из UI будет глючить если не делать очистки БД
    public void checkNumNewBookOnFirstInputStage() throws InterruptedException, SQLException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersFirstStage();
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //проверка совпадения номера последней загруженной книги по UI  и БД
        app.inputFormHelper().checkNumNewBook();
    }

    @Test(enabled = true)
    //проверка что загруженная книга отображается в таблице 1 этапа ввода с нужными статусами
    //проверка из UI будет глючить если не делать очистки БД
    public void checkPresentNewBookOnFirstInputStage() throws InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersFirstStage();
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму просмотра группы
        app.inputFormHelper().gotoViewBookForm();
        //выбор агс
        app.inputFormHelper().selectAgs();
        //проверка на "Требует ввода"
        app.inputFormHelper().checkNeedInput();
        //проверка на "Введен"
        app.inputFormHelper().checkInputedTrue();
        //возврат к списку книг
        app.inputFormHelper().backFromReviewDocForm();
    }

    @Test(enabled = true)
    //проверка максимального номера (последненго загруженного) группы документов в БД и UI на 2 этапе
    //проверка из UI будет глючить если не делать очистки БД
    public void checkNumNewBookOnSecondInputStage() throws SQLException, InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (2 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersSecondStage();
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //проверка совпадения номера последней загруженной книги по UI  и БД
        app.inputFormHelper().checkNumNewBook();
    }


    @Test(enabled = true)
    //проверка что загруженная книга отображается в таблице 2 этапа ввода с нужными статусами
    //проверка из UI будет глючить если не делать очистки БД
    public void checkPresentNewBookOnSecondInputStage() throws InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (2 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersSecondStage();
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму просмотра группы
        app.inputFormHelper().gotoViewBookForm();
        //выбор агс
        app.inputFormHelper().selectAgs();
        //проверка на "Требует ввода"
        app.inputFormHelper().checkNeedInput();
        //проверка на "Введен"
        app.inputFormHelper().checkInputedTrue();
        //возврат к списку книг
        app.inputFormHelper().backFromReviewDocForm();
    }

    @Test(enabled = true)
    //проверка возможности открытия книги на заполнение в 1 этапе
    //проверка из UI будет глючить если не делать очистки БД
    public void fistInputStage() throws InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersFirstStage();
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму ввода
        app.inputFormHelper().gotoInputStageForm();

        //ожидание загрузки и получение текста № а/з
        Thread.sleep(5000);
        String a = "";
        a = app.inputFormHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));
        //возврат к списку книг (выход из формы ввода)
        app.inputFormHelper().backFromInputStageForm();
    }


    @Test (enabled = true)
    //проверка основных полей (1-21) загруженных из  UI и БД ПВВ
    public void checkMainFieldOnFirstStage() throws InterruptedException, SQLException {
        BornDataMainFields agsPvvUi;
        BornDataMainFields agsPvvDb;

        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFiltersFirstStage();
        //поиск по фильтрам
        app.inputFormHelper().submitFormFilters();
        //выбор книги загруженной последней (в BeforeMethod)
        app.inputFormHelper().selectBook();
        //переход на форму ввода
        app.inputFormHelper().gotoInputStageForm();

        //ожидание загрузки
        Thread.sleep(5000);
        //получение значений полей а/з с формы ввода документа
        agsPvvUi = app.inputFormHelper().getMainFieldFromPvv();
        System.out.println(agsPvvUi.toString());
        //получение значений полей а/з из БД
        agsPvvDb = app.inputFormHelper().getMainFieldFromPvvDb();
        System.out.println(agsPvvDb.toString());

        assertThat(agsPvvUi.agsNum, equalTo(agsPvvDb.agsNum));
        assertThat(agsPvvUi.liter, equalTo(agsPvvDb.liter));
        assertThat(agsPvvUi.agsDate, equalTo(agsPvvDb.agsDate));
        assertThat(agsPvvUi.zagsAgsName, equalTo(agsPvvDb.zagsAgsName));
        assertThat(agsPvvUi.agsCopy, equalTo(agsPvvDb.agsCopy));

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
        assertThat(agsPvvUi.childPunkt, equalTo(agsPvvDb.childPunkt));
        assertThat(agsPvvUi.childBirthCond, equalTo(agsPvvDb.childBirthCond));

        assertThat(agsPvvUi.vosstDate, equalTo(agsPvvDb.vosstDate));
        assertThat(agsPvvUi.vosstOrg, equalTo(agsPvvDb.vosstOrg));

        assertThat(agsPvvUi.fatherLastName, equalTo(agsPvvDb.fatherLastName));
        assertThat(agsPvvUi.fatherFirstName, equalTo(agsPvvDb.fatherFirstName));
        assertThat(agsPvvUi.fatherMiddleName, equalTo(agsPvvDb.fatherMiddleName));
        assertThat(agsPvvUi.fatherDateBorn, equalTo(agsPvvDb.fatherDateBorn));
        assertThat(agsPvvUi.fatherCountryNoClass, equalTo(agsPvvDb.fatherCountryNoClass));
        assertThat(agsPvvUi.fatherRegionNoClass, equalTo(agsPvvDb.fatherRegionNoClass));
        assertThat(agsPvvUi.fatherCountry, equalTo(agsPvvDb.fatherCountry));
        assertThat(agsPvvUi.fatherRegion, equalTo(agsPvvDb.fatherRegion));
        assertThat(agsPvvUi.fatherDistrict, equalTo(agsPvvDb.fatherDistrict));
        assertThat(agsPvvUi.fatherPunkt, equalTo(agsPvvDb.fatherPunkt));
        assertThat(agsPvvUi.fatherCitizenshipNoClass, equalTo(agsPvvDb.fatherCitizenshipNoClass));
        assertThat(agsPvvUi.fatherCitizenship, equalTo(agsPvvDb.fatherCitizenship));
        assertThat(agsPvvUi.fatherNationalNoClass, equalTo(agsPvvDb.fatherNationalNoClass));
        assertThat(agsPvvUi.fatherNational, equalTo(agsPvvDb.fatherNational));

        assertThat(agsPvvUi.matherLastName, equalTo(agsPvvDb.matherLastName));
        assertThat(agsPvvUi.matherFirstName, equalTo(agsPvvDb.matherFirstName));
        assertThat(agsPvvUi.matherMiddleName, equalTo(agsPvvDb.matherMiddleName));
        assertThat(agsPvvUi.matherDateBorn, equalTo(agsPvvDb.matherDateBorn));
        assertThat(agsPvvUi.matherCountryNoClass, equalTo(agsPvvDb.matherCountryNoClass));
        assertThat(agsPvvUi.matherRegionNoClass, equalTo(agsPvvDb.matherRegionNoClass));
        assertThat(agsPvvUi.matherCountry, equalTo(agsPvvDb.matherCountry));
        assertThat(agsPvvUi.matherRegion, equalTo(agsPvvDb.matherRegion));
        assertThat(agsPvvUi.matherDistrict, equalTo(agsPvvDb.matherDistrict));
        assertThat(agsPvvUi.matherPunkt, equalTo(agsPvvDb.matherPunkt));
        assertThat(agsPvvUi.matherCitizenshipNoClass, equalTo(agsPvvDb.matherCitizenshipNoClass));
        assertThat(agsPvvUi.matherCitizenship, equalTo(agsPvvDb.matherCitizenship));
        assertThat(agsPvvUi.matherNationalNoClass, equalTo(agsPvvDb.matherNationalNoClass));
        assertThat(agsPvvUi.matherNational, equalTo(agsPvvDb.matherNational));

        assertThat(agsPvvUi.baseTypeDoc, equalTo(agsPvvDb.baseTypeDoc));
        assertThat(agsPvvUi.baseNumDoc, equalTo(agsPvvDb.baseNumDoc));
        assertThat(agsPvvUi.baseDateDoc, equalTo(agsPvvDb.baseDateDoc));
        assertThat(agsPvvUi.baseOrgDoc, equalTo(agsPvvDb.baseOrgDoc));

        assertThat(agsPvvUi.certSeria, equalTo(agsPvvDb.certSeria));
        assertThat(agsPvvUi.certNum, equalTo(agsPvvDb.certNum));
        assertThat(agsPvvUi.certDate, equalTo(agsPvvDb.certDate));


    }

}
