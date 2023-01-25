import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DBConnection {
    String url;
    String user;
    String password;

    public DBConnection() {
        this.url = "jdbc:sqlserver://localhost;encrypt=true;databaseName=Test;integratedSecurity=true;trustServerCertificate=true";
        this.user = "DESKTOP-8JKBJVV\\Lenovo_IT2";
        this.password = "";
    }

    public void dbConnect() {

        try {
            Connection dbConnection = DriverManager.getConnection(url);
            System.out.println("Połączono z Bazą");
        }catch(SQLException e){
            System.out.println("Połączenie nieudane: ");
        };



    }

}
