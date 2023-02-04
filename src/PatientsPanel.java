import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientsPanel extends JFrame{
    PreparedStatement statement=null;
    ResultSet result=null;
    private JPanel patientsPanel;
    private JScrollPane scrollPanePatients;
    private JTable tablePatients;
    private JLabel lName;
    private JTextField tfName;
    private JTextField tfBirthDate;
    private JLabel lBirthDate;
    private JLabel lPesel;
    private JTextField tfPesel;
    private JTextField tfPostCode;
    private JLabel lTelephone;
    private JTextField tfTelephone;
    private JLabel lSurname;
    private JTextField tfSurname;
    private JLabel lBirthPlace;
    private JTextField tfBirthPlace;
    private JLabel lLivePlace;
    private JTextField tfAdres;
    private JLabel lCity;
    private JTextField tfCity;
    private JLabel lEmail;
    private JTextField tfEmail;
    private JButton btnDelete;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnBack;

    public PatientsPanel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(patientsPanel);
        this.setResizable(false);
        this.setSize(1400,700);
        this.setLocationRelativeTo(null);
        tablePatients.setDefaultEditor(Object.class, null);
        showData();
        tablePatients.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePatients.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);




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
                tfPesel.setText("");
                tfName.setText("");
                tfSurname.setText("");
                tfBirthDate.setText("");
                tfBirthPlace.setText("");
                tfAdres.setText("");
                tfPostCode.setText("");
                tfCity.setText("");
                tfTelephone.setText("");
                tfEmail.setText("");
            }
        });
        tablePatients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel tempModel =(DefaultTableModel) tablePatients.getModel();
                int selectedRow=tablePatients.getSelectedRow();
                tfPesel.setText(tempModel.getValueAt(selectedRow,0).toString());
                tfName.setText(tempModel.getValueAt(selectedRow,1).toString());
                tfSurname.setText(tempModel.getValueAt(selectedRow,2).toString());
                tfBirthDate.setText(tempModel.getValueAt(selectedRow,3).toString());
                tfBirthPlace.setText(tempModel.getValueAt(selectedRow,4).toString());
                tfAdres.setText(tempModel.getValueAt(selectedRow,5).toString());
                tfPostCode.setText(tempModel.getValueAt(selectedRow,6).toString());
                tfCity.setText(tempModel.getValueAt(selectedRow,7).toString());
                tfTelephone.setText(tempModel.getValueAt(selectedRow,8).toString());
                tfEmail.setText(tempModel.getValueAt(selectedRow,9).toString());
            }
        });

    }


    public void showData(){
        try{

            String sql="SELECT * From pacjenci;";
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

            tablePatients.setModel(tableModel);
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}