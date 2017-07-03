package qa.pww.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.pww.models.DocForLoad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public class LoadNewDocGroupTests extends TestBase {



    @DataProvider
    public Iterator<Object[]> validDoc() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/LOAD_BORN_ADMIR_KRON_OUT.txt")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new DocForLoad(split[0], split[1], split[2], split[3], split[4], split[5])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @BeforeMethod
    public void initLoadDataForm(){
        //переход на страницу загрузки
        app.loadDataHelper().gotoLoadDataPage();
    }

    @AfterMethod
    public void ShutdownLoadDataForm(){
        //переход на главную
        app.inputFormHelper().gotoMainPage();
    }

    @Test(dataProvider = "validDoc")
    public void testLoadNewDocGroup(DocForLoad docAtt) throws InterruptedException {

        //заполнение полей формы
        app.loadDataHelper().fillLoadNewDocGroupFofm(docAtt);
        //запуск загрузки
        app.loadDataHelper().submitLoad();
        //ожидание конца загрузки группы документов
        app.loadDataHelper().waitingLogText();
        //проверка текста в поле Лог загрузки
        String textarea = app.loadDataHelper().waitingLogText();
        assertThat(textarea, startsWith("Загрузка запущена"));
        System.out.println(" -------------------------------- ");
        System.out.println(textarea);
        System.out.println();
    }

}
