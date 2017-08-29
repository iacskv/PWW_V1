package qa.pww.tests;

import org.testng.annotations.Test;

/**
 * Created by k.smotrov on 07.08.2017.
 */
public class PmiTest extends TestBase{


    String login = "kron_op";
    String pass = "kron_op";
    String lastname = "Васин";
    String firstname = "Игорь";
    String midname = "Семенович";
    String title = "оператор ввода";
    String room = "№3";
    String descr = "1 смена";

    String rolename = "Оператор ввода";
    String roledescr = "1 и 2 этапы ввода";

    String distname = "Справочник льгот";
    String distkod = "W1000";
    String col1name = "Льготы";
    String col1kod = "S1000";
    String col2name = "Категории";
    String col2kode = "S500";
    String lgtname = "Герой России";
    String lgtkat = "1";
    String lgtves = "100";
    String distpath = "D:\\GIT_REP\\zags-inputarena\\db\\group document types and dictionaties\\dictionaries\\male.iad";

    String mainbook = "1СМ";
    String newbookname = "11СМ";

    String admin = "Касторин В.С.";
    String adminFullname = "Касторин Владимир Сергеевич";
    String adminPass = "admin";
    String kron_op = "Дмитриев И.С.";
    String kron_opFullname = "Дмитриев Игорь Семенович";
    String kron_opPass = "kron_op";


    @Test (enabled = true, priority = 1)
    public void createRole(){
        app.pmiHelper().gotoRolePage();
    }

    @Test (enabled = true, priority = 2)
    public void changeRulesForRole(){
        app.pmiHelper().gotoRolePage();
        app.pmiHelper().selectRole("Оператор ввода");
        app.pmiHelper().fillRulesRole();
        app.pmiHelper().saveRole();

    }

    @Test (enabled = true, priority = 3)
    public void createUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().createUserBtn();
        app.pmiHelper().fillNewUser("kron_op","Васин", "Игорь", "Семенович", "Оператор ввода", "Сотрудник ЗАГС");
        app.pmiHelper().saveNewUser();
        app.pmiHelper().exitNewUserBtn();

    }

    @Test (enabled = true, priority = 4)
    public void editUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().fillEditUser("Дмитриев");
        app.pmiHelper().saveEditUser();
        app.pmiHelper().exitEditUserBtn();

    }

    @Test (enabled = false, priority = 5)
    public void changeUserRole(){
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().giveNewRoleToUser("Оператор ввода");
        app.pmiHelper().saveEditUser();
        app.pmiHelper().exitEditUserBtn();

    }

    @Test (enabled = true, priority = 6)
    public void changePassUser() throws InterruptedException {
        app.pmiHelper().gotoUserPage();
        app.pmiHelper().selectUser("kron_op");
        app.pmiHelper().changePassUserBtn();
        app.pmiHelper().fillNewPassUser("kron_op");
        app.pmiHelper().saveNewPassUser();
    }

    @Test (enabled = false, priority = 7)
    public void createDistonary(){

    }

    @Test (enabled = false, priority = 8)
    public void editAttrDistonary() throws InterruptedException {

    }

    @Test (enabled = false, priority = 9)
    public void fillDistonary() throws InterruptedException {

    }

    @Test (enabled = false, priority = 10)
    public void loadDistinaryFromFile(){

    }

    @Test (enabled = true, priority = 11)
    //загрузка книг
    public void loadNewBook () throws InterruptedException {

    }

    @Test (enabled = true, priority = 12)
    public void filterListBook() throws InterruptedException {

    }

    @Test (enabled = true, priority = 13)
    public void changeBookInfo(){

    }

    @Test (enabled = true, priority = 14)
    public void assignMainBook() throws InterruptedException {

    }

    @Test (enabled = true, priority = 15)
    public void inputMainBookDoc() throws InterruptedException {

    }

    @Test (enabled = false, priority = 16)
    public void reviewDoc(){

    }

    @Test (enabled = false, priority = 17)
    public void editDoc(){

    }

}
