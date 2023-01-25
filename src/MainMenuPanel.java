import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JFrame {
    private JButton btnClose;
    private JPanel optionsPanel;
    private JButton btnLogOut;
    private JButton btnPatients;
    private JButton btnAdmissions;
    private JButton btnDoctors;
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
            dispose();
        }
    });
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionsPanel,"Wylogowano pomyślnie urzytkownika "+correctLogin);
                System.out.println("Wylogowano");
                JFrame loginPage = new LoginPanel();
                loginPage.setVisible(true);
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
