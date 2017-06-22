package qa.pww.tests;

import org.testng.annotations.Test;

/**
 * Created by k.smotrov on 22.06.2017.
 */
public class ControlDocumentTests {

    @Test (enabled = false, priority = 1)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Готов к выгрузке" (группа без ошибок и без истории)
    public void moveGroupToVerification(){
    }

    @Test (enabled = false, priority = 2)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа c ошибоками, без истории)
    public void moveGroupWithErrorsToKorrection(){

    }

    @Test (enabled = false, priority = 3)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа без ошибок, с историей)
    public void moveGroupWithHistoryToKorrection(){

    }

    @Test (enabled = false, priority = 4)
    //перевод группы из "Ввода" в "Верификацию" и ожидание "Корректировки" (группа c ошибоками, с историей)
    public void moveGroupWithErrorsAndHistoryToKorrection(){

    }

    @Test (enabled = false, priority = 5)
    //перевод группы из "Корректировки" в "Готов к выгрузке"
    public void moveGroupToSaveFromKorrection(){

    }

    @Test (enabled = false, priority = 6)
    //перевод из "Готов к выгрузке" в "Корректировка"
    public void moveGroupToKorrectionFromSave(){

    }



}
