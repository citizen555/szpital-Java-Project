import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DBConnectionTest {
    @Test
    public void testDbConnect() {
        boolean result = DBConnection.dbConnect();
        assertTrue(result);
    }

    @Test
    public void testDbConnectionClose() {
        DBConnection.dbConnect();
        DBConnection.dbConnectionClose();
    }

}