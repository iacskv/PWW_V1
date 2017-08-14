package qa.pww.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import qa.pww.appmanager.ApplicationManager;

import java.sql.SQLException;


/**
 * Created by Константин on 19.03.2017.
 */
public class TestBase {

  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.initDb();
    app.init();
    //app.clearPvvDb();

  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws SQLException {
    app.stop();
  }


}
