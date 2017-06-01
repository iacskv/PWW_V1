package qa.pww.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pww.models.DocForLoad;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
    DocForLoad docAttr= new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

    @BeforeMethod
    public void initLoadDataForm() throws InterruptedException {
        //загрузка АГС
        app.loadDataHelper().gotoLoadDataPage();
        app.loadDataHelper().fillLoadNewDocGroupFofm(docAttr);
        app.loadDataHelper().submitLoad();
        app.loadDataHelper().waitingLogText();

    }

    @Test
    //проверка что загруженная книга отображается в таблице 1 этапа ввода с нужными статусами
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


   @Test
   //проверка что загруженная книга отображается в таблице 2 этапа ввода с нужными статусами
    public void checkPresentNewBookOnSecondInputStage(){
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

    @Test
    //проверка возможности открытия книги на заполнение в 1 этапе
    public void fistInputStage () throws InterruptedException {
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
        String a="";
        a = app.inputFormHelper().textNumDoc();
        //проверка на ожидаемый номер документа (из BeforeMethod)
        assertThat(a, equalTo(docAttr.fNum));

        //возврат к списку книг (выход из формы ввода)
        app.inputFormHelper().backFromInputStageForm();

    }


}
