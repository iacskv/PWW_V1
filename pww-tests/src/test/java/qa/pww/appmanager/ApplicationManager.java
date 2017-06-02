package qa.pww.appmanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Константин on 19.03.2017.
 */
public class ApplicationManager {


  private final Properties properties;
  private String browser = "CHROME";
  WebDriver wd;

  private SessionHelper sessionHelper;
  private LoadDataHelper loadDataHelper;
  private InputFormHelper inputFormHelper;

  private Connection pvvDb;
  private Connection zagsDb;



  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {


    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if (browser.equals(BrowserType.FIREFOX)) {
      FirefoxBinary binary = new FirefoxBinary(new File("D:/Program Files/Mozilla Firefox/firefox.exe"));
      wd = new FirefoxDriver(binary, new FirefoxProfile());
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    loadDataHelper = new LoadDataHelper(wd);
    inputFormHelper = new InputFormHelper(wd);
  }

  public void initDb (){
      DbHelper dbHelper = new DbHelper();

      pvvDb=dbHelper.getConnection("jdbc:oracle:thin:@db.dev.pvv.zags.adc.vpn:1521:inputarena","inputarena_review", "inputarena_review");
      zagsDb=dbHelper.getConnection("jdbc:oracle:thin:@dbnode01.etalon.zags.adc.vpn:1521/zagstest","sysuser","spb");
  }

  public void stop() throws SQLException {
    wd.quit();
    pvvDb.close();
    zagsDb.close();
  }

  public LoadDataHelper loadDataHelper(){
    return loadDataHelper;
  }

  public InputFormHelper inputFormHelper(){
    return inputFormHelper;
  }

    public Connection getPvvDb() {
        return pvvDb;
    }

    public Connection getZagsDb() {
        return zagsDb;
    }
}
