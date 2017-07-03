package qa.pww.Locators;

/**
 * Created by k.smotrov on 01.06.2017.
 */
public abstract class FirstInputStageMarriageFormLocators {

    //Реквизиты а/з
    public static String NUM_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"№ (номер):\")]/following-sibling::*[1]/*//input";
    public static String LITER_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"Литера:\")]/following-sibling::*[1]/*//input";
    public static String NAME_ZAGS_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"Название органа записи\")]/following-sibling::*[1]/*//input";
    public static String NUM_COPY_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"Экземпляр:\")]/following-sibling::*[1]/*//input";

    public static String DD_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String MM_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String YYYY_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";
    
    //данные жениха (1-11)
    public static String HI_LASTNAME_BEFORE_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"1.Фамилия до заключения брака:\")]/following-sibling::*[1]/*//input";
    public static String HI_LASTNAME_AFTER_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"2.Фамилия после заключения брака:\")]/following-sibling::*[1]/*//input";
    public static String HI_FNAME_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"3.Имя:\")]/following-sibling::*[1]/*//input";
    public static String HI_MNAME_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"4.Отчество:\")]/following-sibling::*[1]/*//input";

    public static String HI_DD_BORN_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String HI_MM_BORN_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String HI_YYYY_BORN_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String HI_AGE_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"5.Возраст (исполнилось лет):\")]/following-sibling::*[1]/*//input";
    public static String HI_COUNTRY_NO_CLASS_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_REGION_NO_CLASS_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_COUNTRY_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_REGION_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_DISTRICT_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Район:\")]/following-sibling::*[1]/*//input";
    public static String HI_TOWN_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Город:\")]/following-sibling::*[1]/*//input";
    public static String HI_PUNKT_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"6.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String HI_CITIZENSHIP_NO_CLASS_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"7.Гражданство (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_CITIZENSHIP_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"7.Гражданство (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_NATIONAL_NO_CLASS_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"8.Национальность (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_NATIONAL_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"8.Национальность (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String HI_DIV_DOC_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"9.Тип документа:\")]/following-sibling::*[1]/*//input";
    public static String HI_DIV_NUM_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"9.запись акта №:\")]/following-sibling::*[1]/*//input";

    public static String HI_DIV_DD_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[20]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String HI_DIV_MM_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[20]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String HI_DIV_YYYY_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[20]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String HI_DIV_ORG_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"9.наименование органа ЗАГСа:\")]/following-sibling::*[1]/*//input";
    public static String HI_DOC_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.тип документа:\")]/following-sibling::*[1]/*//input";
    public static String HI_DOC_NUM_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.№:\")]/following-sibling::*[1]/*//input";
    public static String HI_DOC_SER_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.серия:\")]/following-sibling::*[1]/*//input";

    public static String HI_DOC_DD_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[25]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String HI_DOC_MM_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[25]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String HI_DOC_YYYY_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[25]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String HI_DOC_ORG_MARRIAGE = "//body//span[contains(text(),\"Он\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.наименование органа, выдавшего документ:\")]/following-sibling::*[1]/*//input";
    
    //данные невесты (1-11)
    public static String SHE_LASTNAME_BEFORE_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"1.Фамилия до заключения брака:\")]/following-sibling::*[1]/*//input";
    public static String SHE_LASTNAME_AFTER_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"2.Фамилия после заключения брака:\")]/following-sibling::*[1]/*//input";
    public static String SHE_FNAME_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"3.Имя:\")]/following-sibling::*[1]/*//input";
    public static String SHE_MNAME_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"4.Отчество:\")]/following-sibling::*[1]/*//input";

    public static String SHE_DD_BORN_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String SHE_MM_BORN_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String SHE_YYYY_BORN_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[5]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String SHE_AGE_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"5.Возраст (исполнилось лет):\")]/following-sibling::*[1]/*//input";
    public static String SHE_COUNTRY_NO_CLASS_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_REGION_NO_CLASS_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_COUNTRY_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_REGION_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_DISTRICT_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Район:\")]/following-sibling::*[1]/*//input";
    public static String SHE_TOWN_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Город:\")]/following-sibling::*[1]/*//input";
    public static String SHE_PUNKT_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"6.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String SHE_CITIZENSHIP_NO_CLASS_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"7.Гражданство (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_CITIZENSHIP_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"7.Гражданство (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_NATIONAL_NO_CLASS_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"8.Национальность (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_NATIONAL_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"8.Национальность (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String SHE_DIV_DOC_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"9.Тип документа:\")]/following-sibling::*[1]/*//input";
    public static String SHE_DIV_NUM_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"9.запись акта №:\")]/following-sibling::*[1]/*//input";
    //public static String SHE_DIV_NUM_MARRIAGE = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[19]/div[1]/div/input";

    public static String SHE_DIV_DD_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[20]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String SHE_DIV_MM_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[20]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String SHE_DIV_YYYY_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[20]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String SHE_DIV_ORG_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"9.наименование органа ЗАГСа:\")]/following-sibling::*[1]/*//input";
    public static String SHE_DOC_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"11.тип документа:\")]/following-sibling::*[1]/*//input";
    public static String SHE_DOC_NUM_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"11.№:\")]/following-sibling::*[1]/*//input";
    public static String SHE_DOC_SER_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"11.серия:\")]/following-sibling::*[1]/*//input";

    public static String SHE_DOC_DD_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[25]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String SHE_DOC_MM_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[25]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String SHE_DOC_YYYY_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[25]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    public static String SHE_DOC_ORG_MARRIAGE = "//body//span[text()=\"Она\"]/../following-sibling::*[1]/*//label[contains(text(),\"11.наименование органа, выдавшего документ:\")]/following-sibling::*[1]/*//input";

    //есть изменения?
    public static String MORE_HISTORY_MARRIAGE = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[1]/div/input";

    //локаторы кнопок
    public static String SAVE_MARRIAGE_BTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String NEXT_MARRIAGE_WITH_NO_SAVE = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button";

    public static String BACK_FROM_INPUT_FORM_BTN_MARRIAGE = "//button[contains(text(),\"Вернуться к списку документов\")]";
    public static String END_INPUT_BOOK_BTN_MARRIAGE = "//button[contains(text(),\"Завершить ввод\")]";

}
