import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame{
    private JPanel mainPanel;
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnClose;

    private String test;
    public LoginPanel() {
        super("Szpitalex 1.0   Zaloguj się");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(400,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if (!tfLogin.getText().equals(Main.correctLogin)) {
                    JOptionPane.showMessageDialog(mainPanel,"Dane logowania są niepoprawne");
                    tfLogin.setText("");
                    pfPassword.setText("");
                }else if(!pfPassword.getText().equals(Main.correctPassword)){
                    JOptionPane.showMessageDialog(mainPanel,"Dane logowania są niepoprawne");
                    tfLogin.setText("");
                    pfPassword.setText("");
                }else {
                    System.out.println("Zalogowano");
                    JFrame options = new MainMenuPanel(Main.correctLogin);
                    options.setVisible(true);
                    dispose();
                }


            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}
