package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static qa.pww.PmiLocators.DistMaleContentPage.*;
import static qa.pww.PmiLocators.DistMaleNewStringForm.*;
import static qa.pww.PmiLocators.DistMaleStringForm.*;
import static qa.pww.PmiLocators.DistonaryPage.*;
import static qa.pww.PmiLocators.EditUserForm.*;
import static qa.pww.PmiLocators.LoadContentForm.*;
import static qa.pww.PmiLocators.MainMenu.*;
import static qa.pww.PmiLocators.NewDistForm.*;
import static qa.pww.PmiLocators.NewPassForm.*;
import static qa.pww.PmiLocators.NewUserForm.*;
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

    public void saveNewUser() throws InterruptedException {
        click(By.xpath(CREATEUSERBTN));
        sleep(1);
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

    public void saveEditUser() throws InterruptedException {
        click(By.xpath(SAVEEDITUSERBTN));
        sleep(1);
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

    public void saveNewPassUser() throws InterruptedException {
        click(By.xpath(SAVENEWPASSBTN));
        sleep(1);
        click(By.xpath(OKNEWPASSBTN));
    }

    public void gotoDistonaryPage(){
        click(By.xpath(DISTBTN));
    }

    public void addDistonaryBtn(){
        click(By.xpath(ADDDISTBTN));
    }

    public void fillNewColumnDist(String nameCol, String typeCol, String codeCol){
        type(By.xpath(NAMECOL), nameCol);
        click(By.xpath(TYPECOL));
        click(By.xpath(TYPEECOL + "[text()='" + typeCol + "']"));
        type(By.xpath(CODECOL), codeCol);
    }

    public void createNewColumnBtn(){
        click(By.xpath(CREATECOLUMNTBTN));
    }

    public void fillNewDist(String nameDist,String codeDist,String colDist){
        type(By.xpath(NAMENEWDIST),nameDist);
        type(By.xpath(CODENEWDIST), codeDist);
        click(By.xpath(COLNEWDIST));
        click(By.xpath(COLLNEWDIST + "[text()='" + colDist + "']"));
    }

    public void SaveAndExitDistBtn(){
        click(By.xpath(SAVEEXITDISTBTN));
    }

    public void selectDistonary(String dist){
        click(By.xpath(NAMEDIST + "[text()='" + dist + "']"));
    }

    public void editDistBtn(){
        click(By.xpath(EDITDISTBTN));
    }

    public void contentDistBtn(){
        click(By.xpath(CONTENTDISTBTN));
    }

    public void createNewMaleStringBtn(){
        click(By.xpath(ADDSTRINGCONTBTN));
    }

    public void fillNewMaleString(String male, String code, String weigth){
        type(By.xpath(NAMENEWSTRINGDIST), male);
        type(By.xpath(CODENEWSTRINGDIST), code);
        type(By.xpath(WEIGHTNEWSTRINGDIST), weigth);
    }

    public void saveNewStringDist(){
        click(By.xpath(SAVEEXITNEWSTRINGDISTBTN));
    }

    public void selectStringDist(String name){
        click(By.xpath(MALENAME + "[text()='" + name + "']"));
    }

    public void editStringDistBtn(){
        click(By.xpath(EDITSTRINGCONTBTN));
    }

    public void fillMaleString(String male, String code, String weigth){
        type(By.xpath(NAMESTRINGDIST), male);
        type(By.xpath(CODESTRINGDIST), code);
        type(By.xpath(WEIGHTSTRINGDIST), weigth);
    }

    public void saveStringDist(){
        click(By.xpath(SAVEEXITSTRINGDISTBTN));
    }

    public void deleteStringDist(){
        click(By.xpath(DELETESTRINGCONTBTN));
        click(By.xpath(OKDELSTRINGDIST));
    }

    public void exitMaleDist() throws InterruptedException {
        sleep(1);
        click(By.xpath(SPANMALEDIST));
        sleep(1);
        click(By.xpath(CLOSEMALEDIST));
        sleep(1);
    }

    public void loadContentBtn(){
        click(By.xpath(LOADCONTBTN));
    }

    public void fillContentFilePath(File path){
        attach(By.xpath(NAMEFILECONTENT), path);
    }

    public void loadFileContentBtn(){
        click(By.xpath(LOADCONTENTBTN));
    }
}
