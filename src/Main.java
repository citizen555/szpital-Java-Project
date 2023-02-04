import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {


        JFrame loginPage = new LoginPanel();
        loginPage.setVisible(true);
        //setting current Windows version look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }
}
