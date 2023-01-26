import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "";
    private static Connection dbConnection=null;

    public static void dbConnect(){

        try {
            dbConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Połączono z Bazą");
        }catch(SQLException e) {
            System.out.println("Połączenie nieudane: ");
            e.printStackTrace();
        }
    }
    public static void dbConnectionClose(){
        try {
            dbConnection.close();
            System.out.println("Połączenie z baza danych zamknięte");
        } catch (SQLException e) {
            System.out.println("Błąd przy zamknięciu bazy:");
            e.printStackTrace();
        }
    }

}
