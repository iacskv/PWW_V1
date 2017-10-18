package qa.pww.tests;

import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by k.smotrov on 07.08.2017.
 */
public class PmiTest extends TestBase{

    File path = new File("D:\\iacskv\\PWW_V1\\pww-tests\\src\\test\\resources\\maleContent.xlsx");

    //создание роли пользователя
    @Test (enabled = false, priority = 1)
    public void createRole(){
        app.pmiHelper().gotoRolePage();
    }

    //изменение прав роли пользователя
    @Test (enabled = false, priority = 2)
    public void changeRulesForRole(){
        app.pmiHelper().gotoRolePage();
        app.pmiHelper().selectRole("Оператор ввода");
        app.pmiHelper().fillRulesRole();
        app.pmiHelper().saveRole();

    }

    //создание пользователя и назначение роли
    @Test (enabled = false, priority = 3)
    public void createUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().createUserBtn();
        app.pmiHelper().fillNewUser("kron_op","Васин", "Игорь", "Семенович", "Оператор ввода", "Сотрудник ЗАГС");
        app.pmiHelper().saveNewUser();
        app.pmiHelper().exitNewUserBtn();

    }

    //редактирование пользователя
    @Test (enabled = false, priority = 4)
    public void editUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().fillEditUser("Дмитриев");
        app.pmiHelper().saveEditUser();
        app.pmiHelper().exitEditUserBtn();

    }

    //переназначение ролей для пользователя
    @Test (enabled = false, priority = 5)
    public void changeUserRole() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().giveNewRoleToUser("Оператор ввода");
        app.pmiHelper().saveEditUser();
        app.pmiHelper().exitEditUserBtn();

    }

    //смена пароля пользователя
    @Test (enabled = false, priority = 6)
    public void changePassUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().changePassUserBtn();
        app.pmiHelper().fillNewPassUser("kron_op");
        app.pmiHelper().saveNewPassUser();
    }

    //создание справочника
    @Test (enabled = false, priority = 7)
    public void createDistonary(){
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().addDistonaryBtn();
        app.pmiHelper().fillNewColumnDist("Пол", "Строка", "male");
        app.pmiHelper().createNewColumnBtn();
        app.pmiHelper().fillNewDist("Пол","male","Пол");
        app.pmiHelper().SaveAndExitDistBtn();
    }

    //редактирование аттрибутов справочника
    @Test (enabled = false, priority = 8)
    public void editAttrDistonary() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().editDistBtn();
        app.pmiHelper().fillNewColumnDist("Код", "Число", "codeMale");
        app.pmiHelper().createNewColumnBtn();
        app.pmiHelper().SaveAndExitDistBtn();

    }

    //заполнение справочника данными
    @Test (enabled = false, priority = 9)
    public void fillContentDistonary() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().contentDistBtn();
        app.pmiHelper().createNewMaleStringBtn();
        app.pmiHelper().fillNewMaleString("неопределенный", "0", "3");
        app.pmiHelper().saveNewStringDist();
        app.pmiHelper().exitMaleDist();
    }

    //редактирование данных справочника
    @Test (enabled = false, priority = 10)
    public void editContentDistinary() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().contentDistBtn();
        app.pmiHelper().selectStringDist("неопределенный");
        app.pmiHelper().editStringDistBtn();
        app.pmiHelper().fillMaleString("неизвестный", "0", "3");
        app.pmiHelper().saveStringDist();
        app.pmiHelper().exitMaleDist();

    }

    //удаление данных в справочнике
    @Test (enabled = false, priority = 11)
    public void deleteContentDistinary() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().contentDistBtn();
        app.pmiHelper().selectStringDist("неизвестный");
        app.pmiHelper().deleteStringDist();
        app.pmiHelper().exitMaleDist();
    }

    //загрузка данных в справочник из файла
    @Test (enabled = false, priority = 12)
    public void loadContentDistinaryFromFile() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().contentDistBtn();
        app.pmiHelper().loadContentBtn();
        app.pmiHelper().fillContentFilePath(path);
        app.pmiHelper().loadFileContentBtn();
        app.pmiHelper().exitMaleDist();
    }

    //загрузка книги а/з
    @Test (enabled = true, priority = 13)
    public void loadNewBook () throws InterruptedException {
       app.pmiHelper().loadPage();
       app.pmiHelper().fillLoadParamBook("2003", "Книга записей актов (2000-2003)", "Смерть", "Кронштадтский (1997-2003)", "1СМ", "1", "1");
       app.pmiHelper().startLoadBtn();
       String a = app.pmiHelper().waitLoadBookResult();
       //System.out.println(a);
    }

    //поиск книги а/з в списке
    @Test (enabled = false, priority = 14)
    public void filterListBook() throws InterruptedException {
        app.pmiHelper().gotoBooksPage();
        app.pmiHelper().fillFilter("Смерть");
        app.pmiHelper().startFilterBtn();
        app.pmiHelper().cleanFilterBtn();
    }

    //изменение аттрибутов книги а/з
    @Test (enabled = true, priority = 15)
    public void changeBookInfo() throws InterruptedException {
        app.pmiHelper().gotoBooksPage();
        app.pmiHelper().selectBookOnBooksPage("1СМ");
        app.pmiHelper().editBookBtn();
        app.pmiHelper().fillNumBookInfo("11СМ");
        app.pmiHelper().saveExitInfoBookBtn();
    }

    //назначение пользователя на ввод книги а/з
    @Test (enabled = true, priority = 16)
    public void assignBook() throws InterruptedException {
        app.pmiHelper().gotoBooksPage();
        app.pmiHelper().selectBookOnBooksPage("11СМ");
        app.pmiHelper().setOperatorBtn();
        app.pmiHelper().fillOperator("Этап 1", "Дмитриев И.С.");
        app.pmiHelper().confirmSetOperatorBtn();
        app.pmiHelper().exitSetOperatorBtn();
    }

    //ввод данных а/з (ЭТАП ВВОДА)
    @Test (enabled = true, priority = 17)
    public void inputMainFieldsDoc() throws InterruptedException {
        app.pmiHelper().unloginBtn();
        app.pmiHelper().confUnloginBtn();
        app.pmiHelper().login("kron_op", "kron_op");
        app.pmiHelper().gotoInputPageOper();
        app.pmiHelper().selectBookOnInputPage("Дмитриев Игорь Семенович");
        app.pmiHelper().startInputBookBtn();
        app.pmiHelper().fillDeathAgs("Егорович");
        //app.pmiHelper().addSpecMarcDeathAgs("", "", "", "");
        app.pmiHelper().saveDeathAgsBtn();
        app.pmiHelper().fillHasInputHystory("Нет");
        app.pmiHelper().saveDeathAgsBtn();
        app.pmiHelper().leaveInputBtn();
    }

    //просмотр данных а/з (НА ЭТАПЕ ВВОДА)
    @Test (enabled = true, priority = 18)
    public void reviewDoc() throws InterruptedException {
        app.pmiHelper().gotoInputPageOper();
        app.pmiHelper().selectBookOnInputPage("Дмитриев Игорь Семенович");
        app.pmiHelper().reviewAllDocBtn();
        app.pmiHelper().selectReviewDoc("№1 Смерть");
        app.pmiHelper().openReviewDocForm();
        app.pmiHelper().closeReviewDocForm();
        app.pmiHelper().returnToInputBtn();
    }

    //редактирование данных а/з (НА ЭТАПЕ ВВОДА)
    @Test (enabled = true, priority = 19)
    public void editDoc() throws InterruptedException {
        app.pmiHelper().gotoInputPageOper();
        app.pmiHelper().selectBookOnInputPage("Дмитриев Игорь Семенович");
        app.pmiHelper().reviewAllDocBtn();
        app.pmiHelper().selectReviewDoc("№1 Смерть");
        app.pmiHelper().openEditDocFormBtn();
        app.pmiHelper().fillDeathEditAgsForm("Егорович");
        app.pmiHelper().saveExitEditDeathAgsFormBtn();
        app.pmiHelper().returnToInputBtn();
    }

    //завершение этапа ввода книги а/з
    @Test (enabled = true, priority = 20)
    public void endFirstInput() throws InterruptedException {
        app.pmiHelper().startInputBookBtn();
        app.pmiHelper().finishInputBtn();
    }

    //второй этап ввода книги а/з (от назначения до завершения)
    @Test (enabled = true, priority = 21)
    public void secondInput() throws InterruptedException {
        app.pmiHelper().unloginBtn();
        app.pmiHelper().confUnloginBtn();
        app.pmiHelper().login("admin", "admin");
        //повторение первого этапа ввода
        //
        //назначение на второй этап
        app.pmiHelper().gotoBooksPage();
        app.pmiHelper().selectBookOnBooksPage("11СМ");
        app.pmiHelper().setOperatorBtn();
        app.pmiHelper().fillOperator("Этап 2", "Касторин В.С.");
        app.pmiHelper().confirmSetOperatorBtn();
        app.pmiHelper().exitSetOperatorBtn();
        //ввод основных полей
        app.pmiHelper().gotoInputAdmin();
        app.pmiHelper().selectBookOnInputPage("Касторин Владимир Сергеевич");
        app.pmiHelper().startInputBookBtn();
        app.pmiHelper().fillDeathAgs("Петрович");
        //app.pmiHelper().addSpecMarcDeathAgs("", "", "", "");
        app.pmiHelper().saveDeathAgsBtn();
        app.pmiHelper().fillHasInputHystory("Нет");
        app.pmiHelper().saveDeathAgsBtn();
        app.pmiHelper().finishInputBtn();
    }

    //прервод книги на этап верификации
    @Test (enabled = true, priority = 22)
    public void moveBookToVerification() throws InterruptedException {
        app.pmiHelper().gotoBooksPage();
        app.pmiHelper().selectBookOnBooksPage("11СМ");
        app.pmiHelper().editBookBtn();
        app.pmiHelper().changeFaseBook("верификация");
        app.pmiHelper().saveExitInfoBookBtn();
        app.pmiHelper().waitVerificationJob(35);
    }

    //этап корректировки (ожидается ошибка в поле Отчество, разница в вводе на 1 и 2 этапе)
    @Test (enabled = true, priority = 23)
    public void correctionBookFase() throws InterruptedException {
        app.pmiHelper().gotoCorrectionPage();
        app.pmiHelper().selectBookOnCorrectionPage("11СМ");
        app.pmiHelper().gotoCorrectionBtn();
        app.pmiHelper().selectAgsForCorrection("№1 Смерть");
        app.pmiHelper().correctionAgsBtn();
        app.pmiHelper().fillCorrectionStage("Петрович");
        app.pmiHelper().saveCloseCorrectionAgsBtn();
        app.pmiHelper().finishCorrectionBtn();
    }

    //выгрузка книги а/з
    @Test (enabled = true, priority = 24)
    public void outputBook() throws InterruptedException {
        app.pmiHelper().gotoOutputBookPage();
        app.pmiHelper().selectAllBookForOutputBtn();
        app.pmiHelper().startOutputBookBtn();
        app.pmiHelper().waitResultOutputBook();
    }

    //просмотр электронного документа
    @Test (enabled = true, priority = 25)
    public void reviewDigitalDoc (){
        app.pmiHelper().gotoDigitalBtn();
        app.pmiHelper().needSignDigDocBtn();
        app.pmiHelper().selectDigDoc("Смерть");
        app.pmiHelper().reviewDigDocBtn();
        app.pmiHelper().gotoXmlSpanDigDocForm();
        app.pmiHelper().closeReviewDigDocForm();
    }

    //просмотр аттрибутов ЭД
    @Test (enabled = true, priority = 26)
    public void reviewInfoDigitalDoc (){
        app.pmiHelper().gotoDigitalBtn();
        app.pmiHelper().needSignDigDocBtn();
        app.pmiHelper().selectDigDoc("Смерть");
        app.pmiHelper().reviewDigDocBtn();
        app.pmiHelper().gotoInfoSpanDigDocForm();
        app.pmiHelper().closeReviewDigDocForm();
    }

    //подписание электронного документа
    @Test (enabled = true, priority = 27)
    public void signDigitalDoc (){


    }

    //формирование статистики по площадкам
    @Test (enabled = true, priority = 28)
    public void statsLocation (){

    }

    //формирование по пользователям
    @Test (enabled = true, priority = 29)
    public void statsUser(){

    }

}
