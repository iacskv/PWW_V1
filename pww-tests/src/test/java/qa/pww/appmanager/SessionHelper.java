package qa.pww.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Константин on 19.03.2017.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {

    super(wd);
  }
  public void login(String nameUser, String passUser) {
    String fildUser = "//div/form/div[1]/div[3]/div[2]/input";
    String fildPas = "//div/form/div[1]/div[4]/div[2]/input";
    String submitLoginButton = "//div/form/div[1]/div[4]/div[2]/div/button";

    type(By.xpath(fildUser), nameUser);
    type(By.xpath(fildPas), passUser);
    click(By.xpath(submitLoginButton));
  }
}
