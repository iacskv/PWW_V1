package qa.pww.Locators;

/**
 * Created by k.smotrov on 01.06.2017.
 */
public abstract class FirstInputStageBornFormLocators {

    //локаторы полей реквизитов акта

    public static String NUM_BORN = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"№ (номер):\")]/following-sibling::*[1]/*//input";
    public static String LITER_BORN = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Литера:\")]/following-sibling::*[1]/*//input";
    public static String NAME_ZAGS_BORN = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Название органа записи актов гражданского состояния:\")]/following-sibling::*[1]/*//input";
    public static String NUM_COPY_BORN = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Экземпляр:\")]/following-sibling::*[1]/*//input";

    public static String CH_DD_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String CH_MM_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String CH_YYYY_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";


    //локаторы сведений о ребенке
    public static String CH_SEX = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"4.Пол:\")]/following-sibling::*[1]/*//input";
    public static String CH_LASTNAME = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"1.Фамилия:\")]/following-sibling::*[1]/*//input";
    public static String CH_FNAME = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"2.Имя:\")]/following-sibling::*[1]/*//input";
    public static String CH_MNAME = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"3.Отчество:\")]/following-sibling::*[1]/*//input";

    public static String CH_BORN_DD_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String CH_BORN_MM_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String CH_BORN_YYYY_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String CH_COUNTRY_NO_CLASS = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String CH_REGION_NO_CLASS = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String CH_COUNTRY = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String CH_REGION = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String CH_DISTRICT = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Район:\")]/following-sibling::*[1]/*//input";
    public static String CH_TOWN = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Город:\")]/following-sibling::*[1]/*//input";
    public static String CH_PUNKT = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String CH_IS_A_LIFE = "//body//span[contains(text(),\"CВЕДЕНИЯ О РЕБЁНКЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"8.Живорожденный или мертворожденный:\")]/following-sibling::*[1]/*//input";

    //локаторы основания для восстановление а/з
    public static String VOSST_DD_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String VOSST_MM_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String VOSST_YYYY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";
    public static String VOSST_ORG_BORN = "//body//span[contains(text(),\"10.Основание восстановления записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Название органа, выдавшего документ:\")]/following-sibling::*[1]/*//input";

    //локаторы данных об отце
    public static String FATHER_LAST_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.Фамилия:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_FIRST_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"12.Имя\")]/following-sibling::*[1]/*//input";
    public static String FATHER_MIDDLE_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"13.Отчество\")]/following-sibling::*[1]/*//input";

    public static String FATHER_DD_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String FATHER_MM_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String FATHER_YYYY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String FATHER_COUNTRY_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_REGION_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_COUNTRY_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_REGION_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_DISNRICT_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Район:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_TOWN_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Город:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_PUNKT_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_CITIZENSHIP_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_CITIZENSHIP_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_NATIONAL_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_NATIONAL_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (классиф.):\")]/following-sibling::*[1]/*//input";

    //локаторы данных о матери
    public static String MATHER_LAST_NAME_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.Фамилия:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_FIRST_NAME_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"12.Имя\")]/following-sibling::*[1]/*//input";
    public static String MATHER_MIDDLE_NAME_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"13.Отчество\")]/following-sibling::*[1]/*//input";

    public static String MATHER_DD_BORN_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String MATHER_MM_BORN_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String MATHER_YYYY_BORN_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String MATHER_COUNTRY_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_REGION_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_COUNTRY_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_REGION_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_DISNRICT_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Район:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_TOWN_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Город:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_PUNKT_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_CITIZENSHIP_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_CITIZENSHIP_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_NATIONAL_NO_CLASS_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_NATIONAL_BORN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (классиф.):\")]/following-sibling::*[1]/*//input";

    //основание сведений об отце
    public static String BASE_TYPE_DOC_BORN = "//body//span[contains(text(),\"19.Сведения об отце указаны на основании:\")]/../following-sibling::*[1]/*//label[contains(text(),\"Тип документа:\")]/following-sibling::*[1]/*//input";
    public static String BASE_NUM_DOC_BORN = "//body//span[contains(text(),\"19.Сведения об отце указаны на основании:\")]/../following-sibling::*[1]/*//label[contains(text(),\"запись акта №:\")]/following-sibling::*[1]/*//input";

    public static String BASE_DD_DOC_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String BASE_MM_DOC_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String BASE_YYYY_DOC_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String BASE_ORG_DOC_BORN = "//body//span[contains(text(),\"19.Сведения об отце указаны на основании:\")]/../following-sibling::*[1]/*//label[contains(text(),\"наименование органа ЗАГСа:\")]/following-sibling::*[1]/*//input";

    //выданное свидетельство
    public static String CERT_SERIA_BORN = "//body//span[contains(text(),\"21.Выдано свидетельство\")]/../following-sibling::*[1]/*//label[contains(text(),\"Серия:\")]/following-sibling::*[1]/*//input";
    public static String CERT_NUM_BORN = "//body//span[contains(text(),\"21.Выдано свидетельство\")]/../following-sibling::*[1]/*//label[contains(text(),\"№ (номер):\")]/following-sibling::*[1]/*//input";

    public static String CERT_DD_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String CERT_MM_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String CERT_YYYY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    //признак наличия изменений
    public static String MORE_HISTORY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[9]/div[1]/div/input";

    //локаторы кнопок
    public static String SAVE_BORN_BTN_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String NEXT_BORN_WITH_NO_SAVE_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button";

    public static String BACK_FROM_INPUT_FORM_BTN_BORN = "//button[contains(text(),\"Вернуться к списку документов\")]";
    public static String END_INPUT_BOOK_BTN_BORN = "//button[contains(text(),\"Завершить ввод\")]";
}
