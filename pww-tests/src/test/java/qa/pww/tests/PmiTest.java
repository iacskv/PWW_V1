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


    @Test (enabled = true, priority = 1)
    public void createUser() throws InterruptedException {
        app.pmiHelper().gotoMainPage();
        app.pmiHelper().gotoAdmPage();
        app.pmiHelper().gotoUsersBtn();
        app.pmiHelper().createUserBtn();
        app.pmiHelper().createNewUser(login, pass, lastname, firstname, midname, title, room, descr );
    }



    @Test (enabled = true, priority = 2)
    public void editUser() throws InterruptedException {
        app.pmiHelper().selectPMiUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().editPmiUser();


    }

    @Test (enabled = true, priority = 3)
    public void changePassUser() throws InterruptedException {
        app.pmiHelper().selectPMiUser("adm_admin");
        app.pmiHelper().changePassBtn();
        app.pmiHelper().changePassPmiUser();
    }

    @Test (enabled = true, priority = 4)
    public void createRole(){
        //пустой тест
        app.pmiHelper().gotoRole();
        app.pmiHelper().createNewRoleBtn();
        app.pmiHelper().createNewRole();

    }

    @Test (enabled = true, priority = 5)
    public void changeRulesForRole(){
        app.pmiHelper().selectPmiRole(rolename);
        app.pmiHelper().changeRulesPmiRole();
    }

    @Test (enabled = true, priority = 6)
    public void changeUserRole(){
        app.pmiHelper().gotoUsersBtn();
        app.pmiHelper().selectPMiUser(login);
        app.pmiHelper().editUserBtn();
        app.pmiHelper().changePmiRoleForUser();
    }

    @Test (enabled = true, priority = 7)
    public void createDistonary(){
        app.pmiHelper().gotoDistonaryForm();
        app.pmiHelper().gotoDictinaryBtn();
        app.pmiHelper().createNewDistonaryBtn();
        app.pmiHelper().createNewDistinary(distname, distkod, col1name, col1kod);
    }

    @Test (enabled = true, priority = 8)
    public void editAttrDistonary() throws InterruptedException {
        app.pmiHelper().selectPmiDist(distname);
        app.pmiHelper().editDistBtn();
        app.pmiHelper().editDist(col2name, col2kode);

    }

    @Test (enabled = true, priority = 9)
    public void fillDistonary() throws InterruptedException {
        app.pmiHelper().selectPmiDist(distname);
        app.pmiHelper().fillDistonaryBtn();
        app.pmiHelper().fillDistonary(lgtname, lgtkat, lgtves);
    }

    @Test (enabled = true, priority = 10)
    public void loadDistinaryFromFile(){
        app.pmiHelper().importDistBtn();
        app.pmiHelper().importDist(distpath);

    }

    @Test (enabled = true, priority = 11)
    public void loadNewBook (){
        app.pmiHelper().gotoInput();
        app.pmiHelper().loadBookBtn();
        app.pmiHelper().loadBook("2003", "Смерть", "Кронштадтский (1997-2003)", "1СМ", "1", "1");

    }

}
