package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static qa.pww.PmiLocators.EditUserPage.*;
import static qa.pww.PmiLocators.MainMenu.*;
import static qa.pww.PmiLocators.NewPassForm.*;
import static qa.pww.PmiLocators.NewUserPage.*;
import static qa.pww.PmiLocators.RolePage.*;
import static qa.pww.PmiLocators.UserPage.*;

/**
 * Created by k.smotrov on 07.08.2017.
 */
public class PmiHelper extends HelperBase{

    public PmiHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoRolePage(){
        click(By.xpath(ROLEBTN));
    }

    public void selectRole(String role){
        click(By.xpath("//div[text()='" + role + "']"));
    }

    public void fillRulesRole(){
        click(By.xpath(MAINPAGERULE));
        click(By.xpath(PATCHNOTERULE));
        click(By.xpath(INPUTRULE));
    }

    public void saveRole(){
        click(By.xpath(SAVEROLEBTN));
    }

    public void gotoUserPage(){
        click(By.xpath(USERBTN));
    }

    public void createUserBtn(){
        click(By.xpath(ADDUSERBTN));
    }

    public void fillNewUser(String logpass, String lname, String fname, String mname, String title, String role){
        type(By.xpath(LOGIN),logpass);
        type(By.xpath(PASS),logpass);
        type(By.xpath(PASS2),logpass);
        click(By.xpath(LOCATION));
        click(By.xpath(LOCATIONN));
        type(By.xpath(LNAME), lname);
        type(By.xpath(FNAME), fname);
        type(By.xpath(MNAME), mname);
        type(By.xpath(TITLE), title);
        click(By.xpath(ROLE + "[text()='" + role + "']"));
    }

    public void saveNewUser(){
        click(By.xpath(CREATEUSERBTN));
        click(By.xpath(OKBTN));
    }

    public void exitNewUserBtn(){
        click(By.xpath(EXITNEWUSERBTN));
    }

    public void selectUser(String userlog){
        click(By.xpath("//div[text()='" + userlog + "']"));
    }

    public void editUserBtn(){
        click(By.xpath(EDITUSERBTN));
    }

    public void fillEditUser(String lname){
        type(By.xpath(EDITUSERLNAME), lname);
    }

    public void giveNewRoleToUser(String role){
        click(By.xpath(EDITUSERROLE + "[text()='" + role + "']"));
    }

    public void saveEditUser(){
        click(By.xpath(SAVEEDITUSERBTN));
        click(By.xpath(OKEDITBTN));
    }

    public void exitEditUserBtn(){
        click(By.xpath(EXITEDITUSERBTN));
    }

    public void changePassUserBtn(){
        click(By.xpath(NEWPASSUSERBTN));
    }

    public void fillNewPassUser(String newpass){
        type(By.xpath(NEWPASS), newpass);
        type(By.xpath(NEWPASSS), newpass);
    }

    public void saveNewPassUser(){
        click(By.xpath(SAVENEWPASSBTN));
        click(By.xpath(OKNEWPASSBTN));
    }

}
