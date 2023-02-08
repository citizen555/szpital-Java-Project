import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TEST {
    private MainMenuPanel mainMenuPanel;

    @Test
    public void testDbConnect() {
        boolean result = DBConnection.dbConnect();
        Assert.assertTrue(result);
    }

    @Test
    public void testDbConnectionClose() {
        DBConnection.dbConnect();
        DBConnection.dbConnectionClose();
    }

    @Before
    public void setUp() {
        mainMenuPanel = new MainMenuPanel("testLogin");
    }

    @Test
    public void testMainMenuPanelCreation() {
        assertNotNull(mainMenuPanel);
        assertEquals("Szpitalex 1.0   Wybierz działanie", mainMenuPanel.getTitle());
    }


        @Test
        public void peselTest() {
            //valid PESEL number
            assertTrue(DataCorectness.pesel("12345678901"));
            //invalid PESEL number
            assertFalse(DataCorectness.pesel("1234567890"));
        }

        @Test
        public void nameTest() {
            //valid name
            assertTrue(DataCorectness.name("John"));
            //invalid name
            assertFalse(DataCorectness.name("John1"));
        }

        @Test
        public void dateTest() {
            //valid date
            assertTrue(DataCorectness.date("2021-12-31"));
            //invalid date
            assertFalse(DataCorectness.date("2021-12-32"));
        }

        @Test
        public void timeTest() {
            //valid time
            assertTrue(DataCorectness.time("12:30:00"));
            //invalid time
            assertFalse(DataCorectness.time("25:30:00"));
        }

        @Test
        public void postCodeTest() {
            //valid postcode
            assertTrue(DataCorectness.postCode("00-000"));
            //invalid postcode
            assertFalse(DataCorectness.postCode("00000"));
        }

        @Test
        public void emailTest() {
            //valid email
            assertTrue(DataCorectness.email("example@email.com"));
            //invalid email
            assertFalse(DataCorectness.email("example@.com"));
        }

        @Test
        public void telephoneTest() {
            //valid telephone number
            assertTrue(DataCorectness.telephone("123456789"));
            //invalid telephone number
            assertFalse(DataCorectness.telephone("12345678"));
        }

        @Test
        public void containsNumberAndCharsTest() {
            //valid string
            assertTrue(DataCorectness.containsNumberAndChars("John"));
            //invalid string
            assertFalse(DataCorectness.containsNumberAndChars("John1"));
        }

        @Test
        public void salaryTest() {
            //valid salary
            assertTrue(DataCorectness.salary("1000"));
            //invalid salary
            assertFalse(DataCorectness.salary("1,000"));
        }

        private LoginPanel loginPanel;
        private JTextField tfLogin;
        private JButton btnLogin;
        private JButton btnClose;

        @BeforeEach
        public void setUp2() {
            loginPanel = new LoginPanel();
            tfLogin = loginPanel.tfLogin;
            JPasswordField pfPassword = loginPanel.pfPassword;
            btnLogin = loginPanel.btnLogin;
            btnClose = loginPanel.btnClose;
        }

        @org.junit.jupiter.api.Test
        public void testCloseButton() {
            ActionEvent closeEvent = new ActionEvent(btnClose, ActionEvent.ACTION_PERFORMED, "Close");
            for (ActionListener listener : btnClose.getActionListeners()) {
                listener.actionPerformed(closeEvent);
            }

            // Sprawdź, czy okno zostało zamknięte
            Assert.assertFalse(loginPanel.isShowing());
        }

        private String getMessageFromOptionPane() {
            JOptionPane optionPane = (JOptionPane)
                    SwingUtilities.getAncestorOfClass(JOptionPane.class, tfLogin);
            return optionPane.getMessage().toString();
        }

}
