package qa.pww.tests;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by k.smotrov on 02.06.2017.
 */
public class DbTest extends TestBase {
    @Test
    public void testName() throws Exception {
        PreparedStatement statement = app.getZagsDb().prepareStatement("select count(*) as cnt from born");
        ResultSet resultSet = statement.executeQuery();
        while( resultSet.next() ){
            System.out.println( resultSet.getString( "cnt" ));
        }
        resultSet.close();
    }
}
