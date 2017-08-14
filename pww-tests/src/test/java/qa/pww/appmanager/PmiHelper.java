package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by k.smotrov on 07.08.2017.
 */
public class PmiHelper extends HelperBase{

    public PmiHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoMainPage(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span"));
    }

    public void gotoAdmPage(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/ul/li[4]/a[2]/em/span/span"));
    }

    public void gotoUsersBtn(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createUserBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createNewUser (String login, String pass, String lastName, String firstName, String midName, String title, String room, String descr) throws InterruptedException {
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[1]/div/div[1]/div[1]/div/input"), login);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[1]/div/div[2]/div[1]/div/input"), pass);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[1]/div/div[3]/div[1]/div/input"), pass);
        click(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[1]/div/div[4]/div[1]/div/img"));
        click(By.xpath("html/body/div[11]/div/div[13]"));
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[1]/div[1]/div/input"), lastName);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[2]/div[1]/div/input"), firstName);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[3]/div[1]/div/input"), midName);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[6]/div[1]/div/input"), title);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[7]/div[1]/div/input"), room);
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[8]/div[1]/div/textarea"), descr);
        //роль - админ
        click(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/fieldset/div/div/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[1]/div/div"));
        //создать
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
        sleep(1);
        //подтвердить
        click(By.xpath("html/body/div[9]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
        // закрыть
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void selectPMiUser(String login){
        click(By.xpath("//div[contains(text(),'" + login+ "')]"));
    }

    public void editUserBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void editPmiUser() throws InterruptedException {
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/fieldset[2]/div/div[1]/div[1]/div/input"), "Дмитриев");
        //сохранить
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
        sleep(1);
        //подтвердить
        click(By.xpath("html/body/div[9]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
        //закрыть
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void changePassBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[4]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void changePassPmiUser() throws InterruptedException {
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[1]/div[1]/div/input"), "adm_admin");
        type(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div/input"), "adm_admin");
        //сохранить
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
        sleep(1);
        //подтвердить
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void gotoRole(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createNewRoleBtn(){

    }

    public void createNewRole(){

    }

    public void selectPmiRole(String rolename){
        click(By.xpath("//div[contains(text(),'" + rolename + "')]"));
    }

    public void changeRulesPmiRole(){
        //главная
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[1]/div[1]/img[3]"));
        //последние изменения
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[1]/div[2]/div/div/img[3]"));
        //площадка ввода - ввод
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[6]/div/img[3]"));
        //сохранить
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button"));

    }

    public void changePmiRoleForUser(){
        //снять админа
        click(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/fieldset/div/div/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[1]/div/div"));
        //поставить оператора
        click(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/fieldset/div/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div"));
        //сохранить
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
        //подтвердить
        click(By.xpath("html/body/div[9]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
        //закрыть
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void gotoDistonaryForm(){
       click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/ul/li[3]/a[2]/em/span/span"));
    }

    public void gotoDictinaryBtn(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createNewDistonaryBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createNewDistinary(String distname, String distkod, String col1name, String col1kod){
      type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[1]/form/div[1]/div[1]/div/input"),col1name);
      click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[1]/form/div[2]/div[1]/div/img"));
      click(By.xpath("html/body/div[12]/div/div[1]"));
      type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[1]/form/div[3]/div[1]/div/input"),col1kod);
      click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
      type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[1]/div/div[1]/div[1]/div/input"),distname);
      type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[1]/div/div[3]/div[1]/div/input"),distkod);
      click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[1]/div/div[4]/div[1]/div/img"));
      click(By.xpath("html/body/div[12]/div/div"));
      click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[7]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void selectPmiDist(String distname) throws InterruptedException {
        sleep(3);
        click(By.xpath("//div[contains(text(),'" + distname + "')]"));
    }

    public void editDistBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void editDist(String col2name, String col2kod){
        type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[1]/form/div[1]/div[1]/div/input"),col2name);
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[1]/form/div[2]/div[1]/div/img"));
        click(By.xpath("html/body/div[12]/div/div[3]"));
        type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[1]/form/div[3]/div[1]/div/input"),col2kod);
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[2]/div/div/div[2]/div[3]/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/fieldset[1]/div/div[4]/div[1]/div/img"));
        click(By.xpath("html/body/div[12]/div/div[2]"));
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[7]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void fillDistonaryBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void fillDistonary(String lgtname, String lgtkat, String lgtves) throws InterruptedException {
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
        type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/form/div[1]/div[1]/div/input"),lgtname);
        type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/form/div[2]/div[1]/div/input"),lgtkat);
        type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/form/div[3]/div[1]/div/input"), lgtves);
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[7]/table/tbody/tr[2]/td[2]/em/button"));
        sleep(1);
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/ul/li[2]/a[1]"));
    }

    public void importDistBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[8]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void importDist(String distpath){
        File file = new File(distpath);
        attach(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/div/div[1]/div/input[2]"),file);
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void gotoInput(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span"));
    }

    public void loadBookBtn(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void loadBook(String year, String typeBook, String nameZags, String numbook, String sNum, String lNum) throws InterruptedException {
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[1]/div[1]/div/img"));
        click(By.xpath("//div[text()='" + year + "']"));
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[3]/div[1]/div/img"));
        click(By.xpath("//div[text()='" + typeBook + "']"));
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[4]/div[1]/div/img"));
        click(By.xpath("//div[text()='" + nameZags + "']"));
        type(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[5]/div[1]/div/input"),numbook);
        type(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[6]/div[1]/div/input"),sNum);
        type(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[7]/div[1]/div/input"),lNum);
        sleep(1);
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
        sleep(10);
    }

    public void gotoControlBookBtn(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void findControlBook(String name){
        type(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[11]/div/input"),name);
        click(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[12]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void selectBook(String mainbook){
        click(By.xpath("//div[text()='" + mainbook + "']"));
    }

    public void ediBookBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void editBook(String newbookname){
        type(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/div/div/fieldset[2]/div/div[1]/div[1]/div/input"),newbookname);
        click(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[7]/table/tbody/tr[2]/td[2]/em/button"));
    }
}
