package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static qa.pww.PmiLocators.BookPage.*;
import static qa.pww.PmiLocators.DeathInputPage.*;
import static qa.pww.PmiLocators.DistMaleContentPage.*;
import static qa.pww.PmiLocators.DistMaleNewStringForm.*;
import static qa.pww.PmiLocators.DistMaleStringForm.*;
import static qa.pww.PmiLocators.DistonaryPage.*;
import static qa.pww.PmiLocators.EditUserForm.*;
import static qa.pww.PmiLocators.InfoBookForm.*;
import static qa.pww.PmiLocators.InputPage.*;
import static qa.pww.PmiLocators.LoadContentForm.*;
import static qa.pww.PmiLocators.LoadPage.*;
import static qa.pww.PmiLocators.LoginForm.*;
import static qa.pww.PmiLocators.MainMenu.*;
import static qa.pww.PmiLocators.NewDistForm.*;
import static qa.pww.PmiLocators.NewPassForm.*;
import static qa.pww.PmiLocators.NewUserForm.*;
import static qa.pww.PmiLocators.RolePage.*;
import static qa.pww.PmiLocators.SetOperatorForm.*;
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

    public void loadPage(){
        click(By.xpath(LOADBTN));
    }

    public void fillLoadParamBook(String year, String typeBook, String typeAgs, String dept, String numBook, String startNum, String endNum){
        click(By.xpath(YEARLOAD));
        click(By.xpath(YEARRLOAD + "[text()='" + year + "']"));
        click(By.xpath(TYPEBOOKLOAD));
        click(By.xpath(TYPEBOOKKLOAD + "[text()='" + typeBook + "']"));
        click(By.xpath(TYPEAGSLOAD));
        click(By.xpath(TYPEAGSSLOAD + "[text()='" + typeAgs + "']"));
        click(By.xpath(DEPTLOAD));
        click(By.xpath(DEPTTLOAD + "[text()='" + dept + "']"));
        type(By.xpath(NUMBOOKLOAD), numBook);
        type(By.xpath(STARTNUMLOAD), startNum);
        type(By.xpath(ENDNUMLOAD), endNum);
    }

    public void startLoadBtn() throws InterruptedException {
        sleep(1);
        click(By.xpath(STARTLOAD));
    }

    public String waitLoadBookResult()throws InterruptedException{
            int i = 0;
            String a = "";
            JavascriptExecutor js = (JavascriptExecutor) wd;
            while (a.equals("")) {
                a = js.executeScript("return document.evaluate('" + RESULTLOAD + "', document, null, XPathResult.ANY_TYPE, null).iterateNext().getAttributeNode('class').ownerElement.value").toString();
                sleep(1);
                i++;
                if (i > 180) {
                    return "Не дождались";
                }
            }
            return a;
    }

    public void gotoBooks(){
        click(By.xpath(BOOKBTN));
    }

    public void fillFilter(String filter){
        type(By.xpath(NUMFILTERBOOK), filter);
    }

    public void startFilterBtn(){
        click(By.xpath(STARTFILTERBOOK));
    }

    public void cleanFilterBtn(){
        click(By.xpath(CLEANFILTERBOOK));
    }

    public void selectBook(String book){
        click(By.xpath(NUMBOOK + "[text()='" + book + "']"));
    }

    public void editBookBtn(){
        click(By.xpath(EDITBOOK));
    }

    public void fillNumBookInfo(String num){
        type(By.xpath(NUMBOOKINFO), num);
    }

    public void saveExitInfoBookBtn() throws InterruptedException {
        click(By.xpath(SAVEEXITINFOBOOK));
        sleep(1);
    }

    public void setOperatorBtn(){
        click(By.xpath(SETOPERBOOK));
    }

    public void fillOperator(String stage, String name){
        click(By.xpath(STAGESETOPER));
        click(By.xpath(STAGEESETOPER + "[text()='" + stage + "']"));
        click(By.xpath(SETOPER));
        click(By.xpath(SETTOPER + "[text()='" + name + "']"));
    }

    public void confirmSetOperatorBtn(){
        click(By.xpath(CONFRMSETOPER));
    }

    public void exitSetOperatorBtn(){
        click(By.xpath(EXITSETOPER));
    }

    public void unloginBtn() throws InterruptedException {
        click(By.xpath(EXITBTN));
        sleep(1);
    }

    public void confUnloginBtn(){
        click(By.xpath(YESEXITBTN));
    }

    public void login(String login, String pass) throws InterruptedException {
        type(By.xpath(LOGINUSER), login);
        type(By.xpath(PASSUSER), pass);
        click(By.xpath(LOGINBTN));
        sleep(2);
    }

    public void gotoInput(){
        click(By.xpath(INPUTOPERBTN));
    }

    public void selectBookOnInput(String name){
        click(By.xpath(BLOCKEDAGSUSER + "[text()='" + name + "']"));
    }

    public void startInputBookBtn(){
        click(By.xpath(STARTINPUTBTN));
    }

    public void fillDeathAgs(){
        type(By.xpath(LASTNAMEDEATHPERSON), "Егорович");
    }

    public void addSpecMarcDeathAgs(String typeMark, String dd, String mm, String yyyy){

    }

    public void fillHasInputHystory(String hasHystory){
        click(By.xpath(HASHISTORYDEATHINPUT));
        click(By.xpath(HASHISTORYYDEATHINPUT + "[text()='" + hasHystory + "']"));
    }

    public void saveDeathAgsBtn(){
        click(By.xpath(SAVEINPUTAGSBTN));
    }

    public void leaveInputBtn(){
        click(By.xpath(LEAVEINPUTBTN));
    }
}
