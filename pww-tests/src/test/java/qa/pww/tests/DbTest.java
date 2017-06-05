package qa.pww.tests;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by k.smotrov on 02.06.2017.
 */
public class DbTest extends TestBase {

    public  String sqlFieldsRequest = "WITH DOCUMENT_VALUES AS (SELECT DOC_STAGE_PROP_ID PROPERTY_ID, REQ_ID, VALUE, LEVEL PROPERTY_LEVEL, ROWNUM PROPERTY_ORDER, PROP_ORDER MULTIPLICITY FROM DOCUMENT_STAGE_PROPERTY START WITH PARENT_ID IS NULL AND DOC_STAGE_ID = (SELECT MIN (doc_stage_id) FROM document_stage WHERE doc_id IN (SELECT MIN (doc_id) FROM document WHERE doc_grp_id IN (SELECT MAX (doc_grp_id) FROM document_group))) CONNECT BY PRIOR DOC_STAGE_PROP_ID = PARENT_ID) SELECT PROPERTY_ORDER, LPAD(' ', (PROPERTY_LEVEL - 1) * 6, ' ') || REQ_NAME PROPERTY_NAME, VALUE, MULTIPLICITY, DOCUMENT_VALUES.REQ_ID, REQ_CODE PROPERTY_CODE, PROPERTY_ID FROM DOCUMENT_VALUES, DOCUMENT_TYPE_REQUISITE WHERE DOCUMENT_VALUES.REQ_ID = DOCUMENT_TYPE_REQUISITE.REQ_ID ORDER BY PROPERTY_ORDER";

    //поиск максимального ID книги (последняя загруженная)
    @Test
    public void getFromDbMaxBookId() throws SQLException {
        List<String> bookId = new ArrayList<>();
        PreparedStatement statement = app.getPvvDb().prepareStatement("select DOC_GRP_ID from DOCUMENT_GROUP");
        ResultSet resultSet = statement.executeQuery();
        while( resultSet.next() ){
            bookId.add(resultSet.getString("DOC_GRP_ID"));

        }
        String maxBookId = Collections.max(bookId);
        System.out.println(maxBookId);
        resultSet.close();
    }




    @Test //загрузка реквизитов (код, название, значение) первого документа последней загруженной книги
    public void getFromDbDocMainFieldsWithName() throws Exception {
        String reqNameId;
        int i = 0;
        List<String> reqValue = new ArrayList<String>();
        PreparedStatement statement = app.getPvvDb().prepareStatement(sqlFieldsRequest);
        ResultSet resultSet = statement.executeQuery();
        while( resultSet.next() ){
            reqNameId = resultSet.getString("REQ_ID" );
            PreparedStatement nameReqId = app.getPvvDb().prepareStatement("select REQ_NAME from DOCUMENT_TYPE_REQUISITE where REQ_ID = " +reqNameId);
            ResultSet rs = nameReqId.executeQuery();
            while (rs.next()) {
                reqValue.add((reqNameId + " " + rs.getString("REQ_NAME") + " = " + resultSet.getString("VALUE" )));
            }
            rs.close();
            System.out.println(reqValue.get(i));
            i++;
        }
        resultSet.close();
    }

    @Test //загрузка реквизитов  первого документа последней загруженной книги
    public void getFromDbDocMainFields() throws Exception {
        List<String> reqValue = new ArrayList<>();
        PreparedStatement statement = app.getPvvDb().prepareStatement(sqlFieldsRequest);
        ResultSet resultSet = statement.executeQuery();
        while( resultSet.next() ){
            reqValue.add(resultSet.getString("VALUE" ));
        }
        resultSet.close();
    }
}
