package qa.pww.tests;

import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by k.smotrov on 07.08.2017.
 */
public class PmiTest extends TestBase{

    File path = new File("D:\\iacskv\\PWW_V1\\pww-tests\\src\\test\\resources\\maleContent.xlsx");

    @Test (enabled = false, priority = 1)
    public void createRole(){
        app.pmiHelper().gotoRolePage();
    }

    @Test (enabled = false, priority = 2)
    public void changeRulesForRole(){
        app.pmiHelper().gotoRolePage();
        app.pmiHelper().selectRole("Оператор ввода");
        app.pmiHelper().fillRulesRole();
        app.pmiHelper().saveRole();

    }

    @Test (enabled = false, priority = 3)
    public void createUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().createUserBtn();
        app.pmiHelper().fillNewUser("kron_op","Васин", "Игорь", "Семенович", "Оператор ввода", "Сотрудник ЗАГС");
        app.pmiHelper().saveNewUser();
        app.pmiHelper().exitNewUserBtn();

    }

    @Test (enabled = false, priority = 4)
    public void editUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().fillEditUser("Дмитриев");
        app.pmiHelper().saveEditUser();
        app.pmiHelper().exitEditUserBtn();

    }

    @Test (enabled = false, priority = 5)
    public void changeUserRole() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().giveNewRoleToUser("Оператор ввода");
        app.pmiHelper().saveEditUser();
        app.pmiHelper().exitEditUserBtn();

    }

    @Test (enabled = false, priority = 6)
    public void changePassUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().changePassUserBtn();
        app.pmiHelper().fillNewPassUser("kron_op");
        app.pmiHelper().saveNewPassUser();
    }

    @Test (enabled = false, priority = 7)
    public void createDistonary(){
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().addDistonaryBtn();
        app.pmiHelper().fillNewColumnDist("Пол", "Строка", "male");
        app.pmiHelper().createNewColumnBtn();
        app.pmiHelper().fillNewDist("Пол","male","Пол");
        app.pmiHelper().SaveAndExitDistBtn();
    }

    @Test (enabled = false, priority = 8)
    public void editAttrDistonary() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().editDistBtn();
        app.pmiHelper().fillNewColumnDist("Код", "Число", "codeMale");
        app.pmiHelper().createNewColumnBtn();
        app.pmiHelper().SaveAndExitDistBtn();

    }

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

    @Test (enabled = false, priority = 11)
    public void deleteContentDistinary() throws InterruptedException {
        app.pmiHelper().gotoDistonaryPage();
        app.pmiHelper().selectDistonary("Пол");
        app.pmiHelper().contentDistBtn();
        app.pmiHelper().selectStringDist("неизвестный");
        app.pmiHelper().deleteStringDist();
        app.pmiHelper().exitMaleDist();
    }

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

    @Test (enabled = true, priority = 13)
    //загрузка книг
    public void loadNewBook () throws InterruptedException {
       app.pmiHelper().loadPage();
       app.pmiHelper().fillLoadParamBook("2003", "Книга записей актов (2000-2003)", "Смерть", "Кронштадтский (1997-2003)", "1СМ", "1", "1");
       app.pmiHelper().startLoadBtn();
       String a = app.pmiHelper().waitLoadBookResult();
       //System.out.println(a);
    }

    @Test (enabled = true, priority = 14)
    public void filterListBook() throws InterruptedException {
        app.pmiHelper().gotoBooks();
        app.pmiHelper().fillFilter("Смерть");
        app.pmiHelper().startFilterBtn();
        app.pmiHelper().cleanFilterBtn();
    }

    @Test (enabled = true, priority = 15)
    public void changeBookInfo() throws InterruptedException {
        app.pmiHelper().gotoBooks();
        app.pmiHelper().selectBook("1СМ");
        app.pmiHelper().editBookBtn();
        app.pmiHelper().fillNumBookInfo("11СМ");
        app.pmiHelper().saveExitInfoBookBtn();
    }

    @Test (enabled = true, priority = 16)
    public void assignBook() throws InterruptedException {
        app.pmiHelper().gotoBooks();
        app.pmiHelper().selectBook("11СМ");
        app.pmiHelper().setOperatorBtn();
        app.pmiHelper().fillOperator("Этап 1", "Дмитриев И.С.");
        app.pmiHelper().confirmSetOperatorBtn();
        app.pmiHelper().exitSetOperatorBtn();
    }

    @Test (enabled = true, priority = 17)
    public void inputMainFieldsDoc() throws InterruptedException {
        app.pmiHelper().unloginBtn();
        app.pmiHelper().confUnloginBtn();
        app.pmiHelper().login("kron_op", "kron_op");
        app.pmiHelper().gotoInput();
        app.pmiHelper().selectBookOnInput("Дмитриев Игорь Семенович");
        app.pmiHelper().startInputBookBtn();
        app.pmiHelper().fillDeathAgs();
        //app.pmiHelper().addSpecMarcDeathAgs("", "", "", "");
        app.pmiHelper().saveDeathAgsBtn();
        app.pmiHelper().fillHasInputHystory("Нет");
        app.pmiHelper().saveDeathAgsBtn();

        //отсюда неработает
        app.pmiHelper().leaveInputBtn();
    }

    @Test (enabled = false, priority = 18)
    public void reviewDoc(){

    }

    @Test (enabled = false, priority = 19)
    public void editDoc(){

    }

}
