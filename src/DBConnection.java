import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnection {
    static String url;
    static String user;
    static String password;

    public DBConnection() {
        //url = "jdbc:sqlserver://localhost;encrypt=true;databaseName=Test;integratedSecurity=true;trustServerCertificate=true";
        url = "jdbc:sqlserver://localhost;databaseName=Test;integratedSecurity=true;";
        user = "DESKTOP-8JKBJVV\\Lenovo_IT2";
        password = "";
        System.out.println();
        //System.out.println(url);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection dbConnection=null;
            dbConnection = DriverManager.getConnection(url);
            System.out.println("Połączono z Bazą");
        }catch(SQLException | ClassNotFoundException ex) {
            System.out.println("Połączenie nieudane: ");
            ex.printStackTrace();
        }
    }

}
