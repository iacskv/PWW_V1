package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static qa.pww.Locators.FirstInputStageFormLocators.*;
import static qa.pww.Locators.InputFormLocators.*;
import static qa.pww.Locators.ReviewDocForm.*;
import static qa.pww.Locators.SpanLocators.*;

/**
 * Created by k.smotrov on 25.05.2017.
 */
public class InputFormHelper extends HelperBase {


    public InputFormHelper(WebDriver wd) {
        super(wd);
    }
    JavascriptExecutor js = (JavascriptExecutor) wd;

    public void gotoInputForm() {
        click(By.xpath(PVV_SPAN));
        click(By.xpath(INPUT_BTN));

    }

    public void fillFormFiltersFirstStage() {
        click(By.xpath(TYPE_DOC)); //клик по фильтру "Тип"
        click(By.xpath("//div[text()='Книга записей актов (2000-2003)']")); //выбор "Книга 2000-2003"
        click(By.xpath(STAGE)); //клик по фильтру "Этап"
        click(By.xpath("//div[text()='1']")); //клик по "1"

    }

    public void fillFormFiltersSecondStage() {
        click(By.xpath(TYPE_DOC)); //клик по фильтру "Тип"
        click(By.xpath("//div[text()='Книга записей актов (2000-2003)']")); //выбор "Книга 2000-2003"
        click(By.xpath(STAGE)); //клик по фильтру "Этап"
        click(By.xpath("//div[text()='2']")); //клик по "2"

    }

    public void submitFormFilters() {
        click(By.xpath(SHOW_BTN)); //клик по кнопке "Показать"
    }

    //поиск строки в таблице с макс номером книги
    public String findBookWithMaxInd() {

        String book_max_id;
        List<WebElement> elements = wd.findElements(By.xpath("//div[contains(text(),'Номер книги:')]"));
        ArrayList<String> book_id = new ArrayList<>();
        for (WebElement element : elements) {
            String identifier = element.getText();
            identifier = identifier.replaceAll("Наименование.*", "").replaceAll("Номер книги: ", "").replace(",", "").replace(" ", "");
            book_id.add(identifier);
        }
        book_max_id = Collections.max(book_id);
        System.out.println("номер книги = " + book_max_id);
        return book_max_id;
    }

    public void selectBook() {
        click(By.xpath("//div[contains(text(),'Номер книги: " + findBookWithMaxInd() + "')]"));
    }

    public void gotoViewBookForm() {
        click(By.xpath(VIEW_BTN));
    }

    public void selectAgs() {
        click(By.xpath("//span[contains(text(),'Запись акта о рождении')]"));
    }

    public void checkNeedInput() {
        assertThat(wd.findElement(By.xpath(NEED_INPUT_TD)).getText(), equalTo("да"));

    }

    public void checkInputedTrue() {
        assertThat(wd.findElement(By.xpath(INPUTED_TD)).getText(), equalTo("нет"));
    }

    public void gotoInputStageForm(){
        click(By.xpath(LETS_INPUT_BTN));
    }

    public String textNumDoc(){
        String a = "";
        a = js.executeScript("return document.evaluate('" + NUM_DOC + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
        return a;
    }

    public void backFromInputStageForm(){
        click(By.xpath(BACK_FROM_INPUT_FORM_BTN));
    }

    public void backFromReviewDocForm(){
        click(By.xpath(BACK_FROM_REVIEW_DOC_FORM));
    }




}
