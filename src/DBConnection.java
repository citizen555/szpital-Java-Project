import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "";
    public static Connection dbConnection=null;

    public static boolean dbConnect(){

        try {
            dbConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Połączono z Bazą");
            return true;
        }catch(SQLException e) {
            System.out.println("Połączenie nieudane: ");
            e.printStackTrace();
            return false;
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
