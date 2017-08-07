package qa.pww.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by k.smotrov on 07.08.2017.
 */
public class PmiTest extends TestBase{


    @BeforeMethod

    public void initUsersPage(){

        app.pmiHelper().gotoMainPage();
        app.pmiHelper().gotoAdmPage();
        app.pmiHelper().gotoUsers();
    }

    @Test

    public void createUser(){
        app.pmiHelper().createUserBtn();


    }

}
