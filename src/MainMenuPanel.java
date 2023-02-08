import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JFrame {
    JButton btnClose;
    JPanel optionsPanel;
    JButton btnLogOut;
    JButton btnPatients;
    JButton btnAdmissions;
    JButton btnDoctors;
    private JLabel lbLogin;

    public MainMenuPanel(String correctLogin) {
        super("Szpitalex 1.0   Wybierz działanie");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(optionsPanel);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        lbLogin.setText(correctLogin);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DBConnection.dbConnectionClose();
                dispose();
        }
        });
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionsPanel,"Wylogowano pomyślnie użytkownika "+correctLogin);
                System.out.println("Wylogowano");
                JFrame loginPage = new LoginPanel();
                loginPage.setVisible(true);

                DBConnection.dbConnectionClose();
                dispose();
            }
        });
        btnDoctors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame doctorsPanel = new DoctorsPanel();
                doctorsPanel.setVisible(true);
                dispose();
            }
        });
        btnAdmissions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame AdmissionsPanel = new AdmissionsPanel();
                AdmissionsPanel.setVisible(true);
                dispose();
            }
        });
        btnPatients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame PatientsPanel = new PatientsPanel();
                PatientsPanel.setVisible(true);
                dispose();
            }
        });
    }
}
