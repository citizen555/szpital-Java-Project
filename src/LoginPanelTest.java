import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LoginPanelTest {
    private LoginPanel loginPanel;
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnClose;

    @BeforeEach
    public void setUp() {
        loginPanel = new LoginPanel();
        tfLogin = loginPanel.tfLogin;
        pfPassword = loginPanel.pfPassword;
        btnLogin = loginPanel.btnLogin;
        btnClose = loginPanel.btnClose;
    }
    @Test
    public void testCloseButton() {
        ActionEvent closeEvent = new ActionEvent(btnClose, ActionEvent.ACTION_PERFORMED, "Close");
        for (ActionListener listener : btnClose.getActionListeners()) {
            listener.actionPerformed(closeEvent);
        }

        // Sprawdź, czy okno zostało zamknięte
        assertFalse(loginPanel.isShowing());
    }
    private String getMessageFromOptionPane() {
        JOptionPane optionPane = (JOptionPane)
                SwingUtilities.getAncestorOfClass(JOptionPane.class, tfLogin);
        return optionPane.getMessage().toString();
    }
}
