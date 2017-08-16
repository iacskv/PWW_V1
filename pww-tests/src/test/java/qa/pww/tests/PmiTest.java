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


    @Test (enabled = false, priority = 1)
    public void createUser() throws InterruptedException {
        app.pmiHelper().gotoMainPage();
        app.pmiHelper().gotoAdmPage();
        app.pmiHelper().gotoUsersBtn();
        app.pmiHelper().createUserBtn();
        app.pmiHelper().createNewUser(login, pass, lastname, firstname, midname, title, room, descr );
    }



    @Test (enabled = false, priority = 2)
    public void editUser() throws InterruptedException {
        app.pmiHelper().selectPMiUser("kron_op");
        app.pmiHelper().editUserBtn();
        app.pmiHelper().editPmiUser();
    }

    @Test (enabled = false, priority = 3)
    public void changePassUser() throws InterruptedException {
        app.pmiHelper().selectPMiUser("adm_admin");
        app.pmiHelper().changePassBtn();
        app.pmiHelper().changePassPmiUser();
    }

    @Test (enabled = false, priority = 4)
    public void createRole(){
        //пустой тест
        app.pmiHelper().gotoRole();
        app.pmiHelper().createNewRoleBtn();
        app.pmiHelper().createNewRole();
    }

    @Test (enabled = false, priority = 5)
    public void changeRulesForRole(){
        app.pmiHelper().selectPmiRole(rolename);
        app.pmiHelper().changeRulesPmiRole();
    }

    @Test (enabled = false, priority = 6)
    public void changeUserRole(){
        app.pmiHelper().gotoUsersBtn();
        app.pmiHelper().selectPMiUser(login);
        app.pmiHelper().editUserBtn();
        app.pmiHelper().changePmiRoleForUser();
    }

    @Test (enabled = false, priority = 7)
    public void createDistonary(){
        app.pmiHelper().gotoDistonaryForm();
        app.pmiHelper().gotoDictinaryBtn();
        app.pmiHelper().createNewDistonaryBtn();
        app.pmiHelper().createNewDistinary(distname, distkod, col1name, col1kod);
    }

    @Test (enabled = false, priority = 8)
    public void editAttrDistonary() throws InterruptedException {
        app.pmiHelper().selectPmiDist(distname);
        app.pmiHelper().editDistBtn();
        app.pmiHelper().editDist(col2name, col2kode);
    }

    @Test (enabled = false, priority = 9)
    public void fillDistonary() throws InterruptedException {
        app.pmiHelper().selectPmiDist(distname);
        app.pmiHelper().fillDistonaryBtn();
        app.pmiHelper().fillDistonary(lgtname, lgtkat, lgtves);
    }

    @Test (enabled = false, priority = 10)
    public void loadDistinaryFromFile(){
        app.pmiHelper().importDistBtn();
        app.pmiHelper().importDist(distpath);
    }

    @Test (enabled = true, priority = 11)
    //загрузка книг
    public void loadNewBook () throws InterruptedException {
        app.pmiHelper().gotoInput();
        app.pmiHelper().loadBookBtn();
        //app.pmiHelper().loadBook("2003", "Рождение", "Кронштадтский (1997-2003)", "1РО", "1", "1");
        //app.pmiHelper().loadBook("2003", "Регистрация брака", "Кронштадтский (1997-2003)", "1РБ", "1", "1");
        app.pmiHelper().loadBook("2003", "Смерть", "Кронштадтский (1997-2003)", "1СМ", "1", "1");
    }

    @Test (enabled = true, priority = 12)
    public void filterListBook() throws InterruptedException {
        app.pmiHelper().gotoInput();
        app.pmiHelper().gotoControlBookBtn();
        app.pmiHelper().findControlBook("Смерть");
    }

    @Test (enabled = true, priority = 13)
    public void changeBookInfo(){
        app.pmiHelper().selectBook(mainbook);
        app.pmiHelper().ediBookBtn();
        app.pmiHelper().editBook(newbookname);
    }

    @Test (enabled = true, priority = 14)
    public void assignMainBook() throws InterruptedException {
        app.pmiHelper().selectBook(newbookname);
        app.pmiHelper().assignBookToUserBtn();
        app.pmiHelper().assignBookToUser(1, kron_op);
    }

    @Test (enabled = true, priority = 15)
    public void inputMainBookDoc() throws InterruptedException {
        app.pmiHelper().exitUser();
        app.pmiHelper().loginUser(kron_opPass, kron_opPass);
        app.pmiHelper().gotoInput();
        app.pmiHelper().inputBtn();
        app.pmiHelper().selectBook(kron_opFullname);
        app.pmiHelper().startInputBtn();
        app.pmiHelper().fillClassFieldsDeathInputForm();
        app.pmiHelper().hasChanges(0);
        app.pmiHelper().saveDocBtn();
        app.pmiHelper().endInputBookBtn();

        app.pmiHelper().exitUser();
        app.pmiHelper().loginUser(adminPass, adminPass);

        app.pmiHelper().gotoInput();
        app.pmiHelper().gotoControlBookBtn();
        app.pmiHelper().selectBook(newbookname);
        app.pmiHelper().assignBookToUserBtn();
        app.pmiHelper().assignBookToUser(2, admin);

        app.pmiHelper().inputBtn();
        app.pmiHelper().selectBook(adminFullname);
        app.pmiHelper().startInputBtn();
        app.pmiHelper().fillClassFieldsDeathInputForm();

        app.pmiHelper().saveDocBtn();
        app.pmiHelper().returnToBookListBtn();
    }

    @Test (enabled = false, priority = 16)
    public void reviewDoc(){
        app.pmiHelper().reviewBookBtn();
        app.pmiHelper().selectDocForReview();
        app.pmiHelper().reviewDocBtn();
        app.pmiHelper().returnFromReviewDocBtn();
    }

    @Test (enabled = false, priority = 17)
    public void editDoc(){
        app.pmiHelper().selectDocForReview();
        app.pmiHelper().editDocBtn();
        app.pmiHelper().insertDateCert("03");
        app.pmiHelper().insertErrorInDoc("Егорович");
        app.pmiHelper().saveAndExitBtn();
        app.pmiHelper().returnToBookListBtn();
        app.pmiHelper().startInputBtn();
        app.pmiHelper().endInputBookBtn();
    }

}
