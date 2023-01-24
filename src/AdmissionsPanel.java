import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdmissionsPanel extends JFrame{
    private JPanel admissionsPanel;
    private JButton btnBack;

    public AdmissionsPanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(admissionsPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame MainMenuPanel = new MainMenuPanel(CorrectLoginData.getCorrectLogin());
                MainMenuPanel.setVisible(true);
                dispose();
            }
        });
    }
}
