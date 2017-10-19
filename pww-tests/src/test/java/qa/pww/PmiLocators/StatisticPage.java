package qa.pww.PmiLocators;

/**
 * Created by k.smotrov on 19.10.2017.
 */
public abstract class StatisticPage {

    //вкладки
    public static String BOOKSTATSSPAN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span";
    public static String INPUTSTATSSPAN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span";
    public static String ERRORSTATSSPAN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/ul/li[3]/a[2]/em/span/span";
    public static String LOCATIONSTATSSPAN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/ul/li[4]/a[2]/em/span/span";
    public static String USERSTATSSPAN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/ul/li[5]/a[2]/em/span/span";

    //кнопки (по вкладкам)
    //по книгам
    public static String SAVEBOOKSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";
    //по вводу
    public static String SEARCHINPUTSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String SAVEINPUTSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";
    //по ошибкам
    public static String SEARCHERRORSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String SAVEERRORSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";
    //по полощадкам
    public static String SAVELOCATIONSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";
    //по пользователям
    public static String SEARCHUSERSTATSBTN = "html//button[text()='Показать']";
    public static String RESETSEARCHUSERSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[2]/table[2]/tbody/tr[2]/td[2]/em/button";
    public static String SAVEUSERSTATSBTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";

    //поля
    //по площадкам
    public static String NAMELOCFILTERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[1]/div/div/div[1]/div/img";
    public static String NAMELOCFILTERSTATT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[1]/div/div/div[1]/div/input";

    public static String NAMELOCATIONSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]/div";
    public static String WAITFORINPUTLOCSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[2]/div";
    public static String INPUTEDLOCSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[3]/div";
    public static String DOUBLEINPUTEDLOCSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[4]/div";
    public static String OUTPUTEDLOCSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[5]/div";

    //по пользователям
    public static String NAMEUERFILTERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div/img";
    public static String NAMEUERFILTERSTATT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div/input";
    public static String FDATEFILTERUSERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/table/tbody/tr/td[2]/div/div[2]/div[1]/form/div/div[1]/div/img";
    public static String FDATEFILTERUSERSTATT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/table/tbody/tr/td[2]/div/div[2]/div[1]/form/div/div[1]/div/input";
    public static String LDATEFILTERUSERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/table/tbody/tr/td[3]/div/div[2]/div[1]/form/div/div[1]/div/img";
    public static String LDATEFILTERUSERSTATT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/table/tbody/tr/td[3]/div/div[2]/div[1]/form/div/div[1]/div/input";

    public static String NAMEUSERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]/div";
    public static String LOCUSERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[2]/div";
    public static String INPUTEDUSERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[3]/div";
    public static String OUTPUTEDUSERSTAT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[5]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[4]/div";

}
