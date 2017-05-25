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

  public void stop() {
    wd.quit();
  }

  public LoadDataHelper loadDataHelper(){
    return loadDataHelper;
  }

  public InputFormHelper inputFormHelper(){
    return inputFormHelper;
  }


}
