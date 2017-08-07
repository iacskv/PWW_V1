package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void gotoUsers(){
        click(By.xpath("html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createUserBtn(){
        click(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));
    }

    public void createNewUser (String login, String pass, String lastName, String firstName, String midName, String title, String room, String descr){
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
        click(By.xpath("html/body/div[8]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/form/fieldset/div/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div"));
        click(By.xpath("html/body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/em/button"));

    }


}
