import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorsPanel extends JFrame{
    private JButton btnBack;
    private JPanel doctorsPanel;
    private JTable tableDoctors;
    private JScrollPane scrollPaneDoctors;
    private JLabel lName;
    private JLabel lSurname;
    private JTextField tfSurname;
    private JLabel lBirthDate;
    private JTextField tfBirthDate;
    private JLabel lBirthPlace;
    private JTextField tfBirthPlace;
    private JLabel lPesel;
    private JTextField tfPesel;
    private JLabel lLivePlace;
    private JTextField tfAdres;
    private JTextField tfPostCode;
    private JLabel lCity;
    private JTextField tfCity;
    private JLabel lTelephone;
    private JTextField tfTelephone;
    private JTextField tfEmail;
    private JLabel lEmail;
    private JTextField tfSalary;
    private JButton btnSave;
    private JButton btnDelete;
    private JTextField tfName;
    private JButton btnClear;


    public DoctorsPanel() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(doctorsPanel);
        this.setResizable(false);
        this.setSize(1400,1000);
        this.setLocationRelativeTo(null);
        tableDoctors.setDefaultEditor(Object.class, null);
        showData();
        tableDoctors.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableDoctors.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // sets the look and feel to be that of the operating system's
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame MainMenuPanel = new MainMenuPanel(CorrectLoginData.getCorrectLogin());
                MainMenuPanel.setVisible(true);
                dispose();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfSurname.setText("");
                tfBirthDate.setText("");
                tfBirthPlace.setText("");
                tfPesel.setText("");
                tfAdres.setText("");
                tfPostCode.setText("");
                tfCity.setText("");
                tfTelephone.setText("");
                tfEmail.setText("");
                tfSalary.setText("");
            }
        });
        tableDoctors.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model=(DefaultTableModel) tableDoctors.getModel();
                int selectedRow=tableDoctors.getSelectedRow();
                tfName.setText(model.getValueAt(selectedRow,1).toString());
                tfSurname.setText(model.getValueAt(selectedRow,2).toString());
                tfBirthDate.setText(model.getValueAt(selectedRow,3).toString());
                tfBirthPlace.setText(model.getValueAt(selectedRow,4).toString());
                tfPesel.setText(model.getValueAt(selectedRow,5).toString());
                tfAdres.setText(model.getValueAt(selectedRow,6).toString());
                tfPostCode.setText(model.getValueAt(selectedRow,7).toString());
                tfCity.setText(model.getValueAt(selectedRow,8).toString());
                tfTelephone.setText(model.getValueAt(selectedRow,9).toString());
                tfEmail.setText(model.getValueAt(selectedRow,10).toString());
                tfSalary.setText(model.getValueAt(selectedRow,11).toString());
            }
        });
    }


    public void showData(){
        PreparedStatement statement=null;
        ResultSet result=null;

        try{

            String sql="SELECT * From lekarze";
            statement = DBConnection.dbConnection.prepareStatement(sql);
            result = statement.executeQuery();

            int numberOfColumns = result.getMetaData().getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            for (int i=1;i<=numberOfColumns;i++){
                tableModel.addColumn(result.getMetaData().getColumnName(i));
            }
            while(result.next()){
                Object[] row = new Object[numberOfColumns];
                for(int i=1;i<=numberOfColumns;i++){
                    row[i-1]=result.getObject(i);
                }
                tableModel.addRow(row);
            }

            tableDoctors.setModel(tableModel);
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}







