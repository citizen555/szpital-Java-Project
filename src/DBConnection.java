import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DBConnection {
    static String url;
    static String user;
    static String password;

    public DBConnection() {

        url = "jdbc:mysql://localhost:3306/test";
        user = "root";
        password = "";

        Connection dbConnection=null;
        try {
            dbConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Połączono z Bazą");
            dbConnectionClose(dbConnection);
        }catch(SQLException e) {
            System.out.println("Połączenie nieudane: ");
            e.printStackTrace();
        }

    }

    public void dbConnectionClose(Connection dbConnection){
        try {
            dbConnection.close();
            System.out.println("Połączenie z baza danych zamknięte");
        } catch (SQLException e) {
            System.out.println("Błąd przy zamknięciu bazy:");
            e.printStackTrace();
        }
    }

}
