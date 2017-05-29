package qa.pww.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pww.models.DocForLoad;

/**
 * Created by k.smotrov on 25.05.2017.
 */
public class InputStageTests extends TestBase {


    @BeforeMethod
    public void initLoadDataForm() throws InterruptedException {
        //загрузка АГС
        String typedoc = "Книга записей актов (2000-2003)";
        String typeags = "Запись акта о рождении";
        String year = "2003";
        String typezags = "Кронштадтский (1997-2003)";
        String fNum = "275";
        String lNum = "275";
        DocForLoad docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);
        app.loadDataHelper().gotoLoadDataPage();
        app.loadDataHelper().fillLoadNewDocGroupFofm(docAttr);
        app.loadDataHelper().submitLoad();
        app.loadDataHelper().waitingLogText();

    }

    @Test
    public void checkPresentNewBookOnInputStage() throws InterruptedException {
        //переход на страницу выбора группы док
        app.inputFormHelper().gotoInputForm();
        //заполнение фильтров (1 этап, 2000-2003)
        app.inputFormHelper().fillFormFilters();
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

    }
}
