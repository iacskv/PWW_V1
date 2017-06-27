package qa.pww.Locators;

/**
 * Created by k.smotrov on 01.06.2017.
 */
public abstract class FirstInputStageBornFormLocators {

    //локаторы полей реквизитов акта

    /*public static String NUM_DOC = "//body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/input";
    public static String LITER = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/input";
    public static String NAME_ZAGS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div/input";
    public static String NUM_COPY = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div/input";
*/
    public static String NUM_DOC = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"№ (номер):\")]/following-sibling::*[1]/*//input";
    public static String LITER = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Литера:\")]/following-sibling::*[1]/*//input";
    public static String NAME_ZAGS = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Название органа записи актов гражданского состояния:\")]/following-sibling::*[1]/*//input";
    public static String NUM_COPY = "//body//span[contains(text(),\"Реквизиты записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Экземпляр:\")]/following-sibling::*[1]/*//input";

    public static String CH_DD_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String CH_MM_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String CH_YYYY_ACT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";


    //локаторы сведений о ребенке
    /*public static String CH_SEX = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div/input";
    public static String CH_LASTNAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div/input";
    public static String CH_FNAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div/input";
    public static String CH_MNAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/input";
*/
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

   /* public static String CH_COUNTRY_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/div/input";
    public static String CH_REGION_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/div/input";
    public static String CH_COUNTRY = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[8]/div[1]/div/input";
    public static String CH_REGION = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[9]/div[1]/div/input";
    public static String CH_DISTRICT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[10]/div[1]/div/input";
    public static String CH_TOWN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[11]/div[1]/div/input";
    public static String CH_PUNKT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[12]/div[1]/div/input";
    public static String CH_IS_A_LIFE = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[13]/div[1]/div/input";
*/
    //локаторы основания для восстановление а/з
    public static String VOSST_DD = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String VOSST_MM = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String VOSST_YYYY = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    //public static String VOSST_ORG = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div/input";

    public static String VOSST_ORG = "//body//span[contains(text(),\"10.Основание восстановления записи акта о рождении\")]/../following-sibling::*[1]/*//label[contains(text(),\"Название органа, выдавшего документ:\")]/following-sibling::*[1]/*//input";

    //локаторы данных об отце
   /* public static String FATHER_LAST_NAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div/input";
    public static String FATHER_FIRST_NAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div/input";
    public static String FATHER_MIDDLE_NAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[3]/div[1]/div/input";
*/
    public static String FATHER_LAST_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.Фамилия:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_FIRST_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"12.Имя\")]/following-sibling::*[1]/*//input";
    public static String FATHER_MIDDLE_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"13.Отчество\")]/following-sibling::*[1]/*//input";


    public static String FATHER_DD_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String FATHER_MM_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String FATHER_YYYY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    /*public static String FATHER_COUNTRY_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[5]/div[1]/div/input";
    public static String FATHER_REGION_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[6]/div[1]/div/input";
    public static String FATHER_COUNTRY = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[7]/div[1]/div/input";
    public static String FATHER_REGION = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[8]/div[1]/div/input";
    public static String FATHER_DISNRICT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[9]/div[1]/div/input";
    public static String FATHER_TOWN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[10]/div[1]/div/input";
    public static String FATHER_PUNKT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[11]/div[1]/div/input";
    public static String FATHER_CITIZENSHIP_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[12]/div[1]/div/input";
    public static String FATHER_CITIZENSHIP = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[13]/div[1]/div/input";
    public static String FATHER_NATIONAL_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[14]/div[1]/div/input";
    public static String FATHER_NATIONAL = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[15]/div[1]/div/input";
*/

    public static String FATHER_COUNTRY_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_REGION_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_COUNTRY = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_REGION = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_DISNRICT = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Район:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_TOWN = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Город:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_PUNKT = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String FATHER_CITIZENSHIP_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_CITIZENSHIP = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_NATIONAL_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String FATHER_NATIONAL = "//body//span[contains(text(),\"СВЕДЕНИЯ ОБ ОТЦЕ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (классиф.):\")]/following-sibling::*[1]/*//input";

    //локаторы данных о матери

    /*public static String MATHER_LAST_NAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div/input";
    public static String MATHER_FIRST_NAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div/input";
    public static String MATHER_MIDDLE_NAME = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[3]/div[1]/div/input";
*/

    public static String MATHER_LAST_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"11.Фамилия:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_FIRST_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"12.Имя\")]/following-sibling::*[1]/*//input";
    public static String MATHER_MIDDLE_NAME = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"13.Отчество\")]/following-sibling::*[1]/*//input";


