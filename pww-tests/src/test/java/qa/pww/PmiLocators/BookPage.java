package qa.pww.PmiLocators;

/**
 * Created by k.smotrov on 31.08.2017.
 */
public abstract class BookPage {

    //кнопки (c пропустить 2 этап)
    public static String REVEIWBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String EDITBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button";
    public static String SETOPERBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[4]/table/tbody/tr[2]/td[2]/em/button";
    public static String SKIPSECONDINPUTBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button";

    public static String STARTFILTERBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[11]/table/tbody/tr[2]/td[2]/em/button";
    public static String CLEANFILTERBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[12]/table/tbody/tr[2]/td[2]/em/button";

    //поля
    public static String FASEFILTERBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[8]/div/img";
    public static String FASEFILTERRBOOK = "html/body/div[9]/div/div";
    public static String NUMFILTERBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[10]/div/input";

    //грид для удобства колонки отдельно
    public static String FASEBOOKGRID = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[2]/div";
    public static String FIRSTINPUTBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[3]/div";
    public static String SECONGINPUTBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[4]/div";
    public static String NUMBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[6]/div";
    public static String TYPEAGSBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[9]/div";
    public static String BLOCKBOOK = "html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[12]";
}
