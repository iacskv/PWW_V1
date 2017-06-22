package qa.pww.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pww.models.DocForLoad;


/**
 * Created by k.smotrov on 12.05.2017.
 */
public class OutOfLimitRangeNumTests extends TestBase {
    DocForLoad docAttr;
    @BeforeMethod
    public void initLoadDataForm(){
        //данные для проверки
        String typedoc = "Книга записей актов (2000-2003)";
        String typeags = "Запись акта о рождении";
        String year = "2003";
        String typezags = "Адмиралтейский (1994-2003)";
        String fNum = "";
        String lNum = "";

        docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

        //переход на страницу загрузки
        app.loadDataHelper().gotoLoadDataPage();
    }

    @AfterMethod
    public void ShutdownLoadDataForm(){
        //переход на главную
        app.inputFormHelper().gotoMainPage();
    }




    @Test //больше 500 док внутри 1-999999
    public void testOutOfLimitRangeNum() throws InterruptedException {

        docAttr.setfNum("1");
        docAttr.setlNum("502");

        //переход на страницу загрузки
        app.loadDataHelper().gotoLoadDataPage();

        //заполнение формы
        app.loadDataHelper().fillLoadNewDocGroupFofm (docAttr);

        //запуск загрузки
        app.loadDataHelper().submitLoad();

        // проверка на наличие инфобокса, его заголовка и текста
        System.out.println("--------------");
        app.loadDataHelper().checkInfoBox();

        //закрытие инфобокса
        app.loadDataHelper().infoBoxClose();


        // проверка алертов у полей номеров
        app.loadDataHelper().checkFNumFieldAlert();
        app.loadDataHelper().checkLNumFieldAlert();
    }



    @Test //Начальный номер больше 999999
    public void testFNumTooBig() throws InterruptedException {

        docAttr.setfNum("1000000");
        docAttr.setlNum("1");

        //переход на страницу загрузки
        app.loadDataHelper().gotoLoadDataPage();

        //заполнение формы
        app.loadDataHelper().fillLoadNewDocGroupFofm (docAttr);

        //проверка алерта Начального номера
        System.out.println("--------------");
        System.out.println("Начальный номер = " + docAttr.fNum);
        System.out.println("Конечный номер = " + docAttr.lNum);
        app.loadDataHelper().checkFNumFieldAlert();
    }

    @Test //Конечный номер больше 999999
    public void testLNumTooBig() throws InterruptedException {

        docAttr.setfNum("1");
        docAttr.setlNum("1000000");


        //переход на страницу загрузки
        app.loadDataHelper().gotoLoadDataPage();

        //заполнение формы
        app.loadDataHelper().fillLoadNewDocGroupFofm (docAttr);

        //проверка алерта Начального номера
        System.out.println("--------------");
        System.out.println("Начальный номер = " + docAttr.fNum);
        System.out.println("Конечный номер = " + docAttr.lNum);
        app.loadDataHelper().checkLNumFieldAlert();
    }

    @Test //Начальный и Конечный номера больше 999999
    public void testAllNumTooBig() throws InterruptedException {

        docAttr.setfNum("1000000");
        docAttr.setlNum("1000000");


        //переход на страницу загрузки
        app.loadDataHelper().gotoLoadDataPage();

        //заполнение формы
        app.loadDataHelper().fillLoadNewDocGroupFofm (docAttr);

        // проверка алертов у полей номеров
        System.out.println("--------------");
        System.out.println("Начальный номер = " + docAttr.fNum);
        System.out.println("Конечный номер = " + docAttr.lNum);
        app.loadDataHelper().checkFNumFieldAlert();

    }

}