    public static String MATHER_DD_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String MATHER_MM_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String MATHER_YYYY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[4]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";


    /*public static String MATHER_COUNTRY_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[5]/div[1]/div/input";
    public static String MATHER_REGION_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[6]/div[1]/div/input";
    public static String MATHER_COUNTRY = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[7]/div[1]/div/input";
    public static String MATHER_REGION = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[8]/div[1]/div/input";
    public static String MATHER_DISNRICT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[9]/div[1]/div/input";
    public static String MATHER_TOWN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[10]/div[1]/div/input";
    public static String MATHER_PUNKT = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[11]/div[1]/div/input";
    public static String MATHER_CITIZENSHIP_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[12]/div[1]/div/input";
    public static String MATHER_CITIZENSHIP = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[13]/div[1]/div/input";
    public static String MATHER_NATIONAL_NO_CLASS = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[14]/div[1]/div/input";
    public static String MATHER_NATIONAL = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[15]/div[1]/div/input";
*/
    public static String MATHER_COUNTRY_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Страна (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_REGION_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_COUNTRY = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Cтрана (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_REGION = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Область, край, республика, город фед. значения (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_DISNRICT = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Район:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_TOWN = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Город:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_PUNKT = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"15.Населённый пункт:\")]/following-sibling::*[1]/*//input";
    public static String MATHER_CITIZENSHIP_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_CITIZENSHIP = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"16.Гражданство (классиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_NATIONAL_NO_CLASS = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (неклассиф.):\")]/following-sibling::*[1]/*//input";
    public static String MATHER_NATIONAL = "//body//span[contains(text(),\"СВЕДЕНИЯ О МАТЕРИ\")]/../following-sibling::*[1]/*//label[contains(text(),\"17.Национальность (классиф.):\")]/following-sibling::*[1]/*//input";


    //основание сведений об отце
    /*public static String BASE_TYPE_DOC = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div/input";
    public static String BASE_NUM_DOC = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div/input";
*/
    public static String BASE_TYPE_DOC = "//body//span[contains(text(),\"19.Сведения об отце указаны на основании:\")]/../following-sibling::*[1]/*//label[contains(text(),\"Тип документа:\")]/following-sibling::*[1]/*//input";
    public static String BASE_NUM_DOC = "//body//span[contains(text(),\"19.Сведения об отце указаны на основании:\")]/../following-sibling::*[1]/*//label[contains(text(),\"запись акта №:\")]/following-sibling::*[1]/*//input";

    public static String BASE_DD_DOC = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String BASE_MM_DOC = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String BASE_YYYY_DOC = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";

    //public static String BASE_ORG_DOC = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[4]/div[1]/div/input";

    public static String BASE_ORG_DOC = "//body//span[contains(text(),\"19.Сведения об отце указаны на основании:\")]/../following-sibling::*[1]/*//label[contains(text(),\"наименование органа ЗАГСа:\")]/following-sibling::*[1]/*//input";


    //выданное свидетельство
    /*public static String CERT_SERIA = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[1]/div[1]/div/input";
    public static String CERT_NUM = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div/input";
*/
    public static String CERT_SERIA = "//body//span[contains(text(),\"21.Выдано свидетельство\")]/../following-sibling::*[1]/*//label[contains(text(),\"Серия:\")]/following-sibling::*[1]/*//input";
    public static String CERT_NUM = "//body//span[contains(text(),\"21.Выдано свидетельство\")]/../following-sibling::*[1]/*//label[contains(text(),\"№ (номер):\")]/following-sibling::*[1]/*//input";


    public static String CERT_DD = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[1]/div/div[1]/div/input";
    public static String CERT_MM = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[2]/div/div[1]/div/input";
    public static String CERT_YYYY = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[7]/div[2]/div[1]/div[3]/div[2]/div[1]/form/div/div/div[3]/div/div[1]/div/input";


    //признак наличия изменений
    public static String MORE_HISTORY_BORN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[9]/div[1]/div/input";

    //локаторы кнопок
    public static String SAVE_BORN_BTN = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button";
    public static String NEXT_BORN_WITH_NO_SAVE = "html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button";

    public static String BACK_FROM_INPUT_FORM_BTN = "//button[contains(text(),\"Вернуться к списку документов\")]";
    public static String END_INPUT_BOOK_BTN = "//button[contains(text(),\"Завершить ввод\")]";
}