import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsPanel extends JFrame{
    private JButton btnBack;
    private JPanel doctorsPanel;


    public DoctorsPanel() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(doctorsPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame MainMenuPanel = new MainMenuPanel(Main.correctLogin);
                MainMenuPanel.setVisible(true);
                dispose();
            }
        });
    }



}
