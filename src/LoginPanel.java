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

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String correctLogin="admin";
                String correctPassword="1234";

                if (!tfLogin.getText().equals(correctLogin)) {
                    JOptionPane.showMessageDialog(mainPanel,"Dane logowania są niepoprawne");
                    tfLogin.setText("");
                    pfPassword.setText("");
                }else if(!pfPassword.getText().equals(correctPassword)){
                    JOptionPane.showMessageDialog(mainPanel,"Dane logowania są niepoprawne");
                    tfLogin.setText("");
                    pfPassword.setText("");
                }else {
                    System.out.println("Zalogowano");
                    JFrame options = new MainMenuPanel(correctLogin);
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
