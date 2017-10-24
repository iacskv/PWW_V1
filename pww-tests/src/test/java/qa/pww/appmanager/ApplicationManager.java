package qa.pww.appmanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
  Connection pvvDb;
  Connection zagsDb;

  private SessionHelper sessionHelper;
  private LoadDataHelper loadDataHelper;
  private InputFormHelper inputFormHelper;
  private FirstInputStageBornHelper firstInputStageBornHelper;
  private FirstInputStageMarriageHelper firstInputStageMarriageHelper;
  private ControlFormHelper controlFormHelper;
  private PmiHelper pmiHelper;
  private int rs;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  //инициализация вэб-драйвера
  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if (browser.equals(BrowserType.FIREFOX)) {
      FirefoxBinary binary = new FirefoxBinary(new File("D:/Program Files/Mozilla Firefox/firefox.exe"));
      wd = new FirefoxDriver(binary, new FirefoxProfile());
      //wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    loadDataHelper = new LoadDataHelper(wd);
    inputFormHelper = new InputFormHelper(wd, pvvDb, zagsDb);
    firstInputStageBornHelper = new FirstInputStageBornHelper(wd,pvvDb,zagsDb);
    firstInputStageMarriageHelper = new FirstInputStageMarriageHelper(wd,pvvDb,zagsDb);
    controlFormHelper = new ControlFormHelper(wd, pvvDb, zagsDb);
    pmiHelper = new PmiHelper(wd);

  }

  //инициализация подключения к БД ПВВ и ЗАГС
  public void initDb () throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    DbHelper dbHelper = new DbHelper();

    pvvDb = dbHelper.getConnection(properties.getProperty("pvv.baseUrl"), (properties.getProperty("pvv.userLogin")), (properties.getProperty("pvv.userPassword")));
    zagsDb = dbHelper.getConnection(properties.getProperty("zags.baseUrl"), (properties.getProperty("zags.userLogin")), (properties.getProperty("zags.userPassword")));

  }

  //очистка БД ПВВ
  public void clearPvvDb() throws SQLException {
    PreparedStatement st1 = getPvvDb().prepareStatement("DELETE FROM EXPORT_ERROR_LOG");
     rs = st1.executeUpdate();
    st1.close();
    PreparedStatement st2 = getPvvDb().prepareStatement("DELETE FROM EXPORT_DOCUMENT_GROUP");
     rs = st2.executeUpdate();
    st2.close();
    PreparedStatement st3 = getPvvDb().prepareStatement("DELETE FROM EXPORT_SESSION");
     rs = st3.executeUpdate();
    st3.close();
    PreparedStatement st4 = getPvvDb().prepareStatement("DELETE FROM document_stage");
     rs = st4.executeUpdate();
    st4.close();
    PreparedStatement st5 = getPvvDb().prepareStatement("DELETE FROM document");
     rs = st5.executeUpdate();
    st5.close();
    PreparedStatement st6 = getPvvDb().prepareStatement("DELETE FROM document_group_stage");
     rs = st6.executeUpdate();
    st6.close();
    PreparedStatement st7 = getPvvDb().prepareStatement("DELETE FROM document_group");
     rs = st7.executeUpdate();
    st7.close();


  }

  //очистка БД ЗАГС от выгруженных а/з из ПВВ
  public void clearZagsDb() throws SQLException {
    PreparedStatement st1 = getZagsDb().prepareStatement("delete from inputarena.born_ext");
    rs = st1.executeUpdate();
    st1.close();
    PreparedStatement st2 = getZagsDb().prepareStatement("delete from inputarena.death_ext");
    rs = st2.executeUpdate();
    st2.close();
    PreparedStatement st3 = getZagsDb().prepareStatement("delete from inputarena.married_ext");
    rs = st3.executeUpdate();
    st3.close();
    PreparedStatement st4 = getZagsDb().prepareStatement("delete from inputarena.change_fam_ext");
    rs = st4.executeUpdate();
    st4.close();
    PreparedStatement st5 = getZagsDb().prepareStatement("delete from inputarena.adopt_ext");
    rs = st5.executeUpdate();
    st5.close();
    PreparedStatement st6 = getZagsDb().prepareStatement("delete from inputarena.divorce_ext");
    rs = st6.executeUpdate();
    st6.close();
    PreparedStatement st7 = getZagsDb().prepareStatement("delete from inputarena.ftno_ext");
    rs = st7.executeUpdate();
    st7.close();
    PreparedStatement st8 = getZagsDb().prepareStatement("delete from inputarena.processed_act_records");
    rs = st8.executeUpdate();
    st7.close();
    PreparedStatement st9 = getZagsDb().prepareStatement("delete from inputarena.special_marks");
    rs = st9.executeUpdate();
    st7.close();
  }

 //остановка вэб-драйвера и отключения от БД
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

  public FirstInputStageBornHelper firstInputStageBornHelper() {
    return firstInputStageBornHelper;
  }

  public FirstInputStageMarriageHelper firstInputStageMarriageHelper() {
    return firstInputStageMarriageHelper;
  }

  public ControlFormHelper controlFormHelper() {
    return controlFormHelper;
  }

  public PmiHelper pmiHelper () {
    return pmiHelper;
  }

  public Connection getPvvDb() {
        return pvvDb;
    }

  public Connection getZagsDb() {
        return zagsDb;
    }

}
