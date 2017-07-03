package qa.pww.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import qa.pww.models.DocForLoad;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static qa.pww.Locators.LoadDataFormLocators.*;
import static qa.pww.Locators.SpanLocators.*;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public class LoadDataHelper extends HelperBase {

    public DocForLoad docAttr;

    public LoadDataHelper(WebDriver wd) {
        super(wd);
    }

    public String waitingLogText() throws InterruptedException {
        int i = 0;
        String a = "";
        JavascriptExecutor js = (JavascriptExecutor) wd;
        while (a.equals("")) {

            a = js.executeScript("return document.getElementById('x-auto-38-input').getAttributeNode('class').ownerElement.value;").toString();
            Thread.sleep(1000);
            i++;
            if (i > 180) {
                return "Не дождались";
            }
        }
        return a;
    }

    public void gotoLoadDataPage() {
        //вкладка площадка ввода
        click(By.xpath(PVV_SPAN));

        // клик по кнопке загрузка данных
        click(By.xpath(LOAD_BTN));
    }

    public void fillLoadNewDocGroupFofm(DocForLoad docAtt) throws InterruptedException {
        // выбор типа книги
        Thread.sleep(5000);

        click(By.xpath(TYPE_DOC));
        click(By.xpath("//div[8]/div/div[text()='" + docAtt.typeDoc + "']"));//по пункту списка (200-2003)

        // выбор типа АГС
        click(By.xpath(TYPE_AGS));
        click(By.xpath("//div[8]/div/div[text()='" + docAtt.typeAgs + "']"));//рождение

        //выбор года
        click(By.xpath(YEAR));
        click(By.xpath("//div[8]/div/div[text()='" + docAtt.year + "']"));//2003

        // выбор ЗАГС
        click(By.xpath(TYPE_ZAGS));
        click(By.xpath("//div[8]/div/div[text()='" + docAtt.typeZags + "']"));//адмиралтейский

        //ввод первого номера
        type(By.xpath(F_NUM), docAtt.fNum);

        //ввод последнего номера
        type(By.xpath(L_NUM), docAtt.lNum);
    }

    public void submitLoad() throws InterruptedException {
        //клик по кнопке загрузка
        Thread.sleep(1000);
        click(By.xpath(LOAD_RUN_BTN));
    }

    public void checkInfoBox() {
        assertThat(wd.findElement(By.xpath(INFO_BOX_NUM)), notNullValue());
        System.out.println("инфобокс на месте");
        assertThat(wd.findElement(By.xpath(INFO_BOX_NUM_SPAN)).getText(), equalTo("Неверные значения номеров актовых записей"));
        System.out.println("заголовок ок");
        assertThat(wd.findElement(By.xpath(INFO_BOX_NUM_TEXT)).getText(), equalTo("Не больше 500 актовых записей за раз"));
        System.out.println("текст инфобокса ок");
    }

    public void infoBoxClose() {
        click(By.xpath(INFO_BOX_NUM_BTN));
    }

    public void checkFNumFieldAlert() {
        assertThat(wd.findElement(By.xpath(F_NUM_ALRT)), notNullValue());

        System.out.println("алерт поля 'Начальный номер' на месте");
    }

    public void checkLNumFieldAlert() {
        assertThat(wd.findElement(By.xpath(L_NUM_ALRT)), notNullValue());

        System.out.println("алерт поля 'Конечный номер' на месте");
    }


    @AfterMethod
        public void gotoMainPage(){
            click(By.xpath(MAIN_SPAN));
    }
}
