package qa.pww.Locators;

/**
 * Created by k.smotrov on 01.06.2017.
 */
public abstract class FirstInputStageMarriageFormLocators {

    //Реквизиты а/з
    public static String NUM_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"№ (номер):\")]/following-sibling::*[1]/*//input";
    public static String LITER_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"Литера:\")]/following-sibling::*[1]/*//input";;
    public static String NAME_ZAGS_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"Название органа записи\")]/following-sibling::*[1]/*//input";;
    public static String NUM_COPY_MARRIAGE = "//body//span[contains(text(),\"Реквизиты записи акта о браке\")]/../following-sibling::*[1]/*//label[contains(text(),\"Экземпляр:\")]/following-sibling::*[1]/*//input";;

    public static String DD_MARRIAGE;
    public static String MM_MARRIAGE;
    public static String YYYY_MARRIAGE;
    
    //данные жениха (1-11)
    /*public static String HI_LASTNAME_BEFORE_MARRIAGE
    public static String HI_LASTNAME_AFTER_MARRIAGE
    public static String HI_FNAME_MARRIAGE
    public static String HI_MNAME_MARRIAGE
    public static String HI_DD_BORN_MARRIAGE
    public static String HI_MM_BORN_MARRIAGE
    public static String HI_YYYY_BORN_MARRIAGE
    public static String HI_AGE_MARRIAGE
    public static String HI_COUNTRY_NO_CLASS_MARRIAGE
    public static String HI_REGION_NO_CLASS_MARRIAGE
    public static String HI_COUNTRY_MARRIAGE
    public static String HI_REGION_MARRIAGE
    public static String HI_DISTRICT_MARRIAGE
    public static String HI_TOWN_MARRIAGE
    public static String HI_PUNKT_MARRIAGE
    public static String HI_CITIZENSHIP_NO_CLASS_MARRIAGE
    public static String HI_CITIZENSHIP_MARRIAGE
    public static String HI_NATIONAL_NO_CLASS_MARRIAGE
    public static String HI_NATIONAL_MARRIAGE
    public static String HI_DIV_DOC_MARRIAGE
    public static String HI_DIV_NUM_MARRIAGE
    public static String HI_DIV_DD_MARRIAGE
    public static String HI_DIV_MM_MARRIAGE
    public static String HI_DIV_YYYY_MARRIAGE
    public static String HI_DIV_ORG_MARRIAGE
    public static String HI_DOC_MARRIAGE
    public static String HI_DOC_NUM_MARRIAGE
    public static String HI_DOC_SER_MARRIAGE
    public static String HI_DOC_DD_MARRIAGE
    public static String HI_DOC_MM_MARRIAGE
    public static String HI_DOC_YYYY_MARRIAGE
    public static String HI_DOC_ORG_MARRIAGE*/
    
    //данные невесты (1-11)
    /*public static String SHE_LASTNAME_BEFORE_MARRIAGE
    public static String SHE_LASTNAME_AFTER_MARRIAGE
    public static String SHE_FNAME_MARRIAGE
    public static String SHE_MNAME_MARRIAGE
    public static String SHE_DD_BORN_MARRIAGE
    public static String SHE_MM_BORN_MARRIAGE
    public static String SHE_YYYY_BORN_MARRIAGE
    public static String SHE_AGE_MARRIAGE
    public static String SHE_COUNTRY_NO_CLASS_MARRIAGE
    public static String SHE_REGION_NO_CLASS_MARRIAGE
    public static String SHE_COUNTRY_MARRIAGE
    public static String SHE_REGION_MARRIAGE
    public static String SHE_DISTRICT_MARRIAGE
    public static String SHE_TOWN_MARRIAGE
    public static String SHE_PUNKT_MARRIAGE
    public static String SHE_CITIZENSHIP_NO_CLASS_MARRIAGE
    public static String SHE_CITIZENSHIP_MARRIAGE
    public static String SHE_NATIONAL_NO_CLASS_MARRIAGE
    public static String SHE_NATIONAL_MARRIAGE
    public static String SHE_DIV_DOC_MARRIAGE
    public static String SHE_DIV_NUM_MARRIAGE
    public static String SHE_DIV_DD_MARRIAGE
    public static String SHE_DIV_MM_MARRIAGE
    public static String SHE_DIV_YYYY_MARRIAGE
    public static String SHE_DIV_ORG_MARRIAGE
    public static String SHE_DOC_MARRIAGE
    public static String SHE_DOC_NUM_MARRIAGE
    public static String SHE_DOC_SER_MARRIAGE
    public static String SHE_DOC_DD_MARRIAGE
    public static String SHE_DOC_MM_MARRIAGE
    public static String SHE_DOC_YYYY_MARRIAGE
    public static String SHE_DOC_ORG_MARRIAGE
*/
   //есть изменения?
    public static String MORE_HISTORY_MARRIAGE = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[1]/div/input";

    //локаторы кнопок
    public static String SAVE_MARRIAGE_BTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String NEXT_MARRIAGE_WITH_NO_SAVE = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button";


}
